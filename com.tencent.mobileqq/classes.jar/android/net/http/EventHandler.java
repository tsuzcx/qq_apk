package android.net.http;

public abstract interface EventHandler
{
  public static final int ERROR = -1;
  public static final int ERROR_AUTH = -4;
  public static final int ERROR_BAD_URL = -12;
  public static final int ERROR_CONNECT = -6;
  public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
  public static final int ERROR_IO = -7;
  public static final int ERROR_LOOKUP = -2;
  public static final int ERROR_PROXYAUTH = -5;
  public static final int ERROR_REDIRECT_LOOP = -9;
  public static final int ERROR_TIMEOUT = -8;
  public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
  public static final int ERROR_UNSUPPORTED_SCHEME = -10;
  public static final int FILE_ERROR = -13;
  public static final int FILE_NOT_FOUND_ERROR = -14;
  public static final int OK = 0;
  public static final int TOO_MANY_REQUESTS_ERROR = -15;
  
  public abstract void certificate(SslCertificate paramSslCertificate);
  
  public abstract void data(byte[] paramArrayOfByte, int paramInt);
  
  public abstract void endData();
  
  public abstract void error(int paramInt, String paramString);
  
  public abstract boolean handleSslErrorRequest(SslError paramSslError);
  
  public abstract void headers(Headers paramHeaders);
  
  public abstract void status(int paramInt1, int paramInt2, int paramInt3, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.net.http.EventHandler
 * JD-Core Version:    0.7.0.1
 */