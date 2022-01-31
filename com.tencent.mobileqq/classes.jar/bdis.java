import com.tencent.qphone.base.util.QLog;

final class bdis
  extends alsi
{
  public void a(boolean paramBoolean, long paramLong, alsj paramalsj)
  {
    if (paramalsj != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("StatictisInfo[ ");
      localStringBuilder.append("appSeq: " + paramalsj.jdField_a_of_type_Int);
      localStringBuilder.append("errCode: " + paramalsj.b);
      localStringBuilder.append("retryCount: " + paramalsj.c);
      localStringBuilder.append("detailErrorReason: " + paramalsj.jdField_a_of_type_Long);
      localStringBuilder.append("timeoutReason: " + paramalsj.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" ]");
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + "," + localStringBuilder.toString());
      return;
    }
    QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + ",statictisInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdis
 * JD-Core Version:    0.7.0.1
 */