import com.tencent.qphone.base.util.QLog;

final class bdnb
  extends alwx
{
  public void a(boolean paramBoolean, long paramLong, alwy paramalwy)
  {
    if (paramalwy != null)
    {
      StringBuilder localStringBuilder = new StringBuilder(256);
      localStringBuilder.append("StatictisInfo[ ");
      localStringBuilder.append("appSeq: " + paramalwy.jdField_a_of_type_Int);
      localStringBuilder.append("errCode: " + paramalwy.b);
      localStringBuilder.append("retryCount: " + paramalwy.c);
      localStringBuilder.append("detailErrorReason: " + paramalwy.jdField_a_of_type_Long);
      localStringBuilder.append("timeoutReason: " + paramalwy.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(" ]");
      QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + "," + localStringBuilder.toString());
      return;
    }
    QLog.d("RedPacketStructMsg", 1, "onNotifyResultAfterSendRich isSuccess:" + paramBoolean + ",statictisInfo == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdnb
 * JD-Core Version:    0.7.0.1
 */