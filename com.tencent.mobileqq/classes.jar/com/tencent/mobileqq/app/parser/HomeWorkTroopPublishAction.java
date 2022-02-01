package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;

public class HomeWorkTroopPublishAction
  extends JumpAction
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("HomeWorkTroopPublishAction", 1, localStringBuilder.toString());
      h_("HomeWorkTroopPublishAction");
    }
    return false;
  }
  
  protected boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((this.b instanceof Activity))
    {
      ((IHWTroopUIApi)QRoute.api(IHWTroopUIApi.class)).startPublishHomeWorkFragment((Activity)this.b, null, paramString);
      ((Activity)this.b).overridePendingTransition(2130772434, 2130772007);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.HomeWorkTroopPublishAction
 * JD-Core Version:    0.7.0.1
 */