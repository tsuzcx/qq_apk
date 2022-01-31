package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import wkx;
import wle;
import wli;
import wlr;
import wsv;

public class HomeFeedPresenter$2
  implements Runnable
{
  public HomeFeedPresenter$2(wli paramwli, wle paramwle) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if ((this.a.c) && (this.a.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
      wli.a(this.this$0).clear();
    }
    wli.a(this.this$0).addAll(this.a.b);
    this.this$0.a(wli.a(this.this$0));
    Collections.sort(wli.a(this.this$0), wkx.a);
    wli.a(this.this$0, this.a.jdField_a_of_type_Boolean);
    this.a.b = wli.a(this.this$0);
    wsv.a("Q.qqstory.home.data.HomeFeedPresenter", "had load feed size:%d, take time:%d", Integer.valueOf(wli.a(this.this$0).size()), Long.valueOf(System.currentTimeMillis() - l));
    if (wli.a(this.this$0) != null) {
      wli.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */