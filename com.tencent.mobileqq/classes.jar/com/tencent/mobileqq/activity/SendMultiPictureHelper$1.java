package com.tencent.mobileqq.activity;

import android.os.Message;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.BaseTransProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class SendMultiPictureHelper$1
  extends TransProcessorHandler
{
  SendMultiPictureHelper$1(SendMultiPictureHelper paramSendMultiPictureHelper) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    paramMessage = (FileMsg)paramMessage.obj;
    if (paramMessage == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SendMultiPictureHelper", 2, "file is null");
      }
    }
    label389:
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("SendMultiPictureHelper", 2, "transferListener status: " + i);
      }
      Object localObject = paramMessage.mUin + paramMessage.uniseq;
      localObject = ((ITransFileController)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITransFileController.class)).findProcessor((String)localObject);
      if ((localObject instanceof BaseTransProcessor)) {}
      for (i = ((BaseTransProcessor)localObject).getProgress();; i = 0)
      {
        if (this.a.jdField_d_of_type_Boolean) {
          break label389;
        }
        if (this.a.jdField_b_of_type_Boolean)
        {
          if (paramMessage.status == 1005)
          {
            this.a.jdField_c_of_type_Boolean = true;
            return;
          }
          if (paramMessage.status == 1003)
          {
            this.a.a();
            return;
          }
          SendMultiPictureHelper.a(this.a, this.a.jdField_c_of_type_Int, this.a.jdField_a_of_type_JavaLangString, paramMessage.uniseq);
          return;
        }
        if (paramMessage.status == 1003)
        {
          if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
            this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.a.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int + 1), Integer.valueOf(this.a.jdField_b_of_type_Int), Integer.valueOf(100) }));
          }
          this.a.a();
          return;
        }
        if (paramMessage.status == 1005)
        {
          this.a.a();
          return;
        }
        if (this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null) {
          break;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setMessage(String.format(this.a.jdField_d_of_type_JavaLangString, new Object[] { Integer.valueOf(this.a.jdField_a_of_type_Int + 1), Integer.valueOf(this.a.jdField_b_of_type_Int), Integer.valueOf(i) }));
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SendMultiPictureHelper.1
 * JD-Core Version:    0.7.0.1
 */