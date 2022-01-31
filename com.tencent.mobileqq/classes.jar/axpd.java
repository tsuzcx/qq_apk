import android.view.ViewGroup;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public final class axpd
  extends axny
{
  public axpd(Object paramObject, SplashADView paramSplashADView, AppActivity paramAppActivity)
  {
    super(paramObject);
  }
  
  protected void a()
  {
    try
    {
      avdx localavdx = (avdx)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b = false;
      switch (localavdx.a)
      {
      case 2: 
        this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.d();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("SplashMiniGameStarter", 1, "show SplashAd end() error ", localException);
      return;
    }
  }
  
  protected void a(axnx paramaxnx)
  {
    avdx localavdx;
    try
    {
      if (this.jdField_a_of_type_JavaLangObject == null) {
        return;
      }
      localavdx = (avdx)this.jdField_a_of_type_JavaLangObject;
      QLog.i("SplashMiniGameStarter", 1, "bindView");
      axns.a = System.currentTimeMillis();
      if (!this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.jdField_a_of_type_Boolean)
      {
        paramaxnx.a = 0L;
        return;
      }
    }
    catch (Exception paramaxnx)
    {
      QLog.e("SplashMiniGameStarter", 1, "show SplashAd bindView error ", paramaxnx);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_MqqAppAppActivity.findViewById(2131376397);
    if (localViewGroup == null)
    {
      QLog.i("SplashMiniGameStarter", 1, "bindView fail, root is null");
      paramaxnx.a = 0L;
      return;
    }
    SplashMiniGameStarter.setNeedShow(false);
    localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView, 0);
    switch (localavdx.a)
    {
    }
    for (;;)
    {
      SplashMiniGameStarter.preloadMiniGame();
      return;
      QLog.i("SplashMiniGameStarter", 1, "show video");
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b();
      if (SplashMiniGameStarter.curData != null) {}
      for (long l = SplashMiniGameStarter.curData.videoDuration * 1000;; l = 5000L)
      {
        paramaxnx.a = l;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     axpd
 * JD-Core Version:    0.7.0.1
 */