package com.tencent.mobileqq.apollo.api.impl;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.SettingMeRelativeLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.apollo.ApolloRenderInterfaceImpl;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISettingMeApolloViewController;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.api.impl.model.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerContext;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerInfoManager;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerStatus;
import com.tencent.mobileqq.apollo.drawer.CardDrawerStatus;
import com.tencent.mobileqq.apollo.drawer.FirstDrawerStatus;
import com.tencent.mobileqq.apollo.drawer.HireDrawerStatus;
import com.tencent.mobileqq.apollo.drawer.PushDrawerStatus;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.utils.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.CmShowStatUtil;
import com.tencent.mobileqq.apollo.view.ApolloDrawerInfoViewListener;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.redtouch.RedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class SettingMeApolloViewControllerImpl
  implements Handler.Callback, View.OnClickListener, ISettingMeApolloViewController
{
  private static final int MSG_CODE_DESTROY_APOLLO_ON_BACKGROUND = 65537;
  private static final int MSG_CODE_PLAY_ACTION = 65535;
  private static final int MSG_CODE_REFRESH_APOLLO = 65536;
  public static final String TAG = "SettingMeApolloViewController";
  public static long sDestroyTimeOut = 180000L;
  private ApolloExtensionObserverImpl cmshowObserver = new SettingMeApolloViewControllerImpl.2(this);
  protected ApolloBoxEnterView mApolloBoxEnterView;
  protected ApolloDrawerContext mApolloDrawer;
  private ApolloDrawerInfoViewListener mApolloDrawerInfoViewListener;
  private int mApolloDrawerStatus = 0;
  int mApolloFeatureFlag;
  protected FrameGifView mApolloSettingMeImg;
  protected View mApolloStaticEntry;
  private ApolloTextureView mApolloSurfaceView;
  private WeakReference<ViewGroup> mContentViewRef;
  private boolean mDrawerClosed;
  private ISpriteDrawerInfoCallback mDrawerInfoCallback = new SettingMeApolloViewControllerImpl.5(this);
  protected int[] mDressIds;
  protected FrameGifView mExploreBox;
  protected boolean mIsActionPlay;
  public boolean mIsDestroyApollo = false;
  public boolean mIsSurfaceReady = false;
  private WeakReference<QQSettingMe> mQQSettingMeRef;
  private SettingMeApolloViewControllerImpl.RefreshApolloTask mRefreshApolloTask;
  public int mRoleId;
  protected float mRoleWidth;
  private SpriteDrawerInfoManager mSpriteDrawerInfoManager;
  WeakReferenceHandler mUIHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  
  private void apolloDtSpriteReport(QQAppInterface paramQQAppInterface, String paramString)
  {
    ApolloDtReportUtil.a("setting_me", "sprite", paramString, new ApolloDtReportUtil.DtReportParamsBuilder().a(ApolloDtReportUtil.a(paramQQAppInterface)).b(paramQQAppInterface.getCurrentAccountUin()).a());
  }
  
  @TargetApi(14)
  private void checkApolloUI(CheckApolloInfoResult paramCheckApolloInfoResult)
  {
    if (paramCheckApolloInfoResult == null) {}
    label685:
    label1113:
    for (;;)
    {
      return;
      QQSettingMe localQQSettingMe = (QQSettingMe)this.mQQSettingMeRef.get();
      if (localQQSettingMe != null)
      {
        QQAppInterface localQQAppInterface = localQQSettingMe.a();
        if (localQQAppInterface != null)
        {
          ViewGroup localViewGroup = (ViewGroup)this.mContentViewRef.get();
          if (localViewGroup != null)
          {
            long l1 = System.currentTimeMillis();
            Object localObject = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
            int j = this.mApolloFeatureFlag;
            int k = ApolloDrawerInfoManager.a(this.mApolloDrawerStatus);
            if (((ApolloManagerServiceImpl)localObject).mIsNewStoreUser) {}
            for (int i = 0;; i = 1)
            {
              VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_show", j, k, new String[] { "", String.valueOf(i) });
              if (QLog.isColorLevel()) {
                QLog.d("SettingMeApolloViewController", 2, new Object[] { "roleId->" + paramCheckApolloInfoResult.jdField_a_of_type_Int + " apolloStatus->" + this.mApolloFeatureFlag + " needStatic->" + paramCheckApolloInfoResult.jdField_a_of_type_Boolean, ",mApolloDrawerStatus->", Integer.valueOf(this.mApolloDrawerStatus) });
              }
              if (!this.mDrawerClosed) {
                break;
              }
              QLog.i("SettingMeApolloViewController", 1, "checkApolloUI on DrawerClosed!");
              TraceReportUtil.a(paramCheckApolloInfoResult.e, 11, 106, new Object[] { "DrawerClosed" });
              return;
            }
            this.mApolloStaticEntry.setVisibility(8);
            this.mApolloSettingMeImg.setVisibility(8);
            this.mApolloSettingMeImg.c();
            this.mApolloSettingMeImg.setImageBitmap(null);
            float f2;
            float f1;
            if ((this.mApolloDrawerStatus == 1) || (this.mApolloDrawerStatus == 6)) {
              if (this.mApolloSurfaceView == null)
              {
                TraceReportUtil.a(paramCheckApolloInfoResult.e, 11, 0, new Object[] { "checkUI done" });
                TraceReportUtil.a(paramCheckApolloInfoResult.e, 100);
                long l2 = DeviceInfoUtil.i();
                i = (int)((float)DeviceInfoUtil.j() * 0.4F);
                j = ApolloDrawerInfoManager.a(i, l2);
                localObject = BaseApplicationImpl.getContext().getResources();
                l2 = Math.max(DeviceInfoUtil.h(), DeviceInfoUtil.g());
                this.mRoleWidth = ((j - AIOUtils.a(66.0F, (Resources)localObject)) / DeviceInfoUtil.a());
                f2 = FontSettingManager.getFontLevel() / 16.0F;
                if (f2 != 0.0F)
                {
                  if (f2 > 1.0F)
                  {
                    f1 = 1.05F;
                    this.mRoleWidth = (f1 * this.mRoleWidth);
                  }
                }
                else
                {
                  f1 = (float)(l2 >> 2) / 368.0F;
                  if (l2 != DeviceInfoUtil.j()) {
                    QLog.e("SettingMeApolloViewController", 1, "DeviceInfoUtil.getPortraitHeight():" + DeviceInfoUtil.j() + " height:" + l2);
                  }
                  this.mSpriteDrawerInfoManager = new SpriteDrawerInfoManager(localQQAppInterface);
                  this.mSpriteDrawerInfoManager.a(f1, this.mRoleWidth, 15);
                  this.mApolloDrawerInfoViewListener = new ApolloDrawerInfoViewListener(this.mSpriteDrawerInfoManager, 1);
                  this.mApolloSurfaceView = new ApolloTextureView(localViewGroup.getContext(), null);
                  this.mApolloSurfaceView.init(this.mApolloDrawerInfoViewListener);
                  this.mSpriteDrawerInfoManager.a(this.mApolloSurfaceView);
                  ThreadManager.post(new SettingMeApolloViewControllerImpl.4(this), 10, null, true);
                  this.mRoleId = paramCheckApolloInfoResult.jdField_a_of_type_Int;
                  this.mDressIds = paramCheckApolloInfoResult.jdField_a_of_type_ArrayOfInt;
                  this.mApolloSurfaceView.mIsDrawerView = true;
                  this.mApolloSurfaceView.mManHeight = ((float)(l2 >> 2));
                  localQQAppInterface.addObserver(this.mApolloDrawerInfoViewListener);
                  this.mApolloSurfaceView.setDispatchEvent2Native(true);
                  this.mSpriteDrawerInfoManager.a(this.mDrawerInfoCallback);
                  if (localQQSettingMe.a() == null) {
                    break label987;
                  }
                  f1 = localQQSettingMe.a().a();
                  f1 = localQQSettingMe.a().b();
                  paramCheckApolloInfoResult = new RelativeLayout.LayoutParams(j, i);
                  paramCheckApolloInfoResult.addRule(12, -1);
                  paramCheckApolloInfoResult.addRule(11, -1);
                  localViewGroup.addView(this.mApolloSurfaceView, paramCheckApolloInfoResult);
                  if ((localViewGroup instanceof SettingMeRelativeLayout)) {
                    ((SettingMeRelativeLayout)localViewGroup).setSurfaceView(this.mApolloSurfaceView, this.mApolloBoxEnterView, 0.0F, 0.0F);
                  }
                  this.mApolloBoxEnterView.bringToFront();
                  this.mApolloBoxEnterView.setVisibility(8);
                  this.mApolloBoxEnterView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                  float f3 = FontSettingManager.getFontLevel() / 16.0F;
                  f2 = f3;
                  if (f3 == 0.0F) {
                    f2 = 1.0F;
                  }
                  f2 = DeviceInfoUtil.a() / f2;
                  paramCheckApolloInfoResult = new RelativeLayout.LayoutParams((int)(45.0F * f2), (int)(45.0F * f2));
                  paramCheckApolloInfoResult.addRule(11, -1);
                  paramCheckApolloInfoResult.addRule(12, -1);
                  paramCheckApolloInfoResult.rightMargin = ((int)(f1 + 66.0F * f2 + AIOUtils.a(8.0F, (Resources)localObject)));
                  paramCheckApolloInfoResult.bottomMargin = ((int)(f2 * 5.0F));
                  this.mApolloBoxEnterView.setLayoutParams(paramCheckApolloInfoResult);
                  if (this.mApolloDrawerStatus != 1) {
                    break label1019;
                  }
                  this.mApolloBoxEnterView.a(localQQAppInterface, "drawer", localQQAppInterface.getCurrentAccountUin(), -1);
                  if (this.mApolloSurfaceView.getVisibility() != 0) {
                    this.mApolloSurfaceView.setVisibility(0);
                  }
                  if ((localViewGroup instanceof SettingMeRelativeLayout)) {
                    ((SettingMeRelativeLayout)localViewGroup).a();
                  }
                }
              }
            }
            for (;;)
            {
              if (!QLog.isColorLevel()) {
                break label1113;
              }
              QLog.d("SettingMeApolloViewController", 2, "refresh ApolloSettingMe->" + (System.currentTimeMillis() - l1));
              return;
              f1 = f2;
              if (f2 >= 1.0F) {
                break;
              }
              f1 = 0.95F;
              break;
              label987:
              f1 = (float)(((Resources)localObject).getDisplayMetrics().density * 100.0F + 0.5D);
              f1 = ((Resources)localObject).getDimensionPixelSize(2131298524);
              break label685;
              label1019:
              this.mApolloBoxEnterView.setVisibility(8);
              break label900;
              TraceReportUtil.a(paramCheckApolloInfoResult.e, 11, 107, new Object[] { "already init" });
              if (this.mApolloDrawerStatus != 1) {
                break label900;
              }
              this.mApolloBoxEnterView.a(localQQAppInterface, "drawer", localQQAppInterface.getCurrentAccountUin(), -1);
              break label900;
              TraceReportUtil.a(paramCheckApolloInfoResult.e, 11, 108, new Object[] { "mApolloDrawerStatus:", Integer.valueOf(this.mApolloDrawerStatus) });
            }
          }
        }
      }
    }
  }
  
  private void clickApollo(String paramString)
  {
    QQSettingMe localQQSettingMe = (QQSettingMe)this.mQQSettingMeRef.get();
    if (localQQSettingMe == null) {}
    QQAppInterface localQQAppInterface;
    ViewGroup localViewGroup;
    do
    {
      do
      {
        return;
        localQQAppInterface = localQQSettingMe.a();
      } while (localQQAppInterface == null);
      localViewGroup = (ViewGroup)this.mContentViewRef.get();
    } while (localViewGroup == null);
    if (this.mApolloBoxEnterView.getVisibility() == 0) {}
    ApolloDrawerStatus localApolloDrawerStatus;
    Object localObject;
    for (int j = 1;; j = 0)
    {
      Intent localIntent = new Intent();
      String str2 = localQQAppInterface.getCurrentAccountUin();
      localIntent.putExtra("extra_key_box_uin", str2);
      localIntent.putExtra("extra_key_open_box", this.mApolloBoxEnterView.a());
      if (j != 0)
      {
        this.mApolloBoxEnterView.setApolloHadStolen();
        localIntent.putExtra("key_box_type", this.mApolloBoxEnterView.a());
      }
      localIntent.putExtra("extra_key_box_from", "drawer");
      localApolloDrawerStatus = this.mApolloDrawer.a();
      ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      String str1 = localApolloManagerServiceImpl.mLastShopTab;
      if (QLog.isColorLevel()) {
        QLog.d("SettingMeApolloViewController", 2, new Object[] { "[onNotifyStatusChanged] lastTab=", str1 });
      }
      localObject = str1;
      if (localApolloDrawerStatus != null)
      {
        localObject = str1;
        if ((localApolloDrawerStatus instanceof PushDrawerStatus))
        {
          PushDrawerStatus localPushDrawerStatus = (PushDrawerStatus)localApolloDrawerStatus;
          localObject = str1;
          if (localPushDrawerStatus.b)
          {
            localObject = str1;
            if (localPushDrawerStatus.a != null)
            {
              String str3 = localPushDrawerStatus.a.scheme;
              localObject = str1;
              if (!TextUtils.isEmpty(str3))
              {
                str1 = str3.trim();
                localPushDrawerStatus.a(localQQAppInterface);
                localObject = str1;
                if (QLog.isColorLevel())
                {
                  QLog.d("SettingMeApolloViewController", 2, new Object[] { "[onNotifyStatusChanged] scheme from bubble=", str1 });
                  localObject = str1;
                }
              }
            }
          }
        }
      }
      localObject = localApolloManagerServiceImpl.getLastTabUrl(1, (String)localObject);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(ApolloConstant.v))) {
        localIntent.putExtra("extra_key_url_append", "&tab=interactive&suin=" + str2);
      }
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(localViewGroup.getContext(), localIntent, "drawer", (String)localObject, null);
      localObject = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
      if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("pet"))) {
        break;
      }
      VipUtils.a(null, "cmshow", "Apollo", "drawerpetclick", 0, 0, new String[] { ((ApolloManagerServiceImpl)localObject).getPetId(localQQAppInterface.getCurrentUin()) });
      if (j != 0)
      {
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "0X80065C0", 0, 0, new String[] { "0" });
        this.mApolloBoxEnterView.setVisibility(8);
      }
      localQQSettingMe.G();
      if ((localApolloDrawerStatus instanceof HireDrawerStatus)) {
        ((HireDrawerStatus)localApolloDrawerStatus).a(localQQAppInterface);
      }
      apolloDtSpriteReport(localQQAppInterface, "click");
      return;
    }
    int k = this.mApolloFeatureFlag;
    int m = ApolloDrawerInfoManager.a(this.mApolloDrawerStatus);
    label566:
    int i;
    if (j != 0)
    {
      paramString = "0";
      if ((localApolloDrawerStatus == null) || (!localApolloDrawerStatus.b)) {
        break label622;
      }
      i = 2;
    }
    for (;;)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_clk", k, m, new String[] { paramString, String.valueOf(i) });
      break;
      paramString = "1";
      break label566;
      label622:
      if (((ApolloManagerServiceImpl)localObject).mIsNewStoreUser) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  private boolean initApolloDrawerStatusView(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SettingMeApolloViewController", 2, new Object[] { "initApolloDrawerStatusView:", Integer.valueOf(paramInt) });
    }
    switch (paramInt)
    {
    }
    do
    {
      return true;
      if (this.mApolloSurfaceView != null) {
        this.mApolloSurfaceView.setVisibility(8);
      }
      this.mApolloBoxEnterView.setVisibility(8);
      this.mApolloSettingMeImg.setVisibility(8);
      this.mApolloStaticEntry.setVisibility(8);
    } while (paramInt == 0);
    return false;
  }
  
  private void showApolloFirstGuide()
  {
    Object localObject = (QQSettingMe)this.mQQSettingMeRef.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).a();
    } while ((localObject == null) || (!BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getBoolean(((QQAppInterface)localObject).getAccount() + "apollo_settingme_first_enter", true)) || (ApolloDrawerInfoManager.a(this.mApolloDrawerStatus)));
    localObject = new FirstDrawerStatus((QQAppInterface)localObject);
    this.mApolloDrawer.a((ApolloDrawerStatus)localObject);
  }
  
  public void destroyApollo()
  {
    QLog.i("SettingMeApolloViewController", 1, "destroyApollo");
    Object localObject = (QQSettingMe)this.mQQSettingMeRef.get();
    if (localObject == null) {}
    do
    {
      ViewGroup localViewGroup;
      do
      {
        do
        {
          return;
          localObject = ((QQSettingMe)localObject).a();
        } while (localObject == null);
        localViewGroup = (ViewGroup)this.mContentViewRef.get();
      } while (localViewGroup == null);
      if ((localViewGroup instanceof SettingMeRelativeLayout)) {
        ((SettingMeRelativeLayout)localViewGroup).setSurfaceView(null, null, 1.0F, 0.0F);
      }
      if (this.mSpriteDrawerInfoManager != null)
      {
        this.mSpriteDrawerInfoManager.d();
        this.mSpriteDrawerInfoManager = null;
      }
      if ((localObject != null) && (this.mApolloDrawerInfoViewListener != null))
      {
        ((QQAppInterface)localObject).removeObserver(this.mApolloDrawerInfoViewListener);
        this.mApolloDrawerInfoViewListener = null;
      }
      if (this.mApolloSurfaceView != null)
      {
        localViewGroup.removeView(this.mApolloSurfaceView);
        this.mApolloSurfaceView = null;
      }
      this.mIsDestroyApollo = true;
      this.mIsSurfaceReady = false;
    } while (!QLog.isColorLevel());
    QLog.d("SettingMeApolloViewController", 2, "destroyApollo end");
  }
  
  public void getApolloCardAction()
  {
    Object localObject = (QQSettingMe)this.mQQSettingMeRef.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).a();
    } while ((localObject == null) || (this.mApolloDrawer == null));
    localObject = new CardDrawerStatus((QQAppInterface)localObject);
    this.mApolloDrawer.a((ApolloDrawerStatus)localObject);
  }
  
  @NotNull
  public BusinessObserver getObserver()
  {
    return this.cmshowObserver;
  }
  
  public View getView()
  {
    return this.mApolloSurfaceView;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 65536: 
      do
      {
        do
        {
          return false;
        } while ((QQSettingMe)this.mQQSettingMeRef.get() == null);
        if (this.mDrawerClosed)
        {
          QLog.i("SettingMeApolloViewController", 1, "MSG_CODE_REFRESH_APOLLO on DrawerClosed!");
          TraceReportUtil.a(SpriteUtil.b(1), 11, 106, new Object[] { "DrawerClosed" });
          return false;
        }
      } while (!(paramMessage.obj instanceof CheckApolloInfoResult));
      checkApolloUI((CheckApolloInfoResult)paramMessage.obj);
      return false;
    }
    QLog.i("SettingMeApolloViewController", 1, "MSG_CODE_DESTROY_APOLLO_ON_BACKGROUND");
    destroyApollo();
    return false;
  }
  
  public void init(QQSettingMe paramQQSettingMe, ViewGroup paramViewGroup)
  {
    this.mQQSettingMeRef = new WeakReference(paramQQSettingMe);
    this.mContentViewRef = new WeakReference(paramViewGroup);
    this.mRefreshApolloTask = new SettingMeApolloViewControllerImpl.RefreshApolloTask(paramQQSettingMe, this);
    this.mApolloBoxEnterView = ((ApolloBoxEnterView)paramViewGroup.findViewById(2131362799));
    this.mApolloBoxEnterView.setOnClickListener(this);
    this.mApolloBoxEnterView.setContentDescription(BaseApplicationImpl.getContext().getResources().getString(2131690165));
    this.mApolloSettingMeImg = ((FrameGifView)paramViewGroup.findViewById(2131362851));
    this.mApolloSettingMeImg.setOnClickListener(this);
    this.mApolloStaticEntry = paramViewGroup.findViewById(2131362856);
    this.mApolloStaticEntry.setOnClickListener(this);
    this.mApolloDrawer = new ApolloDrawerContext();
  }
  
  public void initApolloDrawerStatus()
  {
    Object localObject = (QQSettingMe)this.mQQSettingMeRef.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).a();
    } while (localObject == null);
    this.mApolloDrawerStatus = 0;
    this.mApolloDrawerStatus = ((ApolloManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all")).getDrawerStatus((QQAppInterface)localObject);
    QLog.d("SettingMeApolloViewController", 1, new Object[] { "initApolloDrawerStatus:", Integer.valueOf(this.mApolloDrawerStatus) });
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    QQSettingMe localQQSettingMe;
    QQAppInterface localQQAppInterface;
    do
    {
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localQQSettingMe = (QQSettingMe)this.mQQSettingMeRef.get();
      } while (localQQSettingMe == null);
      localQQAppInterface = localQQSettingMe.a();
    } while (localQQAppInterface == null);
    Intent localIntent = new Intent();
    if (paramView.getId() == 2131362799)
    {
      localIntent.putExtra("extra_key_url_append", "&tab=interactive&suin=" + localQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("extra_key_box_uin", localQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("extra_key_open_box", this.mApolloBoxEnterView.a());
      if (this.mApolloBoxEnterView.getVisibility() == 0)
      {
        this.mApolloBoxEnterView.setApolloHadStolen();
        localIntent.putExtra("key_box_type", this.mApolloBoxEnterView.a());
      }
      localIntent.putExtra("extra_key_box_from", "drawer");
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "0X80065C0", 0, 0, new String[] { "0" });
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(paramView.getContext(), localIntent, "drawer", ApolloConstant.v, null);
      label247:
      if (this.mApolloBoxEnterView.getVisibility() != 0) {
        break label340;
      }
      this.mApolloBoxEnterView.setVisibility(8);
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_clk", this.mApolloFeatureFlag, ApolloDrawerInfoManager.a(this.mApolloDrawerStatus), new String[] { "1", "" });
    }
    for (;;)
    {
      localQQSettingMe.G();
      break;
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(paramView.getContext(), localIntent, "drawer", ApolloConstant.u, null);
      break label247;
      label340:
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_clk", this.mApolloFeatureFlag, ApolloDrawerInfoManager.a(this.mApolloDrawerStatus), new String[] { "0", "" });
    }
  }
  
  public void onDestroy()
  {
    if (this.mApolloSurfaceView != null) {
      this.mApolloSurfaceView.getRenderImpl().c();
    }
    if (this.mApolloSettingMeImg != null)
    {
      this.mApolloSettingMeImg.c();
      this.mApolloSettingMeImg.setImageBitmap(null);
    }
    destroyApollo();
    QLog.i("SettingMeApolloViewController", 1, "onDestroy");
  }
  
  public void onDrawerClosed()
  {
    this.mDrawerClosed = true;
    ThreadManager.removeJobFromThreadPool(this.mRefreshApolloTask, 16);
    this.mIsActionPlay = false;
    if (this.mApolloSurfaceView != null) {
      this.mApolloSurfaceView.getRenderImpl().a(1, null, "Bubble");
    }
    if (this.mApolloDrawer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SettingMeApolloViewController", 2, "set apollodrawer status 9999");
      }
      this.mApolloDrawer.a();
    }
    QLog.i("SettingMeApolloViewController", 1, "onDrawerClosed sDisableDestroySettingmeSwitch:" + ApolloConfigUtils.c);
    Object localObject = (QQSettingMe)this.mQQSettingMeRef.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).a();
    } while ((localObject == null) || (((IApolloManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentAccountUin()) != 2) || (ApolloConfigUtils.c));
    this.mUIHandler.removeMessages(65537);
    if (ApolloConfigUtils.b > 0) {
      sDestroyTimeOut = ApolloConfigUtils.b * 1000;
    }
    this.mUIHandler.sendEmptyMessageDelayed(65537, sDestroyTimeOut);
    QLog.d("SettingMeApolloViewController", 1, new Object[] { "send delay msg MSG_CODE_DESTROY_APOLLO_ON_BACKGROUND sDestroyTimeOut:", Long.valueOf(sDestroyTimeOut) });
  }
  
  public void onDrawerOpened()
  {
    this.mDrawerClosed = false;
    this.mUIHandler.removeCallbacksAndMessages(Integer.valueOf(65537));
    Object localObject;
    if (this.mIsSurfaceReady)
    {
      localObject = (QQSettingMe)this.mQQSettingMeRef.get();
      if (localObject != null) {
        break label40;
      }
    }
    label40:
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).a();
    } while (localObject == null);
    apolloDtSpriteReport((QQAppInterface)localObject, "expose");
  }
  
  public void onPause()
  {
    this.mIsActionPlay = false;
    if (this.mApolloBoxEnterView != null) {
      this.mApolloBoxEnterView.setVisibility(8);
    }
    if (this.mSpriteDrawerInfoManager != null) {
      this.mSpriteDrawerInfoManager.b();
    }
    if (this.mApolloBoxEnterView != null) {
      this.mApolloBoxEnterView.setVisibility(8);
    }
    if (this.mExploreBox != null)
    {
      this.mExploreBox.setVisibility(8);
      this.mExploreBox.c();
    }
    Object localObject = (QQSettingMe)this.mQQSettingMeRef.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).a();
    } while (localObject == null);
    if (this.mApolloDrawer != null) {
      this.mApolloDrawer.a((QQAppInterface)localObject, this.mSpriteDrawerInfoManager);
    }
    QLog.i("SettingMeApolloViewController", 1, "onPause");
  }
  
  public void parseApolloRedTouch()
  {
    Object localObject1 = (QQSettingMe)this.mQQSettingMeRef.get();
    if (localObject1 == null) {}
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          return;
          localObject1 = ((QQSettingMe)localObject1).a();
        } while ((localObject1 == null) || (localObject1 == null) || (Build.VERSION.SDK_INT < 14));
        localObject2 = (RedTouchManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.MGR_RED_TOUCH);
      } while (!ApolloGameUtil.a((AppRuntime)localObject1));
      localObject1 = new ArrayList();
      i = 0;
      while (i < ApolloConstant.b.length)
      {
        localObject3 = ((RedTouchManager)localObject2).a(ApolloConstant.b[i]);
        if ((localObject3 != null) && (!TextUtils.isEmpty(((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.get()))) {
          ((List)localObject1).add(localObject3);
        }
        i += 1;
      }
    } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
    int i = 0;
    label136:
    if (i < ((List)localObject1).size())
    {
      QLog.d("SettingMeApolloViewController", 1, "buffer = " + ((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).buffer.get());
      localObject2 = ((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).path.get();
      localObject3 = ((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).buffer.get();
      if (((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).iNewFlag.get() != 1) {
        break label263;
      }
    }
    label263:
    for (boolean bool = true;; bool = false)
    {
      parseApolloRedTouchJson(0, (String)localObject2, (String)localObject3, bool);
      i += 1;
      break label136;
      break;
    }
  }
  
  public boolean parseApolloRedTouchJson(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    JSONObject localJSONObject;
    try
    {
      localObject1 = (QQSettingMe)this.mQQSettingMeRef.get();
      if (localObject1 == null) {
        return false;
      }
      localObject1 = ((QQSettingMe)localObject1).a();
      if (localObject1 == null) {
        return false;
      }
      localObject2 = new JSONObject(paramString2);
      paramString2 = ((JSONObject)localObject2).optString("_show_mission");
      localObject2 = ((JSONObject)localObject2).optJSONObject("msg");
      if (localObject2 != null)
      {
        localJSONObject = ((JSONObject)localObject2).optJSONObject(paramString2);
        if (localJSONObject == null) {
          break label571;
        }
        int i = localJSONObject.optInt("time");
        int j = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getInt(paramString1, 0);
        QLog.d("SettingMeApolloViewController", 1, new Object[] { "parseApolloRedTouchJson timestamp=", Integer.valueOf(i), ", spTimeStamp=", Integer.valueOf(j) });
        if (i == j) {
          return false;
        }
        localObject2 = localJSONObject.optString("content");
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localJSONObject = new JSONObject((String)localObject2);
          localObject2 = new DrawerPushItem();
          ((DrawerPushItem)localObject2).msg_type = paramInt;
          ((DrawerPushItem)localObject2).is_reddot = 1;
          ((DrawerPushItem)localObject2).msg_id = paramString2;
          if (!localJSONObject.has("mainPriority")) {
            return false;
          }
          ((DrawerPushItem)localObject2).act_id = localJSONObject.optString("id");
          ((DrawerPushItem)localObject2).priority = localJSONObject.optInt("mainPriority");
          ((DrawerPushItem)localObject2).sub_priority = localJSONObject.optInt("subPriority");
          ((DrawerPushItem)localObject2).start_ts = localJSONObject.optInt("showTime");
          ((DrawerPushItem)localObject2).end_ts = localJSONObject.optInt("expireTime");
          ((DrawerPushItem)localObject2).send_time = i;
          ((DrawerPushItem)localObject2).action_id = localJSONObject.optInt("actionId");
          ((DrawerPushItem)localObject2).reddotGameId = localJSONObject.optInt("gameId");
          ((DrawerPushItem)localObject2).color = localJSONObject.optInt("fontColor");
          ((DrawerPushItem)localObject2).content = localJSONObject.optString("bubbleText");
          ((DrawerPushItem)localObject2).bubble_res_id = localJSONObject.optInt("bubbleID");
          ((DrawerPushItem)localObject2).target_model = localJSONObject.optInt("targetModel");
          paramInt = localJSONObject.optInt("type");
          ((DrawerPushItem)localObject2).scheme = localJSONObject.optString("scheme");
          if (paramInt == 0) {}
          for (;;)
          {
            ((DrawerPushItem)localObject2).show_counts = localJSONObject.optInt("showCounts");
            ((DrawerPushItem)localObject2).reddotPath = paramString1;
            paramString1 = (ApolloManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloManagerService.class, "all");
            if (!paramBoolean) {
              break label543;
            }
            QLog.d("SettingMeApolloViewController", 1, new Object[] { "parseApolloRedTouchJson, item=", localObject2 });
            paramString1.addPushItem((DrawerPushItem)localObject2);
            break label624;
            if (paramInt != 1) {
              break;
            }
            ((DrawerPushItem)localObject2).ext_url = ApolloConstant.g;
          }
        }
      }
      return false;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SettingMeApolloViewController", 2, "parseRedInfo error :" + paramString1.toString());
      }
    }
    while (paramInt == 2)
    {
      ((DrawerPushItem)localObject2).ext_url = localJSONObject.optString("url");
      break;
      label543:
      QLog.d("SettingMeApolloViewController", 1, new Object[] { "parseApolloRedTouchJson, clearBubble, redId=", paramString2 });
      paramString1.clearBubble(paramString2);
      break label624;
      label571:
      if ((!paramBoolean) && ((this.mApolloDrawer.a() instanceof PushDrawerStatus)) && (((JSONObject)localObject2).has(String.valueOf(PushDrawerStatus.d)))) {
        ((ApolloManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloManagerService.class, "all")).clearBubble(PushDrawerStatus.d);
      }
    }
    label624:
    return true;
  }
  
  public void recoverApollo()
  {
    if ((this.mApolloDrawerStatus != 1) && (this.mApolloDrawerStatus != 6)) {
      return;
    }
    destroyApollo();
    refreshApolloView();
  }
  
  @TargetApi(14)
  public void refreshApolloView()
  {
    QQSettingMe localQQSettingMe = (QQSettingMe)this.mQQSettingMeRef.get();
    if (localQQSettingMe == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
        QLog.d("SettingMeApolloViewController", 1, new Object[] { "refreshApolloView isResume:", Boolean.valueOf(localQQSettingMe.a()) });
        this.mUIHandler.removeMessages(65537);
      } while ((localQQSettingMe.a()) && (!this.mIsDestroyApollo));
      this.mIsDestroyApollo = false;
      bool = initApolloDrawerStatusView(this.mApolloDrawerStatus);
      if (bool) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SettingMeApolloViewController", 2, new Object[] { "refreshApolloView not show apollo,needShowApollo:", Boolean.valueOf(bool) });
    return;
    CmShowStatUtil.a("drawer_pre");
    if (this.mSpriteDrawerInfoManager != null) {
      this.mSpriteDrawerInfoManager.c();
    }
    ThreadManagerV2.removeJobFromThreadPool(this.mRefreshApolloTask, 16);
    ThreadManagerV2.excute(this.mRefreshApolloTask, 16, null, true);
  }
  
  public void showExploreBox(String paramString)
  {
    ThreadManager.getUIHandler().post(new SettingMeApolloViewControllerImpl.3(this, paramString));
  }
  
  public void showPushInfo()
  {
    Object localObject1 = (QQSettingMe)this.mQQSettingMeRef.get();
    if (localObject1 == null) {}
    do
    {
      do
      {
        return;
        localObject1 = ((QQSettingMe)localObject1).a();
      } while (localObject1 == null);
      localObject2 = (ApolloManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloManagerService.class, "all");
    } while (!ApolloGameUtil.a((AppRuntime)localObject1));
    Object localObject2 = ((ApolloManagerServiceImpl)localObject2).getCurrentPushItemByUserStatus(0, ApolloDrawerInfoManager.b(this.mApolloDrawerStatus));
    if (localObject2 != null)
    {
      QLog.d("SettingMeApolloViewController", 1, new Object[] { "showPushInfo item:", localObject2 });
      localObject2 = new PushDrawerStatus((QQAppInterface)localObject1, (DrawerPushItem)localObject2);
      this.mApolloDrawer.a((ApolloDrawerStatus)localObject2);
    }
    for (;;)
    {
      long l = ((QQAppInterface)localObject1).getApp().getSharedPreferences("apollo_sp" + ((QQAppInterface)localObject1).getCurrentUin(), 0).getLong("hire_end", 0L);
      if ((NetConnInfoCenter.getServerTime() < l) && (!ApolloDrawerInfoManager.a(this.mApolloDrawerStatus)))
      {
        localObject1 = new HireDrawerStatus((QQAppInterface)localObject1);
        this.mApolloDrawer.a((ApolloDrawerStatus)localObject1);
      }
      showApolloFirstGuide();
      return;
      ((ApolloExtensionHandlerImpl)((QQAppInterface)localObject1).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).c(1);
    }
  }
  
  public void updateCmshowStatus()
  {
    ThreadManager.post(new SettingMeApolloViewControllerImpl.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.SettingMeApolloViewControllerImpl
 * JD-Core Version:    0.7.0.1
 */