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

public final class bajo
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
    if (agwf.a()) {
      return 1;
    }
    if (agwf.c()) {
      return 2;
    }
    if (agwf.e()) {
      return 5;
    }
    if (!TextUtils.isEmpty(azzu.a("ro.build.version.opporom"))) {
      return 3;
    }
    if (!TextUtils.isEmpty(azzu.a("ro.vivo.os.version"))) {
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
    paramQQAppInterface = ((ajjj)paramQQAppInterface.getManager(51)).e(paramString);
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
  
  public static void a()
  {
    aqcx.a().d();
    ETTextView.e();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      aqdf localaqdf = (aqdf)((QQAppInterface)localObject).getManager(219);
      if (localaqdf != null) {
        localaqdf.d();
      }
      localObject = (fv)((QQAppInterface)localObject).getManager(42);
      if (localObject != null) {
        ((fv)localObject).b();
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
        localObject1 = bant.a("signatureEntrance");
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
      localObject1 = bant.a("signatureDIYEntrance");
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
    awcl localawcl = (awcl)paramQQAppInterface.getManager(12);
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
    if (localawcl != null)
    {
      if (localawcl.a("100005.100001") == -1) {
        break label263;
      }
      i = 1;
      if (i != 0)
      {
        if (localawcl.a("100005.100003") == -1) {
          break label268;
        }
        j = 1;
        if (localawcl.a("100005.100002") == -1) {
          break label273;
        }
        k = 1;
        if (localawcl.a("100005.100006") == -1) {
          break label278;
        }
        m = 1;
        if (localawcl.a("100005.100018") == -1) {
          break label284;
        }
        n = 1;
        if (localawcl.a("100005.100020") == -1) {
          break label290;
        }
        i1 = 1;
        if (localawcl.a("100005.100021") == -1) {
          break label296;
        }
        i2 = 1;
        bool = ((fv)paramQQAppInterface.getManager(42)).a;
        if (!bool) {
          break label312;
        }
        if (localawcl.a("100005.100011") == -1) {
          break label302;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label158:
      if (((bool) && (j == 0) && (k == 0) && (m == 0) && (i == 0) && (n == 0) && (i1 == 0) && (i2 == 0)) || ((!bool) && (j == 0) && (k == 0) && (m == 0) && (n == 0) && (i1 == 0) && (i2 == 0))) {
        if (localawcl.a("100005") == -1) {
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
          ((auqh)paramQQAppInterface.getManager(36)).b("100005");
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
    long l = babp.d();
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
            acju localacju = (acju)aciy.a((View)localObject);
            localObject = aciy.a((View)localObject);
            if ((localObject != null) && (((ChatMessage)localObject).needVipBubble()) && (localacju != null) && (localacju.a != null) && (localacju.a.jdField_a_of_type_Int == alnt.a.jdField_a_of_type_Int) && (localBubbleManager.a(ajrm.a(((ChatMessage)localObject).vipBubbleID)))) {
              return true;
            }
            if ((localObject != null) && (((fv)paramQQAppInterface.getManager(42)).a(localacju, (ChatMessage)localObject))) {
              return true;
            }
          }
          else if ((localObject != null) && ((aciy.a((View)localObject) instanceof adnv)))
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
        bace.a(paramString1, str, false);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajo
 * JD-Core Version:    0.7.0.1
 */