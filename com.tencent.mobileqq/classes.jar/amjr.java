import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amjr
{
  public int a = -1;
  public int b = -1;
  public int c = -1;
  public int d = -1;
  
  @NonNull
  public static amjr a()
  {
    return new amjr();
  }
  
  @NonNull
  public static amjr a(@Nullable String paramString)
  {
    amjr localamjr = new amjr();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localamjr.a = paramString.optInt("kingcard", 0);
        localamjr.b = paramString.optInt("gldrawable", 0);
        localamjr.c = paramString.optInt("webso_preload", 0);
        localamjr.d = paramString.optInt("webso_screenshot", 0);
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localamjr.toString());
      }
      return localamjr;
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
    return this.b > 0;
  }
  
  public String toString()
  {
    return "QVipSDKConfig{kingCard=" + this.a + ", gldrawable=" + this.b + ", webso_preload=" + this.c + ", webso_screenshot=" + this.d + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjr
 * JD-Core Version:    0.7.0.1
 */