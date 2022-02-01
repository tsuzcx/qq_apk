package com.tencent.mobileqq.apollo.drawer.impl;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.SettingMeRelativeLayout;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeApolloProcessor;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeViewModel;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.config.ApolloConfigUtils;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerContext;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerInfoManager;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerInfoViewListener;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerStrategy;
import com.tencent.mobileqq.apollo.drawer.CardDrawerStrategy;
import com.tencent.mobileqq.apollo.drawer.DefaultDrawerStrategy;
import com.tencent.mobileqq.apollo.drawer.FirstDrawerStrategy;
import com.tencent.mobileqq.apollo.drawer.HireDrawerStrategy;
import com.tencent.mobileqq.apollo.drawer.ISettingMeApolloViewController;
import com.tencent.mobileqq.apollo.drawer.PushDrawerStrategy;
import com.tencent.mobileqq.apollo.drawer.QQStatusDrawerStrategy;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.apollo.model.ApolloBaseInfo;
import com.tencent.mobileqq.apollo.model.ApolloSkeletonBounding;
import com.tencent.mobileqq.apollo.model.CheckApolloInfoResult;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.apollo.script.drawerinfo.SpriteDrawerInfoManager;
import com.tencent.mobileqq.apollo.statistics.CmShowStatUtil;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.apollo.statistics.product.DtReportParamsBuilder;
import com.tencent.mobileqq.apollo.statistics.trace.TraceReportUtil;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.touch.ICMTouchManager;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.cmshow.brickengine.BKUtils;
import com.tencent.mobileqq.cmshow.crossengine.CEEngineHelper;
import com.tencent.mobileqq.cmshow.engine.CMShowPlatform;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.model.RenderConfig;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.scene.Scene;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.ScriptUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.Builder;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow.DrawableBuilder;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public class SettingMeApolloViewControllerImpl
  implements Handler.Callback, View.OnClickListener, ISettingMeApolloViewController
{
  private static final int AUDIO_VIBRATOR_DURATION_MILLIS = 100;
  private static final int MSG_CODE_DESTROY_APOLLO_ON_BACKGROUND = 65537;
  private static final int MSG_CODE_PLAY_ACTION = 65535;
  private static final int MSG_CODE_REFRESH_APOLLO = 65536;
  public static final String TAG = "[cmshow][SettingMeApolloViewController]";
  private static long sDestroyTimeOut = 180000L;
  private static final Pattern sSpriteNodeNamePattern = Pattern.compile("^\\d+\\**\\d+(_\\d_\\d)?$");
  private ApolloExtensionObserver cmshowObserver = new SettingMeApolloViewControllerImpl.2(this);
  private ApolloBoxEnterView mApolloBoxEnterView;
  private ApolloDrawerContext mApolloDrawer;
  private ApolloDrawerInfoViewListener mApolloDrawerInfoViewListener;
  private int mApolloDrawerStatus = 0;
  private int mApolloFeatureFlag;
  private View mApolloStaticEntry;
  private View mBackgroundMaskView;
  private CalloutPopupWindow mCloseCmShowPopupWindow;
  private ICMShowEngine mCmShowEngine;
  private ICMShowView mCmShowView;
  private WeakReference<ViewGroup> mContentViewRef;
  private boolean mDrawerClosed;
  private ISpriteDrawerInfoCallback mDrawerInfoCallback = new SettingMeApolloViewControllerImpl.10(this);
  private int[] mDressIds;
  private FrameGifView mExploreBox;
  private boolean mIsActionPlay;
  private boolean mIsDestroyApollo = false;
  private boolean mIsSurfaceReady = false;
  private WeakReference<QQSettingMe> mQQSettingMeRef;
  private SettingMeApolloViewControllerImpl.RefreshApolloTask mRefreshApolloTask;
  private int mRoleId;
  private float mRoleWidth;
  private SpriteDrawerInfoManager mSpriteDrawerInfoManager;
  private View mSpritePlaceHolderView;
  private WeakReferenceHandler mUIHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
  private Vibrator mVibrator;
  
  private void apolloDtSpriteReport(QQAppInterface paramQQAppInterface, String paramString)
  {
    ApolloDtReportUtil.a("setting_me", "sprite", paramString, new DtReportParamsBuilder().a(ApolloDtReportUtil.a(paramQQAppInterface)).c(paramQQAppInterface.getCurrentAccountUin()).a());
  }
  
  private void checkApolloUI(CheckApolloInfoResult paramCheckApolloInfoResult)
  {
    if (paramCheckApolloInfoResult == null) {
      return;
    }
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.mContentViewRef.get();
    if (localViewGroup == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    Object localObject1 = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_show", this.mApolloFeatureFlag, ApolloDrawerInfoManager.a(this.mApolloDrawerStatus), new String[] { "", String.valueOf(((ApolloManagerServiceImpl)localObject1).mIsNewStoreUser ^ true) });
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("checkApolloUI roleId->");
      ((StringBuilder)localObject1).append(paramCheckApolloInfoResult.roleId);
      ((StringBuilder)localObject1).append(" apolloStatus->");
      ((StringBuilder)localObject1).append(this.mApolloFeatureFlag);
      ((StringBuilder)localObject1).append(" needStatic->");
      ((StringBuilder)localObject1).append(paramCheckApolloInfoResult.needStatic);
      QLog.d("[cmshow][SettingMeApolloViewController]", 2, new Object[] { ((StringBuilder)localObject1).toString(), ",mApolloDrawerStatus->", Integer.valueOf(this.mApolloDrawerStatus) });
    }
    if (this.mDrawerClosed)
    {
      QLog.i("[cmshow][SettingMeApolloViewController]", 1, "checkApolloUI on DrawerClosed!");
      TraceReportUtil.a(paramCheckApolloInfoResult.traceFeatureId, 11, 106, new Object[] { "DrawerClosed" });
      return;
    }
    this.mApolloStaticEntry.setVisibility(8);
    if (!isDrawerCmShowOpen())
    {
      TraceReportUtil.a(paramCheckApolloInfoResult.traceFeatureId, 11, 108, new Object[] { "mApolloDrawerStatus:", Integer.valueOf(this.mApolloDrawerStatus) });
      return;
    }
    if (this.mBackgroundMaskView == null)
    {
      this.mBackgroundMaskView = new View(localViewGroup.getContext());
      this.mBackgroundMaskView.setBackgroundResource(2131168376);
      this.mBackgroundMaskView.setVisibility(8);
      localObject1 = new RelativeLayout.LayoutParams(-1, -1);
      this.mBackgroundMaskView.setOnClickListener(this);
      localViewGroup.addView(this.mBackgroundMaskView, (ViewGroup.LayoutParams)localObject1);
    }
    if (this.mCmShowView == null)
    {
      TraceReportUtil.a(paramCheckApolloInfoResult.traceFeatureId, 11, 0, new Object[] { "checkUI done" });
      TraceReportUtil.a(paramCheckApolloInfoResult.traceFeatureId, 100);
      long l2 = DeviceInfoUtil.D();
      int i = (int)((float)DeviceInfoUtil.E() * 0.4F);
      int j = ApolloDrawerInfoManager.a(i, l2);
      l2 = Math.max(DeviceInfoUtil.C(), DeviceInfoUtil.B());
      this.mRoleWidth = ((j - ViewUtils.dip2px(66.0F)) / DeviceInfoUtil.A());
      float f2 = FontSettingManager.getFontLevel() / 16.0F;
      if (f2 != 0.0F)
      {
        if (f2 > 1.0F)
        {
          f1 = 1.05F;
        }
        else
        {
          f1 = f2;
          if (f2 < 1.0F) {
            f1 = 0.95F;
          }
        }
        this.mRoleWidth *= f1;
      }
      float f1 = (float)(l2 >> 2) / 368.0F;
      if (l2 != DeviceInfoUtil.E())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("DeviceInfoUtil.getPortraitHeight():");
        ((StringBuilder)localObject1).append(DeviceInfoUtil.E());
        ((StringBuilder)localObject1).append(" height:");
        ((StringBuilder)localObject1).append(l2);
        QLog.e("[cmshow][SettingMeApolloViewController]", 1, ((StringBuilder)localObject1).toString());
      }
      this.mSpriteDrawerInfoManager = new SpriteDrawerInfoManager(localQQAppInterface);
      this.mSpriteDrawerInfoManager.a(f1, this.mRoleWidth, 15);
      this.mApolloDrawerInfoViewListener = new SettingMeApolloViewControllerImpl.4(this, this.mSpriteDrawerInfoManager, 1);
      localObject1 = Arrays.asList(new Scene[] { Scene.DRAWER });
      CEEngineHelper.a.a((List)localObject1, localViewGroup);
      this.mCmShowEngine = CMShowPlatform.a.a(BaseApplicationImpl.getApplication(), Scene.DRAWER);
      localObject1 = this.mCmShowEngine.c();
      ((IRenderService)localObject1).a(this.mApolloDrawerInfoViewListener);
      ((IRenderService)localObject1).a(this.mApolloDrawerInfoViewListener);
      Object localObject2 = new RenderConfig();
      ((RenderConfig)localObject2).a = true;
      ((RenderConfig)localObject2).e = true;
      ((IRenderService)localObject1).a((RenderConfig)localObject2);
      this.mCmShowView = ((IRenderService)localObject1).a();
      this.mCmShowView.getTouchManager().b(true);
      this.mSpriteDrawerInfoManager.a(this.mCmShowEngine);
      ThreadManager.post(new SettingMeApolloViewControllerImpl.5(this), 10, null, true);
      this.mRoleId = paramCheckApolloInfoResult.roleId;
      this.mDressIds = paramCheckApolloInfoResult.dressIds;
      localQQAppInterface.addObserver(this.mApolloDrawerInfoViewListener);
      this.mSpriteDrawerInfoManager.a(this.mDrawerInfoCallback);
      paramCheckApolloInfoResult = new RelativeLayout.LayoutParams(j, i);
      paramCheckApolloInfoResult.addRule(12, -1);
      paramCheckApolloInfoResult.addRule(11, -1);
      localViewGroup.addView(this.mCmShowView.getView(), paramCheckApolloInfoResult);
      if ((localViewGroup instanceof SettingMeRelativeLayout)) {
        ((SettingMeRelativeLayout)localViewGroup).setSurfaceView(this.mCmShowView.getView(), this.mApolloBoxEnterView, 0.0F, 0.0F);
      }
      this.mApolloBoxEnterView.bringToFront();
      this.mApolloBoxEnterView.setVisibility(8);
      this.mApolloBoxEnterView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramCheckApolloInfoResult = new RelativeLayout.LayoutParams(ViewUtils.dip2px(45.0F), ViewUtils.dip2px(45.0F));
      paramCheckApolloInfoResult.addRule(11, -1);
      paramCheckApolloInfoResult.addRule(12, -1);
      i = ViewUtils.dip2px(8.0F);
      paramCheckApolloInfoResult.rightMargin = ((int)(getBoxViewWidth(BaseApplicationImpl.getContext().getResources()) + ViewUtils.dip2px(66.0F) + i));
      paramCheckApolloInfoResult.bottomMargin = ViewUtils.dip2px(5.0F);
      this.mApolloBoxEnterView.setLayoutParams(paramCheckApolloInfoResult);
      if (this.mApolloDrawerStatus == 1) {
        this.mApolloBoxEnterView.a(localQQAppInterface, "drawer", localQQAppInterface.getCurrentAccountUin(), -1);
      }
      paramCheckApolloInfoResult = ((ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(localQQAppInterface.getCurrentAccountUin());
      localObject1 = BaseApplicationImpl.getApplication();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("get_user_apollo_info_drawer_dress_sp");
      ((StringBuilder)localObject2).append(localQQAppInterface.getCurrentUin());
      if ((!((BaseApplicationImpl)localObject1).getSharedPreferences(((StringBuilder)localObject2).toString(), 0).getString("bubble", "").equals("")) && (paramCheckApolloInfoResult.apolloDrawerStatus != 0)) {
        showApolloNoneUserBubble();
      }
      this.mCmShowEngine.k();
      this.mCmShowView.resume();
    }
    else
    {
      TraceReportUtil.a(paramCheckApolloInfoResult.traceFeatureId, 11, 107, new Object[] { "already init" });
      if (this.mApolloDrawerStatus == 1) {
        this.mApolloBoxEnterView.a(localQQAppInterface, "drawer", localQQAppInterface.getCurrentAccountUin(), -1);
      }
    }
    paramCheckApolloInfoResult = this.mCmShowView.getView();
    if (paramCheckApolloInfoResult != null)
    {
      if (paramCheckApolloInfoResult.getVisibility() != 0) {
        paramCheckApolloInfoResult.setVisibility(0);
      }
      paramCheckApolloInfoResult.setId(2131428475);
    }
    if ((localViewGroup instanceof SettingMeRelativeLayout)) {
      ((SettingMeRelativeLayout)localViewGroup).a();
    }
    if (QLog.isColorLevel())
    {
      paramCheckApolloInfoResult = new StringBuilder();
      paramCheckApolloInfoResult.append("refresh ApolloSettingMe->");
      paramCheckApolloInfoResult.append(System.currentTimeMillis() - l1);
      QLog.d("[cmshow][SettingMeApolloViewController]", 2, paramCheckApolloInfoResult.toString());
    }
  }
  
  private void clickApollo(String paramString)
  {
    QQSettingMe localQQSettingMe = (QQSettingMe)this.mQQSettingMeRef.get();
    if (localQQSettingMe == null) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)localQQSettingMe.h();
    if (localQQAppInterface == null) {
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.mContentViewRef.get();
    if (localViewGroup == null) {
      return;
    }
    int j;
    if (this.mApolloBoxEnterView.getVisibility() == 0) {
      j = 1;
    } else {
      j = 0;
    }
    Intent localIntent = new Intent();
    String str1 = localQQAppInterface.getCurrentAccountUin();
    localIntent.putExtra("extra_key_box_uin", str1);
    localIntent.putExtra("extra_key_open_box", this.mApolloBoxEnterView.a());
    if (j != 0)
    {
      this.mApolloBoxEnterView.setApolloHadStolen();
      localIntent.putExtra("key_box_type", this.mApolloBoxEnterView.getBoxType());
    }
    localIntent.putExtra("extra_key_box_from", "drawer");
    ApolloDrawerStrategy localApolloDrawerStrategy = this.mApolloDrawer.b();
    ApolloManagerServiceImpl localApolloManagerServiceImpl = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    Object localObject2 = localApolloManagerServiceImpl.mLastShopTab;
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if (bool) {
      QLog.d("[cmshow][SettingMeApolloViewController]", 2, new Object[] { "[onNotifyStatusChanged] lastTab=", localObject2 });
    }
    Object localObject1 = localObject2;
    if (localApolloDrawerStrategy != null)
    {
      localObject1 = localObject2;
      if ((localApolloDrawerStrategy instanceof PushDrawerStrategy))
      {
        PushDrawerStrategy localPushDrawerStrategy = (PushDrawerStrategy)localApolloDrawerStrategy;
        localObject1 = localObject2;
        if (localPushDrawerStrategy.c)
        {
          localObject1 = localObject2;
          if (localPushDrawerStrategy.j != null)
          {
            String str2 = localPushDrawerStrategy.j.scheme;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty(str2))
            {
              localObject2 = str2.trim();
              localPushDrawerStrategy.a(localQQAppInterface);
              localObject1 = localObject2;
              if (QLog.isColorLevel())
              {
                QLog.d("[cmshow][SettingMeApolloViewController]", 2, new Object[] { "[onNotifyStatusChanged] scheme from bubble=", localObject2 });
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    }
    localObject1 = localApolloManagerServiceImpl.getLastTabUrl(1, (String)localObject1);
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(ApolloConstant.I)))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("&tab=interactive&suin=");
      ((StringBuilder)localObject2).append(str1);
      localIntent.putExtra("extra_key_url_append", ((StringBuilder)localObject2).toString());
    }
    ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(localViewGroup.getContext(), localIntent, "drawer", (String)localObject1, null);
    localObject1 = (ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("pet")))
    {
      VipUtils.a(null, "cmshow", "Apollo", "drawerpetclick", 0, 0, new String[] { ((ApolloManagerServiceImpl)localObject1).getPetId(localQQAppInterface.getCurrentUin()) });
    }
    else
    {
      int k = this.mApolloFeatureFlag;
      int m = ApolloDrawerInfoManager.a(this.mApolloDrawerStatus);
      if (j != 0) {
        paramString = "0";
      } else {
        paramString = "1";
      }
      if ((localApolloDrawerStrategy == null) || (!localApolloDrawerStrategy.c)) {
        if (((ApolloManagerServiceImpl)localObject1).mIsNewStoreUser) {
          i = 0;
        } else {
          i = 1;
        }
      }
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_clk", k, m, new String[] { paramString, String.valueOf(i) });
    }
    if (j != 0)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "0X80065C0", 0, 0, new String[] { "0" });
      this.mApolloBoxEnterView.setVisibility(8);
    }
    ((QQSettingMeApolloProcessor)localQQSettingMe.a().a("d_apollo")).a();
    if ((localApolloDrawerStrategy instanceof HireDrawerStrategy)) {
      ((HireDrawerStrategy)localApolloDrawerStrategy).a(localQQAppInterface);
    }
    apolloDtSpriteReport(localQQAppInterface, "click");
  }
  
  private DrawerPushItem convertBufferContent2PushItem(@NonNull String paramString1, int paramInt1, @NonNull String paramString2, int paramInt2, String paramString3)
  {
    paramString1 = new JSONObject(paramString1);
    if (!paramString1.has("mainPriority")) {
      return null;
    }
    DrawerPushItem localDrawerPushItem = new DrawerPushItem();
    localDrawerPushItem.msg_type = paramInt1;
    localDrawerPushItem.is_reddot = 1;
    localDrawerPushItem.msg_id = paramString2;
    localDrawerPushItem.act_id = paramString1.optString("id");
    localDrawerPushItem.priority = paramString1.optInt("mainPriority");
    localDrawerPushItem.sub_priority = paramString1.optInt("subPriority");
    localDrawerPushItem.start_ts = paramString1.optInt("showTime");
    localDrawerPushItem.end_ts = paramString1.optInt("expireTime");
    localDrawerPushItem.send_time = paramInt2;
    localDrawerPushItem.action_id = paramString1.optInt("actionId");
    localDrawerPushItem.reddotGameId = paramString1.optInt("gameId");
    localDrawerPushItem.color = paramString1.optInt("fontColor");
    localDrawerPushItem.content = paramString1.optString("bubbleText");
    localDrawerPushItem.bubble_res_id = paramString1.optInt("bubbleID");
    localDrawerPushItem.target_model = paramString1.optInt("targetModel");
    paramInt1 = paramString1.optInt("type");
    localDrawerPushItem.scheme = paramString1.optString("scheme");
    if (paramInt1 != 0) {
      if (paramInt1 == 1) {
        localDrawerPushItem.ext_url = ApolloConstant.t;
      } else if (paramInt1 == 2) {
        localDrawerPushItem.ext_url = paramString1.optString("url");
      }
    }
    localDrawerPushItem.show_counts = paramString1.optInt("showCounts");
    localDrawerPushItem.reddotPath = paramString3;
    return localDrawerPushItem;
  }
  
  private void getApolloCardAction()
  {
    Object localObject = getApp();
    if (localObject == null) {
      return;
    }
    if (this.mApolloDrawer != null)
    {
      localObject = new CardDrawerStrategy((QQAppInterface)localObject);
      this.mApolloDrawer.a((ApolloDrawerStrategy)localObject);
    }
  }
  
  private void getApolloQQStatusAction()
  {
    Object localObject = getApp();
    if (localObject == null)
    {
      QLog.e("[cmshow][SettingMeApolloViewController]", 1, "getApolloQQStatus err, QQAppInterface null");
      return;
    }
    if (this.mApolloDrawer != null)
    {
      localObject = new QQStatusDrawerStrategy((QQAppInterface)localObject);
      this.mApolloDrawer.a((ApolloDrawerStrategy)localObject);
    }
  }
  
  private QQAppInterface getApp()
  {
    Object localObject = this.mQQSettingMeRef;
    QQAppInterface localQQAppInterface = null;
    if (localObject != null) {
      localObject = (QQSettingMe)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    if (localObject != null) {
      localQQAppInterface = (QQAppInterface)((QQSettingMe)localObject).h();
    }
    return localQQAppInterface;
  }
  
  private float getBoxViewWidth(Resources paramResources)
  {
    float f = paramResources.getDimensionPixelSize(2131299233);
    paramResources = BaseActivity.sTopActivity;
    if (paramResources == null) {
      return f;
    }
    paramResources = FrameHelperActivity.a(paramResources);
    if (paramResources == null) {
      return f;
    }
    if (paramResources.ah == null) {
      return f;
    }
    return paramResources.ah.getTargetWidth();
  }
  
  private void handleCloseCmShow(@NonNull Context paramContext)
  {
    hideCloseCMShowUI();
    Object localObject = this.mCmShowView;
    if (localObject != null)
    {
      localObject = ((ICMShowView)localObject).getView();
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
    }
    showOpenCmShowGuideIfNotShowed(paramContext);
    paramContext = getApp();
    if (paramContext != null)
    {
      localObject = (IApolloDaoManagerService)paramContext.getRuntimeService(IApolloDaoManagerService.class, "all");
      ApolloBaseInfo localApolloBaseInfo = ((IApolloDaoManagerService)localObject).getApolloBaseInfo(paramContext.getCurrentUin());
      localApolloBaseInfo.apolloStatus = 2;
      ((IApolloDaoManagerService)localObject).saveOrUpdateApolloBaseInfo(localApolloBaseInfo);
      ((ApolloExtensionHandler)paramContext.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(2, "SettingMe", new SettingMeApolloViewControllerImpl.9(this));
    }
    else
    {
      QLog.e("[cmshow][SettingMeApolloViewController]", 1, "[handleCloseCmShow] error, app is null!");
    }
    apolloDtSpriteReport(getApp(), "hold_close");
  }
  
  private void handleCmShowViewOnLongTouch(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][SettingMeApolloViewController]", 2, new Object[] { "[onLongTouch] apolloId:", paramString });
    }
    if (this.mVibrator == null) {
      this.mVibrator = ((Vibrator)BaseApplicationImpl.getContext().getSystemService("vibrator"));
    }
    this.mVibrator.vibrate(100L);
    showCloseCMShowUI();
    apolloDtSpriteReport(getApp(), "hold");
  }
  
  private void hideCloseCMShowUI()
  {
    Object localObject = this.mBackgroundMaskView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.mSpritePlaceHolderView;
    if (localObject != null) {
      ((View)localObject).setVisibility(8);
    }
    localObject = this.mCloseCmShowPopupWindow;
    if (localObject != null) {
      ((CalloutPopupWindow)localObject).dismiss();
    }
  }
  
  private boolean initApolloDrawerStatusView(int paramInt)
  {
    boolean bool2 = QLog.isColorLevel();
    boolean bool1 = true;
    if (bool2) {
      QLog.d("[cmshow][SettingMeApolloViewController]", 2, new Object[] { "initApolloDrawerStatusView:", Integer.valueOf(paramInt) });
    }
    if ((paramInt != -1) && (paramInt != 0))
    {
      if (paramInt != 1) {
        return true;
      }
    }
    else
    {
      ICMShowView localICMShowView = this.mCmShowView;
      if ((localICMShowView != null) && (localICMShowView.getView() != null)) {
        this.mCmShowView.getView().setVisibility(8);
      }
      this.mApolloBoxEnterView.setVisibility(8);
      this.mApolloStaticEntry.setVisibility(8);
      if (paramInt == 0) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  private boolean isDrawerCmShowOpen()
  {
    int i = this.mApolloDrawerStatus;
    boolean bool = true;
    if (i != 1)
    {
      if (i == 6) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  private void parseApolloRedTouch()
  {
    Object localObject1 = getApp();
    if (localObject1 == null) {
      return;
    }
    if (!ApolloUtilImpl.isApolloUser((AppRuntime)localObject1)) {
      return;
    }
    Object localObject2 = (IRedTouchManager)((QQAppInterface)localObject1).getRuntimeService(IRedTouchManager.class, "");
    localObject1 = new ArrayList();
    int i = 0;
    Object localObject3;
    while (i < ApolloConstant.Z.length)
    {
      localObject3 = ((IRedTouchManager)localObject2).getAppInfoByPath(ApolloConstant.Z[i]);
      if ((localObject3 != null) && (!TextUtils.isEmpty(((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.get()))) {
        ((List)localObject1).add(localObject3);
      }
      i += 1;
    }
    if (((List)localObject1).size() == 0) {
      return;
    }
    i = 0;
    while (i < ((List)localObject1).size())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("parseApolloRedTouch buffer = ");
      ((StringBuilder)localObject2).append(((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).buffer.get());
      localObject2 = ((StringBuilder)localObject2).toString();
      boolean bool = true;
      QLog.d("[cmshow][SettingMeApolloViewController]", 1, (String)localObject2);
      localObject2 = ((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).path.get();
      localObject3 = ((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).buffer.get();
      if (((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).iNewFlag.get() != 1) {
        bool = false;
      }
      parseApolloRedTouchJson(0, (String)localObject2, (String)localObject3, bool);
      i += 1;
    }
  }
  
  private boolean parseApolloRedTouchJson(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      localObject1 = getApp();
      if (localObject1 == null) {
        return false;
      }
      Object localObject2 = new JSONObject(paramString2);
      String str = ((JSONObject)localObject2).optString("_show_mission");
      localObject2 = ((JSONObject)localObject2).optJSONObject("msg");
      if (localObject2 == null) {
        return false;
      }
      JSONObject localJSONObject = ((JSONObject)localObject2).optJSONObject(str);
      if (localJSONObject != null)
      {
        int i = localJSONObject.optInt("time");
        int j = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getInt(paramString1, 0);
        QLog.d("[cmshow][SettingMeApolloViewController]", 1, new Object[] { "parseApolloRedTouchJson timestamp=", Integer.valueOf(i), ", spTimeStamp=", Integer.valueOf(j) });
        if (i == j) {
          return false;
        }
        localObject2 = convertBufferContent2PushItem(localJSONObject.optString("content"), paramInt, str, i, paramString1);
        if (localObject2 == null) {
          return false;
        }
        localObject1 = (ApolloDaoManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all");
        if (paramBoolean)
        {
          QLog.d("[cmshow][SettingMeApolloViewController]", 1, new Object[] { "parseApolloRedTouchJson, item=", localObject2 });
          ((ApolloDaoManagerServiceImpl)localObject1).addPushItem((DrawerPushItem)localObject2);
          return true;
        }
        QLog.d("[cmshow][SettingMeApolloViewController]", 1, new Object[] { "parseApolloRedTouchJson, clearBubble, redId=", str });
        ((ApolloDaoManagerServiceImpl)localObject1).clearBubble(str);
        return true;
      }
      if (!paramBoolean) {
        try
        {
          if ((!(this.mApolloDrawer.b() instanceof PushDrawerStrategy)) || (!((JSONObject)localObject2).has(String.valueOf(PushDrawerStrategy.i)))) {
            break label365;
          }
          ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject1).getRuntimeService(IApolloDaoManagerService.class, "all")).clearBubble(PushDrawerStrategy.i);
          return false;
        }
        catch (Exception localException1) {}
      } else {
        return false;
      }
    }
    catch (Exception localException2)
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parseRedInfo error, path:");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(", content:");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.e("[cmshow][SettingMeApolloViewController]", 1, ((StringBuilder)localObject1).toString(), localException2);
    }
    label365:
    return false;
  }
  
  private void showApolloFirstGuide()
  {
    Object localObject = getApp();
    if (localObject == null) {
      return;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((QQAppInterface)localObject).getAccount());
    localStringBuilder.append("apollo_settingme_first_enter");
    if ((localSharedPreferences.getBoolean(localStringBuilder.toString(), true)) && (!ApolloDrawerInfoManager.c(this.mApolloDrawerStatus)))
    {
      localObject = new FirstDrawerStrategy((QQAppInterface)localObject);
      this.mApolloDrawer.a((ApolloDrawerStrategy)localObject);
    }
  }
  
  private void showApolloNoneUserBubble()
  {
    Object localObject = (QQSettingMe)this.mQQSettingMeRef.get();
    if (localObject == null)
    {
      QLog.e("[cmshow][SettingMeApolloViewController]", 1, "qqSettingMe null");
      return;
    }
    localObject = (QQAppInterface)((QQSettingMe)localObject).h();
    if (localObject == null)
    {
      QLog.e("[cmshow][SettingMeApolloViewController]", 1, "app null");
      return;
    }
    if (((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(((QQAppInterface)localObject).getCurrentAccountUin()).apolloDrawerStatus != 1) {
      return;
    }
    localObject = new DefaultDrawerStrategy((QQAppInterface)localObject);
    this.mApolloDrawer.a((ApolloDrawerStrategy)localObject);
  }
  
  private void showCloseCMShowUI()
  {
    if (this.mCmShowView == null)
    {
      QLog.e("[cmshow][SettingMeApolloViewController]", 1, "[showCloseCMShowUI] return, mCmShowView is null!");
      return;
    }
    Object localObject2 = (ViewGroup)this.mContentViewRef.get();
    if (localObject2 == null)
    {
      QLog.e("[cmshow][SettingMeApolloViewController]", 1, "[showCloseCMShowUI] return, contentView is null!");
      return;
    }
    if (getApp() == null)
    {
      QLog.e("[cmshow][SettingMeApolloViewController]", 1, "[showCloseCMShowUI] return, app is null!");
      return;
    }
    Object localObject1 = this.mCmShowView.getTouchManager().b();
    if (localObject1 != null)
    {
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject1 = (ApolloSkeletonBounding)((Iterator)localObject3).next();
        if (!TextUtils.isEmpty(((ApolloSkeletonBounding)localObject1).name))
        {
          localObject4 = sSpriteNodeNamePattern.matcher(((ApolloSkeletonBounding)localObject1).name);
          if ((localObject4 != null) && (((Matcher)localObject4).matches())) {
            break label150;
          }
        }
      }
    }
    localObject1 = null;
    label150:
    if (localObject1 == null)
    {
      QLog.e("[cmshow][SettingMeApolloViewController]", 1, "[showCloseCMShowUI] return, spriteSkeletonBounding is null!");
      return;
    }
    Object localObject3 = this.mBackgroundMaskView;
    if (localObject3 != null) {
      ((View)localObject3).setVisibility(0);
    }
    localObject3 = ((ViewGroup)localObject2).getContext();
    if (this.mCloseCmShowPopupWindow == null)
    {
      localObject4 = CalloutPopupWindow.a((Context)localObject3).b(-1).a(((Context)localObject3).getResources().getString(2131886700)).a(14.0F).a(-1);
      ((CalloutPopupWindow.Builder)localObject4).c(49);
      int i;
      if (ThemeUtil.isNowThemeIsNight(getApp(), false, null)) {
        i = ((Context)localObject3).getResources().getColor(2131166456);
      } else {
        i = ((Context)localObject3).getResources().getColor(2131166458);
      }
      this.mCloseCmShowPopupWindow = new CalloutPopupWindow.DrawableBuilder((CalloutPopupWindow.Builder)localObject4).b(i).a(8).a().a();
    }
    Object localObject4 = this.mCloseCmShowPopupWindow;
    if (localObject4 == null) {
      return;
    }
    ((CalloutPopupWindow)localObject4).a(new SettingMeApolloViewControllerImpl.6(this));
    if (this.mSpritePlaceHolderView == null)
    {
      this.mSpritePlaceHolderView = new View((Context)localObject3);
      ((ViewGroup)localObject2).addView(this.mSpritePlaceHolderView);
    }
    localObject2 = new RelativeLayout.LayoutParams((int)((ApolloSkeletonBounding)localObject1).width, (int)((ApolloSkeletonBounding)localObject1).height);
    ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131428475);
    ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131428475);
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = ((int)((ApolloSkeletonBounding)localObject1).x);
    if (this.mApolloDrawerStatus == 6)
    {
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ViewUtils.dip2px(52.0F);
      this.mCloseCmShowPopupWindow.b(ViewUtils.dpToPx(50.0F));
    }
    else
    {
      ((RelativeLayout.LayoutParams)localObject2).topMargin = ViewUtils.dip2px(80.0F);
      this.mCloseCmShowPopupWindow.b(ViewUtils.dpToPx(25.0F));
    }
    this.mSpritePlaceHolderView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    this.mSpritePlaceHolderView.setVisibility(0);
    this.mSpritePlaceHolderView.getViewTreeObserver().addOnGlobalLayoutListener(new SettingMeApolloViewControllerImpl.7(this));
  }
  
  private void showFeelingBubble(String paramString, int paramInt1, int paramInt2)
  {
    QLog.d("[cmshow][SettingMeApolloViewController]", 1, "showFeelingBubble");
    SpriteUtil.a(this.mSpriteDrawerInfoManager.a(), this.mSpriteDrawerInfoManager.e(), paramString, 9, paramInt1, paramInt2);
  }
  
  private void showOpenCmShowGuideIfNotShowed(@NonNull Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("apollo_sp", 0);
    if (localSharedPreferences.getBoolean("open_cmshow_guide_dialog_showed", false)) {
      return;
    }
    QQCustomDialog localQQCustomDialog = new QQCustomDialog(paramContext, 2131953338);
    localQQCustomDialog.setContentView(2131624611);
    Resources localResources = paramContext.getResources();
    localQQCustomDialog.setTitle(2131886729);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(localResources.getString(2131886727));
    StatableBitmapDrawable localStatableBitmapDrawable = new StatableBitmapDrawable(localResources, BitmapManager.a(localResources, 2130852058), false, false);
    int i = localSpannableStringBuilder.length();
    localSpannableStringBuilder.append("[S]");
    int j = ViewUtils.dpToPx(20.0F);
    localStatableBitmapDrawable.setBounds(0, 0, j, j);
    localSpannableStringBuilder.setSpan(new ImageSpan(localStatableBitmapDrawable, 0), i, i + 3, 17);
    localSpannableStringBuilder.append(localResources.getString(2131886728));
    paramContext = LayoutInflater.from(paramContext).inflate(2131624188, null);
    ((TextView)paramContext.findViewById(2131431751)).setText(localSpannableStringBuilder);
    localQQCustomDialog.addView(paramContext);
    localQQCustomDialog.setPositiveButton(2131890029, new SettingMeApolloViewControllerImpl.8(this, localQQCustomDialog));
    localQQCustomDialog.show();
    localSharedPreferences.edit().putBoolean("open_cmshow_guide_dialog_showed", true).apply();
  }
  
  private void showPushInfo()
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      return;
    }
    Object localObject = (ApolloDaoManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloDaoManagerService.class, "all");
    if (!ApolloUtilImpl.isApolloUser(localQQAppInterface)) {
      return;
    }
    localObject = ((ApolloDaoManagerServiceImpl)localObject).getCurrentPushItemByUserStatus(0, ApolloDrawerInfoManager.b(this.mApolloDrawerStatus));
    if (localObject != null)
    {
      QLog.d("[cmshow][SettingMeApolloViewController]", 1, new Object[] { "showPushInfo item:", localObject });
      localObject = new PushDrawerStrategy(localQQAppInterface, (DrawerPushItem)localObject);
      this.mApolloDrawer.a((ApolloDrawerStrategy)localObject);
    }
    else
    {
      ((ApolloExtensionHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(1);
    }
    localObject = localQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("apollo_sp");
    localStringBuilder.append(localQQAppInterface.getCurrentUin());
    long l = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getLong("hire_end", 0L);
    if ((NetConnInfoCenter.getServerTime() < l) && (!ApolloDrawerInfoManager.c(this.mApolloDrawerStatus)))
    {
      localObject = new HireDrawerStrategy(localQQAppInterface);
      this.mApolloDrawer.a((ApolloDrawerStrategy)localObject);
    }
    localObject = localQQAppInterface.getApp();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("get_user_apollo_info_drawer_dress_sp");
    localStringBuilder.append(localQQAppInterface.getCurrentUin());
    if (!((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).contains("bubble")) {
      showApolloFirstGuide();
    }
  }
  
  public void destroyApollo()
  {
    QLog.i("[cmshow][SettingMeApolloViewController]", 1, "destroyApollo");
    Object localObject1 = getApp();
    if (localObject1 == null) {
      return;
    }
    Object localObject2 = (ViewGroup)this.mContentViewRef.get();
    if (localObject2 == null) {
      return;
    }
    if ((localObject2 instanceof SettingMeRelativeLayout)) {
      ((SettingMeRelativeLayout)localObject2).setSurfaceView(null, null, 1.0F, 0.0F);
    }
    localObject2 = this.mSpriteDrawerInfoManager;
    if (localObject2 != null)
    {
      ((SpriteDrawerInfoManager)localObject2).h();
      this.mSpriteDrawerInfoManager = null;
    }
    if (localObject1 != null)
    {
      localObject2 = this.mApolloDrawerInfoViewListener;
      if (localObject2 != null)
      {
        ((QQAppInterface)localObject1).removeObserver((BusinessObserver)localObject2);
        this.mApolloDrawerInfoViewListener = null;
      }
    }
    localObject1 = this.mCmShowView;
    if (localObject1 != null)
    {
      BKUtils.a(((ICMShowView)localObject1).getView());
      this.mCmShowView = null;
    }
    localObject1 = this.mCmShowEngine;
    if (localObject1 != null)
    {
      ((ICMShowEngine)localObject1).m();
      this.mCmShowEngine = null;
    }
    this.mIsDestroyApollo = true;
    this.mIsSurfaceReady = false;
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][SettingMeApolloViewController]", 2, "destroyApollo end");
    }
  }
  
  @NotNull
  public BusinessObserver getObserver()
  {
    return this.cmshowObserver;
  }
  
  public View getView()
  {
    ICMShowView localICMShowView = this.mCmShowView;
    if (localICMShowView != null) {
      return localICMShowView.getView();
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 65536)
    {
      if (i != 65537) {
        return false;
      }
      QLog.i("[cmshow][SettingMeApolloViewController]", 1, "MSG_CODE_DESTROY_APOLLO_ON_BACKGROUND");
      destroyApollo();
      return false;
    }
    if ((QQSettingMe)this.mQQSettingMeRef.get() == null) {
      return false;
    }
    if (this.mDrawerClosed)
    {
      QLog.i("[cmshow][SettingMeApolloViewController]", 1, "MSG_CODE_REFRESH_APOLLO on DrawerClosed!");
      TraceReportUtil.a(TraceReportUtil.c(1), 11, 106, new Object[] { "DrawerClosed" });
      return false;
    }
    if ((paramMessage.obj instanceof CheckApolloInfoResult)) {
      checkApolloUI((CheckApolloInfoResult)paramMessage.obj);
    }
    return false;
  }
  
  public void init(Object paramObject, ViewGroup paramViewGroup)
  {
    if ((paramObject instanceof QQSettingMe))
    {
      paramObject = (QQSettingMe)paramObject;
      this.mQQSettingMeRef = new WeakReference(paramObject);
      this.mContentViewRef = new WeakReference(paramViewGroup);
      this.mRefreshApolloTask = new SettingMeApolloViewControllerImpl.RefreshApolloTask(paramObject, this);
      this.mApolloBoxEnterView = ((ApolloBoxEnterView)paramViewGroup.findViewById(2131428435));
      this.mApolloBoxEnterView.setOnClickListener(this);
      this.mApolloStaticEntry = paramViewGroup.findViewById(2131428486);
      this.mApolloStaticEntry.setOnClickListener(this);
      this.mApolloDrawer = new ApolloDrawerContext();
      return;
    }
    paramViewGroup = new StringBuilder();
    paramViewGroup.append("can not init without a QQSettingMe:");
    paramViewGroup.append(paramObject);
    throw new IllegalArgumentException(paramViewGroup.toString());
  }
  
  public void initApolloDrawerStatus()
  {
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface == null) {
      return;
    }
    this.mApolloDrawerStatus = 0;
    this.mApolloDrawerStatus = ((ApolloManagerServiceImpl)localQQAppInterface.getRuntimeService(IApolloManagerService.class, "all")).getDrawerStatus(localQQAppInterface);
    QLog.d("[cmshow][SettingMeApolloViewController]", 1, new Object[] { "initApolloDrawerStatus:", Integer.valueOf(this.mApolloDrawerStatus) });
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if ((i != 2131428435) && (i != 2131428486))
    {
      if (paramView == this.mBackgroundMaskView) {
        hideCloseCMShowUI();
      }
    }
    else
    {
      QQSettingMe localQQSettingMe = (QQSettingMe)this.mQQSettingMeRef.get();
      if (localQQSettingMe == null) {
        return;
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)localQQSettingMe.h();
      if (localQQAppInterface == null) {
        return;
      }
      Intent localIntent = new Intent();
      if (paramView.getId() == 2131428435)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("&tab=interactive&suin=");
        localStringBuilder.append(localQQAppInterface.getCurrentAccountUin());
        localIntent.putExtra("extra_key_url_append", localStringBuilder.toString());
        localIntent.putExtra("extra_key_box_uin", localQQAppInterface.getCurrentAccountUin());
        localIntent.putExtra("extra_key_open_box", this.mApolloBoxEnterView.a());
        if (this.mApolloBoxEnterView.getVisibility() == 0)
        {
          this.mApolloBoxEnterView.setApolloHadStolen();
          localIntent.putExtra("key_box_type", this.mApolloBoxEnterView.getBoxType());
        }
        localIntent.putExtra("extra_key_box_from", "drawer");
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "0X80065C0", 0, 0, new String[] { "0" });
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(paramView.getContext(), localIntent, "drawer", ApolloConstant.I, null);
      }
      else
      {
        ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(paramView.getContext(), localIntent, "drawer", ApolloConstant.H, null);
      }
      if (this.mApolloBoxEnterView.getVisibility() == 0)
      {
        this.mApolloBoxEnterView.setVisibility(8);
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_clk", this.mApolloFeatureFlag, ApolloDrawerInfoManager.a(this.mApolloDrawerStatus), new String[] { "1", "" });
      }
      else
      {
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_clk", this.mApolloFeatureFlag, ApolloDrawerInfoManager.a(this.mApolloDrawerStatus), new String[] { "0", "" });
      }
      ((QQSettingMeApolloProcessor)localQQSettingMe.a().a("d_apollo")).a();
    }
  }
  
  public void onDestroy()
  {
    ICMShowEngine localICMShowEngine = this.mCmShowEngine;
    if (localICMShowEngine != null) {
      localICMShowEngine.m();
    }
    destroyApollo();
    QLog.i("[cmshow][SettingMeApolloViewController]", 1, "onDestroy");
  }
  
  public void onDrawerClosed()
  {
    this.mDrawerClosed = true;
    ThreadManager.removeJobFromThreadPool(this.mRefreshApolloTask, 16);
    this.mIsActionPlay = false;
    hideCloseCMShowUI();
    if (this.mCmShowView != null)
    {
      localObject = ScriptUtils.a(1, null, "Bubble");
      ICMShowEngine localICMShowEngine = this.mCmShowEngine;
      if (localICMShowEngine != null) {
        localICMShowEngine.e().a(new Script((String)localObject));
      }
      if (this.mCmShowView.getView() != null) {
        this.mCmShowView.getView().setVisibility(8);
      }
    }
    if (this.mApolloDrawer != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][SettingMeApolloViewController]", 2, "set apollodrawer status 9999");
      }
      this.mApolloDrawer.a();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onDrawerClosed sDisableDestroySettingmeSwitch:");
    ((StringBuilder)localObject).append(ApolloConfigUtils.i);
    QLog.i("[cmshow][SettingMeApolloViewController]", 1, ((StringBuilder)localObject).toString());
    if (getApp() == null) {
      return;
    }
    if (!ApolloConfigUtils.i)
    {
      this.mUIHandler.removeMessages(65537);
      if (ApolloConfigUtils.j > 0) {
        sDestroyTimeOut = ApolloConfigUtils.j * 1000;
      }
      this.mUIHandler.sendEmptyMessageDelayed(65537, sDestroyTimeOut);
      QLog.d("[cmshow][SettingMeApolloViewController]", 1, new Object[] { "send delay msg MSG_CODE_DESTROY_APOLLO_ON_BACKGROUND sDestroyTimeOut:", Long.valueOf(sDestroyTimeOut) });
    }
  }
  
  public void onDrawerOpened()
  {
    this.mDrawerClosed = false;
    this.mUIHandler.removeCallbacksAndMessages(Integer.valueOf(65537));
    Object localObject = this.mCmShowView;
    if ((localObject != null) && (((ICMShowView)localObject).getView() != null)) {
      this.mCmShowView.getView().setVisibility(0);
    }
    if (this.mIsSurfaceReady)
    {
      localObject = getApp();
      if (localObject == null) {
        return;
      }
      apolloDtSpriteReport((QQAppInterface)localObject, "expose");
    }
  }
  
  public void onPause()
  {
    this.mIsActionPlay = false;
    Object localObject = this.mSpriteDrawerInfoManager;
    if (localObject != null) {
      ((SpriteDrawerInfoManager)localObject).c();
    }
    localObject = this.mApolloBoxEnterView;
    if (localObject != null) {
      ((ApolloBoxEnterView)localObject).setVisibility(8);
    }
    localObject = this.mExploreBox;
    if (localObject != null)
    {
      ((FrameGifView)localObject).setVisibility(8);
      this.mExploreBox.d();
    }
    localObject = this.mCmShowView;
    if (localObject != null) {
      ((ICMShowView)localObject).pause();
    }
    localObject = this.mCmShowEngine;
    if (localObject != null) {
      ((ICMShowEngine)localObject).l();
    }
    localObject = getApp();
    if (localObject == null) {
      return;
    }
    ApolloDrawerContext localApolloDrawerContext = this.mApolloDrawer;
    if (localApolloDrawerContext != null) {
      localApolloDrawerContext.a((QQAppInterface)localObject, this.mSpriteDrawerInfoManager);
    }
    QLog.i("[cmshow][SettingMeApolloViewController]", 1, "onPause");
  }
  
  public void recoverApollo()
  {
    if (!isDrawerCmShowOpen()) {
      return;
    }
    destroyApollo();
    refreshApolloView();
  }
  
  @TargetApi(14)
  public void refreshApolloView()
  {
    Object localObject = (QQSettingMe)this.mQQSettingMeRef.get();
    if (localObject == null) {
      return;
    }
    QLog.d("[cmshow][SettingMeApolloViewController]", 1, new Object[] { "refreshApolloView isResume:", Boolean.valueOf(QQSettingMe.i()) });
    this.mUIHandler.removeMessages(65537);
    localObject = (QQAppInterface)((QQSettingMe)localObject).h();
    localObject = ((ApolloDaoManagerServiceImpl)((QQAppInterface)localObject).getRuntimeService(IApolloDaoManagerService.class, "all")).getApolloBaseInfo(((QQAppInterface)localObject).getCurrentUin());
    if ((localObject != null) && (((ApolloBaseInfo)localObject).apolloDrawerStatus == 0))
    {
      QLog.d("[cmshow][SettingMeApolloViewController]", 2, "refreshApolloView destroyApollo");
      if (!this.mIsDestroyApollo) {
        destroyApollo();
      }
      return;
    }
    if ((!QQSettingMe.i()) || (this.mIsDestroyApollo))
    {
      this.mIsDestroyApollo = false;
      boolean bool = initApolloDrawerStatusView(this.mApolloDrawerStatus);
      if (!bool)
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow][SettingMeApolloViewController]", 2, new Object[] { "refreshApolloView not show apollo,needShowApollo:", Boolean.valueOf(bool) });
        }
        return;
      }
      CmShowStatUtil.a("drawer_pre");
      localObject = this.mSpriteDrawerInfoManager;
      if (localObject != null) {
        ((SpriteDrawerInfoManager)localObject).d();
      }
      localObject = this.mCmShowEngine;
      if (localObject != null) {
        ((ICMShowEngine)localObject).k();
      }
      localObject = this.mCmShowView;
      if (localObject != null) {
        ((ICMShowView)localObject).resume();
      }
      ThreadManagerV2.removeJobFromThreadPool(this.mRefreshApolloTask, 16);
      ThreadManagerV2.excute(this.mRefreshApolloTask, 16, null, true);
    }
  }
  
  public void showExploreBox(String paramString)
  {
    ThreadManager.getUIHandler().post(new SettingMeApolloViewControllerImpl.3(this, paramString));
  }
  
  public void updateCmshowStatus()
  {
    ThreadManager.post(new SettingMeApolloViewControllerImpl.1(this), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.drawer.impl.SettingMeApolloViewControllerImpl
 * JD-Core Version:    0.7.0.1
 */