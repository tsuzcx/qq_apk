import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.splashad.SplashADView;
import com.tencent.qphone.base.util.QLog;

public final class awpi
  implements View.OnClickListener
{
  public awpi(auep paramauep, awoa paramawoa, SplashADView paramSplashADView, Activity paramActivity) {}
  
  public void onClick(View paramView)
  {
    int j = 0;
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131303128: 
      if ((this.jdField_a_of_type_Auep != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Auep.b))) {
        auem.a(this.jdField_a_of_type_Auep.b, null, 3);
      }
      this.jdField_a_of_type_Awoa.a(15, 1, 0L);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.setOnClickListener(null);
    auem.a = true;
    int i = j;
    if (this.jdField_a_of_type_Auep != null) {
      if (this.jdField_a_of_type_Auep.jdField_d_of_type_Int != 2)
      {
        i = j;
        if (this.jdField_a_of_type_Auep.jdField_d_of_type_Int != 3) {}
      }
      else
      {
        auem.a = false;
        i = 2000;
        if ((this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.a) && (this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.b) && (this.jdField_a_of_type_Auep.a == 2)) {
          this.jdField_a_of_type_ComTencentMobileqqSplashadSplashADView.d();
        }
        bgpp.b(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Auep.jdField_d_of_type_JavaLangString);
      }
    }
    QLog.i("QSplash@QbossSplashUtil", 1, "cover_layer =" + i);
    this.jdField_a_of_type_Awoa.a(15, 1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awpi
 * JD-Core Version:    0.7.0.1
 */