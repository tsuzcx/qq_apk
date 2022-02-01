package com.tencent.biz.qqstory.storyHome;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryConstant;
import com.tencent.mobileqq.app.HardCodeUtil;

class QQStoryMainActivity$1
  implements QQStoryMainController.QQStoryMainView
{
  QQStoryMainActivity$1(QQStoryMainActivity paramQQStoryMainActivity) {}
  
  public View a()
  {
    return QQStoryMainActivity.a(this.a);
  }
  
  public void a(String paramString)
  {
    QQStoryMainActivity.a(this.a, paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.startTitleProgress();
      return;
    }
    this.a.stopTitleProgress();
  }
  
  public void b()
  {
    this.a.onBackEvent();
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      QQStoryMainActivity.a(this.a, QQStoryConstant.a, HardCodeUtil.a(2131908569));
      return;
    }
    a(QQStoryConstant.a);
  }
  
  public ImageView c()
  {
    return this.a.rightViewImg;
  }
  
  public TextView d()
  {
    return this.a.rightViewText;
  }
  
  public void e() {}
  
  public void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainActivity.1
 * JD-Core Version:    0.7.0.1
 */