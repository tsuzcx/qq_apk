package com.tencent.av.wtogether.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.wtogether.callback.GroupFileClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class QVideoGroupFileExpandableListAdapter$1
  implements View.OnClickListener
{
  QVideoGroupFileExpandableListAdapter$1(QVideoGroupFileExpandableListAdapter paramQVideoGroupFileExpandableListAdapter) {}
  
  public void onClick(View paramView)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((QVideoGroupFileExpandableListAdapter.RecentItemHolder)paramView.getTag()).g;
    Object localObject = localFileManagerEntity.Uuid;
    QVideoGroupFileExpandableListAdapter localQVideoGroupFileExpandableListAdapter = this.a;
    paramView = (View)localObject;
    if (((String)localObject).equalsIgnoreCase(QVideoGroupFileExpandableListAdapter.a(localQVideoGroupFileExpandableListAdapter))) {
      paramView = null;
    }
    QVideoGroupFileExpandableListAdapter.a(localQVideoGroupFileExpandableListAdapter, paramView);
    this.a.notifyDataSetChanged();
    if (QVideoGroupFileExpandableListAdapter.b(this.a) != null)
    {
      localObject = QVideoGroupFileExpandableListAdapter.b(this.a);
      if (QVideoGroupFileExpandableListAdapter.a(this.a) != null) {
        paramView = localFileManagerEntity;
      } else {
        paramView = null;
      }
      ((GroupFileClickListener)localObject).a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QVideoGroupFileExpandableListAdapter.1
 * JD-Core Version:    0.7.0.1
 */