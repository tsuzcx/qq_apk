package com.tencent.mobileqq.ark.dict;

import com.tencent.qphone.base.util.QLog;

class ArkAiDictUpdateMgr$4$1
  implements ArkAiDictUpdateMgr.IUpdateDictCallback
{
  ArkAiDictUpdateMgr$4$1(ArkAiDictUpdateMgr.4 param4) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.i("ArkDict.Update", 1, String.format("updateDict, incremental update fail, full update result, success=%s, name=%s", new Object[] { Boolean.toString(paramBoolean), this.a.jdField_a_of_type_ComTencentMobileqqArkDictDictInfo.a }));
    this.a.jdField_a_of_type_ComTencentMobileqqArkDictArkAiDictUpdateMgr$IUpdateDictCallback.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.4.1
 * JD-Core Version:    0.7.0.1
 */