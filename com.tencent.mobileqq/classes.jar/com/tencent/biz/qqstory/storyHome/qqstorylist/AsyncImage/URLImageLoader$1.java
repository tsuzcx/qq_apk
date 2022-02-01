package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.InfoPrinter;

class URLImageLoader$1
  extends LruCache<URLImageLoader.Config, Drawable>
{
  URLImageLoader$1(URLImageLoader paramURLImageLoader, int paramInt)
  {
    super(paramInt);
  }
  
  protected int a(URLImageLoader.Config paramConfig, Drawable paramDrawable)
  {
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      if (paramDrawable != null)
      {
        int i = paramDrawable.getRowBytes() * paramDrawable.getHeight();
        InfoPrinter.b("Q.qqstory.newImageLoader", new Object[] { "URLImageLoader cache put:", paramConfig, " size=", Integer.valueOf(i) });
        return i;
      }
    }
    return 524288;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.URLImageLoader.1
 * JD-Core Version:    0.7.0.1
 */