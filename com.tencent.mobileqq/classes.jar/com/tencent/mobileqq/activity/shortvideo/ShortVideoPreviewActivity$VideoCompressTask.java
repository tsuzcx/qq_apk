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
  QQProgressDialog a;
  Activity b;
  String c;
  String d;
  String e;
  
  public ShortVideoPreviewActivity$VideoCompressTask(ShortVideoPreviewActivity paramShortVideoPreviewActivity, Activity paramActivity)
  {
    this.b = paramActivity;
    this.a = new QQProgressDialog(paramActivity);
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
    //   7: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   10: istore 4
    //   12: iconst_m1
    //   13: istore_3
    //   14: iconst_m1
    //   15: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   18: astore 14
    //   20: iload 4
    //   22: ifne +646 -> 668
    //   25: aload_0
    //   26: getfield 24	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:b	Landroid/app/Activity;
    //   29: ifnonnull +6 -> 35
    //   32: aload 14
    //   34: areturn
    //   35: aload_0
    //   36: aload 13
    //   38: putfield 49	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:c	Ljava/lang/String;
    //   41: new 51	java/lang/StringBuilder
    //   44: dup
    //   45: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   48: astore_1
    //   49: aload_1
    //   50: getstatic 57	com/tencent/mobileqq/app/AppConstants:SDCARD_PATH	Ljava/lang/String;
    //   53: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_1
    //   58: ldc 63
    //   60: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: new 65	java/io/File
    //   67: dup
    //   68: aload_1
    //   69: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   75: astore_1
    //   76: aload_1
    //   77: invokevirtual 76	java/io/File:exists	()Z
    //   80: ifne +8 -> 88
    //   83: aload_1
    //   84: invokevirtual 79	java/io/File:mkdirs	()Z
    //   87: pop
    //   88: invokestatic 85	java/lang/System:currentTimeMillis	()J
    //   91: lstore 7
    //   93: aload_0
    //   94: getfield 24	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:b	Landroid/app/Activity;
    //   97: invokestatic 91	com/tencent/mobileqq/shortvideo/util/ShortVideoTrimmer:initVideoTrim	(Landroid/content/Context;)Z
    //   100: istore 4
    //   102: aload 13
    //   104: ldc 93
    //   106: invokevirtual 99	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   109: istore_2
    //   110: iload_2
    //   111: iconst_m1
    //   112: if_icmpne +6 -> 118
    //   115: aload 14
    //   117: areturn
    //   118: aload_0
    //   119: aload 13
    //   121: aload 13
    //   123: iload_2
    //   124: iconst_1
    //   125: iadd
    //   126: invokevirtual 103	java/lang/String:substring	(I)Ljava/lang/String;
    //   129: invokestatic 109	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoCompressPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   132: putfield 111	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:d	Ljava/lang/String;
    //   135: iload 4
    //   137: ifeq +295 -> 432
    //   140: getstatic 117	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:mNoCompress	I
    //   143: iconst_m1
    //   144: if_icmpne +30 -> 174
    //   147: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +11 -> 161
    //   153: ldc 124
    //   155: iconst_2
    //   156: ldc 126
    //   158: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aload_0
    //   162: aload_0
    //   163: getfield 49	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:c	Ljava/lang/String;
    //   166: putfield 111	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:d	Ljava/lang/String;
    //   169: iconst_0
    //   170: istore_2
    //   171: goto +106 -> 277
    //   174: aload 13
    //   176: aload_0
    //   177: getfield 24	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:b	Landroid/app/Activity;
    //   180: invokestatic 133	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity:CompressPosition	(Ljava/lang/String;Landroid/content/Context;)Ljava/util/HashMap;
    //   183: astore 14
    //   185: aload 14
    //   187: ldc 135
    //   189: invokevirtual 141	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   192: checkcast 95	java/lang/String
    //   195: invokestatic 144	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   198: istore_3
    //   199: aload_0
    //   200: aload 14
    //   202: ldc 146
    //   204: invokevirtual 141	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   207: checkcast 95	java/lang/String
    //   210: putfield 111	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:d	Ljava/lang/String;
    //   213: iload_3
    //   214: istore_2
    //   215: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   218: ifeq +59 -> 277
    //   221: new 51	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   228: astore 14
    //   230: aload 14
    //   232: ldc 148
    //   234: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: aload 14
    //   240: aload 13
    //   242: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: pop
    //   246: aload 14
    //   248: ldc 150
    //   250: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload 14
    //   256: aload_0
    //   257: getfield 111	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:d	Ljava/lang/String;
    //   260: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   263: pop
    //   264: ldc 124
    //   266: iconst_2
    //   267: aload 14
    //   269: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: iload_3
    //   276: istore_2
    //   277: invokestatic 85	java/lang/System:currentTimeMillis	()J
    //   280: lstore 9
    //   282: new 65	java/io/File
    //   285: dup
    //   286: aload 13
    //   288: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   291: invokevirtual 153	java/io/File:length	()J
    //   294: lstore 11
    //   296: lconst_0
    //   297: lstore 5
    //   299: aload_0
    //   300: getfield 111	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:d	Ljava/lang/String;
    //   303: invokestatic 41	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   306: ifne +19 -> 325
    //   309: new 65	java/io/File
    //   312: dup
    //   313: aload_0
    //   314: getfield 111	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:d	Ljava/lang/String;
    //   317: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;)V
    //   320: invokevirtual 153	java/io/File:length	()J
    //   323: lstore 5
    //   325: iload_2
    //   326: istore_3
    //   327: invokestatic 122	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   330: ifeq +102 -> 432
    //   333: new 51	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   340: astore 14
    //   342: aload 14
    //   344: ldc 155
    //   346: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: pop
    //   350: aload 14
    //   352: iload_2
    //   353: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload 14
    //   359: ldc 160
    //   361: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload 14
    //   367: lload 9
    //   369: lload 7
    //   371: lsub
    //   372: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   375: pop
    //   376: aload 14
    //   378: ldc 165
    //   380: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 14
    //   386: lload 11
    //   388: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   391: pop
    //   392: aload 14
    //   394: ldc 167
    //   396: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: pop
    //   400: aload 14
    //   402: lload 5
    //   404: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 14
    //   410: ldc 169
    //   412: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   415: pop
    //   416: ldc 171
    //   418: iconst_2
    //   419: aload 14
    //   421: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 129	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: iload_2
    //   428: istore_3
    //   429: goto +3 -> 432
    //   432: aload_0
    //   433: getfield 24	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:b	Landroid/app/Activity;
    //   436: aload 13
    //   438: invokestatic 175	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getVideoThumbnail	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   441: astore 16
    //   443: aload 16
    //   445: ifnull +218 -> 663
    //   448: new 51	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   455: astore 13
    //   457: aload 13
    //   459: lload 7
    //   461: invokestatic 178	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   464: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: pop
    //   468: aload 13
    //   470: ldc 180
    //   472: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: pop
    //   476: new 65	java/io/File
    //   479: dup
    //   480: aload_1
    //   481: aload 13
    //   483: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokespecial 183	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   489: astore 17
    //   491: aconst_null
    //   492: astore 15
    //   494: aconst_null
    //   495: astore 14
    //   497: aconst_null
    //   498: astore_1
    //   499: aload 15
    //   501: astore 13
    //   503: aload 17
    //   505: invokevirtual 186	java/io/File:createNewFile	()Z
    //   508: ifeq +64 -> 572
    //   511: aload 15
    //   513: astore 13
    //   515: aload_0
    //   516: aload 17
    //   518: invokevirtual 189	java/io/File:getPath	()Ljava/lang/String;
    //   521: putfield 191	com/tencent/mobileqq/activity/shortvideo/ShortVideoPreviewActivity$VideoCompressTask:e	Ljava/lang/String;
    //   524: aload 15
    //   526: astore 13
    //   528: new 193	java/io/FileOutputStream
    //   531: dup
    //   532: aload 17
    //   534: invokevirtual 189	java/io/File:getPath	()Ljava/lang/String;
    //   537: invokespecial 194	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   540: astore_1
    //   541: aload 16
    //   543: getstatic 200	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   546: bipush 100
    //   548: aload_1
    //   549: invokevirtual 206	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   552: pop
    //   553: goto +19 -> 572
    //   556: astore 14
    //   558: aload_1
    //   559: astore 13
    //   561: aload 14
    //   563: astore_1
    //   564: goto +87 -> 651
    //   567: astore 14
    //   569: goto +27 -> 596
    //   572: aload_1
    //   573: ifnull +90 -> 663
    //   576: aload_1
    //   577: invokevirtual 209	java/io/FileOutputStream:close	()V
    //   580: goto +83 -> 663
    //   583: astore_1
    //   584: goto +67 -> 651
    //   587: astore 13
    //   589: aload 14
    //   591: astore_1
    //   592: aload 13
    //   594: astore 14
    //   596: aload_1
    //   597: astore 13
    //   599: new 51	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   606: astore 15
    //   608: aload_1
    //   609: astore 13
    //   611: aload 15
    //   613: ldc 211
    //   615: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: aload_1
    //   620: astore 13
    //   622: aload 15
    //   624: aload 14
    //   626: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: aload_1
    //   631: astore 13
    //   633: ldc 171
    //   635: iconst_1
    //   636: aload 15
    //   638: invokevirtual 69	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: aload_1
    //   645: ifnull +18 -> 663
    //   648: goto -72 -> 576
    //   651: aload 13
    //   653: ifnull +8 -> 661
    //   656: aload 13
    //   658: invokevirtual 209	java/io/FileOutputStream:close	()V
    //   661: aload_1
    //   662: athrow
    //   663: iload_3
    //   664: invokestatic 47	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   667: areturn
    //   668: aload 14
    //   670: areturn
    //   671: astore_1
    //   672: goto -9 -> 663
    //   675: astore 13
    //   677: goto -16 -> 661
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	680	0	this	VideoCompressTask
    //   0	680	1	paramVarArgs	String[]
    //   109	319	2	i	int
    //   13	651	3	j	int
    //   10	126	4	bool	boolean
    //   297	106	5	l1	long
    //   91	369	7	l2	long
    //   280	88	9	l3	long
    //   294	93	11	l4	long
    //   3	557	13	localObject1	Object
    //   587	6	13	localException1	java.lang.Exception
    //   597	60	13	arrayOfString	String[]
    //   675	1	13	localException2	java.lang.Exception
    //   18	478	14	localObject2	Object
    //   556	6	14	localObject3	Object
    //   567	23	14	localException3	java.lang.Exception
    //   594	75	14	localException4	java.lang.Exception
    //   492	145	15	localStringBuilder	java.lang.StringBuilder
    //   441	101	16	localBitmap	android.graphics.Bitmap
    //   489	44	17	localFile	File
    // Exception table:
    //   from	to	target	type
    //   541	553	556	finally
    //   541	553	567	java/lang/Exception
    //   503	511	583	finally
    //   515	524	583	finally
    //   528	541	583	finally
    //   599	608	583	finally
    //   611	619	583	finally
    //   622	630	583	finally
    //   633	644	583	finally
    //   503	511	587	java/lang/Exception
    //   515	524	587	java/lang/Exception
    //   528	541	587	java/lang/Exception
    //   576	580	671	java/lang/Exception
    //   656	661	675	java/lang/Exception
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    Object localObject = this.a;
    if ((localObject != null) && (((QQProgressDialog)localObject).isShowing())) {
      this.a.dismiss();
    }
    if (TextUtils.isEmpty(this.d)) {
      localObject = this.c;
    } else {
      localObject = this.d;
    }
    long l = new File((String)localObject).length();
    Activity localActivity = this.b;
    int i = 10485760;
    if (localActivity != null) {
      i = localActivity.getIntent().getIntExtra("size_after_compress", 10485760);
    }
    if (l > i)
    {
      QQToast.makeText(this.b, HardCodeUtil.a(2131911495), 0).show(this.f.getTitleBarHeight());
      this.b.setResult(0);
      this.b.finish();
      this.b = null;
      return;
    }
    if ((this.b != null) && (paramInteger.intValue() == 0))
    {
      paramInteger = new Intent();
      paramInteger.putExtra("video_dir", (String)localObject);
      paramInteger.putExtra("thumb_dir", this.e);
      this.b.setResult(-1, paramInteger);
      this.b.finish();
      this.b = null;
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.a(HardCodeUtil.a(2131911466));
    this.a.setCancelable(false);
    this.a.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity.VideoCompressTask
 * JD-Core Version:    0.7.0.1
 */