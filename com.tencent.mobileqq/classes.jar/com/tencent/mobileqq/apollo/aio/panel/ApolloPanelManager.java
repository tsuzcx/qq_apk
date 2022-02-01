package com.tencent.mobileqq.apollo.aio.panel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.text.Editable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.model.ApolloSlaveInfo;
import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XEditTextEx;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class ApolloPanelManager
{
  public volatile int a;
  public long a;
  public ApolloInfo a;
  public String a;
  private WeakReference<AppInterface> a;
  public ConcurrentHashMap<Long, ApolloSlaveInfo> a;
  public AtomicInteger a;
  public volatile boolean a;
  public int b;
  private ApolloInfo jdField_b_of_type_ComTencentMobileqqApolloModelApolloInfo = null;
  private WeakReference<BaseChatPie> jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean = false;
  private WeakReference<ApolloPanelManager.PanelClickCallback> c;
  
  public ApolloPanelManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
  }
  
  private void b(ApolloInfo paramApolloInfo)
  {
    if ((a() != null) && (this.jdField_b_of_type_JavaLangRefWeakReference.get() != null))
    {
      if (paramApolloInfo == null) {
        return;
      }
      Object localObject1 = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      Object localObject3 = ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a();
      ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo = paramApolloInfo;
      if (((SessionInfo)localObject3).jdField_a_of_type_Int == 3000) {
        i = 11;
      } else if (((SessionInfo)localObject3).jdField_a_of_type_Int == 1) {
        i = 3;
      } else {
        i = 0;
      }
      Object localObject2 = new Intent();
      ((Intent)localObject2).putExtra("troop_uin", ((SessionInfo)localObject3).jdField_a_of_type_JavaLangString);
      ((Intent)localObject2).putExtra("param_from", i);
      if (((BaseChatPie)localObject1).c() == 21) {
        ((Intent)localObject2).putExtra("param_troop_send_apollo_msg", true);
      }
      ((Intent)localObject2).putExtra("param_is_pop_up_style", true);
      ((Intent)localObject2).putExtra("param_troop_send_apollo_msg", true);
      RouteUtils.a(((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, (Intent)localObject2, "/troop/memberlist/TroopMemberList", 6001);
      localObject1 = ((BaseChatPie)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject2 = ((SessionInfo)localObject3).jdField_a_of_type_JavaLangString;
      int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(((SessionInfo)localObject3).jdField_a_of_type_Int);
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(paramApolloInfo.mAction.actionId);
      localObject3 = ((StringBuilder)localObject3).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("655_");
      localStringBuilder.append(paramApolloInfo.mPackageId);
      VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "g_action_double_clk", (String)localObject2, -1, i, new String[] { localObject3, localStringBuilder.toString(), "1", String.valueOf(System.currentTimeMillis() / 1000L) });
    }
  }
  
  public AppInterface a()
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference == null) {
      return null;
    }
    return (AppInterface)localWeakReference.get();
  }
  
  public void a()
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (ApolloPanelManager.PanelClickCallback)((WeakReference)localObject).get();
      if (localObject != null) {
        ((ApolloPanelManager.PanelClickCallback)localObject).a();
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = (ApolloPanelManager.PanelClickCallback)((WeakReference)localObject).get();
      if (localObject != null) {
        ((ApolloPanelManager.PanelClickCallback)localObject).a(paramInt, paramBoolean1, paramBoolean2);
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanelManager", 2, new Object[] { "[onGetSlaveListFromSvr], ret:", Long.valueOf(paramLong), "resqData:", paramString1, ",reqData:", paramString2 });
    }
    if (0L != paramLong) {
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        i = new JSONObject(paramString2).optInt("actionId");
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloPanelManager", 2, new Object[] { "actionId:", Integer.valueOf(i), ",orgActionId:" });
        }
        paramString2 = a().getCurrentAccountUin();
        paramString1 = new JSONObject(paramString1);
        this.jdField_a_of_type_JavaLangString = paramString1.toString();
        paramString1 = paramString1.getJSONObject("data");
        JSONArray localJSONArray = paramString1.getJSONArray("slaveInfoList");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          i = 0;
          if (i < localJSONArray.length())
          {
            ApolloSlaveInfo localApolloSlaveInfo = (ApolloSlaveInfo)JSONUtils.a(localJSONArray.getJSONObject(i), ApolloSlaveInfo.class);
            if (localApolloSlaveInfo == null) {
              break label342;
            }
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(localApolloSlaveInfo.uin), localApolloSlaveInfo);
            break label342;
          }
        }
        this.jdField_b_of_type_Int = paramString1.optInt("defaultActId");
        paramString1 = (ApolloSlaveInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(Long.parseLong(paramString2)));
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramString1.slaveTotal);
        if (paramString1.isCaptured != 1) {
          break label351;
        }
        bool = true;
        this.jdField_b_of_type_Boolean = bool;
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloPanelManager", 2, new Object[] { "my slave info", paramString1.toString() });
        }
        ThreadManager.getUIHandler().post(new ApolloPanelManager.2(this));
        return;
      }
      catch (Throwable paramString1)
      {
        QLog.e("[cmshow]ApolloPanelManager", 1, "[onGetSlaveListFromSvr], errInfo->", paramString1);
        return;
      }
      label342:
      i += 1;
      continue;
      label351:
      boolean bool = false;
    }
  }
  
  public void a(BaseAIOContext paramBaseAIOContext, ApolloInfo paramApolloInfo)
  {
    if ((paramBaseAIOContext instanceof AIOContext))
    {
      Object localObject2 = ((AIOContext)paramBaseAIOContext).a();
      if ((paramApolloInfo != null) && (localObject2 != null) && (((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (((BaseChatPie)localObject2).jdField_a_of_type_ComTencentWidgetXEditTextEx != null) && (((BaseChatPie)localObject2).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() != null))
      {
        a();
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloPanelManager", 2, new Object[] { "[sendActionMsg] mainInfo=", paramApolloInfo });
        }
        Object localObject1 = ((BaseChatPie)localObject2).a();
        paramApolloInfo.mAction.atNickName = "";
        paramApolloInfo.mAction.inputText = "";
        if (CmShowAioMatcherImpl.judgeSupported(((SessionInfo)localObject1).jdField_a_of_type_Int, 1))
        {
          paramApolloInfo.mAction.peerUin = ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString;
          paramApolloInfo.mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(((BaseChatPie)localObject2).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        }
        else if ((CmShowAioMatcherImpl.judgeSupported(((SessionInfo)localObject1).jdField_a_of_type_Int, 2)) && (((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
        {
          paramBaseAIOContext = new ArrayList();
          AtTroopMemberSpan.a(((BaseChatPie)localObject2).jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), paramBaseAIOContext);
          if (paramApolloInfo.mAction.personNum == 1)
          {
            Object localObject3;
            int i;
            if ((paramBaseAIOContext.size() == 1) && (0L != ((AtTroopMemberInfo)paramBaseAIOContext.get(0)).uin) && (((AtTroopMemberInfo)paramBaseAIOContext.get(0)).startPos == 0))
            {
              String str = com.tencent.mobileqq.text.TextUtils.emoticonToText(((BaseChatPie)localObject2).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
              try
              {
                paramApolloInfo.mAction.atNickName = str.substring(0, ((AtTroopMemberInfo)paramBaseAIOContext.get(0)).textLen);
                if (((AtTroopMemberInfo)paramBaseAIOContext.get(0)).textLen >= ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() - 1) {
                  paramApolloInfo.mAction.inputText = "";
                } else {
                  paramApolloInfo.mAction.inputText = str.substring(((AtTroopMemberInfo)paramBaseAIOContext.get(0)).textLen);
                }
              }
              catch (Exception localException)
              {
                if (QLog.isColorLevel())
                {
                  localObject4 = new StringBuilder();
                  ((StringBuilder)localObject4).append("inputText err:");
                  ((StringBuilder)localObject4).append(localException.getMessage());
                  QLog.d("[cmshow]ApolloPanelManager", 2, ((StringBuilder)localObject4).toString());
                }
                paramApolloInfo.mAction.inputText = "";
              }
              localObject3 = paramApolloInfo.mAction;
              Object localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append(((AtTroopMemberInfo)paramBaseAIOContext.get(0)).uin);
              ((StringBuilder)localObject4).append("");
              ((ApolloActionData)localObject3).peerUin = ((StringBuilder)localObject4).toString();
              ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
              if (android.text.TextUtils.isEmpty(paramApolloInfo.mAction.inputText))
              {
                if (!android.text.TextUtils.isEmpty(paramApolloInfo.mActionText))
                {
                  if (paramApolloInfo.mTextType == 0)
                  {
                    i = 6;
                    break label572;
                  }
                  if (paramApolloInfo.mTextType == 1)
                  {
                    i = 7;
                    break label572;
                  }
                }
                i = 2;
              }
              else if (android.text.TextUtils.isEmpty(paramApolloInfo.mActionText))
              {
                i = 3;
              }
              else if (paramApolloInfo.mTextType == 0)
              {
                i = 4;
              }
              else if (paramApolloInfo.mTextType == 1)
              {
                i = 5;
              }
              else
              {
                i = 0;
              }
              label572:
              localObject3 = ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject4 = ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString;
              int j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(((SessionInfo)localObject1).jdField_a_of_type_Int);
              paramBaseAIOContext = new StringBuilder();
              paramBaseAIOContext.append("");
              paramBaseAIOContext.append(paramApolloInfo.mAction.actionId);
              Object localObject5 = paramBaseAIOContext.toString();
              paramBaseAIOContext = new StringBuilder();
              paramBaseAIOContext.append("655_");
              paramBaseAIOContext.append(paramApolloInfo.mPackageId);
              Object localObject6 = paramBaseAIOContext.toString();
              paramBaseAIOContext = "0";
              VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "g_action_double_clk", (String)localObject4, -1, j, new String[] { localObject5, localObject6, "0", String.valueOf(System.currentTimeMillis() / 1000L) });
              localObject3 = ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject4 = ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString;
              j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(((SessionInfo)localObject1).jdField_a_of_type_Int);
              localObject5 = new StringBuilder();
              ((StringBuilder)localObject5).append("");
              ((StringBuilder)localObject5).append(paramApolloInfo.mAction.actionId);
              localObject5 = ((StringBuilder)localObject5).toString();
              localObject6 = new StringBuilder();
              ((StringBuilder)localObject6).append("655_");
              ((StringBuilder)localObject6).append(paramApolloInfo.mPackageId);
              localObject6 = ((StringBuilder)localObject6).toString();
              if (!android.text.TextUtils.isEmpty(paramApolloInfo.mActionText)) {
                paramBaseAIOContext = paramApolloInfo.mActionText;
              }
              VipUtils.a((AppInterface)localObject3, "cmshow", "Apollo", "g_action_double_sent", (String)localObject4, i, j, new String[] { localObject5, localObject6, paramBaseAIOContext, paramApolloInfo.mAction.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
            }
            else
            {
              if (paramApolloInfo.mAction.actionType == 5)
              {
                a(paramApolloInfo, (BaseChatPie)localObject2);
                return;
              }
              ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo = paramApolloInfo;
              if (((SessionInfo)localObject1).jdField_a_of_type_Int == 3000) {
                i = 11;
              } else if (((SessionInfo)localObject1).jdField_a_of_type_Int == 1) {
                i = 3;
              } else {
                i = 0;
              }
              paramBaseAIOContext = new Intent();
              paramBaseAIOContext.putExtra("troop_uin", ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString);
              paramBaseAIOContext.putExtra("param_from", i);
              if (((BaseChatPie)localObject2).c() == 21) {
                paramBaseAIOContext.putExtra("param_troop_send_apollo_msg", true);
              }
              paramBaseAIOContext.putExtra("param_is_pop_up_style", true);
              paramBaseAIOContext.putExtra("param_troop_send_apollo_msg", true);
              RouteUtils.a(((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramBaseAIOContext, "/troop/memberlist/TroopMemberList", 6001);
              paramBaseAIOContext = ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject2 = ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString;
              i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(((SessionInfo)localObject1).jdField_a_of_type_Int);
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("");
              ((StringBuilder)localObject1).append(paramApolloInfo.mAction.actionId);
              localObject1 = ((StringBuilder)localObject1).toString();
              localObject3 = new StringBuilder();
              ((StringBuilder)localObject3).append("655_");
              ((StringBuilder)localObject3).append(paramApolloInfo.mPackageId);
              VipUtils.a(paramBaseAIOContext, "cmshow", "Apollo", "g_action_double_clk", (String)localObject2, -1, i, new String[] { localObject1, ((StringBuilder)localObject3).toString(), "1", String.valueOf(System.currentTimeMillis() / 1000L) });
            }
          }
          else if (paramApolloInfo.mAction.personNum == 0)
          {
            paramApolloInfo.mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(((BaseChatPie)localObject2).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
            ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
          }
        }
        paramBaseAIOContext = ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
        if ((paramBaseAIOContext != null) && (paramBaseAIOContext.length() > 99))
        {
          ChatActivityUtils.a(((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131718759, 1);
          return;
        }
        if ((((SessionInfo)localObject1).jdField_a_of_type_Int != 1) && (((SessionInfo)localObject1).jdField_a_of_type_Int != 3000)) {
          ((BaseChatPie)localObject2).jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
        }
        if (((BaseChatPie)localObject2).jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) {
          ((BaseChatPie)localObject2).a(paramApolloInfo);
        }
        return;
      }
      return;
    }
    QLog.e("[cmshow]ApolloPanelManager", 1, "[sendActionMsg] error! param baseAIOContext is not instanceof AIOContext");
  }
  
  public void a(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo)
  {
    if (paramBaseChatPie != null)
    {
      if (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
        return;
      }
      this.jdField_b_of_type_ComTencentMobileqqApolloModelApolloInfo = paramApolloInfo;
      this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
      this.jdField_a_of_type_Boolean = true;
      ((ApolloExtensionHandler)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 262144, "get gold balance");
    }
  }
  
  public void a(ApolloPanelManager.PanelClickCallback paramPanelClickCallback)
  {
    this.c = new WeakReference(paramPanelClickCallback);
  }
  
  public void a(ApolloInfo paramApolloInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanelManager", 2, "[checkSlavesBeforeSend]");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloModelApolloInfo = paramApolloInfo;
    if ((System.currentTimeMillis() - this.jdField_a_of_type_Long <= 120000L) && (paramApolloInfo != null))
    {
      ThreadManager.getUIHandler().post(new ApolloPanelManager.1(this, paramApolloInfo));
      return;
    }
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("cmd", "apollo_terminal_info.get_user_slaves_v2");
        localJSONObject.put("from", "android");
        if ((paramApolloInfo != null) && (paramApolloInfo.mAction != null))
        {
          paramApolloInfo = Integer.valueOf(paramApolloInfo.mAction.actionId);
          localJSONObject.put("actionId", paramApolloInfo);
          paramApolloInfo = new JSONArray();
          paramApolloInfo.put(Long.parseLong(a().getCurrentAccountUin()));
          localJSONObject.put("toUins", paramApolloInfo);
          ((ApolloExtensionHandler)a().getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).b("apollo_terminal_info.get_user_slaves_v2", localJSONObject.toString(), 7);
          return;
        }
      }
      catch (Throwable paramApolloInfo)
      {
        QLog.e("[cmshow]ApolloPanelManager", 1, "[checkSlavesBeforeSend], errInfo->", paramApolloInfo);
        return;
      }
      paramApolloInfo = null;
    }
  }
  
  public void a(ApolloInfo paramApolloInfo, BaseChatPie paramBaseChatPie)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    a(paramApolloInfo);
  }
  
  public void b()
  {
    WeakReference localWeakReference = this.c;
    if (localWeakReference != null)
    {
      localWeakReference.clear();
      this.c = null;
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo)
  {
    if ((paramBaseChatPie != null) && (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      if (paramBaseChatPie.a() == null) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow]ApolloPanelManager", 2, new Object[] { "[previewNewAction] apolloInfo=", paramApolloInfo });
      }
      SessionInfo localSessionInfo = paramBaseChatPie.a();
      ApolloActionData localApolloActionData = paramApolloInfo.mAction;
      SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
      localSpriteTaskParam.f = localApolloActionData.actionId;
      localSpriteTaskParam.jdField_c_of_type_Int = 0;
      localSpriteTaskParam.h = localSessionInfo.jdField_a_of_type_Int;
      localSpriteTaskParam.g = 3;
      localSpriteTaskParam.jdField_a_of_type_Long = -10000L;
      localSpriteTaskParam.i = 0;
      localSpriteTaskParam.jdField_a_of_type_Float = 0.0F;
      boolean bool;
      if (paramApolloInfo.mTextType == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localSpriteTaskParam.jdField_b_of_type_Boolean = bool;
      localSpriteTaskParam.jdField_c_of_type_JavaLangString = paramApolloInfo.mActionText;
      localSpriteTaskParam.e = localApolloActionData.personNum;
      paramApolloInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = String.valueOf(paramApolloInfo);
      if (CmShowAioMatcherImpl.judgeSupported(localSessionInfo.jdField_a_of_type_Int, 1))
      {
        localSpriteTaskParam.jdField_b_of_type_JavaLangString = localSessionInfo.jdField_a_of_type_JavaLangString;
      }
      else if (localSpriteTaskParam.e != 0)
      {
        paramApolloInfo = ((FriendsManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramApolloInfo);
        int i;
        if ((paramApolloInfo != null) && (paramApolloInfo.gender != 1)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0) {
          paramApolloInfo = "-2";
        } else {
          paramApolloInfo = "-1";
        }
        localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramApolloInfo;
      }
      if (localApolloActionData.actionType == 5)
      {
        localSpriteTaskParam.jdField_c_of_type_Int = 5;
        paramApolloInfo = (ApolloManagerServiceImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        if ((paramApolloInfo != null) && (paramApolloInfo.getApolloPanelManager() != null))
        {
          localSpriteTaskParam.d = paramApolloInfo.getApolloPanelManager().jdField_a_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("[cmshow]ApolloPanelManager", 2, new Object[] { "[previewNewAction] mSlaveExtJson=", localSpriteTaskParam.d });
          }
        }
      }
      paramApolloInfo = (ISpriteScriptManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
      if (paramApolloInfo != null) {
        paramApolloInfo.getSpriteBridge().b(localSpriteTaskParam);
      }
      VipUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_preview_play", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(localApolloActionData.actionId) });
    }
  }
  
  public void c()
  {
    Object localObject1 = this.jdField_b_of_type_JavaLangRefWeakReference;
    if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
    {
      if (this.jdField_b_of_type_ComTencentMobileqqApolloModelApolloInfo == null) {
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      Object localObject2 = localBaseChatPie.a();
      ApolloActionData localApolloActionData = this.jdField_b_of_type_ComTencentMobileqqApolloModelApolloInfo.mAction;
      int i = this.jdField_a_of_type_Int;
      if (localApolloActionData.currencyType == 1)
      {
        HashMap localHashMap = new HashMap();
        int j = this.jdField_a_of_type_Int;
        String str1;
        String str2;
        String str3;
        if (localApolloActionData.currencyNum <= i)
        {
          str1 = HardCodeUtil.a(2131700696);
          str2 = String.format(localBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690045), new Object[] { Integer.valueOf(localApolloActionData.currencyNum), Integer.valueOf(j) });
          str3 = HardCodeUtil.a(2131700701);
          if (localObject2 != null)
          {
            localObject1 = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(((SessionInfo)localObject2).jdField_a_of_type_Int);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(localApolloActionData.actionId);
            VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "icon_alert_show", i, 0, new String[] { ((StringBuilder)localObject2).toString() });
          }
          localObject1 = "requestSSO";
        }
        else
        {
          str1 = HardCodeUtil.a(2131700693);
          str2 = String.format(localBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131690044), new Object[] { Integer.valueOf(localApolloActionData.currencyNum), Integer.valueOf(j) });
          str3 = HardCodeUtil.a(2131700699);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(ApolloConstant.r);
          ((StringBuilder)localObject1).append("&adtag=authGold");
          localObject1 = ((StringBuilder)localObject1).toString();
          if (localObject2 != null)
          {
            QQAppInterface localQQAppInterface = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
            i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(((SessionInfo)localObject2).jdField_a_of_type_Int);
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("");
            ((StringBuilder)localObject2).append(localApolloActionData.actionId);
            VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "debt_alert_show", i, 0, new String[] { ((StringBuilder)localObject2).toString() });
          }
        }
        localHashMap.put("APOLLO_POP_TYPE", "dialog");
        localHashMap.put("feeType", String.valueOf(localApolloActionData.feeType));
        localHashMap.put("title", str1);
        localHashMap.put("content", str2);
        localHashMap.put("rightString", str3);
        localHashMap.put("url", localObject1);
        localHashMap.put("actionId", String.valueOf(localApolloActionData.actionId));
        localObject1 = new JSONObject();
        try
        {
          ((JSONObject)localObject1).put("packageId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloModelApolloInfo.mPackageId));
        }
        catch (Exception localException)
        {
          QLog.e("[cmshow]ApolloPanelManager", 1, "[authGoldAction] Exception:", localException);
        }
        localHashMap.put("extendJson", ((JSONObject)localObject1).toString());
        localObject1 = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject1 != null)
        {
          localObject1 = ((MqqHandler)localObject1).obtainMessage(45);
          ((Message)localObject1).obj = localHashMap;
          ((Message)localObject1).sendToTarget();
        }
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    this.jdField_a_of_type_JavaLangString = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelManager
 * JD-Core Version:    0.7.0.1
 */