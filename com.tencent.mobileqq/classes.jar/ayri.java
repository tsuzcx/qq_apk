import com.tencent.qphone.base.util.QLog;

class ayri
  extends akat
{
  ayri(ayrf paramayrf) {}
  
  public void a(boolean paramBoolean, long paramLong, akau paramakau)
  {
    if ((this.a.a.a == 1026) && (QLog.isColorLevel())) {
      QLog.i("PttShow", 2, "onNotifyResultAfterSendRich, UIN_TYPE_HOTCHAT_TOPIC  " + paramBoolean);
    }
    this.a.b("sendMsgFinish", "success:" + paramBoolean);
    this.a.a(this.a.c, false, paramBoolean, paramakau);
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    if (paramakau != null) {
      this.a.v = paramakau.d;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayri
 * JD-Core Version:    0.7.0.1
 */