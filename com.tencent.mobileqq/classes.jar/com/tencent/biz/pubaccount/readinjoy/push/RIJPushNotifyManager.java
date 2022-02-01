package com.tencent.biz.pubaccount.readinjoy.push;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.push.mvp.RIJPushNotifyDialog;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyManager;", "", "()V", "checkBoxText", "", "getCheckBoxText", "()Ljava/lang/String;", "dialogShowDuration", "", "getDialogShowDuration", "()J", "shouldShowDialog", "", "type1ButtonText", "getType1ButtonText", "type1HeaderText", "getType1HeaderText", "type2HeaderText", "getType2HeaderText", "type2LeftButtonText", "getType2LeftButtonText", "type2RightButtonText", "getType2RightButtonText", "dismiss", "", "needAnimation", "uin", "getParam", "Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyParam;", "guideType", "", "topActivity", "Landroid/app/Activity;", "avatarUrl", "isDarkMode", "hasNightMode", "logicAction", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isOpenPushNotify", "isDefaultOpen", "buttonId", "reportDialogButtonClicked", "bizType", "uniqueId", "reportDialogCloseIconClicked", "reportDialogExposure", "showPushNotifyDialog", "isForceDarkMode", "showPushNotifyDialogForWeb", "callback", "Lcom/tencent/biz/pubaccount/readinjoy/push/RIJPushNotifyManager$IPushNotifyDialogCallback;", "showToast", "activity", "Companion", "IPushNotifyDialogCallback", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJPushNotifyManager
{
  public static final RIJPushNotifyManager.Companion a;
  @NotNull
  private static final Lazy jdField_a_of_type_KotlinLazy = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)RIJPushNotifyManager.Companion.instance.2.INSTANCE);
  private final long jdField_a_of_type_Long;
  @NotNull
  private final String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  @NotNull
  private final String b;
  @NotNull
  private final String c;
  @NotNull
  private final String d;
  @NotNull
  private final String e;
  @NotNull
  private final String f;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyPushRIJPushNotifyManager$Companion = new RIJPushNotifyManager.Companion(null);
  }
  
  public RIJPushNotifyManager()
  {
    if (Aladdin.getConfig(340).getIntegerFromString("enable_alert", 0) == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Long = (Aladdin.getConfig(340).getIntegerFromString("show_duration", 10) * 1000L);
      String str = Aladdin.getConfig(340).getString("checkbox_text", ReadInJoyUtils.a(2131718181));
      Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…efault_open_push_notify))");
      this.jdField_a_of_type_JavaLangString = str;
      str = Aladdin.getConfig(340).getString("type1_header_text", ReadInJoyUtils.a(2131718273));
      Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…_has_closed_push_notify))");
      this.b = str;
      str = Aladdin.getConfig(340).getString("type1_button_text", ReadInJoyUtils.a(2131718316));
      Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…injoy_open_it_right_now))");
      this.c = str;
      str = Aladdin.getConfig(340).getString("type2_header_text", ReadInJoyUtils.a(2131718274));
      Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…_has_opened_push_notify))");
      this.d = str;
      str = Aladdin.getConfig(340).getString("type2_left_button_text", ReadInJoyUtils.a(2131690946));
      Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…etString(R.string.close))");
      this.e = str;
      str = Aladdin.getConfig(340).getString("type2_right_button_text", ReadInJoyUtils.a(2131718276));
      Intrinsics.checkExpressionValueIsNotNull(str, "Aladdin.getConfig(QQAlad…g.readinjoy_i_dont_need))");
      this.f = str;
      return;
      bool = false;
    }
  }
  
  private final RIJPushNotifyParam a(int paramInt, Activity paramActivity, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, Function3<? super Boolean, ? super Boolean, ? super Integer, Unit> paramFunction3)
  {
    boolean bool2 = false;
    int j = 1;
    int i;
    boolean bool1;
    if ((paramActivity instanceof SplashActivity))
    {
      i = DisplayUtil.a((Context)paramActivity, 72.0F);
      bool1 = bool2;
      if (ThemeUtil.isNowThemeIsNight(ReadInJoyUtils.a(), false, null))
      {
        bool1 = bool2;
        if (paramBoolean2) {
          bool1 = true;
        }
      }
      if (paramInt != 1) {
        break label93;
      }
    }
    label93:
    for (paramInt = j;; paramInt = 2)
    {
      return new RIJPushNotifyParam(paramInt, paramBoolean1, paramString1, paramString2, i, bool1, paramFunction3);
      i = DisplayUtil.a((Context)paramActivity, 16.0F);
      break;
    }
  }
  
  private final void a(int paramInt1, String paramString, int paramInt2)
  {
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    AppInterface localAppInterface = (AppInterface)RIJQQAppInterfaceUtil.a();
    if (paramInt1 == 1) {}
    for (String str = "2";; str = "1")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(localAppInterface, "", "0X800AFFC", "0X800AFFC", 0, 0, str, paramString, String.valueOf(paramInt2), "", false);
      return;
    }
  }
  
  private final void a(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder;
    label39:
    IPublicAccountReportUtils localIPublicAccountReportUtils;
    AppInterface localAppInterface;
    if (paramInt2 == 1)
    {
      paramInt3 = 1;
      localReportR5Builder = new RIJTransMergeKanDianReport.ReportR5Builder();
      localReportR5Builder.a("click_type", Integer.valueOf(paramInt3));
      if (!paramBoolean) {
        break label131;
      }
      paramInt3 = 1;
      localReportR5Builder.a("is_ticked", Integer.valueOf(paramInt3));
      localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
      localAppInterface = (AppInterface)RIJQQAppInterfaceUtil.a();
      if (paramInt1 != 1) {
        break label137;
      }
    }
    label131:
    label137:
    for (String str = "2";; str = "1")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(localAppInterface, "", "0X800AFFE", "0X800AFFE", 0, 0, str, paramString, String.valueOf(paramInt2), localReportR5Builder.a(), false);
      return;
      if (paramInt3 == 1)
      {
        paramInt3 = 0;
        break;
      }
      paramInt3 = 1;
      break;
      paramInt3 = 0;
      break label39;
    }
  }
  
  private final void a(boolean paramBoolean1, boolean paramBoolean2, Activity paramActivity)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramBoolean1) {
      localStringBuilder.append(ReadInJoyUtils.a(2131718317));
    }
    for (;;)
    {
      if (paramBoolean2) {
        localStringBuilder.append(ReadInJoyUtils.a(2131718182));
      }
      QQToast.a((Context)paramActivity, 2, (CharSequence)localStringBuilder, 0).a();
      return;
      localStringBuilder.append(ReadInJoyUtils.a(2131718107));
    }
  }
  
  private final void b(int paramInt1, String paramString, int paramInt2)
  {
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    AppInterface localAppInterface = (AppInterface)RIJQQAppInterfaceUtil.a();
    if (paramInt1 == 1) {}
    for (String str = "2";; str = "1")
    {
      localIPublicAccountReportUtils.publicAccountReportClickEvent(localAppInterface, "", "0X800AFFD", "0X800AFFD", 0, 0, str, paramString, String.valueOf(paramInt2), "", false);
      return;
    }
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @NotNull
  public final String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a(int paramInt1, @NotNull String paramString1, @NotNull String paramString2, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "avatarUrl");
    Intrinsics.checkParameterIsNotNull(paramString2, "uniqueId");
    a(paramInt1, paramString1, paramString2, paramInt2, false);
  }
  
  public final void a(int paramInt1, @NotNull String paramString1, @NotNull String paramString2, int paramInt2, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "avatarUrl");
    Intrinsics.checkParameterIsNotNull(paramString2, "uniqueId");
    QLog.i("RIJPushNotifyManager", 1, "showPushNotifyDialog guideType: " + paramInt1 + " avatarUrl: " + paramString1 + " uin: " + paramString2 + " shouldShowDialog: " + this.jdField_a_of_type_Boolean);
    BaseActivity localBaseActivity;
    Object localObject;
    if ((paramInt1 != 0) && (this.jdField_a_of_type_Boolean))
    {
      localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity == null) {
        break label235;
      }
      localObject = localBaseActivity.getWindow();
      if (localObject == null) {
        break label235;
      }
      localObject = ((Window)localObject).getDecorView();
      if ((localObject instanceof ViewGroup))
      {
        if ((!(localBaseActivity instanceof VideoFeedsPlayActivity)) && (!(localBaseActivity instanceof PublicTransFragmentActivity)) && (!paramBoolean)) {
          break label241;
        }
        paramBoolean = true;
        label146:
        if (((localBaseActivity instanceof VideoFeedsPlayActivity)) || ((localBaseActivity instanceof PublicTransFragmentActivity))) {
          break label247;
        }
      }
    }
    label235:
    label241:
    label247:
    for (boolean bool = true;; bool = false)
    {
      paramString1 = a(paramInt1, (Activity)localBaseActivity, paramString1, paramString2, paramBoolean, bool, (Function3)new RIJPushNotifyManager.showPushNotifyDialog.param.1(this, localBaseActivity, paramString2, paramInt2, paramInt1));
      ReadInJoyLogicEngineEventDispatcher.a().a(false, "MATCH_ALL_UIN");
      new RIJPushNotifyDialog((ViewGroup)localObject, paramString1).a(true);
      a(paramInt2, paramString2, paramInt1);
      return;
      localObject = null;
      break;
      paramBoolean = false;
      break label146;
    }
  }
  
  public final void a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, @NotNull String paramString1, int paramInt2, @NotNull String paramString2, @NotNull RIJPushNotifyManager.IPushNotifyDialogCallback paramIPushNotifyDialogCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "avatarUrl");
    Intrinsics.checkParameterIsNotNull(paramString2, "uniqueId");
    Intrinsics.checkParameterIsNotNull(paramIPushNotifyDialogCallback, "callback");
    QLog.i("RIJPushNotifyManager", 1, "showPushNotifyDialogForWeb guideType: " + paramInt1 + " avatarUrl: " + paramString1 + " uin: " + paramString2 + "isDarkMode: " + paramBoolean1 + " hasNightMode: " + paramBoolean2 + " bizType: " + paramInt2 + " shouldShowDialog: " + this.jdField_a_of_type_Boolean);
    BaseActivity localBaseActivity;
    if ((paramInt1 != 0) && (this.jdField_a_of_type_Boolean))
    {
      localBaseActivity = BaseActivity.sTopActivity;
      if (localBaseActivity == null) {
        break label241;
      }
      localObject = localBaseActivity.getWindow();
      if (localObject == null) {
        break label241;
      }
    }
    label241:
    for (Object localObject = ((Window)localObject).getDecorView();; localObject = null)
    {
      if ((localObject instanceof ViewGroup))
      {
        paramString1 = a(paramInt1, (Activity)localBaseActivity, paramString1, paramString2, paramBoolean1, paramBoolean2, (Function3)new RIJPushNotifyManager.showPushNotifyDialogForWeb.param.1(this, localBaseActivity, paramString2, paramInt2, paramIPushNotifyDialogCallback, paramInt1));
        ReadInJoyLogicEngineEventDispatcher.a().a(false, "MATCH_ALL_UIN");
        new RIJPushNotifyDialog((ViewGroup)localObject, paramString1).a(true);
        a(paramInt2, paramString2, paramInt1);
      }
      return;
    }
  }
  
  public final void a(boolean paramBoolean, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "uin");
    ReadInJoyLogicEngineEventDispatcher.a().a(paramBoolean, paramString);
  }
  
  @NotNull
  public final String b()
  {
    return this.b;
  }
  
  @NotNull
  public final String c()
  {
    return this.c;
  }
  
  @NotNull
  public final String d()
  {
    return this.d;
  }
  
  @NotNull
  public final String e()
  {
    return this.e;
  }
  
  @NotNull
  public final String f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.push.RIJPushNotifyManager
 * JD-Core Version:    0.7.0.1
 */