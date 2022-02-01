package com.tencent.biz.pubaccount.readinjoy.video;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;

public class VideoVolumeController
{
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private VideoVolumeController.MyPhoneStateListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeController$MyPhoneStateListener;
  private VideoVolumeController.VolumeReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeController$VolumeReceiver;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VideoVolumeController.1(this);
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<VideoVolumeController.EventListener> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = true;
  private boolean c = false;
  private boolean d = true;
  private boolean e = false;
  
  public static final VideoVolumeController a()
  {
    return VideoVolumeController.VideoVolumeControllerHolder.a();
  }
  
  public float a()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      return this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3) / this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(3);
    }
    return 0.0F;
  }
  
  public int a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      return this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(paramInt);
    }
    return 0;
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      this.jdField_a_of_type_AndroidMediaAudioManager.adjustStreamVolume(3, paramInt, 0);
    }
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoVolumeController", 2, "inKandianModule: context:" + paramContext);
      }
      a(Integer.toHexString(System.identityHashCode(paramContext)));
    }
  }
  
  public void a(VideoVolumeController.EventListener paramEventListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramEventListener);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoVolumeController", 2, "inKandianModule: hexString:" + paramString);
    }
    if (!"".equals(this.jdField_a_of_type_JavaLangString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoVolumeController", 2, "inKandianModule origin:" + this.jdField_a_of_type_JavaLangString + " act:" + paramString);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoVolumeController", 2, "real inKandianModule origin:" + this.jdField_a_of_type_JavaLangString + " act:" + paramString);
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeController$VolumeReceiver = new VideoVolumeController.VolumeReceiver(this, null);
    paramString = new IntentFilter();
    paramString.addAction("android.media.VOLUME_CHANGED_ACTION");
    paramString.addAction("android.intent.action.HEADSET_PLUG");
    paramString.addAction("android.media.AUDIO_BECOMING_NOISY");
    paramString.addAction("android.media.RINGER_MODE_CHANGED");
    this.d = true;
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeController$VolumeReceiver, paramString);
    paramString = (TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone");
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeController$MyPhoneStateListener = new VideoVolumeController.MyPhoneStateListener(this);
    paramString.listen(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeController$MyPhoneStateListener, 32);
  }
  
  void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((VideoVolumeController.EventListener)localIterator.next()).onPhoneCome();
      }
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield 51	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeController:c	Z
    //   7: aload_0
    //   8: getfield 49	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeController:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   11: ifnull +80 -> 91
    //   14: aload_0
    //   15: getfield 58	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeController:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   18: ifnull +73 -> 91
    //   21: invokestatic 99	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +37 -> 61
    //   27: ldc 101
    //   29: iconst_2
    //   30: new 103	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   37: ldc 231
    //   39: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload_1
    //   43: invokevirtual 234	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   46: ldc 236
    //   48: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_2
    //   52: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   61: aload_0
    //   62: getfield 49	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeController:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   65: aload_0
    //   66: getfield 58	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeController:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   69: invokevirtual 240	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   72: aload_0
    //   73: getfield 51	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeController:c	Z
    //   76: ifeq +18 -> 94
    //   79: aload_0
    //   80: getfield 49	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeController:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   83: aload_0
    //   84: getfield 58	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeController:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   87: invokevirtual 244	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   90: pop
    //   91: aload_0
    //   92: monitorexit
    //   93: return
    //   94: aload_0
    //   95: getfield 49	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeController:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   98: aload_0
    //   99: getfield 58	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeController:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   102: ldc2_w 245
    //   105: invokevirtual 250	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   108: pop
    //   109: goto -18 -> 91
    //   112: astore_2
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_2
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	VideoVolumeController
    //   0	117	1	paramBoolean	boolean
    //   0	117	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	61	112	finally
    //   61	91	112	finally
    //   94	109	112	finally
  }
  
  public void b(Context paramContext)
  {
    if (paramContext != null) {
      b(Integer.toHexString(System.identityHashCode(paramContext)));
    }
  }
  
  public void b(VideoVolumeController.EventListener paramEventListener)
  {
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramEventListener);
  }
  
  public void b(String paramString)
  {
    if (this.jdField_a_of_type_JavaLangString.equals(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoVolumeController", 2, "really outKandianModule origin is:" + this.jdField_a_of_type_JavaLangString + " act:" + paramString);
      }
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
      }
      if (!"".equals(this.jdField_a_of_type_JavaLangString))
      {
        BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeController$VolumeReceiver);
        ((TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone")).listen(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeController$MyPhoneStateListener, 0);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeController$MyPhoneStateListener = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeController$VolumeReceiver = null;
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_AndroidMediaAudioManager = null;
      if (this.jdField_a_of_type_JavaUtilTimer != null)
      {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        this.jdField_a_of_type_JavaUtilTimer.purge();
        this.jdField_a_of_type_JavaUtilTimer = null;
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("VideoVolumeController", 2, "outKandianModule origin:" + this.jdField_a_of_type_JavaLangString + " act:" + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeController
 * JD-Core Version:    0.7.0.1
 */