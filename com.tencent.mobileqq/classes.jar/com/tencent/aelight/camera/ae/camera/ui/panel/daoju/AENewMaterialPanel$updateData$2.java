package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import androidx.viewpager.widget.PagerAdapter;
import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView;
import com.tencent.mobileqq.widget.QQViewPager;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AENewMaterialPanel$updateData$2
  implements Runnable
{
  AENewMaterialPanel$updateData$2(AENewMaterialPanel paramAENewMaterialPanel, List paramList) {}
  
  public final void run()
  {
    PagerAdapter localPagerAdapter = AENewMaterialPanel.d(this.this$0).getAdapter();
    if (localPagerAdapter != null)
    {
      ((AENewMaterialPanel.PanelPageAdapter)localPagerAdapter).e(AENewMaterialPanel.e(this.this$0));
      if ((AENewMaterialPanel.e(this.this$0) >= 0) && (AENewMaterialPanel.e(this.this$0) < this.a.size() - 1)) {
        AENewMaterialPanel.f(this.this$0).onTabChecked(AENewMaterialPanel.e(this.this$0));
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel.PanelPageAdapter");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel.updateData.2
 * JD-Core Version:    0.7.0.1
 */