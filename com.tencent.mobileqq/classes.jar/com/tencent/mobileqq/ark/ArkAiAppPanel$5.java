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
    Object localObject = ArkAiAppPanel.a(this.a).getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(false);
    }
    ArkAiAppPanel.a(this.a).setSelection(paramInt);
    localObject = ArkAiAppPanel.a(this.a).getSelectedView();
    if (localObject != null) {
      ((View)localObject).setSelected(true);
    }
    ArkAiAppPanel.a(this.a, paramInt);
    ArkAiAppPanel.a(this.a, true);
    if ((ArkAiAppPanel.a(this.a) != null) && (ArkAiAppPanel.a(this.a).size() > 0) && (ArkAiAppPanel.a(this.a).size() > ArkAiAppPanel.a(this.a)))
    {
      localObject = (ArkAiInfo)ArkAiAppPanel.a(this.a).get(ArkAiAppPanel.a(this.a));
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