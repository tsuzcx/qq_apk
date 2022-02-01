package com.tencent.mobileqq.ark.dict;

import com.tencent.qphone.base.util.QLog;

class ArkAiDictUpdateMgr$3
  implements ArkAiDictUpdateMgr.IUpdateDictCallback
{
  ArkAiDictUpdateMgr$3(ArkAiDictUpdateMgr paramArkAiDictUpdateMgr, DictInfo paramDictInfo, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback) {}
  
  public void a(boolean paramBoolean)
  {
    QLog.i("ArkDict.Update", 1, String.format("updateDict, local not exists, full update, success=%s, name=%s", new Object[] { Boolean.toString(paramBoolean), this.a.b }));
    this.b.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.3
 * JD-Core Version:    0.7.0.1
 */