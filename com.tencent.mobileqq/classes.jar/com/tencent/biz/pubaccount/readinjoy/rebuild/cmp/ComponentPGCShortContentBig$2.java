package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import com.tencent.biz.pubaccount.readinjoy.gifvideo.wrappers.media.MediaVideoView;
import prl;
import prm;

class ComponentPGCShortContentBig$2
  implements Runnable
{
  ComponentPGCShortContentBig$2(ComponentPGCShortContentBig paramComponentPGCShortContentBig, prl paramprl) {}
  
  public void run()
  {
    if ((ComponentPGCShortContentBig.a(this.this$0) instanceof MediaVideoView)) {
      ((MediaVideoView)ComponentPGCShortContentBig.a(this.this$0)).requestUrlByVid(prm.a(), this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentPGCShortContentBig.2
 * JD-Core Version:    0.7.0.1
 */