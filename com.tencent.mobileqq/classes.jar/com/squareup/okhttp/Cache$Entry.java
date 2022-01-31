package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache.Editor;
import com.squareup.okhttp.internal.DiskLruCache.Snapshot;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.List;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;

final class Cache$Entry
{
  private final int code;
  private final Handshake handshake;
  private final String message;
  private final Protocol protocol;
  private final String requestMethod;
  private final Headers responseHeaders;
  private final String url;
  private final Headers varyHeaders;
  
  public Cache$Entry(Response paramResponse)
  {
    this.url = paramResponse.request().urlString();
    this.varyHeaders = OkHeaders.varyHeaders(paramResponse);
    this.requestMethod = paramResponse.request().method();
    this.protocol = paramResponse.protocol();
    this.code = paramResponse.code();
    this.message = paramResponse.message();
    this.responseHeaders = paramResponse.headers();
    this.handshake = paramResponse.handshake();
  }
  
  public Cache$Entry(Source paramSource)
  {
    try
    {
      BufferedSource localBufferedSource1 = Okio.buffer(paramSource);
      this.url = localBufferedSource1.readUtf8LineStrict();
      this.requestMethod = localBufferedSource1.readUtf8LineStrict();
      Object localObject = new Headers.Builder();
      int k = Cache.access$1000(localBufferedSource1);
      int i = 0;
      while (i < k)
      {
        ((Headers.Builder)localObject).addLenient(localBufferedSource1.readUtf8LineStrict());
        i += 1;
      }
      this.varyHeaders = ((Headers.Builder)localObject).build();
      localObject = StatusLine.parse(localBufferedSource1.readUtf8LineStrict());
      this.protocol = ((StatusLine)localObject).protocol;
      this.code = ((StatusLine)localObject).code;
      this.message = ((StatusLine)localObject).message;
      localObject = new Headers.Builder();
      k = Cache.access$1000(localBufferedSource1);
      i = j;
      while (i < k)
      {
        ((Headers.Builder)localObject).addLenient(localBufferedSource1.readUtf8LineStrict());
        i += 1;
      }
      this.responseHeaders = ((Headers.Builder)localObject).build();
      if (isHttps())
      {
        localObject = localBufferedSource1.readUtf8LineStrict();
        if (((String)localObject).length() > 0) {
          throw new IOException("expected \"\" but was \"" + (String)localObject + "\"");
        }
      }
    }
    finally
    {
      paramSource.close();
    }
    for (this.handshake = Handshake.get(localBufferedSource2.readUtf8LineStrict(), readCertificateList(localBufferedSource2), readCertificateList(localBufferedSource2));; this.handshake = null)
    {
      paramSource.close();
      return;
    }
  }
  
  private boolean isHttps()
  {
    return this.url.startsWith("https://");
  }
  
