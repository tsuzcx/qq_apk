package com.tencent.mobileqq.activity.recent.msgbox;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;

class FilterMessageBoxFragment$9
  implements ThreadExcutor.IThreadListener
{
  FilterMessageBoxFragment$9(FilterMessageBoxFragment paramFilterMessageBoxFragment) {}
  
  public void onAdded()
  {
    FilterMessageBoxFragment.a(this.a, true);
  }
  
  public void onPostRun()
  {
    FilterMessageBoxFragment.a(this.a, false);
  }
  
  public void onPreRun()
  {
    FilterMessageBoxFragment.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.FilterMessageBoxFragment.9
 * JD-Core Version:    0.7.0.1
 */