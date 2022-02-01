package com.tencent.mobileqq.ark;

import com.tencent.wordsegment.WordSegment;
import java.util.Locale;

class ArkAiDictMgr$5
  implements Runnable
{
  public void run()
  {
    String str = ArkAppEnvConfig.a().a() + "/";
    WordSegment.uninit();
    int i = WordSegment.init(str);
    if (i == 0)
    {
      ArkAiDictMgr.b(str);
      return;
    }
    ArkAppCenter.c("ArkApp.Dict", String.format(Locale.CHINA, "initWordData failed, ret=%d", new Object[] { Integer.valueOf(i) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictMgr.5
 * JD-Core Version:    0.7.0.1
 */