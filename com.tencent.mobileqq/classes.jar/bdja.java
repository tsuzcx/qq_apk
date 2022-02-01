import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public final class bdja
  extends bdgz
{
  public bdja(Object paramObject, SplashADView paramSplashADView, AppActivity paramAppActivity, ImageView paramImageView1, ImageView paramImageView2, long paramLong)
  {
    super(paramObject);
  }
  
  protected void a()
  {
    try
    {
      baom localbaom = (baom)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b = false;
      switch (localbaom.a)
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
  
  protected void a(bdgy parambdgy)
  {
    baom localbaom;
    try
    {
      if (this.jdField_a_of_type_JavaLangObject == null) {
        return;
      }
      localbaom = (baom)this.jdField_a_of_type_JavaLangObject;
      QLog.i("QSplash@QbossSplashUtil", 1, "bindView");
      bdgt.jdField_a_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.jdField_a_of_type_Boolean)
      {
        parambdgy.jdField_a_of_type_Long = 0L;
        return;
      }
    }
    catch (Exception parambdgy)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "show SplashAd bindView error ", parambdgy);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_MqqAppAppActivity.findViewById(2131377958);
    if (localViewGroup == null)
    {
      QLog.i("QSplash@QbossSplashUtil", 1, "bindView fail, root is null");
      parambdgy.jdField_a_of_type_Long = 0L;
      return;
    }
    localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView, 0);
    switch (localbaom.a)
    {
    }
    for (;;)
    {
      if (bmll.a(localbaom.l))
      {
        QLog.d("QSplash@QbossSplashUtil", 1, "show UnionBannerSplash ");
        SetSplash.a(this.jdField_a_of_type_MqqAppAppActivity);
        bmll.a(this.jdField_a_of_type_Long + "", 101, localbaom.b, localbaom.j);
        bmll.a(localbaom.b, this.jdField_a_of_type_Long + "");
        baol.a(localbaom.b, this.jdField_a_of_type_Long, false, "tianshu_splash_ad_ids_with_showdate_with_priority_");
      }
      baol.a(localbaom.j, null, 1);
      baol.a(localbaom.b, this.jdField_a_of_type_Long, false, "qboss_splash_ad_ids_with_showdate_with_priority_");
      bdgt.a(localbaom.c, localbaom.g);
      return;
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.b != null))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.b.setVisibility(8);
      }
      parambdgy.jdField_a_of_type_Long = 3000L;
      continue;
      QLog.i("QSplash@QbossSplashUtil", 1, "show video");
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b();
      parambdgy.jdField_a_of_type_Long = 10000L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdja
 * JD-Core Version:    0.7.0.1
 */