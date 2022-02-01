package com.tencent.mobileqq.activity.aio.coreui.input;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.core.AIOContext;

public abstract interface IEditTextChangeCallback
{
  public abstract void a(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean a(AIOContext paramAIOContext, Editable paramEditable);
  
  public abstract void b(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback
 * JD-Core Version:    0.7.0.1
 */