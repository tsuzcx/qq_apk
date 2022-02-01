package com.tencent.mobileqq.app.parser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;

public class QzoneDialogAction
  extends JumpActionBase
{
  public QzoneDialogAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return false;
    }
    Intent localIntent = new Intent();
    QzonePluginProxyActivity.setActivityNameToIntent(localIntent, "com.qzone.common.activities.QzoneDialogActivity");
    localIntent.addFlags(805306368);
    QZoneHelper.launchQZone((Activity)this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localIntent, -1);
    return true;
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = C();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("QzoneDialogAction", 1, "doAction error: " + localException.getMessage());
      a("QzoneDialogAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QzoneDialogAction
 * JD-Core Version:    0.7.0.1
 */