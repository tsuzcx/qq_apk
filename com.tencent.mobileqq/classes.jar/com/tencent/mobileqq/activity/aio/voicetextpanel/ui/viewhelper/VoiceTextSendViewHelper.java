package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextUIState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.utils.ReportUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.QQTheme;
import mqq.app.AppRuntime;

public class VoiceTextSendViewHelper
  extends VoiceTextBaseViewHelpr
{
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  private CompoundButton.OnCheckedChangeListener jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener = new VoiceTextSendViewHelper.1(this);
  private Button b;
  
  public VoiceTextSendViewHelper(VoiceTextStateModel paramVoiceTextStateModel, AppRuntime paramAppRuntime, SharedPreferences paramSharedPreferences)
  {
    super(paramAppRuntime, paramVoiceTextStateModel);
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramSharedPreferences;
  }
  
  private void b(boolean paramBoolean)
  {
    a().d(paramBoolean);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(paramBoolean);
  }
  
  private boolean b()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("businessinfo_ptt_vt_send_type_");
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
    }
    return false;
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_AndroidContentSharedPreferences;
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("businessinfo_ptt_vt_send_type_");
      localStringBuilder.append(this.jdField_a_of_type_MqqAppAppRuntime.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).commit();
    }
  }
  
  private void e()
  {
    if (a().a())
    {
      ReportUtils.a("0X800A1D8", 2, 0);
      return;
    }
    ReportUtils.a("0X800A1D8", 1, 0);
  }
  
  private void f()
  {
    if (a().a())
    {
      ReportUtils.a("0X800A1D9", 2, 0);
      return;
    }
    ReportUtils.a("0X800A1D9", 1, 0);
  }
  
  private void g()
  {
    if (QQTheme.a()) {
      this.b.setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131167089));
    }
  }
  
  private void h()
  {
    View localView = (View)this.jdField_a_of_type_AndroidWidgetCheckBox.getParent();
    localView.post(new VoiceTextSendViewHelper.4(this, ScreenUtil.dip2px(8.0F), localView));
  }
  
  public void a()
  {
    b(false);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131718762);
  }
  
  public void a(VoiceTextPanel paramVoiceTextPanel)
  {
    super.a(paramVoiceTextPanel);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)paramVoiceTextPanel.findViewById(2131377187));
    this.b = ((Button)paramVoiceTextPanel.findViewById(2131364259));
    this.b.setOnClickListener(new VoiceTextSendViewHelper.2(this));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new VoiceTextSendViewHelper.3(this));
    this.jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)paramVoiceTextPanel.findViewById(2131364613));
    this.jdField_a_of_type_AndroidWidgetCheckBox.setOnCheckedChangeListener(this.jdField_a_of_type_AndroidWidgetCompoundButton$OnCheckedChangeListener);
    h();
    g();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_AndroidWidgetButton.isEnabled();
  }
  
  public void c()
  {
    boolean bool = b();
    b(true);
    if (bool)
    {
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
      a().c(true);
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131718764);
      a(true);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    a().c(false);
    this.jdField_a_of_type_AndroidWidgetButton.setText(2131718762);
    a(false);
  }
  
  public void d()
  {
    a(true);
    this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(true);
    a().c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSendViewHelper
 * JD-Core Version:    0.7.0.1
 */