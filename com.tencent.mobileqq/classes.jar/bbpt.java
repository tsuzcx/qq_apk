import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

public class bbpt
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public bbpt(NavBarAIO paramNavBarAIO, int paramInt1, int paramInt2) {}
  
  public void onGlobalLayout()
  {
    if (Build.VERSION.SDK_INT >= 16) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }
    for (;;)
    {
      int i = NavBarAIO.a(this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO);
      int j = NavBarAIO.b(this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO);
      if ((i != this.jdField_a_of_type_Int) || (j != this.b))
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("NavBarAIO", 4, "adjustTitleDimension onGlobalLayout lw_now:" + j + " rw_now:" + i + " lw:" + this.b + " rw:" + this.jdField_a_of_type_Int);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.b();
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarAIO.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbpt
 * JD-Core Version:    0.7.0.1
 */