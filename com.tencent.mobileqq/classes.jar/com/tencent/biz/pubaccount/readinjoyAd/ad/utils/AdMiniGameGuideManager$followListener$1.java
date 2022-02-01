package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.mobileqq.kandian.repo.follow.FollowingMember;
import com.tencent.mobileqq.kandian.repo.follow.IFollowStatusObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "uinsFollowStatus", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/mobileqq/kandian/repo/follow/FollowingMember;", "", "requestFollowStatusBack"}, k=3, mv={1, 1, 16})
final class AdMiniGameGuideManager$followListener$1
  implements IFollowStatusObserver
{
  public static final 1 a = new 1();
  
  public final void a(int paramInt, Map<Long, FollowingMember> paramMap)
  {
    Object localObject3 = null;
    if (paramMap != null) {}
    for (;;)
    {
      try
      {
        localObject1 = (FollowingMember)paramMap.get(Long.valueOf(1001008899179L));
        if (localObject1 == null) {
          break label205;
        }
        localObject1 = Boolean.valueOf(((FollowingMember)localObject1).a());
        if (localObject1 == null) {
          continue;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Followed change:");
        FollowingMember localFollowingMember = (FollowingMember)paramMap.get(Long.valueOf(1001008899179L));
        localObject1 = localObject3;
        if (localFollowingMember != null) {
          localObject1 = Boolean.valueOf(localFollowingMember.a());
        }
        localStringBuilder.append(localObject1);
        QLog.e("AdMiniGameUtil", 2, localStringBuilder.toString());
        localObject1 = AdMiniGameGuideManager.a;
        paramMap = (FollowingMember)paramMap.get(Long.valueOf(1001008899179L));
        bool = true;
        if ((paramMap == null) || (paramMap.a() != true)) {
          break label211;
        }
        ((AdMiniGameGuideManager)localObject1).a(bool);
        return;
      }
      catch (Exception localException)
      {
        Object localObject1;
        continue;
      }
      paramMap = new StringBuilder();
      paramMap.append("checkFollowed error ");
      paramMap.append(((Exception)localObject1).getMessage());
      QLog.e("AdMiniGameUtil", 2, paramMap.toString());
      return;
      label205:
      Object localObject2 = null;
      continue;
      label211:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager.followListener.1
 * JD-Core Version:    0.7.0.1
 */