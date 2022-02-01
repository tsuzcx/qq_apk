import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class bcrc
  implements View.OnClickListener
{
  public bcrc(azvi paramazvi, bcow parambcow, SplashADView paramSplashADView, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.jdField_a_of_type_Azvi != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Azvi.b))) {
        azvf.a(this.jdField_a_of_type_Azvi.b, null, 3);
      }
      this.jdField_a_of_type_Bcow.a(15, 1, 0L);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.setOnClickListener(null);
      azvf.a = true;
      int i = j;
      if (this.jdField_a_of_type_Azvi != null) {
        if (this.jdField_a_of_type_Azvi.jdField_d_of_type_Int != 2)
        {
          i = j;
          if (this.jdField_a_of_type_Azvi.jdField_d_of_type_Int != 3) {}
        }
        else
        {
          azvf.a = false;
          i = 2000;
          if ((this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.a) && (this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b) && (this.jdField_a_of_type_Azvi.a == 2)) {
            this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.d();
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Azvi.b)) {
            azvf.a(this.jdField_a_of_type_Azvi.b, null, 2);
          }
          bmtq.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Azvi.jdField_d_of_type_JavaLangString);
        }
      }
      QLog.i("QSplash@QbossSplashUtil", 1, "cover_layer =" + i);
      this.jdField_a_of_type_Bcow.a(15, 1, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bcrc
 * JD-Core Version:    0.7.0.1
 */