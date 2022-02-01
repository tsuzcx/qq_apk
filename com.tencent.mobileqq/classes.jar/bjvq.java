import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bjvq
{
  protected static bjvq a;
  
  public static bjvq a()
  {
    try
    {
      if (a == null) {
        a = new bjvq();
      }
      bjvq localbjvq = a;
      return localbjvq;
    }
    finally {}
  }
  
  public void a(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, Long paramLong, int paramInt2, int paramInt3, String paramString5)
  {
    long l = SystemClock.elapsedRealtime() - paramLong.longValue();
    if ((paramLong.longValue() == 0L) || (l < 0L)) {
      l = 0L;
    }
    for (;;)
    {
      paramLong = new StringBuffer("https://c.isdspeed.qq.com/code.cgi");
      paramLong.append("?domain=mobile.opensdk.com&cgi=opensdk&type=").append(paramInt1).append("&code=").append(paramInt2).append("&time=").append(l).append("&rate=").append(paramInt3).append("&uin=").append(paramString2).append("&data=");
      paramString1 = bjqq.a(String.valueOf(paramInt1), String.valueOf(paramInt2), String.valueOf(l), String.valueOf(paramInt3), paramString1, paramString2, paramString3, paramString4, paramString5);
      bjqh.a().a(paramLong.toString(), "GET", paramString1, true);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bundle paramBundle, String paramString6, boolean paramBoolean)
  {
    try
    {
      bjjo.a().a(Integer.valueOf(paramString1).intValue());
      label14:
      Object localObject = bjvr.a();
      String str = String.valueOf(bjjo.a().a());
      if (!((String)localObject).equals(str))
      {
        bjvt.a().a((String)localObject, new bjvp(), null, true);
        bjvr.a(str);
      }
      localObject = new bjvp();
      ((bjvp)localObject).c = paramString4;
      ((bjvp)localObject).a = paramString2;
      ((bjvp)localObject).f = bjts.a(bjjo.a().a());
      ((bjvp)localObject).e = paramString5;
      ((bjvp)localObject).d = paramString1;
      ((bjvp)localObject).b = paramString3;
      ((bjvp)localObject).g = String.valueOf(System.currentTimeMillis());
      if (!TextUtils.isEmpty(paramString6)) {
        ((bjvp)localObject).h = paramString6;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OpenSdkStatic", 2, "reprotInfo = " + ((bjvp)localObject).toString());
      }
      bjvt.a().a((bjvp)localObject, paramBundle, paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, bjjo.a().f(), null, paramString5, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, bjjo.a().f(), null, "", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjvq
 * JD-Core Version:    0.7.0.1
 */