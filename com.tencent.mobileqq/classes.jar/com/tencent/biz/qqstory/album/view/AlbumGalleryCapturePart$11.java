package com.tencent.biz.qqstory.album.view;

import bote;
import dov.com.qq.im.capture.view.SpeedFlexibleRecyclerView;
import wef;
import yqp;

public class AlbumGalleryCapturePart$11
  implements Runnable
{
  public AlbumGalleryCapturePart$11(wef paramwef) {}
  
  public void run()
  {
    if (wef.b(this.this$0))
    {
      yqp.b("FredguoFix", "play animation");
      wef.a(this.this$0).a(null);
      boolean bool1 = wef.a(this.this$0).post(wef.a(this.this$0));
      boolean bool2 = wef.a(this.this$0).postDelayed(wef.b(this.this$0), 800L);
      if ((!bool1) || (!bool2)) {
        wef.a(this.this$0).a(wef.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.11
 * JD-Core Version:    0.7.0.1
 */