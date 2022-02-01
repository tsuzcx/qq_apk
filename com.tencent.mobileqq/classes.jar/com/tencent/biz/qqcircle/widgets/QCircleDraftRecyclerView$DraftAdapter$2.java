package com.tencent.biz.qqcircle.widgets;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.winkpublish.model.DraftBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class QCircleDraftRecyclerView$DraftAdapter$2
  implements CompoundButton.OnCheckedChangeListener
{
  QCircleDraftRecyclerView$DraftAdapter$2(QCircleDraftRecyclerView.DraftAdapter paramDraftAdapter, DraftBean paramDraftBean) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.a.setSelected(paramBoolean);
    Iterator localIterator = this.b.b.iterator();
    int i = 0;
    while (localIterator.hasNext()) {
      if (((DraftBean)localIterator.next()).isSelected()) {
        i += 1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QCircleDraftRecyclerView", 1, new Object[] { "onCheckedChanged isChecked: ", Boolean.valueOf(paramBoolean), ", selectCount: ", Integer.valueOf(i) });
    }
    QCircleDraftRecyclerView.DraftAdapter.a(this.b).a(i, this.b.b.size());
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleDraftRecyclerView.DraftAdapter.2
 * JD-Core Version:    0.7.0.1
 */