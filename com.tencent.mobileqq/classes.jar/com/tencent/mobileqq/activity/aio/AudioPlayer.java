package com.tencent.mobileqq.activity.aio;

import agfp;
import agfq;
import agfs;
import android.annotation.TargetApi;
import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.SystemClock;
import awli;
import bamh;
import bdmc;
import bhkl;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class AudioPlayer
  extends AudioPlayerBase
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  bhkl[] jdField_a_of_type_ArrayOfBhkl;
  private boolean e;
  private boolean f;
  private boolean g = true;
  
  public AudioPlayer(Context paramContext, agfs paramagfs)
  {
    super(paramContext, paramagfs);
  }
  
  public static void a(float paramFloat)
  {
    HashMap localHashMap = new HashMap();
    if ((paramFloat >= 0.0F) && (paramFloat < 24.0F)) {
      localHashMap.put("errorCode", String.valueOf(0));
    }
    for (;;)
    {
      localHashMap.put("hour", String.valueOf(paramFloat));
      bdmc.a(BaseApplication.getContext()).a(null, "pttPlayFileNotFind", true, 0L, 0L, localHashMap, "");
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
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("issilk", String.valueOf(paramInt2));
    localHashMap.put("isSuccess", String.valueOf(paramInt1));
    localHashMap.put("errorCode", String.valueOf(paramInt3));
    localHashMap.put("errormsg", paramString);
    bdmc.a(BaseApplication.getContext()).a(null, "pttplaysuc", true, 0L, 0L, localHashMap, "");
  }
  
  private void a(AudioManager paramAudioManager)
  {
    paramAudioManager.setBluetoothScoOn(true);
  }
  
  private void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer_Old", 2, "tryStartBlueToothSco " + paramString);
    }
    l();
    paramString = new agfq(this, paramString, paramInt);
    this.jdField_a_of_type_AndroidAppApplication.registerReceiver(paramString, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = paramString;
    this.jdField_a_of_type_AndroidMediaAudioManager.startBluetoothSco();
  }
  
  private void l()
  {
    if (this.jdField_a_of_type_AndroidContentBroadcastReceiver != null) {
      if (QLog.isColorLevel()) {
        QLog.d("AudioPlayer_Old", 2, "unregister sco receiver:  " + SystemClock.uptimeMillis());
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidAppApplication.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      label51:
      this.jdField_a_of_type_AndroidContentBroadcastReceiver = null;
      return;
    }
    catch (Exception localException)
    {
      break label51;
    }
  }
  
  protected bhkl a()
  {
    if (this.jdField_a_of_type_ArrayOfBhkl == null) {
      this.jdField_a_of_type_ArrayOfBhkl = AudioHelper.a();
    }
    if ((this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()) && (jdField_a_of_type_Boolean)) {
      return this.jdField_a_of_type_ArrayOfBhkl[4];
    }
    if (this.e) {
      return this.jdField_a_of_type_ArrayOfBhkl[2];
    }
    if (this.f) {
      return this.jdField_a_of_type_ArrayOfBhkl[3];
    }
    bhkl[] arrayOfbhkl = this.jdField_a_of_type_ArrayOfBhkl;
    if (this.g) {}
    for (int i = 0;; i = 1) {
      return arrayOfbhkl[i];
    }
  }
  
  public void a()
  {
    l();
    super.a();
  }
  
  public void a(bamh parambamh, int paramInt1, int paramInt2)
  {
    l();
    super.a(parambamh, paramInt1, paramInt2);
  }
  
  @TargetApi(14)
  public void a(String paramString, int paramInt)
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null)
    {
      b = 0;
      a(paramString, paramInt);
      return;
    }
    if (!localBluetoothAdapter.isEnabled())
    {
      b = 0;
      a(paramString, paramInt);
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(1) != 2)
    {
      b = 0;
      a(paramString, paramInt);
      return;
    }
    if (localBluetoothAdapter.getProfileConnectionState(2) == 2)
    {
      b = 0;
      a(paramString, paramInt);
      return;
    }
    paramString = new agfp(this, paramString, paramInt, localBluetoothAdapter);
    localBluetoothAdapter.getProfileProxy(BaseApplication.getContext(), paramString, 1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (a()) {
      c(this.jdField_a_of_type_Bamh.a() - MediaPlayerManager.a);
    }
  }
  
  /* Error */
  public boolean a(String paramString, int paramInt)
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
    //   20: invokestatic 236	java/lang/System:currentTimeMillis	()J
    //   23: lstore 10
    //   25: aload_0
    //   26: aload_1
    //   27: putfield 239	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   30: aload_0
    //   31: invokestatic 245	com/tencent/mobileqq/app/ThreadManager:remove	(Ljava/lang/Runnable;)Z
    //   34: pop
    //   35: getstatic 193	com/tencent/mobileqq/activity/aio/AudioPlayer:b	I
    //   38: iconst_m1
    //   39: if_icmpne +19 -> 58
    //   42: aload_0
    //   43: aload_1
    //   44: iload 6
    //   46: invokevirtual 247	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Ljava/lang/String;I)V
    //   49: iload 9
    //   51: istore 8
    //   53: aload_0
    //   54: monitorexit
    //   55: iload 8
    //   57: ireturn
    //   58: aload_0
    //   59: getfield 141	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   62: invokestatic 250	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Landroid/media/AudioManager;)Z
    //   65: ifeq +22 -> 87
    //   68: aload_0
    //   69: aload_1
    //   70: iload 6
    //   72: invokespecial 252	com/tencent/mobileqq/activity/aio/AudioPlayer:b	(Ljava/lang/String;I)V
    //   75: iload 9
    //   77: istore 8
    //   79: goto -26 -> 53
    //   82: astore_1
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    //   87: aload_1
    //   88: invokestatic 257	bhmi:b	(Ljava/lang/String;)Z
    //   91: ifne +97 -> 188
    //   94: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq +29 -> 126
    //   100: ldc 95
    //   102: iconst_2
    //   103: new 97	java/lang/StringBuilder
    //   106: dup
    //   107: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   110: ldc_w 259
    //   113: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_1
    //   117: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   123: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   126: aload_0
    //   127: invokevirtual 261	com/tencent/mobileqq/activity/aio/AudioPlayer:c	()V
    //   130: aload_0
    //   131: getfield 264	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Agfs	Lagfs;
    //   134: ifnull +48 -> 182
    //   137: aload_0
    //   138: getfield 264	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Agfs	Lagfs;
    //   141: aload_0
    //   142: iconst_m1
    //   143: invokeinterface 269 3 0
    //   148: iconst_0
    //   149: iconst_1
    //   150: iconst_1
    //   151: ldc_w 271
    //   154: invokestatic 273	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(IIILjava/lang/String;)V
    //   157: aload_0
    //   158: getfield 276	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Long	J
    //   161: lconst_0
    //   162: lcmp
    //   163: ifle +19 -> 182
    //   166: invokestatic 281	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   169: aload_0
    //   170: getfield 276	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Long	J
    //   173: lsub
    //   174: l2f
    //   175: ldc_w 282
    //   178: fdiv
    //   179: invokestatic 284	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(F)V
    //   182: iconst_0
    //   183: istore 8
    //   185: goto -132 -> 53
    //   188: aload_0
    //   189: invokevirtual 286	com/tencent/mobileqq/activity/aio/AudioPlayer:g	()V
    //   192: new 288	java/io/FileInputStream
    //   195: dup
    //   196: aload_1
    //   197: invokespecial 289	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   200: astore 13
    //   202: aload 13
    //   204: astore 12
    //   206: aload 13
    //   208: invokestatic 294	bhrp:a	(Ljava/io/InputStream;)B
    //   211: istore 4
    //   213: aload 13
    //   215: astore 12
    //   217: iload 4
    //   219: istore_3
    //   220: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   223: ifeq +47 -> 270
    //   226: aload 13
    //   228: astore 12
    //   230: iload 4
    //   232: istore_3
    //   233: ldc 95
    //   235: iconst_2
    //   236: new 97	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 296
    //   246: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload_1
    //   250: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: ldc_w 298
    //   256: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: iload 4
    //   261: invokevirtual 301	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: iload 4
    //   272: istore 5
    //   274: aload 13
    //   276: ifnull +12 -> 288
    //   279: aload 13
    //   281: invokevirtual 306	java/io/InputStream:close	()V
    //   284: iload 4
    //   286: istore 5
    //   288: iload 5
    //   290: iflt +282 -> 572
    //   293: aload_0
    //   294: new 308	com/tencent/mobileqq/ptt/player/SilkPlayer
    //   297: dup
    //   298: invokespecial 309	com/tencent/mobileqq/ptt/player/SilkPlayer:<init>	()V
    //   301: putfield 218	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Bamh	Lbamh;
    //   304: iconst_1
    //   305: istore_2
    //   306: iload_2
    //   307: invokestatic 313	bhoi:a	(I)V
    //   310: aload_0
    //   311: getfield 218	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Bamh	Lbamh;
    //   314: aload_1
    //   315: invokeinterface 315 2 0
    //   320: aload_0
    //   321: getfield 218	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Bamh	Lbamh;
    //   324: iload 6
    //   326: invokeinterface 317 2 0
    //   331: aload_0
    //   332: getfield 218	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Bamh	Lbamh;
    //   335: iconst_m1
    //   336: iload 5
    //   338: invokeinterface 320 3 0
    //   343: aload_0
    //   344: getfield 218	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Bamh	Lbamh;
    //   347: aload_0
    //   348: invokeinterface 323 2 0
    //   353: aload_0
    //   354: getfield 218	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Bamh	Lbamh;
    //   357: aload_0
    //   358: getfield 326	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Float	F
    //   361: invokeinterface 327 2 0
    //   366: aload_0
    //   367: getfield 218	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Bamh	Lbamh;
    //   370: invokeinterface 328 1 0
    //   375: iload 9
    //   377: istore 8
    //   379: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   382: ifeq -329 -> 53
    //   385: ldc_w 330
    //   388: iconst_2
    //   389: new 97	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   396: ldc_w 332
    //   399: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokestatic 236	java/lang/System:currentTimeMillis	()J
    //   405: lload 10
    //   407: lsub
    //   408: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   411: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: iload 9
    //   419: istore 8
    //   421: goto -368 -> 53
    //   424: astore 14
    //   426: aconst_null
    //   427: astore 13
    //   429: aload 13
    //   431: astore 12
    //   433: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   436: ifeq +37 -> 473
    //   439: aload 13
    //   441: astore 12
    //   443: ldc 95
    //   445: iconst_2
    //   446: new 97	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   453: ldc_w 334
    //   456: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload 14
    //   461: invokevirtual 337	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   464: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   470: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   473: iload_3
    //   474: istore 5
    //   476: aload 13
    //   478: ifnull -190 -> 288
    //   481: aload 13
    //   483: invokevirtual 306	java/io/InputStream:close	()V
    //   486: iload_3
    //   487: istore 5
    //   489: goto -201 -> 288
    //   492: astore 12
    //   494: iload_3
    //   495: istore 5
    //   497: goto -209 -> 288
    //   500: astore_1
    //   501: aconst_null
    //   502: astore 12
    //   504: aload 12
    //   506: ifnull +8 -> 514
    //   509: aload 12
    //   511: invokevirtual 306	java/io/InputStream:close	()V
    //   514: aload_1
    //   515: athrow
    //   516: astore_1
    //   517: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq +13 -> 533
    //   523: ldc 95
    //   525: iconst_2
    //   526: ldc_w 339
    //   529: aload_1
    //   530: invokestatic 342	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   533: aload_0
    //   534: getfield 218	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Bamh	Lbamh;
    //   537: instanceof 308
    //   540: ifeq +81 -> 621
    //   543: iload 7
    //   545: istore_2
    //   546: iconst_0
    //   547: iload_2
    //   548: iconst_2
    //   549: aload_1
    //   550: invokevirtual 343	java/lang/Exception:toString	()Ljava/lang/String;
    //   553: invokestatic 273	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(IIILjava/lang/String;)V
    //   556: aload_0
    //   557: aload_0
    //   558: getfield 218	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Bamh	Lbamh;
    //   561: iconst_0
    //   562: iconst_0
    //   563: invokevirtual 344	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Lbamh;II)V
    //   566: iconst_0
    //   567: istore 8
    //   569: goto -516 -> 53
    //   572: aload_0
    //   573: new 346	com/tencent/mobileqq/ptt/player/AmrPlayer
    //   576: dup
    //   577: invokespecial 347	com/tencent/mobileqq/ptt/player/AmrPlayer:<init>	()V
    //   580: putfield 218	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_Bamh	Lbamh;
    //   583: ldc 95
    //   585: iconst_1
    //   586: new 97	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   593: ldc_w 349
    //   596: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: iload 5
    //   601: invokevirtual 301	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   604: ldc_w 351
    //   607: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 353	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: iconst_2
    //   617: istore_2
    //   618: goto -312 -> 306
    //   621: iconst_0
    //   622: istore_2
    //   623: goto -77 -> 546
    //   626: astore 12
    //   628: iload 4
    //   630: istore 5
    //   632: goto -344 -> 288
    //   635: astore 12
    //   637: goto -123 -> 514
    //   640: astore_1
    //   641: goto -137 -> 504
    //   644: astore 14
    //   646: goto -217 -> 429
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	649	0	this	AudioPlayer
    //   0	649	1	paramString	String
    //   0	649	2	paramInt	int
    //   1	494	3	b1	byte
    //   211	418	4	b2	byte
    //   272	359	5	b3	byte
    //   11	314	6	i	int
    //   3	541	7	j	int
    //   51	517	8	bool1	boolean
    //   6	412	9	bool2	boolean
    //   23	383	10	l	long
    //   204	238	12	localFileInputStream1	java.io.FileInputStream
    //   492	1	12	localException1	Exception
    //   502	8	12	localObject	java.lang.Object
    //   626	1	12	localException2	Exception
    //   635	1	12	localException3	Exception
    //   200	282	13	localFileInputStream2	java.io.FileInputStream
    //   424	36	14	localException4	Exception
    //   644	1	14	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   20	49	82	finally
    //   58	75	82	finally
    //   87	126	82	finally
    //   126	182	82	finally
    //   188	192	82	finally
    //   279	284	82	finally
    //   293	304	82	finally
    //   306	375	82	finally
    //   379	417	82	finally
    //   481	486	82	finally
    //   509	514	82	finally
    //   514	516	82	finally
    //   517	533	82	finally
    //   533	543	82	finally
    //   546	566	82	finally
    //   572	616	82	finally
    //   192	202	424	java/lang/Exception
    //   481	486	492	java/lang/Exception
    //   192	202	500	finally
    //   188	192	516	java/lang/Exception
    //   293	304	516	java/lang/Exception
    //   306	375	516	java/lang/Exception
    //   514	516	516	java/lang/Exception
    //   572	616	516	java/lang/Exception
    //   279	284	626	java/lang/Exception
    //   509	514	635	java/lang/Exception
    //   206	213	640	finally
    //   220	226	640	finally
    //   233	270	640	finally
    //   433	439	640	finally
    //   443	473	640	finally
    //   206	213	644	java/lang/Exception
    //   220	226	644	java/lang/Exception
    //   233	270	644	java/lang/Exception
  }
  
  public boolean a(boolean paramBoolean)
  {
    return a(paramBoolean, false, 0);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((!this.e) && (!this.f) && ((paramBoolean1 != this.g) || (paramBoolean2)))
    {
      this.g = paramBoolean1;
      awli.a().a(paramBoolean1);
      if (a()) {
        c(paramInt);
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    if ((this.f) && (!this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothA2dpOn())) {
      this.f = false;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (a()) {
      c(this.jdField_a_of_type_Bamh.a() - MediaPlayerManager.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioPlayer
 * JD-Core Version:    0.7.0.1
 */