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
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            return;
                          } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StUser)));
                          paramView = (CertifiedAccountMeta.StUser)paramObject;
                        } while (paramView.type.get() != 1);
                        SubscribeLaucher.a(CommentPresenter.a(this.a), paramView);
                        return;
                      } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                      paramView = (CertifiedAccountMeta.StComment)paramObject;
                      QLog.d(CommentPresenter.a(), 1, "click comment, feedId: " + CommentPresenter.a(this.a).id + " commentId: " + paramView.id);
                      CommentPresenter.a(this.a, paramView, null);
                      return;
                    } while ((paramObject == null) || (!(paramObject instanceof Object[])));
                    paramObject = (Object[])paramObject;
                  } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
                  paramView = (CertifiedAccountMeta.StComment)paramObject[0];
                  paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
                  QLog.d(CommentPresenter.a(), 1, "click reply, feedId: " + CommentPresenter.a(this.a).id + " commentId: " + paramView.id + " replyId: " + paramObject.id);
                  CommentPresenter.a(this.a, paramView, paramObject);
                  return;
                } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
                paramView = (CertifiedAccountMeta.StComment)paramObject;
                CommentPresenter.a(this.a).b(paramView);
                return;
              } while ((paramObject == null) || (!(paramObject instanceof Object[])));
              paramView = (Object[])paramObject;
            } while ((paramView.length <= 1) || (paramView[0] == null));
            paramObject = (CertifiedAccountMeta.StComment)paramView[0];
            paramInt1 = CommentPresenter.a(this.a).a(paramObject);
          } while ((paramInt1 < 0) || (paramView[1] == null));
          int i = ((Integer)paramView[1]).intValue();
          this.a.a.setSelectionFromTop(paramInt2, i * (paramInt1 * -1));
          return;
        } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        CommentPresenter.a(this.a, CommentPresenter.a(this.a).a(CommentPresenter.a(this.a), paramView));
        CommentPresenter.c(this.a, true);
        return;
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramView = (Object[])paramObject;
    } while ((paramView.length <= 1) || (paramView[0] == null) || (paramView[1] == null));
    paramObject = (CertifiedAccountMeta.StComment)paramView[0];
    CommentPresenter.a(this.a).a(CommentPresenter.a(this.a), paramObject, (CertifiedAccountMeta.StReply)paramView[1]);
    CommentPresenter.c(this.a, true);
  }
  
  public void b(View paramView, int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt1)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramObject == null) || (!(paramObject instanceof CertifiedAccountMeta.StComment)));
        paramView = (CertifiedAccountMeta.StComment)paramObject;
        CommentPresenter.a(this.a, new ActionSheetDialog(CommentPresenter.a(this.a), false, true));
        CommentPresenter.a(this.a).a(CommentPresenter.b(this.a).getString(2131691369), 0, new CommentPresenter.OnFeedCommentElementClickListener.1(this, paramView));
        if (CommentPresenter.a(this.a, paramView.postUser)) {
          CommentPresenter.a(this.a).a(CommentPresenter.d(this.a).getString(2131691555), 1, new CommentPresenter.OnFeedCommentElementClickListener.2(this, paramView));
        }
        for (;;)
        {
          CommentPresenter.a(this.a).a(CommentPresenter.f(this.a).getString(2131690800));
          CommentPresenter.a(this.a).show();
          return;
          CommentPresenter.a(this.a).a(CommentPresenter.e(this.a).getString(2131718548), 6, new CommentPresenter.OnFeedCommentElementClickListener.3(this, paramView));
        }
      } while ((paramObject == null) || (!(paramObject instanceof Object[])));
      paramObject = (Object[])paramObject;
    } while ((paramObject.length <= 1) || (paramObject[0] == null) || (paramObject[1] == null) || (!(paramObject[0] instanceof CertifiedAccountMeta.StComment)) || (!(paramObject[1] instanceof CertifiedAccountMeta.StReply)));
    paramView = (CertifiedAccountMeta.StComment)paramObject[0];
    paramObject = (CertifiedAccountMeta.StReply)paramObject[1];
    CommentPresenter.a(this.a, new ActionSheetDialog(CommentPresenter.g(this.a), false, true));
    CommentPresenter.a(this.a).a(CommentPresenter.h(this.a).getString(2131691369), 0, new CommentPresenter.OnFeedCommentElementClickListener.4(this, paramObject));
    if (CommentPresenter.a(this.a, paramObject.postUser)) {
      CommentPresenter.a(this.a).a(CommentPresenter.j(this.a).getString(2131691555), 1, new CommentPresenter.OnFeedCommentElementClickListener.5(this, paramView, paramObject));
    }
    for (;;)
    {
      CommentPresenter.a(this.a).a(CommentPresenter.l(this.a).getString(2131690800));
      CommentPresenter.a(this.a).show();
      return;
      CommentPresenter.a(this.a).a(CommentPresenter.k(this.a).getString(2131718548), 6, new CommentPresenter.OnFeedCommentElementClickListener.6(this, paramView, paramObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.OnFeedCommentElementClickListener
 * JD-Core Version:    0.7.0.1
 */