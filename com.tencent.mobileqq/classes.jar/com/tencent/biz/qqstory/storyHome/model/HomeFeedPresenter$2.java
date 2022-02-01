package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import ycs;
import ycz;
import ydd;
import ydm;
import ykq;

public class HomeFeedPresenter$2
  implements Runnable
{
  public HomeFeedPresenter$2(ydd paramydd, ycz paramycz) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if ((this.a.c) && (this.a.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
      ydd.a(this.this$0).clear();
    }
    ydd.a(this.this$0).addAll(this.a.b);
    this.this$0.a(ydd.a(this.this$0));
    Collections.sort(ydd.a(this.this$0), ycs.a);
    ydd.a(this.this$0, this.a.jdField_a_of_type_Boolean);
    this.a.b = ydd.a(this.this$0);
    ykq.a("Q.qqstory.home.data.HomeFeedPresenter", "had load feed size:%d, take time:%d", Integer.valueOf(ydd.a(this.this$0).size()), Long.valueOf(System.currentTimeMillis() - l));
    if (ydd.a(this.this$0) != null) {
      ydd.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */