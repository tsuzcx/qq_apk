import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import java.io.File;

public class aokq
  extends AsyncTask
{
  Activity jdField_a_of_type_AndroidAppActivity;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  
  public aokq(ShortVideoPreviewActivity paramShortVideoPreviewActivity, Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(paramActivity);
  }
  
  /* Error */
  protected Integer a(String... paramVarArgs)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_0
    //   2: aaload
    //   3: astore 13
    //   5: aload 13
    //   7: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +10 -> 20
    //   13: aload_0
    //   14: getfield 20	aokq:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   17: ifnonnull +8 -> 25
    //   20: iconst_m1
    //   21: invokestatic 43	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: areturn
    //   25: aload_0
    //   26: aload 13
    //   28: putfield 45	aokq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   31: new 47	java/io/File
    //   34: dup
    //   35: new 49	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   42: getstatic 55	com/tencent/mobileqq/app/AppConstants:aJ	Ljava/lang/String;
    //   45: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 61
    //   50: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 72	java/io/File:exists	()Z
    //   64: ifne +8 -> 72
    //   67: aload_1
    //   68: invokevirtual 75	java/io/File:mkdirs	()Z
    //   71: pop
    //   72: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   75: lstore 6
    //   77: aload_0
    //   78: getfield 20	aokq:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   81: iconst_0
    //   82: iconst_0
    //   83: invokestatic 86	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Landroid/content/Context;II)Z
    //   86: istore 12
    //   88: aload 13
    //   90: ldc 88
    //   92: invokevirtual 94	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   95: istore_2
    //   96: iload_2
    //   97: iconst_m1
    //   98: if_icmpne +8 -> 106
    //   101: iconst_m1
    //   102: invokestatic 43	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   105: areturn
    //   106: iconst_m1
    //   107: istore_3
    //   108: aload_0
    //   109: aload 13
    //   111: aload 13
    //   113: iload_2
    //   114: iconst_1
    //   115: iadd
    //   116: invokevirtual 98	java/lang/String:substring	(I)Ljava/lang/String;
    //   119: invokestatic 103	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:b	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   122: putfield 105	aokq:b	Ljava/lang/String;
    //   125: iload 12
    //   127: ifeq +161 -> 288
    //   130: aload 13
    //   132: invokestatic 108	dov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:a	(Ljava/lang/String;)Ldov/com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer$CompressConfig;
    //   135: pop
    //   136: getstatic 114	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:j	I
    //   139: iconst_m1
    //   140: if_icmpne +255 -> 395
    //   143: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +11 -> 157
    //   149: ldc 121
    //   151: iconst_2
    //   152: ldc 123
    //   154: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   157: aload_0
    //   158: aload_0
    //   159: getfield 45	aokq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   162: putfield 105	aokq:b	Ljava/lang/String;
    //   165: iconst_0
    //   166: istore_2
    //   167: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   170: lstore 8
    //   172: new 47	java/io/File
    //   175: dup
    //   176: aload 13
    //   178: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   181: invokevirtual 130	java/io/File:length	()J
    //   184: lstore 10
    //   186: lconst_0
    //   187: lstore 4
    //   189: aload_0
    //   190: getfield 105	aokq:b	Ljava/lang/String;
    //   193: invokestatic 37	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   196: ifne +19 -> 215
    //   199: new 47	java/io/File
    //   202: dup
    //   203: aload_0
    //   204: getfield 105	aokq:b	Ljava/lang/String;
    //   207: invokespecial 68	java/io/File:<init>	(Ljava/lang/String;)V
    //   210: invokevirtual 130	java/io/File:length	()J
    //   213: lstore 4
    //   215: iload_2
    //   216: istore_3
    //   217: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   220: ifeq +68 -> 288
    //   223: ldc 132
    //   225: iconst_2
    //   226: new 49	java/lang/StringBuilder
    //   229: dup
    //   230: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   233: ldc 134
    //   235: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: iload_2
    //   239: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   242: ldc 139
    //   244: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: lload 8
    //   249: lload 6
    //   251: lsub
    //   252: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   255: ldc 144
    //   257: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: lload 10
    //   262: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   265: ldc 146
    //   267: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: lload 4
    //   272: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   275: ldc 148
    //   277: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: iload_2
    //   287: istore_3
    //   288: aload_0
    //   289: getfield 20	aokq:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   292: aload 13
    //   294: invokestatic 151	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   297: astore 14
    //   299: aload 14
    //   301: ifnull +89 -> 390
    //   304: new 47	java/io/File
    //   307: dup
    //   308: aload_1
    //   309: new 49	java/lang/StringBuilder
    //   312: dup
    //   313: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   316: lload 6
    //   318: invokestatic 154	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   321: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: ldc 156
    //   326: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokespecial 159	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   335: astore_1
    //   336: aload_1
    //   337: invokevirtual 162	java/io/File:createNewFile	()Z
    //   340: ifeq +233 -> 573
    //   343: aload_0
    //   344: aload_1
    //   345: invokevirtual 165	java/io/File:getPath	()Ljava/lang/String;
    //   348: putfield 167	aokq:c	Ljava/lang/String;
    //   351: new 169	java/io/FileOutputStream
    //   354: dup
    //   355: aload_1
    //   356: invokevirtual 165	java/io/File:getPath	()Ljava/lang/String;
    //   359: invokespecial 170	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   362: astore 13
    //   364: aload 13
    //   366: astore_1
    //   367: aload 14
    //   369: getstatic 176	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   372: bipush 100
    //   374: aload 13
    //   376: invokevirtual 182	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   379: pop
    //   380: aload 13
    //   382: ifnull +8 -> 390
    //   385: aload 13
    //   387: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   390: iload_3
    //   391: invokestatic 43	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   394: areturn
    //   395: new 187	java/util/HashMap
    //   398: dup
    //   399: invokespecial 188	java/util/HashMap:<init>	()V
    //   402: pop
    //   403: aload 13
    //   405: aload_0
    //   406: getfield 20	aokq:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   409: invokestatic 191	dov/com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:a	(Ljava/lang/String;Landroid/content/Context;)Ljava/util/HashMap;
    //   412: astore 14
    //   414: aload 14
    //   416: ldc 193
    //   418: invokevirtual 197	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   421: checkcast 90	java/lang/String
    //   424: invokestatic 200	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   427: istore_2
    //   428: aload_0
    //   429: aload 14
    //   431: ldc 202
    //   433: invokevirtual 197	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   436: checkcast 90	java/lang/String
    //   439: putfield 105	aokq:b	Ljava/lang/String;
    //   442: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq +41 -> 486
    //   448: ldc 121
    //   450: iconst_2
    //   451: new 49	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   458: ldc 204
    //   460: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: aload 13
    //   465: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: ldc 206
    //   470: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload_0
    //   474: getfield 105	aokq:b	Ljava/lang/String;
    //   477: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: goto -319 -> 167
    //   489: astore 14
    //   491: aconst_null
    //   492: astore 13
    //   494: aload 13
    //   496: astore_1
    //   497: ldc 132
    //   499: iconst_1
    //   500: new 49	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 50	java/lang/StringBuilder:<init>	()V
    //   507: ldc 208
    //   509: invokevirtual 59	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload 14
    //   514: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   517: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   520: invokestatic 214	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   523: aload 13
    //   525: ifnull -135 -> 390
    //   528: aload 13
    //   530: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   533: goto -143 -> 390
    //   536: astore_1
    //   537: goto -147 -> 390
    //   540: astore 13
    //   542: aconst_null
    //   543: astore_1
    //   544: aload_1
    //   545: ifnull +7 -> 552
    //   548: aload_1
    //   549: invokevirtual 185	java/io/FileOutputStream:close	()V
    //   552: aload 13
    //   554: athrow
    //   555: astore_1
    //   556: goto -166 -> 390
    //   559: astore_1
    //   560: goto -8 -> 552
    //   563: astore 13
    //   565: goto -21 -> 544
    //   568: astore 14
    //   570: goto -76 -> 494
    //   573: aconst_null
    //   574: astore 13
    //   576: goto -196 -> 380
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	aokq
    //   0	579	1	paramVarArgs	String[]
    //   95	333	2	i	int
    //   107	284	3	j	int
    //   187	84	4	l1	long
    //   75	242	6	l2	long
    //   170	78	8	l3	long
    //   184	77	10	l4	long
    //   86	40	12	bool	boolean
    //   3	526	13	localObject1	java.lang.Object
    //   540	13	13	localObject2	java.lang.Object
    //   563	1	13	localObject3	java.lang.Object
    //   574	1	13	localObject4	java.lang.Object
    //   297	133	14	localObject5	java.lang.Object
    //   489	24	14	localException1	java.lang.Exception
    //   568	1	14	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   336	364	489	java/lang/Exception
    //   528	533	536	java/lang/Exception
    //   336	364	540	finally
    //   385	390	555	java/lang/Exception
    //   548	552	559	java/lang/Exception
    //   367	380	563	finally
    //   497	523	563	finally
    //   367	380	568	java/lang/Exception
  }
  
  protected void a(Integer paramInteger)
  {
    int i = 10485760;
    super.onPostExecute(paramInteger);
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    String str;
    if (TextUtils.isEmpty(this.b))
    {
      str = this.jdField_a_of_type_JavaLangString;
      long l = new File(str).length();
      if (this.jdField_a_of_type_AndroidAppActivity != null) {
        i = this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("size_after_compress", 10485760);
      }
      if (l <= i) {
        break label141;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, "文件过大，无法发送", 0).b(this.jdField_a_of_type_DovComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.getTitleBarHeight());
      this.jdField_a_of_type_AndroidAppActivity.setResult(0);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      this.jdField_a_of_type_AndroidAppActivity = null;
    }
    label141:
    while ((this.jdField_a_of_type_AndroidAppActivity == null) || (paramInteger.intValue() != 0))
    {
      return;
      str = this.b;
      break;
    }
    paramInteger = new Intent();
    paramInteger.putExtra("video_dir", str);
    paramInteger.putExtra("thumb_dir", this.c);
    this.jdField_a_of_type_AndroidAppActivity.setResult(-1, paramInteger);
    this.jdField_a_of_type_AndroidAppActivity.finish();
    this.jdField_a_of_type_AndroidAppActivity = null;
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a("准备压缩");
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aokq
 * JD-Core Version:    0.7.0.1
 */