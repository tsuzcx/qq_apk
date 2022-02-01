package com.tencent.liteav;

import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.text.SimpleDateFormat;
import java.util.Date;

public class j
{
  private String a = "";
  private String b = "";
  private int c = 0;
  private String d = "";
  private String e = "";
  private long f = 0L;
  
  private String a(String paramString)
  {
    if (paramString.contains("#EXT-TX-TS-START-TIME"))
    {
      int i = paramString.indexOf("#EXT-TX-TS-START-TIME:") + 22;
      if (i > 0)
      {
        paramString = paramString.substring(i);
        i = paramString.indexOf("#");
        if (i > 0) {
          return paramString.substring(0, i).replaceAll("\r\n", "");
        }
      }
    }
    return null;
  }
  
  public int a(String paramString1, String paramString2, int paramInt, j.a parama)
  {
    if ((paramString1 != null) && (!paramString1.isEmpty()))
    {
      this.d = TXCCommonUtil.getAppID();
      if (TextUtils.isEmpty(this.d)) {
        return -2;
      }
      AsyncTask.execute(new j.1(this, paramInt, paramString2, paramString1, parama));
      return 0;
    }
    return -1;
  }
  
  public long a()
  {
    return System.currentTimeMillis() - this.f;
  }
  
  public String a(long paramLong)
  {
    String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(this.f + paramLong * 1000L));
    int i = this.c;
    if (i < 0)
    {
      paramLong = (System.currentTimeMillis() - this.f - paramLong) / 1000L;
      return String.format("http://%s/timeshift/%s/%s/timeshift.m3u8?delay=%d", new Object[] { this.a, this.e, this.b, Long.valueOf(paramLong) });
    }
    return String.format("http://%s/%s/%s/timeshift.m3u8?starttime=%s&appid=%s&txKbps=0", new Object[] { this.a, Integer.valueOf(i), this.b, str, this.d });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.j
 * JD-Core Version:    0.7.0.1
 */