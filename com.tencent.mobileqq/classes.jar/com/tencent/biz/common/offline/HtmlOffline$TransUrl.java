package com.tencent.biz.common.offline;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.offline.util.ILog;
import com.tencent.biz.common.util.OfflineSecurity;
import com.tencent.biz.common.util.Util;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class HtmlOffline$TransUrl
{
  private Context a;
  private String b;
  private AsyncCallBack c;
  private String d;
  
  public HtmlOffline$TransUrl(Context paramContext, String paramString, AsyncCallBack paramAsyncCallBack)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramAsyncCallBack != null))
    {
      this.a = paramContext;
      this.b = paramString;
      this.c = paramAsyncCallBack;
      this.d = Uri.parse(paramString).getQueryParameter("_bid");
      return;
    }
    if (HtmlOffline.f.a()) {
      HtmlOffline.f.a("HtmlCheckUpdate", 2, "new TransUrl error");
    }
  }
  
  private String a(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    if (paramInt2 == 2)
    {
      paramString1 = paramString2;
      if (!paramString2.contains("_lv="))
      {
        paramString1 = new StringBuilder();
        paramString1.append("_lv=");
        paramString1.append(paramInt1);
        return HtmlOffline.a(paramString2, paramString1.toString());
      }
    }
    else
    {
      paramInt2 = this.b.indexOf(":");
      paramString2 = this.b.substring(paramInt2 + 3);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file://");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString2);
      paramString2 = localStringBuilder.toString();
      if (!paramString2.contains("_lv="))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("_lv=");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("&_t=");
        localStringBuilder.append(System.currentTimeMillis());
        paramString2 = HtmlOffline.a(paramString2, localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString3);
      paramString1 = paramString2;
      if (!new File(localStringBuilder.toString()).exists()) {
        paramString1 = this.b;
      }
    }
    return paramString1;
  }
  
  private JSONObject a(long paramLong, String paramString, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject;
    if (!HtmlOffline.b(this.d))
    {
      localJSONObject = paramJSONObject;
      if (paramJSONObject != null) {}
    }
    else
    {
      paramJSONObject = HtmlOffline.c(this.d);
      localJSONObject = paramJSONObject;
      if (paramJSONObject != null)
      {
        long l = paramJSONObject.optLong("expired", 0L);
        localJSONObject = paramJSONObject;
        if (l > 0L)
        {
          localJSONObject = paramJSONObject;
          if (paramLong > l)
          {
            if (HtmlOffline.c == 0) {
              HtmlOffline.c = 1;
            }
            Util.a(paramString);
            HtmlOffline.i("-->offline:doTransUrl,zip expire =1");
            localJSONObject = paramJSONObject;
          }
        }
      }
    }
    return localJSONObject;
  }
  
  private void a(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    if (paramInt > 0)
    {
      long l2 = System.currentTimeMillis();
      Object localObject = this.d;
      long l1 = paramInt;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      paramLong1 = l2 - paramLong1;
      localStringBuilder.append(paramLong1);
      HtmlOffline.a((String)localObject, 0, l1, -1, "lixian_cover", localStringBuilder.toString());
      BidDownloader.a(0, this.d, 0, paramInt, "lixian_cover", 0);
      if (HtmlOffline.f.a())
      {
        localObject = HtmlOffline.f;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("trans time:");
        localStringBuilder.append(paramLong1);
        ((ILog)localObject).a("HtmlCheckUpdate", 2, localStringBuilder.toString());
      }
      if (paramLong2 > 0L)
      {
        HtmlOffline.a(this.d, Long.valueOf(paramLong2).intValue(), 1L, -1, "lixian_cover_sec", "");
        BidDownloader.a(0, this.d, 0, 0, "lixian_cover_sec", 1);
        return;
      }
      if (paramLong3 > 0L)
      {
        HtmlOffline.a(this.d, Long.valueOf(paramLong3).intValue(), 2L, -1, "lixian_cover_sec", "");
        BidDownloader.a(0, this.d, 0, 0, "lixian_cover_sec", 2);
      }
    }
    else
    {
      HtmlOffline.a(this.d, 7, paramInt, NetworkUtil.getNetWorkType(), "lixian_cover", "0");
      BidDownloader.a(0, this.d, 7, paramInt, "lixian_cover", 0);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (HtmlOffline.f.a())
    {
      localObject = HtmlOffline.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("transThread callback mode:");
      localStringBuilder.append(paramInt);
      ((ILog)localObject).a("HtmlCheckUpdate", 2, localStringBuilder.toString());
    }
    Object localObject = this.c;
    if (localObject != null) {
      ((AsyncCallBack)localObject).loaded(paramInt, paramString);
    }
  }
  
  private void b(long paramLong, String paramString, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      int j = HtmlOffline.c(this.a, this.d);
      int i = j;
      if (j != 1)
      {
        long l = paramJSONObject.optLong("expired", 0L);
        i = j;
        if (l > 0L)
        {
          i = j;
          if (paramLong > l) {
            i = 1;
          }
        }
      }
      if (i == 1)
      {
        HtmlOffline.c = 1;
        Util.a(paramString);
        HtmlOffline.a(this.a, this.d, 0);
        if (HtmlOffline.f.a()) {
          HtmlOffline.f.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl,expire =1");
        }
      }
    }
  }
  
  private boolean b()
  {
    String str = OfflineEnvHelper.c(this.d);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    Context localContext = this.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("html5/");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(".zip");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(this.d);
    localStringBuilder.append(".zip");
    return HtmlOffline.a(localContext, (String)localObject, localStringBuilder.toString());
  }
  
  public void a()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("-->offline:doTransUrl start:");
    ((StringBuilder)localObject1).append(this.d);
    HtmlOffline.i(((StringBuilder)localObject1).toString());
    HtmlOffline.c = 0;
    long l3 = System.currentTimeMillis();
    localObject1 = OfflineEnvHelper.b(this.d);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      HtmlOffline.i("-->offline:doTransUrl,html root dir is null!");
      a(this.b, 0);
      HtmlOffline.a(this.d, 2, 0L, -1, "lixian_cover", "0");
      BidDownloader.a(0, this.d, 2, 0, "lixian_cover", 0);
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.d);
    String str1 = ((StringBuilder)localObject2).toString();
    localObject2 = HtmlOffline.a(this.a, this.d);
    localObject1 = HtmlOffline.c(this.d);
    b(l3, str1, (JSONObject)localObject1);
    localObject1 = a(l3, str1, (JSONObject)localObject1);
    int k;
    long l1;
    if (localObject2 != null)
    {
      k = ((JSONObject)localObject2).optInt("version", 0);
      l1 = ((JSONObject)localObject2).optLong("expired", 0L);
      if ((l1 > 0L) && (l3 > l1)) {
        j = 1;
      } else {
        j = 0;
      }
    }
    else
    {
      j = 0;
      k = 0;
    }
    int i;
    if (localObject1 != null) {
      i = ((JSONObject)localObject1).optInt("version", 0);
    } else {
      i = 0;
    }
    int m = 3;
    if ((k == 0) && (i == 0))
    {
      HtmlOffline.i("-->offline:doTransUrl:no package in both asset and data dir!");
      if (HtmlOffline.c == 0) {
        HtmlOffline.c = 3;
      }
      HtmlOffline.d(str1, this.d);
      a(this.b, 0);
      str1 = this.d;
      i = NetworkUtil.getNetWorkType();
      if (localObject1 == null) {
        localObject2 = "0";
      } else {
        localObject2 = "1";
      }
      HtmlOffline.a(str1, 5, 0L, i, "lixian_cover", (String)localObject2);
      localObject2 = this.d;
      if (localObject1 == null) {
        i = 0;
      } else {
        i = 1;
      }
      BidDownloader.a(0, (String)localObject2, 5, 0, "lixian_cover", i);
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("-->offline:getVersion :");
    ((StringBuilder)localObject2).append(String.valueOf(k));
    ((StringBuilder)localObject2).append(",");
    ((StringBuilder)localObject2).append(String.valueOf(i));
    HtmlOffline.i(((StringBuilder)localObject2).toString());
    if ((i < k) && (j == 0)) {
      if (b())
      {
        if (HtmlOffline.b(this.d))
        {
          localObject1 = HtmlOffline.c(this.d);
          if (localObject1 != null)
          {
            i = ((JSONObject)localObject1).optInt("version", 0);
          }
          else
          {
            j = 10;
            break label491;
          }
        }
        else
        {
          j = 9;
          break label491;
        }
      }
      else
      {
        j = 8;
        break label491;
      }
    }
    int j = 6;
    label491:
    if (i < k)
    {
      HtmlOffline.i("-->offline,doTransUrl:SD card update fail.");
      if (HtmlOffline.c == 0) {
        HtmlOffline.c = 4;
      }
      HtmlOffline.d(str1, this.d);
      a(this.b, 0);
      str1 = this.d;
      l1 = i;
      k = NetworkUtil.getNetWorkType();
      if (localObject1 == null) {
        localObject2 = "0";
      } else {
        localObject2 = "1";
      }
      HtmlOffline.a(str1, j, l1, k, "lixian_cover", (String)localObject2);
      localObject2 = this.d;
      if (localObject1 == null) {
        k = 0;
      } else {
        k = 1;
      }
      BidDownloader.a(0, (String)localObject2, j, i, "lixian_cover", k);
      return;
    }
    if (localObject1 != null) {
      j = ((JSONObject)localObject1).optInt("loadmode", 1);
    } else {
      j = 1;
    }
    localObject2 = this.b;
    String str2 = HtmlOffline.g((String)localObject2);
    localObject2 = a(str1, i, j, (String)localObject2, str2);
    if (localObject1 != null) {
      k = ((JSONObject)localObject1).optInt("verifyType", 0);
    } else {
      k = 0;
    }
    long l2;
    if (new File(str1).exists())
    {
      if (HtmlOffline.g != null) {
        HtmlOffline.g.clear();
      }
      l1 = System.currentTimeMillis();
      boolean bool;
      if ((j == 2) && (k == 1))
      {
        if (!TextUtils.isEmpty(str2))
        {
          bool = OfflineSecurity.b(str2, str1, this.d);
          j = m;
        }
        else
        {
          bool = false;
        }
        l1 = System.currentTimeMillis() - l1;
        l2 = 0L;
      }
      else
      {
        bool = OfflineSecurity.a(str1, this.d);
        l2 = System.currentTimeMillis() - l1;
        l1 = 0L;
      }
      if (!bool)
      {
        if (HtmlOffline.c == 0) {
          HtmlOffline.c = 5;
        }
        HtmlOffline.d(str1, this.d);
        localObject1 = this.b;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("-->offline:trans VerifyFile fail :");
        ((StringBuilder)localObject2).append(this.d);
        HtmlOffline.i(((StringBuilder)localObject2).toString());
        i = 0;
        j = 0;
      }
      else
      {
        localObject1 = localObject2;
      }
    }
    else
    {
      l1 = 0L;
      l2 = 0L;
      localObject1 = localObject2;
    }
    a((String)localObject1, j);
    a(l3, i, l1, l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.TransUrl
 * JD-Core Version:    0.7.0.1
 */