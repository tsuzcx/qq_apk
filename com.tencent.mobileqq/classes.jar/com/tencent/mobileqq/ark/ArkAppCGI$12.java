package com.tencent.mobileqq.ark;

import java.util.ArrayList;

class ArkAppCGI$12
  implements ArkAppCGI.ITaskHttpResult
{
  ArkAppCGI$12(ArkAppCGI paramArkAppCGI) {}
  
  public void a(ArkAppCGI.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramQueryTask.b.size())
    {
      ArkAppCGI.ArkAppCGICallback localArkAppCGICallback = (ArkAppCGI.ArkAppCGICallback)paramQueryTask.b.get(i);
      if (localArkAppCGICallback != null) {
        localArkAppCGICallback.b(paramBoolean, paramQueryTask.a, paramArrayOfByte);
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCGI.12
 * JD-Core Version:    0.7.0.1
 */