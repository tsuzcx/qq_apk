package android.support.v4.app;

import android.os.Build.VERSION;

public class NotificationCompat
{
  public static final int FLAG_HIGH_PRIORITY = 128;
  private static final NotificationCompat.NotificationCompatImpl IMPL = new NotificationCompat.NotificationCompatImplHoneycomb();
  public static final int PRIORITY_DEFAULT = 0;
  public static final int PRIORITY_HIGH = 1;
  public static final int PRIORITY_LOW = -1;
  public static final int PRIORITY_MAX = 2;
  public static final int PRIORITY_MIN = -2;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      IMPL = new NotificationCompat.NotificationCompatImplOreo();
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      IMPL = new NotificationCompat.NotificationCompatImplJellybean();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      IMPL = new NotificationCompat.NotificationCompatImplIceCreamSandwich();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      IMPL = new NotificationCompat.NotificationCompatImplHoneycomb();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat
 * JD-Core Version:    0.7.0.1
 */