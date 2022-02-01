package com.tencent.av.wtogether.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.wtogether.callback.C2CFileClickListener;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;

class QVideoC2CFileExpandableListAdapter$1
  implements View.OnClickListener
{
  QVideoC2CFileExpandableListAdapter$1(QVideoC2CFileExpandableListAdapter paramQVideoC2CFileExpandableListAdapter) {}
  
  public void onClick(View paramView)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)((QVideoC2CFileExpandableListAdapter.RecentItemHolder)paramView.getTag()).a;
    Object localObject = localFileManagerEntity.Uuid;
    QVideoC2CFileExpandableListAdapter localQVideoC2CFileExpandableListAdapter = this.a;
    paramView = (View)localObject;
    if (((String)localObject).equalsIgnoreCase(QVideoC2CFileExpandableListAdapter.a(localQVideoC2CFileExpandableListAdapter))) {
      paramView = null;
    }
    QVideoC2CFileExpandableListAdapter.a(localQVideoC2CFileExpandableListAdapter, paramView);
    this.a.notifyDataSetChanged();
    if (QVideoC2CFileExpandableListAdapter.a(this.a) != null)
    {
      localObject = QVideoC2CFileExpandableListAdapter.a(this.a);
      if (QVideoC2CFileExpandableListAdapter.a(this.a) != null) {
        paramView = localFileManagerEntity;
      } else {
        paramView = null;
      }
      ((C2CFileClickListener)localObject).a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.adapter.QVideoC2CFileExpandableListAdapter.1
 * JD-Core Version:    0.7.0.1
 */