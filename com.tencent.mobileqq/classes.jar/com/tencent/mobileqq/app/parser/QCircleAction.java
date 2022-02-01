package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.activity.qcircle.utils.QCircleUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qcircle.api.IQCircleService;
import com.tencent.qphone.base.util.QLog;

public class QCircleAction
  extends JumpActionBase
{
  public QCircleAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      QCircleUtils.a().enterBySchemeAction(this.jdField_a_of_type_AndroidContentContext, this.c, this.jdField_a_of_type_JavaUtilHashMap);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("QCircleAction", 1, "doAction error: " + localException.getMessage());
      a("QCircleAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QCircleAction
 * JD-Core Version:    0.7.0.1
 */