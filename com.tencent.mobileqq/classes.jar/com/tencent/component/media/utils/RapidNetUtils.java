package com.tencent.component.media.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.webkit.URLUtil;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.youtu.android.rapidnet.SuperresolutionLib;
import com.tencent.youtu.android.rapidnet.SuperresolutionLog;
import java.io.File;
import pnu;
import pnv;

public class RapidNetUtils
{
  private static int jdField_a_of_type_Int;
  private static volatile SuperresolutionLib jdField_a_of_type_ComTencentYoutuAndroidRapidnetSuperresolutionLib;
  public static volatile int currentModelId;
  
  static
  {
    SuperresolutionLog.setLogCallback(new pnu());
  }
  
  private static int a()
  {
    if (jdField_a_of_type_Int == 0) {}
    try
    {
      File[] arrayOfFile = new File("/sys/devices/system/cpu/").listFiles(new pnv());
      if (arrayOfFile == null) {
        return 1;
      }
      jdField_a_of_type_Int = arrayOfFile.length;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ImageManagerEnv.getLogger().e("SuperResolution.RapidNetUtils", new Object[] { "getCpuCores exception occured,e=" + localException.getMessage() });
        jdField_a_of_type_Int = 1;
      }
    }
    ImageManagerEnv.getLogger().d("SuperResolution.RapidNetUtils", new Object[] { "getCpuCores, num=" + jdField_a_of_type_Int });
    return jdField_a_of_type_Int;
  }
  
  private static int a(SuperresolutionLib paramSuperresolutionLib, Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    long l = System.currentTimeMillis();
    int i = 0;
    while (i < 1)
    {
      if (SuperresolutionLib.sLoadSuccess) {
        paramSuperresolutionLib.superResolution(paramBitmap, paramFloat1, paramFloat2, b());
      }
      i += 1;
    }
    return (int)((System.currentTimeMillis() - l) / 1);
  }
  
  private static void a(int paramInt, boolean paramBoolean)
  {
    if ((jdField_a_of_type_ComTencentYoutuAndroidRapidnetSuperresolutionLib == null) || (currentModelId != paramInt)) {}
    long l;
    Pair localPair;
    label370:
    try
    {
      if (jdField_a_of_type_ComTencentYoutuAndroidRapidnetSuperresolutionLib != null)
      {
        int i = currentModelId;
        if (i == paramInt) {
          break label370;
        }
      }
    }
    finally {}
    try
    {
      l = System.currentTimeMillis();
      localPair = ImageManagerEnv.g().loadSuperResolutionModelFile(paramInt);
      ImageManagerEnv.getLogger().w("SuperResolution.RapidNetUtils", new Object[] { "superResolution load model file. cost=" + (System.currentTimeMillis() - l) });
      if (localPair == null)
      {
        ImageManagerEnv.getLogger().e("SuperResolution.RapidNetUtils", new Object[] { "load model error" });
        ImageManagerEnv.g().startSuperResolutionModelDownload(paramInt);
        return;
      }
      if ((jdField_a_of_type_ComTencentYoutuAndroidRapidnetSuperresolutionLib != null) && (SuperresolutionLib.sLoadSuccess))
      {
        ImageManagerEnv.getLogger().w("SuperResolution.RapidNetUtils", new Object[] { "destroy previous superresolutionLib" });
        l = System.currentTimeMillis();
        jdField_a_of_type_ComTencentYoutuAndroidRapidnetSuperresolutionLib.destroy();
        l = System.currentTimeMillis() - l;
        ImageManagerEnv.getLogger().w("SuperResolution.RapidNetUtils", new Object[] { "superResolution destroy lib. cost=" + l });
        if (paramBoolean) {
          ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "super_resolution_time_cost", "lib_destroy", (int)l);
        }
      }
      ImageManagerEnv.getLogger().d("SuperResolution.RapidNetUtils", new Object[] { "create lib. currentModelId=" + currentModelId + " newModelId=" + paramInt });
      l = System.currentTimeMillis();
      jdField_a_of_type_ComTencentYoutuAndroidRapidnetSuperresolutionLib = new SuperresolutionLib((String)localPair.second, (String)localPair.first);
      l = System.currentTimeMillis() - l;
      ImageManagerEnv.getLogger().w("SuperResolution.RapidNetUtils", new Object[] { "superResolution create lib. cost=" + l });
      if (paramBoolean) {
        ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "super_resolution_time_cost", "lib_create", (int)l);
      }
      currentModelId = paramInt;
      ImageManagerEnv.g().saveSuperResolutionLastModelId(currentModelId);
    }
    catch (Throwable localThrowable)
    {
      ImageManagerEnv.getLogger().e("SuperResolution.RapidNetUtils", new Object[] { "createLib error:" + Log.getStackTraceString(localThrowable) });
      break label370;
    }
  }
  
  private static int b()
  {
    int i = a();
    ImageManagerEnv.getLogger().w("SuperResolution.RapidNetUtils", new Object[] { "running on " + i + " cpu cores" });
    if (i <= 2) {
      return 1;
    }
    return i - 1;
  }
  
  public static boolean canDoSuperResolution(int paramInt1, int paramInt2)
  {
    return true;
  }
  
  public static String convertBigUrlToHrUrl(String paramString)
  {
    try
    {
      paramString = Uri.parse(paramString).buildUpon().appendQueryParameter("sr", String.valueOf(ImageManagerEnv.g().getSuperResolutionHighScaleModelId())).appendQueryParameter("srhs", "1").build().toString();
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public static String convertSrUrlToBigUrl(String paramString)
  {
    try
    {
      String str = paramString.replace(ImageManagerEnv.g().getImageCurrentUrlSegment(), ImageManagerEnv.g().getImageBigUrlSegment()).replaceAll(ImageManagerEnv.g().getSRParameterRex(), "").replaceAll(ImageManagerEnv.g().getQAParameterRex(), "");
      return str;
    }
    catch (Throwable localThrowable)
    {
      ImageManagerEnv.getLogger().e("SuperResolution.RapidNetUtils", new Object[] { "convertSrUrlToBigUrl error: url=" + paramString + " " + Log.getStackTraceString(localThrowable) });
    }
    return null;
  }
  
  public static Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    int j = 1;
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    int i = paramDrawable.getIntrinsicWidth();
    if (i > 0) {}
    for (;;)
    {
      int k = paramDrawable.getIntrinsicHeight();
      if (k > 0) {
        j = k;
      }
      Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      Canvas localCanvas = new Canvas(localBitmap);
      paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
      paramDrawable.draw(localCanvas);
      return localBitmap;
      i = 1;
    }
  }
  
  public static int getModelIdFromUrl(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {}
    do
    {
      return -1;
      paramString = Uri.parse(paramString).getQueryParameter("sr");
    } while (TextUtils.isEmpty(paramString));
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Throwable paramString)
    {
      ImageManagerEnv.getLogger().e("SuperResolution.RapidNetUtils", new Object[] { "needSuperResolution parse sr error!!! " + paramString.getMessage() });
    }
    return -1;
  }
  
  public static boolean hasInit()
  {
    return jdField_a_of_type_ComTencentYoutuAndroidRapidnetSuperresolutionLib != null;
  }
  
  public static boolean isBigUrl(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {}
    while (paramString.indexOf(ImageManagerEnv.g().getImageBigUrlSegment()) == -1) {
      return false;
    }
    return true;
  }
  
  public static boolean isHighScaleUrl(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        boolean bool = TextUtils.isEmpty(Uri.parse(paramString).getQueryParameter("srhs"));
        if (!bool) {
          return true;
        }
      }
      catch (Throwable paramString) {}
    }
    return false;
  }
  
  public static boolean isSuperResolutionUrl(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        boolean bool = TextUtils.isEmpty(Uri.parse(paramString).getQueryParameter("sr"));
        if (!bool) {
          return true;
        }
      }
      catch (Throwable paramString) {}
    }
    return false;
  }
  
  public static boolean needRerunBenchmark(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {}
    for (;;)
    {
      return false;
      paramString = Uri.parse(paramString).getQueryParameter("rr");
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          if (Integer.parseInt(paramString) > 0)
          {
            ImageManagerEnv.getLogger().w("SuperResolution.RapidNetUtils", new Object[] { "needRerunBenchmark !!!" });
            return true;
          }
        }
        catch (Throwable paramString)
        {
          ImageManagerEnv.getLogger().e("SuperResolution.RapidNetUtils", new Object[] { "needRerunBenchmark parse sr error!!! " + paramString.getMessage() });
        }
      }
    }
    return false;
  }
  
  public static boolean needSuperResolution(String paramString)
  {
    if (!URLUtil.isNetworkUrl(paramString)) {}
    Object localObject;
    int i;
    do
    {
      return false;
      localObject = Uri.parse(paramString);
      paramString = ((Uri)localObject).getQueryParameter("sr");
      localObject = ((Uri)localObject).getQueryParameter("lsr");
      if (!TextUtils.isEmpty(paramString)) {
        try
        {
          i = Integer.parseInt(paramString);
          if (ImageManagerEnv.g().isSuperResolutionModelReady(i)) {
            return true;
          }
          ImageManagerEnv.getLogger().w("SuperResolution.RapidNetUtils", new Object[] { "needSuperResolution model missing, try to download. sr=" + i });
          ImageManagerEnv.g().startSuperResolutionModelDownload(i);
          return false;
        }
        catch (Throwable paramString)
        {
          ImageManagerEnv.getLogger().e("SuperResolution.RapidNetUtils", new Object[] { "needSuperResolution parse sr error!!! " + paramString.getMessage() });
          return false;
        }
      }
    } while (TextUtils.isEmpty((CharSequence)localObject));
    try
    {
      i = Integer.parseInt((String)localObject);
      if (!ImageManagerEnv.g().isSuperResolutionModelReady(i))
      {
        ImageManagerEnv.getLogger().w("SuperResolution.RapidNetUtils", new Object[] { "needSuperResolution, try to download. lsr=" + i });
        ImageManagerEnv.g().startSuperResolutionModelDownload(i);
        return false;
      }
    }
    catch (Throwable paramString)
    {
      ImageManagerEnv.getLogger().e("SuperResolution.RapidNetUtils", new Object[] { "needSuperResolution parse lsr error!!! " + paramString.getMessage() });
      return false;
    }
    ImageManagerEnv.getLogger().w("SuperResolution.RapidNetUtils", new Object[] { "needSuperResolution, try to download. lsr=" + i });
    ImageManagerEnv.g().updateSuperResolutionDownloadedModel();
    return false;
  }
  
  /* Error */
  public static int runBenchmark()
  {
    // Byte code:
    //   0: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   3: invokevirtual 359	com/tencent/component/media/ImageManagerEnv:getBenchmarkImagePath	()Ljava/lang/String;
    //   6: astore 9
    //   8: aload 9
    //   10: invokestatic 314	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   13: ifeq +9 -> 22
    //   16: iconst_m1
    //   17: istore 5
    //   19: iload 5
    //   21: ireturn
    //   22: new 361	java/io/BufferedInputStream
    //   25: dup
    //   26: new 363	java/io/FileInputStream
    //   29: dup
    //   30: aload 9
    //   32: invokespecial 364	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   35: invokespecial 367	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: aconst_null
    //   39: invokestatic 373	com/tencent/component/media/utils/BitmapUtils:getOptions	()Landroid/graphics/BitmapFactory$Options;
    //   42: invokestatic 379	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   45: astore 11
    //   47: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   50: invokevirtual 382	com/tencent/component/media/ImageManagerEnv:getDefaultSuperResolutionModelId	()I
    //   53: istore 8
    //   55: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   58: iload 8
    //   60: invokevirtual 115	com/tencent/component/media/ImageManagerEnv:loadSuperResolutionModelFile	(I)Landroid/util/Pair;
    //   63: astore 9
    //   65: aload 9
    //   67: ifnonnull +49 -> 116
    //   70: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   73: ldc 50
    //   75: iconst_1
    //   76: anewarray 4	java/lang/Object
    //   79: dup
    //   80: iconst_0
    //   81: ldc 125
    //   83: aastore
    //   84: invokeinterface 80 3 0
    //   89: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   92: iload 8
    //   94: invokevirtual 129	com/tencent/component/media/ImageManagerEnv:startSuperResolutionModelDownload	(I)V
    //   97: iconst_m1
    //   98: istore 5
    //   100: iconst_0
    //   101: ifeq -82 -> 19
    //   104: new 384	java/lang/NullPointerException
    //   107: dup
    //   108: invokespecial 385	java/lang/NullPointerException:<init>	()V
    //   111: athrow
    //   112: astore 9
    //   114: iconst_m1
    //   115: ireturn
    //   116: new 89	com/tencent/youtu/android/rapidnet/SuperresolutionLib
    //   119: dup
    //   120: aload 9
    //   122: getfield 156	android/util/Pair:second	Ljava/lang/Object;
    //   125: checkcast 158	java/lang/String
    //   128: aload 9
    //   130: getfield 161	android/util/Pair:first	Ljava/lang/Object;
    //   133: checkcast 158	java/lang/String
    //   136: invokespecial 164	com/tencent/youtu/android/rapidnet/SuperresolutionLib:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: astore 10
    //   141: aload 10
    //   143: astore 9
    //   145: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   148: iload 8
    //   150: invokevirtual 389	com/tencent/component/media/ImageManagerEnv:getSuperResolutionScaleByModelId	(I)F
    //   153: fstore_3
    //   154: aload 10
    //   156: astore 9
    //   158: aload 10
    //   160: aload 11
    //   162: fload_3
    //   163: fconst_0
    //   164: invokestatic 391	com/tencent/component/media/utils/RapidNetUtils:a	(Lcom/tencent/youtu/android/rapidnet/SuperresolutionLib;Landroid/graphics/Bitmap;FF)I
    //   167: istore 5
    //   169: aload 10
    //   171: astore 9
    //   173: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   176: ldc 138
    //   178: ldc_w 393
    //   181: ldc_w 395
    //   184: iload 5
    //   186: invokevirtual 146	com/tencent/component/media/ImageManagerEnv:reportImageTimeCostMTA	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   189: iconst_m1
    //   190: istore 7
    //   192: aload 10
    //   194: astore 9
    //   196: aload 10
    //   198: invokevirtual 398	com/tencent/youtu/android/rapidnet/SuperresolutionLib:isGPUSupportOpenCL	()Z
    //   201: ifeq +781 -> 982
    //   204: aload 10
    //   206: astore 9
    //   208: aload 10
    //   210: aload 11
    //   212: fload_3
    //   213: fconst_1
    //   214: invokestatic 391	com/tencent/component/media/utils/RapidNetUtils:a	(Lcom/tencent/youtu/android/rapidnet/SuperresolutionLib;Landroid/graphics/Bitmap;FF)I
    //   217: istore 6
    //   219: aload 10
    //   221: astore 9
    //   223: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   226: ldc 138
    //   228: ldc_w 393
    //   231: ldc_w 400
    //   234: iload 6
    //   236: invokevirtual 146	com/tencent/component/media/ImageManagerEnv:reportImageTimeCostMTA	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   239: aload 10
    //   241: astore 9
    //   243: fconst_1
    //   244: iload 5
    //   246: i2f
    //   247: fmul
    //   248: iload 5
    //   250: iload 6
    //   252: iadd
    //   253: i2f
    //   254: fdiv
    //   255: fstore_2
    //   256: aload 10
    //   258: astore 9
    //   260: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   263: invokevirtual 404	com/tencent/component/media/ImageManagerEnv:getSuperResolutionGpuRatioBoundary	()Landroid/util/Pair;
    //   266: astore 12
    //   268: ldc_w 405
    //   271: fstore_1
    //   272: ldc_w 406
    //   275: fstore_0
    //   276: aload 12
    //   278: ifnull +716 -> 994
    //   281: aload 10
    //   283: astore 9
    //   285: aload 12
    //   287: getfield 161	android/util/Pair:first	Ljava/lang/Object;
    //   290: checkcast 408	java/lang/Float
    //   293: invokevirtual 412	java/lang/Float:floatValue	()F
    //   296: fstore_1
    //   297: aload 10
    //   299: astore 9
    //   301: aload 12
    //   303: getfield 156	android/util/Pair:second	Ljava/lang/Object;
    //   306: checkcast 408	java/lang/Float
    //   309: invokevirtual 412	java/lang/Float:floatValue	()F
    //   312: fstore_0
    //   313: goto +681 -> 994
    //   316: aload 10
    //   318: astore 9
    //   320: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   323: ldc 50
    //   325: iconst_1
    //   326: anewarray 4	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: new 52	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   338: ldc_w 414
    //   341: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: iload 5
    //   346: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   349: ldc_w 416
    //   352: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: iload 6
    //   357: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   360: ldc_w 418
    //   363: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: fload_0
    //   367: invokevirtual 421	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   370: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   373: aastore
    //   374: invokeinterface 123 3 0
    //   379: iload 5
    //   381: iload 6
    //   383: if_icmpge +400 -> 783
    //   386: iload 5
    //   388: istore 4
    //   390: fload_0
    //   391: fconst_0
    //   392: fcmpl
    //   393: ifle +586 -> 979
    //   396: fload_0
    //   397: fconst_1
    //   398: fcmpg
    //   399: ifge +580 -> 979
    //   402: aload 10
    //   404: astore 9
    //   406: aload 10
    //   408: aload 11
    //   410: fload_3
    //   411: fload_0
    //   412: invokestatic 391	com/tencent/component/media/utils/RapidNetUtils:a	(Lcom/tencent/youtu/android/rapidnet/SuperresolutionLib;Landroid/graphics/Bitmap;FF)I
    //   415: istore 7
    //   417: aload 10
    //   419: astore 9
    //   421: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   424: ldc 50
    //   426: iconst_1
    //   427: anewarray 4	java/lang/Object
    //   430: dup
    //   431: iconst_0
    //   432: new 52	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   439: ldc_w 423
    //   442: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: iload 7
    //   447: invokevirtual 62	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   450: ldc_w 425
    //   453: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: fload_0
    //   457: invokevirtual 421	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   460: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: aastore
    //   464: invokeinterface 123 3 0
    //   469: iload 4
    //   471: iload 7
    //   473: if_icmpge +317 -> 790
    //   476: aload 10
    //   478: astore 9
    //   480: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   483: ldc 138
    //   485: ldc_w 393
    //   488: ldc_w 427
    //   491: iload 7
    //   493: invokevirtual 146	com/tencent/component/media/ImageManagerEnv:reportImageTimeCostMTA	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   496: aload 10
    //   498: astore 9
    //   500: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   503: fload_0
    //   504: invokevirtual 431	com/tencent/component/media/ImageManagerEnv:saveSuperResolutionGpuPercent	(F)V
    //   507: aload 10
    //   509: astore 9
    //   511: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   514: ldc 138
    //   516: ldc_w 393
    //   519: ldc_w 433
    //   522: iload 4
    //   524: invokevirtual 146	com/tencent/component/media/ImageManagerEnv:reportImageTimeCostMTA	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   527: aload 10
    //   529: astore 9
    //   531: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   534: ldc 138
    //   536: ldc_w 393
    //   539: ldc_w 435
    //   542: ldc_w 436
    //   545: fload_0
    //   546: fmul
    //   547: f2i
    //   548: invokevirtual 146	com/tencent/component/media/ImageManagerEnv:reportImageTimeCostMTA	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   551: aload 10
    //   553: astore 9
    //   555: new 438	java/util/HashMap
    //   558: dup
    //   559: invokespecial 439	java/util/HashMap:<init>	()V
    //   562: astore 11
    //   564: aload 10
    //   566: astore 9
    //   568: aload 11
    //   570: ldc_w 441
    //   573: getstatic 447	android/os/Build:MODEL	Ljava/lang/String;
    //   576: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   579: pop
    //   580: aload 10
    //   582: astore 9
    //   584: aload 11
    //   586: ldc_w 453
    //   589: getstatic 458	android/os/Build$VERSION:SDK_INT	I
    //   592: invokestatic 208	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   595: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   598: pop
    //   599: aload 10
    //   601: astore 9
    //   603: aload 11
    //   605: ldc_w 460
    //   608: iconst_0
    //   609: invokestatic 463	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   612: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   615: pop
    //   616: aload 10
    //   618: astore 9
    //   620: aload 11
    //   622: ldc_w 465
    //   625: iload 8
    //   627: invokestatic 208	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   630: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   633: pop
    //   634: aload 10
    //   636: astore 9
    //   638: aload 11
    //   640: ldc_w 433
    //   643: iload 4
    //   645: invokestatic 208	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   648: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   651: pop
    //   652: aload 10
    //   654: astore 9
    //   656: aload 11
    //   658: ldc_w 395
    //   661: iload 5
    //   663: invokestatic 208	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   666: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   669: pop
    //   670: iload 6
    //   672: ifle +21 -> 693
    //   675: aload 10
    //   677: astore 9
    //   679: aload 11
    //   681: ldc_w 400
    //   684: iload 6
    //   686: invokestatic 208	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   689: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   692: pop
    //   693: iload 7
    //   695: ifle +21 -> 716
    //   698: aload 10
    //   700: astore 9
    //   702: aload 11
    //   704: ldc_w 427
    //   707: iload 7
    //   709: invokestatic 208	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   712: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   715: pop
    //   716: aload 10
    //   718: astore 9
    //   720: aload 11
    //   722: ldc_w 467
    //   725: fload_0
    //   726: invokestatic 470	java/lang/String:valueOf	(F)Ljava/lang/String;
    //   729: invokevirtual 451	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   732: pop
    //   733: aload 10
    //   735: astore 9
    //   737: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   740: ldc_w 472
    //   743: aload 11
    //   745: invokevirtual 476	com/tencent/component/media/ImageManagerEnv:statisticCollectorReport	(Ljava/lang/String;Ljava/util/HashMap;)V
    //   748: iload 4
    //   750: istore 5
    //   752: aload 10
    //   754: ifnull -735 -> 19
    //   757: aload 10
    //   759: invokevirtual 134	com/tencent/youtu/android/rapidnet/SuperresolutionLib:destroy	()V
    //   762: iload 4
    //   764: ireturn
    //   765: astore 9
    //   767: iload 4
    //   769: ireturn
    //   770: fload_2
    //   771: fstore_0
    //   772: fload_2
    //   773: fload_1
    //   774: fcmpl
    //   775: iflt -459 -> 316
    //   778: fconst_1
    //   779: fstore_0
    //   780: goto -464 -> 316
    //   783: iload 6
    //   785: istore 4
    //   787: goto -397 -> 390
    //   790: iload 7
    //   792: istore 4
    //   794: goto -318 -> 476
    //   797: astore 10
    //   799: aconst_null
    //   800: astore 9
    //   802: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   805: ldc 50
    //   807: iconst_1
    //   808: anewarray 4	java/lang/Object
    //   811: dup
    //   812: iconst_0
    //   813: new 52	java/lang/StringBuilder
    //   816: dup
    //   817: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   820: ldc_w 478
    //   823: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: aload 10
    //   828: invokestatic 179	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   831: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: aastore
    //   838: invokeinterface 80 3 0
    //   843: aload 9
    //   845: ifnull +8 -> 853
    //   848: aload 9
    //   850: invokevirtual 134	com/tencent/youtu/android/rapidnet/SuperresolutionLib:destroy	()V
    //   853: iconst_m1
    //   854: ireturn
    //   855: astore 11
    //   857: aconst_null
    //   858: astore 10
    //   860: aload 10
    //   862: astore 9
    //   864: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   867: ldc 50
    //   869: iconst_1
    //   870: anewarray 4	java/lang/Object
    //   873: dup
    //   874: iconst_0
    //   875: new 52	java/lang/StringBuilder
    //   878: dup
    //   879: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   882: ldc_w 480
    //   885: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   888: aload 11
    //   890: invokestatic 179	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   893: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   899: aastore
    //   900: invokeinterface 80 3 0
    //   905: aload 10
    //   907: ifnull -54 -> 853
    //   910: aload 10
    //   912: invokevirtual 134	com/tencent/youtu/android/rapidnet/SuperresolutionLib:destroy	()V
    //   915: goto -62 -> 853
    //   918: astore 9
    //   920: goto -67 -> 853
    //   923: astore 10
    //   925: aconst_null
    //   926: astore 9
    //   928: aload 9
    //   930: ifnull +8 -> 938
    //   933: aload 9
    //   935: invokevirtual 134	com/tencent/youtu/android/rapidnet/SuperresolutionLib:destroy	()V
    //   938: aload 10
    //   940: athrow
    //   941: astore 9
    //   943: goto -90 -> 853
    //   946: astore 9
    //   948: goto -10 -> 938
    //   951: astore 10
    //   953: goto -25 -> 928
    //   956: astore 10
    //   958: goto -30 -> 928
    //   961: astore 11
    //   963: goto -103 -> 860
    //   966: astore 11
    //   968: aload 10
    //   970: astore 9
    //   972: aload 11
    //   974: astore 10
    //   976: goto -174 -> 802
    //   979: goto -483 -> 496
    //   982: fconst_0
    //   983: fstore_0
    //   984: iconst_m1
    //   985: istore 6
    //   987: iload 5
    //   989: istore 4
    //   991: goto -495 -> 496
    //   994: fload_2
    //   995: fload_0
    //   996: fcmpg
    //   997: ifgt -227 -> 770
    //   1000: fconst_0
    //   1001: fstore_0
    //   1002: goto -686 -> 316
    // Local variable table:
    //   start	length	slot	name	signature
    //   275	727	0	f1	float
    //   271	503	1	f2	float
    //   255	740	2	f3	float
    //   153	258	3	f4	float
    //   388	602	4	i	int
    //   17	971	5	j	int
    //   217	769	6	k	int
    //   190	601	7	m	int
    //   53	573	8	n	int
    //   6	60	9	localObject1	Object
    //   112	17	9	localThrowable1	Throwable
    //   143	593	9	localObject2	Object
    //   765	1	9	localThrowable2	Throwable
    //   800	63	9	localObject3	Object
    //   918	1	9	localThrowable3	Throwable
    //   926	8	9	localObject4	Object
    //   941	1	9	localThrowable4	Throwable
    //   946	1	9	localThrowable5	Throwable
    //   970	1	9	localObject5	Object
    //   139	619	10	localSuperresolutionLib	SuperresolutionLib
    //   797	30	10	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   858	53	10	localObject6	Object
    //   923	16	10	localObject7	Object
    //   951	1	10	localObject8	Object
    //   956	13	10	localObject9	Object
    //   974	1	10	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   45	699	11	localObject10	Object
    //   855	34	11	localThrowable6	Throwable
    //   961	1	11	localThrowable7	Throwable
    //   966	7	11	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   266	36	12	localPair	Pair
    // Exception table:
    //   from	to	target	type
    //   104	112	112	java/lang/Throwable
    //   757	762	765	java/lang/Throwable
    //   22	65	797	java/lang/OutOfMemoryError
    //   70	97	797	java/lang/OutOfMemoryError
    //   116	141	797	java/lang/OutOfMemoryError
    //   22	65	855	java/lang/Throwable
    //   70	97	855	java/lang/Throwable
    //   116	141	855	java/lang/Throwable
    //   910	915	918	java/lang/Throwable
    //   22	65	923	finally
    //   70	97	923	finally
    //   116	141	923	finally
    //   848	853	941	java/lang/Throwable
    //   933	938	946	java/lang/Throwable
    //   145	154	951	finally
    //   158	169	951	finally
    //   173	189	951	finally
    //   196	204	951	finally
    //   208	219	951	finally
    //   223	239	951	finally
    //   243	256	951	finally
    //   260	268	951	finally
    //   285	297	951	finally
    //   301	313	951	finally
    //   320	379	951	finally
    //   406	417	951	finally
    //   421	469	951	finally
    //   480	496	951	finally
    //   500	507	951	finally
    //   511	527	951	finally
    //   531	551	951	finally
    //   555	564	951	finally
    //   568	580	951	finally
    //   584	599	951	finally
    //   603	616	951	finally
    //   620	634	951	finally
    //   638	652	951	finally
    //   656	670	951	finally
    //   679	693	951	finally
    //   702	716	951	finally
    //   720	733	951	finally
    //   737	748	951	finally
    //   864	905	951	finally
    //   802	843	956	finally
    //   145	154	961	java/lang/Throwable
    //   158	169	961	java/lang/Throwable
    //   173	189	961	java/lang/Throwable
    //   196	204	961	java/lang/Throwable
    //   208	219	961	java/lang/Throwable
    //   223	239	961	java/lang/Throwable
    //   243	256	961	java/lang/Throwable
    //   260	268	961	java/lang/Throwable
    //   285	297	961	java/lang/Throwable
    //   301	313	961	java/lang/Throwable
    //   320	379	961	java/lang/Throwable
    //   406	417	961	java/lang/Throwable
    //   421	469	961	java/lang/Throwable
    //   480	496	961	java/lang/Throwable
    //   500	507	961	java/lang/Throwable
    //   511	527	961	java/lang/Throwable
    //   531	551	961	java/lang/Throwable
    //   555	564	961	java/lang/Throwable
    //   568	580	961	java/lang/Throwable
    //   584	599	961	java/lang/Throwable
    //   603	616	961	java/lang/Throwable
    //   620	634	961	java/lang/Throwable
    //   638	652	961	java/lang/Throwable
    //   656	670	961	java/lang/Throwable
    //   679	693	961	java/lang/Throwable
    //   702	716	961	java/lang/Throwable
    //   720	733	961	java/lang/Throwable
    //   737	748	961	java/lang/Throwable
    //   145	154	966	java/lang/OutOfMemoryError
    //   158	169	966	java/lang/OutOfMemoryError
    //   173	189	966	java/lang/OutOfMemoryError
    //   196	204	966	java/lang/OutOfMemoryError
    //   208	219	966	java/lang/OutOfMemoryError
    //   223	239	966	java/lang/OutOfMemoryError
    //   243	256	966	java/lang/OutOfMemoryError
    //   260	268	966	java/lang/OutOfMemoryError
    //   285	297	966	java/lang/OutOfMemoryError
    //   301	313	966	java/lang/OutOfMemoryError
    //   320	379	966	java/lang/OutOfMemoryError
    //   406	417	966	java/lang/OutOfMemoryError
    //   421	469	966	java/lang/OutOfMemoryError
    //   480	496	966	java/lang/OutOfMemoryError
    //   500	507	966	java/lang/OutOfMemoryError
    //   511	527	966	java/lang/OutOfMemoryError
    //   531	551	966	java/lang/OutOfMemoryError
    //   555	564	966	java/lang/OutOfMemoryError
    //   568	580	966	java/lang/OutOfMemoryError
    //   584	599	966	java/lang/OutOfMemoryError
    //   603	616	966	java/lang/OutOfMemoryError
    //   620	634	966	java/lang/OutOfMemoryError
    //   638	652	966	java/lang/OutOfMemoryError
    //   656	670	966	java/lang/OutOfMemoryError
    //   679	693	966	java/lang/OutOfMemoryError
    //   702	716	966	java/lang/OutOfMemoryError
    //   720	733	966	java/lang/OutOfMemoryError
    //   737	748	966	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public static Bitmap superResolution(Bitmap paramBitmap, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   6: ldc 50
    //   8: iconst_1
    //   9: anewarray 4	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: ldc_w 483
    //   17: aastore
    //   18: invokeinterface 123 3 0
    //   23: aload_0
    //   24: ifnonnull +30 -> 54
    //   27: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   30: ldc 50
    //   32: iconst_1
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: ldc_w 485
    //   41: aastore
    //   42: invokeinterface 80 3 0
    //   47: aconst_null
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: areturn
    //   54: aload_0
    //   55: invokevirtual 488	android/graphics/Bitmap:isRecycled	()Z
    //   58: ifeq +28 -> 86
    //   61: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   64: ldc 50
    //   66: iconst_1
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: ldc_w 490
    //   75: aastore
    //   76: invokeinterface 80 3 0
    //   81: aconst_null
    //   82: astore_0
    //   83: goto -34 -> 49
    //   86: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   89: invokevirtual 493	com/tencent/component/media/ImageManagerEnv:checkSuperResolutionSo	()Z
    //   92: ifne +34 -> 126
    //   95: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   98: ldc 50
    //   100: iconst_1
    //   101: anewarray 4	java/lang/Object
    //   104: dup
    //   105: iconst_0
    //   106: ldc_w 495
    //   109: aastore
    //   110: invokeinterface 80 3 0
    //   115: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   118: invokevirtual 498	com/tencent/component/media/ImageManagerEnv:prepareSuperResolutionEnv	()V
    //   121: aconst_null
    //   122: astore_0
    //   123: goto -74 -> 49
    //   126: iload_1
    //   127: iconst_1
    //   128: invokestatic 500	com/tencent/component/media/utils/RapidNetUtils:a	(IZ)V
    //   131: getstatic 93	com/tencent/youtu/android/rapidnet/SuperresolutionLib:sLoadSuccess	Z
    //   134: ifne +28 -> 162
    //   137: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   140: ldc 50
    //   142: iconst_1
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: ldc_w 502
    //   151: aastore
    //   152: invokeinterface 80 3 0
    //   157: aconst_null
    //   158: astore_0
    //   159: goto -110 -> 49
    //   162: aload_0
    //   163: astore 8
    //   165: aload_0
    //   166: invokevirtual 506	android/graphics/Bitmap:getConfig	()Landroid/graphics/Bitmap$Config;
    //   169: getstatic 272	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   172: if_acmpeq +140 -> 312
    //   175: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   178: ldc 50
    //   180: iconst_1
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: ldc_w 508
    //   189: aastore
    //   190: invokeinterface 123 3 0
    //   195: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   198: lstore 6
    //   200: aload_0
    //   201: invokevirtual 509	android/graphics/Bitmap:getWidth	()I
    //   204: istore 4
    //   206: aload_0
    //   207: invokevirtual 510	android/graphics/Bitmap:getHeight	()I
    //   210: istore 5
    //   212: iload 4
    //   214: iload 5
    //   216: imul
    //   217: newarray int
    //   219: astore 8
    //   221: aload_0
    //   222: aload 8
    //   224: iconst_0
    //   225: iload 4
    //   227: iconst_0
    //   228: iconst_0
    //   229: iload 4
    //   231: iload 5
    //   233: invokevirtual 514	android/graphics/Bitmap:getPixels	([IIIIIII)V
    //   236: aload 8
    //   238: iload 4
    //   240: iload 5
    //   242: getstatic 272	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   245: invokestatic 517	android/graphics/Bitmap:createBitmap	([IIILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;
    //   248: astore 8
    //   250: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   253: lload 6
    //   255: lsub
    //   256: lstore 6
    //   258: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   261: ldc 50
    //   263: iconst_1
    //   264: anewarray 4	java/lang/Object
    //   267: dup
    //   268: iconst_0
    //   269: new 52	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   276: ldc_w 519
    //   279: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: lload 6
    //   284: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   287: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: aastore
    //   291: invokeinterface 123 3 0
    //   296: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   299: ldc 138
    //   301: ldc 140
    //   303: ldc_w 521
    //   306: lload 6
    //   308: l2i
    //   309: invokevirtual 146	com/tencent/component/media/ImageManagerEnv:reportImageTimeCostMTA	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   312: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   315: iload_1
    //   316: invokevirtual 389	com/tencent/component/media/ImageManagerEnv:getSuperResolutionScaleByModelId	(I)F
    //   319: fstore_2
    //   320: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   323: invokevirtual 524	com/tencent/component/media/ImageManagerEnv:getSuperResolutionGpuPercent	()F
    //   326: fstore_3
    //   327: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   330: ldc 50
    //   332: iconst_1
    //   333: anewarray 4	java/lang/Object
    //   336: dup
    //   337: iconst_0
    //   338: new 52	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   345: ldc_w 526
    //   348: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: fload_2
    //   352: invokevirtual 421	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   355: ldc_w 528
    //   358: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: fload_3
    //   362: invokevirtual 421	java/lang/StringBuilder:append	(F)Ljava/lang/StringBuilder;
    //   365: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   368: aastore
    //   369: invokeinterface 123 3 0
    //   374: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   377: lstore 6
    //   379: getstatic 105	com/tencent/component/media/utils/RapidNetUtils:jdField_a_of_type_ComTencentYoutuAndroidRapidnetSuperresolutionLib	Lcom/tencent/youtu/android/rapidnet/SuperresolutionLib;
    //   382: aload 8
    //   384: fload_2
    //   385: fload_3
    //   386: invokestatic 96	com/tencent/component/media/utils/RapidNetUtils:b	()I
    //   389: invokevirtual 100	com/tencent/youtu/android/rapidnet/SuperresolutionLib:superResolution	(Landroid/graphics/Bitmap;FFI)Landroid/graphics/Bitmap;
    //   392: astore_0
    //   393: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   396: ldc 50
    //   398: iconst_1
    //   399: anewarray 4	java/lang/Object
    //   402: dup
    //   403: iconst_0
    //   404: ldc_w 530
    //   407: aastore
    //   408: invokeinterface 123 3 0
    //   413: invokestatic 87	java/lang/System:currentTimeMillis	()J
    //   416: lload 6
    //   418: lsub
    //   419: lstore 6
    //   421: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   424: ldc 50
    //   426: iconst_1
    //   427: anewarray 4	java/lang/Object
    //   430: dup
    //   431: iconst_0
    //   432: new 52	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   439: ldc_w 532
    //   442: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: lload 6
    //   447: invokevirtual 120	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   450: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: aastore
    //   454: invokeinterface 123 3 0
    //   459: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   462: ldc 138
    //   464: ldc 140
    //   466: ldc_w 534
    //   469: lload 6
    //   471: l2i
    //   472: invokevirtual 146	com/tencent/component/media/ImageManagerEnv:reportImageTimeCostMTA	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   475: goto -426 -> 49
    //   478: astore_0
    //   479: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   482: ldc 50
    //   484: iconst_1
    //   485: anewarray 4	java/lang/Object
    //   488: dup
    //   489: iconst_0
    //   490: new 52	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 53	java/lang/StringBuilder:<init>	()V
    //   497: ldc_w 536
    //   500: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload_0
    //   504: invokevirtual 322	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   507: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: aastore
    //   514: invokeinterface 80 3 0
    //   519: aconst_null
    //   520: astore_0
    //   521: goto -472 -> 49
    //   524: astore_0
    //   525: ldc 2
    //   527: monitorexit
    //   528: aload_0
    //   529: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	paramBitmap	Bitmap
    //   0	530	1	paramInt	int
    //   319	66	2	f1	float
    //   326	60	3	f2	float
    //   204	35	4	i	int
    //   210	31	5	j	int
    //   198	272	6	l	long
    //   163	220	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   86	121	478	java/lang/Throwable
    //   126	157	478	java/lang/Throwable
    //   165	312	478	java/lang/Throwable
    //   312	475	478	java/lang/Throwable
    //   3	23	524	finally
    //   27	47	524	finally
    //   54	81	524	finally
    //   86	121	524	finally
    //   126	157	524	finally
    //   165	312	524	finally
    //   312	475	524	finally
    //   479	519	524	finally
  }
  
  public static Drawable superResolution(Context paramContext, Drawable paramDrawable, int paramInt)
  {
    if (paramDrawable == null) {
      return null;
    }
    paramDrawable = superResolution(drawableToBitmap(paramDrawable), paramInt);
    return new BitmapDrawable(paramContext.getResources(), paramDrawable);
  }
  
  public static Bitmap tintBitmap(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap == null) {
      return null;
    }
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap.getConfig());
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    localPaint.setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.MULTIPLY));
    localCanvas.drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return localBitmap;
  }
  
  /* Error */
  public static void tryInitLibrary()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   6: invokevirtual 577	com/tencent/component/media/ImageManagerEnv:isSuperResolutionEnvReady	()Z
    //   9: ifne +27 -> 36
    //   12: invokestatic 48	com/tencent/component/media/ImageManagerEnv:getLogger	()Lcom/tencent/component/media/ILog;
    //   15: ldc 50
    //   17: iconst_1
    //   18: anewarray 4	java/lang/Object
    //   21: dup
    //   22: iconst_0
    //   23: ldc_w 579
    //   26: aastore
    //   27: invokeinterface 123 3 0
    //   32: ldc 2
    //   34: monitorexit
    //   35: return
    //   36: invokestatic 581	com/tencent/component/media/utils/RapidNetUtils:hasInit	()Z
    //   39: ifne -7 -> 32
    //   42: invokestatic 111	com/tencent/component/media/ImageManagerEnv:g	()Lcom/tencent/component/media/ImageManagerEnv;
    //   45: invokevirtual 584	com/tencent/component/media/ImageManagerEnv:getSuperResolutionLastModelId	()I
    //   48: iconst_0
    //   49: invokestatic 500	com/tencent/component/media/utils/RapidNetUtils:a	(IZ)V
    //   52: goto -20 -> 32
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   55	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	32	55	finally
    //   36	52	55	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.utils.RapidNetUtils
 * JD-Core Version:    0.7.0.1
 */