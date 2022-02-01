package com.tencent.biz.pubaccount.readinjoy.reward;

import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.reward.aidl.RIJAidlClientRedPacketModule;
import com.tencent.biz.pubaccount.readinjoy.reward.utils.Utils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/reward/RIJRewardTaskArticleTimer$Companion;", "", "()V", "TAG", "", "isNowInKanDianTab", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class RIJRewardTaskArticleTimer$Companion
{
  @JvmStatic
  public final boolean a()
  {
    if (Utils.a()) {
      return RIJXTabFrameUtils.a.a();
    }
    return RIJAidlClientRedPacketModule.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.reward.RIJRewardTaskArticleTimer.Companion
 * JD-Core Version:    0.7.0.1
 */