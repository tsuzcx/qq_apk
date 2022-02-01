package com.tencent.av.smallscreen;

import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.WindowManager.LayoutParams;
import com.tencent.av.VideoController;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.utils.AudioHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppService;

public class BaseSmallScreenService
  extends AppService
  implements SmallScreenRelativeLayout.FloatListener
{
  int jdField_a_of_type_Int = 0;
  Handler jdField_a_of_type_AndroidOsHandler;
  PhoneStateListener jdField_a_of_type_AndroidTelephonyPhoneStateListener = new BaseSmallScreenService.1(this);
  TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
  Runnable jdField_a_of_type_JavaLangRunnable = null;
  boolean jdField_a_of_type_Boolean = true;
  final SmallScreenItemBase[] jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase = new SmallScreenItemBase[4];
  int jdField_b_of_type_Int = 7;
  Runnable jdField_b_of_type_JavaLangRunnable = null;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  boolean jdField_c_of_type_Boolean = false;
  boolean d = false;
  boolean e = true;
  boolean f = false;
  
  public int a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    paramSmallScreenRelativeLayout = a(paramSmallScreenRelativeLayout);
    if (paramSmallScreenRelativeLayout == null) {
      return 0;
    }
    return paramSmallScreenRelativeLayout.a().x;
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  SmallScreenRelativeLayout a(int paramInt)
  {
    SmallScreenItemBase[] arrayOfSmallScreenItemBase = this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase;
    if (arrayOfSmallScreenItemBase[paramInt] != null) {
      return arrayOfSmallScreenItemBase[paramInt].jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout;
    }
    return null;
  }
  
  SmallScreenToast a(int paramInt)
  {
    SmallScreenItemBase[] arrayOfSmallScreenItemBase = this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase;
    if (arrayOfSmallScreenItemBase[paramInt] != null) {
      return arrayOfSmallScreenItemBase[paramInt].jdField_a_of_type_ComTencentAvSmallscreenSmallScreenToast;
    }
    return null;
  }
  
  protected SmallScreenToast a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    int i = 0;
    while (i < 4)
    {
      if (a(i) == paramSmallScreenRelativeLayout) {
        return a(i);
      }
      i += 1;
    }
    return null;
  }
  
  void a()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onIsLockChanged, mIsLock[");
      localStringBuilder.append(this.jdField_c_of_type_Boolean);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w("BaseSmallScreenService", 1, localStringBuilder.toString());
    }
    a(l);
  }
  
  void a(int paramInt, String paramString) {}
  
  void a(long paramLong) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramSmallScreenRelativeLayout = a(paramSmallScreenRelativeLayout);
    if (paramSmallScreenRelativeLayout != null)
    {
      WindowManager.LayoutParams localLayoutParams = paramSmallScreenRelativeLayout.a();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      localLayoutParams.width = (paramInt3 - paramInt1);
      localLayoutParams.height = (paramInt4 - paramInt2);
      paramSmallScreenRelativeLayout.c();
    }
  }
  
  protected boolean a()
  {
    return SmallScreenUtils.f(((AppInterface)this.app).getApp());
  }
  
  public boolean a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    return true;
  }
  
  public int b(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    paramSmallScreenRelativeLayout = a(paramSmallScreenRelativeLayout);
    if (paramSmallScreenRelativeLayout == null) {
      return 0;
    }
    return paramSmallScreenRelativeLayout.a().y;
  }
  
  void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHasSmartBarChanged mHasSmartBar = ");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
      QLog.d("BaseSmallScreenService", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = a(1);
    if (localObject != null) {
      ((SmallScreenRelativeLayout)localObject).a();
    }
  }
  
  void c() {}
  
  void d() {}
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onCreate start");
    }
    boolean bool = true;
    try
    {
      super.onCreate();
      this.d = false;
      localObject2 = null;
      try
      {
        localObject1 = (LayoutInflater)getSystemService("layout_inflater");
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onCreate e = ");
          ((StringBuilder)localObject1).append(localOutOfMemoryError);
          QLog.e("BaseSmallScreenService", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
      catch (Exception localException2)
      {
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("onCreate e = ");
          ((StringBuilder)localObject1).append(localException2);
          QLog.e("BaseSmallScreenService", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
      if (localObject1 == null)
      {
        QLog.e("BaseSmallScreenService", 1, "onCreate cannot get inflate service!");
        stopSelf();
        return;
      }
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)getSystemService("phone"));
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_AndroidTelephonyPhoneStateListener, 32);
      localObject2 = new SmallScreenAudio(this);
      ((SmallScreenAudio)localObject2).a(this, (LayoutInflater)localObject1, this);
      this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase[0] = localObject2;
      localObject2 = new SmallScreenVideo(this);
      ((SmallScreenVideo)localObject2).a(this, (LayoutInflater)localObject1, this);
      this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase[1] = localObject2;
      localObject2 = new SmallScreenShare(this);
      ((SmallScreenShare)localObject2).a(this, (LayoutInflater)localObject1, this);
      this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase[2] = localObject2;
      localObject2 = new SmallScreenWatchTogether(this);
      ((SmallScreenWatchTogether)localObject2).a(this, (LayoutInflater)localObject1, this);
      this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase[3] = localObject2;
      Object localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.intent.action.NEW_OUTGOING_CALL");
      ((IntentFilter)localObject1).addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
      this.jdField_b_of_type_Boolean = SmallScreenUtils.i();
      int i;
      if ((Build.VERSION.SDK_INT >= 21) && (VideoController.a().a().c())) {
        i = 1;
      } else {
        i = 0;
      }
      if ((!SmallScreenUtils.c(((AppInterface)this.app).getApp())) || (i != 0)) {
        bool = false;
      }
      this.e = bool;
      this.jdField_c_of_type_Boolean = SmallScreenUtils.b(((AppInterface)this.app).getApp());
      this.f = SmallScreenUtils.f(((AppInterface)this.app).getApp());
      if (this.jdField_a_of_type_JavaLangRunnable == null) {
        this.jdField_a_of_type_JavaLangRunnable = new BaseSmallScreenService.InitRunnable(this);
      }
      a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 400L);
      if (this.jdField_b_of_type_JavaLangRunnable == null) {
        this.jdField_b_of_type_JavaLangRunnable = new BaseSmallScreenService.OnOpChangedRunnable(this);
      }
      a().postDelayed(this.jdField_b_of_type_JavaLangRunnable, 1000L);
      if (QLog.isColorLevel()) {
        QLog.d("BaseSmallScreenService", 2, "onCreate end");
      }
      return;
    }
    catch (Exception localException1)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onCreate e = ");
      ((StringBuilder)localObject2).append(localException1);
      QLog.e("BaseSmallScreenService", 1, ((StringBuilder)localObject2).toString());
      stopSelf();
    }
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onDestroy start");
    }
    super.onDestroy();
    this.d = true;
    TelephonyManager localTelephonyManager = this.jdField_a_of_type_AndroidTelephonyTelephonyManager;
    PhoneStateListener localPhoneStateListener = this.jdField_a_of_type_AndroidTelephonyPhoneStateListener;
    int i = 0;
    localTelephonyManager.listen(localPhoneStateListener, 0);
    this.jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
    if (this.jdField_b_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    }
    if (this.jdField_a_of_type_JavaLangRunnable != null) {
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_AndroidTelephonyPhoneStateListener = null;
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_b_of_type_JavaLangRunnable = null;
    while (i < 4)
    {
      this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase[i].a();
      this.jdField_a_of_type_ArrayOfComTencentAvSmallscreenSmallScreenItemBase[i] = null;
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onDestroy end");
    }
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
    if (QLog.isColorLevel()) {
      QLog.d("BaseSmallScreenService", 2, "onLowMemory");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.smallscreen.BaseSmallScreenService
 * JD-Core Version:    0.7.0.1
 */