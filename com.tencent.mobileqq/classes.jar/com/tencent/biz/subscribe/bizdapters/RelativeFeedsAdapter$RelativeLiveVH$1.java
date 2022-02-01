package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLive.RoomIcon;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;

class RelativeFeedsAdapter$RelativeLiveVH$1
  implements View.OnClickListener
{
  RelativeFeedsAdapter$RelativeLiveVH$1(RelativeFeedsAdapter.RelativeLiveVH paramRelativeLiveVH, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.a;
    if (localObject1 == null)
    {
      QLog.e("RelativeFeedsAdapter", 1, "onClick feed is null");
    }
    else
    {
      localObject1 = ((CertifiedAccountMeta.StFeed)localObject1).live;
      String str2 = "";
      if ((localObject1 != null) && (this.a.live.roomId.has())) {
        localObject1 = String.valueOf(this.a.live.roomId.get());
      } else {
        localObject1 = "";
      }
      RelativeFeedsAdapter.a(this.b.r, (String)localObject1);
      String str1;
      if ((this.a.live != null) && (this.a.live.rtmpURL != null) && (this.a.live.rtmpURL.has())) {
        str1 = this.a.live.rtmpURL.get();
      } else {
        str1 = "";
      }
      Iterator localIterator = this.a.live.roomIcon.get().iterator();
      do
      {
        localObject2 = str2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (CertifiedAccountMeta.StLive.RoomIcon)localIterator.next();
      } while (!"1:1".equals(((CertifiedAccountMeta.StLive.RoomIcon)localObject2).size.get()));
      Object localObject2 = ((CertifiedAccountMeta.StLive.RoomIcon)localObject2).url.get();
      this.b.r.a(this.b.itemView.getContext(), (String)localObject1, str1, this.b.r.g(), RelativeFeedsAdapter.d(this.b.r), (String)localObject2, "0", "0", "0", "0");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.RelativeLiveVH.1
 * JD-Core Version:    0.7.0.1
 */