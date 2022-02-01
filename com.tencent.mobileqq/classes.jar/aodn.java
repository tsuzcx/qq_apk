import android.content.Context;
import android.content.SharedPreferences;
import android.util.Xml;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResInfo;
import dov.com.qq.im.ae.download.AEResUtil;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public class aodn
{
  private static final Object a;
  public static boolean a;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  /* Error */
  public static byte a(String arg0)
  {
    // Byte code:
    //   0: iconst_4
    //   1: istore_2
    //   2: iconst_1
    //   3: putstatic 20	aodn:jdField_a_of_type_Boolean	Z
    //   6: new 22	java/io/File
    //   9: dup
    //   10: invokestatic 26	aodn:b	()Ljava/lang/String;
    //   13: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   16: astore 4
    //   18: aload 4
    //   20: invokevirtual 33	java/io/File:exists	()Z
    //   23: ifeq +40 -> 63
    //   26: aload 4
    //   28: invokestatic 39	com/tencent/mobileqq/filemanager/util/FileUtil:deleteFile	(Ljava/io/File;)Z
    //   31: istore_3
    //   32: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +28 -> 63
    //   38: ldc 46
    //   40: iconst_2
    //   41: new 48	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   48: ldc 51
    //   50: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: iload_3
    //   54: invokevirtual 58	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: aload_0
    //   64: invokestatic 67	aodn:a	()Ljava/lang/String;
    //   67: invokestatic 70	aodn:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: new 72	java/util/HashMap
    //   73: dup
    //   74: invokespecial 73	java/util/HashMap:<init>	()V
    //   77: astore 6
    //   79: getstatic 79	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   82: ldc 81
    //   84: iconst_4
    //   85: invokevirtual 85	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   88: invokeinterface 91 1 0
    //   93: astore 5
    //   95: new 22	java/io/File
    //   98: dup
    //   99: new 48	java/lang/StringBuilder
    //   102: dup
    //   103: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   106: invokestatic 67	aodn:a	()Ljava/lang/String;
    //   109: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc 93
    //   114: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   123: astore 4
    //   125: aload 4
    //   127: invokevirtual 33	java/io/File:exists	()Z
    //   130: ifeq +375 -> 505
    //   133: aconst_null
    //   134: astore_0
    //   135: aload 4
    //   137: invokestatic 99	com/tencent/mobileqq/utils/FileUtils:readFileToString	(Ljava/io/File;)Ljava/lang/String;
    //   140: astore 4
    //   142: aload 4
    //   144: astore_0
    //   145: aload_0
    //   146: ifnull +338 -> 484
    //   149: aload_0
    //   150: aload 6
    //   152: invokestatic 102	aodn:a	(Ljava/lang/String;Ljava/util/HashMap;)Z
    //   155: ifeq +329 -> 484
    //   158: getstatic 14	aodn:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   161: astore_0
    //   162: aload_0
    //   163: monitorenter
    //   164: aload 6
    //   166: invokevirtual 106	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   169: invokeinterface 112 1 0
    //   174: astore 4
    //   176: aload 4
    //   178: invokeinterface 117 1 0
    //   183: ifeq +341 -> 524
    //   186: aload 4
    //   188: invokeinterface 121 1 0
    //   193: checkcast 123	java/util/Map$Entry
    //   196: astore 6
    //   198: new 48	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   205: invokestatic 67	aodn:a	()Ljava/lang/String;
    //   208: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 125
    //   213: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload 6
    //   218: invokeinterface 128 1 0
    //   223: checkcast 130	java/lang/String
    //   226: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: ldc 132
    //   231: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: astore 8
    //   239: new 22	java/io/File
    //   242: dup
    //   243: aload 8
    //   245: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   248: astore 7
    //   250: aload 7
    //   252: invokevirtual 33	java/io/File:exists	()Z
    //   255: ifeq +224 -> 479
    //   258: aload 8
    //   260: invokestatic 137	ayja:a	(Ljava/lang/String;)Ljava/lang/String;
    //   263: astore 8
    //   265: aload 6
    //   267: invokeinterface 140 1 0
    //   272: checkcast 130	java/lang/String
    //   275: aload 8
    //   277: invokevirtual 144	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   280: ifne +85 -> 365
    //   283: aload 7
    //   285: invokevirtual 147	java/io/File:delete	()Z
    //   288: pop
    //   289: iconst_2
    //   290: istore_1
    //   291: aload 5
    //   293: invokeinterface 152 1 0
    //   298: pop
    //   299: aload_0
    //   300: monitorexit
    //   301: iconst_0
    //   302: putstatic 20	aodn:jdField_a_of_type_Boolean	Z
    //   305: iload_1
    //   306: ireturn
    //   307: astore_0
    //   308: iconst_0
    //   309: putstatic 20	aodn:jdField_a_of_type_Boolean	Z
    //   312: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +31 -> 346
    //   318: ldc 46
    //   320: iconst_2
    //   321: new 48	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   328: ldc 154
    //   330: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   333: aload_0
    //   334: invokevirtual 157	java/io/IOException:getMessage	()Ljava/lang/String;
    //   337: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   343: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   346: invokestatic 67	aodn:a	()Ljava/lang/String;
    //   349: iconst_0
    //   350: invokestatic 160	com/tencent/mobileqq/utils/FileUtils:delete	(Ljava/lang/String;Z)V
    //   353: iconst_m1
    //   354: ireturn
    //   355: astore 4
    //   357: aload 4
    //   359: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   362: goto -217 -> 145
    //   365: aload 5
    //   367: new 48	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   374: ldc 165
    //   376: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: aload 6
    //   381: invokeinterface 128 1 0
    //   386: checkcast 130	java/lang/String
    //   389: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: aload 6
    //   397: invokeinterface 140 1 0
    //   402: checkcast 130	java/lang/String
    //   405: invokeinterface 169 3 0
    //   410: pop
    //   411: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq -238 -> 176
    //   417: ldc 46
    //   419: iconst_2
    //   420: new 48	java/lang/StringBuilder
    //   423: dup
    //   424: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   427: ldc 171
    //   429: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload 6
    //   434: invokeinterface 128 1 0
    //   439: checkcast 130	java/lang/String
    //   442: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc 173
    //   447: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload 6
    //   452: invokeinterface 140 1 0
    //   457: checkcast 130	java/lang/String
    //   460: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   466: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   469: goto -293 -> 176
    //   472: astore 4
    //   474: aload_0
    //   475: monitorexit
    //   476: aload 4
    //   478: athrow
    //   479: iconst_3
    //   480: istore_1
    //   481: goto -190 -> 291
    //   484: iload_2
    //   485: istore_1
    //   486: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq -188 -> 301
    //   492: ldc 46
    //   494: iconst_2
    //   495: ldc 175
    //   497: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   500: iload_2
    //   501: istore_1
    //   502: goto -201 -> 301
    //   505: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq +11 -> 519
    //   511: ldc 46
    //   513: iconst_2
    //   514: ldc 177
    //   516: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   519: iconst_0
    //   520: istore_1
    //   521: goto -220 -> 301
    //   524: iconst_0
    //   525: istore_1
    //   526: goto -235 -> 291
    // Local variable table:
    //   start	length	slot	name	signature
    //   290	236	1	b1	byte
    //   1	500	2	b2	byte
    //   31	23	3	bool	boolean
    //   16	171	4	localObject1	Object
    //   355	3	4	localIOException	java.io.IOException
    //   472	5	4	localObject2	Object
    //   93	273	5	localEditor	android.content.SharedPreferences.Editor
    //   77	374	6	localObject3	Object
    //   248	36	7	localFile	File
    //   237	39	8	str	String
    // Exception table:
    //   from	to	target	type
    //   63	70	307	java/io/IOException
    //   135	142	355	java/io/IOException
    //   164	176	472	finally
    //   176	289	472	finally
    //   291	301	472	finally
    //   365	469	472	finally
    //   474	476	472	finally
  }
  
  public static String a()
  {
    Object localObject = BaseApplicationImpl.sApplication.getFilesDir();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FaceScanNativeSoLoader", 2, "getFilesDir is null");
      }
      localObject = "";
    }
    String str;
    do
    {
      return localObject;
      str = localObject + "/pddata/prd/face_scan_so_v795";
      localObject = str;
    } while (!QLog.isColorLevel());
    QLog.i("FaceScanNativeSoLoader", 2, "getFaceLibPath ,path = " + str);
    return str;
  }
  
  public static String a(String paramString)
  {
    new StringBuilder().append(a()).append("/lib").append(paramString).append(".so").toString();
    String str = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("face_native_" + paramString, null);
    if (QLog.isColorLevel()) {
      QLog.i("FaceScanNativeSoLoader", 2, "getFaceSoMd5 ,soName = " + paramString + ",md5 = " + str);
    }
    return str;
  }
  
  /* Error */
  public static void a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 44	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +28 -> 33
    //   8: ldc 46
    //   10: iconst_2
    //   11: new 48	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   18: ldc 207
    //   20: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_0
    //   24: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: new 209	com/tencent/commonsdk/zip/QZipFile
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 210	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 214	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   48: astore 6
    //   50: sipush 8192
    //   53: newarray byte
    //   55: astore 7
    //   57: aload 6
    //   59: invokeinterface 219 1 0
    //   64: ifeq +332 -> 396
    //   67: aload 6
    //   69: invokeinterface 222 1 0
    //   74: checkcast 224	java/util/zip/ZipEntry
    //   77: astore 5
    //   79: aload 5
    //   81: invokevirtual 227	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: ifnull +412 -> 498
    //   89: aload_0
    //   90: ldc 229
    //   92: invokevirtual 233	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   95: ifeq +6 -> 101
    //   98: goto -41 -> 57
    //   101: new 48	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   108: aload_1
    //   109: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: getstatic 237	java/io/File:separator	Ljava/lang/String;
    //   115: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: aload_0
    //   119: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: astore_0
    //   126: aload 5
    //   128: invokevirtual 240	java/util/zip/ZipEntry:isDirectory	()Z
    //   131: ifeq +27 -> 158
    //   134: new 22	java/io/File
    //   137: dup
    //   138: aload_0
    //   139: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   142: astore_0
    //   143: aload_0
    //   144: invokevirtual 33	java/io/File:exists	()Z
    //   147: ifne +354 -> 501
    //   150: aload_0
    //   151: invokevirtual 243	java/io/File:mkdir	()Z
    //   154: pop
    //   155: goto +346 -> 501
    //   158: aload_0
    //   159: getstatic 237	java/io/File:separator	Ljava/lang/String;
    //   162: invokevirtual 247	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   165: istore_2
    //   166: aload_0
    //   167: iconst_0
    //   168: iload_2
    //   169: invokevirtual 251	java/lang/String:substring	(II)Ljava/lang/String;
    //   172: astore 8
    //   174: aload_0
    //   175: iload_2
    //   176: iconst_1
    //   177: iadd
    //   178: invokevirtual 254	java/lang/String:substring	(I)Ljava/lang/String;
    //   181: ldc_w 256
    //   184: invokevirtual 259	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   187: ifeq +6 -> 193
    //   190: goto -133 -> 57
    //   193: new 22	java/io/File
    //   196: dup
    //   197: aload 8
    //   199: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   202: astore 8
    //   204: aload 8
    //   206: invokevirtual 33	java/io/File:exists	()Z
    //   209: ifne +9 -> 218
    //   212: aload 8
    //   214: invokevirtual 243	java/io/File:mkdir	()Z
    //   217: pop
    //   218: new 22	java/io/File
    //   221: dup
    //   222: new 48	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   229: aload_0
    //   230: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: ldc_w 261
    //   236: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   245: astore 8
    //   247: new 22	java/io/File
    //   250: dup
    //   251: aload_0
    //   252: invokespecial 29	java/io/File:<init>	(Ljava/lang/String;)V
    //   255: astore 9
    //   257: aload 8
    //   259: invokevirtual 33	java/io/File:exists	()Z
    //   262: ifeq +9 -> 271
    //   265: aload 8
    //   267: invokevirtual 147	java/io/File:delete	()Z
    //   270: pop
    //   271: new 263	java/io/FileOutputStream
    //   274: dup
    //   275: aload 8
    //   277: invokespecial 266	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   280: astore_0
    //   281: aload 4
    //   283: aload 5
    //   285: invokevirtual 270	com/tencent/commonsdk/zip/QZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   288: astore 5
    //   290: aload 5
    //   292: aload 7
    //   294: iconst_0
    //   295: aload 7
    //   297: arraylength
    //   298: invokevirtual 276	java/io/InputStream:read	([BII)I
    //   301: istore_2
    //   302: iload_2
    //   303: iconst_m1
    //   304: if_icmpeq +52 -> 356
    //   307: aload_0
    //   308: aload 7
    //   310: iconst_0
    //   311: iload_2
    //   312: invokevirtual 280	java/io/FileOutputStream:write	([BII)V
    //   315: goto -25 -> 290
    //   318: astore 6
    //   320: aload 5
    //   322: astore_1
    //   323: aload_0
    //   324: astore_3
    //   325: aload 6
    //   327: astore_0
    //   328: aload_3
    //   329: ifnull +7 -> 336
    //   332: aload_3
    //   333: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   336: aload_1
    //   337: ifnull +7 -> 344
    //   340: aload_1
    //   341: invokevirtual 284	java/io/InputStream:close	()V
    //   344: aload 4
    //   346: ifnull +8 -> 354
    //   349: aload 4
    //   351: invokevirtual 285	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   354: aload_0
    //   355: athrow
    //   356: aload_0
    //   357: invokevirtual 288	java/io/FileOutputStream:flush	()V
    //   360: aload_0
    //   361: invokevirtual 283	java/io/FileOutputStream:close	()V
    //   364: aload 5
    //   366: invokevirtual 284	java/io/InputStream:close	()V
    //   369: aload 8
    //   371: aload 9
    //   373: invokestatic 292	com/tencent/mobileqq/utils/FileUtils:renameFile	(Ljava/io/File;Ljava/io/File;)Z
    //   376: ifne +125 -> 501
    //   379: aload 8
    //   381: aload 9
    //   383: invokestatic 295	com/tencent/mobileqq/utils/FileUtils:copyFile	(Ljava/io/File;Ljava/io/File;)Z
    //   386: pop
    //   387: goto +114 -> 501
    //   390: astore_0
    //   391: aconst_null
    //   392: astore_1
    //   393: goto -65 -> 328
    //   396: iconst_0
    //   397: ifeq +11 -> 408
    //   400: new 297	java/lang/NullPointerException
    //   403: dup
    //   404: invokespecial 298	java/lang/NullPointerException:<init>	()V
    //   407: athrow
    //   408: iconst_0
    //   409: ifeq +11 -> 420
    //   412: new 297	java/lang/NullPointerException
    //   415: dup
    //   416: invokespecial 298	java/lang/NullPointerException:<init>	()V
    //   419: athrow
    //   420: aload 4
    //   422: ifnull +8 -> 430
    //   425: aload 4
    //   427: invokevirtual 285	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   430: return
    //   431: astore_0
    //   432: aload_0
    //   433: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   436: goto -28 -> 408
    //   439: astore_0
    //   440: aload_0
    //   441: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   444: goto -24 -> 420
    //   447: astore_0
    //   448: aload_0
    //   449: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   452: return
    //   453: astore_3
    //   454: aload_3
    //   455: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   458: goto -122 -> 336
    //   461: astore_1
    //   462: aload_1
    //   463: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   466: goto -122 -> 344
    //   469: astore_1
    //   470: aload_1
    //   471: invokevirtual 163	java/io/IOException:printStackTrace	()V
    //   474: goto -120 -> 354
    //   477: astore_0
    //   478: aconst_null
    //   479: astore 4
    //   481: aconst_null
    //   482: astore_1
    //   483: goto -155 -> 328
    //   486: astore 5
    //   488: aconst_null
    //   489: astore_1
    //   490: aload_0
    //   491: astore_3
    //   492: aload 5
    //   494: astore_0
    //   495: goto -167 -> 328
    //   498: goto -441 -> 57
    //   501: goto -444 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	504	0	paramString1	String
    //   0	504	1	paramString2	String
    //   165	147	2	i	int
    //   1	332	3	str1	String
    //   453	2	3	localIOException	java.io.IOException
    //   491	1	3	str2	String
    //   41	439	4	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   77	288	5	localObject1	Object
    //   486	7	5	localObject2	Object
    //   48	20	6	localEnumeration	java.util.Enumeration
    //   318	8	6	localObject3	Object
    //   55	254	7	arrayOfByte	byte[]
    //   172	208	8	localObject4	Object
    //   255	127	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   290	302	318	finally
    //   307	315	318	finally
    //   356	369	318	finally
    //   43	57	390	finally
    //   57	85	390	finally
    //   89	98	390	finally
    //   101	155	390	finally
    //   158	190	390	finally
    //   193	218	390	finally
    //   218	271	390	finally
    //   271	281	390	finally
    //   369	387	390	finally
    //   400	408	431	java/io/IOException
    //   412	420	439	java/io/IOException
    //   425	430	447	java/io/IOException
    //   332	336	453	java/io/IOException
    //   340	344	461	java/io/IOException
    //   349	354	469	java/io/IOException
    //   33	43	477	finally
    //   281	290	486	finally
  }
  
  public static boolean a()
  {
    if ((!FileUtil.isFileExists(e())) || (!FileUtil.isFileExists(d())) || (!FileUtil.isFileExists(c())) || (!a("YTFaceCluster")) || (!a("YTFaceExtFeature")) || (!FileUtil.isFileExists(f())) || (!a("YTFaceClusterJNI_V841")))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanNativeSoLoader", 2, "isAllSoFileReady native so is not exist!");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceScanNativeSoLoader", 2, "isAllSoFileReady true");
    }
    return true;
  }
  
  public static boolean a(String paramString)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    String str1 = a() + "/lib" + paramString + ".so";
    ??? = new File(str1);
    boolean bool1 = bool3;
    if (!jdField_a_of_type_Boolean)
    {
      bool1 = bool3;
      if (!((File)???).exists()) {}
    }
    for (;;)
    {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        String str2 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 4).getString("face_native_" + paramString, null);
        str1 = ayja.a(str1);
        if (QLog.isColorLevel()) {
          QLog.d("FaceScanNativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " ,spmd5 = " + str2 + ",fileMD5 = " + str1);
        }
        if (str2 != null) {
          if (str2.equalsIgnoreCase(str1))
          {
            break label298;
            if (QLog.isColorLevel()) {
              QLog.d("FaceScanNativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " ,result = " + bool1 + ",isUncompressZip = " + jdField_a_of_type_Boolean);
            }
            return bool1;
          }
          else
          {
            bool1 = bool2;
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("FaceScanNativeSoLoader", 2, "isSoFileExist: soName= " + paramString + " check md5 false!");
            bool1 = bool2;
          }
        }
      }
      label298:
      bool1 = true;
    }
  }
  
  public static boolean a(String paramString, HashMap<String, String> paramHashMap)
  {
    boolean bool = true;
    XmlPullParser localXmlPullParser = Xml.newPullParser();
    paramHashMap.clear();
    for (;;)
    {
      try
      {
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramHashMap)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("FaceScanNativeSoLoader", 2, paramString, paramHashMap);
        bool = false;
        return bool;
      }
      int i = localXmlPullParser.next();
      break label203;
      String str = localXmlPullParser.getName();
      if (str.equalsIgnoreCase("YTFaceCluster"))
      {
        paramHashMap.put("YTFaceCluster", localXmlPullParser.nextText());
        continue;
      }
      else
      {
        if (str.equalsIgnoreCase("YTFaceExtFeature"))
        {
          paramHashMap.put("YTFaceExtFeature", localXmlPullParser.nextText());
          continue;
        }
        if (!str.equalsIgnoreCase("YTFaceClusterJNI_V841")) {
          continue;
        }
        paramHashMap.put("YTFaceClusterJNI_V841", localXmlPullParser.nextText());
        continue;
      }
      if (QLog.isColorLevel())
      {
        QLog.d("FaceScanNativeSoLoader", 2, "parseConfig success|config=" + paramHashMap);
        return true;
        label203:
        if (i != 1) {
          switch (i)
          {
          }
        }
      }
    }
  }
  
  public static byte b(String paramString)
  {
    byte b1 = 0;
    try
    {
      System.load(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("FaceScanNativeSoLoader", 2, "loadSoByPath ret = " + b1 + ",soPath = " + paramString);
      }
      return b1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        byte b2 = -2;
        b1 = b2;
        if (QLog.isColorLevel())
        {
          QLog.e("FaceScanNativeSoLoader", 2, "loadSoByPath error", localUnsatisfiedLinkError);
          b1 = b2;
        }
      }
    }
  }
  
  public static String b()
  {
    return BaseApplicationImpl.sApplication.getFilesDir().getParent() + "/face_scan";
  }
  
  public static byte c(String paramString)
  {
    byte b3 = 0;
    byte b2 = 0;
    if (paramString == null) {
      return -1;
    }
    String str = a() + "/lib" + paramString + ".so";
    if (QLog.isColorLevel()) {
      QLog.i("FaceScanNativeSoLoader", 2, "loadFaceNativeSo start faceNativeSo: " + str);
    }
    File localFile = new File(str);
    if ((!jdField_a_of_type_Boolean) && (localFile.exists())) {}
    for (;;)
    {
      try
      {
        System.load(str);
        b1 = b2;
        if (QLog.isColorLevel())
        {
          QLog.i("FaceScanNativeSoLoader", 2, "load " + str + " success!");
          b1 = b2;
        }
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        QLog.d("FaceScanNativeSoLoader", 1, "loadFaceNativeSo load from face dir failed, libName = " + paramString + "," + localUnsatisfiedLinkError.getMessage());
        b1 = -2;
        continue;
      }
      aoht.a(paramString, b1);
      return b1;
      byte b1 = b3;
      if (jdField_a_of_type_Boolean)
      {
        b1 = b3;
        if (!localFile.exists()) {
          b1 = -3;
        }
      }
      b2 = b1;
      if (jdField_a_of_type_Boolean)
      {
        b2 = b1;
        if (localFile.exists()) {
          b2 = -4;
        }
      }
      b1 = b2;
      if (!jdField_a_of_type_Boolean)
      {
        b1 = b2;
        if (!localFile.exists()) {
          b1 = -5;
        }
      }
      QLog.d("FaceScanNativeSoLoader", 1, "loadFaceNativeSo no face so in face dir,libName = " + paramString);
    }
  }
  
  public static String c()
  {
    return AEResUtil.getUnzippedPackageDir(AEResInfo.AE_RES_BASE_PACKAGE) + "libc++_shared.so";
  }
  
  public static String d()
  {
    return AEResUtil.getUnzippedPackageDir(AEResInfo.AE_RES_BASE_PACKAGE) + "libYTCommon.so";
  }
  
  public static String e()
  {
    return AEResUtil.getUnzippedPackageDir(AEResInfo.AE_RES_BASE_PACKAGE) + "libopencv_world.so";
  }
  
  public static String f()
  {
    return AEResUtil.getUnzippedPackageDir(AEResInfo.AE_RES_BASE_PACKAGE) + "libYTFaceTrackPro.so";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aodn
 * JD-Core Version:    0.7.0.1
 */