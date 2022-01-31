package com.tencent.component.media.image;

import com.tencent.component.media.ImageManagerEnv.ImageDownloaderListener;
import com.tencent.component.media.utils.ImageManagerLog;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class DownloadImageTask$1
  implements ImageManagerEnv.ImageDownloaderListener
{
  private void processErrorInfo(ImageKey paramImageKey, ImageDownloadInfo paramImageDownloadInfo)
  {
    JSONObject localJSONObject;
    if ((paramImageKey != null) && (paramImageKey.options != null) && (paramImageDownloadInfo != null)) {
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("问题描述", ImageTaskConst.getImageTaskErrorDescription(paramImageDownloadInfo.nocacheCode));
      localJSONObject.put("serverIp", paramImageDownloadInfo.serverIp);
      localJSONObject.put("clientIp", paramImageDownloadInfo.clientIp);
      localJSONObject.put("nocacheStatus", String.valueOf(paramImageDownloadInfo.nocacheCode));
      localJSONObject.put("filePath", paramImageKey.filePath);
      localJSONObject.put("downloadDetailInfo", paramImageDownloadInfo.downloadDetailInfo);
      paramImageKey.options.errCode = localJSONObject.toString();
      ImageManagerLog.w("DownloadImageTask", "processErrorInfo, info = " + localJSONObject.toString());
      return;
    }
    catch (JSONException paramImageDownloadInfo)
    {
      for (;;)
      {
        ImageManagerLog.e("DownloadImageTask", "onDownloadFailed, Json Exception!");
        paramImageDownloadInfo.printStackTrace();
      }
    }
  }
  
  public void onDownloadCanceled(String paramString)
  {
    DownloadImageTask localDownloadImageTask = (DownloadImageTask)DownloadImageTask.access$000().remove(paramString);
    ImageTracer.cancel(paramString);
    if (localDownloadImageTask != null)
    {
      if ((localDownloadImageTask.mImageKey != null) && (localDownloadImageTask.mImageKey.urlKey != null)) {
        ImageTaskTracer.removeImageDownloadRecord(localDownloadImageTask.mImageKey.urlKey);
      }
      localDownloadImageTask.setResult(0, new Object[] { paramString });
    }
  }
  
  public void onDownloadFailed(String paramString, ImageDownloadInfo paramImageDownloadInfo)
  {
    DownloadImageTask localDownloadImageTask = (DownloadImageTask)DownloadImageTask.access$000().remove(paramString);
    ImageTracer.downloadFail(paramString);
    ProgressTracer.print(1001, paramString);
    ImageKey localImageKey;
    int j;
    int k;
    int i;
    if (localDownloadImageTask != null)
    {
      localImageKey = localDownloadImageTask.getImageKey();
      if ((localImageKey != null) && (localImageKey.options != null) && (paramImageDownloadInfo != null))
      {
        j = paramImageDownloadInfo.failCode;
        k = paramImageDownloadInfo.retCode;
        if (paramImageDownloadInfo.retCode >= 0) {
          break label309;
        }
        i = 1;
      }
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("问题描述", ImageTaskConst.getImageTaskErrorDescription(paramImageDownloadInfo.retCode));
        localJSONObject.put("failCode", String.valueOf(j));
        localJSONObject.put("exceptionCode", String.valueOf(k));
        localJSONObject.put("serverIp", paramImageDownloadInfo.serverIp);
        localJSONObject.put("clientIp", paramImageDownloadInfo.clientIp);
        localJSONObject.put("errType", String.valueOf(i));
        localJSONObject.put("url", paramString);
        localImageKey.options.errCode = localJSONObject.toString();
        ImageManagerLog.e("DownloadImageTask", "onDownloadFailed, failCode=" + paramImageDownloadInfo.failCode + ", exceptionCode=" + paramImageDownloadInfo.retCode + ", serverIp=" + paramImageDownloadInfo.serverIp + ", clientIp=" + paramImageDownloadInfo.clientIp + ", contentType=" + paramImageDownloadInfo.contentType + "， url=" + paramString);
        if ((localImageKey != null) && (localImageKey.urlKey != null))
        {
          ImageTaskTracer.removeImageDownloadRecord(localImageKey.urlKey);
          ImageTaskTracer.addImageDownloadFailedRecord(localImageKey.urlKey);
        }
        localDownloadImageTask.setResult(1, new Object[] { paramString });
        return;
        label309:
        i = 2;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ImageManagerLog.e("DownloadImageTask", "onDownloadFailed, Json Exception!");
          localJSONException.printStackTrace();
        }
      }
    }
  }
  
  public void onDownloadProgress(String paramString, long paramLong, float paramFloat)
  {
    DownloadImageTask localDownloadImageTask = (DownloadImageTask)DownloadImageTask.access$000().get(paramString);
    if (localDownloadImageTask != null)
    {
      if ((localDownloadImageTask.mImageKey != null) && (localDownloadImageTask.mImageKey.urlKey != null)) {
        ImageTaskTracer.removeImageDownloadRecord(localDownloadImageTask.mImageKey.urlKey);
      }
      localDownloadImageTask.setResult(3, new Object[] { paramString, Long.valueOf(paramLong), Float.valueOf(paramFloat) });
    }
  }
  
  public void onDownloadSucceed(String paramString1, String paramString2, boolean paramBoolean, ImageDownloadInfo paramImageDownloadInfo)
  {
    DownloadImageTask localDownloadImageTask = (DownloadImageTask)DownloadImageTask.access$000().remove(paramString1);
    if (localDownloadImageTask == null) {
      return;
    }
    if ((localDownloadImageTask.mImageKey != null) && (localDownloadImageTask.mImageKey.urlKey != null)) {
      ImageTaskTracer.removeImageDownloadRecord(localDownloadImageTask.mImageKey.urlKey);
    }
    boolean bool = ImageManager.getInstance().onDownloadSucceed(localDownloadImageTask.mImageKey, paramString1, paramString2, paramBoolean);
    if (bool)
    {
      if (paramBoolean) {
        processErrorInfo(localDownloadImageTask.getImageKey(), paramImageDownloadInfo);
      }
      localDownloadImageTask.setResult(2, new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      return;
    }
    paramString2 = localDownloadImageTask.getImageKey();
    if ((paramString2 != null) && (paramString2.options != null)) {
      paramString2.options.errCode = ImageManager.getErrorString(paramString2, 800);
    }
    ImageManagerLog.w("DownloadImageTask", "onDownloadSucceed, canDecode = " + bool + ", url=" + paramString1);
    localDownloadImageTask.setResult(1, new Object[] { paramString1 });
  }
  
  public void onStreamProgress(String paramString1, String paramString2)
  {
    DownloadImageTask localDownloadImageTask = (DownloadImageTask)DownloadImageTask.access$000().get(paramString1);
    if ((localDownloadImageTask.mImageKey != null) && (localDownloadImageTask.mImageKey.urlKey != null)) {
      ImageTaskTracer.removeImageDownloadRecord(localDownloadImageTask.mImageKey.urlKey);
    }
    if ((localDownloadImageTask != null) && (localDownloadImageTask.mImageKey != null) && (localDownloadImageTask.mImageKey.options != null) && (localDownloadImageTask.mImageKey.options.isGifPlayWhileDownloading)) {
      localDownloadImageTask.setResult(14, new Object[] { paramString1, paramString2 });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.DownloadImageTask.1
 * JD-Core Version:    0.7.0.1
 */