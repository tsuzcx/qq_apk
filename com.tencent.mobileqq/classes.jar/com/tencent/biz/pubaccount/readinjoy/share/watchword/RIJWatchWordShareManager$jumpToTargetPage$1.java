package com.tencent.biz.pubaccount.readinjoy.share.watchword;

import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordModel.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.share.watchword.mvp.RIJReadWatchWordModel.VideoInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "clickType", "", "invoke"}, k=3, mv={1, 1, 16})
final class RIJWatchWordShareManager$jumpToTargetPage$1
  extends Lambda
  implements Function1<Integer, Unit>
{
  RIJWatchWordShareManager$jumpToTargetPage$1(RIJWatchWordShareManager paramRIJWatchWordShareManager, String paramString, RIJReadWatchWordModel.VideoInfo paramVideoInfo, RIJReadWatchWordModel.UserInfo paramUserInfo)
  {
    super(1);
  }
  
  public final void invoke(int paramInt)
  {
    if (paramInt == 1) {
      RIJWatchWordShareManager.a(this.this$0, this.$jumpUrl);
    }
    RIJWatchWordShareManager localRIJWatchWordShareManager = this.this$0;
    String str = this.$videoInfo.c();
    RIJReadWatchWordModel.UserInfo localUserInfo = this.$userInfo;
    if (localUserInfo != null) {}
    for (long l = localUserInfo.a();; l = 0L)
    {
      RIJWatchWordShareManager.a(localRIJWatchWordShareManager, 0, str, "", l, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.share.watchword.RIJWatchWordShareManager.jumpToTargetPage.1
 * JD-Core Version:    0.7.0.1
 */