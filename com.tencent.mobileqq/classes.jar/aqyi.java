import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqyi
{
  public int a = 2;
  public int b = 1;
  public int c = 1;
  public int d = 1;
  public int e = 15;
  private int f = 1;
  private int g = 1;
  private int h = 1;
  private int i;
  private int j = 16;
  private int k;
  
  @NonNull
  public static aqyi a()
  {
    return new aqyi();
  }
  
  @NonNull
  public static aqyi a(@Nullable String paramString)
  {
    aqyi localaqyi = new aqyi();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localaqyi.a = paramString.optInt("kingcard", localaqyi.a);
        localaqyi.f = paramString.optInt("gldrawable", localaqyi.f);
        localaqyi.b = paramString.optInt("webso_preload", localaqyi.b);
        localaqyi.c = paramString.optInt("webso_screenshot", localaqyi.c);
        localaqyi.g = paramString.optInt("etcdrawable", localaqyi.g);
        localaqyi.h = paramString.optInt("gldrawableEtcApng", localaqyi.h);
        localaqyi.d = paramString.optInt("livePreload", localaqyi.d);
        localaqyi.e = paramString.optInt("liveAllowSdk", localaqyi.e);
        localaqyi.i = paramString.optInt("limitTime", localaqyi.i);
        localaqyi.j = paramString.optInt("gldrawableMinSdk", localaqyi.j);
        localaqyi.k = paramString.optInt("supportVideoTheme", localaqyi.k);
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localaqyi.toString());
      }
      return localaqyi;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, "json parse error:" + paramString);
      }
    }
  }
  
  public int a()
  {
    return this.e;
  }
  
  public boolean a()
  {
    return this.f > 0;
  }
  
  public boolean a(int paramInt)
  {
    return paramInt >= this.j;
  }
  
  public int b()
  {
    return this.i;
  }
  
  public boolean b()
  {
    return this.g > 0;
  }
  
  public boolean c()
  {
    return this.h > 0;
  }
  
  public boolean d()
  {
    return this.d > 0;
  }
  
  public boolean e()
  {
    int m;
    if (this.k > 0) {
      m = 1;
    }
    while ((bhbt.a()) && (m != 0))
    {
      return true;
      if ((bhbt.b()) && (!bgln.g())) {
        m = 1;
      } else {
        m = 0;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return "QVipSDKConfig{gldrawable=" + this.f + ", etcdrawable=" + this.g + ", gldrawableEtcApng=" + this.h + ", kingCard=" + this.a + ", websoPreload=" + this.b + ", websoScreenshot=" + this.c + ", livePreload=" + this.d + ", liveAllowSdk=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqyi
 * JD-Core Version:    0.7.0.1
 */