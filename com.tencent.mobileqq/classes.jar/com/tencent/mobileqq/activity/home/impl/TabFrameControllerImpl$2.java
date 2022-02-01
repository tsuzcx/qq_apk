package com.tencent.mobileqq.activity.home.impl;

import com.tencent.mobileqq.app.Frame;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.widget.QQTabHost;
import com.tencent.mobileqq.widget.QQTabHost.OnTabSelectionListener;
import com.tencent.qphone.base.util.QLog;

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
        paramQQTabHost.e();
      }
    }
    if (paramInt1 != -1) {
      try
      {
        paramQQTabHost = this.jdField_a_of_type_ComTencentMobileqqAppFrameFragment.a.getCurrentTabTag();
        paramInt1 = this.jdField_a_of_type_ComTencentMobileqqActivityHomeImplTabFrameControllerImpl.getTabIndexFromName(paramQQTabHost);
        paramQQTabHost = new StringBuilder();
        paramQQTabHost.append("onTabSelected tabIndex: ");
        paramQQTabHost.append(paramInt1);
        QLog.i("TabFrameControllerImpl", 1, paramQQTabHost.toString());
        this.jdField_a_of_type_ComTencentMobileqqActivityHomeImplTabFrameControllerImpl.dispatchUpdateFrameOnTabClick(paramInt1);
        return;
      }
      catch (Exception paramQQTabHost)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onTabSelected excetpion: ");
        localStringBuilder.append(paramQQTabHost);
        QLog.e("TabFrameControllerImpl", 1, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.2
 * JD-Core Version:    0.7.0.1
 */