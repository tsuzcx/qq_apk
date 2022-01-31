class baso
  extends alsi
{
  baso(basm parambasm) {}
  
  public void a(boolean paramBoolean, long paramLong, alsj paramalsj)
  {
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
    this.a.a(-1, "MessageForScribble SEND FAIL", "", this.a.b);
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baso
 * JD-Core Version:    0.7.0.1
 */