import android.text.TextUtils;
import mqq.manager.Manager;

public class anmi
  implements Manager
{
  public static long a;
  public static long b;
  public static long c;
  protected aukp a;
  
  public static void a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!atbr.c())
    {
      atbi.a(paramString, "DatingManager.maplng", Long.valueOf(paramLong1));
      atbi.a(paramString, "DatingManager.maplat", Long.valueOf(paramLong2));
      atbi.a(paramString, "DatingManager.timestamp", Long.valueOf(paramLong3));
      return;
    }
    jdField_a_of_type_Long = paramLong1;
    b = paramLong2;
    c = paramLong3;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Aukp != null) {}
    try
    {
      this.jdField_a_of_type_Aukp.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     anmi
 * JD-Core Version:    0.7.0.1
 */