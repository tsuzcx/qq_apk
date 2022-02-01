package com.tencent.hippy.qq.adapter;

import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory;
import com.tencent.mobileqq.vas.apng.api.VasApngFactory.Options;
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

public class HippyQQImageLoader
  extends HippyImageLoader
{
  protected static final int MAX_DOWNLOAD_RETRY_COUNT = 3;
  protected static final String TAG = "HippyImageAdapter";
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private Set<URLDrawable> urlDrawableList = new HashSet();
  
  private void internalRequestApngImage(HippyQQImageLoader.HippyImageInfo paramHippyImageInfo, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    VasApngFactory.Options localOptions = new VasApngFactory.Options();
    localOptions.c(paramHippyImageInfo.reqHeight);
    localOptions.b(paramHippyImageInfo.reqWidth);
    localOptions.a(paramHippyImageInfo.repeatCount);
    String str = VasApngUtil.getCacheFilePath(paramHippyImageInfo.url);
    URLDrawable localURLDrawable = VasApngFactory.a(paramHippyImageInfo.url, localOptions, str);
    if (localURLDrawable == null) {
      QLog.e("HippyImageAdapter", 1, "internalRequestApngImage urlDrawable is null");
    }
    do
    {
      return;
      this.urlDrawableList.add(localURLDrawable);
      boolean bool = new File(str).exists();
      if (QLog.isColorLevel()) {
        QLog.i("HippyImageAdapter", 2, "internalRequestApngImage url:" + paramHippyImageInfo.url + " localFileExist:" + bool + " status:" + localURLDrawable.getStatus());
      }
      if ((!bool) && (localURLDrawable.getStatus() != 1)) {
        break;
      }
    } while (paramURLDrawableListener == null);
    paramURLDrawableListener.onLoadSuccessed(localURLDrawable);
    return;
    localOptions.a(paramURLDrawableListener);
    if ((localURLDrawable.getStatus() == 2) || (localURLDrawable.getStatus() == 3))
    {
      localURLDrawable.restartDownload();
      return;
    }
    localURLDrawable.startDownload();
  }
  
  private void internalRequestImage(HippyQQImageLoader.HippyImageInfo paramHippyImageInfo, URLDrawable.URLDrawableListener paramURLDrawableListener)
  {
    boolean bool = true;
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130851162);
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130851162);
    localURLDrawableOptions.mRequestWidth = paramHippyImageInfo.reqWidth;
    localURLDrawableOptions.mRequestHeight = paramHippyImageInfo.reqHeight;
    localURLDrawableOptions.mUseApngImage = paramHippyImageInfo.isApng;
    localURLDrawableOptions.mPlayGifImage = paramHippyImageInfo.isGif;
    if (localURLDrawableOptions.mPlayGifImage) {
      AbstractGifImage.resumeAll();
    }
    Object localObject2 = URLDrawable.getDrawable(paramHippyImageInfo.url, localURLDrawableOptions);
    Object localObject1;
    if (((URLDrawable)localObject2).getFileInLocal() != null)
    {
      localObject1 = localObject2;
      if (((URLDrawable)localObject2).getFileInLocal().exists()) {}
    }
    else
    {
      localObject1 = localObject2;
      if (((URLDrawable)localObject2).getStatus() == 1)
      {
        QLog.i("HippyImageAdapter", 2, "internalRequestImage url:" + paramHippyImageInfo.url + " remove cache status:" + ((URLDrawable)localObject2).getStatus());
        URLDrawable.removeMemoryCacheByUrl(paramHippyImageInfo.url, localURLDrawableOptions);
        localObject1 = URLDrawable.getDrawable(paramHippyImageInfo.url, localURLDrawableOptions);
      }
    }
    this.urlDrawableList.add(localObject1);
    localObject2 = ((URLDrawable)localObject1).getFileInLocal();
    if ((localObject2 != null) && (((File)localObject2).exists())) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("HippyImageAdapter", 2, "internalRequestImage url:" + paramHippyImageInfo.url + " localFileExist:" + bool + " status:" + ((URLDrawable)localObject1).getStatus());
      }
      if (!bool) {
        break;
      }
      if (paramURLDrawableListener != null) {
        paramURLDrawableListener.onLoadSuccessed((URLDrawable)localObject1);
      }
      return;
      bool = false;
    }
    ((URLDrawable)localObject1).setTag(Integer.valueOf(0));
    ((URLDrawable)localObject1).setURLDrawableListener(paramURLDrawableListener);
    if ((((URLDrawable)localObject1).getStatus() == 2) || (((URLDrawable)localObject1).getStatus() == 3))
    {
      ((URLDrawable)localObject1).restartDownload();
      return;
    }
    ((URLDrawable)localObject1).startDownload();
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
    if (paramHippyImageInfo.isApng) {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        onApngImageDownloadSuccessed(paramHippyImageInfo, paramURLDrawable);
      }
    }
    for (;;)
    {
      this.urlDrawableList.remove(paramURLDrawable);
      return;
      this.mHandler.post(new HippyQQImageLoader.1(this, paramHippyImageInfo, paramURLDrawable));
      continue;
      File localFile = paramURLDrawable.getFileInLocal();
      if ((localFile == null) || (!localFile.exists()))
      {
        QLog.e("HippyImageAdapter", 1, "onImageDownloadSuccessed url:" + paramHippyImageInfo.url + " onLoadSuccessed notExists");
        return;
      }
      ThreadManager.post(new HippyQQImageLoader.2(this, paramHippyImageInfo, localFile), 8, null, true);
    }
  }
  
  private void tryReDownload(URLDrawable paramURLDrawable, Throwable paramThrowable, HippyQQImageLoader.HippyImageInfo paramHippyImageInfo)
  {
    if ((paramURLDrawable == null) || (!NetworkUtil.g(null))) {}
    do
    {
      return;
      localObject = paramURLDrawable.getTag();
    } while (!(localObject instanceof Integer));
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = ((Integer)localObject).intValue();
    if (i < 3)
    {
      i += 1;
      paramURLDrawable.setTag(Integer.valueOf(i));
      paramURLDrawable.restartDownload();
      paramHippyImageInfo = localStringBuilder1.append("hit restart download, retryCounts: ").append(i).append(", url: ");
      if (paramURLDrawable.getURL() != null) {}
      for (paramURLDrawable = paramURLDrawable.getURL().toString();; paramURLDrawable = "null")
      {
        paramHippyImageInfo.append(paramURLDrawable).append(", errorMsg: ").append(paramThrowable.getMessage());
        QLog.e("HippyImageAdapter", 1, "tryReDownload " + localStringBuilder1.toString());
        return;
      }
    }
    StringBuilder localStringBuilder2 = localStringBuilder1.append("reach max restart count, ").append(", url: ");
    if (paramURLDrawable.getURL() != null) {}
    for (Object localObject = paramURLDrawable.getURL().toString();; localObject = "null")
    {
      localStringBuilder2.append((String)localObject).append(", errorMsg: ").append(paramThrowable.getMessage());
      paramHippyImageInfo.onRequestFail(paramThrowable, null);
      this.urlDrawableList.remove(paramURLDrawable);
      break;
    }
  }
  
  public void fetchImage(String paramString, HippyImageLoader.Callback paramCallback, Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof Map)))
    {
      paramObject = ((Map)paramObject).get("props");
      if ((paramObject == null) || (!(paramObject instanceof HippyMap))) {
        break label65;
      }
    }
    label65:
    for (paramObject = (HippyMap)paramObject;; paramObject = new HippyMap())
    {
      paramString = new HippyQQImageLoader.HippyImageInfo(paramString, paramObject, paramCallback);
      if (!TextUtils.isEmpty(paramString.url)) {
        break label76;
      }
      return;
      break;
    }
    label76:
    paramCallback = new HippyQQImageLoader.3(this, paramString);
    if (paramString.isApng)
    {
      internalRequestApngImage(paramString, paramCallback);
      return;
    }
    internalRequestImage(paramString, paramCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader
 * JD-Core Version:    0.7.0.1
 */