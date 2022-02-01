package com.tencent.biz.pubaccount.readinjoy.video;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.WeakHashMap;
import mqq.util.WeakReference;

public class VideoVolumeControl
{
  private static VideoVolumeControl jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl;
  private int jdField_a_of_type_Int = -1;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private VideoVolumeControl.MyPhoneStateListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl$MyPhoneStateListener;
  private VideoVolumeControl.VideoStateListener jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl$VideoStateListener;
  private VideoVolumeControl.VolumeReceiver jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl$VolumeReceiver;
  private Runnable jdField_a_of_type_JavaLangRunnable = new VideoVolumeControl.1(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList<WeakReference<ImageView>> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map<VideoPlayManager, Boolean> jdField_a_of_type_JavaUtilMap = new WeakHashMap();
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "";
  private Map<VideoFeedsPlayManager, Boolean> jdField_b_of_type_JavaUtilMap = new WeakHashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int = 0;
  private boolean jdField_d_of_type_Boolean = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = true;
  private boolean h = false;
  private boolean i = true;
  private boolean j = false;
  private boolean k = false;
  private boolean l = true;
  private boolean m = false;
  
  public static VideoVolumeControl a()
  {
    if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl == null) {
        jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl = new VideoVolumeControl();
      }
      return jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl;
    }
    finally {}
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      int n = ((TelephonyManager)paramContext.getSystemService("phone")).getCallState();
      return (n == 1) || (n == 2);
    }
    catch (Exception paramContext)
    {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 1, "obtain inCall info failed " + paramContext.toString());
    }
    return false;
  }
  
  public float a()
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
      return this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3) / this.jdField_a_of_type_AndroidMediaAudioManager.getStreamMaxVolume(3);
    }
    return 0.0F;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilTimer == null) {
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
    }
    this.i = false;
    this.jdField_a_of_type_JavaUtilTimer.schedule(new VideoVolumeControl.3(this), 2000L);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.adjustStreamVolume(3, paramInt, 0);
      if (this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3) == 0) {
        a(true, "system volume 0", this.jdField_d_of_type_Int);
      }
    }
    else
    {
      return;
    }
    a(false, "system volume change", this.jdField_d_of_type_Int);
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "inKandianModule errParam，activity == null");
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramActivity.toString();
      if ("".equals(this.jdField_b_of_type_JavaLangString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "inKandianModule origin:" + this.jdField_b_of_type_JavaLangString + " act:" + paramActivity.toString());
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "real inKandianModule origin:" + this.jdField_b_of_type_JavaLangString + " act:" + paramActivity.toString());
    }
    this.jdField_b_of_type_JavaLangString = paramActivity.toString();
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl$VolumeReceiver == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl$VolumeReceiver = new VideoVolumeControl.VolumeReceiver(this, null);
    }
    paramActivity = new IntentFilter();
    paramActivity.addAction("android.media.VOLUME_CHANGED_ACTION");
    paramActivity.addAction("android.intent.action.HEADSET_PLUG");
    paramActivity.addAction("android.media.AUDIO_BECOMING_NOISY");
    paramActivity.addAction("android.media.RINGER_MODE_CHANGED");
    this.l = true;
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl$VolumeReceiver, paramActivity);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl$MyPhoneStateListener == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl$MyPhoneStateListener = new VideoVolumeControl.MyPhoneStateListener(this);
    }
    ThreadManager.excute(new VideoVolumeControl.2(this), 16, null, true);
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl$VideoStateListener == null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl$VideoStateListener = new VideoVolumeControl.VideoStateListener(this);
    }
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode();
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  public void a(ImageView paramImageView)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramImageView));
  }
  
  public void a(VideoPlayManager paramVideoPlayManager)
  {
    if (paramVideoPlayManager != null)
    {
      paramVideoPlayManager.c(b());
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramVideoPlayManager)) {
        this.jdField_a_of_type_JavaUtilMap.put(paramVideoPlayManager, Boolean.valueOf(true));
      }
      paramVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl$VideoStateListener);
      this.jdField_d_of_type_Int = 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "addVideoManager :" + paramVideoPlayManager + " list:" + this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  /* Error */
  public void a(boolean paramBoolean, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_1
    //   4: putfield 96	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:k	Z
    //   7: aload_0
    //   8: getfield 87	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   11: ifnull +82 -> 93
    //   14: aload_0
    //   15: getfield 103	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   18: ifnull +75 -> 93
    //   21: invokestatic 214	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +39 -> 63
    //   27: ldc 141
    //   29: iconst_2
    //   30: new 143	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 144	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 323
    //   40: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_1
    //   44: invokevirtual 326	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: ldc_w 328
    //   50: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_2
    //   54: invokevirtual 150	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 155	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 160	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: aload_0
    //   64: getfield 87	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   67: aload_0
    //   68: getfield 103	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   71: invokevirtual 332	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   74: aload_0
    //   75: getfield 96	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:k	Z
    //   78: ifeq +18 -> 96
    //   81: aload_0
    //   82: getfield 87	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   85: aload_0
    //   86: getfield 103	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   89: invokevirtual 336	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   92: pop
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: aload_0
    //   97: getfield 87	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   100: aload_0
    //   101: getfield 103	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   104: ldc2_w 181
    //   107: invokevirtual 340	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   110: pop
    //   111: goto -18 -> 93
    //   114: astore_2
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_2
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	VideoVolumeControl
    //   0	119	1	paramBoolean	boolean
    //   0	119	2	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	63	114	finally
    //   63	93	114	finally
    //   96	111	114	finally
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!this.e) {
      this.e = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "setMute :" + paramBoolean + ", oldValue:" + this.jdField_b_of_type_Boolean + " reason:" + paramString + " what:" + paramInt);
    }
    label153:
    label241:
    int n;
    if ((paramInt == 1) || (paramInt == 0))
    {
      paramString = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      Object localObject;
      for (boolean bool1 = false; paramString.hasNext(); bool1 = ((VideoPlayManager)localObject).b() | bool1)
      {
        localObject = (VideoPlayManager)paramString.next();
        if (localObject == null) {
          break label450;
        }
        ((VideoPlayManager)localObject).c(paramBoolean);
      }
      this.jdField_c_of_type_Boolean = paramBoolean;
      if (bool1) {
        if (this.jdField_c_of_type_Boolean) {
          break label247;
        }
      }
      label247:
      for (boolean bool2 = true;; bool2 = false)
      {
        a(bool2, "by user click mute btn ");
        if ((paramInt != 2) && (paramInt != 0)) {
          break label258;
        }
        paramString = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
        while (paramString.hasNext())
        {
          localObject = (VideoFeedsPlayManager)paramString.next();
          if (localObject == null) {
            break label444;
          }
          ((VideoFeedsPlayManager)localObject).d(paramBoolean);
          paramInt = ((VideoFeedsPlayManager)localObject).d() | bool1;
          n = paramInt;
        }
      }
      this.jdField_d_of_type_Boolean = paramBoolean;
      label258:
      this.jdField_b_of_type_Boolean = paramBoolean;
      if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        paramInt = 0;
      }
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          paramString = (WeakReference)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
          if ((paramString == null) || (paramString.get() == null)) {
            break label459;
          }
          if (!paramBoolean) {
            break label399;
          }
          ((ImageView)paramString.get()).setImageDrawable(((ImageView)paramString.get()).getResources().getDrawable(2130843267));
          ((ImageView)paramString.get()).setContentDescription(HardCodeUtil.a(2131716281));
        }
      }
      catch (Exception paramString)
      {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 1, "failed to update volume view:" + paramString.toString());
      }
      return;
      label399:
      ((ImageView)paramString.get()).setImageDrawable(((ImageView)paramString.get()).getResources().getDrawable(2130843268));
      ((ImageView)paramString.get()).setContentDescription(HardCodeUtil.a(2131716282));
      break label459;
      label444:
      paramInt = n;
      break label241;
      label450:
      break;
      n = 0;
      break label153;
      label459:
      paramInt += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    if (!this.e) {
      a(this.jdField_a_of_type_Boolean, "start auto play", 1);
    }
  }
  
  public void b(Activity paramActivity)
  {
    if (this.jdField_b_of_type_JavaLangString.equals(paramActivity.toString()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "really outKandianModule origin is:" + this.jdField_b_of_type_JavaLangString + " act:" + paramActivity.toString() + ",formDynamicTo1T3:" + this.f);
      }
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
      }
      if (!"".equals(this.jdField_b_of_type_JavaLangString))
      {
        BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl$VolumeReceiver);
        ThreadManager.excute(new VideoVolumeControl.4(this), 16, null, true);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl$VideoStateListener = null;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl$VolumeReceiver = null;
      this.jdField_b_of_type_JavaLangString = "";
      this.jdField_a_of_type_AndroidMediaAudioManager = null;
      if (!this.f)
      {
        a(false, "outKandianModule", 2);
        a(this.jdField_a_of_type_Boolean, "outKandianModule", 1);
        this.e = false;
        if ((paramActivity instanceof ReadInJoyNewFeedsActivity)) {
          ImageManager.a().a();
        }
        if (this.jdField_a_of_type_JavaUtilTimer != null)
        {
          this.jdField_a_of_type_JavaUtilTimer.cancel();
          this.jdField_a_of_type_JavaUtilTimer.purge();
          this.jdField_a_of_type_JavaUtilTimer = null;
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return;
        this.f = false;
        this.g = false;
      }
    }
    QLog.w("Q.readinjoy.video.VideoVolumeControl", 2, "outKandianModule origin:" + this.jdField_b_of_type_JavaLangString + " act:" + paramActivity.toString());
  }
  
  public void b(VideoPlayManager paramVideoPlayManager)
  {
    if (paramVideoPlayManager != null) {
      this.jdField_a_of_type_JavaUtilMap.remove(paramVideoPlayManager);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "removeVideoManager :" + paramVideoPlayManager + " list:" + this.jdField_a_of_type_JavaUtilMap);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  void c()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (VideoPlayManager)localIterator.next();
      if (localObject != null) {
        ((VideoPlayManager)localObject).f();
      }
    }
    localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      localObject = (VideoFeedsPlayManager)localIterator.next();
      if (localObject != null) {
        ((VideoFeedsPlayManager)localObject).g();
      }
    }
  }
  
  void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (VideoPlayManager)localIterator.next();
        if ((localObject != null) && (((VideoPlayManager)localObject).b()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayStateWhenPhoneCome:" + localObject);
          }
          if (((VideoPlayManager)localObject).a() != 5) {
            ((VideoPlayManager)localObject).b(true);
          }
          ((VideoPlayManager)localObject).a();
        }
      }
      localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (VideoFeedsPlayManager)localIterator.next();
        if ((localObject != null) && (((VideoFeedsPlayManager)localObject).d()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayStateWhenPhoneCome:" + localObject);
          }
          if (((VideoFeedsPlayManager)localObject).a() != 5) {
            ((VideoFeedsPlayManager)localObject).b(true);
          }
          ((VideoFeedsPlayManager)localObject).b();
        }
      }
    }
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
  
  public boolean d()
  {
    return !this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl
 * JD-Core Version:    0.7.0.1
 */