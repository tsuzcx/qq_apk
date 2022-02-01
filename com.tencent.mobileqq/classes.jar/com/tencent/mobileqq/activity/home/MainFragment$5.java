package com.tencent.mobileqq.activity.home;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SharedPreUtils;

class MainFragment$5
  implements Runnable
{
  MainFragment$5(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (BaseApplicationImpl.getContext() != null) {
      SharedPreUtils.a(BaseApplicationImpl.getContext(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.5
 * JD-Core Version:    0.7.0.1
 */