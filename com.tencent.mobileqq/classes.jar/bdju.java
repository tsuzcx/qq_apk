import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class bdju
  implements View.OnClickListener
{
  public bdju(bany parambany, banw parambanw, String paramString, bdho parambdho, SplashADView paramSplashADView, Activity paramActivity) {}
  
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
      if ((this.jdField_a_of_type_Bany != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bany.b))) {
        banv.a(this.jdField_a_of_type_Bany.b, null, 3);
      }
      if ((this.jdField_a_of_type_Banw != null) && (bnua.a(this.jdField_a_of_type_Banw.l))) {
        bnua.a(this.jdField_a_of_type_JavaLangString + "", 162, this.jdField_a_of_type_Banw.b, this.jdField_a_of_type_Banw.j);
      }
      this.jdField_a_of_type_Bdho.a(15, 1, 0L);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.setOnClickListener(null);
      banv.a = true;
      int i = j;
      if (this.jdField_a_of_type_Bany != null) {
        if (this.jdField_a_of_type_Bany.jdField_d_of_type_Int != 2)
        {
          i = j;
          if (this.jdField_a_of_type_Bany.jdField_d_of_type_Int != 3) {}
        }
        else
        {
          banv.a = false;
          i = 2000;
          if ((this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.a) && (this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b) && (this.jdField_a_of_type_Bany.a == 2)) {
            this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.d();
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Bany.b)) {
            banv.a(this.jdField_a_of_type_Bany.b, null, 2);
          }
          bnuy.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bany.jdField_d_of_type_JavaLangString);
        }
      }
      if ((this.jdField_a_of_type_Banw != null) && (bnua.a(this.jdField_a_of_type_Banw.l)))
      {
        bnua.a(this.jdField_a_of_type_JavaLangString + "");
        bnua.a(this.jdField_a_of_type_JavaLangString + "", 102, this.jdField_a_of_type_Banw.b, this.jdField_a_of_type_Banw.j);
      }
      QLog.i("QSplash@QbossSplashUtil", 1, "cover_layer =" + i);
      this.jdField_a_of_type_Bdho.a(15, 1, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdju
 * JD-Core Version:    0.7.0.1
 */