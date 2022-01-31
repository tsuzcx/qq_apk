import android.content.Intent;
import cooperation.qzone.util.QZLog;

public class bjhs
{
  public static boolean a(Object paramObject, int paramInt1, int paramInt2, Intent paramIntent)
  {
    QZLog.i("QZoneEventHandler", "handleActivityEvent: " + paramInt1 + " " + paramInt2);
    switch (paramInt1)
    {
    default: 
      return false;
    }
    if (((paramObject instanceof agps)) && (((agps)paramObject).a != null)) {
      ((agps)paramObject).a.a(paramInt1, paramInt2, paramIntent);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjhs
 * JD-Core Version:    0.7.0.1
 */