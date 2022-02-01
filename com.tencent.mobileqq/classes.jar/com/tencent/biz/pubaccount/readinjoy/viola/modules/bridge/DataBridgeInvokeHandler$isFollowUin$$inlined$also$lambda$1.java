package com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge;

import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/DataBridgeInvokeHandler$isFollowUin$1$1"}, k=3, mv={1, 1, 16})
final class DataBridgeInvokeHandler$isFollowUin$$inlined$also$lambda$1
  implements Runnable
{
  DataBridgeInvokeHandler$isFollowUin$$inlined$also$lambda$1(String paramString1, DataBridgeInvokeHandler paramDataBridgeInvokeHandler, String paramString2) {}
  
  public final void run()
  {
    try
    {
      boolean bool = FollowListInfoModule.a(Long.parseLong(this.a), null);
      DataBridgeInvokeHandler.a(this.this$0, bool, this.b);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("DataBridgeInvokeHandler", 1, "[isFollowUin]: " + localException.getMessage());
      this.this$0.a(this.b, "error in isFollowUin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DataBridgeInvokeHandler.isFollowUin..inlined.also.lambda.1
 * JD-Core Version:    0.7.0.1
 */