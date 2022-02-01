package com.tencent.mobileqq.app.parser;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneShareManager;

public class QzoneRedpocketShareAction
  extends JumpActionBase
{
  public QzoneRedpocketShareAction(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
    String str2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentNickname();
    String str3 = QUA.getQUA3();
    QZoneShareManager.shareToQZoneForRedPocket(this.jdField_a_of_type_AndroidContentContext, str1, null, 0, str2, str3);
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
      QLog.e("QzoneRedpocketShareAction", 1, "doAction error: " + localException.getMessage());
      a("QzoneRedpocketShareAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.parser.QzoneRedpocketShareAction
 * JD-Core Version:    0.7.0.1
 */