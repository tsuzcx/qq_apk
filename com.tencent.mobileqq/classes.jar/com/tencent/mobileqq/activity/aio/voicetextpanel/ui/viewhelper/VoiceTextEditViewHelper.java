package com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.anim.VoiceTextShowAnimator;
import com.tencent.mobileqq.activity.aio.voicetextpanel.anim.VoiceTextShowAnimator.LoadingTextListner;
import com.tencent.mobileqq.activity.aio.voicetextpanel.listeners.VoiceTextUserOpListener;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextInfoState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextStateModel;
import com.tencent.mobileqq.activity.aio.voicetextpanel.model.VoiceTextSttState;
import com.tencent.mobileqq.activity.aio.voicetextpanel.ui.VoiceTextPanel;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

public class VoiceTextEditViewHelper
  extends VoiceTextBaseViewHelpr
  implements View.OnClickListener, VoiceTextShowAnimator.LoadingTextListner
{
  TextView.OnEditorActionListener e = new VoiceTextEditViewHelper.2(this);
  private Handler f;
  private EditText g;
  private VoiceTextShowAnimator h;
  private TextWatcher i = new VoiceTextEditViewHelper.1(this);
  
  public VoiceTextEditViewHelper(VoiceTextStateModel paramVoiceTextStateModel, AppRuntime paramAppRuntime, Handler paramHandler)
  {
    super(paramAppRuntime, paramVoiceTextStateModel);
    this.f = paramHandler;
    this.h = new VoiceTextShowAnimator();
  }
  
  private void m()
  {
    SpannableString localSpannableString;
    if (d().a())
    {
      localSpannableString = this.h.c();
      this.g.setText(localSpannableString);
      return;
    }
    if (d().b())
    {
      localSpannableString = this.h.b(c().b());
      this.g.setText(localSpannableString);
      this.g.setSelection(this.h.d(), this.h.d());
      return;
    }
    if (d().c()) {
      o();
    }
  }
  
  private void n()
  {
    if (QQTheme.isNowThemeIsNight())
    {
      this.g.setTextColor(Color.parseColor("#777777"));
      return;
    }
    this.g.setTextColor(Color.parseColor("#03081a"));
  }
  
  private void o()
  {
    Object localObject = c().b();
    if (StringUtil.isEmpty((String)localObject))
    {
      this.g.setText("");
      d().a(5);
      this.g.setFocusableInTouchMode(true);
      this.h.b();
      QQToast.makeText(this.b, HardCodeUtil.a(2131913772), 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
      return;
    }
    if (this.h.a((String)localObject))
    {
      n();
      this.g.setText((CharSequence)localObject);
      this.h.b();
      this.g.setFocusableInTouchMode(true);
      d().a(5);
      this.g.setSelection(((String)localObject).length(), ((String)localObject).length());
      return;
    }
    localObject = this.h.b((String)localObject);
    this.g.setText((CharSequence)localObject);
    this.g.setSelection(this.h.d(), this.h.d());
  }
  
  public void a()
  {
    this.f.post(new VoiceTextEditViewHelper.3(this));
  }
  
  public void a(VoiceTextUserOpListener paramVoiceTextUserOpListener)
  {
    super.a(paramVoiceTextUserOpListener);
    this.h.a(this.a, this.b.getResources().getColorStateList(2131168122), this);
  }
  
  public void a(VoiceTextPanel paramVoiceTextPanel)
  {
    super.a(paramVoiceTextPanel);
    this.g = ((EditText)paramVoiceTextPanel.findViewById(2131432302));
    this.g.setHorizontallyScrolling(false);
    this.g.setLines(100);
    this.g.setOnClickListener(this);
    this.g.setOnEditorActionListener(this.e);
    this.g.addTextChangedListener(this.i);
  }
  
  public void a(String paramString)
  {
    this.g.setText(paramString);
  }
  
  public void f()
  {
    this.g.setEnabled(true);
    this.g.setFocusableInTouchMode(false);
  }
  
  public void g()
  {
    this.g.setText("");
  }
  
  public EditText h()
  {
    return this.g;
  }
  
  public void i()
  {
    this.g.setFocusable(true);
    this.g.setFocusableInTouchMode(true);
    this.g.requestFocus();
  }
  
  public void j()
  {
    this.g.setText("");
    this.g.setFocusableInTouchMode(true);
  }
  
  public void k()
  {
    this.h.a();
  }
  
  public void l()
  {
    this.h.b();
  }
  
  public void onClick(View paramView)
  {
    if ((d().a()) || (d().b())) {
      QQToast.makeText(this.b, HardCodeUtil.a(2131913778), 0).show(this.b.getResources().getDimensionPixelSize(2131299920));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextEditViewHelper
 * JD-Core Version:    0.7.0.1
 */