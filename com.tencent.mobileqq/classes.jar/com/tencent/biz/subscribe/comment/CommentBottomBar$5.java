package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StLike;
import NS_CERTIFIED_ACCOUNT_WRITE.CertifiedAccountWrite.StDoLikeRsp;
import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.event.PraisedUpdateEvents;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.widget.QQToast;

class CommentBottomBar$5
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountWrite.StDoLikeRsp>
{
  CommentBottomBar$5(CommentBottomBar paramCommentBottomBar) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountWrite.StDoLikeRsp paramStDoLikeRsp)
  {
    CommentBottomBar.a(this.a, true);
    int j = 0;
    if ((paramBoolean) && (paramLong == 0L) && (paramStDoLikeRsp != null))
    {
      if (paramStDoLikeRsp.like.status.get() == 1) {
        i = CommentBottomBar.a(this.a).likeInfo.count.get() + 1;
      } else {
        i = CommentBottomBar.a(this.a).likeInfo.count.get() - 1;
      }
      if (CommentBottomBar.a(this.a) != null)
      {
        CommentBottomBar.a(this.a).likeInfo.status.set(paramStDoLikeRsp.like.status.get());
        CommentBottomBar.a(this.a).likeInfo.count.set(i);
      }
      SimpleEventBus.getInstance().dispatchEvent(new PraisedUpdateEvents(CommentBottomBar.a(this.a).id.get(), paramStDoLikeRsp.like.status.get(), i));
      int i = j;
      if (BaseApplicationImpl.sProcessId == 1) {
        i = 1;
      }
      if (i == 0)
      {
        paramBaseRequest = new Bundle();
        paramBaseRequest.putString("feed_id", CommentBottomBar.a(this.a).id.get());
        paramBaseRequest.putInt("feed_like_status", paramStDoLikeRsp.like.status.get());
        paramBaseRequest.putInt("feed_like_num", paramStDoLikeRsp.like.count.get());
        QIPCClientHelper.getInstance().callServer(SimpleEventBus.IPC_SERVICE_MODULE_NAME, SimpleEventBus.ACTION_PRAISED_UPDATE, paramBaseRequest, null);
      }
      return;
    }
    QQToast.a(this.a.getContext(), 1, paramString, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentBottomBar.5
 * JD-Core Version:    0.7.0.1
 */