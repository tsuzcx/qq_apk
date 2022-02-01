package com.tencent.biz.qqstory.album.view;

import bonx;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import vza;
import ykq;

public class AlbumGalleryCapturePart$11
  implements Runnable
{
  public AlbumGalleryCapturePart$11(vza paramvza) {}
  
  public void run()
  {
    if (vza.a(this.this$0))
    {
      ykq.b("FredguoFix", "play animation");
      vza.a(this.this$0).a(null);
      boolean bool1 = vza.a(this.this$0).post(vza.a(this.this$0));
      boolean bool2 = vza.a(this.this$0).postDelayed(vza.b(this.this$0), 800L);
      if ((!bool1) || (!bool2)) {
        vza.a(this.this$0).a(vza.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.11
 * JD-Core Version:    0.7.0.1
 */