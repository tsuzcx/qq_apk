import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.VideoSendTaskManager;
import java.util.HashMap;

class anuv
  implements Runnable
{
  anuv(anuu paramanuu, UpCallBack.SendResult paramSendResult) {}
  
  public void run()
  {
    if ((TransferRequest)VideoSendTaskManager.a(this.jdField_a_of_type_Anuu.a).get(anuu.a(this.jdField_a_of_type_Anuu)) != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack$SendResult.a != 0) {
        break label85;
      }
      if (QLog.isColorLevel()) {
        QLog.i("PreUploadVideo", 2, "[onSend]ResultOk id=" + anuu.a(this.jdField_a_of_type_Anuu));
      }
      this.jdField_a_of_type_Anuu.a(this.jdField_a_of_type_ComTencentMobileqqPicUpCallBack$SendResult);
    }
    label85:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i("PreUploadVideo", 2, "[onSend]ResultFail id=" + anuu.a(this.jdField_a_of_type_Anuu));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anuv
 * JD-Core Version:    0.7.0.1
 */