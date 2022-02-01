import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.TroopMemberListActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloPanelManager.1;
import com.tencent.mobileqq.apollo.ApolloPanelManager.2;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class amtq
{
  public volatile int a;
  public long a;
  public anra a;
  public String a;
  private WeakReference<QQAppInterface> a;
  public ConcurrentHashMap<Long, ApolloSlaveInfo> a;
  public AtomicInteger a;
  public volatile boolean a;
  public int b;
  private anra jdField_b_of_type_Anra;
  private WeakReference<BaseChatPie> jdField_b_of_type_JavaLangRefWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private WeakReference<amtr> c;
  
  public amtq(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  private void b(anra paramanra)
  {
    if ((a() == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) || (paramanra == null)) {
      return;
    }
    BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
    SessionInfo localSessionInfo = ((BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get()).a();
    localBaseChatPie.jdField_a_of_type_Anra = paramanra;
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
      VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.jdField_a_of_type_JavaLangString, -1, ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int), new String[] { "" + paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + paramanra.jdField_a_of_type_Int, "1", String.valueOf(System.currentTimeMillis() / 1000L) });
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
      amtr localamtr = (amtr)this.c.get();
      if (localamtr != null) {
        localamtr.a(paramInt, paramBoolean1, paramBoolean2);
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
            ApolloSlaveInfo localApolloSlaveInfo = (ApolloSlaveInfo)bhhq.a(localJSONArray.getJSONObject(i), ApolloSlaveInfo.class);
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
        ThreadManager.getUIHandler().post(new ApolloPanelManager.2(this));
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
  
  public void a(amtr paramamtr)
  {
    this.c = new WeakReference(paramamtr);
  }
  
  public void a(anra paramanra)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, "[checkSlavesBeforeSend]");
    }
    this.jdField_a_of_type_Anra = paramanra;
    if ((System.currentTimeMillis() - this.jdField_a_of_type_Long <= 120000L) && (paramanra != null))
    {
      ThreadManager.getUIHandler().post(new ApolloPanelManager.1(this, paramanra));
      return;
    }
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject();
        localJSONObject.put("cmd", "apollo_terminal_info.get_user_slaves_v2");
        localJSONObject.put("from", "android");
        if (paramanra == null) {
          break label196;
        }
        if (paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData != null) {
          break label180;
        }
      }
      catch (Throwable paramanra)
      {
        JSONObject localJSONObject;
        QLog.e("Apollo_PanelManager", 1, "[checkSlavesBeforeSend], errInfo->", paramanra);
        return;
      }
      localJSONObject.put("actionId", paramanra);
      paramanra = new JSONArray();
      paramanra.put(Long.parseLong(a().getCurrentAccountUin()));
      localJSONObject.put("toUins", paramanra);
      ((VasExtensionHandler)a().a(71)).a("apollo_terminal_info.get_user_slaves_v2", localJSONObject.toString(), -1L, 7);
      return;
      label180:
      int i = paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
      paramanra = Integer.valueOf(i);
      continue;
      label196:
      paramanra = null;
    }
  }
  
  public void a(anra paramanra, BaseChatPie paramBaseChatPie)
  {
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    a(paramanra);
  }
  
  public void a(BaseChatPie paramBaseChatPie, anra paramanra)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    this.jdField_b_of_type_Anra = paramanra;
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramBaseChatPie);
    this.jdField_a_of_type_Boolean = true;
    ((VasExtensionHandler)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(71)).a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), 262144, "get gold balance");
  }
  
  public void b()
  {
    if ((this.jdField_b_of_type_JavaLangRefWeakReference == null) || (this.jdField_b_of_type_JavaLangRefWeakReference.get() == null) || (this.jdField_b_of_type_Anra == null)) {}
    for (;;)
    {
      return;
      this.jdField_a_of_type_Boolean = false;
      BaseChatPie localBaseChatPie = (BaseChatPie)this.jdField_b_of_type_JavaLangRefWeakReference.get();
      SessionInfo localSessionInfo = localBaseChatPie.a();
      ApolloActionData localApolloActionData = this.jdField_b_of_type_Anra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
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
        localObject4 = anzj.a(2131699391);
        str2 = String.format(localBaseChatPie.jdField_a_of_type_AndroidContentContext.getResources().getString(2131690025), new Object[] { Integer.valueOf(localApolloActionData.currencyNum), Integer.valueOf(j) });
        localObject5 = anzj.a(2131699396);
        localObject3 = "requestSSO";
        localObject2 = localObject5;
        str1 = str2;
        localObject1 = localObject4;
        if (localSessionInfo == null) {
          break label583;
        }
        VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "icon_alert_show", ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + localApolloActionData.actionId });
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
        ((JSONObject)localObject1).put("packageId", String.valueOf(this.jdField_b_of_type_Anra.jdField_a_of_type_Int));
        localHashMap.put("extendJson", ((JSONObject)localObject1).toString());
        localObject1 = localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(ChatActivity.class);
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((MqqHandler)localObject1).obtainMessage(45);
        ((Message)localObject1).obj = localHashMap;
        ((Message)localObject1).sendToTarget();
        return;
        localObject4 = anzj.a(2131699388);
        str2 = String.format(localBaseChatPie.jdField_a_of_type_AndroidContentContext.getString(2131690024), new Object[] { Integer.valueOf(localApolloActionData.currencyNum), Integer.valueOf(j) });
        localObject5 = anzj.a(2131699394);
        String str3 = annv.Z + "&adtag=authGold";
        localObject3 = str3;
        localObject2 = localObject5;
        str1 = str2;
        localObject1 = localObject4;
        if (localSessionInfo != null)
        {
          VipUtils.a(localBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "debt_alert_show", ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + localApolloActionData.actionId });
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
  
  public void b(BaseChatPie paramBaseChatPie, anra paramanra)
  {
    if ((paramanra == null) || (paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText() == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, new Object[] { "[sendActionMsg] mainInfo=", paramanra });
    }
    SessionInfo localSessionInfo = paramBaseChatPie.a();
    paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.atNickName = "";
    paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = "";
    if (localSessionInfo.jdField_a_of_type_Int == 0)
    {
      paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = localSessionInfo.jdField_a_of_type_JavaLangString;
      paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = behh.b(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
    }
    label123:
    while (((localSessionInfo.jdField_a_of_type_Int != 1) && (localSessionInfo.jdField_a_of_type_Int != 3000)) || (paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null))
    {
      localObject1 = paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString();
      if ((localObject1 == null) || (((String)localObject1).length() <= 99)) {
        break;
      }
      ChatActivityUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), 2131717895, 1);
      return;
    }
    Object localObject1 = new ArrayList();
    bgme.a(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getEditableText(), (ArrayList)localObject1);
    Object localObject2;
    if (paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum == 1) {
      if ((((ArrayList)localObject1).size() == 1) && (0L != ((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).uin) && (((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).startPos == 0)) {
        localObject2 = behh.b(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
      }
    }
    label782:
    label822:
    label1140:
    for (;;)
    {
      try
      {
        paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.atNickName = ((String)localObject2).substring(0, ((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen);
        if (((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen >= paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().length() - 1)
        {
          paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = "";
          paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin = (((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).uin + "");
          paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
          i = 0;
          if (!TextUtils.isEmpty(paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText)) {
            break label782;
          }
          j = 2;
          i = j;
          if (TextUtils.isEmpty(paramanra.jdField_b_of_type_JavaLangString)) {
            break label1140;
          }
          if (paramanra.d != 0) {
            continue;
          }
          i = 6;
          VipUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.jdField_a_of_type_JavaLangString, -1, ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int), new String[] { "" + paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + paramanra.jdField_a_of_type_Int, "0", String.valueOf(System.currentTimeMillis() / 1000L) });
          localObject2 = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
          String str1 = localSessionInfo.jdField_a_of_type_JavaLangString;
          j = ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int);
          String str2 = "" + paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId;
          String str3 = "655_" + paramanra.jdField_a_of_type_Int;
          if (!TextUtils.isEmpty(paramanra.jdField_b_of_type_JavaLangString)) {
            break label822;
          }
          localObject1 = "0";
          VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "g_action_double_sent", str1, i, j, new String[] { str2, str3, localObject1, paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.peerUin, String.valueOf(System.currentTimeMillis() / 1000L) });
          break label123;
        }
        paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = ((String)localObject2).substring(((MessageForText.AtTroopMemberInfo)((ArrayList)localObject1).get(0)).textLen);
        continue;
      }
      catch (Exception localException)
      {
        int j;
        if (QLog.isColorLevel()) {
          QLog.d("Apollo_PanelManager", 2, "inputText err:" + localException.getMessage());
        }
        paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = "";
        continue;
        i = j;
        if (paramanra.d != 1) {
          break label1140;
        }
      }
      int i = 7;
      continue;
      if (TextUtils.isEmpty(paramanra.jdField_b_of_type_JavaLangString))
      {
        i = 3;
      }
      else if (paramanra.d == 0)
      {
        i = 4;
      }
      else if (paramanra.d == 1)
      {
        i = 5;
        continue;
        localObject1 = paramanra.jdField_b_of_type_JavaLangString;
        continue;
        if (paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionType == 5)
        {
          a(paramanra, paramBaseChatPie);
          return;
        }
        paramBaseChatPie.jdField_a_of_type_Anra = paramanra;
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
          VipUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "g_action_double_clk", localSessionInfo.jdField_a_of_type_JavaLangString, -1, ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int), new String[] { "" + paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.actionId, "655_" + paramanra.jdField_a_of_type_Int, "1", String.valueOf(System.currentTimeMillis() / 1000L) });
          return;
          if (localSessionInfo.jdField_a_of_type_Int == 1) {
            i = 3;
          }
        }
        if (paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.personNum != 0) {
          break label123;
        }
        paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData.inputText = behh.b(paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().toString());
        paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
        break label123;
        if ((localSessionInfo.jdField_a_of_type_Int != 1) && (localSessionInfo.jdField_a_of_type_Int != 3000)) {
          paramBaseChatPie.jdField_a_of_type_ComTencentWidgetXEditTextEx.getText().clear();
        }
        if (paramBaseChatPie.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
          break;
        }
        paramBaseChatPie.a(paramanra);
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
  
  public void c(BaseChatPie paramBaseChatPie, anra paramanra)
  {
    if ((paramBaseChatPie == null) || (paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (paramBaseChatPie.a() == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Apollo_PanelManager", 2, new Object[] { "[previewNewAction] apolloInfo=", paramanra });
    }
    SessionInfo localSessionInfo = paramBaseChatPie.a();
    ApolloActionData localApolloActionData = paramanra.jdField_a_of_type_ComTencentMobileqqDataApolloActionData;
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = localApolloActionData.actionId;
    localSpriteTaskParam.jdField_c_of_type_Int = 0;
    localSpriteTaskParam.h = localSessionInfo.jdField_a_of_type_Int;
    localSpriteTaskParam.g = 3;
    localSpriteTaskParam.jdField_a_of_type_Long = -10000L;
    localSpriteTaskParam.i = 0;
    localSpriteTaskParam.jdField_a_of_type_Float = 0.0F;
    boolean bool;
    if (paramanra.d == 1)
    {
      bool = true;
      localSpriteTaskParam.jdField_b_of_type_Boolean = bool;
      localSpriteTaskParam.jdField_c_of_type_JavaLangString = paramanra.jdField_b_of_type_JavaLangString;
      localSpriteTaskParam.e = localApolloActionData.personNum;
      paramanra = paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = String.valueOf(paramanra);
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
        paramanra = (amsx)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(153);
        if ((paramanra != null) && (paramanra.a() != null))
        {
          localSpriteTaskParam.d = paramanra.a().jdField_a_of_type_JavaLangString;
          if (QLog.isColorLevel()) {
            QLog.d("Apollo_PanelManager", 2, new Object[] { "[previewNewAction] mSlaveExtJson=", localSpriteTaskParam.d });
          }
        }
      }
      paramanra = angi.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (paramanra != null) {
        paramanra.a().a(localSpriteTaskParam);
      }
      VipUtils.a(paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "action_preview_play", ApolloUtil.b(localSessionInfo.jdField_a_of_type_Int), 0, new String[] { String.valueOf(localApolloActionData.actionId) });
      return;
      bool = false;
      break;
    }
    paramanra = ((anyw)paramBaseChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).b(paramanra);
    int i;
    if (paramanra != null) {
      if (paramanra.gender == 1) {
        i = 1;
      }
    }
    for (;;)
    {
      label377:
      if (i != 0) {}
      for (paramanra = "-2";; paramanra = "-1")
      {
        localSpriteTaskParam.jdField_b_of_type_JavaLangString = paramanra;
        break;
        i = 0;
        break label377;
      }
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amtq
 * JD-Core Version:    0.7.0.1
 */