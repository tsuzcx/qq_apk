package com.tencent.biz.qqcircle.immersive.part;

import com.tencent.biz.qqcircle.immersive.adapter.QFSLayerPageAdapter;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;

class QFSLayerBasePart$4
  implements Runnable
{
  QFSLayerBasePart$4(QFSLayerBasePart paramQFSLayerBasePart, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      return;
    }
    this.this$0.b.e(new QFSFeedSelectInfo(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.4
 * JD-Core Version:    0.7.0.1
 */