package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import uwf;
import uwm;
import uwq;
import uwz;
import ved;

public class HomeFeedPresenter$2
  implements Runnable
{
  public HomeFeedPresenter$2(uwq paramuwq, uwm paramuwm) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if ((this.a.c) && (this.a.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
      uwq.a(this.this$0).clear();
    }
    uwq.a(this.this$0).addAll(this.a.b);
    this.this$0.a(uwq.a(this.this$0));
    Collections.sort(uwq.a(this.this$0), uwf.a);
    uwq.a(this.this$0, this.a.jdField_a_of_type_Boolean);
    this.a.b = uwq.a(this.this$0);
    ved.a("Q.qqstory.home.data.HomeFeedPresenter", "had load feed size:%d, take time:%d", Integer.valueOf(uwq.a(this.this$0).size()), Long.valueOf(System.currentTimeMillis() - l));
    if (uwq.a(this.this$0) != null) {
      uwq.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */