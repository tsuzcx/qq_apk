import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public final class beki
{
  public static Bundle a(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("TOGETHER_BUNDLE_KEY_FROM_TYPE", paramInt);
    localBundle.putBoolean("TOGETHER_BUNDLE_KEY_OPEN_STATUS", paramBoolean);
    return localBundle;
  }
  
  public static Bundle a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString1, String paramString2, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("TOGETHER_BUNDLE_KEY_IS_OWNER", paramBoolean2);
    localBundle.putBoolean("TOGETHER_BUNDLE_KEY_IS_ADMIN", paramBoolean3);
    localBundle.putString("TOGETHER_BUNDLE_KEY_OWNER_UIN", paramString1);
    localBundle.putString("TOGETHER_BUNDLE_KEY_TROOP_UIN", paramString2);
    localBundle.putInt("TOGETHER_BUNDLE_KEY_FROM_TYPE", paramInt);
    localBundle.putBoolean("TOGETHER_BUNDLE_KEY_OPEN_STATUS", paramBoolean1);
    return localBundle;
  }
  
  public static <T extends bekh> T a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 2) {
      return new WatchTogetherSession(paramString);
    }
    if (paramInt1 == 4) {
      return new SingTogetherSession(paramInt2, paramString);
    }
    throw new UnsupportedOperationException("Can not generate an object.");
  }
  
  public static ChatMessage a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    List localList = paramQQAppInterface.getMessageFacade().getAIOList(paramString, paramInt);
    if ((localList == null) || (localList.isEmpty()))
    {
      paramQQAppInterface = null;
      return paramQQAppInterface;
    }
    paramInt = localList.size() - 1;
    for (;;)
    {
      if (paramInt < 0) {
        break label70;
      }
      paramString = (ChatMessage)localList.get(paramInt);
      paramQQAppInterface = paramString;
      if (!bcsc.a(paramString.msgtype)) {
        break;
      }
      paramInt -= 1;
    }
    label70:
    return null;
  }
  
  public static String a(int paramInt, String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return paramString;
      try
      {
        int i = azqw.a(paramString);
        if ((paramInt <= 0) || (TextUtils.isEmpty(paramString)) || (i <= paramInt)) {
          continue;
        }
        StringBuilder localStringBuilder = new StringBuilder();
        i = 0;
        for (;;)
        {
          int k;
          if (j < paramString.length())
          {
            k = paramString.codePointAt(j);
            if ((k < 32) || (k > 126)) {
              break label105;
            }
            i += 1;
          }
          for (;;)
          {
            localStringBuilder.appendCodePoint(k);
            if (i < paramInt) {
              break;
            }
            localStringBuilder.append("...");
            paramString = localStringBuilder.toString();
            return paramString;
            label105:
            if (k >= 65535)
            {
              i += 1;
              j += 1;
            }
            else
            {
              i += 2;
            }
          }
          j += 1;
        }
        return "";
      }
      catch (Throwable paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("TogetherUtils", 2, paramString.getMessage(), paramString);
        }
      }
    }
  }
  
  public static String a(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    Object localObject = paramString;
    String str;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_TROOP_UIN"))
    {
      str = paramBundle.getString("TOGETHER_BUNDLE_KEY_TROOP_UIN");
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localObject = bkyp.a(paramString, "troopuin", (String)localObject);
    }
    paramString = (String)localObject;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_OWNER_UIN"))
    {
      str = paramBundle.getString("TOGETHER_BUNDLE_KEY_OWNER_UIN");
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      paramString = bkyp.a((String)localObject, "troopowneruin", paramString);
    }
    localObject = paramString;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_IS_OWNER")) {
      localObject = bkyp.a(paramString, "isowner", paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_OWNER", false) + "");
    }
    paramString = (String)localObject;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_IS_ADMIN")) {
      paramString = bkyp.a((String)localObject, "isadmin", paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_ADMIN", false) + "");
    }
    localObject = paramString;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_OPEN_STATUS")) {
      localObject = bkyp.a(paramString, "isopen", paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_OPEN_STATUS", false) + "");
    }
    paramString = (String)localObject;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_FROM_TYPE")) {
      paramString = bkyp.a((String)localObject, "from", paramBundle.getInt("TOGETHER_BUNDLE_KEY_FROM_TYPE", 0) + "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherUtils", 2, new Object[] { "jumpToDefaultTogetherWatch, realJumpURL=", paramString });
    }
    return paramString;
  }
  
  public static void a(int paramInt, Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    Object localObject1;
    label13:
    Object localObject4;
    label20:
    Object localObject3;
    label28:
    Object localObject2;
    label36:
    Object localObject5;
    if (paramMap1 == null)
    {
      localObject1 = null;
      if (paramMap1 != null) {
        break label283;
      }
      paramMap1 = null;
      if (paramMap != null) {
        break label298;
      }
      localObject4 = null;
      if (localObject4 != null) {
        break label314;
      }
      localObject3 = null;
      if (localObject4 != null) {
        break label328;
      }
      localObject2 = null;
      if (localObject4 != null) {
        break label342;
      }
      localObject5 = "";
      label45:
      localObject5 = (String)localObject5;
      if (localObject4 != null) {
        break label356;
      }
      localObject4 = null;
      label63:
      localObject4 = (Integer)localObject4;
      if (localObject4 == null) {
        break label607;
      }
    }
    for (;;)
    {
      try
      {
        i = ((Integer)localObject4).intValue();
        j = i;
        if (paramMap == null)
        {
          localObject4 = null;
          if (paramMap != null) {
            continue;
          }
          paramMap = null;
          QLog.d("TogetherUtils", 1, new Object[] { "onArkTogetherClick params[", localObject1, " ", paramMap1, " ", localObject3, " ", localObject2, "]" });
          l2 = 0L;
          k = -1;
          l1 = l2;
          if (!(localObject3 instanceof Long)) {}
        }
      }
      catch (Throwable localThrowable)
      {
        try
        {
          l1 = ((Long)localObject3).longValue();
          localObject3 = null;
          if ((localObject2 instanceof String)) {
            localObject3 = (String)localObject2;
          }
          i = k;
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            i = k;
            if (TextUtils.isEmpty(paramMap1)) {}
          }
          try
          {
            bool = "2".equalsIgnoreCase((String)localObject1);
            if (!bool) {
              continue;
            }
            i = 2;
          }
          catch (Exception localException1)
          {
            boolean bool;
            label283:
            label298:
            label314:
            label328:
            label342:
            label356:
            String str;
            i = k;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.i("TogetherUtils", 2, localException1.getMessage(), localException1);
            i = k;
            continue;
            BaseActivity localBaseActivity = BaseActivity.sTopActivity;
            if (localBaseActivity != null) {
              continue;
            }
            QLog.d("TogetherUtils", 1, "onArkTogetherClick return null activity");
            return;
            localObject2 = new Bundle();
            ((Bundle)localObject2).putString("video_id", (String)localObject5);
            ((Bundle)localObject2).putInt("category_id", j);
            ((Bundle)localObject2).putString("title_name", str);
            ((Bundle)localObject2).putString("room_cover", paramMap);
            ((Bundle)localObject2).putString("song_id", localException2);
            bejv.a(localBaseActivity.app).a(localBaseActivity, paramInt, i, paramMap1, l1, 8, (Bundle)localObject2);
            return;
          }
          if (((i != 2) && (i != 1)) || (l1 == 0L))
          {
            QLog.d("TogetherUtils", 1, "onArkTogetherClick return invalid params");
            return;
            localObject1 = (String)paramMap1.get("chatType");
            break;
            paramMap1 = (String)paramMap1.get("chatUIN");
            break label13;
            localObject4 = (HashMap)paramMap.get("extra");
            break label20;
            localObject3 = ((Map)localObject4).get("aio_media_id");
            break label28;
            localObject2 = ((Map)localObject4).get("song_id");
            break label36;
            localObject5 = ((Map)localObject4).get("match_id");
            break label45;
            localObject4 = ((Map)localObject4).get("sub_type");
            break label63;
            localThrowable = localThrowable;
            QLog.e("TogetherUtils", 1, "categoryId to int ", localThrowable);
            j = 0;
            continue;
            str = (String)paramMap.get("summary");
            continue;
            paramMap = (String)paramMap.get("cover");
          }
        }
        catch (Exception localException2)
        {
          int j;
          long l2;
          int k;
          long l1 = l2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.i("TogetherUtils", 2, localException2.getMessage(), localException2);
          l1 = l2;
          continue;
          bool = "3".equalsIgnoreCase((String)localObject1);
          if (bool)
          {
            i = 1;
            continue;
          }
          i = -1;
          continue;
        }
      }
      label607:
      int i = 0;
    }
  }
  
  public static void a(@NonNull Context paramContext, int paramInt1, @NonNull String paramString1, @Nullable String paramString2, @NonNull Bundle paramBundle, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      QQToast.a(paramContext, 0, 2131720058, 0).a();
      return;
    case 1: 
      paramString2 = new Intent(paramContext, QQBrowserActivity.class);
      if (paramInt2 == 1) {}
      for (paramString1 = a(paramString1, paramBundle);; paramString1 = b(paramString1, paramBundle))
      {
        paramString2.putExtra("url", paramString1);
        paramString2.setFlags(268435456);
        paramContext.startActivity(paramString2);
        return;
      }
    }
    paramString2 = new Intent();
    if (paramInt2 == 1) {}
    for (paramContext = a(paramString1, paramBundle);; paramContext = b(paramString1, paramBundle))
    {
      paramContext = Uri.parse(paramContext);
      if (QLog.isColorLevel()) {
        QLog.d("TogetherUtils", 2, new Object[] { "jumpToDefaultTogetherWatch, realJumpURI=", paramContext.toString() });
      }
      paramString2.setData(paramContext);
      paramString2.setFlags(268435456);
      BaseApplicationImpl.getContext().startActivity(paramString2);
      return;
    }
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, int paramInt1, @NonNull String paramString1, @Nullable String paramString2, @NonNull Bundle paramBundle, int paramInt2)
  {
    a(paramQQAppInterface.getApp(), paramInt1, paramString1, paramString2, paramBundle, paramInt2);
  }
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, @NonNull bekh parambekh, boolean paramBoolean)
  {
    a(paramQQAppInterface, parambekh.jdField_e_of_type_Int + "_" + parambekh.f + "_" + parambekh.jdField_e_of_type_JavaLangString, paramBoolean, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TogetherUtils", 2, "setIsGroupWatchTogetherOpen, app =" + paramQQAppInterface + ",troopuin=" + paramString + ",isOpen=" + paramBoolean);
    }
    if (paramQQAppInterface != null)
    {
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (localTroopManager != null)
      {
        paramString = localTroopManager.b(paramString);
        if (paramString != null)
        {
          boolean bool = paramString.isWatchTogetherOpen();
          paramString.setIsWatchTogether(paramBoolean);
          localTroopManager.b(paramString);
          if (QLog.isColorLevel()) {
            QLog.i("TogetherUtils", 2, "setIsGroupWatchTogetherOpen troopinfo saved, last=" + bool);
          }
          if (bool != paramBoolean)
          {
            paramString = paramQQAppInterface.getHandler(Conversation.class);
            if (paramString != null) {
              paramString.sendEmptyMessage(1009);
            }
            paramQQAppInterface = paramQQAppInterface.getHandler(HiddenChatSettingFragment.class);
            if (paramQQAppInterface != null) {
              paramQQAppInterface.sendEmptyMessage(1);
            }
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.i("TogetherUtils", 2, "setBusinessTogetherOpen, uin=" + paramString + " isOpen=" + paramBoolean + " sessionType =" + paramInt1 + " businessType=" + paramInt2);
    }
    Object localObject;
    int i;
    boolean bool;
    if (paramInt1 == 1)
    {
      localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      i = j;
      if (localObject != null)
      {
        paramString = ((TroopManager)localObject).b(paramString);
        i = j;
        if (paramString != null)
        {
          bool = paramString.isTogetherBusinessOpen(paramInt2);
          paramString.setTogetherBusiness(paramBoolean, paramInt2);
          ((TroopManager)localObject).b(paramString);
          if (QLog.isColorLevel()) {
            QLog.i("TogetherUtils", 2, "setBusinessTogetherOpen troopinfo saved, last=" + bool);
          }
          if (bool == paramBoolean) {
            break label213;
          }
          paramInt1 = 1;
          i = paramInt1;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramString = paramQQAppInterface.getHandler(Conversation.class);
        if (paramString != null) {
          paramString.sendEmptyMessage(1009);
        }
        paramQQAppInterface = paramQQAppInterface.getHandler(HiddenChatSettingFragment.class);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.sendEmptyMessage(1);
        }
      }
      return;
      label213:
      paramInt1 = 0;
      break;
      i = j;
      if (paramInt1 == 2)
      {
        localObject = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        paramString = ((anvk)localObject).a(paramString, false);
        if (paramString != null)
        {
          bool = paramString.isTogetherBusinessOpen(paramInt2);
          paramString.setTogetherBusiness(paramBoolean, paramInt2);
          ((anvk)localObject).a(paramString);
          if (QLog.isColorLevel()) {
            QLog.i("TogetherUtils", 2, "setBusinessTogetherOpen troopinfo saved, last=" + bool);
          }
          i = j;
          if (bool != paramBoolean) {
            i = 1;
          }
        }
        else
        {
          i = j;
          if (QLog.isColorLevel())
          {
            QLog.d("TogetherUtils", 2, "setBusinessTogetherOpen extensionInfo is null");
            i = j;
          }
        }
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
    for (String str = paramQQAppInterface.getCurrentUin();; str = "qq_together_pref")
    {
      paramQQAppInterface.getApplication().getSharedPreferences(str, 0).edit().putBoolean(paramString, paramBoolean1).apply();
      return;
    }
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    for (;;)
    {
      return;
      String str = "";
      if (paramString1.equals("1041")) {
        str = "clk_joinbuy_bar";
      }
      if ((paramString1.equals("1042")) || (paramString1.equals("1043"))) {
        str = "clk_sucbuy_bar";
      }
      if (paramString1.equals("1046")) {
        str = "clk_overtimebuy_bar";
      }
      if ((paramString1.equals("1044")) || (paramString1.equals("1045"))) {
        str = "clk_sucticket_bar";
      }
      if ((paramString1.equals("1047")) || (paramString1.equals("1048"))) {}
      for (paramString1 = "clk_overtimeticket_bar"; !TextUtils.isEmpty(paramString1); paramString1 = str)
      {
        bdla.b(null, "dc00899", "Grp_AIO", "", "video_tab", paramString1, 0, 0, paramString2, "", "", "");
        return;
      }
    }
  }
  
  public static boolean a(Intent paramIntent, bekh parambekh, boolean paramBoolean)
  {
    if (!paramBoolean) {
      if (QLog.isColorLevel()) {
        QLog.d("TogetherUtils", 2, "invokeJoinDialog ChatPie not onResume");
      }
    }
    do
    {
      boolean bool;
      do
      {
        return false;
        paramBoolean = paramIntent.getBooleanExtra("key_notification_click_action", false);
        bool = paramIntent.getBooleanExtra("together_business_has_show_join_dialog", false);
        paramIntent.putExtra("together_business_has_show_join_dialog", true);
        if ((paramBoolean) && (!bool)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TogetherUtils", 2, new Object[] { "invokeJoinDialog not from notification isFromNotification= ", Boolean.valueOf(paramBoolean), " hasShowJoinDialog=", Boolean.valueOf(bool) });
      return false;
      if ((parambekh.h == 1) && (parambekh.i != 2)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("TogetherUtils", 2, new Object[] { "invokeJoinDialog togetherSession.status=", Integer.valueOf(parambekh.h), " togetherSession.userState=", Integer.valueOf(parambekh.i) });
    return false;
    return true;
  }
  
  public static boolean a(@NonNull QQAppInterface paramQQAppInterface, @NonNull bekh parambekh)
  {
    return a(paramQQAppInterface, parambekh.jdField_e_of_type_Int + "_" + parambekh.f + "_" + parambekh.jdField_e_of_type_JavaLangString, true, true);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TogetherUtils", 2, "setBusinessTogetherOpen, uin=" + paramString + " sessionType =" + paramInt1 + " businessType=" + paramInt2);
    }
    boolean bool2;
    boolean bool1;
    if (paramInt1 == 1)
    {
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
      if (paramQQAppInterface == null) {
        break label241;
      }
      paramQQAppInterface = paramQQAppInterface.b(paramString);
      if (paramQQAppInterface == null) {
        break label241;
      }
      bool2 = paramQQAppInterface.isTogetherBusinessOpen(paramInt2);
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.i("TogetherUtils", 2, "isBusinessTogetherOpen troopinfo last=" + bool2);
        bool1 = bool2;
      }
    }
    do
    {
      return bool1;
      if (paramInt1 != 2) {
        break label241;
      }
      anvk localanvk = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramQQAppInterface = localanvk.a(paramString, false);
      paramString = localanvk.b(paramString);
      if ((paramString == null) || (!paramString.isFriend())) {
        return false;
      }
      if (paramQQAppInterface == null) {
        break;
      }
      bool2 = paramQQAppInterface.isTogetherBusinessOpen(paramInt2);
      bool1 = bool2;
    } while (!QLog.isColorLevel());
    QLog.d("TogetherUtils", 2, "isBusinessTogetherOpen extensionInfo last=" + bool2);
    return bool2;
    if (QLog.isColorLevel()) {
      QLog.d("TogetherUtils", 2, "isBusinessTogetherOpen extensionInfo is null");
    }
    label241:
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
    for (String str = paramQQAppInterface.getCurrentUin();; str = "qq_together_pref") {
      return paramQQAppInterface.getApplication().getSharedPreferences(str, 0).getBoolean(paramString, paramBoolean1);
    }
  }
  
  public static boolean a(ChatMessage paramChatMessage)
  {
    if (!(paramChatMessage instanceof MessageForArkApp)) {
      return false;
    }
    paramChatMessage = ((MessageForArkApp)paramChatMessage).ark_app_message;
    if (!"com.tencent.together".equals(paramChatMessage.appName)) {
      return false;
    }
    try
    {
      paramChatMessage = new JSONObject(paramChatMessage.metaList).optJSONObject("invite");
      if (paramChatMessage == null) {
        return false;
      }
      paramChatMessage = aptq.a(paramChatMessage).get("type");
      if ((paramChatMessage != null) && ((paramChatMessage instanceof String)))
      {
        boolean bool = "watch".equals(((String)paramChatMessage).toLowerCase());
        if (bool) {
          return true;
        }
      }
    }
    catch (JSONException paramChatMessage)
    {
      paramChatMessage.printStackTrace();
    }
    return false;
  }
  
  public static String b(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    String str = paramString;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_C2C_FRIEND_OPENID")) {
      str = bkyp.a(paramString, "friend_user_openid", paramBundle.getString("TOGETHER_BUNDLE_KEY_C2C_FRIEND_OPENID"));
    }
    paramString = str;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_OPEN_STATUS")) {
      paramString = bkyp.a(str, "isopen", paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_OPEN_STATUS") + "");
    }
    str = paramString;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_FROM_TYPE")) {
      str = bkyp.a(paramString, "from", paramBundle.getInt("TOGETHER_BUNDLE_KEY_FROM_TYPE") + "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherUtils", 2, new Object[] { "generalC2CJumpURL, realJumpURL=", str });
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beki
 * JD-Core Version:    0.7.0.1
 */