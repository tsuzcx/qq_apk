import com.tencent.qphone.base.util.QLog;

final class bhho
  extends anyz
{
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, anza paramanza)
  {
    if (paramanza != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("StatictisInfo[ ");
      localStringBuilder.append("appSeq: " + paramanza.jdField_a_of_type_Int);
      localStringBuilder.append("errCode: " + paramanza.b);
      localStringBuilder.append("retryCount: " + paramanza.c);
      localStringBuilder.append("detailErrorReason: " + paramanza.jdField_a_of_type_Long);
      localStringBuilder.append("timeoutReason: " + paramanza.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" ]");
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + "," + localStringBuilder.toString());
      return;
    }
    QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + ",statictisInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhho
 * JD-Core Version:    0.7.0.1
 */