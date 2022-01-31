import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.ShortVideoUploadProcessor;

public class ayvi
  extends akat
{
  public ayvi(ShortVideoUploadProcessor paramShortVideoUploadProcessor) {}
  
  public void a(boolean paramBoolean, long paramLong, akau paramakau)
  {
    this.a.b("sendMsgFinish", "success:" + paramBoolean);
    bbfb.a(String.valueOf(this.a.a.jdField_a_of_type_Long), "message", "sendMsgFinish isSuccess:" + paramBoolean + ",mr = " + this.a.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.toString());
    this.a.a(this.a.c, false, paramBoolean, paramakau);
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayvi
 * JD-Core Version:    0.7.0.1
 */