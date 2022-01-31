import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public final class awpd
  extends awob
{
  public awpd(Object paramObject, SplashADView paramSplashADView, AppActivity paramAppActivity, ImageView paramImageView1, ImageView paramImageView2, long paramLong)
  {
    super(paramObject);
  }
  
  protected void a()
  {
    try
    {
      auen localauen = (auen)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b = false;
      switch (localauen.a)
      {
      case 2: 
        this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.d();
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "show SplashAd end() error ", localException);
      return;
    }
  }
  
  protected void a(awoa paramawoa)
  {
    auen localauen;
    try
    {
      if (this.jdField_a_of_type_JavaLangObject == null) {
        return;
      }
      localauen = (auen)this.jdField_a_of_type_JavaLangObject;
      QLog.i("QSplash@QbossSplashUtil", 1, "bindView");
      awnv.jdField_a_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.jdField_a_of_type_Boolean)
      {
        paramawoa.jdField_a_of_type_Long = 0L;
        return;
      }
    }
    catch (Exception paramawoa)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "show SplashAd bindView error ", paramawoa);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_MqqAppAppActivity.findViewById(2131310602);
    if (localViewGroup == null)
    {
      QLog.i("QSplash@QbossSplashUtil", 1, "bindView fail, root is null");
      paramawoa.jdField_a_of_type_Long = 0L;
      return;
    }
    localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView, 0);
    switch (localauen.a)
    {
    }
    for (;;)
    {
      auem.a(localauen.j, null, 1);
      auem.a(localauen.b, this.jdField_a_of_type_Long, false);
      awnv.a(localauen.c, localauen.g);
      return;
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.b != null))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.b.setVisibility(8);
      }
      paramawoa.jdField_a_of_type_Long = 3000L;
      continue;
      QLog.i("QSplash@QbossSplashUtil", 1, "show video");
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b();
      paramawoa.jdField_a_of_type_Long = 10000L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awpd
 * JD-Core Version:    0.7.0.1
 */