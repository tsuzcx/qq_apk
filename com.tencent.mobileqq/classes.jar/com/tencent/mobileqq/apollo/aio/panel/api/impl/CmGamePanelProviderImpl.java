package com.tencent.mobileqq.apollo.aio.panel.api.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.aio.panel.api.ICmGamePanelProvider;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.widget.XPanelContainer;

public class CmGamePanelProviderImpl
  implements PanelProvider<View>, ICmGamePanelProvider
{
  private static final String TAG = "[cmshow]CmGamePanelProvider";
  private BaseChatPie chatPie;
  private View cmGamePanel;
  private ApolloExtensionObserver mApolloBattleGameObserver = new CmGamePanelProviderImpl.2(this);
  private ApolloBattleGameViewBinder mApolloBattleGameViewBinder;
  private int mSceneId;
  
  public View createPanel(Context paramContext)
  {
    this.mApolloBattleGameViewBinder = new ApolloBattleGameViewBinder(this.chatPie.a(), paramContext, this.chatPie.a());
    this.cmGamePanel = this.mApolloBattleGameViewBinder.c();
    if (CmShowAioMatcherImpl.judgeSupported(this.chatPie.b(), 1)) {
      this.mSceneId = 4018;
    } else if (CmShowAioMatcherImpl.judgeSupported(this.chatPie.b(), 2)) {
      this.mSceneId = 4019;
    } else {
      this.mSceneId = -1;
    }
    this.mApolloBattleGameViewBinder.a(true);
    this.chatPie.a.addObserver(this.mApolloBattleGameObserver);
    ThreadManagerV2.executeOnSubThread(new CmGamePanelProviderImpl.1(this));
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
    this.chatPie = ((BaseChatPie)paramObject);
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel()
  {
    this.chatPie.a.removeObserver(this.mApolloBattleGameObserver);
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    paramXPanelContainer.a(40);
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.api.impl.CmGamePanelProviderImpl
 * JD-Core Version:    0.7.0.1
 */