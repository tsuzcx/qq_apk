package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.helper.HiddenChatHelper;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.LocaleManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SecSvcHandler;
import com.tencent.mobileqq.app.SecSvcObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.config.business.LocaleConfProcessor;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.msgbackup.util.MsgBackupConfigProcessor;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.settings.config.SettingsConfigHelper;
import com.tencent.mobileqq.simpleui.SimpleUIHandler;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.AlphabeticFontHandler;
import com.tencent.mobileqq.studymode.AlphabeticFontHelper;
import com.tencent.mobileqq.studymode.AlphabeticFontSwitchObserver;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment;
import com.tencent.mobileqq.studymode.KidModeObserver;
import com.tencent.mobileqq.studymode.KidModeServlet;
import com.tencent.mobileqq.studymode.KidModeUtils;
import com.tencent.mobileqq.studymode.KidModeVerifyFragment;
import com.tencent.mobileqq.studymode.ModeConstantsKt;
import com.tencent.mobileqq.studymode.ModeRadioGroup;
import com.tencent.mobileqq.studymode.ModeRadioGroup.OnCheckChangeListener;
import com.tencent.mobileqq.studymode.ModeSwitchManager;
import com.tencent.mobileqq.studymode.ModeSwitchManager.OnModeChangeResultCallback;
import com.tencent.mobileqq.studymode.ModeSwitchManager.SwitchingStatus;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneHelper;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

