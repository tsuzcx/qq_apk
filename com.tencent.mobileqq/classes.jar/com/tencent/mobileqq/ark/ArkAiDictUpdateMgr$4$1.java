package com.tencent.mobileqq.ark;

class ArkAiDictUpdateMgr$4$1
  implements ArkAiDictUpdateMgr.IUpdateDictCallback
{
  ArkAiDictUpdateMgr$4$1(ArkAiDictUpdateMgr.4 param4) {}
  
  public void a(boolean paramBoolean)
  {
    ArkAppCenter.c("ArkApp.Dict.Update", String.format("updateDict, incremental update fail, full update result, success=%s, name=%s", new Object[] { Boolean.toString(paramBoolean), this.a.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.a }));
    if (paramBoolean) {}
    this.a.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$IUpdateDictCallback.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.4.1
 * JD-Core Version:    0.7.0.1
 */