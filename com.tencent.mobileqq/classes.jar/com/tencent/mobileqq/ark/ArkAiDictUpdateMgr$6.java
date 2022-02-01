package com.tencent.mobileqq.ark;

class ArkAiDictUpdateMgr$6
  implements ArkAiDictUpdateMgr.IDownloadDictFileCallback
{
  ArkAiDictUpdateMgr$6(ArkAiDictUpdateMgr paramArkAiDictUpdateMgr, ArkAiDictUpdateMgr.DictInfo paramDictInfo, String paramString, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.b }));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$IUpdateDictCallback.a(false);
      return;
      if (!ArkAiDictUpdateMgr.b(paramArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.d))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.b, this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.d }));
      }
      else
      {
        String str = String.format("%s/%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_a_of_type_JavaLangString });
        if (ArkAiDictUpdateMgr.a(paramArrayOfByte, str)) {
          break;
        }
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictFullUpdate, write to file fail, name=%s, url=%s, path=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.b, str }));
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$IUpdateDictCallback.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.6
 * JD-Core Version:    0.7.0.1
 */