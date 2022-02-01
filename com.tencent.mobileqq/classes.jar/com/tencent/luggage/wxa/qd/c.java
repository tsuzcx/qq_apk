package com.tencent.luggage.wxa.qd;

import com.tencent.luggage.wxa.qz.o;
import com.tencent.qqmusic.mediaplayer.network.IMediaHTTPConnection;
import java.net.URL;
import java.util.HashMap;

public class c
  extends com.tencent.luggage.wxa.gv.b
{
  private IMediaHTTPConnection a;
  private com.tencent.luggage.wxa.if.b b;
  
  public c(IMediaHTTPConnection paramIMediaHTTPConnection, com.tencent.luggage.wxa.if.b paramb)
  {
    this.a = paramIMediaHTTPConnection;
    this.b = paramb;
  }
  
  public int a(long paramLong, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    IMediaHTTPConnection localIMediaHTTPConnection = this.a;
    if (localIMediaHTTPConnection != null) {
      return localIMediaHTTPConnection.readAt(paramLong, paramArrayOfByte, paramInt1, paramInt2);
    }
    return super.a(paramLong, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public com.tencent.luggage.wxa.if.b a()
  {
    return this.b;
  }
  
  public void b()
  {
    if (this.a != null)
    {
      Object localObject = null;
      try
      {
        URL localURL = new URL(this.b.b);
        localObject = localURL;
      }
      catch (Exception localException)
      {
        o.a("MicroMsg.Audio.AudioHttpDownloadSource", localException, "connect", new Object[0]);
      }
      HashMap localHashMap = new HashMap();
      this.a.connect(localObject, localHashMap);
    }
  }
  
  public void c()
  {
    IMediaHTTPConnection localIMediaHTTPConnection = this.a;
    if (localIMediaHTTPConnection != null) {
      localIMediaHTTPConnection.disconnect();
    }
  }
  
  public long d()
  {
    IMediaHTTPConnection localIMediaHTTPConnection = this.a;
    if (localIMediaHTTPConnection != null) {
      return localIMediaHTTPConnection.getSize();
    }
    return super.d();
  }
  
  public String e()
  {
    IMediaHTTPConnection localIMediaHTTPConnection = this.a;
    if (localIMediaHTTPConnection != null) {
      return localIMediaHTTPConnection.getMIMEType();
    }
    return super.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qd.c
 * JD-Core Version:    0.7.0.1
 */