package com.tencent.biz.qqcircle.fragments.message.presenter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.fragments.message.item.QCircleMessageReplyItemView.QCircleMessageReplyItemListener;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper;
import com.tencent.biz.qqcircle.utils.QCircleCommentHelper;

class QCircleReplyMessagePresenter$2
  implements QCircleMessageReplyItemView.QCircleMessageReplyItemListener
{
  QCircleReplyMessagePresenter$2(QCircleReplyMessagePresenter paramQCircleReplyMessagePresenter, Context paramContext) {}
  
  public void a(View paramView, QCircleFeedCommentInfo paramQCircleFeedCommentInfo)
  {
    if ((paramQCircleFeedCommentInfo != null) && (QCircleReplyMessagePresenter.a(this.b) != null))
    {
      if (!QCircleBindPhoneNumberHelper.a())
      {
        QCircleBindPhoneNumberHelper.a(this.a, 3);
        return;
      }
      QCircleCommentHelper.a().a((Activity)this.a, paramQCircleFeedCommentInfo, QCircleReplyMessagePresenter.a(this.b), QCircleReplyMessagePresenter.b(this.b));
      QCircleReplyMessagePresenter.a(this.b, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.presenter.QCircleReplyMessagePresenter.2
 * JD-Core Version:    0.7.0.1
 */