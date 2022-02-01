class bblw
  implements bbkr
{
  bblw(bblv parambblv) {}
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    yuk.d("FlowEdit_VideoFlowDecodeWrapper", paramThrowable, "onDecodeError: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong) {}
  
  public void b(long paramLong)
  {
    yuk.a("FlowEdit_VideoFlowDecodeWrapper", "onDecodeSeekTo: %d", Long.valueOf(paramLong));
  }
  
  public void f()
  {
    yuk.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeStart: ");
  }
  
  public void g()
  {
    yuk.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeFinish: ");
  }
  
  public void i()
  {
    yuk.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeCancel: ");
  }
  
  public void l()
  {
    yuk.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeRepeat: ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bblw
 * JD-Core Version:    0.7.0.1
 */