  /* Error */
  private List<Certificate> readCertificateList(BufferedSource paramBufferedSource)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 95	com/squareup/okhttp/Cache:access$1000	(Lokio/BufferedSource;)I
    //   4: istore_3
    //   5: iload_3
    //   6: iconst_m1
    //   7: if_icmpne +11 -> 18
    //   10: invokestatic 168	java/util/Collections:emptyList	()Ljava/util/List;
    //   13: astore 4
    //   15: aload 4
    //   17: areturn
    //   18: ldc 170
    //   20: invokestatic 176	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   23: astore 6
    //   25: new 178	java/util/ArrayList
    //   28: dup
    //   29: iload_3
    //   30: invokespecial 181	java/util/ArrayList:<init>	(I)V
    //   33: astore 5
    //   35: iconst_0
    //   36: istore_2
    //   37: aload 5
    //   39: astore 4
    //   41: iload_2
    //   42: iload_3
    //   43: if_icmpge -28 -> 15
    //   46: aload_1
    //   47: invokeinterface 86 1 0
    //   52: astore 4
    //   54: new 183	okio/Buffer
    //   57: dup
    //   58: invokespecial 184	okio/Buffer:<init>	()V
    //   61: astore 7
    //   63: aload 7
    //   65: aload 4
    //   67: invokestatic 190	okio/ByteString:decodeBase64	(Ljava/lang/String;)Lokio/ByteString;
    //   70: invokevirtual 194	okio/Buffer:write	(Lokio/ByteString;)Lokio/Buffer;
    //   73: pop
    //   74: aload 5
    //   76: aload 6
    //   78: aload 7
    //   80: invokevirtual 198	okio/Buffer:inputStream	()Ljava/io/InputStream;
    //   83: invokevirtual 202	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   86: invokeinterface 208 2 0
    //   91: pop
    //   92: iload_2
    //   93: iconst_1
    //   94: iadd
    //   95: istore_2
    //   96: goto -59 -> 37
    //   99: astore_1
    //   100: new 122	java/io/IOException
    //   103: dup
    //   104: aload_1
    //   105: invokevirtual 211	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
    //   108: invokespecial 139	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	Entry
    //   0	112	1	paramBufferedSource	BufferedSource
    //   36	60	2	i	int
    //   4	40	3	j	int
    //   13	53	4	localObject	Object
    //   33	42	5	localArrayList	java.util.ArrayList
    //   23	54	6	localCertificateFactory	java.security.cert.CertificateFactory
    //   61	18	7	localBuffer	okio.Buffer
    // Exception table:
    //   from	to	target	type
    //   18	35	99	java/security/cert/CertificateException
    //   46	92	99	java/security/cert/CertificateException
  }
  
  private void writeCertList(BufferedSink paramBufferedSink, List<Certificate> paramList)
  {
    try
    {
      paramBufferedSink.writeDecimalLong(paramList.size());
      paramBufferedSink.writeByte(10);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        paramBufferedSink.writeUtf8(ByteString.of(((Certificate)paramList.get(i)).getEncoded()).base64());
        paramBufferedSink.writeByte(10);
        i += 1;
      }
      return;
    }
    catch (CertificateEncodingException paramBufferedSink)
    {
      throw new IOException(paramBufferedSink.getMessage());
    }
  }
  
  public boolean matches(Request paramRequest, Response paramResponse)
  {
    return (this.url.equals(paramRequest.urlString())) && (this.requestMethod.equals(paramRequest.method())) && (OkHeaders.varyMatches(paramResponse, this.varyHeaders, paramRequest));
  }
  
  public Response response(Request paramRequest, DiskLruCache.Snapshot paramSnapshot)
  {
    paramRequest = this.responseHeaders.get("Content-Type");
    String str = this.responseHeaders.get("Content-Length");
    Request localRequest = new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
    return new Response.Builder().request(localRequest).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new Cache.CacheResponseBody(paramSnapshot, paramRequest, str)).handshake(this.handshake).build();
  }
  
  public void writeTo(DiskLruCache.Editor paramEditor)
  {
    int j = 0;
    paramEditor = Okio.buffer(paramEditor.newSink(0));
    paramEditor.writeUtf8(this.url);
    paramEditor.writeByte(10);
    paramEditor.writeUtf8(this.requestMethod);
    paramEditor.writeByte(10);
    paramEditor.writeDecimalLong(this.varyHeaders.size());
    paramEditor.writeByte(10);
    int k = this.varyHeaders.size();
    int i = 0;
    while (i < k)
    {
      paramEditor.writeUtf8(this.varyHeaders.name(i));
      paramEditor.writeUtf8(": ");
      paramEditor.writeUtf8(this.varyHeaders.value(i));
      paramEditor.writeByte(10);
      i += 1;
    }
    paramEditor.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString());
    paramEditor.writeByte(10);
    paramEditor.writeDecimalLong(this.responseHeaders.size());
    paramEditor.writeByte(10);
    k = this.responseHeaders.size();
    i = j;
    while (i < k)
    {
      paramEditor.writeUtf8(this.responseHeaders.name(i));
      paramEditor.writeUtf8(": ");
      paramEditor.writeUtf8(this.responseHeaders.value(i));
      paramEditor.writeByte(10);
      i += 1;
    }
    if (isHttps())
    {
      paramEditor.writeByte(10);
      paramEditor.writeUtf8(this.handshake.cipherSuite());
      paramEditor.writeByte(10);
      writeCertList(paramEditor, this.handshake.peerCertificates());
      writeCertList(paramEditor, this.handshake.localCertificates());
    }
    paramEditor.close();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.squareup.okhttp.Cache.Entry
 * JD-Core Version:    0.7.0.1
 */