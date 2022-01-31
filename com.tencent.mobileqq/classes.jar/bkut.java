import android.app.Activity;
import android.os.AsyncTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.activity.EditWebDanceMachineVideoActivity;
import java.io.File;
import java.lang.ref.WeakReference;

public class bkut
  extends AsyncTask<Void, Void, Integer>
{
  int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  aytv jdField_a_of_type_Aytv;
  String jdField_a_of_type_JavaLangString;
  public WeakReference<AppInterface> a;
  String b;
  
  public bkut(EditWebDanceMachineVideoActivity paramEditWebDanceMachineVideoActivity, Activity paramActivity, String paramString1, String paramString2, int paramInt, AppInterface paramAppInterface, aytv paramaytv)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_Aytv = paramaytv;
  }
  
  private int a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((paramString2 == null) || ("".equals(paramString2))) {
      return 0;
    }
    if ((paramString1 == null) || ("".equals(paramString1))) {
      return -1;
    }
    paramString4 = paramString1 + File.separator + paramString4 + "_target.mp4";
    paramString1 = paramString1 + File.separator + "mc_audio.mp4";
    Object localObject = new File(paramString1);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
    localObject = AudioEncoder.a(null, null, 0);
    ((axkh)localObject).b = paramString1;
    ((axkh)localObject).jdField_a_of_type_JavaLangString = paramString2;
    int i = AudioEncoder.a(paramString2);
    if (i != 0) {
      a("checkSourceAudioIsOK: errcode=" + i, null);
    }
    for (;;)
    {
      return 0;
      long l = System.currentTimeMillis();
      i = AudioEncoder.a((axkh)localObject);
      a("AudioEncoder.encodeSafely:time=" + (System.currentTimeMillis() - l) / 1000.0D, null);
      if (i != 0)
      {
        a("AudioEncoder.encodeSafely: errcode=" + i, null);
        return i;
      }
      paramString2 = new File(paramString1);
      if (!paramString2.exists())
      {
        a("AudioEncoder.encodeSafely: exists = false", null);
      }
      else
      {
        i = blce.a(paramString3, paramString1, paramString4, 0);
        paramString2.delete();
        if (i != 0)
        {
          a("HwVideoMerge.merge: errcode=" + i, null);
          return i;
        }
        this.jdField_a_of_type_JavaLangString = paramString4;
      }
    }
  }
  
  private void a(String paramString, Throwable paramThrowable)
  {
    if (QLog.isColorLevel())
    {
      if (paramThrowable != null) {
        QLog.e("DANCE_MACHINE_SHARE_TAG", 2, "[@] " + paramString, paramThrowable);
      }
    }
    else {
      return;
    }
    QLog.d("DANCE_MACHINE_SHARE_TAG", 2, "[@] " + paramString);
  }
  
  /* Error */
  protected Integer a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: new 57	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 27	bkut:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 8
    //   13: aload 8
    //   15: invokevirtual 156	java/io/File:getParent	()Ljava/lang/String;
    //   18: astore_1
    //   19: aload 8
    //   21: invokevirtual 159	java/io/File:getName	()Ljava/lang/String;
    //   24: astore 8
    //   26: aload_0
    //   27: aload_1
    //   28: aload_0
    //   29: getfield 25	bkut:b	Ljava/lang/String;
    //   32: aload_0
    //   33: getfield 27	bkut:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: aload 8
    //   38: invokespecial 161	bkut:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   41: istore_2
    //   42: iload_2
    //   43: ifeq +12 -> 55
    //   46: iload_2
    //   47: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: astore 8
    //   52: aload 8
    //   54: areturn
    //   55: aload_0
    //   56: getfield 27	bkut:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   59: astore 10
    //   61: aload 10
    //   63: invokestatic 172	bbdx:b	(Ljava/lang/String;)Z
    //   66: ifne +22 -> 88
    //   69: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +11 -> 83
    //   75: ldc 132
    //   77: iconst_2
    //   78: ldc 174
    //   80: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: iconst_m1
    //   84: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: areturn
    //   88: new 57	java/io/File
    //   91: dup
    //   92: aload 10
    //   94: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 179	java/io/File:length	()J
    //   102: lstore_3
    //   103: lload_3
    //   104: lconst_0
    //   105: lcmp
    //   106: ifne +22 -> 128
    //   109: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   112: ifeq +11 -> 123
    //   115: ldc 132
    //   117: iconst_2
    //   118: ldc 181
    //   120: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: iconst_m1
    //   124: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: areturn
    //   128: new 183	java/io/FileInputStream
    //   131: dup
    //   132: aload_1
    //   133: invokespecial 186	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   136: astore_1
    //   137: aload_1
    //   138: astore 8
    //   140: aload_1
    //   141: lload_3
    //   142: invokestatic 192	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   145: astore 12
    //   147: aload_1
    //   148: astore 8
    //   150: aload 12
    //   152: invokestatic 197	bbea:a	([B)Ljava/lang/String;
    //   155: astore 11
    //   157: aload_1
    //   158: astore 8
    //   160: aload 11
    //   162: invokestatic 203	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   165: ifeq +70 -> 235
    //   168: aload_1
    //   169: astore 8
    //   171: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +32 -> 206
    //   177: aload_1
    //   178: astore 8
    //   180: ldc 132
    //   182: iconst_2
    //   183: new 50	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   190: ldc 205
    //   192: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 11
    //   197: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: iconst_m1
    //   207: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   210: astore 9
    //   212: aload 9
    //   214: astore 8
    //   216: aload_1
    //   217: ifnull -165 -> 52
    //   220: aload_1
    //   221: invokevirtual 208	java/io/FileInputStream:close	()V
    //   224: aload 9
    //   226: areturn
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   232: aload 9
    //   234: areturn
    //   235: aload_1
    //   236: ifnull +7 -> 243
    //   239: aload_1
    //   240: invokevirtual 208	java/io/FileInputStream:close	()V
    //   243: new 213	android/media/MediaMetadataRetriever
    //   246: dup
    //   247: invokespecial 214	android/media/MediaMetadataRetriever:<init>	()V
    //   250: astore 9
    //   252: aload 9
    //   254: aload 10
    //   256: invokevirtual 217	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   259: lconst_0
    //   260: lstore_3
    //   261: aload 9
    //   263: bipush 9
    //   265: invokevirtual 221	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   268: astore 8
    //   270: aload 8
    //   272: ifnull +12 -> 284
    //   275: aload 8
    //   277: invokestatic 226	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   280: invokevirtual 229	java/lang/Long:longValue	()J
    //   283: lstore_3
    //   284: lload_3
    //   285: lstore 5
    //   287: aload_0
    //   288: getfield 18	bkut:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   291: invokestatic 234	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Z
    //   294: ifne +29 -> 323
    //   297: lload_3
    //   298: lstore 5
    //   300: aload_0
    //   301: getfield 18	bkut:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   304: invokestatic 236	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:b	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Z
    //   307: ifne +16 -> 323
    //   310: lload_3
    //   311: ldc2_w 237
    //   314: lcmp
    //   315: ifle +196 -> 511
    //   318: ldc2_w 237
    //   321: lstore 5
    //   323: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq +39 -> 365
    //   329: ldc 132
    //   331: iconst_2
    //   332: new 50	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   339: ldc 240
    //   341: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload 8
    //   346: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: ldc 242
    //   351: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: lload 5
    //   356: invokevirtual 245	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   359: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 248	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   365: aload 9
    //   367: lload 5
    //   369: ldc2_w 249
    //   372: lmul
    //   373: invokevirtual 254	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   376: astore 8
    //   378: aload 9
    //   380: invokevirtual 257	android/media/MediaMetadataRetriever:release	()V
    //   383: aload 8
    //   385: ifnonnull +185 -> 570
    //   388: iconst_m1
    //   389: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   392: areturn
    //   393: astore 8
    //   395: aload 8
    //   397: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   400: goto -157 -> 243
    //   403: astore 9
    //   405: aconst_null
    //   406: astore_1
    //   407: aload_1
    //   408: astore 8
    //   410: aload 9
    //   412: invokevirtual 258	java/io/FileNotFoundException:printStackTrace	()V
    //   415: aconst_null
    //   416: astore_1
    //   417: iconst_m1
    //   418: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   421: astore_1
    //   422: aload_1
    //   423: astore 8
    //   425: iconst_0
    //   426: ifeq -374 -> 52
    //   429: new 260	java/lang/NullPointerException
    //   432: dup
    //   433: invokespecial 261	java/lang/NullPointerException:<init>	()V
    //   436: athrow
    //   437: astore 8
    //   439: aload 8
    //   441: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   444: aload_1
    //   445: areturn
    //   446: astore_1
    //   447: aconst_null
    //   448: astore 8
    //   450: aload 8
    //   452: ifnull +8 -> 460
    //   455: aload 8
    //   457: invokevirtual 208	java/io/FileInputStream:close	()V
    //   460: aload_1
    //   461: athrow
    //   462: astore 8
    //   464: aload 8
    //   466: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   469: goto -9 -> 460
    //   472: astore_1
    //   473: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   476: ifeq +30 -> 506
    //   479: ldc 132
    //   481: iconst_2
    //   482: new 50	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   489: ldc_w 263
    //   492: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload 10
    //   497: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   503: invokestatic 176	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   506: iconst_m1
    //   507: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   510: areturn
    //   511: lconst_0
    //   512: lstore 5
    //   514: goto -191 -> 323
    //   517: astore_1
    //   518: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq +13 -> 534
    //   524: ldc 132
    //   526: iconst_2
    //   527: ldc_w 265
    //   530: aload_1
    //   531: invokestatic 138	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   534: aload 9
    //   536: invokevirtual 257	android/media/MediaMetadataRetriever:release	()V
    //   539: iconst_m1
    //   540: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   543: areturn
    //   544: astore 8
    //   546: aload 8
    //   548: invokevirtual 266	java/lang/Exception:printStackTrace	()V
    //   551: aload 9
    //   553: invokevirtual 257	android/media/MediaMetadataRetriever:release	()V
    //   556: aconst_null
    //   557: astore 8
    //   559: goto -176 -> 383
    //   562: astore_1
    //   563: aload 9
    //   565: invokevirtual 257	android/media/MediaMetadataRetriever:release	()V
    //   568: aload_1
    //   569: athrow
    //   570: iconst_2
    //   571: iconst_2
    //   572: invokestatic 270	bklw:a	(I)Ljava/lang/String;
    //   575: ldc_w 272
    //   578: invokestatic 275	bklw:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   581: astore 13
    //   583: aload 8
    //   585: getstatic 281	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   588: bipush 100
    //   590: aload 13
    //   592: invokestatic 286	vxv:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   595: istore 7
    //   597: aload 8
    //   599: invokevirtual 291	android/graphics/Bitmap:recycle	()V
    //   602: iload 7
    //   604: ifne +23 -> 627
    //   607: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   610: ifeq +12 -> 622
    //   613: ldc 132
    //   615: iconst_2
    //   616: ldc_w 293
    //   619: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   622: iconst_m1
    //   623: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   626: areturn
    //   627: new 57	java/io/File
    //   630: dup
    //   631: aload 13
    //   633: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   636: astore 8
    //   638: aload 8
    //   640: invokevirtual 75	java/io/File:exists	()Z
    //   643: ifeq +102 -> 745
    //   646: aload 8
    //   648: invokevirtual 296	java/io/File:isFile	()Z
    //   651: ifeq +94 -> 745
    //   654: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   657: ifeq +30 -> 687
    //   660: ldc 132
    //   662: iconst_2
    //   663: new 50	java/lang/StringBuilder
    //   666: dup
    //   667: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   670: ldc_w 298
    //   673: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: aload 13
    //   678: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: invokevirtual 66	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   687: new 183	java/io/FileInputStream
    //   690: dup
    //   691: aload 13
    //   693: invokespecial 299	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   696: astore 9
    //   698: aload 9
    //   700: astore 8
    //   702: aload 9
    //   704: new 57	java/io/File
    //   707: dup
    //   708: aload 13
    //   710: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   713: invokevirtual 179	java/io/File:length	()J
    //   716: invokestatic 192	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   719: astore_1
    //   720: aload 9
    //   722: ifnull +8 -> 730
    //   725: aload 9
    //   727: invokevirtual 208	java/io/FileInputStream:close	()V
    //   730: aload_0
    //   731: getfield 36	bkut:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   734: invokevirtual 303	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   737: ifnonnull +106 -> 843
    //   740: iconst_m1
    //   741: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   744: areturn
    //   745: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   748: ifeq +12 -> 760
    //   751: ldc 132
    //   753: iconst_2
    //   754: ldc_w 305
    //   757: invokestatic 142	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   760: iconst_m1
    //   761: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   764: areturn
    //   765: astore 8
    //   767: aload 8
    //   769: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   772: goto -42 -> 730
    //   775: astore 8
    //   777: aload 8
    //   779: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   782: aconst_null
    //   783: astore_1
    //   784: iconst_m1
    //   785: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   788: astore_1
    //   789: aload_1
    //   790: astore 8
    //   792: iconst_0
    //   793: ifeq -741 -> 52
    //   796: new 260	java/lang/NullPointerException
    //   799: dup
    //   800: invokespecial 261	java/lang/NullPointerException:<init>	()V
    //   803: athrow
    //   804: astore 8
    //   806: aload 8
    //   808: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   811: aload_1
    //   812: areturn
    //   813: astore 9
    //   815: aload_1
    //   816: astore 8
    //   818: aload 9
    //   820: astore_1
    //   821: aload 8
    //   823: ifnull +8 -> 831
    //   826: aload 8
    //   828: invokevirtual 208	java/io/FileInputStream:close	()V
    //   831: aload_1
    //   832: athrow
    //   833: astore 8
    //   835: aload 8
    //   837: invokevirtual 211	java/io/IOException:printStackTrace	()V
    //   840: goto -9 -> 831
    //   843: aload_0
    //   844: getfield 18	bkut:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   847: aload 11
    //   849: invokestatic 308	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;Ljava/lang/String;)Ljava/lang/String;
    //   852: pop
    //   853: aload_0
    //   854: getfield 18	bkut:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   857: aload_1
    //   858: invokestatic 311	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;[B)[B
    //   861: pop
    //   862: aload_0
    //   863: getfield 18	bkut:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   866: aload 13
    //   868: invokestatic 313	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:b	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;Ljava/lang/String;)Ljava/lang/String;
    //   871: pop
    //   872: aload_0
    //   873: getfield 18	bkut:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   876: aload_0
    //   877: getfield 29	bkut:jdField_a_of_type_Int	I
    //   880: invokestatic 316	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;I)I
    //   883: pop
    //   884: aload_0
    //   885: getfield 18	bkut:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   888: invokestatic 319	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Laytt;
    //   891: ifnonnull +40 -> 931
    //   894: aload_0
    //   895: getfield 18	bkut:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   898: new 321	aytt
    //   901: dup
    //   902: aload_0
    //   903: getfield 36	bkut:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   906: invokevirtual 303	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   909: checkcast 323	com/tencent/common/app/AppInterface
    //   912: aload_0
    //   913: getfield 38	bkut:jdField_a_of_type_Aytv	Laytv;
    //   916: aload 10
    //   918: aload 12
    //   920: getstatic 327	ahty:b	I
    //   923: iconst_0
    //   924: invokespecial 330	aytt:<init>	(Lcom/tencent/common/app/AppInterface;Laytv;Ljava/lang/String;[BIZ)V
    //   927: invokestatic 333	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;Laytt;)Laytt;
    //   930: pop
    //   931: aload_0
    //   932: getfield 18	bkut:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   935: invokestatic 319	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Laytt;
    //   938: invokevirtual 335	aytt:a	()Z
    //   941: pop
    //   942: aload_0
    //   943: getfield 18	bkut:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   946: invokestatic 338	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Lbfnk;
    //   949: iconst_m1
    //   950: ldc2_w 339
    //   953: invokevirtual 346	bfnk:sendEmptyMessageDelayed	(IJ)Z
    //   956: pop
    //   957: aload_0
    //   958: getfield 18	bkut:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   961: invokestatic 351	android/os/SystemClock:elapsedRealtime	()J
    //   964: invokestatic 354	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;J)J
    //   967: pop2
    //   968: iconst_0
    //   969: invokestatic 167	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   972: areturn
    //   973: astore_1
    //   974: goto -153 -> 821
    //   977: astore 9
    //   979: aload_1
    //   980: astore 8
    //   982: aload 9
    //   984: astore_1
    //   985: goto -164 -> 821
    //   988: astore 8
    //   990: aload 9
    //   992: astore_1
    //   993: goto -216 -> 777
    //   996: astore_1
    //   997: goto -547 -> 450
    //   1000: astore 9
    //   1002: goto -595 -> 407
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1005	0	this	bkut
    //   0	1005	1	paramVarArgs	Void[]
    //   41	6	2	i	int
    //   102	209	3	l1	long
    //   285	228	5	l2	long
    //   595	8	7	bool	boolean
    //   11	373	8	localObject1	Object
    //   393	3	8	localIOException1	java.io.IOException
    //   408	16	8	arrayOfVoid1	Void[]
    //   437	3	8	localIOException2	java.io.IOException
    //   448	8	8	localObject2	Object
    //   462	3	8	localIOException3	java.io.IOException
    //   544	3	8	localException	java.lang.Exception
    //   557	144	8	localObject3	Object
    //   765	3	8	localIOException4	java.io.IOException
    //   775	3	8	localIOException5	java.io.IOException
    //   790	1	8	arrayOfVoid2	Void[]
    //   804	3	8	localIOException6	java.io.IOException
    //   816	11	8	arrayOfVoid3	Void[]
    //   833	3	8	localIOException7	java.io.IOException
    //   980	1	8	arrayOfVoid4	Void[]
    //   988	1	8	localIOException8	java.io.IOException
    //   210	169	9	localObject4	Object
    //   403	161	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   696	30	9	localFileInputStream	java.io.FileInputStream
    //   813	6	9	localObject5	Object
    //   977	14	9	localObject6	Object
    //   1000	1	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   59	858	10	str1	String
    //   155	693	11	str2	String
    //   145	774	12	arrayOfByte	byte[]
    //   581	286	13	str3	String
    // Exception table:
    //   from	to	target	type
    //   220	224	227	java/io/IOException
    //   239	243	393	java/io/IOException
    //   128	137	403	java/io/FileNotFoundException
    //   429	437	437	java/io/IOException
    //   128	137	446	finally
    //   455	460	462	java/io/IOException
    //   252	259	472	java/lang/IllegalArgumentException
    //   275	284	517	java/lang/OutOfMemoryError
    //   287	297	517	java/lang/OutOfMemoryError
    //   300	310	517	java/lang/OutOfMemoryError
    //   323	365	517	java/lang/OutOfMemoryError
    //   365	378	517	java/lang/OutOfMemoryError
    //   275	284	544	java/lang/Exception
    //   287	297	544	java/lang/Exception
    //   300	310	544	java/lang/Exception
    //   323	365	544	java/lang/Exception
    //   365	378	544	java/lang/Exception
    //   275	284	562	finally
    //   287	297	562	finally
    //   300	310	562	finally
    //   323	365	562	finally
    //   365	378	562	finally
    //   518	534	562	finally
    //   546	551	562	finally
    //   725	730	765	java/io/IOException
    //   687	698	775	java/io/IOException
    //   796	804	804	java/io/IOException
    //   687	698	813	finally
    //   826	831	833	java/io/IOException
    //   702	720	973	finally
    //   777	782	977	finally
    //   702	720	988	java/io/IOException
    //   140	147	996	finally
    //   150	157	996	finally
    //   160	168	996	finally
    //   171	177	996	finally
    //   180	206	996	finally
    //   410	415	996	finally
    //   140	147	1000	java/io/FileNotFoundException
    //   150	157	1000	java/io/FileNotFoundException
    //   160	168	1000	java/io/FileNotFoundException
    //   171	177	1000	java/io/FileNotFoundException
    //   180	206	1000	java/io/FileNotFoundException
  }
  
  protected void a(Integer paramInteger)
  {
    if (paramInteger.intValue() != 0)
    {
      EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity);
      EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity).removeMessages(-1);
    }
  }
  
  protected void onPreExecute()
  {
    EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity, this.jdField_a_of_type_AndroidAppActivity, 2131698736);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkut
 * JD-Core Version:    0.7.0.1
 */