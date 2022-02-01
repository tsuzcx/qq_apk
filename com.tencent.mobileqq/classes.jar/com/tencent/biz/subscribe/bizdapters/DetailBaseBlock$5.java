package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.utils.TimeAndCountHelper;
import com.tencent.biz.subscribe.utils.TimeAndCountHelper.CountResult;
import com.tencent.qphone.base.util.QLog;

class DetailBaseBlock$5
  implements TimeAndCountHelper.CountResult
{
  DetailBaseBlock$5(DetailBaseBlock paramDetailBaseBlock, CertifiedAccountMeta.StFeed paramStFeed) {}
  
  public void a(int paramInt)
  {
    String str = DetailBaseBlock.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("count:");
    localStringBuilder.append(paramInt);
    QLog.d(str, 2, localStringBuilder.toString());
    if ((DetailBaseBlock.q(this.b) != null) && (paramInt == 1)) {
      if (TimeAndCountHelper.a().a(DetailBaseBlock.r(this.b), "subscribe_sp_key_show_praise_guide") == 0)
      {
        if ((this.b.b != null) && (!this.b.b.c())) {
          this.b.m();
        }
      }
      else if ((TimeAndCountHelper.a().a(DetailBaseBlock.s(this.b), "subscribe_sp_key_show_follow_guide") == 0) && (!SubscribeUtils.a(this.a))) {
        this.b.l();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.5
 * JD-Core Version:    0.7.0.1
 */