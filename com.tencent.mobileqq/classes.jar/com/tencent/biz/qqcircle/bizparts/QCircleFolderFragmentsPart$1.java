package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.Tab;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat.ViewPagerTabEventListener;
import com.tencent.biz.qqcircle.widgets.QCircleFolderTabView;
import java.util.ArrayList;

class QCircleFolderFragmentsPart$1
  implements TabLayoutCompat.ViewPagerTabEventListener
{
  QCircleFolderFragmentsPart$1(QCircleFolderFragmentsPart paramQCircleFolderFragmentsPart) {}
  
  public View a(ViewGroup paramViewGroup)
  {
    paramViewGroup = new QCircleFolderTabView(paramViewGroup);
    QCircleFolderFragmentsPart.a(this.a).add(paramViewGroup);
    return paramViewGroup.a();
  }
  
  public void a(TabLayoutCompat.Tab paramTab1, @Nullable TabLayoutCompat.Tab paramTab2, int paramInt)
  {
    if (paramTab1 != null) {
      QCircleFolderFragmentsPart.a(this.a, paramTab1.c(), 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart.1
 * JD-Core Version:    0.7.0.1
 */