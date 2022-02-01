import com.tencent.qphone.base.util.QLog;

class beuc
  extends aocj
{
  beuc(betz parambetz) {}
  
  public void a(boolean paramBoolean, long paramLong, aock paramaock)
  {
    if ((this.a.a.a == 1026) && (QLog.isColorLevel())) {
      QLog.i("PttShow", 2, "onNotifyResultAfterSendRich, UIN_TYPE_HOTCHAT_TOPIC  " + paramBoolean);
    }
    this.a.b("sendMsgFinish", "success:" + paramBoolean);
    this.a.a(this.a.c, false, paramBoolean, paramaock);
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    if (paramaock != null) {
      this.a.v = paramaock.d;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beuc
 * JD-Core Version:    0.7.0.1
 */