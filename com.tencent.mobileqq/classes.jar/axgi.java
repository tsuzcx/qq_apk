import android.content.Context;
import android.media.AudioManager;
import android.text.TextUtils;
import com.tencent.maxvideo.common.GlobalInit;
import com.tencent.maxvideo.common.MessageStruct;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axgi
{
  public static int a;
  public static long a;
  public static Context a;
  public static String a;
  public static final int[] a;
  public static int b;
  private static String b;
  public static final int[] b;
  public static int c;
  private static String c;
  public static final int[] c;
  public static int d;
  private static String d;
  public static final int[] d;
  private static String e;
  public static final int[] e;
  private static String f;
  public static final int[] f;
  public static final int[] g = { 1280, 800 };
  public static final int[] h = { 720, 480 };
  
  static
  {
    jdField_a_of_type_AndroidContentContext = VideoEnvironment.a();
    jdField_a_of_type_Long = -1L;
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_Int = 640;
    jdField_d_of_type_Int = 480;
    jdField_a_of_type_ArrayOfInt = new int[] { 960, 640 };
    jdField_b_of_type_ArrayOfInt = new int[] { 720, 480 };
    jdField_c_of_type_ArrayOfInt = new int[] { 720, 540, 640, 480, 480, 360, 320, 240 };
    jdField_d_of_type_ArrayOfInt = new int[] { 1, 1, 0 };
    jdField_e_of_type_ArrayOfInt = new int[] { 1, 0, 0 };
    jdField_f_of_type_ArrayOfInt = new int[] { 1, 1, 0 };
  }
  
  public static String a()
  {
    return jdField_c_of_type_JavaLangString;
  }
  
  public static void a()
  {
    try
    {
      AudioManager localAudioManager = (AudioManager)VideoEnvironment.a().getSystemService("audio");
      int j = localAudioManager.requestAudioFocus(null, 3, 2);
      int i = j;
      if (j == 0) {
        i = localAudioManager.requestAudioFocus(null, 3, 1);
      }
      if (i == 0) {
        localAudioManager.requestAudioFocus(null, 3, 3);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static boolean a(long paramLong, Context paramContext)
  {
    if (paramLong <= 0L) {}
    boolean bool1;
    boolean bool2;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            bool1 = bbdx.a();
            if (!bool1)
            {
              if (QLog.isColorLevel()) {
                QLog.e("initDirs", 2, "hasSDCardAndWritable = false");
              }
              return bool1;
            }
            paramContext = axlz.a().jdField_b_of_type_JavaLangString;
            if (!TextUtils.isEmpty(paramContext)) {
              break;
            }
          } while (!QLog.isColorLevel());
          QLog.e("initDirs", 2, "sdcardDirPath = empty");
          return false;
          if (QLog.isColorLevel()) {
            QLog.e("initDirs", 2, "sdcardDirPath:storeVideoPath=" + paramContext);
          }
          localFile = new File(paramContext);
          if ((localFile.exists()) && (localFile.isDirectory()) && (localFile.canWrite())) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.e("initDirs", 2, "exists OR isDirectory OR canWrite = false");
        return false;
        jdField_a_of_type_JavaLangString = paramContext + File.separator + "trimvideo";
        File localFile = new File(jdField_a_of_type_JavaLangString);
        bool1 = localFile.mkdirs();
        bool2 = localFile.isDirectory();
        if (QLog.isColorLevel()) {
          QLog.e("initDirs", 2, "trimVideoFilesDirPath:mkd=" + bool1 + " isdir=" + bool2);
        }
      } while ((!bool1) && (!bool2));
      jdField_e_of_type_JavaLangString = paramContext + "/Product";
      jdField_d_of_type_JavaLangString = paramContext + "/Material";
      jdField_f_of_type_JavaLangString = jdField_d_of_type_JavaLangString + "/ProcessedMaterial";
      jdField_b_of_type_JavaLangString = paramContext + "/log.txt";
      jdField_c_of_type_JavaLangString = paramContext + File.separator + "Source";
      paramContext = new File(jdField_c_of_type_JavaLangString);
      bool1 = paramContext.mkdirs();
      bool2 = paramContext.isDirectory();
      if (QLog.isColorLevel()) {
        QLog.e("initDirs", 2, "avSourceFilesDirPath:mkd=" + bool1 + " isdir=" + bool2);
      }
    } while ((!bool1) && (!bool2));
    return true;
  }
  
  public static boolean a(long paramLong, Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramContext == null) {
      if (QLog.isColorLevel()) {
        QLog.e("GloableValue", 2, "GloableValue[init]context=" + paramContext);
      }
    }
    do
    {
      return false;
      if ((jdField_a_of_type_Long > 0L) && ((paramLong <= 0L) || (jdField_a_of_type_Long == paramLong)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("GloableValue", 2, "GloableValue[init]sUin=" + jdField_a_of_type_Long + "uin=" + paramLong);
        }
        return true;
      }
      jdField_a_of_type_Long = paramLong;
    } while ((!a(paramLong, paramContext)) || (!a(paramLong + "", paramContext, paramInt1, paramInt2)));
    return true;
  }
  
  /* Error */
  public static boolean a(String paramString, Context paramContext, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 8
    //   12: invokestatic 100	axlz:a	()Laxlz;
    //   15: getfield 102	axlz:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   18: astore 9
    //   20: new 204	com/tencent/maxvideo/common/MessageStruct
    //   23: dup
    //   24: bipush 6
    //   26: invokespecial 207	com/tencent/maxvideo/common/MessageStruct:<init>	(I)V
    //   29: astore 4
    //   31: aload 4
    //   33: new 112	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   40: ldc 209
    //   42: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: aload_0
    //   46: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: ldc 211
    //   51: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload 9
    //   56: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: ldc 213
    //   61: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: getstatic 172	axgi:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   67: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc 215
    //   72: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: getstatic 58	axgi:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   78: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: ldc 217
    //   83: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: getstatic 161	axgi:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   89: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc 219
    //   94: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: getstatic 165	axgi:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   100: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 221
    //   105: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: getstatic 169	axgi:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   111: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 223
    //   116: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: getstatic 226	axim:jdField_c_of_type_Int	I
    //   122: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   125: ldc 231
    //   127: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: getstatic 233	axim:g	I
    //   133: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc 235
    //   138: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: iload_2
    //   142: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   145: ldc 237
    //   147: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_3
    //   151: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: ldc 239
    //   156: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iconst_0
    //   160: invokevirtual 229	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   163: ldc 241
    //   165: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: putfield 245	com/tencent/maxvideo/common/MessageStruct:mObj0	Ljava/lang/Object;
    //   174: aload 4
    //   176: aconst_null
    //   177: aconst_null
    //   178: invokestatic 251	com/tencent/maxvideo/common/GlobalInit:nativeSyncProcessMsg	(Lcom/tencent/maxvideo/common/MessageStruct;Lcom/tencent/maxvideo/common/MessageStruct;Ljava/lang/Object;)Z
    //   181: pop
    //   182: aload_1
    //   183: invokevirtual 255	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   186: ldc_w 256
    //   189: invokevirtual 262	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   192: astore_0
    //   193: aload_0
    //   194: invokevirtual 268	java/io/InputStream:available	()I
    //   197: newarray byte
    //   199: astore 10
    //   201: aload_0
    //   202: aload 10
    //   204: invokevirtual 272	java/io/InputStream:read	([B)I
    //   207: pop
    //   208: new 274	java/io/FileOutputStream
    //   211: dup
    //   212: new 126	java/io/File
    //   215: dup
    //   216: new 112	java/lang/StringBuilder
    //   219: dup
    //   220: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   223: aload 9
    //   225: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: ldc_w 276
    //   231: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   240: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   243: astore 4
    //   245: aload 4
    //   247: aload 10
    //   249: invokevirtual 283	java/io/FileOutputStream:write	([B)V
    //   252: aload_0
    //   253: ifnull +7 -> 260
    //   256: aload_0
    //   257: invokevirtual 286	java/io/InputStream:close	()V
    //   260: aload 4
    //   262: ifnull +8 -> 270
    //   265: aload 4
    //   267: invokevirtual 287	java/io/FileOutputStream:close	()V
    //   270: aload_1
    //   271: invokevirtual 255	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   274: ldc_w 288
    //   277: invokevirtual 262	android/content/res/Resources:openRawResource	(I)Ljava/io/InputStream;
    //   280: astore_0
    //   281: aload_0
    //   282: invokevirtual 268	java/io/InputStream:available	()I
    //   285: newarray byte
    //   287: astore 4
    //   289: aload_0
    //   290: aload 4
    //   292: invokevirtual 272	java/io/InputStream:read	([B)I
    //   295: pop
    //   296: new 274	java/io/FileOutputStream
    //   299: dup
    //   300: new 126	java/io/File
    //   303: dup
    //   304: new 112	java/lang/StringBuilder
    //   307: dup
    //   308: invokespecial 115	java/lang/StringBuilder:<init>	()V
    //   311: aload 9
    //   313: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc_w 290
    //   319: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokespecial 129	java/io/File:<init>	(Ljava/lang/String;)V
    //   328: invokespecial 279	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   331: astore_1
    //   332: aload_1
    //   333: aload 4
    //   335: invokevirtual 283	java/io/FileOutputStream:write	([B)V
    //   338: aload_0
    //   339: ifnull +7 -> 346
    //   342: aload_0
    //   343: invokevirtual 286	java/io/InputStream:close	()V
    //   346: aload_1
    //   347: ifnull +7 -> 354
    //   350: aload_1
    //   351: invokevirtual 287	java/io/FileOutputStream:close	()V
    //   354: iconst_1
    //   355: ireturn
    //   356: astore_0
    //   357: aconst_null
    //   358: astore 4
    //   360: aconst_null
    //   361: astore_0
    //   362: aload_0
    //   363: ifnull +7 -> 370
    //   366: aload_0
    //   367: invokevirtual 286	java/io/InputStream:close	()V
    //   370: aload 4
    //   372: ifnull -102 -> 270
    //   375: aload 4
    //   377: invokevirtual 287	java/io/FileOutputStream:close	()V
    //   380: goto -110 -> 270
    //   383: astore_0
    //   384: goto -114 -> 270
    //   387: astore_0
    //   388: aconst_null
    //   389: astore 4
    //   391: aconst_null
    //   392: astore_0
    //   393: aload_0
    //   394: ifnull +7 -> 401
    //   397: aload_0
    //   398: invokevirtual 286	java/io/InputStream:close	()V
    //   401: aload 4
    //   403: ifnull -133 -> 270
    //   406: aload 4
    //   408: invokevirtual 287	java/io/FileOutputStream:close	()V
    //   411: goto -141 -> 270
    //   414: astore_0
    //   415: goto -145 -> 270
    //   418: astore_1
    //   419: aconst_null
    //   420: astore_0
    //   421: aload 8
    //   423: astore 4
    //   425: aload_0
    //   426: ifnull +7 -> 433
    //   429: aload_0
    //   430: invokevirtual 286	java/io/InputStream:close	()V
    //   433: aload 4
    //   435: ifnull +8 -> 443
    //   438: aload 4
    //   440: invokevirtual 287	java/io/FileOutputStream:close	()V
    //   443: aload_1
    //   444: athrow
    //   445: astore_0
    //   446: aconst_null
    //   447: astore_0
    //   448: aload 5
    //   450: astore_1
    //   451: aload_0
    //   452: ifnull +7 -> 459
    //   455: aload_0
    //   456: invokevirtual 286	java/io/InputStream:close	()V
    //   459: aload_1
    //   460: ifnull -106 -> 354
    //   463: aload_1
    //   464: invokevirtual 287	java/io/FileOutputStream:close	()V
    //   467: goto -113 -> 354
    //   470: astore_0
    //   471: goto -117 -> 354
    //   474: astore_0
    //   475: aconst_null
    //   476: astore_0
    //   477: aload 7
    //   479: astore_1
    //   480: aload_0
    //   481: ifnull +7 -> 488
    //   484: aload_0
    //   485: invokevirtual 286	java/io/InputStream:close	()V
    //   488: aload_1
    //   489: ifnull -135 -> 354
    //   492: aload_1
    //   493: invokevirtual 287	java/io/FileOutputStream:close	()V
    //   496: goto -142 -> 354
    //   499: astore_0
    //   500: goto -146 -> 354
    //   503: astore_1
    //   504: aconst_null
    //   505: astore_0
    //   506: aload 6
    //   508: astore 4
    //   510: aload_0
    //   511: ifnull +7 -> 518
    //   514: aload_0
    //   515: invokevirtual 286	java/io/InputStream:close	()V
    //   518: aload 4
    //   520: ifnull +8 -> 528
    //   523: aload 4
    //   525: invokevirtual 287	java/io/FileOutputStream:close	()V
    //   528: aload_1
    //   529: athrow
    //   530: astore_0
    //   531: goto -271 -> 260
    //   534: astore_0
    //   535: goto -265 -> 270
    //   538: astore_0
    //   539: goto -169 -> 370
    //   542: astore_0
    //   543: goto -142 -> 401
    //   546: astore_0
    //   547: goto -114 -> 433
    //   550: astore_0
    //   551: goto -108 -> 443
    //   554: astore_0
    //   555: goto -209 -> 346
    //   558: astore_0
    //   559: goto -205 -> 354
    //   562: astore_0
    //   563: goto -104 -> 459
    //   566: astore_0
    //   567: goto -79 -> 488
    //   570: astore_0
    //   571: goto -53 -> 518
    //   574: astore_0
    //   575: goto -47 -> 528
    //   578: astore_1
    //   579: aload 6
    //   581: astore 4
    //   583: goto -73 -> 510
    //   586: astore 5
    //   588: aload_1
    //   589: astore 4
    //   591: aload 5
    //   593: astore_1
    //   594: goto -84 -> 510
    //   597: astore_1
    //   598: aload 7
    //   600: astore_1
    //   601: goto -121 -> 480
    //   604: astore 4
    //   606: goto -126 -> 480
    //   609: astore_1
    //   610: aload 5
    //   612: astore_1
    //   613: goto -162 -> 451
    //   616: astore 4
    //   618: goto -167 -> 451
    //   621: astore_1
    //   622: aload 8
    //   624: astore 4
    //   626: goto -201 -> 425
    //   629: astore_1
    //   630: goto -205 -> 425
    //   633: astore 4
    //   635: aconst_null
    //   636: astore 4
    //   638: goto -245 -> 393
    //   641: astore 8
    //   643: goto -250 -> 393
    //   646: astore 4
    //   648: aconst_null
    //   649: astore 4
    //   651: goto -289 -> 362
    //   654: astore 8
    //   656: goto -294 -> 362
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	659	0	paramString	String
    //   0	659	1	paramContext	Context
    //   0	659	2	paramInt1	int
    //   0	659	3	paramInt2	int
    //   29	561	4	localObject1	Object
    //   604	1	4	localIOException1	java.io.IOException
    //   616	1	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   624	1	4	localObject2	Object
    //   633	1	4	localIOException2	java.io.IOException
    //   636	1	4	localObject3	Object
    //   646	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   649	1	4	localObject4	Object
    //   1	448	5	localObject5	Object
    //   586	25	5	localObject6	Object
    //   7	573	6	localObject7	Object
    //   4	595	7	localObject8	Object
    //   10	613	8	localObject9	Object
    //   641	1	8	localIOException3	java.io.IOException
    //   654	1	8	localFileNotFoundException3	java.io.FileNotFoundException
    //   18	294	9	str	String
    //   199	49	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   182	193	356	java/io/FileNotFoundException
    //   375	380	383	java/io/IOException
    //   182	193	387	java/io/IOException
    //   406	411	414	java/io/IOException
    //   182	193	418	finally
    //   270	281	445	java/io/FileNotFoundException
    //   463	467	470	java/io/IOException
    //   270	281	474	java/io/IOException
    //   492	496	499	java/io/IOException
    //   270	281	503	finally
    //   256	260	530	java/io/IOException
    //   265	270	534	java/io/IOException
    //   366	370	538	java/io/IOException
    //   397	401	542	java/io/IOException
    //   429	433	546	java/io/IOException
    //   438	443	550	java/io/IOException
    //   342	346	554	java/io/IOException
    //   350	354	558	java/io/IOException
    //   455	459	562	java/io/IOException
    //   484	488	566	java/io/IOException
    //   514	518	570	java/io/IOException
    //   523	528	574	java/io/IOException
    //   281	332	578	finally
    //   332	338	586	finally
    //   281	332	597	java/io/IOException
    //   332	338	604	java/io/IOException
    //   281	332	609	java/io/FileNotFoundException
    //   332	338	616	java/io/FileNotFoundException
    //   193	245	621	finally
    //   245	252	629	finally
    //   193	245	633	java/io/IOException
    //   245	252	641	java/io/IOException
    //   193	245	646	java/io/FileNotFoundException
    //   245	252	654	java/io/FileNotFoundException
  }
  
  public static void b()
  {
    try
    {
      ((AudioManager)VideoEnvironment.a().getSystemService("audio")).abandonAudioFocus(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void c()
  {
    GlobalInit.nativeSyncProcessMsg(new MessageStruct(7), null, null);
    jdField_a_of_type_Long = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axgi
 * JD-Core Version:    0.7.0.1
 */