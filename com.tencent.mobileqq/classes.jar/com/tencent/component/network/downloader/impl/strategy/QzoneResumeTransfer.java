package com.tencent.component.network.downloader.impl.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.tencent.component.network.downloader.UrlKeyGenerator;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.utils.Base64;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

public class QzoneResumeTransfer
  implements ResumeTransfer
{
  private Context jdField_a_of_type_AndroidContentContext;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private UrlKeyGenerator jdField_a_of_type_ComTencentComponentNetworkDownloaderUrlKeyGenerator;
  private FileCacheService jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  public Map a;
  public boolean a;
  private String[] jdField_a_of_type_ArrayOfJavaLangString = { "a[0-9].qpic.cn", "m.qpic.cn", ".*qzonestyle.gtimg.cn", ".*qzs.qq.com", ".*i.gtimg.cn", "a\\d+.photo.store.qq.com", "b\\d+.photo.store.qq.com", "vqzone.tc.qq.com", "vwecam.tc.qq.com" };
  private Map jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
  private boolean jdField_b_of_type_Boolean = false;
  
  public QzoneResumeTransfer(Context paramContext, String paramString, FileCacheService paramFileCacheService, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService = paramFileCacheService;
    this.jdField_b_of_type_Boolean = paramBoolean;
    d();
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext);
      b();
    }
  }
  
  private QzoneResumeTransfer.CacheFileAttribute a(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return null;
    }
    return (QzoneResumeTransfer.CacheFileAttribute)this.jdField_b_of_type_JavaUtilMap.get(paramString);
  }
  
  private QzoneResumeTransfer.CacheFileAttribute a(HttpResponse paramHttpResponse, Response paramResponse)
  {
    Header localHeader = null;
    Object localObject = null;
    if ((paramHttpResponse == null) && (paramResponse == null)) {
      return null;
    }
    if (paramHttpResponse != null)
    {
      paramResponse = paramHttpResponse.getEntity();
      if (paramResponse == null) {
        break label133;
      }
      paramResponse = paramResponse.getContentType();
      if (paramResponse == null) {
        break label133;
      }
    }
    label133:
    for (paramResponse = paramResponse.getValue();; paramResponse = null)
    {
      localHeader = paramHttpResponse.getFirstHeader("Last-Modified");
      paramHttpResponse = paramResponse;
      if (localHeader != null)
      {
        localObject = localHeader.getValue();
        paramHttpResponse = paramResponse;
      }
      for (;;)
      {
        return new QzoneResumeTransfer.CacheFileAttribute(paramHttpResponse, (String)localObject);
        if (paramResponse != null)
        {
          localObject = paramResponse.body();
          paramHttpResponse = localHeader;
          if (localObject != null)
          {
            localObject = ((ResponseBody)localObject).contentType();
            paramHttpResponse = localHeader;
            if (localObject != null) {
              paramHttpResponse = ((MediaType)localObject).toString();
            }
          }
          localObject = paramResponse.header("Last-Modified");
        }
        else
        {
          paramHttpResponse = null;
        }
      }
    }
  }
  
  private boolean a(File paramFile)
  {
    if ((paramFile == null) || (!paramFile.exists())) {}
    long l;
    do
    {
      return false;
      l = paramFile.lastModified();
      l = System.currentTimeMillis() - l;
    } while ((l < 0L) || (l > 86400000L));
    return true;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return true;
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
        return false;
      }
    } while (this.jdField_a_of_type_JavaUtilList.contains(paramString2));
    paramString1 = this.jdField_a_of_type_JavaUtilMap.entrySet().iterator();
    while (paramString1.hasNext()) {
      if (Utils.match((Pattern)((Map.Entry)paramString1.next()).getValue(), paramString2)) {
        this.jdField_a_of_type_JavaUtilList.add(paramString2);
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(String paramString, HttpResponse paramHttpResponse, Response paramResponse)
  {
    long l4 = 0L;
    if (((paramHttpResponse == null) || (paramHttpResponse.getStatusLine() == null) || (paramHttpResponse.getStatusLine().getStatusCode() != 206)) && ((paramResponse == null) || (paramResponse.code() != 206))) {
      return true;
    }
    Object localObject;
    long l1;
    if (paramHttpResponse != null)
    {
      localObject = paramHttpResponse.getEntity();
      if (localObject == null) {
        break label264;
      }
      l1 = ((HttpEntity)localObject).getContentLength();
    }
    for (;;)
    {
      localObject = null;
      label105:
      int i;
      if (paramHttpResponse != null)
      {
        paramResponse = paramHttpResponse.getFirstHeader("Content-Range");
        paramHttpResponse = (HttpResponse)localObject;
        if (paramResponse != null) {
          paramHttpResponse = paramResponse.getValue();
        }
        if (TextUtils.isEmpty(paramHttpResponse)) {
          break label258;
        }
        i = paramHttpResponse.indexOf("/");
      }
      for (;;)
      {
        for (;;)
        {
          try
          {
            i = Integer.valueOf(paramHttpResponse.substring(i + 1)).intValue();
            l2 = i;
          }
          catch (Exception paramHttpResponse)
          {
            long l3;
            l2 = 0L;
            continue;
          }
          paramString = c(paramString);
          paramString = this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService.a(paramString);
          l3 = l4;
          if (paramString != null)
          {
            l3 = l4;
            if (paramString.exists()) {
              l3 = paramString.length();
            }
          }
          if (l3 + l1 != l2) {
            break label256;
          }
          return true;
          if (paramResponse != null)
          {
            localObject = paramResponse.body();
            if (localObject != null) {
              try
              {
                l1 = ((ResponseBody)localObject).contentLength();
              }
              catch (IOException localIOException)
              {
                localIOException.printStackTrace();
              }
            }
          }
        }
        l1 = 0L;
        break;
        paramHttpResponse = localIOException;
        if (paramResponse == null) {
          break label105;
        }
        paramHttpResponse = paramResponse.header("Content-Range");
        break label105;
        label256:
        return false;
        label258:
        long l2 = 0L;
      }
      label264:
      l1 = 0L;
    }
  }
  
  private String b(String paramString)
  {
    paramString = c(paramString);
    if (paramString == null) {
      return null;
    }
    paramString = (QzoneResumeTransfer.CacheFileAttribute)this.jdField_b_of_type_JavaUtilMap.get(paramString);
    if (paramString != null) {
      return paramString.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  private void b()
  {
    localObject3 = null;
    localObject1 = null;
    Object localObject4 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString("contenttype_" + this.jdField_a_of_type_JavaLangString, null);
    if (localObject4 != null) {}
    try
    {
      localObject4 = Utils.unmarshall(Base64.a((String)localObject4, 0));
      localObject1 = localObject4;
      localObject3 = localObject4;
      this.jdField_b_of_type_JavaUtilMap.clear();
      localObject1 = localObject4;
      localObject3 = localObject4;
      ((Parcel)localObject4).readMap(this.jdField_b_of_type_JavaUtilMap, this.jdField_a_of_type_AndroidContentContext.getClassLoader());
      if (localObject4 == null) {
        break label93;
      }
      localObject1 = localObject4;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localObject3 = localObject1;
        QDLog.d("download", "download", localThrowable);
        if (localObject1 == null) {}
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label141;
      }
      localObject3.recycle();
    }
    localObject1.recycle();
    label93:
    if (this.jdField_b_of_type_JavaUtilMap == null) {
      this.jdField_b_of_type_JavaUtilMap = new HashMap();
    }
  }
  
  private String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_ComTencentComponentNetworkDownloaderUrlKeyGenerator;
    if (localObject == null)
    {
      localObject = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label44;
      }
    }
    for (;;)
    {
      return String.valueOf(paramString.hashCode());
      localObject = ((UrlKeyGenerator)localObject).a(paramString);
      break;
      label44:
      paramString = (String)localObject;
    }
  }
  
  private void c()
  {
    localObject3 = null;
    localObject1 = null;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject1 = localParcel;
      localObject3 = localParcel;
      localParcel.writeMap(this.jdField_b_of_type_JavaUtilMap);
      localObject1 = localParcel;
      localObject3 = localParcel;
      String str = new String(Base64.b(localParcel.marshall(), 0));
      localObject1 = localParcel;
      localObject3 = localParcel;
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString("contenttype_" + this.jdField_a_of_type_JavaLangString, str).commit();
      if (localParcel == null) {
        break label100;
      }
      localObject1 = localParcel;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label100:
        localObject3 = localObject1;
        QDLog.c("QzoneResumeTransfer", "saveConfig", localException);
        if (localObject1 == null) {}
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label130;
      }
      localObject3.recycle();
    }
    localObject1.recycle();
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaUtilMap.clear();
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      Pattern localPattern = Pattern.compile(this.jdField_a_of_type_ArrayOfJavaLangString[i], 2);
      this.jdField_a_of_type_JavaUtilMap.put(this.jdField_a_of_type_ArrayOfJavaLangString[i], localPattern);
      i += 1;
    }
  }
  
  public String a(String paramString)
  {
    paramString = this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService.a(c(paramString));
    if ((paramString != null) && (paramString.exists())) {
      return paramString.getPath();
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService.a();
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilMap.clear();
      c();
      return;
    }
  }
  
  public void a(UrlKeyGenerator paramUrlKeyGenerator)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderUrlKeyGenerator = paramUrlKeyGenerator;
  }
  
  public void a(String arg1)
  {
    String str = c(???);
    this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService.a(str);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilMap.remove(str);
      c();
      return;
    }
  }
  
  public void a(String paramString1, String arg2, HttpResponse paramHttpResponse, Response paramResponse)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(???))) {}
    do
    {
      return;
      ??? = new File(???);
    } while ((!???.exists()) || (???.length() <= 0L) || (!this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService.a(c(paramString1))) || (!this.jdField_b_of_type_Boolean) || ((paramHttpResponse == null) && (paramResponse == null)));
    paramHttpResponse = a(paramHttpResponse, paramResponse);
    paramResponse = new StringBuilder().append("Downloader Resume Response url:").append(paramString1).append(" curr:");
    if (paramHttpResponse != null) {}
    for (??? = paramHttpResponse.toString();; ??? = "N/A")
    {
      QDLog.a("downloader", ???);
      if (paramHttpResponse == null) {
        break;
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (!paramHttpResponse.equals((QzoneResumeTransfer.CacheFileAttribute)this.jdField_b_of_type_JavaUtilMap.get(c(paramString1))))
        {
          this.jdField_b_of_type_JavaUtilMap.put(c(paramString1), paramHttpResponse);
          c();
        }
        return;
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      synchronized (this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService)
      {
        this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService.a(c(paramString));
        if (!this.jdField_b_of_type_Boolean) {}
      }
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_b_of_type_JavaUtilMap.containsKey(c(paramString)))
      {
        this.jdField_b_of_type_JavaUtilMap.remove(c(paramString));
        c();
      }
      return;
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(HttpGet paramHttpGet, Request.Builder paramBuilder, String paramString1, String paramString2)
  {
    if (!a(paramString1, paramString2)) {
      return;
    }
    paramString2 = c(paramString1);
    File localFile = this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService.a(paramString2);
    long l;
    if ((localFile != null) && (localFile.exists())) {
      if (a(localFile))
      {
        l = localFile.length();
        paramString2 = b(paramString1);
        if (l > 0L)
        {
          if (this.jdField_b_of_type_Boolean) {
            break label223;
          }
          if (paramHttpGet == null) {
            break label181;
          }
          paramHttpGet.addHeader("Range", "bytes=" + l + "-");
        }
      }
    }
    for (;;)
    {
      QDLog.b("downloader", "Downloader Resume --- begin range:" + l + " Accept:" + paramString2 + " url:" + paramString1);
      return;
      this.jdField_a_of_type_ComTencentComponentNetworkModuleCacheFileFileCacheService.a(paramString2);
      l = 0L;
      break;
      label181:
      if (paramBuilder != null)
      {
        paramBuilder.addHeader("Range", "bytes=" + l + "-");
        continue;
        label223:
        if (!TextUtils.isEmpty(paramString2)) {
          if (paramHttpGet != null)
          {
            paramHttpGet.addHeader("Range", "bytes=" + l + "-");
            paramHttpGet.addHeader("Accept", paramString2);
            paramHttpGet.addHeader("Q-Accept", paramString2);
          }
          else if (paramBuilder != null)
          {
            paramBuilder.addHeader("Range", "bytes=" + l + "-");
            paramBuilder.addHeader("Accept", paramString2);
            paramBuilder.addHeader("Q-Accept", paramString2);
          }
        }
      }
    }
  }
  
  public void a(String[] paramArrayOfString, boolean paramBoolean)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
      return;
    }
    if (!paramBoolean) {}
    String[] arrayOfString;
    for (this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;; this.jdField_a_of_type_ArrayOfJavaLangString = arrayOfString)
    {
      d();
      return;
      int i = this.jdField_a_of_type_ArrayOfJavaLangString.length;
      int j = paramArrayOfString.length + i;
      arrayOfString = new String[j];
      i = 0;
      if (i < j)
      {
        if (i < this.jdField_a_of_type_ArrayOfJavaLangString.length) {
          arrayOfString[i] = this.jdField_a_of_type_ArrayOfJavaLangString[i];
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfString[i] = paramArrayOfString[(i - this.jdField_a_of_type_ArrayOfJavaLangString.length)];
        }
      }
    }
  }
  
  public boolean a(String paramString1, String paramString2, HttpResponse paramHttpResponse, Response paramResponse)
  {
    if ((!this.jdField_b_of_type_Boolean) || (!a(paramString1, paramString2))) {
      return true;
    }
    if ((TextUtils.isEmpty(paramString1)) || ((paramHttpResponse == null) && (paramResponse == null))) {
      return false;
    }
    if (!a(paramString1, paramHttpResponse, paramResponse)) {
      return false;
    }
    paramString2 = a(paramString1);
    if (paramString2 == null) {
      return true;
    }
    paramHttpResponse = a(paramHttpResponse, paramResponse);
    if (QDLog.b())
    {
      paramResponse = new StringBuilder().append("download content-type check url:").append(paramString1).append(" old:");
      if (paramString2 == null) {
        break label157;
      }
      paramString1 = paramString2.toString();
      paramResponse = paramResponse.append(paramString1).append(" curr:");
      if (paramHttpResponse == null) {
        break label164;
      }
    }
    label157:
    label164:
    for (paramString1 = paramHttpResponse.toString();; paramString1 = "N/A")
    {
      QDLog.b("downloader", paramString1);
      if (!paramString2.equals(paramHttpResponse)) {
        break label171;
      }
      return true;
      paramString1 = "N/A";
      break;
    }
    label171:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.strategy.QzoneResumeTransfer
 * JD-Core Version:    0.7.0.1
 */