package com.tencent.mobileqq.ark;

import com.tencent.open.base.BspatchUtil;
import java.io.File;

class ArkAiDictUpdateMgr$7
  implements ArkAiDictUpdateMgr.IDownloadDictFileCallback
{
  ArkAiDictUpdateMgr$7(ArkAiDictUpdateMgr paramArkAiDictUpdateMgr, ArkAiDictUpdateMgr.DictInfo paramDictInfo1, String paramString1, ArkAiDictUpdateMgr.DictInfo paramDictInfo2, String paramString2, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_b_of_type_JavaLangString }));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$IUpdateDictCallback.a(false);
      return;
      if (!ArkAiDictUpdateMgr.b(paramArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.f))
      {
        ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, md5 mismatch, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.f }));
      }
      else
      {
        String str1 = ArkAiDictUpdateMgr.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_a_of_type_JavaLangString);
        if (!new File(str1).isFile())
        {
          ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, src path not exist, name=%s, path=s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_a_of_type_JavaLangString, str1 }));
        }
        else
        {
          String str2 = String.format("%s/diff-%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.d });
          if (!ArkAiDictUpdateMgr.a(paramArrayOfByte, str2))
          {
            ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, write diff to file fail, name=%s, path=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_a_of_type_JavaLangString, str2 }));
          }
          else
          {
            if (BspatchUtil.a(str1, str2, String.format("%s/%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_a_of_type_JavaLangString }))) {
              break;
            }
            ArkAppCenter.c("ArkApp.Dict.Update", String.format("dictIncrementalUpdate, patch fail, name=%s, diff-md5=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$DictInfo.f }));
          }
        }
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$IUpdateDictCallback.a(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.7
 * JD-Core Version:    0.7.0.1
 */