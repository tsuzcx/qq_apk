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
    QQProgressDialog localQQProgressDialog = this.a;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.a.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.UIUtils.StoryProgressUI
 * JD-Core Version:    0.7.0.1
 */