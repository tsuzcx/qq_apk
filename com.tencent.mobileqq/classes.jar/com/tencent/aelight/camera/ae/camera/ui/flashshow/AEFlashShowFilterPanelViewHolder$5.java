package com.tencent.aelight.camera.ae.camera.ui.flashshow;

import com.tencent.aelight.camera.ae.control.AEQIMManager;
import com.tencent.mobileqq.wink.editor.filter.FilterMaterialPanelContentAdapter;
import com.tencent.mobileqq.wink.view.WinkMaterialPanel;
import java.util.List;

class AEFlashShowFilterPanelViewHolder$5
  implements Runnable
{
  AEFlashShowFilterPanelViewHolder$5(AEFlashShowFilterPanelViewHolder paramAEFlashShowFilterPanelViewHolder, List paramList1, List paramList2) {}
  
  public void run()
  {
    AEFlashShowFilterPanelViewHolder.d(this.this$0).setup(AEFlashShowFilterPanelViewHolder.c(this.this$0), this.a, this.b);
    AEFlashShowFilterDataManager localAEFlashShowFilterDataManager = (AEFlashShowFilterDataManager)AEQIMManager.a(4);
    if (localAEFlashShowFilterDataManager.a() != null) {
      AEFlashShowFilterPanelViewHolder.c(this.this$0).a(localAEFlashShowFilterDataManager.a().a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.flashshow.AEFlashShowFilterPanelViewHolder.5
 * JD-Core Version:    0.7.0.1
 */