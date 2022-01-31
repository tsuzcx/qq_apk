import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

class bnas
  implements AbstractUnifiedMonitor.ThreadMonitorCallback
{
  bnas(bnar parambnar) {}
  
  public void onThreadMonitorEnd(int paramInt)
  {
    if (paramInt == 10) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnas
 * JD-Core Version:    0.7.0.1
 */