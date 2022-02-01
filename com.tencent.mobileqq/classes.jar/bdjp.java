import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;

public final class bdjp
  extends bdhp
{
  public bdjp(Object paramObject, SplashADView paramSplashADView, AppActivity paramAppActivity, ImageView paramImageView1, ImageView paramImageView2, long paramLong)
  {
    super(paramObject);
  }
  
  protected void a()
  {
    try
    {
      banw localbanw = (banw)this.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b = false;
      switch (localbanw.a)
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
  
  protected void a(bdho parambdho)
  {
    banw localbanw;
    try
    {
      if (this.jdField_a_of_type_JavaLangObject == null) {
        return;
      }
      localbanw = (banw)this.jdField_a_of_type_JavaLangObject;
      QLog.i("QSplash@QbossSplashUtil", 1, "bindView");
      bdhj.jdField_a_of_type_Long = System.currentTimeMillis();
      if (!this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.jdField_a_of_type_Boolean)
      {
        parambdho.jdField_a_of_type_Long = 0L;
        return;
      }
    }
    catch (Exception parambdho)
    {
      QLog.e("QSplash@QbossSplashUtil", 1, "show SplashAd bindView error ", parambdho);
      return;
    }
    ViewGroup localViewGroup = (ViewGroup)this.jdField_a_of_type_MqqAppAppActivity.findViewById(2131377909);
    if (localViewGroup == null)
    {
      QLog.i("QSplash@QbossSplashUtil", 1, "bindView fail, root is null");
      parambdho.jdField_a_of_type_Long = 0L;
      return;
    }
    localViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView, 0);
    switch (localbanw.a)
    {
    }
    for (;;)
    {
      if (bnua.a(localbanw.l))
      {
        bnua.a(this.jdField_a_of_type_Long + "", 101, localbanw.b, localbanw.j);
        banv.a(localbanw.b, this.jdField_a_of_type_Long, false, "tianshu_splash_ad_ids_with_showdate_with_priority_");
      }
      banv.a(localbanw.j, null, 1);
      banv.a(localbanw.b, this.jdField_a_of_type_Long, false, "qboss_splash_ad_ids_with_showdate_with_priority_");
      bdhj.a(localbanw.c, localbanw.g);
      return;
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.b != null))
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.b.setVisibility(8);
      }
      parambdho.jdField_a_of_type_Long = 3000L;
      continue;
      QLog.i("QSplash@QbossSplashUtil", 1, "show video");
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b();
      parambdho.jdField_a_of_type_Long = 10000L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdjp
 * JD-Core Version:    0.7.0.1
 */