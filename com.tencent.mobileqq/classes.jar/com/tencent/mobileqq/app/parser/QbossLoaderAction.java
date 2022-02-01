package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qbosssplash.common.QbossPreDownloadManager;
import com.tencent.qphone.base.util.QLog;

public class QbossLoaderAction
  extends JumpActionBase
{
  public QbossLoaderAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = QbossPreDownloadManager.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaUtilHashMap);
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QbossLoaderAction", 1, "doAction error: " + localException.getMessage());
      a("QbossLoaderAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QbossLoaderAction
 * JD-Core Version:    0.7.0.1
 */