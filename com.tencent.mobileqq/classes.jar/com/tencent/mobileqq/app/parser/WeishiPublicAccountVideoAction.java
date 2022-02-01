package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class WeishiPublicAccountVideoAction
  extends JumpAction
{
  public WeishiPublicAccountVideoAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    boolean bool = false;
    try
    {
      if ("openPlayer".equals(this.jdField_a_of_type_JavaUtilHashMap.get("action"))) {
        bool = ((IWSManager)QRoute.api(IWSManager.class)).enterWSVerticalPlayerPageForMiniApp(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
      }
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("WeishiPublicAccountVideoAction", 1, localStringBuilder.toString());
      b_("WeishiPublicAccountVideoAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.WeishiPublicAccountVideoAction
 * JD-Core Version:    0.7.0.1
 */