package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.GetPortalRsp.RoomItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.bean.FeedsItemInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;

class RelativeLiveFeedsAdapter$RelativeLiveVH$1
  implements View.OnClickListener
{
  RelativeLiveFeedsAdapter$RelativeLiveVH$1(RelativeLiveFeedsAdapter.RelativeLiveVH paramRelativeLiveVH, FeedsItemInfo paramFeedsItemInfo) {}
  
  public void onClick(View paramView)
  {
    Object localObject3 = this.a.b;
    String str1 = ((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).room_id.get();
    Object localObject1;
    Object localObject2;
    long l;
    Object localObject4;
    if (RelativeLiveFeedsAdapter.b(this.b.q) == 0)
    {
      RelativeLiveFeedsAdapter.a(this.b.q, 6);
      if (this.a.c)
      {
        localObject1 = MobileReportManager.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).room_id.get());
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        l = System.currentTimeMillis();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).room_id.get());
        ((StringBuilder)localObject4).append("");
        ((MobileReportManager)localObject1).reportActionLive((String)localObject2, "25", "qq_live", "tab_page", "subscribe", 102, 1, l, ((StringBuilder)localObject4).toString());
      }
      else
      {
        localObject1 = MobileReportManager.getInstance();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).room_id.get());
        ((StringBuilder)localObject2).append("");
        localObject2 = ((StringBuilder)localObject2).toString();
        l = System.currentTimeMillis();
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append(((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).room_id.get());
        ((StringBuilder)localObject4).append("");
        ((MobileReportManager)localObject1).reportActionLive((String)localObject2, "25", "qq_live", "tab_page", "recommend_room", 102, 1, l, ((StringBuilder)localObject4).toString());
      }
    }
    else if (RelativeLiveFeedsAdapter.b(this.b.q) == 1)
    {
      RelativeLiveFeedsAdapter.a(this.b.q, 5);
      localObject1 = MobileReportManager.getInstance();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append("");
      localObject2 = ((StringBuilder)localObject2).toString();
      l = System.currentTimeMillis();
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(str1);
      ((StringBuilder)localObject4).append("");
      ((MobileReportManager)localObject1).reportActionLive((String)localObject2, "25", "qq_live", "find_page", "hot_push", 102, 1, l, ((StringBuilder)localObject4).toString());
    }
    ((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).portrait.get();
    String str2 = ((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).pic_url.get();
    Object localObject5;
    if (((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).has())
    {
      if (((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).room_type.has()) {
        localObject1 = String.valueOf(((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).room_type.get());
      } else {
        localObject1 = "0";
      }
      if (((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).game_id.has()) {
        localObject2 = String.valueOf(((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).game_id.get());
      } else {
        localObject2 = "0";
      }
      if (((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).game_tag_id.has()) {
        localObject4 = String.valueOf(((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).game_tag_id);
      } else {
        localObject4 = "0";
      }
      if (((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).video_source.has()) {
        localObject3 = String.valueOf(((CertifiedAccountRead.GetPortalRsp.RoomItem)localObject3).video_source);
      } else {
        localObject3 = "0";
      }
    }
    else
    {
      localObject5 = "0";
      localObject1 = localObject5;
      localObject2 = localObject1;
      localObject3 = localObject2;
      localObject4 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject5;
    }
    if (QLog.isColorLevel())
    {
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append("setClickListener roomType:");
      ((StringBuilder)localObject5).append((String)localObject1);
      ((StringBuilder)localObject5).append(", gameId:");
      ((StringBuilder)localObject5).append((String)localObject2);
      ((StringBuilder)localObject5).append(", gameTagId:");
      ((StringBuilder)localObject5).append((String)localObject4);
      ((StringBuilder)localObject5).append(", videoSource:");
      ((StringBuilder)localObject5).append((String)localObject3);
      QLog.d("RelativeFeedsAdapter", 2, ((StringBuilder)localObject5).toString());
    }
    this.b.q.a(this.b.itemView.getContext(), str1, null, this.b.q.d(), RelativeLiveFeedsAdapter.c(this.b.q), str2, (String)localObject1, (String)localObject2, (String)localObject4, (String)localObject3);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeLiveFeedsAdapter.RelativeLiveVH.1
 * JD-Core Version:    0.7.0.1
 */