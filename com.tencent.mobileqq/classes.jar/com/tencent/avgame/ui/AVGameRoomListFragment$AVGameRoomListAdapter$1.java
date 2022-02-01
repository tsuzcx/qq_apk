package com.tencent.avgame.ui;

import com.tencent.avgame.business.observer.AvGameRoomListObserver;
import com.tencent.avgame.business.observer.AvGameRoomListObserver.BatchGetGroupGameRoomListResult;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class AVGameRoomListFragment$AVGameRoomListAdapter$1
  extends AvGameRoomListObserver
{
  AVGameRoomListFragment$AVGameRoomListAdapter$1(AVGameRoomListFragment.AVGameRoomListAdapter paramAVGameRoomListAdapter) {}
  
  public void a(int paramInt, String paramString, AvGameRoomListObserver.BatchGetGroupGameRoomListResult paramBatchGetGroupGameRoomListResult)
  {
    ThreadManager.getUIHandler().post(new AVGameRoomListFragment.AVGameRoomListAdapter.1.1(this, paramBatchGetGroupGameRoomListResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AVGameRoomListFragment.AVGameRoomListAdapter.1
 * JD-Core Version:    0.7.0.1
 */