package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.comment.CommentPresenter.GetFeedResponseListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class SubscribeHybirdFragment$6
  implements CommentPresenter.GetFeedResponseListener
{
  SubscribeHybirdFragment$6(SubscribeHybirdFragment paramSubscribeHybirdFragment) {}
  
  public void a(int paramInt)
  {
    SubscribeHybirdFragment.a(this.a).a(paramInt);
  }
  
  public void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean, long paramLong, String paramString)
  {
    if ((paramStGetFeedDetailRsp != null) && (paramStGetFeedDetailRsp.feed.get() != null))
    {
      SubscribeHybirdFragment.a(this.a, paramStGetFeedDetailRsp, paramLong, paramString);
      return;
    }
    QQToast.a(this.a.getHostActivity(), HardCodeUtil.a(2131714439), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment.6
 * JD-Core Version:    0.7.0.1
 */