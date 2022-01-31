import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.trackrecordlib.core.IRecordConfig;

public class awpa
  implements IRecordConfig
{
  public awpa(RecordTracer paramRecordTracer) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awpa
 * JD-Core Version:    0.7.0.1
 */