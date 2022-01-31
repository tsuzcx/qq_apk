import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.reactive.SimpleObserver;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import dov.com.tencent.biz.qqstory.takevideo.EditWebVideoPartManager.2;
import dov.com.tencent.biz.qqstory.takevideo.publish.PublishParam;

public class bjze
  extends bjxn
{
  private double jdField_a_of_type_Double;
  private aigo jdField_a_of_type_Aigo;
  private aigp jdField_a_of_type_Aigp;
  private double b;
  public int c;
  
  /* Error */
  private int a(PublishParam paramPublishParam)
  {
    // Byte code:
    //   0: new 29	blck
    //   3: dup
    //   4: invokespecial 30	blck:<init>	()V
    //   7: astore 9
    //   9: new 32	java/io/File
    //   12: dup
    //   13: aload_1
    //   14: getfield 38	dov/com/tencent/biz/qqstory/takevideo/publish/PublishParam:j	Ljava/lang/String;
    //   17: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 45	java/io/File:getParentFile	()Ljava/io/File;
    //   23: invokevirtual 49	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   26: astore 10
    //   28: aload_1
    //   29: getfield 51	dov/com/tencent/biz/qqstory/takevideo/publish/PublishParam:c	Ljava/lang/String;
    //   32: astore 11
    //   34: aload_1
    //   35: getfield 38	dov/com/tencent/biz/qqstory/takevideo/publish/PublishParam:j	Ljava/lang/String;
    //   38: astore_1
    //   39: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq +29 -> 71
    //   45: ldc 59
    //   47: iconst_2
    //   48: new 61	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   55: ldc 64
    //   57: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: aload 10
    //   62: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   71: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   74: lstore 7
    //   76: aload_0
    //   77: new 83	aigp
    //   80: dup
    //   81: invokespecial 84	aigp:<init>	()V
    //   84: putfield 86	bjze:jdField_a_of_type_Aigp	Laigp;
    //   87: aload_1
    //   88: invokestatic 91	bbdx:b	(Ljava/lang/String;)Z
    //   91: ifne +23 -> 114
    //   94: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +11 -> 108
    //   100: ldc 59
    //   102: iconst_2
    //   103: ldc 93
    //   105: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   108: sipush -300
    //   111: istore_2
    //   112: iload_2
    //   113: ireturn
    //   114: aload 11
    //   116: invokestatic 91	bbdx:b	(Ljava/lang/String;)Z
    //   119: ifne +21 -> 140
    //   122: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   125: ifeq +11 -> 136
    //   128: ldc 59
    //   130: iconst_2
    //   131: ldc 95
    //   133: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: sipush -301
    //   139: ireturn
    //   140: aload_1
    //   141: aload 9
    //   143: invokestatic 100	blcj:a	(Ljava/lang/String;Lblck;)I
    //   146: istore_3
    //   147: iload_3
    //   148: ifeq +38 -> 186
    //   151: iload_3
    //   152: istore_2
    //   153: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq -44 -> 112
    //   159: ldc 59
    //   161: iconst_2
    //   162: new 61	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   169: ldc 102
    //   171: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload_3
    //   175: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   178: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: iload_3
    //   185: ireturn
    //   186: aload 9
    //   188: getfield 108	blck:a	[I
    //   191: iconst_3
    //   192: iaload
    //   193: sipush 500
    //   196: iadd
    //   197: sipush 1000
    //   200: idiv
    //   201: istore 5
    //   203: aload 9
    //   205: getfield 108	blck:a	[I
    //   208: iconst_2
    //   209: iaload
    //   210: istore 6
    //   212: aload 9
    //   214: getfield 108	blck:a	[I
    //   217: iconst_0
    //   218: iaload
    //   219: istore 4
    //   221: aload 9
    //   223: getfield 108	blck:a	[I
    //   226: iconst_1
    //   227: iaload
    //   228: istore_2
    //   229: iload 6
    //   231: bipush 90
    //   233: if_icmpeq +13 -> 246
    //   236: iload_2
    //   237: istore_3
    //   238: iload 6
    //   240: sipush 270
    //   243: if_icmpne +14 -> 257
    //   246: aload 9
    //   248: getfield 108	blck:a	[I
    //   251: iconst_0
    //   252: iaload
    //   253: istore_3
    //   254: iload_2
    //   255: istore 4
    //   257: aload 11
    //   259: aload_0
    //   260: getfield 19	bjze:jdField_a_of_type_Double	D
    //   263: aload_0
    //   264: getfield 110	bjze:b	D
    //   267: invokestatic 115	bbef:a	(Ljava/lang/String;DD)Z
    //   270: pop
    //   271: new 32	java/io/File
    //   274: dup
    //   275: aload 11
    //   277: invokespecial 41	java/io/File:<init>	(Ljava/lang/String;)V
    //   280: astore_1
    //   281: new 117	java/io/FileInputStream
    //   284: dup
    //   285: aload 11
    //   287: invokespecial 118	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   290: astore 9
    //   292: aload 9
    //   294: aload_1
    //   295: invokevirtual 121	java/io/File:length	()J
    //   298: invokestatic 127	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   301: astore_1
    //   302: aload_1
    //   303: invokestatic 133	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   306: astore 10
    //   308: aload 9
    //   310: ifnull +8 -> 318
    //   313: aload 9
    //   315: invokevirtual 136	java/io/FileInputStream:close	()V
    //   318: aload 10
    //   320: invokestatic 142	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   323: ifeq +43 -> 366
    //   326: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +11 -> 340
    //   332: ldc 59
    //   334: iconst_2
    //   335: ldc 144
    //   337: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   340: sipush -302
    //   343: ireturn
    //   344: astore_1
    //   345: aconst_null
    //   346: astore 9
    //   348: aconst_null
    //   349: astore_1
    //   350: aconst_null
    //   351: astore 10
    //   353: goto -45 -> 308
    //   356: astore 9
    //   358: aload 9
    //   360: invokevirtual 147	java/io/IOException:printStackTrace	()V
    //   363: goto -45 -> 318
    //   366: aload 10
    //   368: ldc 149
    //   370: invokestatic 154	dov/com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   373: astore 9
    //   375: aload 11
    //   377: aload 9
    //   379: invokestatic 157	bbdx:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   382: ifeq +86 -> 468
    //   385: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   388: ifeq +38 -> 426
    //   391: ldc 59
    //   393: iconst_2
    //   394: new 61	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   401: ldc 159
    //   403: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: invokestatic 81	java/lang/System:currentTimeMillis	()J
    //   409: lload 7
    //   411: lsub
    //   412: l2d
    //   413: ldc2_w 160
    //   416: ddiv
    //   417: invokevirtual 164	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   420: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   423: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   426: aload_0
    //   427: getfield 86	bjze:jdField_a_of_type_Aigp	Laigp;
    //   430: aload 9
    //   432: putfield 166	aigp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   435: aload_0
    //   436: getfield 86	bjze:jdField_a_of_type_Aigp	Laigp;
    //   439: aload_1
    //   440: putfield 169	aigp:jdField_a_of_type_ArrayOfByte	[B
    //   443: aload_0
    //   444: getfield 86	bjze:jdField_a_of_type_Aigp	Laigp;
    //   447: iload 4
    //   449: putfield 171	aigp:jdField_a_of_type_Int	I
    //   452: aload_0
    //   453: getfield 86	bjze:jdField_a_of_type_Aigp	Laigp;
    //   456: iload_3
    //   457: putfield 173	aigp:b	I
    //   460: aload_0
    //   461: iload 5
    //   463: putfield 175	bjze:c	I
    //   466: iconst_0
    //   467: ireturn
    //   468: aload 9
    //   470: invokestatic 91	bbdx:b	(Ljava/lang/String;)Z
    //   473: ifne +60 -> 533
    //   476: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +39 -> 518
    //   482: ldc 59
    //   484: iconst_2
    //   485: new 61	java/lang/StringBuilder
    //   488: dup
    //   489: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   492: ldc 177
    //   494: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: aload 11
    //   499: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: ldc 179
    //   504: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: aload 9
    //   509: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   515: invokestatic 75	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   518: sipush -301
    //   521: ireturn
    //   522: astore_1
    //   523: aconst_null
    //   524: astore_1
    //   525: goto -175 -> 350
    //   528: astore 10
    //   530: goto -180 -> 350
    //   533: aload 11
    //   535: astore 9
    //   537: goto -152 -> 385
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	540	0	this	bjze
    //   0	540	1	paramPublishParam	PublishParam
    //   111	144	2	i	int
    //   146	311	3	j	int
    //   219	229	4	k	int
    //   201	261	5	m	int
    //   210	34	6	n	int
    //   74	336	7	l	long
    //   7	340	9	localObject1	java.lang.Object
    //   356	3	9	localIOException	java.io.IOException
    //   373	163	9	localObject2	java.lang.Object
    //   26	341	10	str1	java.lang.String
    //   528	1	10	localFileNotFoundException	java.io.FileNotFoundException
    //   32	502	11	str2	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   281	292	344	java/io/FileNotFoundException
    //   313	318	356	java/io/IOException
    //   292	302	522	java/io/FileNotFoundException
    //   302	308	528	java/io/FileNotFoundException
  }
  
  private void a(Activity paramActivity, EditVideoParams.EditSource paramEditSource, PublishParam paramPublishParam)
  {
    ThreadManager.post(new EditWebVideoPartManager.2(this, paramEditSource, paramPublishParam, paramActivity), 5, null, true);
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: invokestatic 211	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	()Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;
    //   3: astore 10
    //   5: invokestatic 216	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   8: ifeq +234 -> 242
    //   11: ldc 218
    //   13: iconst_0
    //   14: invokestatic 224	cooperation/qzone/thread/QzoneHandlerThreadFactory:getHandlerThread	(Ljava/lang/String;Z)Lcooperation/qzone/thread/QzoneBaseThread;
    //   17: new 226	dov/com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager$3
    //   20: dup
    //   21: aload_0
    //   22: aload 10
    //   24: invokespecial 229	dov/com/tencent/biz/qqstory/takevideo/EditWebVideoPartManager$3:<init>	(Lbjze;Ldov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr;)V
    //   27: invokevirtual 234	cooperation/qzone/thread/QzoneBaseThread:post	(Ljava/lang/Runnable;)V
    //   30: invokestatic 216	com/tencent/mobileqq/shortvideo/VideoEnvironment:d	()Z
    //   33: ifeq +208 -> 241
    //   36: lconst_0
    //   37: lstore 6
    //   39: aload 10
    //   41: getfield 237	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   44: astore 9
    //   46: aload 9
    //   48: monitorenter
    //   49: aload 10
    //   51: getfield 237	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   54: invokevirtual 242	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   57: istore 8
    //   59: lload 6
    //   61: lstore 4
    //   63: iload 8
    //   65: ifne +103 -> 168
    //   68: lload 6
    //   70: lstore_2
    //   71: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   74: ifeq +14 -> 88
    //   77: lload 6
    //   79: lstore_2
    //   80: ldc 59
    //   82: iconst_2
    //   83: ldc 244
    //   85: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   88: lload 6
    //   90: lstore_2
    //   91: invokestatic 251	android/os/SystemClock:elapsedRealtime	()J
    //   94: lstore 4
    //   96: lload 6
    //   98: lstore_2
    //   99: aload 10
    //   101: getfield 237	dov/com/tencent/mobileqq/activity/richmedia/state/RMVideoStateMgr:a	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   104: ldc2_w 252
    //   107: invokevirtual 259	java/lang/Object:wait	(J)V
    //   110: lload 6
    //   112: lstore_2
    //   113: invokestatic 251	android/os/SystemClock:elapsedRealtime	()J
    //   116: lload 4
    //   118: lsub
    //   119: lstore 6
    //   121: lload 6
    //   123: lstore 4
    //   125: lload 6
    //   127: lstore_2
    //   128: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +37 -> 168
    //   134: lload 6
    //   136: lstore_2
    //   137: ldc 59
    //   139: iconst_2
    //   140: new 61	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 261
    //   150: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: lload 6
    //   155: invokevirtual 264	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   158: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: lload 6
    //   166: lstore 4
    //   168: aload 9
    //   170: monitorexit
    //   171: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq +12 -> 186
    //   177: ldc 59
    //   179: iconst_2
    //   180: ldc_w 266
    //   183: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: lload 4
    //   188: ldc2_w 267
    //   191: lcmp
    //   192: ifge +49 -> 241
    //   195: bipush 30
    //   197: lload 4
    //   199: l2i
    //   200: isub
    //   201: istore_1
    //   202: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   205: ifeq +29 -> 234
    //   208: ldc 59
    //   210: iconst_2
    //   211: new 61	java/lang/StringBuilder
    //   214: dup
    //   215: invokespecial 62	java/lang/StringBuilder:<init>	()V
    //   218: ldc_w 270
    //   221: invokevirtual 68	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: iload_1
    //   225: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   231: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   234: iload_1
    //   235: i2l
    //   236: lstore_2
    //   237: lload_2
    //   238: invokestatic 275	java/lang/Thread:sleep	(J)V
    //   241: return
    //   242: invokestatic 280	blbm:a	()Lblbm;
    //   245: invokevirtual 283	blbm:a	()Lcom/tencent/maxvideo/mediadevice/AVCodec;
    //   248: invokevirtual 289	com/tencent/maxvideo/mediadevice/AVCodec:recordSubmit	()I
    //   251: pop
    //   252: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   255: ifeq -225 -> 30
    //   258: ldc 59
    //   260: iconst_2
    //   261: ldc_w 291
    //   264: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   267: goto -237 -> 30
    //   270: astore 9
    //   272: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   275: ifeq +12 -> 287
    //   278: ldc 59
    //   280: iconst_2
    //   281: ldc_w 293
    //   284: invokestatic 246	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   287: aload 9
    //   289: invokevirtual 294	java/lang/UnsatisfiedLinkError:printStackTrace	()V
    //   292: goto -262 -> 30
    //   295: astore 10
    //   297: lload_2
    //   298: lstore 4
    //   300: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   303: ifeq -135 -> 168
    //   306: ldc 59
    //   308: iconst_2
    //   309: ldc_w 296
    //   312: aload 10
    //   314: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   317: lload_2
    //   318: lstore 4
    //   320: goto -152 -> 168
    //   323: astore 10
    //   325: aload 9
    //   327: monitorexit
    //   328: aload 10
    //   330: athrow
    //   331: astore 9
    //   333: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq -95 -> 241
    //   339: ldc 59
    //   341: iconst_2
    //   342: ldc_w 302
    //   345: aload 9
    //   347: invokestatic 300	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   350: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	bjze
    //   201	34	1	i	int
    //   70	248	2	l1	long
    //   61	258	4	l2	long
    //   37	128	6	l3	long
    //   57	7	8	bool	boolean
    //   44	125	9	localAtomicBoolean	java.util.concurrent.atomic.AtomicBoolean
    //   270	56	9	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
    //   331	15	9	localInterruptedException1	java.lang.InterruptedException
    //   3	97	10	localRMVideoStateMgr	dov.com.tencent.mobileqq.activity.richmedia.state.RMVideoStateMgr
    //   295	18	10	localInterruptedException2	java.lang.InterruptedException
    //   323	6	10	localObject	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   242	267	270	java/lang/UnsatisfiedLinkError
    //   71	77	295	java/lang/InterruptedException
    //   80	88	295	java/lang/InterruptedException
    //   91	96	295	java/lang/InterruptedException
    //   99	110	295	java/lang/InterruptedException
    //   113	121	295	java/lang/InterruptedException
    //   128	134	295	java/lang/InterruptedException
    //   137	164	295	java/lang/InterruptedException
    //   49	59	323	finally
    //   71	77	323	finally
    //   80	88	323	finally
    //   91	96	323	finally
    //   99	110	323	finally
    //   113	121	323	finally
    //   128	134	323	finally
    //   137	164	323	finally
    //   168	171	323	finally
    //   300	317	323	finally
    //   325	328	323	finally
    //   237	241	331	java/lang/InterruptedException
  }
  
  protected SimpleObserver<bkld> a()
  {
    return new bjzf(this);
  }
  
  public void a(aigo paramaigo)
  {
    if (paramaigo != null) {
      this.jdField_a_of_type_Aigo = paramaigo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjze
 * JD-Core Version:    0.7.0.1
 */