public class GeneralSettingActivity
  extends IphoneTitleBarActivity
  implements URLDrawable.URLDrawableListener2, ModeRadioGroup.OnCheckChangeListener, ModeSwitchManager.OnModeChangeResultCallback
{
  Handler jdField_a_of_type_AndroidOsHandler = new GeneralSettingActivity.19(this);
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new GeneralSettingActivity.3(this);
  View jdField_a_of_type_AndroidViewView;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new GeneralSettingActivity.16(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  SimpleUIChoiceView jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView = new SimpleUIChoiceView();
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private SecSvcObserver jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver = new GeneralSettingActivity.21(this);
  SimpleUIHandler jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIHandler;
  private AlphabeticFontHandler jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontHandler;
  private AlphabeticFontHelper jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontHelper;
  private final AlphabeticFontSwitchObserver jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontSwitchObserver = new GeneralSettingActivity.2(this);
  private KidModeObserver jdField_a_of_type_ComTencentMobileqqStudymodeKidModeObserver = new GeneralSettingActivity.1(this);
  ModeRadioGroup jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup;
  private RedTouch jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormSwitchSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  FormSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormSwitchSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  private View jdField_c_of_type_AndroidViewView;
  FormSwitchSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  
  private TopGestureLayout a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout == null)
    {
      Object localObject = (ViewGroup)getWindow().getDecorView();
      View localView = ((ViewGroup)localObject).getChildAt(0);
      if ((localView instanceof DragFrameLayout)) {
        localObject = (ViewGroup)localView;
      }
      localObject = ((ViewGroup)localObject).getChildAt(0);
      if ((localObject instanceof TopGestureLayout)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout = ((TopGestureLayout)localObject);
      }
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  }
  
  private void a(int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.a(paramInt, paramBoolean);
    this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean));
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      e(2131694475, 1);
      a(paramCompoundButton, paramBoolean1 ^ true);
      return;
    }
    if (paramCompoundButton == this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a())
    {
      if (a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem))
      {
        a(paramCompoundButton, paramBoolean1 ^ true);
        return;
      }
      Object localObject = new GeneralSettingActivity.17(this, paramBoolean2, paramInt, paramCompoundButton, paramBoolean1);
      if (paramBoolean1)
      {
        SharedPreferences localSharedPreferences = ThemeUtil.getUinThemePreferences(this.app);
        if (localSharedPreferences.getBoolean("key_simple_should_show_switch_dialog", true))
        {
          localSharedPreferences.edit().putBoolean("key_simple_should_show_switch_dialog", false).apply();
          localObject = new GeneralSettingActivity.18(this, (Runnable)localObject);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, getString(2131718851), 0, 2131718849, (DialogInterface.OnClickListener)localObject, null);
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new GeneralSettingActivity.WeakRefSimpleUIDismissListener(this, paramCompoundButton));
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        }
        else
        {
          ((Runnable)localObject).run();
        }
      }
      else
      {
        ((Runnable)localObject).run();
      }
      if (paramBoolean1) {
        paramCompoundButton = "0X800A0FC";
      } else {
        paramCompoundButton = "0X800A0FD";
      }
      ReportController.b(this.app, "dc00898", "", "", paramCompoundButton, paramCompoundButton, SimpleUIUtil.f(), 0, "0", "0", "", "");
    }
  }
  
  private void a(boolean paramBoolean)
  {
    FormSwitchSimpleItem localFormSwitchSimpleItem = this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
    if (localFormSwitchSimpleItem != null) {
      localFormSwitchSimpleItem.setChecked(paramBoolean);
    }
  }
  
  private void a(boolean paramBoolean, FormSwitchSimpleItem paramFormSwitchSimpleItem)
  {
    paramFormSwitchSimpleItem = paramFormSwitchSimpleItem.b();
    if (paramFormSwitchSimpleItem == null) {
      return;
    }
    Drawable localDrawable;
    if (paramBoolean)
    {
      paramFormSwitchSimpleItem.setVisibility(0);
      localDrawable = getResources().getDrawable(2130839406);
      paramFormSwitchSimpleItem.setTag(localDrawable);
      int i = AIOUtils.b(19.0F, getResources());
      localDrawable.setBounds(0, 0, i, i);
      paramFormSwitchSimpleItem.setCompoundDrawables(null, null, localDrawable, null);
      ((Animatable)localDrawable).start();
    }
    else
    {
      localDrawable = (Drawable)paramFormSwitchSimpleItem.getTag();
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).stop();
      }
      paramFormSwitchSimpleItem.setTag(null);
      paramFormSwitchSimpleItem.setVisibility(8);
      paramFormSwitchSimpleItem.setCompoundDrawables(null, null, null, null);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a().setEnabled(paramBoolean ^ true);
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "handleModeSelectRadioByRequest");
    }
    if ((StudyModeManager.b()) && (this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup != null))
    {
      int i = ModeConstantsKt.a(paramBoolean1, paramBoolean2);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(i, false, false);
    }
    a(paramBoolean1, SimpleUIUtil.f());
  }
  
  private boolean a(FormSwitchSimpleItem paramFormSwitchSimpleItem)
  {
    paramFormSwitchSimpleItem = paramFormSwitchSimpleItem.b();
    if (paramFormSwitchSimpleItem == null) {
      return false;
    }
    return (paramFormSwitchSimpleItem.getTag() instanceof Animatable);
  }
  
  private void c()
  {
    SecSvcHandler localSecSvcHandler = (SecSvcHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    if (localSecSvcHandler != null) {
      localSecSvcHandler.a(3);
    }
    KidModeServlet.a(this.app);
  }
  
  private void d()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      e(2131694475, 1);
      return;
    }
    if ((StudyModeManager.b() != -1) && (StudyModeManager.a() != -1))
    {
      if ((StudyModeManager.b() == 0) && (StudyModeManager.a() == 1))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("FIRST_TIME_RES", -1);
        KidModeVerifyFragment.a(this, localIntent);
        return;
      }
      KidModeAdvanceSettingFragment.a(this);
      return;
    }
    e(2131694475, 1);
  }
  
  private void d(int paramInt)
  {
    if (SettingsConfigHelper.a(this.app))
    {
      if (paramInt == 2)
      {
        ReportController.a(this.app, "0X800B86D");
        return;
      }
      if (paramInt == 1)
      {
        ReportController.a(this.app, "0X800B86C");
        return;
      }
      if (paramInt == 0) {
        ReportController.a(this.app, "0X800B86B");
      }
    }
    else
    {
      if (paramInt == 2)
      {
        ReportController.b(this.app, "dc00898", "", "", "0X800AD6B", "0X800AD6B", 0, 0, "", "", "", "");
        return;
      }
      if (paramInt == 1)
      {
        ReportController.b(this.app, "dc00898", "", "", "0X800A0FC", "0X800A0FC", SimpleUIUtil.f(), 0, "0", "0", "", "");
        return;
      }
      if (paramInt == 0) {
        ReportController.b(this.app, "dc00898", "", "", "0X800A0FD", "0X800A0FD", SimpleUIUtil.f(), 0, "0", "0", "", "");
      }
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.app.getRuntimeService(IRedTouchManager.class, "");
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localIRedTouchManager.getAppInfoByPath("100190.100194");
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(localAppInfo);
      localIRedTouchManager.onReportRedPointExposure(localAppInfo);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131377615));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131377614);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131361794));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365380));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131369681));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131369680));
    a(2131374445, 2131699239, 0, 2130839433);
    super.findViewById(2131364580).setOnClickListener(new GeneralSettingActivity.4(this));
    j();
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131367085);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131371537);
    if (MsgBackupConfigProcessor.a()) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.fontCfg.name(), "-1");
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("current fontSetting dpcValue=");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("GeneralSettingActivity", 2, ((StringBuilder)localObject2).toString());
    }
    if (("1".equals(localObject1)) && (FontSettingManager.isDisplayMetricNoAnswer()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    else if ("0".equals(localObject1))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      FontSettingManager.revert2SystemDensity(this);
    }
    else if (FontSettingManager.isSupportDevice())
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    }
    else
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      FontSettingManager.revert2SystemDensity(this);
    }
    if (LocaleConfProcessor.a())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("GeneralSettingActivity, entrance1:false, entrance2:");
      ((StringBuilder)localObject1).append(LocaleManager.jdField_a_of_type_Boolean);
      LocaleManager.a(((StringBuilder)localObject1).toString());
      View localView = findViewById(2131374444);
      if (localView != null)
      {
        localView.setVisibility(0);
        localObject1 = this.jdField_b_of_type_AndroidViewView;
        if ((localObject1 instanceof FormSimpleItem)) {
          ((FormSimpleItem)localObject1).setBgType(1);
        }
        ((TextView)localView.findViewById(2131374459)).setText(getResources().getString(2131718797));
        localObject2 = localView.findViewById(2131374460);
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ((ViewStub)localView.findViewById(2131374461)).inflate();
        }
        ((View)localObject1).setVisibility(0);
        localObject1 = (TextView)((View)localObject1).findViewById(2131377679);
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setTextSize(0, getResources().getDimensionPixelSize(2131296773));
        ((TextView)localObject1).setTypeface(Typeface.DEFAULT);
        ((TextView)localObject1).setText(LocaleManager.a(LocaleManager.a()));
        localView.setOnClickListener(new GeneralSettingActivity.5(this));
      }
    }
    h();
    i();
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new GeneralSettingActivity.6(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new GeneralSettingActivity.7(this));
    if (DarkModeManager.a())
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(DarkModeManager.c());
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(new GeneralSettingActivity.8(this));
      if (SettingsConfigHelper.a(this.app)) {
        ReportController.a(this.app, "0X800B80A");
      }
    }
    else
    {
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    k();
    if (AppSetting.d)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131705338));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("系统通知栏显示QQ图标");
      this.jdField_c_of_type_AndroidViewView.setContentDescription(getActivity().getResources().getString(2131718833));
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getActivity().getResources().getString(2131718828));
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup = ((ModeRadioGroup)super.findViewById(2131367724));
    l();
    g();
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2, true, false);
  }
  
  private void g()
  {
    if (SettingsConfigHelper.a(this.app))
    {
      ReportController.a(this.app, "0X800B80C");
      ReportController.a(this.app, "0X800B80B");
      ReportController.a(this.app, "0X800B810");
      ReportController.a(this.app, "0X800B80F");
      ReportController.a(this.app, "0X800B80E");
      ReportController.a(this.app, "0X800B80D");
      ReportController.a(this.app, "0X800B807");
      ReportController.a(this.app, "0X800B808");
      if (StudyModeManager.b()) {
        ReportController.a(this.app, "0X800B809");
      }
    }
  }
  
  private void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131366261));
    boolean bool = SettingCloneUtil.readValue(this, null, getString(2131694971), "qqsetting_enter_sendmsg_key", false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new GeneralSettingActivity.9(this));
  }
  
  private void i()
  {
    boolean bool = SettingCloneUtil.readValue(this, null, getString(2131718840), "qqsetting_notify_icon_key", false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131372017));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new GeneralSettingActivity.10(this));
  }
  
  private void j()
  {
    super.findViewById(2131363087).setOnClickListener(new GeneralSettingActivity.11(this));
  }
  
  private void k()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364503));
    if (SettingsConfigHelper.a(this.app))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      findViewById(2131364580).setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getResources().getString(2131690807));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new GeneralSettingActivity.12(this));
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  private void l()
  {
    ModeSwitchManager localModeSwitchManager = (ModeSwitchManager)this.app.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
    localModeSwitchManager.a(this);
    Object localObject2 = (TextView)findViewById(2131377616);
    TextView localTextView = (TextView)findViewById(2131371428);
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365759);
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131364815);
    if (StudyModeManager.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      localTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.setOnCheckChangeListener(this);
      localView.setVisibility(8);
      ((View)localObject1).setPadding(0, 0, 0, 0);
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height -= AIOUtils.b(20.0F, getResources());
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
      {
        localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.b(13.0F, getResources());
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
      localTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.setVisibility(8);
      localView.setVisibility(0);
    }
    boolean bool = SimpleUIUtil.a();
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.b().setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.a(this.jdField_a_of_type_AndroidViewView, this);
    a(bool, SimpleUIUtil.f());
    if (StudyModeManager.a())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      a(this.jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontHandler.a());
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
    }
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, new Object[] { "[KidMode] configSwitch: ", Boolean.valueOf(StudyModeManager.a()), " isSwitch: ", Boolean.valueOf(localModeSwitchManager.a()), " manager TargetType: ", Integer.valueOf(localModeSwitchManager.a()) });
    }
    if ((StudyModeManager.b()) && (localModeSwitchManager.a()))
    {
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.a(false);
      if ((ModeConstantsKt.a() == 1) && (localModeSwitchManager.a() == 1))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.b(localModeSwitchManager.b(), true);
        this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(true));
        this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(localModeSwitchManager.a(), false, false);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(localModeSwitchManager.a(), false, true);
      }
    }
    else
    {
      ((SimpleUIHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).a();
      if (StudyModeManager.b())
      {
        int i = ModeConstantsKt.a();
        this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(i, false, false);
      }
      else
      {
        a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a(), bool);
      }
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(new GeneralSettingActivity.13(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
  }
  
  private void m()
  {
    ThreadManager.getUIHandler().post(new GeneralSettingActivity.20(this));
  }
  
  protected void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    TopGestureLayout localTopGestureLayout = a();
    if (localTopGestureLayout == null)
    {
      QLog.e("GeneralSettingActivity", 2, "processRvTouchEvent failed! topGestureLayout return null!");
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    localTopGestureLayout.setInterceptTouchEventListener(new GeneralSettingActivity.15(this));
  }
  
  protected void a(int paramInt)
  {
    if ((StudyModeManager.b() != -1) && (StudyModeManager.a() != -1))
    {
      if ((StudyModeManager.b() == 0) && (StudyModeManager.a() == 1))
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("target", 1);
        localIntent.putExtra("RESULT_CODE", 2);
        localIntent.putExtra("ExtraTargetMode", paramInt);
        localIntent.putExtra("FIRST_TIME_RES", -1);
        KidModeVerifyFragment.a(this, localIntent);
        return;
      }
      b(paramInt);
      return;
    }
    a("handleExitKidMode unknown status");
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onModeCheckedChanged curType : ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", oldType : ");
      localStringBuilder.append(paramInt2);
      QLog.d("GeneralSettingActivity", 2, localStringBuilder.toString());
    }
    d(paramInt1);
    if (paramInt2 == 2)
    {
      a(paramInt1);
      return;
    }
    b(paramInt1);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView2 = findViewById(paramInt1);
    if (localView2 == null) {
      return;
    }
    TextView localTextView = (TextView)localView2.findViewById(2131374459);
    localTextView.setText(paramInt2);
    View localView1 = localView2.findViewById(2131374460);
    Object localObject = localView1;
    if (localView1 == null) {
      localObject = ((ViewStub)localView2.findViewById(2131374461)).inflate();
    }
    ((View)localObject).setVisibility(0);
    localObject = (TextView)((View)localObject).findViewById(2131377679);
    ((TextView)localObject).setVisibility(0);
    ((TextView)localObject).setTextSize(0, getResources().getDimensionPixelSize(2131296773));
    ((TextView)localObject).setTypeface(Typeface.DEFAULT);
    ((TextView)localObject).setText(HardCodeUtil.a(2131705342));
    if (AppSetting.d) {
      localTextView.setContentDescription(getString(paramInt2));
    }
    if (paramInt3 > 0) {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(getActivity().getResources().getDrawable(paramInt3), null, null, null);
    }
    localView2.setBackgroundResource(paramInt4);
    localView2.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if ((localView2 instanceof FormItemRelativeLayout))
    {
      localObject = (FormItemRelativeLayout)localView2;
      if (paramInt4 == 2130839449) {
        ((FormItemRelativeLayout)localObject).setBGType(1);
      } else if (paramInt4 == 2130839443) {
        ((FormItemRelativeLayout)localObject).setBGType(2);
      }
    }
    if (paramInt1 == 2131374445)
    {
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, localView2).d(30).a();
      e();
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (ModeSwitchManager)this.app.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
    boolean bool = ((ModeSwitchManager)localObject).a();
    localObject = ((ModeSwitchManager)localObject).a(this, paramInt1, paramInt2, paramBoolean1);
    StringBuilder localStringBuilder;
    if (((ModeSwitchManager.SwitchingStatus)localObject).a())
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("changeMode switchingStatus.isSwitching : true , mode : ");
        localStringBuilder.append(((ModeSwitchManager.SwitchingStatus)localObject).a());
        QLog.d("GeneralSettingActivity", 2, localStringBuilder.toString());
      }
      if (paramBoolean2)
      {
        a(paramInt2, true);
        this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
        this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.a(false);
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(((ModeSwitchManager.SwitchingStatus)localObject).a(), false, true ^ paramBoolean2);
      if (bool) {
        QQToast.a(BaseApplication.getContext(), 0, 2131718856, 0).a();
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("changeMode switchingStatus.isSwitching : false , mode : ");
        localStringBuilder.append(((ModeSwitchManager.SwitchingStatus)localObject).b());
        QLog.d("GeneralSettingActivity", 2, localStringBuilder.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(((ModeSwitchManager.SwitchingStatus)localObject).b(), false, false);
    }
  }
  
  protected void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  protected void a(String paramString)
  {
    e(2131718850, 1);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(2, false, false);
    a(false, SimpleUIUtil.f());
    QLog.d("GeneralSettingActivity", 1, new Object[] { paramString, " switch failed" });
  }
  
  void a(String paramString, int paramInt)
  {
    QQToast.a(BaseApplication.getContext(), paramInt, paramString, 0).b(getTitleBarHeight());
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 1, new Object[] { "checkNeedShowSimpleUIChoice switch: ", Boolean.valueOf(paramBoolean), " bPref: ", Integer.valueOf(paramInt) });
    }
    View localView = this.jdField_a_of_type_AndroidViewView;
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    localView.setVisibility(i);
    a(paramInt, false);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = true;
    boolean bool1 = true;
    if (!bool3)
    {
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 1;
      }
      QQToast.a(this, i, paramString, 0).a();
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onModeChangeComplete isSuccess : ");
      paramString.append(paramBoolean);
      paramString.append(", curType : ");
      paramString.append(paramInt1);
      paramString.append(", oldType : ");
      paramString.append(paramInt2);
      QLog.d("GeneralSettingActivity", 2, paramString.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.a(true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1, false, false);
      if (paramInt1 == 1) {
        paramBoolean = bool1;
      } else {
        paramBoolean = false;
      }
      a(paramBoolean, SimpleUIUtil.f());
      QZoneHelper.killQZoneProcess();
      if (paramInt1 != 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      KidModeUtils.b("SETTING", this.app);
      a(this.jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontHandler.a());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt2, false, false);
    if (paramInt2 == 1) {
      paramBoolean = bool2;
    } else {
      paramBoolean = false;
    }
    a(paramBoolean, SimpleUIUtil.f());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onSwitchSimpleUICallback suc=%b bSwitchElsePref=%b hasChange=%b statusCode=%d", new Object[] { "SimpleUILog", Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) }));
    }
    if (paramBoolean3)
    {
      paramBoolean2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a().isChecked();
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          a(getString(2131718853, new Object[] { HardCodeUtil.a(2131705341) }), 2);
        }
      }
      else
      {
        a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a(), SimpleUIUtil.a());
        int i;
        if (paramBoolean2) {
          i = 2131705339;
        } else {
          i = 2131705340;
        }
        Object localObject1 = HardCodeUtil.a(i);
        Object localObject2 = getString(2131718852, new Object[] { localObject1 });
        if (1 == paramInt)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131705336));
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(HardCodeUtil.a(2131705337));
          localObject1 = ((StringBuilder)localObject2).toString();
        }
        else
        {
          localObject1 = localObject2;
          if (6 == paramInt)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append((String)localObject2);
            ((StringBuilder)localObject1).append(HardCodeUtil.a(2131705335));
            localObject1 = ((StringBuilder)localObject1).toString();
          }
        }
        a((String)localObject1, 1);
      }
    }
    else if (!paramBoolean1)
    {
      e(2131718850, 1);
    }
    a(false, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem);
    a(SimpleUIUtil.a(), SimpleUIUtil.f());
    if (paramBoolean1) {
      QZoneHelper.killQZoneProcess();
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onReqGetSimpleUISwitch suc=%b [%b,%d]", new Object[] { "SimpleUILog", Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) }));
    }
    if (paramBoolean1)
    {
      if (!this.app.getCurrentAccountUin().equals(paramString)) {
        return;
      }
      if (a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem)) {
        return;
      }
      if (a()) {
        return;
      }
      a(paramBoolean2, paramBoolean3);
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_AndroidViewView.getTag();
    return ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue());
  }
  
  public void b()
  {
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(DarkModeManager.c());
  }
  
  protected void b(int paramInt)
  {
    int j = 1;
    if (paramInt != 1) {
      j = 0;
    }
    boolean bool = ThemeUtil.isNowThemeIsNight(this.app, false, null);
    int k = SimpleUIUtil.f();
    int i = k;
    if (j != 0) {
      if (bool)
      {
        i = SimpleUIUtil.c;
      }
      else
      {
        i = k;
        if (ThemeUtil.isNowThemeIsNight(this.app, false, SimpleUIUtil.a(k))) {
          i = SimpleUIUtil.g();
        }
      }
    }
    if (j != 0)
    {
      if (!DarkModeManager.a(this, SimpleUIUtil.a(i), new GeneralSettingActivity.14(this, paramInt, i))) {
        f(paramInt, i);
      }
    }
    else {
      f(paramInt, i);
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onModeChangeStart curType : ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", oldType : ");
      localStringBuilder.append(paramInt2);
      QLog.d("GeneralSettingActivity", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.a(false);
  }
  
  public void c(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      e(2131694475, 1);
      QQToast.a(BaseApplication.getContext(), 1, 2131694475, 0).b(getTitleBarHeight());
      return;
    }
    if (a()) {
      return;
    }
    if (StudyModeManager.b()) {
      a(1, paramInt, false, true);
    } else if (!((SimpleUIHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a().isChecked(), paramInt, false)) {
      e(2131718856, 0);
    } else {
      a(paramInt, true);
    }
    ReportController.b(this.app, "dc00898", "", "", "0X800A3D6", "0X800A3D6", paramInt + 1, 0, "0", "0", "", "");
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onSelectModeRecover curType : ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", oldType : ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("GeneralSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView;
    boolean bool = true;
    ((SimpleUIChoiceView)localObject).a(true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt2, false, false);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1);
    if (paramInt2 != 1) {
      bool = false;
    }
    a(bool, SimpleUIUtil.f());
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onModeSwitching curType : ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", oldType : ");
      ((StringBuilder)localObject).append(paramInt2);
      QLog.d("GeneralSettingActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup;
    boolean bool = true;
    ((ModeRadioGroup)localObject).a(paramInt1, false, true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.a(false);
    if (paramInt2 != 1) {
      bool = false;
    }
    a(bool, SimpleUIUtil.f());
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1)
    {
      ((SimpleUIHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).b();
      return;
    }
    if (paramInt1 == 2)
    {
      if ((paramInt2 == -1) && (paramIntent != null))
      {
        paramInt1 = paramIntent.getIntExtra("ExtraTargetMode", -1);
        if (paramInt1 == -1)
        {
          QLog.e("GeneralSettingActivity", 1, new Object[] { "error targetType:", Integer.valueOf(paramInt1) });
          return;
        }
        b(paramInt1);
        return;
      }
      a("Verify cancel");
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561443);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.addFlags(262144);
      RouteUtils.a(this, paramBundle, "/base/login");
      super.finish();
      return false;
    }
    super.setTitle(2131699222);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontSwitchObserver);
    this.app.registObserver(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeObserver);
    addObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontHandler = ((AlphabeticFontHandler)this.app.getBusinessHandler(BusinessHandlerFactory.TEENS_MODE_ALPHABETIC_FONT_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontHelper = new AlphabeticFontHelper();
    this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIHandler = ((SimpleUIHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER));
    f();
    c();
    return true;
  }
  
  protected void doOnDestroy()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      super.dismissDialog(1);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).setOnDismissListener(null);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      }
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView;
    if (localObject != null) {
      ((SimpleUIChoiceView)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIHandler;
    if (localObject != null) {
      ((SimpleUIHandler)localObject).onDestroy();
    }
    super.doOnDestroy();
    localObject = a();
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchEventListener(null);
    }
    localObject = (ModeSwitchManager)this.app.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
    ((ModeSwitchManager)localObject).b(this);
    ((ModeSwitchManager)localObject).a();
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontSwitchObserver);
    this.app.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqStudymodeKidModeObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppSecSvcObserver);
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    a();
  }
  
  void e(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  protected boolean onBackEvent()
  {
    HiddenChatHelper.b(this, QQSettingSettingActivity.class);
    return super.onBackEvent();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected Dialog onCreateDialog(int paramInt)
  {
    if (paramInt != 1) {
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131690861));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(true);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.b(true);
    return this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  }
  
  public void onFileDownloaded(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onFileDownloaded", new Object[] { "SimpleUILog" }));
    }
    m();
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onLoadCanceled", new Object[] { "SimpleUILog" }));
    }
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onLoadFialed", new Object[] { "SimpleUILog" }));
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onLoadCanceled", new Object[] { "SimpleUILog" }));
    }
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onLoadSuccessed", new Object[] { "SimpleUILog" }));
    }
    m();
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onPostThemeChanged", new Object[] { "SimpleUILog" }));
    }
  }
  
  protected String setLastActivityName()
  {
    return super.getString(2131694949);
  }
  
  public boolean showPreview()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity
 * JD-Core Version:    0.7.0.1
 */