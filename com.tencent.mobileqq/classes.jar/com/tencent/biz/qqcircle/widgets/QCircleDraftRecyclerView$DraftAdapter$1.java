package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QCircleDraftRecyclerView$DraftAdapter$1
  implements View.OnClickListener
{
  QCircleDraftRecyclerView$DraftAdapter$1(QCircleDraftRecyclerView.DraftAdapter paramDraftAdapter, QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder paramDraftViewHolder, DraftBean paramDraftBean) {}
  
  public void onClick(View paramView)
  {
    QCircleDraftRecyclerView.DraftAdapter.DraftViewHolder.c(this.a).setChecked(this.b.isSelected() ^ true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView.DraftAdapter.1
 * JD-Core Version:    0.7.0.1
 */