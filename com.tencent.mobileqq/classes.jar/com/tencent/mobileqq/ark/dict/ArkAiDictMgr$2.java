package com.tencent.mobileqq.ark.dict;

import com.tencent.qphone.base.util.QLog;
import com.tencent.wordsegment.WordSegment.ILogCallback;

final class ArkAiDictMgr$2
  implements WordSegment.ILogCallback
{
  public void OnLog(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ArkDict.DictMgr.WordSegment.");
    localStringBuilder.append(paramString1);
    QLog.i(localStringBuilder.toString(), 1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictMgr.2
 * JD-Core Version:    0.7.0.1
 */