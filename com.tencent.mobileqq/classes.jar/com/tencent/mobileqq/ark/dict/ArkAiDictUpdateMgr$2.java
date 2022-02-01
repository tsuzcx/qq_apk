package com.tencent.mobileqq.ark.dict;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Locale;

class ArkAiDictUpdateMgr$2
  implements ArkAiDictUpdateMgr.IUpdateDictCallback
{
  ArkAiDictUpdateMgr$2(ArkAiDictUpdateMgr paramArkAiDictUpdateMgr, ArkAiDictUpdateMgr.UpdateState paramUpdateState, DictInfo paramDictInfo, String paramString1, ArkAiDictUpdateMgr.IUpdateDictCallback paramIUpdateDictCallback, String paramString2) {}
  
  public void a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      this.a.b = false;
    }
    synchronized (this.a)
    {
      ArkAiDictUpdateMgr.UpdateState localUpdateState2 = this.a;
      int i = localUpdateState2.a - 1;
      localUpdateState2.a = i;
      if (i > 0)
      {
        QLog.i("ArkDict.Update", 1, String.format(Locale.CHINA, "updateWordDict, one task complete, name=%s, success=%s, left=%d", new Object[] { this.b.b, Boolean.toString(paramBoolean), Integer.valueOf(i) }));
        return;
      }
      QLog.i("ArkDict.Update", 1, String.format("updateWordDict, all complete, success=%s", new Object[] { Boolean.toString(this.a.b) }));
      if (!this.a.b)
      {
        FileUtils.deleteDirectory(this.c);
        this.d.a(false);
        return;
      }
      if (!ArkAiDictUpdateMgr.a(ArkAiDictMgr.a(this.e), new File(this.c).getParent()))
      {
        QLog.i("ArkDict.Update", 1, "updateWordDict, renameDictDirAfterUpdateSuccess fail");
        this.d.a(false);
        return;
      }
      this.d.a(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.2
 * JD-Core Version:    0.7.0.1
 */