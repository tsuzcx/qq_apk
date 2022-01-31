package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.drawable.ChatBackgroundDrawable;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.diy.DIYThemeUtils;
import com.tencent.mobileqq.theme.diy.ResData;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import com.tencent.sharpP.SharpPUtil;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
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
    //   0: new 93	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 94	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore 6
    //   9: ldc 96
    //   11: getstatic 101	android/os/Build:BRAND	Ljava/lang/String;
    //   14: invokevirtual 106	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   17: ifeq +458 -> 475
    //   20: aload 6
    //   22: getstatic 112	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   25: putfield 115	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   28: aload 6
    //   30: iconst_1
    //   31: putfield 118	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   34: aload 6
    //   36: iconst_1
    //   37: putfield 122	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   40: aload 6
    //   42: iconst_0
    //   43: putfield 118	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   46: aload_1
    //   47: aload 6
    //   49: invokestatic 127	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   52: astore 5
    //   54: aload 5
    //   56: getfield 132	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   59: astore 4
    //   61: aload 4
    //   63: ifnull +11 -> 74
    //   66: aload 5
    //   68: getfield 134	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   71: ifeq +420 -> 491
    //   74: new 44	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   81: ldc 136
    //   83: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_1
    //   87: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: ldc 138
    //   92: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: astore 7
    //   97: aload 4
    //   99: ifnonnull +387 -> 486
    //   102: iconst_1
    //   103: istore_3
    //   104: ldc 140
    //   106: iconst_1
    //   107: aload 7
    //   109: iload_3
    //   110: invokevirtual 143	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   113: ldc 145
    //   115: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload 6
    //   120: getfield 122	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   123: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   126: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   129: invokestatic 154	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   132: new 156	java/util/HashMap
    //   135: dup
    //   136: invokespecial 157	java/util/HashMap:<init>	()V
    //   139: astore 7
    //   141: aload 7
    //   143: ldc 159
    //   145: new 44	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   152: ldc 161
    //   154: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload 5
    //   159: getfield 134	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   162: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   165: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokevirtual 165	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   171: pop
    //   172: aload 7
    //   174: ldc 167
    //   176: invokestatic 172	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   179: invokevirtual 165	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   182: pop
    //   183: aload_0
    //   184: invokestatic 177	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   187: astore 8
    //   189: getstatic 183	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   192: invokevirtual 187	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   195: checkcast 189	com/tencent/mobileqq/app/QQAppInterface
    //   198: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   201: astore 9
    //   203: aload 4
    //   205: ifnull +342 -> 547
    //   208: iconst_1
    //   209: istore_3
    //   210: aload 8
    //   212: aload 9
    //   214: ldc 194
    //   216: iload_3
    //   217: lconst_1
    //   218: lconst_0
    //   219: aload 7
    //   221: ldc 196
    //   223: iconst_0
    //   224: invokevirtual 199	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   227: aload 5
    //   229: getfield 134	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   232: iconst_1
    //   233: if_icmpne +345 -> 578
    //   236: ldc 140
    //   238: iconst_1
    //   239: new 44	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   246: ldc 201
    //   248: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: aload_1
    //   252: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   258: invokestatic 154	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: aload 6
    //   263: getfield 122	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   266: iconst_2
    //   267: imul
    //   268: istore_2
    //   269: iload_2
    //   270: bipush 32
    //   272: if_icmpgt +111 -> 383
    //   275: aload 6
    //   277: iload_2
    //   278: putfield 122	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   281: aload_1
    //   282: aload 6
    //   284: invokestatic 127	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   287: astore 5
    //   289: aload 5
    //   291: getfield 132	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_AndroidGraphicsBitmap	Landroid/graphics/Bitmap;
    //   294: astore 4
    //   296: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifne +8 -> 307
    //   302: aload 4
    //   304: ifnonnull +70 -> 374
    //   307: new 44	java/lang/StringBuilder
    //   310: dup
    //   311: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   314: ldc 206
    //   316: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: aload 5
    //   321: getfield 134	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   324: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   327: ldc 208
    //   329: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: aload_1
    //   333: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: ldc 210
    //   338: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: iload_2
    //   342: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   345: ldc 138
    //   347: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: astore 7
    //   352: aload 4
    //   354: ifnull +198 -> 552
    //   357: iconst_1
    //   358: istore_3
    //   359: ldc 140
    //   361: iconst_2
    //   362: aload 7
    //   364: iload_3
    //   365: invokevirtual 143	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   368: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: aload 5
    //   376: getfield 134	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   379: iconst_1
    //   380: if_icmpeq +177 -> 557
    //   383: new 156	java/util/HashMap
    //   386: dup
    //   387: invokespecial 157	java/util/HashMap:<init>	()V
    //   390: astore_1
    //   391: aload_1
    //   392: ldc 159
    //   394: new 44	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   401: ldc 215
    //   403: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: aload 5
    //   408: getfield 134	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:jdField_a_of_type_Int	I
    //   411: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   414: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   417: invokevirtual 165	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   420: pop
    //   421: aload_1
    //   422: ldc 167
    //   424: invokestatic 172	com/tencent/mobileqq/theme/ThemeUtil:getCurrentThemeId	()Ljava/lang/String;
    //   427: invokevirtual 165	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   430: pop
    //   431: aload_0
    //   432: invokestatic 177	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   435: astore_0
    //   436: getstatic 183	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   439: invokevirtual 187	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   442: checkcast 189	com/tencent/mobileqq/app/QQAppInterface
    //   445: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   448: astore 5
    //   450: aload 4
    //   452: ifnull +112 -> 564
    //   455: iconst_1
    //   456: istore_3
    //   457: aload_0
    //   458: aload 5
    //   460: ldc 194
    //   462: iload_3
    //   463: lconst_1
    //   464: lconst_0
    //   465: aload_1
    //   466: ldc 196
    //   468: iconst_0
    //   469: invokevirtual 199	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   472: aload 4
    //   474: areturn
    //   475: aload 6
    //   477: getstatic 218	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   480: putfield 115	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   483: goto -455 -> 28
    //   486: iconst_0
    //   487: istore_3
    //   488: goto -384 -> 104
    //   491: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   494: ifeq -362 -> 132
    //   497: ldc 140
    //   499: iconst_2
    //   500: new 44	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   507: ldc 220
    //   509: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload_1
    //   513: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc 208
    //   518: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: aload_1
    //   522: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: ldc 145
    //   527: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload 6
    //   532: getfield 122	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   535: invokevirtual 148	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   538: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: goto -412 -> 132
    //   547: iconst_0
    //   548: istore_3
    //   549: goto -339 -> 210
    //   552: iconst_0
    //   553: istore_3
    //   554: goto -195 -> 359
    //   557: iload_2
    //   558: iconst_2
    //   559: imul
    //   560: istore_2
    //   561: goto -292 -> 269
    //   564: iconst_0
    //   565: istore_3
    //   566: goto -109 -> 457
    //   569: astore_0
    //   570: aload 4
    //   572: areturn
    //   573: astore 7
    //   575: goto -348 -> 227
    //   578: aload 4
    //   580: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	581	0	paramContext	Context
    //   0	581	1	paramString	String
    //   268	293	2	i	int
    //   103	463	3	bool	boolean
    //   59	520	4	localBitmap	Bitmap
    //   52	407	5	localObject1	Object
    //   7	524	6	localOptions	android.graphics.BitmapFactory.Options
    //   95	268	7	localObject2	Object
    //   573	1	7	localException	Exception
    //   187	24	8	localStatisticCollector	StatisticCollector
    //   201	12	9	str	String
    // Exception table:
    //   from	to	target	type
    //   383	450	569	java/lang/Exception
    //   457	472	569	java/lang/Exception
    //   132	203	573	java/lang/Exception
    //   210	227	573	java/lang/Exception
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("chat_background_path_" + paramString1, 0);
    paramString1 = localSharedPreferences.getString(paramString2, null);
    paramContext = paramString1;
    if (paramString1 == null)
    {
      paramString1 = localSharedPreferences.getString("chat_uniform_bg", null);
      paramContext = paramString1;
      if (paramString1 == null) {
        paramContext = "null";
      }
    }
    return paramContext;
  }
  
  static void a(Context paramContext, ChatBackground paramChatBackground, String paramString, boolean paramBoolean)
  {
    Object localObject1 = null;
    Object localObject2;
    label165:
    int i;
    try
    {
      localObject2 = Shader.TileMode.REPEAT;
      localDrawable = paramContext.getResources().getDrawable(2130838348);
      if (localDrawable == null)
      {
        QLog.e("ChatBackground", 1, "setAIOBackgroundBmp Drawable d == null.");
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ChatBackground", 2, "setAIOBackgroundBmp, Drawable d=" + localDrawable + ",path=" + paramString);
      }
      if (!ThemeUtil.isNowThemeIsAnimate()) {
        break label165;
      }
      paramString = ThemeUtil.getAnimatePathByTag(3);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("key_use_rect", true);
      ((Bundle)localObject1).putBoolean("key_play_apng", paramBoolean);
      paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = VasApngUtil.a(BaseApplicationImpl.sApplication.getRuntime(), paramString, "-chatBg-", localDrawable, new int[] { 0 }, "-chatBg-", (Bundle)localObject1);
      paramChatBackground.jdField_a_of_type_JavaLangString = paramString;
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        Drawable localDrawable;
        QLog.e("ChatBackground", 1, "setAIOBackgroundBmp OOM1:" + paramString.getMessage());
        paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845899);
        try
        {
          paramString = new HashMap();
          paramString.put("param_FailCode", "OOM1");
          paramString.put("param_themeid", ThemeUtil.getCurrentThemeId());
          StatisticCollector.a(paramContext).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString, "", false);
        }
        catch (Exception paramContext) {}
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        label202:
        QLog.e("ChatBackground", 1, "setAIOBackgroundBmp OOM2 or Err:" + paramString.getMessage());
        paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845899);
        try
        {
          paramString = new HashMap();
          paramString.put("param_FailCode", "EE");
          paramString.put("param_themeid", ThemeUtil.getCurrentThemeId());
          StatisticCollector.a(paramContext).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString, "", false);
        }
        catch (Exception paramContext) {}
      }
      QLog.e("ChatBackground", 1, "setAIOBackgroundBmp out.img == null");
      return;
    }
    if (paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      paramChatBackground.jdField_a_of_type_Boolean = true;
      return;
      if ((localDrawable instanceof BitmapDrawable))
      {
        localObject1 = ((BitmapDrawable)localDrawable).getBitmap();
        paramString = ((BitmapDrawable)localDrawable).getTileModeX();
        i = ((BitmapDrawable)localDrawable).getGravity();
        if ((localObject1 != null) && (paramString != Shader.TileMode.REPEAT) && (i == 48)) {
          break label402;
        }
        paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localDrawable;
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder().append("setAIOBackgroundBmp, bgBitmap=").append(localObject1).append(", type=");
          if (paramString != Shader.TileMode.REPEAT) {
            break label664;
          }
        }
      }
    }
    label402:
    label664:
    for (paramBoolean = true;; paramBoolean = false)
    {
      QLog.d("ChatBackground", 2, paramBoolean + ", gravity=" + i);
      for (;;)
      {
        for (;;)
        {
          if (localObject1 != null) {
            break label428;
          }
          try
          {
            paramString = new HashMap();
            paramString.put("param_FailCode", "dNull");
            paramString.put("param_themeid", ThemeUtil.getCurrentThemeId());
            StatisticCollector.a(paramContext).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString, "", false);
          }
          catch (Exception paramContext) {}
        }
        break;
        if (!(localDrawable instanceof SkinnableBitmapDrawable)) {
          break label654;
        }
        localObject1 = ((SkinnableBitmapDrawable)localDrawable).getBitmap();
        paramString = ((SkinnableBitmapDrawable)localDrawable).getTileModeX();
        i = ((SkinnableBitmapDrawable)localDrawable).getGravity();
        break label202;
        paramString = new ChatBackgroundDrawable(paramContext.getResources(), (Bitmap)localObject1);
        paramString.setGravity(i);
        paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramString;
      }
      label428:
      break;
      paramString = (String)localObject2;
      i = 119;
      break label202;
    }
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("setChatBackground, friendUin=");
      if (TextUtils.isEmpty(paramString2)) {
        break label259;
      }
    }
    label259:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("ChatBackground", 2, bool + ", path=" + paramString3);
      paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString1, 0);
      paramString1 = paramContext.edit();
      if (paramString2 != null) {
        break;
      }
      paramString1.putString("chat_uniform_bg", paramString3);
      paramString2 = paramContext.getAll();
      if (paramString2 == null) {
        break label311;
      }
      paramString2 = paramString2.keySet().iterator();
      while (paramString2.hasNext())
      {
        localObject = (String)paramString2.next();
        if (Pattern.compile("[0-9]*").matcher((CharSequence)localObject).matches())
        {
          String str = paramContext.getString((String)localObject, "null");
          bool = paramContext.getBoolean((String)localObject + "_is_c2c_set", false);
          if ((str == null) || (str.trim().length() == 0) || (str.equals("null")) || (str.equals("none")) || (!bool)) {
            paramString1.putString((String)localObject, paramString3);
          }
        }
      }
    }
    paramString1.putString(paramString2, paramString3);
    if (paramString3.equals("null")) {
      paramString1.putBoolean(paramString2 + "_is_c2c_set", false);
    }
    for (;;)
    {
      label311:
      paramString1.commit();
      return;
      paramString1.putBoolean(paramString2 + "_is_c2c_set", true);
    }
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, ChatBackground paramChatBackground)
  {
    if (paramChatBackground == null)
    {
      QLog.e("ChatBackground", 1, "getChatBackground out=null");
      return false;
    }
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("chat_background_path_" + paramString1, 0);
    paramString2 = localSharedPreferences.getString(paramString2, null);
    String str1 = paramString2;
    if (paramString2 == null)
    {
      paramString2 = localSharedPreferences.getString("chat_uniform_bg", null);
      str1 = paramString2;
      if (paramString2 == null) {
        str1 = "null";
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackground_Time", 2, "getChatBackground, out.isDecodeSuccess=" + paramChatBackground.jdField_a_of_type_Boolean + ", path=" + str1 + ", out.path=" + paramChatBackground.jdField_a_of_type_JavaLangString);
    }
    boolean bool1;
    int i;
    label158:
    boolean bool2;
    if ((paramInt & 0x1) != 0)
    {
      bool1 = true;
      if ((paramInt & 0x4) == 0) {
        break label294;
      }
      i = 1;
      if ((paramInt & 0x2) == 0) {
        break label300;
      }
      bool2 = true;
      label168:
      if ((paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (paramChatBackground.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramChatBackground.jdField_a_of_type_JavaLangString)) && (paramChatBackground.jdField_a_of_type_JavaLangString.equals(str1))) {
        break label1591;
      }
    }
    label294:
    label300:
    long l1;
    label354:
    long l2;
    Object localObject1;
    for (;;)
    {
      try
      {
        if ((!TextUtils.isEmpty(str1)) && (!"null".equals(str1)) && (!"none".equals(str1))) {
          continue;
        }
        paramChatBackground.jdField_a_of_type_JavaLangString = "null";
        paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131494237);
        a(paramContext, paramChatBackground, str1, bool1);
      }
      catch (OutOfMemoryError paramString1)
      {
        long l3;
        QLog.e("ChatBackground", 1, "getChatBackground OOM0 ; path = " + str1);
        paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845899);
        try
        {
          paramString1 = new HashMap();
          paramString1.put("param_FailCode", "OOM0");
          paramString1.put("param_themeid", ThemeUtil.getCurrentThemeId());
          StatisticCollector.a(paramContext).a(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString1, "", false);
        }
        catch (Exception paramContext) {}
        continue;
        paramString2 = paramContext.getResources().getDrawable(2130838348);
        continue;
      }
      if (paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        QLog.e("ChatBackground", 1, "getChatBackground error out.img == null");
      }
      return true;
      bool1 = false;
      break;
      i = 0;
      break label158;
      bool2 = false;
      break label168;
      if ((i == 0) || (!ChatBackgroundManager.a(new File(str1)))) {
        break label677;
      }
      l1 = SystemClock.uptimeMillis();
      paramString1 = (Bitmap)BaseApplicationImpl.sImageCache.get(str1);
      if (paramString1 != null) {
        break label1629;
      }
      paramString1 = a(paramContext, str1);
      l2 = SystemClock.uptimeMillis();
      if (paramString1 == null) {
        continue;
      }
      BaseApplicationImpl.sImageCache.put(str1, paramString1);
      paramString2 = new ChatBackgroundDrawable(paramContext.getResources(), paramString1);
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("key_use_rect", true);
      ((Bundle)localObject1).putBoolean("key_double_bitmap", true);
      paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = VasApngUtil.a(BaseApplicationImpl.sApplication.getRuntime(), str1, "-chatBg-", paramString2, new int[] { 0 }, "-chatBg-", (Bundle)localObject1);
      if ((paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) && (paramString1 != null)) {
        paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ChatBackgroundDrawable(paramContext.getResources(), paramString1);
      }
      paramChatBackground.jdField_a_of_type_JavaLangString = str1;
      paramChatBackground.jdField_a_of_type_Boolean = true;
      if (paramString1 != null) {
        paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = a(localSharedPreferences, str1, paramString1);
      }
      l3 = SystemClock.uptimeMillis();
      QLog.d("ChatBackground_Time", 1, "APNG_getBitmap " + (l2 - l1) + " APNG_init " + (l3 - l2));
    }
    label677:
    label701:
    boolean bool3;
    if (BaseApplicationImpl.sImageCache.get(str1) != null)
    {
      localObject1 = (Bitmap)BaseApplicationImpl.sImageCache.get(str1);
      paramString2 = (String)localObject1;
      if (localObject1 != null)
      {
        paramString2 = (String)localObject1;
        if (((Bitmap)localObject1).isRecycled()) {
          paramString2 = null;
        }
      }
      bool3 = false;
      paramBoolean = bool3;
      localObject1 = paramString2;
      if (paramString2 == null)
      {
        localObject1 = new File(str1);
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          break label1632;
        }
        if (((File)localObject1).isFile()) {
          break label1321;
        }
        break label1632;
        label770:
        if ((localObject1 == null) || (!((File)localObject1).exists())) {
          break label1203;
        }
        paramBoolean = QQSharpPUtil.a(paramContext);
        if ((QLog.isColorLevel()) || (!paramBoolean)) {
          QLog.d("ChatBackground", 2, "getChatBackground, sharpP exists, path=" + str1 + ", sharpPAv=" + paramBoolean);
        }
        if (!paramBoolean) {
          break label1626;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = SharpPUtil.decodeSharpPByFilePath(((File)localObject1).getAbsolutePath());
        if (!QLog.isColorLevel())
        {
          paramString2 = (String)localObject1;
          if (localObject1 != null) {
            break label1643;
          }
        }
        paramString2 = new StringBuilder().append("getChatBackground, sharpP decode result=");
        if (localObject1 != null)
        {
          paramBoolean = true;
          QLog.d("ChatBackground", 2, paramBoolean + ", path=" + str1);
          paramString2 = (String)localObject1;
          break label1643;
          label914:
          if (QLog.isColorLevel())
          {
            paramString2 = new StringBuilder().append("getChatBackground, check bg=");
            if (localObject1 == null) {
              break label1667;
            }
            bool3 = true;
            QLog.d("ChatBackground", 2, bool3 + ", path=" + str1);
          }
          if (localObject1 == null) {
            break label1376;
          }
          BaseApplicationImpl.sImageCache.put(str1, localObject1);
          paramChatBackground.jdField_a_of_type_JavaLangString = str1;
          paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ChatBackgroundDrawable(paramContext.getResources(), (Bitmap)localObject1);
          paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = a(localSharedPreferences, str1, (Bitmap)localObject1);
          paramChatBackground.jdField_a_of_type_Boolean = true;
          break;
          label1031:
          localObject1 = new File(QQSharpPUtil.a((File)localObject1));
          break label770;
        }
        paramBoolean = false;
        continue;
        label1116:
        if (paramString2 != null) {
          break label1201;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        QLog.e("ChatBackground", 1, "sharpP decodeSharpPByFilePath UnsatisfiedLinkError, msg:" + localUnsatisfiedLinkError.getMessage());
        if ((!QLog.isColorLevel()) && (paramString2 != null)) {
          break label1626;
        }
        localObject2 = new StringBuilder().append("getChatBackground, sharpP decode result=");
        if (paramString2 == null) {
          break label1657;
        }
        paramBoolean = true;
        QLog.d("ChatBackground", 2, paramBoolean + ", path=" + str1);
      }
      finally
      {
        if (QLog.isColorLevel()) {}
      }
      Object localObject2 = new StringBuilder().append("getChatBackground, sharpP decode result=");
      if (paramString2 != null) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        QLog.d("ChatBackground", 2, paramBoolean + ", path=" + str1);
        label1201:
        throw paramString1;
        label1203:
        QLog.e("ChatBackground", 1, "getChatBackground Error, file == null ; path = " + str1);
        try
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("param_FailCode", "dd_5");
          ((HashMap)localObject2).put("param_themeid", ThemeUtil.getCurrentThemeId());
          StatisticCollector localStatisticCollector = StatisticCollector.a(paramContext);
          String str2 = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount();
          if (paramString2 != null) {}
          for (paramBoolean = true;; paramBoolean = false)
          {
            localStatisticCollector.a(str2, "ChatBackgroundDecoder", paramBoolean, 1L, 0L, (HashMap)localObject2, "", false);
            paramBoolean = true;
            break;
          }
          l1 = SystemClock.uptimeMillis();
        }
        catch (Exception localException)
        {
          paramBoolean = true;
        }
        label1321:
        Object localObject3 = a(paramContext, str1);
        l2 = SystemClock.uptimeMillis();
        QLog.e("ChatBackground_Time", 1, "Normal_getBitmap " + (l2 - l1));
        paramBoolean = bool3;
        break label914;
        label1376:
        paramString1 = paramContext.getSharedPreferences("theme_background_path_" + paramString1, 0).getString("theme_bg_aio_path_url", null);
        if (!TextUtils.isEmpty(paramString1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChatBackground", 2, "getChatBackground, downloading, url=" + paramString1 + ", path=" + str1);
          }
          paramString2 = new ResData();
          paramString2.path = str1;
          paramString2.url = paramString1;
          paramString2.loadingType = 3;
          paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = DIYThemeUtils.getDIYDrawable(paramContext, paramString2, 0, 0, -1, bool2);
          paramChatBackground.jdField_a_of_type_JavaLangString = str1;
          break;
        }
        QLog.e("ChatBackground", 2, "getChatBackground, bg == null, path=" + str1 + ", fileErr=" + paramBoolean);
        paramChatBackground.jdField_a_of_type_JavaLangString = "null";
        paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131494237);
        a(paramContext, paramChatBackground, str1, bool1);
        if (paramBoolean) {
          break;
        }
        paramChatBackground.jdField_a_of_type_Boolean = false;
        break;
        label1591:
        if (QLog.isColorLevel()) {
          QLog.d("ChatBackground", 2, "getChatBackground, bg not change, path=" + str1);
        }
        return false;
        label1626:
        break label1643;
        label1629:
        break label354;
        label1632:
        if (localObject3 != null) {
          break label1031;
        }
        localObject3 = null;
        break label770;
        label1643:
        paramBoolean = false;
        localObject3 = paramString2;
        break label914;
        localObject3 = null;
        break label701;
        label1657:
        paramBoolean = false;
        break label1116;
      }
      label1667:
      bool3 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatBackground
 * JD-Core Version:    0.7.0.1
 */