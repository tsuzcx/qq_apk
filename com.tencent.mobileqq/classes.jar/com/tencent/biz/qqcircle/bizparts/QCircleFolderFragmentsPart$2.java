package com.tencent.biz.qqcircle.bizparts;

import android.view.View;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.fragments.QCircleBaseFragment;
import com.tencent.biz.qqcircle.fragments.QCircleBaseTabFragment;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;
import java.util.ArrayList;

class QCircleFolderFragmentsPart$2
  implements ViewPager.OnPageChangeListener
{
  QCircleFolderFragmentsPart$2(QCircleFolderFragmentsPart paramQCircleFolderFragmentsPart) {}
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    QCircleFolderFragmentsPart.a(this.a, paramInt, 2);
    if ((QCircleFolderFragmentsPart.b(this.a) != null) && (QCircleFolderFragmentsPart.b(this.a).getChildCount() > paramInt)) {
      QCircleFolderFragmentsPart.b(this.a).getChildAt(paramInt).performClick();
    }
    if (QCircleFolderFragmentsPart.c(this.a).size() > paramInt)
    {
      ((QCircleBaseTabFragment)QCircleFolderFragmentsPart.c(this.a).get(paramInt)).a(paramInt);
      localObject = ((QCircleBaseTabFragment)QCircleFolderFragmentsPart.c(this.a).get(paramInt)).U();
      if (localObject != null) {
        QCircleFolderFragmentsPart.a(this.a, ((QCircleTabInfo)localObject).a());
      }
    }
    Object localObject = this.a;
    ((QCircleFolderFragmentsPart)localObject).c("tab_changed", Integer.valueOf(QCircleFolderFragmentsPart.d((QCircleFolderFragmentsPart)localObject)));
    localObject = this.a;
    QCircleFolderFragmentsPart.b((QCircleFolderFragmentsPart)localObject, QCircleFolderFragmentsPart.d((QCircleFolderFragmentsPart)localObject));
    if ((this.a.j() instanceof QCircleBaseFragment)) {
      ((QCircleBaseFragment)this.a.j()).h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleFolderFragmentsPart.2
 * JD-Core Version:    0.7.0.1
 */