package com.tencent.mobileqq.apollo;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.script.SpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteScriptManager;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.apollo.view.ApolloInfo;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloSlaveInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.lovelanguage.LoveLanguageConfig;
import com.tencent.mobileqq.lovelanguage.LoveLanguageManager;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionHandler;
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
import yhm;
import yhn;

public class ApolloPanelManager
{
  public volatile int a;
  public long a;
  public ApolloInfo a;
  public String a;
  private WeakReference a;
  public ConcurrentHashMap a;
  public AtomicInteger a;
  public volatile boolean a;
  public int b;
  private ApolloInfo jdField_b_of_type_ComTencentMobileqqApolloViewApolloInfo;
  private WeakReference jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private WeakReference c;
  
  public ApolloPanelManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  private void b(ApolloInfo paramApolloInfo)
  {
    if ((a() == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) || (paramApolloInfo == null)) {
      return;
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    SessionInfo localSessionInfo = ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a();
    localBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo = paramApolloInfo;
    int i;
    if (localSessionInfo.jdField_a_of_type_Int == 3000) {
      i = 11;
    }
    for (;;)
    {
      Intent localIntent = TroopMemberListActivity.a(localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localSessionInfo.jdField_a_of_type_JavaLangString, i);
      if (localBaseChatPie.f() == 21) {
        localIntent.putExtra("param_troop_send_apollo_msg", true);
      }
      localIntent.putExtra("param_is_pop_up_style", true);
      localIntent.putExtra("param_troop_send_apollo_msg", true);
      localBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult(localIntent, 6001);
      VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.jdField_a_of_type_JavaLangString, -1, ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int), new String[] { "" + paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + paramApolloInfo.jdField_a_of_type_Int, "1", String.valueOf(System.currentTimeMillis() / 1000L) });
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
  
  public void a()
  {
    if (this.c != null)
    {
      this.c.clear();
      this.c = null;
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
              break label340;
            }
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(localApolloSlaveInfo.uin), localApolloSlaveInfo);
            break label340;
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
        ThreadManager.getUIHandler().post(new yhn(this));
        return;
      }
      catch (Throwable paramString1)
      {
        QLog.e("Apollo_PanelManager", 1, "[onGetSlaveListFromSvr], errInfo->", paramString1);
        return;
      }
      label340:
      i += 1;
    }
  }
  
  public void a(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqApolloViewApolloInfo = paramApolloInfo;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_Boolean = true;
    ((VasExtensionHandler)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 262144, "get gold balance");
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
    this.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo = paramApolloInfo;
    if ((System.currentTimeMillis() - this.jdField_a_of_type_Long <= 120000L) && (paramApolloInfo != null))
    {
      ThreadManager.getUIHandler().post(new yhm(this, paramApolloInfo));
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
          break label196;
        }
        if (paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) {
          break label180;
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
      ((VasExtensionHandler)a().a(71)).a("apollo_terminal_info.get_user_slaves_v2", localJSONObject.toString(), -1L, 7);
      return;
      label180:
      int i = paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
      paramApolloInfo = Integer.valueOf(i);
      continue;
      label196:
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
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_b_of_type_ComTencentMobileqqApolloViewApolloInfo == null)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      SessionInfo localSessionInfo = localBaseChatPie.a();
      ApolloActionData localApolloActionData = this.jdField_b_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
      int i = this.jdField_a_of_type_Int;
      if (localApolloActionData.currencyType != 1) {
        continue;
      }
      HashMap localHashMap = new HashMap();
      int j = this.jdField_a_of_type_Int;
      Object localObject2;
      Object localObject5;
      Object localObject4;
      Object localObject3;
      Object localObject1;
      if (localApolloActionData.currencyNum <= i)
      {
        localObject2 = "金币购买动作";
        localObject5 = String.format(localBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438207), new Object[] { Integer.valueOf(localApolloActionData.currencyNum), Integer.valueOf(j) });
        localObject4 = "购买";
        localObject3 = "requestSSO";
        localObject1 = localObject5;
        if (localSessionInfo == null) {
          break label569;
        }
        VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "icon_alert_show", ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + localApolloActionData.actionId });
        localObject1 = "requestSSO";
        localObject2 = "购买";
        localObject3 = localObject5;
        localObject4 = "金币购买动作";
        localHashMap.put("APOLLO_POP_TYPE", "dialog");
        localHashMap.put("feeType", String.valueOf(localApolloActionData.feeType));
        localHashMap.put("title", localObject4);
        localHashMap.put("content", localObject3);
        localHashMap.put("rightString", localObject2);
        localHashMap.put("url", localObject1);
        localHashMap.put("actionId", String.valueOf(localApolloActionData.actionId));
        localObject1 = new JSONObject();
      }
      try
      {
        ((JSONObject)localObject1).put("packageId", String.valueOf(this.jdField_b_of_type_ComTencentMobileqqApolloViewApolloInfo.jdField_a_of_type_Int));
        localHashMap.put("extendJson", ((JSONObject)localObject1).toString());
        localObject1 = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((MqqHandler)localObject1).obtainMessage(45);
        ((Message)localObject1).obj = localHashMap;
        ((Message)localObject1).sendToTarget();
        return;
        localObject5 = "余额不足";
        Object localObject6 = String.format(localBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131438208), new Object[] { Integer.valueOf(localApolloActionData.currencyNum), Integer.valueOf(j) });
        String str1 = "充值";
        String str2 = ApolloConstant.P + "&adtag=authGold";
        localObject3 = str2;
        localObject4 = str1;
        localObject1 = localObject6;
        localObject2 = localObject5;
        if (localSessionInfo != null)
        {
          VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "debt_alert_show", ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + localApolloActionData.actionId });
          localObject2 = localObject5;
          localObject1 = localObject6;
          localObject4 = str1;
          localObject3 = str2;
        }
        label569:
        localObject5 = localObject1;
        localObject6 = localObject2;
        localObject1 = localObject3;
        localObject2 = localObject4;
        localObject3 = localObject5;
        localObject4 = localObject6;
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
  
  public void b(BaseChatPie paramBaseChatPie, ApolloInfo paramApolloInfo)
  {
    if ((paramApolloInfo == null) || (paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null)) {
      return;
    }
    if (LoveLanguageConfig.a(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString())) {
      ((LoveLanguageManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(273)).a(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, new Object[] { "[sendActionMsg] mainInfo=", paramApolloInfo });
    }
    SessionInfo localSessionInfo = paramBaseChatPie.a();
    paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.atNickName = "";
    paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = "";
    if (localSessionInfo.jdField_a_of_type_Int == 0)
    {
      paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = localSessionInfo.jdField_a_of_type_JavaLangString;
      paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = com.tencent.mobileqq.text.TextUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    }
    label160:
    while (((localSessionInfo.jdField_a_of_type_Int != 1) && (localSessionInfo.jdField_a_of_type_Int != 3000)) || (paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null))
    {
      localObject1 = paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      if ((localObject1 == null) || (((String)localObject1).length() <= 99)) {
        break;
      }
      ChatActivityUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131433361, 1);
      return;
    }
    Object localObject1 = new ArrayList();
    AtTroopMemberSpan.a(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject1);
    Object localObject2;
    if (paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum == 1) {
      if ((((ArrayList)localObject1).size() == 1) && (0L != ((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).uin) && (((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).startPos == 0)) {
        localObject2 = com.tencent.mobileqq.text.TextUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      }
    }
    label790:
    label830:
    label1148:
    for (;;)
    {
      try
      {
        paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.atNickName = ((String)localObject2).substring(0, ((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen);
        if (((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen >= paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() - 1)
        {
          paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = "";
          paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = (((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).uin + "");
          paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
          i = 0;
          if (!android.text.TextUtils.isEmpty(paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText)) {
            break label790;
          }
          j = 2;
          i = j;
          if (android.text.TextUtils.isEmpty(paramApolloInfo.jdField_b_of_type_JavaLangString)) {
            break label1148;
          }
          if (paramApolloInfo.d != 0) {
            continue;
          }
          i = 6;
          VipUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.jdField_a_of_type_JavaLangString, -1, ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int), new String[] { "" + paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + paramApolloInfo.jdField_a_of_type_Int, "0", String.valueOf(System.currentTimeMillis() / 1000L) });
          localObject2 = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          String str1 = localSessionInfo.jdField_a_of_type_JavaLangString;
          j = ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int);
          String str2 = "" + paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
          if (!android.text.TextUtils.isEmpty(paramApolloInfo.jdField_b_of_type_JavaLangString)) {
            break label830;
          }
          localObject1 = "0";
          VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "g_action_double_sent", str1, i, j, new String[] { str2, localObject1, paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
          break label160;
        }
        paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = ((String)localObject2).substring(((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen);
        continue;
      }
      catch (Exception localException)
      {
        int j;
        if (QLog.isColorLevel()) {
          QLog.d("Apollo_PanelManager", 2, "inputText err:" + localException.getMessage());
        }
        paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = "";
        continue;
        i = j;
        if (paramApolloInfo.d != 1) {
          break label1148;
        }
      }
      int i = 7;
      continue;
      if (android.text.TextUtils.isEmpty(paramApolloInfo.jdField_b_of_type_JavaLangString))
      {
        i = 3;
      }
      else if (paramApolloInfo.d == 0)
      {
        i = 4;
      }
      else if (paramApolloInfo.d == 1)
      {
        i = 5;
        continue;
        localObject1 = paramApolloInfo.jdField_b_of_type_JavaLangString;
        continue;
        if (paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionType == 5)
        {
          a(paramApolloInfo, paramBaseChatPie);
          return;
        }
        paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqApolloViewApolloInfo = paramApolloInfo;
        i = 0;
        if (localSessionInfo.jdField_a_of_type_Int == 3000) {
          i = 11;
        }
        for (;;)
        {
          localObject1 = TroopMemberListActivity.a(paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, localSessionInfo.jdField_a_of_type_JavaLangString, i);
          if (paramBaseChatPie.f() == 21) {
            ((Intent)localObject1).putExtra("param_troop_send_apollo_msg", true);
          }
          ((Intent)localObject1).putExtra("param_is_pop_up_style", true);
          ((Intent)localObject1).putExtra("param_troop_send_apollo_msg", true);
          paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.startActivityForResult((Intent)localObject1, 6001);
          VipUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.jdField_a_of_type_JavaLangString, -1, ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int), new String[] { "" + paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + paramApolloInfo.jdField_a_of_type_Int, "1", String.valueOf(System.currentTimeMillis() / 1000L) });
          return;
          if (localSessionInfo.jdField_a_of_type_Int == 1) {
            i = 3;
          }
        }
        if (paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum != 0) {
          break label160;
        }
        paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = com.tencent.mobileqq.text.TextUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
        break label160;
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
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
    this.jdField_a_of_type_JavaLangString = null;
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
    ApolloActionData localApolloActionData = paramApolloInfo.jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = localApolloActionData.actionId;
    localSpriteTaskParam.jdField_c_of_type_Int = 0;
    localSpriteTaskParam.h = localSessionInfo.jdField_a_of_type_Int;
    localSpriteTaskParam.g = 3;
    localSpriteTaskParam.jdField_a_of_type_Long = -10000L;
    localSpriteTaskParam.i = 0;
    localSpriteTaskParam.jdField_a_of_type_Float = 0.0F;
    boolean bool;
    if (paramApolloInfo.d == 1)
    {
      bool = true;
      localSpriteTaskParam.jdField_b_of_type_Boolean = bool;
      localSpriteTaskParam.jdField_c_of_type_JavaLangString = paramApolloInfo.jdField_b_of_type_JavaLangString;
      localSpriteTaskParam.e = localApolloActionData.personNum;
      paramApolloInfo = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = String.valueOf(paramApolloInfo);
      if (localSessionInfo.jdField_a_of_type_Int != 0) {
        break label338;
      }
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = localSessionInfo.jdField_a_of_type_JavaLangString;
    }
    label338:
    while (localSpriteTaskParam.e == 0)
    {
      if (localApolloActionData.actionType == 5)
      {
        localSpriteTaskParam.jdField_c_of_type_Int = 5;
        paramApolloInfo = (ApolloManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
        if ((paramApolloInfo != null) && (paramApolloInfo.a() != null))
        {
          localSpriteTaskParam.d = paramApolloInfo.a().jdField_a_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("Apollo_PanelManager", 2, new Object[] { "[previewNewAction] mSlaveExtJson=", localSpriteTaskParam.d });
          }
        }
      }
      paramApolloInfo = SpriteUtil.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramApolloInfo != null) {
        paramApolloInfo.a().a(localSpriteTaskParam);
      }
      VipUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_preview_play", ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(localApolloActionData.actionId) });
      return;
      bool = false;
      break;
    }
    paramApolloInfo = ((FriendsManager)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramApolloInfo);
    int i;
    if (paramApolloInfo != null) {
      if (paramApolloInfo.gender == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      label377:
      if (i != 0) {}
      for (paramApolloInfo = "-2";; paramApolloInfo = "-1")
      {
        localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramApolloInfo;
        break;
        i = 0;
        break label377;
      }
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloPanelManager
 * JD-Core Version:    0.7.0.1
 */