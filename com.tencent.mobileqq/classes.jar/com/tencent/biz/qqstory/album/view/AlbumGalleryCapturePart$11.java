package com.tencent.biz.qqstory.album.view;

import bjjn;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import srv;
import veg;

public class AlbumGalleryCapturePart$11
  implements Runnable
{
  public AlbumGalleryCapturePart$11(srv paramsrv) {}
  
  public void run()
  {
    if (srv.b(this.this$0))
    {
      veg.b("FredguoFix", "play animation");
      srv.a(this.this$0).a(null);
      boolean bool1 = srv.a(this.this$0).post(srv.a(this.this$0));
      boolean bool2 = srv.a(this.this$0).postDelayed(srv.b(this.this$0), 800L);
      if ((!bool1) || (!bool2)) {
        srv.a(this.this$0).a(srv.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.11
 * JD-Core Version:    0.7.0.1
 */