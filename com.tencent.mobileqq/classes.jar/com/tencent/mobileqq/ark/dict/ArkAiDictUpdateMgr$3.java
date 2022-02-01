package com.tencent.mobileqq.ark.dict;

import com.tencent.qphone.base.util.QLog;

class ArkAiDictUpdateMgr$3
  implements ArkAiDictUpdateMgr.IUpdateDictCallback
{
  ArkAiDictUpdateMgr$3(ArkAiDictUpdateMgr paramArkAiDictUpdateMgr, DictInfo paramDictInfo, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.i("ArkDict.Update", 1, String.format("updateDict, local not exists, full update, success=%s, name=%s", new Object[] { Boolean.toString(paramBoolean), this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.a }));
    this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$IUpdateDictCallback.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.3
 * JD-Core Version:    0.7.0.1
 */