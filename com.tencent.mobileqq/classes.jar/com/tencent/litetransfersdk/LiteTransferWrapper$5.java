package com.tencent.litetransfersdk;

import java.util.ArrayList;

class LiteTransferWrapper$5
  implements Runnable
{
  LiteTransferWrapper$5(LiteTransferWrapper paramLiteTransferWrapper, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if (LiteTransferWrapper.access$200(this.this$0) != 0L)
    {
      this.this$0.SetProxyToJni();
      LiteTransferWrapper localLiteTransferWrapper = this.this$0;
      long l = LiteTransferWrapper.access$200(localLiteTransferWrapper);
      ArrayList localArrayList = this.a;
      localLiteTransferWrapper.SendGroupToJNI(l, (Session[])localArrayList.toArray(new Session[localArrayList.size()]), this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.litetransfersdk.LiteTransferWrapper.5
 * JD-Core Version:    0.7.0.1
 */