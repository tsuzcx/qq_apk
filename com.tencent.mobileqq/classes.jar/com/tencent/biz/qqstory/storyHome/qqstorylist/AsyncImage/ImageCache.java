package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class ImageCache
  extends LruCache
{
  protected int a(String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.ImageCache
 * JD-Core Version:    0.7.0.1
 */