package com.tencent.mobileqq.activity.shortvideo;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;

class ShortVideoPreviewActivity$VideoCompressTask
  extends AsyncTask<String, Void, Integer>
{
  Activity jdField_a_of_type_AndroidAppActivity;
  QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog;
  String jdField_a_of_type_JavaLangString;
  String b;
  String c;
  
  public ShortVideoPreviewActivity$VideoCompressTask(ShortVideoPreviewActivity paramShortVideoPreviewActivity, Activity paramActivity)
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
    //   7: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: ifne +10 -> 20
    //   13: aload_0
    //   14: getfield 21	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   17: ifnonnull +8 -> 25
    //   20: iconst_m1
    //   21: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   24: areturn
    //   25: aload_0
    //   26: aload 13
    //   28: putfield 46	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   31: new 48	java/io/File
    //   34: dup
    //   35: new 50	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   42: getstatic 56	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   45: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: ldc 62
    //   50: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 73	java/io/File:exists	()Z
    //   64: ifne +8 -> 72
    //   67: aload_1
    //   68: invokevirtual 76	java/io/File:mkdirs	()Z
    //   71: pop
    //   72: invokestatic 82	java/lang/System:currentTimeMillis	()J
    //   75: lstore 6
    //   77: aload_0
    //   78: getfield 21	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   81: invokestatic 88	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:initVideoTrim	(Landroid/content/Context;)Z
    //   84: istore 12
    //   86: aload 13
    //   88: ldc 90
    //   90: invokevirtual 96	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   93: istore_2
    //   94: iload_2
    //   95: iconst_m1
    //   96: if_icmpne +8 -> 104
    //   99: iconst_m1
    //   100: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: areturn
    //   104: iconst_m1
    //   105: istore_3
    //   106: aload_0
    //   107: aload 13
    //   109: aload 13
    //   111: iload_2
    //   112: iconst_1
    //   113: iadd
    //   114: invokevirtual 100	java/lang/String:substring	(I)Ljava/lang/String;
    //   117: invokestatic 106	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoCompressPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   120: putfield 108	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:b	Ljava/lang/String;
    //   123: iload 12
    //   125: ifeq +155 -> 280
    //   128: getstatic 114	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:i	I
    //   131: iconst_m1
    //   132: if_icmpne +255 -> 387
    //   135: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +11 -> 149
    //   141: ldc 121
    //   143: iconst_2
    //   144: ldc 123
    //   146: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   149: aload_0
    //   150: aload_0
    //   151: getfield 46	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   154: putfield 108	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:b	Ljava/lang/String;
    //   157: iconst_0
    //   158: istore_2
    //   159: invokestatic 82	java/lang/System:currentTimeMillis	()J
    //   162: lstore 8
    //   164: new 48	java/io/File
    //   167: dup
    //   168: aload 13
    //   170: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   173: invokevirtual 130	java/io/File:length	()J
    //   176: lstore 10
    //   178: lconst_0
    //   179: lstore 4
    //   181: aload_0
    //   182: getfield 108	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:b	Ljava/lang/String;
    //   185: invokestatic 38	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifne +19 -> 207
    //   191: new 48	java/io/File
    //   194: dup
    //   195: aload_0
    //   196: getfield 108	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:b	Ljava/lang/String;
    //   199: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   202: invokevirtual 130	java/io/File:length	()J
    //   205: lstore 4
    //   207: iload_2
    //   208: istore_3
    //   209: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   212: ifeq +68 -> 280
    //   215: ldc 132
    //   217: iconst_2
    //   218: new 50	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   225: ldc 134
    //   227: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: iload_2
    //   231: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   234: ldc 139
    //   236: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: lload 8
    //   241: lload 6
    //   243: lsub
    //   244: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   247: ldc 144
    //   249: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: lload 10
    //   254: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   257: ldc 146
    //   259: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: lload 4
    //   264: invokevirtual 142	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   267: ldc 148
    //   269: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: iload_2
    //   279: istore_3
    //   280: aload_0
    //   281: getfield 21	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   284: aload 13
    //   286: invokestatic 152	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   289: astore 14
    //   291: aload 14
    //   293: ifnull +89 -> 382
    //   296: new 48	java/io/File
    //   299: dup
    //   300: aload_1
    //   301: new 50	java/lang/StringBuilder
    //   304: dup
    //   305: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   308: lload 6
    //   310: invokestatic 155	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   313: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc 157
    //   318: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokespecial 160	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   327: astore_1
    //   328: aload_1
    //   329: invokevirtual 163	java/io/File:createNewFile	()Z
    //   332: ifeq +225 -> 557
    //   335: aload_0
    //   336: aload_1
    //   337: invokevirtual 166	java/io/File:getPath	()Ljava/lang/String;
    //   340: putfield 168	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:c	Ljava/lang/String;
    //   343: new 170	java/io/FileOutputStream
    //   346: dup
    //   347: aload_1
    //   348: invokevirtual 166	java/io/File:getPath	()Ljava/lang/String;
    //   351: invokespecial 171	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   354: astore 13
    //   356: aload 13
    //   358: astore_1
    //   359: aload 14
    //   361: getstatic 177	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   364: bipush 100
    //   366: aload 13
    //   368: invokevirtual 183	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   371: pop
    //   372: aload 13
    //   374: ifnull +8 -> 382
    //   377: aload 13
    //   379: invokevirtual 186	java/io/FileOutputStream:close	()V
    //   382: iload_3
    //   383: invokestatic 44	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   386: areturn
    //   387: aload 13
    //   389: aload_0
    //   390: getfield 21	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:jdField_a_of_type_AndroidAppActivity	Landroid/app/Activity;
    //   393: invokestatic 189	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:a	(Ljava/lang/String;Landroid/content/Context;)Ljava/util/HashMap;
    //   396: astore 14
    //   398: aload 14
    //   400: ldc 191
    //   402: invokevirtual 197	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   405: checkcast 92	java/lang/String
    //   408: invokestatic 200	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   411: istore_2
    //   412: aload_0
    //   413: aload 14
    //   415: ldc 202
    //   417: invokevirtual 197	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   420: checkcast 92	java/lang/String
    //   423: putfield 108	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:b	Ljava/lang/String;
    //   426: invokestatic 119	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   429: ifeq +41 -> 470
    //   432: ldc 121
    //   434: iconst_2
    //   435: new 50	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   442: ldc 204
    //   444: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: aload 13
    //   449: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc 206
    //   454: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload_0
    //   458: getfield 108	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:b	Ljava/lang/String;
    //   461: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: goto -311 -> 159
    //   473: astore 14
    //   475: aconst_null
    //   476: astore 13
    //   478: aload 13
    //   480: astore_1
    //   481: ldc 132
    //   483: iconst_1
    //   484: new 50	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   491: ldc 208
    //   493: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload 14
    //   498: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 213	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   507: aload 13
    //   509: ifnull -127 -> 382
    //   512: aload 13
    //   514: invokevirtual 186	java/io/FileOutputStream:close	()V
    //   517: goto -135 -> 382
    //   520: astore_1
    //   521: goto -139 -> 382
    //   524: astore 13
    //   526: aconst_null
    //   527: astore_1
    //   528: aload_1
    //   529: ifnull +7 -> 536
    //   532: aload_1
    //   533: invokevirtual 186	java/io/FileOutputStream:close	()V
    //   536: aload 13
    //   538: athrow
    //   539: astore_1
    //   540: goto -158 -> 382
    //   543: astore_1
    //   544: goto -8 -> 536
    //   547: astore 13
    //   549: goto -21 -> 528
    //   552: astore 14
    //   554: goto -76 -> 478
    //   557: aconst_null
    //   558: astore 13
    //   560: goto -188 -> 372
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	563	0	this	VideoCompressTask
    //   0	563	1	paramVarArgs	String[]
    //   93	319	2	i	int
    //   105	278	3	j	int
    //   179	84	4	l1	long
    //   75	234	6	l2	long
    //   162	78	8	l3	long
    //   176	77	10	l4	long
    //   84	40	12	bool	boolean
    //   3	510	13	localObject1	java.lang.Object
    //   524	13	13	localObject2	java.lang.Object
    //   547	1	13	localObject3	java.lang.Object
    //   558	1	13	localObject4	java.lang.Object
    //   289	125	14	localObject5	java.lang.Object
    //   473	24	14	localException1	java.lang.Exception
    //   552	1	14	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   328	356	473	java/lang/Exception
    //   512	517	520	java/lang/Exception
    //   328	356	524	finally
    //   377	382	539	java/lang/Exception
    //   532	536	543	java/lang/Exception
    //   359	372	547	finally
    //   481	507	547	finally
    //   359	372	552	java/lang/Exception
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
        break label144;
      }
      QQToast.a(this.jdField_a_of_type_AndroidAppActivity, HardCodeUtil.a(2131714033), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityShortvideoShortVideoPreviewActivity.getTitleBarHeight());
      this.jdField_a_of_type_AndroidAppActivity.setResult(0);
      this.jdField_a_of_type_AndroidAppActivity.finish();
      this.jdField_a_of_type_AndroidAppActivity = null;
    }
    label144:
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
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(HardCodeUtil.a(2131714004));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.setCancelable(false);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.VideoCompressTask
 * JD-Core Version:    0.7.0.1
 */