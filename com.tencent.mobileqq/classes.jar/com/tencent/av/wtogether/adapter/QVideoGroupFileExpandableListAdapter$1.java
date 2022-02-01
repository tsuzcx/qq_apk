package com.tencent.av.wtogether.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QVideoGroupFileExpandableListAdapter$1
  implements View.OnClickListener
{
  QVideoGroupFileExpandableListAdapter$1(QVideoGroupFileExpandableListAdapter paramQVideoGroupFileExpandableListAdapter) {}
  
  public void onClick(View paramView)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((QVideoGroupFileExpandableListAdapter.RecentItemHolder)paramView.getTag()).a;
    Object localObject2 = localFileManagerEntity.Uuid;
    QVideoGroupFileExpandableListAdapter localQVideoGroupFileExpandableListAdapter = this.a;
    Object localObject1 = localObject2;
    if (((String)localObject2).equalsIgnoreCase(QVideoGroupFileExpandableListAdapter.a(this.a))) {
      localObject1 = null;
    }
    QVideoGroupFileExpandableListAdapter.a(localQVideoGroupFileExpandableListAdapter, (String)localObject1);
    this.a.notifyDataSetChanged();
    if (QVideoGroupFileExpandableListAdapter.a(this.a) != null)
    {
      localObject2 = QVideoGroupFileExpandableListAdapter.a(this.a);
      if (QVideoGroupFileExpandableListAdapter.a(this.a) == null) {
        break label113;
      }
    }
    label113:
    for (localObject1 = localFileManagerEntity;; localObject1 = null)
    {
      ((QVideoGroupFileExpandableListAdapter.UIEvent)localObject2).a((FileManagerEntity)localObject1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QVideoGroupFileExpandableListAdapter.1
 * JD-Core Version:    0.7.0.1
 */