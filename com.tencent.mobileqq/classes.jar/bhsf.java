import com.tencent.qphone.base.util.QLog;

final class bhsf
  extends aocj
{
  public void a(boolean paramBoolean, long paramLong, aock paramaock)
  {
    if (paramaock != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("StatictisInfo[ ");
      localStringBuilder.append("appSeq: " + paramaock.jdField_a_of_type_Int);
      localStringBuilder.append("errCode: " + paramaock.b);
      localStringBuilder.append("retryCount: " + paramaock.c);
      localStringBuilder.append("detailErrorReason: " + paramaock.jdField_a_of_type_Long);
      localStringBuilder.append("timeoutReason: " + paramaock.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" ]");
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + "," + localStringBuilder.toString());
      return;
    }
    QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + ",statictisInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsf
 * JD-Core Version:    0.7.0.1
 */