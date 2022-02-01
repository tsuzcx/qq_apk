import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class aqqt
  implements bhza
{
  aqqt(aqqr paramaqqr, int paramInt) {}
  
  public void onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = bicp.a(this.jdField_a_of_type_Aqqr.a.getApp(), this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "playRingId.onCompleted: invoked. ", " wavPath: ", paramQQAppInterface });
    }
    aqqr.a(this.jdField_a_of_type_Aqqr, paramQQAppInterface);
  }
  
  public void onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqqt
 * JD-Core Version:    0.7.0.1
 */