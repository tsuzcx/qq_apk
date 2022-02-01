package com.tencent.biz.qqcircle.immersive.part;

import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.beans.QCircleLayerBean;
import com.tencent.biz.qqcircle.immersive.personal.event.QFSLayerFeedPosSyncEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;

class QFSLayerPageListPart$1
  extends ViewPager2.OnPageChangeCallback
{
  QFSLayerPageListPart$1(QFSLayerPageListPart paramQFSLayerPageListPart) {}
  
  public void onPageSelected(int paramInt)
  {
    super.onPageSelected(paramInt);
    if ((QFSLayerPageListPart.a(this.a) != null) && (QFSLayerPageListPart.a(this.a).getTransInitBean() != null))
    {
      if (QFSLayerPageListPart.a(this.a).getTransInitBean().getExtraTypeInfo() == null) {
        return;
      }
      SimpleEventBus.getInstance().dispatchEvent(new QFSLayerFeedPosSyncEvent(paramInt, QFSLayerPageListPart.a(this.a).getTransInitBean().getExtraTypeInfo().sourceType));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerPageListPart.1
 * JD-Core Version:    0.7.0.1
 */