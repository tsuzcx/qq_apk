import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.location.Location;
import android.media.ExifInterface;
import android.os.Build.VERSION;
import android.provider.MediaStore.Images.Media;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.JpegExifReader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.LocalMultiProcConfig;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

public class bhog
{
  private static long jdField_a_of_type_Long;
  private static bhog jdField_a_of_type_Bhog;
  static Map<Long, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "DISTINCT _data" };
  
  public static int a(String paramString)
  {
    try
    {
      int i = JpegExifReader.readOrientation(paramString);
      switch (i)
      {
      case 4: 
      case 5: 
      case 7: 
      default: 
        return 0;
      case 6: 
        return 90;
      case 3: 
        return 180;
      }
      return 270;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return 0;
  }
  
  private long a()
  {
    return LocalMultiProcConfig.getLong("LocalRecentPhotoCheckManager.new_photo_check_lasttime", 0L);
  }
  
  private static Cursor a(Context paramContext, int paramInt, long paramLong1, long paramLong2)
  {
    paramInt = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadPhotoChangeStrategy", 1);
    int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadPhotoMinSize", 300);
    long l = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadPhotoMaxSize", 20000) * 1024;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bucket_display_name");
    ((StringBuilder)localObject).append(" != 'Screenshots' ");
    ((StringBuilder)localObject).append(" and ");
    ((StringBuilder)localObject).append("_size");
    ((StringBuilder)localObject).append(">=");
    ((StringBuilder)localObject).append(i * 1024);
    if (paramInt == 1)
    {
      ((StringBuilder)localObject).append(" and ");
      ((StringBuilder)localObject).append("_size");
      ((StringBuilder)localObject).append("<=");
      ((StringBuilder)localObject).append(l);
    }
    ((StringBuilder)localObject).append(" and ");
    ((StringBuilder)localObject).append("date_modified");
    ((StringBuilder)localObject).append(">=");
    ((StringBuilder)localObject).append(paramLong1 / 1000L);
    ((StringBuilder)localObject).append(" and ");
    ((StringBuilder)localObject).append("date_modified");
    ((StringBuilder)localObject).append(" <= ");
    ((StringBuilder)localObject).append(paramLong2 / 1000L);
    localObject = ((StringBuilder)localObject).toString();
    try
    {
      paramContext = paramContext.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, jdField_a_of_type_ArrayOfJavaLangString, (String)localObject, null, "date_modified DESC LIMIT 0,50");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  @TargetApi(11)
  public static Bitmap a(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, Bitmap paramBitmap)
  {
    if ((paramString == null) || ("".equals(paramString)) || (paramString.length() <= 0)) {}
    while ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists())) {
      return null;
    }
    for (;;)
    {
      try
      {
        localOptions = new BitmapFactory.Options();
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap = null;
        System.gc();
        try
        {
          paramString = BitmapFactory.decodeFile(paramString, paramBitmap);
          return paramString;
        }
        catch (Throwable paramString)
        {
          QLog.i("PhotoUtils", 1, "decodeBitmapFromFile happen exception");
          System.gc();
          return null;
        }
      }
      try
      {
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(paramString, localOptions);
        localOptions.inJustDecodeBounds = false;
        if ((paramInt1 == 0) || (paramInt2 == 0)) {
          break label219;
        }
        if (!paramBoolean) {
          continue;
        }
        paramInt1 = Math.max(localOptions.outWidth / paramInt1, localOptions.outHeight / paramInt2);
      }
      catch (Throwable paramBitmap)
      {
        paramBitmap = localOptions;
        continue;
        paramInt1 = 1;
        continue;
      }
      localOptions.inSampleSize = paramInt1;
      localOptions.inMutable = true;
      if ((Build.VERSION.SDK_INT >= 11) && (paramBitmap != null)) {
        localOptions.inBitmap = paramBitmap;
      }
      return BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream(paramString), 4096), null, localOptions);
      paramInt1 = Math.min(localOptions.outWidth / paramInt1, localOptions.outHeight / paramInt2);
    }
  }
  
  public static Bitmap a(String paramString, Bitmap paramBitmap)
  {
    return a(paramString, 0, 0, false, paramBitmap);
  }
  
  public static ExifInterface a(String paramString)
  {
    try
    {
      if (!JpegExifReader.isCrashJpeg(paramString))
      {
        paramString = new ExifInterface(paramString);
        return paramString;
      }
      return null;
    }
    catch (IOException paramString) {}
    return null;
  }
  
  public static bhog a()
  {
    if (jdField_a_of_type_Bhog == null) {}
    try
    {
      if (jdField_a_of_type_Bhog == null) {
        jdField_a_of_type_Bhog = new bhog();
      }
      return jdField_a_of_type_Bhog;
    }
    finally {}
  }
  
  public static String a(double paramDouble)
  {
    String[] arrayOfString = Location.convert(Math.abs(paramDouble), 2).split(":");
    Object localObject = arrayOfString[2].split("\\.");
    if (localObject.length == 0) {}
    for (localObject = arrayOfString[2];; localObject = localObject[0]) {
      return arrayOfString[0] + "/1," + arrayOfString[1] + "/1," + (String)localObject + "/1";
    }
  }
  
  /* Error */
  public static ArrayList<String> a(Context paramContext, int paramInt1, long paramLong1, long paramLong2, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: lload_2
    //   3: lload 4
    //   5: invokestatic 267	bhog:a	(Landroid/content/Context;IJJ)Landroid/database/Cursor;
    //   8: astore_0
    //   9: aload_0
    //   10: invokeinterface 272 1 0
    //   15: istore_1
    //   16: iload_1
    //   17: ifle +370 -> 387
    //   20: new 274	java/util/ArrayList
    //   23: dup
    //   24: iload_1
    //   25: invokespecial 277	java/util/ArrayList:<init>	(I)V
    //   28: astore 9
    //   30: aload_0
    //   31: ldc_w 279
    //   34: invokeinterface 282 2 0
    //   39: istore_1
    //   40: new 274	java/util/ArrayList
    //   43: dup
    //   44: invokespecial 283	java/util/ArrayList:<init>	()V
    //   47: astore 8
    //   49: iload 7
    //   51: tableswitch	default:+342 -> 393, 0:+179->230, 1:+190->241, 2:+201->252
    //   77: nop
    //   78: fstore 18
    //   80: astore 18
    //   82: istore_1
    //   83: iconst_1
    //   84: invokevirtual 64	common/config/service/QzoneConfig:getConfig	(Ljava/lang/String;Ljava/lang/String;I)I
    //   87: istore 7
    //   89: aload_0
    //   90: invokeinterface 286 1 0
    //   95: ifeq +285 -> 380
    //   98: aload_0
    //   99: iload_1
    //   100: invokeinterface 290 2 0
    //   105: astore 10
    //   107: aload 10
    //   109: ifnull -20 -> 89
    //   112: aload 8
    //   114: aload 10
    //   116: invokeinterface 295 2 0
    //   121: ifne -32 -> 89
    //   124: new 145	java/io/File
    //   127: dup
    //   128: aload 10
    //   130: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   133: astore 11
    //   135: aload 11
    //   137: ifnull -48 -> 89
    //   140: aload 11
    //   142: invokevirtual 152	java/io/File:exists	()Z
    //   145: ifeq -56 -> 89
    //   148: aload 11
    //   150: invokevirtual 298	java/io/File:isDirectory	()Z
    //   153: ifne -64 -> 89
    //   156: iload 7
    //   158: ifne +14 -> 172
    //   161: aload 10
    //   163: invokestatic 300	bhog:a	(Ljava/lang/String;)Landroid/media/ExifInterface;
    //   166: invokestatic 303	bhog:a	(Landroid/media/ExifInterface;)Z
    //   169: ifeq -80 -> 89
    //   172: aload 9
    //   174: aload 10
    //   176: invokevirtual 306	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   179: pop
    //   180: aload 9
    //   182: invokevirtual 309	java/util/ArrayList:size	()I
    //   185: iload 6
    //   187: if_icmplt -98 -> 89
    //   190: invokestatic 312	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   193: ifeq +187 -> 380
    //   196: ldc 215
    //   198: iconst_4
    //   199: ldc_w 314
    //   202: invokestatic 317	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   205: aload 9
    //   207: astore 8
    //   209: aload 8
    //   211: astore 9
    //   213: aload_0
    //   214: ifnull +13 -> 227
    //   217: aload_0
    //   218: invokeinterface 320 1 0
    //   223: aload 8
    //   225: astore 9
    //   227: aload 9
    //   229: areturn
    //   230: ldc_w 322
    //   233: invokestatic 327	bhoz:a	(Ljava/lang/String;)Ljava/util/List;
    //   236: astore 8
    //   238: goto -162 -> 76
    //   241: ldc_w 329
    //   244: invokestatic 327	bhoz:a	(Ljava/lang/String;)Ljava/util/List;
    //   247: astore 8
    //   249: goto -173 -> 76
    //   252: ldc_w 331
    //   255: invokestatic 327	bhoz:a	(Ljava/lang/String;)Ljava/util/List;
    //   258: astore 8
    //   260: goto -184 -> 76
    //   263: astore_0
    //   264: aload_0
    //   265: invokevirtual 38	java/lang/Exception:printStackTrace	()V
    //   268: aload 8
    //   270: areturn
    //   271: astore 9
    //   273: aconst_null
    //   274: astore_0
    //   275: aconst_null
    //   276: astore 8
    //   278: aload 9
    //   280: invokevirtual 38	java/lang/Exception:printStackTrace	()V
    //   283: aload_0
    //   284: astore 9
    //   286: aload 8
    //   288: ifnull -61 -> 227
    //   291: aload 8
    //   293: invokeinterface 320 1 0
    //   298: aload_0
    //   299: areturn
    //   300: astore 8
    //   302: aload 8
    //   304: invokevirtual 38	java/lang/Exception:printStackTrace	()V
    //   307: aload_0
    //   308: areturn
    //   309: astore 8
    //   311: aconst_null
    //   312: astore_0
    //   313: aload_0
    //   314: ifnull +9 -> 323
    //   317: aload_0
    //   318: invokeinterface 320 1 0
    //   323: aload 8
    //   325: athrow
    //   326: astore_0
    //   327: aload_0
    //   328: invokevirtual 38	java/lang/Exception:printStackTrace	()V
    //   331: goto -8 -> 323
    //   334: astore 8
    //   336: goto -23 -> 313
    //   339: astore 9
    //   341: aload 8
    //   343: astore_0
    //   344: aload 9
    //   346: astore 8
    //   348: goto -35 -> 313
    //   351: astore 9
    //   353: aconst_null
    //   354: astore 10
    //   356: aload_0
    //   357: astore 8
    //   359: aload 10
    //   361: astore_0
    //   362: goto -84 -> 278
    //   365: astore 10
    //   367: aload_0
    //   368: astore 8
    //   370: aload 9
    //   372: astore_0
    //   373: aload 10
    //   375: astore 9
    //   377: goto -99 -> 278
    //   380: aload 9
    //   382: astore 8
    //   384: goto -175 -> 209
    //   387: aconst_null
    //   388: astore 8
    //   390: goto -181 -> 209
    //   393: goto -317 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	396	0	paramContext	Context
    //   0	396	1	paramInt1	int
    //   0	396	2	paramLong1	long
    //   0	396	4	paramLong2	long
    //   0	396	6	paramInt2	int
    //   0	396	7	paramInt3	int
    //   47	245	8	localObject1	Object
    //   300	3	8	localException1	Exception
    //   309	15	8	localObject2	Object
    //   334	8	8	localObject3	Object
    //   346	43	8	localObject4	Object
    //   28	200	9	localObject5	Object
    //   271	8	9	localException2	Exception
    //   284	1	9	localContext	Context
    //   339	6	9	localObject6	Object
    //   351	20	9	localException3	Exception
    //   375	6	9	localObject7	Object
    //   105	255	10	str	String
    //   365	9	10	localException4	Exception
    //   133	16	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   217	223	263	java/lang/Exception
    //   0	9	271	java/lang/Exception
    //   291	298	300	java/lang/Exception
    //   0	9	309	finally
    //   317	323	326	java/lang/Exception
    //   9	16	334	finally
    //   20	30	334	finally
    //   30	49	334	finally
    //   76	89	334	finally
    //   89	107	334	finally
    //   112	135	334	finally
    //   140	156	334	finally
    //   161	172	334	finally
    //   172	205	334	finally
    //   230	238	334	finally
    //   241	249	334	finally
    //   252	260	334	finally
    //   278	283	339	finally
    //   9	16	351	java/lang/Exception
    //   20	30	351	java/lang/Exception
    //   30	49	365	java/lang/Exception
    //   76	89	365	java/lang/Exception
    //   89	107	365	java/lang/Exception
    //   112	135	365	java/lang/Exception
    //   140	156	365	java/lang/Exception
    //   161	172	365	java/lang/Exception
    //   172	205	365	java/lang/Exception
    //   230	238	365	java/lang/Exception
    //   241	249	365	java/lang/Exception
    //   252	260	365	java/lang/Exception
  }
  
  public static void a()
  {
    if (jdField_a_of_type_JavaUtilMap != null) {
      jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public static boolean a()
  {
    jdField_a_of_type_Long = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
    int i;
    if (jdField_a_of_type_JavaUtilMap.get(Long.valueOf(jdField_a_of_type_Long)) != null) {
      i = ((Integer)jdField_a_of_type_JavaUtilMap.get(Long.valueOf(jdField_a_of_type_Long))).intValue();
    }
    while ((i & 0x2) != 0)
    {
      return true;
      i = LocalMultiProcConfig.getInt4Uin("qzone_feed_gray_mask", 1, jdField_a_of_type_Long);
      jdField_a_of_type_JavaUtilMap.put(Long.valueOf(jdField_a_of_type_Long), Integer.valueOf(i));
    }
    return false;
  }
  
  /* Error */
  public static boolean a(Bitmap paramBitmap, String paramString, android.graphics.Bitmap.CompressFormat paramCompressFormat, int paramInt, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 145	java/io/File
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 148	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_1
    //   9: aload_1
    //   10: invokevirtual 152	java/io/File:exists	()Z
    //   13: ifne +8 -> 21
    //   16: aload_1
    //   17: invokevirtual 387	java/io/File:createNewFile	()Z
    //   20: pop
    //   21: new 389	java/io/BufferedOutputStream
    //   24: dup
    //   25: new 391	java/io/FileOutputStream
    //   28: dup
    //   29: aload_1
    //   30: invokespecial 394	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   33: invokespecial 397	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   36: astore 7
    //   38: aload 7
    //   40: astore_1
    //   41: aload_0
    //   42: aload_2
    //   43: iload_3
    //   44: aload 7
    //   46: invokevirtual 403	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   49: istore 5
    //   51: aload 7
    //   53: astore_1
    //   54: aload 7
    //   56: invokevirtual 406	java/io/BufferedOutputStream:flush	()V
    //   59: iload 4
    //   61: ifeq +10 -> 71
    //   64: aload 7
    //   66: astore_1
    //   67: aload_0
    //   68: invokevirtual 409	android/graphics/Bitmap:recycle	()V
    //   71: iload 5
    //   73: istore 6
    //   75: aload 7
    //   77: ifnull +12 -> 89
    //   80: aload 7
    //   82: invokevirtual 410	java/io/BufferedOutputStream:close	()V
    //   85: iload 5
    //   87: istore 6
    //   89: iload 6
    //   91: ireturn
    //   92: astore 7
    //   94: ldc 215
    //   96: iconst_1
    //   97: ldc_w 412
    //   100: aload 7
    //   102: invokestatic 416	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   105: goto -84 -> 21
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 417	java/io/IOException:printStackTrace	()V
    //   113: iload 5
    //   115: ireturn
    //   116: astore_0
    //   117: aconst_null
    //   118: astore_2
    //   119: iconst_0
    //   120: istore 4
    //   122: aload_2
    //   123: astore_1
    //   124: ldc 215
    //   126: iconst_1
    //   127: ldc_w 419
    //   130: aload_0
    //   131: invokestatic 416	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   134: iload 4
    //   136: istore 6
    //   138: aload_2
    //   139: ifnull -50 -> 89
    //   142: aload_2
    //   143: invokevirtual 410	java/io/BufferedOutputStream:close	()V
    //   146: iload 4
    //   148: ireturn
    //   149: astore_0
    //   150: aload_0
    //   151: invokevirtual 417	java/io/IOException:printStackTrace	()V
    //   154: iload 4
    //   156: ireturn
    //   157: astore_0
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_1
    //   161: ifnull +7 -> 168
    //   164: aload_1
    //   165: invokevirtual 410	java/io/BufferedOutputStream:close	()V
    //   168: aload_0
    //   169: athrow
    //   170: astore_1
    //   171: aload_1
    //   172: invokevirtual 417	java/io/IOException:printStackTrace	()V
    //   175: goto -7 -> 168
    //   178: astore_0
    //   179: goto -19 -> 160
    //   182: astore_0
    //   183: iconst_0
    //   184: istore 4
    //   186: aload 7
    //   188: astore_2
    //   189: goto -67 -> 122
    //   192: astore_0
    //   193: iload 5
    //   195: istore 4
    //   197: aload 7
    //   199: astore_2
    //   200: goto -78 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	paramBitmap	Bitmap
    //   0	203	1	paramString	String
    //   0	203	2	paramCompressFormat	android.graphics.Bitmap.CompressFormat
    //   0	203	3	paramInt	int
    //   0	203	4	paramBoolean	boolean
    //   49	145	5	bool1	boolean
    //   73	64	6	bool2	boolean
    //   36	45	7	localBufferedOutputStream	java.io.BufferedOutputStream
    //   92	106	7	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   16	21	92	java/lang/Exception
    //   80	85	108	java/io/IOException
    //   21	38	116	java/lang/Exception
    //   142	146	149	java/io/IOException
    //   21	38	157	finally
    //   164	168	170	java/io/IOException
    //   41	51	178	finally
    //   54	59	178	finally
    //   67	71	178	finally
    //   124	134	178	finally
    //   41	51	182	java/lang/Exception
    //   54	59	192	java/lang/Exception
    //   67	71	192	java/lang/Exception
  }
  
  private static boolean a(ExifInterface paramExifInterface)
  {
    if (paramExifInterface == null) {}
    do
    {
      return false;
      paramExifInterface = paramExifInterface.getAttribute("DateTime");
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "FDateTime:" + paramExifInterface);
      }
    } while (paramExifInterface == null);
    return true;
  }
  
  public static boolean c()
  {
    long l1 = QzoneConfig.getInstance().getConfig("PhotoUpload", "PhotoUploadGuideScanTimeInterval", 1) * 60 * 60 * 1000;
    long l2 = LocalMultiProcConfig.getLong("key_photo_guide_last_check", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, "KEY_PHOTO_GUIDE_LAST_CHECK get:" + l2);
    }
    if (l2 <= 0L) {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isOverLastCheck");
      }
    }
    do
    {
      return true;
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isOverLastCheck S-L:" + (System.currentTimeMillis() - l2));
      }
    } while ((System.currentTimeMillis() - l2 >= l1) || (System.currentTimeMillis() - l2 <= 0L));
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoUtils", 4, "isOverLastCheck false");
    }
    return false;
  }
  
  public static boolean d()
  {
    long l = LocalMultiProcConfig.getLong("key_photo_guide_enter_qzone_date", 0L);
    if (l <= 0L) {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "isCurrentDayInQzone false");
      }
    }
    do
    {
      return false;
      l = System.currentTimeMillis() - l;
      if ((l <= 86400000L) && (l > 0L)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.d("PhotoUtils", 4, "isCurrentDayInQzone false");
    return false;
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoUtils", 4, "isCurrentDayInQzone");
    }
    return true;
  }
  
  public static boolean e()
  {
    int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_album_photo_show_start_hour", 19);
    int j = QzoneConfig.getInstance().getConfig("PhotoUpload", "secondary_album_photo_show_end_hour", 22);
    int k = Calendar.getInstance().get(11);
    return (k >= i) && (k < j);
  }
  
  public boolean b()
  {
    if ((QzoneConfig.getInstance().getConfig("PhotoUpload", "GuideShowOpen", 7) & 0x4) == 0) {
      if (QLog.isDevelopLevel()) {
        QLog.d("PhotoUtils", 4, "showGuide == CLOSE");
      }
    }
    label178:
    ArrayList localArrayList;
    do
    {
      do
      {
        return false;
        int i = QzoneConfig.getInstance().getConfig("PhotoUpload", "ExposePhotoMinCount", 10);
        long l4 = QzoneConfig.getInstance().getConfig("PhotoUpload", "ExposePhotoTimeRange", 6) * 60 * 60 * 1000;
        long l3 = a();
        long l2 = System.currentTimeMillis();
        if (l3 != 0L)
        {
          l1 = l3;
          if (l2 >= l3) {}
        }
        else
        {
          l1 = l2;
        }
        if (l1 == l2) {}
        for (long l1 = l2 - l4;; l1 = Math.max(l1, l2 - l4))
        {
          if (l1 == l2 - l4) {
            break label178;
          }
          if (!QLog.isDevelopLevel()) {
            break;
          }
          QLog.d("PhotoUtils", 4, l4 + "秒以内");
          return false;
        }
        if (QLog.isDevelopLevel())
        {
          QLog.d("PhotoUtils", 4, "filterTime:" + l1);
          QLog.d("PhotoUtils", 4, "nowTime:" + l2);
        }
        localArrayList = a(BaseApplication.getContext(), 20480, l1, l2, i, 0);
        if ((localArrayList != null) && (localArrayList.size() >= i))
        {
          LocalMultiProcConfig.putLong("key_photo_guide_first_photo", new File((String)localArrayList.get(localArrayList.size() - 1)).lastModified());
          return true;
        }
        if (localArrayList != null) {
          break;
        }
      } while (!QLog.isDevelopLevel());
      QLog.d("PhotoUtils", 4, "no pics");
      return false;
    } while (!QLog.isDevelopLevel());
    QLog.d("PhotoUtils", 4, "pics count:" + localArrayList.size());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhog
 * JD-Core Version:    0.7.0.1
 */