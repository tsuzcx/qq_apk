package com.tencent.av.screenshare.floatingwindow;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.WindowManager.LayoutParams;
import com.tencent.av.VideoConstants.EmShareOps;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.qphone.base.util.QLog;
import lid;
import lym;
import lyn;
import lyo;
import mbw;
import mls;
import mqq.app.AppService;

public class ScreenShareFloatingWindowService
  extends AppService
  implements lym
{
  public static boolean a;
  private int jdField_a_of_type_Int = -1;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private VideoController jdField_a_of_type_ComTencentAvVideoController;
  private VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private ScreenShareFloatingRelativeLayout jdField_a_of_type_ComTencentAvScreenshareFloatingwindowScreenShareFloatingRelativeLayout;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private lyn jdField_a_of_type_Lyn;
  private final int jdField_b_of_type_Int = 1000;
  boolean jdField_b_of_type_Boolean = false;
  private boolean c;
  
  private void a()
  {
    try
    {
      LayoutInflater localLayoutInflater = (LayoutInflater)getSystemService("layout_inflater");
      this.jdField_a_of_type_ComTencentAvScreenshareFloatingwindowScreenShareFloatingRelativeLayout = ((ScreenShareFloatingRelativeLayout)localLayoutInflater.inflate(2131559630, null));
      this.jdField_a_of_type_ComTencentAvScreenshareFloatingwindowScreenShareFloatingRelativeLayout.setFloatListener(this);
      this.jdField_a_of_type_Lyn = new lyn(this, this.jdField_a_of_type_ComTencentAvScreenshareFloatingwindowScreenShareFloatingRelativeLayout);
      a(this.jdField_a_of_type_Lyn.a());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ScreenShareFloatingWindowService", 2, "onCreate e = " + localException);
        }
        Object localObject1 = null;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ScreenShareFloatingWindowService", 2, "onCreate e = " + localOutOfMemoryError);
        }
        Object localObject2 = null;
      }
    }
  }
  
  @TargetApi(21)
  private void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject != null) {
      ((ScreenShareCtrl)localObject).a(VideoConstants.EmShareOps.STOP);
    }
    localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (localObject != null) {
      ((mls)localObject).a(paramInt);
    }
  }
  
  private static void a(WindowManager.LayoutParams paramLayoutParams)
  {
    paramLayoutParams.flags = 16909064;
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramLayoutParams.type = 2038;
      return;
    }
    paramLayoutParams.type = 2002;
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = ((VideoAppInterface)this.app);
    this.jdField_a_of_type_ComTencentAvVideoController = ((VideoAppInterface)this.app).a();
    this.c = lyo.b(this);
    this.jdField_a_of_type_JavaLangRunnable = new ScreenShareFloatingWindowService.FloatingWindowPermissionCheckRunnable(this);
    a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
  }
  
  private void c()
  {
    if (this.c) {
      this.jdField_a_of_type_Lyn.a();
    }
  }
  
  @TargetApi(21)
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShareFloatingWindowService", 2, "doCloseMediaProjection");
    }
    this.jdField_a_of_type_Int = 2;
    a(2);
    this.jdField_a_of_type_Lyn.a();
    stopSelf();
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShareFloatingWindowService", 2, "doFloatingWindowPermissionChange");
    }
    if (this.c)
    {
      this.jdField_a_of_type_Lyn.a();
      return;
    }
    this.jdField_a_of_type_Lyn.a();
  }
  
  public Point a()
  {
    return new Point(this.jdField_a_of_type_Lyn.a().x, this.jdField_a_of_type_Lyn.a().y);
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public void a(ScreenShareFloatingRelativeLayout paramScreenShareFloatingRelativeLayout, int paramInt1, int paramInt2)
  {
    paramScreenShareFloatingRelativeLayout = this.jdField_a_of_type_Lyn;
    WindowManager.LayoutParams localLayoutParams = paramScreenShareFloatingRelativeLayout.a();
    localLayoutParams.x = paramInt1;
    localLayoutParams.y = paramInt2;
    localLayoutParams.width = -2;
    localLayoutParams.height = -2;
    localLayoutParams.windowAnimations = 0;
    paramScreenShareFloatingRelativeLayout.b();
  }
  
  public boolean a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShareFloatingWindowService", 2, "onClick");
    }
    d();
    if (this.jdField_a_of_type_ComTencentAvVideoController.a().ao) {
      mbw.a(getApplicationContext(), this.jdField_a_of_type_ComTencentAvVideoController);
    }
    return false;
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShareFloatingWindowService", 2, "onCreate");
    }
    try
    {
      super.onCreate();
      jdField_a_of_type_Boolean = true;
      a();
      b();
      c();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ScreenShareFloatingWindowService", 1, "onCreate e = " + localException);
      stopSelf();
    }
  }
  
  @TargetApi(21)
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScreenShareFloatingWindowService", 2, "onDestroy");
    }
    super.onDestroy();
    if (this.jdField_a_of_type_Int == -1)
    {
      this.jdField_a_of_type_Int = 3;
      a(this.jdField_a_of_type_Int);
    }
    this.jdField_b_of_type_Boolean = true;
    a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Lyn.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.screenshare.floatingwindow.ScreenShareFloatingWindowService
 * JD-Core Version:    0.7.0.1
 */