package com.tencent.mobileqq.ark.dict;

import com.tencent.mobileqq.ark.core.ArkPredownloader.Task;
import com.tencent.mobileqq.ark.delegate.IHTTPDownloadCallback;

class ArkAiDictUpdateMgr$8$1
  implements IHTTPDownloadCallback
{
  ArkAiDictUpdateMgr$8$1(ArkAiDictUpdateMgr.8 param8) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    this.a.b.a(paramArrayOfByte);
    ArkPredownloader.Task localTask = this.a.c;
    String str = this.a.a;
    long l;
    if (paramArrayOfByte != null) {
      l = paramArrayOfByte.length;
    } else {
      l = -1L;
    }
    localTask.a(str, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.dict.ArkAiDictUpdateMgr.8.1
 * JD-Core Version:    0.7.0.1
 */