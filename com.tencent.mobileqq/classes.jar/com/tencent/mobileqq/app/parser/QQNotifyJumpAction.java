package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.activateFriend.QQReminderJumpFragment;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QQNotifyJumpAction
  extends JumpAction
{
  protected QQNotifyJumpAction(BaseQQAppInterface paramBaseQQAppInterface, Context paramContext)
  {
    super(paramBaseQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      if (this.f.containsKey("msgid"))
      {
        String str = (String)this.f.get("msgid");
        QQReminderJumpFragment.a(this.b, str);
      }
      return false;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("QQNotifyJumpAction", 1, localStringBuilder.toString());
      h_("QQNotifyJumpAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQNotifyJumpAction
 * JD-Core Version:    0.7.0.1
 */