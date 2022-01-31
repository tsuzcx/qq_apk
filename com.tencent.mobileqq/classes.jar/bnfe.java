import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

class bnfe
  implements AbstractUnifiedMonitor.ThreadMonitorCallback
{
  bnfe(bnfd parambnfd) {}
  
  public void onThreadMonitorEnd(int paramInt)
  {
    if (paramInt == 10) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfe
 * JD-Core Version:    0.7.0.1
 */