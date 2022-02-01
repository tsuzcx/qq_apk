package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.homework.entry.ui.PublishHomeWorkFragment;
import com.tencent.qphone.base.util.QLog;

public class HomeWorkTroopPublishAction
  extends JumpActionBase
{
  public HomeWorkTroopPublishAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = a(b("gc"));
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("HomeWorkTroopPublishAction", 1, "doAction error: " + localException.getMessage());
      a("HomeWorkTroopPublishAction");
    }
    return false;
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((this.a instanceof Activity))
    {
      PublishHomeWorkFragment.a((Activity)this.a, null, paramString);
      ((Activity)this.a).overridePendingTransition(2130772314, 2130771992);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.HomeWorkTroopPublishAction
 * JD-Core Version:    0.7.0.1
 */