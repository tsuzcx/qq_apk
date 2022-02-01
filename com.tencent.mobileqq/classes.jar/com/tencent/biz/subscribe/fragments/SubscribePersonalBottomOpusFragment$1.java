package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StImage;
import android.view.View;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter.ItemClickListener;
import com.tencent.biz.subscribe.transition.TransitionAnimHelper;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedItemView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;

class SubscribePersonalBottomOpusFragment$1
  implements RelativeFeedsAdapter.ItemClickListener
{
  SubscribePersonalBottomOpusFragment$1(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment) {}
  
  public void a(View paramView, CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      if (paramStFeed.id.get().startsWith("fakeid_"))
      {
        QQToast.a(this.a.getBaseActivity(), HardCodeUtil.a(2131714443), 0).a();
        return;
      }
      if ((paramView instanceof RelativeFeedItemView))
      {
        paramView = (RelativeFeedItemView)paramView;
        if (paramView.a != null) {
          SubscribeLaucher.a(this.a.getBaseActivity(), paramStFeed, 0, TransitionAnimHelper.a(paramView.a, paramStFeed.cover.width.get(), paramStFeed.cover.height.get()));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment.1
 * JD-Core Version:    0.7.0.1
 */