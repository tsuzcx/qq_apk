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
  public byte a;
  public int a;
  private final QQStoryObserver jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver = new MsgTabStoryNodeConfigManager.2(this);
  private MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  DPCObserver jdField_a_of_type_ComTencentMobileqqDpcDPCObserver = null;
  public boolean a;
  public boolean b;
  public boolean c = true;
  public boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  
  public MsgTabStoryNodeConfigManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Byte = -1;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_Boolean = ((Boolean)((StoryConfigManager)SuperManager.a(10)).b("key_story_msg_tab_show", Boolean.valueOf(false))).booleanValue();
    this.c = a();
    c();
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(this.jdField_a_of_type_ComTencentMobileqqDpcDPCObserver);
    paramQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    this.d = ((QQStoryManager)paramQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER)).f();
    b(false);
    paramQQAppInterface = StoryConfigManager.d();
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig = a(paramQQAppInterface);
      paramQQAppInterface = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig;
      if (paramQQAppInterface != null) {
        paramQQAppInterface.jdField_b_of_type_Boolean = StoryConfigManager.e();
      }
    }
  }
  
  private MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig a(String paramString)
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
        localMsgTabTakeVideoNodeConfig.jdField_a_of_type_Long = ((JSONObject)localObject).optLong("startTime", -1L);
        localMsgTabTakeVideoNodeConfig.jdField_b_of_type_Long = ((JSONObject)localObject).optLong("endTime", -1L);
        localMsgTabTakeVideoNodeConfig.jdField_a_of_type_JavaLangString = ((JSONObject)localObject).optString("imageUrl", "");
        localMsgTabTakeVideoNodeConfig.jdField_b_of_type_JavaLangString = ((JSONObject)localObject).optString("desc", "");
        localMsgTabTakeVideoNodeConfig.c = ((JSONObject)localObject).optString("jumpUrl", "");
        localMsgTabTakeVideoNodeConfig.d = ((JSONObject)localObject).optString("contentId", "");
        int i = ((JSONObject)localObject).optInt("oneTimeUse", 0);
        bool = true;
        if (i == 1)
        {
          localMsgTabTakeVideoNodeConfig.jdField_a_of_type_Boolean = bool;
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
  
  private void b()
  {
    if ((this.jdField_b_of_type_Boolean) && (this.c) && (this.jdField_a_of_type_Byte == 0) && (!this.h))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request!");
      this.h = true;
      Object localObject = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
      if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null)) {
        localObject = new MsgTabCheckActiveRequest(((SosoLbsInfo)localObject).mLocation.cityCode);
      } else {
        localObject = new MsgTabCheckActiveRequest(null);
      }
      QQStoryManager localQQStoryManager = (QQStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
      MsgTabStoryNodeConfigManager.1 local1 = new MsgTabStoryNodeConfigManager.1(this, (QQStoryHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER), localQQStoryManager);
      long l1 = localQQStoryManager.a();
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
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("update cfg svr=");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      ((StringBuilder)localObject).append(", dpc=");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(", user=");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool2 = this.jdField_a_of_type_Boolean;
    boolean bool1;
    if ((this.jdField_b_of_type_Boolean) && (this.c) && (this.d)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    this.jdField_a_of_type_Int = 52;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject == null) {
      return;
    }
    if ((paramBoolean) && (bool2 != this.jdField_a_of_type_Boolean))
    {
      ((TroopRedTouchHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).notifyUI(105, true, null);
      ((QQStoryHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1020, true, Boolean.valueOf(this.jdField_a_of_type_Boolean));
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDpcDPCObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqDpcDPCObserver = new MsgTabStoryNodeConfigManager.3(this);
    }
  }
  
  private void d()
  {
    if ((this.e) && (this.g) && (this.f)) {
      b();
    }
  }
  
  private void e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null)
    {
      localObject = (QQStoryHandler)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
      boolean bool;
      if ((this.jdField_b_of_type_Boolean) && (this.c)) {
        bool = true;
      } else {
        bool = false;
      }
      ((QQStoryHandler)localObject).notifyUI(1022, true, Boolean.valueOf(bool));
    }
  }
  
  public MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig = null;
    StoryConfigManager.e(false);
    StoryConfigManager.c("");
    SLog.c("Q.qqstory.config.takevideo", "configManager.clearMsgTabTakeVideoConfig");
    MsgTabStoryNodeConfigManager.UpdateTakeVideoConfigEvent localUpdateTakeVideoConfigEvent = new MsgTabStoryNodeConfigManager.UpdateTakeVideoConfigEvent();
    StoryDispatcher.a().dispatch(localUpdateTakeVideoConfigEvent);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
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
    MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig localMsgTabTakeVideoNodeConfig1 = a(paramString);
    if (localMsgTabTakeVideoNodeConfig1 != null)
    {
      if (TextUtils.isEmpty(localMsgTabTakeVideoNodeConfig1.d))
      {
        SLog.e("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig contentId is null", new Object[] { paramString });
        return false;
      }
      MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig localMsgTabTakeVideoNodeConfig2 = this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig;
      if ((localMsgTabTakeVideoNodeConfig2 != null) && (TextUtils.equals(localMsgTabTakeVideoNodeConfig2.d, localMsgTabTakeVideoNodeConfig1.d)))
      {
        SLog.d("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig same config ignore, config=%s", new Object[] { paramString });
        return false;
      }
      SLog.b("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig old config=%s, new config=%s", this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig, paramString);
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig = localMsgTabTakeVideoNodeConfig1;
      StoryConfigManager.e(false);
      StoryConfigManager.c(paramString);
      paramString = new MsgTabStoryNodeConfigManager.UpdateTakeVideoConfigEvent();
      StoryDispatcher.a().dispatch(paramString);
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    }
    ((IDPCApi)QRoute.api(IDPCApi.class)).removeObserver(this.jdField_a_of_type_ComTencentMobileqqDpcDPCObserver);
    this.jdField_a_of_type_ComTencentMobileqqDpcDPCObserver = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager
 * JD-Core Version:    0.7.0.1
 */