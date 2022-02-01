package com.tencent.mobileqq.ark.dict;

import com.tencent.open.base.BspatchUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ArkAiDictUpdateMgr$7
  implements ArkAiDictUpdateMgr.IDownloadDictFileCallback
{
  ArkAiDictUpdateMgr$7(ArkAiDictUpdateMgr paramArkAiDictUpdateMgr, DictInfo paramDictInfo1, String paramString1, DictInfo paramDictInfo2, String paramString2, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      if (!ArkAiDictUpdateMgr.b(paramArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.f))
      {
        QLog.i("ArkDict.Update", 1, String.format("dictIncrementalUpdate, md5 mismatch, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.f }));
      }
      else
      {
        String str1 = ArkAiDictUpdateMgr.a(this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_ComTencentMobileqqArkDictDictInfo.jdField_a_of_type_JavaLangString);
        if (!new File(str1).isFile())
        {
          QLog.i("ArkDict.Update", 1, String.format("dictIncrementalUpdate, src path not exist, name=%s, path=s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.jdField_a_of_type_JavaLangString, str1 }));
        }
        else
        {
          String str2 = String.format("%s/diff-%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.d });
          if (!ArkAiDictUpdateMgr.a(paramArrayOfByte, str2)) {
            QLog.i("ArkDict.Update", 1, String.format("dictIncrementalUpdate, write diff to file fail, name=%s, path=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.jdField_a_of_type_JavaLangString, str2 }));
          } else if (!BspatchUtil.a(str1, str2, String.format("%s/%s", new Object[] { this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.jdField_a_of_type_JavaLangString }))) {
            QLog.i("ArkDict.Update", 1, String.format("dictIncrementalUpdate, patch fail, name=%s, diff-md5=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.f }));
          } else {
            this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$IUpdateDictCallback.a(true);
          }
        }
      }
    }
    else {
      QLog.i("ArkDict.Update", 1, String.format("dictIncrementalUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.jdField_b_of_type_JavaLangString }));
    }
    this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$IUpdateDictCallback.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.7
 * JD-Core Version:    0.7.0.1
 */