import android.os.HandlerThread;
import com.tencent.ark.ArkEnvironmentManager.ThreadCreater;
import com.tencent.mobileqq.app.ThreadManager;

public final class annu
  implements ArkEnvironmentManager.ThreadCreater
{
  public HandlerThread createHanderThread(String paramString)
  {
    return ThreadManager.newFreeHandlerThread(paramString, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annu
 * JD-Core Version:    0.7.0.1
 */