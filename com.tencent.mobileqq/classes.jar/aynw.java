import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class aynw
  implements PopupWindow.OnDismissListener
{
  aynx jdField_a_of_type_Aynx;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  public aynw(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherPanel", 2, "destroyPanel");
    }
    a();
    this.jdField_a_of_type_Aynx.b();
    this.jdField_a_of_type_Aynx = null;
  }
  
  public void a(TroopChatPie paramTroopChatPie, View paramView)
  {
    paramView = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    if (paramView.isActive()) {
      paramView.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_Aynx == null)
    {
      this.jdField_a_of_type_Aynx = aynx.a(paramTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, -1, -1);
      this.jdField_a_of_type_Aynx.setOnDismissListener(this);
      ayna.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a();
    }
    paramTroopChatPie = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow();
    if (paramTroopChatPie != null)
    {
      paramView = paramTroopChatPie.getAttributes();
      paramView.alpha = 0.5F;
      paramTroopChatPie.setAttributes(paramView);
    }
    this.jdField_a_of_type_Aynx.setAnimationStyle(2131755379);
    this.jdField_a_of_type_Aynx.showAtLocation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView(), 80, 0, 0);
    this.jdField_a_of_type_Aynx.a();
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Aynx != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Aynx.isShowing())
      {
        this.jdField_a_of_type_Aynx.dismiss();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onDismiss()
  {
    ayna.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(false);
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
 * Qualified Name:     aynw
 * JD-Core Version:    0.7.0.1
 */