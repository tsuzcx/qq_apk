package com.tencent.mobileqq.ark.dict;

import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ArkAiDictUpdateMgr$1$1
  implements ArkAiDictUpdateMgr.IUpdateDictCallback
{
  ArkAiDictUpdateMgr$1$1(ArkAiDictUpdateMgr.1 param1, DictConfig paramDictConfig1, ArkAiDictUpdateMgr.UpdateState paramUpdateState, DictConfig paramDictConfig2) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      QLog.i("ArkDict.Update", 1, String.format("updateWordDict, one task failed, dict-id=%s", new Object[] { ArkAiDictUpdateMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkDictDictConfig) }));
      this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$UpdateState.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$UpdateState)
    {
      ArkAiDictUpdateMgr.UpdateState localUpdateState2 = this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$UpdateState;
      int i = localUpdateState2.jdField_a_of_type_Int - 1;
      localUpdateState2.jdField_a_of_type_Int = i;
      if (i != 0) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$UpdateState.jdField_a_of_type_Boolean)
      {
        QLog.i("ArkDict.Update", 1, "updateWordDict, all success");
        ArkAiDictUpdateMgr.a(this.b);
        ArkAiDictUpdateMgr.b(this.b);
        ArkAiDictMgr.b(ArkAiDictUpdateMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$1.this$0));
      }
      else
      {
        QLog.i("ArkDict.Update", 1, "updateWordDict, one or more tasks failed.");
      }
      try
      {
        ArkAiDictUpdateMgr.b(this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$1.this$0, false);
        if (ArkAiDictUpdateMgr.b(this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$1.this$0))
        {
          ArkAiDictUpdateMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$1.this$0, false);
          QLog.i("ArkDict.Update", 1, "updateWordDict, pending update task exists, wait 5 second and update");
          ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThreadDelay(new ArkAiDictUpdateMgr.1.1.1(this), 5000);
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.1.1
 * JD-Core Version:    0.7.0.1
 */