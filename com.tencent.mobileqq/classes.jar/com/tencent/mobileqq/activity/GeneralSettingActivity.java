package com.tencent.mobileqq.activity;

import Override;
import aebx;
import aeby;
import aebz;
import aeca;
import aecb;
import aecc;
import aecd;
import aecf;
import aecg;
import aech;
import aeci;
import aecj;
import aeck;
import aecl;
import aecm;
import aecn;
import aeco;
import aecp;
import aecr;
import aexr;
import agij;
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
import anvx;
import anxv;
import aodi;
import aodj;
import arbl;
import axcn;
import bbbq;
import bdfe;
import bdfk;
import bdla;
import bdud;
import bdue;
import bduf;
import bdut;
import bduu;
import bduv;
import bduz;
import bdva;
import bdve;
import bdvf;
import bdvh;
import bdvn;
import behh;
import bhdj;
import bisl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener2;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.studymode.KidModeAdvanceSettingFragment;
import com.tencent.mobileqq.studymode.KidModeVerifyFragment;
import com.tencent.mobileqq.studymode.ModeRadioGroup;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.FormItemRelativeLayout;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.FormSwitchSimpleItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
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
  implements bdva, bdvf, URLDrawable.URLDrawableListener2
{
  public aexr a;
  public Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new aecj(this);
  public View a;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new aecd(this);
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private aodj jdField_a_of_type_Aodj = new aeci(this);
  bdfe jdField_a_of_type_Bdfe;
  private bdud jdField_a_of_type_Bdud;
  private bdue jdField_a_of_type_Bdue;
  private final bduf jdField_a_of_type_Bduf = new aech(this);
  private bdut jdField_a_of_type_Bdut = new aebx(this);
  public bisl a;
  private TopGestureLayout jdField_a_of_type_ComTencentMobileqqActivityFlingTopGestureLayout;
  private RedTouch jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch;
  ModeRadioGroup jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  FormSimpleItem jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem;
  FormSwitchItem jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  public FormSwitchSimpleItem a;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean;
  private View jdField_b_of_type_AndroidViewView;
  FormSwitchItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem;
  FormSwitchSimpleItem jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  private View jdField_c_of_type_AndroidViewView;
  FormSwitchSimpleItem jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem;
  
  public GeneralSettingActivity()
  {
    this.jdField_a_of_type_Aexr = new aexr();
    this.jdField_a_of_type_AndroidOsHandler = new aecg(this);
  }
  
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
    this.jdField_a_of_type_Aexr.a(paramInt, paramBoolean);
    this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(paramBoolean));
  }
  
  private void a(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      e(2131694305, 1);
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
    Object localObject = new GeneralSettingActivity.16(this, paramBoolean2, paramInt, paramCompoundButton, paramBoolean1);
    if (paramBoolean1)
    {
      SharedPreferences localSharedPreferences = ThemeUtil.getUinThemePreferences(this.app);
      if (localSharedPreferences.getBoolean("key_simple_should_show_switch_dialog", true))
      {
        localSharedPreferences.edit().putBoolean("key_simple_should_show_switch_dialog", false).apply();
        localObject = new aecf(this, (Runnable)localObject);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this, getString(2131718609), 0, 2131718607, (DialogInterface.OnClickListener)localObject, null);
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new aecr(this, paramCompoundButton));
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
        if (!paramBoolean1) {
          break label242;
        }
      }
    }
    label242:
    for (paramCompoundButton = "0X800A0FC";; paramCompoundButton = "0X800A0FD")
    {
      bdla.b(this.app, "dc00898", "", "", paramCompoundButton, paramCompoundButton, bdfk.c(), 0, "0", "0", "", "");
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
      localDrawable = getResources().getDrawable(2130839470);
      paramFormSwitchSimpleItem.setTag(localDrawable);
      int i = AIOUtils.dp2px(19.0F, getResources());
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
    if ((bdvn.b()) && (this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup != null))
    {
      int i = bduz.a(paramBoolean1, paramBoolean2);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(i, false, false);
    }
    a(paramBoolean1, bdfk.c());
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
    aodi localaodi = (aodi)this.app.getBusinessHandler(BusinessHandlerFactory.SEC_SVC_HANDLER);
    if (localaodi != null) {
      localaodi.a(1);
    }
    bduu.a(this.app);
  }
  
  private void d()
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      e(2131694305, 1);
      return;
    }
    if ((bdvn.b() == -1) || (bdvn.a() == -1))
    {
      e(2131694305, 1);
      return;
    }
    if ((bdvn.b() == 0) && (bdvn.a() == 1))
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("FIRST_TIME_RES", -1);
      KidModeVerifyFragment.a(this, localIntent);
      return;
    }
    KidModeAdvanceSettingFragment.a(this);
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null)
    {
      bbbq localbbbq = (bbbq)this.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
      BusinessInfoCheckUpdate.AppInfo localAppInfo = localbbbq.a("100190.100194");
      this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localAppInfo);
      localbbbq.a(localAppInfo);
    }
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131377788));
    this.jdField_a_of_type_AndroidViewView = super.findViewById(2131377787);
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131361792));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131365387));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131366206));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem = ((FormSwitchItem)super.findViewById(2131372132));
    this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem = ((FormSwitchSimpleItem)super.findViewById(2131369727));
    this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem = ((FormSimpleItem)super.findViewById(2131369726));
    a(2131374538, 2131698822, 0, 2130839496);
    super.findViewById(2131364579).setOnClickListener(new aeck(this));
    super.findViewById(2131363101).setOnClickListener(new aecl(this));
    this.jdField_b_of_type_AndroidViewView = super.findViewById(2131367112);
    this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    this.jdField_c_of_type_AndroidViewView = super.findViewById(2131371606);
    if (axcn.a()) {
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
    }
    Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.fontCfg.name(), "-1");
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "current fontSetting dpcValue=" + (String)localObject);
    }
    if (("1".equals(localObject)) && (FontSettingManager.isDisplayMetricNoAnswer()))
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(0);
      if (arbl.a())
      {
        anxv.a("GeneralSettingActivity, entrance1:false, entrance2:" + anxv.jdField_a_of_type_Boolean);
        View localView2 = findViewById(2131374537);
        if (localView2 != null)
        {
          localView2.setVisibility(0);
          if ((this.jdField_b_of_type_AndroidViewView instanceof FormSimpleItem)) {
            ((FormSimpleItem)this.jdField_b_of_type_AndroidViewView).setBgType(1);
          }
          ((TextView)localView2.findViewById(2131374552)).setText(getResources().getString(2131718557));
          View localView1 = localView2.findViewById(2131374553);
          localObject = localView1;
          if (localView1 == null) {
            localObject = ((ViewStub)localView2.findViewById(2131374554)).inflate();
          }
          ((View)localObject).setVisibility(0);
          localObject = (TextView)((View)localObject).findViewById(2131377857);
          ((TextView)localObject).setVisibility(0);
          ((TextView)localObject).setTextSize(0, getResources().getDimensionPixelSize(2131296773));
          ((TextView)localObject).setTypeface(Typeface.DEFAULT);
          ((TextView)localObject).setText(anxv.a(anxv.a()));
          localView2.setOnClickListener(new aecm(this));
        }
      }
      boolean bool = SettingCloneUtil.readValue(this, null, getString(2131694743), "qqsetting_enter_sendmsg_key", false);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aecn(this));
      bool = SettingCloneUtil.readValue(this, null, getString(2131718598), "qqsetting_notify_icon_key", false);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setChecked(bool);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setOnCheckedChangeListener(new aeco(this));
      this.jdField_b_of_type_AndroidViewView.setOnClickListener(new aecp(this));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new aeby(this));
      if (!behh.a()) {
        break label773;
      }
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(behh.c());
      this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(new aebz(this));
    }
    for (;;)
    {
      if (AppSetting.c)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription(anvx.a(2131704718));
        this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchItem.setContentDescription("系统通知栏显示QQ图标");
        this.jdField_c_of_type_AndroidViewView.setContentDescription(getActivity().getResources().getString(2131718592));
        this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setContentDescription(getActivity().getResources().getString(2131718587));
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup = ((ModeRadioGroup)super.findViewById(2131367759));
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
      label773:
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
    bdve localbdve = (bdve)this.app.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
    localbdve.a(this);
    Object localObject2 = (TextView)findViewById(2131377790);
    TextView localTextView = (TextView)findViewById(2131371492);
    View localView = this.jdField_a_of_type_AndroidViewView.findViewById(2131365759);
    Object localObject1 = this.jdField_a_of_type_AndroidViewView.findViewById(2131364807);
    boolean bool;
    if (bdvn.b())
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      localTextView.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.setOnCheckChangeListener(this);
      localView.setVisibility(8);
      ((View)localObject1).setPadding(0, 0, 0, 0);
      localObject2 = (RelativeLayout.LayoutParams)((View)localObject1).getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject2).height -= AIOUtils.dp2px(20.0F, getResources());
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (this.jdField_b_of_type_AndroidViewView.getVisibility() == 0)
      {
        localObject1 = (LinearLayout.LayoutParams)this.jdField_b_of_type_AndroidViewView.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).topMargin = AIOUtils.dp2px(14.0F, getResources());
        this.jdField_b_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      bool = bdfk.b();
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.b().setVisibility(8);
      this.jdField_a_of_type_Aexr.a(this.jdField_a_of_type_AndroidViewView, this);
      a(bool, bdfk.c());
      if (!bdvn.a()) {
        break label418;
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(0);
      a(this.jdField_a_of_type_Bdud.a());
      label272:
      if ((!bdvn.b()) || (!localbdve.a())) {
        break label455;
      }
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
      this.jdField_a_of_type_Aexr.a(false);
      if ((bduz.a() != 1) || (localbdve.a() != 1)) {
        break label439;
      }
      this.jdField_a_of_type_Aexr.b(localbdve.b(), true);
      this.jdField_a_of_type_AndroidViewView.setTag(Boolean.valueOf(true));
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(localbdve.a(), false, false);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setOnCheckedChangeListener(new aeca(this));
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(0);
      ((TextView)localObject2).setVisibility(0);
      localTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.setVisibility(8);
      localView.setVisibility(0);
      break;
      label418:
      this.jdField_a_of_type_ComTencentMobileqqWidgetFormSimpleItem.setVisibility(8);
      this.jdField_b_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setVisibility(8);
      break label272;
      label439:
      this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(localbdve.a(), false, true);
      continue;
      label455:
      ((bdfe)this.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).a();
      if (bdvn.b())
      {
        int i = bduz.a();
        this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(i, false, false);
      }
      else
      {
        a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a(), bool);
      }
    }
  }
  
  private void h()
  {
    ThreadManager.getUIHandler().post(new GeneralSettingActivity.19(this));
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
    localTopGestureLayout.setInterceptTouchEventListener(new aecc(this));
  }
  
  protected void a(int paramInt)
  {
    if ((bdvn.b() == -1) || (bdvn.a() == -1))
    {
      a("handleExitKidMode unknown status");
      return;
    }
    if ((bdvn.b() == 0) && (bdvn.a() == 1))
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
    if (paramInt1 == 2) {
      bdla.b(this.app, "dc00898", "", "", "0X800AD6B", "0X800AD6B", 0, 0, "", "", "", "");
    }
    while (paramInt2 == 2)
    {
      a(paramInt1);
      return;
      if (paramInt1 == 1) {
        bdla.b(this.app, "dc00898", "", "", "0X800A0FC", "0X800A0FC", bdfk.c(), 0, "0", "0", "", "");
      } else if (paramInt1 == 0) {
        bdla.b(this.app, "dc00898", "", "", "0X800A0FD", "0X800A0FD", bdfk.c(), 0, "0", "0", "", "");
      }
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
      TextView localTextView = (TextView)localView2.findViewById(2131374552);
      localTextView.setText(paramInt2);
      View localView1 = localView2.findViewById(2131374553);
      Object localObject = localView1;
      if (localView1 == null) {
        localObject = ((ViewStub)localView2.findViewById(2131374554)).inflate();
      }
      ((View)localObject).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131377857);
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setTextSize(0, getResources().getDimensionPixelSize(2131296773));
      ((TextView)localObject).setTypeface(Typeface.DEFAULT);
      ((TextView)localObject).setText(anvx.a(2131704722));
      if (AppSetting.c) {
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
        if (paramInt4 != 2130839512) {
          break label246;
        }
        ((FormItemRelativeLayout)localObject).setBGType(1);
      }
      while (paramInt1 == 2131374538)
      {
        this.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = new RedTouch(this, localView2).d(30).a();
        e();
        return;
        label246:
        if (paramInt4 == 2130839506) {
          ((FormItemRelativeLayout)localObject).setBGType(2);
        }
      }
    }
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = (bdve)this.app.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
    boolean bool = ((bdve)localObject).a();
    localObject = ((bdve)localObject).a(this, paramInt1, paramInt2, paramBoolean1);
    if (((bdvh)localObject).a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("GeneralSettingActivity", 2, "changeMode switchingStatus.isSwitching : true , mode : " + ((bdvh)localObject).a());
      }
      if (paramBoolean2)
      {
        a(paramInt2, true);
        this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(false);
        this.jdField_a_of_type_Aexr.a(false);
      }
      ModeRadioGroup localModeRadioGroup = this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup;
      paramInt1 = ((bdvh)localObject).a();
      if (!paramBoolean2) {}
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        localModeRadioGroup.a(paramInt1, false, paramBoolean1);
        if (bool) {
          QQToast.a(BaseApplication.getContext(), 0, 2131718614, 0).a();
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("GeneralSettingActivity", 2, "changeMode switchingStatus.isSwitching : false , mode : " + ((bdvh)localObject).b());
    }
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(((bdvh)localObject).b(), false, false);
  }
  
  public void a(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton.setOnCheckedChangeListener(null);
    paramCompoundButton.setChecked(paramBoolean);
    paramCompoundButton.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
  }
  
  protected void a(String paramString)
  {
    e(2131718608, 1);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(2, false, false);
    a(false, bdfk.c());
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
      this.jdField_a_of_type_Aexr.a(true);
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
      a(paramBoolean, bdfk.c());
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
    bduv.b("SETTING", this.app);
    a(this.jdField_a_of_type_Bdud.a());
    return;
    label209:
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt2, false, false);
    if (paramInt2 == 1) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      a(paramBoolean, bdfk.c());
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
          a(getString(2131718611, new Object[] { anvx.a(2131704721) }), 2);
        }
        a(false, this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem);
        a(bdfk.b(), bdfk.c());
        if (paramBoolean1) {
          QZoneDistributedAppCtrl.killQZoneProcess();
        }
        return;
      }
      a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a(), bdfk.b());
      if (paramBoolean2)
      {
        localObject = anvx.a(2131704719);
        str = getString(2131718610, new Object[] { localObject });
        if (1 != paramInt) {
          break label239;
        }
        localObject = anvx.a(2131704716) + (String)localObject + anvx.a(2131704717);
      }
    }
    for (;;)
    {
      a((String)localObject, 1);
      break;
      localObject = anvx.a(2131704720);
      break label159;
      label239:
      if (6 == paramInt)
      {
        localObject = str + anvx.a(2131704715);
        continue;
        if (paramBoolean1) {
          break;
        }
        e(2131718608, 1);
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
    this.jdField_c_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.setChecked(behh.c());
  }
  
  protected void b(int paramInt)
  {
    int j = 1;
    int i;
    if (paramInt == 1)
    {
      boolean bool = ThemeUtil.isNowThemeIsNight(this.app, false, null);
      i = bdfk.c();
      if (j == 0) {
        break label101;
      }
      if (!bool) {
        break label72;
      }
      i = bdfk.c;
    }
    label72:
    label101:
    for (;;)
    {
      if (j != 0)
      {
        if (!behh.a(this, bdfk.a(i), new aecb(this, paramInt, i))) {
          f(paramInt, i);
        }
        return;
        j = 0;
        break;
        if (!ThemeUtil.isNowThemeIsNight(this.app, false, bdfk.a(i))) {
          break label101;
        }
        i = bdfk.d();
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
    this.jdField_a_of_type_Aexr.a(false);
  }
  
  public void c(int paramInt)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      e(2131694305, 1);
      QQToast.a(BaseApplication.getContext(), 1, 2131694305, 0).b(getTitleBarHeight());
    }
    while (a()) {
      return;
    }
    if (bdvn.b()) {
      a(1, paramInt, false, true);
    }
    for (;;)
    {
      bdla.b(this.app, "dc00898", "", "", "0X800A3D6", "0X800A3D6", paramInt + 1, 0, "0", "0", "", "");
      return;
      if (!((bdfe)this.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqWidgetFormSwitchSimpleItem.a().isChecked(), paramInt, false)) {
        e(2131718614, 0);
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
    this.jdField_a_of_type_Aexr.a(true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(true);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt2, false, false);
    this.jdField_a_of_type_ComTencentMobileqqStudymodeModeRadioGroup.a(paramInt1);
    if (paramInt2 == 1) {}
    for (;;)
    {
      a(bool, bdfk.c());
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
    this.jdField_a_of_type_Aexr.a(false);
    if (paramInt2 == 1) {}
    for (;;)
    {
      a(bool, bdfk.c());
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
      ((bdfe)this.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER)).b();
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
    super.setContentView(2131561490);
    if (!this.app.isLogin())
    {
      paramBundle = new Intent();
      paramBundle.setClass(this, LoginActivity.class);
      paramBundle.addFlags(262144);
      startActivity(paramBundle);
      super.finish();
      return false;
    }
    super.setTitle(2131698805);
    this.jdField_a_of_type_JavaLangString = this.app.getCurrentAccountUin();
    super.setVolumeControlStream(3);
    addObserver(this.jdField_a_of_type_Bduf);
    this.app.registObserver(this.jdField_a_of_type_Bdut);
    addObserver(this.jdField_a_of_type_Aodj);
    this.jdField_a_of_type_Bdud = ((bdud)this.app.getBusinessHandler(BusinessHandlerFactory.TEENS_MODE_ALPHABETIC_FONT_HANDLER));
    this.jdField_a_of_type_Bdue = new bdue();
    this.jdField_a_of_type_Bdfe = ((bdfe)this.app.getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER));
    f();
    c();
    return true;
  }
  
  public void doOnDestroy()
  {
    if ((this.jdField_a_of_type_Bisl != null) && (this.jdField_a_of_type_Bisl.isShowing())) {
      super.dismissDialog(1);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(null);
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing()) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.cancel();
      }
    }
    if (this.jdField_a_of_type_Aexr != null) {
      this.jdField_a_of_type_Aexr.b();
    }
    if (this.jdField_a_of_type_Bdfe != null) {
      this.jdField_a_of_type_Bdfe.onDestroy();
    }
    super.doOnDestroy();
    Object localObject = a();
    if (localObject != null) {
      ((TopGestureLayout)localObject).setInterceptTouchEventListener(null);
    }
    localObject = (bdve)this.app.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER);
    ((bdve)localObject).b(this);
    ((bdve)localObject).a();
    removeObserver(this.jdField_a_of_type_Bduf);
    this.app.unRegistObserver(this.jdField_a_of_type_Bdut);
    removeObserver(this.jdField_a_of_type_Aodj);
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
    agij.b(this, QQSettingSettingActivity.class);
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
    this.jdField_a_of_type_Bisl = null;
    this.jdField_a_of_type_Bisl = new bisl(this, super.getTitleBarHeight());
    this.jdField_a_of_type_Bisl.a(getString(2131690828));
    this.jdField_a_of_type_Bisl.c(true);
    this.jdField_a_of_type_Bisl.a(false);
    this.jdField_a_of_type_Bisl.b(true);
    return this.jdField_a_of_type_Bisl;
  }
  
  public void onFileDownloaded(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.i("GeneralSettingActivity", 2, String.format("%s urldrawable onFileDownloaded", new Object[] { "SimpleUILog" }));
    }
    h();
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
    h();
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
    return super.getString(2131694721);
  }
  
  public boolean showPreview()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      super.getWindow().addFlags(67108864);
    }
    return super.showPreview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GeneralSettingActivity
 * JD-Core Version:    0.7.0.1
 */