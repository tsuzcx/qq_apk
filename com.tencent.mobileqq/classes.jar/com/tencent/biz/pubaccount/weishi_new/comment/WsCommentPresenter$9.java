package com.tencent.biz.pubaccount.weishi_new.comment;

import UserGrowth.stSimpleMetaComment;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaReply;
import android.view.View;
import android.widget.ListView;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;

class WsCommentPresenter$9
  implements WsCommentInputPopupWindow.OnDismissListener
{
  WsCommentPresenter$9(WsCommentPresenter paramWsCommentPresenter, stSimpleMetaComment paramstSimpleMetaComment, stSimpleMetaReply paramstSimpleMetaReply, boolean paramBoolean) {}
  
  public void a()
  {
    WsCommentPresenter.e(this.d).setVisibility(0);
    Object localObject = WSCommentRestoreManager.a().a(this.d.n(), this.a, this.b);
    WsCommentPresenter.g(this.d).b((String)localObject);
    if (this.a != null)
    {
      if (WsCommentPresenter.h(this.d) == null) {
        return;
      }
      int k = WsCommentPresenter.h(this.d).indexOf(this.a);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("index:");
      ((StringBuilder)localObject).append(k);
      WSLog.a("commentnel-log", ((StringBuilder)localObject).toString());
      if (this.b == null)
      {
        WsCommentPresenter.a(this.d).setSelectionFromTop(k, 0);
        return;
      }
      int j = WSCommentRestoreManager.a().b(this.d.n(), this.a, this.b);
      int i = j;
      if (j == 0) {
        i = WsCommentPresenter.a(this.d, this.a, this.b);
      }
      WsCommentPresenter.a(this.d).setSelectionFromTop(k, -i);
    }
  }
  
  public void a(String paramString)
  {
    WsCommentPresenter.e(this.d).setVisibility(8);
    WsCommentPresenter.d(this.d, paramString);
    WSCommentRestoreManager localWSCommentRestoreManager = WSCommentRestoreManager.a();
    stSimpleMetaFeed localstSimpleMetaFeed = this.d.n();
    stSimpleMetaComment localstSimpleMetaComment = this.a;
    stSimpleMetaReply localstSimpleMetaReply = this.b;
    localWSCommentRestoreManager.a(localstSimpleMetaFeed, localstSimpleMetaComment, localstSimpleMetaReply, paramString, WsCommentPresenter.a(this.d, localstSimpleMetaComment, localstSimpleMetaReply));
    if (this.c) {
      WsCommentPresenter.f(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.9
 * JD-Core Version:    0.7.0.1
 */