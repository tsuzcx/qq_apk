import dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr;
import dov.com.tencent.mobileqq.shortvideo.common.GloableValue;

public final class aohs
  implements Runnable
{
  public aohs(String paramString) {}
  
  public void run()
  {
    String str = GloableValue.a();
    if ((str != null) && (!"".equals(str)) && (str.contains("/Android/data/com.tencent.mobileqq/qq/video"))) {
      RMVideoStateMgr.a(str, this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aohs
 * JD-Core Version:    0.7.0.1
 */