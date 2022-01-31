import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.VideoSendTaskManager;
import java.util.HashMap;

class aola
  implements Runnable
{
  aola(aokz paramaokz, UpCallBack.SendResult paramSendResult) {}
  
  public void run()
  {
    if ((TransferRequest)VideoSendTaskManager.a(this.jdField_a_of_type_Aokz.a).get(aokz.a(this.jdField_a_of_type_Aokz)) != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack$SendResult.a != 0) {
        break label85;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PreUploadVideo", 2, "[onSend]ResultOk id=" + aokz.a(this.jdField_a_of_type_Aokz));
      }
      this.jdField_a_of_type_Aokz.a(this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack$SendResult);
    }
    label85:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("PreUploadVideo", 2, "[onSend]ResultFail id=" + aokz.a(this.jdField_a_of_type_Aokz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aola
 * JD-Core Version:    0.7.0.1
 */