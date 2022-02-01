package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.util.Locale;

class ArkAiDictUpdateMgr$2
  implements ArkAiDictUpdateMgr.IUpdateDictCallback
{
  ArkAiDictUpdateMgr$2(ArkAiDictUpdateMgr paramArkAiDictUpdateMgr, ArkAiDictUpdateMgr.UpdateState paramUpdateState, ArkAiDictUpdateMgr.DictInfo paramDictInfo, String paramString1, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$UpdateState.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$UpdateState)
    {
      ArkAiDictUpdateMgr.UpdateState localUpdateState2 = this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$UpdateState;
      int i = localUpdateState2.jdField_a_of_type_Int - 1;
      localUpdateState2.jdField_a_of_type_Int = i;
      if (i > 0)
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format(Locale.CHINA, "updateWordDict, one task complete, name=%s, success=%s, left=%d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_a_of_type_JavaLangString, Boolean.toString(paramBoolean), Integer.valueOf(i) }));
        return;
      }
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateWordDict, all complete, success=%s", new Object[] { Boolean.toString(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$UpdateState.jdField_a_of_type_Boolean) }));
      if (!this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$UpdateState.jdField_a_of_type_Boolean)
      {
        FileUtils.a(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$IUpdateDictCallback.a(false);
        return;
      }
    }
    if (!ArkAiDictUpdateMgr.a(ArkAiDictMgr.a(this.b), new File(this.jdField_a_of_type_JavaLangString).getParent()))
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "updateWordDict, renameDictDirAfterUpdateSuccess fail");
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$IUpdateDictCallback.a(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$IUpdateDictCallback.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.2
 * JD-Core Version:    0.7.0.1
 */