package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.coreui.pluspanel.PlusPanel;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;

public class PlusPanelHelper
  implements ILifeCycleHelper
{
  private BaseChatPie a;
  private PanelManager b;
  
  public PlusPanelHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private PlusPanel a()
  {
    if (this.b == null) {
      this.b = this.a.bq();
    }
    return (PlusPanel)this.b.d(8);
  }
  
  public String getTag()
  {
    return "PlusPanelHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7, 10, 11, 12, 15 };
  }
  
  public void onMoveToState(int paramInt)
  {
    PlusPanel localPlusPanel = a();
    if (localPlusPanel != null) {
      localPlusPanel.a(this.a, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.PlusPanelHelper
 * JD-Core Version:    0.7.0.1
 */