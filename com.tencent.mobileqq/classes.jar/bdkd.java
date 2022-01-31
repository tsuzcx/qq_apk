import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bdkd
{
  protected static bdkd a;
  
  public static bdkd a()
  {
    try
    {
      if (a == null) {
        a = new bdkd();
      }
      bdkd localbdkd = a;
      return localbdkd;
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
      paramString1 = bdfb.a(String.valueOf(paramInt1), String.valueOf(paramInt2), String.valueOf(l), String.valueOf(paramInt3), paramString1, paramString2, paramString3, paramString4, paramString5);
      bdes.a().a(paramLong.toString(), "GET", paramString1, true);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bundle paramBundle, String paramString6, boolean paramBoolean)
  {
    try
    {
      bcyb.a().a(Integer.valueOf(paramString1).intValue());
      label14:
      Object localObject = bdke.a();
      String str = String.valueOf(bcyb.a().a());
      if (!((String)localObject).equals(str))
      {
        bdkg.a().a((String)localObject, new bdkc(), null, true);
        bdke.a(str);
      }
      localObject = new bdkc();
      ((bdkc)localObject).c = paramString4;
      ((bdkc)localObject).a = paramString2;
      ((bdkc)localObject).f = bdid.a(bcyb.a().a());
      ((bdkc)localObject).e = paramString5;
      ((bdkc)localObject).d = paramString1;
      ((bdkc)localObject).b = paramString3;
      ((bdkc)localObject).g = String.valueOf(System.currentTimeMillis());
      if (!TextUtils.isEmpty(paramString6)) {
        ((bdkc)localObject).h = paramString6;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OpenSdkStatic", 2, "reprotInfo = " + ((bdkc)localObject).toString());
      }
      bdkg.a().a((bdkc)localObject, paramBundle, paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, bcyb.a().f(), null, paramString5, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, bcyb.a().f(), null, "", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bdkd
 * JD-Core Version:    0.7.0.1
 */