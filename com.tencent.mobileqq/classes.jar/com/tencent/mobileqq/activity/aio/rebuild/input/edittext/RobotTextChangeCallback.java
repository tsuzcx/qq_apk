package com.tencent.mobileqq.activity.aio.rebuild.input.edittext;

import android.os.Bundle;
import android.text.Editable;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.input.AIOInput;
import com.tencent.mobileqq.activity.aio.coreui.input.EditTextUI;
import com.tencent.mobileqq.activity.aio.coreui.input.IEditTextChangeCallback;
import com.tencent.mobileqq.activity.aio.coreui.input.InputUIContainer;
import com.tencent.mobileqq.activity.aio.helper.RobotChatUIHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper;
import com.tencent.mobileqq.activity.aio.rebuild.input.shortcutbar.AIOShortcutBarHelper.AIOShortcutBarEvent;
import com.tencent.qphone.base.util.QLog;

public class RobotTextChangeCallback
  implements IEditTextChangeCallback
{
  public void a(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public boolean a(AIOContext paramAIOContext, Editable paramEditable)
  {
    boolean bool;
    if (paramEditable.length() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramAIOContext = (RobotChatUIHelper)paramAIOContext.a(36);
    if ((paramAIOContext != null) && (paramAIOContext.e())) {
      paramAIOContext.g_(bool);
    }
    return false;
  }
  
  public void b(AIOContext paramAIOContext, CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramCharSequence = (AIOShortcutBarHelper)paramAIOContext.a(52);
    if (paramAIOContext.O().a == 1043)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" onTextChanged:  start=");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(" before=");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(" count=");
        ((StringBuilder)localObject).append(paramInt3);
        QLog.d("RobotTextChangeCallback", 2, ((StringBuilder)localObject).toString());
      }
      if (paramCharSequence != null)
      {
        localObject = new AIOShortcutBarHelper.AIOShortcutBarEvent(23);
        ((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject).a().putBoolean("isRobot", true);
        ((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject).a().putInt("nInputLineCount", paramAIOContext.p().d().f().h());
        paramCharSequence.a((AIOShortcutBarHelper.AIOShortcutBarEvent)localObject);
      }
    }
    else if (paramAIOContext.O().a == 1)
    {
      paramAIOContext = paramAIOContext.O();
      if ((!paramAIOContext.z) && (paramAIOContext.b != null) && (paramAIOContext.b.length() != 0))
      {
        paramAIOContext = new AIOShortcutBarHelper.AIOShortcutBarEvent(23);
        paramAIOContext.a().putBoolean("isTroop", true);
        paramCharSequence.a(paramAIOContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.input.edittext.RobotTextChangeCallback
 * JD-Core Version:    0.7.0.1
 */