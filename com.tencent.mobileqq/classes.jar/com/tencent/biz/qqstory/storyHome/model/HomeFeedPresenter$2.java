package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import ujm;
import ujt;
import ujx;
import ukg;
import urk;

public class HomeFeedPresenter$2
  implements Runnable
{
  public HomeFeedPresenter$2(ujx paramujx, ujt paramujt) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if ((this.a.c) && (this.a.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
      ujx.a(this.this$0).clear();
    }
    ujx.a(this.this$0).addAll(this.a.b);
    this.this$0.a(ujx.a(this.this$0));
    Collections.sort(ujx.a(this.this$0), ujm.a);
    ujx.a(this.this$0, this.a.jdField_a_of_type_Boolean);
    this.a.b = ujx.a(this.this$0);
    urk.a("Q.qqstory.home.data.HomeFeedPresenter", "had load feed size:%d, take time:%d", Integer.valueOf(ujx.a(this.this$0).size()), Long.valueOf(System.currentTimeMillis() - l));
    if (ujx.a(this.this$0) != null) {
      ujx.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */