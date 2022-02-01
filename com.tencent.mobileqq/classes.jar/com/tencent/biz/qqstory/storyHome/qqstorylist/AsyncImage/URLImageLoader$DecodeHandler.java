package com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.biz.qqstory.storyHome.qqstorylist.common.StoryListUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;

public class URLImageLoader$DecodeHandler
  implements DownloadParams.DecodeHandler
{
  private URLImageLoader.Config a;
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    if (this.a.b != null) {
      return StoryListUtils.a(new BitmapDrawable(paramBitmap), this.a.c, this.a.d, UIUtils.e, this.a.b);
    }
    return paramBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.AsyncImage.URLImageLoader.DecodeHandler
 * JD-Core Version:    0.7.0.1
 */