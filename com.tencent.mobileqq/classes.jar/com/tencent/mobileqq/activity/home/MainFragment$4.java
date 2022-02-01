package com.tencent.mobileqq.activity.home;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.SharedPreUtils;

class MainFragment$4
  implements Runnable
{
  MainFragment$4(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (BaseApplicationImpl.getContext() != null) {
      SharedPreUtils.a(BaseApplicationImpl.getContext(), "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.4
 * JD-Core Version:    0.7.0.1
 */