package com.tencent.map.sdk.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.exception.NetUnavailableException;
import com.tencent.map.tools.net.http.HttpCanceler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public final class qb
  extends qa
{
  private static t b;
  private u c;
  
  protected final NetResponse a(String paramString1, String paramString2, int paramInt1, int paramInt2, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler)
  {
    if (b == null) {
      throw new IOException("HttpClient Init Failed and is Null");
    }
    paramString1 = b.a(paramString1, null);
    if (paramInt1 > 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramString1.b(bool);
      paramString1.a(paramInt2);
      paramString1.b(paramInt2);
      paramString1.a(true);
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1.a("User-Agent", paramString2);
      }
      if ((paramHashMap == null) || (paramHashMap.isEmpty())) {
        break;
      }
      paramString2 = paramHashMap.entrySet().iterator();
      while (paramString2.hasNext())
      {
        paramHashMap = (Map.Entry)paramString2.next();
        if (paramHashMap != null) {
          paramString1.a((String)paramHashMap.getKey(), (String)paramHashMap.getValue());
        }
      }
    }
    if (paramHttpCanceler != null)
    {
      paramHttpCanceler.setHttpAccessRequest(this, new qb.1(this));
      this.c = paramString1;
    }
    paramString1 = b.a(paramString1);
    paramInt1 = paramString1.c();
    paramInt2 = paramString1.a();
    paramString2 = new NetResponse();
    paramString2.statusCode = paramInt1;
    paramString2.errorCode = paramInt2;
    if ((paramInt2 == 0) && (paramInt1 == 200))
    {
      paramString2.data = paramString1.d();
      paramString2.charset = a(paramString1.a("Content-Type"));
      return paramString2;
    }
    paramString1 = "errorCode:" + paramInt2 + ", statusCode:" + paramInt1 + ", detailErrorInfo:" + paramString1.b();
    if (paramInt2 == -4) {}
    for (paramString1 = new NetUnavailableException(paramString1);; paramString1 = new qk(paramString1)) {
      throw paramString1;
    }
  }
  
  protected final NetResponse a(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    if (b == null) {
      throw new IOException("HttpClient Init Failed and is Null");
    }
    paramString1 = b.a(paramString1, paramArrayOfByte);
    paramString1.a(false);
    paramString1.b(true);
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.a("User-Agent", paramString2);
    }
    paramString1 = b.a(paramString1);
    paramString2 = new NetResponse();
    int i = paramString1.c();
    int j = paramString1.a();
    paramString2.statusCode = i;
    paramString2.errorCode = j;
    if ((j == 0) && (i == 200))
    {
      paramString2.data = paramString1.d();
      paramString2.charset = a(paramString1.a("Content-Type"));
      return paramString2;
    }
    paramString1 = "errorCode" + j + ", statusCode:" + i + ", detailErrorInfo:" + paramString1.b();
    if (j == -4) {}
    for (paramString1 = new NetUnavailableException(paramString1);; paramString1 = new qk(paramString1)) {
      throw paramString1;
    }
  }
  
  protected final NetResponse a(String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt1, HashMap<String, String> paramHashMap, HttpCanceler paramHttpCanceler, int paramInt2)
  {
    boolean bool = false;
    if (b == null) {
      throw new IOException("HttpClient Init Failed and is Null");
    }
    paramString1 = b.a(paramString1, paramArrayOfByte);
    paramString1.a(false);
    if (paramInt1 > 0) {
      bool = true;
    }
    paramString1.b(bool);
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1.a("User-Agent", paramString2);
    }
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      paramString2 = paramHashMap.entrySet().iterator();
      while (paramString2.hasNext())
      {
        paramArrayOfByte = (Map.Entry)paramString2.next();
        if (paramArrayOfByte != null) {
          paramString1.a((String)paramArrayOfByte.getKey(), (String)paramArrayOfByte.getValue());
        }
      }
    }
    if (paramHttpCanceler != null)
    {
      paramHttpCanceler.setHttpAccessRequest(this, new qb.2(this));
      this.c = paramString1;
    }
    if (paramInt2 > 0)
    {
      paramString1.a(paramInt2);
      paramString1.b(paramInt2);
    }
    for (;;)
    {
      paramString1 = b.a(paramString1);
      paramInt1 = paramString1.c();
      paramInt2 = paramString1.a();
      if ((paramInt2 != 0) || (paramInt1 != 200)) {
        break;
      }
      paramString2 = new NetResponse();
      paramString2.data = paramString1.d();
      paramString2.charset = a(paramString1.a("Content-Type"));
      return paramString2;
      paramString1.a(10000);
      paramString1.b(10000);
    }
    paramString1 = "errorCode:" + paramInt2 + ", statusCode:" + paramInt1 + ", detailErrorInfo:" + paramString1.b();
    if (paramInt2 == -4)
    {
      paramString1 = new NetUnavailableException(paramString1);
      paramString1.errorCode = paramInt2;
      paramString1.statusCode = paramInt1;
      throw paramString1;
    }
    paramString1 = new qk(paramString1);
    paramString1.errorCode = paramInt2;
    paramString1.statusCode = paramInt1;
    throw paramString1;
  }
  
  protected final void a(Context paramContext, Bundle paramBundle)
  {
    if (b == null)
    {
      int i = 3203;
      String str2 = pz.a;
      String str1 = "android_vector_sdk_4.2.8.1";
      if (paramBundle != null)
      {
        i = paramBundle.getInt("halley_app_id");
        str2 = paramBundle.getString("halley_app_name");
        str1 = paramBundle.getString("halley_app_version");
      }
      b = p.a(new q(paramContext, i, str2, str1));
    }
  }
  
  protected final void a(String paramString1, byte[] paramArrayOfByte, String paramString2, String paramString3, String paramString4, String paramString5, HttpCanceler paramHttpCanceler)
  {
    if (b == null) {
      throw new IOException("HttpClient Init Failed and is Null");
    }
    paramString1 = b.a(paramString1, paramArrayOfByte);
    paramString1.a(false);
    paramString1.b(true);
    paramString1.a("User-Agent", "QQ Map Mobile");
    paramString1.a("Sign", paramString2);
    paramString1.a("nonce", paramString3);
    paramString1.a("timestamp", paramString4);
    paramString1.a("Range", "bytes=" + paramString5 + "-");
    if (paramHttpCanceler != null)
    {
      paramHttpCanceler.setHttpAccessRequest(this, new qb.3(this));
      this.c = paramString1;
    }
    paramString1 = b.a(paramString1);
    int i = paramString1.c();
    int j = paramString1.a();
    if ((j == 0) && (i == 200))
    {
      paramString1 = paramString1.a("User-ReturnCode");
      i = Integer.parseInt(paramString1);
      if (i != 0)
      {
        if (i == -2) {
          throw new qj();
        }
        throw new Exception("FileUploader user error:".concat(String.valueOf(paramString1)));
      }
    }
    else
    {
      paramString1 = "errorCode" + j + ", statusCode:" + i + ", detailErrorInfo:" + paramString1.b();
      if (j == -4)
      {
        paramString1 = new NetUnavailableException(paramString1);
        paramString1.errorCode = j;
        paramString1.statusCode = i;
        throw paramString1;
      }
      paramString1 = new qk(paramString1);
      paramString1.errorCode = j;
      paramString1.statusCode = i;
      throw paramString1;
    }
  }
  
  public final boolean cancel()
  {
    if (this.c != null)
    {
      this.c.a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.qb
 * JD-Core Version:    0.7.0.1
 */