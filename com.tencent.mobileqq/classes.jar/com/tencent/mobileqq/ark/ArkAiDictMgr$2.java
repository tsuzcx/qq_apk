package com.tencent.mobileqq.ark;

import com.tencent.wordsegment.WordSegment.ILogCallback;

final class ArkAiDictMgr$2
  implements WordSegment.ILogCallback
{
  public void OnLog(String paramString1, String paramString2)
  {
    ArkAppCenter.c("ArkApp.Dict.WordSegment." + paramString1, String.format("%s", new Object[] { paramString2 }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictMgr.2
 * JD-Core Version:    0.7.0.1
 */