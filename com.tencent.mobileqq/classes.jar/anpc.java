import dov.com.tencent.mfsdk.collector.DropFrameMonitor;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

public class anpc
  implements AbstractUnifiedMonitor.ThreadMonitorCallback
{
  public anpc(DropFrameMonitor paramDropFrameMonitor) {}
  
  public void onThreadMonitorEnd(int paramInt)
  {
    if (paramInt == 10) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anpc
 * JD-Core Version:    0.7.0.1
 */