package com.tencent.biz.qqcircle.immersive.part;

import com.tencent.biz.qqcircle.immersive.adapter.QFSLayerPageAdapter;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;

class QFSLayerBasePart$5
  implements Runnable
{
  QFSLayerBasePart$5(QFSLayerBasePart paramQFSLayerBasePart, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.b == null) {
      return;
    }
    this.this$0.b.d(new QFSFeedSelectInfo(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.5
 * JD-Core Version:    0.7.0.1
 */