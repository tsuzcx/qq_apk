package com.tencent.biz.qqstory.album.view;

import com.tencent.biz.qqstory.support.logging.SLog;
import dov.com.qq.im.capture.view.CustomLinearSnapHelper;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;

class AlbumGalleryCapturePart$11
  implements Runnable
{
  AlbumGalleryCapturePart$11(AlbumGalleryCapturePart paramAlbumGalleryCapturePart) {}
  
  public void run()
  {
    if (AlbumGalleryCapturePart.b(this.this$0))
    {
      SLog.b("FredguoFix", "play animation");
      AlbumGalleryCapturePart.a(this.this$0).a(null);
      boolean bool1 = AlbumGalleryCapturePart.a(this.this$0).post(AlbumGalleryCapturePart.a(this.this$0));
      boolean bool2 = AlbumGalleryCapturePart.a(this.this$0).postDelayed(AlbumGalleryCapturePart.b(this.this$0), 800L);
      if ((!bool1) || (!bool2)) {
        AlbumGalleryCapturePart.a(this.this$0).a(AlbumGalleryCapturePart.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.11
 * JD-Core Version:    0.7.0.1
 */