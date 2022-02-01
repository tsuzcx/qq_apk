package com.tencent.mobileqq.activity;

import com.tencent.image.AbstractGifImage;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

class ChatHistory$26
  implements AbsListView.OnScrollListener
{
  ChatHistory$26(ChatHistory paramChatHistory) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    paramAbsListView = this.a;
    paramAbsListView.m = paramInt;
    if (paramInt == 0)
    {
      AbstractGifImage.resumeAll();
      return;
    }
    if ((paramAbsListView.a != null) && (this.a.a.jdField_a_of_type_Int == 1) && (!this.a.a.jdField_a_of_type_Boolean)) {
      this.a.a.d();
    }
    AbstractGifImage.pauseAll();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.26
 * JD-Core Version:    0.7.0.1
 */