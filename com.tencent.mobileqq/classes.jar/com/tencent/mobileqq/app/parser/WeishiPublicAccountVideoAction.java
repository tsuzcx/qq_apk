package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class WeishiPublicAccountVideoAction
  extends JumpActionBase
{
  public WeishiPublicAccountVideoAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      if ("openPlayer".equals(this.jdField_a_of_type_JavaUtilHashMap.get("action")))
      {
        boolean bool = ((IWSManager)QRoute.api(IWSManager.class)).enterWSVerticalPlayerPageForMiniApp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("WeishiPublicAccountVideoAction", 1, "doAction error: " + localException.getMessage());
      a("WeishiPublicAccountVideoAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.WeishiPublicAccountVideoAction
 * JD-Core Version:    0.7.0.1
 */