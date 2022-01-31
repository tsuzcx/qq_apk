import android.text.TextUtils;
import mqq.manager.Manager;

public class aphy
  implements Manager
{
  public static long a;
  public static long b;
  public static long c;
  protected awgf a;
  
  public static void a(String paramString, long paramLong1, long paramLong2, long paramLong3)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!auwz.c())
    {
      auwq.a(paramString, "DatingManager.maplng", Long.valueOf(paramLong1));
      auwq.a(paramString, "DatingManager.maplat", Long.valueOf(paramLong2));
      auwq.a(paramString, "DatingManager.timestamp", Long.valueOf(paramLong3));
      return;
    }
    jdField_a_of_type_Long = paramLong1;
    b = paramLong2;
    c = paramLong3;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Awgf != null) {}
    try
    {
      this.jdField_a_of_type_Awgf.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aphy
 * JD-Core Version:    0.7.0.1
 */