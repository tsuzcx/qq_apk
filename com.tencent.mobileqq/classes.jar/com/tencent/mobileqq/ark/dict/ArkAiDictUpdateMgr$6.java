package com.tencent.mobileqq.ark.dict;

import com.tencent.qphone.base.util.QLog;

class ArkAiDictUpdateMgr$6
  implements ArkAiDictUpdateMgr.IDownloadDictFileCallback
{
  ArkAiDictUpdateMgr$6(ArkAiDictUpdateMgr paramArkAiDictUpdateMgr, DictInfo paramDictInfo, String paramString, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      if (!ArkAiDictUpdateMgr.b(paramArrayOfByte, this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.d))
      {
        QLog.i("ArkDict.Update", 1, String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.b, this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.d }));
      }
      else
      {
        String str = String.format("%s/%s", new Object[] { this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.jdField_a_of_type_JavaLangString });
        if (!ArkAiDictUpdateMgr.a(paramArrayOfByte, str)) {
          QLog.i("ArkDict.Update", 1, String.format("dictFullUpdate, write to file fail, name=%s, url=%s, path=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.b, str }));
        } else {
          this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$IUpdateDictCallback.a(true);
        }
      }
    }
    else {
      QLog.i("ArkDict.Update", 1, String.format("dictFullUpdate, download fail, name=%s, url=%s", new Object[] { this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.b }));
    }
    this.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$IUpdateDictCallback.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.6
 * JD-Core Version:    0.7.0.1
 */