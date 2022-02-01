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
    Object localObject = this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult;
    if ((localObject != null) && (((AvGameRoomListObserver.BatchGetGroupGameRoomListResult)localObject).jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult.jdField_a_of_type_JavaUtilList != null))
    {
      if (!AVGameRoomListFragment.AVGameRoomListAdapter.a(this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter$1.a).equals(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult.jdField_a_of_type_JavaLangString)) {
        return;
      }
      if ((AVGameRoomListFragment.AVGameRoomListAdapter.a(this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter$1.a) > 0) && (this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult.c == 0) && (this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult.b <= AVGameRoomListFragment.AVGameRoomListAdapter.a(this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter$1.a))) {
        return;
      }
      localObject = new ArrayList();
      if (AVGameRoomListFragment.AVGameRoomListAdapter.a(this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter$1.a) > 0)
      {
        ((List)localObject).addAll(AVGameRoomListFragment.AVGameRoomListAdapter.a(this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter$1.a));
        AVGameRoomListFragment.AVGameRoomListAdapter.a(this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter$1.a, (List)localObject, this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult.jdField_a_of_type_JavaUtilList);
      }
      else
      {
        ((List)localObject).addAll(this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult.jdField_a_of_type_JavaUtilList);
      }
      AVGameRoomListFragment.AVGameRoomListAdapter.a(this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter$1.a, (List)localObject);
      AVGameRoomListFragment.AVGameRoomListAdapter.a(this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter$1.a, this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult.b);
      localObject = this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter$1.a;
      boolean bool;
      if (this.jdField_a_of_type_ComTencentAvgameBusinessObserverAvGameRoomListObserver$BatchGetGroupGameRoomListResult.c > 0) {
        bool = true;
      } else {
        bool = false;
      }
      AVGameRoomListFragment.AVGameRoomListAdapter.a((AVGameRoomListFragment.AVGameRoomListAdapter)localObject, bool);
      this.jdField_a_of_type_ComTencentAvgameUiAVGameRoomListFragment$AVGameRoomListAdapter$1.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment.AVGameRoomListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */