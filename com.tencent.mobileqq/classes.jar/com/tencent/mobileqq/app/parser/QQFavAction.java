package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;

public class QQFavAction
  extends JumpActionBase
{
  public QQFavAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      i = Integer.parseInt(this.c);
      switch (i)
      {
      default: 
        return true;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        QLog.e("QQFavAction", 1, "doAction error NumberFormatException: " + localNumberFormatException.getMessage());
        int i = -1;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("selfSet_leftViewText", BaseApplicationImpl.getApplication().getApplicationContext().getString(2131690778));
      boolean bool = QfavHelper.a((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), localIntent, -1, false);
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QQFavAction", 1, "doAction error: " + localException.getMessage());
      a("QQFavAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QQFavAction
 * JD-Core Version:    0.7.0.1
 */