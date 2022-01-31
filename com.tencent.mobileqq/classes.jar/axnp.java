import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class axnp
  implements PopupWindow.OnDismissListener
{
  axnq jdField_a_of_type_Axnq;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  public axnp(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherPanel", 2, "destroyPanel");
    }
    a();
    this.jdField_a_of_type_Axnq.b();
    this.jdField_a_of_type_Axnq = null;
  }
  
  public void a(aejb paramaejb, View paramView)
  {
    paramView = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    if (paramView.isActive()) {
      paramView.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_Axnq == null)
    {
      this.jdField_a_of_type_Axnq = axnq.a(paramaejb, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, -1, -1);
      this.jdField_a_of_type_Axnq.setOnDismissListener(this);
      axmt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a();
    }
    paramaejb = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow();
    if (paramaejb != null)
    {
      paramView = paramaejb.getAttributes();
      paramView.alpha = 0.5F;
      paramaejb.setAttributes(paramView);
    }
    this.jdField_a_of_type_Axnq.setAnimationStyle(2131689842);
    this.jdField_a_of_type_Axnq.showAtLocation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView(), 80, 0, 0);
    this.jdField_a_of_type_Axnq.a();
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Axnq != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Axnq.isShowing())
      {
        this.jdField_a_of_type_Axnq.dismiss();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onDismiss()
  {
    axmt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(false);
    Window localWindow = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.alpha = 1.0F;
      localWindow.setAttributes(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axnp
 * JD-Core Version:    0.7.0.1
 */