import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video.Media;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper.3;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class avit
  implements Handler.Callback
{
  public static String a;
  private static ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private Activity jdField_a_of_type_AndroidAppActivity;
  public Context a;
  private aviz jdField_a_of_type_Aviz;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bkyc(Looper.getMainLooper(), this, true);
  public boolean a;
  public boolean b;
  private boolean c;
  
  public avit(Activity paramActivity, boolean paramBoolean, aviz paramaviz)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
    this.c = paramBoolean;
    this.jdField_a_of_type_Aviz = paramaviz;
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
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    }
  }
  
  private void a(Uri paramUri, String paramString, InputStream paramInputStream, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.post(new UriParserPathHelper.3(this, paramString, paramInputStream, paramLong, paramUri), 5, null, true);
    if (!this.c) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bhdj.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext.getString(2131691269), anvx.a(2131715292), new aviw(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new avix(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.show();
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
    //   2: aconst_null
    //   3: astore 8
    //   5: aload_0
    //   6: ifnonnull +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aload_0
    //   12: invokevirtual 195	android/net/Uri:getScheme	()Ljava/lang/String;
    //   15: astore 7
    //   17: new 197	java/lang/StringBuilder
    //   20: dup
    //   21: ldc 199
    //   23: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: astore 9
    //   28: aload 9
    //   30: ldc 202
    //   32: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_0
    //   36: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   39: pop
    //   40: aload 7
    //   42: ifnull +13 -> 55
    //   45: aload 7
    //   47: ldc 211
    //   49: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   52: ifeq +237 -> 289
    //   55: new 163	java/io/File
    //   58: dup
    //   59: aload_0
    //   60: invokevirtual 218	android/net/Uri:getPath	()Ljava/lang/String;
    //   63: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore 7
    //   68: aload 7
    //   70: ifnull +572 -> 642
    //   73: aload 7
    //   75: invokevirtual 221	java/io/File:canRead	()Z
    //   78: istore 4
    //   80: iload 4
    //   82: ifeq +560 -> 642
    //   85: iconst_1
    //   86: istore_3
    //   87: iload_3
    //   88: istore 4
    //   90: aload 9
    //   92: ldc 223
    //   94: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload_3
    //   98: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: iload_3
    //   103: ifne +526 -> 629
    //   106: aload_1
    //   107: ifnull +522 -> 629
    //   110: aload_1
    //   111: invokevirtual 77	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   114: astore 10
    //   116: aload 10
    //   118: aload_0
    //   119: aconst_null
    //   120: aconst_null
    //   121: aconst_null
    //   122: aconst_null
    //   123: invokevirtual 87	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   126: astore_1
    //   127: iload_3
    //   128: istore 5
    //   130: aload_1
    //   131: ifnull +130 -> 261
    //   134: iload_3
    //   135: istore 5
    //   137: iload_3
    //   138: istore 6
    //   140: aload_1
    //   141: ldc 228
    //   143: invokeinterface 231 2 0
    //   148: istore_2
    //   149: iload_3
    //   150: istore 5
    //   152: iload_3
    //   153: istore 6
    //   155: aload_1
    //   156: invokeinterface 93 1 0
    //   161: pop
    //   162: iload_2
    //   163: iconst_m1
    //   164: if_icmpne +348 -> 512
    //   167: aload 8
    //   169: astore 7
    //   171: iload_3
    //   172: istore 5
    //   174: iload_3
    //   175: istore 6
    //   177: aload 10
    //   179: aload_0
    //   180: invokevirtual 235	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   183: astore_0
    //   184: iload_3
    //   185: istore 4
    //   187: aload_0
    //   188: ifnull +49 -> 237
    //   191: iload_3
    //   192: istore 4
    //   194: iload_3
    //   195: istore 5
    //   197: iload_3
    //   198: istore 6
    //   200: aload 7
    //   202: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   205: ifne +32 -> 237
    //   208: iload_3
    //   209: istore 5
    //   211: iload_3
    //   212: istore 6
    //   214: ldc 243
    //   216: iconst_1
    //   217: iconst_2
    //   218: anewarray 4	java/lang/Object
    //   221: dup
    //   222: iconst_0
    //   223: ldc 245
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: aload 7
    //   230: aastore
    //   231: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   234: iconst_1
    //   235: istore 4
    //   237: iload 4
    //   239: istore 5
    //   241: aload_0
    //   242: ifnull +19 -> 261
    //   245: iload 4
    //   247: istore 5
    //   249: iload 4
    //   251: istore 6
    //   253: aload_0
    //   254: invokevirtual 254	java/io/InputStream:close	()V
    //   257: iload 4
    //   259: istore 5
    //   261: iload 5
    //   263: istore_3
    //   264: aload_1
    //   265: ifnull +9 -> 274
    //   268: aload_1
    //   269: invokeinterface 104 1 0
    //   274: aload 9
    //   276: ldc_w 256
    //   279: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: iload_3
    //   283: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: iload_3
    //   288: ireturn
    //   289: aload 7
    //   291: ldc_w 258
    //   294: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   297: istore 4
    //   299: iload 4
    //   301: ifeq +336 -> 637
    //   304: aload_1
    //   305: invokevirtual 77	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   308: aload_0
    //   309: iconst_1
    //   310: anewarray 79	java/lang/String
    //   313: dup
    //   314: iconst_0
    //   315: ldc 81
    //   317: aastore
    //   318: aconst_null
    //   319: aconst_null
    //   320: aconst_null
    //   321: invokevirtual 87	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   324: astore 7
    //   326: aload 7
    //   328: ldc 81
    //   330: invokeinterface 97 2 0
    //   335: istore_2
    //   336: aload 7
    //   338: invokeinterface 93 1 0
    //   343: pop
    //   344: aload 7
    //   346: iload_2
    //   347: invokeinterface 101 2 0
    //   352: astore 10
    //   354: aload 7
    //   356: invokeinterface 104 1 0
    //   361: aload 10
    //   363: invokestatic 241	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   366: ifne +266 -> 632
    //   369: ldc 243
    //   371: iconst_1
    //   372: iconst_2
    //   373: anewarray 4	java/lang/Object
    //   376: dup
    //   377: iconst_0
    //   378: ldc_w 260
    //   381: aastore
    //   382: dup
    //   383: iconst_1
    //   384: aload 10
    //   386: aastore
    //   387: invokestatic 263	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   390: new 163	java/io/File
    //   393: dup
    //   394: aload 10
    //   396: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   399: astore 7
    //   401: aload 7
    //   403: ifnull +229 -> 632
    //   406: aload 7
    //   408: invokevirtual 221	java/io/File:canRead	()Z
    //   411: istore 4
    //   413: iload 4
    //   415: ifeq +217 -> 632
    //   418: iconst_1
    //   419: istore_3
    //   420: iload_3
    //   421: istore 4
    //   423: aload 9
    //   425: ldc_w 265
    //   428: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: iload_3
    //   432: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: goto -334 -> 102
    //   439: astore 7
    //   441: iload 4
    //   443: istore_3
    //   444: ldc 243
    //   446: iconst_1
    //   447: ldc_w 267
    //   450: aload 7
    //   452: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   455: goto -353 -> 102
    //   458: astore 7
    //   460: ldc 243
    //   462: iconst_1
    //   463: ldc_w 272
    //   466: aload 7
    //   468: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   471: aload 9
    //   473: ldc_w 265
    //   476: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: iconst_0
    //   480: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: iconst_0
    //   485: istore_3
    //   486: goto -384 -> 102
    //   489: astore 7
    //   491: aload 9
    //   493: ldc_w 265
    //   496: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: iconst_0
    //   500: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   503: pop
    //   504: aload 7
    //   506: athrow
    //   507: astore 7
    //   509: goto -65 -> 444
    //   512: iload_3
    //   513: istore 5
    //   515: iload_3
    //   516: istore 6
    //   518: aload_1
    //   519: iload_2
    //   520: invokeinterface 101 2 0
    //   525: astore 7
    //   527: goto -356 -> 171
    //   530: astore_1
    //   531: aconst_null
    //   532: astore_0
    //   533: ldc 243
    //   535: iconst_1
    //   536: ldc_w 274
    //   539: aload_1
    //   540: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   543: aload_0
    //   544: ifnull +9 -> 553
    //   547: aload_0
    //   548: invokeinterface 104 1 0
    //   553: aload 9
    //   555: ldc_w 256
    //   558: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: iload_3
    //   562: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   565: pop
    //   566: goto -279 -> 287
    //   569: astore_0
    //   570: aconst_null
    //   571: astore_1
    //   572: aload_1
    //   573: ifnull +9 -> 582
    //   576: aload_1
    //   577: invokeinterface 104 1 0
    //   582: aload 9
    //   584: ldc_w 256
    //   587: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: iload_3
    //   591: invokevirtual 226	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   594: pop
    //   595: aload_0
    //   596: athrow
    //   597: astore_0
    //   598: iload 5
    //   600: istore_3
    //   601: goto -29 -> 572
    //   604: astore_1
    //   605: aload_0
    //   606: astore 7
    //   608: aload_1
    //   609: astore_0
    //   610: aload 7
    //   612: astore_1
    //   613: goto -41 -> 572
    //   616: astore 7
    //   618: aload_1
    //   619: astore_0
    //   620: aload 7
    //   622: astore_1
    //   623: iload 6
    //   625: istore_3
    //   626: goto -93 -> 533
    //   629: goto -342 -> 287
    //   632: iconst_0
    //   633: istore_3
    //   634: goto -214 -> 420
    //   637: iconst_0
    //   638: istore_3
    //   639: goto -537 -> 102
    //   642: iconst_0
    //   643: istore_3
    //   644: goto -557 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	647	0	paramUri	Uri
    //   0	647	1	paramContext	Context
    //   148	372	2	i	int
    //   1	643	3	bool1	boolean
    //   78	364	4	bool2	boolean
    //   128	471	5	bool3	boolean
    //   138	486	6	bool4	boolean
    //   15	392	7	localObject1	Object
    //   439	12	7	localException1	Exception
    //   458	9	7	localThrowable	Throwable
    //   489	16	7	localObject2	Object
    //   507	1	7	localException2	Exception
    //   525	86	7	localObject3	Object
    //   616	5	7	localException3	Exception
    //   3	165	8	localObject4	Object
    //   26	557	9	localStringBuilder	StringBuilder
    //   114	281	10	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   90	102	439	java/lang/Exception
    //   423	436	439	java/lang/Exception
    //   304	401	458	java/lang/Throwable
    //   406	413	458	java/lang/Throwable
    //   304	401	489	finally
    //   406	413	489	finally
    //   460	471	489	finally
    //   45	55	507	java/lang/Exception
    //   55	68	507	java/lang/Exception
    //   73	80	507	java/lang/Exception
    //   289	299	507	java/lang/Exception
    //   471	484	507	java/lang/Exception
    //   491	507	507	java/lang/Exception
    //   110	127	530	java/lang/Exception
    //   110	127	569	finally
    //   140	149	597	finally
    //   155	162	597	finally
    //   177	184	597	finally
    //   200	208	597	finally
    //   214	234	597	finally
    //   253	257	597	finally
    //   518	527	597	finally
    //   533	543	604	finally
    //   140	149	616	java/lang/Exception
    //   155	162	616	java/lang/Exception
    //   177	184	616	java/lang/Exception
    //   200	208	616	java/lang/Exception
    //   214	234	616	java/lang/Exception
    //   253	257	616	java/lang/Exception
    //   518	527	616	java/lang/Exception
  }
  
  /* Error */
  private String b(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 45	avit:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   4: invokevirtual 278	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   7: aload_1
    //   8: iconst_1
    //   9: anewarray 79	java/lang/String
    //   12: dup
    //   13: iconst_0
    //   14: ldc 81
    //   16: aastore
    //   17: aconst_null
    //   18: aconst_null
    //   19: aconst_null
    //   20: invokevirtual 87	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   23: astore_1
    //   24: aload_1
    //   25: astore_3
    //   26: aload_1
    //   27: ldc 81
    //   29: invokeinterface 97 2 0
    //   34: istore_2
    //   35: aload_1
    //   36: astore_3
    //   37: aload_1
    //   38: invokeinterface 93 1 0
    //   43: pop
    //   44: aload_1
    //   45: astore_3
    //   46: aload_1
    //   47: iload_2
    //   48: invokeinterface 101 2 0
    //   53: astore 4
    //   55: aload 4
    //   57: astore_3
    //   58: aload_1
    //   59: ifnull +12 -> 71
    //   62: aload_1
    //   63: invokeinterface 104 1 0
    //   68: aload 4
    //   70: astore_3
    //   71: aload_3
    //   72: areturn
    //   73: astore 4
    //   75: aconst_null
    //   76: astore_1
    //   77: aload_1
    //   78: astore_3
    //   79: ldc 243
    //   81: iconst_1
    //   82: ldc_w 280
    //   85: aload 4
    //   87: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: ldc_w 282
    //   93: astore_3
    //   94: aload_1
    //   95: ifnull -24 -> 71
    //   98: aload_1
    //   99: invokeinterface 104 1 0
    //   104: ldc_w 282
    //   107: areturn
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_3
    //   111: aload_3
    //   112: ifnull +9 -> 121
    //   115: aload_3
    //   116: invokeinterface 104 1 0
    //   121: aload_1
    //   122: athrow
    //   123: astore_1
    //   124: goto -13 -> 111
    //   127: astore 4
    //   129: goto -52 -> 77
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	avit
    //   0	132	1	paramUri	Uri
    //   34	14	2	i	int
    //   25	91	3	localObject	Object
    //   53	16	4	str	String
    //   73	13	4	localException1	Exception
    //   127	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	24	73	java/lang/Exception
    //   0	24	108	finally
    //   26	35	123	finally
    //   37	44	123	finally
    //   46	55	123	finally
    //   79	90	123	finally
    //   26	35	127	java/lang/Exception
    //   37	44	127	java/lang/Exception
    //   46	55	127	java/lang/Exception
  }
  
  private void b(String paramString)
  {
    if (!this.c) {}
    QQCustomDialog localQQCustomDialog;
    do
    {
      return;
      localQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131755829);
      localQQCustomDialog.setContentView(2131559043);
      localQQCustomDialog.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131719342));
      localQQCustomDialog.setMessage(paramString);
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      localQQCustomDialog.setCancelable(false);
      localQQCustomDialog.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690676), new aviy(this));
    } while (this.jdField_a_of_type_AndroidAppActivity.isFinishing());
    localQQCustomDialog.show();
  }
  
  /* Error */
  private String c(Uri paramUri)
  {
    // Byte code:
    //   0: getstatic 27	avit:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_1
    //   4: invokevirtual 321	android/net/Uri:toString	()Ljava/lang/String;
    //   7: invokevirtual 325	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   10: checkcast 79	java/lang/String
    //   13: astore 8
    //   15: aload 8
    //   17: ifnull +21 -> 38
    //   20: new 163	java/io/File
    //   23: dup
    //   24: aload 8
    //   26: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   29: invokevirtual 168	java/io/File:exists	()Z
    //   32: ifeq +6 -> 38
    //   35: aload 8
    //   37: areturn
    //   38: aconst_null
    //   39: putstatic 327	avit:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: aload_0
    //   43: getfield 45	avit:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   46: invokevirtual 278	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   49: astore 12
    //   51: aload 12
    //   53: aload_1
    //   54: aconst_null
    //   55: aconst_null
    //   56: aconst_null
    //   57: aconst_null
    //   58: invokevirtual 87	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   61: astore 9
    //   63: aload 9
    //   65: ifnonnull +26 -> 91
    //   68: ldc 243
    //   70: iconst_1
    //   71: ldc_w 329
    //   74: invokestatic 333	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload 9
    //   79: ifnull +10 -> 89
    //   82: aload 9
    //   84: invokeinterface 104 1 0
    //   89: aconst_null
    //   90: areturn
    //   91: aload 9
    //   93: ldc 228
    //   95: invokeinterface 231 2 0
    //   100: istore_2
    //   101: aload 9
    //   103: ldc_w 335
    //   106: invokeinterface 231 2 0
    //   111: istore_3
    //   112: aload 9
    //   114: invokeinterface 93 1 0
    //   119: pop
    //   120: aload 9
    //   122: iload_3
    //   123: invokeinterface 339 2 0
    //   128: lstore 6
    //   130: iload_2
    //   131: iconst_m1
    //   132: if_icmpne +80 -> 212
    //   135: new 197	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   142: invokestatic 178	java/lang/System:currentTimeMillis	()J
    //   145: invokevirtual 343	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   148: ldc_w 282
    //   151: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: astore 8
    //   159: aload 8
    //   161: astore 10
    //   163: lload 6
    //   165: lstore 4
    //   167: aload 9
    //   169: ifnull +18 -> 187
    //   172: aload 9
    //   174: invokeinterface 104 1 0
    //   179: lload 6
    //   181: lstore 4
    //   183: aload 8
    //   185: astore 10
    //   187: lload 4
    //   189: l2f
    //   190: invokestatic 350	com/tencent/mobileqq/utils/FileUtils:getAvailableExternalMemorySize	()F
    //   193: fcmpl
    //   194: ifle +208 -> 402
    //   197: aload_0
    //   198: getfield 45	avit:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   201: ldc_w 351
    //   204: invokevirtual 352	android/app/Activity:getString	(I)Ljava/lang/String;
    //   207: putstatic 327	avit:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   210: aconst_null
    //   211: areturn
    //   212: aload 9
    //   214: iload_2
    //   215: invokeinterface 101 2 0
    //   220: astore 8
    //   222: goto -63 -> 159
    //   225: astore 9
    //   227: aconst_null
    //   228: astore 8
    //   230: ldc 243
    //   232: iconst_1
    //   233: ldc_w 280
    //   236: aload 9
    //   238: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   241: ldc_w 354
    //   244: aload_1
    //   245: invokevirtual 357	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   248: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifne +40 -> 291
    //   254: ldc 243
    //   256: iconst_1
    //   257: iconst_2
    //   258: anewarray 4	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: ldc_w 359
    //   266: aastore
    //   267: dup
    //   268: iconst_1
    //   269: aload_1
    //   270: invokevirtual 357	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   273: aastore
    //   274: invokestatic 251	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   277: aload 8
    //   279: ifnull +10 -> 289
    //   282: aload 8
    //   284: invokeinterface 104 1 0
    //   289: aconst_null
    //   290: areturn
    //   291: new 163	java/io/File
    //   294: dup
    //   295: aload_0
    //   296: aload_1
    //   297: invokespecial 361	avit:b	(Landroid/net/Uri;)Ljava/lang/String;
    //   300: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   303: invokevirtual 364	java/io/File:getName	()Ljava/lang/String;
    //   306: astore 11
    //   308: aload_0
    //   309: getfield 45	avit:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   312: invokevirtual 278	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   315: aload_1
    //   316: invokevirtual 235	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   319: invokevirtual 368	java/io/InputStream:available	()I
    //   322: istore_2
    //   323: iload_2
    //   324: i2l
    //   325: lstore 6
    //   327: aload 11
    //   329: astore 10
    //   331: lload 6
    //   333: lstore 4
    //   335: aload 8
    //   337: ifnull -150 -> 187
    //   340: aload 8
    //   342: invokeinterface 104 1 0
    //   347: aload 11
    //   349: astore 10
    //   351: lload 6
    //   353: lstore 4
    //   355: goto -168 -> 187
    //   358: astore_1
    //   359: ldc 243
    //   361: iconst_1
    //   362: ldc_w 370
    //   365: aload 9
    //   367: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   370: aload 8
    //   372: ifnull +10 -> 382
    //   375: aload 8
    //   377: invokeinterface 104 1 0
    //   382: aconst_null
    //   383: areturn
    //   384: astore_1
    //   385: aconst_null
    //   386: astore 8
    //   388: aload 8
    //   390: ifnull +10 -> 400
    //   393: aload 8
    //   395: invokeinterface 104 1 0
    //   400: aload_1
    //   401: athrow
    //   402: new 197	java/lang/StringBuilder
    //   405: dup
    //   406: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   409: aload_0
    //   410: getfield 45	avit:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   413: invokevirtual 374	android/app/Activity:getExternalCacheDir	()Ljava/io/File;
    //   416: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   419: ldc_w 376
    //   422: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc_w 378
    //   428: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc_w 376
    //   434: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: astore 9
    //   442: new 197	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 340	java/lang/StringBuilder:<init>	()V
    //   449: aload 9
    //   451: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload 9
    //   456: aload 10
    //   458: invokestatic 382	com/tencent/mobileqq/utils/FileUtils:getUnitFileName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   461: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: astore 8
    //   469: aload 9
    //   471: invokestatic 384	avit:a	(Ljava/lang/String;)V
    //   474: new 163	java/io/File
    //   477: dup
    //   478: aload 9
    //   480: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   483: astore 9
    //   485: aload 9
    //   487: invokevirtual 168	java/io/File:exists	()Z
    //   490: ifne +22 -> 512
    //   493: aload 9
    //   495: invokevirtual 387	java/io/File:mkdirs	()Z
    //   498: ifne +14 -> 512
    //   501: ldc_w 388
    //   504: invokestatic 134	anvx:a	(I)Ljava/lang/String;
    //   507: putstatic 327	avit:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   510: aconst_null
    //   511: areturn
    //   512: aload 12
    //   514: aload_1
    //   515: invokevirtual 235	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   518: astore 9
    //   520: aload 9
    //   522: ifnonnull +14 -> 536
    //   525: ldc 243
    //   527: iconst_1
    //   528: ldc_w 390
    //   531: invokestatic 333	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: aconst_null
    //   535: areturn
    //   536: lload 4
    //   538: ldc2_w 391
    //   541: lcmp
    //   542: ifle +141 -> 683
    //   545: aload_0
    //   546: iconst_1
    //   547: putfield 394	avit:b	Z
    //   550: new 110	com/tencent/mobileqq/utils/QQCustomDialog
    //   553: dup
    //   554: aload_0
    //   555: getfield 45	avit:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   558: ldc_w 283
    //   561: invokespecial 286	com/tencent/mobileqq/utils/QQCustomDialog:<init>	(Landroid/content/Context;I)V
    //   564: astore 10
    //   566: aload 10
    //   568: ldc_w 287
    //   571: invokevirtual 291	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   574: aload 10
    //   576: aload_0
    //   577: getfield 57	avit:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   580: ldc_w 292
    //   583: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   586: invokevirtual 296	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   589: pop
    //   590: aload 10
    //   592: aload_0
    //   593: getfield 57	avit:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   596: ldc_w 395
    //   599: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   602: invokevirtual 300	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   605: pop
    //   606: aload 10
    //   608: iconst_0
    //   609: invokevirtual 304	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   612: aload 10
    //   614: iconst_0
    //   615: invokevirtual 307	com/tencent/mobileqq/utils/QQCustomDialog:setCancelable	(Z)V
    //   618: aload 10
    //   620: aload_0
    //   621: getfield 57	avit:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   624: ldc_w 396
    //   627: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   630: new 398	aviu
    //   633: dup
    //   634: aload_0
    //   635: aload 9
    //   637: invokespecial 401	aviu:<init>	(Lavit;Ljava/io/InputStream;)V
    //   640: invokevirtual 315	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   643: pop
    //   644: aload 10
    //   646: aload_0
    //   647: getfield 57	avit:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   650: ldc_w 402
    //   653: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   656: new 404	aviv
    //   659: dup
    //   660: aload_0
    //   661: aload_1
    //   662: aload 8
    //   664: aload 9
    //   666: lload 4
    //   668: invokespecial 406	aviv:<init>	(Lavit;Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   671: invokevirtual 409	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   674: pop
    //   675: aload 10
    //   677: invokevirtual 154	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   680: goto +60 -> 740
    //   683: aload_0
    //   684: aload_1
    //   685: aload 8
    //   687: aload 9
    //   689: lload 4
    //   691: invokespecial 157	avit:a	(Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   694: goto +46 -> 740
    //   697: astore_1
    //   698: aload_0
    //   699: iconst_0
    //   700: putfield 116	avit:jdField_a_of_type_Boolean	Z
    //   703: ldc 243
    //   705: iconst_1
    //   706: ldc_w 411
    //   709: aload_1
    //   710: invokestatic 270	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   713: aconst_null
    //   714: areturn
    //   715: astore_1
    //   716: aload 9
    //   718: astore 8
    //   720: goto -332 -> 388
    //   723: astore_1
    //   724: goto -336 -> 388
    //   727: astore 10
    //   729: aload 9
    //   731: astore 8
    //   733: aload 10
    //   735: astore 9
    //   737: goto -507 -> 230
    //   740: aload 8
    //   742: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	743	0	this	avit
    //   0	743	1	paramUri	Uri
    //   100	224	2	i	int
    //   111	12	3	j	int
    //   165	525	4	l1	long
    //   128	224	6	l2	long
    //   13	728	8	localObject1	Object
    //   61	152	9	localCursor	android.database.Cursor
    //   225	141	9	localException1	Exception
    //   440	296	9	localObject2	Object
    //   161	515	10	localObject3	Object
    //   727	7	10	localException2	Exception
    //   306	42	11	str	String
    //   49	464	12	localContentResolver	android.content.ContentResolver
    // Exception table:
    //   from	to	target	type
    //   51	63	225	java/lang/Exception
    //   291	323	358	java/lang/Exception
    //   51	63	384	finally
    //   402	510	697	java/lang/Exception
    //   512	520	697	java/lang/Exception
    //   525	534	697	java/lang/Exception
    //   545	680	697	java/lang/Exception
    //   683	694	697	java/lang/Exception
    //   68	77	715	finally
    //   91	130	715	finally
    //   135	159	715	finally
    //   212	222	715	finally
    //   230	277	723	finally
    //   291	323	723	finally
    //   359	370	723	finally
    //   68	77	727	java/lang/Exception
    //   91	130	727	java/lang/Exception
    //   135	159	727	java/lang/Exception
    //   212	222	727	java/lang/Exception
  }
  
  protected String a()
  {
    if (jdField_a_of_type_JavaLangString == null) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131718770);
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
        paramUri = paramUri.getPath().replaceFirst("\\/external_files", AppConstants.SDCARD_ROOT);
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
        break label471;
      }
    }
    label471:
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
            if (!"com.android.providers.media.documents".equals(paramUri.getAuthority())) {
              continue;
            }
            Object localObject3 = ((String)localObject1).split(":");
            localObject1 = localObject3[0];
            if ("image".equals(localObject1))
            {
              localObject1 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
              localObject3 = localObject3[1];
              if (localObject1 != null) {
                return a((Uri)localObject1, "_id=?", new String[] { localObject3 });
              }
            }
            else
            {
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
            QLog.e("UriParserPathHelper", 1, "getPathFromUri null == contentUri");
          }
        }
        catch (Exception localException)
        {
          boolean bool;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("UriParserPathHelper", 2, "handle exeption ", localException);
          continue;
        }
        return b(paramUri, paramBoolean);
        bool = "com.google.android.apps.photos.content".equals(paramUri.getAuthority());
        if (bool)
        {
          continue;
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
  }
  
  public String b(Uri paramUri, boolean paramBoolean)
  {
    QLog.e("UriParserPathHelper", 2, new Object[] { "getFilePathAsync copy", Boolean.valueOf(paramBoolean) });
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
          String str = b(paramUri);
          localObject = str;
          if (!new File(str).canRead())
          {
            localObject = str;
            if (paramBoolean)
            {
              localObject = c(paramUri);
              return localObject;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          if (QLog.isColorLevel()) {
            QLog.e("UriParserPathHelper", 2, "Exception", localThrowable);
          }
          if (paramBoolean) {
            return c(paramUri);
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
      if (this.jdField_a_of_type_Aviz != null)
      {
        this.jdField_a_of_type_Aviz.a(null);
        this.jdField_a_of_type_Aviz = null;
        continue;
        a();
        continue;
        QLog.i("UriParserPathHelper", 1, "handleMessage.progress: " + paramMessage.arg1);
        if ((this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.isShowing())) {
          this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setProgress(paramMessage.arg1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avit
 * JD-Core Version:    0.7.0.1
 */