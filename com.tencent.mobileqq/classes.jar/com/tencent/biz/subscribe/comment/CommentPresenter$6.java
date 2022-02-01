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
    QLog.d(CommentPresenter.a(), 1, "onCommentSend()");
    if (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) == null)
    {
      QLog.d(CommentPresenter.a(), 1, "onCommentSend(): mCommentInputPopupWindow null");
      return;
    }
    Object localObject1 = CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a();
    if (TextUtils.isEmpty(((String)localObject1).trim()))
    {
      QQToast.a(CommentPresenter.m(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter), CommentPresenter.n(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).getString(2131692246), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(CommentPresenter.o(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter)))
    {
      QQToast.a(CommentPresenter.p(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter), 1, CommentPresenter.q(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).getString(2131694433), 0).a();
      return;
    }
    Object localObject2 = CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter);
    if (localObject2 == null)
    {
      QLog.e(CommentPresenter.a(), 1, "feed is null");
      return;
    }
    Object localObject3;
    Object localObject4;
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)
    {
      if (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) == null)
      {
        localObject3 = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter;
        CommentPresenter.a((CommentPresenter)localObject3, CommentPresenter.a((CommentPresenter)localObject3, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
      }
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).content.set((String)localObject1);
      localObject3 = new CertifiedAccountMeta.StReply();
      localObject4 = ((CertifiedAccountMeta.StReply)localObject3).id;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("fakeId_");
      localStringBuilder.append(System.currentTimeMillis());
      ((PBStringField)localObject4).set(localStringBuilder.toString());
      ((CertifiedAccountMeta.StReply)localObject3).content.set((String)localObject1);
      ((CertifiedAccountMeta.StReply)localObject3).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StReply)localObject3).postUser.set(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter));
      localObject1 = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply;
      if (localObject1 != null) {
        ((CertifiedAccountMeta.StReply)localObject3).targetUser = ((CertifiedAccountMeta.StUser)((CertifiedAccountMeta.StReply)localObject1).postUser.get());
      } else {
        ((CertifiedAccountMeta.StReply)localObject3).targetUser = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser;
      }
      if (localObject2 == null)
      {
        QLog.e(CommentPresenter.a(), 1, "feed is null");
        return;
      }
      if (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).targetUser != null) {
        CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).put(Long.valueOf(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter)), CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).targetUser);
      }
      localObject1 = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter;
      CommentPresenter.b((CommentPresenter)localObject1, CommentPresenter.a((CommentPresenter)localObject1).a(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, (CertifiedAccountMeta.StReply)localObject3));
      CommentPresenter.c(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, true);
      CommentPresenter.d(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, true);
      if (CommentPresenter.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) != null) {
        CommentPresenter.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).put(Long.valueOf(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter)), CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter));
      }
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, null);
      if (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) != null)
      {
        CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get(), (CertifiedAccountMeta.StReply)localObject3);
        CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).notifyDataSetChanged();
      }
    }
    else
    {
      if (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) == null)
      {
        localObject2 = this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter;
        CommentPresenter.a((CommentPresenter)localObject2, CommentPresenter.b((CommentPresenter)localObject2, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      }
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).content.set((String)localObject1);
      localObject2 = new CertifiedAccountMeta.StComment();
      localObject3 = ((CertifiedAccountMeta.StComment)localObject2).id;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("fakeId_");
      ((StringBuilder)localObject4).append(System.currentTimeMillis());
      ((PBStringField)localObject3).set(((StringBuilder)localObject4).toString());
      ((CertifiedAccountMeta.StComment)localObject2).content.set((String)localObject1);
      ((CertifiedAccountMeta.StComment)localObject2).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StComment)localObject2).postUser.set(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter));
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter), (CertifiedAccountMeta.StComment)localObject2);
      CommentPresenter.c(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, true);
      CommentPresenter.d(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, true);
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, null);
      if (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) != null)
      {
        CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a(0, (CertifiedAccountMeta.StComment)localObject2);
        CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter.a != null)
      {
        QLog.d(CommentPresenter.a(), 1, "mNeedShowCommentList1");
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter.a.setSelection(0);
      }
    }
    CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a("");
    CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).b(null);
    CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.6
 * JD-Core Version:    0.7.0.1
 */