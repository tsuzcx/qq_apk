package com.tencent.comic.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.image.DownloadParams;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;

class ComicCancelRedPointPopItemView$1
  implements DownloadParams.DecodeHandler
{
  ComicCancelRedPointPopItemView$1(ComicCancelRedPointPopItemView paramComicCancelRedPointPopItemView, Context paramContext) {}
  
  public Bitmap run(DownloadParams paramDownloadParams, Bitmap paramBitmap)
  {
    return BaseImageUtil.b(paramBitmap, DisplayUtil.a(this.a, 8.0F), DisplayUtil.a(this.a, 260.0F), DisplayUtil.a(this.a, 346.5F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.ui.ComicCancelRedPointPopItemView.1
 * JD-Core Version:    0.7.0.1
 */