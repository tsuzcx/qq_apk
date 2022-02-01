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
    String str = CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a();
    if (TextUtils.isEmpty(str.trim()))
    {
      QQToast.a(CommentPresenter.m(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter), CommentPresenter.n(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).getString(2131692317), 0).a();
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(CommentPresenter.o(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter)))
    {
      QQToast.a(CommentPresenter.p(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter), 1, CommentPresenter.q(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).getString(2131694468), 0).a();
      return;
    }
    Object localObject = CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter);
    if (localObject == null)
    {
      QLog.e(CommentPresenter.a(), 1, "feed is null");
      return;
    }
    if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment != null)
    {
      if (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) == null) {
        CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply));
      }
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).content.set(str);
      CertifiedAccountMeta.StReply localStReply = new CertifiedAccountMeta.StReply();
      localStReply.id.set("fakeId_" + System.currentTimeMillis());
      localStReply.content.set(str);
      localStReply.createTime.set((int)(System.currentTimeMillis() / 1000L));
      localStReply.postUser.set(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter));
      if (this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply != null) {}
      for (localStReply.targetUser = ((CertifiedAccountMeta.StUser)this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StReply.postUser.get()); localObject == null; localStReply.targetUser = this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.postUser)
      {
        QLog.e(CommentPresenter.a(), 1, "feed is null");
        return;
      }
      if (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).targetUser != null) {
        CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).put(Long.valueOf(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter)), CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).targetUser);
      }
      CommentPresenter.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter), this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment, localStReply));
      CommentPresenter.c(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, true);
      CommentPresenter.d(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, true);
      if (CommentPresenter.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) != null) {
        CommentPresenter.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).put(Long.valueOf(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter)), CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter));
      }
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, null);
      if (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) != null)
      {
        CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a(this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment.id.get(), localStReply);
        CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).notifyDataSetChanged();
      }
    }
    for (;;)
    {
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a("");
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).b(null);
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).dismiss();
      return;
      if (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) == null) {
        CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, CommentPresenter.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, this.jdField_a_of_type_NS_CERTIFIED_ACCOUNTCertifiedAccountMeta$StComment));
      }
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).content.set(str);
      localObject = new CertifiedAccountMeta.StComment();
      ((CertifiedAccountMeta.StComment)localObject).id.set("fakeId_" + System.currentTimeMillis());
      ((CertifiedAccountMeta.StComment)localObject).content.set(str);
      ((CertifiedAccountMeta.StComment)localObject).createTime.set((int)(System.currentTimeMillis() / 1000L));
      ((CertifiedAccountMeta.StComment)localObject).postUser.set(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter));
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter), (CertifiedAccountMeta.StComment)localObject);
      CommentPresenter.c(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, true);
      CommentPresenter.d(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, true);
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, null);
      if (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) != null)
      {
        CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a(0, (CertifiedAccountMeta.StComment)localObject);
        CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).notifyDataSetChanged();
      }
      if (this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter.a != null)
      {
        QLog.d(CommentPresenter.a(), 1, "mNeedShowCommentList1");
        this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter.a.setSelection(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.6
 * JD-Core Version:    0.7.0.1
 */