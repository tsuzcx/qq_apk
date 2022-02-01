package com.tencent.mobileqq.ark;

import aido;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import bcrn;
import bdfk;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.TextPreviewActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import gb;
import nty;
import org.json.JSONException;
import org.json.JSONObject;

public class ArkAppCenterUtil
{
  private static final String ARK_ENGINE_RES_PATH = "res:";
  public static final int ARK_ON_CONFIG_CHANGE = 2;
  public static final int ARK_ON_INIT_SIZE = 1;
  private static final String TAG = "ArkApp.ArkAppCenterUtil";
  public static int sChatBubbleMaxWidth = BaseChatItemLayout.e;
  public static int sChatTextViewMaxWidth = BaseChatItemLayout.f;
  public static DisplayMetrics sDisplayMetrics;
  public static int sDisplayWith = BaseChatItemLayout.jdField_d_of_type_Int;
  public static final int sFoldScreenFixWidth = 840;
  public static final int sFoldScreenMinSize = 1536;
  public static boolean sIsFoldStrategyEnable;
  private static int sOldScreenWidthDp;
  public static int sRealDisplayWith = BaseChatItemLayout.jdField_d_of_type_Int;
  
  static
  {
    checkArkSize(1);
  }
  
  public static String CopyFileToCache(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("ArkApp.ArkAppCenterUtil", 2, "AAShare.CopyFileToCache appName is null or local path is null");
      }
      paramString1 = null;
    }
    String str;
    do
    {
      return paramString1;
      str = ArkEnvironmentManager.getInstance().getAppResPath(paramString1);
      int i = (int)(Math.random() * 10.0D);
      paramString1 = String.format("share_%d_%02d", new Object[] { Long.valueOf(System.currentTimeMillis()), Integer.valueOf(i) });
      str = str + "/" + paramString1;
      paramString1 = "res:" + paramString1;
    } while (FileUtils.copyFile(paramString2, str));
    return "";
  }
  
  /* Error */
  public static String CopyFileToCache(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 67	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +7 -> 11
    //   7: aload_1
    //   8: ifnonnull +21 -> 29
    //   11: invokestatic 73	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   14: ifeq +11 -> 25
    //   17: ldc 16
    //   19: iconst_2
    //   20: ldc 149
    //   22: invokestatic 78	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   25: aconst_null
    //   26: astore_0
    //   27: aload_0
    //   28: areturn
    //   29: invokestatic 84	com/tencent/ark/ArkEnvironmentManager:getInstance	()Lcom/tencent/ark/ArkEnvironmentManager;
    //   32: aload_0
    //   33: invokevirtual 88	com/tencent/ark/ArkEnvironmentManager:getAppResPath	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore_3
    //   37: ldc 98
    //   39: iconst_2
    //   40: anewarray 4	java/lang/Object
    //   43: dup
    //   44: iconst_0
    //   45: invokestatic 104	java/lang/System:currentTimeMillis	()J
    //   48: invokestatic 110	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   51: aastore
    //   52: dup
    //   53: iconst_1
    //   54: invokestatic 94	java/lang/Math:random	()D
    //   57: ldc2_w 95
    //   60: dmul
    //   61: invokestatic 154	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   64: aastore
    //   65: invokestatic 121	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   68: astore_0
    //   69: new 123	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   76: aload_3
    //   77: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: ldc 130
    //   82: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_0
    //   86: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore_3
    //   93: new 123	java/lang/StringBuilder
    //   96: dup
    //   97: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   100: ldc 8
    //   102: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_0
    //   106: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: astore 4
    //   114: new 156	java/io/File
    //   117: dup
    //   118: aload_3
    //   119: invokespecial 159	java/io/File:<init>	(Ljava/lang/String;)V
    //   122: astore_0
    //   123: aload_0
    //   124: invokevirtual 162	java/io/File:exists	()Z
    //   127: ifeq +8 -> 135
    //   130: aload_0
    //   131: invokevirtual 165	java/io/File:delete	()Z
    //   134: pop
    //   135: new 167	java/io/FileOutputStream
    //   138: dup
    //   139: aload_0
    //   140: invokespecial 170	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   143: astore_3
    //   144: aload_3
    //   145: astore_0
    //   146: aload_3
    //   147: aload_1
    //   148: iconst_0
    //   149: aload_1
    //   150: arraylength
    //   151: invokevirtual 174	java/io/FileOutputStream:write	([BII)V
    //   154: aload_3
    //   155: astore_0
    //   156: aload_3
    //   157: invokevirtual 177	java/io/FileOutputStream:flush	()V
    //   160: aload_3
    //   161: ifnull +161 -> 322
    //   164: aload_3
    //   165: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   168: iconst_1
    //   169: istore_2
    //   170: aload 4
    //   172: astore_0
    //   173: iload_2
    //   174: ifne -147 -> 27
    //   177: ldc 142
    //   179: areturn
    //   180: astore_0
    //   181: ldc 16
    //   183: iconst_1
    //   184: ldc 182
    //   186: aload_0
    //   187: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: iconst_1
    //   191: istore_2
    //   192: goto -22 -> 170
    //   195: astore_1
    //   196: aconst_null
    //   197: astore_3
    //   198: aload_3
    //   199: astore_0
    //   200: ldc 16
    //   202: iconst_1
    //   203: ldc 182
    //   205: aload_1
    //   206: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: aload_3
    //   210: ifnull +107 -> 317
    //   213: aload_3
    //   214: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   217: iconst_0
    //   218: istore_2
    //   219: goto -49 -> 170
    //   222: astore_0
    //   223: ldc 16
    //   225: iconst_1
    //   226: ldc 182
    //   228: aload_0
    //   229: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   232: iconst_0
    //   233: istore_2
    //   234: goto -64 -> 170
    //   237: astore_1
    //   238: aconst_null
    //   239: astore_3
    //   240: aload_3
    //   241: astore_0
    //   242: ldc 16
    //   244: iconst_1
    //   245: ldc 187
    //   247: aload_1
    //   248: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   251: aload_3
    //   252: ifnull +65 -> 317
    //   255: aload_3
    //   256: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   259: iconst_0
    //   260: istore_2
    //   261: goto -91 -> 170
    //   264: astore_0
    //   265: ldc 16
    //   267: iconst_1
    //   268: ldc 182
    //   270: aload_0
    //   271: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   274: iconst_0
    //   275: istore_2
    //   276: goto -106 -> 170
    //   279: astore_1
    //   280: aconst_null
    //   281: astore_0
    //   282: aload_0
    //   283: ifnull +7 -> 290
    //   286: aload_0
    //   287: invokevirtual 180	java/io/FileOutputStream:close	()V
    //   290: aload_1
    //   291: athrow
    //   292: astore_0
    //   293: ldc 16
    //   295: iconst_1
    //   296: ldc 182
    //   298: aload_0
    //   299: invokestatic 185	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   302: goto -12 -> 290
    //   305: astore_1
    //   306: goto -24 -> 282
    //   309: astore_1
    //   310: goto -70 -> 240
    //   313: astore_1
    //   314: goto -116 -> 198
    //   317: iconst_0
    //   318: istore_2
    //   319: goto -149 -> 170
    //   322: iconst_1
    //   323: istore_2
    //   324: goto -154 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	paramString	String
    //   0	327	1	paramArrayOfByte	byte[]
    //   169	155	2	i	int
    //   36	220	3	localObject	Object
    //   112	59	4	str	String
    // Exception table:
    //   from	to	target	type
    //   164	168	180	java/io/IOException
    //   114	135	195	java/io/IOException
    //   135	144	195	java/io/IOException
    //   213	217	222	java/io/IOException
    //   114	135	237	java/lang/OutOfMemoryError
    //   135	144	237	java/lang/OutOfMemoryError
    //   255	259	264	java/io/IOException
    //   114	135	279	finally
    //   135	144	279	finally
    //   286	290	292	java/io/IOException
    //   146	154	305	finally
    //   156	160	305	finally
    //   200	209	305	finally
    //   242	251	305	finally
    //   146	154	309	java/lang/OutOfMemoryError
    //   156	160	309	java/lang/OutOfMemoryError
    //   146	154	313	java/io/IOException
    //   156	160	313	java/io/IOException
  }
  
  private static void checkArkSize(int paramInt)
  {
    DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
    int i = Math.min(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    sRealDisplayWith = i;
    if (sDisplayMetrics == null) {
      sDisplayMetrics = localDisplayMetrics;
    }
    QLog.e("ArkApp.ArkAppCenterUtil", 1, new Object[] { "ArkFold.checkArkSize model=", Build.MODEL, ",screenWidth=", Integer.valueOf(i), ",sDisplayWith=", Integer.valueOf(sDisplayWith), ",scene=", Integer.valueOf(paramInt) });
    if ((i >= 1536) && (sDisplayWith != 840))
    {
      sIsFoldStrategyEnable = true;
      sDisplayWith = 840;
      sChatBubbleMaxWidth = (int)(sDisplayWith - 108.0F * getDensity());
      sChatTextViewMaxWidth = sChatBubbleMaxWidth - BaseChatItemLayout.j - BaseChatItemLayout.k;
      QLog.e("ArkApp.ArkAppCenterUtil", 1, new Object[] { "ArkFold.checkArkSize handle fold screen sChatBubbleMaxWidth=", Integer.valueOf(sChatBubbleMaxWidth), ",sDisplayWith=", Integer.valueOf(sDisplayWith), ",sChatTextViewMaxWidth=", Integer.valueOf(sChatTextViewMaxWidth) });
    }
  }
  
  public static void doOnConfigurationChanged(Configuration paramConfiguration)
  {
    if (paramConfiguration.screenWidthDp != sOldScreenWidthDp)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkApp.ArkAppCenterUtil", 2, new Object[] { "ArkFold.BaseChatePie.onConfigurationChanged.mOldScreenDp=", Integer.valueOf(sOldScreenWidthDp), ",newScreenDp=", Integer.valueOf(paramConfiguration.screenWidthDp) });
      }
      sOldScreenWidthDp = paramConfiguration.screenWidthDp;
      checkArkSize(2);
    }
  }
  
  public static String getCurrentAppConfig()
  {
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject2 = new JSONObject();
        if (!bdfk.b()) {
          continue;
        }
        localJSONObject2.put("mode", "concise");
        localJSONObject2.put("themeId", ThemeUtil.getCurrentThemeId());
        localJSONObject1.put("theme", localJSONObject2);
      }
      catch (JSONException localJSONException)
      {
        JSONObject localJSONObject2;
        QLog.e("ArkApp.ArkAppCenterUtil", 1, "Exception=", localJSONException);
        continue;
      }
      return localJSONObject1.toString();
      localJSONObject2.put("mode", "default");
    }
  }
  
  public static float getDensity()
  {
    return BaseChatItemLayout.jdField_d_of_type_Float;
  }
  
  public static boolean isPublicAccount()
  {
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      Object localObject = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (localObject != null)
      {
        localObject = ((ChatFragment)localObject).a();
        if ((localObject != null) && ((localObject instanceof aido))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static void onThemeChanged()
  {
    String str = getCurrentAppConfig();
    QLog.d("ArkApp.ArkAppCenterUtil", 1, new Object[] { "onThemeChanged.appconfig=", str });
    try
    {
      ark.arkApplicationSetConfig(null, str);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      QLog.e("ArkApp.ArkAppCenterUtil", 1, "onThemeChanged.ark so not load.e=", localUnsatisfiedLinkError);
    }
  }
  
  public static void preDownloadArkApp(AppInterface paramAppInterface, String paramString1, String paramString2)
  {
    if ((paramAppInterface == null) || (TextUtils.isEmpty(paramString1))) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAppCenterUtil", 2, new Object[] { "preDownloadArkApp download start,appName: ", paramString1, ",appView=", paramString2 });
    }
    ArkAppMgr.getInstance().getAppPathByName(paramString1, paramString2, "0.0.0.1", null, new ArkAppCenterUtil.1());
  }
  
  public static void printScaleInfo(String paramString, Context paramContext)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "ArkApp.ArkAppCenterUtil";
    }
    try
    {
      DisplayMetrics localDisplayMetrics = BaseApplicationImpl.getContext().getResources().getDisplayMetrics();
      paramString = new StringBuilder("print density info:");
      paramString.append("\n model=").append(Build.MODEL).append(", ver=").append(Build.VERSION.RELEASE).append(",SDK=").append(Build.VERSION.SDK_INT).append("\n BaseChatItemLayout.density=").append(BaseChatItemLayout.jdField_d_of_type_Float).append("\n application density=").append(localDisplayMetrics.density).append("-").append(localDisplayMetrics.scaledDensity);
      if (paramContext != null)
      {
        paramContext = paramContext.getResources().getDisplayMetrics();
        paramString.append("\n activity density=").append(paramContext.density).append("-").append(paramContext.scaledDensity);
      }
      QLog.i(str, 1, paramString.toString());
      return;
    }
    catch (Exception paramString)
    {
      QLog.e("ArkApp.ArkAppCenterUtil", 1, "printScaleInfo Exception:", paramString);
    }
  }
  
  public static void showArkMessageContent(Context paramContext, MessageForArkApp paramMessageForArkApp, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, TextPreviewActivity.class);
    localIntent.putExtra("peeruin", paramMessageForArkApp.frienduin);
    localIntent.putExtra("uin_type", paramMessageForArkApp.istroop);
    localIntent.putExtra("content", paramMessageForArkApp.ark_app_message.toAppXml());
    localIntent.putExtra("uniseq", paramMessageForArkApp.uniseq);
    localIntent.putExtra("bubbleId", paramMessageForArkApp.vipBubbleID);
    localIntent.putExtra("bubbleDiyId", paramMessageForArkApp.vipBubbleDiyTextId);
    localIntent.putExtra("fontId", paramMessageForArkApp.getExtInfoFromExtStr("vip_font_id"));
    localIntent.putExtra("troop_at_info", paramMessageForArkApp.getExtInfoFromExtStr(bcrn.i));
    localIntent.putExtra("senderUin", paramMessageForArkApp.senderuin);
    localIntent.putExtra("sessionType", paramInt);
    localIntent.putExtra("isMultiMsg", paramMessageForArkApp.isMultiMsg);
    String str = paramMessageForArkApp.getExtInfoFromExtStr("vip_font_effect_id");
    if ((!TextUtils.isEmpty(str)) && (TextUtils.isDigitsOnly(str))) {}
    for (int i = Integer.valueOf(str).intValue();; i = 0)
    {
      paramInt = i;
      if (i == 0)
      {
        paramInt = i;
        if (gb.a(paramMessageForArkApp)) {
          paramInt = 1;
        }
      }
      i = paramInt;
      if (paramInt != 0)
      {
        i = paramInt;
        if (1 == paramMessageForArkApp.istroop)
        {
          i = paramInt;
          if (nty.a(paramMessageForArkApp)) {
            i = 0;
          }
        }
      }
      localIntent.putExtra("fontEffectId", i);
      if (paramMessageForArkApp.isSend()) {
        paramMessageForArkApp = paramMessageForArkApp.selfuin;
      }
      for (;;)
      {
        localIntent.putExtra("real_msg_sender_uin", paramMessageForArkApp);
        ((Activity)paramContext).startActivityForResult(localIntent, 14001);
        ((Activity)paramContext).overridePendingTransition(2130772009, 0);
        return;
        if ((paramMessageForArkApp.istroop == 1000) || (paramMessageForArkApp.istroop == 1020) || (paramMessageForArkApp.istroop == 1004)) {
          paramMessageForArkApp = paramMessageForArkApp.frienduin;
        } else {
          paramMessageForArkApp = paramMessageForArkApp.senderuin;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAppCenterUtil
 * JD-Core Version:    0.7.0.1
 */