package com.tencent.acstat;

class ac
  implements StatDispatchCallback
{
  ac(ab paramab) {}
  
  public void onDispatchFailure() {}
  
  public void onDispatchSuccess()
  {
    
    if (af.b().a() >= StatConfig.getMaxBatchReportCount()) {
      af.b().a(StatConfig.getMaxBatchReportCount());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.ac
 * JD-Core Version:    0.7.0.1
 */