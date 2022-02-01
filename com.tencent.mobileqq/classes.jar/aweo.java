import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.limitchat.LimitChatUtil.3;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aweo
{
  public static int a()
  {
    return 16001;
  }
  
  public static int a(AppInterface paramAppInterface)
  {
    int j = 0;
    int i;
    if ((paramAppInterface instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatState in mainprocess");
      }
      paramAppInterface = (asqt)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
      if (paramAppInterface == null) {
        break label97;
      }
      i = paramAppInterface.a();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatState :" + i);
      }
      return i;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("LimitChatUtil", 2, "getLimitChatState in otherprocess,ERROR");
        i = j;
        continue;
        label97:
        i = 0;
      }
    }
  }
  
  public static long a(QQAppInterface paramQQAppInterface, asne paramasne, long paramLong, int paramInt)
  {
    return a(paramQQAppInterface, paramasne, paramLong, paramInt, 1044);
  }
  
  public static long a(QQAppInterface paramQQAppInterface, asne paramasne, long paramLong, int paramInt1, int paramInt2)
  {
    if ((paramQQAppInterface == null) || (paramasne == null)) {
      return -1L;
    }
    int i = -4023;
    if (paramInt1 != 1)
    {
      paramInt1 = i;
      if (paramInt2 != 1045) {}
    }
    else
    {
      paramInt1 = -4024;
    }
    MessageForLimitChatTopic localMessageForLimitChatTopic = (MessageForLimitChatTopic)bcsa.a(paramInt1);
    Object localObject = paramQQAppInterface.getMessageFacade().getAIOList(paramasne.jdField_b_of_type_JavaLangString, paramInt2);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {}
    for (long l = ((ChatMessage)((List)localObject).get(((List)localObject).size() - 1)).shmsgseq + 1L;; l = Math.abs(new Random().nextInt()))
    {
      paramLong -= 5L;
      localMessageForLimitChatTopic.init(paramQQAppInterface.getCurrentAccountUin(), paramasne.jdField_b_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramasne.jdField_c_of_type_JavaLangString, paramLong, paramInt1, paramInt2, l);
      localMessageForLimitChatTopic.isread = true;
      localMessageForLimitChatTopic.shmsgseq = l;
      localObject = new JSONObject();
      a((JSONObject)localObject, paramasne);
      localMessageForLimitChatTopic.saveExtInfoToExtStr("match_chat_msg_data_key", ((JSONObject)localObject).toString());
      if (QLog.isDevelopLevel()) {
        QLog.i("LimitChatUtil", 4, String.format(Locale.getDefault(), "addTopicMessage in seq %s  time %s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) }));
      }
      if (!anyv.a(paramQQAppInterface, localMessageForLimitChatTopic, false))
      {
        paramQQAppInterface.getMessageFacade().addMessage(localMessageForLimitChatTopic, localMessageForLimitChatTopic.selfuin);
        if (QLog.isDevelopLevel()) {
          QLog.i("LimitChatUtil", 4, String.format(Locale.getDefault(), "addTopicMessage in 2", new Object[0]));
        }
      }
      return localMessageForLimitChatTopic.time;
    }
  }
  
  private static Intent a(Context paramContext, String paramString1, String paramString2, Long paramLong, String paramString3, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "makeIntent, uin:" + paramString1 + " nick:" + paramString2 + " timestamp:" + paramLong + " topic:" + paramString3);
    }
    paramContext = new Intent(paramContext, ChatActivity.class);
    paramContext.putExtra("uin", paramString1);
    paramContext.putExtra("uinname", paramString2);
    paramContext.putExtra("uintype", 1044);
    if (paramInt == 0) {
      paramContext.putExtra("entrance", 21);
    }
    for (;;)
    {
      paramContext.putExtra("key_limitchat_auto_open", true);
      paramString1 = new Bundle();
      paramString1.putInt("key_limitchat_from_type", paramInt);
      paramContext.putExtras(paramString1);
      return paramContext;
      paramContext.putExtra("entrance", 20);
    }
  }
  
  public static String a(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatUin in mainprocess");
      }
      paramAppInterface = (asqt)paramAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER);
      if (paramAppInterface == null) {
        break label95;
      }
      paramAppInterface = paramAppInterface.a();
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatUin :" + paramAppInterface);
      }
      return paramAppInterface;
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "getLimitChatState in otherprocess");
      }
      paramAppInterface = "";
      continue;
      label95:
      paramAppInterface = null;
    }
  }
  
  public static void a(Activity paramActivity, asne paramasne, String paramString, int paramInt)
  {
    String str1 = paramasne.jdField_b_of_type_JavaLangString;
    String str2 = paramasne.jdField_c_of_type_JavaLangString;
    paramString = a(paramActivity, str1, paramString, Long.valueOf(paramasne.jdField_a_of_type_Long), str2, paramInt);
    paramString.putExtra("need_check_apollo_dress_up", true);
    paramInt = aici.d;
    if (paramasne.jdField_b_of_type_Int == 0) {
      paramInt = aici.e;
    }
    for (;;)
    {
      paramString.putExtra("key_limitchat_enter_type", paramInt);
      paramActivity.startActivityForResult(paramString, a());
      return;
      if (paramasne.jdField_b_of_type_Int == 1) {
        paramInt = aici.d;
      } else if (paramasne.jdField_b_of_type_Int >= 2) {
        paramInt = aici.f;
      }
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LimitChatUtil", 2, "startAddFriendActivity " + paramString1 + " " + paramString2 + " " + paramString3);
    }
    paramString3 = ((aslo)((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).a(paramString1, false);
    int i = 8;
    if (paramString3 != null) {
      i = ExtendFriendUserInfo.fromTypeToSubID(paramString3.fromType);
    }
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      paramString1 = AddFriendLogicActivity.a(paramContext, 1, paramString1, null, 3094, i, paramString2, null, null, paramContext.getResources().getString(2131690676), null);
      if (paramString1 != null) {
        paramString1.putExtra("entrance", 1);
      }
      paramContext.startActivityForResult(paramString1, 16002);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("LimitChatUtil", 2, "tryAddRecentUser begin");
          }
          paramQQAppInterface = paramQQAppInterface.getProxyManager().a();
        } while (paramQQAppInterface == null);
        if (!paramQQAppInterface.isUinInRecent(paramString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LimitChatUtil", 2, "tryAddRecentUser ,find rencentuser");
      return;
      paramString = (RecentUser)paramQQAppInterface.findRecentUserByUin(paramString, 0);
      long l = NetConnInfoCenter.getServerTime();
      if (paramString.lastmsgtime < l) {
        paramString.lastmsgtime = l;
      }
      paramQQAppInterface.saveRecentUser(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("LimitChatUtil", 2, "tryAddRecentUser end");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, String paramString4, int paramInt3, boolean paramBoolean, MessageRecord paramMessageRecord, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LimitChatUtil", 2, String.format("addGrayTipsMessage frdUin:%s msg:%s ", new Object[] { paramString1, bhbx.a(paramString3) }));
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      l = bcrg.a();
      if ((paramBoolean) || (paramMessageRecord == null) || (!a(paramQQAppInterface, paramString1, paramInt2, paramMessageRecord))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LimitChatUtil", 2, String.format("addGrayTipsMessage last tip message is same", new Object[0]));
    return;
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, String.format("addGrayTipsMessage start add tip message", new Object[0]));
    }
    paramString1 = new avhz(paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString3, paramInt1, -5020, paramInt2, l);
    paramString1.jdField_c_of_type_JavaLangString = paramString3;
    if (paramMessageRecord != null) {}
    for (long l = paramMessageRecord.shmsgseq;; l = Math.abs(new Random().nextInt()))
    {
      if (!TextUtils.isEmpty(paramString4))
      {
        paramMessageRecord = new Bundle();
        paramInt1 = paramString3.indexOf(paramString4);
        if (paramInt1 >= 0)
        {
          paramInt2 = paramString4.length();
          paramMessageRecord.putInt("key_action", paramInt3);
          paramMessageRecord.putString("textColor", "#40A0FF");
          paramMessageRecord.putString("key_action_DATA", paramString2);
          paramMessageRecord.putString("key_a_action_DATA", paramInt4 + "");
          paramString1.a(paramInt1, paramInt2 + paramInt1, paramMessageRecord);
        }
      }
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
      paramString2.isread = true;
      paramString2.shmsgseq = l;
      paramString2.mNeedTimeStamp = true;
      paramString2.updateUniteGrayTipMsgData(paramQQAppInterface);
      paramQQAppInterface.getMessageFacade().addMessage(paramString2, paramQQAppInterface.getCurrentAccountUin());
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    aslo localaslo = (aslo)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    ExtendFriendUserInfo localExtendFriendUserInfo = localaslo.a(paramString1, true);
    paramQQAppInterface = localExtendFriendUserInfo;
    if (localExtendFriendUserInfo == null) {
      paramQQAppInterface = new ExtendFriendUserInfo();
    }
    paramQQAppInterface.uin = paramString1;
    if (paramBoolean) {}
    for (paramString1 = "{}";; paramString1 = null)
    {
      paramQQAppInterface.miniProfileMsg = paramString1;
      paramQQAppInterface.tagID = paramInt;
      paramQQAppInterface.tagName = paramString2;
      localaslo.a(paramQQAppInterface);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt1, String paramString2, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, int paramInt3)
  {
    aslo localaslo = (aslo)paramQQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    ExtendFriendUserInfo localExtendFriendUserInfo = localaslo.a(paramString1, true);
    paramQQAppInterface = localExtendFriendUserInfo;
    if (localExtendFriendUserInfo == null) {
      paramQQAppInterface = new ExtendFriendUserInfo();
    }
    paramQQAppInterface.uin = paramString1;
    if (paramBoolean1)
    {
      paramString1 = "{}";
      paramQQAppInterface.miniProfileMsg = paramString1;
      paramQQAppInterface.tagID = paramInt1;
      paramQQAppInterface.tagName = paramString2;
      paramQQAppInterface.distance = paramInt2;
      if ((!paramBoolean2) || (paramInt2 < 0)) {
        break label109;
      }
    }
    label109:
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      paramQQAppInterface.showDistanceHLight = paramBoolean1;
      paramQQAppInterface.fromType = paramInt3;
      localaslo.a(paramQQAppInterface);
      return;
      paramString1 = null;
      break;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new LimitChatUtil.3(paramQQAppInterface, paramMessageRecord));
  }
  
  private static void a(JSONObject paramJSONObject, asne paramasne)
  {
    JSONArray localJSONArray;
    Iterator localIterator;
    Object localObject;
    JSONObject localJSONObject;
    boolean bool;
    try
    {
      if (paramasne.jdField_c_of_type_JavaLangString != null) {
        paramJSONObject.put("topic_msg", paramasne.jdField_c_of_type_JavaLangString);
      }
      if (paramasne.jdField_a_of_type_Asmk != null)
      {
        if (paramasne.jdField_a_of_type_Asmk.jdField_b_of_type_JavaLangString != null) {
          paramJSONObject.put("age", paramasne.jdField_a_of_type_Asmk.jdField_b_of_type_JavaLangString);
        }
        paramJSONObject.put("gender", paramasne.jdField_a_of_type_Asmk.jdField_a_of_type_Int);
        paramJSONObject.put("matchTagId", paramasne.jdField_b_of_type_Int);
        paramJSONObject.put("matchTagName", paramasne.f);
        if (paramasne.jdField_a_of_type_Asmk.jdField_c_of_type_JavaLangString != null) {
          paramJSONObject.put("constellation", paramasne.jdField_a_of_type_Asmk.jdField_c_of_type_JavaLangString);
        }
        if (paramasne.jdField_a_of_type_Asmk.e != null) {
          paramJSONObject.put("school", paramasne.jdField_a_of_type_Asmk.e);
        }
        if (paramasne.jdField_a_of_type_Asmk.f != null) {
          paramJSONObject.put("company", paramasne.jdField_a_of_type_Asmk.f);
        }
        if (paramasne.jdField_a_of_type_Asmk.d != null) {
          paramJSONObject.put("city", paramasne.jdField_a_of_type_Asmk.d);
        }
        if (paramasne.jdField_a_of_type_Asmk.g != null) {
          paramJSONObject.put("declaration", paramasne.jdField_a_of_type_Asmk.g);
        }
        if (paramasne.jdField_a_of_type_Asmk.h != null) {
          paramJSONObject.put("voiceUrl", paramasne.jdField_a_of_type_Asmk.h);
        }
        paramJSONObject.put("voiceDuration", paramasne.jdField_a_of_type_Asmk.jdField_b_of_type_Int);
        if (paramasne.jdField_a_of_type_Asmk.i != null) {
          paramJSONObject.put("signWords", paramasne.jdField_a_of_type_Asmk.i);
        }
        if (paramasne.jdField_a_of_type_Asmk.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localJSONArray = new JSONArray();
          localIterator = paramasne.jdField_a_of_type_Asmk.jdField_a_of_type_JavaUtilArrayList.iterator();
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label432;
            }
            localObject = (asno)localIterator.next();
            if (((asno)localObject).jdField_a_of_type_JavaLangString != null)
            {
              localJSONObject = new JSONObject();
              localJSONObject.put("tagName", ((asno)localObject).jdField_a_of_type_JavaLangString);
              if (((asno)localObject).jdField_a_of_type_Int == 0) {
                break;
              }
              bool = true;
              localJSONObject.put("tagSame", bool);
              localJSONArray.put(localJSONObject);
            }
          }
        }
      }
      else
      {
        return;
      }
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("LimitChatUtil", 4, "initProfileJSON " + paramJSONObject);
      }
    }
    label432:
    do
    {
      bool = false;
      break;
      if (localJSONArray.length() > 0) {
        paramJSONObject.put("personalTags", localJSONArray);
      }
      paramJSONObject.put("popular", paramasne.jdField_a_of_type_Asmk.jdField_a_of_type_Long);
      if (paramasne.jdField_a_of_type_Asmk.jdField_b_of_type_JavaUtilArrayList != null)
      {
        localJSONArray = new JSONArray();
        localIterator = paramasne.jdField_a_of_type_Asmk.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (localIterator.hasNext())
        {
          localObject = (asnp)localIterator.next();
          if (((asnp)localObject).jdField_a_of_type_JavaLangString != null)
          {
            localJSONObject = new JSONObject();
            localJSONObject.put("shcool_name", ((asnp)localObject).jdField_a_of_type_JavaLangString);
            localJSONObject.put("shcool_state", ((asnp)localObject).jdField_a_of_type_Long);
            localJSONArray.put(localJSONObject);
          }
        }
        if (localJSONArray.length() > 0) {
          paramJSONObject.put("shcoolInfos", localJSONArray);
        }
      }
    } while (paramasne.jdField_a_of_type_Asmk.jdField_c_of_type_Int < 0);
    paramJSONObject.put("distance", paramasne.jdField_a_of_type_Asmk.jdField_c_of_type_Int);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3342337) || (paramInt == 3342338) || (paramInt == 3342339) || (paramInt == 459802) || (paramInt == 459803) || (paramInt == 459817);
  }
  
  @Deprecated
  public static boolean a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return false;
    }
    return c(paramSessionInfo.curType);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null) || (TextUtils.isEmpty(paramMessageRecord.frienduin))) {}
    String str;
    boolean bool;
    do
    {
      return false;
      int i = a(paramQQAppInterface);
      str = a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "checkInterceptMessage, current state:" + i + " uin:" + str);
      }
      bool = asrt.a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "checkInterceptMessage showEntry = " + bool);
      }
    } while ((paramMessageRecord.frienduin.equals(str)) && (bool));
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "checkInterceptMessage, intercept");
    }
    c(paramQQAppInterface, paramMessageRecord.frienduin);
    return true;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      Object localObject = paramQQAppInterface.getMessageFacade().getAllMessages(paramString, paramInt, null);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        Collections.sort((List)localObject, new awep());
        localObject = (MessageRecord)((List)localObject).get(((List)localObject).size() - 1);
        if ((localObject instanceof MessageForLimitChatTopic))
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("LimitChatUtil", 4, "clearLastTopicMessage done:" + ((MessageRecord)localObject).msgseq);
          }
          paramQQAppInterface.getMessageFacade().removeMsgByUniseq(paramString, paramInt, ((MessageRecord)localObject).uniseq);
          return true;
        }
      }
    }
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    while ((paramMessageRecord == null) || (!(paramMessageRecord instanceof MessageForUniteGrayTip)) || (((MessageForUniteGrayTip)paramMessageRecord).tipParam.jdField_b_of_type_Int != paramInt)) {
      return false;
    }
    return true;
  }
  
  public static boolean a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (!b(paramMessageRecord.istroop)) {
      return false;
    }
    return true;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString)
  {
    ((bbdh)paramQQAppInterface.getManager(QQManagerFactory.ICE_BREAKING_MNG)).a(paramString);
  }
  
  public static boolean b(int paramInt)
  {
    return (1044 == paramInt) || (1045 == paramInt);
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null) || (TextUtils.isEmpty(paramMessageRecord.frienduin))) {}
    boolean bool;
    do
    {
      return false;
      bool = asrt.a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "checkInterceptMatchMessage showEntry = " + bool);
      }
    } while (bool);
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "checkInterceptMatchMessage, intercept");
    }
    c(paramQQAppInterface, paramMessageRecord.frienduin);
    return true;
  }
  
  @Deprecated
  public static boolean b(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {}
    while (!c(paramMessageRecord.istroop)) {
      return false;
    }
    return true;
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "getLimitChatState in mainprocess");
    }
    awen.a().a(paramQQAppInterface, paramString);
  }
  
  @Deprecated
  public static boolean c(int paramInt)
  {
    return 1037 == paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aweo
 * JD-Core Version:    0.7.0.1
 */