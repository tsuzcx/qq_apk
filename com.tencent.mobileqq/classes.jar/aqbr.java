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
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class aqbr
  implements Handler.Callback
{
  public static String a;
  private static ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private Activity jdField_a_of_type_AndroidAppActivity;
  public Context a;
  private aqbx jdField_a_of_type_Aqbx;
  private bafb jdField_a_of_type_Bafb;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new beez(Looper.getMainLooper(), this, true);
  public boolean a;
  public boolean b;
  private boolean c;
  
  public aqbr(Activity paramActivity, boolean paramBoolean, aqbx paramaqbx)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
    this.c = paramBoolean;
    this.jdField_a_of_type_Aqbx = paramaqbx;
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
    if (this.jdField_a_of_type_Bafb != null) {
      this.jdField_a_of_type_Bafb.dismiss();
    }
  }
  
  private void a(Uri paramUri, String paramString, InputStream paramInputStream, long paramLong)
  {
    this.jdField_a_of_type_Boolean = true;
    ThreadManager.post(new UriParserPathHelper.3(this, paramString, paramInputStream, paramLong, paramUri), 5, null, true);
    if (!this.c) {
      return;
    }
    if (this.jdField_a_of_type_Bafb == null)
    {
      this.jdField_a_of_type_Bafb = babr.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext.getString(2131625736), ajjy.a(2131650138), new aqbu(this));
      this.jdField_a_of_type_Bafb.setOnDismissListener(new aqbv(this));
    }
    this.jdField_a_of_type_Bafb.show();
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
  private String b(Uri paramUri)
  {
    // Byte code:
    //   0: getstatic 27	aqbr:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_1
    //   4: invokevirtual 195	android/net/Uri:toString	()Ljava/lang/String;
    //   7: invokevirtual 199	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
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
    //   39: putstatic 201	aqbr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: aload_0
    //   43: getfield 45	aqbr:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   46: invokevirtual 204	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
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
    //   65: ifnonnull +31 -> 96
    //   68: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   71: ifeq +11 -> 82
    //   74: ldc 211
    //   76: iconst_2
    //   77: ldc 213
    //   79: invokestatic 217	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   82: aload 6
    //   84: ifnull +10 -> 94
    //   87: aload 6
    //   89: invokeinterface 104 1 0
    //   94: aconst_null
    //   95: areturn
    //   96: aload 6
    //   98: ldc 219
    //   100: invokeinterface 222 2 0
    //   105: istore_2
    //   106: aload 6
    //   108: ldc 224
    //   110: invokeinterface 222 2 0
    //   115: istore_3
    //   116: aload 6
    //   118: invokeinterface 93 1 0
    //   123: pop
    //   124: aload 6
    //   126: iload_3
    //   127: invokeinterface 228 2 0
    //   132: lstore 4
    //   134: lload 4
    //   136: l2f
    //   137: invokestatic 233	bace:c	()F
    //   140: fcmpl
    //   141: ifle +29 -> 170
    //   144: aload_0
    //   145: getfield 45	aqbr:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   148: ldc 234
    //   150: invokevirtual 235	android/app/Activity:getString	(I)Ljava/lang/String;
    //   153: putstatic 201	aqbr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   156: aload 6
    //   158: ifnull +10 -> 168
    //   161: aload 6
    //   163: invokeinterface 104 1 0
    //   168: aconst_null
    //   169: areturn
    //   170: iload_2
    //   171: iconst_m1
    //   172: if_icmpne +148 -> 320
    //   175: new 237	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   182: invokestatic 178	java/lang/System:currentTimeMillis	()J
    //   185: invokevirtual 242	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   188: ldc 244
    //   190: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: astore 7
    //   198: new 237	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   205: aload_0
    //   206: getfield 45	aqbr:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   209: invokevirtual 252	android/app/Activity:getExternalCacheDir	()Ljava/io/File;
    //   212: invokevirtual 255	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   215: ldc_w 257
    //   218: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: ldc_w 259
    //   224: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc_w 257
    //   230: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: astore 9
    //   238: new 237	java/lang/StringBuilder
    //   241: dup
    //   242: invokespecial 238	java/lang/StringBuilder:<init>	()V
    //   245: aload 9
    //   247: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload 9
    //   252: aload 7
    //   254: invokestatic 262	bace:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   257: invokevirtual 247	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: invokevirtual 248	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   263: astore 7
    //   265: aload 9
    //   267: invokestatic 264	aqbr:a	(Ljava/lang/String;)V
    //   270: new 163	java/io/File
    //   273: dup
    //   274: aload 9
    //   276: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   279: astore 9
    //   281: aload 9
    //   283: invokevirtual 168	java/io/File:exists	()Z
    //   286: ifne +47 -> 333
    //   289: aload 9
    //   291: invokevirtual 267	java/io/File:mkdirs	()Z
    //   294: ifne +39 -> 333
    //   297: ldc_w 268
    //   300: invokestatic 134	ajjy:a	(I)Ljava/lang/String;
    //   303: putstatic 201	aqbr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   306: aload 6
    //   308: ifnull +10 -> 318
    //   311: aload 6
    //   313: invokeinterface 104 1 0
    //   318: aconst_null
    //   319: areturn
    //   320: aload 6
    //   322: iload_2
    //   323: invokeinterface 101 2 0
    //   328: astore 7
    //   330: goto -132 -> 198
    //   333: aload 8
    //   335: aload_1
    //   336: invokevirtual 272	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   339: astore 8
    //   341: aload 8
    //   343: ifnonnull +32 -> 375
    //   346: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +12 -> 361
    //   352: ldc 211
    //   354: iconst_2
    //   355: ldc_w 274
    //   358: invokestatic 217	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: aload 6
    //   363: ifnull +10 -> 373
    //   366: aload 6
    //   368: invokeinterface 104 1 0
    //   373: aconst_null
    //   374: areturn
    //   375: lload 4
    //   377: ldc2_w 275
    //   380: lcmp
    //   381: ifle +153 -> 534
    //   384: aload_0
    //   385: iconst_1
    //   386: putfield 278	aqbr:b	Z
    //   389: new 110	bafb
    //   392: dup
    //   393: aload_0
    //   394: getfield 45	aqbr:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   397: ldc_w 279
    //   400: invokespecial 282	bafb:<init>	(Landroid/content/Context;I)V
    //   403: astore 9
    //   405: aload 9
    //   407: ldc_w 283
    //   410: invokevirtual 287	bafb:setContentView	(I)V
    //   413: aload 9
    //   415: aload_0
    //   416: getfield 57	aqbr:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   419: ldc_w 288
    //   422: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   425: invokevirtual 292	bafb:setTitle	(Ljava/lang/String;)Lbafb;
    //   428: pop
    //   429: aload 9
    //   431: aload_0
    //   432: getfield 57	aqbr:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   435: ldc_w 293
    //   438: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   441: invokevirtual 297	bafb:setMessage	(Ljava/lang/CharSequence;)Lbafb;
    //   444: pop
    //   445: aload 9
    //   447: iconst_0
    //   448: invokevirtual 301	bafb:setCanceledOnTouchOutside	(Z)V
    //   451: aload 9
    //   453: iconst_0
    //   454: invokevirtual 304	bafb:setCancelable	(Z)V
    //   457: aload 9
    //   459: aload_0
    //   460: getfield 57	aqbr:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   463: ldc_w 305
    //   466: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   469: new 307	aqbs
    //   472: dup
    //   473: aload_0
    //   474: aload 8
    //   476: invokespecial 310	aqbs:<init>	(Laqbr;Ljava/io/InputStream;)V
    //   479: invokevirtual 314	bafb:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbafb;
    //   482: pop
    //   483: aload 9
    //   485: aload_0
    //   486: getfield 57	aqbr:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   489: ldc_w 315
    //   492: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   495: new 317	aqbt
    //   498: dup
    //   499: aload_0
    //   500: aload_1
    //   501: aload 7
    //   503: aload 8
    //   505: lload 4
    //   507: invokespecial 319	aqbt:<init>	(Laqbr;Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   510: invokevirtual 322	bafb:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lbafb;
    //   513: pop
    //   514: aload 9
    //   516: invokevirtual 154	bafb:show	()V
    //   519: aload 6
    //   521: ifnull +10 -> 531
    //   524: aload 6
    //   526: invokeinterface 104 1 0
    //   531: aload 7
    //   533: areturn
    //   534: aload_0
    //   535: aload_1
    //   536: aload 7
    //   538: aload 8
    //   540: lload 4
    //   542: invokespecial 157	aqbr:a	(Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   545: goto -26 -> 519
    //   548: astore 7
    //   550: aload 6
    //   552: astore_1
    //   553: aload 7
    //   555: astore 6
    //   557: aload_0
    //   558: iconst_0
    //   559: putfield 116	aqbr:jdField_a_of_type_Boolean	Z
    //   562: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq +14 -> 579
    //   568: ldc 211
    //   570: iconst_2
    //   571: ldc_w 324
    //   574: aload 6
    //   576: invokestatic 327	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   579: aload_1
    //   580: ifnull +9 -> 589
    //   583: aload_1
    //   584: invokeinterface 104 1 0
    //   589: aconst_null
    //   590: areturn
    //   591: astore_1
    //   592: aconst_null
    //   593: astore 6
    //   595: aload 6
    //   597: ifnull +10 -> 607
    //   600: aload 6
    //   602: invokeinterface 104 1 0
    //   607: aload_1
    //   608: athrow
    //   609: astore_1
    //   610: goto -15 -> 595
    //   613: astore 7
    //   615: aload_1
    //   616: astore 6
    //   618: aload 7
    //   620: astore_1
    //   621: goto -26 -> 595
    //   624: astore 6
    //   626: aconst_null
    //   627: astore_1
    //   628: goto -71 -> 557
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	this	aqbr
    //   0	631	1	paramUri	Uri
    //   105	218	2	i	int
    //   115	12	3	j	int
    //   132	409	4	l	long
    //   13	604	6	localObject1	Object
    //   624	1	6	localException1	Exception
    //   196	341	7	str	String
    //   548	6	7	localException2	Exception
    //   613	6	7	localObject2	Object
    //   49	490	8	localObject3	Object
    //   236	279	9	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   68	82	548	java/lang/Exception
    //   96	156	548	java/lang/Exception
    //   175	198	548	java/lang/Exception
    //   198	306	548	java/lang/Exception
    //   320	330	548	java/lang/Exception
    //   333	341	548	java/lang/Exception
    //   346	361	548	java/lang/Exception
    //   384	519	548	java/lang/Exception
    //   534	545	548	java/lang/Exception
    //   51	63	591	finally
    //   68	82	609	finally
    //   96	156	609	finally
    //   175	198	609	finally
    //   198	306	609	finally
    //   320	330	609	finally
    //   333	341	609	finally
    //   346	361	609	finally
    //   384	519	609	finally
    //   534	545	609	finally
    //   557	579	613	finally
    //   51	63	624	java/lang/Exception
  }
  
  private void b(String paramString)
  {
    if (!this.c) {}
    bafb localbafb;
    do
    {
      return;
      localbafb = new bafb(this.jdField_a_of_type_AndroidAppActivity, 2131690181);
      localbafb.setContentView(2131493345);
      localbafb.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131654355));
      localbafb.setMessage(paramString);
      localbafb.setCanceledOnTouchOutside(false);
      localbafb.setCancelable(false);
      localbafb.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131625011), new aqbw(this));
    } while (this.jdField_a_of_type_AndroidAppActivity.isFinishing());
    localbafb.show();
  }
  
  protected String a()
  {
    if (jdField_a_of_type_JavaLangString == null) {
      return this.jdField_a_of_type_AndroidContentContext.getString(2131653600);
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
    if ((befo.l()) && ("com.android.fileexplorer.fileprovider".equalsIgnoreCase(paramUri.getAuthority())))
    {
      localObject1 = paramUri.getPathSegments();
      if ((((List)localObject1).size() >= 2) && ("external_files".equalsIgnoreCase((String)((List)localObject1).get(0))))
      {
        paramUri = paramUri.getPath().replaceFirst("\\/external_files", ajed.aT);
        if (QLog.isColorLevel()) {
          QLog.d("UriParserPathHelper", 2, "Nougat path: " + paramUri);
        }
        return paramUri;
      }
    }
    else if (befo.i())
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
      if (this.jdField_a_of_type_Aqbx != null)
      {
        this.jdField_a_of_type_Aqbx.a(null);
        this.jdField_a_of_type_Aqbx = null;
        continue;
        a();
        continue;
        QLog.i("UriParserPathHelper", 2, "progress: " + paramMessage.arg1);
        if ((this.jdField_a_of_type_Bafb != null) && (this.jdField_a_of_type_Bafb.isShowing())) {
          this.jdField_a_of_type_Bafb.setProgress(paramMessage.arg1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqbr
 * JD-Core Version:    0.7.0.1
 */