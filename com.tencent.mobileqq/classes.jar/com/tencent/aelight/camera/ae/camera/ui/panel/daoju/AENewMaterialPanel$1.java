package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import com.tencent.aelight.camera.aioeditor.capture.view.QIMSlidingTabView.IOnTabCheckListener;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.widget.QQViewPager;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "tabIndex", "", "onTabChecked"}, k=3, mv={1, 1, 16})
final class AENewMaterialPanel$1
  implements QIMSlidingTabView.IOnTabCheckListener
{
  AENewMaterialPanel$1(AENewMaterialPanel paramAENewMaterialPanel) {}
  
  public final void onTabChecked(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tab checked to index: ");
    localStringBuilder.append(paramInt);
    AEQLog.b("AEBottomPanelPart", localStringBuilder.toString());
    if (AENewMaterialPanel.d(this.a).getCurrentItem() != paramInt) {
      AENewMaterialPanel.d(this.a).setCurrentItem(paramInt);
    }
    AENewMaterialPanel.a(this.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel.1
 * JD-Core Version:    0.7.0.1
 */