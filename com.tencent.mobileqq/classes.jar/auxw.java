import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper.3;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class auxw
  implements Handler.Callback
{
  public static String a;
  private static ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private Activity jdField_a_of_type_AndroidAppActivity;
  public Context a;
  private auyc jdField_a_of_type_Auyc;
  private bgpa jdField_a_of_type_Bgpa;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bkfv(Looper.getMainLooper(), this, true);
  public boolean a;
  public boolean b;
  private boolean c;
  
  public auxw(Activity paramActivity, boolean paramBoolean, auyc paramauyc)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
    this.c = paramBoolean;
    this.jdField_a_of_type_Auyc = paramauyc;
  }
  
  /* Error */
  public static String a(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    // Byte code:
    //   0: invokestatic 71	com/tencent/common/app/BaseApplicationImpl:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   3: astore_3
    //   4: aload_3
    //   5: invokevirtual 77	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   8: aload_0
    //   9: iconst_1
    //   10: anewarray 79	java/lang/String
    //   13: dup
    //   14: iconst_0
    //   15: ldc 81
    //   17: aastore
    //   18: aload_1
    //   19: aload_2
    //   20: aconst_null
    //   21: invokevirtual 87	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnull +39 -> 65
    //   29: aload_0
    //   30: invokeinterface 93 1 0
    //   35: ifeq +30 -> 65
    //   38: aload_0
    //   39: aload_0
    //   40: ldc 81
    //   42: invokeinterface 97 2 0
    //   47: invokeinterface 101 2 0
    //   52: astore_1
    //   53: aload_0
    //   54: ifnull +9 -> 63
    //   57: aload_0
    //   58: invokeinterface 104 1 0
    //   63: aload_1
    //   64: areturn
    //   65: aload_0
    //   66: ifnull +9 -> 75
    //   69: aload_0
    //   70: invokeinterface 104 1 0
    //   75: aconst_null
    //   76: areturn
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_0
    //   80: aload_0
    //   81: ifnull -6 -> 75
    //   84: aload_0
    //   85: invokeinterface 104 1 0
    //   90: goto -15 -> 75
    //   93: astore_1
    //   94: aconst_null
    //   95: astore_0
    //   96: aload_0
    //   97: ifnull +9 -> 106
    //   100: aload_0
    //   101: invokeinterface 104 1 0
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: goto -13 -> 96
    //   112: astore_1
    //   113: goto -33 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	116	0	paramUri	Uri
    //   0	116	1	paramString	String
    //   0	116	2	paramArrayOfString	String[]
    //   3	2	3	localBaseApplication	com.tencent.qphone.base.util.BaseApplication
    // Exception table:
    //   from	to	target	type
    //   4	25	77	java/lang/Throwable
    //   4	25	93	finally
    //   29	53	108	finally
    //   29	53	112	java/lang/Throwable
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_Bgpa != null) {
      this.jdField_a_of_type_Bgpa.dismiss();
    }
  }
  
  private void a(Uri paramUri, String paramString, InputStream paramInputStream, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.post(new UriParserPathHelper.3(this, paramString, paramInputStream, paramLong, paramUri), 5, null, true);
    if (!this.c) {
      return;
    }
    if (this.jdField_a_of_type_Bgpa == null)
    {
      this.jdField_a_of_type_Bgpa = bglp.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext.getString(2131691145), anni.a(2131714601), new auxz(this));
      this.jdField_a_of_type_Bgpa.setOnDismissListener(new auya(this));
    }
    this.jdField_a_of_type_Bgpa.show();
  }
  
  private static void a(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    for (;;)
    {
      return;
      paramString = paramString.listFiles();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (System.currentTimeMillis() - localObject.lastModified() > 86400000L) {
          localObject.delete();
        }
        i += 1;
      }
    }
  }
  
  /* Error */
  public static boolean a(Uri paramUri, Context paramContext)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: aload_0
    //   6: ifnonnull +6 -> 12
    //   9: iload 4
    //   11: ireturn
    //   12: aload_0
    //   13: invokevirtual 195	android/net/Uri:getScheme	()Ljava/lang/String;
    //   16: astore 5
    //   18: new 197	java/lang/StringBuilder
    //   21: dup
    //   22: ldc 199
    //   24: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: astore 6
    //   29: aload 6
    //   31: ldc 202
    //   33: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload 5
    //   43: ifnull +13 -> 56
    //   46: aload 5
    //   48: ldc 211
    //   50: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   53: ifeq +159 -> 212
    //   56: new 163	java/io/File
    //   59: dup
    //   60: aload_0
    //   61: invokevirtual 218	android/net/Uri:getPath	()Ljava/lang/String;
    //   64: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 5
    //   69: aload 5
    //   71: ifnull +427 -> 498
    //   74: aload 5
    //   76: invokevirtual 221	java/io/File:canRead	()Z
    //   79: istore 4
    //   81: iload 4
    //   83: ifeq +415 -> 498
    //   86: iconst_1
    //   87: istore_3
    //   88: iload_3
    //   89: istore 4
    //   91: aload 6
    //   93: ldc 223
    //   95: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: iload_3
    //   99: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: iload_3
    //   104: istore 4
    //   106: iload_3
    //   107: ifne -98 -> 9
    //   110: iload_3
    //   111: istore 4
    //   113: aload_1
    //   114: ifnull -105 -> 9
    //   117: aload_1
    //   118: invokevirtual 77	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   121: astore 5
    //   123: aload 5
    //   125: aload_0
    //   126: aconst_null
    //   127: aconst_null
    //   128: aconst_null
    //   129: aconst_null
    //   130: invokevirtual 87	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   133: astore_1
    //   134: aload_1
    //   135: ifnull +350 -> 485
    //   138: aload_1
    //   139: ldc 228
    //   141: invokeinterface 231 2 0
    //   146: istore_2
    //   147: aload_1
    //   148: invokeinterface 93 1 0
    //   153: pop
    //   154: iload_2
    //   155: iconst_m1
    //   156: if_icmpne +278 -> 434
    //   159: aconst_null
    //   160: astore_1
    //   161: aload 5
    //   163: aload_0
    //   164: invokevirtual 235	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   167: ifnull +318 -> 485
    //   170: aload_1
    //   171: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   174: ifne +311 -> 485
    //   177: ldc 243
    //   179: iconst_1
    //   180: iconst_2
    //   181: anewarray 4	java/lang/Object
    //   184: dup
    //   185: iconst_0
    //   186: ldc 245
    //   188: aastore
    //   189: dup
    //   190: iconst_1
    //   191: aload_1
    //   192: aastore
    //   193: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   196: iconst_1
    //   197: istore_3
    //   198: aload 6
    //   200: ldc 253
    //   202: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: iload_3
    //   206: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: iload_3
    //   211: ireturn
    //   212: aload 5
    //   214: ldc 255
    //   216: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   219: istore 4
    //   221: iload 4
    //   223: ifeq +270 -> 493
    //   226: aload_1
    //   227: invokevirtual 77	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   230: aload_0
    //   231: iconst_1
    //   232: anewarray 79	java/lang/String
    //   235: dup
    //   236: iconst_0
    //   237: ldc 81
    //   239: aastore
    //   240: aconst_null
    //   241: aconst_null
    //   242: aconst_null
    //   243: invokevirtual 87	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   246: astore 5
    //   248: aload 5
    //   250: ldc 81
    //   252: invokeinterface 97 2 0
    //   257: istore_2
    //   258: aload 5
    //   260: invokeinterface 93 1 0
    //   265: pop
    //   266: aload 5
    //   268: iload_2
    //   269: invokeinterface 101 2 0
    //   274: astore 7
    //   276: aload 5
    //   278: invokeinterface 104 1 0
    //   283: aload 7
    //   285: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   288: ifne +200 -> 488
    //   291: ldc 243
    //   293: iconst_1
    //   294: iconst_2
    //   295: anewarray 4	java/lang/Object
    //   298: dup
    //   299: iconst_0
    //   300: ldc_w 257
    //   303: aastore
    //   304: dup
    //   305: iconst_1
    //   306: aload 7
    //   308: aastore
    //   309: invokestatic 260	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   312: new 163	java/io/File
    //   315: dup
    //   316: aload 7
    //   318: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   321: astore 5
    //   323: aload 5
    //   325: ifnull +163 -> 488
    //   328: aload 5
    //   330: invokevirtual 221	java/io/File:canRead	()Z
    //   333: istore 4
    //   335: iload 4
    //   337: ifeq +151 -> 488
    //   340: iconst_1
    //   341: istore_3
    //   342: iload_3
    //   343: istore 4
    //   345: aload 6
    //   347: ldc_w 262
    //   350: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: iload_3
    //   354: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   357: pop
    //   358: goto -255 -> 103
    //   361: astore 5
    //   363: iload 4
    //   365: istore_3
    //   366: ldc 243
    //   368: iconst_1
    //   369: ldc_w 264
    //   372: aload 5
    //   374: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   377: goto -274 -> 103
    //   380: astore 5
    //   382: ldc 243
    //   384: iconst_1
    //   385: ldc_w 269
    //   388: aload 5
    //   390: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   393: aload 6
    //   395: ldc_w 262
    //   398: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: iconst_0
    //   402: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: iconst_0
    //   407: istore_3
    //   408: goto -305 -> 103
    //   411: astore 5
    //   413: aload 6
    //   415: ldc_w 262
    //   418: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: iconst_0
    //   422: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload 5
    //   428: athrow
    //   429: astore 5
    //   431: goto -65 -> 366
    //   434: aload_1
    //   435: iload_2
    //   436: invokeinterface 101 2 0
    //   441: astore_1
    //   442: goto -281 -> 161
    //   445: astore_0
    //   446: ldc 243
    //   448: iconst_1
    //   449: ldc_w 271
    //   452: aload_0
    //   453: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   456: aload 6
    //   458: ldc 253
    //   460: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: iload_3
    //   464: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: iload_3
    //   469: ireturn
    //   470: astore_0
    //   471: aload 6
    //   473: ldc 253
    //   475: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: iload_3
    //   479: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: aload_0
    //   484: athrow
    //   485: goto -287 -> 198
    //   488: iconst_0
    //   489: istore_3
    //   490: goto -148 -> 342
    //   493: iconst_0
    //   494: istore_3
    //   495: goto -392 -> 103
    //   498: iconst_0
    //   499: istore_3
    //   500: goto -412 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	paramUri	Uri
    //   0	503	1	paramContext	Context
    //   146	290	2	i	int
    //   1	499	3	bool1	boolean
    //   3	361	4	bool2	boolean
    //   16	313	5	localObject1	Object
    //   361	12	5	localException1	Exception
    //   380	9	5	localThrowable	Throwable
    //   411	16	5	localObject2	Object
    //   429	1	5	localException2	Exception
    //   27	445	6	localStringBuilder	StringBuilder
    //   274	43	7	str	String
    // Exception table:
    //   from	to	target	type
    //   91	103	361	java/lang/Exception
    //   345	358	361	java/lang/Exception
    //   226	323	380	java/lang/Throwable
    //   328	335	380	java/lang/Throwable
    //   226	323	411	finally
    //   328	335	411	finally
    //   382	393	411	finally
    //   46	56	429	java/lang/Exception
    //   56	69	429	java/lang/Exception
    //   74	81	429	java/lang/Exception
    //   212	221	429	java/lang/Exception
    //   393	406	429	java/lang/Exception
    //   413	429	429	java/lang/Exception
    //   117	134	445	java/lang/Exception
    //   138	154	445	java/lang/Exception
    //   161	196	445	java/lang/Exception
    //   434	442	445	java/lang/Exception
    //   117	134	470	finally
    //   138	154	470	finally
    //   161	196	470	finally
    //   434	442	470	finally
    //   446	456	470	finally
  }
  
  /* Error */
  private String b(Uri paramUri)
  {
    // Byte code:
    //   0: getstatic 27	auxw:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_1
    //   4: invokevirtual 275	android/net/Uri:toString	()Ljava/lang/String;
    //   7: invokevirtual 279	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 79	java/lang/String
    //   13: astore 6
    //   15: aload 6
    //   17: ifnull +21 -> 38
    //   20: new 163	java/io/File
    //   23: dup
    //   24: aload 6
    //   26: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 168	java/io/File:exists	()Z
    //   32: ifeq +6 -> 38
    //   35: aload 6
    //   37: areturn
    //   38: aconst_null
    //   39: putstatic 281	auxw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: aload_0
    //   43: getfield 45	auxw:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   46: invokevirtual 284	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   49: astore 8
    //   51: aload 8
    //   53: aload_1
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokevirtual 87	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore 6
    //   63: aload 6
    //   65: ifnonnull +26 -> 91
    //   68: ldc 243
    //   70: iconst_1
    //   71: ldc_w 286
    //   74: invokestatic 290	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload 6
    //   79: ifnull +10 -> 89
    //   82: aload 6
    //   84: invokeinterface 104 1 0
    //   89: aconst_null
    //   90: areturn
    //   91: aload 6
    //   93: ldc 228
    //   95: invokeinterface 231 2 0
    //   100: istore_2
    //   101: aload 6
    //   103: ldc_w 292
    //   106: invokeinterface 231 2 0
    //   111: istore_3
    //   112: aload 6
    //   114: invokeinterface 93 1 0
    //   119: pop
    //   120: aload 6
    //   122: iload_3
    //   123: invokeinterface 296 2 0
    //   128: lstore 4
    //   130: lload 4
    //   132: l2f
    //   133: invokestatic 301	bgmg:c	()F
    //   136: fcmpl
    //   137: ifle +30 -> 167
    //   140: aload_0
    //   141: getfield 45	auxw:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   144: ldc_w 302
    //   147: invokevirtual 303	android/app/Activity:getString	(I)Ljava/lang/String;
    //   150: putstatic 281	auxw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   153: aload 6
    //   155: ifnull +10 -> 165
    //   158: aload 6
    //   160: invokeinterface 104 1 0
    //   165: aconst_null
    //   166: areturn
    //   167: iload_2
    //   168: iconst_m1
    //   169: if_icmpne +149 -> 318
    //   172: new 197	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   179: invokestatic 178	java/lang/System:currentTimeMillis	()J
    //   182: invokevirtual 307	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   185: ldc_w 309
    //   188: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: astore 7
    //   196: new 197	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   203: aload_0
    //   204: getfield 45	auxw:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   207: invokevirtual 314	android/app/Activity:getExternalCacheDir	()Ljava/io/File;
    //   210: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   213: ldc_w 316
    //   216: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: ldc_w 318
    //   222: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc_w 316
    //   228: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: astore 9
    //   236: new 197	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 304	java/lang/StringBuilder:<init>	()V
    //   243: aload 9
    //   245: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: aload 9
    //   250: aload 7
    //   252: invokestatic 321	bgmg:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   255: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: invokevirtual 310	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   261: astore 7
    //   263: aload 9
    //   265: invokestatic 323	auxw:a	(Ljava/lang/String;)V
    //   268: new 163	java/io/File
    //   271: dup
    //   272: aload 9
    //   274: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   277: astore 9
    //   279: aload 9
    //   281: invokevirtual 168	java/io/File:exists	()Z
    //   284: ifne +47 -> 331
    //   287: aload 9
    //   289: invokevirtual 326	java/io/File:mkdirs	()Z
    //   292: ifne +39 -> 331
    //   295: ldc_w 327
    //   298: invokestatic 134	anni:a	(I)Ljava/lang/String;
    //   301: putstatic 281	auxw:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   304: aload 6
    //   306: ifnull +10 -> 316
    //   309: aload 6
    //   311: invokeinterface 104 1 0
    //   316: aconst_null
    //   317: areturn
    //   318: aload 6
    //   320: iload_2
    //   321: invokeinterface 101 2 0
    //   326: astore 7
    //   328: goto -132 -> 196
    //   331: aload 8
    //   333: aload_1
    //   334: invokevirtual 235	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   337: astore 8
    //   339: aload 8
    //   341: ifnonnull +26 -> 367
    //   344: ldc 243
    //   346: iconst_1
    //   347: ldc_w 329
    //   350: invokestatic 290	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: aload 6
    //   355: ifnull +10 -> 365
    //   358: aload 6
    //   360: invokeinterface 104 1 0
    //   365: aconst_null
    //   366: areturn
    //   367: lload 4
    //   369: ldc2_w 330
    //   372: lcmp
    //   373: ifle +153 -> 526
    //   376: aload_0
    //   377: iconst_1
    //   378: putfield 333	auxw:b	Z
    //   381: new 110	bgpa
    //   384: dup
    //   385: aload_0
    //   386: getfield 45	auxw:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   389: ldc_w 334
    //   392: invokespecial 337	bgpa:<init>	(Landroid/content/Context;I)V
    //   395: astore 9
    //   397: aload 9
    //   399: ldc_w 338
    //   402: invokevirtual 342	bgpa:setContentView	(I)V
    //   405: aload 9
    //   407: aload_0
    //   408: getfield 57	auxw:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   411: ldc_w 343
    //   414: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   417: invokevirtual 347	bgpa:setTitle	(Ljava/lang/String;)Lbgpa;
    //   420: pop
    //   421: aload 9
    //   423: aload_0
    //   424: getfield 57	auxw:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   427: ldc_w 348
    //   430: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   433: invokevirtual 352	bgpa:setMessage	(Ljava/lang/CharSequence;)Lbgpa;
    //   436: pop
    //   437: aload 9
    //   439: iconst_0
    //   440: invokevirtual 356	bgpa:setCanceledOnTouchOutside	(Z)V
    //   443: aload 9
    //   445: iconst_0
    //   446: invokevirtual 359	bgpa:setCancelable	(Z)V
    //   449: aload 9
    //   451: aload_0
    //   452: getfield 57	auxw:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   455: ldc_w 360
    //   458: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   461: new 362	auxx
    //   464: dup
    //   465: aload_0
    //   466: aload 8
    //   468: invokespecial 365	auxx:<init>	(Lauxw;Ljava/io/InputStream;)V
    //   471: invokevirtual 369	bgpa:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbgpa;
    //   474: pop
    //   475: aload 9
    //   477: aload_0
    //   478: getfield 57	auxw:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   481: ldc_w 370
    //   484: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   487: new 372	auxy
    //   490: dup
    //   491: aload_0
    //   492: aload_1
    //   493: aload 7
    //   495: aload 8
    //   497: lload 4
    //   499: invokespecial 374	auxy:<init>	(Lauxw;Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   502: invokevirtual 377	bgpa:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbgpa;
    //   505: pop
    //   506: aload 9
    //   508: invokevirtual 154	bgpa:show	()V
    //   511: aload 6
    //   513: ifnull +10 -> 523
    //   516: aload 6
    //   518: invokeinterface 104 1 0
    //   523: aload 7
    //   525: areturn
    //   526: aload_0
    //   527: aload_1
    //   528: aload 7
    //   530: aload 8
    //   532: lload 4
    //   534: invokespecial 157	auxw:a	(Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   537: goto -26 -> 511
    //   540: astore 7
    //   542: aload 6
    //   544: astore_1
    //   545: aload 7
    //   547: astore 6
    //   549: aload_0
    //   550: iconst_0
    //   551: putfield 116	auxw:jdField_a_of_type_Boolean	Z
    //   554: ldc 243
    //   556: iconst_1
    //   557: ldc_w 379
    //   560: aload 6
    //   562: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   565: aload_1
    //   566: ifnull +9 -> 575
    //   569: aload_1
    //   570: invokeinterface 104 1 0
    //   575: aconst_null
    //   576: areturn
    //   577: astore_1
    //   578: aconst_null
    //   579: astore 6
    //   581: aload 6
    //   583: ifnull +10 -> 593
    //   586: aload 6
    //   588: invokeinterface 104 1 0
    //   593: aload_1
    //   594: athrow
    //   595: astore_1
    //   596: goto -15 -> 581
    //   599: astore 7
    //   601: aload_1
    //   602: astore 6
    //   604: aload 7
    //   606: astore_1
    //   607: goto -26 -> 581
    //   610: astore 6
    //   612: aconst_null
    //   613: astore_1
    //   614: goto -65 -> 549
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	this	auxw
    //   0	617	1	paramUri	Uri
    //   100	221	2	i	int
    //   111	12	3	j	int
    //   128	405	4	l	long
    //   13	590	6	localObject1	Object
    //   610	1	6	localException1	Exception
    //   194	335	7	str	String
    //   540	6	7	localException2	Exception
    //   599	6	7	localObject2	Object
    //   49	482	8	localObject3	Object
    //   234	273	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   68	77	540	java/lang/Exception
    //   91	153	540	java/lang/Exception
    //   172	196	540	java/lang/Exception
    //   196	304	540	java/lang/Exception
    //   318	328	540	java/lang/Exception
    //   331	339	540	java/lang/Exception
    //   344	353	540	java/lang/Exception
    //   376	511	540	java/lang/Exception
    //   526	537	540	java/lang/Exception
    //   51	63	577	finally
    //   68	77	595	finally
    //   91	153	595	finally
    //   172	196	595	finally
    //   196	304	595	finally
    //   318	328	595	finally
    //   331	339	595	finally
    //   344	353	595	finally
    //   376	511	595	finally
    //   526	537	595	finally
    //   549	565	599	finally
    //   51	63	610	java/lang/Exception
  }
  
  private void b(String paramString)
  {
    if (!this.c) {}
    bgpa localbgpa;
    do
    {
      return;
      localbgpa = new bgpa(this.jdField_a_of_type_AndroidAppActivity, 2131755823);
      localbgpa.setContentView(2131559009);
      localbgpa.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131718563));
      localbgpa.setMessage(paramString);
      localbgpa.setCanceledOnTouchOutside(false);
      localbgpa.setCancelable(false);
      localbgpa.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690563), new auyb(this));
    } while (this.jdField_a_of_type_AndroidAppActivity.isFinishing());
    localbgpa.show();
  }
  
  protected String a()
  {
    if (jdField_a_of_type_JavaLangString == null) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131718011);
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public String a(Uri paramUri)
  {
    return a(paramUri, true);
  }
  
  public String a(Uri paramUri, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UriParserPathHelper", 2, "uri= " + paramUri);
    }
    this.jdField_a_of_type_Boolean = false;
    this.b = false;
    if ((VersionUtils.isNougat()) && ("com.android.fileexplorer.fileprovider".equalsIgnoreCase(paramUri.getAuthority())))
    {
      localObject1 = paramUri.getPathSegments();
      if ((((List)localObject1).size() >= 2) && ("external_files".equalsIgnoreCase((String)((List)localObject1).get(0))))
      {
        paramUri = paramUri.getPath().replaceFirst("\\/external_files", anhk.aZ);
        if (QLog.isColorLevel()) {
          QLog.d("UriParserPathHelper", 2, "Nougat path: " + paramUri);
        }
        return paramUri;
      }
    }
    else if (VersionUtils.isKITKAT())
    {
      localObject1 = paramUri.getPathSegments();
      if ((((List)localObject1).size() < 2) || (!"document".equals(((List)localObject1).get(0)))) {
        break label450;
      }
    }
    label450:
    Object localObject2;
    for (Object localObject1 = (String)((List)localObject1).get(1);; localObject2 = null) {
      for (;;)
      {
        try
        {
          if ("com.android.externalstorage.documents".equals(paramUri.getAuthority()))
          {
            localObject1 = ((String)localObject1).split(":");
            if ("primary".equalsIgnoreCase(localObject1[0])) {
              return Environment.getExternalStorageDirectory() + "/" + localObject1[1];
            }
          }
          else
          {
            if ("com.android.providers.downloads.documents".equals(paramUri.getAuthority())) {
              return a(ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf((String)localObject1).longValue()), null, null);
            }
            if ("com.android.providers.media.documents".equals(paramUri.getAuthority()))
            {
              String[] arrayOfString = ((String)localObject1).split(":");
              localObject1 = arrayOfString[0];
              if ("image".equals(localObject1))
              {
                localObject1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                return a((Uri)localObject1, "_id=?", new String[] { arrayOfString[1] });
              }
              if ("video".equals(localObject1))
              {
                localObject1 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                continue;
              }
              if (!"audio".equals(localObject1)) {
                break;
              }
              localObject1 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
              continue;
            }
            boolean bool = "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
            if (!bool) {}
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("UriParserPathHelper", 2, "handle exeption ", localException);
          continue;
        }
        return b(paramUri, paramBoolean);
        if ((localException.size() >= 2) && ("my_external".equals(localException.get(0))) && ("com.android.contacts.files".equals(paramUri.getAuthority())))
        {
          paramUri = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
          int i = 1;
          while (i < localException.size())
          {
            paramUri.append('/').append((String)localException.get(i));
            i += 1;
          }
          return paramUri.toString();
        }
      }
    }
  }
  
  public String b(Uri paramUri, boolean paramBoolean)
  {
    Object localObject = paramUri.getScheme();
    if ((localObject == null) || (((String)localObject).equals("file"))) {
      localObject = new File(paramUri.getPath()).getAbsolutePath();
    }
    for (;;)
    {
      return localObject;
      if (((String)localObject).equals("content")) {
        try
        {
          localObject = this.jdField_a_of_type_AndroidAppActivity.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
          int i = ((Cursor)localObject).getColumnIndexOrThrow("_data");
          ((Cursor)localObject).moveToFirst();
          String str = ((Cursor)localObject).getString(i);
          ((Cursor)localObject).close();
          localObject = str;
          if (!new File(str).canRead())
          {
            localObject = str;
            if (paramBoolean)
            {
              localObject = b(paramUri);
              return localObject;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          if (paramBoolean) {
            return b(paramUri);
          }
        }
      }
    }
    return null;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      a();
      b(a());
      if (this.jdField_a_of_type_Auyc != null)
      {
        this.jdField_a_of_type_Auyc.a(null);
        this.jdField_a_of_type_Auyc = null;
        continue;
        a();
        continue;
        QLog.i("UriParserPathHelper", 1, "handleMessage.progress: " + paramMessage.arg1);
        if ((this.jdField_a_of_type_Bgpa != null) && (this.jdField_a_of_type_Bgpa.isShowing())) {
          this.jdField_a_of_type_Bgpa.setProgress(paramMessage.arg1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auxw
 * JD-Core Version:    0.7.0.1
 */