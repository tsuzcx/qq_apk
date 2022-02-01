package com.tencent.biz.qqstory.utils;

import bisl;

public class UIUtils$StoryProgressUI
{
  bisl mProgressDialog;
  
  UIUtils$StoryProgressUI(bisl parambisl)
  {
    this.mProgressDialog = parambisl;
  }
  
  public void dismiss()
  {
    if ((this.mProgressDialog != null) && (this.mProgressDialog.isShowing())) {
      this.mProgressDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.UIUtils.StoryProgressUI
 * JD-Core Version:    0.7.0.1
 */