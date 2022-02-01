import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public final class bccf
  extends bcae
{
  public bccf(Object paramObject, SplashADView paramSplashADView, AppActivity paramAppActivity, ImageView paramImageView1, ImageView paramImageView2, long paramLong)
  {
    super(paramObject);
  }
  
  protected void a()
  {
    try
    {
      azie localazie = (azie)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b = false;
      switch (localazie.a)
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
  
  protected void a(bcad parambcad)
  {
    azie localazie;
    try
    {
      if (this.jdField_a_of_type_JavaLangObject == null) {
        return;
      }
      localazie = (azie)this.jdField_a_of_type_JavaLangObject;
      QLog.i("QSplash@QbossSplashUtil", 1, "bindView");
      bbzy.jdField_a_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.jdField_a_of_type_Boolean)
      {
        parambcad.jdField_a_of_type_Long = 0L;
        return;
      }
    }
    catch (Exception parambcad)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "show SplashAd bindView error ", parambcad);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_MqqAppAppActivity.findViewById(2131377679);
    if (localViewGroup == null)
    {
      QLog.i("QSplash@QbossSplashUtil", 1, "bindView fail, root is null");
      parambcad.jdField_a_of_type_Long = 0L;
      return;
    }
    localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView, 0);
    switch (localazie.a)
    {
    }
    for (;;)
    {
      if (bkzh.a(localazie.l))
      {
        QLog.d("QSplash@QbossSplashUtil", 1, "show UnionBannerSplash ");
        SetSplash.a(this.jdField_a_of_type_MqqAppAppActivity);
        bkzh.a(this.jdField_a_of_type_Long + "", 101, localazie.b, localazie.j);
        azid.a(localazie.b, this.jdField_a_of_type_Long, false, "tianshu_splash_ad_ids_with_showdate_with_priority_");
      }
      azid.a(localazie.j, null, 1);
      azid.a(localazie.b, this.jdField_a_of_type_Long, false, "qboss_splash_ad_ids_with_showdate_with_priority_");
      bbzy.a(localazie.c, localazie.g);
      return;
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.b != null))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.b.setVisibility(8);
      }
      parambcad.jdField_a_of_type_Long = 3000L;
      continue;
      QLog.i("QSplash@QbossSplashUtil", 1, "show video");
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b();
      parambcad.jdField_a_of_type_Long = 10000L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bccf
 * JD-Core Version:    0.7.0.1
 */