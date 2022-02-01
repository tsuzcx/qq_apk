package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController.QQStoryMainView;
import com.tencent.biz.qqstory.utils.AssertUtils;

class Now$2
  implements QQStoryMainController.QQStoryMainView
{
  Now$2(Now paramNow) {}
  
  public View a()
  {
    return this.a.jdField_b_of_type_AndroidWidgetRelativeLayout;
  }
  
  public ImageView a()
  {
    boolean bool;
    if (this.a.jdField_a_of_type_AndroidWidgetImageView != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    return this.a.jdField_a_of_type_AndroidWidgetImageView;
  }
  
  public TextView a()
  {
    boolean bool;
    if (this.a.c != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    return this.a.c;
  }
  
  public void a()
  {
    this.a.a();
  }
  
  public void a(String paramString)
  {
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Now.a(this.a);
      return;
    }
    Now.b(this.a);
  }
  
  public void b()
  {
    this.a.c(false);
  }
  
  public void b(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(i);
  }
  
  public void c()
  {
    this.a.c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Now.2
 * JD-Core Version:    0.7.0.1
 */