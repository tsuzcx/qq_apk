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
    paramQQAppInterface = StoryConfigManager.e();
    if (!TextUtils.isEmpty(paramQQAppInterface))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig = a(paramQQAppInterface);
      if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig.jdField_b_of_type_Boolean = StoryConfigManager.f();
      }
    }
  }
  
  private MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig a(String paramString)
  {
    boolean bool = true;
    if (TextUtils.isEmpty(paramString))
    {
      SLog.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig is null");
      return null;
    }
    try
    {
      MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig localMsgTabTakeVideoNodeConfig = new MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig();
      JSONObject localJSONObject = new JSONObject(paramString);
      localMsgTabTakeVideoNodeConfig.jdField_a_of_type_Long = localJSONObject.optLong("startTime", -1L);
      localMsgTabTakeVideoNodeConfig.jdField_b_of_type_Long = localJSONObject.optLong("endTime", -1L);
      localMsgTabTakeVideoNodeConfig.jdField_a_of_type_JavaLangString = localJSONObject.optString("imageUrl", "");
      localMsgTabTakeVideoNodeConfig.jdField_b_of_type_JavaLangString = localJSONObject.optString("desc", "");
      localMsgTabTakeVideoNodeConfig.c = localJSONObject.optString("jumpUrl", "");
      localMsgTabTakeVideoNodeConfig.d = localJSONObject.optString("contentId", "");
      if (localJSONObject.optInt("oneTimeUse", 0) == 1) {}
      for (;;)
      {
        localMsgTabTakeVideoNodeConfig.jdField_a_of_type_Boolean = bool;
        return localMsgTabTakeVideoNodeConfig;
        bool = false;
      }
      return null;
    }
    catch (JSONException localJSONException)
    {
      SLog.c("Q.qqstory.config.takevideo", "parseTakeVideoConfig config error config=" + paramString, localJSONException);
    }
  }
  
  private void b()
  {
    if ((!this.jdField_b_of_type_Boolean) || (!this.c) || (this.jdField_a_of_type_Byte != 0) || (this.h) || (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request!");
    this.h = true;
    Object localObject = ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).getSosoInfo();
    if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null)) {}
    long l1;
    long l2;
    for (localObject = new MsgTabCheckActiveRequest(((SosoLbsInfo)localObject).mLocation.cityCode);; localObject = new MsgTabCheckActiveRequest(null))
    {
      QQStoryManager localQQStoryManager = (QQStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
      MsgTabStoryNodeConfigManager.1 local1 = new MsgTabStoryNodeConfigManager.1(this, (QQStoryHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER), localQQStoryManager);
      l1 = localQQStoryManager.a();
      l2 = NetConnInfoCenter.getServerTime();
      if (l2 <= l1) {
        break;
      }
      CmdTaskManger.a().a((NetworkRequest)localObject, local1);
      SLog.b("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request sent");
      return;
    }
    SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", "startCheckActivity request not send, check next time! %d, %d", Long.valueOf(l2), Long.valueOf(l1));
  }
  
  private void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "update cfg svr=" + this.jdField_b_of_type_Boolean + ", dpc=" + this.c + ", user=" + this.d);
    }
    boolean bool2 = this.jdField_a_of_type_Boolean;
    boolean bool1;
    if ((this.jdField_b_of_type_Boolean) && (this.c) && (this.d))
    {
      bool1 = true;
      this.jdField_a_of_type_Boolean = bool1;
      this.jdField_a_of_type_Int = 52;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
        break label113;
      }
    }
    label113:
    while ((!paramBoolean) || (bool2 == this.jdField_a_of_type_Boolean))
    {
      return;
      bool1 = false;
      break;
    }
    ((TroopRedTouchHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER)).notifyUI(105, true, null);
    ((QQStoryHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).notifyUI(1020, true, Boolean.valueOf(this.jdField_a_of_type_Boolean));
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
    QQStoryHandler localQQStoryHandler;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      localQQStoryHandler = (QQStoryHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
      if ((!this.jdField_b_of_type_Boolean) || (!this.c)) {
        break label50;
      }
    }
    label50:
    for (boolean bool = true;; bool = false)
    {
      localQQStoryHandler.notifyUI(1022, true, Boolean.valueOf(bool));
      return;
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
    StoryConfigManager.f("");
    SLog.c("Q.qqstory.config.takevideo", "configManager.clearMsgTabTakeVideoConfig");
    MsgTabStoryNodeConfigManager.UpdateTakeVideoConfigEvent localUpdateTakeVideoConfigEvent = new MsgTabStoryNodeConfigManager.UpdateTakeVideoConfigEvent();
    StoryDispatcher.a().dispatch(localUpdateTakeVideoConfigEvent);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return;
    }
    QQStoryManager localQQStoryManager = (QQStoryManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QQSTORY_MANAGER);
    this.d = paramBoolean;
    localQQStoryManager.i(paramBoolean);
    b(true);
  }
  
  public boolean a()
  {
    String str = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.StoryCfg.name(), "1");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.msgTab.MsgTabStoryNodeConfigManager", 2, "getMsgTabDPC:" + str);
    }
    if (!TextUtils.isEmpty(str))
    {
      Integer[] arrayOfInteger = new Integer[1];
      arrayOfInteger[0] = Integer.valueOf(0);
      if (((IDPCApi)QRoute.api(IDPCApi.class)).parseComplexParamsByStringToIntParser(str, arrayOfInteger) >= 0) {
        return arrayOfInteger[0].intValue() == 1;
      }
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    MsgTabStoryNodeConfigManager.MsgTabTakeVideoNodeConfig localMsgTabTakeVideoNodeConfig = a(paramString);
    if (localMsgTabTakeVideoNodeConfig != null)
    {
      if (TextUtils.isEmpty(localMsgTabTakeVideoNodeConfig.d)) {
        SLog.e("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig contentId is null", new Object[] { paramString });
      }
    }
    else {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig.d, localMsgTabTakeVideoNodeConfig.d)))
    {
      SLog.d("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig same config ignore, config=%s", new Object[] { paramString });
      return false;
    }
    SLog.b("Q.qqstory.config.takevideo", "configManager.handleMsgTabTakeVideoConfig old config=%s, new config=%s", this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig, paramString);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager$MsgTabTakeVideoNodeConfig = localMsgTabTakeVideoNodeConfig;
    StoryConfigManager.e(false);
    StoryConfigManager.f(paramString);
    paramString = new MsgTabStoryNodeConfigManager.UpdateTakeVideoConfigEvent();
    StoryDispatcher.a().dispatch(paramString);
    return true;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryObserver);
    }
    ((IDPCApi)QRoute.api(IDPCApi.class)).removeObserver(this.jdField_a_of_type_ComTencentMobileqqDpcDPCObserver);
    this.jdField_a_of_type_ComTencentMobileqqDpcDPCObserver = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager
 * JD-Core Version:    0.7.0.1
 */