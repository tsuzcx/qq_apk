package com.tencent.biz.pubaccount.readinjoy.comment;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyCommentListView$2
  implements View.OnClickListener
{
  ReadInJoyCommentListView$2(ReadInJoyCommentListView paramReadInJoyCommentListView) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ReadInJoyCommentListView", 2, "loadmore comment when network not available");
    ReadInJoyCommentListView.access$000(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListView.2
 * JD-Core Version:    0.7.0.1
 */