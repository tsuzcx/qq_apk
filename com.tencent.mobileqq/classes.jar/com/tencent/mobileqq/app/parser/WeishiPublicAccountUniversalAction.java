package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class WeishiPublicAccountUniversalAction
  extends JumpAction
{
  private Object a;
  
  public WeishiPublicAccountUniversalAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public WeishiPublicAccountUniversalAction(QQAppInterface paramQQAppInterface, Context paramContext, Object paramObject)
  {
    this(paramQQAppInterface, paramContext);
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = ((IWSManager)QRoute.api(IWSManager.class)).doJumpAction((String)this.jdField_a_of_type_JavaUtilHashMap.get("action"), this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_JavaLangObject);
      return bool;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doAction error: ");
      localStringBuilder.append(localException.getMessage());
      QLog.e("WeishiPublicAccountUniversalAction", 1, localStringBuilder.toString());
      b_("WeishiPublicAccountUniversalAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.WeishiPublicAccountUniversalAction
 * JD-Core Version:    0.7.0.1
 */