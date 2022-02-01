package com.tencent.hippy.qq.patchbundle;

import android.text.TextUtils;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PatchUtils
{
  private static final String TAG = "PatchUtils";
  
  public static boolean dispatchSSOData2Page(String paramString, List<PatchBundleConfig.SSOListConfig> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          PatchBundleConfig.SSOListConfig localSSOListConfig = (PatchBundleConfig.SSOListConfig)paramList.next();
          if (!TextUtils.isEmpty(localSSOListConfig.mRsp))
          {
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put(localSSOListConfig.mKey, localSSOListConfig.mRsp);
            localJSONArray.put(localJSONObject2);
          }
        }
        localJSONObject1.put("ssoDataList", localJSONArray);
      }
      catch (Exception paramList)
      {
        QLog.e("PatchUtils", 1, paramList, new Object[0]);
      }
      catch (JSONException paramList)
      {
        QLog.e("PatchUtils", 1, paramList, new Object[0]);
      }
      paramList = new HippyMap();
      paramList.pushJSONObject(localJSONObject1);
      HippyQQEngine.dispatchEvent("ssoDataPreload", paramString, paramList);
      return true;
    }
    return false;
  }
  
  public static void downloadPatchBundle(String paramString)
  {
    Object localObject = new File(getBundleFilePath(paramString));
    if (!((File)localObject).exists())
    {
      DownloaderInterface localDownloaderInterface = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(5);
      if (localDownloaderInterface == null)
      {
        QLog.e("PatchUtils", 1, "downloadPatchBundle downloader == null");
        return;
      }
      localObject = new DownloadTask(paramString, (File)localObject);
      ((DownloadTask)localObject).p = true;
      ((DownloadTask)localObject).f = "hippy_patch";
      ((DownloadTask)localObject).b = 1;
      ((DownloadTask)localObject).n = false;
      ((DownloadTask)localObject).r = true;
      localDownloaderInterface.startDownload((DownloadTask)localObject, new PatchUtils.1(paramString), null);
    }
  }
  
  public static int generateGTK(String paramString)
  {
    int k = paramString.length();
    int j = 5381;
    int i = 0;
    while (i < k)
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  public static final String getBundleFilePath(String paramString)
  {
    File localFile = new File(HippyQQFileUtil.getHippyFileByType("patch"), "bundle");
    localFile.mkdirs();
    return new File(localFile, String.valueOf(paramString.hashCode())).getAbsolutePath();
  }
  
  public static final String getConfigFilePath()
  {
    File localFile = new File(HippyQQFileUtil.getHippyFileByType("patch"), "config");
    localFile.mkdirs();
    return new File(localFile, "config.json").getAbsolutePath();
  }
  
  public static DownloaderInterface getDownloadFactory()
  {
    DownloaderInterface localDownloaderInterface2 = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(5);
    DownloaderInterface localDownloaderInterface1 = localDownloaderInterface2;
    if (localDownloaderInterface2 == null)
    {
      QLog.e("PatchUtils", 1, "downloadPatchBundle downloader == null");
      localDownloaderInterface1 = null;
    }
    return localDownloaderInterface1;
  }
  
  public static final String getSSOCacheFilePath(String paramString)
  {
    File localFile = new File(HippyQQFileUtil.getHippyFileByType("patch"), "ssoCache");
    localFile.mkdirs();
    return new File(localFile, paramString).getAbsolutePath();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.patchbundle.PatchUtils
 * JD-Core Version:    0.7.0.1
 */