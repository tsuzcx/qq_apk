import com.tencent.qphone.base.util.QLog;

final class bbjk
  extends akav
{
  public void a(boolean paramBoolean, long paramLong, akaw paramakaw)
  {
    if (paramakaw != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("StatictisInfo[ ");
      localStringBuilder.append("appSeq: " + paramakaw.jdField_a_of_type_Int);
      localStringBuilder.append("errCode: " + paramakaw.b);
      localStringBuilder.append("retryCount: " + paramakaw.c);
      localStringBuilder.append("detailErrorReason: " + paramakaw.jdField_a_of_type_Long);
      localStringBuilder.append("timeoutReason: " + paramakaw.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" ]");
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + "," + localStringBuilder.toString());
      return;
    }
    QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + ",statictisInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjk
 * JD-Core Version:    0.7.0.1
 */