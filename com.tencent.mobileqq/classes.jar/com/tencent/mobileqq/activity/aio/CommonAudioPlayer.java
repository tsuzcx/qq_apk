package com.tencent.mobileqq.activity.aio;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerBase.AudioPlayerListener;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerHelper;
import com.tencent.mobileqq.qqaudio.audioplayer.AudioPlayerHelper.AudioPlayerParameter;
import com.tencent.mobileqq.qqaudio.audioplayer.IAudioFilePlayer;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;

public class CommonAudioPlayer
  extends AudioPlayerBase
  implements AudioDeviceManager.IAudioDeviceListener
{
  private AudioBluetoothSCOHelper jdField_a_of_type_ComTencentMobileqqActivityAioAudioBluetoothSCOHelper;
  private AudioDeviceStatus jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus;
  private CommonAudioPlayer.UIAudioDeivceChangedListern jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer$UIAudioDeivceChangedListern;
  volatile boolean jdField_a_of_type_Boolean = false;
  private String b;
  
  public CommonAudioPlayer(Context paramContext, AudioPlayerBase.AudioPlayerListener paramAudioPlayerListener)
  {
    super(paramContext, paramAudioPlayerListener);
  }
  
  private void a(AudioDeviceStatus.AudioDeviceStatusResult paramAudioDeviceStatusResult)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    if (paramAudioDeviceStatusResult == null) {}
    Object localObject;
    do
    {
      return;
      localObject = "CommonAudioPlayer.notifyUIDeviceStatusChanged getDeviceStatusType = " + paramAudioDeviceStatusResult.a();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus.a((String)localObject);
      switch (paramAudioDeviceStatusResult.a())
      {
      default: 
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer$UIAudioDeivceChangedListern == null);
    bool1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus.a();
    boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus.d();
    if (bool3) {
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer$UIAudioDeivceChangedListern.a(bool3, bool1);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer$UIAudioDeivceChangedListern == null) {
        break;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer$UIAudioDeivceChangedListern;
      bool2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus.b();
      bool3 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus.c();
      boolean bool4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus.a();
      if (paramAudioDeviceStatusResult.a() == 2) {
        bool1 = true;
      }
      ((CommonAudioPlayer.UIAudioDeivceChangedListern)localObject).a(bool2, bool3, bool4, bool1);
      return;
    }
  }
  
  private void m()
  {
    String str = this.b;
    if (StringUtil.a(str)) {
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setPackage(this.jdField_a_of_type_AndroidAppApplication.getPackageName());
    localIntent.setAction("mqq.audiosenormanager.audio.start");
    localIntent.putExtra("audiosenormanager.playkey", str);
    this.jdField_a_of_type_AndroidAppApplication.getApplicationContext().sendBroadcast(localIntent);
  }
  
  private void n()
  {
    String str = this.b;
    if (StringUtil.a(str)) {
      return;
    }
    this.b = null;
    Intent localIntent = new Intent();
    localIntent.setPackage(this.jdField_a_of_type_AndroidAppApplication.getPackageName());
    localIntent.setAction("mqq.audiosenormanager.audio.end");
    localIntent.putExtra("audiosenormanager.playkey", str);
    this.jdField_a_of_type_AndroidAppApplication.getApplicationContext().sendBroadcast(localIntent);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus.a();
  }
  
  public AudioPlayerHelper.AudioPlayerParameter a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioBluetoothSCOHelper.a();
    super.a();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_JavaLangString != null) {
      this.jdField_a_of_type_Boolean = true;
    }
    super.a(paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus.a(paramInt, paramBoolean);
      AudioDeviceStatus.AudioDeviceStatusResult localAudioDeviceStatusResult = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus.a();
      if (localAudioDeviceStatusResult != null)
      {
        boolean bool = a();
        if (QLog.isColorLevel()) {
          QLog.d("AudioPlayer_Common", 2, "before notifyUIDeviceStatusChanged status = " + localAudioDeviceStatusResult.a + " | isPlaying = " + bool);
        }
        if (bool)
        {
          if (localAudioDeviceStatusResult.a())
          {
            localAudioDeviceStatusResult.a();
            a(this.jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer.a() - AudioPlayerHelper.a);
          }
          a(localAudioDeviceStatusResult);
        }
      }
      switch (paramInt)
      {
      }
      break;
    }
    do
    {
      do
      {
        return;
        a(paramBoolean, false);
        break;
        a(paramBoolean, true);
        break;
      } while (paramBoolean);
      l();
      return;
    } while (!paramBoolean);
    l();
  }
  
  public void a(CommonAudioPlayer.UIAudioDeivceChangedListern paramUIAudioDeivceChangedListern)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer$UIAudioDeivceChangedListern = paramUIAudioDeivceChangedListern;
  }
  
  public void a(IAudioFilePlayer paramIAudioFilePlayer, int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioBluetoothSCOHelper.a();
    super.a(paramIAudioFilePlayer, paramInt1, paramInt2, paramString);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public boolean a()
  {
    return (super.a()) || (this.jdField_a_of_type_Boolean);
  }
  
  /* Error */
  public boolean a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore_3
    //   2: iload_2
    //   3: istore 6
    //   5: iload_2
    //   6: ifge +6 -> 12
    //   9: iconst_0
    //   10: istore 6
    //   12: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   15: lstore 7
    //   17: aload_0
    //   18: aload_1
    //   19: putfield 133	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   22: aload_0
    //   23: invokestatic 201	com/tencent/mobileqq/app/ThreadManager:remove	(Ljava/lang/Runnable;)Z
    //   26: pop
    //   27: aload_0
    //   28: invokevirtual 202	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:b	()Z
    //   31: ifne +5 -> 36
    //   34: iconst_0
    //   35: ireturn
    //   36: aload_0
    //   37: getfield 46	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus	Lcom/tencent/mobileqq/activity/aio/AudioDeviceStatus;
    //   40: invokevirtual 204	com/tencent/mobileqq/activity/aio/AudioDeviceStatus:b	()V
    //   43: aload_0
    //   44: getfield 125	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioBluetoothSCOHelper	Lcom/tencent/mobileqq/activity/aio/AudioBluetoothSCOHelper;
    //   47: aload_1
    //   48: iload 6
    //   50: invokevirtual 207	com/tencent/mobileqq/activity/aio/AudioBluetoothSCOHelper:a	(Ljava/lang/String;I)I
    //   53: istore_2
    //   54: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +28 -> 85
    //   60: ldc 150
    //   62: iconst_2
    //   63: new 23	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   70: ldc 209
    //   72: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: iload_2
    //   76: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   79: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   85: iload_2
    //   86: ifne +10 -> 96
    //   89: aload_0
    //   90: iconst_0
    //   91: putfield 19	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Boolean	Z
    //   94: iconst_0
    //   95: ireturn
    //   96: iload_2
    //   97: iconst_2
    //   98: if_icmpne +10 -> 108
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 19	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Boolean	Z
    //   106: iconst_1
    //   107: ireturn
    //   108: aload_0
    //   109: getfield 212	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   112: invokestatic 217	com/tencent/mobileqq/qqaudio/audioplayer/AudioPlayer:a	(Landroid/media/AudioManager;)Z
    //   115: ifeq +68 -> 183
    //   118: aload_0
    //   119: getfield 125	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqActivityAioAudioBluetoothSCOHelper	Lcom/tencent/mobileqq/activity/aio/AudioBluetoothSCOHelper;
    //   122: aload_1
    //   123: iload 6
    //   125: invokevirtual 219	com/tencent/mobileqq/activity/aio/AudioBluetoothSCOHelper:b	(Ljava/lang/String;I)I
    //   128: istore_2
    //   129: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +28 -> 160
    //   135: ldc 150
    //   137: iconst_2
    //   138: new 23	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   145: ldc 221
    //   147: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: iload_2
    //   151: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   154: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: iload_2
    //   161: ifne +10 -> 171
    //   164: aload_0
    //   165: iconst_0
    //   166: putfield 19	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Boolean	Z
    //   169: iconst_0
    //   170: ireturn
    //   171: iload_2
    //   172: iconst_2
    //   173: if_icmpne +10 -> 183
    //   176: aload_0
    //   177: iconst_0
    //   178: putfield 19	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Boolean	Z
    //   181: iconst_1
    //   182: ireturn
    //   183: aload_0
    //   184: new 23	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   191: aload_1
    //   192: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: lload 7
    //   197: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   200: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: putfield 75	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:b	Ljava/lang/String;
    //   206: aload_0
    //   207: invokevirtual 227	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:k	()V
    //   210: new 229	java/io/FileInputStream
    //   213: dup
    //   214: aload_1
    //   215: invokespecial 231	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   218: astore 10
    //   220: aload 10
    //   222: astore 9
    //   224: aload 10
    //   226: invokestatic 236	com/tencent/mobileqq/qqaudio/QQAudioUtils:a	(Ljava/io/InputStream;)B
    //   229: istore 4
    //   231: aload 10
    //   233: astore 9
    //   235: iload 4
    //   237: istore_3
    //   238: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   241: ifeq +45 -> 286
    //   244: aload 10
    //   246: astore 9
    //   248: iload 4
    //   250: istore_3
    //   251: ldc 150
    //   253: iconst_2
    //   254: new 23	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   261: ldc 238
    //   263: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: aload_1
    //   267: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: ldc 240
    //   272: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: iload 4
    //   277: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   280: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   286: iload 4
    //   288: istore 5
    //   290: aload 10
    //   292: ifnull +12 -> 304
    //   295: aload 10
    //   297: invokevirtual 245	java/io/InputStream:close	()V
    //   300: iload 4
    //   302: istore 5
    //   304: iload 5
    //   306: iflt +253 -> 559
    //   309: aload_0
    //   310: new 247	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer
    //   313: dup
    //   314: invokespecial 248	com/tencent/mobileqq/qqaudio/audioplayer/SilkPlayer:<init>	()V
    //   317: putfield 168	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   320: iconst_1
    //   321: istore_2
    //   322: iload_2
    //   323: invokestatic 251	com/tencent/mobileqq/qqaudio/QQAudioReporter:a	(I)V
    //   326: aload_0
    //   327: getfield 168	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   330: aload_1
    //   331: invokeinterface 252 2 0
    //   336: aload_0
    //   337: getfield 168	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   340: iload 6
    //   342: invokeinterface 254 2 0
    //   347: aload_0
    //   348: getfield 168	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   351: iconst_m1
    //   352: iload 5
    //   354: invokeinterface 257 3 0
    //   359: aload_0
    //   360: getfield 168	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   363: aload_0
    //   364: invokeinterface 260 2 0
    //   369: aload_0
    //   370: getfield 168	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   373: aload_0
    //   374: getfield 263	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_Float	F
    //   377: invokeinterface 266 2 0
    //   382: aload_0
    //   383: getfield 168	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   386: invokeinterface 267 1 0
    //   391: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   394: ifeq +34 -> 428
    //   397: ldc 150
    //   399: iconst_2
    //   400: new 23	java/lang/StringBuilder
    //   403: dup
    //   404: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   407: ldc_w 269
    //   410: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: invokestatic 195	java/lang/System:currentTimeMillis	()J
    //   416: lload 7
    //   418: lsub
    //   419: invokevirtual 224	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   422: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: aload_0
    //   429: invokespecial 271	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:m	()V
    //   432: iconst_1
    //   433: ireturn
    //   434: astore 11
    //   436: aconst_null
    //   437: astore 10
    //   439: aload 10
    //   441: astore 9
    //   443: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   446: ifeq +37 -> 483
    //   449: aload 10
    //   451: astore 9
    //   453: ldc 150
    //   455: iconst_2
    //   456: new 23	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   463: ldc_w 273
    //   466: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: aload 11
    //   471: invokevirtual 276	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   474: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   477: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   480: invokestatic 163	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: iload_3
    //   484: istore 5
    //   486: aload 10
    //   488: ifnull -184 -> 304
    //   491: aload 10
    //   493: invokevirtual 245	java/io/InputStream:close	()V
    //   496: iload_3
    //   497: istore 5
    //   499: goto -195 -> 304
    //   502: astore 9
    //   504: iload_3
    //   505: istore 5
    //   507: goto -203 -> 304
    //   510: astore_1
    //   511: aconst_null
    //   512: astore 9
    //   514: aload 9
    //   516: ifnull +8 -> 524
    //   519: aload 9
    //   521: invokevirtual 245	java/io/InputStream:close	()V
    //   524: aload_1
    //   525: athrow
    //   526: astore_1
    //   527: invokestatic 148	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   530: ifeq +13 -> 543
    //   533: ldc 150
    //   535: iconst_2
    //   536: ldc_w 278
    //   539: aload_1
    //   540: invokestatic 281	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   543: aload_0
    //   544: aload_0
    //   545: getfield 168	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   548: iconst_2
    //   549: iconst_0
    //   550: aload_1
    //   551: invokevirtual 282	java/lang/Exception:toString	()Ljava/lang/String;
    //   554: invokevirtual 283	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:a	(Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;IILjava/lang/String;)V
    //   557: iconst_0
    //   558: ireturn
    //   559: aload_0
    //   560: new 285	com/tencent/mobileqq/qqaudio/audioplayer/AmrPlayer
    //   563: dup
    //   564: invokespecial 286	com/tencent/mobileqq/qqaudio/audioplayer/AmrPlayer:<init>	()V
    //   567: putfield 168	com/tencent/mobileqq/activity/aio/CommonAudioPlayer:jdField_a_of_type_ComTencentMobileqqQqaudioAudioplayerIAudioFilePlayer	Lcom/tencent/mobileqq/qqaudio/audioplayer/IAudioFilePlayer;
    //   570: ldc 150
    //   572: iconst_1
    //   573: new 23	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   580: ldc_w 288
    //   583: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: iload 5
    //   588: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   591: ldc_w 290
    //   594: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   597: invokevirtual 44	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 293	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: iconst_2
    //   604: istore_2
    //   605: goto -283 -> 322
    //   608: astore 9
    //   610: iload 4
    //   612: istore 5
    //   614: goto -310 -> 304
    //   617: astore 9
    //   619: goto -95 -> 524
    //   622: astore_1
    //   623: goto -109 -> 514
    //   626: astore 11
    //   628: goto -189 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	631	0	this	CommonAudioPlayer
    //   0	631	1	paramString	String
    //   0	631	2	paramInt	int
    //   1	504	3	b1	byte
    //   229	382	4	b2	byte
    //   288	325	5	b3	byte
    //   3	338	6	i	int
    //   15	402	7	l	long
    //   222	230	9	localFileInputStream1	java.io.FileInputStream
    //   502	1	9	localException1	java.lang.Exception
    //   512	8	9	localObject	Object
    //   608	1	9	localException2	java.lang.Exception
    //   617	1	9	localException3	java.lang.Exception
    //   218	274	10	localFileInputStream2	java.io.FileInputStream
    //   434	36	11	localException4	java.lang.Exception
    //   626	1	11	localException5	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   210	220	434	java/lang/Exception
    //   491	496	502	java/lang/Exception
    //   210	220	510	finally
    //   206	210	526	java/lang/Exception
    //   309	320	526	java/lang/Exception
    //   322	391	526	java/lang/Exception
    //   524	526	526	java/lang/Exception
    //   559	603	526	java/lang/Exception
    //   295	300	608	java/lang/Exception
    //   519	524	617	java/lang/Exception
    //   224	231	622	finally
    //   238	244	622	finally
    //   251	286	622	finally
    //   443	449	622	finally
    //   453	483	622	finally
    //   224	231	626	java/lang/Exception
    //   238	244	626	java/lang/Exception
    //   251	286	626	java/lang/Exception
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus = new AudioDeviceStatus();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioBluetoothSCOHelper = new AudioBluetoothSCOHelper(this.jdField_a_of_type_AndroidAppApplication);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioBluetoothSCOHelper.a(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus.a();
  }
  
  public void c()
  {
    super.c();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void d()
  {
    try
    {
      n();
      super.d();
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus.a(this.jdField_a_of_type_AndroidMediaAudioManager);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus.e(true);
  }
  
  public void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioDeviceStatus.e(false);
  }
  
  public void h()
  {
    super.h();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioBluetoothSCOHelper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CommonAudioPlayer
 * JD-Core Version:    0.7.0.1
 */