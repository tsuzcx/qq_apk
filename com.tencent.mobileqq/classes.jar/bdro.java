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
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatSettingFragment;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public final class bdro
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
  
  public static <T extends bdrn> T a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 2) {
      return new WatchTogetherSession(paramString);
    }
    if (paramInt1 == 4) {
      return new SingTogetherSession(paramInt2, paramString);
    }
    throw new UnsupportedOperationException("Can not generate an object.");
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
        int i = azez.a(paramString);
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
      localObject = bkgj.a(paramString, "troopuin", (String)localObject);
    }
    paramString = (String)localObject;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_OWNER_UIN"))
    {
      str = paramBundle.getString("TOGETHER_BUNDLE_KEY_OWNER_UIN");
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      paramString = bkgj.a((String)localObject, "troopowneruin", paramString);
    }
    localObject = paramString;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_IS_OWNER")) {
      localObject = bkgj.a(paramString, "isowner", paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_OWNER", false) + "");
    }
    paramString = (String)localObject;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_IS_ADMIN")) {
      paramString = bkgj.a((String)localObject, "isadmin", paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_ADMIN", false) + "");
    }
    localObject = paramString;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_OPEN_STATUS")) {
      localObject = bkgj.a(paramString, "isopen", paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_OPEN_STATUS", false) + "");
    }
    paramString = (String)localObject;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_FROM_TYPE")) {
      paramString = bkgj.a((String)localObject, "from", paramBundle.getInt("TOGETHER_BUNDLE_KEY_FROM_TYPE", 0) + "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherUtils", 2, new Object[] { "jumpToDefaultTogetherWatch, realJumpURL=", paramString });
    }
    return paramString;
  }
  
  /* Error */
  public static void a(int paramInt, java.util.Map<String, Object> paramMap, java.util.Map<String, String> paramMap1)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +142 -> 143
    //   4: aconst_null
    //   5: astore 7
    //   7: aload_2
    //   8: ifnonnull +151 -> 159
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_1
    //   14: ifnonnull +160 -> 174
    //   17: aconst_null
    //   18: astore_1
    //   19: aload_1
    //   20: ifnonnull +169 -> 189
    //   23: aconst_null
    //   24: astore_1
    //   25: ldc 106
    //   27: iconst_1
    //   28: bipush 7
    //   30: anewarray 4	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: ldc 167
    //   37: aastore
    //   38: dup
    //   39: iconst_1
    //   40: aload 7
    //   42: aastore
    //   43: dup
    //   44: iconst_2
    //   45: ldc 169
    //   47: aastore
    //   48: dup
    //   49: iconst_3
    //   50: aload_2
    //   51: aastore
    //   52: dup
    //   53: iconst_4
    //   54: ldc 169
    //   56: aastore
    //   57: dup
    //   58: iconst_5
    //   59: aload_1
    //   60: aastore
    //   61: dup
    //   62: bipush 6
    //   64: ldc 171
    //   66: aastore
    //   67: invokestatic 161	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   70: aload_1
    //   71: instanceof 173
    //   74: ifeq +145 -> 219
    //   77: aload_1
    //   78: checkcast 173	java/lang/Long
    //   81: invokevirtual 177	java/lang/Long:longValue	()J
    //   84: lstore 4
    //   86: aload 7
    //   88: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   91: ifne +171 -> 262
    //   94: aload_2
    //   95: invokestatic 65	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   98: ifne +164 -> 262
    //   101: ldc 179
    //   103: aload 7
    //   105: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   108: istore 6
    //   110: iload 6
    //   112: ifeq +113 -> 225
    //   115: iconst_2
    //   116: istore_3
    //   117: iload_3
    //   118: iconst_2
    //   119: if_icmpeq +8 -> 127
    //   122: iload_3
    //   123: iconst_1
    //   124: if_icmpne +10 -> 134
    //   127: lload 4
    //   129: lconst_0
    //   130: lcmp
    //   131: ifne +136 -> 267
    //   134: ldc 106
    //   136: iconst_1
    //   137: ldc 184
    //   139: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   142: return
    //   143: aload_2
    //   144: ldc 189
    //   146: invokeinterface 195 2 0
    //   151: checkcast 75	java/lang/String
    //   154: astore 7
    //   156: goto -149 -> 7
    //   159: aload_2
    //   160: ldc 197
    //   162: invokeinterface 195 2 0
    //   167: checkcast 75	java/lang/String
    //   170: astore_2
    //   171: goto -158 -> 13
    //   174: aload_1
    //   175: ldc 199
    //   177: invokeinterface 195 2 0
    //   182: checkcast 201	java/util/HashMap
    //   185: astore_1
    //   186: goto -167 -> 19
    //   189: aload_1
    //   190: ldc 203
    //   192: invokeinterface 195 2 0
    //   197: astore_1
    //   198: goto -173 -> 25
    //   201: astore_1
    //   202: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +14 -> 219
    //   208: ldc 106
    //   210: iconst_2
    //   211: aload_1
    //   212: invokevirtual 204	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   215: aload_1
    //   216: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   219: lconst_0
    //   220: lstore 4
    //   222: goto -136 -> 86
    //   225: ldc 206
    //   227: aload 7
    //   229: invokevirtual 182	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   232: istore 6
    //   234: iload 6
    //   236: ifeq +65 -> 301
    //   239: iconst_1
    //   240: istore_3
    //   241: goto -124 -> 117
    //   244: astore_1
    //   245: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   248: ifeq +14 -> 262
    //   251: ldc 106
    //   253: iconst_2
    //   254: aload_1
    //   255: invokevirtual 204	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   258: aload_1
    //   259: invokestatic 113	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   262: iconst_m1
    //   263: istore_3
    //   264: goto -147 -> 117
    //   267: getstatic 212	com/tencent/mobileqq/app/BaseActivity:sTopActivity	Lcom/tencent/mobileqq/app/BaseActivity;
    //   270: astore_1
    //   271: aload_1
    //   272: ifnonnull +12 -> 284
    //   275: ldc 106
    //   277: iconst_1
    //   278: ldc 214
    //   280: invokestatic 187	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: return
    //   284: aload_1
    //   285: getfield 218	com/tencent/mobileqq/app/BaseActivity:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   288: invokestatic 223	bdrb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lbdrb;
    //   291: aload_1
    //   292: iload_0
    //   293: iload_3
    //   294: aload_2
    //   295: lload 4
    //   297: invokevirtual 226	bdrb:a	(Lcom/tencent/mobileqq/app/BaseActivity;IILjava/lang/String;J)V
    //   300: return
    //   301: iconst_m1
    //   302: istore_3
    //   303: goto -186 -> 117
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	306	0	paramInt	int
    //   0	306	1	paramMap	java.util.Map<String, Object>
    //   0	306	2	paramMap1	java.util.Map<String, String>
    //   116	187	3	i	int
    //   84	212	4	l	long
    //   108	127	6	bool	boolean
    //   5	223	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   77	86	201	java/lang/Exception
    //   101	110	244	java/lang/Exception
    //   225	234	244	java/lang/Exception
  }
  
  public static void a(@NonNull Context paramContext, int paramInt1, @NonNull String paramString1, @Nullable String paramString2, @NonNull Bundle paramBundle, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      QQToast.a(paramContext, 0, 2131719118, 0).a();
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
  
  public static void a(@NonNull QQAppInterface paramQQAppInterface, @NonNull bdrn parambdrn, boolean paramBoolean)
  {
    a(paramQQAppInterface, parambdrn.d + "_" + parambdrn.jdField_e_of_type_Int + "_" + parambdrn.jdField_e_of_type_JavaLangString, paramBoolean, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TogetherUtils", 2, "setIsGroupWatchTogetherOpen, app =" + paramQQAppInterface + ",troopuin=" + paramString + ",isOpen=" + paramBoolean);
    }
    if (paramQQAppInterface != null)
    {
      TroopManager localTroopManager = (TroopManager)paramQQAppInterface.getManager(52);
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
      localObject = (TroopManager)paramQQAppInterface.getManager(52);
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
            break label212;
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
      label212:
      paramInt1 = 0;
      break;
      i = j;
      if (paramInt1 == 2)
      {
        localObject = (anmw)paramQQAppInterface.getManager(51);
        paramString = ((anmw)localObject).a(paramString, false);
        if (paramString != null)
        {
          bool = paramString.isTogetherBusinessOpen(paramInt2);
          paramString.setTogetherBusiness(paramBoolean, paramInt2);
          ((anmw)localObject).a(paramString);
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
    for (String str = paramQQAppInterface.c();; str = "qq_together_pref")
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
        bcst.b(null, "dc00899", "Grp_AIO", "", "video_tab", paramString1, 0, 0, paramString2, "", "", "");
        return;
      }
    }
  }
  
  public static boolean a(@NonNull QQAppInterface paramQQAppInterface, @NonNull bdrn parambdrn)
  {
    return a(paramQQAppInterface, parambdrn.d + "_" + parambdrn.jdField_e_of_type_Int + "_" + parambdrn.jdField_e_of_type_JavaLangString, true, true);
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
      paramQQAppInterface = (TroopManager)paramQQAppInterface.getManager(52);
      if (paramQQAppInterface == null) {
        break label239;
      }
      paramQQAppInterface = paramQQAppInterface.b(paramString);
      if (paramQQAppInterface == null) {
        break label239;
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
        break label239;
      }
      anmw localanmw = (anmw)paramQQAppInterface.getManager(51);
      paramQQAppInterface = localanmw.a(paramString, false);
      paramString = localanmw.b(paramString);
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
    label239:
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
    for (String str = paramQQAppInterface.c();; str = "qq_together_pref") {
      return paramQQAppInterface.getApplication().getSharedPreferences(str, 0).getBoolean(paramString, paramBoolean1);
    }
  }
  
  public static String b(@NonNull String paramString, @NonNull Bundle paramBundle)
  {
    String str = paramString;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_C2C_FRIEND_OPENID")) {
      str = bkgj.a(paramString, "friend_user_openid", paramBundle.getString("TOGETHER_BUNDLE_KEY_C2C_FRIEND_OPENID"));
    }
    paramString = str;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_OPEN_STATUS")) {
      paramString = bkgj.a(str, "isopen", paramBundle.getBoolean("TOGETHER_BUNDLE_KEY_OPEN_STATUS") + "");
    }
    str = paramString;
    if (paramBundle.containsKey("TOGETHER_BUNDLE_KEY_FROM_TYPE")) {
      str = bkgj.a(paramString, "from", paramBundle.getInt("TOGETHER_BUNDLE_KEY_FROM_TYPE") + "");
    }
    if (QLog.isColorLevel()) {
      QLog.d("TogetherUtils", 2, new Object[] { "generalC2CJumpURL, realJumpURL=", str });
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdro
 * JD-Core Version:    0.7.0.1
 */