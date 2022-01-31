package com.tencent.biz.qqstory.album.view;

import bhov;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import sez;
import urk;

public class AlbumGalleryCapturePart$11
  implements Runnable
{
  public AlbumGalleryCapturePart$11(sez paramsez) {}
  
  public void run()
  {
    if (sez.b(this.this$0))
    {
      urk.b("FredguoFix", "play animation");
      sez.a(this.this$0).a(null);
      boolean bool1 = sez.a(this.this$0).post(sez.a(this.this$0));
      boolean bool2 = sez.a(this.this$0).postDelayed(sez.b(this.this$0), 800L);
      if ((!bool1) || (!bool2)) {
        sez.a(this.this$0).a(sez.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.11
 * JD-Core Version:    0.7.0.1
 */