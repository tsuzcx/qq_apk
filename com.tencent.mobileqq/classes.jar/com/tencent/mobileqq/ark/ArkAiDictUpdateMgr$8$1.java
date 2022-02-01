package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.ThreadManager;

class ArkAiDictUpdateMgr$8$1
  extends ArkAppCGI.ArkAppCGICallback
{
  ArkAiDictUpdateMgr$8$1(ArkAiDictUpdateMgr.8 param8) {}
  
  public void a(boolean paramBoolean, long paramLong, byte[] paramArrayOfByte)
  {
    ThreadManager.post(new ArkAiDictUpdateMgr.8.1.1(this, paramArrayOfByte, paramBoolean), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8.1
 * JD-Core Version:    0.7.0.1
 */