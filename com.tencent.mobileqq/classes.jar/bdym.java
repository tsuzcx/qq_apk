import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import com.tencent.qqmini.sdk.core.MiniAppEnv;

public class bdym
{
  public static Debug.MemoryInfo a(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = new Debug.MemoryInfo();
    if (Build.VERSION.SDK_INT >= 14)
    {
      Debug.getMemoryInfo((Debug.MemoryInfo)localObject2);
      localObject1 = localObject2;
    }
    for (;;)
    {
      return localObject1;
      try
      {
        localObject2 = MiniAppEnv.g().getContext();
        if (localObject2 == null) {
          continue;
        }
        localObject1 = ((ActivityManager)((Context)localObject2).getSystemService("activity")).getProcessMemoryInfo(new int[] { paramInt });
        if (localObject1.length > 0) {}
        for (localObject1 = localObject1[0];; localObject1 = null) {
          return localObject1;
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdym
 * JD-Core Version:    0.7.0.1
 */