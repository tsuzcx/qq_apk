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
      if (!ArkAiDictUpdateMgr.b(paramArrayOfByte, this.a.e))
      {
        QLog.i("ArkDict.Update", 1, String.format("dictFullUpdate, check md5 fail, name=%s, url=%s, md5=%s", new Object[] { this.a.b, this.a.c, this.a.e }));
      }
      else
      {
        String str = String.format("%s/%s", new Object[] { this.b, this.a.b });
        if (!ArkAiDictUpdateMgr.a(paramArrayOfByte, str)) {
          QLog.i("ArkDict.Update", 1, String.format("dictFullUpdate, write to file fail, name=%s, url=%s, path=%s", new Object[] { this.a.b, this.a.c, str }));
        } else {
          this.c.a(true);
        }
      }
    }
    else {
      QLog.i("ArkDict.Update", 1, String.format("dictFullUpdate, download fail, name=%s, url=%s", new Object[] { this.a.b, this.a.c }));
    }
    this.c.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.6
 * JD-Core Version:    0.7.0.1
 */