import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bfja
{
  protected static bfja a;
  
  public static bfja a()
  {
    try
    {
      if (a == null) {
        a = new bfja();
      }
      bfja localbfja = a;
      return localbfja;
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
      paramString1 = bfdz.a(String.valueOf(paramInt1), String.valueOf(paramInt2), String.valueOf(l), String.valueOf(paramInt3), paramString1, paramString2, paramString3, paramString4, paramString5);
      bfdq.a().a(paramLong.toString(), "GET", paramString1, true);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bundle paramBundle, String paramString6, boolean paramBoolean)
  {
    try
    {
      bexd.a().a(Integer.valueOf(paramString1).intValue());
      label14:
      Object localObject = bfjb.a();
      String str = String.valueOf(bexd.a().a());
      if (!((String)localObject).equals(str))
      {
        bfjd.a().a((String)localObject, new bfiz(), null, true);
        bfjb.a(str);
      }
      localObject = new bfiz();
      ((bfiz)localObject).c = paramString4;
      ((bfiz)localObject).a = paramString2;
      ((bfiz)localObject).f = bfhb.a(bexd.a().a());
      ((bfiz)localObject).e = paramString5;
      ((bfiz)localObject).d = paramString1;
      ((bfiz)localObject).b = paramString3;
      ((bfiz)localObject).g = String.valueOf(System.currentTimeMillis());
      if (!TextUtils.isEmpty(paramString6)) {
        ((bfiz)localObject).h = paramString6;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OpenSdkStatic", 2, "reprotInfo = " + ((bfiz)localObject).toString());
      }
      bfjd.a().a((bfiz)localObject, paramBundle, paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, bexd.a().f(), null, paramString5, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, bexd.a().f(), null, "", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfja
 * JD-Core Version:    0.7.0.1
 */