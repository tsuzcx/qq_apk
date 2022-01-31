import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public final class azow
  extends aznq
{
  public azow(Object paramObject, SplashADView paramSplashADView, AppActivity paramAppActivity, ImageView paramImageView1, ImageView paramImageView2, long paramLong)
  {
    super(paramObject);
  }
  
  protected void a()
  {
    try
    {
      awzr localawzr = (awzr)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b = false;
      switch (localawzr.a)
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
  
  protected void a(aznp paramaznp)
  {
    awzr localawzr;
    try
    {
      if (this.jdField_a_of_type_JavaLangObject == null) {
        return;
      }
      localawzr = (awzr)this.jdField_a_of_type_JavaLangObject;
      QLog.i("QSplash@QbossSplashUtil", 1, "bindView");
      aznk.jdField_a_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.jdField_a_of_type_Boolean)
      {
        paramaznp.jdField_a_of_type_Long = 0L;
        return;
      }
    }
    catch (Exception paramaznp)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "show SplashAd bindView error ", paramaznp);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_MqqAppAppActivity.findViewById(2131376955);
    if (localViewGroup == null)
    {
      QLog.i("QSplash@QbossSplashUtil", 1, "bindView fail, root is null");
      paramaznp.jdField_a_of_type_Long = 0L;
      return;
    }
    localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView, 0);
    switch (localawzr.a)
    {
    }
    for (;;)
    {
      awzq.a(localawzr.j, null, 1);
      awzq.a(localawzr.b, this.jdField_a_of_type_Long, false);
      aznk.a(localawzr.c, localawzr.g);
      return;
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.b != null))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.b.setVisibility(8);
      }
      paramaznp.jdField_a_of_type_Long = 3000L;
      continue;
      QLog.i("QSplash@QbossSplashUtil", 1, "show video");
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b();
      paramaznp.jdField_a_of_type_Long = 10000L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     azow
 * JD-Core Version:    0.7.0.1
 */