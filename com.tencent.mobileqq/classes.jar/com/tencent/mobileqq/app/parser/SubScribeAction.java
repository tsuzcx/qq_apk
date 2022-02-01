package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class SubScribeAction
  extends JumpActionBase
{
  public SubScribeAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      SubscribeLaucher.a(this.jdField_a_of_type_AndroidContentContext, this.c, this.jdField_a_of_type_JavaUtilHashMap);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("SubScribeAction", 1, "doAction error: " + localException.getMessage());
      a("SubScribeAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.SubScribeAction
 * JD-Core Version:    0.7.0.1
 */