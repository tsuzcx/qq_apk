package com.tencent.biz.qqstory.shareGroup.icon;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

class ShareGroupIconManager$UrlBitmapDownloaderImp$InnerURLDrawableListener
  implements URLDrawable.URLDrawableListener
{
  private final String b;
  private final int c;
  private final int d;
  private final URLDrawable e;
  
  public ShareGroupIconManager$UrlBitmapDownloaderImp$InnerURLDrawableListener(ShareGroupIconManager.UrlBitmapDownloaderImp paramUrlBitmapDownloaderImp, @NonNull String paramString, int paramInt1, int paramInt2, URLDrawable paramURLDrawable)
  {
    this.b = paramString;
    this.c = paramInt1;
    this.d = paramInt2;
    this.e = paramURLDrawable;
  }
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    ShareGroupIconManager.UrlBitmapDownloaderImp.a(this.a).remove(this.e);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    ShareGroupIconManager.UrlBitmapDownloaderImp.a(this.a).remove(this.e);
    SLog.d("story.icon.ShareGroupIconManager", "download url failed. %s", new Object[] { this.b });
    paramURLDrawable = (HashSet)ShareGroupIconManager.UrlBitmapDownloaderImp.b(this.a).remove(this.b);
    if (paramURLDrawable != null)
    {
      paramURLDrawable = paramURLDrawable.iterator();
      while (paramURLDrawable.hasNext()) {
        ((UrlBitmapDownloader.Listener)paramURLDrawable.next()).a(this.b, paramThrowable);
      }
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    ShareGroupIconManager.UrlBitmapDownloaderImp.a(this.a).remove(this.e);
    SLog.a("story.icon.ShareGroupIconManager", "download url success. %s", this.b);
    Bitmap localBitmap = ShareGroupIconManager.UrlBitmapDownloaderImp.a(this.a, paramURLDrawable, this.c, this.d);
    if (localBitmap != null)
    {
      paramURLDrawable = (HashSet)ShareGroupIconManager.UrlBitmapDownloaderImp.b(this.a).remove(this.b);
      if (paramURLDrawable != null)
      {
        paramURLDrawable = paramURLDrawable.iterator();
        while (paramURLDrawable.hasNext()) {
          ((UrlBitmapDownloader.Listener)paramURLDrawable.next()).a(this.b, localBitmap);
        }
      }
    }
    else
    {
      SLog.e("story.icon.ShareGroupIconManager", "download url success directly. but OOM occur !");
      onLoadFialed(paramURLDrawable, new Throwable("getBitmapFromDrawable failed"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.icon.ShareGroupIconManager.UrlBitmapDownloaderImp.InnerURLDrawableListener
 * JD-Core Version:    0.7.0.1
 */