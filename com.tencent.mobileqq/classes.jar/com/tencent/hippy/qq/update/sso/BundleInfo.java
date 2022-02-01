package com.tencent.hippy.qq.update.sso;

import android.text.TextUtils;
import com.tencent.hippy.qq.update.HippyQQFileUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class BundleInfo
{
  private static final int MAX_PRE_DOWNLOAD_FAILED_CNT = 2;
  private static final String TAG = "BundleInfo";
  public String bundleMd5;
  public String bundleName;
  public long bundleSize;
  public int bundleVersion;
  public String diffPkgMd5;
  public long diffPkgSize;
  public String diffPkgUrl;
  public String diffQarFileMd5;
  public String downloadUrl;
  public boolean isUsePreDownload;
  public int maxPreDownloadFailedCnt;
  
  private boolean checkData()
  {
    return (!TextUtils.isEmpty(this.bundleName)) && (this.bundleVersion >= 0) && (!TextUtils.isEmpty(this.bundleMd5)) && (!TextUtils.isEmpty(this.downloadUrl));
  }
  
  public static BundleInfo fromJson(JSONObject paramJSONObject)
  {
    Object localObject = null;
    if (paramJSONObject == null) {
      return null;
    }
    BundleInfo localBundleInfo = new BundleInfo();
    localBundleInfo.bundleName = paramJSONObject.optString("bundleName");
    localBundleInfo.bundleVersion = paramJSONObject.optInt("bundleVersion", -1);
    localBundleInfo.bundleMd5 = paramJSONObject.optString("bundleMd5");
    localBundleInfo.downloadUrl = paramJSONObject.optString("downloadUrl");
    localBundleInfo.bundleSize = paramJSONObject.optLong("bundleSize");
    localBundleInfo.maxPreDownloadFailedCnt = paramJSONObject.optInt("maxFailedCnt", 2);
    boolean bool = false;
    if (paramJSONObject.optInt("isUsePreDownload", 0) == 1) {
      bool = true;
    }
    localBundleInfo.isUsePreDownload = bool;
    paramJSONObject = paramJSONObject.optJSONObject("stDiffPkg");
    if (paramJSONObject != null)
    {
      localBundleInfo.diffPkgSize = paramJSONObject.optLong("iSize");
      localBundleInfo.diffPkgMd5 = paramJSONObject.optString("sMd5");
      localBundleInfo.diffQarFileMd5 = paramJSONObject.optString("sTotalPkgMd5");
      localBundleInfo.diffPkgUrl = paramJSONObject.optString("sUrl");
    }
    paramJSONObject = localObject;
    if (localBundleInfo.checkData()) {
      paramJSONObject = localBundleInfo;
    }
    return paramJSONObject;
  }
  
  public static ArrayList<BundleInfo> parseBundleList(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("BundleInfo", 2, "[parseBundleInfo] json is empty.");
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("bundleList");
      if (paramString == null)
      {
        QLog.i("BundleInfo", 2, "[parseBundleInfo] array is null.");
        return null;
      }
      localObject = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        BundleInfo localBundleInfo = fromJson(paramString.getJSONObject(i));
        if (localBundleInfo != null) {
          ((ArrayList)localObject).add(localBundleInfo);
        }
        i += 1;
      }
      return localObject;
    }
    catch (Throwable paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[parseBundleInfo] e:");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("BundleInfo", 2, ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public boolean canDiffUpdate(int paramInt)
  {
    if ((paramInt > 0) && (hasDiffPkg())) {
      return HippyQQFileUtil.getJsBundleZipFile(this.bundleName, paramInt).exists();
    }
    return false;
  }
  
  public boolean checkMd5(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    String str;
    if (paramBoolean) {
      str = this.diffPkgMd5;
    } else {
      str = this.bundleMd5;
    }
    return paramString.equals(str);
  }
  
  public File getDownloadFile(boolean paramBoolean)
  {
    if (paramBoolean) {
      return HippyQQFileUtil.getDiffPkgFile(this.bundleName, this.bundleVersion);
    }
    return HippyQQFileUtil.getJsBundleZipFile(this.bundleName, this.bundleVersion);
  }
  
  public boolean hasDiffPkg()
  {
    return (this.diffPkgSize > 0L) && (!TextUtils.isEmpty(this.diffPkgMd5)) && (!TextUtils.isEmpty(this.diffQarFileMd5)) && (!TextUtils.isEmpty(this.diffPkgUrl));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.update.sso.BundleInfo
 * JD-Core Version:    0.7.0.1
 */