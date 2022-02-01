package com.tencent.mobileqq.ark.dict;

import com.tencent.qphone.base.util.QLog;
import com.tencent.wordsegment.WordSegment;
import java.io.File;
import java.util.Locale;
import mqq.app.AppRuntime;

final class ArkAiDictMgr$4
  implements Runnable
{
  ArkAiDictMgr$4(AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    try
    {
      if (ArkAiDictMgr.a(this.a))
      {
        String str = ArkAiDictUpdateMgr.a();
        if (str == null)
        {
          QLog.i("ArkDict.DictMgr", 1, String.format(Locale.CHINA, "reloadWordData, local dict config not available", new Object[0]));
          return;
        }
        if ((ArkAiDictMgr.b() != null) && (ArkAiDictMgr.b().equals(str)))
        {
          QLog.i("ArkDict.DictMgr", 1, String.format(Locale.CHINA, "reloadWordData, dict already loaded, dict-id=%s", new Object[] { ArkAiDictMgr.b() }));
          return;
        }
        localObject = ArkAiDictMgr.a(str);
        if (!new File((String)localObject).exists())
        {
          QLog.i("ArkDict.DictMgr", 1, String.format(Locale.CHINA, "reloadWordData, local dict file not available, dict-id=%s", new Object[] { str }));
          return;
        }
        WordSegment.uninit();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append('/');
        int i = WordSegment.init(localStringBuilder.toString());
        if (i != 0)
        {
          QLog.i("ArkDict.DictMgr", 1, String.format(Locale.CHINA, String.format(Locale.CHINA, "reloadWordData failed, dict-id=%s, ret=%d", new Object[] { str, Integer.valueOf(i) }), new Object[0]));
          return;
        }
        QLog.i("ArkDict.DictMgr", 1, String.format(Locale.CHINA, String.format("reloadWordData success, dict-id=%s", new Object[] { str }), new Object[0]));
        ArkAiDictMgr.b(str);
        return;
      }
      QLog.i("ArkDict.DictMgr", 1, String.format("reloadWordData, dict flag is off", new Object[0]));
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reloadWordData, UnsatisfiedLinkError, err:");
      ((StringBuilder)localObject).append(localUnsatisfiedLinkError.getMessage());
      QLog.i("ArkDict.DictMgr", 1, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictMgr.4
 * JD-Core Version:    0.7.0.1
 */