import com.tencent.qphone.base.util.QLog;

final class baid
  extends ajmm
{
  public void a(boolean paramBoolean, long paramLong, ajmn paramajmn)
  {
    if (paramajmn != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("StatictisInfo[ ");
      localStringBuilder.append("appSeq: " + paramajmn.jdField_a_of_type_Int);
      localStringBuilder.append("errCode: " + paramajmn.b);
      localStringBuilder.append("retryCount: " + paramajmn.c);
      localStringBuilder.append("detailErrorReason: " + paramajmn.jdField_a_of_type_Long);
      localStringBuilder.append("timeoutReason: " + paramajmn.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" ]");
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + "," + localStringBuilder.toString());
      return;
    }
    QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + ",statictisInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baid
 * JD-Core Version:    0.7.0.1
 */