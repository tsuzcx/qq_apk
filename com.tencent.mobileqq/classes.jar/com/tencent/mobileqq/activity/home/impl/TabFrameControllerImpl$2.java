package com.tencent.mobileqq.activity.home.impl;

import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabControlReporter;
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
      paramQQTabHost = this.a.v();
      if (paramQQTabHost != null) {
        paramQQTabHost.cx_();
      }
    }
    if (paramInt1 != -1) {}
    for (;;)
    {
      try
      {
        paramQQTabHost = this.a.s.getCurrentTabTag();
        if (paramInt1 != paramInt2) {
          break label145;
        }
        bool = true;
        TabControlReporter.a(paramQQTabHost, paramInt2, bool);
        paramInt1 = this.b.getTabIndexFromName(paramQQTabHost);
        paramQQTabHost = new StringBuilder();
        paramQQTabHost.append("onTabSelected tabIndex: ");
        paramQQTabHost.append(paramInt1);
        QLog.i("TabFrameControllerImpl", 1, paramQQTabHost.toString());
        this.b.dispatchUpdateFrameOnTabClick(this.a, paramInt1);
        return;
      }
      catch (Exception paramQQTabHost)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onTabSelected excetpion: ");
        localStringBuilder.append(paramQQTabHost);
        QLog.e("TabFrameControllerImpl", 1, localStringBuilder.toString());
      }
      return;
      label145:
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.impl.TabFrameControllerImpl.2
 * JD-Core Version:    0.7.0.1
 */