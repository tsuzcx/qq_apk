import com.tencent.qphone.base.util.QLog;

class ayrk
  extends akav
{
  ayrk(ayrh paramayrh) {}
  
  public void a(boolean paramBoolean, long paramLong, akaw paramakaw)
  {
    if ((this.a.a.a == 1026) && (QLog.isColorLevel())) {
      QLog.i("PttShow", 2, "onNotifyResultAfterSendRich, UIN_TYPE_HOTCHAT_TOPIC  " + paramBoolean);
    }
    this.a.b("sendMsgFinish", "success:" + paramBoolean);
    this.a.a(this.a.c, false, paramBoolean, paramakaw);
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    if (paramakaw != null) {
      this.a.v = paramakaw.d;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayrk
 * JD-Core Version:    0.7.0.1
 */