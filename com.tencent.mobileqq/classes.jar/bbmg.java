class bbmg
  implements bblb
{
  bbmg(bbmf parambbmf) {}
  
  public void a(int paramInt, Throwable paramThrowable)
  {
    ykq.d("FlowEdit_VideoFlowDecodeWrapper", paramThrowable, "onDecodeError: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(long paramLong) {}
  
  public void b(long paramLong)
  {
    ykq.a("FlowEdit_VideoFlowDecodeWrapper", "onDecodeSeekTo: %d", Long.valueOf(paramLong));
  }
  
  public void g()
  {
    ykq.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeStart: ");
  }
  
  public void j()
  {
    ykq.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeFinish: ");
  }
  
  public void k()
  {
    ykq.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeCancel: ");
  }
  
  public void l()
  {
    ykq.b("FlowEdit_VideoFlowDecodeWrapper", "onDecodeRepeat: ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmg
 * JD-Core Version:    0.7.0.1
 */