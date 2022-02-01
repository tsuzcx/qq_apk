package com.tencent.biz.qqstory.msgTabNode.model;

import android.text.TextUtils;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.QQStoryObserver;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.msgTabNode.network.MsgTabCheckActiveRequest;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import mqq.manager.Manager;
import org.json.JSONException;
import org.json.JSONObject;

public class MsgTabStoryNodeConfigManager
  implements Manager
{
  public boolean a = false;
  public boolean b = false;
  public boolean c = true;
  public boolean d = false;
  public byte e = -1;
  public int f;
  QQAppInterface g;
  DPCObserver h = null;
  private boolean i = false;
  private boolean j = false;
  private boolean k = false;
  private boolean l = false;
  private MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig m;
  private final QQStoryObserver n = new MsgTabStoryNodeConfigManager.2(this);
  
  public MsgTabStoryNodeConfigManager(QQAppInterface paramQQAppInterface)
  {
    this.g = paramQQAppInterface;
    this.b = ((Boolean)((StoryConfigManager)SuperManager.a(10)).c("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    this.c = a();
    e();
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(this.h);
    paramQQAppInterface.addObserver(this.n);
    this.d = ((QQStoryManager)paramQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER)).i();
    b(false);
    paramQQAppInterface = StoryConfigManager.q();
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      this.m = b(paramQQAppInterface);
      paramQQAppInterface = this.m;
      if (paramQQAppInterface != null) {
        paramQQAppInterface.h = StoryConfigManager.r();
      }
    }
  }
  
  private MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      SLog.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig is null");
      return null;
    }
    for (;;)
    {
      try
      {
        MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig localMsgTabTakeVideoNodeConfig = new MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig();
        localObject = new JSONObject(paramString);
        localMsgTabTakeVideoNodeConfig.a = ((JSONObject)localObject).optLong("startTime", -1L);
        localMsgTabTakeVideoNodeConfig.b = ((JSONObject)localObject).optLong("endTime", -1L);
        localMsgTabTakeVideoNodeConfig.c = ((JSONObject)localObject).optString("imageUrl", "");
        localMsgTabTakeVideoNodeConfig.d = ((JSONObject)localObject).optString("desc", "");
        localMsgTabTakeVideoNodeConfig.e = ((JSONObject)localObject).optString("jumpUrl", "");
        localMsgTabTakeVideoNodeConfig.f = ((JSONObject)localObject).optString("contentId", "");
        int i1 = ((JSONObject)localObject).optInt("oneTimeUse", 0);
        bool = true;
        if (i1 == 1)
        {
          localMsgTabTakeVideoNodeConfig.g = bool;
          return localMsgTabTakeVideoNodeConfig;
        }
      }
      catch (JSONException localJSONException)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parseTakeVideoConfig config error config=");
        ((StringBuilder)localObject).append(paramString);
        SLog.c("Q.qqstory.config.takevideo", ((StringBuilder)localObject).toString(), localJSONException);
        return null;
      }
      boolean bool = false;
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update cfg svr=");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append(", dpc=");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", user=");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool2 = this.a;
    boolean bool1;
    if ((this.b) && (this.c) && (this.d)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.a = bool1;
    this.f = 52;
    Object localObject = this.g;
    if (localObject == null) {
      return;
    }
    if ((paramBoolean) && (bool2 != this.a))
    {
      ((TroopRedTouchHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).notifyUI(105, true, null);
      ((QQStoryHandler)this.g.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1020, true, Boolean.valueOf(this.a));
    }
  }
  
  private void d()
  {
    if ((this.b) && (this.c) && (this.e == 0) && (!this.l))
    {
      if (this.g == null) {
        return;
      }
      SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request!");
      this.l = true;
      Object localObject = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
      if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null)) {
        localObject = new MsgTabCheckActiveRequest(((SosoLbsInfo)localObject).mLocation.cityCode);
      } else {
        localObject = new MsgTabCheckActiveRequest(null);
      }
      QQStoryManager localQQStoryManager = (QQStoryManager)this.g.getManager(QQManagerFactory.QQSTORY_MANAGER);
      MsgTabStoryNodeConfigManager.1 local1 = new MsgTabStoryNodeConfigManager.1(this, (QQStoryHandler)this.g.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER), localQQStoryManager);
      long l1 = localQQStoryManager.j();
      long l2 = NetConnInfoCenter.getServerTime();
      if (l2 > l1)
      {
        CmdTaskManger.a().a((NetworkRequest)localObject, local1);
        SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request sent");
        return;
      }
      SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request not send, check next time! %d, %d", Long.valueOf(l2), Long.valueOf(l1));
    }
  }
  
  private void e()
  {
    if (this.h == null) {
      this.h = new MsgTabStoryNodeConfigManager.3(this);
    }
  }
  
  private void f()
  {
    if ((this.i) && (this.k) && (this.j)) {
      d();
    }
  }
  
  private void g()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      localObject = (QQStoryHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
      boolean bool;
      if ((this.b) && (this.c)) {
        bool = true;
      } else {
        bool = false;
      }
      ((QQStoryHandler)localObject).notifyUI(1022, true, Boolean.valueOf(bool));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.g;
    if (localObject == null) {
      return;
    }
    localObject = (QQStoryManager)((QQAppInterface)localObject).getManager(QQManagerFactory.QQSTORY_MANAGER);
    this.d = paramBoolean;
    ((QQStoryManager)localObject).i(paramBoolean);
    b(true);
  }
  
  public boolean a()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.StoryCfg.name(), "1");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMsgTabDPC:");
      ((StringBuilder)localObject).append(str);
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool3 = TextUtils.isEmpty(str);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!bool3)
    {
      localObject = new Integer[1];
      localObject[0] = Integer.valueOf(0);
      bool1 = bool2;
      if (((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser(str, (Integer[])localObject) >= 0)
      {
        if (localObject[0].intValue() == 1) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString)
  {
    MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig localMsgTabTakeVideoNodeConfig1 = b(paramString);
    if (localMsgTabTakeVideoNodeConfig1 != null)
    {
      if (TextUtils.isEmpty(localMsgTabTakeVideoNodeConfig1.f))
      {
        SLog.e("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig contentId is null", new Object[] { paramString });
        return false;
      }
      MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig localMsgTabTakeVideoNodeConfig2 = this.m;
      if ((localMsgTabTakeVideoNodeConfig2 != null) && (TextUtils.equals(localMsgTabTakeVideoNodeConfig2.f, localMsgTabTakeVideoNodeConfig1.f)))
      {
        SLog.d("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig same config ignore, config=%s", new Object[] { paramString });
        return false;
      }
      SLog.b("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig old config=%s, new config=%s", this.m, paramString);
      this.m = localMsgTabTakeVideoNodeConfig1;
      StoryConfigManager.e(false);
      StoryConfigManager.c(paramString);
      paramString = new MsgTabStoryNodeConfigManager.UpdateTakeVideoConfigEvent();
      StoryDispatcher.a().dispatch(paramString);
      return true;
    }
    return false;
  }
  
  public MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig b()
  {
    return this.m;
  }
  
  public void c()
  {
    this.m = null;
    StoryConfigManager.e(false);
    StoryConfigManager.c("");
    SLog.c("Q.qqstory.config.takevideo", "configManager.clearMsgTabTakeVideoConfig");
    MsgTabStoryNodeConfigManager.UpdateTakeVideoConfigEvent localUpdateTakeVideoConfigEvent = new MsgTabStoryNodeConfigManager.UpdateTakeVideoConfigEvent();
    StoryDispatcher.a().dispatch(localUpdateTakeVideoConfigEvent);
  }
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface = this.g;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.n);
    }
    ((IDPCApi)QRoute.api(IDPCApi.class)).removeObserver(this.h);
    this.h = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager
 * JD-Core Version:    0.7.0.1
 */