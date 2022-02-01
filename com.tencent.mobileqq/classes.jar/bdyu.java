import com.tencent.mobileqq.data.MessageRecord;

class bdyu
  extends anqd
{
  bdyu(bdyr parambdyr) {}
  
  public void a(boolean paramBoolean, long paramLong, anqe paramanqe)
  {
    this.a.b("sendMsgFinish", "success:" + paramBoolean);
    bgnl.a(String.valueOf(this.a.a.jdField_a_of_type_Long), "message", "sendMsgFinish isSuccess:" + paramBoolean + ",mr = " + this.a.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.toString());
    this.a.a(this.a.c, false, paramBoolean, paramanqe);
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdyu
 * JD-Core Version:    0.7.0.1
 */