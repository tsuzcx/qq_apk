package com.tencent.mobileqq.activity.history;

import com.tencent.biz.troop.file.protocol.ITroopFileInfoUpdate;
import com.tencent.biz.troop.file.protocol.TroopFileGetFileCountObserver;
import java.lang.ref.WeakReference;

class ChatHistoryTroopFileFragment$FileFileCountObserver
  extends TroopFileGetFileCountObserver
{
  WeakReference<ITroopFileInfoUpdate> jdField_a_of_type_JavaLangRefWeakReference;
  
  ChatHistoryTroopFileFragment$FileFileCountObserver(ChatHistoryTroopFileFragment paramChatHistoryTroopFileFragment, ITroopFileInfoUpdate paramITroopFileInfoUpdate)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramITroopFileInfoUpdate);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3)
  {
    ITroopFileInfoUpdate localITroopFileInfoUpdate = (ITroopFileInfoUpdate)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localITroopFileInfoUpdate != null) {
      localITroopFileInfoUpdate.a(paramBoolean1, paramBoolean2, paramInt1, paramInt2, paramInt3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopFileFragment.FileFileCountObserver
 * JD-Core Version:    0.7.0.1
 */