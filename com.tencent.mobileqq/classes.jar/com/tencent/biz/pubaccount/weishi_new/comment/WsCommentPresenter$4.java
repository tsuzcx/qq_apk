package com.tencent.biz.pubaccount.weishi_new.comment;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class WsCommentPresenter$4
  implements AbsListView.OnScrollListener
{
  boolean jdField_a_of_type_Boolean = false;
  
  WsCommentPresenter$4(WsCommentPresenter paramWsCommentPresenter) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt3 > 0) && (paramAbsListView.getFirstVisiblePosition() + paramInt2 >= paramInt3)) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    EventCollector.getInstance().onListScrollStateChanged(paramAbsListView, paramInt);
    if ((this.jdField_a_of_type_Boolean) && (paramInt == 0))
    {
      WSLog.c("comment", "onScrollStateChanged scrollState:" + paramInt);
      WsCommentPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter.a().a(WsCommentPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter)));
      if (WsCommentPresenter.b(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter) != null)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter.a().a(WsCommentPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter), true);
        WsCommentPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCommentWsCommentPresenter, true);
      }
    }
    else
    {
      return;
    }
    WSLog.c("comment", "mCommentAttachInfo is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentPresenter.4
 * JD-Core Version:    0.7.0.1
 */