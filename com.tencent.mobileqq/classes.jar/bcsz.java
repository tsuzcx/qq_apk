import com.tencent.av.service.AVPbInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.util.QLog;

class bcsz
  implements lxy
{
  bcsz(bcsy parambcsy, byte[] paramArrayOfByte, String paramString, long paramLong1, MessageHandler paramMessageHandler, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean) {}
  
  public void a(lxx paramlxx)
  {
    AVPbInfo localAVPbInfo = paramlxx.a(this.jdField_a_of_type_ArrayOfByte);
    if (localAVPbInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ret, bindId:" + localAVPbInfo.bindId + ", bindIdType:" + localAVPbInfo.bindIdType + ", phoneNum:" + localAVPbInfo.phoneNum);
      }
      if (!llq.c()) {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Discard video message cause device not support");
        }
      }
    }
    for (;;)
    {
      paramlxx.a();
      return;
      if (this.jdField_a_of_type_Long >= 60L)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Discard video message because of time out " + this.jdField_a_of_type_Long + " s");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "===========handleSharpVideoMessageResp 1234========");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.b, this.jdField_a_of_type_ArrayOfByte, this.c, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ret, decode failed!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsz
 * JD-Core Version:    0.7.0.1
 */