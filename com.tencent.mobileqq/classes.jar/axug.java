class axug
  extends ajmm
{
  axug(axue paramaxue) {}
  
  public void a(boolean paramBoolean, long paramLong, ajmn paramajmn)
  {
    this.a.b("sendMsgFinish", "success:" + paramBoolean);
    this.a.a(this.a.c, false, paramBoolean, paramajmn);
    if (paramBoolean)
    {
      this.a.e();
      return;
    }
    if (paramajmn != null) {
      this.a.v = paramajmn.d;
    }
    this.a.a(-1, "MessageForScribble SEND FAIL", "", this.a.b);
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axug
 * JD-Core Version:    0.7.0.1
 */