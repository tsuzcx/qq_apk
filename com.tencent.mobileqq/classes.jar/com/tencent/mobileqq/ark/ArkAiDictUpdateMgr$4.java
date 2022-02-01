package com.tencent.mobileqq.ark;

class ArkAiDictUpdateMgr$4
  implements ArkAiDictUpdateMgr.IUpdateDictCallback
{
  ArkAiDictUpdateMgr$4(ArkAiDictUpdateMgr paramArkAiDictUpdateMgr, ArkAiDictUpdateMgr.DictInfo paramDictInfo, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update success, name=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_a_of_type_JavaLangString }));
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$IUpdateDictCallback.a(true);
      return;
    }
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_a_of_type_JavaLangString }));
    ArkAiDictUpdateMgr.a(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo, new ArkAiDictUpdateMgr.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.4
 * JD-Core Version:    0.7.0.1
 */