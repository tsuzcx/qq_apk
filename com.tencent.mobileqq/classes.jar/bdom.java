import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
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

public final class bdom
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
    if (ajeq.a()) {
      return 1;
    }
    if (ajeq.c()) {
      return 2;
    }
    if (ajeq.e()) {
      return 5;
    }
    if (!TextUtils.isEmpty(bdep.a("ro.build.version.opporom"))) {
      return 3;
    }
    if (!TextUtils.isEmpty(bdep.a("ro.vivo.os.version"))) {
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
    paramQQAppInterface = ((alto)paramQQAppInterface.getManager(51)).e(paramString);
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
    //   5: new 102	java/io/File
    //   8: dup
    //   9: new 104	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: getstatic 114	java/io/File:separator	Ljava/lang/String;
    //   23: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokespecial 121	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 4
    //   38: aload 4
    //   40: invokevirtual 124	java/io/File:exists	()Z
    //   43: istore_3
    //   44: iload_3
    //   45: ifne +8 -> 53
    //   48: ldc 2
    //   50: monitorexit
    //   51: iload_2
    //   52: ireturn
    //   53: new 104	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: getstatic 114	java/io/File:separator	Ljava/lang/String;
    //   67: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 129	java/lang/System:load	(Ljava/lang/String;)V
    //   80: iconst_0
    //   81: istore_2
    //   82: goto -34 -> 48
    //   85: astore_0
    //   86: ldc 131
    //   88: iconst_1
    //   89: new 104	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   96: ldc 133
    //   98: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload_0
    //   102: invokevirtual 136	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   105: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 141	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload 4
    //   116: invokevirtual 144	java/io/File:delete	()Z
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
  
  /* Error */
  public static SpannableString a(QQAppInterface paramQQAppInterface, com.tencent.imcore.message.QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload 8
    //   5: astore 6
    //   7: aload_1
    //   8: getfield 231	com/tencent/imcore/message/QQMessageFacade$Message:mExJsonObject	Lorg/json/JSONObject;
    //   11: ifnull +183 -> 194
    //   14: new 233	org/json/JSONObject
    //   17: dup
    //   18: new 233	org/json/JSONObject
    //   21: dup
    //   22: aload_1
    //   23: getfield 231	com/tencent/imcore/message/QQMessageFacade$Message:mExJsonObject	Lorg/json/JSONObject;
    //   26: ldc 235
    //   28: ldc 237
    //   30: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: invokespecial 242	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   36: ldc 244
    //   38: ldc 237
    //   40: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: invokespecial 242	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   46: astore 6
    //   48: aload 6
    //   50: ldc 246
    //   52: aconst_null
    //   53: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_1
    //   57: aload 6
    //   59: ldc 248
    //   61: ldc 250
    //   63: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   66: astore 6
    //   68: aload_1
    //   69: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   72: istore 5
    //   74: iload 5
    //   76: ifeq +5 -> 81
    //   79: aconst_null
    //   80: astore_1
    //   81: aload_1
    //   82: astore 7
    //   84: aload 6
    //   86: astore_1
    //   87: aload_0
    //   88: invokestatic 253	bdom:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   91: astore_0
    //   92: aload 8
    //   94: astore 6
    //   96: aload 7
    //   98: ifnull +96 -> 194
    //   101: aload 7
    //   103: ldc 255
    //   105: invokevirtual 261	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   108: istore_3
    //   109: aload_0
    //   110: invokevirtual 264	java/lang/String:length	()I
    //   113: iload_3
    //   114: iadd
    //   115: istore 4
    //   117: aload 7
    //   119: ldc 255
    //   121: aload_0
    //   122: invokevirtual 268	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   125: astore_0
    //   126: iload_3
    //   127: iconst_m1
    //   128: if_icmple +95 -> 223
    //   131: new 270	android/text/SpannableString
    //   134: dup
    //   135: aload_0
    //   136: invokespecial 273	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   139: astore_0
    //   140: aload_0
    //   141: astore 6
    //   143: aload_1
    //   144: ifnull +50 -> 194
    //   147: aload_0
    //   148: astore 6
    //   150: iload_2
    //   151: ifeq +43 -> 194
    //   154: aload_0
    //   155: new 275	android/text/style/StyleSpan
    //   158: dup
    //   159: iconst_1
    //   160: invokespecial 276	android/text/style/StyleSpan:<init>	(I)V
    //   163: iload_3
    //   164: iload 4
    //   166: bipush 18
    //   168: invokevirtual 280	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   171: aload_0
    //   172: new 282	android/text/style/ForegroundColorSpan
    //   175: dup
    //   176: aload_1
    //   177: invokestatic 287	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   180: invokespecial 288	android/text/style/ForegroundColorSpan:<init>	(I)V
    //   183: iload_3
    //   184: iload 4
    //   186: bipush 18
    //   188: invokevirtual 280	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   191: aload_0
    //   192: astore 6
    //   194: aload 6
    //   196: areturn
    //   197: astore 7
    //   199: aconst_null
    //   200: astore 6
    //   202: aconst_null
    //   203: astore_1
    //   204: aload 7
    //   206: invokevirtual 291	org/json/JSONException:printStackTrace	()V
    //   209: aload 6
    //   211: astore 7
    //   213: goto -126 -> 87
    //   216: astore_1
    //   217: aload_1
    //   218: invokevirtual 292	java/lang/IllegalArgumentException:printStackTrace	()V
    //   221: aload_0
    //   222: areturn
    //   223: new 270	android/text/SpannableString
    //   226: dup
    //   227: aload_0
    //   228: invokespecial 273	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   231: areturn
    //   232: astore 7
    //   234: aload_1
    //   235: astore 6
    //   237: aconst_null
    //   238: astore_1
    //   239: goto -35 -> 204
    //   242: astore 9
    //   244: aload_1
    //   245: astore 7
    //   247: aload 6
    //   249: astore_1
    //   250: aload 7
    //   252: astore 6
    //   254: aload 9
    //   256: astore 7
    //   258: goto -54 -> 204
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramQQAppInterface	QQAppInterface
    //   0	261	1	paramMessage	com.tencent.imcore.message.QQMessageFacade.Message
    //   0	261	2	paramBoolean	boolean
    //   108	76	3	i	int
    //   115	70	4	j	int
    //   72	3	5	bool	boolean
    //   5	248	6	localObject1	Object
    //   82	36	7	localMessage	com.tencent.imcore.message.QQMessageFacade.Message
    //   197	8	7	localJSONException1	org.json.JSONException
    //   211	1	7	localObject2	Object
    //   232	1	7	localJSONException2	org.json.JSONException
    //   245	12	7	localObject3	Object
    //   1	92	8	localObject4	Object
    //   242	13	9	localJSONException3	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   14	57	197	org/json/JSONException
    //   154	191	216	java/lang/IllegalArgumentException
    //   57	68	232	org/json/JSONException
    //   68	74	242	org/json/JSONException
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
    asry.a().d();
    ETTextView.clearCache();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      assg localassg = (assg)((QQAppInterface)localObject).getManager(219);
      if (localassg != null) {
        localassg.d();
      }
      localObject = (fx)((QQAppInterface)localObject).getManager(42);
      if (localObject != null) {
        ((fx)localObject).b();
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
        localObject1 = bdtg.a("signatureEntrance");
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
      localObject1 = bdtg.a("signatureDIYEntrance");
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
    azbi localazbi = (azbi)paramQQAppInterface.getManager(12);
    int i;
    int j;
    label51:
    int k;
    label65:
    int m;
    label80:
    int n;
    label95:
    int i1;
    label110:
    int i2;
    label125:
    boolean bool;
    if (localazbi != null)
    {
      if (localazbi.a("100005.100001") == -1) {
        break label263;
      }
      i = 1;
      if (i != 0)
      {
        if (localazbi.a("100005.100003") == -1) {
          break label268;
        }
        j = 1;
        if (localazbi.a("100005.100002") == -1) {
          break label273;
        }
        k = 1;
        if (localazbi.a("100005.100006") == -1) {
          break label278;
        }
        m = 1;
        if (localazbi.a("100005.100018") == -1) {
          break label284;
        }
        n = 1;
        if (localazbi.a("100005.100020") == -1) {
          break label290;
        }
        i1 = 1;
        if (localazbi.a("100005.100021") == -1) {
          break label296;
        }
        i2 = 1;
        bool = ((fx)paramQQAppInterface.getManager(42)).a;
        if (!bool) {
          break label312;
        }
        if (localazbi.a("100005.100011") == -1) {
          break label302;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label158:
      if (((bool) && (j == 0) && (k == 0) && (m == 0) && (i == 0) && (n == 0) && (i1 == 0) && (i2 == 0)) || ((!bool) && (j == 0) && (k == 0) && (m == 0) && (n == 0) && (i1 == 0) && (i2 == 0))) {
        if (localazbi.a("100005") == -1) {
          break label307;
        }
      }
      label263:
      label268:
      label273:
      label278:
      label284:
      label290:
      label296:
      label302:
      label307:
      for (i = i3;; i = 0)
      {
        if (i != 0) {
          ((axlx)paramQQAppInterface.getManager(36)).b("100005");
        }
        return;
        i = 0;
        break;
        j = 0;
        break label51;
        k = 0;
        break label65;
        m = 0;
        break label80;
        n = 0;
        break label95;
        i1 = 0;
        break label110;
        i2 = 0;
        break label125;
        i = 0;
        break label158;
      }
      label312:
      i = 0;
    }
  }
  
  public static boolean a()
  {
    long l = bdgk.d();
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
    for (BubbleManager localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(44);; localBubbleManager = null)
    {
      if ((paramXListView != null) && (localBubbleManager != null))
      {
        int i = paramXListView.getChildCount() - 1;
        while (i >= 0)
        {
          Object localObject = paramXListView.getChildAt(i);
          if ((localObject instanceof BaseChatItemLayout))
          {
            aeqi localaeqi = (aeqi)aepi.a((View)localObject);
            localObject = aepi.a((View)localObject);
            if ((localObject != null) && (((ChatMessage)localObject).needVipBubble()) && (localaeqi != null) && (localaeqi.a != null) && (localaeqi.a.jdField_a_of_type_Int == anxo.a.jdField_a_of_type_Int) && (localBubbleManager.a(amca.a(((ChatMessage)localObject).vipBubbleID)))) {
              return true;
            }
            if ((localObject != null) && (((fx)paramQQAppInterface.getManager(42)).a(localaeqi, (ChatMessage)localObject))) {
              return true;
            }
          }
          else if ((localObject != null) && ((aepi.a((View)localObject) instanceof afzv)))
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
        bdhb.a(paramString1, str, false);
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
    //   4: ifnull +294 -> 298
    //   7: aload_1
    //   8: getfield 692	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11: invokevirtual 697	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   14: ifeq +284 -> 298
    //   17: new 699	tencent/im/msg/hummer/resv/generalflags$ResvAttr
    //   20: dup
    //   21: invokespecial 700	tencent/im/msg/hummer/resv/generalflags$ResvAttr:<init>	()V
    //   24: astore 4
    //   26: aload 4
    //   28: aload_1
    //   29: getfield 692	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   32: invokevirtual 704	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   35: invokevirtual 710	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   38: invokevirtual 714	tencent/im/msg/hummer/resv/generalflags$ResvAttr:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   41: pop
    //   42: aload 4
    //   44: getfield 717	tencent/im/msg/hummer/resv/generalflags$ResvAttr:bytes_oac_msg_extend	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   47: invokevirtual 697	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   50: ifeq +243 -> 293
    //   53: new 233	org/json/JSONObject
    //   56: dup
    //   57: new 233	org/json/JSONObject
    //   60: dup
    //   61: aload 4
    //   63: getfield 717	tencent/im/msg/hummer/resv/generalflags$ResvAttr:bytes_oac_msg_extend	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   66: invokevirtual 704	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   69: invokevirtual 720	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   72: invokespecial 242	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   75: ldc 244
    //   77: ldc 237
    //   79: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: invokespecial 242	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: ldc_w 722
    //   90: aload_1
    //   91: ldc 246
    //   93: aconst_null
    //   94: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: invokevirtual 241	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   100: astore_1
    //   101: aload_1
    //   102: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: istore_3
    //   106: iload_3
    //   107: ifeq +5 -> 112
    //   110: aconst_null
    //   111: astore_1
    //   112: aload 5
    //   114: astore 4
    //   116: aload_1
    //   117: ifnull +138 -> 255
    //   120: aload 5
    //   122: astore 4
    //   124: aload_0
    //   125: arraylength
    //   126: ifle +129 -> 255
    //   129: invokestatic 309	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   132: invokevirtual 340	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   135: astore 4
    //   137: aload 4
    //   139: instanceof 69
    //   142: ifeq +148 -> 290
    //   145: aload_1
    //   146: ldc 255
    //   148: aload 4
    //   150: checkcast 69	com/tencent/mobileqq/app/QQAppInterface
    //   153: invokestatic 253	bdom:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   156: invokevirtual 268	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   159: astore_1
    //   160: new 257	java/lang/String
    //   163: dup
    //   164: aload_0
    //   165: iload_2
    //   166: invokestatic 727	azwm:a	([BI)[B
    //   169: ldc_w 729
    //   172: invokespecial 732	java/lang/String:<init>	([BLjava/lang/String;)V
    //   175: astore_0
    //   176: aload 5
    //   178: astore 4
    //   180: aload_0
    //   181: ldc_w 734
    //   184: invokevirtual 380	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   187: ifeq +68 -> 255
    //   190: getstatic 13	bdom:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   193: iconst_1
    //   194: new 104	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 736
    //   204: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 739	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_0
    //   218: ldc_w 741
    //   221: new 104	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   228: ldc_w 734
    //   231: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: aload_1
    //   235: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: ldc_w 743
    //   241: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   247: invokevirtual 746	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   250: invokevirtual 749	java/lang/String:getBytes	()[B
    //   253: astore 4
    //   255: aload 4
    //   257: areturn
    //   258: astore 4
    //   260: aconst_null
    //   261: astore_1
    //   262: getstatic 13	bdom:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   265: iconst_1
    //   266: aload 4
    //   268: iconst_0
    //   269: anewarray 4	java/lang/Object
    //   272: invokestatic 752	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   275: goto -163 -> 112
    //   278: astore_0
    //   279: aload_0
    //   280: invokevirtual 753	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   283: aconst_null
    //   284: areturn
    //   285: astore 4
    //   287: goto -25 -> 262
    //   290: goto -130 -> 160
    //   293: aconst_null
    //   294: astore_1
    //   295: goto -183 -> 112
    //   298: aconst_null
    //   299: astore_1
    //   300: goto -188 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	paramArrayOfByte	byte[]
    //   0	303	1	paramGeneralFlags	tencent.im.msg.im_msg_body.GeneralFlags
    //   0	303	2	paramInt	int
    //   105	2	3	bool	boolean
    //   24	232	4	localObject1	Object
    //   258	9	4	localException1	Exception
    //   285	1	4	localException2	Exception
    //   1	176	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	101	258	java/lang/Exception
    //   160	176	278	java/io/UnsupportedEncodingException
    //   180	255	278	java/io/UnsupportedEncodingException
    //   101	106	285	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdom
 * JD-Core Version:    0.7.0.1
 */