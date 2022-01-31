import com.tencent.qphone.base.util.QLog;

final class bbjy
  extends akat
{
  public void a(boolean paramBoolean, long paramLong, akau paramakau)
  {
    if (paramakau != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("StatictisInfo[ ");
      localStringBuilder.append("appSeq: " + paramakau.jdField_a_of_type_Int);
      localStringBuilder.append("errCode: " + paramakau.b);
      localStringBuilder.append("retryCount: " + paramakau.c);
      localStringBuilder.append("detailErrorReason: " + paramakau.jdField_a_of_type_Long);
      localStringBuilder.append("timeoutReason: " + paramakau.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" ]");
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + "," + localStringBuilder.toString());
      return;
    }
    QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + ",statictisInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjy
 * JD-Core Version:    0.7.0.1
 */