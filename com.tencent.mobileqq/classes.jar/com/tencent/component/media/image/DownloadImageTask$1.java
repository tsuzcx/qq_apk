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
    if ((paramImageKey != null) && (paramImageKey.options != null) && (paramImageDownloadInfo != null))
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("问题描述", ImageTaskConst.getImageTaskErrorDescription(paramImageDownloadInfo.nocacheCode));
        localJSONObject.put("serverIp", paramImageDownloadInfo.serverIp);
        localJSONObject.put("clientIp", paramImageDownloadInfo.clientIp);
        localJSONObject.put("nocacheStatus", String.valueOf(paramImageDownloadInfo.nocacheCode));
        localJSONObject.put("filePath", paramImageKey.filePath);
        localJSONObject.put("downloadDetailInfo", paramImageDownloadInfo.downloadDetailInfo);
      }
      catch (JSONException paramImageDownloadInfo)
      {
        ImageManagerLog.e("DownloadImageTask", "onDownloadFailed, Json Exception!");
        paramImageDownloadInfo.printStackTrace();
      }
      paramImageKey.options.errCode = localJSONObject.toString();
      paramImageKey = new StringBuilder();
      paramImageKey.append("processErrorInfo, info = ");
      paramImageKey.append(localJSONObject.toString());
      ImageManagerLog.w("DownloadImageTask", paramImageKey.toString());
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
    if (localDownloadImageTask != null)
    {
      ImageKey localImageKey = localDownloadImageTask.getImageKey();
      if ((localImageKey != null) && (localImageKey.options != null) && (paramImageDownloadInfo != null))
      {
        int j = paramImageDownloadInfo.failCode;
        int k = paramImageDownloadInfo.retCode;
        int i;
        if (paramImageDownloadInfo.retCode < 0) {
          i = 1;
        } else {
          i = 2;
        }
        Object localObject = new JSONObject();
        try
        {
          ((JSONObject)localObject).put("问题描述", ImageTaskConst.getImageTaskErrorDescription(paramImageDownloadInfo.retCode));
          ((JSONObject)localObject).put("failCode", String.valueOf(j));
          ((JSONObject)localObject).put("exceptionCode", String.valueOf(k));
          ((JSONObject)localObject).put("serverIp", paramImageDownloadInfo.serverIp);
          ((JSONObject)localObject).put("clientIp", paramImageDownloadInfo.clientIp);
          ((JSONObject)localObject).put("errType", String.valueOf(i));
          ((JSONObject)localObject).put("url", paramString);
        }
        catch (JSONException localJSONException)
        {
          ImageManagerLog.e("DownloadImageTask", "onDownloadFailed, Json Exception!");
          localJSONException.printStackTrace();
        }
        localImageKey.options.errCode = ((JSONObject)localObject).toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onDownloadFailed, failCode=");
        ((StringBuilder)localObject).append(paramImageDownloadInfo.failCode);
        ((StringBuilder)localObject).append(", exceptionCode=");
        ((StringBuilder)localObject).append(paramImageDownloadInfo.retCode);
        ((StringBuilder)localObject).append(", serverIp=");
        ((StringBuilder)localObject).append(paramImageDownloadInfo.serverIp);
        ((StringBuilder)localObject).append(", clientIp=");
        ((StringBuilder)localObject).append(paramImageDownloadInfo.clientIp);
        ((StringBuilder)localObject).append(", contentType=");
        ((StringBuilder)localObject).append(paramImageDownloadInfo.contentType);
        ((StringBuilder)localObject).append("， url=");
        ((StringBuilder)localObject).append(paramString);
        ImageManagerLog.e("DownloadImageTask", ((StringBuilder)localObject).toString());
      }
      if ((localImageKey != null) && (localImageKey.urlKey != null))
      {
        ImageTaskTracer.removeImageDownloadRecord(localImageKey.urlKey);
        ImageTaskTracer.addImageDownloadFailedRecord(localImageKey.urlKey);
      }
      localDownloadImageTask.setResult(1, new Object[] { paramString });
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
    paramString2 = new StringBuilder();
    paramString2.append("onDownloadSucceed, canDecode = ");
    paramString2.append(bool);
    paramString2.append(", url=");
    paramString2.append(paramString1);
    ImageManagerLog.w("DownloadImageTask", paramString2.toString());
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