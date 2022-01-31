class axqt
  implements axpo
{
  axqt(axqs paramaxqs) {}
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    wsv.d("FlowEdit_VideoFlowDecodeWrapper", paramThrowable, "onDecodeError: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong) {}
  
  public void b(long paramLong)
  {
    wsv.a("FlowEdit_VideoFlowDecodeWrapper", "onDecodeSeekTo: %d", Long.valueOf(paramLong));
  }
  
  public void f()
  {
    wsv.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeStart: ");
  }
  
  public void g()
  {
    wsv.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeFinish: ");
  }
  
  public void i()
  {
    wsv.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeCancel: ");
  }
  
  public void l()
  {
    wsv.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeRepeat: ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axqt
 * JD-Core Version:    0.7.0.1
 */