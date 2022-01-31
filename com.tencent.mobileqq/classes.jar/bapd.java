import com.tencent.qphone.base.util.QLog;

class bapd
  extends alsi
{
  bapd(bapa parambapa) {}
  
  public void a(boolean paramBoolean, long paramLong, alsj paramalsj)
  {
    if ((this.a.a.a == 1026) && (QLog.isColorLevel())) {
      QLog.i("PttShow", 2, "onNotifyResultAfterSendRich, UIN_TYPE_HOTCHAT_TOPIC  " + paramBoolean);
    }
    this.a.b("sendMsgFinish", "success:" + paramBoolean);
    this.a.a(this.a.c, false, paramBoolean, paramalsj);
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    if (paramalsj != null) {
      this.a.v = paramalsj.d;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bapd
 * JD-Core Version:    0.7.0.1
 */