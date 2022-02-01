package com.tencent.mobileqq.apollo.api.aio.panel.impl;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.aio.panel.ICmGamePanelProvider;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionObserverImpl;
import com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloBattleGameViewBinder;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.widget.XPanelContainer;

public class CmGamePanelProviderImpl
  implements ICmGamePanelProvider
{
  private static final String TAG = "CmGamePanelProvider";
  private BaseChatPie chatPie;
  private View cmGamePanel;
  private ApolloExtensionObserverImpl mApolloBattleGameObserver = new CmGamePanelProviderImpl.2(this);
  private ApolloBattleGameViewBinder mApolloBattleGameViewBinder;
  private int mSceneId;
  
  public View createPanel(Context paramContext)
  {
    this.mApolloBattleGameViewBinder = new ApolloBattleGameViewBinder(this.chatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.chatPie.jdField_a_of_type_AndroidContentContext, this.chatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
    this.cmGamePanel = this.mApolloBattleGameViewBinder.c();
    if (CmShowAioMatcher.a(this.chatPie.b(), 1)) {
      this.mSceneId = 4018;
    }
    for (;;)
    {
      this.mApolloBattleGameViewBinder.a(true);
      this.chatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.mApolloBattleGameObserver);
      ThreadManagerV2.executeOnSubThread(new CmGamePanelProviderImpl.1(this));
      return this.cmGamePanel;
      if (CmShowAioMatcher.a(this.chatPie.b(), 2)) {
        this.mSceneId = 4019;
      } else {
        this.mSceneId = -1;
      }
    }
  }
  
  public View getPanel()
  {
    return this.cmGamePanel;
  }
  
  public int getPanelId()
  {
    return 40;
  }
  
  public void init(BaseChatPie paramBaseChatPie)
  {
    this.chatPie = paramBaseChatPie;
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onHideAllPanel()
  {
    this.chatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.mApolloBattleGameObserver);
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2) {}
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    paramXPanelContainer.a(getPanelId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.panel.impl.CmGamePanelProviderImpl
 * JD-Core Version:    0.7.0.1
 */