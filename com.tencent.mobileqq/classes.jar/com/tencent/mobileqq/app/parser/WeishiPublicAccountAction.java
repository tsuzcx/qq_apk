package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class WeishiPublicAccountAction
  extends JumpActionBase
{
  public WeishiPublicAccountAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      ((IWSManager)QRoute.api(IWSManager.class)).enterWSPublicAccount(this.a, "from_search_rzh_ws", false);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("WeishiPublicAccountAction", 1, "doAction error: " + localException.getMessage());
      a("WeishiPublicAccountAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.WeishiPublicAccountAction
 * JD-Core Version:    0.7.0.1
 */