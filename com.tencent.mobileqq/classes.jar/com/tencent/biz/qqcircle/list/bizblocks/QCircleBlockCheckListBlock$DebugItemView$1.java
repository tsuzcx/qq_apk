package com.tencent.biz.qqcircle.list.bizblocks;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleBlockCheckListBlock$DebugItemView$1
  implements View.OnClickListener
{
  QCircleBlockCheckListBlock$DebugItemView$1(QCircleBlockCheckListBlock.DebugItemView paramDebugItemView) {}
  
  public void onClick(View paramView)
  {
    if (QCircleBlockCheckListBlock.DebugItemView.a(this.a)) {
      QCircleBlockCheckListBlock.DebugItemView.b(this.a).getLayoutParams().height = ViewUtils.a(20.0F);
    } else {
      QCircleBlockCheckListBlock.DebugItemView.b(this.a).getLayoutParams().height = -2;
    }
    QCircleBlockCheckListBlock.DebugItemView.b(this.a).requestLayout();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleBlockCheckListBlock.DebugItemView.1
 * JD-Core Version:    0.7.0.1
 */