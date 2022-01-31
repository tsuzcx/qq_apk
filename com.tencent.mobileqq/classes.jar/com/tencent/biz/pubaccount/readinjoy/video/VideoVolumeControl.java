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
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.WeakHashMap;
import mey;
import mez;
import mfa;
import mfb;
import mfc;
import mqq.util.WeakReference;

public class VideoVolumeControl
{
  private static VideoVolumeControl jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl;
  private int jdField_a_of_type_Int = -1;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private Runnable jdField_a_of_type_JavaLangRunnable = new mey(this);
  private String jdField_a_of_type_JavaLangString;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap = new WeakHashMap();
  private Timer jdField_a_of_type_JavaUtilTimer;
  private mfa jdField_a_of_type_Mfa;
  private mfb jdField_a_of_type_Mfb;
  private mfc jdField_a_of_type_Mfc;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "";
  private Map jdField_b_of_type_JavaUtilMap = new WeakHashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = true;
  private int jdField_d_of_type_Int;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  private boolean f;
  private boolean g = true;
  private boolean h;
  private boolean i = true;
  private boolean j;
  private boolean k;
  private boolean l = true;
  private boolean m;
  
  /* Error */
  public static VideoVolumeControl a()
  {
    // Byte code:
    //   0: getstatic 101	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   3: ifnull +7 -> 10
    //   6: getstatic 101	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   9: areturn
    //   10: ldc 2
    //   12: monitorenter
    //   13: getstatic 101	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   16: ifnonnull +13 -> 29
    //   19: new 2	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl
    //   22: dup
    //   23: invokespecial 102	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:<init>	()V
    //   26: putstatic 101	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   29: getstatic 101	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   32: iconst_1
    //   33: putfield 36	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_Boolean	Z
    //   36: getstatic 101	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   39: getstatic 101	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   42: getfield 36	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_Boolean	Z
    //   45: putfield 38	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_b_of_type_Boolean	Z
    //   48: ldc 2
    //   50: monitorexit
    //   51: getstatic 101	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl;
    //   54: areturn
    //   55: astore_0
    //   56: ldc 104
    //   58: iconst_1
    //   59: ldc 106
    //   61: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: goto -16 -> 48
    //   67: astore_0
    //   68: ldc 2
    //   70: monitorexit
    //   71: aload_0
    //   72: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   55	1	0	localException	Exception
    //   67	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	48	55	java/lang/Exception
    //   13	29	67	finally
    //   29	48	67	finally
    //   48	51	67	finally
    //   56	64	67	finally
    //   68	71	67	finally
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
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilTimer == null) {
      this.jdField_a_of_type_JavaUtilTimer = new Timer();
    }
    this.i = false;
    this.jdField_a_of_type_JavaUtilTimer.schedule(new mez(this), 2000L);
  }
  
  public void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "errParam");
    }
    do
    {
      return;
      this.jdField_a_of_type_JavaLangString = paramActivity.getClass().getName();
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "activity : " + paramActivity);
      if ("".equals(this.jdField_b_of_type_JavaLangString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "inKandianModule origin:" + this.jdField_b_of_type_JavaLangString + " act:" + paramActivity.getClass().getName());
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "real inKandianModule origin:" + this.jdField_b_of_type_JavaLangString + " act:" + paramActivity.getClass().getName());
    }
    this.jdField_b_of_type_JavaLangString = paramActivity.getClass().getName();
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
    this.jdField_a_of_type_Mfc = new mfc(this, null);
    paramActivity = new IntentFilter();
    paramActivity.addAction("android.media.VOLUME_CHANGED_ACTION");
    paramActivity.addAction("android.intent.action.HEADSET_PLUG");
    paramActivity.addAction("android.media.AUDIO_BECOMING_NOISY");
    paramActivity.addAction("android.media.RINGER_MODE_CHANGED");
    this.l = true;
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.jdField_a_of_type_Mfc, paramActivity);
    paramActivity = (TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone");
    this.jdField_a_of_type_Mfa = new mfa(this);
    paramActivity.listen(this.jdField_a_of_type_Mfa, 32);
    this.jdField_a_of_type_Mfb = new mfb(this);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
    this.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  public void a(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if (paramVideoFeedsPlayManager != null)
    {
      paramVideoFeedsPlayManager.d(a(false));
      if (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramVideoFeedsPlayManager)) {
        this.jdField_b_of_type_JavaUtilMap.put(paramVideoFeedsPlayManager, Boolean.valueOf(true));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "addVideoMgr :" + paramVideoFeedsPlayManager + " list:" + this.jdField_b_of_type_JavaUtilMap);
    }
  }
  
  public void a(VideoPlayManager paramVideoPlayManager)
  {
    if (paramVideoPlayManager != null)
    {
      paramVideoPlayManager.b(b());
      if (!this.jdField_a_of_type_JavaUtilMap.containsKey(paramVideoPlayManager)) {
        this.jdField_a_of_type_JavaUtilMap.put(paramVideoPlayManager, Boolean.valueOf(true));
      }
      paramVideoPlayManager.a(this.jdField_a_of_type_Mfb);
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
    //   4: putfield 144	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:k	Z
    //   7: aload_0
    //   8: getfield 72	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   11: ifnull +82 -> 93
    //   14: aload_0
    //   15: getfield 86	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   18: ifnull +75 -> 93
    //   21: invokestatic 194	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   24: ifeq +39 -> 63
    //   27: ldc 104
    //   29: iconst_2
    //   30: new 129	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 304
    //   40: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_1
    //   44: invokevirtual 307	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: ldc_w 309
    //   50: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_2
    //   54: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 111	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: aload_0
    //   64: getfield 72	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   67: aload_0
    //   68: getfield 86	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   71: invokevirtual 313	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   74: aload_0
    //   75: getfield 144	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:k	Z
    //   78: ifeq +18 -> 96
    //   81: aload_0
    //   82: getfield 72	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   85: aload_0
    //   86: getfield 86	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   89: invokevirtual 317	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   92: pop
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: aload_0
    //   97: getfield 72	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   100: aload_0
    //   101: getfield 86	com/tencent/biz/pubaccount/readinjoy/video/VideoVolumeControl:jdField_a_of_type_JavaLangRunnable	Ljava/lang/Runnable;
    //   104: ldc2_w 160
    //   107: invokevirtual 321	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
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
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "setMute :" + paramBoolean + " reason:" + paramString + " what:" + paramInt);
    }
    this.jdField_d_of_type_Int = paramInt;
    int n;
    if ((paramInt == 1) || (paramInt == 0))
    {
      paramString = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      Object localObject;
      for (n = 0; paramString.hasNext(); n = ((VideoPlayManager)localObject).a() | n)
      {
        localObject = (VideoPlayManager)paramString.next();
        if (localObject == null) {
          break label402;
        }
        ((VideoPlayManager)localObject).b(paramBoolean);
      }
      this.jdField_c_of_type_Boolean = paramBoolean;
      label145:
      if ((paramInt == 2) || (paramInt == 0))
      {
        paramString = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
        for (paramInt = n; paramString.hasNext(); paramInt = ((VideoFeedsPlayManager)localObject).c() | paramInt)
        {
          localObject = (VideoFeedsPlayManager)paramString.next();
          if (localObject == null) {
            break label399;
          }
          ((VideoFeedsPlayManager)localObject).d(paramBoolean);
        }
        label211:
        this.jdField_d_of_type_Boolean = paramBoolean;
      }
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
            break label411;
          }
          if (!paramBoolean) {
            break label357;
          }
          ((ImageView)paramString.get()).setImageDrawable(((ImageView)paramString.get()).getResources().getDrawable(2130840851));
          ((ImageView)paramString.get()).setContentDescription("取消静音");
        }
      }
      catch (Exception paramString)
      {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 1, "failed to update volume view:" + paramString.toString());
      }
      return;
      label357:
      ((ImageView)paramString.get()).setImageDrawable(((ImageView)paramString.get()).getResources().getDrawable(2130840852));
      ((ImageView)paramString.get()).setContentDescription("静音");
      break label411;
      label399:
      break label211;
      label402:
      break;
      n = 0;
      break label145;
      label411:
      paramInt += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.jdField_d_of_type_Boolean;
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3) > 0) {}
    for (paramBoolean = false;; paramBoolean = true)
    {
      this.jdField_d_of_type_Boolean = paramBoolean;
      return this.jdField_d_of_type_Boolean;
    }
  }
  
  public void b()
  {
    if (!this.e) {
      a(this.jdField_a_of_type_Boolean, "start auto play", 1);
    }
  }
  
  public void b(Activity paramActivity)
  {
    if (this.jdField_b_of_type_JavaLangString.equals(paramActivity.getClass().getName()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "really outKandianModule origin is:" + this.jdField_b_of_type_JavaLangString + " act:" + paramActivity.getClass().getName());
      }
      if (this.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
      }
      if (!"".equals(this.jdField_b_of_type_JavaLangString))
      {
        BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(this.jdField_a_of_type_Mfc);
        ((TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone")).listen(this.jdField_a_of_type_Mfa, 0);
      }
      this.jdField_a_of_type_Mfa = null;
      this.jdField_a_of_type_Mfb = null;
      this.jdField_a_of_type_Mfc = null;
      this.jdField_b_of_type_JavaLangString = "";
      this.jdField_a_of_type_AndroidMediaAudioManager = null;
      if (!this.f)
      {
        a(false, "outKandianModule", 2);
        a(this.jdField_a_of_type_Boolean, "outKandianModule", 1);
        this.e = false;
        if (this.jdField_a_of_type_JavaUtilArrayList != null) {
          this.jdField_a_of_type_JavaUtilArrayList.clear();
        }
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
    QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "outKandianModule origin:" + this.jdField_b_of_type_JavaLangString + " act:" + paramActivity.getClass().getName());
  }
  
  public void b(VideoFeedsPlayManager paramVideoFeedsPlayManager)
  {
    if (paramVideoFeedsPlayManager != null) {
      this.jdField_b_of_type_JavaUtilMap.remove(paramVideoFeedsPlayManager);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "removeVideoMgr :" + paramVideoFeedsPlayManager + " list:" + this.jdField_b_of_type_JavaUtilMap);
    }
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
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.j = paramBoolean;
  }
  
  public boolean c()
  {
    return !this.e;
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        localObject = (VideoPlayManager)localIterator.next();
        if ((localObject != null) && (((VideoPlayManager)localObject).a()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayStateWhenPhoneCome:" + localObject);
          }
          if (((VideoPlayManager)localObject).a() != 5) {
            ((VideoPlayManager)localObject).a(true);
          }
          ((VideoPlayManager)localObject).a();
        }
      }
      localIterator = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        localObject = (VideoFeedsPlayManager)localIterator.next();
        if ((localObject != null) && (((VideoFeedsPlayManager)localObject).c()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video.VideoVolumeControl", 2, "checkPlayStateWhenPhoneCome:" + localObject);
          }
          if (((VideoFeedsPlayManager)localObject).a() != 5) {
            ((VideoFeedsPlayManager)localObject).a(true);
          }
          ((VideoFeedsPlayManager)localObject).c();
        }
      }
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.f = paramBoolean;
    if (paramBoolean) {
      this.g = true;
    }
  }
  
  public void f(boolean paramBoolean)
  {
    this.h = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl
 * JD-Core Version:    0.7.0.1
 */