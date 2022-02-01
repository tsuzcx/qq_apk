package com.tencent.acstat;

import java.util.List;

class al
  implements StatDispatchCallback
{
  al(af paramaf, List paramList, boolean paramBoolean) {}
  
  public void onDispatchFailure()
  {
    StatServiceImpl.d();
    this.c.a(this.a, 1, this.b, true);
  }
  
  public void onDispatchSuccess()
  {
    StatServiceImpl.c();
    this.c.a(this.a, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.al
 * JD-Core Version:    0.7.0.1
 */