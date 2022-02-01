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
  public d g;
  public ab h;
  public volatile boolean i = false;
  public int j = 0;
  public boolean k = true;
  CountDownLatch l = new CountDownLatch(1);
  public volatile boolean m = false;
  public long n;
  private boolean o = false;
  private int p = 0;
  private ao q;
  
  public i(String paramString, byte[] paramArrayOfByte)
  {
    this.a = paramString;
    this.b = paramArrayOfByte;
    this.f = cn.d();
  }
  
  public final String a()
  {
    return this.f;
  }
  
  public final void a(ao paramao)
  {
    try
    {
      this.q = paramao;
      return;
    }
    finally
    {
      paramao = finally;
      throw paramao;
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
    this.j = 15000;
  }
  
  public final boolean c()
  {
    try
    {
      boolean bool = this.l.await(this.j, TimeUnit.MILLISECONDS);
      return bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      label18:
      break label18;
    }
    return true;
  }
  
  public final ao d()
  {
    try
    {
      ao localao = this.q;
      return localao;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("url:");
    localStringBuilder2.append(this.a);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",body:");
    localStringBuilder2.append(cn.b(this.b));
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",isGet:false");
    localStringBuilder2 = new StringBuilder(",timeout:");
    localStringBuilder2.append(this.e);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",tag:");
    localStringBuilder2.append(null);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",httpCallback:");
    localStringBuilder2.append(null);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",testMode:0");
    localStringBuilder2 = new StringBuilder(",httpCallback:");
    localStringBuilder2.append(null);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder1.append(",testMode:0");
    localStringBuilder2 = new StringBuilder(",followRedirects:");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",isAbort:");
    localStringBuilder2.append(this.i);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",headers:");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.i
 * JD-Core Version:    0.7.0.1
 */