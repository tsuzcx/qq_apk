import android.app.Activity;
import dov.com.tencent.mobileqq.activity.richmedia.FlowSendTask;

public class anqe
  implements Runnable
{
  public anqe(FlowSendTask paramFlowSendTask) {}
  
  public void run()
  {
    this.a.a.setResult(1001);
    this.a.a.finish();
    this.a.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anqe
 * JD-Core Version:    0.7.0.1
 */