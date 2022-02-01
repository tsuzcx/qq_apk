package com.tencent.biz.pubaccount.readinjoy.kandianreport;

import com.tencent.biz.pubaccount.readinjoy.featurecompute.JSContext;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;

class TaskManager$14$1
  implements INetEngine.INetEngineListener
{
  TaskManager$14$1(TaskManager.14 param14, String paramString, JSContext paramJSContext) {}
  
  public void onResp(NetResp paramNetResp)
  {
    TaskManager.access$800(this.this$1.this$0, paramNetResp, this.val$callbackMethod, this.val$jsContext, this.this$1.val$task);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.kandianreport.TaskManager.14.1
 * JD-Core Version:    0.7.0.1
 */