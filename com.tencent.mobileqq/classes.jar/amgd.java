import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class amgd
  implements bbqp
{
  amgd(amgb paramamgb, int paramInt) {}
  
  public void onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = bbtj.a(this.jdField_a_of_type_Amgb.a.getApp(), this.jdField_a_of_type_Int);
    if (QLog.isColorLevel()) {
      QLog.d("MessageNotificationSettingManager", 2, new Object[] { "playRingId.onCompleted: invoked. ", " wavPath: ", paramQQAppInterface });
    }
    amgb.a(this.jdField_a_of_type_Amgb, paramQQAppInterface);
  }
  
  public void onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amgd
 * JD-Core Version:    0.7.0.1
 */