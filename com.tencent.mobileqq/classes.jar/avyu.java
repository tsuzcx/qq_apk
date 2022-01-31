class avyu
  implements avxp
{
  avyu(avyt paramavyt) {}
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    ved.d("FlowEdit_VideoFlowDecodeWrapper", paramThrowable, "onDecodeError: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong) {}
  
  public void b(long paramLong)
  {
    ved.a("FlowEdit_VideoFlowDecodeWrapper", "onDecodeSeekTo: %d", Long.valueOf(paramLong));
  }
  
  public void f()
  {
    ved.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeStart: ");
  }
  
  public void g()
  {
    ved.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeFinish: ");
  }
  
  public void i()
  {
    ved.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeCancel: ");
  }
  
  public void l()
  {
    ved.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeRepeat: ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avyu
 * JD-Core Version:    0.7.0.1
 */