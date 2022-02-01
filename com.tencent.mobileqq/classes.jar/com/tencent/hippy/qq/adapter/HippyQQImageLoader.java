package com.tencent.hippy.qq.adapter;

import android.content.res.Resources;
import android.graphics.Movie;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.hippy.qq.offline.HippyOfflineAssist;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;

public class HippyQQImageLoader
  extends HippyImageLoader
{
  protected static final int MAX_DOWNLOAD_RETRY_COUNT = 3;
  protected static final String TAG = "HippyImageAdapter";
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private Set<URLDrawable> urlDrawableList = new HashSet();
  
  private void decodeImage(HippyQQImageLoader.HippyImageInfo paramHippyImageInfo, File paramFile)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeImage url:");
      ((StringBuilder)localObject).append(paramHippyImageInfo.url);
      ((StringBuilder)localObject).append(" useLocal setData");
      QLog.i("HippyImageAdapter", 2, ((StringBuilder)localObject).toString());
    }
    HippyDrawable localHippyDrawable = new HippyDrawable();
    localHippyDrawable.setData(paramFile, paramHippyImageInfo.isGif);
    if ((localHippyDrawable.getGIF() != null) && (localHippyDrawable.getGIF().duration() <= 0))
    {
      paramFile = new Exception("DecodeGifError");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("decodeImage gif duration is error. url:");
      ((StringBuilder)localObject).append(paramHippyImageInfo.url);
      QLog.e("HippyImageAdapter", 1, ((StringBuilder)localObject).toString());
      localObject = "Duration of gif is error";
    }
    else
    {
      paramFile = null;
      localObject = paramFile;
    }
    this.mHandler.post(new HippyQQImageLoader.3(this, paramHippyImageInfo, paramFile, (String)localObject, localHippyDrawable));
  }
  
  private URLDrawable getApngDrawableFromOffline(HippyQQImageLoader.HippyImageInfo paramHippyImageInfo)
  {
    if (paramHippyImageInfo == null) {
      return null;
    }
    String str = HippyOfflineAssist.getOfflineResPath(paramHippyImageInfo.url);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    ApngOptions localApngOptions = new ApngOptions();
    localApngOptions.c(paramHippyImageInfo.reqHeight);
    localApngOptions.b(paramHippyImageInfo.reqWidth);
    localApngOptions.a(paramHippyImageInfo.repeatCount);
    return ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramHippyImageInfo.url, localApngOptions, str);
  }
  
  private URLDrawable getDrawalbeFromOffline(HippyQQImageLoader.HippyImageInfo paramHippyImageInfo)
  {
    if (paramHippyImageInfo == null) {
      return null;
    }
    String str = HippyOfflineAssist.getOfflineResPath(paramHippyImageInfo.url);
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getDrawalbeFromOffline], url:");
      ((StringBuilder)localObject).append(paramHippyImageInfo.url);
      ((StringBuilder)localObject).append(",localPath:");
      ((StringBuilder)localObject).append(str);
      QLog.d("HippyImageAdapter", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = MobileQQ.getContext().getResources().getDrawable(2130851078);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = MobileQQ.getContext().getResources().getDrawable(2130851078);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramHippyImageInfo.reqWidth;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramHippyImageInfo.reqHeight;
    ((URLDrawable.URLDrawableOptions)localObject).mUseApngImage = paramHippyImageInfo.isApng;
    ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = paramHippyImageInfo.isGif;
    return URLDrawable.getFileDrawable(str, (URLDrawable.URLDrawableOptions)localObject);
  }
  
  private String getOfflinePath(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == null) {
      return null;
    }
    try
    {
      paramURLDrawable = paramURLDrawable.getURL().toString();
      if (TextUtils.isEmpty(paramURLDrawable)) {
        return null;
      }
      if (paramURLDrawable.startsWith("file:/"))
      {
        paramURLDrawable = paramURLDrawable.substring(6);
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("[getOfflinePath], path:");
          localStringBuilder.append(paramURLDrawable);
          QLog.d("HippyImageAdapter", 2, localStringBuilder.toString());
        }
        return paramURLDrawable;
      }
      return null;
    }
    catch (Throwable paramURLDrawable) {}
    return null;
  }
  
  private void internalRequestApngImage(HippyQQImageLoader.HippyImageInfo paramHippyImageInfo, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    Object localObject1 = getApngDrawableFromOffline(paramHippyImageInfo);
    if (localObject1 != null)
    {
      if (paramURLDrawableListener != null) {
        paramURLDrawableListener.onLoadSuccessed((URLDrawable)localObject1);
      }
      return;
    }
    localObject1 = new ApngOptions();
    ((ApngOptions)localObject1).c(paramHippyImageInfo.reqHeight);
    ((ApngOptions)localObject1).b(paramHippyImageInfo.reqWidth);
    ((ApngOptions)localObject1).a(paramHippyImageInfo.repeatCount);
    Object localObject2 = VasApngUtil.getCacheFilePath(paramHippyImageInfo.url);
    URLDrawable localURLDrawable = ((IVasApngFactory)QRoute.api(IVasApngFactory.class)).getApngURLDrawable(paramHippyImageInfo.url, (ApngOptions)localObject1, (String)localObject2);
    if (localURLDrawable == null)
    {
      QLog.e("HippyImageAdapter", 1, "internalRequestApngImage urlDrawable is null");
      return;
    }
    this.urlDrawableList.add(localURLDrawable);
    boolean bool = new File((String)localObject2).exists();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("internalRequestApngImage url:");
      ((StringBuilder)localObject2).append(paramHippyImageInfo.url);
      ((StringBuilder)localObject2).append(" localFileExist:");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(" status:");
      ((StringBuilder)localObject2).append(localURLDrawable.getStatus());
      QLog.i("HippyImageAdapter", 2, ((StringBuilder)localObject2).toString());
    }
    if ((!bool) && (localURLDrawable.getStatus() != 1))
    {
      ((ApngOptions)localObject1).a(paramURLDrawableListener);
      if ((localURLDrawable.getStatus() != 2) && (localURLDrawable.getStatus() != 3))
      {
        localURLDrawable.startDownload();
        return;
      }
      localURLDrawable.restartDownload();
      return;
    }
    if (paramURLDrawableListener != null) {
      paramURLDrawableListener.onLoadSuccessed(localURLDrawable);
    }
  }
  
  private void internalRequestImage(HippyQQImageLoader.HippyImageInfo paramHippyImageInfo, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    Object localObject1 = getDrawalbeFromOffline(paramHippyImageInfo);
    if (localObject1 != null)
    {
      if (paramURLDrawableListener != null) {
        paramURLDrawableListener.onLoadSuccessed((URLDrawable)localObject1);
      }
      return;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = MobileQQ.getContext().getResources().getDrawable(2130851078);
    localURLDrawableOptions.mLoadingDrawable = MobileQQ.getContext().getResources().getDrawable(2130851078);
    localURLDrawableOptions.mRequestWidth = paramHippyImageInfo.reqWidth;
    localURLDrawableOptions.mRequestHeight = paramHippyImageInfo.reqHeight;
    localURLDrawableOptions.mUseApngImage = paramHippyImageInfo.isApng;
    localURLDrawableOptions.mPlayGifImage = paramHippyImageInfo.isGif;
    if (localURLDrawableOptions.mPlayGifImage) {
      AbstractGifImage.resumeAll();
    }
    Object localObject2 = URLDrawable.getDrawable(paramHippyImageInfo.url, localURLDrawableOptions);
    localObject1 = ((URLDrawable)localObject2).getFileInLocal();
    boolean bool = true;
    if (localObject1 != null)
    {
      localObject1 = localObject2;
      if (((URLDrawable)localObject2).getFileInLocal().exists()) {}
    }
    else
    {
      localObject1 = localObject2;
      if (((URLDrawable)localObject2).getStatus() == 1)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("internalRequestImage url:");
        ((StringBuilder)localObject1).append(paramHippyImageInfo.url);
        ((StringBuilder)localObject1).append(" remove cache status:");
        ((StringBuilder)localObject1).append(((URLDrawable)localObject2).getStatus());
        QLog.i("HippyImageAdapter", 2, ((StringBuilder)localObject1).toString());
        URLDrawable.removeMemoryCacheByUrl(paramHippyImageInfo.url, localURLDrawableOptions);
        localObject1 = URLDrawable.getDrawable(paramHippyImageInfo.url, localURLDrawableOptions);
      }
    }
    this.urlDrawableList.add(localObject1);
    localObject2 = ((URLDrawable)localObject1).getFileInLocal();
    if ((localObject2 == null) || (!((File)localObject2).exists())) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("internalRequestImage url:");
      ((StringBuilder)localObject2).append(paramHippyImageInfo.url);
      ((StringBuilder)localObject2).append(" localFileExist:");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(" status:");
      ((StringBuilder)localObject2).append(((URLDrawable)localObject1).getStatus());
      QLog.i("HippyImageAdapter", 2, ((StringBuilder)localObject2).toString());
    }
    if (bool)
    {
      if (paramURLDrawableListener != null) {
        paramURLDrawableListener.onLoadSuccessed((URLDrawable)localObject1);
      }
    }
    else
    {
      ((URLDrawable)localObject1).setTag(Integer.valueOf(0));
      ((URLDrawable)localObject1).setURLDrawableListener(paramURLDrawableListener);
      if ((((URLDrawable)localObject1).getStatus() != 2) && (((URLDrawable)localObject1).getStatus() != 3))
      {
        ((URLDrawable)localObject1).startDownload();
        return;
      }
      ((URLDrawable)localObject1).restartDownload();
    }
  }
  
  private void onApngImageDownloadSuccessed(HippyQQImageLoader.HippyImageInfo paramHippyImageInfo, URLDrawable paramURLDrawable)
  {
    HippyDrawable localHippyDrawable = new HippyDrawable();
    localHippyDrawable.setDrawable(paramURLDrawable);
    if (!paramHippyImageInfo.resizeMode.equals("cover"))
    {
      paramURLDrawable = paramURLDrawable.getCurrDrawable();
      if ((paramURLDrawable instanceof ApngDrawable)) {
        ((ApngDrawable)paramURLDrawable).setGravity(17);
      }
    }
    paramHippyImageInfo.onRequestSuccess(localHippyDrawable);
  }
  
  private void onImageDownloadSuccessed(HippyQQImageLoader.HippyImageInfo paramHippyImageInfo, URLDrawable paramURLDrawable)
  {
    if (paramHippyImageInfo.isApng)
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        onApngImageDownloadSuccessed(paramHippyImageInfo, paramURLDrawable);
      } else {
        this.mHandler.post(new HippyQQImageLoader.1(this, paramHippyImageInfo, paramURLDrawable));
      }
    }
    else
    {
      localObject = getOfflinePath(paramURLDrawable);
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new File((String)localObject);
      }
      else
      {
        File localFile = paramURLDrawable.getFileInLocal();
        if (localFile == null) {
          break label125;
        }
        localObject = localFile;
        if (!localFile.exists()) {
          break label125;
        }
      }
      ThreadManager.post(new HippyQQImageLoader.2(this, paramHippyImageInfo, (File)localObject), 8, null, true);
    }
    this.urlDrawableList.remove(paramURLDrawable);
    return;
    label125:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onImageDownloadSuccessed url:");
    ((StringBuilder)localObject).append(paramHippyImageInfo.url);
    ((StringBuilder)localObject).append(" onLoadSuccessed notExists， url：");
    ((StringBuilder)localObject).append(paramURLDrawable.getURL());
    QLog.e("HippyImageAdapter", 1, ((StringBuilder)localObject).toString());
  }
  
  private void tryReDownload(URLDrawable paramURLDrawable, Throwable paramThrowable, HippyQQImageLoader.HippyImageInfo paramHippyImageInfo)
  {
    if (paramURLDrawable != null)
    {
      if (!NetworkUtil.isNetworkAvailable(null)) {
        return;
      }
      Object localObject = paramURLDrawable.getTag();
      if ((localObject instanceof Integer))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        int i = ((Integer)localObject).intValue();
        localObject = "null";
        if (i < 3)
        {
          i += 1;
          paramURLDrawable.setTag(Integer.valueOf(i));
          paramURLDrawable.restartDownload();
          localStringBuilder.append("hit restart download, retryCounts: ");
          localStringBuilder.append(i);
          localStringBuilder.append(", url: ");
          if (paramURLDrawable.getURL() != null) {
            localObject = paramURLDrawable.getURL().toString();
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(", errorMsg: ");
          localStringBuilder.append(paramThrowable.getMessage());
        }
        else
        {
          localStringBuilder.append("reach max restart count, ");
          localStringBuilder.append(", url: ");
          if (paramURLDrawable.getURL() != null) {
            localObject = paramURLDrawable.getURL().toString();
          }
          localStringBuilder.append((String)localObject);
          localStringBuilder.append(", errorMsg: ");
          localStringBuilder.append(paramThrowable.getMessage());
          paramHippyImageInfo.onRequestFail(paramThrowable, null);
          this.urlDrawableList.remove(paramURLDrawable);
        }
        paramURLDrawable = new StringBuilder();
        paramURLDrawable.append("tryReDownload ");
        paramURLDrawable.append(localStringBuilder.toString());
        QLog.e("HippyImageAdapter", 1, paramURLDrawable.toString());
      }
    }
  }
  
  public void fetchImage(String paramString, HippyImageLoader.Callback paramCallback, Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject != null)
    {
      localObject = paramObject;
      if ((paramObject instanceof Map)) {
        localObject = ((Map)paramObject).get("props");
      }
    }
    if ((localObject != null) && ((localObject instanceof HippyMap))) {
      paramObject = (HippyMap)localObject;
    } else {
      paramObject = new HippyMap();
    }
    paramString = new HippyQQImageLoader.HippyImageInfo(paramString, paramObject, paramCallback);
    if (TextUtils.isEmpty(paramString.url)) {
      return;
    }
    paramCallback = new HippyQQImageLoader.4(this, paramString);
    if (paramString.isApng)
    {
      internalRequestApngImage(paramString, paramCallback);
      return;
    }
    internalRequestImage(paramString, paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader
 * JD-Core Version:    0.7.0.1
 */