package com.tencent.mobileqq.activity.aio.rebuild.input.edittext;

import android.text.Editable;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback;
import com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpContext;
import com.tencent.qidian.QidianManager;

public class QidianTextChangeCallback
  implements IEditTextChangeCallback
{
  public void a(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean a(AIOContext paramAIOContext, Editable paramEditable)
  {
    if (((paramAIOContext instanceof BusinessCmrTmpContext)) && (!QidianManager.a(paramAIOContext.a(), paramAIOContext.a().a))) {
      ((BusinessCmrTmpContext)paramAIOContext).a(paramEditable);
    }
    return false;
  }
  
  public void b(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.edittext.QidianTextChangeCallback
 * JD-Core Version:    0.7.0.1
 */