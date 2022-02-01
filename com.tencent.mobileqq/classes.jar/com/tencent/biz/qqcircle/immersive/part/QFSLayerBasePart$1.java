package com.tencent.biz.qqcircle.immersive.part;

import android.view.View;
import com.tencent.biz.qqcircle.immersive.bean.QFSTouchBean;
import com.tencent.biz.qqcircle.immersive.views.QFSLayerFeedItemView;
import com.tencent.biz.qqcircle.immersive.views.QFSPageTurnContainer.ChildDisallowInterceptListener;

class QFSLayerBasePart$1
  implements QFSPageTurnContainer.ChildDisallowInterceptListener
{
  QFSLayerBasePart$1(QFSLayerBasePart paramQFSLayerBasePart) {}
  
  public boolean a(View paramView, QFSTouchBean paramQFSTouchBean)
  {
    if ((paramView instanceof QFSLayerFeedItemView)) {
      return ((QFSLayerFeedItemView)paramView).a(paramQFSTouchBean);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSLayerBasePart.1
 * JD-Core Version:    0.7.0.1
 */