package com.tencent.biz.qqcircle.immersive.part;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.immersive.views.QFSMultiTabView;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.Tab;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.ViewPagerTabEventListener;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import java.util.ArrayList;
import java.util.Map;

class QFSMainMultiTabFragmentPart$1
  implements TabLayoutCompat.ViewPagerTabEventListener
{
  QFSMainMultiTabFragmentPart$1(QFSMainMultiTabFragmentPart paramQFSMainMultiTabFragmentPart) {}
  
  private void a(TabLayoutCompat.Tab paramTab, int paramInt)
  {
    if (paramTab != null)
    {
      if (paramInt == 1)
      {
        QFSMainMultiTabFragmentPart.a(this.a, paramTab.c(), 1);
        EventCollector.getInstance().onViewClicked(paramTab.a());
        return;
      }
      paramTab = this.a;
      QFSMainMultiTabFragmentPart.a(paramTab, QFSMainMultiTabFragmentPart.c(paramTab), 2);
    }
  }
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new QFSMultiTabView(paramViewGroup);
    QFSMainMultiTabFragmentPart.a(this.a).add(paramViewGroup);
    if (QFSMainMultiTabFragmentPart.b(this.a).size() >= QFSMainMultiTabFragmentPart.a(this.a).size())
    {
      VideoReport.setElementId(paramViewGroup.a(), "em_xsj_top_tab");
      Map localMap = new QCircleDTParamBuilder().buildElementParams();
      localMap.put("xsj_tab_title", QFSMainMultiTabFragmentPart.b(this.a).get(QFSMainMultiTabFragmentPart.a(this.a).size() - 1));
      VideoReport.setElementParams(paramViewGroup.a(), localMap);
    }
    return paramViewGroup.a();
  }
  
  public void a(TabLayoutCompat.Tab paramTab1, @Nullable TabLayoutCompat.Tab paramTab2, int paramInt)
  {
    a(paramTab1, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSMainMultiTabFragmentPart.1
 * JD-Core Version:    0.7.0.1
 */