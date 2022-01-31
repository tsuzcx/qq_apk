package com.tencent.biz.qqstory.album.view;

import blvo;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import ugk;
import wsv;

public class AlbumGalleryCapturePart$11
  implements Runnable
{
  public AlbumGalleryCapturePart$11(ugk paramugk) {}
  
  public void run()
  {
    if (ugk.b(this.this$0))
    {
      wsv.b("FredguoFix", "play animation");
      ugk.a(this.this$0).a(null);
      boolean bool1 = ugk.a(this.this$0).post(ugk.a(this.this$0));
      boolean bool2 = ugk.a(this.this$0).postDelayed(ugk.b(this.this$0), 800L);
      if ((!bool1) || (!bool2)) {
        ugk.a(this.this$0).a(ugk.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.11
 * JD-Core Version:    0.7.0.1
 */