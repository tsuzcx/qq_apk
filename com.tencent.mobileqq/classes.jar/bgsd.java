import com.tencent.qphone.base.util.QLog;

final class bgsd
  extends anqd
{
  public void a(boolean paramBoolean, long paramLong, anqe paramanqe)
  {
    if (paramanqe != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("StatictisInfo[ ");
      localStringBuilder.append("appSeq: " + paramanqe.jdField_a_of_type_Int);
      localStringBuilder.append("errCode: " + paramanqe.b);
      localStringBuilder.append("retryCount: " + paramanqe.c);
      localStringBuilder.append("detailErrorReason: " + paramanqe.jdField_a_of_type_Long);
      localStringBuilder.append("timeoutReason: " + paramanqe.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" ]");
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + "," + localStringBuilder.toString());
      return;
    }
    QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + ",statictisInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgsd
 * JD-Core Version:    0.7.0.1
 */