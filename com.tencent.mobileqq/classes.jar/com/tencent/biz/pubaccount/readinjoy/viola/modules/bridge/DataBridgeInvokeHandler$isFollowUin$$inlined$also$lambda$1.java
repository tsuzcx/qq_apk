package com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge;

import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import ppo;
import ppq;
import tgs;
import tgu;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run", "com/tencent/biz/pubaccount/readinjoy/viola/modules/bridge/DataBridgeInvokeHandler$isFollowUin$1$1"}, k=3, mv={1, 1, 16})
public final class DataBridgeInvokeHandler$isFollowUin$$inlined$also$lambda$1
  implements Runnable
{
  public DataBridgeInvokeHandler$isFollowUin$$inlined$also$lambda$1(String paramString1, tgs paramtgs, String paramString2) {}
  
  public final void run()
  {
    try
    {
      ppo.a(Long.parseLong(this.a), (ppq)new tgu(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("DataBridgeInvokeHandler", 1, "[isFollowUin]: " + localException.getMessage());
      this.this$0.a(this.b, "error in isFollowUin");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.bridge.DataBridgeInvokeHandler.isFollowUin..inlined.also.lambda.1
 * JD-Core Version:    0.7.0.1
 */