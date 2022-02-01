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
  private Context jdField_a_of_type_AndroidContentContext;
  private AsyncCallBack jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public HtmlOffline$TransUrl(Context paramContext, String paramString, AsyncCallBack paramAsyncCallBack)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramAsyncCallBack != null))
    {
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack = paramAsyncCallBack;
      this.b = Uri.parse(paramString).getQueryParameter("_bid");
      return;
    }
    if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
      HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "new TransUrl error");
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a())
    {
      localObject = HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("transThread callback mode:");
      localStringBuilder.append(paramInt);
      ((ILog)localObject).a("HtmlCheckUpdate", 2, localStringBuilder.toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentBizCommonOfflineAsyncCallBack;
    if (localObject != null) {
      ((AsyncCallBack)localObject).loaded(paramInt, paramString);
    }
  }
  
  private boolean a()
  {
    String str = OfflineEnvHelper.b(this.b);
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    Context localContext = this.jdField_a_of_type_AndroidContentContext;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("html5/");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append(".zip");
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(this.b);
    localStringBuilder.append(".zip");
    return HtmlOffline.a(localContext, (String)localObject, localStringBuilder.toString());
  }
  
  public void a()
  {
    if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a())
    {
      localObject1 = HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("-->offline:doTransUrl start:");
      ((StringBuilder)localObject2).append(this.b);
      ((ILog)localObject1).a("HtmlCheckUpdate", 2, ((StringBuilder)localObject2).toString());
    }
    int i1 = 0;
    HtmlOffline.jdField_a_of_type_Int = 0;
    long l3 = System.currentTimeMillis();
    Object localObject1 = OfflineEnvHelper.a(this.b);
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl,html root dir is null!");
      }
      a(this.jdField_a_of_type_JavaLangString, 0);
      HtmlOffline.a(this.b, 2, 0L, -1, "lixian_cover", "0");
      BidDownloader.a(0, this.b, 2, 0, "lixian_cover", 0);
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(this.b);
    String str1 = ((StringBuilder)localObject2).toString();
    Object localObject3 = HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.b);
    localObject2 = HtmlOffline.a(this.b);
    long l1;
    if (localObject2 != null)
    {
      j = HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.b);
      i = j;
      if (j != 1)
      {
        l1 = ((JSONObject)localObject2).optLong("expired", 0L);
        i = j;
        if (l1 > 0L)
        {
          i = j;
          if (l3 > l1) {
            i = 1;
          }
        }
      }
      if (i == 1)
      {
        HtmlOffline.jdField_a_of_type_Int = 1;
        Util.a(str1);
        HtmlOffline.a(this.jdField_a_of_type_AndroidContentContext, this.b, 0);
        if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
          HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl,expire =1");
        }
      }
    }
    if (!HtmlOffline.b(this.b))
    {
      localObject1 = localObject2;
      if (localObject2 != null) {}
    }
    else
    {
      localObject2 = HtmlOffline.a(this.b);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        l1 = ((JSONObject)localObject2).optLong("expired", 0L);
        localObject1 = localObject2;
        if (l1 > 0L)
        {
          localObject1 = localObject2;
          if (l3 > l1)
          {
            if (HtmlOffline.jdField_a_of_type_Int == 0) {
              HtmlOffline.jdField_a_of_type_Int = 1;
            }
            Util.a(str1);
            localObject1 = localObject2;
            if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a())
            {
              HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl,zip expire =1");
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    int n;
    int k;
    if (localObject3 != null)
    {
      n = ((JSONObject)localObject3).optInt("version", 0);
      l1 = ((JSONObject)localObject3).optLong("expired", 0L);
      if ((l1 > 0L) && (l3 > l1)) {
        k = 1;
      } else {
        k = 0;
      }
    }
    else
    {
      k = 0;
      n = 0;
    }
    int m;
    if (localObject1 != null) {
      m = ((JSONObject)localObject1).optInt("version", 0);
    } else {
      m = 0;
    }
    int i2 = 3;
    if ((n == 0) && (m == 0))
    {
      if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline:doTransUrl:no package in both asset and data dir!");
      }
      if (HtmlOffline.jdField_a_of_type_Int == 0) {
        HtmlOffline.jdField_a_of_type_Int = 3;
      }
      HtmlOffline.a(str1, this.b);
      a(this.jdField_a_of_type_JavaLangString, 0);
      localObject3 = this.b;
      i = NetworkUtil.getNetWorkType();
      if (localObject1 == null) {
        localObject2 = "0";
      } else {
        localObject2 = "1";
      }
      HtmlOffline.a((String)localObject3, 5, 0L, i, "lixian_cover", (String)localObject2);
      localObject2 = this.b;
      if (localObject1 == null) {
        i = 0;
      } else {
        i = 1;
      }
      BidDownloader.a(0, (String)localObject2, 5, 0, "lixian_cover", i);
      return;
    }
    if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a())
    {
      localObject2 = HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("-->offline:getVersion :");
      ((StringBuilder)localObject3).append(String.valueOf(n));
      ((StringBuilder)localObject3).append(",");
      ((StringBuilder)localObject3).append(String.valueOf(m));
      ((ILog)localObject2).a("HtmlCheckUpdate", 2, ((StringBuilder)localObject3).toString());
    }
    int i3 = 6;
    localObject2 = localObject1;
    int j = m;
    int i = i3;
    if (m < n)
    {
      localObject2 = localObject1;
      j = m;
      i = i3;
      if (k == 0) {
        if (a())
        {
          if (HtmlOffline.b(this.b))
          {
            localObject2 = HtmlOffline.a(this.b);
            if (localObject2 != null)
            {
              j = ((JSONObject)localObject2).optInt("version", 0);
              i = i3;
            }
            else
            {
              i = 10;
              j = m;
            }
          }
          else
          {
            i = 9;
            localObject2 = localObject1;
            j = m;
          }
        }
        else
        {
          i = 8;
          j = m;
          localObject2 = localObject1;
        }
      }
    }
    if (j < n)
    {
      if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a()) {
        HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a("HtmlCheckUpdate", 2, "-->offline,doTransUrl:SD card update fail.");
      }
      if (HtmlOffline.jdField_a_of_type_Int == 0) {
        HtmlOffline.jdField_a_of_type_Int = 4;
      }
      HtmlOffline.a(str1, this.b);
      a(this.jdField_a_of_type_JavaLangString, 0);
      localObject3 = this.b;
      l1 = j;
      k = NetworkUtil.getNetWorkType();
      if (localObject2 == null) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      HtmlOffline.a((String)localObject3, i, l1, k, "lixian_cover", (String)localObject1);
      localObject1 = this.b;
      if (localObject2 == null) {
        k = 0;
      } else {
        k = 1;
      }
      BidDownloader.a(0, (String)localObject1, i, j, "lixian_cover", k);
      return;
    }
    if (localObject2 != null) {
      i = ((JSONObject)localObject2).optInt("loadmode", 1);
    } else {
      i = 1;
    }
    localObject3 = this.jdField_a_of_type_JavaLangString;
    String str2 = HtmlOffline.d((String)localObject3);
    if (i == 2)
    {
      localObject1 = localObject3;
      if (!((String)localObject3).contains("_lv="))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("_lv=");
        ((StringBuilder)localObject1).append(j);
        localObject1 = HtmlOffline.a((String)localObject3, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      k = this.jdField_a_of_type_JavaLangString.indexOf(":");
      localObject1 = this.jdField_a_of_type_JavaLangString.substring(k + 3);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("file://");
      ((StringBuilder)localObject3).append(str1);
      ((StringBuilder)localObject3).append("/");
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject1 = ((StringBuilder)localObject3).toString();
      if (!((String)localObject1).contains("_lv="))
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("_lv=");
        ((StringBuilder)localObject3).append(j);
        ((StringBuilder)localObject3).append("&_t=");
        ((StringBuilder)localObject3).append(System.currentTimeMillis());
        localObject1 = HtmlOffline.a((String)localObject1, ((StringBuilder)localObject3).toString());
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(str1);
      ((StringBuilder)localObject3).append("/");
      ((StringBuilder)localObject3).append(str2);
      if (!new File(((StringBuilder)localObject3).toString()).exists()) {
        localObject1 = this.jdField_a_of_type_JavaLangString;
      }
    }
    if (localObject2 != null) {
      k = ((JSONObject)localObject2).optInt("verifyType", 0);
    } else {
      k = 0;
    }
    long l2;
    if (new File(str1).exists())
    {
      if (HtmlOffline.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
        HtmlOffline.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      }
      l1 = System.currentTimeMillis();
      boolean bool;
      if ((i == 2) && (k == 1))
      {
        if (!TextUtils.isEmpty(str2))
        {
          bool = OfflineSecurity.b(str2, str1, this.b);
          i = i2;
        }
        else
        {
          bool = false;
        }
        l2 = System.currentTimeMillis() - l1;
        l1 = 0L;
      }
      else
      {
        bool = OfflineSecurity.a(str1, this.b);
        l1 = System.currentTimeMillis() - l1;
        l2 = 0L;
      }
      if (!bool)
      {
        if (HtmlOffline.jdField_a_of_type_Int == 0) {
          HtmlOffline.jdField_a_of_type_Int = 5;
        }
        HtmlOffline.a(str1, this.b);
        localObject1 = this.jdField_a_of_type_JavaLangString;
        if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a())
        {
          localObject2 = HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("-->offline:trans VerifyFile fail :");
          ((StringBuilder)localObject3).append(this.b);
          ((ILog)localObject2).a("HtmlCheckUpdate", 2, ((StringBuilder)localObject3).toString());
        }
        j = 0;
        i = i1;
      }
    }
    else
    {
      l2 = 0L;
      l1 = 0L;
    }
    a((String)localObject1, i);
    if (j > 0)
    {
      long l5 = System.currentTimeMillis();
      localObject1 = this.b;
      long l4 = j;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("");
      l3 = l5 - l3;
      ((StringBuilder)localObject2).append(l3);
      HtmlOffline.a((String)localObject1, 0, l4, -1, "lixian_cover", ((StringBuilder)localObject2).toString());
      BidDownloader.a(0, this.b, 0, j, "lixian_cover", 0);
      if (HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog.a())
      {
        localObject1 = HtmlOffline.jdField_a_of_type_ComTencentBizCommonOfflineUtilILog;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("trans time:");
        ((StringBuilder)localObject2).append(l3);
        ((ILog)localObject1).a("HtmlCheckUpdate", 2, ((StringBuilder)localObject2).toString());
      }
      if (l2 > 0L)
      {
        HtmlOffline.a(this.b, Long.valueOf(l2).intValue(), 1L, -1, "lixian_cover_sec", "");
        BidDownloader.a(0, this.b, 0, 0, "lixian_cover_sec", 1);
        return;
      }
      if (l1 > 0L)
      {
        HtmlOffline.a(this.b, Long.valueOf(l1).intValue(), 2L, -1, "lixian_cover_sec", "");
        BidDownloader.a(0, this.b, 0, 0, "lixian_cover_sec", 2);
      }
    }
    else
    {
      HtmlOffline.a(this.b, 7, j, NetworkUtil.getNetWorkType(), "lixian_cover", "0");
      BidDownloader.a(0, this.b, 7, j, "lixian_cover", 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.TransUrl
 * JD-Core Version:    0.7.0.1
 */