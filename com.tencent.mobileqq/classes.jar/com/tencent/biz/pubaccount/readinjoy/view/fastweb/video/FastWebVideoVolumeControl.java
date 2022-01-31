package com.tencent.biz.pubaccount.readinjoy.view.fastweb.video;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.telephony.TelephonyManager;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.WeakHashMap;
import mqq.util.WeakReference;
import mtm;
import mtn;

public class FastWebVideoVolumeControl
{
  private static FastWebVideoVolumeControl jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoVolumeControl;
  private int jdField_a_of_type_Int = -1;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Map jdField_a_of_type_JavaUtilMap = new WeakHashMap();
  private Timer jdField_a_of_type_JavaUtilTimer;
  private mtm jdField_a_of_type_Mtm;
  private mtn jdField_a_of_type_Mtn;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = -1;
  private Map jdField_b_of_type_JavaUtilMap = new WeakHashMap();
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f = true;
  private boolean g;
  private boolean h = true;
  private boolean i;
  private boolean j = true;
  private boolean k;
  
  /* Error */
  public static FastWebVideoVolumeControl a()
  {
    // Byte code:
    //   0: getstatic 87	com/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl;
    //   3: ifnull +7 -> 10
    //   6: getstatic 87	com/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl;
    //   9: areturn
    //   10: ldc 2
    //   12: monitorenter
    //   13: getstatic 87	com/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl;
    //   16: ifnonnull +13 -> 29
    //   19: new 2	com/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl
    //   22: dup
    //   23: invokespecial 88	com/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl:<init>	()V
    //   26: putstatic 87	com/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl;
    //   29: getstatic 87	com/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl;
    //   32: iconst_1
    //   33: putfield 32	com/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl:jdField_a_of_type_Boolean	Z
    //   36: getstatic 87	com/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl;
    //   39: getstatic 87	com/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl;
    //   42: getfield 32	com/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl:jdField_a_of_type_Boolean	Z
    //   45: putfield 34	com/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl:jdField_b_of_type_Boolean	Z
    //   48: ldc 2
    //   50: monitorexit
    //   51: getstatic 87	com/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl:jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebVideoFastWebVideoVolumeControl	Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/video/FastWebVideoVolumeControl;
    //   54: areturn
    //   55: astore_0
    //   56: ldc 90
    //   58: iconst_1
    //   59: ldc 92
    //   61: invokestatic 97	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
  
  public void a(Activity paramActivity)
  {
    if (paramActivity == null) {
      QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "errParam");
    }
    do
    {
      return;
      QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "activity : " + paramActivity);
      if ("".equals(this.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "inKandianModule origin:" + this.jdField_a_of_type_JavaLangString + " act:" + paramActivity.getClass().getName());
    return;
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "real inKandianModule origin:" + this.jdField_a_of_type_JavaLangString + " act:" + paramActivity.getClass().getName());
    }
    this.jdField_a_of_type_JavaLangString = paramActivity.getClass().getName();
    this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("audio"));
    this.jdField_a_of_type_Mtn = new mtn(this, null);
    paramActivity = new IntentFilter();
    paramActivity.addAction("android.media.VOLUME_CHANGED_ACTION");
    paramActivity.addAction("android.intent.action.HEADSET_PLUG");
    paramActivity.addAction("android.media.AUDIO_BECOMING_NOISY");
    paramActivity.addAction("android.media.RINGER_MODE_CHANGED");
    this.j = true;
    BaseApplicationImpl.getApplication().getBaseContext().registerReceiver(this.jdField_a_of_type_Mtn, paramActivity);
    paramActivity = (TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone");
    this.jdField_a_of_type_Mtm = new mtm(this);
    paramActivity.listen(this.jdField_a_of_type_Mtm, 32);
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getRingerMode();
    this.jdField_b_of_type_Int = this.jdField_a_of_type_Int;
  }
  
  public void a(ImageView paramImageView)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(new WeakReference(paramImageView));
  }
  
  public void a(FastWebVideoFeedsPlayManager paramFastWebVideoFeedsPlayManager)
  {
    if (paramFastWebVideoFeedsPlayManager != null)
    {
      paramFastWebVideoFeedsPlayManager.d(a());
      if (!this.jdField_b_of_type_JavaUtilMap.containsKey(paramFastWebVideoFeedsPlayManager)) {
        this.jdField_b_of_type_JavaUtilMap.put(paramFastWebVideoFeedsPlayManager, Boolean.valueOf(true));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "addVideoMgr :" + paramFastWebVideoFeedsPlayManager + " list:" + this.jdField_b_of_type_JavaUtilMap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (!this.d) {
      this.d = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "setMute :" + paramBoolean + " reason:" + paramString + " what:" + paramInt);
    }
    int m;
    if (this.jdField_a_of_type_AndroidMediaAudioManager != null)
    {
      m = this.jdField_a_of_type_AndroidMediaAudioManager.getStreamVolume(3);
      if ((paramBoolean) || (m != 0)) {}
    }
    this.jdField_c_of_type_Int = paramInt;
    int n;
    if ((paramInt == 1) || (paramInt == 0))
    {
      paramString = this.jdField_a_of_type_JavaUtilMap.keySet().iterator();
      Object localObject;
      for (m = 0; paramString.hasNext(); n = ((VideoPlayManager)localObject).a() | m)
      {
        localObject = (VideoPlayManager)paramString.next();
        if (localObject == null) {
          break label445;
        }
        ((VideoPlayManager)localObject).b(paramBoolean);
      }
      label166:
      if ((paramInt == 2) || (paramInt == 0))
      {
        paramString = this.jdField_b_of_type_JavaUtilMap.keySet().iterator();
        for (paramInt = n; paramString.hasNext(); paramInt = ((FastWebVideoFeedsPlayManager)localObject).c() | paramInt)
        {
          localObject = (FastWebVideoFeedsPlayManager)paramString.next();
          if (localObject == null) {
            break label442;
          }
          ((FastWebVideoFeedsPlayManager)localObject).d(paramBoolean);
        }
        label232:
        this.jdField_c_of_type_Boolean = paramBoolean;
      }
      if ((!paramBoolean) && (this.jdField_a_of_type_AndroidMediaAudioManager != null)) {
        this.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(null, 3, 2);
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
            break label454;
          }
          if (!paramBoolean) {
            break label400;
          }
          ((ImageView)paramString.get()).setImageDrawable(((ImageView)paramString.get()).getResources().getDrawable(2130840905));
          ((ImageView)paramString.get()).setContentDescription("取消静音");
        }
      }
      catch (Exception paramString)
      {
        QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 1, "failed to update volume view:" + paramString.toString());
      }
      return;
      label400:
      ((ImageView)paramString.get()).setImageDrawable(((ImageView)paramString.get()).getResources().getDrawable(2130840906));
      ((ImageView)paramString.get()).setContentDescription("静音");
      break label454;
      label442:
      break label232;
      label445:
      break;
      n = 0;
      break label166;
      label454:
      paramInt += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b(Activity paramActivity)
  {
    if (this.jdField_a_of_type_JavaLangString.equals(paramActivity.getClass().getName()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "really outKandianModule origin:" + this.jdField_a_of_type_JavaLangString + " act:" + paramActivity.getClass().getName());
      }
      if ((this.e) || ("koobee".equalsIgnoreCase(Build.MANUFACTURER))) {}
    }
    try
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(null);
      label95:
      if (!"".equals(this.jdField_a_of_type_JavaLangString))
      {
        BaseApplicationImpl.getApplication().getBaseContext().unregisterReceiver(this.jdField_a_of_type_Mtn);
        ((TelephonyManager)BaseApplicationImpl.getApplication().getBaseContext().getSystemService("phone")).listen(this.jdField_a_of_type_Mtm, 0);
      }
      this.jdField_a_of_type_Mtm = null;
      this.jdField_a_of_type_Mtn = null;
      this.jdField_a_of_type_JavaLangString = "";
      this.jdField_a_of_type_AndroidMediaAudioManager = null;
      if (!this.e)
      {
        a(false, "outKandianModule", 2);
        a(this.jdField_a_of_type_Boolean, "outKandianModule", 1);
        this.d = false;
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
      do
      {
        return;
        this.e = false;
        this.f = false;
        break;
      } while (!QLog.isColorLevel());
      QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "outKandianModule origin:" + this.jdField_a_of_type_JavaLangString + " act:" + paramActivity.getClass().getName());
      return;
    }
    catch (Exception localException)
    {
      break label95;
    }
  }
  
  public void b(boolean paramBoolean)
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
            QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "checkPlayStateWhenPhoneCome:" + localObject);
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
        localObject = (FastWebVideoFeedsPlayManager)localIterator.next();
        if ((localObject != null) && (((FastWebVideoFeedsPlayManager)localObject).c()))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.readinjoy.video.FastWebVideoVolumeControl", 2, "checkPlayStateWhenPhoneCome:" + localObject);
          }
          if (((FastWebVideoFeedsPlayManager)localObject).a() != 5) {
            ((FastWebVideoFeedsPlayManager)localObject).a(true);
          }
          ((FastWebVideoFeedsPlayManager)localObject).c();
        }
      }
    }
  }
  
  public boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
    if (paramBoolean) {
      this.f = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.video.FastWebVideoVolumeControl
 * JD-Core Version:    0.7.0.1
 */