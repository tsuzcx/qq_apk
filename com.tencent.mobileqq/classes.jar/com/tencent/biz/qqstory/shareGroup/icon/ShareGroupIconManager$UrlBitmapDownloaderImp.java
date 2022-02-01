package com.tencent.biz.qqstory.shareGroup.icon;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.utils.ImageUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class ShareGroupIconManager$UrlBitmapDownloaderImp
  implements UrlBitmapDownloader
{
  private final HashSet<URLDrawable> jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private final ConcurrentHashMap<String, HashSet<UrlBitmapDownloader.Listener>> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  
  private Bitmap a(@NonNull URLDrawable paramURLDrawable, int paramInt1, int paramInt2)
  {
    Object localObject = paramURLDrawable.getCurrDrawable();
    if ((localObject instanceof RegionDrawable))
    {
      localObject = ((RegionDrawable)localObject).getBitmap();
      if (localObject != null) {
        return localObject;
      }
    }
    return ImageUtil.a(paramURLDrawable, paramInt1, paramInt2);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2, UrlBitmapDownloader.Listener paramListener)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = new ColorDrawable(1073741824);
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable;
    try
    {
      URL localURL = new URL(paramString);
      localObject = URLDrawable.getDrawable(localURL, (URLDrawable.URLDrawableOptions)localObject);
      ((URLDrawable)localObject).setURLDrawableListener(new ShareGroupIconManager.UrlBitmapDownloaderImp.InnerURLDrawableListener(this, paramString, paramInt1, paramInt2, (URLDrawable)localObject));
      ((URLDrawable)localObject).setAutoDownload(true);
      if (((URLDrawable)localObject).getStatus() == 1)
      {
        SLog.a("story.icon.ShareGroupIconManager", "download url success directly. %s", paramString);
        localObject = a((URLDrawable)localObject, paramInt1, paramInt2);
        if (localObject != null)
        {
          paramListener.a(paramString, (Bitmap)localObject);
          return;
        }
        SLog.e("story.icon.ShareGroupIconManager", "download url success directly. but OOM occur !");
        paramListener.a(paramString, new Throwable("getBitmapFromDrawable failed"));
        return;
      }
      SLog.a("story.icon.ShareGroupIconManager", "download url pending. %s", paramString);
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.putIfAbsent(paramString, new HashSet());
      ((HashSet)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).add(paramListener);
      this.jdField_a_of_type_JavaUtilHashSet.add(localObject);
      ((URLDrawable)localObject).startDownload();
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      SLog.c("story.icon.ShareGroupIconManager", localMalformedURLException, "can not download url. %s", new Object[] { paramString });
      paramListener.a(paramString, new Throwable("getBitmapFromDrawable failed"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager.UrlBitmapDownloaderImp
 * JD-Core Version:    0.7.0.1
 */