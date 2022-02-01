package com.tencent.aelight.camera.ae.camera.ui.panel.daoju;

import com.tencent.aelight.camera.ae.camera.ui.panel.AEGridView;
import com.tencent.aelight.camera.ae.data.AEMaterialMetaData;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.mobileqq.widget.QQViewPager;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class AENewMaterialPanel$selectCategoryAndItem$2
  implements Runnable
{
  AENewMaterialPanel$selectCategoryAndItem$2(AENewMaterialPanel paramAENewMaterialPanel, int paramInt1, int paramInt2, AEMaterialMetaData paramAEMaterialMetaData) {}
  
  public final void run()
  {
    Object localObject2 = AENewMaterialPanel.d(this.this$0).getAdapter();
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof AENewMaterialPanel.PanelPageAdapter)) {
      localObject1 = null;
    }
    localObject1 = (AENewMaterialPanel.PanelPageAdapter)localObject1;
    if (localObject1 != null) {
      localObject1 = ((AENewMaterialPanel.PanelPageAdapter)localObject1).b(this.a);
    } else {
      localObject1 = null;
    }
    if (localObject1 != null) {
      ((AEGridView)localObject1).a(this.b);
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("scroll down ");
    ((StringBuilder)localObject2).append(String.valueOf(localObject1));
    ((StringBuilder)localObject2).append(" to position = ");
    ((StringBuilder)localObject2).append(this.b);
    AEQLog.b("AEBottomPanelPart", ((StringBuilder)localObject2).toString());
    if (localObject1 != null) {
      localObject1 = ((AEGridView)localObject1).getAdapter();
    } else {
      localObject1 = null;
    }
    localObject2 = localObject1;
    if (!(localObject1 instanceof AENewMaterialAdapter)) {
      localObject2 = null;
    }
    localObject1 = (AENewMaterialAdapter)localObject2;
    if (localObject1 != null) {
      ((AENewMaterialAdapter)localObject1).a(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.panel.daoju.AENewMaterialPanel.selectCategoryAndItem.2
 * JD-Core Version:    0.7.0.1
 */