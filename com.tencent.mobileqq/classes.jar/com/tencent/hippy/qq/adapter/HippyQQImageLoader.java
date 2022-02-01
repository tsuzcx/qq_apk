package com.tencent.hippy.qq.adapter;

import android.content.res.Resources;
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
      URLDrawable localURLDrawable;
      HippyDrawable localHippyDrawable;
      File localFile;
      boolean bool1;
      if (paramHippyMap.getString("resizeMode") != null)
      {
        paramHippyMap = paramHippyMap.getString("resizeMode");
        localURLDrawable = URLDrawable.getDrawable(paramString, obtainURLDrawableOptions(bool2, i, j, str));
        this.urlDrawableList.add(localURLDrawable);
        localHippyDrawable = new HippyDrawable();
        localFile = localURLDrawable.getFileInLocal();
        if ((localFile == null) || (!localFile.exists())) {
          break label252;
        }
        bool1 = true;
        label149:
        if (QLog.isColorLevel()) {
          QLog.i("HippyImageAdapter", 2, "internalRequestImage url:" + paramString + " localFileExist:" + bool1);
        }
        if (!bool1) {
          break label284;
        }
        if (!isApng(str)) {
          break label258;
        }
        localHippyDrawable.setDrawable(localURLDrawable);
        this.mHandler.post(new HippyQQImageLoader.1(this, paramHippyMap, localURLDrawable, paramCallback, localHippyDrawable));
      }
      for (;;)
      {
        this.urlDrawableList.remove(localURLDrawable);
        return;
        paramHippyMap = "";
        break;
        label252:
        bool1 = false;
        break label149;
        label258:
        ThreadManager.post(new HippyQQImageLoader.2(this, paramString, localHippyDrawable, localFile, bool2, paramCallback), 8, null, true);
      }
      label284:
      localURLDrawable.setTag(Integer.valueOf(0));
      localURLDrawable.setURLDrawableListener(new HippyQQImageLoader.3(this, paramString, str, localHippyDrawable, paramHippyMap, paramCallback, bool2));
      if (localURLDrawable.getStatus() == 2)
      {
        localURLDrawable.restartDownload();
        return;
      }
      localURLDrawable.startDownload();
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
    localURLDrawableOptions.mFailedDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130850605);
    localURLDrawableOptions.mLoadingDrawable = BaseApplicationImpl.getContext().getResources().getDrawable(2130850605);
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
    if ((paramObject != null) && ((paramObject instanceof HippyMap))) {}
    for (paramObject = (HippyMap)paramObject;; paramObject = new HippyMap())
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