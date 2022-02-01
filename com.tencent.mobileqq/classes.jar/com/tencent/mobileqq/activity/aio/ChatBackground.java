package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.DIYThemeUtils;
import com.tencent.mobileqq.theme.diy.ResData;
import com.tencent.mobileqq.theme.diy.ThemeBackground;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatBackground
{
  public ColorStateList a;
  public Drawable a;
  public String a;
  public boolean a;
  
  public static int a(Bitmap paramBitmap)
  {
    int i = 0;
    if (paramBitmap != null)
    {
      int j = paramBitmap.getWidth();
      int n = paramBitmap.getHeight();
      int[] arrayOfInt = new int[n];
      paramBitmap.getPixels(arrayOfInt, 0, 1, j / 2, 0, 1, n);
      j = 0;
      int k = 0;
      int m = 0;
      while (i < n)
      {
        int i1 = arrayOfInt[i];
        m += Color.red(i1);
        k += Color.green(i1);
        j += Color.blue(i1);
        i += 1;
      }
      if ((j + (m + k)) / n / 3 > 220) {
        return -10395552;
      }
      return -1;
    }
    return -10395552;
  }
  
  public static SharedPreferences a(Context paramContext, String paramString, int paramInt)
  {
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString, paramInt);
    if (DiySecureFileHelper.a("QQThemeChatBackgroundMigration", paramString) < 1)
    {
      SharedPreferences.Editor localEditor = paramContext.edit();
      QLog.d("DiySecureFileHelper", 1, "Move Chatbackground SharedPreferences");
      int i;
      if (paramContext.getAll() != null)
      {
        Iterator localIterator = paramContext.getAll().entrySet().iterator();
        paramInt = 0;
        i = paramInt;
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          String str;
          if ((localEntry.getValue() instanceof String))
          {
            str = (String)localEntry.getValue();
            i = paramInt;
            if (str != null)
            {
              i = paramInt;
              if (str.contains("/custom_background/" + paramString + "/"))
              {
                localEditor.putString((String)localEntry.getKey(), str.replace("/custom_background/" + paramString + "/", "/custom_background/" + DiySecureFileHelper.a(paramString) + "/"));
                i = 1;
              }
            }
            paramInt = i;
            if (str == null) {
              break label716;
            }
            paramInt = i;
            if (!str.contains("/" + paramString + "/custom_background/")) {
              break label716;
            }
            localEditor.putString((String)localEntry.getKey(), str.replace("/" + paramString + "/custom_background/", "/custom_background/" + DiySecureFileHelper.a(paramString) + "/"));
            paramInt = 1;
          }
          label647:
          label683:
          label716:
          for (;;)
          {
            break;
            str = (String)localEntry.getKey();
            i = paramInt;
            if (str != null)
            {
              i = paramInt;
              if (str.contains("/custom_background/" + paramString + "/"))
              {
                if (!(localEntry.getValue() instanceof Integer)) {
                  break label647;
                }
                localEditor.putInt(str.replace("/custom_background/" + paramString + "/", "/custom_background/" + DiySecureFileHelper.a(paramString) + "/"), ((Integer)localEntry.getValue()).intValue());
              }
            }
            for (i = 1;; i = paramInt)
            {
              paramInt = i;
              if (str == null) {
                break label716;
              }
              paramInt = i;
              if (!str.contains("/" + paramString + "/custom_background/")) {
                break label716;
              }
              if (!(localEntry.getValue() instanceof Integer)) {
                break label683;
              }
              localEditor.putInt(str.replace("/" + paramString + "/custom_background/", "/custom_background/" + DiySecureFileHelper.a(paramString) + "/"), ((Integer)localEntry.getValue()).intValue());
              paramInt = 1;
              break;
              QLog.e("DiySecureFileHelper", 1, "value not int : " + localEntry.getValue());
            }
            QLog.e("DiySecureFileHelper", 1, "value not int : " + localEntry.getValue());
            paramInt = i;
          }
        }
      }
      else
      {
        QLog.e("DiySecureFileHelper", 1, "sf.getAll is null");
        i = 0;
      }
      if (i != 0) {
        localEditor.commit();
      }
      DiySecureFileHelper.a("QQThemeChatBackgroundMigration", paramString, 1);
    }
    return paramContext;
  }
  
  private static ColorStateList a(SharedPreferences paramSharedPreferences, String paramString, Bitmap paramBitmap)
  {
    paramString = "chat_backgournd_nickname_color." + paramString;
    if (paramSharedPreferences.contains(paramString)) {
      return ColorStateList.valueOf(paramSharedPreferences.getInt(paramString, -10395552));
    }
    int i = a(paramBitmap);
    paramSharedPreferences.edit().putInt(paramString, i).commit();
    return ColorStateList.valueOf(i);
  }
  
  /* Error */
  @android.support.annotation.Nullable
  private static Bitmap a(Context paramContext, String paramString)
  {
    // Byte code:
    //   0: new 190	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 191	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore 6
    //   9: ldc 193
    //   11: getstatic 198	android/os/Build:BRAND	Ljava/lang/String;
    //   14: invokevirtual 201	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   17: ifeq +469 -> 486
    //   20: aload 6
    //   22: getstatic 207	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   25: putfield 210	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   28: aload 6
    //   30: iconst_1
    //   31: putfield 213	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   34: aload 6
    //   36: iconst_1
    //   37: putfield 217	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   40: aload 6
    //   42: iconst_0
    //   43: putfield 213	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   46: aload_1
    //   47: aload 6
    //   49: invokestatic 222	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   52: astore 5
    //   54: aload 5
    //   56: getfield 227	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   59: astore 4
    //   61: aload 4
    //   63: ifnull +11 -> 74
    //   66: aload 5
    //   68: getfield 229	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   71: ifeq +431 -> 502
    //   74: new 44	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   81: ldc 231
    //   83: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 233
    //   92: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: astore 7
    //   97: aload 4
    //   99: ifnonnull +398 -> 497
    //   102: iconst_1
    //   103: istore_3
    //   104: ldc 235
    //   106: iconst_1
    //   107: aload 7
    //   109: iload_3
    //   110: invokevirtual 238	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   113: ldc 240
    //   115: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 6
    //   120: getfield 217	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   123: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: new 245	java/util/HashMap
    //   135: dup
    //   136: invokespecial 246	java/util/HashMap:<init>	()V
    //   139: astore 7
    //   141: aload 7
    //   143: ldc 248
    //   145: new 44	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   152: ldc 250
    //   154: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 5
    //   159: getfield 229	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   162: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   171: pop
    //   172: aload 7
    //   174: ldc_w 256
    //   177: invokestatic 261	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   180: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   183: pop
    //   184: aload_0
    //   185: invokestatic 267	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   188: astore 8
    //   190: getstatic 273	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   193: invokevirtual 277	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   196: checkcast 279	com/tencent/mobileqq/app/QQAppInterface
    //   199: invokevirtual 282	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   202: astore 9
    //   204: aload 4
    //   206: ifnull +354 -> 560
    //   209: iconst_1
    //   210: istore_3
    //   211: aload 8
    //   213: aload 9
    //   215: ldc_w 284
    //   218: iload_3
    //   219: lconst_1
    //   220: lconst_0
    //   221: aload 7
    //   223: ldc_w 286
    //   226: iconst_0
    //   227: invokevirtual 290	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   230: aload 5
    //   232: getfield 229	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   235: iconst_1
    //   236: if_icmpne +355 -> 591
    //   239: ldc 235
    //   241: iconst_1
    //   242: new 44	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   249: ldc_w 292
    //   252: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: aload_1
    //   256: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   262: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   265: aload 6
    //   267: getfield 217	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   270: iconst_2
    //   271: imul
    //   272: istore_2
    //   273: iload_2
    //   274: bipush 32
    //   276: if_icmpgt +114 -> 390
    //   279: aload 6
    //   281: iload_2
    //   282: putfield 217	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   285: aload_1
    //   286: aload 6
    //   288: invokestatic 222	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   291: astore 5
    //   293: aload 5
    //   295: getfield 227	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   298: astore 4
    //   300: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifne +8 -> 311
    //   306: aload 4
    //   308: ifnonnull +73 -> 381
    //   311: new 44	java/lang/StringBuilder
    //   314: dup
    //   315: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   318: ldc_w 297
    //   321: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload 5
    //   326: getfield 229	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   329: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: ldc_w 299
    //   335: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_1
    //   339: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: ldc_w 301
    //   345: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: iload_2
    //   349: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: ldc 233
    //   354: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: astore 7
    //   359: aload 4
    //   361: ifnull +204 -> 565
    //   364: iconst_1
    //   365: istore_3
    //   366: ldc 235
    //   368: iconst_2
    //   369: aload 7
    //   371: iload_3
    //   372: invokevirtual 238	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   375: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   378: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   381: aload 5
    //   383: getfield 229	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   386: iconst_1
    //   387: if_icmpeq +183 -> 570
    //   390: new 245	java/util/HashMap
    //   393: dup
    //   394: invokespecial 246	java/util/HashMap:<init>	()V
    //   397: astore_1
    //   398: aload_1
    //   399: ldc 248
    //   401: new 44	java/lang/StringBuilder
    //   404: dup
    //   405: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   408: ldc_w 303
    //   411: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   414: aload 5
    //   416: getfield 229	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   419: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   428: pop
    //   429: aload_1
    //   430: ldc_w 256
    //   433: invokestatic 261	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   436: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   439: pop
    //   440: aload_0
    //   441: invokestatic 267	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   444: astore_0
    //   445: getstatic 273	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   448: invokevirtual 277	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   451: checkcast 279	com/tencent/mobileqq/app/QQAppInterface
    //   454: invokevirtual 282	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   457: astore 5
    //   459: aload 4
    //   461: ifnull +116 -> 577
    //   464: iconst_1
    //   465: istore_3
    //   466: aload_0
    //   467: aload 5
    //   469: ldc_w 284
    //   472: iload_3
    //   473: lconst_1
    //   474: lconst_0
    //   475: aload_1
    //   476: ldc_w 286
    //   479: iconst_0
    //   480: invokevirtual 290	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   483: aload 4
    //   485: areturn
    //   486: aload 6
    //   488: getstatic 306	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   491: putfield 210	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   494: goto -466 -> 28
    //   497: iconst_0
    //   498: istore_3
    //   499: goto -395 -> 104
    //   502: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   505: ifeq -373 -> 132
    //   508: ldc 235
    //   510: iconst_2
    //   511: new 44	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   518: ldc_w 308
    //   521: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: aload_1
    //   525: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: ldc_w 299
    //   531: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_1
    //   535: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: ldc 240
    //   540: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: aload 6
    //   545: getfield 217	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   548: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   551: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: goto -425 -> 132
    //   560: iconst_0
    //   561: istore_3
    //   562: goto -351 -> 211
    //   565: iconst_0
    //   566: istore_3
    //   567: goto -201 -> 366
    //   570: iload_2
    //   571: iconst_2
    //   572: imul
    //   573: istore_2
    //   574: goto -301 -> 273
    //   577: iconst_0
    //   578: istore_3
    //   579: goto -113 -> 466
    //   582: astore_0
    //   583: aload 4
    //   585: areturn
    //   586: astore 7
    //   588: goto -358 -> 230
    //   591: aload 4
    //   593: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	paramContext	Context
    //   0	594	1	paramString	String
    //   272	302	2	i	int
    //   103	476	3	bool	boolean
    //   59	533	4	localBitmap	Bitmap
    //   52	416	5	localObject1	Object
    //   7	537	6	localOptions	android.graphics.BitmapFactory.Options
    //   95	275	7	localObject2	Object
    //   586	1	7	localException	Exception
    //   188	24	8	localStatisticCollector	StatisticCollector
    //   202	12	9	str	String
    // Exception table:
    //   from	to	target	type
    //   390	459	582	java/lang/Exception
    //   466	483	582	java/lang/Exception
    //   132	204	586	java/lang/Exception
    //   211	230	586	java/lang/Exception
  }
  
  private static Bitmap a(Context paramContext, String paramString, Bitmap paramBitmap, File paramFile)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    boolean bool4 = QQSharpPUtil.a(paramContext);
    if ((QLog.isColorLevel()) || (!bool4)) {
      QLog.d("ChatBackground", 2, "getChatBackground, sharpP exists, path=" + paramString + ", sharpPAv=" + bool4);
    }
    paramContext = paramBitmap;
    if (bool4) {}
    for (;;)
    {
      try
      {
        paramContext = SharpPUtil.decodeSharpPByFilePath(paramFile.getAbsolutePath());
        paramBitmap = paramContext;
        if (!QLog.isColorLevel())
        {
          paramContext = paramBitmap;
          if (paramBitmap != null) {}
        }
        else
        {
          paramContext = new StringBuilder().append("getChatBackground, sharpP decode result=");
          if (paramBitmap == null) {
            continue;
          }
          QLog.d("ChatBackground", 2, bool1 + ", path=" + paramString);
          paramContext = paramBitmap;
        }
      }
      catch (UnsatisfiedLinkError paramContext)
      {
        QLog.e("ChatBackground", 1, "sharpP decodeSharpPByFilePath UnsatisfiedLinkError, msg:" + paramContext.getMessage());
        if (QLog.isColorLevel()) {
          continue;
        }
        paramContext = paramBitmap;
        if (paramBitmap != null) {
          continue;
        }
        paramContext = new StringBuilder().append("getChatBackground, sharpP decode result=");
        if (paramBitmap == null) {
          continue;
        }
        bool1 = bool2;
        QLog.d("ChatBackground", 2, bool1 + ", path=" + paramString);
        return paramBitmap;
        bool1 = false;
        continue;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          break label253;
        }
      }
      return paramContext;
      bool1 = false;
    }
    if (paramBitmap == null)
    {
      label253:
      paramFile = new StringBuilder().append("getChatBackground, sharpP decode result=");
      if (paramBitmap == null) {
        break label302;
      }
    }
    label302:
    for (bool1 = bool3;; bool1 = false)
    {
      QLog.d("ChatBackground", 2, bool1 + ", path=" + paramString);
      throw paramContext;
    }
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    return ChatBackgroundManager.a(paramContext, paramString1, paramString2);
  }
  
  private static void a(Context paramContext, ChatBackground paramChatBackground, SharedPreferences paramSharedPreferences, String paramString)
  {
    long l1 = SystemClock.uptimeMillis();
    Bitmap localBitmap = (Bitmap)GlobalImageCache.a.get(paramString);
    if (localBitmap == null) {
      localBitmap = a(paramContext, paramString);
    }
    for (;;)
    {
      long l2 = SystemClock.uptimeMillis();
      if (localBitmap != null) {
        GlobalImageCache.a.put(paramString, localBitmap);
      }
      for (Object localObject = new ChatBackgroundDrawable(paramContext.getResources(), localBitmap);; localObject = paramContext.getResources().getDrawable(2130839222))
      {
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("key_use_rect", true);
        localBundle.putBoolean("key_double_bitmap", true);
        paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), paramString, "-chatBg-", (Drawable)localObject, new int[] { 0 }, "-chatBg-", localBundle);
        if ((paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (localBitmap != null)) {
          paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ChatBackgroundDrawable(paramContext.getResources(), localBitmap);
        }
        paramChatBackground.jdField_a_of_type_JavaLangString = paramString;
        paramChatBackground.jdField_a_of_type_Boolean = true;
        if (localBitmap != null) {
          paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = a(paramSharedPreferences, paramString, localBitmap);
        }
        long l3 = SystemClock.uptimeMillis();
        QLog.d("ChatBackground_Time", 1, "APNG_getBitmap " + (l2 - l1) + " APNG_init " + (l3 - l2));
        return;
      }
    }
  }
  
  /* Error */
  static void a(Context paramContext, ChatBackground paramChatBackground, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: getstatic 428	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   3: astore 6
    //   5: aload_0
    //   6: invokevirtual 371	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   9: ldc_w 413
    //   12: invokevirtual 419	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   15: astore 7
    //   17: aload 7
    //   19: ifnonnull +13 -> 32
    //   22: ldc 235
    //   24: iconst_1
    //   25: ldc_w 430
    //   28: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: return
    //   32: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +40 -> 75
    //   38: ldc 235
    //   40: iconst_2
    //   41: new 44	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   48: ldc_w 432
    //   51: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload 7
    //   56: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: ldc_w 434
    //   62: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: aload_2
    //   66: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: iconst_0
    //   76: istore 4
    //   78: iconst_0
    //   79: istore 5
    //   81: getstatic 440	com/tencent/mobileqq/theme/diy/ThemeBackground:sAIOBusinessFlag	Lcom/tencent/mobileqq/theme/diy/ThemeBackground$BusinessFlag;
    //   84: invokevirtual 445	com/tencent/mobileqq/theme/diy/ThemeBackground$BusinessFlag:setUseStatic	()V
    //   87: invokestatic 448	com/tencent/mobileqq/theme/ThemeUtil:isNowThemeIsAnimate	()Z
    //   90: ifeq +153 -> 243
    //   93: iconst_3
    //   94: invokestatic 452	com/tencent/mobileqq/theme/ThemeUtil:getAnimatePathByTag	(I)Ljava/lang/String;
    //   97: astore_2
    //   98: new 376	android/os/Bundle
    //   101: dup
    //   102: invokespecial 377	android/os/Bundle:<init>	()V
    //   105: astore 8
    //   107: aload 8
    //   109: ldc_w 379
    //   112: iconst_1
    //   113: invokevirtual 383	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   116: aload 8
    //   118: ldc_w 454
    //   121: iload_3
    //   122: invokevirtual 383	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   125: aload_2
    //   126: ldc_w 456
    //   129: ldc_w 413
    //   132: invokestatic 460	com/tencent/mobileqq/theme/diy/ThemeBackground:getDynamicDrawable	(Ljava/lang/String;Ljava/lang/String;I)Landroid/graphics/drawable/Drawable;
    //   135: astore 9
    //   137: aload 9
    //   139: ifnull +32 -> 171
    //   142: invokestatic 465	com/tencent/mobileqq/vas/gldrawable/GLDrawableWraper:a	()Lcom/tencent/mobileqq/vas/gldrawable/GLDrawableWraper;
    //   145: aload 9
    //   147: iconst_1
    //   148: invokevirtual 468	com/tencent/mobileqq/vas/gldrawable/GLDrawableWraper:a	(Landroid/graphics/drawable/Drawable;Z)V
    //   151: aload_1
    //   152: aload 9
    //   154: putfield 395	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   157: aload_1
    //   158: aload_2
    //   159: putfield 397	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   162: iconst_1
    //   163: istore 5
    //   165: getstatic 440	com/tencent/mobileqq/theme/diy/ThemeBackground:sAIOBusinessFlag	Lcom/tencent/mobileqq/theme/diy/ThemeBackground$BusinessFlag;
    //   168: invokevirtual 471	com/tencent/mobileqq/theme/diy/ThemeBackground$BusinessFlag:setUseVideo	()V
    //   171: iload 5
    //   173: istore 4
    //   175: iload 5
    //   177: ifne +66 -> 243
    //   180: iload 5
    //   182: istore 4
    //   184: new 323	java/io/File
    //   187: dup
    //   188: aload_2
    //   189: invokespecial 474	java/io/File:<init>	(Ljava/lang/String;)V
    //   192: invokevirtual 477	java/io/File:exists	()Z
    //   195: ifeq +48 -> 243
    //   198: aload_1
    //   199: getstatic 273	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   202: invokevirtual 277	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   205: aload_2
    //   206: ldc_w 387
    //   209: aload 7
    //   211: iconst_1
    //   212: newarray int
    //   214: dup
    //   215: iconst_0
    //   216: iconst_0
    //   217: iastore
    //   218: ldc_w 387
    //   221: aload 8
    //   223: invokestatic 393	com/tencent/mobileqq/vas/VasApngUtil:getApngDrawable	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/drawable/Drawable;[ILjava/lang/String;Landroid/os/Bundle;)Lcom/tencent/image/URLDrawable;
    //   226: putfield 395	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   229: aload_1
    //   230: aload_2
    //   231: putfield 397	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   234: iconst_1
    //   235: istore 4
    //   237: getstatic 440	com/tencent/mobileqq/theme/diy/ThemeBackground:sAIOBusinessFlag	Lcom/tencent/mobileqq/theme/diy/ThemeBackground$BusinessFlag;
    //   240: invokevirtual 480	com/tencent/mobileqq/theme/diy/ThemeBackground$BusinessFlag:setUseApng	()V
    //   243: iload 4
    //   245: ifne +196 -> 441
    //   248: aload 7
    //   250: instanceof 482
    //   253: ifeq +201 -> 454
    //   256: aload 7
    //   258: checkcast 482	android/graphics/drawable/BitmapDrawable
    //   261: invokevirtual 486	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   264: astore 6
    //   266: aload 7
    //   268: checkcast 482	android/graphics/drawable/BitmapDrawable
    //   271: invokevirtual 490	android/graphics/drawable/BitmapDrawable:getTileModeX	()Landroid/graphics/Shader$TileMode;
    //   274: astore_2
    //   275: aload 7
    //   277: checkcast 482	android/graphics/drawable/BitmapDrawable
    //   280: invokevirtual 493	android/graphics/drawable/BitmapDrawable:getGravity	()I
    //   283: istore 4
    //   285: aload 6
    //   287: ifnull +17 -> 304
    //   290: aload_2
    //   291: getstatic 428	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   294: if_acmpeq +10 -> 304
    //   297: iload 4
    //   299: bipush 48
    //   301: if_icmpeq +193 -> 494
    //   304: aload_1
    //   305: aload 7
    //   307: putfield 395	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   310: invokestatic 295	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +64 -> 377
    //   316: new 44	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 495
    //   326: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload 6
    //   331: invokevirtual 155	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   334: ldc_w 497
    //   337: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: astore 7
    //   342: aload_2
    //   343: getstatic 428	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   346: if_acmpne +423 -> 769
    //   349: iconst_1
    //   350: istore_3
    //   351: ldc 235
    //   353: iconst_2
    //   354: aload 7
    //   356: iload_3
    //   357: invokevirtual 238	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   360: ldc_w 499
    //   363: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: iload 4
    //   368: invokevirtual 243	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 84	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: aload 6
    //   379: ifnonnull +62 -> 441
    //   382: new 245	java/util/HashMap
    //   385: dup
    //   386: invokespecial 246	java/util/HashMap:<init>	()V
    //   389: astore_2
    //   390: aload_2
    //   391: ldc 248
    //   393: ldc_w 501
    //   396: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   399: pop
    //   400: aload_2
    //   401: ldc_w 256
    //   404: invokestatic 261	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   407: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   410: pop
    //   411: aload_0
    //   412: invokestatic 267	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   415: getstatic 273	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   418: invokevirtual 277	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   421: checkcast 279	com/tencent/mobileqq/app/QQAppInterface
    //   424: invokevirtual 282	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   427: ldc_w 284
    //   430: iconst_0
    //   431: lconst_1
    //   432: lconst_0
    //   433: aload_2
    //   434: ldc_w 286
    //   437: iconst_0
    //   438: invokevirtual 290	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   441: aload_1
    //   442: getfield 395	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   445: ifnull +297 -> 742
    //   448: aload_1
    //   449: iconst_1
    //   450: putfield 399	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_Boolean	Z
    //   453: return
    //   454: aload 7
    //   456: instanceof 503
    //   459: ifeq +297 -> 756
    //   462: aload 7
    //   464: checkcast 503	com/tencent/theme/SkinnableBitmapDrawable
    //   467: invokevirtual 504	com/tencent/theme/SkinnableBitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   470: astore 6
    //   472: aload 7
    //   474: checkcast 503	com/tencent/theme/SkinnableBitmapDrawable
    //   477: invokevirtual 505	com/tencent/theme/SkinnableBitmapDrawable:getTileModeX	()Landroid/graphics/Shader$TileMode;
    //   480: astore_2
    //   481: aload 7
    //   483: checkcast 503	com/tencent/theme/SkinnableBitmapDrawable
    //   486: invokevirtual 506	com/tencent/theme/SkinnableBitmapDrawable:getGravity	()I
    //   489: istore 4
    //   491: goto -206 -> 285
    //   494: new 367	com/tencent/mobileqq/drawable/ChatBackgroundDrawable
    //   497: dup
    //   498: aload_0
    //   499: invokevirtual 371	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   502: aload 6
    //   504: invokespecial 374	com/tencent/mobileqq/drawable/ChatBackgroundDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   507: astore_2
    //   508: aload_2
    //   509: iload 4
    //   511: invokevirtual 510	com/tencent/mobileqq/drawable/ChatBackgroundDrawable:setGravity	(I)V
    //   514: aload_1
    //   515: aload_2
    //   516: putfield 395	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   519: goto -142 -> 377
    //   522: astore_2
    //   523: ldc 235
    //   525: iconst_1
    //   526: new 44	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   533: ldc_w 512
    //   536: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   539: aload_2
    //   540: invokevirtual 513	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   543: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   552: aload_1
    //   553: aload_0
    //   554: invokevirtual 371	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   557: ldc_w 514
    //   560: invokevirtual 419	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   563: putfield 395	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   566: new 245	java/util/HashMap
    //   569: dup
    //   570: invokespecial 246	java/util/HashMap:<init>	()V
    //   573: astore_2
    //   574: aload_2
    //   575: ldc 248
    //   577: ldc_w 516
    //   580: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   583: pop
    //   584: aload_2
    //   585: ldc_w 256
    //   588: invokestatic 261	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   591: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   594: pop
    //   595: aload_0
    //   596: invokestatic 267	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   599: getstatic 273	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   602: invokevirtual 277	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   605: checkcast 279	com/tencent/mobileqq/app/QQAppInterface
    //   608: invokevirtual 282	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   611: ldc_w 284
    //   614: iconst_0
    //   615: lconst_1
    //   616: lconst_0
    //   617: aload_2
    //   618: ldc_w 286
    //   621: iconst_0
    //   622: invokevirtual 290	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   625: goto -184 -> 441
    //   628: astore_0
    //   629: goto -188 -> 441
    //   632: astore_2
    //   633: ldc 235
    //   635: iconst_1
    //   636: new 44	java/lang/StringBuilder
    //   639: dup
    //   640: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   643: ldc_w 518
    //   646: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: aload_2
    //   650: invokevirtual 519	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   653: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   662: aload_1
    //   663: aload_0
    //   664: invokevirtual 371	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   667: ldc_w 514
    //   670: invokevirtual 419	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   673: putfield 395	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   676: new 245	java/util/HashMap
    //   679: dup
    //   680: invokespecial 246	java/util/HashMap:<init>	()V
    //   683: astore_2
    //   684: aload_2
    //   685: ldc 248
    //   687: ldc_w 521
    //   690: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   693: pop
    //   694: aload_2
    //   695: ldc_w 256
    //   698: invokestatic 261	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   701: invokevirtual 254	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   704: pop
    //   705: aload_0
    //   706: invokestatic 267	com/tencent/mobileqq/statistics/StatisticCollector:getInstance	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   709: getstatic 273	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   712: invokevirtual 277	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   715: checkcast 279	com/tencent/mobileqq/app/QQAppInterface
    //   718: invokevirtual 282	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   721: ldc_w 284
    //   724: iconst_0
    //   725: lconst_1
    //   726: lconst_0
    //   727: aload_2
    //   728: ldc_w 286
    //   731: iconst_0
    //   732: invokevirtual 290	com/tencent/mobileqq/statistics/StatisticCollector:collectPerformance	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   735: goto -294 -> 441
    //   738: astore_0
    //   739: goto -298 -> 441
    //   742: ldc 235
    //   744: iconst_1
    //   745: ldc_w 523
    //   748: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   751: return
    //   752: astore_0
    //   753: goto -312 -> 441
    //   756: bipush 119
    //   758: istore 4
    //   760: aload 6
    //   762: astore_2
    //   763: aconst_null
    //   764: astore 6
    //   766: goto -481 -> 285
    //   769: iconst_0
    //   770: istore_3
    //   771: goto -420 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	774	0	paramContext	Context
    //   0	774	1	paramChatBackground	ChatBackground
    //   0	774	2	paramString	String
    //   0	774	3	paramBoolean	boolean
    //   76	683	4	i	int
    //   79	102	5	j	int
    //   3	762	6	localObject1	Object
    //   15	467	7	localObject2	Object
    //   105	117	8	localBundle	Bundle
    //   135	18	9	localDrawable	Drawable
    // Exception table:
    //   from	to	target	type
    //   0	17	522	java/lang/OutOfMemoryError
    //   22	31	522	java/lang/OutOfMemoryError
    //   32	75	522	java/lang/OutOfMemoryError
    //   81	87	522	java/lang/OutOfMemoryError
    //   87	137	522	java/lang/OutOfMemoryError
    //   142	162	522	java/lang/OutOfMemoryError
    //   165	171	522	java/lang/OutOfMemoryError
    //   184	234	522	java/lang/OutOfMemoryError
    //   237	243	522	java/lang/OutOfMemoryError
    //   248	285	522	java/lang/OutOfMemoryError
    //   290	297	522	java/lang/OutOfMemoryError
    //   304	349	522	java/lang/OutOfMemoryError
    //   351	377	522	java/lang/OutOfMemoryError
    //   382	441	522	java/lang/OutOfMemoryError
    //   454	491	522	java/lang/OutOfMemoryError
    //   494	519	522	java/lang/OutOfMemoryError
    //   566	625	628	java/lang/Exception
    //   0	17	632	java/lang/Exception
    //   22	31	632	java/lang/Exception
    //   32	75	632	java/lang/Exception
    //   81	87	632	java/lang/Exception
    //   87	137	632	java/lang/Exception
    //   142	162	632	java/lang/Exception
    //   165	171	632	java/lang/Exception
    //   184	234	632	java/lang/Exception
    //   237	243	632	java/lang/Exception
    //   248	285	632	java/lang/Exception
    //   290	297	632	java/lang/Exception
    //   304	349	632	java/lang/Exception
    //   351	377	632	java/lang/Exception
    //   454	491	632	java/lang/Exception
    //   494	519	632	java/lang/Exception
    //   676	735	738	java/lang/Exception
    //   382	441	752	java/lang/Exception
  }
  
  private static void a(Context paramContext, String paramString1, ChatBackground paramChatBackground, SharedPreferences paramSharedPreferences, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject2;
    Object localObject1;
    boolean bool1;
    if (GlobalImageCache.a.get(paramString2) != null)
    {
      localObject2 = (Bitmap)GlobalImageCache.a.get(paramString2);
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((Bitmap)localObject2).isRecycled()) {
          localObject1 = null;
        }
      }
      bool1 = false;
      if (localObject1 != null) {
        break label625;
      }
      localObject2 = new File(paramString2);
      if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
        break label363;
      }
      localObject2 = new File(QQSharpPUtil.a((File)localObject2));
      if (!((File)localObject2).exists()) {
        break label236;
      }
      localObject1 = a(paramContext, paramString2, (Bitmap)localObject1, (File)localObject2);
    }
    label146:
    label236:
    label625:
    for (;;)
    {
      label117:
      boolean bool2;
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder().append("getChatBackground, check bg=");
        if (localObject1 != null)
        {
          bool2 = true;
          QLog.d("ChatBackground", 2, bool2 + ", path=" + paramString2);
        }
      }
      else
      {
        if (localObject1 == null) {
          break label421;
        }
        GlobalImageCache.a.put(paramString2, localObject1);
        paramChatBackground.jdField_a_of_type_JavaLangString = paramString2;
        paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ChatBackgroundDrawable(paramContext.getResources(), (Bitmap)localObject1);
        paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = a(paramSharedPreferences, paramString2, (Bitmap)localObject1);
        paramChatBackground.jdField_a_of_type_Boolean = true;
      }
      for (;;)
      {
        for (;;)
        {
          return;
          localObject2 = null;
          break;
          QLog.e("ChatBackground", 1, "getChatBackground Error, file == null ; path = " + paramString2);
          try
          {
            localObject2 = new HashMap();
            ((HashMap)localObject2).put("param_FailCode", "dd_5");
            ((HashMap)localObject2).put("param_themeid", ThemeUtil.getCurrentThemeId());
            StatisticCollector localStatisticCollector = StatisticCollector.getInstance(paramContext);
            String str = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount();
            if (localObject1 != null) {}
            for (bool1 = true;; bool1 = false)
            {
              localStatisticCollector.collectPerformance(str, "ChatBackgroundDecoder", bool1, 1L, 0L, (HashMap)localObject2, "", false);
              bool1 = true;
              break;
            }
          }
          catch (Exception localException)
          {
            bool1 = true;
          }
        }
        long l1 = SystemClock.uptimeMillis();
        localObject1 = a(paramContext, paramString2);
        long l2 = SystemClock.uptimeMillis();
        QLog.e("ChatBackground_Time", 1, "Normal_getBitmap " + (l2 - l1));
        break label117;
        bool2 = false;
        break label146;
        paramString1 = ThemeBackground.getSharedPreferences(paramContext, paramString1, 0).getString("theme_bg_aio_path_url", null);
        if (!TextUtils.isEmpty(paramString1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatBackground", 2, "getChatBackground, downloading, url=" + paramString1 + ", path=" + paramString2);
          }
          paramSharedPreferences = new ResData();
          paramSharedPreferences.path = paramString2;
          paramSharedPreferences.url = paramString1;
          paramSharedPreferences.loadingType = 3;
          paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = DIYThemeUtils.getDIYDrawable(paramContext, paramSharedPreferences, 0, 0, -1, paramBoolean2);
          paramChatBackground.jdField_a_of_type_JavaLangString = paramString2;
          return;
        }
        QLog.e("ChatBackground", 2, "getChatBackground, bg == null, path=" + paramString2 + ", fileErr=" + bool1);
        paramChatBackground.jdField_a_of_type_JavaLangString = "null";
        try
        {
          paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131167058);
          a(paramContext, paramChatBackground, paramString2, paramBoolean1);
          if (!bool1)
          {
            paramChatBackground.jdField_a_of_type_Boolean = false;
            return;
          }
        }
        catch (RuntimeException paramString1)
        {
          for (;;)
          {
            QLog.d("ChatBackground_Time", 2, "getChatBackground error");
          }
        }
      }
    }
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    a(paramContext, paramString1, paramString2, paramString3, -1);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    a(paramContext, paramString1, paramString2, paramString3, 0, paramInt);
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackground", 1, new Throwable(), new Object[0]);
    }
    Object localObject = new StringBuilder().append("setChatBackground, friendUin=");
    if (!TextUtils.isEmpty(paramString2)) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ChatBackground", 1, bool + ", path=" + paramString3);
      paramContext = a(paramContext, paramString1, 4);
      paramString1 = paramContext.edit();
      if (paramString2 != null) {
        break;
      }
      paramString1.putString("chat_uniform_bg", paramString3);
      paramString1.putInt("_chat_bg_effect", paramInt1);
      paramString2 = paramContext.getAll();
      if (paramString2 == null) {
        break label413;
      }
      paramString2 = paramString2.keySet().iterator();
      while (paramString2.hasNext())
      {
        localObject = (String)paramString2.next();
        if (Pattern.compile("[0-9]*").matcher((CharSequence)localObject).matches())
        {
          String str = paramContext.getString((String)localObject, "null");
          bool = paramContext.getBoolean((String)localObject + "_is_c2c_set", false);
          if ((str == null) || (str.trim().length() == 0) || (str.equals("null")) || (str.equals("none")) || (!bool))
          {
            paramString1.putString((String)localObject, paramString3);
            paramString1.putInt((String)localObject + "_chat_bg_effect", paramInt1);
          }
        }
      }
    }
    paramString1.putString(paramString2, paramString3);
    paramString1.putInt(paramString2 + "_uinType", paramInt2);
    if (paramString3.equals("null"))
    {
      paramString1.putBoolean(paramString2 + "_is_c2c_set", false);
      paramString1.remove(paramString2 + "_chat_bg_effect");
    }
    for (;;)
    {
      label413:
      paramString1.commit();
      return;
      paramString1.putBoolean(paramString2 + "_is_c2c_set", true);
      paramString1.putInt(paramString2 + "_chat_bg_effect", paramInt1);
    }
  }
  
  private static boolean a(Context paramContext, String paramString1, int paramInt, ChatBackground paramChatBackground, SharedPreferences paramSharedPreferences, String paramString2)
  {
    boolean bool1;
    if ((paramInt & 0x1) != 0) {
      bool1 = true;
    }
    int i;
    label18:
    boolean bool2;
    for (;;)
    {
      if ((paramInt & 0x4) != 0)
      {
        i = 1;
        if ((paramInt & 0x2) == 0) {
          break label153;
        }
        bool2 = true;
        if ((paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (paramChatBackground.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramChatBackground.jdField_a_of_type_JavaLangString)) && (paramChatBackground.jdField_a_of_type_JavaLangString.equals(paramString2))) {
          break label330;
        }
      }
      for (;;)
      {
        try
        {
          if ((!TextUtils.isEmpty(paramString2)) && (!"null".equals(paramString2)) && (!"none".equals(paramString2))) {
            continue;
          }
          paramChatBackground.jdField_a_of_type_JavaLangString = "null";
        }
        catch (OutOfMemoryError paramString1)
        {
          label153:
          QLog.e("ChatBackground", 1, "getChatBackground OOM0 ; path = " + paramString2);
          paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130850446);
          try
          {
            paramString1 = new HashMap();
            paramString1.put("param_FailCode", "OOM0");
            paramString1.put("param_themeid", ThemeUtil.getCurrentThemeId());
            StatisticCollector.getInstance(paramContext).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString1, "", false);
          }
          catch (Exception paramContext) {}
          continue;
          if ((i == 0) || (!ChatBackgroundManager.a(new File(paramString2)))) {
            continue;
          }
          a(paramContext, paramChatBackground, paramSharedPreferences, paramString2);
          continue;
          a(paramContext, paramString1, paramChatBackground, paramSharedPreferences, paramString2, bool1, bool2);
          continue;
        }
        try
        {
          paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131167058);
          a(paramContext, paramChatBackground, paramString2, bool1);
          if (paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
            QLog.e("ChatBackground", 1, "getChatBackground error out.img == null");
          }
          return true;
          bool1 = false;
          break;
          i = 0;
          break label18;
          bool2 = false;
        }
        catch (RuntimeException paramString1)
        {
          QLog.d("ChatBackground_Time", 2, "getChatBackground error");
        }
      }
    }
    label330:
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackground", 2, "getChatBackground, bg not change, path=" + paramString2);
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, ChatBackground paramChatBackground)
  {
    if (paramChatBackground == null)
    {
      QLog.e("ChatBackground", 1, "getChatBackground out=null");
      return false;
    }
    SharedPreferences localSharedPreferences = a(paramContext, paramString1, 0);
    if (!TextUtils.isEmpty(paramString2)) {}
    for (String str = localSharedPreferences.getString(paramString2, null);; str = null)
    {
      if (str != null)
      {
        paramString2 = str;
        if (!str.equals("null")) {}
      }
      else
      {
        str = localSharedPreferences.getString("chat_uniform_bg", null);
        paramString2 = str;
        if (str == null) {
          paramString2 = "null";
        }
      }
      paramString2 = ThemeDiyStyleLogic.getDiyVFSPath(paramString2);
      if (QLog.isColorLevel()) {
        QLog.d("ChatBackground_Time", 2, "getChatBackground, out.isDecodeSuccess=" + paramChatBackground.jdField_a_of_type_Boolean + ", path=" + paramString2 + ", out.path=" + paramChatBackground.jdField_a_of_type_JavaLangString);
      }
      return a(paramContext, paramString1, paramInt, paramChatBackground, localSharedPreferences, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatBackground
 * JD-Core Version:    0.7.0.1
 */