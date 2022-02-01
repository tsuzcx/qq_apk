package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.biz.qqcircle.immersive.QFSPersonalProductFeedFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QFSPersonalBottomWidget$7
  implements View.OnClickListener
{
  QFSPersonalBottomWidget$7(QFSPersonalBottomWidget paramQFSPersonalBottomWidget, QFSPersonalProductFeedFragment paramQFSPersonalProductFeedFragment) {}
  
  public void onClick(View paramView)
  {
    QFSPersonalBottomWidget.e(this.b).setCurrentItem(0);
    this.a.x();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.widget.QFSPersonalBottomWidget.7
 * JD-Core Version:    0.7.0.1
 */