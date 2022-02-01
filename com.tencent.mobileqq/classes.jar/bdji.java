import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class bdji
  implements View.OnClickListener
{
  public bdji(baoo parambaoo, baom parambaom, String paramString, bdgy parambdgy, SplashADView paramSplashADView, Activity paramActivity) {}
  
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
      if ((this.jdField_a_of_type_Baoo != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Baoo.b))) {
        baol.a(this.jdField_a_of_type_Baoo.b, null, 3);
      }
      if ((this.jdField_a_of_type_Baom != null) && (bmll.a(this.jdField_a_of_type_Baom.l))) {
        bmll.a(this.jdField_a_of_type_JavaLangString + "", 162, this.jdField_a_of_type_Baom.b, this.jdField_a_of_type_Baom.j);
      }
      this.jdField_a_of_type_Bdgy.a(15, 1, 0L);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.setOnClickListener(null);
      baol.a = true;
      int i = j;
      if (this.jdField_a_of_type_Baoo != null) {
        if (this.jdField_a_of_type_Baoo.jdField_d_of_type_Int != 2)
        {
          i = j;
          if (this.jdField_a_of_type_Baoo.jdField_d_of_type_Int != 3) {}
        }
        else
        {
          baol.a = false;
          i = 2000;
          if ((this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.a) && (this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b) && (this.jdField_a_of_type_Baoo.a == 2)) {
            this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.d();
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Baoo.b)) {
            baol.a(this.jdField_a_of_type_Baoo.b, null, 2);
          }
          if ((this.jdField_a_of_type_Baom != null) && (bmll.a(this.jdField_a_of_type_Baom.l))) {
            bmll.a(this.jdField_a_of_type_JavaLangString + "", 102, this.jdField_a_of_type_Baom.b, this.jdField_a_of_type_Baom.j);
          }
          bmmj.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Baoo.jdField_d_of_type_JavaLangString);
        }
      }
      if ((this.jdField_a_of_type_Baom != null) && (bmll.a(this.jdField_a_of_type_Baom.l))) {
        bmll.a(this.jdField_a_of_type_JavaLangString + "");
      }
      QLog.i("QSplash@QbossSplashUtil", 1, "cover_layer =" + i);
      this.jdField_a_of_type_Bdgy.a(15, 1, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdji
 * JD-Core Version:    0.7.0.1
 */