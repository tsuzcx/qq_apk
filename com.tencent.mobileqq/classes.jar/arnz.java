import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arnz
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
  public static arnz a()
  {
    return new arnz();
  }
  
  @NonNull
  public static arnz a(@Nullable String paramString)
  {
    arnz localarnz = new arnz();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localarnz.a = paramString.optInt("kingcard", localarnz.a);
        localarnz.f = paramString.optInt("gldrawable", localarnz.f);
        localarnz.b = paramString.optInt("webso_preload", localarnz.b);
        localarnz.c = paramString.optInt("webso_screenshot", localarnz.c);
        localarnz.g = paramString.optInt("etcdrawable", localarnz.g);
        localarnz.h = paramString.optInt("gldrawableEtcApng", localarnz.h);
        localarnz.d = paramString.optInt("livePreload", localarnz.d);
        localarnz.e = paramString.optInt("liveAllowSdk", localarnz.e);
        localarnz.i = paramString.optInt("limitTime", localarnz.i);
        localarnz.j = paramString.optInt("gldrawableMinSdk", localarnz.j);
        localarnz.k = paramString.optInt("supportVideoTheme", localarnz.k);
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localarnz.toString());
      }
      return localarnz;
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
    while ((bicd.a()) && (m != 0))
    {
      return true;
      if ((bicd.b()) && (!bhlo.g())) {
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
 * Qualified Name:     arnz
 * JD-Core Version:    0.7.0.1
 */