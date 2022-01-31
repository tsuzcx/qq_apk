package com.tencent.biz.qqstory.utils;

import com.tencent.mobileqq.widget.QQProgressDialog;

public class UIUtils$StoryProgressUI
{
  QQProgressDialog a;
  
  UIUtils$StoryProgressUI(QQProgressDialog paramQQProgressDialog)
  {
    this.a = paramQQProgressDialog;
  }
  
  public void a()
  {
    if ((this.a != null) && (this.a.isShowing())) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.UIUtils.StoryProgressUI
 * JD-Core Version:    0.7.0.1
 */