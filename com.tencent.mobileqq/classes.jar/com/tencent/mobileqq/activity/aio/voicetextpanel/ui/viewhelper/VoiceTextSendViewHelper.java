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
  private Button e;
  private Button f;
  private CheckBox g;
  private SharedPreferences h;
  private CompoundButton.OnCheckedChangeListener i = new VoiceTextSendViewHelper.1(this);
  
  public VoiceTextSendViewHelper(VoiceTextStateModel paramVoiceTextStateModel, AppRuntime paramAppRuntime, SharedPreferences paramSharedPreferences)
  {
    super(paramAppRuntime, paramVoiceTextStateModel);
    this.h = paramSharedPreferences;
  }
  
  private void b(boolean paramBoolean)
  {
    e().d(paramBoolean);
    this.g.setEnabled(paramBoolean);
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.h;
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("businessinfo_ptt_vt_send_type_");
      localStringBuilder.append(this.a.getCurrentAccountUin());
      ((SharedPreferences.Editor)localObject).putBoolean(localStringBuilder.toString(), paramBoolean).commit();
    }
  }
  
  private void i()
  {
    if (e().a())
    {
      ReportUtils.a("0X800A1D8", 2, 0);
      return;
    }
    ReportUtils.a("0X800A1D8", 1, 0);
  }
  
  private void j()
  {
    if (e().a())
    {
      ReportUtils.a("0X800A1D9", 2, 0);
      return;
    }
    ReportUtils.a("0X800A1D9", 1, 0);
  }
  
  private boolean k()
  {
    SharedPreferences localSharedPreferences = this.h;
    if (localSharedPreferences != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("businessinfo_ptt_vt_send_type_");
      localStringBuilder.append(this.a.getCurrentAccountUin());
      return localSharedPreferences.getBoolean(localStringBuilder.toString(), false);
    }
    return false;
  }
  
  private void l()
  {
    if (QQTheme.isNowThemeIsNight()) {
      this.f.setTextColor(this.b.getResources().getColor(2131168041));
    }
  }
  
  private void m()
  {
    View localView = (View)this.g.getParent();
    localView.post(new VoiceTextSendViewHelper.4(this, ScreenUtil.dip2px(8.0F), localView));
  }
  
  public void a()
  {
    b(false);
    this.e.setText(2131916268);
  }
  
  public void a(VoiceTextPanel paramVoiceTextPanel)
  {
    super.a(paramVoiceTextPanel);
    this.e = ((Button)paramVoiceTextPanel.findViewById(2131445568));
    this.f = ((Button)paramVoiceTextPanel.findViewById(2131430272));
    this.f.setOnClickListener(new VoiceTextSendViewHelper.2(this));
    this.e.setOnClickListener(new VoiceTextSendViewHelper.3(this));
    this.g = ((CheckBox)paramVoiceTextPanel.findViewById(2131430688));
    this.g.setOnCheckedChangeListener(this.i);
    m();
    l();
  }
  
  public void a(boolean paramBoolean)
  {
    this.e.setEnabled(paramBoolean);
  }
  
  public void f()
  {
    boolean bool = k();
    b(true);
    if (bool)
    {
      this.g.setChecked(true);
      e().c(true);
      this.e.setText(2131916270);
      a(true);
      return;
    }
    this.g.setChecked(false);
    e().c(false);
    this.e.setText(2131916268);
    a(false);
  }
  
  public boolean g()
  {
    return this.e.isEnabled();
  }
  
  public void h()
  {
    a(true);
    this.g.setChecked(true);
    e().c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextSendViewHelper
 * JD-Core Version:    0.7.0.1
 */