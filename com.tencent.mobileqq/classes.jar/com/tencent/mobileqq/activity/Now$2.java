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
    return this.a.d;
  }
  
  public void a(String paramString)
  {
    this.a.e.setText(paramString);
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
    this.a.h();
  }
  
  public void b(boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    this.a.f.setVisibility(i);
  }
  
  public ImageView c()
  {
    boolean bool;
    if (this.a.g != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    return this.a.g;
  }
  
  public TextView d()
  {
    boolean bool;
    if (this.a.h != null) {
      bool = true;
    } else {
      bool = false;
    }
    AssertUtils.assertTrue(bool);
    return this.a.h;
  }
  
  public void e()
  {
    this.a.c(false);
  }
  
  public void f()
  {
    this.a.c(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Now.2
 * JD-Core Version:    0.7.0.1
 */