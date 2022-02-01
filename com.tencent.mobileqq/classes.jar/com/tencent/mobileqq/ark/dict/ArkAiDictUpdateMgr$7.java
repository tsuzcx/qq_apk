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
      if (!ArkAiDictUpdateMgr.b(paramArrayOfByte, this.a.g))
      {
        QLog.i("ArkDict.Update", 1, String.format("dictIncrementalUpdate, md5 mismatch, name=%s, url=%s, md5=%s", new Object[] { this.a.b, this.a.c, this.a.g }));
      }
      else
      {
        String str1 = ArkAiDictUpdateMgr.b(this.b, this.c.b);
        if (!new File(str1).isFile())
        {
          QLog.i("ArkDict.Update", 1, String.format("dictIncrementalUpdate, src path not exist, name=%s, path=s", new Object[] { this.a.b, str1 }));
        }
        else
        {
          String str2 = String.format("%s/diff-%s", new Object[] { this.d, this.a.e });
          if (!ArkAiDictUpdateMgr.a(paramArrayOfByte, str2)) {
            QLog.i("ArkDict.Update", 1, String.format("dictIncrementalUpdate, write diff to file fail, name=%s, path=%s", new Object[] { this.a.b, str2 }));
          } else if (!BspatchUtil.a(str1, str2, String.format("%s/%s", new Object[] { this.d, this.a.b }))) {
            QLog.i("ArkDict.Update", 1, String.format("dictIncrementalUpdate, patch fail, name=%s, diff-md5=%s", new Object[] { this.a.b, this.a.g }));
          } else {
            this.e.a(true);
          }
        }
      }
    }
    else {
      QLog.i("ArkDict.Update", 1, String.format("dictIncrementalUpdate, download fail, name=%s, url=%s", new Object[] { this.a.b, this.a.c }));
    }
    this.e.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.7
 * JD-Core Version:    0.7.0.1
 */