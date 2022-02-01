package com.tencent.map.sdk.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;
import com.tencent.map.tools.net.NetAdapter;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.http.HttpCanceler;
import java.util.HashMap;

public abstract class qa
  implements NetAdapter
{
  protected Bundle a;
  
  protected static String a(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (localObject.contains("charset"))
        {
          paramString = localObject.split("=");
          if (paramString.length <= 1) {
            break;
          }
          return paramString[1].trim();
        }
        i += 1;
      }
    }
    return "GBK";
  }
  
  private static String b(String paramString)
  {
    Object localObject = paramString;
    if (Build.VERSION.SDK_INT >= 28)
    {
      localObject = paramString;
      if (paramString.startsWith("http://"))
      {
        localObject = new StringBuilder("https://");
        ((StringBuilder)localObject).append(paramString.substring(7));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  protected abstract NetResponse a(String paramString1, String paramString2, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler);
  
  protected abstract NetResponse a(String paramString1, String paramString2, byte[] paramArrayOfByte);
  
  protected abstract NetResponse a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler, int paramInt2);
  
  protected abstract void a(Context paramContext, Bundle paramBundle);
  
  public final void a(Bundle paramBundle)
  {
    this.a = paramBundle;
  }
  
  protected abstract void a(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4, String paramString5, HttpCanceler paramHttpCanceler);
  
  public NetResponse doGet(String paramString)
  {
    return doGet(paramString, "QQ Map Mobile");
  }
  
  public NetResponse doGet(String paramString, int paramInt, HttpCanceler paramHttpCanceler)
  {
    return doGet(paramString, "QQ Map Mobile", paramInt, null, paramHttpCanceler);
  }
  
  public NetResponse doGet(String paramString1, String paramString2)
  {
    return doGet(paramString1, paramString2, 1);
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt)
  {
    return doGet(paramString1, paramString2, paramInt, null);
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    try
    {
      paramString1 = a(b(paramString1), paramString2, paramInt1, paramInt2, paramHashMap, paramHttpCanceler);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return new NetResponse(paramString1);
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt, HttpCanceler paramHttpCanceler)
  {
    return doGet(paramString1, paramString2, paramInt, null, paramHttpCanceler);
  }
  
  public NetResponse doGet(String paramString1, String paramString2, int paramInt, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    return doGet(paramString1, paramString2, paramInt, 10000, paramHashMap, paramHttpCanceler);
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    return doPost(paramString1, paramString2, paramArrayOfByte, 1);
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt)
  {
    return doPost(paramString1, paramString2, paramArrayOfByte, paramInt, null);
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    try
    {
      paramString1 = a(b(paramString1), paramString2, paramArrayOfByte, paramInt1, paramHashMap, paramHttpCanceler, paramInt2);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return new NetResponse(paramString1);
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, HttpCanceler paramHttpCanceler)
  {
    return doPost(paramString1, paramString2, paramArrayOfByte, paramInt, null, paramHttpCanceler);
  }
  
  public NetResponse doPost(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    return doPost(paramString1, paramString2, paramArrayOfByte, paramInt, 0, paramHashMap, paramHttpCanceler);
  }
  
  public NetResponse doPost(String paramString, byte[] paramArrayOfByte)
  {
    return doPost(paramString, "QQ Map Mobile", paramArrayOfByte);
  }
  
  public NetResponse doPost(String paramString, byte[] paramArrayOfByte, int paramInt, HttpCanceler paramHttpCanceler)
  {
    return doPost(paramString, "QQ Map Mobile", paramArrayOfByte, paramInt, null, paramHttpCanceler);
  }
  
  public NetResponse doPostNoBuffer(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    try
    {
      paramString1 = a(b(paramString1), paramString2, paramArrayOfByte);
      return paramString1;
    }
    catch (Exception paramString1) {}
    return new NetResponse(paramString1);
  }
  
  public void doRangePost(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4, String paramString5, HttpCanceler paramHttpCanceler)
  {
    try
    {
      a(b(paramString1), paramArrayOfByte, paramString2, paramString3, paramString4, paramString5, paramHttpCanceler);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void initNet(Context paramContext)
  {
    try
    {
      a(paramContext, this.a);
      return;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder("initNet error:");
      localStringBuilder.append(paramContext.toString());
      Log.e("NetImpl", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.qa
 * JD-Core Version:    0.7.0.1
 */