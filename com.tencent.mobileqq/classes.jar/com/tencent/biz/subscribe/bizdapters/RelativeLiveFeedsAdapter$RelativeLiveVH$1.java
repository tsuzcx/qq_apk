package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.bean.FeedsItemInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;

class RelativeLiveFeedsAdapter$RelativeLiveVH$1
  implements View.OnClickListener
{
  RelativeLiveFeedsAdapter$RelativeLiveVH$1(RelativeLiveFeedsAdapter.RelativeLiveVH paramRelativeLiveVH, FeedsItemInfo paramFeedsItemInfo) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderBeanFeedsItemInfo.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$GetPortalRsp$RoomItem;
    String str = ((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject1).room_id.get();
    MobileReportManager localMobileReportManager;
    Object localObject2;
    long l;
    StringBuilder localStringBuilder;
    if (RelativeLiveFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.a) == 0)
    {
      RelativeLiveFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.a, 6);
      if (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderBeanFeedsItemInfo.jdField_a_of_type_Boolean)
      {
        localMobileReportManager = MobileReportManager.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject1).room_id.get());
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        l = System.currentTimeMillis();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject1).room_id.get());
        localStringBuilder.append("");
        localMobileReportManager.reportActionLive((String)localObject2, "25", "qq_live", "tab_page", "subscribe", 102, 1, l, localStringBuilder.toString());
      }
      else
      {
        localMobileReportManager = MobileReportManager.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject1).room_id.get());
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        l = System.currentTimeMillis();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject1).room_id.get());
        localStringBuilder.append("");
        localMobileReportManager.reportActionLive((String)localObject2, "25", "qq_live", "tab_page", "recommend_room", 102, 1, l, localStringBuilder.toString());
      }
    }
    else if (RelativeLiveFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.a) == 1)
    {
      RelativeLiveFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.a, 5);
      localMobileReportManager = MobileReportManager.getInstance();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      l = System.currentTimeMillis();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("");
      localMobileReportManager.reportActionLive((String)localObject2, "25", "qq_live", "find_page", "hot_push", 102, 1, l, localStringBuilder.toString());
    }
    ((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject1).portrait.get();
    localObject1 = ((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject1).pic_url.get();
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.a.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.itemView.getContext(), str, null, this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.a.a(), RelativeLiveFeedsAdapter.b(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.a), (String)localObject1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter.RelativeLiveVH.1
 * JD-Core Version:    0.7.0.1
 */