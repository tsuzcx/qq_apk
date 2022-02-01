package com.tencent.av.wtogether.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QVideoC2CFileExpandableListAdapter$1
  implements View.OnClickListener
{
  QVideoC2CFileExpandableListAdapter$1(QVideoC2CFileExpandableListAdapter paramQVideoC2CFileExpandableListAdapter) {}
  
  public void onClick(View paramView)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((QVideoC2CFileExpandableListAdapter.RecentItemHolder)paramView.getTag()).a;
    Object localObject2 = localFileManagerEntity.Uuid;
    QVideoC2CFileExpandableListAdapter localQVideoC2CFileExpandableListAdapter = this.a;
    Object localObject1 = localObject2;
    if (((String)localObject2).equalsIgnoreCase(QVideoC2CFileExpandableListAdapter.a(this.a))) {
      localObject1 = null;
    }
    QVideoC2CFileExpandableListAdapter.a(localQVideoC2CFileExpandableListAdapter, (String)localObject1);
    this.a.notifyDataSetChanged();
    if (QVideoC2CFileExpandableListAdapter.a(this.a) != null)
    {
      localObject2 = QVideoC2CFileExpandableListAdapter.a(this.a);
      if (QVideoC2CFileExpandableListAdapter.a(this.a) == null) {
        break label113;
      }
    }
    label113:
    for (localObject1 = localFileManagerEntity;; localObject1 = null)
    {
      ((QVideoC2CFileExpandableListAdapter.UIEvent)localObject2).a((FileManagerEntity)localObject1);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QVideoC2CFileExpandableListAdapter.1
 * JD-Core Version:    0.7.0.1
 */