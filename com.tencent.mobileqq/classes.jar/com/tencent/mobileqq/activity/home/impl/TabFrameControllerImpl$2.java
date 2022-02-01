package com.tencent.mobileqq.activity.home.impl;

import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabHost.OnTabSelectionListener;

class TabFrameControllerImpl$2
  implements QQTabHost.OnTabSelectionListener
{
  TabFrameControllerImpl$2(TabFrameControllerImpl paramTabFrameControllerImpl, FrameFragment paramFrameFragment) {}
  
  public void a(int paramInt1, int paramInt2, QQTabHost paramQQTabHost)
  {
    if (paramInt1 == paramInt2)
    {
      paramQQTabHost = this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.a();
      if (paramQQTabHost != null) {
        paramQQTabHost.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.2
 * JD-Core Version:    0.7.0.1
 */