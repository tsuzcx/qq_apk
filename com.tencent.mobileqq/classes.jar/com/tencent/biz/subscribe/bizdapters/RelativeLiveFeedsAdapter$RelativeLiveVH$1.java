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
    Object localObject = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderBeanFeedsItemInfo.jdField_a_of_type_NS_CERTIFIED_ACCOUNT_READCertifiedAccountRead$GetPortalRsp$RoomItem;
    String str = ((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject).room_id.get();
    if (RelativeLiveFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.a) == 0) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderBeanFeedsItemInfo.jdField_a_of_type_Boolean) {
        MobileReportManager.getInstance().reportActionLive(((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject).room_id.get() + "", "25", "qq_live", "tab_page", "subscribe", 102, 1, System.currentTimeMillis(), ((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject).room_id.get() + "");
      }
    }
    for (;;)
    {
      ((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject).portrait.get();
      localObject = ((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject).pic_url.get();
      this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.a.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.itemView.getContext(), str, null, this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.a.a(), RelativeLiveFeedsAdapter.b(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.a), (String)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      MobileReportManager.getInstance().reportActionLive(((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject).room_id.get() + "", "25", "qq_live", "tab_page", "recommend_room", 102, 1, System.currentTimeMillis(), ((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject).room_id.get() + "");
      continue;
      if (RelativeLiveFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.a) == 1)
      {
        RelativeLiveFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeLiveFeedsAdapter$RelativeLiveVH.a, 5);
        MobileReportManager.getInstance().reportActionLive(str + "", "25", "qq_live", "find_page", "hot_push", 102, 1, System.currentTimeMillis(), str + "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter.RelativeLiveVH.1
 * JD-Core Version:    0.7.0.1
 */