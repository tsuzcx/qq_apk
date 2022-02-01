package com.tencent.hippy.qq.adapter;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader.Callback;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.utils.ViolaLogUtils;
import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HippyQQImageLoader
  extends HippyImageLoader
{
  public static final String TAG = "HippyImageAdapter";
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private Set<URLDrawable> urlDrawableList = new HashSet();
  
  private void internalRequestImage(String paramString, HippyMap paramHippyMap, HippyImageLoader.Callback paramCallback)
  {
    if (paramString.startsWith("//")) {
      paramString = "https:" + paramString;
    }
    for (;;)
    {
      if (!paramString.startsWith("http")) {
        return;
      }
      boolean bool2 = paramHippyMap.getBoolean("isGif");
      int i = paramHippyMap.getInt("width");
      int j = paramHippyMap.getInt("height");
      String str = paramHippyMap.getString("imageType");
      Object localObject3;
      Object localObject2;
      Object localObject1;
      boolean bool1;
      if (paramHippyMap.getString("resizeMode") != null)
      {
        paramHippyMap = paramHippyMap.getString("resizeMode");
        localObject3 = obtainURLDrawableOptions(bool2, i, j, str);
        localObject2 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject3);
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
            QLog.i("HippyImageAdapter", 2, "internalRequestImage url:" + paramString + " remove cache status:" + ((URLDrawable)localObject2).getStatus());
            URLDrawable.removeMemoryCacheByUrl(paramString, (URLDrawable.URLDrawableOptions)localObject3);
            localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject3);
          }
        }
        this.urlDrawableList.add(localObject1);
        localObject2 = new HippyDrawable();
        localObject3 = ((URLDrawable)localObject1).getFileInLocal();
        if ((localObject3 == null) || (!((File)localObject3).exists())) {
          break label362;
        }
        bool1 = true;
        label241:
        if ((QLog.isColorLevel()) || (!bool1)) {
          QLog.i("HippyImageAdapter", 2, "internalRequestImage url:" + paramString + " localFileExist:" + bool1 + " status:" + ((URLDrawable)localObject1).getStatus());
        }
        if (!bool1) {
          break label394;
        }
        if (!isApng(str)) {
          break label368;
        }
        ((HippyDrawable)localObject2).setDrawable((Drawable)localObject1);
        this.mHandler.post(new HippyQQImageLoader.1(this, paramHippyMap, (URLDrawable)localObject1, paramCallback, (HippyDrawable)localObject2));
      }
      for (;;)
      {
        this.urlDrawableList.remove(localObject1);
        return;
        paramHippyMap = "";
        break;
        label362:
        bool1 = false;
        break label241;
        label368:
        ThreadManager.post(new HippyQQImageLoader.2(this, paramString, (HippyDrawable)localObject2, (File)localObject3, bool2, paramCallback), 8, null, true);
      }
      label394:
      ((URLDrawable)localObject1).setTag(Integer.valueOf(0));
      ((URLDrawable)localObject1).setURLDrawableListener(new HippyQQImageLoader.3(this, paramString, str, (HippyDrawable)localObject2, paramHippyMap, paramCallback, bool2));
      if ((((URLDrawable)localObject1).getStatus() == 2) || (((URLDrawable)localObject1).getStatus() == 3))
      {
        ((URLDrawable)localObject1).restartDownload();
        return;
      }
      ((URLDrawable)localObject1).startDownload();
      return;
    }
  }
  
  private boolean isApng(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals("apng"));
  }
  
  private URLDrawable.URLDrawableOptions obtainURLDrawableOptions(boolean paramBoolean, int paramInt1, int paramInt2, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130850736);
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130850736);
    localURLDrawableOptions.mRequestWidth = paramInt1;
    localURLDrawableOptions.mRequestHeight = paramInt2;
    if (paramBoolean) {
      AbstractGifImage.resumeAll();
    }
    for (localURLDrawableOptions.mPlayGifImage = true;; localURLDrawableOptions.mPlayGifImage = false)
    {
      if (isApng(paramString))
      {
        ApngImage.resumeAll();
        localURLDrawableOptions.mUseApngImage = true;
      }
      return localURLDrawableOptions;
    }
  }
  
  private void tryReDownload(URLDrawable paramURLDrawable, Throwable paramThrowable, HippyImageLoader.Callback paramCallback)
  {
    if ((paramURLDrawable == null) || (!NetworkUtil.isNetworkAvailable(null))) {}
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
      paramCallback = localStringBuilder1.append("hit restart download, retryCounts: ").append(i).append(", url: ");
      if (paramURLDrawable.getURL() != null) {}
      for (paramURLDrawable = paramURLDrawable.getURL().toString();; paramURLDrawable = "null")
      {
        paramCallback.append(paramURLDrawable).append(", errorMsg: ").append(paramThrowable.getMessage());
        ViolaLogUtils.d("HippyImageAdapter", localStringBuilder1.toString());
        return;
      }
    }
    StringBuilder localStringBuilder2 = localStringBuilder1.append("reach max restart count, ").append(", url: ");
    if (paramURLDrawable.getURL() != null) {}
    for (Object localObject = paramURLDrawable.getURL().toString();; localObject = "null")
    {
      localStringBuilder2.append((String)localObject).append(", errorMsg: ").append(paramThrowable.getMessage());
      paramCallback.onRequestFail(paramThrowable, null);
      this.urlDrawableList.remove(paramURLDrawable);
      break;
    }
  }
  
  public void fetchImage(String paramString, HippyImageLoader.Callback paramCallback, Object paramObject)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramObject != null)
    {
      localObject1 = localObject2;
      if ((paramObject instanceof Map)) {
        localObject1 = ((Map)paramObject).get("props");
      }
    }
    if ((localObject1 != null) && ((localObject1 instanceof HippyMap))) {}
    for (paramObject = (HippyMap)localObject1;; paramObject = new HippyMap())
    {
      internalRequestImage(paramString, paramObject, paramCallback);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.adapter.HippyQQImageLoader
 * JD-Core Version:    0.7.0.1
 */