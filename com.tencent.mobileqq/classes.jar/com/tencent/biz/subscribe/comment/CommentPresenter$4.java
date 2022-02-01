package com.tencent.biz.subscribe.comment;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommentPresenter$4
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  CommentPresenter$4(CommentPresenter paramCommentPresenter) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramAbsListView.getFirstVisiblePosition() + paramInt2 >= paramInt3))
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0) && (!CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter)) && (!CommentPresenter.b(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter)))
    {
      QLog.i(CommentPresenter.a(), 1, "onLastItemVisible");
      CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter)));
      if (CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter) != null)
      {
        CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter).a(CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter), true);
        CommentPresenter.a(this.jdField_a_of_type_ComTencentBizSubscribeCommentCommentPresenter, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentPresenter.4
 * JD-Core Version:    0.7.0.1
 */