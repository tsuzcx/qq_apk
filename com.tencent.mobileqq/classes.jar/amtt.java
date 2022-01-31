import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.nativemonitor.NativeMonitorConfigHelper.1.1;
import com.tencent.mobileqq.nativememorymonitor.library.ExternalProvider;

public final class amtt
  implements ExternalProvider
{
  public void onSoLoad(String paramString1, String paramString2)
  {
    ThreadManager.excute(new NativeMonitorConfigHelper.1.1(this, paramString1, paramString2), 64, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     amtt
 * JD-Core Version:    0.7.0.1
 */