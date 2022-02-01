package com.tencent.featuretoggle.hltxkg.access.http.a;

import android.text.TextUtils;
import com.tencent.featuretoggle.hltxkg.access.http.IHttpCallback;
import com.tencent.featuretoggle.hltxkg.access.http.IHttpRequest;
import com.tencent.featuretoggle.hltxkg.common.a.k;
import com.tencent.featuretoggle.hltxkg.common.b.a.f;
import com.tencent.featuretoggle.hltxkg.common.e.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class d
  implements IHttpRequest
{
  private int jdField_a_of_type_Int = 0;
  private f jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF;
  private Object jdField_a_of_type_JavaLangObject;
  public String a;
  private CountDownLatch jdField_a_of_type_JavaUtilConcurrentCountDownLatch = new CountDownLatch(1);
  public byte[] b;
  public Map<String, String> c;
  public boolean d = false;
  public boolean e = true;
  public int f = -1;
  public String g = "";
  public IHttpCallback h;
  public k i;
  public volatile boolean j = false;
  public int k = 0;
  public boolean l = true;
  public volatile boolean m = false;
  public String n;
  
  public d(String paramString, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.b = paramArrayOfByte;
    this.g = c.c();
  }
  
  public final void a(e parame)
  {
    if (!this.j) {
      this.h.onHttpResponse(this, parame);
    }
  }
  
  public final void a(f paramf)
  {
    try
    {
      this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF = paramf;
      return;
    }
    finally
    {
      paramf = finally;
      throw paramf;
    }
  }
  
  public final boolean a()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.await(this.k, TimeUnit.MILLISECONDS);
      return bool;
    }
    catch (InterruptedException localInterruptedException)
    {
      label18:
      break label18;
    }
    return true;
  }
  
  public final void abort()
  {
    this.j = true;
    k localk = this.i;
    if (localk != null) {
      localk.b();
    }
  }
  
  public final void b()
  {
    this.jdField_a_of_type_JavaUtilConcurrentCountDownLatch.countDown();
  }
  
  public final f c()
  {
    try
    {
      f localf = this.jdField_a_of_type_ComTencentFeaturetoggleHltxkgCommonBAF;
      return localf;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void enableRetry(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public final Object getTag()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public final String getUniqueId()
  {
    return this.g;
  }
  
  public final void setAppScene(String paramString)
  {
    this.n = paramString;
  }
  
  public final void setFollowRedirects(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final void setForceRetTimeout(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.k = paramInt;
  }
  
  public final void setHttpHeader(String paramString1, String paramString2)
  {
    if (this.c == null) {
      this.c = new HashMap();
    }
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      this.c.put(paramString1, paramString2);
    }
  }
  
  public final void setHttpMethod(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public final void setMode(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final void setTag(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public final void setTimeout(int paramInt)
  {
    this.f = paramInt;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder("url:");
    localStringBuilder2.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",body:");
    localStringBuilder2.append(c.b(this.b));
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",isGet:");
    localStringBuilder2.append(this.d);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",timeout:");
    localStringBuilder2.append(this.f);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",tag:");
    localStringBuilder2.append(this.jdField_a_of_type_JavaLangObject);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",httpCallback:");
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",testMode:");
    localStringBuilder2.append(this.jdField_a_of_type_Int);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",httpCallback:");
    localStringBuilder2.append(this.h);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",testMode:");
    localStringBuilder2.append(this.jdField_a_of_type_Int);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",followRedirects:");
    localStringBuilder2.append(this.e);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",isAbort:");
    localStringBuilder2.append(this.j);
    localStringBuilder1.append(localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder(",headers:");
    localStringBuilder2.append(this.c);
    localStringBuilder1.append(localStringBuilder2.toString());
    return localStringBuilder1.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.access.http.a.d
 * JD-Core Version:    0.7.0.1
 */