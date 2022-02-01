package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.data.IFetchDataRspListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushVideoModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;

public class WSFetchPushDataModule
  implements IFetchDataModule
{
  private void a(WSRedDotPushMsg paramWSRedDotPushMsg, IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    if (paramWSRedDotPushMsg == null) {
      return;
    }
    Object localObject = paramWSRedDotPushMsg.mStrategyInfo;
    if (TextUtils.isEmpty(paramWSRedDotPushMsg.mFeedIds)) {
      return;
    }
    if ((localObject != null) && (((IWSPushBaseStrategy)localObject).getType() != 2))
    {
      localObject = (WSPushStrategyInfo)localObject;
      if (((WSPushStrategyInfo)localObject).mWSPushVideoModel == null) {
        return;
      }
      paramWSRedDotPushMsg = ((WSPushStrategyInfo)localObject).mWSPushVideoModel.a(paramWSRedDotPushMsg.mFeedIds);
      WeishiBusinessLooper.a().a(new WSFetchPushDataModule.1(this, paramIFetchDataRspListener, paramWSRedDotPushMsg));
    }
  }
  
  public void a(IFetchDataRspListener<WSVerticalItemData> paramIFetchDataRspListener)
  {
    a(WeishiUtils.a(), paramIFetchDataRspListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.module.WSFetchPushDataModule
 * JD-Core Version:    0.7.0.1
 */