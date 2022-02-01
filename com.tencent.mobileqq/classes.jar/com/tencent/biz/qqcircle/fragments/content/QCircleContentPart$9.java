package com.tencent.biz.qqcircle.fragments.content;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleContentPart$9
  implements View.OnClickListener
{
  QCircleContentPart$9(QCircleContentPart paramQCircleContentPart) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.g() instanceof Activity)) {
      this.a.a(0.0F, 0.0F);
    }
    QCircleContentPart localQCircleContentPart = this.a;
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = localQCircleContentPart.q();
    String str;
    if (QCircleContentPart.p(this.a)) {
      str = "1";
    } else {
      str = "2";
    }
    QCircleContentPart.a(localQCircleContentPart, 91, 2, localQCircleExtraTypeInfo, str);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentPart.9
 * JD-Core Version:    0.7.0.1
 */