package com.tencent.mobileqq.ark;

class ArkAiDictUpdateMgr$3
  implements ArkAiDictUpdateMgr.IUpdateDictCallback
{
  ArkAiDictUpdateMgr$3(ArkAiDictUpdateMgr paramArkAiDictUpdateMgr, ArkAiDictUpdateMgr.DictInfo paramDictInfo, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback) {}
  
  public void a(boolean paramBoolean)
  {
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, local not exists, full update, success=%s, name=%s", new Object[] { Boolean.toString(paramBoolean), this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.a }));
    if (paramBoolean) {}
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$IUpdateDictCallback.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.3
 * JD-Core Version:    0.7.0.1
 */