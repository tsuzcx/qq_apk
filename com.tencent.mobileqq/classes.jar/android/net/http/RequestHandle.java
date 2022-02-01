package android.net.http;

import android.net.compatibility.WebAddress;
import java.io.InputStream;
import java.util.Map;

public class RequestHandle
{
  public static final int MAX_REDIRECT_COUNT = 16;
  
  public RequestHandle(RequestQueue paramRequestQueue, String paramString1, WebAddress paramWebAddress, String paramString2, Map<String, String> paramMap, InputStream paramInputStream, int paramInt, Request paramRequest)
  {
    throw new RuntimeException("Stub!");
  }
  
  public RequestHandle(RequestQueue paramRequestQueue, String paramString1, WebAddress paramWebAddress, String paramString2, Map<String, String> paramMap, InputStream paramInputStream, int paramInt, Request paramRequest, Connection paramConnection)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static String authorizationHeader(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public static String computeBasicAuthResponse(String paramString1, String paramString2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void cancel()
  {
    throw new RuntimeException("Stub!");
  }
  
  public String getMethod()
  {
    throw new RuntimeException("Stub!");
  }
  
  public int getRedirectCount()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void handleSslErrorResponse(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean isRedirectMax()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void pauseRequest(boolean paramBoolean)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void processRequest()
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setRedirectCount(int paramInt)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setupBasicAuthResponse(boolean paramBoolean, String paramString1, String paramString2)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void setupDigestAuthResponse(boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    throw new RuntimeException("Stub!");
  }
  
  public boolean setupRedirect(String paramString, int paramInt, Map<String, String> paramMap)
  {
    throw new RuntimeException("Stub!");
  }
  
  public void waitUntilComplete()
  {
    throw new RuntimeException("Stub!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.net.http.RequestHandle
 * JD-Core Version:    0.7.0.1
 */