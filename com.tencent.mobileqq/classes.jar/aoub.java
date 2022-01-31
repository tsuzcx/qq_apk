import android.app.Activity;
import android.os.AsyncTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder.AudioData;
import com.tencent.mobileqq.transfile.QIMWebVideoUploader.IQIMWebVideoUpCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import dov.com.tencent.mobileqq.richmedia.capture.activity.EditWebDanceMachineVideoActivity;
import dov.com.tencent.mobileqq.shortvideo.util.HwVideoMerge;
import java.io.File;
import java.lang.ref.WeakReference;

public class aoub
  extends AsyncTask
{
  int jdField_a_of_type_Int;
  Activity jdField_a_of_type_AndroidAppActivity;
  QIMWebVideoUploader.IQIMWebVideoUpCallback jdField_a_of_type_ComTencentMobileqqTransfileQIMWebVideoUploader$IQIMWebVideoUpCallback;
  String jdField_a_of_type_JavaLangString;
  public WeakReference a;
  String b;
  
  public aoub(EditWebDanceMachineVideoActivity paramEditWebDanceMachineVideoActivity, Activity paramActivity, String paramString1, String paramString2, int paramInt, AppInterface paramAppInterface, QIMWebVideoUploader.IQIMWebVideoUpCallback paramIQIMWebVideoUpCallback)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqTransfileQIMWebVideoUploader$IQIMWebVideoUpCallback = paramIQIMWebVideoUpCallback;
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
    ((AudioEncoder.AudioData)localObject).b = paramString1;
    ((AudioEncoder.AudioData)localObject).jdField_a_of_type_JavaLangString = paramString2;
    int i = AudioEncoder.a(paramString2);
    if (i != 0) {
      a("checkSourceAudioIsOK: errcode=" + i, null);
    }
    for (;;)
    {
      return 0;
      long l = System.currentTimeMillis();
      i = AudioEncoder.a((AudioEncoder.AudioData)localObject);
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
        i = HwVideoMerge.a(paramString3, paramString1, paramString4, 0);
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
  protected Integer a(java.lang.Void... paramVarArgs)
  {
    // Byte code:
    //   0: new 55	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 25	aoub:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   8: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 8
    //   13: aload 8
    //   15: invokevirtual 154	java/io/File:getParent	()Ljava/lang/String;
    //   18: astore_1
    //   19: aload 8
    //   21: invokevirtual 157	java/io/File:getName	()Ljava/lang/String;
    //   24: astore 8
    //   26: aload_0
    //   27: aload_1
    //   28: aload_0
    //   29: getfield 23	aoub:b	Ljava/lang/String;
    //   32: aload_0
    //   33: getfield 25	aoub:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   36: aload 8
    //   38: invokespecial 159	aoub:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   41: istore_2
    //   42: iload_2
    //   43: ifeq +12 -> 55
    //   46: iload_2
    //   47: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   50: astore 8
    //   52: aload 8
    //   54: areturn
    //   55: aload_0
    //   56: getfield 25	aoub:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   59: astore 10
    //   61: aload 10
    //   63: invokestatic 170	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   66: ifne +22 -> 88
    //   69: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   72: ifeq +11 -> 83
    //   75: ldc 130
    //   77: iconst_2
    //   78: ldc 172
    //   80: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: iconst_m1
    //   84: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: areturn
    //   88: new 55	java/io/File
    //   91: dup
    //   92: aload 10
    //   94: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   97: astore_1
    //   98: aload_1
    //   99: invokevirtual 177	java/io/File:length	()J
    //   102: lstore 4
    //   104: lload 4
    //   106: lconst_0
    //   107: lcmp
    //   108: ifne +22 -> 130
    //   111: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +11 -> 125
    //   117: ldc 130
    //   119: iconst_2
    //   120: ldc 179
    //   122: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: iconst_m1
    //   126: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: areturn
    //   130: new 181	java/io/FileInputStream
    //   133: dup
    //   134: aload_1
    //   135: invokespecial 184	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   138: astore_1
    //   139: aload_1
    //   140: astore 8
    //   142: aload_1
    //   143: lload 4
    //   145: invokestatic 190	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   148: astore 12
    //   150: aload_1
    //   151: astore 8
    //   153: aload 12
    //   155: invokestatic 195	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   158: astore 11
    //   160: aload_1
    //   161: astore 8
    //   163: aload 11
    //   165: invokestatic 201	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   168: ifeq +70 -> 238
    //   171: aload_1
    //   172: astore 8
    //   174: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +32 -> 209
    //   180: aload_1
    //   181: astore 8
    //   183: ldc 130
    //   185: iconst_2
    //   186: new 48	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   193: ldc 203
    //   195: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload 11
    //   200: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: iconst_m1
    //   210: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   213: astore 9
    //   215: aload 9
    //   217: astore 8
    //   219: aload_1
    //   220: ifnull -168 -> 52
    //   223: aload_1
    //   224: invokevirtual 206	java/io/FileInputStream:close	()V
    //   227: aload 9
    //   229: areturn
    //   230: astore_1
    //   231: aload_1
    //   232: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   235: aload 9
    //   237: areturn
    //   238: aload_1
    //   239: ifnull +7 -> 246
    //   242: aload_1
    //   243: invokevirtual 206	java/io/FileInputStream:close	()V
    //   246: new 211	android/media/MediaMetadataRetriever
    //   249: dup
    //   250: invokespecial 212	android/media/MediaMetadataRetriever:<init>	()V
    //   253: astore 9
    //   255: aload 9
    //   257: aload 10
    //   259: invokevirtual 215	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   262: lconst_0
    //   263: lstore 4
    //   265: aload 9
    //   267: bipush 9
    //   269: invokevirtual 219	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   272: astore 8
    //   274: aload 8
    //   276: ifnull +13 -> 289
    //   279: aload 8
    //   281: invokestatic 224	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   284: invokevirtual 227	java/lang/Long:longValue	()J
    //   287: lstore 4
    //   289: lload 4
    //   291: lstore 6
    //   293: aload_0
    //   294: getfield 16	aoub:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   297: invokestatic 232	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Z
    //   300: ifne +31 -> 331
    //   303: lload 4
    //   305: lstore 6
    //   307: aload_0
    //   308: getfield 16	aoub:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   311: invokestatic 234	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:b	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Z
    //   314: ifne +17 -> 331
    //   317: lload 4
    //   319: ldc2_w 235
    //   322: lcmp
    //   323: ifle +196 -> 519
    //   326: ldc2_w 235
    //   329: lstore 6
    //   331: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq +39 -> 373
    //   337: ldc 130
    //   339: iconst_2
    //   340: new 48	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   347: ldc 238
    //   349: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload 8
    //   354: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: ldc 240
    //   359: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: lload 6
    //   364: invokevirtual 243	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   367: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 246	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: aload 9
    //   375: lload 6
    //   377: ldc2_w 247
    //   380: lmul
    //   381: invokevirtual 252	android/media/MediaMetadataRetriever:getFrameAtTime	(J)Landroid/graphics/Bitmap;
    //   384: astore 8
    //   386: aload 9
    //   388: invokevirtual 255	android/media/MediaMetadataRetriever:release	()V
    //   391: aload 8
    //   393: ifnonnull +185 -> 578
    //   396: iconst_m1
    //   397: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   400: areturn
    //   401: astore 8
    //   403: aload 8
    //   405: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   408: goto -162 -> 246
    //   411: astore 9
    //   413: aconst_null
    //   414: astore_1
    //   415: aload_1
    //   416: astore 8
    //   418: aload 9
    //   420: invokevirtual 256	java/io/FileNotFoundException:printStackTrace	()V
    //   423: aconst_null
    //   424: astore_1
    //   425: iconst_m1
    //   426: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   429: astore_1
    //   430: aload_1
    //   431: astore 8
    //   433: iconst_0
    //   434: ifeq -382 -> 52
    //   437: new 258	java/lang/NullPointerException
    //   440: dup
    //   441: invokespecial 259	java/lang/NullPointerException:<init>	()V
    //   444: athrow
    //   445: astore 8
    //   447: aload 8
    //   449: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   452: aload_1
    //   453: areturn
    //   454: astore_1
    //   455: aconst_null
    //   456: astore 8
    //   458: aload 8
    //   460: ifnull +8 -> 468
    //   463: aload 8
    //   465: invokevirtual 206	java/io/FileInputStream:close	()V
    //   468: aload_1
    //   469: athrow
    //   470: astore 8
    //   472: aload 8
    //   474: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   477: goto -9 -> 468
    //   480: astore_1
    //   481: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +30 -> 514
    //   487: ldc 130
    //   489: iconst_2
    //   490: new 48	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   497: ldc_w 261
    //   500: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload 10
    //   505: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 174	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   514: iconst_m1
    //   515: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   518: areturn
    //   519: lconst_0
    //   520: lstore 6
    //   522: goto -191 -> 331
    //   525: astore_1
    //   526: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   529: ifeq +13 -> 542
    //   532: ldc 130
    //   534: iconst_2
    //   535: ldc_w 263
    //   538: aload_1
    //   539: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   542: aload 9
    //   544: invokevirtual 255	android/media/MediaMetadataRetriever:release	()V
    //   547: iconst_m1
    //   548: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   551: areturn
    //   552: astore 8
    //   554: aload 8
    //   556: invokevirtual 264	java/lang/Exception:printStackTrace	()V
    //   559: aload 9
    //   561: invokevirtual 255	android/media/MediaMetadataRetriever:release	()V
    //   564: aconst_null
    //   565: astore 8
    //   567: goto -176 -> 391
    //   570: astore_1
    //   571: aload 9
    //   573: invokevirtual 255	android/media/MediaMetadataRetriever:release	()V
    //   576: aload_1
    //   577: athrow
    //   578: iconst_2
    //   579: iconst_2
    //   580: invokestatic 268	dov/com/tencent/biz/qqstory/takevideo/publish/PublishFileManager:a	(I)Ljava/lang/String;
    //   583: ldc_w 270
    //   586: invokestatic 273	dov/com/tencent/biz/qqstory/takevideo/publish/PublishFileManager:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   589: astore 13
    //   591: aload 8
    //   593: getstatic 279	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   596: bipush 100
    //   598: aload 13
    //   600: invokestatic 284	com/tencent/biz/qqstory/utils/BitmapUtils:a	(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap$CompressFormat;ILjava/lang/String;)Z
    //   603: istore_3
    //   604: aload 8
    //   606: invokevirtual 289	android/graphics/Bitmap:recycle	()V
    //   609: iload_3
    //   610: ifne +23 -> 633
    //   613: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   616: ifeq +12 -> 628
    //   619: ldc 130
    //   621: iconst_2
    //   622: ldc_w 291
    //   625: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   628: iconst_m1
    //   629: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   632: areturn
    //   633: new 55	java/io/File
    //   636: dup
    //   637: aload 13
    //   639: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   642: astore 8
    //   644: aload 8
    //   646: invokevirtual 73	java/io/File:exists	()Z
    //   649: ifeq +102 -> 751
    //   652: aload 8
    //   654: invokevirtual 294	java/io/File:isFile	()Z
    //   657: ifeq +94 -> 751
    //   660: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   663: ifeq +30 -> 693
    //   666: ldc 130
    //   668: iconst_2
    //   669: new 48	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 49	java/lang/StringBuilder:<init>	()V
    //   676: ldc_w 296
    //   679: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload 13
    //   684: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   693: new 181	java/io/FileInputStream
    //   696: dup
    //   697: aload 13
    //   699: invokespecial 297	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   702: astore 8
    //   704: aload 8
    //   706: astore 9
    //   708: aload 8
    //   710: new 55	java/io/File
    //   713: dup
    //   714: aload 13
    //   716: invokespecial 69	java/io/File:<init>	(Ljava/lang/String;)V
    //   719: invokevirtual 177	java/io/File:length	()J
    //   722: invokestatic 190	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   725: astore_1
    //   726: aload 8
    //   728: ifnull +8 -> 736
    //   731: aload 8
    //   733: invokevirtual 206	java/io/FileInputStream:close	()V
    //   736: aload_0
    //   737: getfield 34	aoub:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   740: invokevirtual 301	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   743: ifnonnull +106 -> 849
    //   746: iconst_m1
    //   747: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   750: areturn
    //   751: invokestatic 128	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   754: ifeq +12 -> 766
    //   757: ldc 130
    //   759: iconst_2
    //   760: ldc_w 303
    //   763: invokestatic 140	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   766: iconst_m1
    //   767: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   770: areturn
    //   771: astore 8
    //   773: aload 8
    //   775: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   778: goto -42 -> 736
    //   781: astore 8
    //   783: aload 8
    //   785: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   788: aconst_null
    //   789: astore_1
    //   790: iconst_m1
    //   791: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   794: astore_1
    //   795: aload_1
    //   796: astore 8
    //   798: iconst_0
    //   799: ifeq -747 -> 52
    //   802: new 258	java/lang/NullPointerException
    //   805: dup
    //   806: invokespecial 259	java/lang/NullPointerException:<init>	()V
    //   809: athrow
    //   810: astore 8
    //   812: aload 8
    //   814: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   817: aload_1
    //   818: areturn
    //   819: astore 9
    //   821: aload_1
    //   822: astore 8
    //   824: aload 9
    //   826: astore_1
    //   827: aload 8
    //   829: ifnull +8 -> 837
    //   832: aload 8
    //   834: invokevirtual 206	java/io/FileInputStream:close	()V
    //   837: aload_1
    //   838: athrow
    //   839: astore 8
    //   841: aload 8
    //   843: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   846: goto -9 -> 837
    //   849: aload_0
    //   850: getfield 16	aoub:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   853: aload 11
    //   855: invokestatic 306	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;Ljava/lang/String;)Ljava/lang/String;
    //   858: pop
    //   859: aload_0
    //   860: getfield 16	aoub:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   863: aload_1
    //   864: invokestatic 309	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;[B)[B
    //   867: pop
    //   868: aload_0
    //   869: getfield 16	aoub:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   872: aload 13
    //   874: invokestatic 311	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:b	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;Ljava/lang/String;)Ljava/lang/String;
    //   877: pop
    //   878: aload_0
    //   879: getfield 16	aoub:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   882: aload_0
    //   883: getfield 27	aoub:jdField_a_of_type_Int	I
    //   886: invokestatic 314	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;I)I
    //   889: pop
    //   890: aload_0
    //   891: getfield 16	aoub:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   894: invokestatic 317	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Lcom/tencent/mobileqq/transfile/QIMWebVideoUploader;
    //   897: ifnonnull +40 -> 937
    //   900: aload_0
    //   901: getfield 16	aoub:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   904: new 319	com/tencent/mobileqq/transfile/QIMWebVideoUploader
    //   907: dup
    //   908: aload_0
    //   909: getfield 34	aoub:jdField_a_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   912: invokevirtual 301	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   915: checkcast 321	com/tencent/common/app/AppInterface
    //   918: aload_0
    //   919: getfield 36	aoub:jdField_a_of_type_ComTencentMobileqqTransfileQIMWebVideoUploader$IQIMWebVideoUpCallback	Lcom/tencent/mobileqq/transfile/QIMWebVideoUploader$IQIMWebVideoUpCallback;
    //   922: aload 10
    //   924: aload 12
    //   926: getstatic 325	com/tencent/mobileqq/activity/richmedia/FlowCameraConstant:b	I
    //   929: iconst_0
    //   930: invokespecial 328	com/tencent/mobileqq/transfile/QIMWebVideoUploader:<init>	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/transfile/QIMWebVideoUploader$IQIMWebVideoUpCallback;Ljava/lang/String;[BIZ)V
    //   933: invokestatic 331	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;Lcom/tencent/mobileqq/transfile/QIMWebVideoUploader;)Lcom/tencent/mobileqq/transfile/QIMWebVideoUploader;
    //   936: pop
    //   937: aload_0
    //   938: getfield 16	aoub:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   941: invokestatic 317	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Lcom/tencent/mobileqq/transfile/QIMWebVideoUploader;
    //   944: invokevirtual 333	com/tencent/mobileqq/transfile/QIMWebVideoUploader:a	()Z
    //   947: pop
    //   948: aload_0
    //   949: getfield 16	aoub:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   952: invokestatic 336	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;)Lcom/tencent/util/MqqWeakReferenceHandler;
    //   955: iconst_m1
    //   956: ldc2_w 337
    //   959: invokevirtual 344	com/tencent/util/MqqWeakReferenceHandler:sendEmptyMessageDelayed	(IJ)Z
    //   962: pop
    //   963: aload_0
    //   964: getfield 16	aoub:jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity	Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;
    //   967: invokestatic 349	android/os/SystemClock:elapsedRealtime	()J
    //   970: invokestatic 352	dov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity:a	(Ldov/com/tencent/mobileqq/richmedia/capture/activity/EditWebDanceMachineVideoActivity;J)J
    //   973: pop2
    //   974: iconst_0
    //   975: invokestatic 165	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   978: areturn
    //   979: astore_1
    //   980: aload 9
    //   982: astore 8
    //   984: goto -157 -> 827
    //   987: astore 9
    //   989: aload_1
    //   990: astore 8
    //   992: aload 9
    //   994: astore_1
    //   995: goto -168 -> 827
    //   998: astore 9
    //   1000: aload 8
    //   1002: astore_1
    //   1003: aload 9
    //   1005: astore 8
    //   1007: goto -224 -> 783
    //   1010: astore_1
    //   1011: goto -553 -> 458
    //   1014: astore 9
    //   1016: goto -601 -> 415
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1019	0	this	aoub
    //   0	1019	1	paramVarArgs	java.lang.Void[]
    //   41	6	2	i	int
    //   603	7	3	bool	boolean
    //   102	216	4	l1	long
    //   291	230	6	l2	long
    //   11	381	8	localObject1	Object
    //   401	3	8	localIOException1	java.io.IOException
    //   416	16	8	arrayOfVoid1	java.lang.Void[]
    //   445	3	8	localIOException2	java.io.IOException
    //   456	8	8	localObject2	Object
    //   470	3	8	localIOException3	java.io.IOException
    //   552	3	8	localException	java.lang.Exception
    //   565	167	8	localObject3	Object
    //   771	3	8	localIOException4	java.io.IOException
    //   781	3	8	localIOException5	java.io.IOException
    //   796	1	8	arrayOfVoid2	java.lang.Void[]
    //   810	3	8	localIOException6	java.io.IOException
    //   822	11	8	arrayOfVoid3	java.lang.Void[]
    //   839	3	8	localIOException7	java.io.IOException
    //   982	24	8	localObject4	Object
    //   213	174	9	localObject5	Object
    //   411	161	9	localFileNotFoundException1	java.io.FileNotFoundException
    //   706	1	9	localObject6	Object
    //   819	162	9	localObject7	Object
    //   987	6	9	localObject8	Object
    //   998	6	9	localIOException8	java.io.IOException
    //   1014	1	9	localFileNotFoundException2	java.io.FileNotFoundException
    //   59	864	10	str1	String
    //   158	696	11	str2	String
    //   148	777	12	arrayOfByte	byte[]
    //   589	284	13	str3	String
    // Exception table:
    //   from	to	target	type
    //   223	227	230	java/io/IOException
    //   242	246	401	java/io/IOException
    //   130	139	411	java/io/FileNotFoundException
    //   437	445	445	java/io/IOException
    //   130	139	454	finally
    //   463	468	470	java/io/IOException
    //   255	262	480	java/lang/IllegalArgumentException
    //   279	289	525	java/lang/OutOfMemoryError
    //   293	303	525	java/lang/OutOfMemoryError
    //   307	317	525	java/lang/OutOfMemoryError
    //   331	373	525	java/lang/OutOfMemoryError
    //   373	386	525	java/lang/OutOfMemoryError
    //   279	289	552	java/lang/Exception
    //   293	303	552	java/lang/Exception
    //   307	317	552	java/lang/Exception
    //   331	373	552	java/lang/Exception
    //   373	386	552	java/lang/Exception
    //   279	289	570	finally
    //   293	303	570	finally
    //   307	317	570	finally
    //   331	373	570	finally
    //   373	386	570	finally
    //   526	542	570	finally
    //   554	559	570	finally
    //   731	736	771	java/io/IOException
    //   693	704	781	java/io/IOException
    //   802	810	810	java/io/IOException
    //   693	704	819	finally
    //   832	837	839	java/io/IOException
    //   708	726	979	finally
    //   783	788	987	finally
    //   708	726	998	java/io/IOException
    //   142	150	1010	finally
    //   153	160	1010	finally
    //   163	171	1010	finally
    //   174	180	1010	finally
    //   183	209	1010	finally
    //   418	423	1010	finally
    //   142	150	1014	java/io/FileNotFoundException
    //   153	160	1014	java/io/FileNotFoundException
    //   163	171	1014	java/io/FileNotFoundException
    //   174	180	1014	java/io/FileNotFoundException
    //   183	209	1014	java/io/FileNotFoundException
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
    EditWebDanceMachineVideoActivity.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureActivityEditWebDanceMachineVideoActivity, this.jdField_a_of_type_AndroidAppActivity, 2131437052);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoub
 * JD-Core Version:    0.7.0.1
 */