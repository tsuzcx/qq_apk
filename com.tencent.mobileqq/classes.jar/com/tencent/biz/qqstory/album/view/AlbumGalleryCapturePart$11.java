package com.tencent.biz.qqstory.album.view;

import bmaa;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import ukt;
import wxe;

public class AlbumGalleryCapturePart$11
  implements Runnable
{
  public AlbumGalleryCapturePart$11(ukt paramukt) {}
  
  public void run()
  {
    if (ukt.b(this.this$0))
    {
      wxe.b("FredguoFix", "play animation");
      ukt.a(this.this$0).a(null);
      boolean bool1 = ukt.a(this.this$0).post(ukt.a(this.this$0));
      boolean bool2 = ukt.a(this.this$0).postDelayed(ukt.b(this.this$0), 800L);
      if ((!bool1) || (!bool2)) {
        ukt.a(this.this$0).a(ukt.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.11
 * JD-Core Version:    0.7.0.1
 */