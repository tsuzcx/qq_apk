import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.VideoSendTaskManager;
import java.util.HashMap;

class aott
  implements Runnable
{
  aott(aots paramaots, UpCallBack.SendResult paramSendResult) {}
  
  public void run()
  {
    if ((TransferRequest)VideoSendTaskManager.a(this.jdField_a_of_type_Aots.a).get(aots.a(this.jdField_a_of_type_Aots)) != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack$SendResult.a != 0) {
        break label85;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PreUploadVideo", 2, "[onSend]ResultOk id=" + aots.a(this.jdField_a_of_type_Aots));
      }
      this.jdField_a_of_type_Aots.a(this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack$SendResult);
    }
    label85:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("PreUploadVideo", 2, "[onSend]ResultFail id=" + aots.a(this.jdField_a_of_type_Aots));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aott
 * JD-Core Version:    0.7.0.1
 */