package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.biz.pubaccount.readinjoy.model.FollowListInfoModule.FollowStatusObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.FollowingMember;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", "", "uinsFollowStatus", "", "", "kotlin.jvm.PlatformType", "Lcom/tencent/biz/pubaccount/readinjoy/struct/FollowingMember;", "", "requestFollowStatusBack"}, k=3, mv={1, 1, 16})
final class AdMiniGameGuideManager$followListener$1
  implements FollowListInfoModule.FollowStatusObserver
{
  public static final 1 a = new 1();
  
  public final void a(int paramInt, Map<Long, FollowingMember> paramMap)
  {
    if (paramMap != null) {}
    try
    {
      Object localObject = (FollowingMember)paramMap.get(Long.valueOf(1001008899179L));
      if (localObject != null)
      {
        localObject = Boolean.valueOf(((FollowingMember)localObject).a());
        if (localObject != null)
        {
          StringBuilder localStringBuilder = new StringBuilder().append("Followed change:");
          localObject = (FollowingMember)paramMap.get(Long.valueOf(1001008899179L));
          if (localObject == null) {
            break label151;
          }
          localObject = Boolean.valueOf(((FollowingMember)localObject).a());
          label87:
          QLog.e("AdMiniGameUtil", 2, localObject);
          localObject = AdMiniGameGuideManager.a;
          paramMap = (FollowingMember)paramMap.get(Long.valueOf(1001008899179L));
          if ((paramMap == null) || (paramMap.a() != true)) {
            break label157;
          }
        }
      }
      label151:
      label157:
      for (boolean bool = true;; bool = false)
      {
        ((AdMiniGameGuideManager)localObject).a(bool);
        return;
        localObject = null;
        break;
        localObject = null;
        break label87;
      }
      return;
    }
    catch (Exception paramMap)
    {
      QLog.e("AdMiniGameUtil", 2, "checkFollowed error " + paramMap.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdMiniGameGuideManager.followListener.1
 * JD-Core Version:    0.7.0.1
 */