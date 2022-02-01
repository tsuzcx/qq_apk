package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.comment.CommentPresenter.GetFeedResponseListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class SubscribeHybirdFragment$5
  implements CommentPresenter.GetFeedResponseListener
{
  SubscribeHybirdFragment$5(SubscribeHybirdFragment paramSubscribeHybirdFragment) {}
  
  public void a(int paramInt)
  {
    SubscribeHybirdFragment.a(this.a).a(paramInt);
  }
  
  public void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean, long paramLong, String paramString)
  {
    if ((paramStGetFeedDetailRsp == null) || (paramStGetFeedDetailRsp.feed.get() == null))
    {
      QQToast.a(this.a.getHostActivity(), HardCodeUtil.a(2131714518), 0).a();
      return;
    }
    SubscribeHybirdFragment.a(this.a, paramStGetFeedDetailRsp, paramLong, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribeHybirdFragment.5
 * JD-Core Version:    0.7.0.1
 */