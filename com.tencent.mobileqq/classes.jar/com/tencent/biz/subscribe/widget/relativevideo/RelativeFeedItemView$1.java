package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.network.DoLikeRequest;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class RelativeFeedItemView$1
  implements View.OnClickListener
{
  RelativeFeedItemView$1(RelativeFeedItemView paramRelativeFeedItemView, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void onClick(View paramView)
  {
    if ((RelativeFeedItemView.a(this.b)) && (this.b.getData() != null) && (SubscribeUtils.a(((CertifiedAccountMeta.StFeed)this.b.getData()).status.get()))) {
      if (!RelativeFeedItemView.b(this.b))
      {
        QQToast.makeText(this.b.getContext(), HardCodeUtil.a(2131910844), 0).show();
      }
      else
      {
        RelativeFeedItemView.a(this.b, false);
        DoLikeRequest localDoLikeRequest = new DoLikeRequest(this.a);
        VSNetworkHelper.getInstance().sendRequest(localDoLikeRequest, new RelativeFeedItemView.1.1(this));
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView.1
 * JD-Core Version:    0.7.0.1
 */