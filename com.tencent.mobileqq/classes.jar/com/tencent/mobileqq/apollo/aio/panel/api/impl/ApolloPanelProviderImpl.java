package com.tencent.mobileqq.apollo.aio.panel.api.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.helper.CoreHelperProvider;
import com.tencent.mobileqq.activity.aio.helper.OnActivityResultCallback;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.activity.aio.panel.PanelManager;
import com.tencent.mobileqq.activity.aio.panel.PanelProvider;
import com.tencent.mobileqq.apollo.aio.api.IApolloAIOHelper;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanel;
import com.tencent.mobileqq.apollo.aio.panel.ApolloPanelManager;
import com.tencent.mobileqq.apollo.aio.panel.api.IApolloPanelProvider;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.script.ISpriteActionScript;
import com.tencent.mobileqq.apollo.script.api.ISpriteUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.view.hippy.CmGameApiProvider;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class ApolloPanelProviderImpl
  implements Handler.Callback, OnActivityResultCallback, PanelProvider<ApolloPanel>, IApolloPanelProvider
{
  private static final String TAG = "[cmshow]ApolloPanelProviderImpl";
  private ApolloPanel mApolloPanel;
  private int mApolloPanelStatus = -1;
  private BaseChatPie mChatPie;
  private int mJumpActionId = -1;
  private long mLastScreenHeight;
  private long mLastScreenWidth;
  private int mPkgId = -1;
  
  private boolean handleApolloPanelMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 44)
    {
      Object localObject;
      if (i != 45)
      {
        if (i != 49)
        {
          if (i != 66)
          {
            if (i != 76) {
              return false;
            }
            paramMessage = this.mApolloPanel;
            if (paramMessage != null)
            {
              paramMessage.j();
              return true;
            }
          }
          else if (this.mApolloPanel != null)
          {
            localObject = (ApolloInfo)paramMessage.obj;
            if (paramMessage.arg1 == 1)
            {
              this.mApolloPanel.b();
              return true;
            }
            this.mApolloPanel.a((ApolloInfo)localObject);
            return true;
          }
        }
        else
        {
          showApolloPanel();
          return true;
        }
      }
      else if (this.mApolloPanel != null)
      {
        paramMessage = (HashMap)paramMessage.obj;
        if (paramMessage != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("");
          ((StringBuilder)localObject).append(AIOUtils.a(this.mChatPie.aX()));
          paramMessage.put("offset", ((StringBuilder)localObject).toString());
          this.mApolloPanel.a(paramMessage);
          return true;
        }
      }
    }
    else
    {
      paramMessage = this.mApolloPanel;
      if (paramMessage != null) {
        paramMessage.a();
      }
    }
    return true;
  }
  
  private void updateApolloPanel(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 21) || (paramInt2 == 21))
    {
      ApolloPanel localApolloPanel = this.mApolloPanel;
      if (localApolloPanel != null) {
        localApolloPanel.a(paramInt1, paramInt2, localApolloPanel);
      }
    }
  }
  
  public HippyAPIProvider createHippyProvider()
  {
    return new CmGameApiProvider();
  }
  
  public ApolloPanel createPanel(Context paramContext)
  {
    this.mApolloPanel = new ApolloPanel(paramContext);
    paramContext = this.mApolloPanel;
    BaseChatPie localBaseChatPie = this.mChatPie;
    paramContext.a(localBaseChatPie, localBaseChatPie.ah, this.mJumpActionId, this.mPkgId, this.mApolloPanelStatus);
    StartupTracker.a("apollo_panel_open", null);
    return this.mApolloPanel;
  }
  
  void doOnDestroy()
  {
    ApolloPanel localApolloPanel = this.mApolloPanel;
    if (localApolloPanel != null) {
      localApolloPanel.f();
    }
    this.mApolloPanelStatus = -1;
  }
  
  void doOnShow()
  {
    showQuickApolloSendPanel();
  }
  
  public ApolloPanel getPanel()
  {
    return this.mApolloPanel;
  }
  
  public int getPanelId()
  {
    return 21;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return handleApolloPanelMessage(paramMessage);
  }
  
  public void init(Object paramObject)
  {
    if ((paramObject instanceof BaseChatPie))
    {
      this.mChatPie = ((BaseChatPie)paramObject);
      paramObject = this.mChatPie.bv().d();
      if (paramObject != null)
      {
        paramObject.a(this);
        paramObject.a(this);
      }
      else
      {
        QLog.e("[cmshow]ApolloPanelProviderImpl", 2, "[init] error! helperProvider is null!");
      }
      this.mLastScreenWidth = DeviceInfoUtil.D();
      this.mLastScreenHeight = DeviceInfoUtil.E();
    }
  }
  
  public boolean isCMModule(String paramString)
  {
    return "minigameEntry".equals(paramString);
  }
  
  public boolean isNeedRecreatePanel()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    paramIntent = this.mChatPie.i();
    if (paramInt1 == 14007)
    {
      if (paramIntent != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloPanel", 2, "isActionBack");
        }
        ((IApolloExtensionHandler)paramIntent.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramIntent.getCurrentAccountUin(), 128L, "apolloPanel");
      }
    }
    else if ((paramInt1 == 14003) && (paramIntent != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloPanel", 2, "check slave");
      }
      ((ApolloManagerServiceImpl)paramIntent.getRuntimeService(IApolloManagerService.class, "all")).getApolloPanelManager().a(null);
    }
  }
  
  public void onHideAllPanel() {}
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 10)
    {
      if (paramInt != 15)
      {
        if (paramInt != 19) {
          return;
        }
        paramInt = 1;
        long l1 = DeviceInfoUtil.a(true);
        long l2 = this.mLastScreenWidth;
        if ((l2 != l1) && (l2 != this.mLastScreenHeight)) {
          QLog.d("[cmshow]ApolloPanelProviderImpl", 1, new Object[] { "[doOnConfigurationChanged] screenWidth:", Long.valueOf(l1), ",mLastScreenWidth:", Long.valueOf(this.mLastScreenWidth), ",mLastScreenHeight:", Long.valueOf(this.mLastScreenHeight) });
        } else {
          paramInt = 0;
        }
        this.mLastScreenWidth = l1;
        this.mLastScreenHeight = DeviceInfoUtil.E();
        if (paramInt != 0)
        {
          Object localObject = (ISpriteUtil)QRoute.api(ISpriteUtil.class);
          ISpriteActionScript localISpriteActionScript = ((ISpriteUtil)localObject).getActionScript(this.mChatPie.i());
          if (localISpriteActionScript != null) {
            localISpriteActionScript.a(this.mLastScreenWidth, this.mLastScreenHeight, ((ISpriteUtil)localObject).getAIOSurfaceInitWidth(), ((ISpriteUtil)localObject).getAIOSurfaceInitHeight());
          }
          localObject = this.mApolloPanel;
          if (localObject != null) {
            ((ApolloPanel)localObject).a(this.mChatPie.i().getCurrentAccountUin());
          }
        }
      }
      else
      {
        doOnDestroy();
      }
    }
    else {
      doOnShow();
    }
  }
  
  public void onPanelChanged(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 21) {
      StartupTracker.a(null, "apollo_panel_open");
    }
    ThreadManager.getUIHandler().post(new ApolloPanelProviderImpl.1(this, paramInt1, paramInt2));
  }
  
  public void onPanelIconClick(XPanelContainer paramXPanelContainer)
  {
    paramXPanelContainer.a(21);
    paramXPanelContainer = this.mChatPie.i();
    Object localObject = (IApolloManagerService)paramXPanelContainer.getRuntimeService(IApolloManagerService.class, "all");
    if ((((IApolloManagerService)localObject).getApolloStatus(paramXPanelContainer.getCurrentUin()) == 0) || (((IApolloManagerService)localObject).getApolloStatus(paramXPanelContainer.getCurrentUin()) == 2))
    {
      int i = ((IApolloManagerService)localObject).getApolloStatus(paramXPanelContainer.getCurrentUin());
      int j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportUserResult(((IApolloManagerService)localObject).getApolloUserStatus());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessionType(this.mChatPie.F()));
      VipUtils.a(paramXPanelContainer, "cmshow", "Apollo", "panel_close_show", i, j, new String[] { ((StringBuilder)localObject).toString() });
    }
  }
  
  public void onPanelIconClickBeforeCreate(int paramInt) {}
  
  public void postOnPanelChanged(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 21)
    {
      int i = this.mChatPie.ah.a;
      paramInt2 = 0;
      paramInt1 = paramInt2;
      if (i == 1)
      {
        HotChatManager localHotChatManager = (HotChatManager)this.mChatPie.d.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
        paramInt1 = paramInt2;
        if (localHotChatManager != null)
        {
          paramInt1 = paramInt2;
          if (localHotChatManager.b(this.mChatPie.ah.b)) {
            paramInt1 = 1;
          }
        }
      }
      if (paramInt1 != 0)
      {
        this.mChatPie.W.setSelected(21);
        return;
      }
      this.mChatPie.W.setSelected(8);
    }
  }
  
  public void showApolloPanel()
  {
    PanelManager localPanelManager = this.mChatPie.bq();
    if (localPanelManager != null) {
      localPanelManager.e(21);
    }
  }
  
  public void showApolloStatusPanel(int paramInt)
  {
    if (paramInt == 0) {
      paramInt = ((IApolloManagerService)this.mChatPie.d.getRuntimeService(IApolloManagerService.class, "all")).getApolloStatus(this.mChatPie.d.getCurrentUin());
    } else {
      paramInt = -1;
    }
    ApolloPanel localApolloPanel = this.mApolloPanel;
    if (localApolloPanel != null) {
      localApolloPanel.a(paramInt);
    }
    this.mApolloPanelStatus = paramInt;
    showApolloPanel();
  }
  
  public boolean showQuickApolloSendPanel()
  {
    Object localObject = (IApolloAIOHelper)this.mChatPie.q(8);
    if ((localObject != null) && (((IApolloAIOHelper)localObject).isApolloForward()))
    {
      localObject = this.mChatPie.aX().getIntent();
      int i;
      if (((Intent)localObject).hasExtra("apollo_actionid_key"))
      {
        i = ((Intent)localObject).getExtras().getInt("apollo_actionid_key");
        ((Intent)localObject).removeExtra("apollo_actionid_key");
      }
      else
      {
        i = -1;
      }
      int j;
      if (((Intent)localObject).hasExtra("apollo_pkgid_key"))
      {
        j = ((Intent)localObject).getExtras().getInt("apollo_pkgid_key");
        ((Intent)localObject).removeExtra("apollo_pkgid_key");
      }
      else
      {
        j = -1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanelProviderImpl", 2, new Object[] { "showQuickApolloSendPanel, pkgId=", Integer.valueOf(j), ", actionId=", Integer.valueOf(i) });
      }
      localObject = this.mApolloPanel;
      if (localObject != null)
      {
        ((ApolloPanel)localObject).b(j, i);
      }
      else
      {
        this.mJumpActionId = i;
        this.mPkgId = j;
      }
      showApolloPanel();
      this.mJumpActionId = -1;
      this.mPkgId = -1;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.api.impl.ApolloPanelProviderImpl
 * JD-Core Version:    0.7.0.1
 */