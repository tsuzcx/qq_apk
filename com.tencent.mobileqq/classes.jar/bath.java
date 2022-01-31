import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;

public class bath
  extends alsi
{
  public bath(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  public void a(boolean paramBoolean, long paramLong, alsj paramalsj)
  {
    this.a.b("sendMsgFinish", "success:" + paramBoolean);
    bddw.a(String.valueOf(this.a.a.jdField_a_of_type_Long), "message", "sendMsgFinish isSuccess:" + paramBoolean + ",mr = " + this.a.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.toString());
    this.a.a(this.a.c, false, paramBoolean, paramalsj);
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bath
 * JD-Core Version:    0.7.0.1
 */