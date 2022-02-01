package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.activity.activateFriend.QQNotifySettingFragment;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class QQNotifySettingAction
  extends JumpAction
{
  public QQNotifySettingAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      if ((this.f.containsKey("scheme")) && (this.f.containsKey("msgid")) && (this.f.containsKey("busiid")))
      {
        localObject = (String)this.f.get("msgid");
        String str2 = (String)this.f.get("busiid");
        String str3 = (String)this.f.get("scheme");
        String str1 = "";
        if (this.f.containsKey("domain")) {
          str1 = (String)this.f.get("domain");
        }
        QQNotifySettingFragment.a(this.b, (String)localObject, str2, str3, str1);
      }
      return false;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doAction error: ");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("QQNotifySettingAction", 1, ((StringBuilder)localObject).toString());
      h_("QQNotifySettingAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQNotifySettingAction
 * JD-Core Version:    0.7.0.1
 */