package com.tencent.featuretoggle.hltxkg.access.http.a;

import com.tencent.featuretoggle.hltxkg.access.http.IHttpResponse;
import com.tencent.featuretoggle.hltxkg.common.b.a.f;
import java.util.Map;

public final class e
  implements IHttpResponse
{
  private f a;
  
  public e(f paramf)
  {
    this.a = paramf;
  }
  
  public final Map<String, String> getAllHeaders()
  {
    return this.a.a();
  }
  
  public final int getErrorCode()
  {
    return this.a.a;
  }
  
  public final String getErrorInfo()
  {
    return this.a.b;
  }
  
  public final byte[] getHttpBody()
  {
    return this.a.d;
  }
  
  public final int getHttpBodyLen()
  {
    if (this.a.d != null) {
      return this.a.d.length;
    }
    return 0;
  }
  
  public final String getHttpHeader(String paramString)
  {
    return this.a.a(paramString);
  }
  
  public final int getHttpStatus()
  {
    return this.a.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.access.http.a.e
 * JD-Core Version:    0.7.0.1
 */