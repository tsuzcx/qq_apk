import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bjme
{
  protected static bjme a;
  
  public static bjme a()
  {
    try
    {
      if (a == null) {
        a = new bjme();
      }
      bjme localbjme = a;
      return localbjme;
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
      paramString1 = bjhh.a(String.valueOf(paramInt1), String.valueOf(paramInt2), String.valueOf(l), String.valueOf(paramInt3), paramString1, paramString2, paramString3, paramString4, paramString5);
      bjgx.a().a(paramLong.toString(), "GET", paramString1, true);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bundle paramBundle, String paramString6, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      bizw.a().a(Integer.valueOf(paramString1).intValue());
      label14:
      Object localObject = bjmf.a();
      String str = String.valueOf(bizw.a().a());
      if (!((String)localObject).equals(str))
      {
        bjmh.a().a((String)localObject, new bjmd(), null, true, paramBoolean2);
        bjmf.a(str);
      }
      localObject = new bjmd();
      ((bjmd)localObject).c = paramString4;
      ((bjmd)localObject).a = paramString2;
      ((bjmd)localObject).f = bjkj.a(bizw.a().a());
      ((bjmd)localObject).e = paramString5;
      ((bjmd)localObject).d = paramString1;
      ((bjmd)localObject).b = paramString3;
      ((bjmd)localObject).g = String.valueOf(System.currentTimeMillis());
      if (!TextUtils.isEmpty(paramString6)) {
        ((bjmd)localObject).h = paramString6;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OpenSdkStatic", 2, "reprotInfo = " + ((bjmd)localObject).toString());
      }
      bjmh.a().a(str, (bjmd)localObject, paramBundle, paramBoolean1, paramBoolean2);
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramString1, paramString2, paramString3, paramString4, bizw.a().f(), null, paramString5, paramBoolean1, paramBoolean2);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, bizw.a().f(), null, "", paramBoolean, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjme
 * JD-Core Version:    0.7.0.1
 */