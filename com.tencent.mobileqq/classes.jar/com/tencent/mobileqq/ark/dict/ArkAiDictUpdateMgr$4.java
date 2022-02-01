package com.tencent.mobileqq.ark.dict;

import com.tencent.qphone.base.util.QLog;

class ArkAiDictUpdateMgr$4
  implements ArkAiDictUpdateMgr.IUpdateDictCallback
{
  ArkAiDictUpdateMgr$4(ArkAiDictUpdateMgr paramArkAiDictUpdateMgr, DictInfo paramDictInfo, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QLog.i("ArkDict.Update", 1, String.format("updateDict, incremental update success, name=%s", new Object[] { this.a.b }));
      this.b.a(true);
      return;
    }
    QLog.i("ArkDict.Update", 1, String.format("updateDict, incremental update fail, try full update, name=%s", new Object[] { this.a.b }));
    ArkAiDictUpdateMgr.a(this.d, this.c, this.a, new ArkAiDictUpdateMgr.4.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.4
 * JD-Core Version:    0.7.0.1
 */