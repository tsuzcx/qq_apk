package androidx.core.app;

import android.app.Service;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;

public final class ServiceCompat
{
  public static final int START_STICKY = 1;
  public static final int STOP_FOREGROUND_DETACH = 2;
  public static final int STOP_FOREGROUND_REMOVE = 1;
  
  public static void stopForeground(@NonNull Service paramService, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramService.stopForeground(paramInt);
      return;
    }
    boolean bool = true;
    if ((paramInt & 0x1) == 0) {
      bool = false;
    }
    paramService.stopForeground(bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.app.ServiceCompat
 * JD-Core Version:    0.7.0.1
 */