package com.tencent.mobileqq.app;

import amsw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qphone.base.util.QLog;

final class SignatureManager$2
  implements Runnable
{
  SignatureManager$2(RichStatus paramRichStatus, String paramString) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        RichStatus localRichStatus = this.jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
        Object localObject1 = (amsw)localQQAppInterface.getManager(51);
        boolean bool = ((amsw)localObject1).b(this.jdField_a_of_type_JavaLangString);
        if (!bool) {
          return;
        }
        if (localRichStatus == null)
        {
          localObject1 = ((amsw)localObject1).a(this.jdField_a_of_type_JavaLangString);
          if (localObject1 == null) {
            return;
          }
          bool = ((ExtensionInfo)localObject1).isAdded2C2C;
          if (bool) {
            return;
          }
          localRichStatus = ((ExtensionInfo)localObject1).getRichStatus();
          bool = SignatureManager.a(localRichStatus);
          if (bool) {
            return;
          }
          bool = SignatureManager.a(localQQAppInterface, localRichStatus, this.jdField_a_of_type_JavaLangString);
          if (bool) {
            return;
          }
          SignatureManager.a(localQQAppInterface, localRichStatus);
          bool = SignatureManager.a(localQQAppInterface, this.jdField_a_of_type_JavaLangString);
          if (bool) {
            return;
          }
          String str = SignatureManager.a(localRichStatus);
          if (str == null) {
            return;
          }
          SignatureManager.a(localQQAppInterface, localRichStatus, (ExtensionInfo)localObject1, str, this.jdField_a_of_type_JavaLangString);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("Signature", 2, "insertSignMsgIfNeeded exception:" + localException);
        return;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("Signature", 2, "insert signature cost:" + (System.currentTimeMillis() - l) + " ms");
        }
        SignatureManager.a(true);
      }
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager.2
 * JD-Core Version:    0.7.0.1
 */