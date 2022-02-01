import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class beyq
{
  public static int a;
  public static Bitmap.Config a;
  public static final Drawable a;
  public static File a;
  private static boolean a;
  public static int b;
  public static Bitmap.Config b;
  public static final Drawable b;
  public static int c;
  private static int d;
  private static int e;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.ARGB_8888;
    jdField_b_of_type_AndroidGraphicsBitmap$Config = Bitmap.Config.RGB_565;
    jdField_a_of_type_Int = 921600;
    jdField_b_of_type_Int = 45;
    c = 135;
    e = -1;
    jdField_a_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(0);
    jdField_b_of_type_AndroidGraphicsDrawableDrawable = new ColorDrawable(1073741824);
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    if (localBaseApplication != null)
    {
      jdField_b_of_type_Int = (int)bhmg.a(localBaseApplication, 45.0F);
      c = (int)bhmg.a(localBaseApplication, 135.0F);
      d = localBaseApplication.getResources().getDisplayMetrics().densityDpi;
    }
  }
  
  public static int a()
  {
    a();
    return e;
  }
  
  public static int a(String paramString)
  {
    return bhmq.b(paramString);
  }
  
  public static int a(String paramString, boolean paramBoolean)
  {
    int i = 65537;
    if ("chatthumb".equals(paramString)) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatImageDownloader", 2, "getFileSizeType protocol:" + paramString + ",output_type:" + i);
      }
      return i;
      if ("chatimg".equals(paramString))
      {
        if (paramBoolean) {
          i = 1;
        } else {
          i = 131075;
        }
      }
      else if ("chatraw".equals(paramString)) {
        i = 131075;
      }
    }
  }
  
  public static Bitmap a()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("static://CommonProgress");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = bhgm.a(BaseApplicationImpl.getContext().getResources(), 2130839409);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageHashMap != null)
        {
          BaseApplicationImpl.sImageHashMap.put("static://CommonProgress", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public static Drawable a()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("static://CommonFailedDrawable");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = bhgm.a(BaseApplicationImpl.getContext().getResources(), 2130838073);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageHashMap != null)
        {
          BaseApplicationImpl.sImageHashMap.put("static://CommonFailedDrawable", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
  
  public static Drawable a(int paramInt)
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get(String.valueOf(paramInt));
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = bhgm.a(BaseApplicationImpl.getContext().getResources(), paramInt);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageHashMap != null)
        {
          BaseApplicationImpl.sImageHashMap.put(String.valueOf(paramInt), localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
  
  public static URLDrawable a(azqr paramazqr, int paramInt)
  {
    return a(paramazqr, paramInt, null, null);
  }
  
  public static URLDrawable a(azqr paramazqr, int paramInt, String paramString, URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    boolean bool2 = true;
    if (paramazqr == null) {
      return null;
    }
    paramString = URLDrawable.getDrawable(a(paramazqr, paramInt, paramString), paramURLDrawableOptions);
    paramString.setTag(paramazqr);
    if (paramazqr.isSendFromLocal()) {}
    for (;;)
    {
      return paramString;
      if (!azqc.jdField_a_of_type_Boolean) {
        break;
      }
      paramString.setAutoDownload(true);
    }
    boolean bool3 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694443), "qqsetting_auto_receive_pic_key", true);
    boolean bool1 = bool2;
    if (bhnv.b(BaseApplication.getContext()) != 1) {
      if (!bool3) {
        break label102;
      }
    }
    label102:
    for (bool1 = bool2;; bool1 = false)
    {
      paramString.setAutoDownload(bool1);
      break;
    }
  }
  
  public static URLDrawable a(String paramString)
  {
    return a(paramString, 0, 0, null, null, false, 0.0F);
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2)
  {
    return a(paramString, paramInt1, paramInt2, null, null, false, 0.0F);
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramString, paramInt1, paramInt2, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable a(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean, float paramFloat)
  {
    try
    {
      paramDrawable1 = a(new URL(paramString), paramInt1, paramInt2, paramDrawable1, paramDrawable2, paramBoolean, paramFloat);
      return paramDrawable1;
    }
    catch (MalformedURLException paramDrawable1)
    {
      throw new IllegalArgumentException("illegal url format: " + paramString);
    }
  }
  
  public static URLDrawable a(String paramString, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramString, 0, 0, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL)
  {
    return a(paramURL, 0, 0, null, null, false, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, int paramInt1, int paramInt2)
  {
    return a(paramURL, paramInt1, paramInt2, null, null, false, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    return a(paramURL, paramInt1, paramInt2, paramDrawable1, paramDrawable2, paramBoolean, 0.0F);
  }
  
  public static URLDrawable a(URL paramURL, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean, float paramFloat)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = paramInt1;
    localURLDrawableOptions.mRequestHeight = paramInt2;
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    localURLDrawableOptions.mFailedDrawable = paramDrawable2;
    localURLDrawableOptions.mPlayGifImage = paramBoolean;
    localURLDrawableOptions.mGifRoundCorner = paramFloat;
    return URLDrawable.getDrawable(paramURL, localURLDrawableOptions);
  }
  
  public static URLDrawable a(URL paramURL, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    return a(paramURL, 0, 0, paramDrawable1, paramDrawable2, false, 0.0F);
  }
  
  private static String a(azpz paramazpz)
  {
    if (paramazpz == null) {
      return null;
    }
    switch (paramazpz.jdField_b_of_type_Int)
    {
    default: 
      return null;
    case 0: 
    case 1000: 
    case 1001: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1008: 
    case 1009: 
    case 1020: 
    case 1023: 
    case 1024: 
    case 10002: 
    case 10004: 
    case 10008: 
      return "C2C";
    case 1: 
      return "Troup";
    }
    return "Disscussion";
  }
  
  private static String a(azpz paramazpz, int paramInt)
  {
    if (paramInt == 65537) {}
    String str = null;
    if (paramInt == 65537) {
      str = "chatthumb";
    }
    for (;;)
    {
      switch (paramazpz.jdField_b_of_type_Int)
      {
      default: 
        return str;
        if (paramInt == 1) {
          str = "chatimg";
        } else if (paramInt == 131075) {
          str = "chatraw";
        }
        break;
      }
    }
    return "favimage";
  }
  
  public static URL a(azqd paramazqd, int paramInt, String paramString)
  {
    if (paramazqd == null) {
      return null;
    }
    String str1 = paramazqd.f;
    label48:
    String str2;
    if ((str1 != null) && (!"null".equals(str1)) && (!"".equals(str1)))
    {
      if (paramazqd.jdField_b_of_type_Boolean) {
        paramInt = 1;
      }
      if (paramString == null) {
        break label184;
      }
      str2 = str1;
      if (str1 != null) {}
    }
    for (;;)
    {
      try
      {
        str1 = "holyshit_" + System.currentTimeMillis();
        str2 = str1;
        if (QLog.isColorLevel())
        {
          QLog.e("URLDrawableHelper", 2, "getURL file == null" + paramazqd.toString());
          str2 = str1;
        }
        if (paramString == null) {
          break label207;
        }
        paramazqd = new URL(paramString, null, str2);
        return paramazqd;
      }
      catch (MalformedURLException paramazqd)
      {
        label184:
        QLog.e("URLDrawableHelper", 1, "getURL error ", paramazqd);
        return null;
      }
      if ((paramazqd.jdField_b_of_type_Int == 8000) && (paramInt == 65537))
      {
        if (bdku.a())
        {
          str1 = paramazqd.k;
          break;
        }
        str1 = paramazqd.h;
        break;
      }
      str1 = paramazqd.g;
      break;
      paramString = a(paramazqd, paramInt);
      break label48;
      label207:
      paramazqd = null;
    }
  }
  
  public static URL a(azqr paramazqr, int paramInt)
  {
    return a(paramazqr, paramInt, null);
  }
  
  public static URL a(azqr paramazqr, int paramInt, String paramString)
  {
    if (paramazqr == null) {
      return null;
    }
    if (paramazqr.isSendFromLocal()) {
      return a(paramazqr.getPicUploadInfo(), paramInt, paramString);
    }
    return a(paramazqr.getPicDownloadInfo(), paramInt, paramString);
  }
  
  public static URL a(azqt paramazqt, int paramInt, String paramString)
  {
    if (paramazqt == null) {
      return null;
    }
    if (paramazqt.d < 4) {}
    for (String str2 = a(paramazqt);; str2 = null)
    {
      String str3 = a(paramazqt, paramInt);
      if ((paramazqt.jdField_b_of_type_Int == 8000) && (paramInt == 65537)) {}
      for (String str1 = paramazqt.h;; str1 = "") {
        for (;;)
        {
          if (str1 != null) {}
          try
          {
            if (("".equals(str1)) && (QLog.isColorLevel())) {
              QLog.e("URLDrawableHelper", 2, "getURL file == null" + paramazqt.toString());
            }
            if (paramString != null)
            {
              paramazqt = new URL(paramString, str2, str1);
              return paramazqt;
              if ((paramazqt.f != null) && (!"".equals(paramazqt.f)))
              {
                str1 = paramazqt.f;
                continue;
              }
              if ((paramazqt.a != null) && (!"".equals(paramazqt.a)))
              {
                str1 = paramazqt.a;
                continue;
              }
              if ((paramazqt.g != null) && (!"".equals(paramazqt.g))) {
                str1 = paramazqt.g;
              }
            }
            else
            {
              if (str3 == null) {
                break;
              }
              paramazqt = new URL(str3, str2, str1);
              return paramazqt;
            }
          }
          catch (MalformedURLException paramazqt)
          {
            paramazqt.printStackTrace();
            return null;
          }
        }
      }
    }
  }
  
  public static URL a(String paramString, int paramInt)
  {
    String str = "chatimg";
    if (paramInt == 65537) {
      str = "chatthumb";
    }
    for (;;)
    {
      try
      {
        paramString = new URL(str, null, paramString);
        return paramString;
      }
      catch (MalformedURLException paramString)
      {
        paramString.printStackTrace();
      }
      if (paramInt == 1) {
        str = "chatimg";
      } else if (paramInt == 131075) {
        str = "chatraw";
      }
    }
    return null;
  }
  
  /* Error */
  public static void a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 377	beyq:jdField_a_of_type_Boolean	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +7 -> 15
    //   11: ldc 2
    //   13: monitorexit
    //   14: return
    //   15: invokestatic 382	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   18: getstatic 388	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:aio_config	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   21: invokevirtual 391	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   24: ldc_w 393
    //   27: invokevirtual 396	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   30: ldc_w 398
    //   33: invokevirtual 402	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   36: astore_2
    //   37: aload_2
    //   38: arraylength
    //   39: istore_0
    //   40: iload_0
    //   41: ifle +15 -> 56
    //   44: aload_2
    //   45: iconst_0
    //   46: aaload
    //   47: invokestatic 407	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   50: invokevirtual 410	java/lang/Integer:intValue	()I
    //   53: putstatic 37	beyq:e	I
    //   56: iconst_1
    //   57: putstatic 377	beyq:jdField_a_of_type_Boolean	Z
    //   60: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   63: ifeq -52 -> 11
    //   66: ldc_w 315
    //   69: iconst_2
    //   70: new 109	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 111	java/lang/StringBuilder:<init>	()V
    //   77: ldc_w 412
    //   80: invokevirtual 117	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: getstatic 37	beyq:e	I
    //   86: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 415	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: goto -84 -> 11
    //   98: astore_2
    //   99: ldc 2
    //   101: monitorexit
    //   102: aload_2
    //   103: athrow
    //   104: astore_2
    //   105: invokestatic 105	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +13 -> 121
    //   111: ldc_w 315
    //   114: iconst_2
    //   115: ldc_w 417
    //   118: invokestatic 415	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   121: iconst_m1
    //   122: putstatic 37	beyq:e	I
    //   125: goto -69 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   39	2	0	i	int
    //   6	2	1	bool	boolean
    //   36	9	2	arrayOfString	String[]
    //   98	5	2	localObject	Object
    //   104	1	2	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   3	7	98	finally
    //   15	40	98	finally
    //   44	56	98	finally
    //   56	95	98	finally
    //   105	121	98	finally
    //   121	125	98	finally
    //   44	56	104	java/lang/Exception
  }
  
  public static void a(URLDrawable paramURLDrawable, String paramString, boolean paramBoolean)
  {
    String str = paramURLDrawable.getURL().toString();
    if ((paramURLDrawable.getStatus() != 1) && (beqz.b(str))) {}
    try
    {
      paramURLDrawable.downloadImediatly();
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("URLDrawableHelper", 2, "downloadImediatly decode OOM,currentAccountUin=" + paramString + ",d.getURL=" + paramURLDrawable.getURL());
    }
  }
  
  public static boolean a()
  {
    return AppNetConnInfo.isMobileConn();
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool1 = AppNetConnInfo.isMobileConn();
    boolean bool2 = SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694443), "qqsetting_auto_receive_pic_key", true);
    return (bool1) && (!bool2);
  }
  
  public static boolean a(Context paramContext, azqr paramazqr, int paramInt)
  {
    return beqz.a(a(paramazqr, paramInt).toString()) != null;
  }
  
  public static Drawable b()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageHashMap != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageHashMap.get("static://CommonLoadingDrawable");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = bhgm.a(BaseApplicationImpl.getContext().getResources(), 2130838070);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageHashMap != null)
        {
          BaseApplicationImpl.sImageHashMap.put("static://CommonLoadingDrawable", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
  
  public static URLDrawable b(azqr paramazqr, int paramInt)
  {
    URLDrawable localURLDrawable = URLDrawable.getDrawable(a(paramazqr, 65537));
    localURLDrawable.setTargetDensity(d);
    int i;
    URL localURL;
    if (localURLDrawable.getStatus() == 1)
    {
      i = 1;
      localURL = a(paramazqr, paramInt);
      if (i == 0) {
        break label68;
      }
    }
    label68:
    for (localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, localURLDrawable, null, true);; localURLDrawable = URLDrawable.getDrawable(localURL, -1, -1, true))
    {
      localURLDrawable.setTargetDensity(d);
      localURLDrawable.setTag(paramazqr);
      return localURLDrawable;
      i = 0;
      break;
    }
  }
  
  public static boolean b(Context paramContext)
  {
    return SettingCloneUtil.readValue(BaseApplication.getContext(), null, BaseApplication.getContext().getString(2131694443), "qqsetting_auto_receive_pic_key", true);
  }
  
  public static Drawable c()
  {
    Bitmap localBitmap1 = null;
    if (BaseApplicationImpl.sImageCache != null) {
      localBitmap1 = (Bitmap)BaseApplicationImpl.sImageCache.get("static://CommonFailedDrawable_sticker");
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = bhgm.a(BaseApplicationImpl.getContext().getResources(), 2130844559);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (BaseApplicationImpl.sImageCache != null)
        {
          BaseApplicationImpl.sImageCache.put("static://CommonFailedDrawable_sticker", localBitmap1);
          localBitmap2 = localBitmap1;
        }
      }
    }
    if (localBitmap2 != null) {
      return new BitmapDrawable(localBitmap2);
    }
    return new ColorDrawable();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     beyq
 * JD-Core Version:    0.7.0.1
 */