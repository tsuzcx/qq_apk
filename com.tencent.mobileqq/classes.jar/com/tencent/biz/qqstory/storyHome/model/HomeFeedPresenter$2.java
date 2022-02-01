package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import xnx;
import xoe;
import xoi;
import xor;
import xvv;

public class HomeFeedPresenter$2
  implements Runnable
{
  public HomeFeedPresenter$2(xoi paramxoi, xoe paramxoe) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if ((this.a.c) && (this.a.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
      xoi.a(this.this$0).clear();
    }
    xoi.a(this.this$0).addAll(this.a.b);
    this.this$0.a(xoi.a(this.this$0));
    Collections.sort(xoi.a(this.this$0), xnx.a);
    xoi.a(this.this$0, this.a.jdField_a_of_type_Boolean);
    this.a.b = xoi.a(this.this$0);
    xvv.a("Q.qqstory.home.data.HomeFeedPresenter", "had load feed size:%d, take time:%d", Integer.valueOf(xoi.a(this.this$0).size()), Long.valueOf(System.currentTimeMillis() - l));
    if (xoi.a(this.this$0) != null) {
      xoi.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */