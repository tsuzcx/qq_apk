import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.qwallet.utils.OSUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.VasUtils.1;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public final class bhiw
{
  private static int a;
  public static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "VasUtils";
    jdField_a_of_type_Int = 1000;
  }
  
  public static int a()
  {
    if (OSUtils.isMIUI()) {
      return 1;
    }
    if (OSUtils.isEMUI()) {
      return 2;
    }
    if (OSUtils.isFlymeOS()) {
      return 5;
    }
    if (!TextUtils.isEmpty(SystemUtil.getSystemProperty("ro.build.version.opporom"))) {
      return 3;
    }
    if (!TextUtils.isEmpty(SystemUtil.getSystemProperty("ro.vivo.os.version"))) {
      return 4;
    }
    return 0;
  }
  
  public static int a(Context paramContext)
  {
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  public static int a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
    if (paramQQAppInterface != null)
    {
      boolean bool = paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      if (paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
      {
        if (paramQQAppInterface.getServiceType(EVIPSPEC.E_SP_SUPERVIP) == 1) {
          return 22;
        }
        return 5;
      }
      if (bool)
      {
        if (paramQQAppInterface.getServiceType(EVIPSPEC.E_SP_QQVIP) == 1) {
          return 21;
        }
        return 4;
      }
    }
    return 1;
  }
  
  /* Error */
  public static int a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: new 110	java/io/File
    //   8: dup
    //   9: new 112	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: getstatic 122	java/io/File:separator	Ljava/lang/String;
    //   23: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 4
    //   38: aload 4
    //   40: invokevirtual 132	java/io/File:exists	()Z
    //   43: istore_3
    //   44: iload_3
    //   45: ifne +8 -> 53
    //   48: ldc 2
    //   50: monitorexit
    //   51: iload_2
    //   52: ireturn
    //   53: new 112	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: getstatic 122	java/io/File:separator	Ljava/lang/String;
    //   67: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 137	java/lang/System:load	(Ljava/lang/String;)V
    //   80: iconst_0
    //   81: istore_2
    //   82: goto -34 -> 48
    //   85: astore_0
    //   86: ldc 139
    //   88: iconst_1
    //   89: new 112	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   96: ldc 141
    //   98: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: invokevirtual 144	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   105: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 149	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload 4
    //   116: invokevirtual 152	java/io/File:delete	()Z
    //   119: pop
    //   120: iconst_2
    //   121: istore_2
    //   122: goto -74 -> 48
    //   125: astore_0
    //   126: ldc 2
    //   128: monitorexit
    //   129: aload_0
    //   130: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	131	0	paramString1	String
    //   0	131	1	paramString2	String
    //   1	121	2	i	int
    //   43	2	3	bool	boolean
    //   36	79	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   53	80	85	java/lang/Throwable
    //   5	44	125	finally
    //   53	80	125	finally
    //   86	120	125	finally
  }
  
  public static Drawable a(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener, Drawable paramDrawable)
  {
    return a(paramString, false, false, paramURLDrawableListener, paramDrawable);
  }
  
  public static Drawable a(String paramString, boolean paramBoolean1, boolean paramBoolean2, URLDrawable.URLDrawableListener paramURLDrawableListener, Drawable paramDrawable)
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject1 = paramDrawable;
    Object localObject2;
    Object localObject3;
    if (paramDrawable == null)
    {
      localObject2 = localObject5;
      localObject3 = paramDrawable;
    }
    for (;;)
    {
      try
      {
        localObject1 = new ColorDrawable(-1513240);
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable = URLDrawable.URLDrawableOptions.obtain();
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable.mFailedDrawable = ((Drawable)localObject1);
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable.mLoadingDrawable = ((Drawable)localObject1);
        if (!paramBoolean1) {
          continue;
        }
      }
      catch (Exception paramURLDrawableListener)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "getIPSiteDrawable error url = " + paramString + "error msg = " + paramURLDrawableListener);
        localObject1 = localObject3;
        paramDrawable = (Drawable)localObject2;
        continue;
        if (!paramBoolean2) {
          continue;
        }
        try
        {
          paramDrawable = URLDrawable.getDrawable(new URL("protocol_vas_extension_image", "COMIC_IPSITE_GAME_IMAGE", paramString), paramDrawable);
        }
        catch (Exception paramDrawable)
        {
          localObject2 = localObject5;
          localObject3 = localObject1;
          QLog.e(jdField_a_of_type_JavaLangString, 1, "getIPSiteDrawable error = " + paramDrawable);
          paramDrawable = localObject4;
        }
        continue;
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable = URLDrawable.getDrawable(paramString, paramDrawable);
        continue;
        return paramDrawable;
        if (paramDrawable != null) {
          continue;
        }
      }
      try
      {
        paramDrawable = URLDrawable.getDrawable(new URL("protocol_vas_extension_image", "COMIC_IP_SITE_ROUND_IMAGE", paramString), paramDrawable);
        if (paramDrawable != null)
        {
          localObject2 = paramDrawable;
          localObject3 = localObject1;
          if (paramDrawable.getTag() == null)
          {
            localObject2 = paramDrawable;
            localObject3 = localObject1;
            paramDrawable.setTag(Integer.valueOf(0));
          }
          localObject2 = paramDrawable;
          localObject3 = localObject1;
          paramDrawable.setURLDrawableListener(paramURLDrawableListener);
          localObject2 = paramDrawable;
          localObject3 = localObject1;
          paramDrawable.setAutoDownload(true);
        }
      }
      catch (Exception paramDrawable)
      {
        localObject2 = localObject5;
        localObject3 = localObject1;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "getIPSiteDrawable error = " + paramDrawable);
        paramDrawable = localObject4;
      }
    }
    return localObject1;
  }
  
  public static SpannableString a(QQAppInterface paramQQAppInterface, QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    int j = 0;
    if (paramMessage.mExJsonObject != null)
    {
      label130:
      label241:
      for (;;)
      {
        try
        {
          JSONObject localJSONObject = new JSONObject(new JSONObject(paramMessage.mExJsonObject.optString("report_key_bytes_oac_msg_extend", "")).optString("sp_brief", ""));
          Object localObject1 = localJSONObject.optString("brief", null);
          Object localObject3;
          int k;
          int m;
          localJSONException1.printStackTrace();
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            try
            {
              str = localJSONObject.optString("color", "#ff0000");
              paramMessage = (QQMessageFacade.Message)localObject1;
              localObject3 = localObject1;
            }
            catch (JSONException localJSONException4)
            {
              String str = null;
              i = -1;
              paramMessage = localJSONException1;
              Object localObject2 = localJSONException4;
              continue;
            }
            for (;;)
            {
              try
              {
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  paramMessage = null;
                }
                localObject3 = paramMessage;
                localObject1 = localJSONObject.optJSONObject("range");
                if (localObject1 == null) {
                  continue;
                }
                localObject3 = paramMessage;
                i = ((JSONObject)localObject1).optInt("location", -1);
              }
              catch (JSONException localJSONException2)
              {
                i = -1;
                paramMessage = localJSONException4;
                break label241;
                i = -1;
                break label130;
              }
              try
              {
                k = ((JSONObject)localObject1).optInt("length", 0);
                j = k;
                paramQQAppInterface = a(paramQQAppInterface);
                if (paramMessage == null) {
                  break label331;
                }
                k = paramMessage.indexOf("[nick]");
                m = paramQQAppInterface.length() + k;
                paramQQAppInterface = paramMessage.replace("[nick]", paramQQAppInterface);
                if (k <= -1) {
                  break label256;
                }
                paramQQAppInterface = new SpannableString(paramQQAppInterface);
                if ((str == null) || (!paramBoolean)) {}
              }
              catch (JSONException localJSONException3)
              {
                break label241;
              }
            }
            try
            {
              paramQQAppInterface.setSpan(new StyleSpan(1), k, m, 18);
              paramQQAppInterface.setSpan(new ForegroundColorSpan(Color.parseColor(str)), k, m, 18);
              return paramQQAppInterface;
            }
            catch (IllegalArgumentException paramMessage)
            {
              paramMessage.printStackTrace();
              return paramQQAppInterface;
            }
          }
          localJSONException1 = localJSONException1;
          str = null;
          paramMessage = null;
          i = -1;
        }
      }
      label256:
      if ((paramBoolean) && (i > -1) && (j > 0)) {
        try
        {
          if ((!TextUtils.isEmpty(paramQQAppInterface)) && (!TextUtils.isEmpty(str)))
          {
            paramMessage = new SpannableString(paramQQAppInterface);
            paramMessage.setSpan(new ForegroundColorSpan(Color.parseColor(str)), i, j, 33);
            return paramMessage;
          }
        }
        catch (Exception paramMessage)
        {
          paramMessage.printStackTrace();
        }
      }
      return new SpannableString(paramQQAppInterface);
    }
    label331:
    return null;
  }
  
  public static SpannableString a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split(" ");
      paramString = new SpannableString(paramString);
      int i = 0;
      while (i < arrayOfString.length)
      {
        String str = arrayOfString[i];
        if (a(str))
        {
          int k = i - 1;
          int j = 0;
          while (k >= 0)
          {
            j = j + arrayOfString[k].length() + 1;
            k -= 1;
          }
          k = str.length();
          paramString.setSpan(new ForegroundColorSpan(-15550475), j, k + j, 33);
        }
        i += 1;
      }
      return paramString;
    }
    return new SpannableString("");
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + "vas_so" + File.separator;
  }
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getCurrentNickname();
      paramQQAppInterface = str;
      if (TextUtils.isEmpty(str)) {
        paramQQAppInterface = "亲爱的用户";
      }
      return paramQQAppInterface;
    }
    return "";
  }
  
  public static void a()
  {
    avjz.a().d();
    ETTextView.clearCache();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      avkh localavkh = (avkh)((QQAppInterface)localObject).getManager(QQManagerFactory.HIBOOM_MANAGER);
      if (localavkh != null) {
        localavkh.d();
      }
      localObject = (gb)((QQAppInterface)localObject).getManager(QQManagerFactory.CHAT_FONT_MANAGER);
      if (localObject != null) {
        ((gb)localObject).b();
      }
    }
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt, String paramString)
  {
    a(paramActivity, paramAppInterface, paramInt, paramString, -1, -1, -1, null);
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    a(paramActivity, paramAppInterface, paramInt1, paramString, paramInt2, -1, -1, null);
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    String str2 = "signature_1";
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("fragmentStyle", 3);
    Object localObject1 = "";
    Object localObject2;
    String str1;
    if (paramInt1 == 0)
    {
      localObject2 = localObject1;
      if (paramBundle != null) {
        localObject2 = paramBundle.getString("signUrl");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        str1 = str2;
        if (((String)localObject2).contains(".qq.com")) {}
      }
      else
      {
        localObject1 = bhnp.a("signatureEntrance");
        str1 = str2;
      }
      localObject2 = new StringBuilder((String)localObject1);
      if (!((String)localObject1).contains("?")) {
        break label344;
      }
      ((StringBuilder)localObject2).append("&signatureEdit=1");
      label125:
      if (paramInt3 > -1)
      {
        ((StringBuilder)localObject2).append("&templateId=");
        ((StringBuilder)localObject2).append(paramInt3);
      }
      if (paramInt4 > -1)
      {
        ((StringBuilder)localObject2).append("&fontId=");
        ((StringBuilder)localObject2).append(paramInt4);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "openSignatureEdit: url= " + ((StringBuilder)localObject2).toString());
      }
      localIntent.putExtra("url", ((StringBuilder)localObject2).toString());
      localIntent.putExtra("isTransparentTitle", true);
      localIntent.putExtra("via", paramString);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      if (paramBundle != null) {
        localIntent.putExtra("sign_extra", paramBundle);
      }
      if (paramInt2 != -1) {
        break label356;
      }
      paramActivity.startActivity(localIntent);
    }
    for (;;)
    {
      if (paramAppInterface != null) {
        VasWebviewUtil.reportCommercialDrainage(paramAppInterface.getCurrentAccountUin(), "signature", str1, paramString, 1, 0, 0, "", "", "");
      }
      return;
      str1 = str2;
      if (paramInt1 != 1) {
        break;
      }
      localObject1 = bhnp.a("signatureDIYEntrance");
      localIntent.putExtra("open_diy", true);
      str1 = "signature_5";
      break;
      label344:
      ((StringBuilder)localObject2).append("?signatureEdit=1");
      break label125;
      label356:
      paramActivity.startActivityForResult(localIntent, paramInt2);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    ((BaseActivity)paramContext).runOnUiThread(new VasUtils.1(paramContext, paramString));
  }
  
  public static void a(AppInterface paramAppInterface)
  {
    MqqHandler localMqqHandler = paramAppInterface.getHandler(ChatActivity.class);
    if (localMqqHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "refreshAIO");
      }
      localMqqHandler.removeMessages(16711697);
      localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(16711697), jdField_a_of_type_Int);
    }
    localMqqHandler = paramAppInterface.getHandler(ChatHistoryBubbleListForTroopFragment.class);
    if (localMqqHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "refresh troop history");
      }
      localMqqHandler.removeMessages(16711697);
      localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(16711697), jdField_a_of_type_Int);
    }
    paramAppInterface = paramAppInterface.getHandler(MiniChatActivity.class);
    if (paramAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "refresh miniAIO");
      }
      paramAppInterface.removeMessages(8);
      paramAppInterface.sendMessageDelayed(paramAppInterface.obtainMessage(8), jdField_a_of_type_Int);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    int i3 = 1;
    bcvc localbcvc = (bcvc)paramQQAppInterface.getManager(QQManagerFactory.GAMECENTER_MANAGER);
    int i;
    int j;
    label52:
    int k;
    label66:
    int m;
    label81:
    int n;
    label96:
    int i1;
    label111:
    int i2;
    label126:
    boolean bool;
    if (localbcvc != null)
    {
      if (localbcvc.a("100005.100001") == -1) {
        break label266;
      }
      i = 1;
      if (i != 0)
      {
        if (localbcvc.a("100005.100003") == -1) {
          break label271;
        }
        j = 1;
        if (localbcvc.a("100005.100002") == -1) {
          break label276;
        }
        k = 1;
        if (localbcvc.a("100005.100006") == -1) {
          break label281;
        }
        m = 1;
        if (localbcvc.a("100005.100018") == -1) {
          break label287;
        }
        n = 1;
        if (localbcvc.a("100005.100020") == -1) {
          break label293;
        }
        i1 = 1;
        if (localbcvc.a("100005.100021") == -1) {
          break label299;
        }
        i2 = 1;
        bool = ((gb)paramQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a;
        if (!bool) {
          break label315;
        }
        if (localbcvc.a("100005.100011") == -1) {
          break label305;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label160:
      if (((bool) && (j == 0) && (k == 0) && (m == 0) && (i == 0) && (n == 0) && (i1 == 0) && (i2 == 0)) || ((!bool) && (j == 0) && (k == 0) && (m == 0) && (n == 0) && (i1 == 0) && (i2 == 0))) {
        if (localbcvc.a("100005") == -1) {
          break label310;
        }
      }
      label266:
      label271:
      label276:
      label281:
      label287:
      label293:
      label299:
      label305:
      label310:
      for (i = i3;; i = 0)
      {
        if (i != 0) {
          ((bbbq)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH)).b("100005");
        }
        return;
        i = 0;
        break;
        j = 0;
        break label52;
        k = 0;
        break label66;
        m = 0;
        break label81;
        n = 0;
        break label96;
        i1 = 0;
        break label111;
        i2 = 0;
        break label126;
        i = 0;
        break label160;
      }
      label315:
      i = 0;
    }
  }
  
  public static boolean a()
  {
    long l = DeviceInfoUtil.getSystemTotalMemory();
    if (l < 1073741824L)
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "isLowDevice: totalMemory below 1G: " + l / 1024L / 1024L + "M");
      return true;
    }
    Runtime localRuntime = Runtime.getRuntime();
    float f1 = (float)localRuntime.maxMemory();
    float f2 = (float)(localRuntime.totalMemory() - localRuntime.freeMemory());
    float f3 = f2 / f1 * 100.0F;
    if (f3 > 85.0F)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "isLowDevice: used: " + f2 + " max: " + f1 + " percent: " + f3);
      return true;
    }
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    if (paramQQAppInterface != null) {}
    for (BubbleManager localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(QQManagerFactory.CHAT_BUBBLE_MANAGER);; localBubbleManager = null)
    {
      if ((paramXListView != null) && (localBubbleManager != null))
      {
        int i = paramXListView.getChildCount() - 1;
        while (i >= 0)
        {
          Object localObject = paramXListView.getChildAt(i);
          if ((localObject instanceof BaseChatItemLayout))
          {
            afqr localafqr = (afqr)AIOUtils.getHolder((View)localObject);
            localObject = AIOUtils.getMessage((View)localObject);
            if ((localObject != null) && (((ChatMessage)localObject).needVipBubble()) && (localafqr != null) && (localafqr.a != null) && (localafqr.a.jdField_a_of_type_Int == aqii.a.jdField_a_of_type_Int) && (localBubbleManager.a(aocy.a(((ChatMessage)localObject).vipBubbleID)))) {
              return true;
            }
            if ((localObject != null) && (((gb)paramQQAppInterface.getManager(QQManagerFactory.CHAT_FONT_MANAGER)).a(localafqr, (ChatMessage)localObject))) {
              return true;
            }
          }
          else if ((localObject != null) && ((AIOUtils.getHolder((View)localObject) instanceof ahfo)))
          {
            return true;
          }
          i -= 1;
        }
      }
      return false;
    }
  }
  
  private static boolean a(String paramString)
  {
    return Pattern.compile("^[-\\+]?[\\d]*$").matcher(paramString).matches();
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "unCompressSo fail zipPath = " + paramString1 + " dstPath = " + paramString2);
    }
    for (;;)
    {
      return false;
      if (!new File(paramString1).exists())
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "unCompressSo fail src file not exists");
        return false;
      }
      String str = paramString2 + File.separator + "unzip_temp/";
      try
      {
        FileUtils.uncompressZip(paramString1, str, false);
        paramString1 = new File(str + paramString3);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "unCompressSo tempfile = " + paramString1.getAbsolutePath());
        }
        if (!paramString1.exists())
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "unCompressSo fail so file not exists");
          return false;
        }
      }
      catch (IOException paramString1)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "unCompressSo IOException: ", paramString1);
        return false;
      }
      paramString2 = paramString2 + File.separator + paramString3;
      paramString3 = new File(paramString2);
      boolean bool;
      if (paramString3.exists())
      {
        bool = paramString3.delete();
        QLog.d(jdField_a_of_type_JavaLangString, 1, "unCompressSo so already exists, delete old so result = " + bool);
      }
      while (bool)
      {
        bool = paramString1.renameTo(paramString3);
        QLog.d(jdField_a_of_type_JavaLangString, 1, "unCompressSo rename temp so to real path result = " + bool + "realpath = " + paramString2);
        return bool;
        bool = true;
      }
    }
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte, tencent.im.msg.im_msg_body.GeneralFlags paramGeneralFlags, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: ifnull +295 -> 299
    //   7: aload_1
    //   8: getfield 733	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11: invokevirtual 738	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   14: ifeq +285 -> 299
    //   17: new 740	tencent/im/msg/hummer/resv/generalflags$ResvAttr
    //   20: dup
    //   21: invokespecial 741	tencent/im/msg/hummer/resv/generalflags$ResvAttr:<init>	()V
    //   24: astore 4
    //   26: aload 4
    //   28: aload_1
    //   29: getfield 733	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   32: invokevirtual 745	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   35: invokevirtual 751	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   38: invokevirtual 755	tencent/im/msg/hummer/resv/generalflags$ResvAttr:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   41: pop
    //   42: aload 4
    //   44: getfield 758	tencent/im/msg/hummer/resv/generalflags$ResvAttr:bytes_oac_msg_extend	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   47: invokevirtual 738	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   50: ifeq +244 -> 294
    //   53: new 241	org/json/JSONObject
    //   56: dup
    //   57: new 241	org/json/JSONObject
    //   60: dup
    //   61: aload 4
    //   63: getfield 758	tencent/im/msg/hummer/resv/generalflags$ResvAttr:bytes_oac_msg_extend	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   66: invokevirtual 745	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   69: invokevirtual 761	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   72: invokespecial 250	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   75: ldc 252
    //   77: ldc 245
    //   79: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: invokespecial 250	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: ldc_w 763
    //   90: aload_1
    //   91: ldc 254
    //   93: aconst_null
    //   94: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   100: astore_1
    //   101: aload_1
    //   102: invokestatic 43	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: istore_3
    //   106: iload_3
    //   107: ifeq +5 -> 112
    //   110: aconst_null
    //   111: astore_1
    //   112: aload 5
    //   114: astore 4
    //   116: aload_1
    //   117: ifnull +139 -> 256
    //   120: aload 5
    //   122: astore 4
    //   124: aload_0
    //   125: arraylength
    //   126: ifle +130 -> 256
    //   129: invokestatic 331	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   132: invokevirtual 362	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   135: astore 4
    //   137: aload 4
    //   139: instanceof 76
    //   142: ifeq +149 -> 291
    //   145: aload_1
    //   146: ldc_w 277
    //   149: aload 4
    //   151: checkcast 76	com/tencent/mobileqq/app/QQAppInterface
    //   154: invokestatic 275	bhiw:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   157: invokevirtual 289	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   160: astore_1
    //   161: new 279	java/lang/String
    //   164: dup
    //   165: aload_0
    //   166: iload_2
    //   167: invokestatic 768	bdpo:a	([BI)[B
    //   170: ldc_w 770
    //   173: invokespecial 773	java/lang/String:<init>	([BLjava/lang/String;)V
    //   176: astore_0
    //   177: aload 5
    //   179: astore 4
    //   181: aload_0
    //   182: ldc_w 775
    //   185: invokevirtual 408	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   188: ifeq +68 -> 256
    //   191: getstatic 13	bhiw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   194: iconst_1
    //   195: new 112	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 777
    //   205: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 780	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_0
    //   219: ldc_w 782
    //   222: new 112	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 775
    //   232: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_1
    //   236: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc_w 784
    //   242: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokevirtual 787	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   251: invokevirtual 790	java/lang/String:getBytes	()[B
    //   254: astore 4
    //   256: aload 4
    //   258: areturn
    //   259: astore 4
    //   261: aconst_null
    //   262: astore_1
    //   263: getstatic 13	bhiw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   266: iconst_1
    //   267: aload 4
    //   269: iconst_0
    //   270: anewarray 4	java/lang/Object
    //   273: invokestatic 793	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   276: goto -164 -> 112
    //   279: astore_0
    //   280: aload_0
    //   281: invokevirtual 794	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   284: aconst_null
    //   285: areturn
    //   286: astore 4
    //   288: goto -25 -> 263
    //   291: goto -130 -> 161
    //   294: aconst_null
    //   295: astore_1
    //   296: goto -184 -> 112
    //   299: aconst_null
    //   300: astore_1
    //   301: goto -189 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramArrayOfByte	byte[]
    //   0	304	1	paramGeneralFlags	tencent.im.msg.im_msg_body.GeneralFlags
    //   0	304	2	paramInt	int
    //   105	2	3	bool	boolean
    //   24	233	4	localObject1	Object
    //   259	9	4	localException1	Exception
    //   286	1	4	localException2	Exception
    //   1	177	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	101	259	java/lang/Exception
    //   161	177	279	java/io/UnsupportedEncodingException
    //   181	256	279	java/io/UnsupportedEncodingException
    //   101	106	286	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhiw
 * JD-Core Version:    0.7.0.1
 */