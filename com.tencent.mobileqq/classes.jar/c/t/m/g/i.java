package c.t.m.g;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class i
  implements e
{
  public String a;
  public byte[] b;
  public Map<String, String> c;
  public boolean d = true;
  public int e = -1;
  public String f = "";
  public int g = 0;
  public boolean h = true;
  CountDownLatch i = new CountDownLatch(1);
  public volatile boolean j = false;
  public long k;
  private volatile boolean l = false;
  private aj m;
  
  public i(String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.f = ch.d();
  }
  
  public final String a()
  {
    return this.f;
  }
  
  public final void a(aj paramaj)
  {
    try
    {
      this.m = paramaj;
      return;
    }
    finally
    {
      paramaj = finally;
      throw paramaj;
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      this.c.put(paramString1, paramString2);
    }
  }
  
  public final void b()
  {
    this.g = 15000;
  }
  
  public final boolean c()
  {
    try
    {
      boolean bool = this.i.await(this.g, TimeUnit.MILLISECONDS);
      return bool;
    }
    catch (InterruptedException localInterruptedException) {}
    return true;
  }
  
  public final aj d()
  {
    try
    {
      aj localaj = this.m;
      return localaj;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("url:" + this.a);
    localStringBuilder.append(",body:" + ch.b(this.b));
    localStringBuilder.append(",isGet:false");
    localStringBuilder.append(",timeout:" + this.e);
    localStringBuilder.append(",tag:" + null);
    localStringBuilder.append(",httpCallback:" + null);
    localStringBuilder.append(",testMode:0");
    localStringBuilder.append(",httpCallback:" + null);
    localStringBuilder.append(",testMode:0");
    localStringBuilder.append(",followRedirects:" + this.d);
    localStringBuilder.append(",isAbort:false");
    localStringBuilder.append(",headers:" + this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.i
 * JD-Core Version:    0.7.0.1
 */