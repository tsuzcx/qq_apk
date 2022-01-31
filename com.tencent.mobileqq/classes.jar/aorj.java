import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aorj
{
  public int a = 2;
  public int b = 1;
  public int c = 1;
  private int d = 1;
  private int e = 1;
  
  @NonNull
  public static aorj a()
  {
    return new aorj();
  }
  
  @NonNull
  public static aorj a(@Nullable String paramString)
  {
    aorj localaorj = new aorj();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localaorj.a = paramString.optInt("kingcard", localaorj.a);
        localaorj.d = paramString.optInt("gldrawable", localaorj.d);
        localaorj.b = paramString.optInt("webso_preload", localaorj.b);
        localaorj.c = paramString.optInt("webso_screenshot", localaorj.c);
        localaorj.e = paramString.optInt("etcdrawable", localaorj.e);
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localaorj.toString());
      }
      return localaorj;
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
 * Qualified Name:     aorj
 * JD-Core Version:    0.7.0.1
 */