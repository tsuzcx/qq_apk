package com.tencent.mobileqq.ark;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.config.business.ArkManageConfig.AIDictConfig;
import com.tencent.mobileqq.config.business.ArkManageConfig.DictConfig;
import java.lang.ref.WeakReference;

class ArkAiDictUpdateMgr$1$1
  implements ArkAiDictUpdateMgr.IUpdateDictCallback
{
  ArkAiDictUpdateMgr$1$1(ArkAiDictUpdateMgr.1 param1, ArkManageConfig.DictConfig paramDictConfig, ArkAiDictUpdateMgr.UpdateState paramUpdateState, ArkManageConfig.AIDictConfig paramAIDictConfig) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateWordDict, one task failed, dict-id=%s", new Object[] { ArkAiDictUpdateMgr.a(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessArkManageConfig$DictConfig) }));
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$UpdateState.jdField_a_of_type_Boolean = false;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$UpdateState)
      {
        ArkAiDictUpdateMgr.UpdateState localUpdateState2 = this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$UpdateState;
        int i = localUpdateState2.jdField_a_of_type_Int - 1;
        localUpdateState2.jdField_a_of_type_Int = i;
        if (i != 0) {
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$UpdateState.jdField_a_of_type_Boolean)
        {
          ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, all success");
          ArkAiDictUpdateMgr.a(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessArkManageConfig$AIDictConfig);
          ArkAiDictUpdateMgr.b(this.jdField_a_of_type_ComTencentMobileqqConfigBusinessArkManageConfig$AIDictConfig);
          ArkAiDictMgr.b((AppInterface)ArkAiDictUpdateMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0).get());
          try
          {
            ArkAiDictUpdateMgr.b(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0, false);
            if (ArkAiDictUpdateMgr.b(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0))
            {
              ArkAiDictUpdateMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$1.this$0, false);
              ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, pending update task exists, wait 5 second and update");
              ArkAppCenter.a().postToMainThreadDelayed(new ArkAiDictUpdateMgr.1.1.1(this), 5000L);
            }
            return;
          }
          finally {}
        }
      }
      ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, one or more tasks failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.1.1
 * JD-Core Version:    0.7.0.1
 */