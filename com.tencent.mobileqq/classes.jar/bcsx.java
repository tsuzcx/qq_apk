import com.tencent.av.service.AVPbInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.util.QLog;

class bcsx
  implements lya
{
  bcsx(bcsw parambcsw, byte[] paramArrayOfByte, long paramLong1, MessageHandler paramMessageHandler, long paramLong2, long paramLong3, long paramLong4, boolean paramBoolean) {}
  
  public void a(lxz paramlxz)
  {
    AVPbInfo localAVPbInfo = paramlxz.a(this.jdField_a_of_type_ArrayOfByte);
    if (localAVPbInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("decodeC2CMsgPkg_QCall", 2, "ret, bindId:" + localAVPbInfo.bindId + ", bindIdType:" + localAVPbInfo.bindIdType + ", phoneNum:" + localAVPbInfo.phoneNum);
      }
      if (!llk.c()) {
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "Discard video message cause device not support");
        }
      }
    }
    for (;;)
    {
      paramlxz.a();
      return;
      if (this.jdField_a_of_type_Long >= 60L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "Discard video message because of time out " + this.jdField_a_of_type_Long + " s");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "===========handleSharpVideoMessageResp 1234========");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.b, this.jdField_a_of_type_ArrayOfByte, this.c, (int)this.d, this.jdField_a_of_type_Boolean);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("decodeC2CMsgPkg_QCall", 2, "ret, decode failed!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsx
 * JD-Core Version:    0.7.0.1
 */