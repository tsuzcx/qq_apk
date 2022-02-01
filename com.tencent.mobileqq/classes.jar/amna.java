import android.content.Context;
import android.content.Intent;
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
import com.tencent.mobileqq.apollo.ApolloPanelManager.1;
import com.tencent.mobileqq.apollo.ApolloPanelManager.2;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloSlaveInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
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

public class amna
{
  public volatile int a;
  public long a;
  public annl a;
  public String a;
  private WeakReference<QQAppInterface> a;
  public ConcurrentHashMap<Long, ApolloSlaveInfo> a;
  public AtomicInteger a;
  public volatile boolean a;
  public int b;
  private annl jdField_b_of_type_Annl;
  private WeakReference<BaseChatPie> jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private WeakReference<amnb> c;
  
  public amna(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  private void b(annl paramannl)
  {
    if ((a() == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) || (paramannl == null)) {
      return;
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    SessionInfo localSessionInfo = ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).getSessionInfo();
    localBaseChatPie.mApolloInfo = paramannl;
    int i;
    if (localSessionInfo.curType == 3000) {
      i = 11;
    }
    for (;;)
    {
      Intent localIntent = TroopMemberListActivity.a(localBaseChatPie.mActivity, localSessionInfo.curFriendUin, i);
      if (localBaseChatPie.getCurrentPanel() == 21) {
        localIntent.putExtra("param_troop_send_apollo_msg", true);
      }
      localIntent.putExtra("param_is_pop_up_style", true);
      localIntent.putExtra("param_troop_send_apollo_msg", true);
      localBaseChatPie.mActivity.startActivityForResult(localIntent, 6001);
      VipUtils.a(localBaseChatPie.app, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.curFriendUin, -1, ApolloUtil.b(localSessionInfo.curType), new String[] { "" + paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + paramannl.jdField_a_of_type_Int, "1", String.valueOf(System.currentTimeMillis() / 1000L) });
      return;
      if (localSessionInfo.curType == 1) {
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
      amnb localamnb = (amnb)this.c.get();
      if (localamnb != null) {
        localamnb.a(paramInt, paramBoolean1, paramBoolean2);
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
            ApolloSlaveInfo localApolloSlaveInfo = (ApolloSlaveInfo)bgzr.a(localJSONArray.getJSONObject(i), ApolloSlaveInfo.class);
            if (localApolloSlaveInfo == null) {
              break label341;
            }
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Long.valueOf(localApolloSlaveInfo.uin), localApolloSlaveInfo);
            break label341;
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
        ThreadManager.getUIHandler().post(new ApolloPanelManager.2(this));
        return;
      }
      catch (Throwable paramString1)
      {
        QLog.e("Apollo_PanelManager", 1, "[onGetSlaveListFromSvr], errInfo->", paramString1);
        return;
      }
      label341:
      i += 1;
    }
  }
  
  public void a(amnb paramamnb)
  {
    this.c = new WeakReference(paramamnb);
  }
  
  public void a(annl paramannl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, "[checkSlavesBeforeSend]");
    }
    this.jdField_a_of_type_Annl = paramannl;
    if ((System.currentTimeMillis() - this.jdField_a_of_type_Long <= 120000L) && (paramannl != null))
    {
      ThreadManager.getUIHandler().post(new ApolloPanelManager.1(this, paramannl));
      return;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("cmd", "apollo_terminal_info.get_user_slaves_v2");
        localJSONObject.put("from", "android");
        if (paramannl == null) {
          break label197;
        }
        if (paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) {
          break label181;
        }
      }
      catch (Throwable paramannl)
      {
        JSONObject localJSONObject;
        QLog.e("Apollo_PanelManager", 1, "[checkSlavesBeforeSend], errInfo->", paramannl);
        return;
      }
      localJSONObject.put("actionId", paramannl);
      paramannl = new JSONArray();
      paramannl.put(Long.parseLong(a().getCurrentAccountUin()));
      localJSONObject.put("toUins", paramannl);
      ((VasExtensionHandler)a().getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a("apollo_terminal_info.get_user_slaves_v2", localJSONObject.toString(), -1L, 7);
      return;
      label181:
      int i = paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
      paramannl = Integer.valueOf(i);
      continue;
      label197:
      paramannl = null;
    }
  }
  
  public void a(annl paramannl, BaseChatPie paramBaseChatPie)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    a(paramannl);
  }
  
  public void a(BaseChatPie paramBaseChatPie, annl paramannl)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.app == null)) {
      return;
    }
    this.jdField_b_of_type_Annl = paramannl;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_Boolean = true;
    ((VasExtensionHandler)paramBaseChatPie.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER)).a(paramBaseChatPie.app.getCurrentUin(), 262144, "get gold balance");
  }
  
  public void b()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_b_of_type_Annl == null)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      SessionInfo localSessionInfo = localBaseChatPie.getSessionInfo();
      ApolloActionData localApolloActionData = this.jdField_b_of_type_Annl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
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
        localObject4 = anvx.a(2131699977);
        str2 = String.format(localBaseChatPie.mContext.getResources().getString(2131690077), new Object[] { Integer.valueOf(localApolloActionData.currencyNum), Integer.valueOf(j) });
        localObject5 = anvx.a(2131699982);
        localObject3 = "requestSSO";
        localObject2 = localObject5;
        str1 = str2;
        localObject1 = localObject4;
        if (localSessionInfo == null) {
          break label583;
        }
        VipUtils.a(localBaseChatPie.app, "cmshow", "Apollo", "icon_alert_show", ApolloUtil.b(localSessionInfo.curType), 0, new String[] { "" + localApolloActionData.actionId });
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
        ((JSONObject)localObject1).put("packageId", String.valueOf(this.jdField_b_of_type_Annl.jdField_a_of_type_Int));
        localHashMap.put("extendJson", ((JSONObject)localObject1).toString());
        localObject1 = localBaseChatPie.app.getHandler(ChatActivity.class);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((MqqHandler)localObject1).obtainMessage(45);
        ((Message)localObject1).obj = localHashMap;
        ((Message)localObject1).sendToTarget();
        return;
        localObject4 = anvx.a(2131699974);
        str2 = String.format(localBaseChatPie.mContext.getString(2131690076), new Object[] { Integer.valueOf(localApolloActionData.currencyNum), Integer.valueOf(j) });
        localObject5 = anvx.a(2131699980);
        String str3 = anka.m + "&adtag=authGold";
        localObject3 = str3;
        localObject2 = localObject5;
        str1 = str2;
        localObject1 = localObject4;
        if (localSessionInfo != null)
        {
          VipUtils.a(localBaseChatPie.app, "cmshow", "Apollo", "debt_alert_show", ApolloUtil.b(localSessionInfo.curType), 0, new String[] { "" + localApolloActionData.actionId });
          localObject1 = localObject4;
          str1 = str2;
          localObject2 = localObject5;
          localObject3 = str3;
        }
        label583:
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
  
  public void b(BaseChatPie paramBaseChatPie, annl paramannl)
  {
    if ((paramannl == null) || (paramBaseChatPie == null) || (paramBaseChatPie.app == null) || (paramBaseChatPie.input == null) || (paramBaseChatPie.input.getText() == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, new Object[] { "[sendActionMsg] mainInfo=", paramannl });
    }
    SessionInfo localSessionInfo = paramBaseChatPie.getSessionInfo();
    paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.atNickName = "";
    paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = "";
    if ((localSessionInfo.curType == 0) || (anck.a(localSessionInfo.curType)))
    {
      paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = localSessionInfo.curFriendUin;
      paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(paramBaseChatPie.input.getText().toString());
    }
    label134:
    while (((localSessionInfo.curType != 1) && (localSessionInfo.curType != 3000)) || (paramBaseChatPie.mActivity == null))
    {
      localObject1 = paramBaseChatPie.input.getText().toString();
      if ((localObject1 == null) || (((String)localObject1).length() <= 99)) {
        break;
      }
      ChatActivityUtils.a(paramBaseChatPie.app.getApplication(), 2131718520, 1);
      return;
    }
    Object localObject1 = new ArrayList();
    bgcz.a(paramBaseChatPie.input.getEditableText(), (ArrayList)localObject1);
    Object localObject2;
    if (paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum == 1) {
      if ((((ArrayList)localObject1).size() == 1) && (0L != ((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).uin) && (((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).startPos == 0)) {
        localObject2 = com.tencent.mobileqq.text.TextUtils.emoticonToText(paramBaseChatPie.input.getText().toString());
      }
    }
    label793:
    label833:
    label1151:
    for (;;)
    {
      try
      {
        paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.atNickName = ((String)localObject2).substring(0, ((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen);
        if (((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen >= paramBaseChatPie.input.getText().length() - 1)
        {
          paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = "";
          paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = (((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).uin + "");
          paramBaseChatPie.input.getText().clear();
          i = 0;
          if (!android.text.TextUtils.isEmpty(paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText)) {
            break label793;
          }
          j = 2;
          i = j;
          if (android.text.TextUtils.isEmpty(paramannl.jdField_b_of_type_JavaLangString)) {
            break label1151;
          }
          if (paramannl.d != 0) {
            continue;
          }
          i = 6;
          VipUtils.a(paramBaseChatPie.app, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.curFriendUin, -1, ApolloUtil.b(localSessionInfo.curType), new String[] { "" + paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + paramannl.jdField_a_of_type_Int, "0", String.valueOf(System.currentTimeMillis() / 1000L) });
          localObject2 = paramBaseChatPie.app;
          String str1 = localSessionInfo.curFriendUin;
          j = ApolloUtil.b(localSessionInfo.curType);
          String str2 = "" + paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
          String str3 = "655_" + paramannl.jdField_a_of_type_Int;
          if (!android.text.TextUtils.isEmpty(paramannl.jdField_b_of_type_JavaLangString)) {
            break label833;
          }
          localObject1 = "0";
          VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "g_action_double_sent", str1, i, j, new String[] { str2, str3, localObject1, paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
          break label134;
        }
        paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = ((String)localObject2).substring(((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen);
        continue;
      }
      catch (Exception localException)
      {
        int j;
        if (QLog.isColorLevel()) {
          QLog.d("Apollo_PanelManager", 2, "inputText err:" + localException.getMessage());
        }
        paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = "";
        continue;
        i = j;
        if (paramannl.d != 1) {
          break label1151;
        }
      }
      int i = 7;
      continue;
      if (android.text.TextUtils.isEmpty(paramannl.jdField_b_of_type_JavaLangString))
      {
        i = 3;
      }
      else if (paramannl.d == 0)
      {
        i = 4;
      }
      else if (paramannl.d == 1)
      {
        i = 5;
        continue;
        localObject1 = paramannl.jdField_b_of_type_JavaLangString;
        continue;
        if (paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionType == 5)
        {
          a(paramannl, paramBaseChatPie);
          return;
        }
        paramBaseChatPie.mApolloInfo = paramannl;
        i = 0;
        if (localSessionInfo.curType == 3000) {
          i = 11;
        }
        for (;;)
        {
          localObject1 = TroopMemberListActivity.a(paramBaseChatPie.mActivity, localSessionInfo.curFriendUin, i);
          if (paramBaseChatPie.getCurrentPanel() == 21) {
            ((Intent)localObject1).putExtra("param_troop_send_apollo_msg", true);
          }
          ((Intent)localObject1).putExtra("param_is_pop_up_style", true);
          ((Intent)localObject1).putExtra("param_troop_send_apollo_msg", true);
          paramBaseChatPie.mActivity.startActivityForResult((Intent)localObject1, 6001);
          VipUtils.a(paramBaseChatPie.app, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.curFriendUin, -1, ApolloUtil.b(localSessionInfo.curType), new String[] { "" + paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + paramannl.jdField_a_of_type_Int, "1", String.valueOf(System.currentTimeMillis() / 1000L) });
          return;
          if (localSessionInfo.curType == 1) {
            i = 3;
          }
        }
        if (paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum != 0) {
          break label134;
        }
        paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = com.tencent.mobileqq.text.TextUtils.emoticonToText(paramBaseChatPie.input.getText().toString());
        paramBaseChatPie.input.getText().clear();
        break label134;
        if ((localSessionInfo.curType != 1) && (localSessionInfo.curType != 3000)) {
          paramBaseChatPie.input.getText().clear();
        }
        if (paramBaseChatPie.mActivity == null) {
          break;
        }
        paramBaseChatPie.send(paramannl);
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
  
  public void c(BaseChatPie paramBaseChatPie, annl paramannl)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.app == null) || (paramBaseChatPie.getSessionInfo() == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, new Object[] { "[previewNewAction] apolloInfo=", paramannl });
    }
    SessionInfo localSessionInfo = paramBaseChatPie.getSessionInfo();
    ApolloActionData localApolloActionData = paramannl.jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = localApolloActionData.actionId;
    localSpriteTaskParam.jdField_c_of_type_Int = 0;
    localSpriteTaskParam.h = localSessionInfo.curType;
    localSpriteTaskParam.g = 3;
    localSpriteTaskParam.jdField_a_of_type_Long = -10000L;
    localSpriteTaskParam.i = 0;
    localSpriteTaskParam.jdField_a_of_type_Float = 0.0F;
    boolean bool;
    if (paramannl.d == 1)
    {
      bool = true;
      localSpriteTaskParam.jdField_b_of_type_Boolean = bool;
      localSpriteTaskParam.jdField_c_of_type_JavaLangString = paramannl.jdField_b_of_type_JavaLangString;
      localSpriteTaskParam.e = localApolloActionData.personNum;
      paramannl = paramBaseChatPie.app.getCurrentUin();
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = String.valueOf(paramannl);
      if (localSessionInfo.curType != 0) {
        break label338;
      }
      localSpriteTaskParam.jdField_b_of_type_JavaLangString = localSessionInfo.curFriendUin;
    }
    label338:
    while (localSpriteTaskParam.e == 0)
    {
      if (localApolloActionData.actionType == 5)
      {
        localSpriteTaskParam.jdField_c_of_type_Int = 5;
        paramannl = (amme)paramBaseChatPie.app.getManager(QQManagerFactory.APOLLO_MANAGER);
        if ((paramannl != null) && (paramannl.a() != null))
        {
          localSpriteTaskParam.d = paramannl.a().jdField_a_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("Apollo_PanelManager", 2, new Object[] { "[previewNewAction] mSlaveExtJson=", localSpriteTaskParam.d });
          }
        }
      }
      paramannl = anck.a(paramBaseChatPie.app);
      if (paramannl != null) {
        paramannl.a().a(localSpriteTaskParam);
      }
      VipUtils.a(paramBaseChatPie.app, "cmshow", "Apollo", "action_preview_play", ApolloUtil.b(localSessionInfo.curType), 0, new String[] { String.valueOf(localApolloActionData.actionId) });
      return;
      bool = false;
      break;
    }
    paramannl = ((anvk)paramBaseChatPie.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramannl);
    int i;
    if (paramannl != null) {
      if (paramannl.gender == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      label378:
      if (i != 0) {}
      for (paramannl = "-2";; paramannl = "-1")
      {
        localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramannl;
        break;
        i = 0;
        break label378;
      }
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amna
 * JD-Core Version:    0.7.0.1
 */