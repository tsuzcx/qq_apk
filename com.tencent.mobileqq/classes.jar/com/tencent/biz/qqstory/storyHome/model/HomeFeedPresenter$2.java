package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import yir;
import yiy;
import yjc;
import yjl;
import yqp;

public class HomeFeedPresenter$2
  implements Runnable
{
  public HomeFeedPresenter$2(yjc paramyjc, yiy paramyiy) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if ((this.a.c) && (this.a.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
      yjc.a(this.this$0).clear();
    }
    yjc.a(this.this$0).addAll(this.a.b);
    this.this$0.a(yjc.a(this.this$0));
    Collections.sort(yjc.a(this.this$0), yir.a);
    yjc.a(this.this$0, this.a.jdField_a_of_type_Boolean);
    this.a.b = yjc.a(this.this$0);
    yqp.a("Q.qqstory.home.data.HomeFeedPresenter", "had load feed size:%d, take time:%d", Integer.valueOf(yjc.a(this.this$0).size()), Long.valueOf(System.currentTimeMillis() - l));
    if (yjc.a(this.this$0) != null) {
      yjc.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */