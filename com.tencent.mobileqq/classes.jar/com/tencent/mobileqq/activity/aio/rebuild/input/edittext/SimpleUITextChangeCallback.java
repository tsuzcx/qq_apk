package com.tencent.mobileqq.activity.aio.rebuild.input.edittext;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.FunBtnUI;
import com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.SimpleUIAIOHelper;

public class SimpleUITextChangeCallback
  implements IEditTextChangeCallback
{
  public void a(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean a(AIOContext paramAIOContext, Editable paramEditable)
  {
    paramAIOContext.p().d().d().c();
    paramAIOContext = (SimpleUIAIOHelper)paramAIOContext.a(29);
    boolean bool;
    if (paramEditable.length() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramAIOContext.g_(bool);
    return false;
  }
  
  public void b(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.edittext.SimpleUITextChangeCallback
 * JD-Core Version:    0.7.0.1
 */