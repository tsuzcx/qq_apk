package com.tencent.biz.troop.feeds;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.DisplayMetrics;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopGameGuideHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.text.style.LinkSpan;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotify;
import com.tencent.mobileqq.troop.data.TroopFeedsDataManager.TroopNotifyAd;
import com.tencent.mobileqq.troop.jsp.TroopNoticeJsHandler;
import com.tencent.mobileqq.troop.logic.TroopFeedsCenterLogic;
import com.tencent.mobileqq.troop.utils.AIOAnimationControlManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationFlagMsg;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.mobileqq.util.AccessibilityUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.TroopReportor;
import com.tencent.mobileqq.widget.BounceScrollView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import mqq.app.AppRuntime;
import org.json.JSONObject;

@TargetApi(9)
public class TroopNewGuidePopWindow
  extends QQCustomDialog
  implements View.OnClickListener, Observer
{
  int jdField_a_of_type_Int = 0;
  protected Handler a;
  View jdField_a_of_type_AndroidViewView;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  protected URLImageView a;
  TroopChatPie jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected TroopFeedsDataManager.TroopNotify a;
  protected TroopFeedsDataManager.TroopNotifyAd a;
  protected TroopFeedsDataManager a;
  TroopFeedsCenterLogic jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic;
  BounceScrollView jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = null;
  protected String a;
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  View jdField_b_of_type_AndroidViewView;
  Button jdField_b_of_type_AndroidWidgetButton;
  ImageView jdField_b_of_type_AndroidWidgetImageView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  String jdField_b_of_type_JavaLangString;
  protected boolean b;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  protected boolean d;
  protected View e;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  boolean jdField_e_of_type_Boolean = false;
  boolean f;
  boolean g = false;
  boolean h = false;
  boolean i = false;
  
  public TroopNewGuidePopWindow(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TroopFeedsCenterLogic paramTroopFeedsCenterLogic, String paramString)
  {
    super(paramBaseActivity, 2131756189);
    this.jdField_e_of_type_AndroidViewView = null;
    this.jdField_a_of_type_ComTencentImageURLImageView = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify = null;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotifyAd = null;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new TroopNewGuidePopWindow.10(this);
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    if ((!(paramBaseActivity instanceof SplashActivity)) && (!(paramBaseActivity instanceof ChatActivity)))
    {
      dismiss();
      return;
    }
    paramBaseActivity = paramBaseActivity.getChatFragment();
    if ((paramBaseActivity != null) && ((paramBaseActivity.a() instanceof TroopChatPie))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie = ((TroopChatPie)paramBaseActivity.a());
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopLogicTroopFeedsCenterLogic = paramTroopFeedsCenterLogic;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    paramBaseActivity = (TroopInfoManager)paramQQAppInterface.getManager(QQManagerFactory.TROOPINFO_MANAGER);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager = paramBaseActivity.a(Long.valueOf(Long.parseLong(paramString)), true);
      this.jdField_b_of_type_JavaLangString = paramString;
      if (a()) {
        this.jdField_e_of_type_Boolean = true;
      }
      setOnDismissListener(new TroopNewGuidePopWindow.1(this));
      this.f = ((TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).n(paramString);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopTipsPopWindow", 2, paramQQAppInterface.toString());
      }
    }
  }
  
  public static String a(long paramLong)
  {
    Date localDate = new Date(paramLong * 1000L);
    Object localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTime(localDate);
    try
    {
      paramLong = NetConnInfoCenter.getServerTime();
    }
    catch (Exception localException)
    {
      label29:
      Object localObject2;
      Object localObject3;
      break label29;
    }
    paramLong = System.currentTimeMillis() / 1000L;
    localObject2 = new Date(paramLong * 1000L);
    localObject3 = Calendar.getInstance();
    ((Calendar)localObject3).setTime((Date)localObject2);
    localObject2 = new SimpleDateFormat("HH:mm");
    if (((Calendar)localObject1).get(1) == ((Calendar)localObject3).get(1))
    {
      localObject1 = new SimpleDateFormat("M月d日");
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(((SimpleDateFormat)localObject1).format(localDate));
      ((StringBuilder)localObject3).append(" ");
      ((StringBuilder)localObject3).append(((SimpleDateFormat)localObject2).format(localDate));
      return ((StringBuilder)localObject3).toString();
    }
    return new SimpleDateFormat("yyyy年M月d日").format(localDate);
  }
  
  public static String a(long paramLong, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Date localDate = new Date(paramLong * 1000L);
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTime(localDate);
    try
    {
      l = NetConnInfoCenter.getServerTime();
    }
    catch (Exception localException1)
    {
      long l;
      label34:
      Object localObject2;
      Calendar localCalendar2;
      Object localObject1;
      Object localObject3;
      StringBuilder localStringBuilder;
      double d1;
      break label34;
    }
    l = System.currentTimeMillis() / 1000L;
    localObject2 = new Date(1000L * l);
    localCalendar2 = Calendar.getInstance();
    localCalendar2.setTime((Date)localObject2);
    localObject1 = new SimpleDateFormat("yyyy-MM-dd");
    localObject2 = ((SimpleDateFormat)localObject1).format((Date)localObject2);
    try
    {
      localObject1 = ((SimpleDateFormat)localObject1).parse((String)localObject2);
      try
      {
        localObject2 = new Date(((Date)localObject1).getTime() - 86400000L);
      }
      catch (Exception localException2) {}
      if (!QLog.isColorLevel()) {
        break label175;
      }
    }
    catch (Exception localException3)
    {
      localObject1 = null;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("get today failed! msg = ");
    ((StringBuilder)localObject3).append(localException3.getMessage());
    QLog.d("TroopTipsPopWindow", 2, ((StringBuilder)localObject3).toString());
    label175:
    localStringBuilder = null;
    if ((localObject1 != null) && (localStringBuilder != null))
    {
      localObject3 = new SimpleDateFormat("HH:mm");
      l -= paramLong;
      paramLong = l;
      if (l < 0L) {
        paramLong = 0L;
      }
      if (paramLong < 60L) {
        return HardCodeUtil.a(2131715461);
      }
      if (paramLong < 3600L)
      {
        l = ((float)paramLong / (float)60L + 0.5F);
        paramLong = l;
        if (l == 0L) {
          paramLong = 1L;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131715456));
        return ((StringBuilder)localObject1).toString();
      }
      if (paramLong < 86400L)
      {
        if (localDate.getDate() != ((Date)localObject1).getDate())
        {
          if (paramBoolean1)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(HardCodeUtil.a(2131715457));
            ((StringBuilder)localObject1).append(" ");
            ((StringBuilder)localObject1).append(((SimpleDateFormat)localObject3).format(localDate));
            return ((StringBuilder)localObject1).toString();
          }
          return HardCodeUtil.a(2131715459);
        }
        if (paramBoolean3)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131715460));
          ((StringBuilder)localObject1).append(((SimpleDateFormat)localObject3).format(localDate));
          return ((StringBuilder)localObject1).toString();
        }
        d1 = (float)paramLong / (float)3600L;
        Double.isNaN(d1);
        paramLong = (d1 + 0.5D);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramLong);
        ((StringBuilder)localObject1).append(HardCodeUtil.a(2131715458));
        return ((StringBuilder)localObject1).toString();
      }
      if ((paramBoolean2) && (paramLong < 259200L) && (localStringBuilder.getTime() - localDate.getTime() <= 86400000L))
      {
        if (paramBoolean1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131715452));
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(((SimpleDateFormat)localObject3).format(localDate));
          return ((StringBuilder)localObject1).toString();
        }
        return HardCodeUtil.a(2131715455);
      }
      if ((paramLong < 172800L) && (((Date)localObject1).getTime() - localDate.getTime() <= 86400000L))
      {
        if (paramBoolean1)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(HardCodeUtil.a(2131715453));
          ((StringBuilder)localObject1).append(" ");
          ((StringBuilder)localObject1).append(((SimpleDateFormat)localObject3).format(localDate));
          return ((StringBuilder)localObject1).toString();
        }
        return HardCodeUtil.a(2131715463);
      }
      if (localCalendar1.get(1) == localCalendar2.get(1))
      {
        localObject1 = new SimpleDateFormat("MM-dd");
        if (paramBoolean1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((SimpleDateFormat)localObject1).format(localDate));
          localStringBuilder.append(" ");
          localStringBuilder.append(((SimpleDateFormat)localObject3).format(localDate));
          return localStringBuilder.toString();
        }
        return ((SimpleDateFormat)localObject1).format(localDate);
      }
      return new SimpleDateFormat("yyyy-MM-dd").format(localDate);
    }
    return "unknown";
  }
  
  public static String a(String paramString)
  {
    return BaseApplicationImpl.getContext().getSharedPreferences("qbiz_host_ip_map", 0).getString(paramString, "");
  }
  
  private boolean a(JSONObject paramJSONObject, int paramInt)
  {
    if (!this.jdField_e_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.deleteObserver(this);
      return false;
    }
    if (QLog.isColorLevel()) {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify == null)
      {
        QLog.d("TroopTipsPopWindow", 2, "initNorNoticeView mTroopNotify  is null.");
      }
      else
      {
        paramJSONObject = new StringBuilder();
        paramJSONObject.append("initNorNoticeView mTroopNotify");
        paramJSONObject.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.toString());
        QLog.d("TroopTipsPopWindow", 2, paramJSONObject.toString());
      }
    }
    paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify;
    if (paramJSONObject == null)
    {
      dismiss();
      return false;
    }
    paramJSONObject.jdField_a_of_type_Int = paramInt;
    if (!TextUtils.isEmpty(paramJSONObject.f)) {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    }
    this.jdField_b_of_type_AndroidWidgetTextView.setText(new QQText(Html.fromHtml(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_c_of_type_JavaLangString), 8));
    paramJSONObject = this.jdField_e_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_b_of_type_Int);
    localStringBuilder.append(HardCodeUtil.a(2131715454));
    paramJSONObject.setText(localStringBuilder.toString());
    this.jdField_d_of_type_AndroidWidgetTextView.setText(a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_Long));
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(this);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_bulletin", "", "grp_card", "exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_c_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131697647);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131697636);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697636));
    }
    this.jdField_d_of_type_AndroidWidgetTextView.getViewTreeObserver().addOnGlobalLayoutListener(new TroopNewGuidePopWindow.3(this));
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.d)) {
      c(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.d);
    }
    if (AppSetting.jdField_d_of_type_Boolean) {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697645, new Object[] { Html.fromHtml(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_b_of_type_JavaLangString).toString(), this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.h, a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_Long, true, true, false), Html.fromHtml(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_c_of_type_JavaLangString).toString() });
    }
    paramJSONObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
    if ((paramJSONObject != null) && (paramJSONObject.jdField_a_of_type_Int == 1))
    {
      b();
      return true;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1001);
    return true;
  }
  
  public static void b(String paramString)
  {
    ThreadManager.post(new TroopNewGuidePopWindow.11(paramString), 5, null, false);
  }
  
  private void c(String paramString)
  {
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
    int k = (int)(localDisplayMetrics.widthPixels - DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 60.0F));
    int m = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F);
    if (!TextUtils.isEmpty(paramString))
    {
      this.jdField_c_of_type_Boolean = true;
      Object localObject1 = this.jdField_a_of_type_AndroidWidgetImageView;
      int j = 0;
      ((ImageView)localObject1).setVisibility(0);
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      Object localObject2;
      try
      {
        URL localURL = new URL(paramString);
        String str = a(localURL.getHost());
        localObject1 = paramString;
        if (!TextUtils.isEmpty(str)) {
          localObject1 = new URL("http", str, localURL.getFile()).toString();
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        localObject2 = paramString;
      }
      paramString = URLDrawable.getDrawable((String)localObject2, k, m);
      if (paramString.getStatus() == 1)
      {
        float f1 = paramString.getIntrinsicHeight();
        float f2 = paramString.getIntrinsicWidth();
        localObject2 = this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
        if (f2 != 0.0F) {
          if (f1 > DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F)) {
            j = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 150.0F);
          } else {
            j = (int)(k * (f1 / f2));
          }
        }
        if (j > 0)
        {
          ((ViewGroup.LayoutParams)localObject2).height = j;
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
        }
      }
      else
      {
        paramString.setURLDrawableListener(new TroopNewGuidePopWindow.5(this, localDisplayMetrics));
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramString);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697640));
    }
  }
  
  void a()
  {
    Object localObject1;
    if (!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.t()) {
        return;
      }
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics();
      Object localObject2 = this.jdField_a_of_type_AndroidViewView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = ((int)(((DisplayMetrics)localObject1).widthPixels - DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 30.0F)));
      this.jdField_a_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = getWindow().getAttributes();
      ((WindowManager.LayoutParams)localObject2).gravity = 17;
      int j = (int)DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 10.0F);
      ((WindowManager.LayoutParams)localObject2).width = ((int)(((DisplayMetrics)localObject1).widthPixels - DisplayUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 30.0F)));
      this.jdField_a_of_type_AndroidViewView.getViewTreeObserver().addOnGlobalLayoutListener(new TroopNewGuidePopWindow.6(this, j));
      localObject1 = (TroopGameGuideHelper)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.a(92);
      if (localObject1 != null) {
        ((TroopGameGuideHelper)localObject1).a();
      }
      if ((!this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) && (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie.t())) {
        super.show();
      }
      a("exp_bulletin");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_Int == 2) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_bulletin", "", "AIOchat", "notice_exp", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.f)) {
        a("exp_vid");
      } else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.d)) {
        a("exp_pic");
      }
    }
    try
    {
      localObject1 = (QQText)this.jdField_b_of_type_AndroidWidgetTextView.getText();
      localObject1 = (LinkSpan[])((QQText)localObject1).getSpans(0, ((QQText)localObject1).length(), LinkSpan.class);
      if ((localObject1 == null) || (localObject1.length == 0)) {
        break label333;
      }
      a("exp_link");
      return;
    }
    catch (Exception localException)
    {
      label318:
      label333:
      break label318;
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopTipsPopWindow", 2, "report exp pattern link");
    }
  }
  
  public void a(int paramInt)
  {
    if (!this.jdField_e_of_type_Boolean) {
      return;
    }
    Object localObject;
    if (this.f)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      String str = this.jdField_b_of_type_JavaLangString;
      TroopReportor.a((AppRuntime)localObject, str, "Grp_notice", "AioNotice_Show", 0, 0, new String[] { str, "", "", "" });
    }
    if (paramInt != 1)
    {
      if (paramInt != 2) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsPopWindow", 2, "show. GET_NEW_GUIDE_NOTICE_REQUEST_CODE");
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.addObserver(this);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.b(1003);
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager != null)
    {
      localObject = TroopNotificationHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
      if (localObject != null)
      {
        if (((TroopNotificationFlagMsg)localObject).jdField_a_of_type_Int == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsPopWindow", 2, "show. TYPE_TROOP_NOTICE, type = 1");
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.addObserver(this);
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.a(1007, ((TroopNotificationFlagMsg)localObject).jdField_a_of_type_JavaLangString);
          return;
        }
        if (((TroopNotificationFlagMsg)localObject).jdField_a_of_type_Int == 2)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsPopWindow", 2, "show. TYPE_TROOP_NOTICE, type = 2");
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.addObserver(this);
          this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.b(1003);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopTipsPopWindow", 2, "show. GET_NOR_NOTICE, type = 0");
        }
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.addObserver(this);
        this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.b(1004);
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = (this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getResources().getDisplayMetrics().heightPixels - this.jdField_a_of_type_Int * 2);
  }
  
  public void a(TroopFeedsDataManager.TroopNotifyAd paramTroopNotifyAd)
  {
    if ((paramTroopNotifyAd != null) && (!TextUtils.isEmpty(paramTroopNotifyAd.jdField_c_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramTroopNotifyAd.jdField_b_of_type_JavaLangString)))
    {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
      Object localObject = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = null;
      ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = null;
      localObject = URLDrawable.getDrawable(paramTroopNotifyAd.jdField_c_of_type_JavaLangString, (URLDrawable.URLDrawableOptions)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
      this.jdField_a_of_type_ComTencentImageURLImageView.setURLDrawableDownListener(new TroopNewGuidePopWindow.7(this));
      this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(new TroopNewGuidePopWindow.8(this, paramTroopNotifyAd));
      return;
    }
    a(false, "json data null------");
  }
  
  void a(String paramString)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    String str = this.jdField_b_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_a_of_type_Int);
    ReportController.b(localQQAppInterface, "P_CliOper", "Grp_bulletin", "", "bulletin_popUp", paramString, 0, 0, str, localStringBuilder.toString(), "", "");
  }
  
  public void a(JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    ThreadManager.post(new TroopNewGuidePopWindow.4(this, paramJSONObject, paramBoolean, paramInt), 8, null, true);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    } else {
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("changAdLayoutVisible show = ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", from = ");
    localStringBuilder.append(paramString);
    QLog.i("zivonchen", 2, localStringBuilder.toString());
  }
  
  public boolean a()
  {
    long l = (DeviceInfoUtil.a() * 3L + DeviceInfoUtil.e() * 7L) / 10L;
    if (l < 3136512L)
    {
      hide();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("availMemSize is ");
      localStringBuilder.append(l);
      localStringBuilder.append(" , smaller than 3M , TroopNewGuidePopWindow can't show ");
      QLog.i("TroopTipsPopWindow", 1, localStringBuilder.toString());
      return false;
    }
    try
    {
      this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).inflate(2131560708, null);
      this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365187);
      this.jdField_d_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131378837);
      this.jdField_d_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView = ((BounceScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376998));
      if (Build.VERSION.SDK_INT > 8) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetBounceScrollView.setOnScrollChangedListener(new TroopNewGuidePopWindow.2(this));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371983));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131364711));
      this.jdField_b_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131371430));
      this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378736));
      this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378734));
      this.jdField_b_of_type_AndroidWidgetTextView.setEditableFactory(QQTextBuilder.EMOCTATION_FACORY);
      this.jdField_b_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131368832));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368838));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368847));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368836));
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this);
      this.jdField_a_of_type_AndroidWidgetButton.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131697644));
      this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131380692));
      this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
      this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131368666);
      this.jdField_e_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131379324);
      this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)this.jdField_e_of_type_AndroidViewView.findViewById(2131379323));
      setContentView(this.jdField_a_of_type_AndroidViewView);
      setCancelable(true);
      return true;
    }
    catch (InflateException localInflateException)
    {
      label475:
      break label475;
    }
    hide();
    QLog.e("TroopTipsPopWindow", 2, "InflateException, OutOfMemoryError, hide TroopNewGuidePopWindow");
    return false;
  }
  
  public void b()
  {
    TroopFeedsDataManager.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0, new TroopNewGuidePopWindow.9(this));
  }
  
  public void dismiss()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
    if (localObject != null) {
      ((TroopFeedsDataManager)localObject).deleteObserver(this);
    }
    localObject = (AIOAnimationControlManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AIO_ANIMATION_MANAGER);
    boolean bool = false;
    if (localObject != null) {
      bool = ((AIOAnimationControlManager)localObject).a(this.jdField_b_of_type_JavaLangString);
    }
    if (bool)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
      if ((localObject != null) && (!((TroopChatPie)localObject).t()))
      {
        AIOAnimationControlManager.jdField_a_of_type_Boolean = true;
        AIOAnimationControlManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie, true);
      }
    }
    super.dismiss();
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((AppSetting.jdField_d_of_type_Boolean) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!this.i))
    {
      AccessibilityUtils.a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_JavaLangString);
      this.i = true;
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    int k = paramView.getId();
    int j = 2;
    Object localObject1 = "";
    Object localObject4;
    Object localObject3;
    Object localObject5;
    String str;
    Object localObject2;
    switch (k)
    {
    default: 
      break;
    case 2131380692: 
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.f))
      {
        localObject1 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
        ((Intent)localObject1).putExtra("url", this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.f);
        ((Intent)localObject1).putExtra("webStyle", "noBottomBar");
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject1);
        a("clk_vid");
      }
      else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.e))
      {
        localObject4 = new ArrayList();
        localObject3 = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.e;
        try
        {
          localObject5 = new URL((String)localObject3);
          str = a(((URL)localObject5).getHost());
          localObject1 = localObject3;
          if (!TextUtils.isEmpty(str)) {
            localObject1 = new URL("http", str, ((URL)localObject5).getFile()).toString();
          }
        }
        catch (MalformedURLException localMalformedURLException)
        {
          localMalformedURLException.printStackTrace();
          localObject2 = localObject3;
        }
        ((ArrayList)localObject4).add(localObject2);
        TroopNoticeJsHandler.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 0, (ArrayList)localObject4, true, "", -1);
        a("clk_pic");
      }
      break;
    case 2131371430: 
      localObject5 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      localObject4 = ((TroopManager)localObject5).b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      if ((localObject4 != null) && (((TroopMemberInfo)localObject4).troopColorNick != null)) {
        localObject3 = ((TroopMemberInfo)localObject4).troopColorNick;
      } else {
        localObject3 = "";
      }
      localObject5 = ((TroopManager)localObject5).b(this.jdField_b_of_type_JavaLangString);
      if (localObject5 != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(((TroopInfo)localObject5).dwGroupClassExt);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      localObject5 = new Intent();
      ((Intent)localObject5).putExtra("edit_type", 5);
      ((Intent)localObject5).putExtra("edit_mode", 0);
      ((Intent)localObject5).putExtra("title", getContext().getResources().getString(2131697577));
      ((Intent)localObject5).putExtra("default_text", (String)localObject3);
      if (localObject4 != null) {
        ((Intent)localObject5).putExtra("default_nick_id", ((TroopMemberInfo)localObject4).troopColorNickId);
      }
      ((Intent)localObject5).putExtra("troopUin", this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject5).putExtra("uin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      ((Intent)localObject5).putExtra("max_num", 60);
      ((Intent)localObject5).putExtra("from", 0);
      RouteUtils.a(getContext(), (Intent)localObject5, "/base/activity/editInfoActivity");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_bulletin", "", "grp_card", "clk", 0, 0, this.jdField_b_of_type_JavaLangString, "", "", "");
      localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject4 = this.jdField_b_of_type_JavaLangString;
      if (!this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_c_of_type_Boolean) {
        j = 1;
      }
      ReportController.b((AppRuntime)localObject3, "dc00898", "", "", "0X800AACA", "0X800AACA", 0, 0, (String)localObject4, (String)localObject2, String.valueOf(j), "");
      dismiss();
      break;
    case 2131364711: 
    case 2131378734: 
    case 2131378736: 
    case 2131378837: 
      localObject4 = new Intent(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, QQBrowserActivity.class);
      localObject5 = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).b(this.jdField_b_of_type_JavaLangString);
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject3 = localObject2;
      if (localObject5 != null)
      {
        localObject3 = localObject2;
        if (str != null)
        {
          if ((!str.equals(((TroopInfo)localObject5).troopowneruin)) && (((TroopInfo)localObject5).Administrator != null)) {
            ((TroopInfo)localObject5).Administrator.contains(str);
          }
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("");
          ((StringBuilder)localObject2).append(((TroopInfo)localObject5).dwGroupClassExt);
          localObject3 = ((StringBuilder)localObject2).toString();
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("https://web.qun.qq.com/mannounce/detail.html?_bid=148&_wv=1031#fid=");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.j);
      ((StringBuilder)localObject2).append("&gc=");
      ((StringBuilder)localObject2).append(this.jdField_b_of_type_JavaLangString);
      ((Intent)localObject4).putExtra("url", ((StringBuilder)localObject2).toString());
      ((Intent)localObject4).putExtra("webStyle", "noBottomBar");
      ((Intent)localObject4).putExtra("startOpenPageTime", System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.startActivity((Intent)localObject4);
      a("clk_history");
      if (this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager$TroopNotify.jdField_c_of_type_Boolean)
      {
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
        localObject4 = this.jdField_b_of_type_JavaLangString;
        if (!this.g) {
          j = 1;
        }
        ReportController.b((AppRuntime)localObject2, "dc00898", "", "", "0X800AAC9", "0X800AAC9", 0, 0, (String)localObject4, (String)localObject3, "", String.valueOf(j));
      }
      else
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800AAC8", "0X800AAC8", 0, 0, this.jdField_b_of_type_JavaLangString, (String)localObject3, "", "");
      }
      dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    paramObservable = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
    if (paramObservable != null) {
      paramObservable.deleteObserver(this);
    }
    paramObservable = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreTroopChatPie;
    if (paramObservable != null)
    {
      if (paramObservable.t()) {
        return;
      }
      if ((paramObject instanceof Integer))
      {
        paramObservable = (Integer)paramObject;
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("update, notifyType = ");
          paramObject.append(paramObservable);
          QLog.d("TroopTipsPopWindow", 2, paramObject.toString());
        }
        if (paramObservable.intValue() == 106)
        {
          paramObservable = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
          if ((paramObservable != null) && (paramObservable.jdField_a_of_type_OrgJsonJSONObject != null))
          {
            a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.jdField_a_of_type_OrgJsonJSONObject, 2, false);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsPopWindow", 2, "mNewGuideNotice = null!");
          }
        }
        else if (paramObservable.intValue() == 1007)
        {
          paramObservable = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
          if ((paramObservable != null) && (paramObservable.b != null))
          {
            a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.b, 1, false);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsPopWindow", 2, "mNewNorNotice = null!");
          }
        }
        else if (paramObservable.intValue() == 1011)
        {
          paramObservable = this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager;
          if ((paramObservable != null) && (paramObservable.b != null))
          {
            a(this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopFeedsDataManager.b, 1, true);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopTipsPopWindow", 2, "mNewNorNotice = null!");
          }
        }
        else if (paramObservable.intValue() == 1012)
        {
          TroopNotificationHelper.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_b_of_type_JavaLangString);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.feeds.TroopNewGuidePopWindow
 * JD-Core Version:    0.7.0.1
 */