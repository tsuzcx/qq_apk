package com.tencent.biz.pubaccount.readinjoy.comment;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.hotpic.PublicAccountGifListener;
import mqq.os.MqqHandler;

class ReadInJoyCommentComponentFragment$8
  implements PublicAccountGifListener
{
  ReadInJoyCommentComponentFragment$8(ReadInJoyCommentComponentFragment paramReadInJoyCommentComponentFragment) {}
  
  public void a(HotPicData paramHotPicData)
  {
    this.a.a = paramHotPicData;
    ReadInJoyCommentComponentFragment.a(this.a, null);
    ThreadManager.getUIHandler().post(new ReadInJoyCommentComponentFragment.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentComponentFragment.8
 * JD-Core Version:    0.7.0.1
 */