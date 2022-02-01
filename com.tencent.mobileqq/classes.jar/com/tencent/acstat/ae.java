package com.tencent.acstat;

class ae
  implements StatDispatchCallback
{
  ae(ab paramab) {}
  
  public void onDispatchFailure()
  {
    af.b().a(ab.b(this.a), null, ab.c(this.a), true);
    StatServiceImpl.d();
  }
  
  public void onDispatchSuccess()
  {
    
    if (af.b().a > 0) {
      StatServiceImpl.commitEvents(ab.a(this.a), -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.acstat.ae
 * JD-Core Version:    0.7.0.1
 */