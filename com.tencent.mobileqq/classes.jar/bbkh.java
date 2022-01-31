import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.mobileqq.widget.NewStyleDropdownView.2.1;
import com.tencent.qphone.base.util.QLog;

public class bbkh
  implements View.OnClickListener
{
  public bbkh(NewStyleDropdownView paramNewStyleDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Bbki.clearFocus();
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_Bbki.getWindowToken(), 0);
    Drawable localDrawable;
    StringBuilder localStringBuilder;
    if ((this.a.jdField_a_of_type_Bbki.getAdapter() != null) && (this.a.jdField_a_of_type_Bbki.getAdapter().getCount() > 0))
    {
      int i = this.a.jdField_a_of_type_Bbki.getAdapter().getCount();
      if (i >= 5) {
        break label323;
      }
      int j = aciy.a(7.5F, this.a.getResources());
      int k = aciy.a(40.0F, this.a.getResources());
      this.a.jdField_a_of_type_Bbki.setDropDownHeight(i * (j * 2 + k) + j * 2);
      localDrawable = ((ImageView)paramView).getDrawable();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("arrow clicked, drawable is down=");
        if (localDrawable != this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) {
          break label348;
        }
      }
    }
    label323:
    label348:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("NewStyleDropdownView", 2, bool + ", isLastDropDown=" + this.a.jdField_a_of_type_Boolean);
      if ((localDrawable != this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) || (this.a.jdField_a_of_type_Boolean)) {
        break label354;
      }
      if (this.a.jdField_a_of_type_Bbkj != null) {
        this.a.jdField_a_of_type_Bbkj.c(false);
      }
      NewStyleDropdownView.a(this.a).postDelayed(new NewStyleDropdownView.2.1(this, paramView), 500L);
      paramView = paramView.getContext();
      if ((paramView != null) && ((paramView instanceof LoginActivity))) {
        awqx.a(((LoginActivity)paramView).app, "dc00898", "", "", "0X8007367", "0X8007367", 0, 0, "", "", "", "");
      }
      return;
      this.a.jdField_a_of_type_Bbki.setDropDownHeight(aciy.a(251.5F, this.a.getResources()));
      break;
    }
    label354:
    if (this.a.jdField_a_of_type_Bbkj != null) {
      this.a.jdField_a_of_type_Bbkj.c(true);
    }
    this.a.jdField_a_of_type_Bbki.dismissDropDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbkh
 * JD-Core Version:    0.7.0.1
 */