package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.support.v4.util.LruCache;
import android.widget.ImageView;
import com.tencent.biz.qqstory.view.asyncImageLoader.ImageLoader;
import com.tencent.biz.qqstory.view.asyncImageLoader.Task;
import nxr;
import nxs;

public class URLImageLoader
  extends ImageLoader
{
  private LruCache a = new nxr(this, 5242880);
  
  public LruCache a()
  {
    return this.a;
  }
  
  public Task a(ImageView paramImageView, URLImageLoader.Config paramConfig)
  {
    return new URLImageLoader.URLTask(paramImageView, paramConfig);
  }
  
  public void a()
  {
    super.a();
    b();
  }
  
  public void b()
  {
    super.b();
    try
    {
      this.a.evictAll();
      return;
    }
    catch (Exception localException)
    {
      this.a = new nxs(this, 5242880);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.URLImageLoader
 * JD-Core Version:    0.7.0.1
 */