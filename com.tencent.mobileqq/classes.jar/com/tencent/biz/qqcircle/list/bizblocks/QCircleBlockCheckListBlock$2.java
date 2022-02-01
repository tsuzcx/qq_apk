package com.tencent.biz.qqcircle.list.bizblocks;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.launcher.QCircleLauncher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class QCircleBlockCheckListBlock$2
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    QCircleLauncher.a(QCircleBlockCheckListBlock.getBlockLooperInfoList());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleBlockCheckListBlock.2
 * JD-Core Version:    0.7.0.1
 */