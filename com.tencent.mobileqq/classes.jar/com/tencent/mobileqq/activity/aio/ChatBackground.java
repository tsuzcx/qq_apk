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
  public ColorStateList a;
  public Drawable a;
  public String a;
  public boolean a;
  
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
    Object localObject2 = BitmapManager.a(paramString, localOptions);
    Bitmap localBitmap = ((BitmapManager.BitmapDecodeResult)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
    boolean bool;
    if ((localBitmap != null) && (((BitmapManager.BitmapDecodeResult)localObject2).jdField_a_of_type_Int == 0))
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
      ((StringBuilder)localObject3).append(((BitmapManager.BitmapDecodeResult)localObject2).jdField_a_of_type_Int);
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
          ((StringBuilder)localObject2).append(((BitmapManager.BitmapDecodeResult)localObject1).jdField_a_of_type_Int);
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
    if (((BitmapManager.BitmapDecodeResult)localObject2).jdField_a_of_type_Int == 1)
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
        localObject1 = BitmapManager.a(paramString, localOptions);
        localBitmap = ((BitmapManager.BitmapDecodeResult)localObject1).jdField_a_of_type_AndroidGraphicsBitmap;
        if ((QLog.isColorLevel()) || (localBitmap == null))
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getChatBackground, miniDecode, result=");
          ((StringBuilder)localObject2).append(((BitmapManager.BitmapDecodeResult)localObject1).jdField_a_of_type_Int);
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
        if (((BitmapManager.BitmapDecodeResult)localObject1).jdField_a_of_type_Int != 1) {
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
    //   1: invokestatic 231	com/tencent/qqsharpP/QQSharpPUtil:a	(Landroid/content/Context;)Z
    //   4: istore 4
    //   6: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifne +8 -> 17
    //   12: iload 4
    //   14: ifne +48 -> 62
    //   17: new 44	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   24: astore_0
    //   25: aload_0
    //   26: ldc 233
    //   28: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: pop
    //   32: aload_0
    //   33: aload_1
    //   34: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload_0
    //   39: ldc 235
    //   41: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload_0
    //   46: iload 4
    //   48: invokevirtual 164	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: ldc 153
    //   54: iconst_2
    //   55: aload_0
    //   56: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aload_2
    //   63: astore 6
    //   65: iload 4
    //   67: ifeq +250 -> 317
    //   70: iconst_0
    //   71: istore 5
    //   73: iconst_0
    //   74: istore 4
    //   76: aload_3
    //   77: invokevirtual 240	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   80: invokestatic 246	com/tencent/sharpP/SharpPUtil:decodeSharpPByFilePath	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   83: astore_0
    //   84: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifne +10 -> 97
    //   90: aload_0
    //   91: astore 6
    //   93: aload_0
    //   94: ifnonnull +223 -> 317
    //   97: new 44	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   104: astore_2
    //   105: aload_2
    //   106: ldc 248
    //   108: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_0
    //   113: astore 6
    //   115: aload_2
    //   116: astore_3
    //   117: aload_0
    //   118: ifnull +11 -> 129
    //   121: aload_2
    //   122: astore_3
    //   123: iconst_1
    //   124: istore 4
    //   126: aload_0
    //   127: astore 6
    //   129: aload_3
    //   130: iload 4
    //   132: invokevirtual 164	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   135: pop
    //   136: aload_3
    //   137: ldc 146
    //   139: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: pop
    //   143: aload_3
    //   144: aload_1
    //   145: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: ldc 153
    //   151: iconst_2
    //   152: aload_3
    //   153: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 6
    //   161: areturn
    //   162: astore_0
    //   163: goto +86 -> 249
    //   166: astore_0
    //   167: new 44	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   174: astore_3
    //   175: aload_3
    //   176: ldc 250
    //   178: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: aload_3
    //   183: aload_0
    //   184: invokevirtual 253	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
    //   187: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: ldc 153
    //   193: iconst_1
    //   194: aload_3
    //   195: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 167	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifne +10 -> 214
    //   207: aload_2
    //   208: astore 6
    //   210: aload_2
    //   211: ifnonnull +106 -> 317
    //   214: new 44	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   221: astore 7
    //   223: aload 7
    //   225: ldc 248
    //   227: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: aload_2
    //   232: astore 6
    //   234: aload 7
    //   236: astore_3
    //   237: aload_2
    //   238: ifnull -109 -> 129
    //   241: aload_2
    //   242: astore_0
    //   243: aload 7
    //   245: astore_3
    //   246: goto -123 -> 123
    //   249: invokestatic 142	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   252: ifne +7 -> 259
    //   255: aload_2
    //   256: ifnonnull +59 -> 315
    //   259: new 44	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 45	java/lang/StringBuilder:<init>	()V
    //   266: astore_3
    //   267: aload_3
    //   268: ldc 248
    //   270: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: iload 5
    //   276: istore 4
    //   278: aload_2
    //   279: ifnull +6 -> 285
    //   282: iconst_1
    //   283: istore 4
    //   285: aload_3
    //   286: iload 4
    //   288: invokevirtual 164	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: aload_3
    //   293: ldc 146
    //   295: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: pop
    //   299: aload_3
    //   300: aload_1
    //   301: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: pop
    //   305: ldc 153
    //   307: iconst_2
    //   308: aload_3
    //   309: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 157	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload_0
    //   316: athrow
    //   317: aload 6
    //   319: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	paramContext	Context
    //   0	320	1	paramString	String
    //   0	320	2	paramBitmap	Bitmap
    //   0	320	3	paramFile	File
    //   4	283	4	bool1	boolean
    //   71	204	5	bool2	boolean
    //   63	255	6	localObject	Object
    //   221	23	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   76	84	162	finally
    //   167	201	162	finally
    //   76	84	166	java/lang/UnsatisfiedLinkError
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
      localObject = paramContext.getResources().getDrawable(2130839075);
    }
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
      try
      {
        localObject1 = Shader.TileMode.REPEAT;
        Object localObject2 = paramContext.getResources().getDrawable(2130839075);
        if (localObject2 == null)
        {
          QLog.e("ChatBackground", 1, "setAIOBackgroundBmp Drawable d == null.");
          return;
        }
        if (QLog.isColorLevel())
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("setAIOBackgroundBmp, Drawable d=");
          ((StringBuilder)localObject3).append(localObject2);
          ((StringBuilder)localObject3).append(",path=");
          ((StringBuilder)localObject3).append(paramString);
          QLog.d("ChatBackground", 2, ((StringBuilder)localObject3).toString());
        }
        ThemeBackground.a.a();
        if (!ThemeUtil.isNowThemeIsAnimate()) {
          break label810;
        }
        paramString = ThemeUtil.getAnimatePathByTag(3);
        Object localObject3 = new Bundle();
        ((Bundle)localObject3).putBoolean("key_use_rect", true);
        ((Bundle)localObject3).putBoolean("key_play_apng", paramBoolean);
        Drawable localDrawable = ThemeBackground.a(paramString, "qq_skin_aio.mp4", 2130839075);
        if (!(localDrawable instanceof IGLDrawable)) {
          break label801;
        }
        ((IGLDrawable)localDrawable).setLockWH(true);
        paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = localDrawable;
        paramChatBackground.jdField_a_of_type_JavaLangString = paramString;
        ThemeBackground.a.d();
        i = 1;
        if ((i != 0) || (!new File(paramString).exists())) {
          break label807;
        }
        paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = VasApngUtil.getApngDrawable(BaseApplicationImpl.sApplication.getRuntime(), paramString, "-chatBg-", (Drawable)localObject2, new int[] { 0 }, "-chatBg-", (Bundle)localObject3);
        paramChatBackground.jdField_a_of_type_JavaLangString = paramString;
        ThemeBackground.a.c();
        i = 1;
        if (i == 0)
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
              break label816;
            }
            paramString = ((SkinnableBitmapDrawable)localObject2).getBitmap();
            localObject1 = ((SkinnableBitmapDrawable)localObject2).getTileModeX();
            i = ((SkinnableBitmapDrawable)localObject2).getGravity();
          }
          if ((paramString != null) && (localObject1 != Shader.TileMode.REPEAT) && (i == 48))
          {
            localObject1 = new ChatBackgroundDrawable(paramContext.getResources(), paramString);
            ((ChatBackgroundDrawable)localObject1).setGravity(i);
            paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject1);
          }
          else
          {
            paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = ((Drawable)localObject2);
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("setAIOBackgroundBmp, bgBitmap=");
              ((StringBuilder)localObject2).append(paramString);
              ((StringBuilder)localObject2).append(", type=");
              if (localObject1 != Shader.TileMode.REPEAT) {
                break label825;
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
        paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130850373);
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
        paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130850373);
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
      if (paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        paramChatBackground.jdField_a_of_type_Boolean = true;
        return;
      }
      QLog.e("ChatBackground", 1, "setAIOBackgroundBmp out.img == null");
      return;
      label801:
      int i = 0;
      continue;
      label807:
      continue;
      label810:
      i = 0;
      continue;
      label816:
      paramString = null;
      i = 119;
      continue;
      label825:
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
        localObject2 = new File(QQSharpPUtil.a((File)localObject2));
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
        break label683;
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
    if (QLog.isColorLevel())
    {
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
      QLog.d("ChatBackground", 2, ((StringBuilder)localObject2).toString());
    }
    if (localObject1 != null)
    {
      GlobalImageCache.a.put(paramString2, localObject1);
      paramChatBackground.jdField_a_of_type_JavaLangString = paramString2;
      paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ChatBackgroundDrawable(paramContext.getResources(), (Bitmap)localObject1);
      paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = a(paramSharedPreferences, paramString2, (Bitmap)localObject1);
      paramChatBackground.jdField_a_of_type_Boolean = true;
      return;
    }
    paramString1 = ThemeBackground.a(paramContext, paramString1, 0).getString("theme_bg_aio_path_url", null);
    if (!TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel())
      {
        paramSharedPreferences = new StringBuilder();
        paramSharedPreferences.append("getChatBackground, downloading, url=");
        paramSharedPreferences.append(paramString1);
        paramSharedPreferences.append(", path=");
        paramSharedPreferences.append(paramString2);
        QLog.d("ChatBackground", 2, paramSharedPreferences.toString());
      }
      paramSharedPreferences = new ResData();
      paramSharedPreferences.c = paramString2;
      paramSharedPreferences.d = paramString1;
      paramSharedPreferences.e = 3;
      paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = DIYThemeUtils.a(paramContext, paramSharedPreferences, 0, 0, -1, paramBoolean2);
      paramChatBackground.jdField_a_of_type_JavaLangString = paramString2;
      return;
    }
    paramString1 = new StringBuilder();
    paramString1.append("getChatBackground, bg == null, path=");
    paramString1.append(paramString2);
    paramString1.append(", fileErr=");
    paramString1.append(bool1);
    QLog.e("ChatBackground", 2, paramString1.toString());
    paramChatBackground.jdField_a_of_type_JavaLangString = "null";
    try
    {
      paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131167081);
    }
    catch (RuntimeException paramString1)
    {
      label644:
      break label644;
    }
    QLog.d("ChatBackground_Time", 2, "getChatBackground error");
    a(paramContext, paramChatBackground, paramString2, paramBoolean1);
    if (!bool1) {
      paramChatBackground.jdField_a_of_type_Boolean = false;
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
    if ((paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) && (paramChatBackground.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(paramChatBackground.jdField_a_of_type_JavaLangString)) && (paramChatBackground.jdField_a_of_type_JavaLangString.equals(paramString2)))
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
        paramChatBackground.jdField_a_of_type_JavaLangString = "null";
      }
    }
    catch (OutOfMemoryError paramString1)
    {
      label235:
      break label257;
    }
    try
    {
      paramChatBackground.jdField_a_of_type_AndroidContentResColorStateList = paramContext.getResources().getColorStateList(2131167081);
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
    paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130850373);
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
    if (paramChatBackground.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
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
    Object localObject;
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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getChatBackground, out.isDecodeSuccess=");
      ((StringBuilder)localObject).append(paramChatBackground.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject).append(", path=");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", out.path=");
      ((StringBuilder)localObject).append(paramChatBackground.jdField_a_of_type_JavaLangString);
      QLog.d("ChatBackground_Time", 2, ((StringBuilder)localObject).toString());
    }
    return a(paramContext, paramString1, paramInt, paramChatBackground, localSharedPreferences, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatBackground
 * JD-Core Version:    0.7.0.1
 */