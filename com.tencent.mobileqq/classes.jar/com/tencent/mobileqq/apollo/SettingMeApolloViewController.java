package com.tencent.mobileqq.apollo;

import aekt;
import akji;
import akjx;
import akkw;
import akmp;
import akmq;
import akot;
import akou;
import akov;
import akow;
import akoy;
import akpa;
import akpb;
import akwt;
import akww;
import akxc;
import alda;
import alee;
import alef;
import algf;
import algm;
import alnq;
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
import axho;
import bdcb;
import bdpx;
import bdqc;
import bhow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.SettingMeRelativeLayout;
import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.apollo.store.ApolloBoxEnterView;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class SettingMeApolloViewController
  implements Handler.Callback, View.OnClickListener
{
  public static long a;
  protected float a;
  public int a;
  public akot a;
  private akww jdField_a_of_type_Akww = new akmq(this);
  private akxc jdField_a_of_type_Akxc;
  private algm jdField_a_of_type_Algm;
  protected View a;
  public bdqc a;
  bhow jdField_a_of_type_Bhow = new bhow(Looper.getMainLooper(), this);
  public ApolloTextureView a;
  private SettingMeApolloViewController.RefreshApolloTask jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController$RefreshApolloTask;
  protected ApolloBoxEnterView a;
  protected FrameGifView a;
  private final WeakReference<QQSettingMe> jdField_a_of_type_JavaLangRefWeakReference;
  protected boolean a;
  protected int[] a;
  int jdField_b_of_type_Int;
  protected FrameGifView b;
  private final WeakReference<ViewGroup> jdField_b_of_type_JavaLangRefWeakReference;
  public boolean b;
  private int jdField_c_of_type_Int = 0;
  private boolean jdField_c_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Long = 180000L;
  }
  
  public SettingMeApolloViewController(QQSettingMe paramQQSettingMe, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Bdqc = new akmp(this);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQSettingMe);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramViewGroup);
    this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController$RefreshApolloTask = new SettingMeApolloViewController.RefreshApolloTask(paramQQSettingMe, this);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView = ((ApolloBoxEnterView)paramViewGroup.findViewById(2131362621));
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setContentDescription(BaseApplicationImpl.getContext().getResources().getString(2131690177));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView = ((FrameGifView)paramViewGroup.findViewById(2131362666));
    this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131362670);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
    this.jdField_a_of_type_Akot = new akot();
  }
  
  @TargetApi(14)
  private void a(akjx paramakjx)
  {
    if (paramakjx == null) {}
    label682:
    label1110:
    for (;;)
    {
      return;
      QQSettingMe localQQSettingMe = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localQQSettingMe != null)
      {
        QQAppInterface localQQAppInterface = localQQSettingMe.a();
        if (localQQAppInterface != null)
        {
          ViewGroup localViewGroup = (ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get();
          if (localViewGroup != null)
          {
            long l1 = System.currentTimeMillis();
            Object localObject = (akji)localQQAppInterface.getManager(153);
            int j = this.jdField_b_of_type_Int;
            int k = akou.a(this.jdField_c_of_type_Int);
            if (((akji)localObject).d) {}
            for (int i = 0;; i = 1)
            {
              VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_show", j, k, new String[] { "", String.valueOf(i) });
              if (QLog.isColorLevel()) {
                QLog.d("SettingMeApolloViewController", 2, new Object[] { "roleId->" + paramakjx.jdField_a_of_type_Int + " apolloStatus->" + this.jdField_b_of_type_Int + " needStatic->" + paramakjx.jdField_a_of_type_Boolean, ",mApolloDrawerStatus->", Integer.valueOf(this.jdField_c_of_type_Int) });
              }
              if (!this.jdField_c_of_type_Boolean) {
                break;
              }
              QLog.i("SettingMeApolloViewController", 1, "checkApolloUI on DrawerClosed!");
              alda.a(paramakjx.e, 11, 106, new Object[] { "DrawerClosed" });
              return;
            }
            this.jdField_a_of_type_AndroidViewView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
            this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.c();
            this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageBitmap(null);
            float f2;
            float f1;
            if ((this.jdField_c_of_type_Int == 1) || (this.jdField_c_of_type_Int == 6)) {
              if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null)
              {
                alda.a(paramakjx.e, 11, 0, new Object[] { "checkUI done" });
                alda.a(paramakjx.e, 100);
                long l2 = bdcb.i();
                i = (int)((float)bdcb.j() * 0.4F);
                j = akou.a(i, l2);
                localObject = BaseApplicationImpl.getContext().getResources();
                l2 = Math.max(bdcb.h(), bdcb.g());
                this.jdField_a_of_type_Float = ((j - aekt.a(66.0F, (Resources)localObject)) / bdcb.a());
                f2 = alnq.a() / 16.0F;
                if (f2 != 0.0F)
                {
                  if (f2 > 1.0F)
                  {
                    f1 = 1.05F;
                    this.jdField_a_of_type_Float = (f1 * this.jdField_a_of_type_Float);
                  }
                }
                else
                {
                  f1 = (float)(l2 >> 2) / 368.0F;
                  if (l2 != bdcb.j()) {
                    QLog.e("SettingMeApolloViewController", 1, "DeviceInfoUtil.getPortraitHeight():" + bdcb.j() + " height:" + l2);
                  }
                  this.jdField_a_of_type_Akxc = new akxc(localQQAppInterface);
                  this.jdField_a_of_type_Akxc.a(f1, this.jdField_a_of_type_Float, 15);
                  this.jdField_a_of_type_Algm = new algm(this.jdField_a_of_type_Akxc, 1);
                  this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = new ApolloTextureView(localViewGroup.getContext(), null);
                  this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.init(this.jdField_a_of_type_Algm);
                  this.jdField_a_of_type_Akxc.a(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
                  ThreadManager.post(new SettingMeApolloViewController.4(this), 10, null, true);
                  this.jdField_a_of_type_Int = paramakjx.jdField_a_of_type_Int;
                  this.jdField_a_of_type_ArrayOfInt = paramakjx.jdField_a_of_type_ArrayOfInt;
                  this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.mIsDrawerView = true;
                  this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.mManHeight = ((float)(l2 >> 2));
                  localQQAppInterface.addObserver(this.jdField_a_of_type_Algm);
                  this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setDispatchEvent2Native(true);
                  this.jdField_a_of_type_Akxc.a(this.jdField_a_of_type_Akww);
                  if (localQQSettingMe.a() == null) {
                    break label984;
                  }
                  f1 = localQQSettingMe.a().a();
                  f1 = localQQSettingMe.a().b();
                  paramakjx = new RelativeLayout.LayoutParams(j, i);
                  paramakjx.addRule(12, -1);
                  paramakjx.addRule(11, -1);
                  localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, paramakjx);
                  if ((localViewGroup instanceof SettingMeRelativeLayout)) {
                    ((SettingMeRelativeLayout)localViewGroup).setSurfaceView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView, this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView, 0.0F, 0.0F);
                  }
                  this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.bringToFront();
                  this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
                  this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                  float f3 = alnq.a() / 16.0F;
                  f2 = f3;
                  if (f3 == 0.0F) {
                    f2 = 1.0F;
                  }
                  f2 = bdcb.a() / f2;
                  paramakjx = new RelativeLayout.LayoutParams((int)(45.0F * f2), (int)(45.0F * f2));
                  paramakjx.addRule(11, -1);
                  paramakjx.addRule(12, -1);
                  paramakjx.rightMargin = ((int)(f1 + 66.0F * f2 + aekt.a(8.0F, (Resources)localObject)));
                  paramakjx.bottomMargin = ((int)(f2 * 5.0F));
                  this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setLayoutParams(paramakjx);
                  if (this.jdField_c_of_type_Int != 1) {
                    break label1016;
                  }
                  this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a(localQQAppInterface, "drawer", localQQAppInterface.getCurrentAccountUin(), -1);
                  if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getVisibility() != 0) {
                    this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(0);
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
                break label1110;
              }
              QLog.d("SettingMeApolloViewController", 2, "refresh ApolloSettingMe->" + (System.currentTimeMillis() - l1));
              return;
              f1 = f2;
              if (f2 >= 1.0F) {
                break;
              }
              f1 = 0.95F;
              break;
              label984:
              f1 = (float)(((Resources)localObject).getDisplayMetrics().density * 100.0F + 0.5D);
              f1 = ((Resources)localObject).getDimensionPixelSize(2131298274);
              break label682;
              label1016:
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
              break label897;
              alda.a(paramakjx.e, 11, 107, new Object[] { "already init" });
              if (this.jdField_c_of_type_Int != 1) {
                break label897;
              }
              this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a(localQQAppInterface, "drawer", localQQAppInterface.getCurrentAccountUin(), -1);
              break label897;
              alda.a(paramakjx.e, 11, 108, new Object[] { "mApolloDrawerStatus:", Integer.valueOf(this.jdField_c_of_type_Int) });
            }
          }
        }
      }
    }
  }
  
  private boolean a(int paramInt)
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
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.setVisibility(8);
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    } while (paramInt == 0);
    return false;
  }
  
  private void b(String paramString)
  {
    QQSettingMe localQQSettingMe = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
      localViewGroup = (ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    } while (localViewGroup == null);
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0) {}
    akov localakov;
    Object localObject;
    for (int j = 1;; j = 0)
    {
      Intent localIntent = new Intent();
      String str2 = localQQAppInterface.getCurrentAccountUin();
      localIntent.putExtra("extra_key_box_uin", str2);
      localIntent.putExtra("extra_key_open_box", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a());
      if (j != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setApolloHadStolen();
        localIntent.putExtra("key_box_type", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a());
      }
      localIntent.putExtra("extra_key_box_from", "drawer");
      localakov = this.jdField_a_of_type_Akot.a();
      akji localakji = (akji)localQQAppInterface.getManager(153);
      String str1 = localakji.k;
      if (QLog.isColorLevel()) {
        QLog.d("SettingMeApolloViewController", 2, new Object[] { "[onNotifyStatusChanged] lastTab=", str1 });
      }
      localObject = str1;
      if (localakov != null)
      {
        localObject = str1;
        if ((localakov instanceof akpb))
        {
          akpb localakpb = (akpb)localakov;
          localObject = str1;
          if (localakpb.jdField_b_of_type_Boolean)
          {
            localObject = str1;
            if (localakpb.a != null)
            {
              String str3 = localakpb.a.scheme;
              localObject = str1;
              if (!TextUtils.isEmpty(str3))
              {
                str1 = str3.trim();
                localakpb.a(localQQAppInterface);
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
      localObject = localakji.a(1, (String)localObject);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(alef.ai))) {
        localIntent.putExtra("extra_key_url_append", "&tab=interactive&suin=" + str2);
      }
      ApolloUtil.a(localViewGroup.getContext(), localIntent, "drawer", (String)localObject, null);
      localObject = (akji)localQQAppInterface.getManager(153);
      if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("pet"))) {
        break label521;
      }
      VipUtils.a(null, "cmshow", "Apollo", "drawerpetclick", 0, 0, new String[] { ((akji)localObject).a(localQQAppInterface.c()) });
      if (j != 0)
      {
        VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "0X80065C0", 0, 0, new String[] { "0" });
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
      }
      localQQSettingMe.H();
      if (!(localakov instanceof akpa)) {
        break;
      }
      ((akpa)localakov).a(localQQAppInterface);
      return;
    }
    label521:
    int k = this.jdField_b_of_type_Int;
    int m = akou.a(this.jdField_c_of_type_Int);
    label544:
    int i;
    if (j != 0)
    {
      paramString = "0";
      if ((localakov == null) || (!localakov.jdField_b_of_type_Boolean)) {
        break label600;
      }
      i = 2;
    }
    for (;;)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_clk", k, m, new String[] { paramString, String.valueOf(i) });
      break;
      paramString = "1";
      break label544;
      label600:
      if (((akji)localObject).d) {
        i = 0;
      } else {
        i = 1;
      }
    }
  }
  
  private void m()
  {
    Object localObject = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).a();
    } while ((localObject == null) || (!BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0).getBoolean(((QQAppInterface)localObject).getAccount() + "apollo_settingme_first_enter", true)) || (akou.a(this.jdField_c_of_type_Int)));
    localObject = new akoy((QQAppInterface)localObject);
    this.jdField_a_of_type_Akot.a((akov)localObject);
  }
  
  public void a()
  {
    ThreadManager.post(new SettingMeApolloViewController.1(this), 5, null, true);
  }
  
  public void a(String paramString)
  {
    ThreadManager.getUIHandler().post(new SettingMeApolloViewController.3(this, paramString));
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    JSONObject localJSONObject;
    try
    {
      localObject1 = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
          break label529;
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
            paramString1 = (akji)((QQAppInterface)localObject1).getManager(153);
            if (!paramBoolean) {
              break label521;
            }
            paramString1.c((DrawerPushItem)localObject2);
            break label581;
            if (paramInt != 1) {
              break;
            }
            ((DrawerPushItem)localObject2).ext_url = alef.T;
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
      label521:
      paramString1.b(paramString2);
      break label581;
      label529:
      if ((!paramBoolean) && ((this.jdField_a_of_type_Akot.a() instanceof akpb)) && (((JSONObject)localObject2).has(String.valueOf(akpb.d)))) {
        ((akji)((QQAppInterface)localObject1).getManager(153)).b(akpb.d);
      }
    }
    label581:
    return true;
  }
  
  public void b()
  {
    Object localObject = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).a();
    } while ((localObject == null) || (this.jdField_a_of_type_Akot == null));
    localObject = new akow((QQAppInterface)localObject);
    this.jdField_a_of_type_Akot.a((akov)localObject);
  }
  
  public void c()
  {
    Object localObject1 = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
        localObject2 = (axho)((QQAppInterface)localObject1).getManager(36);
      } while (!ApolloGameUtil.a((QQAppInterface)localObject1));
      localObject1 = new ArrayList();
      i = 0;
      while (i < alef.b.length)
      {
        localObject3 = ((axho)localObject2).a(alef.b[i]);
        if ((localObject3 != null) && (!TextUtils.isEmpty(((BusinessInfoCheckUpdate.AppInfo)localObject3).buffer.get()))) {
          ((List)localObject1).add(localObject3);
        }
        i += 1;
      }
    } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
    int i = 0;
    label135:
    if (i < ((List)localObject1).size())
    {
      if (QLog.isColorLevel()) {
        QLog.d("SettingMeApolloViewController", 2, "buffer = " + ((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).buffer.get());
      }
      localObject2 = ((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).path.get();
      localObject3 = ((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).buffer.get();
      if (((BusinessInfoCheckUpdate.AppInfo)((List)localObject1).get(i)).iNewFlag.get() != 1) {
        break label268;
      }
    }
    label268:
    for (boolean bool = true;; bool = false)
    {
      a(0, (String)localObject2, (String)localObject3, bool);
      i += 1;
      break label135;
      break;
    }
  }
  
  public void d()
  {
    Object localObject1 = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null) {}
    do
    {
      do
      {
        return;
        localObject1 = ((QQSettingMe)localObject1).a();
      } while (localObject1 == null);
      localObject2 = (akji)((QQAppInterface)localObject1).getManager(153);
    } while (!ApolloGameUtil.a((QQAppInterface)localObject1));
    Object localObject2 = ((akji)localObject2).a(0, akou.b(this.jdField_c_of_type_Int));
    if (localObject2 != null)
    {
      localObject2 = new akpb((QQAppInterface)localObject1, (DrawerPushItem)localObject2);
      this.jdField_a_of_type_Akot.a((akov)localObject2);
    }
    for (;;)
    {
      long l = ((QQAppInterface)localObject1).getApp().getSharedPreferences("apollo_sp" + ((QQAppInterface)localObject1).c(), 0).getLong("hire_end", 0L);
      if ((NetConnInfoCenter.getServerTime() < l) && (!akou.a(this.jdField_c_of_type_Int)))
      {
        localObject1 = new akpa((QQAppInterface)localObject1);
        this.jdField_a_of_type_Akot.a((akov)localObject1);
      }
      m();
      return;
      ((bdpx)((QQAppInterface)localObject1).a(71)).b(1);
    }
  }
  
  @TargetApi(14)
  public void e()
  {
    QQSettingMe localQQSettingMe = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localQQSettingMe == null) {}
    boolean bool;
    do
    {
      do
      {
        return;
        QLog.d("SettingMeApolloViewController", 1, new Object[] { "refreshApolloView isResume:", Boolean.valueOf(localQQSettingMe.a()) });
        this.jdField_a_of_type_Bhow.removeMessages(65537);
      } while ((localQQSettingMe.a()) && (!this.jdField_b_of_type_Boolean));
      this.jdField_b_of_type_Boolean = false;
      bool = a(this.jdField_c_of_type_Int);
      if (bool) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SettingMeApolloViewController", 2, new Object[] { "refreshApolloView not show apollo,needShowApollo:", Boolean.valueOf(bool) });
    return;
    algf.a("drawer_pre");
    if (this.jdField_a_of_type_Akxc != null) {
      this.jdField_a_of_type_Akxc.c();
    }
    ThreadManagerV2.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController$RefreshApolloTask, 16);
    ThreadManagerV2.excute(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController$RefreshApolloTask, 16, null, true);
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
    }
    if (this.jdField_a_of_type_Akxc != null) {
      this.jdField_a_of_type_Akxc.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView != null)
    {
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqApolloViewFrameGifView.c();
    }
    Object localObject = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).a();
    } while (localObject == null);
    if (this.jdField_a_of_type_Akot != null) {
      this.jdField_a_of_type_Akot.a((QQAppInterface)localObject, this.jdField_a_of_type_Akxc);
    }
    QLog.i("SettingMeApolloViewController", 1, "onPause");
  }
  
  public void g()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.c();
      this.jdField_a_of_type_ComTencentMobileqqApolloViewFrameGifView.setImageBitmap(null);
    }
    i();
    QLog.i("SettingMeApolloViewController", 1, "onDestroy");
  }
  
  public void h()
  {
    Object localObject = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).a();
    } while (localObject == null);
    this.jdField_c_of_type_Int = 0;
    this.jdField_c_of_type_Int = ((akji)((QQAppInterface)localObject).getManager(153)).b();
    QLog.d("SettingMeApolloViewController", 1, new Object[] { "initApolloDrawerStatus:", Integer.valueOf(this.jdField_c_of_type_Int) });
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
        } while ((QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get() == null);
        if (this.jdField_c_of_type_Boolean)
        {
          QLog.i("SettingMeApolloViewController", 1, "MSG_CODE_REFRESH_APOLLO on DrawerClosed!");
          alda.a(akwt.b(1), 11, 106, new Object[] { "DrawerClosed" });
          return false;
        }
      } while (!(paramMessage.obj instanceof akjx));
      a((akjx)paramMessage.obj);
      return false;
    }
    QLog.i("SettingMeApolloViewController", 1, "MSG_CODE_DESTROY_APOLLO_ON_BACKGROUND");
    i();
    return false;
  }
  
  public void i()
  {
    QLog.i("SettingMeApolloViewController", 1, "destroyApollo");
    Object localObject = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
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
        localViewGroup = (ViewGroup)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      } while (localViewGroup == null);
      if ((localViewGroup instanceof SettingMeRelativeLayout)) {
        ((SettingMeRelativeLayout)localViewGroup).setSurfaceView(null, null, 1.0F, 0.0F);
      }
      if (this.jdField_a_of_type_Akxc != null)
      {
        this.jdField_a_of_type_Akxc.d();
        this.jdField_a_of_type_Akxc = null;
      }
      if ((localObject != null) && (this.jdField_a_of_type_Algm != null))
      {
        ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_Algm);
        this.jdField_a_of_type_Algm = null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null)
      {
        localViewGroup.removeView(this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView);
        this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView = null;
      }
      this.jdField_b_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("SettingMeApolloViewController", 2, "destroyApollo end");
  }
  
  public void j()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Bhow.removeCallbacksAndMessages(Integer.valueOf(65537));
  }
  
  public void k()
  {
    this.jdField_c_of_type_Boolean = true;
    ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_ComTencentMobileqqApolloSettingMeApolloViewController$RefreshApolloTask, 16);
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getRenderImpl().a(1, null, "Bubble");
    }
    if (this.jdField_a_of_type_Akot != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SettingMeApolloViewController", 2, "set apollodrawer status 9999");
      }
      this.jdField_a_of_type_Akot.a();
    }
    QLog.i("SettingMeApolloViewController", 1, "onDrawerClosed sDisableDestroySettingmeSwitch:" + alee.jdField_c_of_type_Boolean);
    Object localObject = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null) {}
    do
    {
      return;
      localObject = ((QQSettingMe)localObject).a();
    } while ((localObject == null) || (akji.a((QQAppInterface)localObject, ((QQAppInterface)localObject).getCurrentAccountUin()) != 2) || (alee.jdField_c_of_type_Boolean));
    this.jdField_a_of_type_Bhow.removeMessages(65537);
    if (alee.jdField_b_of_type_Int > 0) {
      jdField_a_of_type_Long = alee.jdField_b_of_type_Int * 1000;
    }
    this.jdField_a_of_type_Bhow.sendEmptyMessageDelayed(65537, jdField_a_of_type_Long);
    QLog.d("SettingMeApolloViewController", 1, new Object[] { "send delay msg MSG_CODE_DESTROY_APOLLO_ON_BACKGROUND sDestroyTimeOut:", Long.valueOf(jdField_a_of_type_Long) });
  }
  
  public void l()
  {
    if ((this.jdField_c_of_type_Int != 1) && (this.jdField_c_of_type_Int != 6)) {
      return;
    }
    i();
    e();
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
        return;
        localQQSettingMe = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while (localQQSettingMe == null);
      localQQAppInterface = localQQSettingMe.a();
    } while (localQQAppInterface == null);
    Intent localIntent = new Intent();
    if (paramView.getId() == 2131362621)
    {
      localIntent.putExtra("extra_key_url_append", "&tab=interactive&suin=" + localQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("extra_key_box_uin", localQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("extra_key_open_box", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a());
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() == 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setApolloHadStolen();
        localIntent.putExtra("key_box_type", this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.a());
      }
      localIntent.putExtra("extra_key_box_from", "drawer");
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "0X80065C0", 0, 0, new String[] { "0" });
      ApolloUtil.a(paramView.getContext(), localIntent, "drawer", alef.ai, null);
      if (this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.getVisibility() != 0) {
        break label308;
      }
      this.jdField_a_of_type_ComTencentMobileqqApolloStoreApolloBoxEnterView.setVisibility(8);
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_clk", this.jdField_b_of_type_Int, akou.a(this.jdField_c_of_type_Int), new String[] { "1", "" });
    }
    for (;;)
    {
      localQQSettingMe.H();
      return;
      ApolloUtil.a(paramView.getContext(), localIntent, "drawer", alef.ah, null);
      break;
      label308:
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "drawer_clk", this.jdField_b_of_type_Int, akou.a(this.jdField_c_of_type_Int), new String[] { "0", "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.SettingMeApolloViewController
 * JD-Core Version:    0.7.0.1
 */