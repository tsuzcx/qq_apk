package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFeedDetailRsp;
import com.tencent.biz.subscribe.comment.CommentBottomBar;
import com.tencent.biz.subscribe.comment.CommentPresenter.GetFeedResponseListener;
import com.tencent.biz.subscribe.widget.SubscribeShareHelper;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class DetailBaseBlock$2
  implements CommentPresenter.GetFeedResponseListener
{
  DetailBaseBlock$2(DetailBaseBlock paramDetailBaseBlock) {}
  
  public void a(int paramInt)
  {
    if (this.a.b != null) {
      this.a.b.a(paramInt);
    }
  }
  
  public void a(CertifiedAccountRead.StGetFeedDetailRsp paramStGetFeedDetailRsp, boolean paramBoolean, long paramLong, String paramString)
  {
    if (paramStGetFeedDetailRsp == null)
    {
      QLog.e(DetailBaseBlock.a, 1, "onFeedResponse rsp is null");
      return;
    }
    CertifiedAccountMeta.StFeed localStFeed = (CertifiedAccountMeta.StFeed)paramStGetFeedDetailRsp.feed.get();
    QLog.d(DetailBaseBlock.a, 1, "onFeedResponse hideLoadingView!");
    this.a.g();
    boolean bool = DetailBaseBlock.a(this.a, paramLong, localStFeed);
    String str = DetailBaseBlock.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isInterceptRspByFeedStatus ");
    localStringBuilder.append(bool);
    localStringBuilder.append(",status ");
    if (localStFeed == null) {
      localObject = "none";
    } else {
      localObject = Integer.valueOf(localStFeed.status.get());
    }
    localStringBuilder.append(localObject);
    QLog.i(str, 2, localStringBuilder.toString());
    if (bool)
    {
      this.a.a(paramLong, paramString);
      return;
    }
    this.a.b(localStFeed);
    DetailBaseBlock.a(this.a, paramStGetFeedDetailRsp.share);
    DetailBaseBlock.a(this.a, paramStGetFeedDetailRsp.detailUrl.get());
    DetailBaseBlock.b(this.a, paramStGetFeedDetailRsp.share);
    this.a.a(localStFeed);
    paramString = DetailBaseBlock.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isFinish:");
    ((StringBuilder)localObject).append(paramStGetFeedDetailRsp.isFinish.get());
    ((StringBuilder)localObject).append(" | recommend feeds size:");
    ((StringBuilder)localObject).append(paramStGetFeedDetailRsp.vecRcmdFeed.get().size());
    QLog.i(paramString, 1, ((StringBuilder)localObject).toString());
    this.a.a(paramStGetFeedDetailRsp, paramBoolean);
    if (!paramBoolean)
    {
      paramStGetFeedDetailRsp = this.a.c.poster.id.get();
      paramString = new StringBuilder();
      paramString.append("auth_");
      paramString.append(SubscribeShareHelper.a(this.a.K()));
      VSReporter.a(paramStGetFeedDetailRsp, paramString.toString(), "exp", 0, 0, new String[] { "", "", localStFeed.id.get(), localStFeed.title.get() });
    }
    this.a.d(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.DetailBaseBlock.2
 * JD-Core Version:    0.7.0.1
 */