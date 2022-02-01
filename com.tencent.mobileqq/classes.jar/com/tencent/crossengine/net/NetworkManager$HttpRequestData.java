package com.tencent.crossengine.net;

import android.util.Pair;
import androidx.annotation.Keep;
import java.util.ArrayList;
import java.util.List;

@Keep
public class NetworkManager$HttpRequestData
{
  public static final int AUTU_BAISC = 1;
  public static final int AUTU_DIGEST = 2;
  public static final int AUTU_NEGOTIATE = 3;
  public static final int AUTU_NTLM = 4;
  public static final int HTTP_METHOD_GET = 0;
  public static final int HTTP_METHOD_POST = 1;
  public int authMethod;
  public String authPass;
  public String authUser;
  public NetworkManager.Callback callback;
  public long connectionTimeout;
  public final List<Pair<String, String>> cookies = new ArrayList();
  public boolean followRedirect;
  public final List<Pair<String, String>> header = new ArrayList();
  public int maxRedirects;
  public int method;
  public final List<Object> multiParts = new ArrayList();
  public String postBody;
  public String proxyPass;
  public String proxyUrl;
  public String proxyUser;
  public String referrer;
  public long timeout;
  public String url;
  public String userAgent;
  
  private void addMultiPartData(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    NetworkManager.MultiPartData localMultiPartData = new NetworkManager.MultiPartData();
    localMultiPartData.jdField_a_of_type_JavaLangString = paramString1;
    localMultiPartData.b = paramString2;
    localMultiPartData.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.multiParts.add(localMultiPartData);
  }
  
  private void addMultiPartFile(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    NetworkManager.MultiPartFile localMultiPartFile = new NetworkManager.MultiPartFile();
    localMultiPartFile.jdField_a_of_type_JavaLangString = paramString1;
    localMultiPartFile.b = paramString2;
    localMultiPartFile.c = paramString3;
    localMultiPartFile.d = paramString4;
    this.multiParts.add(localMultiPartFile);
  }
  
  private void addMultiPartString(String paramString1, String paramString2, String paramString3)
  {
    NetworkManager.MultiPartString localMultiPartString = new NetworkManager.MultiPartString();
    localMultiPartString.jdField_a_of_type_JavaLangString = paramString1;
    localMultiPartString.b = paramString2;
    localMultiPartString.c = paramString3;
    this.multiParts.add(localMultiPartString);
  }
  
  private static void addPairList(List<Pair<String, String>> paramList, String paramString1, String paramString2)
  {
    paramList.add(new Pair(paramString1, paramString2));
  }
  
  private void setCallback(long paramLong)
  {
    this.callback = new NetworkManager.Callback(paramLong, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.net.NetworkManager.HttpRequestData
 * JD-Core Version:    0.7.0.1
 */