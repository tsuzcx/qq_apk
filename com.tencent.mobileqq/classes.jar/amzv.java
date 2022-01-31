import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class amzv
{
  public int a = 2;
  public int b = 1;
  public int c = 1;
  private int d = 1;
  private int e = 1;
  
  @NonNull
  public static amzv a()
  {
    return new amzv();
  }
  
  @NonNull
  public static amzv a(@Nullable String paramString)
  {
    amzv localamzv = new amzv();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localamzv.a = paramString.optInt("kingcard", localamzv.a);
        localamzv.d = paramString.optInt("gldrawable", localamzv.d);
        localamzv.b = paramString.optInt("webso_preload", localamzv.b);
        localamzv.c = paramString.optInt("webso_screenshot", localamzv.c);
        localamzv.e = paramString.optInt("etcdrawable", localamzv.e);
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localamzv.toString());
      }
      return localamzv;
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
 * Qualified Name:     amzv
 * JD-Core Version:    0.7.0.1
 */