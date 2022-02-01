import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.trackrecordlib.core.IRecordConfig;

public class bdjm
  implements IRecordConfig
{
  public bdjm(RecordTracer paramRecordTracer) {}
  
  public int getCachedEventSize()
  {
    return 0;
  }
  
  public String getTitleBarId()
  {
    return "com.tencent.mobileqq:id/ivTitleName";
  }
  
  public boolean isEnableRelease()
  {
    return true;
  }
  
  public boolean isFilterUGC()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdjm
 * JD-Core Version:    0.7.0.1
 */