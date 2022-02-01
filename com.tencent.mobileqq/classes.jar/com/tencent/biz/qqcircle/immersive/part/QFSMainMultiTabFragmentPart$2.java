package com.tencent.biz.qqcircle.immersive.part;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.widget.TextView;
import com.tencent.biz.qqcircle.immersive.tab.QFSBaseTabFragment;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.OnTabSelectedListener;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.Tab;
import com.tencent.biz.qqcircle.utils.QCircleThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class QFSMainMultiTabFragmentPart$2
  implements TabLayoutCompat.OnTabSelectedListener
{
  QFSMainMultiTabFragmentPart$2(QFSMainMultiTabFragmentPart paramQFSMainMultiTabFragmentPart) {}
  
  public void a(TabLayoutCompat.Tab paramTab)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onTabSelected");
    localStringBuilder.append(paramTab.c());
    QLog.i("QFSMainMultiTabFragmentPart", 1, localStringBuilder.toString());
    if ((paramTab != null) && (paramTab.j() != null)) {
      paramTab.j().setTextColor(this.a.g().getResources().getColor(2131167047));
    }
    if (QFSMainMultiTabFragmentPart.d(this.a))
    {
      QFSMainMultiTabFragmentPart.a(this.a, paramTab.c());
      QFSMainMultiTabFragmentPart.e(this.a);
      QCircleThreadManager.a().c().postDelayed(new QFSMainMultiTabFragmentPart.2.1(this), 500L);
      this.a.b(paramTab.c());
    }
  }
  
  public void b(TabLayoutCompat.Tab paramTab)
  {
    if ((paramTab != null) && (paramTab.j() != null)) {
      paramTab.j().setTextColor(this.a.g().getResources().getColor(2131167048));
    }
    ((QFSBaseTabFragment)QFSMainMultiTabFragmentPart.f(this.a).get(paramTab.c())).B();
  }
  
  public void c(TabLayoutCompat.Tab paramTab)
  {
    if (paramTab.c() == QFSMainMultiTabFragmentPart.c(this.a))
    {
      EventCollector.getInstance().onViewClicked(paramTab.a());
      ((QFSBaseTabFragment)QFSMainMultiTabFragmentPart.f(this.a).get(QFSMainMultiTabFragmentPart.c(this.a))).M();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart.2
 * JD-Core Version:    0.7.0.1
 */