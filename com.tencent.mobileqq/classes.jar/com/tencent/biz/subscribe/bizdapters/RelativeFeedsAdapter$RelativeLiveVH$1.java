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
import java.util.Iterator;
import java.util.List;

class RelativeFeedsAdapter$RelativeLiveVH$1
  implements View.OnClickListener
{
  RelativeFeedsAdapter$RelativeLiveVH$1(RelativeFeedsAdapter.RelativeLiveVH paramRelativeLiveVH, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live;
    String str2 = "";
    if ((localObject1 != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.roomId.has())) {
      localObject1 = String.valueOf(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.roomId.get());
    } else {
      localObject1 = "";
    }
    RelativeFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.a, (String)localObject1);
    String str1;
    if ((this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.rtmpURL != null) && (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.rtmpURL.has())) {
      str1 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.rtmpURL.get();
    } else {
      str1 = "";
    }
    Iterator localIterator = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StFeed.live.roomIcon.get().iterator();
    do
    {
      localObject2 = str2;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject2 = (CertifiedAccountMeta.StLive.RoomIcon)localIterator.next();
    } while (!"1:1".equals(((CertifiedAccountMeta.StLive.RoomIcon)localObject2).size.get()));
    Object localObject2 = ((CertifiedAccountMeta.StLive.RoomIcon)localObject2).url.get();
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.a.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.itemView.getContext(), (String)localObject1, str1, this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.a.a(), RelativeFeedsAdapter.b(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter$RelativeLiveVH.a), (String)localObject2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.RelativeLiveVH.1
 * JD-Core Version:    0.7.0.1
 */