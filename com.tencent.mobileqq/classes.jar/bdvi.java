import com.tencent.qphone.base.util.QLog;

class bdvi
  extends anqd
{
  bdvi(bdvf parambdvf) {}
  
  public void a(boolean paramBoolean, long paramLong, anqe paramanqe)
  {
    if ((this.a.a.a == 1026) && (QLog.isColorLevel())) {
      QLog.i("PttShow", 2, "onNotifyResultAfterSendRich, UIN_TYPE_HOTCHAT_TOPIC  " + paramBoolean);
    }
    this.a.b("sendMsgFinish", "success:" + paramBoolean);
    this.a.a(this.a.c, false, paramBoolean, paramanqe);
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    if (paramanqe != null) {
      this.a.v = paramanqe.d;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvi
 * JD-Core Version:    0.7.0.1
 */