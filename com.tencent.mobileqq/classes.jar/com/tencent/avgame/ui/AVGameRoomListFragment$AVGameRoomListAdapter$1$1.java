package com.tencent.avgame.ui;

import com.tencent.avgame.business.observer.AvGameRoomListObserver.BatchGetGroupGameRoomListResult;
import java.util.ArrayList;
import java.util.List;

class AVGameRoomListFragment$AVGameRoomListAdapter$1$1
  implements Runnable
{
  AVGameRoomListFragment$AVGameRoomListAdapter$1$1(AVGameRoomListFragment.AVGameRoomListAdapter.1 param1, AvGameRoomListObserver.BatchGetGroupGameRoomListResult paramBatchGetGroupGameRoomListResult) {}
  
  public void run()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((AvGameRoomListObserver.BatchGetGroupGameRoomListResult)localObject).a != null) && (this.a.b != null))
    {
      if (!AVGameRoomListFragment.AVGameRoomListAdapter.a(this.b.a).equals(this.a.a)) {
        return;
      }
      if ((AVGameRoomListFragment.AVGameRoomListAdapter.b(this.b.a) > 0) && (this.a.e == 0) && (this.a.d <= AVGameRoomListFragment.AVGameRoomListAdapter.b(this.b.a))) {
        return;
      }
      localObject = new ArrayList();
      if (AVGameRoomListFragment.AVGameRoomListAdapter.b(this.b.a) > 0)
      {
        ((List)localObject).addAll(AVGameRoomListFragment.AVGameRoomListAdapter.c(this.b.a));
        AVGameRoomListFragment.AVGameRoomListAdapter.a(this.b.a, (List)localObject, this.a.b);
      }
      else
      {
        ((List)localObject).addAll(this.a.b);
      }
      AVGameRoomListFragment.AVGameRoomListAdapter.a(this.b.a, (List)localObject);
      AVGameRoomListFragment.AVGameRoomListAdapter.a(this.b.a, this.a.d);
      localObject = this.b.a;
      boolean bool;
      if (this.a.e > 0) {
        bool = true;
      } else {
        bool = false;
      }
      AVGameRoomListFragment.AVGameRoomListAdapter.a((AVGameRoomListFragment.AVGameRoomListAdapter)localObject, bool);
      this.b.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment.AVGameRoomListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */