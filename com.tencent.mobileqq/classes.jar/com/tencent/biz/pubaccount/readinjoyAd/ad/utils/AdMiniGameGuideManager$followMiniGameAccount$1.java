package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.mobileqq.kandian.repo.account.api.Ox978RespCallBack;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "distUin", "", "kotlin.jvm.PlatformType", "data", "", "handleResp"}, k=3, mv={1, 1, 16})
final class AdMiniGameGuideManager$followMiniGameAccount$1
  implements Ox978RespCallBack
{
  AdMiniGameGuideManager$followMiniGameAccount$1(String paramString) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    AdMiniGameGuideManager.a.c(this.a);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" followMiniGameAccount ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" __");
      localStringBuilder.append(paramString);
      QLog.e("AdMiniGameUtil", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager.followMiniGameAccount.1
 * JD-Core Version:    0.7.0.1
 */