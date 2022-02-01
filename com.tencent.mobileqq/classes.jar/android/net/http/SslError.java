package android.net.http;

import java.security.cert.X509Certificate;

public class SslError
{
  public static final int SSL_DATE_INVALID = 4;
  public static final int SSL_EXPIRED = 1;
  public static final int SSL_IDMISMATCH = 2;
  public static final int SSL_INVALID = 5;
  @Deprecated
  public static final int SSL_MAX_ERROR = 6;
  public static final int SSL_NOTYETVALID = 0;
  public static final int SSL_UNTRUSTED = 3;
  
  @Deprecated
  public SslError(int paramInt, SslCertificate paramSslCertificate)
  {
    throw new RuntimeException("Stub!");
  }
  
  public SslError(int paramInt, SslCertificate paramSslCertificate, String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  @Deprecated
  public SslError(int paramInt, X509Certificate paramX509Certificate)
  {
    throw new RuntimeException("Stub!");
  }
  
  public SslError(int paramInt, X509Certificate paramX509Certificate, String paramString)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean addError(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public SslCertificate getCertificate()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getPrimaryError()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getUrl()
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean hasError(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public String toString()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.net.http.SslError
 * JD-Core Version:    0.7.0.1
 */