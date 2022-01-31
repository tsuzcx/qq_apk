package com.tencent.mobileqq.activity.aio;

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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ptt.player.IPttPlayer;
import com.tencent.mobileqq.ptt.player.IPttPlayerListener;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.AudioHelper.AudioPlayerParameter;
import com.tencent.mobileqq.utils.AudioUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;
import uon;
import uoo;
import uop;

public class AudioPlayer
  implements IPttPlayerListener, Runnable
{
  public static int a;
  private static final List jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(1796) });
  public static boolean a;
  public static boolean b;
  private static int jdField_d_of_type_Int;
  private static boolean f;
  private Application jdField_a_of_type_AndroidAppApplication;
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new uon(this);
  private AudioPlayer.AudioPlayerListener jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener;
  private IPttPlayer jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer;
  private volatile AudioHelper.AudioPlayerParameter jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
  private String jdField_a_of_type_JavaLangString;
  AudioHelper.AudioPlayerParameter[] jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
  private volatile int b;
  private volatile int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean jdField_d_of_type_Boolean;
  private boolean e = true;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_Int = -999;
    jdField_d_of_type_Int = -1;
  }
  
  public AudioPlayer(Context paramContext, AudioPlayer.AudioPlayerListener paramAudioPlayerListener)
  {
    this.jdField_b_of_type_Int = jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidAppApplication = ((Application)paramContext.getApplicationContext());
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidAppApplication.getSystemService("audio"));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener = paramAudioPlayerListener;
  }
  
  private AudioHelper.AudioPlayerParameter a()
  {
    if (this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter == null) {
      this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = AudioHelper.a();
    }
    if ((this.jdField_a_of_type_AndroidMediaAudioManager.isBluetoothScoOn()) && (jdField_a_of_type_Boolean)) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[4];
    }
    if (this.jdField_c_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[2];
    }
    if (this.jdField_d_of_type_Boolean) {
      return this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter[3];
    }
    AudioHelper.AudioPlayerParameter[] arrayOfAudioPlayerParameter = this.jdField_a_of_type_ArrayOfComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter;
    if (this.e) {}
    for (int i = 0;; i = 1) {
      return arrayOfAudioPlayerParameter[i];
    }
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
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      b(this.jdField_a_of_type_JavaLangString, paramInt);
    }
  }
  
  private void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AudioPlayer", 2, "tryStartBlueToothSco " + paramString);
    }
    f();
    paramString = new uop(this, paramString, paramInt);
    this.jdField_a_of_type_AndroidAppApplication.registerReceiver(paramString, new IntentFilter("android.media.ACTION_SCO_AUDIO_STATE_UPDATED"));
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = paramString;
    this.jdField_a_of_type_AndroidMediaAudioManager.startBluetoothSco();
  }
  
  /* Error */
  private boolean b(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 8
    //   3: iconst_m1
    //   4: istore_3
    //   5: aload_0
    //   6: monitorenter
    //   7: iload_2
    //   8: istore 6
    //   10: iload_2
    //   11: ifge +6 -> 17
    //   14: iconst_0
    //   15: istore 6
    //   17: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   20: lstore 9
    //   22: aload_0
    //   23: aload_1
    //   24: putfield 169	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   27: aload_0
    //   28: invokestatic 230	com/tencent/mobileqq/app/ThreadManager:remove	(Ljava/lang/Runnable;)Z
    //   31: pop
    //   32: getstatic 34	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_d_of_type_Int	I
    //   35: iconst_m1
    //   36: if_icmpne +19 -> 55
    //   39: aload_0
    //   40: aload_1
    //   41: iload 6
    //   43: invokevirtual 232	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Ljava/lang/String;I)V
    //   46: iload 8
    //   48: istore 7
    //   50: aload_0
    //   51: monitorexit
    //   52: iload 7
    //   54: ireturn
    //   55: aload_0
    //   56: getfield 84	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   59: invokestatic 234	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Landroid/media/AudioManager;)Z
    //   62: ifeq +22 -> 84
    //   65: aload_0
    //   66: aload_1
    //   67: iload 6
    //   69: invokespecial 236	com/tencent/mobileqq/activity/aio/AudioPlayer:b	(Ljava/lang/String;I)V
    //   72: iload 8
    //   74: istore 7
    //   76: goto -26 -> 50
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: aload_1
    //   85: invokestatic 241	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)Z
    //   88: ifne +62 -> 150
    //   91: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   94: ifeq +28 -> 122
    //   97: ldc 177
    //   99: iconst_2
    //   100: new 179	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   107: ldc 243
    //   109: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: aload_1
    //   113: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   122: aload_0
    //   123: invokevirtual 245	com/tencent/mobileqq/activity/aio/AudioPlayer:c	()V
    //   126: aload_0
    //   127: getfield 86	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   130: ifnull +14 -> 144
    //   133: aload_0
    //   134: getfield 86	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener	Lcom/tencent/mobileqq/activity/aio/AudioPlayer$AudioPlayerListener;
    //   137: aload_0
    //   138: iconst_m1
    //   139: invokeinterface 249 3 0
    //   144: iconst_0
    //   145: istore 7
    //   147: goto -97 -> 50
    //   150: aload_0
    //   151: invokespecial 251	com/tencent/mobileqq/activity/aio/AudioPlayer:e	()V
    //   154: new 253	java/io/FileInputStream
    //   157: dup
    //   158: aload_1
    //   159: invokespecial 254	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   162: astore 12
    //   164: aload 12
    //   166: astore 11
    //   168: aload 12
    //   170: invokestatic 259	com/tencent/mobileqq/utils/RecordParams:a	(Ljava/io/InputStream;)B
    //   173: istore 4
    //   175: aload 12
    //   177: astore 11
    //   179: iload 4
    //   181: istore_3
    //   182: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   185: ifeq +47 -> 232
    //   188: aload 12
    //   190: astore 11
    //   192: iload 4
    //   194: istore_3
    //   195: ldc 177
    //   197: iconst_2
    //   198: new 179	java/lang/StringBuilder
    //   201: dup
    //   202: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   205: ldc_w 261
    //   208: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload_1
    //   212: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc_w 263
    //   218: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: iload 4
    //   223: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   226: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   229: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   232: iload 4
    //   234: istore 5
    //   236: aload 12
    //   238: ifnull +12 -> 250
    //   241: aload 12
    //   243: invokevirtual 271	java/io/InputStream:close	()V
    //   246: iload 4
    //   248: istore 5
    //   250: iload 5
    //   252: iflt +240 -> 492
    //   255: aload_0
    //   256: new 273	com/tencent/mobileqq/ptt/player/SilkPlayer
    //   259: dup
    //   260: invokespecial 274	com/tencent/mobileqq/ptt/player/SilkPlayer:<init>	()V
    //   263: putfield 97	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   266: aload_0
    //   267: getfield 97	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   270: aload_1
    //   271: invokeinterface 278 2 0
    //   276: aload_0
    //   277: getfield 97	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   280: iload 6
    //   282: invokeinterface 279 2 0
    //   287: aload_0
    //   288: getfield 97	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   291: iconst_m1
    //   292: iload 5
    //   294: invokeinterface 282 3 0
    //   299: aload_0
    //   300: getfield 97	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   303: aload_0
    //   304: invokeinterface 285 2 0
    //   309: aload_0
    //   310: getfield 97	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   313: invokeinterface 287 1 0
    //   318: iload 8
    //   320: istore 7
    //   322: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq -275 -> 50
    //   328: ldc_w 289
    //   331: iconst_2
    //   332: new 179	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   339: ldc_w 291
    //   342: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokestatic 224	java/lang/System:currentTimeMillis	()J
    //   348: lload 9
    //   350: lsub
    //   351: invokevirtual 294	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   354: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   360: iload 8
    //   362: istore 7
    //   364: goto -314 -> 50
    //   367: astore 13
    //   369: aconst_null
    //   370: astore 12
    //   372: aload 12
    //   374: astore 11
    //   376: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq +37 -> 416
    //   382: aload 12
    //   384: astore 11
    //   386: ldc 177
    //   388: iconst_2
    //   389: new 179	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   396: ldc_w 296
    //   399: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload 13
    //   404: invokevirtual 299	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   407: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 193	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   416: iload_3
    //   417: istore 5
    //   419: aload 12
    //   421: ifnull -171 -> 250
    //   424: aload 12
    //   426: invokevirtual 271	java/io/InputStream:close	()V
    //   429: iload_3
    //   430: istore 5
    //   432: goto -182 -> 250
    //   435: astore 11
    //   437: iload_3
    //   438: istore 5
    //   440: goto -190 -> 250
    //   443: astore_1
    //   444: aconst_null
    //   445: astore 11
    //   447: aload 11
    //   449: ifnull +8 -> 457
    //   452: aload 11
    //   454: invokevirtual 271	java/io/InputStream:close	()V
    //   457: aload_1
    //   458: athrow
    //   459: astore_1
    //   460: invokestatic 175	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   463: ifeq +13 -> 476
    //   466: ldc 177
    //   468: iconst_2
    //   469: ldc_w 301
    //   472: aload_1
    //   473: invokestatic 304	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   476: aload_0
    //   477: aload_0
    //   478: getfield 97	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   481: iconst_0
    //   482: iconst_0
    //   483: invokevirtual 307	com/tencent/mobileqq/activity/aio/AudioPlayer:a	(Lcom/tencent/mobileqq/ptt/player/IPttPlayer;II)V
    //   486: iconst_0
    //   487: istore 7
    //   489: goto -439 -> 50
    //   492: aload_0
    //   493: new 309	com/tencent/mobileqq/ptt/player/AmrPlayer
    //   496: dup
    //   497: invokespecial 310	com/tencent/mobileqq/ptt/player/AmrPlayer:<init>	()V
    //   500: putfield 97	com/tencent/mobileqq/activity/aio/AudioPlayer:jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer	Lcom/tencent/mobileqq/ptt/player/IPttPlayer;
    //   503: ldc 177
    //   505: iconst_1
    //   506: new 179	java/lang/StringBuilder
    //   509: dup
    //   510: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   513: ldc_w 312
    //   516: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: iload 5
    //   521: invokevirtual 266	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   524: ldc_w 314
    //   527: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: invokevirtual 190	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 316	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: goto -270 -> 266
    //   539: astore 11
    //   541: iload 4
    //   543: istore 5
    //   545: goto -295 -> 250
    //   548: astore 11
    //   550: goto -93 -> 457
    //   553: astore_1
    //   554: goto -107 -> 447
    //   557: astore 13
    //   559: goto -187 -> 372
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	562	0	this	AudioPlayer
    //   0	562	1	paramString	String
    //   0	562	2	paramInt	int
    //   4	434	3	b1	byte
    //   173	369	4	b2	byte
    //   234	310	5	b3	byte
    //   8	273	6	i	int
    //   48	440	7	bool1	boolean
    //   1	360	8	bool2	boolean
    //   20	329	9	l	long
    //   166	219	11	localFileInputStream1	java.io.FileInputStream
    //   435	1	11	localException1	Exception
    //   445	8	11	localObject	Object
    //   539	1	11	localException2	Exception
    //   548	1	11	localException3	Exception
    //   162	263	12	localFileInputStream2	java.io.FileInputStream
    //   367	36	13	localException4	Exception
    //   557	1	13	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   17	46	79	finally
    //   55	72	79	finally
    //   84	122	79	finally
    //   122	144	79	finally
    //   150	154	79	finally
    //   241	246	79	finally
    //   255	266	79	finally
    //   266	318	79	finally
    //   322	360	79	finally
    //   424	429	79	finally
    //   452	457	79	finally
    //   457	459	79	finally
    //   460	476	79	finally
    //   476	486	79	finally
    //   492	536	79	finally
    //   154	164	367	java/lang/Exception
    //   424	429	435	java/lang/Exception
    //   154	164	443	finally
    //   150	154	459	java/lang/Exception
    //   255	266	459	java/lang/Exception
    //   266	318	459	java/lang/Exception
    //   457	459	459	java/lang/Exception
    //   492	536	459	java/lang/Exception
    //   241	246	539	java/lang/Exception
    //   452	457	548	java/lang/Exception
    //   168	175	553	finally
    //   182	188	553	finally
    //   195	232	553	finally
    //   376	382	553	finally
    //   386	416	553	finally
    //   168	175	557	java/lang/Exception
    //   182	188	557	java/lang/Exception
    //   195	232	557	java/lang/Exception
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a()) {
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.c();
      }
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.d();
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.e();
      this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer = null;
    }
  }
  
  private void f()
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
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer == null) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a();
  }
  
  public IPttPlayer a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer;
  }
  
  public void a()
  {
    f();
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.a(this);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(IPttPlayer paramIPttPlayer, int paramInt1, int paramInt2)
  {
    f();
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.a(this, -2);
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
    paramString = new uoo(this, paramString, paramInt, localBluetoothAdapter);
    localBluetoothAdapter.getProfileProxy(BaseApplication.getContext(), paramString, 1);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (a()) {
      b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a() - MediaPlayerManager.jdField_a_of_type_Int);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a());
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
      if (a()) {
        b(paramInt);
      }
      return true;
    }
    return false;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter = a();
    this.jdField_a_of_type_AndroidMediaAudioManager.setMode(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.jdField_a_of_type_Boolean);
    if (this.jdField_b_of_type_Int != jdField_a_of_type_Int) {
      this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.b(this, this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.jdField_b_of_type_Int);
    }
    AudioUtil.a(this.jdField_a_of_type_AndroidAppApplication, true);
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.jdField_b_of_type_Int);
    this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.g();
    int i = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.jdField_b_of_type_Int);
    int j = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(this.jdField_a_of_type_ComTencentMobileqqUtilsAudioHelper$AudioPlayerParameter.jdField_b_of_type_Int);
    if (i / j < 0.1F)
    {
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(1000, 200L);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer$AudioPlayerListener.c(this, this.jdField_c_of_type_Int);
      }
      return;
      this.jdField_c_of_type_Int = 1;
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    if (a()) {
      b(this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a() - MediaPlayerManager.jdField_a_of_type_Int);
    }
  }
  
  public void c()
  {
    try
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(1000);
      if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer != null)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.a()) {
          this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.c();
        }
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.d();
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer.e();
        this.jdField_a_of_type_JavaLangString = null;
        this.jdField_a_of_type_ComTencentMobileqqPttPlayerIPttPlayer = null;
        this.jdField_b_of_type_Int = jdField_a_of_type_Int;
        ThreadManager.post(this, 8, null, false);
      }
      return;
    }
    finally {}
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
    this.jdField_a_of_type_AndroidMediaAudioManager.setMode(0);
    this.jdField_a_of_type_AndroidMediaAudioManager.setSpeakerphoneOn(false);
    AudioUtil.a(this.jdField_a_of_type_AndroidAppApplication, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AudioPlayer
 * JD-Core Version:    0.7.0.1
 */