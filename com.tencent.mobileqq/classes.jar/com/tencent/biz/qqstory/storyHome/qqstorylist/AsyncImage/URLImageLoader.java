package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.tencent.biz.qqstory.view.asyncImageLoader.ImageLoader;
import com.tencent.biz.qqstory.view.asyncImageLoader.Task;

public class URLImageLoader
  extends ImageLoader<URLImageLoader.Config>
{
  private LruCache<URLImageLoader.Config, Drawable> a = new URLImageLoader.1(this, 5242880);
  
  public LruCache<URLImageLoader.Config, Drawable> a()
  {
    return this.a;
  }
  
  public Task a(ImageView paramImageView, URLImageLoader.Config paramConfig)
  {
    return new URLImageLoader.URLTask(paramImageView, paramConfig);
  }
  
  public void b()
  {
    super.b();
    c();
  }
  
  public void c()
  {
    super.c();
    try
    {
      this.a.evictAll();
      return;
    }
    catch (Exception localException)
    {
      label12:
      break label12;
    }
    this.a = new URLImageLoader.2(this, 5242880);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.URLImageLoader
 * JD-Core Version:    0.7.0.1
 */