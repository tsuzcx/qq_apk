import android.support.annotation.NonNull;
import java.util.concurrent.ThreadFactory;

public final class bmgg
  implements ThreadFactory
{
  public Thread newThread(@NonNull Runnable paramRunnable)
  {
    return new Thread(paramRunnable, "PluginDex2Oat");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmgg
 * JD-Core Version:    0.7.0.1
 */