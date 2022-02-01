package com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar;

import com.tencent.biz.qqstory.playvideo.player.TrimTextureVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.widget.HorizontalListView.OnScrollStateChangedListener;

class ScrollFrameSelectBar$1
  implements HorizontalListView.OnScrollStateChangedListener
{
  ScrollFrameSelectBar$1(ScrollFrameSelectBar paramScrollFrameSelectBar) {}
  
  public void onScrollStateChanged(int paramInt)
  {
    SLog.a("Q.qqstory.frameWidget.ScrollFrameSelectBar", "onScrollStateChanged:%s", Integer.valueOf(paramInt));
    switch (paramInt)
    {
    default: 
    case 4098: 
    case 4099: 
      if (ScrollFrameSelectBar.a(this.a).isPlaying())
      {
        ScrollFrameSelectBar.a(this.a).c();
        return;
      }
      break;
    case 4097: 
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.frameSelectBar.ScrollFrameSelectBar.1
 * JD-Core Version:    0.7.0.1
 */