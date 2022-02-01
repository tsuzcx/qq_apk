package com.tencent.biz.qqcircle.immersive.part;

import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.immersive.adapter.QFSLayerPageAdapter;
import com.tencent.biz.qqcircle.immersive.bean.QFSFeedSelectInfo;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer;

class QFSLayerBasePart$6
  implements Runnable
{
  QFSLayerBasePart$6(QFSLayerBasePart paramQFSLayerBasePart) {}
  
  public void run()
  {
    if (this.this$0.b != null)
    {
      if (this.this$0.a == null) {
        return;
      }
      this.this$0.b.d(new QFSFeedSelectInfo(this.this$0.a.getViewPager2().getCurrentItem()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.6
 * JD-Core Version:    0.7.0.1
 */