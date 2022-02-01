package com.tencent.mobileqq.apollo;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.aio.CmShowAioMatcher;
import com.tencent.mobileqq.apollo.api.channel.IRequestHandler;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloExtensionHandlerImpl;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.apollo.api.model.ApolloInfo;
import com.tencent.mobileqq.apollo.api.model.ApolloSlaveInfo;
import com.tencent.mobileqq.apollo.api.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
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
  private IRequestHandler jdField_a_of_type_ComTencentMobileqqApolloApiChannelIRequestHandler;
  public ApolloInfo a;
  public String a;
  private WeakReference<QQAppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  public ConcurrentHashMap<Long, ApolloSlaveInfo> a;
  public AtomicInteger a;
  public volatile boolean a;
  public int b;
  private ApolloInfo jdField_b_of_type_ComTencentMobileqqApolloApiModelApolloInfo = null;
  private WeakReference<BaseChatPie> jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean = false;
  private WeakReference<ApolloPanelManager.PanelClickCallback> c;
  
  public ApolloPanelManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloApiChannelIRequestHandler = new ApolloPanelManager.1(this);
    ApolloUtilImpl.getCmdChannel().addCmdHandler(this.jdField_a_of_type_ComTencentMobileqqApolloApiChannelIRequestHandler);
  }
  
  private void b(ApolloInfo paramApolloInfo)
  {
    if ((a() == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) || (paramApolloInfo == null)) {
      return;
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    SessionInfo localSessionInfo = ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a();
    localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo = paramApolloInfo;
    int i;
    if (localSessionInfo.jdField_a_of_type_Int == 3000) {
      i = 11;
    }
    for (;;)
    {
      Intent localIntent = TroopMemberListActivity.a(localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localSessionInfo.jdField_a_of_type_JavaLangString, i);
      if (localBaseChatPie.g() == 21) {
        localIntent.putExtra("param_troop_send_apollo_msg", true);
      }
      localIntent.putExtra("param_is_pop_up_style", true);
      localIntent.putExtra("param_troop_send_apollo_msg", true);
      localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 6001);
      VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.jdField_a_of_type_JavaLangString, -1, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localSessionInfo.jdField_a_of_type_Int), new String[] { "" + paramApolloInfo.mAction.actionId, "655_" + paramApolloInfo.mPackageId, "1", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
      if (localSessionInfo.jdField_a_of_type_Int == 1) {
        i = 3;
      } else {
        i = 0;
      }
    }
  }
  
  public QQAppInterface a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {
      return null;
    }
    return (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
  }
  
  public String a()
  {
    Object localObject = a();
    if (localObject == null) {
      return null;
    }
    String str = ((QQAppInterface)localObject).getCurrentUin();
    SharedPreferences localSharedPreferences = ((QQAppInterface)localObject).getApp().getSharedPreferences("apollo_sp" + str, 0);
    switch (((IApolloManagerService)((QQAppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all")).getCmShowStatus((QQAppInterface)localObject, str))
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      return localObject;
      localObject = localSharedPreferences.getString("sp_key_apollo_current_page_package_id_3d", String.valueOf(300));
      continue;
      localObject = localSharedPreferences.getString("sp_key_apollo_current_page_package_id_2d", String.valueOf(0));
    }
  }
  
  public void a()
  {
    if (this.c != null)
    {
      ApolloPanelManager.PanelClickCallback localPanelClickCallback = (ApolloPanelManager.PanelClickCallback)this.c.get();
      if (localPanelClickCallback != null) {
        localPanelClickCallback.a();
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.c != null)
    {
      ApolloPanelManager.PanelClickCallback localPanelClickCallback = (ApolloPanelManager.PanelClickCallback)this.c.get();
      if (localPanelClickCallback != null) {
        localPanelClickCallback.a(paramInt, paramBoolean1, paramBoolean2);
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2)
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, new Object[] { "[onGetSlaveListFromSvr], ret:", Long.valueOf(paramLong), "resqData:", paramString1, ",reqData:", paramString2 });
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
          QLog.d("Apollo_PanelManager", 2, new Object[] { "actionId:", Integer.valueOf(i), ",orgActionId:" });
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
              break label353;
            }
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(localApolloSlaveInfo.uin), localApolloSlaveInfo);
            break label353;
          }
        }
        this.jdField_b_of_type_Int = paramString1.optInt("defaultActId");
        paramString1 = (ApolloSlaveInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Long.valueOf(Long.parseLong(paramString2)));
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.set(paramString1.slaveTotal);
        if (paramString1.isCaptured == 1) {
          bool = true;
        }
        this.jdField_b_of_type_Boolean = bool;
        if (QLog.isColorLevel()) {
          QLog.d("Apollo_PanelManager", 2, new Object[] { "my slave info", paramString1.toString() });
        }
        ThreadManager.getUIHandler().post(new ApolloPanelManager.3(this));
        return;
      }
      catch (Throwable paramString1)
      {
        QLog.e("Apollo_PanelManager", 1, "[onGetSlaveListFromSvr], errInfo->", paramString1);
        return;
      }
      label353:
      i += 1;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqApolloApiModelApolloInfo = paramApolloInfo;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_Boolean = true;
    ((ApolloExtensionHandlerImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), 262144, "get gold balance");
  }
  
  public void a(ApolloPanelManager.PanelClickCallback paramPanelClickCallback)
  {
    this.c = new WeakReference(paramPanelClickCallback);
  }
  
  public void a(ApolloInfo paramApolloInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, "[checkSlavesBeforeSend]");
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo = paramApolloInfo;
    if ((System.currentTimeMillis() - this.jdField_a_of_type_Long <= 120000L) && (paramApolloInfo != null))
    {
      ThreadManager.getUIHandler().post(new ApolloPanelManager.2(this, paramApolloInfo));
      return;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("cmd", "apollo_terminal_info.get_user_slaves_v2");
        localJSONObject.put("from", "android");
        if (paramApolloInfo == null) {
          break label200;
        }
        if (paramApolloInfo.mAction != null) {
          break label184;
        }
      }
      catch (Throwable paramApolloInfo)
      {
        JSONObject localJSONObject;
        QLog.e("Apollo_PanelManager", 1, "[checkSlavesBeforeSend], errInfo->", paramApolloInfo);
        return;
      }
      localJSONObject.put("actionId", paramApolloInfo);
      paramApolloInfo = new JSONArray();
      paramApolloInfo.put(Long.parseLong(a().getCurrentAccountUin()));
      localJSONObject.put("toUins", paramApolloInfo);
      ((ApolloExtensionHandlerImpl)a().getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).a("apollo_terminal_info.get_user_slaves_v2", localJSONObject.toString(), -1L, 7);
      return;
      label184:
      int i = paramApolloInfo.mAction.actionId;
      paramApolloInfo = Integer.valueOf(i);
      continue;
      label200:
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
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
    }
  }
  
  public void b(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo)
  {
    if ((paramApolloInfo == null) || (paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null)) {
      return;
    }
    a();
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, new Object[] { "[sendActionMsg] mainInfo=", paramApolloInfo });
    }
    SessionInfo localSessionInfo = paramBaseChatPie.a();
    paramApolloInfo.mAction.atNickName = "";
    paramApolloInfo.mAction.inputText = "";
    if (CmShowAioMatcher.a(localSessionInfo.jdField_a_of_type_Int, 1))
    {
      paramApolloInfo.mAction.peerUin = localSessionInfo.jdField_a_of_type_JavaLangString;
      paramApolloInfo.mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    }
    label132:
    while ((!CmShowAioMatcher.a(localSessionInfo.jdField_a_of_type_Int, 2)) || (paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null))
    {
      localObject1 = paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      if ((localObject1 == null) || (((String)localObject1).length() <= 99)) {
        break;
      }
      ChatActivityUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131719043, 1);
      return;
    }
    Object localObject1 = new ArrayList();
    AtTroopMemberSpan.a(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject1);
    Object localObject2;
    if (paramApolloInfo.mAction.personNum == 1) {
      if ((((ArrayList)localObject1).size() == 1) && (0L != ((AtTroopMemberInfo)((ArrayList)localObject1).get(0)).uin) && (((AtTroopMemberInfo)((ArrayList)localObject1).get(0)).startPos == 0)) {
        localObject2 = com.tencent.mobileqq.text.TextUtils.emoticonToText(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      }
    }
    label1172:
    for (;;)
    {
      try
      {
        paramApolloInfo.mAction.atNickName = ((String)localObject2).substring(0, ((AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen);
        if (((AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen >= paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() - 1)
        {
          paramApolloInfo.mAction.inputText = "";
          paramApolloInfo.mAction.peerUin = (((AtTroopMemberInfo)((ArrayList)localObject1).get(0)).uin + "");
          paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
          i = 0;
          if (!android.text.TextUtils.isEmpty(paramApolloInfo.mAction.inputText)) {
            break label804;
          }
          j = 2;
          i = j;
          if (android.text.TextUtils.isEmpty(paramApolloInfo.mActionText)) {
            break label1172;
          }
          if (paramApolloInfo.mTextType != 0) {
            continue;
          }
          i = 6;
          VipUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.jdField_a_of_type_JavaLangString, -1, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localSessionInfo.jdField_a_of_type_Int), new String[] { "" + paramApolloInfo.mAction.actionId, "655_" + paramApolloInfo.mPackageId, "0", String.valueOf(System.currentTimeMillis() / 1000L) });
          localObject2 = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          String str1 = localSessionInfo.jdField_a_of_type_JavaLangString;
          j = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localSessionInfo.jdField_a_of_type_Int);
          String str2 = "" + paramApolloInfo.mAction.actionId;
          String str3 = "655_" + paramApolloInfo.mPackageId;
          if (!android.text.TextUtils.isEmpty(paramApolloInfo.mActionText)) {
            break label844;
          }
          localObject1 = "0";
          VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "g_action_double_sent", str1, i, j, new String[] { str2, str3, localObject1, paramApolloInfo.mAction.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
          break label132;
        }
        paramApolloInfo.mAction.inputText = ((String)localObject2).substring(((AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen);
        continue;
      }
      catch (Exception localException)
      {
        int j;
        if (QLog.isColorLevel()) {
          QLog.d("Apollo_PanelManager", 2, "inputText err:" + localException.getMessage());
        }
        paramApolloInfo.mAction.inputText = "";
        continue;
        i = j;
        if (paramApolloInfo.mTextType != 1) {
          break label1172;
        }
      }
      int i = 7;
      continue;
      label804:
      if (android.text.TextUtils.isEmpty(paramApolloInfo.mActionText))
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
        continue;
        label844:
        localObject1 = paramApolloInfo.mActionText;
        continue;
        if (paramApolloInfo.mAction.actionType == 5)
        {
          a(paramApolloInfo, paramBaseChatPie);
          return;
        }
        paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloInfo = paramApolloInfo;
        i = 0;
        if (localSessionInfo.jdField_a_of_type_Int == 3000) {
          i = 11;
        }
        for (;;)
        {
          localObject1 = TroopMemberListActivity.a(paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localSessionInfo.jdField_a_of_type_JavaLangString, i);
          if (paramBaseChatPie.g() == 21) {
            ((Intent)localObject1).putExtra("param_troop_send_apollo_msg", true);
          }
          ((Intent)localObject1).putExtra("param_is_pop_up_style", true);
          ((Intent)localObject1).putExtra("param_troop_send_apollo_msg", true);
          paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult((Intent)localObject1, 6001);
          VipUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.jdField_a_of_type_JavaLangString, -1, ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localSessionInfo.jdField_a_of_type_Int), new String[] { "" + paramApolloInfo.mAction.actionId, "655_" + paramApolloInfo.mPackageId, "1", String.valueOf(System.currentTimeMillis() / 1000L) });
          return;
          if (localSessionInfo.jdField_a_of_type_Int == 1) {
            i = 3;
          }
        }
        if (paramApolloInfo.mAction.personNum != 0) {
          break label132;
        }
        paramApolloInfo.mAction.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
        break label132;
        if ((localSessionInfo.jdField_a_of_type_Int != 1) && (localSessionInfo.jdField_a_of_type_Int != 3000)) {
          paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
        }
        if (paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
          break;
        }
        paramBaseChatPie.a(paramApolloInfo);
        return;
      }
    }
  }
  
  public void c()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_b_of_type_ComTencentMobileqqApolloApiModelApolloInfo == null)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      SessionInfo localSessionInfo = localBaseChatPie.a();
      ApolloActionData localApolloActionData = this.jdField_b_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mAction;
      int i = this.jdField_a_of_type_Int;
      if (localApolloActionData.currencyType != 1) {
        continue;
      }
      HashMap localHashMap = new HashMap();
      int j = this.jdField_a_of_type_Int;
      Object localObject4;
      String str2;
      Object localObject5;
      Object localObject3;
      Object localObject2;
      String str1;
      Object localObject1;
      if (localApolloActionData.currencyNum <= i)
      {
        localObject4 = HardCodeUtil.a(2131700555);
        str2 = String.format(localBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690128), new Object[] { Integer.valueOf(localApolloActionData.currencyNum), Integer.valueOf(j) });
        localObject5 = HardCodeUtil.a(2131700560);
        localObject3 = "requestSSO";
        localObject2 = localObject5;
        str1 = str2;
        localObject1 = localObject4;
        if (localSessionInfo == null) {
          break label604;
        }
        VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "icon_alert_show", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + localApolloActionData.actionId });
        localObject1 = "requestSSO";
        str1 = str2;
        localObject2 = localObject4;
        localHashMap.put("APOLLO_POP_TYPE", "dialog");
        localHashMap.put("feeType", String.valueOf(localApolloActionData.feeType));
        localHashMap.put("title", localObject2);
        localHashMap.put("content", str1);
        localHashMap.put("rightString", localObject5);
        localHashMap.put("url", localObject1);
        localHashMap.put("actionId", String.valueOf(localApolloActionData.actionId));
        localObject1 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("packageId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloApiModelApolloInfo.mPackageId));
        localHashMap.put("extendJson", ((JSONObject)localObject1).toString());
        localObject1 = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((MqqHandler)localObject1).obtainMessage(45);
        ((Message)localObject1).obj = localHashMap;
        ((Message)localObject1).sendToTarget();
        return;
        localObject4 = HardCodeUtil.a(2131700552);
        str2 = String.format(localBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131690127), new Object[] { Integer.valueOf(localApolloActionData.currencyNum), Integer.valueOf(j) });
        localObject5 = HardCodeUtil.a(2131700558);
        String str3 = ApolloConstant.m + "&adtag=authGold";
        localObject3 = str3;
        localObject2 = localObject5;
        str1 = str2;
        localObject1 = localObject4;
        if (localSessionInfo != null)
        {
          VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "debt_alert_show", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + localApolloActionData.actionId });
          localObject1 = localObject4;
          str1 = str2;
          localObject2 = localObject5;
          localObject3 = str3;
        }
        label604:
        localObject4 = localObject1;
        localObject1 = localObject3;
        localObject5 = localObject2;
        localObject2 = localObject4;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("Apollo_PanelManager", 1, "[authGoldAction] Exception:", localException);
        }
      }
    }
  }
  
  public void c(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBaseChatPie.a() == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, new Object[] { "[previewNewAction] apolloInfo=", paramApolloInfo });
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
    if (paramApolloInfo.mTextType == 1)
    {
      bool = true;
      localSpriteTaskParam.jdField_b_of_type_Boolean = bool;
      localSpriteTaskParam.jdField_c_of_type_JavaLangString = paramApolloInfo.mActionText;
      localSpriteTaskParam.e = localApolloActionData.personNum;
      paramApolloInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = String.valueOf(paramApolloInfo);
      if (!CmShowAioMatcher.a(localSessionInfo.jdField_a_of_type_Int, 1)) {
        break label367;
      }
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = localSessionInfo.jdField_a_of_type_JavaLangString;
    }
    label367:
    while (localSpriteTaskParam.e == 0)
    {
      if (localApolloActionData.actionType == 5)
      {
        localSpriteTaskParam.jdField_c_of_type_Int = 5;
        paramApolloInfo = (ApolloManagerServiceImpl)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IApolloManagerService.class, "all");
        if ((paramApolloInfo != null) && (paramApolloInfo.getApolloPanelManager() != null))
        {
          localSpriteTaskParam.d = paramApolloInfo.getApolloPanelManager().jdField_a_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("Apollo_PanelManager", 2, new Object[] { "[previewNewAction] mSlaveExtJson=", localSpriteTaskParam.d });
          }
        }
      }
      paramApolloInfo = (ISpriteScriptManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ISpriteScriptManager.class, "all");
      if (paramApolloInfo != null) {
        paramApolloInfo.getSpriteBridge().b(localSpriteTaskParam);
      }
      VipUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_preview_play", ((IApolloUtil)QRoute.api(IApolloUtil.class)).getReportSessiontype(localSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(localApolloActionData.actionId) });
      return;
      bool = false;
      break;
    }
    paramApolloInfo = ((FriendsManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramApolloInfo);
    int i;
    if (paramApolloInfo != null) {
      if (paramApolloInfo.gender == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      label407:
      if (i != 0) {}
      for (paramApolloInfo = "-2";; paramApolloInfo = "-1")
      {
        localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramApolloInfo;
        break;
        i = 0;
        break label407;
      }
      i = 1;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    this.jdField_a_of_type_JavaLangString = null;
    ApolloUtilImpl.getCmdChannel().removeCmdHandler(this.jdField_a_of_type_ComTencentMobileqqApolloApiChannelIRequestHandler);
    this.jdField_a_of_type_ComTencentMobileqqApolloApiChannelIRequestHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager
 * JD-Core Version:    0.7.0.1
 */