import com.tencent.mobileqq.data.MessageRecord;

class bexn
  extends aocj
{
  bexn(bexk parambexk) {}
  
  public void a(boolean paramBoolean, long paramLong, aock paramaock)
  {
    this.a.b("sendMsgFinish", "success:" + paramBoolean);
    bhnn.a(String.valueOf(this.a.a.jdField_a_of_type_Long), "message", "sendMsgFinish isSuccess:" + paramBoolean + ",mr = " + this.a.a.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.toString());
    this.a.a(this.a.c, false, paramBoolean, paramaock);
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bexn
 * JD-Core Version:    0.7.0.1
 */