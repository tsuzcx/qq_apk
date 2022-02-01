import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public final class bccn
  implements View.OnClickListener
{
  public bccn(azig paramazig, azie paramazie, String paramString, bcad parambcad, SplashADView paramSplashADView, Activity paramActivity) {}
  
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
      if ((this.jdField_a_of_type_Azig != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Azig.b))) {
        azid.a(this.jdField_a_of_type_Azig.b, null, 3);
      }
      if ((this.jdField_a_of_type_Azie != null) && (bkzh.a(this.jdField_a_of_type_Azie.l))) {
        bkzh.a(this.jdField_a_of_type_JavaLangString + "", 162, this.jdField_a_of_type_Azie.b, this.jdField_a_of_type_Azie.j);
      }
      this.jdField_a_of_type_Bcad.a(15, 1, 0L);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.setOnClickListener(null);
      azid.a = true;
      int i = j;
      if (this.jdField_a_of_type_Azig != null) {
        if (this.jdField_a_of_type_Azig.jdField_d_of_type_Int != 2)
        {
          i = j;
          if (this.jdField_a_of_type_Azig.jdField_d_of_type_Int != 3) {}
        }
        else
        {
          azid.a = false;
          i = 2000;
          if ((this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.a) && (this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b) && (this.jdField_a_of_type_Azig.a == 2)) {
            this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.d();
          }
          if (!TextUtils.isEmpty(this.jdField_a_of_type_Azig.b)) {
            azid.a(this.jdField_a_of_type_Azig.b, null, 2);
          }
          if ((this.jdField_a_of_type_Azie != null) && (bkzh.a(this.jdField_a_of_type_Azie.l))) {
            bkzh.a(this.jdField_a_of_type_JavaLangString + "", 102, this.jdField_a_of_type_Azie.b, this.jdField_a_of_type_Azie.j);
          }
          blaf.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Azig.jdField_d_of_type_JavaLangString);
        }
      }
      if ((this.jdField_a_of_type_Azie != null) && (bkzh.a(this.jdField_a_of_type_Azie.l))) {
        bkzh.a(this.jdField_a_of_type_JavaLangString + "");
      }
      QLog.i("QSplash@QbossSplashUtil", 1, "cover_layer =" + i);
      this.jdField_a_of_type_Bcad.a(15, 1, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bccn
 * JD-Core Version:    0.7.0.1
 */