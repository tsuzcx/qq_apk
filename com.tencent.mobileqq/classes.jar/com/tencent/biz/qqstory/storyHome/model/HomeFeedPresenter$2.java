package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import ymm;
import ymt;
import ymx;
import yng;
import yuk;

public class HomeFeedPresenter$2
  implements Runnable
{
  public HomeFeedPresenter$2(ymx paramymx, ymt paramymt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if ((this.a.c) && (this.a.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
      ymx.a(this.this$0).clear();
    }
    ymx.a(this.this$0).addAll(this.a.b);
    this.this$0.a(ymx.a(this.this$0));
    Collections.sort(ymx.a(this.this$0), ymm.a);
    ymx.a(this.this$0, this.a.jdField_a_of_type_Boolean);
    this.a.b = ymx.a(this.this$0);
    yuk.a("Q.qqstory.home.data.HomeFeedPresenter", "had load feed size:%d, take time:%d", Integer.valueOf(ymx.a(this.this$0).size()), Long.valueOf(System.currentTimeMillis() - l));
    if (ymx.a(this.this$0) != null) {
      ymx.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */