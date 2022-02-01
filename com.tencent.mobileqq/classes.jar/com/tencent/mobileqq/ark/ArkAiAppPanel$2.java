package com.tencent.mobileqq.ark;

import android.view.View;
import com.tencent.widget.HorizontalListView;

class ArkAiAppPanel$2
  implements Runnable
{
  ArkAiAppPanel$2(ArkAiAppPanel paramArkAiAppPanel) {}
  
  public void run()
  {
    View localView = ArkAiAppPanel.b(this.this$0).getSelectedView();
    if (localView != null) {
      localView.setSelected(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel.2
 * JD-Core Version:    0.7.0.1
 */