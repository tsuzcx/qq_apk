package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.aelight.camera.log.AEQLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/aelight/camera/ae/camera/ui/panel/daoju/AENewMaterialPanel$3", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "aelight_impl_release"}, k=1, mv={1, 1, 16})
public final class AENewMaterialPanel$3
  implements ViewPager.OnPageChangeListener
{
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("page scrolled to position: ");
    localStringBuilder.append(paramInt);
    AEQLog.b("AEBottomPanelPart", localStringBuilder.toString());
    AENewMaterialPanel.f(this.a).onTabChecked(paramInt);
    AENewMaterialPanel.a(this.a, paramInt);
    AENewMaterialPanel.b(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel.3
 * JD-Core Version:    0.7.0.1
 */