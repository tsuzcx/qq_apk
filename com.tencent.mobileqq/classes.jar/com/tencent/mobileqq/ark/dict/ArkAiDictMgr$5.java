package com.tencent.mobileqq.ark.dict;

import com.tencent.mobileqq.ark.env.ArkAppEnvConfig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wordsegment.WordSegment;
import java.util.Locale;

class ArkAiDictMgr$5
  implements Runnable
{
  ArkAiDictMgr$5(ArkAiDictMgr paramArkAiDictMgr) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ArkAppEnvConfig.a().c());
    ((StringBuilder)localObject).append("/");
    localObject = ((StringBuilder)localObject).toString();
    WordSegment.uninit();
    int i = WordSegment.init((String)localObject);
    if (i == 0)
    {
      ArkAiDictMgr.b((String)localObject);
      return;
    }
    QLog.i("ArkDict.DictMgr", 1, String.format(Locale.CHINA, "initWordData failed, ret=%d", new Object[] { Integer.valueOf(i) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictMgr.5
 * JD-Core Version:    0.7.0.1
 */