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

public class aucz
  implements Handler.Callback
{
  public static String a;
  private static ConcurrentHashMap<String, String> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private Activity jdField_a_of_type_AndroidAppActivity;
  public Context a;
  private audf jdField_a_of_type_Audf;
  private QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  private final MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bjmp(Looper.getMainLooper(), this, true);
  public boolean a;
  public boolean b;
  private boolean c;
  
  public aucz(Activity paramActivity, boolean paramBoolean, audf paramaudf)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getApplication().getApplicationContext();
    this.c = paramBoolean;
    this.jdField_a_of_type_Audf = paramaudf;
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
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = bfur.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidContentContext.getString(2131691184), amtj.a(2131714944), new audc(this));
      this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(new audd(this));
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
    //   0: aload_0
    //   1: getfield 45	aucz:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   4: invokevirtual 275	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
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
    //   82: ldc_w 277
    //   85: aload 4
    //   87: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   90: ldc_w 279
    //   93: astore_3
    //   94: aload_1
    //   95: ifnull -24 -> 71
    //   98: aload_1
    //   99: invokeinterface 104 1 0
    //   104: ldc_w 279
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
    //   0	132	0	this	aucz
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
      localQQCustomDialog = new QQCustomDialog(this.jdField_a_of_type_AndroidAppActivity, 2131755826);
      localQQCustomDialog.setContentView(2131559016);
      localQQCustomDialog.setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131718947));
      localQQCustomDialog.setMessage(paramString);
      localQQCustomDialog.setCanceledOnTouchOutside(false);
      localQQCustomDialog.setCancelable(false);
      localQQCustomDialog.setNegativeButton(this.jdField_a_of_type_AndroidContentContext.getString(2131690599), new aude(this));
    } while (this.jdField_a_of_type_AndroidAppActivity.isFinishing());
    localQQCustomDialog.show();
  }
  
  /* Error */
  private String c(Uri paramUri)
  {
    // Byte code:
    //   0: getstatic 27	aucz:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   3: aload_1
    //   4: invokevirtual 318	android/net/Uri:toString	()Ljava/lang/String;
    //   7: invokevirtual 322	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
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
    //   39: putstatic 324	aucz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   42: aload_0
    //   43: getfield 45	aucz:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   46: invokevirtual 275	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
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
    //   71: ldc_w 326
    //   74: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   103: ldc_w 332
    //   106: invokeinterface 231 2 0
    //   111: istore_3
    //   112: aload 9
    //   114: invokeinterface 93 1 0
    //   119: pop
    //   120: aload 9
    //   122: iload_3
    //   123: invokeinterface 336 2 0
    //   128: lstore 6
    //   130: iload_2
    //   131: iconst_m1
    //   132: if_icmpne +80 -> 212
    //   135: new 197	java/lang/StringBuilder
    //   138: dup
    //   139: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   142: invokestatic 178	java/lang/System:currentTimeMillis	()J
    //   145: invokevirtual 340	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   148: ldc_w 279
    //   151: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
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
    //   190: invokestatic 347	com/tencent/mobileqq/utils/FileUtils:getAvailableExternalMemorySize	()F
    //   193: fcmpl
    //   194: ifle +208 -> 402
    //   197: aload_0
    //   198: getfield 45	aucz:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   201: ldc_w 348
    //   204: invokevirtual 349	android/app/Activity:getString	(I)Ljava/lang/String;
    //   207: putstatic 324	aucz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   233: ldc_w 277
    //   236: aload 9
    //   238: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   241: ldc_w 351
    //   244: aload_1
    //   245: invokevirtual 354	android/net/Uri:getAuthority	()Ljava/lang/String;
    //   248: invokevirtual 215	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   251: ifne +40 -> 291
    //   254: ldc 243
    //   256: iconst_1
    //   257: iconst_2
    //   258: anewarray 4	java/lang/Object
    //   261: dup
    //   262: iconst_0
    //   263: ldc_w 356
    //   266: aastore
    //   267: dup
    //   268: iconst_1
    //   269: aload_1
    //   270: invokevirtual 354	android/net/Uri:getAuthority	()Ljava/lang/String;
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
    //   297: invokespecial 358	aucz:b	(Landroid/net/Uri;)Ljava/lang/String;
    //   300: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   303: invokevirtual 361	java/io/File:getName	()Ljava/lang/String;
    //   306: astore 11
    //   308: aload_0
    //   309: getfield 45	aucz:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   312: invokevirtual 275	android/app/Activity:getContentResolver	()Landroid/content/ContentResolver;
    //   315: aload_1
    //   316: invokevirtual 235	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   319: invokevirtual 367	java/io/InputStream:available	()I
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
    //   362: ldc_w 369
    //   365: aload 9
    //   367: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   406: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   409: aload_0
    //   410: getfield 45	aucz:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   413: invokevirtual 373	android/app/Activity:getExternalCacheDir	()Ljava/io/File;
    //   416: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   419: ldc_w 375
    //   422: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: ldc_w 377
    //   428: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: ldc_w 375
    //   434: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: astore 9
    //   442: new 197	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   449: aload 9
    //   451: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload 9
    //   456: aload 10
    //   458: invokestatic 381	com/tencent/mobileqq/utils/FileUtils:getUnitFileName	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   461: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 341	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: astore 8
    //   469: aload 9
    //   471: invokestatic 383	aucz:a	(Ljava/lang/String;)V
    //   474: new 163	java/io/File
    //   477: dup
    //   478: aload 9
    //   480: invokespecial 165	java/io/File:<init>	(Ljava/lang/String;)V
    //   483: astore 9
    //   485: aload 9
    //   487: invokevirtual 168	java/io/File:exists	()Z
    //   490: ifne +22 -> 512
    //   493: aload 9
    //   495: invokevirtual 386	java/io/File:mkdirs	()Z
    //   498: ifne +14 -> 512
    //   501: ldc_w 387
    //   504: invokestatic 134	amtj:a	(I)Ljava/lang/String;
    //   507: putstatic 324	aucz:jdField_a_of_type_JavaLangString	Ljava/lang/String;
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
    //   528: ldc_w 389
    //   531: invokestatic 330	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   534: aconst_null
    //   535: areturn
    //   536: lload 4
    //   538: ldc2_w 390
    //   541: lcmp
    //   542: ifle +141 -> 683
    //   545: aload_0
    //   546: iconst_1
    //   547: putfield 393	aucz:b	Z
    //   550: new 110	com/tencent/mobileqq/utils/QQCustomDialog
    //   553: dup
    //   554: aload_0
    //   555: getfield 45	aucz:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   558: ldc_w 280
    //   561: invokespecial 283	com/tencent/mobileqq/utils/QQCustomDialog:<init>	(Landroid/content/Context;I)V
    //   564: astore 10
    //   566: aload 10
    //   568: ldc_w 284
    //   571: invokevirtual 288	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   574: aload 10
    //   576: aload_0
    //   577: getfield 57	aucz:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   580: ldc_w 289
    //   583: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   586: invokevirtual 293	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   589: pop
    //   590: aload 10
    //   592: aload_0
    //   593: getfield 57	aucz:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   596: ldc_w 394
    //   599: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   602: invokevirtual 297	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(Ljava/lang/CharSequence;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   605: pop
    //   606: aload 10
    //   608: iconst_0
    //   609: invokevirtual 301	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   612: aload 10
    //   614: iconst_0
    //   615: invokevirtual 304	com/tencent/mobileqq/utils/QQCustomDialog:setCancelable	(Z)V
    //   618: aload 10
    //   620: aload_0
    //   621: getfield 57	aucz:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   624: ldc_w 395
    //   627: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   630: new 397	auda
    //   633: dup
    //   634: aload_0
    //   635: aload 9
    //   637: invokespecial 400	auda:<init>	(Laucz;Ljava/io/InputStream;)V
    //   640: invokevirtual 312	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   643: pop
    //   644: aload 10
    //   646: aload_0
    //   647: getfield 57	aucz:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   650: ldc_w 401
    //   653: invokevirtual 129	android/content/Context:getString	(I)Ljava/lang/String;
    //   656: new 403	audb
    //   659: dup
    //   660: aload_0
    //   661: aload_1
    //   662: aload 8
    //   664: aload 9
    //   666: lload 4
    //   668: invokespecial 405	audb:<init>	(Laucz;Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   671: invokevirtual 408	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   674: pop
    //   675: aload 10
    //   677: invokevirtual 154	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   680: goto +60 -> 740
    //   683: aload_0
    //   684: aload_1
    //   685: aload 8
    //   687: aload 9
    //   689: lload 4
    //   691: invokespecial 157	aucz:a	(Landroid/net/Uri;Ljava/lang/String;Ljava/io/InputStream;J)V
    //   694: goto +46 -> 740
    //   697: astore_1
    //   698: aload_0
    //   699: iconst_0
    //   700: putfield 116	aucz:jdField_a_of_type_Boolean	Z
    //   703: ldc 243
    //   705: iconst_1
    //   706: ldc_w 410
    //   709: aload_1
    //   710: invokestatic 267	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
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
    //   0	743	0	this	aucz
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
      return this.jdField_a_of_type_AndroidContentContext.getString(2131718384);
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
      if (this.jdField_a_of_type_Audf != null)
      {
        this.jdField_a_of_type_Audf.a(null);
        this.jdField_a_of_type_Audf = null;
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
 * Qualified Name:     aucz
 * JD-Core Version:    0.7.0.1
 */