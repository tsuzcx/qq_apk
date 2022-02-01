package com.tencent.mobileqq.ark.dict;

import mqq.app.AppRuntime;

final class ArkAiDictMgr$3
  implements Runnable
{
  ArkAiDictMgr$3(AppRuntime paramAppRuntime, WordSegmentResult paramWordSegmentResult, String paramString) {}
  
  public void run()
  {
    ArkAiDictMgr.a(this.a);
    if (ArkAiDictMgr.b())
    {
      WordSegmentResult localWordSegmentResult = this.b;
      localWordSegmentResult.a = true;
      localWordSegmentResult.c = ArkAiDictMgr.a(this.c, 100);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictMgr.3
 * JD-Core Version:    0.7.0.1
 */