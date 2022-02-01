package com.tencent.mobileqq.activity.aio.rebuild.input.edittext;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback;
import com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper;

public class FullScreenTextChangeCallback
  implements IEditTextChangeCallback
{
  public void a(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    ((FullScreenInputHelper)paramAIOContext.a(24)).a(paramCharSequence, paramInt1, paramInt2, paramInt3);
  }
  
  public boolean a(AIOContext paramAIOContext, Editable paramEditable)
  {
    return ((FullScreenInputHelper)paramAIOContext.a(24)).a(paramEditable);
  }
  
  public void b(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.edittext.FullScreenTextChangeCallback
 * JD-Core Version:    0.7.0.1
 */