package com.tencent.biz.subscribe.comment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StComment;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StReply;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;

class CommentPresenter$OnFeedCommentElementClickListener
  implements OnCommentElementClickListener
{
  CommentPresenter$OnFeedCommentElementClickListener(CommentPresenter paramCommentPresenter) {}
  
  public void a(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    Object localObject;
    switch (paramInt1)
    {
    case 3: 
    case 5: 
    case 8: 
    default: 
    case 11: 
      if ((paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramView = (Object[])paramObject;
        if ((paramView.length > 1) && (paramView[0] != null))
        {
          paramObject = (CertifiedAccountMeta.StComment)paramView[0];
          paramInt1 = CommentPresenter.a(this.a).c(paramObject);
          if ((paramInt1 >= 0) && (paramView[1] != null))
          {
            int i = ((Integer)paramView[1]).intValue();
            this.a.g.setSelectionFromTop(paramInt2, paramInt1 * -1 * i);
            return;
          }
        }
      }
      break;
    case 10: 
      if ((paramObject != null) && ((paramObject instanceof CertifiedAccountMeta.StComment)))
      {
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        CommentPresenter.a(this.a).b(paramView);
        return;
      }
      break;
    case 9: 
      if ((paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramView = (Object[])paramObject;
        if ((paramView.length > 1) && (paramView[0] != null) && (paramView[1] != null))
        {
          paramObject = (CertifiedAccountMeta.StComment)paramView[0];
          CommentPresenter.i(this.a).c(CommentPresenter.k(this.a), paramObject, (CertifiedAccountMeta.StReply)paramView[1]);
          CommentPresenter.c(this.a, true);
          return;
        }
      }
      break;
    case 7: 
      if ((paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if ((paramObject.length > 1) && (paramObject[0] != null) && (paramObject[1] != null) && ((paramObject[0] instanceof CertifiedAccountMeta.StComment)) && ((paramObject[1] instanceof CertifiedAccountMeta.StReply)))
        {
          paramView = (CertifiedAccountMeta.StComment)paramObject[0];
          paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
          localObject = CommentPresenter.t();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("click reply, feedId: ");
          localStringBuilder.append(CommentPresenter.k(this.a).id);
          localStringBuilder.append(" commentId: ");
          localStringBuilder.append(paramView.id);
          localStringBuilder.append(" replyId: ");
          localStringBuilder.append(paramObject.id);
          QLog.d((String)localObject, 1, localStringBuilder.toString());
          CommentPresenter.a(this.a, paramView, paramObject);
          return;
        }
      }
      break;
    case 6: 
      if ((paramObject != null) && ((paramObject instanceof CertifiedAccountMeta.StComment)))
      {
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        paramObject = this.a;
        CommentPresenter.a(paramObject, CommentPresenter.i(paramObject).c(CommentPresenter.k(this.a), paramView));
        CommentPresenter.c(this.a, true);
        return;
      }
      break;
    case 4: 
      if ((paramObject != null) && ((paramObject instanceof CertifiedAccountMeta.StComment)))
      {
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        paramObject = CommentPresenter.t();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("click comment, feedId: ");
        ((StringBuilder)localObject).append(CommentPresenter.k(this.a).id);
        ((StringBuilder)localObject).append(" commentId: ");
        ((StringBuilder)localObject).append(paramView.id);
        QLog.d(paramObject, 1, ((StringBuilder)localObject).toString());
        CommentPresenter.a(this.a, paramView, null);
        return;
      }
      break;
    case 1: 
    case 2: 
      if ((paramObject != null) && ((paramObject instanceof CertifiedAccountMeta.StUser)))
      {
        paramView = (CertifiedAccountMeta.StUser)paramObject;
        if (paramView.type.get() == 1) {
          SubscribeLaucher.a(CommentPresenter.n(this.a), paramView);
        }
      }
      break;
    }
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    if (paramInt1 != 5)
    {
      if (paramInt1 != 8) {
        return;
      }
      if ((paramObject != null) && ((paramObject instanceof Object[])))
      {
        paramObject = (Object[])paramObject;
        if ((paramObject.length > 1) && (paramObject[0] != null) && (paramObject[1] != null) && ((paramObject[0] instanceof CertifiedAccountMeta.StComment)) && ((paramObject[1] instanceof CertifiedAccountMeta.StReply)))
        {
          paramView = (CertifiedAccountMeta.StComment)paramObject[0];
          paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
          CommentPresenter localCommentPresenter = this.a;
          CommentPresenter.a(localCommentPresenter, new ActionSheetDialog(CommentPresenter.v(localCommentPresenter), false, true));
          CommentPresenter.r(this.a).a(CommentPresenter.w(this.a).getString(2131888241), 0, new CommentPresenter.OnFeedCommentElementClickListener.4(this, paramObject));
          if (CommentPresenter.a(this.a, paramObject.postUser)) {
            CommentPresenter.r(this.a).a(CommentPresenter.y(this.a).getString(2131888434), 1, new CommentPresenter.OnFeedCommentElementClickListener.5(this, paramView, paramObject));
          } else {
            CommentPresenter.r(this.a).a(CommentPresenter.z(this.a).getString(2131915698), 6, new CommentPresenter.OnFeedCommentElementClickListener.6(this, paramView, paramObject));
          }
          CommentPresenter.r(this.a).a(CommentPresenter.A(this.a).getString(2131887648));
          CommentPresenter.r(this.a).show();
        }
      }
    }
    else if ((paramObject != null) && ((paramObject instanceof CertifiedAccountMeta.StComment)))
    {
      paramView = (CertifiedAccountMeta.StComment)paramObject;
      paramObject = this.a;
      CommentPresenter.a(paramObject, new ActionSheetDialog(CommentPresenter.o(paramObject), false, true));
      CommentPresenter.r(this.a).a(CommentPresenter.p(this.a).getString(2131888241), 0, new CommentPresenter.OnFeedCommentElementClickListener.1(this, paramView));
      if (CommentPresenter.a(this.a, paramView.postUser)) {
        CommentPresenter.r(this.a).a(CommentPresenter.s(this.a).getString(2131888434), 1, new CommentPresenter.OnFeedCommentElementClickListener.2(this, paramView));
      } else {
        CommentPresenter.r(this.a).a(CommentPresenter.t(this.a).getString(2131915698), 6, new CommentPresenter.OnFeedCommentElementClickListener.3(this, paramView));
      }
      CommentPresenter.r(this.a).a(CommentPresenter.u(this.a).getString(2131887648));
      CommentPresenter.r(this.a).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.OnFeedCommentElementClickListener
 * JD-Core Version:    0.7.0.1
 */