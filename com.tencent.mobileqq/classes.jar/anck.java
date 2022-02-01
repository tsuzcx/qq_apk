import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.ApolloEngine;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUtil.1;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Apollo3DMessage;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class anck
{
  private static int a;
  
  static
  {
    jdField_a_of_type_Int = 0;
  }
  
  public static int a()
  {
    return (int)(DeviceInfoUtil.getPortraitWidth() * 4L / 3L);
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return 0;
    case 7: 
      return 1;
    }
    return 2;
  }
  
  public static int a(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    if ((paramInt1 == 0) || (8 == paramInt1)) {
      paramInt2 = ApolloUtil.b(208.0F, paramString, paramInt3);
    }
    do
    {
      do
      {
        return paramInt2;
        if (3 == paramInt1) {
          return 32;
        }
        if (6 != paramInt1) {
          break;
        }
        paramInt2 = 33;
      } while (paramInt3 != 2);
      return 75;
      if (7 == paramInt1)
      {
        if (paramInt3 != 2) {
          break;
        }
        return 74;
      }
    } while (9 == paramInt1);
    QLog.d("cmshow_scripted_SpriteUtil", 1, new Object[] { "Other bubble type, NOT Handle, bubbleType:", Integer.valueOf(paramInt1), ", bubbleId:", Integer.valueOf(32) });
    return 32;
  }
  
  public static int a(int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, boolean paramBoolean3)
  {
    int i = 26;
    paramInt2 = 0;
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        break label89;
      }
      if (paramBoolean3) {
        paramInt2 = 81;
      }
    }
    else if (!paramBoolean1)
    {
      if (!paramBoolean2) {
        break label101;
      }
      if (!paramBoolean3) {
        break label95;
      }
      paramInt2 = 84;
    }
    for (;;)
    {
      if (ApolloUtil.e(paramInt1, paramInt2)) {
        return paramInt2;
      }
      QLog.w("cmshow_scripted_SpriteUtil", 1, "nick bubble not exist, id:" + paramInt2);
      paramInt1 = i;
      if (paramBoolean1) {
        paramInt1 = 25;
      }
      return paramInt1;
      paramInt2 = 82;
      break;
      label89:
      paramInt2 = 25;
      break;
      label95:
      paramInt2 = 83;
      continue;
      label101:
      paramInt2 = 26;
    }
    return paramInt2;
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    return amme.b(paramQQAppInterface);
  }
  
  public static amqr a(String paramString1, QQAppInterface paramQQAppInterface, int paramInt, String paramString2)
  {
    for (;;)
    {
      try
      {
        paramString1 = new JSONObject(paramString1);
        int j = paramString1.optInt("isNeedRemark");
        JSONArray localJSONArray1 = paramString1.optJSONArray("uins");
        paramString1 = new JSONObject();
        JSONArray localJSONArray2 = new JSONArray();
        int i = 0;
        if (i < localJSONArray1.length())
        {
          JSONObject localJSONObject = new JSONObject();
          String str1 = localJSONArray1.optString(i);
          if (j == 0)
          {
            bool = true;
            String str2 = a(paramQQAppInterface, paramInt, str1, paramString2, bool);
            localJSONObject.put("uin", str1);
            localJSONObject.put("nickname", str2);
            localJSONArray2.put(localJSONObject);
            i += 1;
          }
        }
        else
        {
          paramString1.put("nicknames", localJSONArray2);
          paramQQAppInterface = new amqr();
          paramQQAppInterface.jdField_b_of_type_Boolean = true;
          paramQQAppInterface.jdField_a_of_type_JavaLangString = paramString1.toString();
          return paramQQAppInterface;
        }
      }
      catch (Throwable paramString1)
      {
        QLog.e("cmshow_scripted_SpriteUtil", 1, paramString1, new Object[0]);
        return null;
      }
      boolean bool = false;
    }
  }
  
  public static anbt a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return (anbt)((anch)paramQQAppInterface.getManager(QQManagerFactory.SPRITE_SCRIPT_MANAGER)).a().a(0);
  }
  
  public static anbz a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return null;
      paramQQAppInterface = a(paramQQAppInterface);
    } while (paramQQAppInterface == null);
    return paramQQAppInterface.a();
  }
  
  public static ancc a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return ((anch)paramQQAppInterface.getManager(QQManagerFactory.SPRITE_SCRIPT_MANAGER)).a();
  }
  
  public static ancd a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return ((anch)paramQQAppInterface.getManager(QQManagerFactory.SPRITE_SCRIPT_MANAGER)).a();
  }
  
  public static anch a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return (anch)paramQQAppInterface.getManager(QQManagerFactory.SPRITE_SCRIPT_MANAGER);
  }
  
  public static ApolloActionData a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    return ((ankc)paramQQAppInterface.getManager(QQManagerFactory.APOOLO_DAO_MANAGER)).d(paramInt);
  }
  
  public static MessageForApollo a(String paramString, ancc paramancc)
  {
    for (;;)
    {
      try
      {
        if (paramancc.a() == null) {
          return null;
        }
        JSONObject localJSONObject = new JSONObject(new JSONObject(paramString).optString("basicMsg"));
        Object localObject = new ApolloMessage();
        ((ApolloMessage)localObject).id = localJSONObject.optInt("id");
        paramString = localJSONObject.optString("name");
        if (!TextUtils.isEmpty(paramString)) {
          ((ApolloMessage)localObject).name = bhcu.decode(paramString.getBytes("utf-8"), 0);
        }
        ((ApolloMessage)localObject).flag = localJSONObject.optInt("flag");
        ((ApolloMessage)localObject).peer_status = localJSONObject.optInt("peerStatus");
        ((ApolloMessage)localObject).sender_status = localJSONObject.optInt("senderStatus");
        ((ApolloMessage)localObject).peer_ts = localJSONObject.optLong("peerTS");
        ((ApolloMessage)localObject).sender_ts = localJSONObject.optLong("senderTS");
        ((ApolloMessage)localObject).peer_uin = localJSONObject.optLong("peerUin");
        paramString = localJSONObject.optString("atText");
        if (!paramString.isEmpty()) {
          ((ApolloMessage)localObject).text = bhcu.decode(paramString.getBytes("utf-8"), 0);
        }
        paramString = localJSONObject.optJSONObject("extraStr");
        localJSONObject = localJSONObject.optJSONObject("extendJson");
        if (paramString == null)
        {
          paramString = new JSONObject();
          if (localJSONObject != null) {
            paramString.put("extendJson", localJSONObject);
          }
          ((ApolloMessage)localObject).extStr = paramString.toString();
          paramancc = bcsa.a(paramancc.a(), paramancc.a().sessionInfo.curFriendUin, paramancc.a().sessionInfo.troopUin, paramancc.jdField_a_of_type_Int, (ApolloMessage)localObject);
          paramancc.inputText = paramString.optString("inputText");
          paramancc.audioId = paramString.optInt("audioID");
          if (paramString.has("audioStartTime")) {
            paramancc.audioStartTime = ((float)paramString.optDouble("audioStartTime"));
          }
          paramancc.actionType = paramString.optInt("actionType");
          paramancc.msgType = paramString.optInt("msgTyep");
          paramancc.welcomeId = paramString.optLong("welcomeId");
          if (localJSONObject != null) {
            paramancc.extendJson = localJSONObject.toString();
          }
          if (paramString.has("mApollo3DMessage"))
          {
            paramString = paramString.getJSONObject("mApollo3DMessage");
            localObject = new Apollo3DMessage();
            ((Apollo3DMessage)localObject).setMessageWithJSONObject(paramString);
            paramancc.mApollo3DMessage = ((Apollo3DMessage)localObject);
          }
          return paramancc;
        }
      }
      catch (Throwable paramString)
      {
        QLog.e("cmshow_scripted_SpriteUtil", 1, paramString, new Object[0]);
        return null;
      }
    }
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteUtil", 2, new Object[] { "[getSpriteName], uin:", paramString1, ",sessionType:", Integer.valueOf(paramInt), ",groupUin:", paramString2, ",isNeedRemark:", Boolean.valueOf(paramBoolean) });
    }
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString1)))
    {
      paramString1 = "";
      return paramString1;
    }
    if (("-1".equals(paramString1)) || ("-2".equals(paramString1))) {
      return "";
    }
    String str = "";
    if (-1 == paramInt) {
      paramString2 = ContactUtils.getBuddyNickName(paramQQAppInterface, paramString1, true);
    }
    label254:
    do
    {
      for (;;)
      {
        paramQQAppInterface = paramString2;
        if (!TextUtils.isEmpty(paramString2)) {
          paramQQAppInterface = paramString2.replace("\\", "").replace("'", "").replace("\"", "");
        }
        if (TextUtils.isEmpty(paramQQAppInterface)) {
          break;
        }
        return paramQQAppInterface;
        if ((paramInt != 1) && (paramInt != 3000)) {
          break label275;
        }
        if (paramBoolean) {}
        for (str = ContactUtils.getTroopMemberNameRemarkFirst(paramQQAppInterface, paramString2, paramString1);; str = ContactUtils.getTroopMemberNameWithoutRemark(paramQQAppInterface, paramString2, paramString1))
        {
          if (!TextUtils.isEmpty(str))
          {
            paramString2 = str;
            if (!str.equals(paramString1)) {
              break;
            }
          }
          paramString2 = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString1);
          if (paramString2 == null) {
            break label254;
          }
          paramString2 = paramString2.name;
          break;
        }
        ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString1, false);
        paramString2 = str;
      }
      paramString2 = str;
    } while (paramInt != 0);
    label275:
    if (paramBoolean) {}
    for (str = ContactUtils.getFriendNameCheckFriends(paramQQAppInterface, paramString1);; str = ContactUtils.getBuddyNickName(paramQQAppInterface, paramString1, true))
    {
      paramString2 = str;
      if (!paramString1.equals(str)) {
        break;
      }
      ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(paramString1, false);
      paramString2 = str;
      break;
    }
  }
  
  public static String a(String paramString)
  {
    String str = "";
    if (paramString != null) {
      str = Pattern.compile("\\s*|\t|\r|\n").matcher(paramString).replaceAll("");
    }
    return str;
  }
  
  public static void a(int paramInt, Object... paramVarArgs)
  {
    if (BaseApplicationImpl.sProcessId != 1) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = BaseApplicationImpl.getApplication().peekAppRuntime();
      } while ((localObject == null) || (!(localObject instanceof QQAppInterface)));
      localObject = a((QQAppInterface)localObject);
    } while (localObject == null);
    int i = paramInt;
    if (paramInt == 0) {
      i = -100;
    }
    ((anch)localObject).a(i, paramVarArgs);
  }
  
  public static void a(ancc paramancc, List<SpriteTaskParam> paramList)
  {
    if ((paramancc == null) || (paramList == null) || (paramList.size() == 0)) {}
    do
    {
      return;
      paramancc = a(paramancc.a());
    } while (paramancc == null);
    paramancc.a().a(paramList);
  }
  
  public static void a(anct paramanct, int paramInt, ApolloActionData paramApolloActionData)
  {
    if (paramanct == null) {
      return;
    }
    SpriteTaskParam localSpriteTaskParam = new SpriteTaskParam();
    localSpriteTaskParam.f = paramApolloActionData.actionId;
    localSpriteTaskParam.k = paramInt;
    localSpriteTaskParam.jdField_c_of_type_Int = paramApolloActionData.actionType;
    localSpriteTaskParam.g = 5;
    localSpriteTaskParam.e = 0;
    localSpriteTaskParam.jdField_a_of_type_Long = 1000000L;
    localSpriteTaskParam.jdField_a_of_type_Boolean = true;
    localSpriteTaskParam.jdField_b_of_type_Boolean = false;
    paramApolloActionData = paramanct.a();
    if ((paramApolloActionData != null) && (paramApolloActionData.a() != null)) {
      localSpriteTaskParam.jdField_a_of_type_JavaLangString = String.valueOf(paramApolloActionData.jdField_b_of_type_JavaLangString);
    }
    paramanct.a().a(localSpriteTaskParam);
  }
  
  public static void a(anct paramanct, String paramString, int paramInt1, int paramInt2)
  {
    if ((paramanct == null) || (paramanct.a() == null)) {
      return;
    }
    anbt localanbt = paramanct.a();
    paramanct.a().a(paramInt1);
    paramanct = paramanct.a();
    int i = 1;
    if (paramanct != null) {
      i = amme.a(paramanct, paramanct.getCurrentUin());
    }
    localanbt.a("", paramString, a(paramInt1, paramInt2, paramString, i));
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      return;
      paramQQAppInterface = a(paramQQAppInterface);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.jdField_a_of_type_Boolean = true;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (paramQQAppInterface == null)) {}
    ancc localancc;
    int k;
    label71:
    do
    {
      do
      {
        return;
        localancc = a(paramQQAppInterface);
      } while (localancc == null);
      k = localancc.jdField_a_of_type_Int;
      if ((1 == k) || (3000 == k))
      {
        i = 0;
        int j;
        if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString))
        {
          if (paramSpriteTaskParam.jdField_b_of_type_Boolean) {
            i = 2;
          }
        }
        else
        {
          if (!paramSpriteTaskParam.jdField_a_of_type_Boolean) {
            break label161;
          }
          j = 0;
          k = ApolloUtil.b(k);
          str = Integer.toString(paramSpriteTaskParam.f);
          if (paramSpriteTaskParam.e != 0) {
            break label166;
          }
        }
        for (paramSpriteTaskParam = "0";; paramSpriteTaskParam = "1")
        {
          VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "g_msg_clk", j, k, new String[] { str, paramSpriteTaskParam, String.valueOf(i), String.valueOf(System.currentTimeMillis() / 1000L), localancc.jdField_a_of_type_JavaLangString });
          return;
          i = 1;
          break;
          j = 1;
          break label71;
        }
      }
    } while (k != 0);
    label161:
    label166:
    String str = "0";
    if (!TextUtils.isEmpty(paramSpriteTaskParam.jdField_c_of_type_JavaLangString)) {
      str = "1";
    }
    if (paramSpriteTaskParam.jdField_a_of_type_Boolean) {}
    for (int i = 0;; i = 1)
    {
      VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "msg_clk", i, 0, new String[] { Integer.toString(paramSpriteTaskParam.f), str, "", String.valueOf(System.currentTimeMillis() / 1000L), localancc.jdField_a_of_type_JavaLangString });
      return;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    if (paramQQAppInterface == null) {}
    do
    {
      return true;
      if (-1 == paramQQAppInterface.d) {
        paramQQAppInterface.b();
      }
    } while (paramQQAppInterface.d == 1);
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    if ((paramInt == 1) || (paramInt == 3000))
    {
      HotChatManager localHotChatManager = (HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER);
      if ((localHotChatManager != null) && (localHotChatManager.b(paramString)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteUtil", 2, "cmshow NOT support hot chat right now.");
        }
        return false;
      }
    }
    if ((paramInt == 1) && (TroopInfo.isQidianPrivateTroop(paramQQAppInterface, paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteUtil", 2, "cmshow NOT support isQidianPrivateTroop now.");
      }
      return false;
    }
    if ((paramInt == 0) && (bhbx.b(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteUtil", 2, "cmshow NOT support isBabyQUin now.");
      }
      return false;
    }
    if ((paramInt != 1) && (paramInt != 0) && ((paramInt != 3000) || (amme.c("discuss") != 1)) && ((!a(paramInt)) || (!anjy.f)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteUtil", 2, "cmshow NOT support, not friend or troop or discussion.");
      }
      return false;
    }
    return true;
  }
  
  public static boolean a(String paramString, SpriteTaskParam paramSpriteTaskParam, ancc paramancc, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((TextUtils.isEmpty(paramString)) || (paramancc == null) || (paramancc.a() == null)) {
      bool1 = false;
    }
    label111:
    do
    {
      do
      {
        do
        {
          return bool1;
          paramancc = paramancc.a().getCurrentAccountUin();
          if ((TextUtils.isEmpty(paramSpriteTaskParam.jdField_b_of_type_JavaLangString)) || (paramSpriteTaskParam.jdField_b_of_type_JavaLangString.length() <= 4)) {
            break label111;
          }
          if ((!paramString.equals(paramSpriteTaskParam.jdField_b_of_type_JavaLangString)) || (!paramString.equals(paramancc))) {
            break;
          }
          bool1 = bool2;
        } while (!paramString.equals(paramSpriteTaskParam.jdField_a_of_type_JavaLangString));
        if (!paramString.equals(paramSpriteTaskParam.jdField_a_of_type_JavaLangString)) {
          break;
        }
        bool1 = bool2;
      } while (paramBoolean);
      return false;
      if (TextUtils.isEmpty(paramSpriteTaskParam.jdField_a_of_type_JavaLangString)) {
        break;
      }
      bool1 = bool2;
    } while (paramString.equals(paramancc));
    return false;
    return false;
  }
  
  public static int b()
  {
    return (int)DeviceInfoUtil.getPortraitWidth();
  }
  
  public static int b(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 1;
    case 1: 
      return 2;
    case 2: 
      return 3;
    }
    return 113;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      ancc localancc;
      SharedPreferences localSharedPreferences;
      int i;
      do
      {
        do
        {
          do
          {
            return;
            localancc = a(paramQQAppInterface);
          } while (localancc == null);
          localSharedPreferences = localancc.jdField_a_of_type_AndroidContentSharedPreferences;
        } while (localSharedPreferences == null);
        i = localSharedPreferences.getInt("audio_tips_times" + localancc.jdField_b_of_type_JavaLangString, 0);
        if (QLog.isColorLevel()) {
          QLog.d("cmshow_scripted_SpriteUtil", 2, "totalTimes:" + i);
        }
      } while (3 == i);
      localSharedPreferences.edit().putInt("audio_tips_times" + localancc.jdField_b_of_type_JavaLangString, i + 1).commit();
      paramQQAppInterface = paramQQAppInterface.getHandler(ChatActivity.class);
    } while (paramQQAppInterface == null);
    paramQQAppInterface.post(new SpriteUtil.1());
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = a(paramQQAppInterface);
    return (paramQQAppInterface == null) || (paramQQAppInterface.b());
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    int i = b(0);
    if (!d(paramQQAppInterface))
    {
      anis.a(i, 10, 102, new Object[] { "not meet basic case" });
      QLog.i("cmshow_scripted_SpriteUtil", 1, "not meet basic case.");
    }
    do
    {
      do
      {
        return false;
        if (2 == anhm.a(paramQQAppInterface.getCurrentUin(), paramQQAppInterface))
        {
          anis.a(i, 10, 101, new Object[] { "cmshow switch NOT opend CLOSED_STATUS" });
          QLog.i("cmshow_scripted_SpriteUtil", 1, "cmshow switch NOT opend.");
          return false;
        }
        if (!nty.a().a(paramString)) {
          break;
        }
        anis.a(i, 10, 104, new Object[] { "aio anonymous" });
      } while (!QLog.isColorLevel());
      QLog.d("cmshow_scripted_SpriteUtil", 2, "aio anonymous.");
      return false;
    } while ((!a(paramQQAppInterface, paramInt, paramString)) || (b(paramQQAppInterface)));
    paramQQAppInterface = new SessionInfo();
    paramQQAppInterface.curType = paramInt;
    paramQQAppInterface.curFriendUin = paramString;
    return true;
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    return (!b(paramQQAppInterface)) && (anmk.d());
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {}
    do
    {
      do
      {
        return false;
        if (amme.b(BaseApplicationImpl.getContext())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("cmshow_scripted_SpriteUtil", 2, "NOT allowed to use cmshow.");
      return false;
    } while (!ApolloEngine.a());
    return true;
  }
  
  public static boolean e(QQAppInterface paramQQAppInterface)
  {
    if (!d(paramQQAppInterface))
    {
      QLog.i("cmshow_scripted_SpriteUtil", 1, "not meet basic case.");
      return false;
    }
    if (1 != anhm.a(paramQQAppInterface.getCurrentUin(), paramQQAppInterface))
    {
      QLog.i("cmshow_scripted_SpriteUtil", 1, "cmshow switch NOT opend.");
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anck
 * JD-Core Version:    0.7.0.1
 */