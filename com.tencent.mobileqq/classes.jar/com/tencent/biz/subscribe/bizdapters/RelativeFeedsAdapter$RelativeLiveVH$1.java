package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive.RoomIcon;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.Iterator;
import java.util.List;

class RelativeFeedsAdapter$RelativeLiveVH$1
  implements View.OnClickListener
{
  RelativeFeedsAdapter$RelativeLiveVH$1(RelativeFeedsAdapter.RelativeLiveVH paramRelativeLiveVH, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.roomId.has())) {}
    for (String str1 = String.valueOf(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.roomId.get());; str1 = "")
    {
      if (RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.a) == 0)
      {
        RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.a, 6);
        MobileReportManager.getInstance().reportActionLive(str1 + "", "25", "qq_live", "tab_page", "subscribe", 102, 1, System.currentTimeMillis(), str1 + "");
      }
      for (;;)
      {
        Object localObject2 = "";
        Object localObject1 = localObject2;
        if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live != null)
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.rtmpURL != null)
          {
            localObject1 = localObject2;
            if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.rtmpURL.has()) {
              localObject1 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.rtmpURL.get();
            }
          }
        }
        String str2 = "";
        Iterator localIterator = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.roomIcon.get().iterator();
        do
        {
          localObject2 = str2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (CertifiedAccountMeta.StLive.RoomIcon)localIterator.next();
        } while (!"1:1".equals(((CertifiedAccountMeta.StLive.RoomIcon)localObject2).size.get()));
        localObject2 = ((CertifiedAccountMeta.StLive.RoomIcon)localObject2).url.get();
        this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.a.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.itemView.getContext(), str1, (String)localObject1, this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.a.a(), RelativeFeedsAdapter.b(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.a), (String)localObject2);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.a) == 1)
        {
          RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.a, 5);
          MobileReportManager.getInstance().reportActionLive(str1 + "", "25", "qq_live", "find_page", "hot_push", 102, 1, System.currentTimeMillis(), str1 + "");
        }
        else if (RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.a) == 2)
        {
          RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.a, 2);
          MobileReportManager.getInstance().reportActionLive(str1 + "", "25", "qq_live", "shopcart_page", "hot_push", 102, 1, System.currentTimeMillis(), str1 + "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.RelativeLiveVH.1
 * JD-Core Version:    0.7.0.1
 */