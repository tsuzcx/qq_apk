package com.tencent.mobileqq.activity.aio.panel;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIORelatedEmotionHelper;
import com.tencent.widget.XPanelContainer;

public class RelateEmoPanelProvider
  implements PanelProvider<View>
{
  private BaseChatPie a;
  private View b;
  
  public RelateEmoPanelProvider(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public View createPanel(Context paramContext)
  {
    this.b = ((AIORelatedEmotionHelper)this.a.q(72)).c();
    return this.b;
  }
  
  public View getPanel()
  {
    return this.b;
  }
  
  public int getPanelId()
  {
    return 37;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer) {}
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.panel.RelateEmoPanelProvider
 * JD-Core Version:    0.7.0.1
 */