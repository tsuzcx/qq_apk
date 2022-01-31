package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import wpg;
import wpn;
import wpr;
import wqa;
import wxe;

public class HomeFeedPresenter$2
  implements Runnable
{
  public HomeFeedPresenter$2(wpr paramwpr, wpn paramwpn) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if ((this.a.c) && (this.a.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
      wpr.a(this.this$0).clear();
    }
    wpr.a(this.this$0).addAll(this.a.b);
    this.this$0.a(wpr.a(this.this$0));
    Collections.sort(wpr.a(this.this$0), wpg.a);
    wpr.a(this.this$0, this.a.jdField_a_of_type_Boolean);
    this.a.b = wpr.a(this.this$0);
    wxe.a("Q.qqstory.home.data.HomeFeedPresenter", "had load feed size:%d, take time:%d", Integer.valueOf(wpr.a(this.this$0).size()), Long.valueOf(System.currentTimeMillis() - l));
    if (wpr.a(this.this$0) != null) {
      wpr.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */