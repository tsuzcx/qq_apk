package com.tencent.biz.pubaccount.weishi_new.push.biz;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi_new.WSAutoShowCommentParams;
import com.tencent.biz.pubaccount.weishi_new.WSHomeLaunchParams;
import com.tencent.biz.pubaccount.weishi_new.WSOpenHomeThenVideoParams;
import com.tencent.biz.pubaccount.weishi_new.main.WSLauncher.HomeLauncher;
import com.tencent.biz.pubaccount.weishi_new.push.WSBasePushMsg;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushCommentModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/weishi_new/push/biz/WSOpenHomeThenVerticalBiz;", "Lcom/tencent/biz/pubaccount/weishi_new/push/biz/WSBasePushBiz;", "Lcom/tencent/biz/pubaccount/weishi_new/push/WSRedDotPushMsg;", "Lcom/tencent/biz/pubaccount/weishi_new/push/WSPushStrategyInfo;", "pushInfo", "(Lcom/tencent/biz/pubaccount/weishi_new/push/WSRedDotPushMsg;)V", "handlePushMsgClick", "", "context", "Landroid/content/Context;", "strategyInfo", "qqweishi_impl_release"}, k=1, mv={1, 1, 16})
public final class WSOpenHomeThenVerticalBiz
  extends WSBasePushBiz<WSRedDotPushMsg, WSPushStrategyInfo>
{
  public WSOpenHomeThenVerticalBiz(@NotNull WSRedDotPushMsg paramWSRedDotPushMsg)
  {
    super((WSBasePushMsg)paramWSRedDotPushMsg);
  }
  
  public boolean a(@NotNull Context paramContext, @NotNull WSPushStrategyInfo paramWSPushStrategyInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Intrinsics.checkParameterIsNotNull(paramWSPushStrategyInfo, "strategyInfo");
    String str = ((WSRedDotPushMsg)this.a).mFeedIds;
    boolean bool = false;
    if (str != null)
    {
      Object localObject = paramWSPushStrategyInfo.mWSPushCommentModel;
      if (localObject != null) {
        bool = ((WSPushCommentModel)localObject).a();
      }
      if (localObject != null)
      {
        paramWSPushStrategyInfo = ((WSPushCommentModel)localObject).b();
        if (paramWSPushStrategyInfo != null) {}
      }
      else
      {
        paramWSPushStrategyInfo = "";
      }
      if (localObject != null)
      {
        localObject = ((WSPushCommentModel)localObject).c();
        if (localObject != null) {}
      }
      else
      {
        localObject = "";
      }
      paramWSPushStrategyInfo = new WSOpenHomeThenVideoParams(str, "", new WSAutoShowCommentParams(bool, paramWSPushStrategyInfo, (String)localObject), "aio_pre_open_home");
      WSLauncher.HomeLauncher.a(new WSHomeLaunchParams(paramContext, 1, "from_open_home_then_video").a(paramWSPushStrategyInfo).a(str));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.push.biz.WSOpenHomeThenVerticalBiz
 * JD-Core Version:    0.7.0.1
 */