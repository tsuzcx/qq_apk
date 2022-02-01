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
import com.tencent.mobileqq.redtouch.RedTouchManager;
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
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
import cooperation.qzone.util.QZoneDistributedAppCtrl;
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
      e(2131694510, 1);
      if (!paramBoolean1)
      {
        paramBoolean1 = true;
        a(paramCompoundButton, paramBoolean1);
      }
    }
    while (paramCompoundButton != this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a()) {
      for (;;)
      {
        return;
        paramBoolean1 = false;
      }
    }
    if (a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem))
    {
      if (!paramBoolean1) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        a(paramCompoundButton, paramBoolean1);
        return;
      }
    }
    Object localObject = new GeneralSettingActivity.17(this, paramBoolean2, paramInt, paramCompoundButton, paramBoolean1);
    if (paramBoolean1)
    {
      SharedPreferences localSharedPreferences = ThemeUtil.getUinThemePreferences(this.app);
      if (localSharedPreferences.getBoolean("key_simple_should_show_switch_dialog", true))
      {
        localSharedPreferences.edit().putBoolean("key_simple_should_show_switch_dialog", false).apply();
        localObject = new GeneralSettingActivity.18(this, (Runnable)localObject);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = DialogUtil.a(this, getString(2131719133), 0, 2131719131, (DialogInterface.OnClickListener)localObject, null);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new GeneralSettingActivity.WeakRefSimpleUIDismissListener(this, paramCompoundButton));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        if (!paramBoolean1) {
          break label242;
        }
      }
    }
    label242:
    for (paramCompoundButton = "0X800A0FC";; paramCompoundButton = "0X800A0FD")
    {
      ReportController.b(this.app, "dc00898", "", "", paramCompoundButton, paramCompoundButton, SimpleUIUtil.f(), 0, "0", "0", "", "");
      return;
      ((Runnable)localObject).run();
      break;
      ((Runnable)localObject).run();
      break;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem != null) {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(paramBoolean);
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
      localDrawable = getResources().getDrawable(2130839549);
      paramFormSwitchSimpleItem.setTag(localDrawable);
      int i = AIOUtils.a(19.0F, getResources());
      localDrawable.setBounds(0, 0, i, i);
      paramFormSwitchSimpleItem.setCompoundDrawables(null, null, localDrawable, null);
      ((Animatable)localDrawable).start();
      paramFormSwitchSimpleItem = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a();
      if (paramBoolean) {
        break label145;
      }
    }
    label145:
    for (paramBoolean = true;; paramBoolean = false)
    {
      paramFormSwitchSimpleItem.setEnabled(paramBoolean);
      return;
      localDrawable = (Drawable)paramFormSwitchSimpleItem.getTag();
      if ((localDrawable instanceof Animatable)) {
        ((Animatable)localDrawable).stop();
      }
      paramFormSwitchSimpleItem.setTag(null);
      paramFormSwitchSimpleItem.setVisibility(8);
      paramFormSwitchSimpleItem.setCompoundDrawables(null, null, null, null);
      break;
    }
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
    if (paramFormSwitchSimpleItem == null) {}
    while (!(paramFormSwitchSimpleItem.getTag() instanceof Animatable)) {
      return false;
    }
    return true;
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
      e(2131694510, 1);
      return;
    }
    if ((StudyModeManager.b() == -1) || (StudyModeManager.a() == -1))
    {
      e(2131694510, 1);
      return;
    }
    if ((StudyModeManager.b() == 0) && (StudyModeManager.a() == 1))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("FIRST_TIME_RES", -1);
      KidModeVerifyFragment.a(this, localIntent);
      return;
    }
    KidModeAdvanceSettingFragment.a(this);
  }
  
  private void d(int paramInt)
  {
    if (SettingsConfigHelper.a(this.app)) {
      if (paramInt == 2) {
        ReportController.a(this.app, "0X800B86D");
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt == 1)
        {
          ReportController.a(this.app, "0X800B86C");
          return;
        }
      } while (paramInt != 0);
      ReportController.a(this.app, "0X800B86B");
      return;
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
    } while (paramInt != 0);
    ReportController.b(this.app, "dc00898", "", "", "0X800A0FD", "0X800A0FD", SimpleUIUtil.f(), 0, "0", "0", "", "");
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)
    {
      RedTouchManager localRedTouchManager = (RedTouchManager)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localRedTouchManager.a("100190.100194");
      this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.a(localAppInfo);
      localRedTouchManager.a(localAppInfo);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131378199));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131378198);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131361792));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365537));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131369996));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131369995));
    a(2131374909, 2131699135, 0, 2130839575);
    super.findViewById(2131364693).setOnClickListener(new GeneralSettingActivity.4(this));
    j();
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131367302);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131371916);
    if (MsgBackupConfigProcessor.a()) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.fontCfg.name(), "-1");
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "current fontSetting dpcValue=" + (String)localObject);
    }
    if (("1".equals(localObject)) && (FontSettingManager.isDisplayMetricNoAnswer()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (LocaleConfProcessor.a())
      {
        LocaleManager.a("GeneralSettingActivity, entrance1:false, entrance2:" + LocaleManager.jdField_a_of_type_Boolean);
        View localView2 = findViewById(2131374908);
        if (localView2 != null)
        {
          localView2.setVisibility(0);
          if ((this.jdField_b_of_type_AndroidViewView instanceof FormSimpleItem)) {
            ((FormSimpleItem)this.jdField_b_of_type_AndroidViewView).setBgType(1);
          }
          ((TextView)localView2.findViewById(2131374923)).setText(getResources().getString(2131719080));
          View localView1 = localView2.findViewById(2131374924);
          localObject = localView1;
          if (localView1 == null) {
            localObject = ((ViewStub)localView2.findViewById(2131374925)).inflate();
          }
          ((View)localObject).setVisibility(0);
          localObject = (TextView)((View)localObject).findViewById(2131378268);
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setTextSize(0, getResources().getDimensionPixelSize(2131296793));
          ((TextView)localObject).setTypeface(Typeface.DEFAULT);
          ((TextView)localObject).setText(LocaleManager.a(LocaleManager.a()));
          localView2.setOnClickListener(new GeneralSettingActivity.5(this));
        }
      }
      h();
      i();
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new GeneralSettingActivity.6(this));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new GeneralSettingActivity.7(this));
      if (!DarkModeManager.a()) {
        break label688;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(DarkModeManager.c());
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(new GeneralSettingActivity.8(this));
      if (SettingsConfigHelper.a(this.app)) {
        ReportController.a(this.app, "0X800B80A");
      }
    }
    for (;;)
    {
      k();
      if (AppSetting.d)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(HardCodeUtil.a(2131705261));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("系统通知栏显示QQ图标");
        this.jdField_c_of_type_AndroidViewView.setContentDescription(getActivity().getResources().getString(2131719115));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getActivity().getResources().getString(2131719110));
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup = ((ModeRadioGroup)super.findViewById(2131367967));
      l();
      g();
      return;
      if ("0".equals(localObject))
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(8);
        FontSettingManager.revert2SystemDensity(this);
        break;
      }
      if (FontSettingManager.isSupportDevice())
      {
        this.jdField_b_of_type_AndroidViewView.setVisibility(0);
        break;
      }
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      FontSettingManager.revert2SystemDensity(this);
      break;
      label688:
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    }
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131366378));
    boolean bool = SettingCloneUtil.readValue(this, null, getString(2131694981), "qqsetting_enter_sendmsg_key", false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new GeneralSettingActivity.9(this));
  }
  
  private void i()
  {
    boolean bool = SettingCloneUtil.readValue(this, null, getString(2131719122), "qqsetting_notify_icon_key", false);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)findViewById(2131372434));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new GeneralSettingActivity.10(this));
  }
  
  private void j()
  {
    super.findViewById(2131363146).setOnClickListener(new GeneralSettingActivity.11(this));
  }
  
  private void k()
  {
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)findViewById(2131364616));
    if (SettingsConfigHelper.a(this.app))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      findViewById(2131364693).setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setContentDescription(getResources().getString(2131690878));
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(new GeneralSettingActivity.12(this));
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
  }
  
  private void l()
  {
    ModeSwitchManager localModeSwitchManager = (ModeSwitchManager)this.app.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
    localModeSwitchManager.a(this);
    Object localObject2 = (TextView)findViewById(2131378201);
    TextView localTextView = (TextView)findViewById(2131371804);
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365922);
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131364931);
    boolean bool;
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
      ((RelativeLayout.LayoutParams)localObject2).height -= AIOUtils.a(20.0F, getResources());
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
      {
        localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.a(13.0F, getResources());
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      bool = SimpleUIUtil.a();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.b().setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.a(this.jdField_a_of_type_AndroidViewView, this);
      a(bool, SimpleUIUtil.f());
      if (!StudyModeManager.a()) {
        break label483;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      a(this.jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontHandler.a());
      label272:
      if (QLog.isColorLevel()) {
        QLog.d("GeneralSettingActivity", 2, new Object[] { "[KidMode] configSwitch: ", Boolean.valueOf(StudyModeManager.a()), " isSwitch: ", Boolean.valueOf(localModeSwitchManager.a()), " manager TargetType: ", Integer.valueOf(localModeSwitchManager.a()) });
      }
      if ((!StudyModeManager.b()) || (!localModeSwitchManager.a())) {
        break label520;
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
      this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.a(false);
      if ((ModeConstantsKt.a() != 1) || (localModeSwitchManager.a() != 1)) {
        break label504;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.b(localModeSwitchManager.b(), true);
      this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(true));
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(localModeSwitchManager.a(), false, false);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(new GeneralSettingActivity.13(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
      localTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.setVisibility(8);
      localView.setVisibility(0);
      break;
      label483:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      break label272;
      label504:
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(localModeSwitchManager.a(), false, true);
      continue;
      label520:
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
    if ((StudyModeManager.b() == -1) || (StudyModeManager.a() == -1))
    {
      a("handleExitKidMode unknown status");
      return;
    }
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
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "onModeCheckedChanged curType : " + paramInt1 + ", oldType : " + paramInt2);
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
    if (localView2 == null) {}
    for (;;)
    {
      return;
      TextView localTextView = (TextView)localView2.findViewById(2131374923);
      localTextView.setText(paramInt2);
      View localView1 = localView2.findViewById(2131374924);
      Object localObject = localView1;
      if (localView1 == null) {
        localObject = ((ViewStub)localView2.findViewById(2131374925)).inflate();
      }
      ((View)localObject).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131378268);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setTextSize(0, getResources().getDimensionPixelSize(2131296793));
      ((TextView)localObject).setTypeface(Typeface.DEFAULT);
      ((TextView)localObject).setText(HardCodeUtil.a(2131705265));
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
        if (paramInt4 != 2130839591) {
          break label246;
        }
        ((FormItemRelativeLayout)localObject).setBGType(1);
      }
      while (paramInt1 == 2131374909)
      {
        this.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = new RedTouch(this, localView2).d(30).a();
        e();
        return;
        label246:
        if (paramInt4 == 2130839585) {
          ((FormItemRelativeLayout)localObject).setBGType(2);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (ModeSwitchManager)this.app.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
    boolean bool = ((ModeSwitchManager)localObject).a();
    localObject = ((ModeSwitchManager)localObject).a(this, paramInt1, paramInt2, paramBoolean1);
    if (((ModeSwitchManager.SwitchingStatus)localObject).a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GeneralSettingActivity", 2, "changeMode switchingStatus.isSwitching : true , mode : " + ((ModeSwitchManager.SwitchingStatus)localObject).a());
      }
      if (paramBoolean2)
      {
        a(paramInt2, true);
        this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
        this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.a(false);
      }
      ModeRadioGroup localModeRadioGroup = this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup;
      paramInt1 = ((ModeSwitchManager.SwitchingStatus)localObject).a();
      if (!paramBoolean2) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        localModeRadioGroup.a(paramInt1, false, paramBoolean1);
        if (bool) {
          QQToast.a(BaseApplication.getContext(), 0, 2131719138, 0).a();
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "changeMode switchingStatus.isSwitching : false , mode : " + ((ModeSwitchManager.SwitchingStatus)localObject).b());
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(((ModeSwitchManager.SwitchingStatus)localObject).b(), false, false);
  }
  
  protected void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  protected void a(String paramString)
  {
    e(2131719132, 1);
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
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      a(paramInt, false);
      return;
    }
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramBoolean)
      {
        i = 2;
        QQToast.a(this, i, paramString, 0).a();
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("GeneralSettingActivity", 2, "onModeChangeComplete isSuccess : " + paramBoolean + ", curType : " + paramInt1 + ", oldType : " + paramInt2);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.a(true);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(true);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1);
      if (!paramBoolean) {
        break label209;
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1, false, false);
      if (paramInt1 != 1) {
        break label174;
      }
    }
    label174:
    for (paramBoolean = bool1;; paramBoolean = false)
    {
      a(paramBoolean, SimpleUIUtil.f());
      QZoneDistributedAppCtrl.killQZoneProcess();
      if (paramInt1 == 2) {
        break label179;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      return;
      i = 1;
      break;
    }
    label179:
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
    KidModeUtils.b("SETTING", this.app);
    a(this.jdField_a_of_type_ComTencentMobileqqStudymodeAlphabeticFontHandler.a());
    return;
    label209:
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt2, false, false);
    if (paramInt2 == 1) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      a(paramBoolean, SimpleUIUtil.f());
      return;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onSwitchSimpleUICallback suc=%b bSwitchElsePref=%b hasChange=%b statusCode=%d", new Object[] { "SimpleUILog", Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) }));
    }
    Object localObject;
    label159:
    String str;
    if (paramBoolean3)
    {
      paramBoolean2 = this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a().isChecked();
      if (paramBoolean1)
      {
        if (paramBoolean2) {
          a(getString(2131719135, new Object[] { HardCodeUtil.a(2131705264) }), 2);
        }
        a(false, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem);
        a(SimpleUIUtil.a(), SimpleUIUtil.f());
        if (paramBoolean1) {
          QZoneDistributedAppCtrl.killQZoneProcess();
        }
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a(), SimpleUIUtil.a());
      if (paramBoolean2)
      {
        localObject = HardCodeUtil.a(2131705262);
        str = getString(2131719134, new Object[] { localObject });
        if (1 != paramInt) {
          break label239;
        }
        localObject = HardCodeUtil.a(2131705259) + (String)localObject + HardCodeUtil.a(2131705260);
      }
    }
    for (;;)
    {
      a((String)localObject, 1);
      break;
      localObject = HardCodeUtil.a(2131705263);
      break label159;
      label239:
      if (6 == paramInt)
      {
        localObject = str + HardCodeUtil.a(2131705258);
        continue;
        if (paramBoolean1) {
          break;
        }
        e(2131719132, 1);
        break;
      }
      localObject = str;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, @Nullable String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s onReqGetSimpleUISwitch suc=%b [%b,%d]", new Object[] { "SimpleUILog", Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Integer.valueOf(paramInt) }));
    }
    if ((!paramBoolean1) || (!this.app.getCurrentAccountUin().equals(paramString))) {}
    while ((a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem)) || (a())) {
      return;
    }
    a(paramBoolean2, paramBoolean3);
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
    int i;
    if (paramInt == 1)
    {
      boolean bool = ThemeUtil.isNowThemeIsNight(this.app, false, null);
      i = SimpleUIUtil.f();
      if (j == 0) {
        break label101;
      }
      if (!bool) {
        break label72;
      }
      i = SimpleUIUtil.c;
    }
    label72:
    label101:
    for (;;)
    {
      if (j != 0)
      {
        if (!DarkModeManager.a(this, SimpleUIUtil.a(i), new GeneralSettingActivity.14(this, paramInt, i))) {
          f(paramInt, i);
        }
        return;
        j = 0;
        break;
        if (!ThemeUtil.isNowThemeIsNight(this.app, false, SimpleUIUtil.a(i))) {
          break label101;
        }
        i = SimpleUIUtil.g();
        continue;
      }
      f(paramInt, i);
      return;
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "onModeChangeStart curType : " + paramInt1 + ", oldType : " + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.a(false);
  }
  
  public void c(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      e(2131694510, 1);
      QQToast.a(BaseApplication.getContext(), 1, 2131694510, 0).b(getTitleBarHeight());
    }
    while (a()) {
      return;
    }
    if (StudyModeManager.b()) {
      a(1, paramInt, false, true);
    }
    for (;;)
    {
      ReportController.b(this.app, "dc00898", "", "", "0X800A3D6", "0X800A3D6", paramInt + 1, 0, "0", "0", "", "");
      return;
      if (!((SimpleUIHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a().isChecked(), paramInt, false)) {
        e(2131719138, 0);
      } else {
        a(paramInt, true);
      }
    }
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "onSelectModeRecover curType : " + paramInt1 + ", oldType : " + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.a(true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt2, false, false);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1);
    if (paramInt2 == 1) {}
    for (;;)
    {
      a(bool, SimpleUIUtil.f());
      return;
      bool = false;
    }
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "onModeSwitching curType : " + paramInt1 + ", oldType : " + paramInt2);
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1, false, true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
    this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.a(false);
    if (paramInt2 == 1) {}
    for (;;)
    {
      a(bool, SimpleUIUtil.f());
      return;
      bool = false;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1) {
      ((SimpleUIHandler)this.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).b();
    }
    while (paramInt1 != 2) {
      return;
    }
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
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131561601);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.addFlags(262144);
      RouteUtils.a(this, paramBundle, "/base/login");
      super.finish();
      return false;
    }
    super.setTitle(2131699118);
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
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(null);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivitySimpleUIChoiceView.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqSimpleuiSimpleUIHandler.onDestroy();
    }
    super.doOnDestroy();
    Object localObject = a();
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
  
  public void doOnResume()
  {
    super.doOnResume();
    a();
  }
  
  void e(int paramInt1, int paramInt2)
  {
    QQToast.a(BaseApplication.getContext(), paramInt2, paramInt1, 0).b(getTitleBarHeight());
  }
  
  public boolean onBackEvent()
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
    switch (paramInt)
    {
    default: 
      return super.onCreateDialog(paramInt);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this, super.getTitleBarHeight());
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(getString(2131690933));
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
  
  public String setLastActivityName()
  {
    return super.getString(2131694959);
  }
  
  public boolean showPreview()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity
 * JD-Core Version:    0.7.0.1
 */