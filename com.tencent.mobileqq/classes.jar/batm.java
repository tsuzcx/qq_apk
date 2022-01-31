import com.tencent.qphone.base.util.QLog;

class batm
  extends alwx
{
  batm(batj parambatj) {}
  
  public void a(boolean paramBoolean, long paramLong, alwy paramalwy)
  {
    if ((this.a.a.a == 1026) && (QLog.isColorLevel())) {
      QLog.i("PttShow", 2, "onNotifyResultAfterSendRich, UIN_TYPE_HOTCHAT_TOPIC  " + paramBoolean);
    }
    this.a.b("sendMsgFinish", "success:" + paramBoolean);
    this.a.a(this.a.c, false, paramBoolean, paramalwy);
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    if (paramalwy != null) {
      this.a.v = paramalwy.d;
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     batm
 * JD-Core Version:    0.7.0.1
 */