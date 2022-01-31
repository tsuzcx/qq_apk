package com.tencent.biz.qqstory.album.view;

import bjke;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import srs;
import ved;

public class AlbumGalleryCapturePart$11
  implements Runnable
{
  public AlbumGalleryCapturePart$11(srs paramsrs) {}
  
  public void run()
  {
    if (srs.b(this.this$0))
    {
      ved.b("FredguoFix", "play animation");
      srs.a(this.this$0).a(null);
      boolean bool1 = srs.a(this.this$0).post(srs.a(this.this$0));
      boolean bool2 = srs.a(this.this$0).postDelayed(srs.b(this.this$0), 800L);
      if ((!bool1) || (!bool2)) {
        srs.a(this.this$0).a(srs.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.11
 * JD-Core Version:    0.7.0.1
 */