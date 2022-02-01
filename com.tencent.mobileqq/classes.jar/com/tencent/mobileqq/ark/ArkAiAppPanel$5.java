package com.tencent.mobileqq.ark;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.List;

class ArkAiAppPanel$5
  implements AdapterView.OnItemClickListener
{
  ArkAiAppPanel$5(ArkAiAppPanel paramArkAiAppPanel) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = ArkAiAppPanel.b(this.a).getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(false);
    }
    ArkAiAppPanel.b(this.a).setSelection(paramInt);
    localObject = ArkAiAppPanel.b(this.a).getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(true);
    }
    ArkAiAppPanel.a(this.a, paramInt);
    ArkAiAppPanel.b(this.a, true);
    if ((ArkAiAppPanel.f(this.a) != null) && (ArkAiAppPanel.f(this.a).size() > 0) && (ArkAiAppPanel.f(this.a).size() > ArkAiAppPanel.c(this.a)))
    {
      localObject = (ArkAiInfo)ArkAiAppPanel.f(this.a).get(ArkAiAppPanel.c(this.a));
      if (localObject != null) {
        ArkAppDataReport.a(null, ((ArkAiInfo)localObject).a, "AIOInputPannelTabClick", 0, 0, 0L, 0L, 0L, "", "");
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiAppPanel.5
 * JD-Core Version:    0.7.0.1
 */