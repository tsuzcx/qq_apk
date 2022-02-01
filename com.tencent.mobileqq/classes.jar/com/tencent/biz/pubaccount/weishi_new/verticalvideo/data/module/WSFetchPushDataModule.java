package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushVideoModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.IVerticalRspListener;

public class WSFetchPushDataModule
  implements IFetchDataModule
{
  private void a(WSRedDotPushMsg paramWSRedDotPushMsg, IVerticalRspListener paramIVerticalRspListener)
  {
    if (paramWSRedDotPushMsg == null) {}
    IWSPushBaseStrategy localIWSPushBaseStrategy;
    do
    {
      return;
      localIWSPushBaseStrategy = paramWSRedDotPushMsg.mStrategyInfo;
    } while ((TextUtils.isEmpty(paramWSRedDotPushMsg.mFeedIds)) || (localIWSPushBaseStrategy == null) || (localIWSPushBaseStrategy.getType() == 2) || (((WSPushStrategyInfo)localIWSPushBaseStrategy).mWSPushVideoModel == null));
    paramWSRedDotPushMsg = ((WSPushStrategyInfo)localIWSPushBaseStrategy).mWSPushVideoModel.a(paramWSRedDotPushMsg.mFeedIds);
    WeishiBusinessLooper.a().a(new WSFetchPushDataModule.1(this, paramIVerticalRspListener, paramWSRedDotPushMsg));
  }
  
  public void a(IVerticalRspListener paramIVerticalRspListener)
  {
    a(WeishiUtils.a(), paramIVerticalRspListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.WSFetchPushDataModule
 * JD-Core Version:    0.7.0.1
 */