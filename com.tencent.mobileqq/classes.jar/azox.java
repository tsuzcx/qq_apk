import android.view.ViewGroup;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameData;
import com.tencent.mobileqq.minigame.splash.SplashMiniGameStarter;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public final class azox
  extends aznq
{
  public azox(Object paramObject, SplashADView paramSplashADView, AppActivity paramAppActivity)
  {
    super(paramObject);
  }
  
  protected void a()
  {
    try
    {
      awzt localawzt = (awzt)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b = false;
      switch (localawzt.a)
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
  
  protected void a(aznp paramaznp)
  {
    awzt localawzt;
    try
    {
      if (this.jdField_a_of_type_JavaLangObject == null) {
        return;
      }
      localawzt = (awzt)this.jdField_a_of_type_JavaLangObject;
      QLog.i("SplashMiniGameStarter", 1, "bindView");
      aznk.a = System.currentTimeMillis();
      if (!this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.jdField_a_of_type_Boolean)
      {
        paramaznp.a = 0L;
        return;
      }
    }
    catch (Exception paramaznp)
    {
      QLog.e("SplashMiniGameStarter", 1, "show SplashAd bindView error ", paramaznp);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_MqqAppAppActivity.findViewById(2131376955);
    if (localViewGroup == null)
    {
      QLog.i("SplashMiniGameStarter", 1, "bindView fail, root is null");
      paramaznp.a = 0L;
      return;
    }
    SplashMiniGameStarter.setNeedShow(false);
    localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView, 0);
    switch (localawzt.a)
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
        paramaznp.a = l;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azox
 * JD-Core Version:    0.7.0.1
 */