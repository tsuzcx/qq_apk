package com.tencent.mobileqq.activity.aio.coreui.input;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.core.input.MessageSignal;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.rebuild.input.IMECommandListener;
import com.tencent.mobileqq.activity.aio.rebuild.input.InputCallbackRegister;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XEditTextEx.OnPrivateIMECommandListener;
import java.util.Iterator;
import java.util.List;

public class EditTextUI
  implements TextWatcher, View.OnClickListener
{
  private final AIOContext jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext;
  XEditTextEx.OnPrivateIMECommandListener jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener;
  private final XEditTextEx jdField_a_of_type_ComTencentWidgetXEditTextEx;
  private boolean jdField_a_of_type_Boolean = false;
  
  public EditTextUI(AIOContext paramAIOContext, XEditTextEx paramXEditTextEx)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext = paramAIOContext;
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx = paramXEditTextEx;
  }
  
  private void h() {}
  
  public float a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTextSize();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingRight();
  }
  
  public Typeface a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTypeface();
  }
  
  public Bundle a(boolean paramBoolean)
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getInputExtras(paramBoolean);
  }
  
  public Editable a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText();
  }
  
  public TextPaint a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaint();
  }
  
  public final MovementMethod a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMovementMethod();
  }
  
  @Deprecated
  public final XEditTextEx a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.a;
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getTag(paramInt);
  }
  
  public final void a()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(this);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setVisibility(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(paramInt, paramObject);
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a() == 1)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().getSystemService("input_method");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("current panel:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a());
        localStringBuilder.append(", imm active input :");
        localStringBuilder.append(localInputMethodManager.isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx));
        QLog.d("EditTextUI", 2, localStringBuilder.toString());
      }
      if ((!localInputMethodManager.isActive(this.jdField_a_of_type_ComTencentWidgetXEditTextEx)) && (NetConnInfoCenter.getServerTime() - paramLong < 2L) && (!this.jdField_a_of_type_Boolean))
      {
        QLog.d("EditTextUI", 1, "input requestFocus");
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
      }
    }
  }
  
  public void a(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public final void a(Editable.Factory paramFactory)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEditableFactory(paramFactory);
  }
  
  public final void a(MovementMethod paramMovementMethod)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setMovementMethod(paramMovementMethod);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    h();
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setText(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setEnabled(paramBoolean);
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.requestFocus();
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().i().iterator();
    while ((localIterator.hasNext()) && (!((IEditTextChangeCallback)localIterator.next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramEditable))) {}
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().a(paramEditable);
    if (QLog.isColorLevel())
    {
      paramEditable = new StringBuilder();
      paramEditable.append(" afterTextChanged cost: ");
      paramEditable.append(System.currentTimeMillis() - l);
      QLog.d("EditTextUI", 2, paramEditable.toString());
    }
  }
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingLeft();
  }
  
  public Editable b()
  {
    h();
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText();
  }
  
  public final void b()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnClickListener(null);
  }
  
  public void b(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setCompoundDrawablePadding(paramInt);
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    h();
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.append(paramCharSequence);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().i().iterator();
    while (localIterator.hasNext()) {
      ((IEditTextChangeCallback)localIterator.next()).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
    if (QLog.isColorLevel())
    {
      paramCharSequence = new StringBuilder();
      paramCharSequence.append(" beforeTextChanged cost: ");
      paramCharSequence.append(System.currentTimeMillis() - l);
      QLog.d("EditTextUI", 2, paramCharSequence.toString());
    }
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingTop();
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener == null) {
      this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener = new IMECommandListener(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext);
    }
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnPrivateIMECommandListener(this.jdField_a_of_type_ComTencentWidgetXEditTextEx$OnPrivateIMECommandListener);
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setSelection(paramInt);
  }
  
  public int d()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getPaddingBottom();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.setOnPrivateIMECommandListener(null);
  }
  
  public int e()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getLineCount();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.addTextChangedListener(this);
  }
  
  public int f()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getSelectionStart();
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
  }
  
  public final int g()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getWidth();
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentWidgetXEditTextEx.a();
  }
  
  public final int h()
  {
    return this.jdField_a_of_type_ComTencentWidgetXEditTextEx.getMeasuredWidth();
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextUI", 2, "onClick case R.id.input");
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext.a().a().i().iterator();
    while (localIterator.hasNext()) {
      ((IEditTextChangeCallback)localIterator.next()).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreAIOContext, paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
    if (QLog.isColorLevel())
    {
      paramCharSequence = new StringBuilder();
      paramCharSequence.append(" onTextChanged cost: ");
      paramCharSequence.append(System.currentTimeMillis() - l);
      QLog.d("EditTextUI", 2, paramCharSequence.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI
 * JD-Core Version:    0.7.0.1
 */