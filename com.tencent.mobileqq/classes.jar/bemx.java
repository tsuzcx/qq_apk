import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.activity.aio.core.TroopChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

public class bemx
  implements PopupWindow.OnDismissListener
{
  bemy jdField_a_of_type_Bemy;
  BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  
  public bemx(BaseActivity paramBaseActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TogetherPanel", 2, "destroyPanel");
    }
    a();
    this.jdField_a_of_type_Bemy.d();
    this.jdField_a_of_type_Bemy = null;
  }
  
  public void a(TroopChatPie paramTroopChatPie, View paramView, int paramInt)
  {
    paramView = (InputMethodManager)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSystemService("input_method");
    if (paramView.isActive()) {
      paramView.hideSoftInputFromWindow(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView().getWindowToken(), 0);
    }
    if (this.jdField_a_of_type_Bemy == null)
    {
      this.jdField_a_of_type_Bemy = bemy.a(paramTroopChatPie, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, -1, -1, paramInt);
      this.jdField_a_of_type_Bemy.setOnDismissListener(this);
      bejv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a();
    }
    for (;;)
    {
      paramTroopChatPie = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow();
      if (paramTroopChatPie != null)
      {
        paramView = paramTroopChatPie.getAttributes();
        paramView.alpha = 0.5F;
        paramTroopChatPie.setAttributes(paramView);
      }
      this.jdField_a_of_type_Bemy.setAnimationStyle(2131755400);
      this.jdField_a_of_type_Bemy.showAtLocation(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().getDecorView(), 80, 0, 0);
      this.jdField_a_of_type_Bemy.b();
      return;
      if (paramInt == 1) {
        this.jdField_a_of_type_Bemy.c();
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_Bemy != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_Bemy.isShowing())
      {
        this.jdField_a_of_type_Bemy.dismiss();
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onDismiss()
  {
    bejv.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app).a(false);
    Window localWindow = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow();
    if (localWindow != null)
    {
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.alpha = 1.0F;
      localWindow.setAttributes(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bemx
 * JD-Core Version:    0.7.0.1
 */