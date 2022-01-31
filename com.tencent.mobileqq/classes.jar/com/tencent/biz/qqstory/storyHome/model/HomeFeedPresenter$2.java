package com.tencent.biz.qqstory.storyHome.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import java.util.ArrayList;
import java.util.Collections;
import uwi;
import uwp;
import uwt;
import uxc;
import veg;

public class HomeFeedPresenter$2
  implements Runnable
{
  public HomeFeedPresenter$2(uwt paramuwt, uwp paramuwp) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if ((this.a.c) && (this.a.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())) {
      uwt.a(this.this$0).clear();
    }
    uwt.a(this.this$0).addAll(this.a.b);
    this.this$0.a(uwt.a(this.this$0));
    Collections.sort(uwt.a(this.this$0), uwi.a);
    uwt.a(this.this$0, this.a.jdField_a_of_type_Boolean);
    this.a.b = uwt.a(this.this$0);
    veg.a("Q.qqstory.home.data.HomeFeedPresenter", "had load feed size:%d, take time:%d", Integer.valueOf(uwt.a(this.this$0).size()), Long.valueOf(System.currentTimeMillis() - l));
    if (uwt.a(this.this$0) != null) {
      uwt.a(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter.2
 * JD-Core Version:    0.7.0.1
 */