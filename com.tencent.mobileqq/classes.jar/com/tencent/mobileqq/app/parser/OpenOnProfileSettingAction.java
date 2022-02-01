package com.tencent.mobileqq.app.parser;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilesetting.InterestSwitchEditActivity;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;

public class OpenOnProfileSettingAction
  extends JumpAction
{
  public OpenOnProfileSettingAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = b();
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("OpenOnProfileSettingAction", 1, localStringBuilder.toString());
      h_("OpenOnProfileSettingAction");
    }
    return false;
  }
  
  public boolean b()
  {
    Intent localIntent = new Intent(this.b, InterestSwitchEditActivity.class);
    localIntent.setFlags(67108864);
    this.b.startActivity(localIntent);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.OpenOnProfileSettingAction
 * JD-Core Version:    0.7.0.1
 */