package com.tencent.biz.qqstory.album.view;

import bpuz;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import wia;
import yuk;

public class AlbumGalleryCapturePart$11
  implements Runnable
{
  public AlbumGalleryCapturePart$11(wia paramwia) {}
  
  public void run()
  {
    if (wia.b(this.this$0))
    {
      yuk.b("FredguoFix", "play animation");
      wia.a(this.this$0).a(null);
      boolean bool1 = wia.a(this.this$0).post(wia.a(this.this$0));
      boolean bool2 = wia.a(this.this$0).postDelayed(wia.b(this.this$0), 800L);
      if ((!bool1) || (!bool2)) {
        wia.a(this.this$0).a(wia.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.11
 * JD-Core Version:    0.7.0.1
 */