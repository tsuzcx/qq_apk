import android.content.Context;
import android.telephony.TelephonyManager;
import cooperation.qzone.util.QZLog;
import java.lang.reflect.Method;

public class amjy
  extends amjx
{
  protected int b(Context paramContext, int[] paramArrayOfInt)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
    Class localClass = localTelephonyManager.getClass();
    Method localMethod2 = null;
    Method localMethod1 = null;
    if ((b == -1) || (b == 21)) {
      localMethod1 = localMethod2;
    }
    try
    {
      localMethod2 = localClass.getDeclaredMethod("getLine1Number", new Class[] { Integer.TYPE });
      localMethod1 = localMethod2;
      b = 21;
      localMethod1 = localMethod2;
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          localMethod2 = localClass.getDeclaredMethod("getLine1Number", new Class[] { Long.TYPE });
          localMethod1 = localMethod2;
        }
        catch (Throwable localThrowable2)
        {
          bool1 = bool2;
          QZLog.e("UniKingCardHelper/SimManager", "initAllPhoneNum 24 2 error:" + localThrowable2.getMessage());
          continue;
        }
        try
        {
          b = 22;
          bool1 = false;
          if ((b != -1) && (localMethod1 != null)) {
            break label213;
          }
          return super.b(paramContext, paramArrayOfInt);
        }
        catch (Throwable localThrowable3)
        {
          bool1 = false;
          continue;
        }
        localThrowable1 = localThrowable1;
        QZLog.e("UniKingCardHelper/SimManager", "initAllPhoneNum 24 1 error:" + localThrowable1.getMessage());
      }
    }
    if ((b == -1) || (b == 22)) {}
    for (;;)
    {
      label213:
      return a(2, localTelephonyManager, paramArrayOfInt, localMethod1, bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amjy
 * JD-Core Version:    0.7.0.1
 */