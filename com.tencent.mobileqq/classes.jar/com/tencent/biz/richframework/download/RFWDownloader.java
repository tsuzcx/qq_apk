package com.tencent.biz.richframework.download;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import bfys;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.QCircleConfig;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;

public class RFWDownloader
{
  private static final String COS_MD5 = "X-COS-META-MD5";
  private static final String TAG = "RFWDownloader";
  private static OkHttpClient sOkHttpClient;
  private final ConcurrentHashMap<String, ConcurrentHashMap<Integer, WeakReference<RFWDownloader.GetFileListener>>> mDownloadCenter;
  private RFWDownloadStrategy mDownloadStrategy;
  private Set<String> mDownloadingUrlSet = Collections.synchronizedSet(new HashSet());
  
  public RFWDownloader(RFWDownloadStrategy paramRFWDownloadStrategy)
  {
    this.mDownloadStrategy = paramRFWDownloadStrategy;
    this.mDownloadCenter = new ConcurrentHashMap();
  }
  
  private void dispatchGetFileResult(String paramString1, boolean paramBoolean, String paramString2)
  {
    ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.mDownloadCenter.get(paramString1);
    if (localConcurrentHashMap == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = localConcurrentHashMap.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if (localObject != null)
        {
          localObject = (RFWDownloader.GetFileListener)((WeakReference)localObject).get();
          if (localObject != null)
          {
            ((RFWDownloader.GetFileListener)localObject).onRspCallback(paramBoolean, paramString2);
            localConcurrentHashMap.remove(Integer.valueOf(localObject.hashCode()));
            QLog.e("RFWDownloader", 1, "downloadUrl:" + paramString1 + "success");
          }
          else
          {
            QLog.e("RFWDownloader", 1, "downloadUrl:" + paramString1 + "  getFileListener release");
          }
        }
        else
        {
          QLog.e("RFWDownloader", 1, "downloadUrl:" + paramString1 + "WeakReference null");
        }
      }
    }
  }
  
  private String getDecodeUrl(String paramString)
  {
    try
    {
      paramString = URLDecoder.decode(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  private String getEncodeUrl(String paramString)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  private Request getFileUpdateRequest(String paramString)
  {
    return new Request.Builder().url(paramString).head().build();
  }
  
  private String getFilenameForKey(String paramString)
  {
    int i = paramString.length() / 2;
    int j = paramString.substring(0, i).hashCode();
    return String.valueOf(j) + String.valueOf(paramString.substring(i).hashCode());
  }
  
  public static OkHttpClient getOkHttpClient()
  {
    if (sOkHttpClient == null) {}
    try
    {
      if (sOkHttpClient == null) {
        sOkHttpClient = new OkHttpClient().newBuilder().protocols(Arrays.asList(new Protocol[] { Protocol.HTTP_2, Protocol.HTTP_1_1 })).connectTimeout(30000L, TimeUnit.SECONDS).readTimeout(30000L, TimeUnit.SECONDS).writeTimeout(30000L, TimeUnit.SECONDS).build();
      }
      return sOkHttpClient;
    }
    finally {}
  }
  
  private String getResourceSPKey(String paramString)
  {
    return "X-COS-META-MD5" + paramString;
  }
  
  private boolean isZipFile(String paramString)
  {
    return paramString.endsWith(".zip");
  }
  
  private void registerEachListener(String paramString, RFWDownloader.GetFileListener paramGetFileListener)
  {
    ConcurrentHashMap localConcurrentHashMap2 = (ConcurrentHashMap)this.mDownloadCenter.get(paramString);
    ConcurrentHashMap localConcurrentHashMap1 = localConcurrentHashMap2;
    if (localConcurrentHashMap2 == null) {
      localConcurrentHashMap1 = new ConcurrentHashMap();
    }
    localConcurrentHashMap1.put(Integer.valueOf(paramGetFileListener.hashCode()), new WeakReference(paramGetFileListener));
    this.mDownloadCenter.put(paramString, localConcurrentHashMap1);
    QLog.d("RFWDownloader", 2, "add GetFileListener url:" + paramString + " size:" + localConcurrentHashMap1.size());
  }
  
  private void startDownload(String paramString)
  {
    startDownload(paramString, "");
  }
  
  private void startDownload(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(getEncodeUrl(paramString1)))
    {
      QLog.e("RFWDownloader", 1, "downloadError encodePath is Empty");
      return;
    }
    String str = getDefaultSavePath(paramString1);
    try
    {
      ThreadManagerV2.executeOnFileThread(new RFWDownloader.2(this, paramString1, str, paramString2));
      return;
    }
    catch (Exception paramString1)
    {
      QLog.e("RFWDownloader", 1, "error " + paramString1.getMessage());
      paramString1.printStackTrace();
    }
  }
  
  private void updateFileMd5(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      QCircleConfig.getQCircleSp().edit().putString(getResourceSPKey(paramString1), paramString2).apply();
    }
  }
  
  public void checkResource(String paramString, RFWCheckResourceListener paramRFWCheckResourceListener)
  {
    if (paramRFWCheckResourceListener == null)
    {
      QLog.d("RFWDownloader", 1, "checkResource listener is null");
      return;
    }
    boolean bool = isFileDownLoaded(paramString);
    String str = QCircleConfig.getQCircleSp().getString(getResourceSPKey(paramString), "");
    QLog.d("RFWDownloader", 1, "checkResource url:" + paramString + " isDownloaded:" + bool + "  preMd5" + str);
    getOkHttpClient().newCall(getFileUpdateRequest(paramString)).enqueue(new RFWDownloader.4(this, paramString, paramRFWCheckResourceListener, bool, str));
  }
  
  public void downloadOrUpdateFile(String paramString, RFWDownloader.GetFileListener paramGetFileListener)
  {
    ThreadManagerV2.executeOnFileThread(new RFWDownloader.3(this, paramGetFileListener, paramString));
  }
  
  public String getDefaultSavePath(String paramString)
  {
    return this.mDownloadStrategy.getDownloadRootPath() + getEncodeUrl(paramString);
  }
  
  public String getUnZipPath(String paramString)
  {
    if (isZipFile(paramString)) {
      return this.mDownloadStrategy.getDownloadRootPath() + getFilenameForKey(paramString) + File.separator;
    }
    return getDefaultSavePath(paramString);
  }
  
  public void getZipFile(String paramString, RFWDownloader.GetFileListener paramGetFileListener)
  {
    ThreadManagerV2.executeOnFileThread(new RFWDownloader.1(this, paramString, paramGetFileListener));
  }
  
  public boolean isFileDownLoaded(String paramString)
  {
    paramString = new File(getUnZipPath(paramString));
    if (bfys.a() == null) {}
    while ((!paramString.exists()) || ((!paramString.isFile()) && ((!paramString.isDirectory()) || (paramString.listFiles() == null) || (paramString.listFiles().length <= 0)))) {
      return false;
    }
    return true;
  }
  
  public boolean isFileDownLoading(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return this.mDownloadingUrlSet.contains(paramString);
    }
    return false;
  }
  
  public void preloadZipFile(String[] paramArrayOfString, RFWDownloader.GetFileListener paramGetFileListener)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        getZipFile(paramArrayOfString[i], paramGetFileListener);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.download.RFWDownloader
 * JD-Core Version:    0.7.0.1
 */