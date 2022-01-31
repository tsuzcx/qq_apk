package com.tencent.mobileqq.ark;

import alra;
import android.view.View;
import com.tencent.widget.HorizontalListView;

public class ArkAiAppPanel$2
  implements Runnable
{
  public ArkAiAppPanel$2(alra paramalra) {}
  
  public void run()
  {
    View localView = alra.a(this.this$0).getSelectedView();
    if (localView != null) {
      localView.setSelected(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel.2
 * JD-Core Version:    0.7.0.1
 */