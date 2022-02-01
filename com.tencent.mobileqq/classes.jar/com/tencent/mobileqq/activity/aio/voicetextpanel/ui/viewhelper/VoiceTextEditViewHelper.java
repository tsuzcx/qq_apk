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
  private Handler jdField_a_of_type_AndroidOsHandler;
  private TextWatcher jdField_a_of_type_AndroidTextTextWatcher = new VoiceTextEditViewHelper.1(this);
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  TextView.OnEditorActionListener jdField_a_of_type_AndroidWidgetTextView$OnEditorActionListener = new VoiceTextEditViewHelper.2(this);
  private VoiceTextShowAnimator jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator;
  
  public VoiceTextEditViewHelper(VoiceTextStateModel paramVoiceTextStateModel, AppRuntime paramAppRuntime, Handler paramHandler)
  {
    super(paramAppRuntime, paramVoiceTextStateModel);
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator = new VoiceTextShowAnimator();
  }
  
  private void i()
  {
    SpannableString localSpannableString;
    if (a().a())
    {
      localSpannableString = this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator.a();
      this.jdField_a_of_type_AndroidWidgetEditText.setText(localSpannableString);
      return;
    }
    if (a().b())
    {
      localSpannableString = this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator.a(a().b());
      this.jdField_a_of_type_AndroidWidgetEditText.setText(localSpannableString);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator.a());
      return;
    }
    if (a().c()) {
      k();
    }
  }
  
  private void j()
  {
    if (QQTheme.a())
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(Color.parseColor("#777777"));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setTextColor(Color.parseColor("#03081a"));
  }
  
  private void k()
  {
    Object localObject = a().b();
    if (StringUtil.a((String)localObject))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      a().a(5);
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator.b();
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131716330), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator.a((String)localObject))
    {
      j();
      this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator.b();
      this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
      a().a(5);
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(((String)localObject).length(), ((String)localObject).length());
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator.a((String)localObject);
    this.jdField_a_of_type_AndroidWidgetEditText.setText((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator.a());
  }
  
  public EditText a()
  {
    return this.jdField_a_of_type_AndroidWidgetEditText;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new VoiceTextEditViewHelper.3(this));
  }
  
  public void a(VoiceTextUserOpListener paramVoiceTextUserOpListener)
  {
    super.a(paramVoiceTextUserOpListener);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator.a(this.jdField_a_of_type_MqqAppAppRuntime, this.jdField_a_of_type_AndroidContentContext.getResources().getColorStateList(2131167142), this);
  }
  
  public void a(VoiceTextPanel paramVoiceTextPanel)
  {
    super.a(paramVoiceTextPanel);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)paramVoiceTextPanel.findViewById(2131366027));
    this.jdField_a_of_type_AndroidWidgetEditText.setHorizontallyScrolling(false);
    this.jdField_a_of_type_AndroidWidgetEditText.setLines(100);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetEditText.setOnEditorActionListener(this.jdField_a_of_type_AndroidWidgetTextView$OnEditorActionListener);
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(this.jdField_a_of_type_AndroidTextTextWatcher);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText(paramString);
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setEnabled(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(false);
  }
  
  public void d()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
  }
  
  public void f()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator.a();
  }
  
  public void h()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioVoicetextpanelAnimVoiceTextShowAnimator.b();
  }
  
  public void onClick(View paramView)
  {
    if ((a().a()) || (a().b())) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, HardCodeUtil.a(2131716336), 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131299168));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.voicetextpanel.ui.viewhelper.VoiceTextEditViewHelper
 * JD-Core Version:    0.7.0.1
 */