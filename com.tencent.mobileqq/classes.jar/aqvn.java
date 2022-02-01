import android.content.Context;

public class aqvn
  extends lyp
{
  public static int a(Context paramContext, String paramString)
  {
    return a(paramContext, "TencentDocGrayTips_ShowTimes_" + paramString, 0);
  }
  
  public static long a(Context paramContext, String paramString)
  {
    return a(paramContext, "TencentDocGrayTips_LastShowTime_" + paramString, 0L);
  }
  
  public static void b(Context paramContext, String paramString, int paramInt)
  {
    a(paramContext, "TencentDocGrayTips_ShowTimes_" + paramString, paramInt);
  }
  
  public static void b(Context paramContext, String paramString, long paramLong)
  {
    a(paramContext, "TencentDocGrayTips_LastShowTime_" + paramString, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqvn
 * JD-Core Version:    0.7.0.1
 */