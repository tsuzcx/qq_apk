import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class arlh
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
  public static arlh a()
  {
    return new arlh();
  }
  
  @NonNull
  public static arlh a(@Nullable String paramString)
  {
    arlh localarlh = new arlh();
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = new JSONObject(paramString);
        localarlh.a = paramString.optInt("kingcard", localarlh.a);
        localarlh.f = paramString.optInt("gldrawable", localarlh.f);
        localarlh.b = paramString.optInt("webso_preload", localarlh.b);
        localarlh.c = paramString.optInt("webso_screenshot", localarlh.c);
        localarlh.g = paramString.optInt("etcdrawable", localarlh.g);
        localarlh.h = paramString.optInt("gldrawableEtcApng", localarlh.h);
        localarlh.d = paramString.optInt("livePreload", localarlh.d);
        localarlh.e = paramString.optInt("liveAllowSdk", localarlh.e);
        localarlh.i = paramString.optInt("limitTime", localarlh.i);
        localarlh.j = paramString.optInt("gldrawableMinSdk", localarlh.j);
        localarlh.k = paramString.optInt("supportVideoTheme", localarlh.k);
        localarlh.l = paramString.optInt("optimizeTheme", localarlh.l);
      }
      if (QLog.isColorLevel()) {
        QLog.e("QVIP.SDK.ConfigProcessor", 1, " : " + localarlh.toString());
      }
      return localarlh;
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
    while ((bhrj.a()) && (m != 0))
    {
      return true;
      if ((bhrj.b()) && (!DeviceInfoUtil.isLowPerfDevice())) {
        m = 1;
      } else {
        m = 0;
      }
    }
    return false;
  }
  
  public boolean f()
  {
    return (bhrj.a()) && (this.l > 0);
  }
  
  public String toString()
  {
    return "QVipSDKConfig{gldrawable=" + this.f + ", etcdrawable=" + this.g + ", gldrawableEtcApng=" + this.h + ", kingCard=" + this.a + ", websoPreload=" + this.b + ", websoScreenshot=" + this.c + ", livePreload=" + this.d + ", liveAllowSdk=" + this.e + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     arlh
 * JD-Core Version:    0.7.0.1
 */