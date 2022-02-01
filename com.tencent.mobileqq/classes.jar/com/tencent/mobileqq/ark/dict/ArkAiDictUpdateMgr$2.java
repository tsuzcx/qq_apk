package com.tencent.mobileqq.ark.dict;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;

class ArkAiDictUpdateMgr$2
  implements ArkAiDictUpdateMgr.IUpdateDictCallback
{
  ArkAiDictUpdateMgr$2(ArkAiDictUpdateMgr paramArkAiDictUpdateMgr, ArkAiDictUpdateMgr.UpdateState paramUpdateState, DictInfo paramDictInfo, String paramString1, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$UpdateState.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$UpdateState)
    {
      ArkAiDictUpdateMgr.UpdateState localUpdateState2 = this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$UpdateState;
      int i = localUpdateState2.jdField_a_of_type_Int - 1;
      localUpdateState2.jdField_a_of_type_Int = i;
      if (i > 0)
      {
        QLog.i("ArkDict.Update", 1, String.format(Locale.CHINA, "updateWordDict, one task complete, name=%s, success=%s, left=%d", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.jdField_a_of_type_JavaLangString, Boolean.toString(paramBoolean), Integer.valueOf(i) }));
        return;
      }
      QLog.i("ArkDict.Update", 1, String.format("updateWordDict, all complete, success=%s", new Object[] { Boolean.toString(this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$UpdateState.jdField_a_of_type_Boolean) }));
      if (!this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$UpdateState.jdField_a_of_type_Boolean)
      {
        FileUtils.deleteDirectory(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$IUpdateDictCallback.a(false);
        return;
      }
      if (!ArkAiDictUpdateMgr.a(ArkAiDictMgr.a(this.b), new File(this.jdField_a_of_type_JavaLangString).getParent()))
      {
        QLog.i("ArkDict.Update", 1, "updateWordDict, renameDictDirAfterUpdateSuccess fail");
        this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$IUpdateDictCallback.a(false);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$IUpdateDictCallback.a(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.2
 * JD-Core Version:    0.7.0.1
 */