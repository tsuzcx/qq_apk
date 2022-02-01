package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.text.TextUtils;
import android.widget.ListView;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class CommentPresenter$6
  implements SubscribeCommentInputPopupWindow.EventListener
{
  CommentPresenter$6(CommentPresenter paramCommentPresenter, CertifiedAccountMeta.StComment paramStComment, CertifiedAccountMeta.StReply paramStReply) {}
  
  public void a()
  {
    QLog.d(CommentPresenter.t(), 1, "onCommentSend()");
    if (CommentPresenter.B(this.c) == null)
    {
      QLog.d(CommentPresenter.t(), 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    Object localObject1 = CommentPresenter.B(this.c).d();
    if (TextUtils.isEmpty(((String)localObject1).trim()))
    {
      QQToast.makeText(CommentPresenter.C(this.c), CommentPresenter.D(this.c).getString(2131889233), 0).show();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(CommentPresenter.E(this.c)))
    {
      QQToast.makeText(CommentPresenter.F(this.c), 1, CommentPresenter.G(this.c).getString(2131892113), 0).show();
      return;
    }
    Object localObject2 = CommentPresenter.k(this.c);
    if (localObject2 == null)
    {
      QLog.e(CommentPresenter.t(), 1, "feed is null");
      return;
    }
    Object localObject3;
    Object localObject4;
    if (this.a != null)
    {
      if (CommentPresenter.H(this.c) == null)
      {
        localObject3 = this.c;
        CommentPresenter.a((CommentPresenter)localObject3, CommentPresenter.b((CommentPresenter)localObject3, this.a, this.b));
      }
      CommentPresenter.H(this.c).content.set((String)localObject1);
      localObject3 = new CertifiedAccountMeta.StReply();
      localObject4 = ((CertifiedAccountMeta.StReply)localObject3).id;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fakeId_");
      localStringBuilder.append(System.currentTimeMillis());
      ((PBStringField)localObject4).set(localStringBuilder.toString());
      ((CertifiedAccountMeta.StReply)localObject3).content.set((String)localObject1);
      ((CertifiedAccountMeta.StReply)localObject3).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StReply)localObject3).postUser.set(CommentPresenter.I(this.c));
      localObject1 = this.b;
      if (localObject1 != null) {
        ((CertifiedAccountMeta.StReply)localObject3).targetUser = ((CertifiedAccountMeta.StUser)((CertifiedAccountMeta.StReply)localObject1).postUser.get());
      } else {
        ((CertifiedAccountMeta.StReply)localObject3).targetUser = this.a.postUser;
      }
      if (localObject2 == null)
      {
        QLog.e(CommentPresenter.t(), 1, "feed is null");
        return;
      }
      if (CommentPresenter.H(this.c).targetUser != null) {
        CommentPresenter.K(this.c).put(Long.valueOf(CommentPresenter.J(this.c)), CommentPresenter.H(this.c).targetUser);
      }
      localObject1 = this.c;
      CommentPresenter.b((CommentPresenter)localObject1, CommentPresenter.i((CommentPresenter)localObject1).a(CommentPresenter.k(this.c), this.a, (CertifiedAccountMeta.StReply)localObject3));
      CommentPresenter.c(this.c, true);
      CommentPresenter.d(this.c, true);
      if (CommentPresenter.L(this.c) != null) {
        CommentPresenter.L(this.c).put(Long.valueOf(CommentPresenter.J(this.c)), CommentPresenter.H(this.c));
      }
      CommentPresenter.a(this.c, null);
      if (CommentPresenter.a(this.c) != null)
      {
        CommentPresenter.a(this.c).a(this.a.id.get(), (CertifiedAccountMeta.StReply)localObject3);
        CommentPresenter.a(this.c).notifyDataSetChanged();
      }
    }
    else
    {
      if (CommentPresenter.M(this.c) == null)
      {
        localObject2 = this.c;
        CommentPresenter.a((CommentPresenter)localObject2, CommentPresenter.b((CommentPresenter)localObject2, this.a));
      }
      CommentPresenter.M(this.c).content.set((String)localObject1);
      localObject2 = new CertifiedAccountMeta.StComment();
      localObject3 = ((CertifiedAccountMeta.StComment)localObject2).id;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("fakeId_");
      ((StringBuilder)localObject4).append(System.currentTimeMillis());
      ((PBStringField)localObject3).set(((StringBuilder)localObject4).toString());
      ((CertifiedAccountMeta.StComment)localObject2).content.set((String)localObject1);
      ((CertifiedAccountMeta.StComment)localObject2).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StComment)localObject2).postUser.set(CommentPresenter.I(this.c));
      CommentPresenter.i(this.c).a(CommentPresenter.k(this.c), (CertifiedAccountMeta.StComment)localObject2);
      CommentPresenter.c(this.c, true);
      CommentPresenter.d(this.c, true);
      CommentPresenter.a(this.c, null);
      if (CommentPresenter.a(this.c) != null)
      {
        CommentPresenter.a(this.c).a(0, (CertifiedAccountMeta.StComment)localObject2);
        CommentPresenter.a(this.c).notifyDataSetChanged();
      }
      if (this.c.g != null)
      {
        QLog.d(CommentPresenter.t(), 1, "mNeedShowCommentList1");
        this.c.g.setSelection(0);
      }
    }
    CommentPresenter.B(this.c).a("");
    CommentPresenter.B(this.c).b(null);
    CommentPresenter.B(this.c).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.6
 * JD-Core Version:    0.7.0.1
 */