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
  boolean a = true;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  boolean e = true;
  boolean f = false;
  int g = 0;
  int h = 7;
  int i = 0;
  final SmallScreenItemBase[] j = new SmallScreenItemBase[4];
  Runnable k = null;
  Runnable l = null;
  Handler m;
  TelephonyManager n = null;
  PhoneStateListener o = new BaseSmallScreenService.1(this);
  
  public int a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    paramSmallScreenRelativeLayout = e(paramSmallScreenRelativeLayout);
    if (paramSmallScreenRelativeLayout == null) {
      return 0;
    }
    return paramSmallScreenRelativeLayout.f().x;
  }
  
  SmallScreenToast a(int paramInt)
  {
    SmallScreenItemBase[] arrayOfSmallScreenItemBase = this.j;
    if (arrayOfSmallScreenItemBase[paramInt] != null) {
      return arrayOfSmallScreenItemBase[paramInt].n;
    }
    return null;
  }
  
  void a()
  {
    long l1 = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onIsLockChanged, mIsLock[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(l1);
      localStringBuilder.append("]");
      QLog.w("BaseSmallScreenService", 1, localStringBuilder.toString());
    }
    a(l1);
  }
  
  void a(int paramInt, String paramString) {}
  
  void a(long paramLong) {}
  
  public void a(SmallScreenRelativeLayout paramSmallScreenRelativeLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramSmallScreenRelativeLayout = e(paramSmallScreenRelativeLayout);
    if (paramSmallScreenRelativeLayout != null)
    {
      WindowManager.LayoutParams localLayoutParams = paramSmallScreenRelativeLayout.f();
      localLayoutParams.x = paramInt1;
      localLayoutParams.y = paramInt2;
      localLayoutParams.width = (paramInt3 - paramInt1);
      localLayoutParams.height = (paramInt4 - paramInt2);
      paramSmallScreenRelativeLayout.d();
    }
  }
  
  public int b(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    paramSmallScreenRelativeLayout = e(paramSmallScreenRelativeLayout);
    if (paramSmallScreenRelativeLayout == null) {
      return 0;
    }
    return paramSmallScreenRelativeLayout.f().y;
  }
  
  public Handler b()
  {
    if (this.m == null) {
      this.m = new Handler(Looper.getMainLooper());
    }
    return this.m;
  }
  
  SmallScreenRelativeLayout b(int paramInt)
  {
    SmallScreenItemBase[] arrayOfSmallScreenItemBase = this.j;
    if (arrayOfSmallScreenItemBase[paramInt] != null) {
      return arrayOfSmallScreenItemBase[paramInt].m;
    }
    return null;
  }
  
  void c()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onHasSmartBarChanged mHasSmartBar = ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("BaseSmallScreenService", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = b(1);
    if (localObject != null) {
      ((SmallScreenRelativeLayout)localObject).a();
    }
  }
  
  public void c(SmallScreenRelativeLayout paramSmallScreenRelativeLayout) {}
  
  void d() {}
  
  public boolean d(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    return true;
  }
  
  protected SmallScreenToast e(SmallScreenRelativeLayout paramSmallScreenRelativeLayout)
  {
    int i1 = 0;
    while (i1 < 4)
    {
      if (b(i1) == paramSmallScreenRelativeLayout) {
        return a(i1);
      }
      i1 += 1;
    }
    return null;
  }
  
  void e() {}
  
  protected boolean f()
  {
    return SmallScreenUtils.f(((AppInterface)this.app).getApp());
  }
  
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
      this.n = ((TelephonyManager)getSystemService("phone"));
      this.n.listen(this.o, 32);
      localObject2 = new SmallScreenAudio(this);
      ((SmallScreenAudio)localObject2).a(this, (LayoutInflater)localObject1, this);
      this.j[0] = localObject2;
      localObject2 = new SmallScreenVideo(this);
      ((SmallScreenVideo)localObject2).a(this, (LayoutInflater)localObject1, this);
      this.j[1] = localObject2;
      localObject2 = new SmallScreenShare(this);
      ((SmallScreenShare)localObject2).a(this, (LayoutInflater)localObject1, this);
      this.j[2] = localObject2;
      localObject2 = new SmallScreenWatchTogether(this);
      ((SmallScreenWatchTogether)localObject2).a(this, (LayoutInflater)localObject1, this);
      this.j[3] = localObject2;
      Object localObject1 = new IntentFilter();
      ((IntentFilter)localObject1).addAction("android.intent.action.NEW_OUTGOING_CALL");
      ((IntentFilter)localObject1).addAction("tencent.video.q2v.ACTION_SELECT_MEMBER_ACTIVITY_IS_RESUME_CHANGED");
      this.b = SmallScreenUtils.j();
      int i1;
      if ((Build.VERSION.SDK_INT >= 21) && (VideoController.f().aE().e())) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      if ((!SmallScreenUtils.c(((AppInterface)this.app).getApp())) || (i1 != 0)) {
        bool = false;
      }
      this.e = bool;
      this.c = SmallScreenUtils.b(((AppInterface)this.app).getApp());
      this.f = SmallScreenUtils.f(((AppInterface)this.app).getApp());
      if (this.k == null) {
        this.k = new BaseSmallScreenService.InitRunnable(this);
      }
      b().postDelayed(this.k, 400L);
      if (this.l == null) {
        this.l = new BaseSmallScreenService.OnOpChangedRunnable(this);
      }
      b().postDelayed(this.l, 1000L);
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
    TelephonyManager localTelephonyManager = this.n;
    PhoneStateListener localPhoneStateListener = this.o;
    int i1 = 0;
    localTelephonyManager.listen(localPhoneStateListener, 0);
    this.n = null;
    if (this.l != null) {
      b().removeCallbacks(this.l);
    }
    if (this.k != null) {
      b().removeCallbacks(this.k);
    }
    this.o = null;
    this.k = null;
    this.l = null;
    while (i1 < 4)
    {
      this.j[i1].b();
      this.j[i1] = null;
      i1 += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.BaseSmallScreenService
 * JD-Core Version:    0.7.0.1
 */