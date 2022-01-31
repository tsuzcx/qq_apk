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

public class bcnf
  implements View.OnClickListener
{
  public bcnf(NewStyleDropdownView paramNewStyleDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Bcng.clearFocus();
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_Bcng.getWindowToken(), 0);
    Drawable localDrawable;
    StringBuilder localStringBuilder;
    if ((this.a.jdField_a_of_type_Bcng.getAdapter() != null) && (this.a.jdField_a_of_type_Bcng.getAdapter().getCount() > 0))
    {
      int i = this.a.jdField_a_of_type_Bcng.getAdapter().getCount();
      if (i >= 5) {
        break label323;
      }
      int j = actn.a(7.5F, this.a.getResources());
      int k = actn.a(40.0F, this.a.getResources());
      this.a.jdField_a_of_type_Bcng.setDropDownHeight(i * (j * 2 + k) + j * 2);
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
      if (this.a.jdField_a_of_type_Bcnh != null) {
        this.a.jdField_a_of_type_Bcnh.c(false);
      }
      NewStyleDropdownView.a(this.a).postDelayed(new NewStyleDropdownView.2.1(this, paramView), 500L);
      paramView = paramView.getContext();
      if ((paramView != null) && ((paramView instanceof LoginActivity))) {
        axqw.a(((LoginActivity)paramView).app, "dc00898", "", "", "0X8007367", "0X8007367", 0, 0, "", "", "", "");
      }
      return;
      this.a.jdField_a_of_type_Bcng.setDropDownHeight(actn.a(251.5F, this.a.getResources()));
      break;
    }
    label354:
    if (this.a.jdField_a_of_type_Bcnh != null) {
      this.a.jdField_a_of_type_Bcnh.c(true);
    }
    this.a.jdField_a_of_type_Bcng.dismissDropDown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcnf
 * JD-Core Version:    0.7.0.1
 */