package com.tencent.mobileqq.ark;

import alrj;
import altf;
import com.tencent.wordsegment.WordSegment;
import java.util.Locale;

public class ArkAiDictMgr$5
  implements Runnable
{
  public void run()
  {
    String str = altf.a().a() + "/";
    WordSegment.uninit();
    int i = WordSegment.init(str);
    if (i == 0)
    {
      alrj.b(str);
      return;
    }
    ArkAppCenter.c("ArkApp.Dict", String.format(Locale.CHINA, "initWordData failed, ret=%d", new Object[] { Integer.valueOf(i) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictMgr.5
 * JD-Core Version:    0.7.0.1
 */