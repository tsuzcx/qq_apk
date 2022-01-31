package com.tencent.mobileqq.activity.aio;

import aela;
import aelb;
import aelc;
import aeld;
import android.annotation.TargetApi;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import athg;
import awtt;
import awtu;
import azmz;
import bday;
import bdaz;
import com.tencent.mobileqq.ptt.player.AmrPlayer;
import com.tencent.mobileqq.ptt.player.SilkPlayer;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;

public class AudioPlayer
  implements awtu, Runnable
{
  public static int a;
  private static final List<Integer> jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(1796) });
  public static boolean a;
  public static boolean b;
  private static int jdField_d_of_type_Int;
  private static boolean f;
  private float jdField_a_of_type_Float = MediaPlayerManager.jdField_a_of_type_Float;
  private long jdField_a_of_type_Long = -1L;
  private aelc jdField_a_of_type_Aelc;
  private Application jdField_a_of_type_AndroidAppApplication;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new aela(this);
  private awtt jdField_a_of_type_Awtt;
  private volatile bday jdField_a_of_type_Bday;
  private String jdField_a_of_type_JavaLangString;
  private Timer jdField_a_of_type_JavaUtilTimer;
  bday[] jdField_a_of_type_ArrayOfBday;
  private volatile int b;
  private volatile int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean e = true;
  private boolean g;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int = -999;
    jdField_d_of_type_Int = -1;
  }
  
  public AudioPlayer(Context paramContext, aelc paramaelc)
  {
    this.jdField_b_of_type_Int = jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidAppApplication = ((Application)paramContext.getApplicationContext());
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidAppApplication.getSystemService("audio"));
    this.jdField_a_of_type_Aelc = paramaelc;
  }
  
  private bday a()
  {
    if (this.jdField_a_of_type_ArrayOfBday == null) {
      this.jdField_a_of_type_ArrayOfBday = AudioHelper.a();
    }
    if ((this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()) && (jdField_a_of_type_Boolean)) {
      return this.jdField_a_of_type_ArrayOfBday[4];
    }
    if (this.jdField_c_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfBday[2];
    }
    if (this.jdField_d_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfBday[3];
    }
    bday[] arrayOfbday = this.jdField_a_of_type_ArrayOfBday;
    if (this.e) {}
    for (int i = 0;; i = 1) {
      return arrayOfbday[i];
    }
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("issilk", String.valueOf(paramInt2));
    localHashMap.put("isSuccess", String.valueOf(paramInt1));
    localHashMap.put("errorCode", String.valueOf(paramInt3));
    localHashMap.put("errormsg", paramString);
    azmz.a(BaseApplication.getContext()).a(null, "pttplaysuc", true, 0L, 0L, localHashMap, "");
  }
  
  private void a(AudioManager paramAudioManager)
  {
    paramAudioManager.setBluetoothScoOn(true);
  }
  
  @TargetApi(14)
  public static boolean a(AudioManager paramAudioManager)
  {
    if (!jdField_a_of_type_Boolean) {}
    BluetoothAdapter localBluetoothAdapter;
    do
    {
      do
      {
        return false;
      } while (Build.VERSION.SDK_INT < 14);
      localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    } while ((localBluetoothAdapter == null) || (!localBluetoothAdapter.isEnabled()) || (localBluetoothAdapter.getProfileConnectionState(1) != 2) || (localBluetoothAdapter.getProfileConnectionState(2) == 2) || (jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(jdField_d_of_type_Int))) || (f) || (paramAudioManager.isBluetoothScoOn()) || (!paramAudioManager.isBluetoothScoAvailableOffCall()));
    return true;
  }
  
  public static void b(float paramFloat)
  {
    HashMap localHashMap = new HashMap();
    if ((paramFloat >= 0.0F) && (paramFloat < 24.0F)) {
      localHashMap.put("errorCode", String.valueOf(0));
    }
    for (;;)
    {
      localHashMap.put("hour", String.valueOf(paramFloat));
      azmz.a(BaseApplication.getContext()).a(null, "pttPlayFileNotFind", true, 0L, 0L, localHashMap, "");
      return;
      if ((paramFloat >= 24.0F) && (paramFloat < 168.0F)) {
        localHashMap.put("errorCode", String.valueOf(1));
      } else if ((paramFloat >= 168.0F) && (paramFloat < 360.0F)) {
        localHashMap.put("errorCode", String.valueOf(2));
      } else if (paramFloat > 360.0F) {
        localHashMap.put("errorCode", String.valueOf(3));
      }
    }
  }
  
  private void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer", 2, "tryStartBlueToothSco " + paramString);
    }
    g();
    paramString = new aeld(this, paramString, paramInt);
    this.jdField_a_of_type_AndroidAppApplication.registerReceiver(paramString, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = paramString;
    this.jdField_a_of_type_AndroidMediaAudioManager.startBluetoothSco();
  }
  
  /* Error */
  private boolean b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: iconst_1
    //   3: istore 7
    //   5: iconst_1
    //   6: istore 9
    //   8: aload_0
    //   9: monitorenter
    //   10: iload_2
    //   11: istore 6
    //   13: iload_2
    //   14: ifge +6 -> 20
    //   17: iconst_0
    //   18: istore 6
    //   20: invokestatic 286	java/lang/System:currentTimeMillis	()J
    //   23: lstore 10
    //   25: aload_0
    //   26: aload_1
    //   27: putfield 288	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: aload_0
    //   31: invokestatic 294	com/tencent/mobileqq/app/ThreadManager:remove	(Ljava/lang/Runnable;)Z
    //   34: pop
    //   35: getstatic 39	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_d_of_type_Int	I
    //   38: iconst_m1
    //   39: if_icmpne +19 -> 58
    //   42: aload_0
    //   43: aload_1
    //   44: iload 6
    //   46: invokevirtual 296	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Ljava/lang/String;I)V
    //   49: iload 9
    //   51: istore 8
    //   53: aload_0
    //   54: monitorexit
    //   55: iload 8
    //   57: ireturn
    //   58: aload_0
    //   59: getfield 98	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   62: invokestatic 298	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Landroid/media/AudioManager;)Z
    //   65: ifeq +22 -> 87
    //   68: aload_0
    //   69: aload_1
    //   70: iload 6
    //   72: invokespecial 300	com/tencent/mobileqq/activity/aio/AudioPlayer:b	(Ljava/lang/String;I)V
    //   75: iload 9
    //   77: istore 8
    //   79: goto -26 -> 53
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    //   87: aload_1
    //   88: invokestatic 305	bdcs:b	(Ljava/lang/String;)Z
    //   91: ifne +98 -> 189
    //   94: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +29 -> 126
    //   100: ldc 239
    //   102: iconst_2
    //   103: new 241	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 307
    //   113: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload_0
    //   127: invokevirtual 309	com/tencent/mobileqq/activity/aio/AudioPlayer:c	()V
    //   130: aload_0
    //   131: getfield 100	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Aelc	Laelc;
    //   134: ifnull +49 -> 183
    //   137: aload_0
    //   138: getfield 100	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Aelc	Laelc;
    //   141: aload_0
    //   142: iconst_m1
    //   143: invokeinterface 313 3 0
    //   148: aload_0
    //   149: iconst_0
    //   150: iconst_1
    //   151: iconst_1
    //   152: ldc_w 315
    //   155: invokespecial 317	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(IIILjava/lang/String;)V
    //   158: aload_0
    //   159: getfield 71	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Long	J
    //   162: lconst_0
    //   163: lcmp
    //   164: ifle +19 -> 183
    //   167: invokestatic 322	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   170: aload_0
    //   171: getfield 71	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Long	J
    //   174: lsub
    //   175: l2f
    //   176: ldc_w 323
    //   179: fdiv
    //   180: invokestatic 325	com/tencent/mobileqq/activity/aio/AudioPlayer:b	(F)V
    //   183: iconst_0
    //   184: istore 8
    //   186: goto -133 -> 53
    //   189: aload_0
    //   190: invokespecial 327	com/tencent/mobileqq/activity/aio/AudioPlayer:f	()V
    //   193: new 329	java/io/FileInputStream
    //   196: dup
    //   197: aload_1
    //   198: invokespecial 330	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   201: astore 13
    //   203: aload 13
    //   205: astore 12
    //   207: aload 13
    //   209: invokestatic 335	bdic:a	(Ljava/io/InputStream;)B
    //   212: istore 4
    //   214: aload 13
    //   216: astore 12
    //   218: iload 4
    //   220: istore_3
    //   221: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +47 -> 271
    //   227: aload 13
    //   229: astore 12
    //   231: iload 4
    //   233: istore_3
    //   234: ldc 239
    //   236: iconst_2
    //   237: new 241	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   244: ldc_w 337
    //   247: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   250: aload_1
    //   251: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: ldc_w 339
    //   257: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: iload 4
    //   262: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   265: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   271: iload 4
    //   273: istore 5
    //   275: aload 13
    //   277: ifnull +12 -> 289
    //   280: aload 13
    //   282: invokevirtual 347	java/io/InputStream:close	()V
    //   285: iload 4
    //   287: istore 5
    //   289: iload 5
    //   291: iflt +283 -> 574
    //   294: aload_0
    //   295: new 349	com/tencent/mobileqq/ptt/player/SilkPlayer
    //   298: dup
    //   299: invokespecial 350	com/tencent/mobileqq/ptt/player/SilkPlayer:<init>	()V
    //   302: putfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   305: iconst_1
    //   306: istore_2
    //   307: iload_2
    //   308: invokestatic 354	bdew:a	(I)V
    //   311: aload_0
    //   312: getfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   315: aload_1
    //   316: invokeinterface 358 2 0
    //   321: aload_0
    //   322: getfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   325: iload 6
    //   327: invokeinterface 360 2 0
    //   332: aload_0
    //   333: getfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   336: iconst_m1
    //   337: iload 5
    //   339: invokeinterface 363 3 0
    //   344: aload_0
    //   345: getfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   348: aload_0
    //   349: invokeinterface 366 2 0
    //   354: aload_0
    //   355: getfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   358: aload_0
    //   359: getfield 67	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Float	F
    //   362: invokeinterface 368 2 0
    //   367: aload_0
    //   368: getfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   371: invokeinterface 370 1 0
    //   376: iload 9
    //   378: istore 8
    //   380: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq -330 -> 53
    //   386: ldc_w 372
    //   389: iconst_2
    //   390: new 241	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 374
    //   400: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: invokestatic 286	java/lang/System:currentTimeMillis	()J
    //   406: lload 10
    //   408: lsub
    //   409: invokevirtual 377	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   412: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: iload 9
    //   420: istore 8
    //   422: goto -369 -> 53
    //   425: astore 14
    //   427: aconst_null
    //   428: astore 13
    //   430: aload 13
    //   432: astore 12
    //   434: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq +37 -> 474
    //   440: aload 13
    //   442: astore 12
    //   444: ldc 239
    //   446: iconst_2
    //   447: new 241	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   454: ldc_w 379
    //   457: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload 14
    //   462: invokevirtual 382	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   465: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 255	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   474: iload_3
    //   475: istore 5
    //   477: aload 13
    //   479: ifnull -190 -> 289
    //   482: aload 13
    //   484: invokevirtual 347	java/io/InputStream:close	()V
    //   487: iload_3
    //   488: istore 5
    //   490: goto -201 -> 289
    //   493: astore 12
    //   495: iload_3
    //   496: istore 5
    //   498: goto -209 -> 289
    //   501: astore_1
    //   502: aconst_null
    //   503: astore 12
    //   505: aload 12
    //   507: ifnull +8 -> 515
    //   510: aload 12
    //   512: invokevirtual 347	java/io/InputStream:close	()V
    //   515: aload_1
    //   516: athrow
    //   517: astore_1
    //   518: invokestatic 237	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq +13 -> 534
    //   524: ldc 239
    //   526: iconst_2
    //   527: ldc_w 384
    //   530: aload_1
    //   531: invokestatic 387	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   534: aload_0
    //   535: getfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   538: instanceof 349
    //   541: ifeq +82 -> 623
    //   544: iload 7
    //   546: istore_2
    //   547: aload_0
    //   548: iconst_0
    //   549: iload_2
    //   550: iconst_2
    //   551: aload_1
    //   552: invokevirtual 388	java/lang/Exception:toString	()Ljava/lang/String;
    //   555: invokespecial 317	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(IIILjava/lang/String;)V
    //   558: aload_0
    //   559: aload_0
    //   560: getfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   563: iconst_0
    //   564: iconst_0
    //   565: invokevirtual 391	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Lawtt;II)V
    //   568: iconst_0
    //   569: istore 8
    //   571: goto -518 -> 53
    //   574: aload_0
    //   575: new 393	com/tencent/mobileqq/ptt/player/AmrPlayer
    //   578: dup
    //   579: invokespecial 394	com/tencent/mobileqq/ptt/player/AmrPlayer:<init>	()V
    //   582: putfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   585: ldc 239
    //   587: iconst_1
    //   588: new 241	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 242	java/lang/StringBuilder:<init>	()V
    //   595: ldc_w 396
    //   598: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: iload 5
    //   603: invokevirtual 342	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   606: ldc_w 398
    //   609: invokevirtual 248	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: invokevirtual 252	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 400	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   618: iconst_2
    //   619: istore_2
    //   620: goto -313 -> 307
    //   623: iconst_0
    //   624: istore_2
    //   625: goto -78 -> 547
    //   628: astore 12
    //   630: iload 4
    //   632: istore 5
    //   634: goto -345 -> 289
    //   637: astore 12
    //   639: goto -124 -> 515
    //   642: astore_1
    //   643: goto -138 -> 505
    //   646: astore 14
    //   648: goto -218 -> 430
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	651	0	this	AudioPlayer
    //   0	651	1	paramString	String
    //   0	651	2	paramInt	int
    //   1	495	3	b1	byte
    //   212	419	4	b2	byte
    //   273	360	5	b3	byte
    //   11	315	6	i	int
    //   3	542	7	j	int
    //   51	519	8	bool1	boolean
    //   6	413	9	bool2	boolean
    //   23	384	10	l	long
    //   205	238	12	localFileInputStream1	java.io.FileInputStream
    //   493	1	12	localException1	Exception
    //   503	8	12	localObject	Object
    //   628	1	12	localException2	Exception
    //   637	1	12	localException3	Exception
    //   201	282	13	localFileInputStream2	java.io.FileInputStream
    //   425	36	14	localException4	Exception
    //   646	1	14	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   20	49	82	finally
    //   58	75	82	finally
    //   87	126	82	finally
    //   126	183	82	finally
    //   189	193	82	finally
    //   280	285	82	finally
    //   294	305	82	finally
    //   307	376	82	finally
    //   380	418	82	finally
    //   482	487	82	finally
    //   510	515	82	finally
    //   515	517	82	finally
    //   518	534	82	finally
    //   534	544	82	finally
    //   547	568	82	finally
    //   574	618	82	finally
    //   193	203	425	java/lang/Exception
    //   482	487	493	java/lang/Exception
    //   193	203	501	finally
    //   189	193	517	java/lang/Exception
    //   294	305	517	java/lang/Exception
    //   307	376	517	java/lang/Exception
    //   515	517	517	java/lang/Exception
    //   574	618	517	java/lang/Exception
    //   280	285	628	java/lang/Exception
    //   510	515	637	java/lang/Exception
    //   207	214	642	finally
    //   221	227	642	finally
    //   234	271	642	finally
    //   434	440	642	finally
    //   444	474	642	finally
    //   207	214	646	java/lang/Exception
    //   221	227	646	java/lang/Exception
    //   234	271	646	java/lang/Exception
  }
  
  private void c(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      b(this.jdField_a_of_type_JavaLangString, paramInt);
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_Awtt instanceof AmrPlayer))
    {
      h();
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
      this.jdField_a_of_type_JavaUtilTimer.schedule(new AudioPlayer.2(this), 0L, 100L);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Awtt != null)
    {
      if (this.jdField_a_of_type_Awtt.a()) {
        this.jdField_a_of_type_Awtt.c();
      }
      this.jdField_a_of_type_Awtt.d();
      this.jdField_a_of_type_Awtt.e();
      this.jdField_a_of_type_Awtt = null;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer", 2, "unregister sco receiver:  " + SystemClock.uptimeMillis());
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label52:
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Awtt == null) {
      return 0;
    }
    return this.jdField_a_of_type_Awtt.b();
  }
  
  public awtt a()
  {
    return this.jdField_a_of_type_Awtt;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    g();
    c();
    if (this.jdField_a_of_type_Aelc != null) {
      this.jdField_a_of_type_Aelc.a(this);
    }
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    if (QLog.isColorLevel()) {
      QLog.i("AudioPlayer", 2, "setPlaySpeed: " + paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Aelc != null) {}
    try
    {
      this.jdField_a_of_type_Aelc.d(this, b());
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AudioPlayer", 2, "startProgressTimer e= " + localException);
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(awtt paramawtt, int paramInt1, int paramInt2)
  {
    g();
    c();
    if (this.jdField_a_of_type_Aelc != null) {
      this.jdField_a_of_type_Aelc.a(this, -2);
    }
  }
  
  @TargetApi(14)
  public void a(String paramString, int paramInt)
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null)
    {
      jdField_d_of_type_Int = 0;
      b(paramString, paramInt);
      return;
    }
    if (!localBluetoothAdapter.isEnabled())
    {
      jdField_d_of_type_Int = 0;
      b(paramString, paramInt);
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(1) != 2)
    {
      jdField_d_of_type_Int = 0;
      b(paramString, paramInt);
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(2) == 2)
    {
      jdField_d_of_type_Int = 0;
      b(paramString, paramInt);
      return;
    }
    paramString = new aelb(this, paramString, paramInt, localBluetoothAdapter);
    localBluetoothAdapter.getProfileProxy(BaseApplication.getContext(), paramString, 1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (a()) {
      c(this.jdField_a_of_type_Awtt.a() - MediaPlayerManager.jdField_a_of_type_Int);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Awtt != null) && (this.jdField_a_of_type_Awtt.a());
  }
  
  public boolean a(String paramString)
  {
    return b(paramString, 0);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return b(paramString, paramInt);
  }
  
  public boolean a(boolean paramBoolean)
  {
    return a(paramBoolean, false, 0);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!this.jdField_c_of_type_Boolean) && (!this.jdField_d_of_type_Boolean) && ((paramBoolean1 != this.e) || (paramBoolean2)))
    {
      this.e = paramBoolean1;
      athg.a().a(paramBoolean1);
      if (a()) {
        c(paramInt);
      }
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Awtt == null) {
      return 0;
    }
    return this.jdField_a_of_type_Awtt.a();
  }
  
  public void b()
  {
    i = 1;
    this.g = this.jdField_a_of_type_AndroidMediaAudioManager.isSpeakerphoneOn();
    this.jdField_a_of_type_Bday = a();
    this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.jdField_a_of_type_Bday.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(this.jdField_a_of_type_Bday.jdField_a_of_type_Boolean);
    if (this.jdField_b_of_type_Int != jdField_a_of_type_Int) {
      this.jdField_a_of_type_Bday.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    }
    if (this.jdField_a_of_type_Aelc != null) {
      this.jdField_a_of_type_Aelc.b(this, this.jdField_a_of_type_Bday.jdField_b_of_type_Int);
    }
    bdaz.a(this.jdField_a_of_type_AndroidAppApplication, true);
    if (this.jdField_a_of_type_Awtt != null) {
      this.jdField_a_of_type_Awtt.a(this.jdField_a_of_type_Bday.jdField_b_of_type_Int);
    }
    try
    {
      this.jdField_a_of_type_Awtt.g();
      i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(this.jdField_a_of_type_Bday.jdField_b_of_type_Int);
      int j = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(this.jdField_a_of_type_Bday.jdField_b_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer", 2, "currentVolume=" + i + " maxVolume=" + j);
      }
      if (i / j >= 0.18F) {
        break label317;
      }
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 200L);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        if ((this.jdField_a_of_type_Awtt instanceof SilkPlayer)) {}
        for (;;)
        {
          a(0, i, 3, localThrowable.toString());
          return;
          i = 0;
        }
        this.jdField_c_of_type_Int = 1;
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
        continue;
        i = 0;
      }
    }
    if (this.jdField_a_of_type_Aelc != null) {
      this.jdField_a_of_type_Aelc.c(this, this.jdField_c_of_type_Int);
    }
    if ((this.jdField_a_of_type_Awtt instanceof SilkPlayer))
    {
      i = 1;
      a(1, i, 0, "");
      e();
      return;
    }
  }
  
  public void b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (a()) {
      c(this.jdField_a_of_type_Awtt.a() - MediaPlayerManager.jdField_a_of_type_Int);
    }
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 78	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   6: sipush 1000
    //   9: invokevirtual 543	android/os/Handler:removeMessages	(I)V
    //   12: aload_0
    //   13: invokespecial 404	com/tencent/mobileqq/activity/aio/AudioPlayer:h	()V
    //   16: aload_0
    //   17: getfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   20: ifnull +84 -> 104
    //   23: aload_0
    //   24: getfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   27: invokeinterface 420 1 0
    //   32: ifeq +12 -> 44
    //   35: aload_0
    //   36: getfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   39: invokeinterface 421 1 0
    //   44: aload_0
    //   45: getfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   48: invokeinterface 423 1 0
    //   53: aload_0
    //   54: getfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   57: invokeinterface 425 1 0
    //   62: aload_0
    //   63: getstatic 66	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_a_of_type_Float	F
    //   66: putfield 67	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Float	F
    //   69: aload_0
    //   70: ldc2_w 68
    //   73: putfield 71	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Long	J
    //   76: aload_0
    //   77: aconst_null
    //   78: putfield 288	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   81: aload_0
    //   82: aconst_null
    //   83: putfield 111	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Awtt	Lawtt;
    //   86: aload_0
    //   87: getstatic 37	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Int	I
    //   90: putfield 62	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_b_of_type_Int	I
    //   93: aload_0
    //   94: bipush 8
    //   96: aconst_null
    //   97: iconst_0
    //   98: invokestatic 547	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   101: aload_0
    //   102: monitorexit
    //   103: return
    //   104: invokestatic 483	athg:a	()Lathg;
    //   107: invokevirtual 548	athg:a	()Z
    //   110: ifeq -9 -> 101
    //   113: aload_0
    //   114: getstatic 37	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Int	I
    //   117: putfield 62	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_b_of_type_Int	I
    //   120: aload_0
    //   121: bipush 8
    //   123: aconst_null
    //   124: iconst_0
    //   125: invokestatic 547	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   128: goto -27 -> 101
    //   131: astore_1
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	AudioPlayer
    //   131	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	44	131	finally
    //   44	101	131	finally
    //   104	128	131	finally
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      jdField_d_of_type_Int = i;
      f = false;
      return;
    }
  }
  
  public void d()
  {
    if ((jdField_b_of_type_Boolean) && (this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()))
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setBluetoothScoOn(false);
      this.jdField_a_of_type_AndroidMediaAudioManager.stopBluetoothSco();
      jdField_b_of_type_Boolean = false;
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = -1;; i = 0)
    {
      jdField_d_of_type_Int = i;
      f = false;
      return;
    }
  }
  
  public void run()
  {
    try
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.setMode(0);
      this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(this.g);
      bdaz.a(this.jdField_a_of_type_AndroidAppApplication, false);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AudioPlayer", 2, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioPlayer
 * JD-Core Version:    0.7.0.1
 */