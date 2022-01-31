import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class anac
{
  public int a = 2;
  public int b = 1;
  public int c = 1;
  private int d = 1;
  private int e = 1;
  
  @NonNull
  public static anac a()
  {
    return new anac();
  }
  
  @NonNull
  public static anac a(@Nullable String paramString)
  {
    anac localanac = new anac();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localanac.a = paramString.optInt("kingcard", localanac.a);
        localanac.d = paramString.optInt("gldrawable", localanac.d);
        localanac.b = paramString.optInt("webso_preload", localanac.b);
        localanac.c = paramString.optInt("webso_screenshot", localanac.c);
        localanac.e = paramString.optInt("etcdrawable", localanac.e);
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localanac.toString());
      }
      return localanac;
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
 * Qualified Name:     anac
 * JD-Core Version:    0.7.0.1
 */