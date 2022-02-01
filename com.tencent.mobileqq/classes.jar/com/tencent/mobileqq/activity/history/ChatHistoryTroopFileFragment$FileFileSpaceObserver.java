package com.tencent.mobileqq.activity.history;

import com.tencent.biz.troop.file.protocol.ITroopFileInfoUpdate;
import com.tencent.biz.troop.file.protocol.TroopFileGetFileSpaceObserver;
import java.lang.ref.WeakReference;

class ChatHistoryTroopFileFragment$FileFileSpaceObserver
  extends TroopFileGetFileSpaceObserver
{
  WeakReference<ITroopFileInfoUpdate> a;
  
  ChatHistoryTroopFileFragment$FileFileSpaceObserver(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment, ITroopFileInfoUpdate paramITroopFileInfoUpdate)
  {
    this.a = new WeakReference(paramITroopFileInfoUpdate);
  }
  
  public void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    ITroopFileInfoUpdate localITroopFileInfoUpdate = (ITroopFileInfoUpdate)this.a.get();
    if (localITroopFileInfoUpdate != null) {
      localITroopFileInfoUpdate.a(paramBoolean, paramLong1, paramLong2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.FileFileSpaceObserver
 * JD-Core Version:    0.7.0.1
 */