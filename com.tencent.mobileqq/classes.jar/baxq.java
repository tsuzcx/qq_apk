import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;

public class baxq
  extends alwx
{
  public baxq(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  public void a(boolean paramBoolean, long paramLong, alwy paramalwy)
  {
    this.a.b("sendMsgFinish", "success:" + paramBoolean);
    bdif.a(String.valueOf(this.a.a.jdField_a_of_type_Long), "message", "sendMsgFinish isSuccess:" + paramBoolean + ",mr = " + this.a.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.toString());
    this.a.a(this.a.c, false, paramBoolean, paramalwy);
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baxq
 * JD-Core Version:    0.7.0.1
 */