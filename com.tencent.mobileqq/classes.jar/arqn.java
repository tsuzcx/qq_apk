import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.data.MessageForLimitChatTopic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.limitchat.LimitChatUtil.2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class arqn
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
      paramAppInterface = (aoix)paramAppInterface.getManager(292);
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
  
  public static long a(QQAppInterface paramQQAppInterface, aofp paramaofp, long paramLong, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramaofp == null)) {
      return -1L;
    }
    int i = -4023;
    if (paramInt == 1) {
      i = -4024;
    }
    MessageForLimitChatTopic localMessageForLimitChatTopic = (MessageForLimitChatTopic)axaq.a(i);
    Object localObject = paramQQAppInterface.a().a(paramaofp.jdField_b_of_type_JavaLangString, 1044);
    if ((localObject != null) && (!((List)localObject).isEmpty())) {}
    for (long l = ((ChatMessage)((List)localObject).get(((List)localObject).size() - 1)).shmsgseq + 1L;; l = Math.abs(new Random().nextInt()))
    {
      paramLong -= 5L;
      localMessageForLimitChatTopic.init(paramQQAppInterface.getCurrentAccountUin(), paramaofp.jdField_b_of_type_JavaLangString, paramQQAppInterface.getCurrentAccountUin(), paramaofp.c, paramLong, i, 1044, l);
      localMessageForLimitChatTopic.isread = true;
      localMessageForLimitChatTopic.shmsgseq = l;
      localObject = new JSONObject();
      a((JSONObject)localObject, paramaofp);
      localMessageForLimitChatTopic.saveExtInfoToExtStr("match_chat_msg_data_key", ((JSONObject)localObject).toString());
      if (QLog.isDevelopLevel()) {
        QLog.i("LimitChatUtil", 4, String.format(Locale.getDefault(), "addTopicMessage in seq %s  time %s", new Object[] { Long.valueOf(l), Long.valueOf(paramLong) }));
      }
      if (!akau.a(paramQQAppInterface, localMessageForLimitChatTopic, false))
      {
        paramQQAppInterface.a().a(localMessageForLimitChatTopic, localMessageForLimitChatTopic.selfuin);
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
      paramAppInterface = (aoix)paramAppInterface.getManager(292);
      if (paramAppInterface == null) {
        break label93;
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
      paramAppInterface = null;
      continue;
      label93:
      paramAppInterface = null;
    }
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2, Long paramLong, String paramString3, int paramInt)
  {
    paramActivity.startActivityForResult(a(paramActivity, paramString1, paramString2, paramLong, paramString3, paramInt), a());
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LimitChatUtil", 2, "startAddFriendActivity " + paramString1 + " " + paramString2 + " " + paramString3);
    }
    int i = 8;
    if (String.valueOf(1).equals(paramString3)) {
      i = 9;
    }
    if ((paramContext instanceof Activity))
    {
      paramContext = (Activity)paramContext;
      paramString1 = AddFriendLogicActivity.a(paramContext, 1, paramString1, null, 3094, i, paramString2, null, null, paramContext.getResources().getString(2131690572), null);
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
          paramQQAppInterface = paramQQAppInterface.a().a();
        } while (paramQQAppInterface == null);
        if (!paramQQAppInterface.a(paramString)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("LimitChatUtil", 2, "tryAddRecentUser ,find rencentuser");
      return;
      paramString = paramQQAppInterface.a(paramString, 0);
      long l = NetConnInfoCenter.getServerTime();
      if (paramString.lastmsgtime < l) {
        paramString.lastmsgtime = l;
      }
      paramQQAppInterface.a(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("LimitChatUtil", 2, "tryAddRecentUser end");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, int paramInt2, boolean paramBoolean, MessageRecord paramMessageRecord, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LimitChatUtil", 2, String.format("addGrayTipsMessage frdUin:%s msg:%s ", new Object[] { paramString1, bbbd.a(paramString3) }));
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1))) {}
    do
    {
      return;
      l = awzw.a();
      if ((paramBoolean) || (paramMessageRecord == null) || (!a(paramQQAppInterface, paramString1, paramInt1, paramMessageRecord))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LimitChatUtil", 2, String.format("addGrayTipsMessage last tip message is same", new Object[0]));
    return;
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, String.format("addGrayTipsMessage start add tip message", new Object[0]));
    }
    paramString1 = new aquz(paramString1, paramQQAppInterface.getCurrentAccountUin(), paramString3, 1044, -5020, paramInt1, l);
    paramString1.c = paramString3;
    if (paramMessageRecord != null) {}
    for (long l = paramMessageRecord.shmsgseq;; l = Math.abs(new Random().nextInt()))
    {
      if (!TextUtils.isEmpty(paramString4))
      {
        paramMessageRecord = new Bundle();
        paramInt1 = paramString3.indexOf(paramString4);
        if (paramInt1 >= 0)
        {
          int i = paramString4.length();
          paramMessageRecord.putInt("key_action", paramInt2);
          paramMessageRecord.putString("textColor", "#40A0FF");
          paramMessageRecord.putString("key_action_DATA", paramString2);
          paramMessageRecord.putString("key_a_action_DATA", paramInt3 + "");
          paramString1.a(paramInt1, i + paramInt1, paramMessageRecord);
        }
      }
      paramString2 = new MessageForUniteGrayTip();
      paramString2.initGrayTipMsg(paramQQAppInterface, paramString1);
      paramString2.isread = true;
      paramString2.shmsgseq = l;
      paramString2.mNeedTimeStamp = true;
      paramString2.updateUniteGrayTipMsgData(paramQQAppInterface);
      paramQQAppInterface.a().a(paramString2, paramQQAppInterface.getCurrentAccountUin());
      return;
    }
  }
  
  public static void a(MessageRecord paramMessageRecord, QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnSubThread(new LimitChatUtil.2(paramQQAppInterface, paramMessageRecord));
  }
  
  private static void a(JSONObject paramJSONObject, aofp paramaofp)
  {
    JSONArray localJSONArray;
    boolean bool;
    try
    {
      if (paramaofp.c != null) {
        paramJSONObject.put("topic_msg", paramaofp.c);
      }
      if (paramaofp.a != null)
      {
        if (paramaofp.a.jdField_b_of_type_JavaLangString != null) {
          paramJSONObject.put("age", paramaofp.a.jdField_b_of_type_JavaLangString);
        }
        paramJSONObject.put("gender", paramaofp.a.jdField_a_of_type_Int);
        paramJSONObject.put("matchTagId", paramaofp.jdField_b_of_type_Int);
        paramJSONObject.put("matchTagName", paramaofp.f);
        if (paramaofp.a.c != null) {
          paramJSONObject.put("constellation", paramaofp.a.c);
        }
        if (paramaofp.a.e != null) {
          paramJSONObject.put("school", paramaofp.a.e);
        }
        if (paramaofp.a.f != null) {
          paramJSONObject.put("company", paramaofp.a.f);
        }
        if (paramaofp.a.d != null) {
          paramJSONObject.put("city", paramaofp.a.d);
        }
        if (paramaofp.a.g != null) {
          paramJSONObject.put("declaration", paramaofp.a.g);
        }
        if (paramaofp.a.h != null) {
          paramJSONObject.put("voiceUrl", paramaofp.a.h);
        }
        paramJSONObject.put("voiceDuration", paramaofp.a.jdField_b_of_type_Int);
        if (paramaofp.a.i != null) {
          paramJSONObject.put("signWords", paramaofp.a.i);
        }
        if (paramaofp.a.jdField_a_of_type_JavaUtilArrayList != null)
        {
          localJSONArray = new JSONArray();
          paramaofp = paramaofp.a.jdField_a_of_type_JavaUtilArrayList.iterator();
          for (;;)
          {
            if (!paramaofp.hasNext()) {
              break label429;
            }
            aogg localaogg = (aogg)paramaofp.next();
            if (localaogg.jdField_a_of_type_JavaLangString != null)
            {
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("tagName", localaogg.jdField_a_of_type_JavaLangString);
              if (localaogg.jdField_a_of_type_Int == 0) {
                break;
              }
              bool = true;
              localJSONObject.put("tagSame", bool);
              localJSONArray.put(localJSONObject);
            }
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("LimitChatUtil", 4, "initProfileJSON " + paramJSONObject);
      }
    }
    label429:
    do
    {
      bool = false;
      break;
    } while (localJSONArray.length() <= 0);
    paramJSONObject.put("personalTags", localJSONArray);
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 3342337) || (paramInt == 3342338) || (paramInt == 3342339);
  }
  
  @Deprecated
  public static boolean a(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return false;
    }
    return c(paramSessionInfo.jdField_a_of_type_Int);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    if ((paramQQAppInterface == null) || (paramMessageRecord == null) || (TextUtils.isEmpty(paramMessageRecord.frienduin))) {}
    String str;
    do
    {
      return false;
      int i = a(paramQQAppInterface);
      str = a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("LimitChatUtil", 2, "checkInterceptMessage, current state:" + i + " uin:" + str);
      }
    } while (paramMessageRecord.frienduin.equals(str));
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "checkInterceptMessage, intercept");
    }
    d(paramQQAppInterface, paramMessageRecord.frienduin);
    return true;
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
    ((aknv)paramQQAppInterface.getManager(285)).a(paramString);
    aojo.a(paramQQAppInterface, paramString);
  }
  
  public static boolean b(int paramInt)
  {
    return 1044 == paramInt;
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
    paramQQAppInterface = (aoep)paramQQAppInterface.getManager(264);
    if (paramQQAppInterface.a(paramString, true) == null)
    {
      ExtendFriendUserInfo localExtendFriendUserInfo = new ExtendFriendUserInfo();
      localExtendFriendUserInfo.uin = paramString;
      localExtendFriendUserInfo.miniProfileMsg = "{}";
      paramQQAppInterface.a(localExtendFriendUserInfo);
    }
  }
  
  @Deprecated
  public static boolean c(int paramInt)
  {
    return 1037 == paramInt;
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LimitChatUtil", 2, "getLimitChatState in mainprocess");
    }
    arqm.a().a(paramQQAppInterface, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     arqn
 * JD-Core Version:    0.7.0.1
 */