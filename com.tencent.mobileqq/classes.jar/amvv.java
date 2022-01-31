import android.text.TextUtils;
import mqq.manager.Manager;

public class amvv
  implements Manager
{
  public static long a;
  public static long b;
  public static long c;
  protected atmp a;
  
  public static void a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!asfl.c())
    {
      asfc.a(paramString, "DatingManager.maplng", Long.valueOf(paramLong1));
      asfc.a(paramString, "DatingManager.maplat", Long.valueOf(paramLong2));
      asfc.a(paramString, "DatingManager.timestamp", Long.valueOf(paramLong3));
      return;
    }
    jdField_a_of_type_Long = paramLong1;
    b = paramLong2;
    c = paramLong3;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Atmp != null) {}
    try
    {
      this.jdField_a_of_type_Atmp.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     amvv
 * JD-Core Version:    0.7.0.1
 */