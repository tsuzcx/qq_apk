package com.tencent.mobileqq.ark.core;

import java.util.ArrayList;

class ArkAppCGI$2
  implements Runnable
{
  ArkAppCGI$2(ArkAppCGI paramArkAppCGI, ArkAppCGI.QueryTask paramQueryTask, boolean paramBoolean, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    synchronized (ArkAppCGI.a(this.this$0))
    {
      ArkAppCGI.a(this.this$0).remove(this.a);
      this.a.f.a(this.a, this.b, this.c);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkAppCGI.2
 * JD-Core Version:    0.7.0.1
 */