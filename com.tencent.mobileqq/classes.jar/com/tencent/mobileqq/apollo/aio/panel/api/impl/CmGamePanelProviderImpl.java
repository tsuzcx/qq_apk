package com.tencent.mobileqq.apollo.aio.panel.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.BaseChatPanelBarConfProcessor.C2CChatPanelBarConfProcessor;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.BaseChatPanelBarConfProcessor.GroupChatPanelBarConfProcessor;
import com.tencent.mobileqq.activity.aio.panel.chatpanelbar.config.ChatPanelBarConfBean;
import com.tencent.mobileqq.apollo.aio.panel.api.ICmGamePanelProvider;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.CmGameViewBinder;
import com.tencent.mobileqq.apollo.view.hippy.CMBattleGameFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;

public class CmGamePanelProviderImpl
  implements PanelProvider<View>, ICmGamePanelProvider
{
  private static final String TAG = "[cmshow]CmGamePanelProvider";
  private BaseChatPie chatPie;
  private View cmGamePanel;
  private CmGameViewBinder viewBinder;
  
  public View createPanel(Context paramContext)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("createPanel cmGamePanel is null=");
      boolean bool;
      if (this.cmGamePanel == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("[cmshow]CmGamePanelProvider", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.cmGamePanel;
    if (localObject != null) {
      return localObject;
    }
    this.viewBinder = new CmGameViewBinder(this.chatPie.i(), paramContext, this.chatPie.aE());
    this.cmGamePanel = this.viewBinder.i();
    return this.cmGamePanel;
  }
  
  public View getPanel()
  {
    return this.cmGamePanel;
  }
  
  public int getPanelId()
  {
    return 40;
  }
  
  public void init(Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]CmGamePanelProvider", 2, "init");
    }
    this.chatPie = ((BaseChatPie)paramObject);
    boolean bool1 = BaseChatPanelBarConfProcessor.C2CChatPanelBarConfProcessor.a().a();
    boolean bool2 = BaseChatPanelBarConfProcessor.GroupChatPanelBarConfProcessor.b().a();
    if ((bool1) || (bool2)) {
      CMBattleGameFragment.a(this.chatPie.d, this.chatPie.F());
    }
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel() {}
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    paramXPanelContainer.a(40);
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPanelIconClickBeforeCreate viewBinder=null:");
      boolean bool;
      if (this.viewBinder == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.d("[cmshow]CmGamePanelProvider", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.viewBinder;
    if (localObject != null) {
      ((CmGameViewBinder)localObject).d();
    }
  }
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.api.impl.CmGamePanelProviderImpl
 * JD-Core Version:    0.7.0.1
 */