import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class bcfn
{
  protected static bcfn a;
  
  public static bcfn a()
  {
    try
    {
      if (a == null) {
        a = new bcfn();
      }
      bcfn localbcfn = a;
      return localbcfn;
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
      paramString1 = bcam.a(String.valueOf(paramInt1), String.valueOf(paramInt2), String.valueOf(l), String.valueOf(paramInt3), paramString1, paramString2, paramString3, paramString4, paramString5);
      bcad.a().a(paramLong.toString(), "GET", paramString1, true);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Bundle paramBundle, String paramString6, boolean paramBoolean)
  {
    try
    {
      bbtm.a().a(Integer.valueOf(paramString1).intValue());
      label14:
      Object localObject = bcfo.a();
      String str = String.valueOf(bbtm.a().a());
      if (!((String)localObject).equals(str))
      {
        bcfq.a().a((String)localObject, new bcfm(), null, true);
        bcfo.a(str);
      }
      localObject = new bcfm();
      ((bcfm)localObject).c = paramString4;
      ((bcfm)localObject).a = paramString2;
      ((bcfm)localObject).f = bcdn.a(bbtm.a().a());
      ((bcfm)localObject).e = paramString5;
      ((bcfm)localObject).d = paramString1;
      ((bcfm)localObject).b = paramString3;
      ((bcfm)localObject).g = String.valueOf(System.currentTimeMillis());
      if (!TextUtils.isEmpty(paramString6)) {
        ((bcfm)localObject).h = paramString6;
      }
      if (QLog.isColorLevel()) {
        QLog.d("OpenSdkStatic", 2, "reprotInfo = " + ((bcfm)localObject).toString());
      }
      bcfq.a().a((bcfm)localObject, paramBundle, paramBoolean);
      return;
    }
    catch (Exception localException)
    {
      break label14;
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, bbtm.a().f(), null, paramString5, paramBoolean);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    a(paramString1, paramString2, paramString3, paramString4, bbtm.a().f(), null, "", paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcfn
 * JD-Core Version:    0.7.0.1
 */