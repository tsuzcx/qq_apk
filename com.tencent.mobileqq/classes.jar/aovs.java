import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aovs
{
  public int a = 2;
  public int b = 1;
  public int c = 1;
  private int d = 1;
  private int e = 1;
  
  @NonNull
  public static aovs a()
  {
    return new aovs();
  }
  
  @NonNull
  public static aovs a(@Nullable String paramString)
  {
    aovs localaovs = new aovs();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localaovs.a = paramString.optInt("kingcard", localaovs.a);
        localaovs.d = paramString.optInt("gldrawable", localaovs.d);
        localaovs.b = paramString.optInt("webso_preload", localaovs.b);
        localaovs.c = paramString.optInt("webso_screenshot", localaovs.c);
        localaovs.e = paramString.optInt("etcdrawable", localaovs.e);
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localaovs.toString());
      }
      return localaovs;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, "json parse error:" + paramString);
      }
    }
  }
  
  public boolean a()
  {
    return this.d > 0;
  }
  
  public boolean b()
  {
    return this.e > 0;
  }
  
  public String toString()
  {
    return "QVipSDKConfig{kingCard=" + this.a + ", gldrawable=" + this.d + ", webso_preload=" + this.b + ", webso_screenshot=" + this.c + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovs
 * JD-Core Version:    0.7.0.1
 */