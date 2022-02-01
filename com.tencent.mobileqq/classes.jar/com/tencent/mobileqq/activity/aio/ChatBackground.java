package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.BitmapManager.BitmapDecodeResult;
import com.tencent.mobileqq.vas.VasApngUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.theme.chatbg.ChatBackgroundDrawable;
import com.tencent.mobileqq.vas.theme.diy.DIYThemeUtils;
import com.tencent.mobileqq.vas.theme.diy.ResData;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground;
import com.tencent.mobileqq.vas.theme.diy.ThemeBackground.BusinessFlag;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic;
import com.tencent.mobileqq.vas.util.ChatBackgroundUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqsharpP.QQSharpPUtil;
import com.tencent.theme.SkinnableBitmapDrawable;
import java.io.File;
import java.util.HashMap;

public class ChatBackground
{
  public String a;
  public ColorStateList b;
  public Drawable c;
  public boolean d;
  
  public static int a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      int i = paramBitmap.getWidth();
      int n = paramBitmap.getHeight();
      int[] arrayOfInt = new int[n];
      paramBitmap.getPixels(arrayOfInt, 0, 1, i / 2, 0, 1, n);
      i = 0;
      int m = 0;
      int k = 0;
      int j = 0;
      while (i < n)
      {
        int i1 = arrayOfInt[i];
        m += Color.red(i1);
        k += Color.green(i1);
        j += Color.blue(i1);
        i += 1;
      }
      if ((m + k + j) / n / 3 > 220) {
        return -10395552;
      }
      return -1;
    }
    return -10395552;
  }
  
  private static ColorStateList a(SharedPreferences paramSharedPreferences, String paramString, Bitmap paramBitmap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("chat_backgournd_nickname_color.");
    localStringBuilder.append(paramString);
    paramString = localStringBuilder.toString();
    if (paramSharedPreferences.contains(paramString)) {
      return ColorStateList.valueOf(paramSharedPreferences.getInt(paramString, -10395552));
    }
    int i = a(paramBitmap);
    paramSharedPreferences.edit().putInt(paramString, i).commit();
    return ColorStateList.valueOf(i);
  }
  
  @Nullable
  private static Bitmap a(Context paramContext, String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    if ("vivo".equalsIgnoreCase(Build.BRAND)) {
      localOptions.inPreferredConfig = Bitmap.Config.ARGB_8888;
    } else {
      localOptions.inPreferredConfig = Bitmap.Config.RGB_565;
    }
    localOptions.inJustDecodeBounds = true;
    localOptions.inSampleSize = 1;
    localOptions.inJustDecodeBounds = false;
    Object localObject2 = BitmapManager.b(paramString, localOptions);
    Bitmap localBitmap = ((BitmapManager.BitmapDecodeResult)localObject2).a;
    boolean bool;
    if ((localBitmap != null) && (((BitmapManager.BitmapDecodeResult)localObject2).b == 0))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getChatBackground, decodeFileForResult ok, path=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", path=");
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(", inSampleSize");
        ((StringBuilder)localObject1).append(localOptions.inSampleSize);
        QLog.d("ChatBackground", 2, ((StringBuilder)localObject1).toString());
      }
    }
    else
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getChatBackground Err ; path = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append(", bg=");
      if (localBitmap == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject1).append(bool);
      ((StringBuilder)localObject1).append(", inSampleSize");
      ((StringBuilder)localObject1).append(localOptions.inSampleSize);
      QLog.e("ChatBackground", 1, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = new HashMap();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("d_");
      ((StringBuilder)localObject3).append(((BitmapManager.BitmapDecodeResult)localObject2).b);
      ((HashMap)localObject1).put("param_FailCode", ((StringBuilder)localObject3).toString());
      ((HashMap)localObject1).put("param_themeid", ThemeUtil.getCurrentThemeId());
      localObject3 = StatisticCollector.getInstance(paramContext);
      String str = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount();
      if (localBitmap == null) {
        break label686;
      }
      bool = true;
      ((StatisticCollector)localObject3).collectPerformance(str, "ChatBackgroundDecoder", bool, 1L, 0L, (HashMap)localObject1, "", false);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        try
        {
          int i;
          paramString = new HashMap();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("dd_");
          ((StringBuilder)localObject2).append(((BitmapManager.BitmapDecodeResult)localObject1).b);
          paramString.put("param_FailCode", ((StringBuilder)localObject2).toString());
          paramString.put("param_themeid", ThemeUtil.getCurrentThemeId());
          paramContext = StatisticCollector.getInstance(paramContext);
          localObject1 = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount();
          if (localBitmap == null) {
            break;
          }
          bool = true;
          paramContext.collectPerformance((String)localObject1, "ChatBackgroundDecoder", bool, 1L, 0L, paramString, "", false);
          localObject1 = localBitmap;
          return localObject1;
        }
        catch (Exception paramContext)
        {
          return localBitmap;
        }
        localException = localException;
      }
    }
    Object localObject1 = localBitmap;
    if (((BitmapManager.BitmapDecodeResult)localObject2).b == 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getChatBackground OOM ; path = ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.e("ChatBackground", 1, ((StringBuilder)localObject1).toString());
      i = localOptions.inSampleSize * 2;
      localObject1 = localObject2;
      while (i <= 32)
      {
        localOptions.inSampleSize = i;
        localObject1 = BitmapManager.b(paramString, localOptions);
        localBitmap = ((BitmapManager.BitmapDecodeResult)localObject1).a;
        if ((QLog.isColorLevel()) || (localBitmap == null))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getChatBackground, miniDecode, result=");
          ((StringBuilder)localObject2).append(((BitmapManager.BitmapDecodeResult)localObject1).b);
          ((StringBuilder)localObject2).append(", path=");
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(",simpleSize=");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(", bg=");
          if (localBitmap != null) {
            bool = true;
          } else {
            bool = false;
          }
          ((StringBuilder)localObject2).append(bool);
          QLog.d("ChatBackground", 2, ((StringBuilder)localObject2).toString());
        }
        if (((BitmapManager.BitmapDecodeResult)localObject1).b != 1) {
          break;
        }
        i *= 2;
      }
    }
    for (;;)
    {
      label686:
      bool = false;
      break;
      bool = false;
    }
  }
  
  /* Error */
  private static Bitmap a(Context paramContext, String paramString, Bitmap paramBitmap, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 233	com/tencent/qqsharpP/QQSharpPUtil:a	(Landroid/content/Context;)Z
    //   4: istore 4
    //   6: invokestatic 145	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifne +8 -> 17
    //   12: iload 4
    //   14: ifne +48 -> 62
    //   17: new 47	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   24: astore_0
    //   25: aload_0
    //   26: ldc 235
    //   28: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_0
    //   33: aload_1
    //   34: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_0
    //   39: ldc 237
    //   41: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_0
    //   46: iload 4
    //   48: invokevirtual 166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: ldc 156
    //   54: iconst_2
    //   55: aload_0
    //   56: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: iload 4
    //   64: ifeq +214 -> 278
    //   67: iconst_0
    //   68: istore 5
    //   70: iconst_0
    //   71: istore 4
    //   73: aload_3
    //   74: invokevirtual 242	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   77: invokestatic 248	com/tencent/sharpP/SharpPUtil:decodeSharpPByFilePath	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   80: astore 6
    //   82: new 47	java/lang/StringBuilder
    //   85: dup
    //   86: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   89: astore_2
    //   90: aload_2
    //   91: ldc 250
    //   93: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 6
    //   99: astore_3
    //   100: aload_2
    //   101: astore_0
    //   102: aload 6
    //   104: ifnull +13 -> 117
    //   107: aload_2
    //   108: astore_0
    //   109: aload 6
    //   111: astore_2
    //   112: iconst_1
    //   113: istore 4
    //   115: aload_2
    //   116: astore_3
    //   117: aload_0
    //   118: iload 4
    //   120: invokevirtual 166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_0
    //   125: ldc 149
    //   127: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_0
    //   132: aload_1
    //   133: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: ldc 156
    //   139: iconst_1
    //   140: aload_0
    //   141: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aload_3
    //   148: areturn
    //   149: astore_0
    //   150: goto +70 -> 220
    //   153: astore_0
    //   154: new 47	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   161: astore_3
    //   162: aload_3
    //   163: ldc 252
    //   165: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: aload_3
    //   170: aload_0
    //   171: invokevirtual 255	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   174: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: ldc 156
    //   180: iconst_1
    //   181: aload_3
    //   182: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 169	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: new 47	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   195: astore 6
    //   197: aload 6
    //   199: ldc 250
    //   201: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_2
    //   206: astore_3
    //   207: aload 6
    //   209: astore_0
    //   210: aload_2
    //   211: ifnull -94 -> 117
    //   214: aload 6
    //   216: astore_0
    //   217: goto -105 -> 112
    //   220: new 47	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   227: astore_3
    //   228: aload_3
    //   229: ldc 250
    //   231: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: iload 5
    //   237: istore 4
    //   239: aload_2
    //   240: ifnull +6 -> 246
    //   243: iconst_1
    //   244: istore 4
    //   246: aload_3
    //   247: iload 4
    //   249: invokevirtual 166	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   252: pop
    //   253: aload_3
    //   254: ldc 149
    //   256: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload_3
    //   261: aload_1
    //   262: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: ldc 156
    //   268: iconst_1
    //   269: aload_3
    //   270: invokevirtual 58	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 159	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload_0
    //   277: athrow
    //   278: aload_2
    //   279: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	280	0	paramContext	Context
    //   0	280	1	paramString	String
    //   0	280	2	paramBitmap	Bitmap
    //   0	280	3	paramFile	File
    //   4	244	4	bool1	boolean
    //   68	168	5	bool2	boolean
    //   80	135	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   73	82	149	finally
    //   154	188	149	finally
    //   73	82	153	java/lang/UnsatisfiedLinkError
  }
  
  private static void a(Context paramContext, ChatBackground paramChatBackground, SharedPreferences paramSharedPreferences, String paramString)
  {
    long l1 = SystemClock.uptimeMillis();
    Bitmap localBitmap = (Bitmap)GlobalImageCache.a.get(paramString);
    if (localBitmap == null) {
      localBitmap = a(paramContext, paramString);
    }
    long l2 = SystemClock.uptimeMillis();
    Object localObject;
    if (localBitmap != null)
    {
      GlobalImageCache.a.put(paramString, localBitmap);
      localObject = new ChatBackgroundDrawable(paramContext.getResources(), localBitmap);
    }
    else
    {
      localObject = paramContext.getResources().getDrawable(2130839229);
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_use_rect", true);
    localBundle.putBoolean("key_double_bitmap", true);
    paramChatBackground.c = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), paramString, "-chatBg-", (Drawable)localObject, new int[] { 0 }, "-chatBg-", localBundle);
    if ((paramChatBackground.c == null) && (localBitmap != null)) {
      paramChatBackground.c = new ChatBackgroundDrawable(paramContext.getResources(), localBitmap);
    }
    paramChatBackground.a = paramString;
    paramChatBackground.d = true;
    if (localBitmap != null) {
      paramChatBackground.b = a(paramSharedPreferences, paramString, localBitmap);
    }
    long l3 = SystemClock.uptimeMillis();
    paramContext = new StringBuilder();
    paramContext.append("APNG_getBitmap ");
    paramContext.append(l2 - l1);
    paramContext.append(" APNG_init ");
    paramContext.append(l3 - l2);
    QLog.d("ChatBackground_Time", 1, paramContext.toString());
  }
  
  static void a(Context paramContext, ChatBackground paramChatBackground, String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      int k;
      try
      {
        localObject1 = Shader.TileMode.REPEAT;
        k = 119;
        Object localObject2 = paramContext.getResources().getDrawable(2130839229);
        if (localObject2 == null)
        {
          QLog.e("ChatBackground", 1, "setAIOBackgroundBmp Drawable d == null.");
          return;
        }
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("setAIOBackgroundBmp, Drawable d=");
        ((StringBuilder)localObject3).append(localObject2);
        ((StringBuilder)localObject3).append(",path=");
        ((StringBuilder)localObject3).append(paramString);
        QLog.d("ChatBackground", 1, ((StringBuilder)localObject3).toString());
        ThemeBackground.h.a();
        if (!ThemeUtil.isNowThemeIsAnimate()) {
          break label813;
        }
        paramString = ThemeUtil.getAnimatePathByTag(3);
        localObject3 = new Bundle();
        ((Bundle)localObject3).putBoolean("key_use_rect", true);
        ((Bundle)localObject3).putBoolean("key_play_apng", paramBoolean);
        Drawable localDrawable = ThemeBackground.a(paramString, "qq_skin_aio.mp4", 2130839229);
        if (!(localDrawable instanceof IGLDrawable)) {
          break label807;
        }
        ((IGLDrawable)localDrawable).setLockWH(true);
        paramChatBackground.c = localDrawable;
        paramChatBackground.a = paramString;
        ThemeBackground.h.d();
        i = 1;
        j = i;
        if (i == 0)
        {
          j = i;
          if (new File(paramString).exists())
          {
            paramChatBackground.c = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), paramString, "-chatBg-", (Drawable)localObject2, new int[] { 0 }, "-chatBg-", (Bundle)localObject3);
            paramChatBackground.a = paramString;
            ThemeBackground.h.c();
            j = 1;
          }
        }
        if (j == 0)
        {
          if ((localObject2 instanceof BitmapDrawable))
          {
            paramString = ((BitmapDrawable)localObject2).getBitmap();
            localObject1 = ((BitmapDrawable)localObject2).getTileModeX();
            i = ((BitmapDrawable)localObject2).getGravity();
          }
          else
          {
            if (!(localObject2 instanceof SkinnableBitmapDrawable)) {
              break label819;
            }
            paramString = ((SkinnableBitmapDrawable)localObject2).getBitmap();
            localObject1 = ((SkinnableBitmapDrawable)localObject2).getTileModeX();
            i = ((SkinnableBitmapDrawable)localObject2).getGravity();
          }
          if ((paramString != null) && (localObject1 != Shader.TileMode.REPEAT) && (i == 48))
          {
            localObject1 = new ChatBackgroundDrawable(paramContext.getResources(), paramString);
            ((ChatBackgroundDrawable)localObject1).setGravity(i);
            paramChatBackground.c = ((Drawable)localObject1);
          }
          else
          {
            paramChatBackground.c = ((Drawable)localObject2);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("setAIOBackgroundBmp, bgBitmap=");
              ((StringBuilder)localObject2).append(paramString);
              ((StringBuilder)localObject2).append(", type=");
              if (localObject1 != Shader.TileMode.REPEAT) {
                break label828;
              }
              paramBoolean = true;
              ((StringBuilder)localObject2).append(paramBoolean);
              ((StringBuilder)localObject2).append(", gravity=");
              ((StringBuilder)localObject2).append(i);
              QLog.d("ChatBackground", 2, ((StringBuilder)localObject2).toString());
            }
          }
          if (paramString != null) {}
        }
      }
      catch (Exception paramString)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setAIOBackgroundBmp OOM2 or Err:");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        QLog.e("ChatBackground", 1, ((StringBuilder)localObject1).toString());
        paramChatBackground.c = paramContext.getResources().getDrawable(2130852164);
        paramString = new HashMap();
        paramString.put("param_FailCode", "EE");
        paramString.put("param_themeid", ThemeUtil.getCurrentThemeId());
        StatisticCollector.getInstance(paramContext).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString, "", false);
      }
      catch (OutOfMemoryError paramString)
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("setAIOBackgroundBmp OOM1:");
        ((StringBuilder)localObject1).append(paramString.getMessage());
        QLog.e("ChatBackground", 1, ((StringBuilder)localObject1).toString());
        paramChatBackground.c = paramContext.getResources().getDrawable(2130852164);
        paramString = new HashMap();
        paramString.put("param_FailCode", "OOM1");
        paramString.put("param_themeid", ThemeUtil.getCurrentThemeId());
        StatisticCollector.getInstance(paramContext).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString, "", false);
      }
      try
      {
        paramString = new HashMap();
        paramString.put("param_FailCode", "dNull");
        paramString.put("param_themeid", ThemeUtil.getCurrentThemeId());
        StatisticCollector.getInstance(paramContext).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString, "", false);
      }
      catch (Exception paramContext)
      {
        continue;
      }
      if (paramChatBackground.c != null)
      {
        paramChatBackground.d = true;
        return;
      }
      QLog.e("ChatBackground", 1, "setAIOBackgroundBmp out.img == null");
      return;
      label807:
      int i = 0;
      continue;
      label813:
      int j = 0;
      continue;
      label819:
      paramString = null;
      i = k;
      continue;
      label828:
      paramBoolean = false;
    }
  }
  
  private static void a(Context paramContext, String paramString1, ChatBackground paramChatBackground, SharedPreferences paramSharedPreferences, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (GlobalImageCache.a.get(paramString2) != null) {
      localObject2 = (Bitmap)GlobalImageCache.a.get(paramString2);
    } else {
      localObject2 = null;
    }
    Object localObject1 = localObject2;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((Bitmap)localObject2).isRecycled()) {
        localObject1 = null;
      }
    }
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new File(paramString2);
      if ((((File)localObject2).exists()) && (((File)localObject2).isFile()))
      {
        long l1 = SystemClock.uptimeMillis();
        localObject2 = a(paramContext, paramString2);
        long l2 = SystemClock.uptimeMillis();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Normal_getBitmap ");
        ((StringBuilder)localObject1).append(l2 - l1);
        QLog.e("ChatBackground_Time", 1, ((StringBuilder)localObject1).toString());
      }
      else
      {
        localObject2 = new File(QQSharpPUtil.b((File)localObject2));
        if (((File)localObject2).exists())
        {
          localObject2 = a(paramContext, paramString2, (Bitmap)localObject1, (File)localObject2);
        }
        else
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getChatBackground Error, file == null ; path = ");
          ((StringBuilder)localObject2).append(paramString2);
          QLog.e("ChatBackground", 1, ((StringBuilder)localObject2).toString());
        }
      }
    }
    try
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("param_FailCode", "dd_5");
      ((HashMap)localObject2).put("param_themeid", ThemeUtil.getCurrentThemeId());
      localStatisticCollector = StatisticCollector.getInstance(paramContext);
      str = ((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount();
      if (localObject1 == null) {
        break label671;
      }
      bool1 = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        StatisticCollector localStatisticCollector;
        String str;
        boolean bool2;
        continue;
        boolean bool1 = false;
      }
    }
    localStatisticCollector.collectPerformance(str, "ChatBackgroundDecoder", bool1, 1L, 0L, (HashMap)localObject2, "", false);
    bool1 = true;
    break label322;
    bool1 = false;
    localObject1 = localObject2;
    label322:
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getChatBackground, check bg=");
    if (localObject1 != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    ((StringBuilder)localObject2).append(bool2);
    ((StringBuilder)localObject2).append(", path=");
    ((StringBuilder)localObject2).append(paramString2);
    QLog.d("ChatBackground", 1, ((StringBuilder)localObject2).toString());
    if (localObject1 != null)
    {
      GlobalImageCache.a.put(paramString2, localObject1);
      paramChatBackground.a = paramString2;
      paramChatBackground.c = new ChatBackgroundDrawable(paramContext.getResources(), (Bitmap)localObject1);
      paramChatBackground.b = a(paramSharedPreferences, paramString2, (Bitmap)localObject1);
      paramChatBackground.d = true;
      return;
    }
    paramString1 = ThemeBackground.a(paramContext, paramString1, 0).getString("theme_bg_aio_path_url", null);
    if (!TextUtils.isEmpty(paramString1))
    {
      paramSharedPreferences = new StringBuilder();
      paramSharedPreferences.append("getChatBackground, downloading, url=");
      paramSharedPreferences.append(paramString1);
      paramSharedPreferences.append(", path=");
      paramSharedPreferences.append(paramString2);
      QLog.d("ChatBackground", 1, paramSharedPreferences.toString());
      paramSharedPreferences = new ResData();
      paramSharedPreferences.d = paramString2;
      paramSharedPreferences.e = paramString1;
      paramSharedPreferences.i = 3;
      paramChatBackground.c = DIYThemeUtils.a(paramContext, paramSharedPreferences, 0, 0, -1, paramBoolean2);
      paramChatBackground.a = paramString2;
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("getChatBackground, bg == null, path=");
    paramString1.append(paramString2);
    paramString1.append(", fileErr=");
    paramString1.append(bool1);
    QLog.e("ChatBackground", 1, paramString1.toString());
    paramChatBackground.a = "null";
    try
    {
      paramChatBackground.b = paramContext.getResources().getColorStateList(2131168022);
    }
    catch (RuntimeException paramString1)
    {
      label632:
      break label632;
    }
    QLog.d("ChatBackground_Time", 2, "getChatBackground error");
    a(paramContext, paramChatBackground, paramString2, paramBoolean1);
    if (!bool1) {
      paramChatBackground.d = false;
    }
  }
  
  private static boolean a(Context paramContext, String paramString1, int paramInt, ChatBackground paramChatBackground, SharedPreferences paramSharedPreferences, String paramString2)
  {
    boolean bool1;
    if ((paramInt & 0x1) != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i;
    if ((paramInt & 0x4) != 0) {
      i = 1;
    } else {
      i = 0;
    }
    boolean bool2;
    if ((paramInt & 0x2) != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if ((paramChatBackground.c != null) && (paramChatBackground.d) && (!TextUtils.isEmpty(paramChatBackground.a)) && (paramChatBackground.a.equals(paramString2)))
    {
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("getChatBackground, bg not change, path=");
        paramContext.append(paramString2);
        QLog.d("ChatBackground", 2, paramContext.toString());
      }
      return false;
    }
    try
    {
      boolean bool3 = TextUtils.isEmpty(paramString2);
      if ((!bool3) && (!"null".equals(paramString2)) && (!"none".equals(paramString2)))
      {
        if ((i != 0) && (ChatBackgroundManager.a(new File(paramString2)))) {
          a(paramContext, paramChatBackground, paramSharedPreferences, paramString2);
        } else {
          a(paramContext, paramString1, paramChatBackground, paramSharedPreferences, paramString2, bool1, bool2);
        }
      }
      else {
        paramChatBackground.a = "null";
      }
    }
    catch (OutOfMemoryError paramString1)
    {
      label235:
      break label257;
    }
    try
    {
      paramChatBackground.b = paramContext.getResources().getColorStateList(2131168022);
    }
    catch (RuntimeException paramString1)
    {
      break label235;
    }
    QLog.d("ChatBackground_Time", 2, "getChatBackground error");
    a(paramContext, paramChatBackground, paramString2, bool1);
    break label363;
    label257:
    paramString1 = new StringBuilder();
    paramString1.append("getChatBackground OOM0 ; path = ");
    paramString1.append(paramString2);
    QLog.e("ChatBackground", 1, paramString1.toString());
    paramChatBackground.c = paramContext.getResources().getDrawable(2130852164);
    try
    {
      paramString1 = new HashMap();
      paramString1.put("param_FailCode", "OOM0");
      paramString1.put("param_themeid", ThemeUtil.getCurrentThemeId());
      StatisticCollector.getInstance(paramContext).collectPerformance(((QQAppInterface)BaseApplicationImpl.sApplication.getRuntime()).getAccount(), "ChatBackgroundDecoder", false, 1L, 0L, paramString1, "", false);
    }
    catch (Exception paramContext)
    {
      label363:
      break label363;
    }
    if (paramChatBackground.c == null) {
      QLog.e("ChatBackground", 1, "getChatBackground error out.img == null");
    }
    return true;
  }
  
  public static boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, int paramInt, ChatBackground paramChatBackground)
  {
    if (paramChatBackground == null)
    {
      QLog.e("ChatBackground", 1, "getChatBackground out=null");
      return false;
    }
    SharedPreferences localSharedPreferences = ChatBackgroundUtil.a(paramContext, paramString1, 0);
    if (!TextUtils.isEmpty(paramString2)) {
      localObject = localSharedPreferences.getString(paramString2, null);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      paramString2 = (String)localObject;
      if (!((String)localObject).equals("null")) {}
    }
    else
    {
      localObject = localSharedPreferences.getString("chat_uniform_bg", null);
      paramString2 = (String)localObject;
      if (localObject == null) {
        paramString2 = "null";
      }
    }
    paramString2 = ThemeDiyStyleLogic.a(paramString2);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getChatBackground, out.isDecodeSuccess=");
    ((StringBuilder)localObject).append(paramChatBackground.d);
    ((StringBuilder)localObject).append(", path=");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", out.path=");
    ((StringBuilder)localObject).append(paramChatBackground.a);
    QLog.d("ChatBackground_Time", 1, ((StringBuilder)localObject).toString());
    return a(paramContext, paramString1, paramInt, paramChatBackground, localSharedPreferences, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatBackground
 * JD-Core Version:    0.7.0.1
 */