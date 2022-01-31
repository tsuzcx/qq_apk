package com.tencent.mobileqq.activity.aio;

import aciy;
import acjg;
import acka;
import acmp;
import acmq;
import acmr;
import acms;
import acmt;
import adie;
import adot;
import ajed;
import akbm;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import beot;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPtt;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import kvx;
import mqq.manager.Manager;
import mqq.util.WeakReference;

public class MediaPlayerManager
  extends BroadcastReceiver
  implements acjg, SensorEventListener, Runnable, Manager
{
  public static float a;
  public static int a;
  public static float b;
  public static float c;
  private acmq jdField_a_of_type_Acmq;
  private acmr jdField_a_of_type_Acmr;
  private acms jdField_a_of_type_Acms;
  private Sensor jdField_a_of_type_AndroidHardwareSensor;
  private SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private MediaPlayer.OnCompletionListener jdField_a_of_type_AndroidMediaMediaPlayer$OnCompletionListener = new acmp(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private beot jdField_a_of_type_Beot;
  private AudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
  private ChatMessage jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  Runnable jdField_a_of_type_JavaLangRunnable = new MediaPlayerManager.7(this);
  private WeakReference<QQAppInterface> jdField_a_of_type_MqqUtilWeakReference;
  public boolean a;
  private Sensor jdField_b_of_type_AndroidHardwareSensor;
  private ChatMessage jdField_b_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_b_of_type_Boolean = true;
  private ChatMessage jdField_c_of_type_ComTencentMobileqqDataChatMessage;
  boolean jdField_c_of_type_Boolean = false;
  public float d;
  private ChatMessage jdField_d_of_type_ComTencentMobileqqDataChatMessage;
  private boolean jdField_d_of_type_Boolean;
  public float e;
  private boolean e;
  public float f;
  private boolean f;
  private float jdField_g_of_type_Float;
  private boolean jdField_g_of_type_Boolean;
  private float jdField_h_of_type_Float = 0.6F;
  private boolean jdField_h_of_type_Boolean;
  private float jdField_i_of_type_Float = 0.02F;
  private boolean jdField_i_of_type_Boolean;
  
  static
  {
    jdField_a_of_type_Float = 1.0F;
    jdField_b_of_type_Float = 1.5F;
    jdField_c_of_type_Float = 1.8F;
    jdField_a_of_type_Int = 1000;
  }
  
  public MediaPlayerManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Boolean = true;
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer = new AudioPlayer(localBaseApplication, this);
    this.jdField_a_of_type_AndroidHardwareSensorManager = ((SensorManager)localBaseApplication.getSystemService("sensor"));
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
    localIntentFilter.addAction("tencent.av.v2q.StartVideoChat");
    localIntentFilter.addAction("android.media.RINGER_MODE_CHANGED");
    localIntentFilter.addAction("android.intent.action.SCREEN_OFF");
    if (Build.VERSION.SDK_INT >= 11)
    {
      localIntentFilter.addAction("android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED");
      localIntentFilter.addAction("android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED");
    }
    localBaseApplication.registerReceiver(this, localIntentFilter);
    a(paramQQAppInterface);
  }
  
  private float a(Sensor paramSensor)
  {
    String str = Build.MODEL;
    float f1;
    if ((str.equals("ZTE U880s")) || (str.equals("ZTE U807"))) {
      f1 = 97.0F;
    }
    do
    {
      return f1;
      if ((str.equals("Coolpad 5890")) || (str.equals("Coolpad 5891")) || (str.equals("Coolpad 8720L")) || (str.equals("Coolpad 5879")) || (str.equals("Coolpad 5891Q"))) {
        return 5.0F;
      }
      if ((str.equals("HUAWEI Y320-T00")) || (str.equals("Lenovo A658t")) || (str.equals("Lenovo A788t"))) {
        return 10.0F;
      }
      if (str.equals("ME860")) {
        return 99.0F;
      }
      if ((str.equals("ZTE U930HD")) || (str.equals("ZTE-T U960s"))) {
        return 100.0F;
      }
      f1 = 0.0F;
    } while (paramSensor == null);
    return paramSensor.getMaximumRange();
  }
  
  public static int a(ChatMessage paramChatMessage, beot parambeot)
  {
    int j;
    int k;
    if (akbm.a(paramChatMessage.istroop) == 1032)
    {
      j = 1;
      if (parambeot != null) {
        k = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (k >= parambeot.getCount()) {
          break label150;
        }
        Object localObject = parambeot.getItem(k);
        if (localObject != null) {
          if ((localObject instanceof ChatMessage))
          {
            if (((ChatMessage)localObject).uniseq != paramChatMessage.uniseq) {}
          }
          else {
            do
            {
              return k;
              j = 0;
              break;
              if (!(localObject instanceof RecentBaseData)) {
                break label143;
              }
              localObject = (RecentBaseData)localObject;
            } while (((j != 0) && (((RecentBaseData)localObject).a() == 1032) && (((RecentBaseData)localObject).a().equals(ajed.aL))) || ((paramChatMessage.frienduin.equals(((RecentBaseData)localObject).a())) && (paramChatMessage.istroop == ((RecentBaseData)localObject).a())));
          }
        }
        label143:
        k += 1;
      }
    }
    label150:
    return -1;
  }
  
  private int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if (!this.jdField_g_of_type_Boolean)
    {
      k = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Beot);
      a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_c_of_type_ComTencentMobileqqDataChatMessage);
      j = k;
      if (k >= 0)
      {
        localView = aciy.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + k);
        a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a(this.jdField_a_of_type_ComTencentWidgetXListView, k, localView, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramBoolean2);
        j = k;
      }
    }
    while (this.jdField_a_of_type_Acmr == null)
    {
      int k;
      View localView;
      return j;
    }
    this.jdField_a_of_type_Acmr.a(null, 0, null, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, paramBoolean2);
    return 0;
  }
  
  private acmr a(ChatMessage paramChatMessage)
  {
    if ((this.jdField_a_of_type_Beot instanceof acka)) {
      return (acmr)((acka)this.jdField_a_of_type_Beot).a.a(paramChatMessage, this.jdField_a_of_type_Beot);
    }
    return this.jdField_a_of_type_Acmr;
  }
  
  public static MediaPlayerManager a(QQAppInterface paramQQAppInterface)
  {
    try
    {
      paramQQAppInterface = (MediaPlayerManager)paramQQAppInterface.getManager(24);
      return paramQQAppInterface;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  private ChatMessage a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_Beot.getItem(paramInt);
    if ((localObject != null) && ((localObject instanceof ChatMessage))) {
      return (ChatMessage)localObject;
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaPlayerManager", 2, "$bindApp, app = " + paramQQAppInterface);
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() == paramQQAppInterface)) {
      return;
    }
    if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
      a();
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramQQAppInterface);
  }
  
  public static boolean a()
  {
    return Build.MODEL.equals("ZTE U930");
  }
  
  public static boolean a(float paramFloat)
  {
    return (paramFloat > 1.0F) && (Math.abs(paramFloat - 1.0F) > 0.0F);
  }
  
  public static boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 1.0E-006F;
  }
  
  private boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = false;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
      if ((this.jdField_g_of_type_Boolean) || ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_Beot != null))) {
        a(paramBoolean1, paramBoolean2);
      }
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
      bool2 = true;
    }
    label173:
    for (;;)
    {
      return bool2;
      if ((this.jdField_a_of_type_Beot != null) && (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null))
      {
        if (!a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage)) {
          continue;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
        a(paramBoolean1, paramBoolean2);
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
        break;
      }
      if ((this.jdField_a_of_type_Beot != null) || (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null)) {
        break;
      }
      if (this.jdField_a_of_type_Acmr != null) {}
      for (boolean bool1 = this.jdField_a_of_type_Acmr.b(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);; bool1 = false)
      {
        if (!bool1) {
          break label173;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.c();
        a(paramBoolean1, paramBoolean2);
        this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
        break;
      }
    }
  }
  
  private boolean d()
  {
    int k;
    int i1;
    float f1;
    boolean bool1;
    if ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && (this.jdField_a_of_type_Beot != null))
    {
      k = a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, this.jdField_a_of_type_Beot);
      i1 = this.jdField_a_of_type_Beot.getCount();
      if (k <= i1)
      {
        f1 = jdField_a_of_type_Float;
        if (!(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPtt)) {
          break label428;
        }
        bool1 = a(((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).playSpeedPos);
        if (bool1) {
          f1 = ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).playSpeedPos;
        }
        ((MessageForPtt)this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).playSpeedPos = jdField_a_of_type_Float;
      }
    }
    for (;;)
    {
      Object localObject = aciy.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + k);
      if (k >= 0) {
        a(this.jdField_a_of_type_ComTencentMobileqqDataChatMessage).a(this.jdField_a_of_type_ComTencentWidgetXListView, k, (View)localObject, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage, true);
      }
      if (this.jdField_d_of_type_Boolean) {
        while (k < i1 - 1)
        {
          int n = k + 1;
          ChatMessage localChatMessage = a(n);
          k = n;
          if ((localChatMessage instanceof acmt))
          {
            int j;
            label199:
            View localView;
            if ((this.jdField_i_of_type_Boolean) && (localObject != null))
            {
              j = 1;
              localView = aciy.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + n);
            }
            try
            {
              localObject = a(localChatMessage);
              boolean bool2 = ((acmr)localObject).a(this.jdField_a_of_type_ComTencentWidgetXListView, n, localView, localChatMessage);
              if ((bool2) && (bool1) && ((localChatMessage instanceof MessageForPtt)))
              {
                ((MessageForPtt)localChatMessage).playSpeedPos = f1;
                a(f1);
                if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) {
                  this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(((MessageForPtt)localChatMessage).msgTime);
                }
              }
              if ((bool2) && (((acmr)localObject).a(this.jdField_a_of_type_ComTencentWidgetXListView, n, localView, localChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, 0))) {}
              for (int m = 1;; m = 0)
              {
                k = n;
                localObject = localView;
                if (m == 0) {
                  break;
                }
                this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = localChatMessage;
                if (j != 0) {
                  this.jdField_a_of_type_ComTencentWidgetXListView.smoothScrollToPosition(this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + n);
                }
                return true;
                j = 0;
                break label199;
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
            }
            catch (Exception localException)
            {
              k = n;
              localObject = localView;
            }
            QLog.e("MediaPlayerManager", 2, "playNext", localException);
            k = n;
            localObject = localView;
          }
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = null;
      return false;
      label428:
      bool1 = false;
    }
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: invokestatic 418	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   6: getstatic 424	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:qq_audio_play	Lcom/tencent/mobileqq/app/DeviceProfileManager$DpcNames;
    //   9: invokevirtual 427	com/tencent/mobileqq/app/DeviceProfileManager$DpcNames:name	()Ljava/lang/String;
    //   12: aconst_null
    //   13: invokevirtual 430	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   16: astore 7
    //   18: invokestatic 314	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   21: ifeq +31 -> 52
    //   24: ldc_w 316
    //   27: iconst_2
    //   28: new 318	java/lang/StringBuilder
    //   31: dup
    //   32: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   35: ldc_w 432
    //   38: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: aload 7
    //   43: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 334	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload 7
    //   54: invokestatic 438	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +436 -> 493
    //   60: aload 7
    //   62: invokevirtual 441	java/lang/String:length	()I
    //   65: iconst_1
    //   66: if_icmple +427 -> 493
    //   69: aload 7
    //   71: ldc_w 443
    //   74: invokevirtual 447	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   77: astore 7
    //   79: ldc_w 449
    //   82: aload 7
    //   84: iconst_0
    //   85: aaload
    //   86: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   89: istore 6
    //   91: iload 6
    //   93: ifne +271 -> 364
    //   96: iconst_1
    //   97: istore 4
    //   99: aload 7
    //   101: iconst_1
    //   102: aaload
    //   103: invokestatic 455	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   106: fstore_2
    //   107: fload_2
    //   108: fstore_1
    //   109: iload 4
    //   111: istore_3
    //   112: aload 7
    //   114: arraylength
    //   115: iconst_5
    //   116: if_icmplt +40 -> 156
    //   119: aload_0
    //   120: aload 7
    //   122: iconst_2
    //   123: aaload
    //   124: invokestatic 455	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   127: putfield 73	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_h_of_type_Float	F
    //   130: aload_0
    //   131: aload 7
    //   133: iconst_3
    //   134: aaload
    //   135: invokestatic 455	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   138: putfield 76	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_i_of_type_Float	F
    //   141: aload 7
    //   143: iconst_4
    //   144: aaload
    //   145: invokestatic 461	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   148: putstatic 50	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_a_of_type_Int	I
    //   151: iload 4
    //   153: istore_3
    //   154: fload_2
    //   155: fstore_1
    //   156: getstatic 50	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_a_of_type_Int	I
    //   159: ifge +9 -> 168
    //   162: sipush 1000
    //   165: putstatic 50	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_a_of_type_Int	I
    //   168: aload_0
    //   169: getfield 73	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_h_of_type_Float	F
    //   172: fconst_0
    //   173: fcmpg
    //   174: ifgt +5 -> 179
    //   177: iconst_0
    //   178: istore_3
    //   179: invokestatic 418	com/tencent/mobileqq/app/DeviceProfileManager:a	()Lcom/tencent/mobileqq/app/DeviceProfileManager;
    //   182: getstatic 467	com/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames:qq_audio_play_fix	Lcom/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames;
    //   185: invokevirtual 468	com/tencent/mobileqq/app/DeviceProfileManager$AccountDpcManager$DpcAccountNames:name	()Ljava/lang/String;
    //   188: aconst_null
    //   189: invokevirtual 430	com/tencent/mobileqq/app/DeviceProfileManager:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   192: astore 7
    //   194: invokestatic 314	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   197: ifeq +31 -> 228
    //   200: ldc_w 316
    //   203: iconst_2
    //   204: new 318	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 319	java/lang/StringBuilder:<init>	()V
    //   211: ldc_w 470
    //   214: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload 7
    //   219: invokevirtual 325	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: invokevirtual 331	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 334	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: aload 7
    //   230: invokestatic 438	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   233: ifne +254 -> 487
    //   236: aload 7
    //   238: invokevirtual 441	java/lang/String:length	()I
    //   241: iconst_1
    //   242: if_icmple +245 -> 487
    //   245: aload 7
    //   247: ldc_w 443
    //   250: invokevirtual 447	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   253: astore 7
    //   255: ldc_w 472
    //   258: aload 7
    //   260: iconst_4
    //   261: aaload
    //   262: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   265: ifne +219 -> 484
    //   268: aload 7
    //   270: iconst_4
    //   271: aaload
    //   272: invokestatic 455	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   275: fstore_2
    //   276: fload_2
    //   277: fstore_1
    //   278: ldc_w 449
    //   281: aload 7
    //   283: iconst_5
    //   284: aaload
    //   285: invokevirtual 162	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   288: istore 6
    //   290: iload 5
    //   292: istore_3
    //   293: iload 6
    //   295: ifne +5 -> 300
    //   298: iconst_1
    //   299: istore_3
    //   300: iload_3
    //   301: istore 4
    //   303: iload 4
    //   305: ifeq +27 -> 332
    //   308: aload_0
    //   309: aload_0
    //   310: getfield 117	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_a_of_type_AndroidHardwareSensorManager	Landroid/hardware/SensorManager;
    //   313: iconst_1
    //   314: invokevirtual 476	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   317: putfield 478	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_b_of_type_AndroidHardwareSensor	Landroid/hardware/Sensor;
    //   320: aload_0
    //   321: new 480	acmq
    //   324: dup
    //   325: aload_0
    //   326: invokespecial 481	acmq:<init>	(Lcom/tencent/mobileqq/activity/aio/MediaPlayerManager;)V
    //   329: putfield 280	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_a_of_type_Acmq	Lacmq;
    //   332: aload_0
    //   333: aload_0
    //   334: getfield 117	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_a_of_type_AndroidHardwareSensorManager	Landroid/hardware/SensorManager;
    //   337: bipush 8
    //   339: invokevirtual 476	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   342: putfield 483	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_a_of_type_AndroidHardwareSensor	Landroid/hardware/Sensor;
    //   345: fload_1
    //   346: ldc_w 484
    //   349: fcmpl
    //   350: ifle +93 -> 443
    //   353: aload_0
    //   354: fload_1
    //   355: putfield 486	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_g_of_type_Float	F
    //   358: aload_0
    //   359: iconst_1
    //   360: putfield 488	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_h_of_type_Boolean	Z
    //   363: return
    //   364: iconst_0
    //   365: istore 4
    //   367: goto -268 -> 99
    //   370: astore 7
    //   372: iconst_1
    //   373: istore 4
    //   375: fconst_0
    //   376: fstore_2
    //   377: fload_2
    //   378: fstore_1
    //   379: iload 4
    //   381: istore_3
    //   382: invokestatic 314	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   385: ifeq -229 -> 156
    //   388: ldc_w 316
    //   391: iconst_2
    //   392: ldc_w 490
    //   395: aload 7
    //   397: invokestatic 492	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   400: fload_2
    //   401: fstore_1
    //   402: iload 4
    //   404: istore_3
    //   405: goto -249 -> 156
    //   408: astore 7
    //   410: fload_1
    //   411: fstore_2
    //   412: fload_2
    //   413: fstore_1
    //   414: iload_3
    //   415: istore 4
    //   417: invokestatic 314	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   420: ifeq -117 -> 303
    //   423: ldc_w 316
    //   426: iconst_2
    //   427: ldc_w 494
    //   430: aload 7
    //   432: invokestatic 492	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   435: fload_2
    //   436: fstore_1
    //   437: iload_3
    //   438: istore 4
    //   440: goto -137 -> 303
    //   443: aload_0
    //   444: getfield 483	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_a_of_type_AndroidHardwareSensor	Landroid/hardware/Sensor;
    //   447: ifnull -89 -> 358
    //   450: aload_0
    //   451: aload_0
    //   452: aload_0
    //   453: getfield 483	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_a_of_type_AndroidHardwareSensor	Landroid/hardware/Sensor;
    //   456: invokespecial 496	com/tencent/mobileqq/activity/aio/MediaPlayerManager:a	(Landroid/hardware/Sensor;)F
    //   459: putfield 486	com/tencent/mobileqq/activity/aio/MediaPlayerManager:jdField_g_of_type_Float	F
    //   462: goto -104 -> 358
    //   465: astore 7
    //   467: fload_1
    //   468: fstore_2
    //   469: goto -57 -> 412
    //   472: astore 7
    //   474: fconst_0
    //   475: fstore_2
    //   476: goto -99 -> 377
    //   479: astore 7
    //   481: goto -104 -> 377
    //   484: goto -206 -> 278
    //   487: iload_3
    //   488: istore 4
    //   490: goto -187 -> 303
    //   493: fconst_0
    //   494: fstore_1
    //   495: iconst_1
    //   496: istore_3
    //   497: goto -341 -> 156
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	500	0	this	MediaPlayerManager
    //   108	387	1	f1	float
    //   106	370	2	f2	float
    //   111	386	3	j	int
    //   97	392	4	k	int
    //   1	290	5	m	int
    //   89	205	6	bool	boolean
    //   16	266	7	localObject	Object
    //   370	26	7	localException1	Exception
    //   408	23	7	localException2	Exception
    //   465	1	7	localException3	Exception
    //   472	1	7	localException4	Exception
    //   479	1	7	localException5	Exception
    // Exception table:
    //   from	to	target	type
    //   69	91	370	java/lang/Exception
    //   245	276	408	java/lang/Exception
    //   278	290	465	java/lang/Exception
    //   99	107	472	java/lang/Exception
    //   112	151	479	java/lang/Exception
  }
  
  private void h()
  {
    this.jdField_d_of_type_Float = -999.0F;
    this.jdField_e_of_type_Float = -999.0F;
    this.jdField_f_of_type_Float = -999.0F;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public ChatMessage a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
  }
  
  public void a()
  {
    try
    {
      a(true);
      a(this.jdField_a_of_type_ComTencentWidgetXListView);
      if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
        ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).getApp().unregisterReceiver(this);
      }
      this.jdField_a_of_type_MqqUtilWeakReference = null;
      if (QLog.isColorLevel()) {
        QLog.d("MediaPlayerManager", 2, "$unBindApp");
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("MediaPlayerManager", 2, "", localException);
    }
  }
  
  public void a(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(paramFloat);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Beot == null) || (this.jdField_a_of_type_ComTencentWidgetXListView == null)) {
      return;
    }
    int k = this.jdField_a_of_type_Beot.getCount();
    int j = 0;
    label25:
    Object localObject;
    PttAudioWaveView localPttAudioWaveView;
    if (j < k) {
      if (paramInt != j)
      {
        localObject = a(j);
        if (!(localObject instanceof MessageForPtt)) {
          break label154;
        }
        ((MessageForPtt)localObject).playProgress = 0.0F;
        ((MessageForPtt)localObject).playSpeedPos = jdField_a_of_type_Float;
        localObject = aciy.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + j);
        if (localObject != null)
        {
          localPttAudioWaveView = (PttAudioWaveView)((View)localObject).findViewById(2131307224);
          if (localPttAudioWaveView != null)
          {
            localPttAudioWaveView.setProgress(0.0F);
            localPttAudioWaveView.setCanSupportSlide(false);
          }
          localObject = (PttAudioPlayView)((View)localObject).findViewById(2131307223);
          if (localObject != null) {
            ((PttAudioPlayView)localObject).setPlayState(false);
          }
        }
      }
    }
    for (;;)
    {
      j += 1;
      break label25;
      break;
      label154:
      if ((localObject instanceof MessageForMarketFace))
      {
        localObject = (MessageForMarketFace)localObject;
        if (((MessageForMarketFace)localObject).isNewSoundType())
        {
          ((MessageForMarketFace)localObject).playProgress = 0.0F;
          localObject = aciy.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + j);
          if (localObject != null)
          {
            localPttAudioWaveView = (PttAudioWaveView)((View)localObject).findViewById(2131305109);
            if (localPttAudioWaveView != null) {
              localPttAudioWaveView.setProgress(0.0F);
            }
            localObject = (PttAudioPlayView)((View)localObject).findViewById(2131305108);
            if (localObject != null) {
              ((PttAudioPlayView)localObject).setPlayState(false);
            }
          }
        }
      }
    }
  }
  
  public void a(acms paramacms, acmr paramacmr)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "bindUI, listener = " + paramacms + " ,callBack = " + paramacmr);
    }
    this.jdField_a_of_type_Acms = paramacms;
    this.jdField_a_of_type_Acmr = paramacmr;
    this.jdField_g_of_type_Boolean = true;
  }
  
  public void a(AudioPlayer paramAudioPlayer)
  {
    ThreadManager.excute(new MediaPlayerManager.2(this), 16, null, false);
  }
  
  public void a(AudioPlayer paramAudioPlayer, int paramInt)
  {
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
        a(true, true);
      }
      if (this.jdField_a_of_type_Acms != null) {
        this.jdField_a_of_type_Acms.f(paramInt);
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MediaPlayerManager.4(this, paramAudioPlayer, paramInt));
  }
  
  public void a(ChatMessage paramChatMessage)
  {
    this.jdField_d_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
  }
  
  public void a(ChatMessage paramChatMessage1, ChatMessage paramChatMessage2)
  {
    if (((paramChatMessage1 instanceof MessageForPtt)) && ((paramChatMessage2 instanceof MessageForPtt)) && (!paramChatMessage1.equals(paramChatMessage2))) {
      ((MessageForPtt)paramChatMessage1).playSpeedPos = jdField_a_of_type_Float;
    }
  }
  
  public void a(XListView paramXListView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "unBindUI");
    }
    if ((this.jdField_a_of_type_ComTencentWidgetXListView != null) && (this.jdField_a_of_type_ComTencentWidgetXListView == paramXListView))
    {
      this.jdField_a_of_type_ComTencentWidgetXListView = null;
      this.jdField_a_of_type_Beot = null;
      this.jdField_a_of_type_Acms = null;
      this.jdField_a_of_type_Acmr = null;
      this.jdField_d_of_type_Boolean = false;
      this.jdField_i_of_type_Boolean = false;
    }
  }
  
  public void a(XListView paramXListView, beot parambeot, acms paramacms)
  {
    a(paramXListView, parambeot, paramacms, null, true, true);
  }
  
  public void a(XListView paramXListView, beot parambeot, acms paramacms, acmr paramacmr, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "bindUI, mListView = " + this.jdField_a_of_type_ComTencentWidgetXListView + " ,listView = " + paramXListView + " ,adapter = " + parambeot + ", listener = " + paramacms);
    }
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_Beot = parambeot;
    this.jdField_a_of_type_Acms = paramacms;
    this.jdField_a_of_type_Acmr = paramacmr;
    this.jdField_d_of_type_Boolean = paramBoolean1;
    this.jdField_i_of_type_Boolean = paramBoolean2;
    this.jdField_g_of_type_Boolean = false;
  }
  
  public void a(boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (a(paramBoolean, false)) {
        e();
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MediaPlayerManager.1(this, paramBoolean));
  }
  
  public boolean a(ChatMessage paramChatMessage)
  {
    return a(paramChatMessage, false);
  }
  
  public boolean a(ChatMessage paramChatMessage, int paramInt)
  {
    return a(paramChatMessage, false, paramInt);
  }
  
  public boolean a(ChatMessage paramChatMessage, boolean paramBoolean)
  {
    return a(paramChatMessage, paramBoolean, 0);
  }
  
  public boolean a(ChatMessage paramChatMessage, boolean paramBoolean, int paramInt)
  {
    if (!this.jdField_h_of_type_Boolean) {
      g();
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqDataChatMessage != null) && ((this.jdField_b_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForPtt))) {
      ((MessageForPtt)this.jdField_b_of_type_ComTencentMobileqqDataChatMessage).playProgress = 0.0F;
    }
    h();
    adot.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    a(this.jdField_d_of_type_ComTencentMobileqqDataChatMessage, paramChatMessage);
    this.jdField_c_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
    if ((this.jdField_a_of_type_Beot != null) && (paramChatMessage != null) && (this.jdField_a_of_type_MqqUtilWeakReference != null)) {
      if (a(false, false))
      {
        boolean bool2;
        boolean bool3;
        int j;
        boolean bool1;
        if (((paramChatMessage instanceof MessageForLightVideo)) || (aciy.b()))
        {
          this.jdField_e_of_type_Boolean = true;
          bool2 = kvx.a(BaseApplicationImpl.getContext());
          bool3 = AudioHelper.a(BaseApplicationImpl.getContext());
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_e_of_type_Boolean);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(bool2);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool3);
          j = a(paramChatMessage, this.jdField_a_of_type_Beot);
          bool1 = false;
          if (!paramBoolean) {
            break label295;
          }
        }
        label295:
        View localView;
        for (paramBoolean = bool1;; paramBoolean = a(paramChatMessage).a(this.jdField_a_of_type_ComTencentWidgetXListView, j, localView, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, paramInt))
        {
          if (!paramBoolean) {
            break label347;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          this.jdField_c_of_type_Boolean = false;
          this.jdField_c_of_type_ComTencentMobileqqDataChatMessage = null;
          this.jdField_d_of_type_ComTencentMobileqqDataChatMessage = null;
          if (this.jdField_a_of_type_Acms != null)
          {
            this.jdField_a_of_type_Acms.ab();
            this.jdField_a_of_type_Acms.a(bool2, bool3, this.jdField_e_of_type_Boolean, false);
          }
          this.jdField_f_of_type_Boolean = false;
          ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 16);
          ThreadManager.excute(this, 16, null, false);
          return true;
          if ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)) {
            break;
          }
          this.jdField_e_of_type_Boolean = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).t();
          break;
          this.jdField_i_of_type_Boolean = true;
          localView = aciy.a(this.jdField_a_of_type_ComTencentWidgetXListView, this.jdField_a_of_type_ComTencentWidgetXListView.getHeaderViewsCount() + j);
        }
        label347:
        if (QLog.isColorLevel()) {
          QLog.d("MediaPlayerManager", 2, "builder play failed.");
        }
      }
    }
    for (;;)
    {
      this.jdField_c_of_type_ComTencentMobileqqDataChatMessage = null;
      this.jdField_d_of_type_ComTencentMobileqqDataChatMessage = null;
      return false;
      if (QLog.isColorLevel())
      {
        QLog.d("MediaPlayerManager", 2, "doStop failed.");
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("MediaPlayerManager", 2, "request play failed, mAdapter = " + this.jdField_a_of_type_Beot + ", msg = " + paramChatMessage + ", app = " + this.jdField_a_of_type_MqqUtilWeakReference);
        }
      }
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("MediaPlayerManager", 2, "unBindUI");
    }
    this.jdField_a_of_type_Acms = null;
    this.jdField_a_of_type_Acmr = null;
  }
  
  public void b(AudioPlayer paramAudioPlayer, int paramInt)
  {
    if (this.jdField_a_of_type_Acms != null) {
      this.jdField_a_of_type_Acms.g(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((paramBoolean) && (b())) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_i_of_type_Boolean = paramBoolean;
      return;
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null;
  }
  
  public boolean b(ChatMessage paramChatMessage, int paramInt)
  {
    boolean bool1 = false;
    if (!this.jdField_h_of_type_Boolean) {
      g();
    }
    h();
    adot.a(this.jdField_a_of_type_ComTencentWidgetXListView);
    if ((paramChatMessage != null) && (this.jdField_a_of_type_MqqUtilWeakReference != null)) {
      if (a(false, false)) {
        if (aciy.b())
        {
          this.jdField_e_of_type_Boolean = true;
          bool2 = kvx.a(BaseApplicationImpl.getContext());
          bool3 = AudioHelper.a(BaseApplicationImpl.getContext());
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_e_of_type_Boolean);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(bool2);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool3);
          if (!this.jdField_a_of_type_Acmr.a(this.jdField_a_of_type_ComTencentWidgetXListView, 0, null, paramChatMessage, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer, paramInt)) {
            break label233;
          }
          this.jdField_a_of_type_ComTencentMobileqqDataChatMessage = paramChatMessage;
          this.jdField_c_of_type_Boolean = false;
          if (this.jdField_a_of_type_Acms != null)
          {
            this.jdField_a_of_type_Acms.ab();
            this.jdField_a_of_type_Acms.a(bool2, bool3, this.jdField_e_of_type_Boolean, false);
          }
          this.jdField_f_of_type_Boolean = false;
          ThreadManager.removeJobFromThreadPool(this.jdField_a_of_type_JavaLangRunnable, 16);
          ThreadManager.excute(this, 16, null, false);
          bool1 = true;
        }
      }
    }
    label233:
    while (!QLog.isColorLevel())
    {
      do
      {
        do
        {
          for (;;)
          {
            boolean bool2;
            boolean bool3;
            return bool1;
            if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
              this.jdField_e_of_type_Boolean = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).t();
            }
          }
        } while (!QLog.isColorLevel());
        QLog.d("MediaPlayerManager", 2, "builder play failed.");
        return false;
      } while (!QLog.isColorLevel());
      QLog.d("MediaPlayerManager", 2, "doStop failed.");
      return false;
    }
    QLog.d("MediaPlayerManager", 2, "request play failed, mAdapter = " + this.jdField_a_of_type_Beot + ", msg = " + paramChatMessage + ", app = " + this.jdField_a_of_type_MqqUtilWeakReference);
    return false;
  }
  
  public void c()
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_MqqUtilWeakReference != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) {
        bool1 = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).t();
      }
    }
    if ((bool1 != this.jdField_e_of_type_Boolean) && (b()))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(bool1, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b() - jdField_a_of_type_Int);
      if (this.jdField_a_of_type_Acms != null) {
        this.jdField_a_of_type_Acms.a(kvx.a(BaseApplicationImpl.getContext()), AudioHelper.a(BaseApplicationImpl.getContext()), bool1, false);
      }
      if (QLog.isColorLevel()) {
        QLog.d("MediaPlayerManager", 2, "$updateSpeakPhone| speakerOn=" + bool1);
      }
    }
    this.jdField_e_of_type_Boolean = bool1;
  }
  
  public void c(AudioPlayer paramAudioPlayer, int paramInt)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new MediaPlayerManager.5(this, paramInt));
  }
  
  public void c(boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      if (a(paramBoolean, true)) {
        e();
      }
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new MediaPlayerManager.8(this, paramBoolean));
  }
  
  public boolean c()
  {
    return (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) && ((this.jdField_a_of_type_ComTencentMobileqqDataChatMessage instanceof MessageForLightVideo));
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
      this.jdField_b_of_type_ComTencentMobileqqDataChatMessage = this.jdField_a_of_type_ComTencentMobileqqDataChatMessage;
    }
  }
  
  public void d(AudioPlayer paramAudioPlayer, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidOsHandler != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a())) {
      this.jdField_a_of_type_AndroidOsHandler.post(new MediaPlayerManager.6(this, paramInt));
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MediaPlayerManager", 2, "$onStop");
    }
    if (this.jdField_a_of_type_Acms != null) {
      this.jdField_a_of_type_Acms.ac();
    }
    ThreadManager.removeJobFromThreadPool(this, 16);
    ThreadManager.excute(this.jdField_a_of_type_JavaLangRunnable, 16, null, false);
  }
  
  public void f()
  {
    if (!AudioPlayer.jdField_a_of_type_Boolean) {}
    AudioManager localAudioManager;
    do
    {
      return;
      localAudioManager = (AudioManager)BaseApplicationImpl.getContext().getSystemService("audio");
    } while ((!AudioPlayer.jdField_b_of_type_Boolean) || (localAudioManager == null) || (!localAudioManager.isBluetoothScoOn()));
    if (QLog.isColorLevel()) {
      QLog.d("MediaPlayerManager", 2, "stop sco");
    }
    localAudioManager.stopBluetoothSco();
    localAudioManager.setBluetoothScoOn(false);
    AudioPlayer.jdField_b_of_type_Boolean = false;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onDestroy()
  {
    f();
    a();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    String str = paramIntent.getAction();
    if ((str != null) && (str.equals("android.intent.action.HEADSET_PLUG"))) {
      if (paramIntent.hasExtra("state"))
      {
        if (paramIntent.getIntExtra("state", 0) != 1) {
          break label98;
        }
        bool1 = true;
        if (this.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(bool1);
        }
        if (this.jdField_a_of_type_Acms != null) {
          this.jdField_a_of_type_Acms.a(bool1, AudioHelper.a(BaseApplicationImpl.getContext()), this.jdField_e_of_type_Boolean, true);
        }
      }
    }
    label98:
    int j;
    label535:
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            bool1 = false;
            break;
            if ((str != null) && (str.equals("tencent.av.v2q.StartVideoChat")))
            {
              bool1 = paramIntent.getBooleanExtra("updateTime", false);
              bool2 = paramIntent.getBooleanExtra("showTime", false);
              if (QLog.isColorLevel()) {
                QLog.d("MediaPlayerManager", 2, "receive action_recv_video_request. update:" + bool1 + ", show:" + bool2);
              }
              if ((bool1) && (bool2)) {
                ChatActivityUtils.a();
              }
              a(true);
              return;
            }
            if ("android.media.RINGER_MODE_CHANGED".equals(str))
            {
              paramContext = (AudioManager)paramContext.getSystemService("audio");
              try
              {
                j = paramContext.getRingerMode();
                if (QLog.isColorLevel()) {
                  QLog.d("MediaPlayerManager", 2, "currentRingerMode:" + j);
                }
                if (j != 2)
                {
                  this.jdField_e_of_type_Boolean = false;
                  if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null)) {
                    ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).d(this.jdField_e_of_type_Boolean);
                  }
                  if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a()) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_e_of_type_Boolean)) && (this.jdField_a_of_type_Acms != null))
                  {
                    this.jdField_a_of_type_Acms.c(this.jdField_f_of_type_Boolean, this.jdField_e_of_type_Boolean);
                    return;
                  }
                }
              }
              catch (Throwable paramContext)
              {
                for (;;)
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("MediaPlayerManager", 2, "onReceive getRingerMode error:" + paramContext.getMessage());
                  }
                  j = 2;
                }
              }
            }
          }
          if ("android.intent.action.SCREEN_OFF".equals(str))
          {
            a(false);
            adot.a(this.jdField_a_of_type_ComTencentWidgetXListView);
            return;
          }
          if (!"android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED".equals(str)) {
            break label535;
          }
          j = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
        } while ((j != 2) && (j != 0));
        paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
        if (j == 2) {}
        for (;;)
        {
          paramContext.d(bool1);
          if (b())
          {
            bool1 = AudioHelper.a(BaseApplicationImpl.getContext());
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool1);
            if (this.jdField_a_of_type_Acms != null) {
              this.jdField_a_of_type_Acms.a(kvx.a(BaseApplicationImpl.getContext()), bool1, this.jdField_e_of_type_Boolean, false);
            }
          }
          if (j != 0) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.d();
          return;
          bool1 = false;
        }
      } while (!"android.bluetooth.a2dp.profile.action.CONNECTION_STATE_CHANGED".equals(str));
      j = paramIntent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
    } while ((j != 2) && (j != 0));
    paramContext = this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer;
    if (j == 2) {}
    for (bool1 = bool2;; bool1 = false)
    {
      paramContext.c(bool1);
      if (b())
      {
        bool1 = AudioHelper.a(BaseApplicationImpl.getContext());
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b(bool1);
        if (this.jdField_a_of_type_Acms != null) {
          this.jdField_a_of_type_Acms.a(kvx.a(BaseApplicationImpl.getContext()), bool1, this.jdField_e_of_type_Boolean, false);
        }
      }
      if (j != 2) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.d();
      return;
    }
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if ((kvx.a(BaseApplicationImpl.getContext())) || (aciy.b())) {}
    label234:
    label236:
    do
    {
      do
      {
        for (;;)
        {
          return;
          if (paramSensorEvent.values[0] < this.jdField_g_of_type_Float) {}
          for (boolean bool1 = true;; bool1 = false)
          {
            if (((!AudioHelper.c()) && (bool1) && (!this.jdField_a_of_type_Boolean)) || (this.jdField_f_of_type_Boolean == bool1) || (!b())) {
              break label234;
            }
            boolean bool2 = kvx.a(BaseApplicationImpl.getContext());
            boolean bool3 = AudioHelper.a(BaseApplicationImpl.getContext());
            this.jdField_f_of_type_Boolean = bool1;
            if (QLog.isColorLevel()) {
              QLog.d("MediaPlayerManager", 2, "ProximityEventListener$onSensorChanged | currentSpeaker = " + this.jdField_e_of_type_Boolean + " | mNearToEar = " + this.jdField_f_of_type_Boolean + " | wiredHeadsetConnected = " + bool2 + " | btHeadsetConnect = " + bool3);
            }
            if ((bool2) || (bool3)) {
              break;
            }
            if ((!this.jdField_f_of_type_Boolean) || (!this.jdField_e_of_type_Boolean)) {
              break label236;
            }
            this.jdField_e_of_type_Boolean = false;
            this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_e_of_type_Boolean, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b() - jdField_a_of_type_Int);
            if (this.jdField_a_of_type_Acms == null) {
              break;
            }
            this.jdField_a_of_type_Acms.c(this.jdField_f_of_type_Boolean, this.jdField_e_of_type_Boolean);
            return;
          }
        }
        if (!this.jdField_f_of_type_Boolean) {
          break;
        }
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_e_of_type_Boolean, true, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b() - jdField_a_of_type_Int);
      } while (this.jdField_a_of_type_Acms == null);
      this.jdField_a_of_type_Acms.c(this.jdField_f_of_type_Boolean, this.jdField_e_of_type_Boolean);
      return;
    } while ((this.jdField_f_of_type_Boolean) || (this.jdField_e_of_type_Boolean));
    if (c()) {}
    for (this.jdField_e_of_type_Boolean = true;; this.jdField_e_of_type_Boolean = ((QQAppInterface)this.jdField_a_of_type_MqqUtilWeakReference.get()).t()) {
      do
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.a(this.jdField_e_of_type_Boolean, false, this.jdField_a_of_type_ComTencentMobileqqActivityAioAudioPlayer.b() - jdField_a_of_type_Int);
        if (this.jdField_a_of_type_Acms == null) {
          break;
        }
        this.jdField_a_of_type_Acms.c(this.jdField_f_of_type_Boolean, this.jdField_e_of_type_Boolean);
        return;
      } while ((this.jdField_a_of_type_MqqUtilWeakReference == null) || (this.jdField_a_of_type_MqqUtilWeakReference.get() == null));
    }
  }
  
  public void run()
  {
    if ((this.jdField_b_of_type_AndroidHardwareSensor != null) && (this.jdField_a_of_type_AndroidHardwareSensor != null)) {}
    try
    {
      this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this.jdField_a_of_type_Acmq, this.jdField_b_of_type_AndroidHardwareSensor, 3);
      if (this.jdField_a_of_type_AndroidHardwareSensor == null) {}
    }
    catch (Exception localException1)
    {
      try
      {
        this.jdField_a_of_type_AndroidHardwareSensorManager.registerListener(this, this.jdField_a_of_type_AndroidHardwareSensor, 3);
        if (QLog.isColorLevel()) {
          QLog.d("MediaPlayerManager", 2, "$requestPlay| mAccelerationSensro=" + this.jdField_b_of_type_AndroidHardwareSensor + " | mProximitySensor = " + this.jdField_a_of_type_AndroidHardwareSensor);
        }
        return;
        localException1 = localException1;
        localException1.printStackTrace();
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          localException2.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.MediaPlayerManager
 * JD-Core Version:    0.7.0.1
 */