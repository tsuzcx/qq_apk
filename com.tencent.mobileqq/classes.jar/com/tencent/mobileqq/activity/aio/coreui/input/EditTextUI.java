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
  XEditTextEx.OnPrivateIMECommandListener a;
  private final AIOContext b;
  private final XEditTextEx c;
  private boolean d = false;
  
  public EditTextUI(AIOContext paramAIOContext, XEditTextEx paramXEditTextEx)
  {
    this.b = paramAIOContext;
    this.c = paramXEditTextEx;
  }
  
  private void y() {}
  
  public Bundle a(boolean paramBoolean)
  {
    return this.c.getInputExtras(paramBoolean);
  }
  
  public Editable a()
  {
    return this.c.getText();
  }
  
  public void a(int paramInt)
  {
    this.c.setVisibility(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c.setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(int paramInt, Object paramObject)
  {
    this.c.setTag(paramInt, paramObject);
  }
  
  public void a(long paramLong)
  {
    if (this.b.k() == 1)
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)this.b.b().getSystemService("input_method");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("current panel:");
        localStringBuilder.append(this.b.k());
        localStringBuilder.append(", imm active input :");
        localStringBuilder.append(localInputMethodManager.isActive(this.c));
        QLog.d("EditTextUI", 2, localStringBuilder.toString());
      }
      if ((!localInputMethodManager.isActive(this.c)) && (NetConnInfoCenter.getServerTime() - paramLong < 2L) && (!this.d))
      {
        QLog.d("EditTextUI", 1, "input requestFocus");
        this.d = true;
        this.c.requestFocus();
      }
    }
  }
  
  public void a(@Nullable Drawable paramDrawable1, @Nullable Drawable paramDrawable2, @Nullable Drawable paramDrawable3, @Nullable Drawable paramDrawable4)
  {
    this.c.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public final void a(Editable.Factory paramFactory)
  {
    this.c.setEditableFactory(paramFactory);
  }
  
  public final void a(MovementMethod paramMovementMethod)
  {
    this.c.setMovementMethod(paramMovementMethod);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    y();
    this.c.setText(paramCharSequence);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.b.p().c().j().iterator();
    while ((localIterator.hasNext()) && (!((IEditTextChangeCallback)localIterator.next()).a(this.b, paramEditable))) {}
    this.b.p().b().a(paramEditable);
    if (QLog.isColorLevel())
    {
      paramEditable = new StringBuilder();
      paramEditable.append(" afterTextChanged cost: ");
      paramEditable.append(System.currentTimeMillis() - l);
      QLog.d("EditTextUI", 2, paramEditable.toString());
    }
  }
  
  @Deprecated
  public final XEditTextEx b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.c.setCompoundDrawablePadding(paramInt);
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    y();
    this.c.append(paramCharSequence);
  }
  
  public void b(boolean paramBoolean)
  {
    this.c.setEnabled(paramBoolean);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.b.p().c().j().iterator();
    while (localIterator.hasNext()) {
      ((IEditTextChangeCallback)localIterator.next()).a(this.b, paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
    if (QLog.isColorLevel())
    {
      paramCharSequence = new StringBuilder();
      paramCharSequence.append(" beforeTextChanged cost: ");
      paramCharSequence.append(System.currentTimeMillis() - l);
      QLog.d("EditTextUI", 2, paramCharSequence.toString());
    }
  }
  
  public Editable c()
  {
    y();
    return this.c.getEditableText();
  }
  
  public Object c(int paramInt)
  {
    return this.c.getTag(paramInt);
  }
  
  public int d()
  {
    return this.c.getPaddingRight();
  }
  
  public void d(int paramInt)
  {
    this.c.setSelection(paramInt);
  }
  
  public int e()
  {
    return this.c.getPaddingLeft();
  }
  
  public int f()
  {
    return this.c.getPaddingTop();
  }
  
  public int g()
  {
    return this.c.getPaddingBottom();
  }
  
  public int h()
  {
    return this.c.getLineCount();
  }
  
  public Object i()
  {
    return this.c.a;
  }
  
  public int j()
  {
    return this.c.getSelectionStart();
  }
  
  public final int k()
  {
    return this.c.getWidth();
  }
  
  public TextPaint l()
  {
    return this.c.getPaint();
  }
  
  public final MovementMethod m()
  {
    return this.c.getMovementMethod();
  }
  
  public final boolean n()
  {
    return this.c.requestFocus();
  }
  
  public Typeface o()
  {
    return this.c.getTypeface();
  }
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EditTextUI", 2, "onClick case R.id.input");
    }
    this.b.q().a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    long l = System.currentTimeMillis();
    Iterator localIterator = this.b.p().c().j().iterator();
    while (localIterator.hasNext()) {
      ((IEditTextChangeCallback)localIterator.next()).b(this.b, paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
    if (QLog.isColorLevel())
    {
      paramCharSequence = new StringBuilder();
      paramCharSequence.append(" onTextChanged cost: ");
      paramCharSequence.append(System.currentTimeMillis() - l);
      QLog.d("EditTextUI", 2, paramCharSequence.toString());
    }
  }
  
  public float p()
  {
    return this.c.getTextSize();
  }
  
  public final int q()
  {
    return this.c.getMeasuredWidth();
  }
  
  public final void r()
  {
    this.c.setOnClickListener(this);
  }
  
  public final void s()
  {
    this.c.setOnClickListener(null);
  }
  
  public void t()
  {
    if (this.a == null) {
      this.a = new IMECommandListener(this.b);
    }
    this.c.setOnPrivateIMECommandListener(this.a);
  }
  
  public void u()
  {
    this.c.setOnPrivateIMECommandListener(null);
  }
  
  public void v()
  {
    this.c.addTextChangedListener(this);
  }
  
  public void w()
  {
    this.c.removeTextChangedListener(this);
  }
  
  public void x()
  {
    this.c.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI
 * JD-Core Version:    0.7.0.1
 */