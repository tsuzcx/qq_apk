import dov.com.tencent.mfsdk.collector.DropFrameMonitor;
import mqq.util.AbstractUnifiedMonitor.ThreadMonitorCallback;

public class aofh
  implements AbstractUnifiedMonitor.ThreadMonitorCallback
{
  public aofh(DropFrameMonitor paramDropFrameMonitor) {}
  
  public void onThreadMonitorEnd(int paramInt)
  {
    if (paramInt == 10) {
      this.a.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aofh
 * JD-Core Version:    0.7.0.1
 */