package com.tencent.component.network.downloader.impl.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Parcel;
import android.text.TextUtils;
import com.tencent.component.network.downloader.UrlKeyGenerator;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.downloader.strategy.ResumeTransfer;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.cache.file.FileCacheService;
import com.tencent.component.network.utils.Base64;
import java.io.File;
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
import okhttp3.MediaType;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;

public class QzoneResumeTransfer
  implements ResumeTransfer
{
  private FileCacheService mCache;
  private Map<String, QzoneResumeTransfer.CacheFileAttribute> mCacheAttributes = new ConcurrentHashMap();
  private boolean mCheckContentType = false;
  private Context mContext;
  private List<String> mDomainCacheList = Collections.synchronizedList(new ArrayList());
  public Map<String, Pattern> mDominPatterns = new HashMap();
  public boolean mForceEnable = false;
  private final Object mLock = new Object();
  private String mName;
  private SharedPreferences mSharePre;
  private String[] mSupportDomains = { "a[0-9].qpic.cn", "m.qpic.cn", ".*qzonestyle.gtimg.cn", ".*qzs.qq.com", ".*i.gtimg.cn", "a\\d+.photo.store.qq.com", "b\\d+.photo.store.qq.com", "vqzone.tc.qq.com", "vwecam.tc.qq.com" };
  private UrlKeyGenerator mUrlKeyGenerator;
  
  public QzoneResumeTransfer(Context paramContext, String paramString, FileCacheService paramFileCacheService, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mName = paramString;
    this.mCache = paramFileCacheService;
    this.mCheckContentType = paramBoolean;
    initUrlPatterns();
    if (this.mCheckContentType)
    {
      this.mSharePre = paramContext.getSharedPreferences("qzone_download_resume_" + getProcessName(this.mContext), 0);
      loadConfig();
    }
  }
  
  private boolean checkContentRange(String paramString, HttpResponse paramHttpResponse, Response paramResponse)
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
          paramString = getTmpCacheFileName(paramString);
          paramString = this.mCache.getFile(paramString);
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
              catch (Throwable localThrowable)
              {
                localThrowable.printStackTrace();
              }
            }
          }
        }
        l1 = 0L;
        break;
        paramHttpResponse = localThrowable;
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
  
  private String getProcessName(Context paramContext)
  {
    try
    {
      String str = Utils.getCurrentProcessName(paramContext);
      paramContext = str;
      if (str != null)
      {
        paramContext = str;
        if (str.contains(":"))
        {
          int i = str.lastIndexOf(":");
          paramContext = str;
          if (i > 0) {
            paramContext = str.substring(i + 1);
          }
        }
      }
      if (!TextUtils.isEmpty(paramContext)) {
        return paramContext;
      }
      return "";
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  private String getTmpCacheFileName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Object localObject = this.mUrlKeyGenerator;
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
      localObject = ((UrlKeyGenerator)localObject).doGenerate(paramString);
      break;
      label44:
      paramString = (String)localObject;
    }
  }
  
  private QzoneResumeTransfer.CacheFileAttribute getTmpFileAttr(String paramString)
  {
    paramString = getTmpCacheFileName(paramString);
    if (paramString == null) {
      return null;
    }
    return (QzoneResumeTransfer.CacheFileAttribute)this.mCacheAttributes.get(paramString);
  }
  
  private String getTmpFileContentType(String paramString)
  {
    paramString = getTmpCacheFileName(paramString);
    if (paramString == null) {
      return null;
    }
    paramString = (QzoneResumeTransfer.CacheFileAttribute)this.mCacheAttributes.get(paramString);
    if (paramString != null) {
      return paramString.ContentType;
    }
    return null;
  }
  
  private void initUrlPatterns()
  {
    this.mDominPatterns.clear();
    int i = 0;
    while (i < this.mSupportDomains.length)
    {
      Pattern localPattern = Pattern.compile(this.mSupportDomains[i], 2);
      this.mDominPatterns.put(this.mSupportDomains[i], localPattern);
      i += 1;
    }
  }
  
  private boolean isCacheFileVaild(File paramFile)
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
  
  private void loadConfig()
  {
    localObject3 = null;
    localObject1 = null;
    Object localObject4 = this.mSharePre.getString("contenttype_" + this.mName, null);
    if (localObject4 != null) {}
    try
    {
      localObject4 = Utils.unmarshall(Base64.decode((String)localObject4, 0));
      localObject1 = localObject4;
      localObject3 = localObject4;
      this.mCacheAttributes.clear();
      localObject1 = localObject4;
      localObject3 = localObject4;
      ((Parcel)localObject4).readMap(this.mCacheAttributes, this.mContext.getClassLoader());
      if (localObject4 != null) {
        ((Parcel)localObject4).recycle();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localObject3 = localObject1;
        QDLog.e("download", "download", localThrowable);
        if (localObject1 != null) {
          localObject1.recycle();
        }
      }
    }
    finally
    {
      if (localObject3 == null) {
        break label143;
      }
      localObject3.recycle();
    }
    if (this.mCacheAttributes == null) {
      this.mCacheAttributes = new HashMap();
    }
  }
  
  private QzoneResumeTransfer.CacheFileAttribute parseAttrs(HttpResponse paramHttpResponse, Response paramResponse)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if ((paramHttpResponse == null) && (paramResponse == null)) {
      return null;
    }
    if (paramHttpResponse != null)
    {
      paramResponse = paramHttpResponse.getEntity();
      if (paramResponse == null) {
        break label188;
      }
      paramResponse = paramResponse.getContentType();
      if (paramResponse == null) {
        break label188;
      }
    }
    label188:
    for (paramResponse = paramResponse.getValue();; paramResponse = null)
    {
      localObject1 = paramHttpResponse.getFirstHeader("Last-Modified");
      if (localObject1 != null) {}
      for (localObject1 = ((Header)localObject1).getValue();; localObject1 = null)
      {
        Header localHeader = paramHttpResponse.getFirstHeader("Content-Encoding");
        paramHttpResponse = paramResponse;
        Object localObject3 = localObject1;
        if (localHeader != null)
        {
          localObject2 = localHeader.getValue();
          localObject3 = localObject1;
          paramHttpResponse = paramResponse;
        }
        for (;;)
        {
          return new QzoneResumeTransfer.CacheFileAttribute(paramHttpResponse, (String)localObject3, (String)localObject2);
          if (paramResponse != null)
          {
            localObject2 = paramResponse.body();
            paramHttpResponse = (HttpResponse)localObject1;
            if (localObject2 != null)
            {
              localObject2 = ((ResponseBody)localObject2).contentType();
              paramHttpResponse = (HttpResponse)localObject1;
              if (localObject2 != null) {
                paramHttpResponse = ((MediaType)localObject2).toString();
              }
            }
            localObject3 = paramResponse.header("Last-Modified");
            localObject2 = paramResponse.header("Content-Encoding");
          }
          else
          {
            localObject3 = null;
            paramHttpResponse = null;
          }
        }
      }
    }
  }
  
  private void saveConfig()
  {
    Object localObject3 = null;
    Object localObject1 = null;
    try
    {
      Parcel localParcel = Parcel.obtain();
      localObject1 = localParcel;
      localObject3 = localParcel;
      localParcel.writeMap(this.mCacheAttributes);
      localObject1 = localParcel;
      localObject3 = localParcel;
      String str = new String(Base64.encode(localParcel.marshall(), 0));
      localObject1 = localParcel;
      localObject3 = localParcel;
      this.mSharePre.edit().putString("contenttype_" + this.mName, str).commit();
      return;
    }
    catch (Exception localException)
    {
      localObject3 = localObject1;
      QDLog.w("QzoneResumeTransfer", "saveConfig", localException);
      return;
    }
    finally
    {
      if (localObject3 != null) {
        localObject3.recycle();
      }
    }
  }
  
  private boolean supportResumeDownload(String paramString1, String paramString2)
  {
    if (this.mForceEnable) {}
    do
    {
      return true;
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
        return false;
      }
    } while (this.mDomainCacheList.contains(paramString2));
    paramString1 = this.mDominPatterns.entrySet().iterator();
    while (paramString1.hasNext()) {
      if (Utils.match((Pattern)((Map.Entry)paramString1.next()).getValue(), paramString2)) {
        this.mDomainCacheList.add(paramString2);
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void addCacheTmpFile(String paramString1, String arg2, HttpResponse paramHttpResponse, Response paramResponse)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(???))) {}
    do
    {
      return;
      ??? = new File(???);
    } while ((!???.exists()) || (???.length() <= 0L) || (!this.mCache.putFile(getTmpCacheFileName(paramString1))) || (!this.mCheckContentType) || ((paramHttpResponse == null) && (paramResponse == null)));
    paramHttpResponse = parseAttrs(paramHttpResponse, paramResponse);
    paramResponse = new StringBuilder().append("Downloader Resume Response url:").append(paramString1).append(" curr:");
    if (paramHttpResponse != null) {}
    for (??? = paramHttpResponse.toString();; ??? = "N/A")
    {
      QDLog.d("downloader", ???);
      if (paramHttpResponse == null) {
        break;
      }
      synchronized (this.mLock)
      {
        if (!paramHttpResponse.equals((QzoneResumeTransfer.CacheFileAttribute)this.mCacheAttributes.get(getTmpCacheFileName(paramString1))))
        {
          this.mCacheAttributes.put(getTmpCacheFileName(paramString1), paramHttpResponse);
          saveConfig();
        }
        return;
      }
    }
  }
  
  public void cleanCache()
  {
    this.mCache.clear();
    synchronized (this.mLock)
    {
      this.mCacheAttributes.clear();
      saveConfig();
      return;
    }
  }
  
  public void cleanCache(String arg1)
  {
    String str = getTmpCacheFileName(???);
    this.mCache.deleteFile(str);
    synchronized (this.mLock)
    {
      this.mCacheAttributes.remove(str);
      saveConfig();
      return;
    }
  }
  
  public String getResumeTmpFile(String paramString)
  {
    paramString = this.mCache.getFile(getTmpCacheFileName(paramString));
    if ((paramString != null) && (paramString.exists())) {
      return paramString.getPath();
    }
    return null;
  }
  
  public boolean handleResponse(String paramString1, String paramString2, HttpResponse paramHttpResponse, Response paramResponse)
  {
    if ((!this.mCheckContentType) || (!supportResumeDownload(paramString1, paramString2))) {
      return true;
    }
    if ((TextUtils.isEmpty(paramString1)) || ((paramHttpResponse == null) && (paramResponse == null))) {
      return false;
    }
    if (!checkContentRange(paramString1, paramHttpResponse, paramResponse)) {
      return false;
    }
    paramString2 = getTmpFileAttr(paramString1);
    if (paramString2 == null) {
      return true;
    }
    paramHttpResponse = parseAttrs(paramHttpResponse, paramResponse);
    if (QDLog.isInfoEnable())
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
      QDLog.i("downloader", paramString1);
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
  
  public void onDownloadResult(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      synchronized (this.mCache)
      {
        this.mCache.deleteFile(getTmpCacheFileName(paramString));
        if (!this.mCheckContentType) {}
      }
    }
    synchronized (this.mLock)
    {
      if (this.mCacheAttributes.containsKey(getTmpCacheFileName(paramString)))
      {
        this.mCacheAttributes.remove(getTmpCacheFileName(paramString));
        saveConfig();
      }
      return;
      paramString = finally;
      throw paramString;
    }
  }
  
  public void prepareRequest(HttpGet paramHttpGet, Request.Builder paramBuilder, String paramString1, String paramString2)
  {
    if (!supportResumeDownload(paramString1, paramString2)) {
      return;
    }
    paramString2 = getTmpCacheFileName(paramString1);
    File localFile = this.mCache.getFile(paramString2);
    long l;
    if ((localFile != null) && (localFile.exists())) {
      if (isCacheFileVaild(localFile))
      {
        l = localFile.length();
        paramString2 = getTmpFileContentType(paramString1);
        if (l > 0L)
        {
          if (this.mCheckContentType) {
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
      QDLog.i("downloader", "Downloader Resume --- begin range:" + l + " Accept:" + paramString2 + " url:" + paramString1);
      return;
      this.mCache.deleteFile(paramString2);
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
  
  public void setSupportDomains(String[] paramArrayOfString, boolean paramBoolean)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
      return;
    }
    if (!paramBoolean) {}
    String[] arrayOfString;
    for (this.mSupportDomains = paramArrayOfString;; this.mSupportDomains = arrayOfString)
    {
      initUrlPatterns();
      return;
      int i = this.mSupportDomains.length;
      int j = paramArrayOfString.length + i;
      arrayOfString = new String[j];
      i = 0;
      if (i < j)
      {
        if (i < this.mSupportDomains.length) {
          arrayOfString[i] = this.mSupportDomains[i];
        }
        for (;;)
        {
          i += 1;
          break;
          arrayOfString[i] = paramArrayOfString[(i - this.mSupportDomains.length)];
        }
      }
    }
  }
  
  public void setUrlKeyGenerator(UrlKeyGenerator paramUrlKeyGenerator)
  {
    this.mUrlKeyGenerator = paramUrlKeyGenerator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.downloader.impl.strategy.QzoneResumeTransfer
 * JD-Core Version:    0.7.0.1
 */