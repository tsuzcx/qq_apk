package com.tencent.biz.qqstory.album.view;

import bmyf;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import vkf;
import xvv;

public class AlbumGalleryCapturePart$11
  implements Runnable
{
  public AlbumGalleryCapturePart$11(vkf paramvkf) {}
  
  public void run()
  {
    if (vkf.a(this.this$0))
    {
      xvv.b("FredguoFix", "play animation");
      vkf.a(this.this$0).a(null);
      boolean bool1 = vkf.a(this.this$0).post(vkf.a(this.this$0));
      boolean bool2 = vkf.a(this.this$0).postDelayed(vkf.b(this.this$0), 800L);
      if ((!bool1) || (!bool2)) {
        vkf.a(this.this$0).a(vkf.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.11
 * JD-Core Version:    0.7.0.1
 */