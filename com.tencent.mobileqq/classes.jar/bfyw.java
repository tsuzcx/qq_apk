import com.tencent.qphone.base.util.QLog;

final class bfyw
  extends amwl
{
  public void onNotifyResultAfterSendRich(boolean paramBoolean, long paramLong, amwm paramamwm)
  {
    if (paramamwm != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("StatictisInfo[ ");
      localStringBuilder.append("appSeq: " + paramamwm.jdField_a_of_type_Int);
      localStringBuilder.append("errCode: " + paramamwm.b);
      localStringBuilder.append("retryCount: " + paramamwm.c);
      localStringBuilder.append("detailErrorReason: " + paramamwm.jdField_a_of_type_Long);
      localStringBuilder.append("timeoutReason: " + paramamwm.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" ]");
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + "," + localStringBuilder.toString());
      return;
    }
    QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + ",statictisInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfyw
 * JD-Core Version:    0.7.0.1
 */