import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeCleaner;
import com.tencent.mobileqq.theme.ThemeSwitchManager.1;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class ayml
  implements Manager
{
  public Bitmap a;
  Handler jdField_a_of_type_AndroidOsHandler = new aymm(this, Looper.getMainLooper());
  View jdField_a_of_type_AndroidViewView;
  public ImageView a;
  public aymw a;
  bcqf jdField_a_of_type_Bcqf;
  public AppInterface a;
  private ThemeCleaner jdField_a_of_type_ComTencentMobileqqThemeThemeCleaner;
  WeakReference<Activity> jdField_a_of_type_JavaLangRefWeakReference;
  public AtomicBoolean a;
  
  public ayml(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    if ((paramAppRuntime instanceof AppInterface)) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface = ((AppInterface)paramAppRuntime);
    }
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      this.jdField_a_of_type_ComTencentMobileqqThemeThemeCleaner = new ThemeCleaner();
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqThemeThemeCleaner, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.msg.permission.pushnotify", null);
    }
  }
  
  public static boolean a(Bundle paramBundle)
  {
    boolean bool3 = false;
    String str = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.theme_profile.name(), "1|1|1");
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitchManager", 2, "getIsEnableAnimate profileStr:" + str);
    }
    if (!TextUtils.isEmpty(str))
    {
      Integer[] arrayOfInteger = new Integer[3];
      arrayOfInteger[0] = Integer.valueOf(0);
      arrayOfInteger[1] = Integer.valueOf(0);
      arrayOfInteger[2] = Integer.valueOf(0);
      int i = DeviceProfileManager.a(str, arrayOfInteger, new ajve());
      if (QLog.isColorLevel()) {
        QLog.i("ThemeSwitchManager", 2, "getIsEnableAnimate size:" + i + ", params:" + arrayOfInteger);
      }
      if (i >= 3)
      {
        boolean bool1;
        if (arrayOfInteger[0].intValue() == 1)
        {
          bool1 = true;
          if (arrayOfInteger[1].intValue() != 1) {
            break label223;
          }
        }
        label223:
        for (boolean bool2 = true;; bool2 = false)
        {
          if (arrayOfInteger[2].intValue() == 1) {
            bool3 = true;
          }
          if (paramBundle != null)
          {
            paramBundle.putBoolean("dynamic_switch", bool1);
            paramBundle.putBoolean("dynamic_enable", bool2);
            paramBundle.putBoolean("dynamic_webview_enable", bool3);
          }
          return true;
          bool1 = false;
          break;
        }
      }
    }
    return false;
  }
  
  public void a()
  {
    try
    {
      if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null))
      {
        QLog.e("ThemeSwitchManager", 1, "doScreenShot, currActivityRef is null");
        return;
      }
      Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        localObject = localActivity.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null) {
            this.jdField_a_of_type_AndroidViewView = ((View)localObject).getRootView();
          }
        }
      }
      if (this.jdField_a_of_type_AndroidViewView == null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ThemeSwitchManager", 2, "doScreenShot, rootView is null");
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      QLog.e("ThemeSwitchManager", 1, "doScreenShot oom, no animation", localThrowable);
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_AndroidWidgetImageView.getParent() != null)) {
        ((ViewGroup)this.jdField_a_of_type_AndroidWidgetImageView.getParent()).removeView(this.jdField_a_of_type_AndroidWidgetImageView);
      }
      this.jdField_a_of_type_AndroidWidgetImageView = null;
      while (QLog.isColorLevel())
      {
        QLog.d("ThemeSwitchManager", 2, "drawingCache is:" + this.jdField_a_of_type_AndroidGraphicsBitmap);
        return;
        boolean bool1 = this.jdField_a_of_type_AndroidViewView.isDrawingCacheEnabled();
        boolean bool2 = this.jdField_a_of_type_AndroidViewView.willNotCacheDrawing();
        this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(true);
        this.jdField_a_of_type_AndroidViewView.setWillNotCacheDrawing(false);
        localObject = this.jdField_a_of_type_AndroidViewView.getDrawingCache();
        if (localObject != null)
        {
          this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap((Bitmap)localObject);
          this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(localThrowable);
          this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
          if ((localThrowable instanceof QQBrowserActivity))
          {
            this.jdField_a_of_type_AndroidWidgetImageView.setAlpha(220);
            if (QLog.isColorLevel()) {
              QLog.d("ThemeSwitchManager", 2, "doScreenShot, refActivity is QQBrowserActivity");
            }
          }
          ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_AndroidViewView;
          this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          localViewGroup.addView(this.jdField_a_of_type_AndroidWidgetImageView);
        }
        this.jdField_a_of_type_AndroidViewView.setDrawingCacheEnabled(bool1);
        this.jdField_a_of_type_AndroidViewView.setWillNotCacheDrawing(bool2);
      }
    }
  }
  
  public void a(Activity paramActivity)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(200);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(201);
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing()))
    {
      this.jdField_a_of_type_Bcqf.dismiss();
      this.jdField_a_of_type_Bcqf = null;
    }
    if (this.jdField_a_of_type_AndroidViewView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 2, "onPostThemeChanged rootView is null");
      }
      return;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      if ((!this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (this.jdField_a_of_type_AndroidWidgetImageView != null))
      {
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.1F);
        localAlphaAnimation.setDuration(501L);
        localAlphaAnimation.setInterpolator(new LinearInterpolator());
        localAlphaAnimation.setFillAfter(true);
        this.jdField_a_of_type_AndroidWidgetImageView.setAnimation(localAlphaAnimation);
        this.jdField_a_of_type_AndroidViewView.postDelayed(new ThemeSwitchManager.1(this), 601L);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewView = null;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 2, "onPostThemeChanged drawingCache is null");
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqThemeThemeCleaner != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqThemeThemeCleaner);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
    if ((this.jdField_a_of_type_Bcqf != null) && (this.jdField_a_of_type_Bcqf.isShowing()))
    {
      this.jdField_a_of_type_Bcqf.dismiss();
      this.jdField_a_of_type_Bcqf = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayml
 * JD-Core Version:    0.7.0.1
 */