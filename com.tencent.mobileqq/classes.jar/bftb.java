import android.content.Intent;
import cooperation.qzone.util.QZLog;

public class bftb
{
  public static boolean a(Object paramObject, int paramInt1, int paramInt2, Intent paramIntent)
  {
    QZLog.i("QZoneEventHandler", "handleActivityEvent: " + paramInt1 + " " + paramInt2);
    switch (paramInt1)
    {
    default: 
      return false;
    }
    if (((paramObject instanceof aedo)) && (((aedo)paramObject).a != null)) {
      ((aedo)paramObject).a.a(paramInt1, paramInt2, paramIntent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bftb
 * JD-Core Version:    0.7.0.1
 */