import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class aqhx
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
  private int l = 1;
  
  @NonNull
  public static aqhx a()
  {
    return new aqhx();
  }
  
  @NonNull
  public static aqhx a(@Nullable String paramString)
  {
    aqhx localaqhx = new aqhx();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localaqhx.a = paramString.optInt("kingcard", localaqhx.a);
        localaqhx.f = paramString.optInt("gldrawable", localaqhx.f);
        localaqhx.b = paramString.optInt("webso_preload", localaqhx.b);
        localaqhx.c = paramString.optInt("webso_screenshot", localaqhx.c);
        localaqhx.g = paramString.optInt("etcdrawable", localaqhx.g);
        localaqhx.h = paramString.optInt("gldrawableEtcApng", localaqhx.h);
        localaqhx.d = paramString.optInt("livePreload", localaqhx.d);
        localaqhx.e = paramString.optInt("liveAllowSdk", localaqhx.e);
        localaqhx.i = paramString.optInt("limitTime", localaqhx.i);
        localaqhx.j = paramString.optInt("gldrawableMinSdk", localaqhx.j);
        localaqhx.k = paramString.optInt("supportVideoTheme", localaqhx.k);
        localaqhx.l = paramString.optInt("optimizeTheme", localaqhx.l);
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localaqhx.toString());
      }
      return localaqhx;
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
    while ((bgio.a()) && (m != 0))
    {
      return true;
      if ((bgio.b()) && (!DeviceInfoUtil.isLowPerfDevice())) {
        m = 1;
      } else {
        m = 0;
      }
    }
    return false;
  }
  
  public boolean f()
  {
    return (bgio.a()) && (this.l > 0);
  }
  
  public String toString()
  {
    return "QVipSDKConfig{gldrawable=" + this.f + ", etcdrawable=" + this.g + ", gldrawableEtcApng=" + this.h + ", kingCard=" + this.a + ", websoPreload=" + this.b + ", websoScreenshot=" + this.c + ", livePreload=" + this.d + ", liveAllowSdk=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqhx
 * JD-Core Version:    0.7.0.1
 */