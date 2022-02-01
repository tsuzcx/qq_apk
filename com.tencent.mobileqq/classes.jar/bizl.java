import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.mobileqq.widget.NewStyleDropdownView.2.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bizl
  implements View.OnClickListener
{
  public bizl(NewStyleDropdownView paramNewStyleDropdownView) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_Bizm.clearFocus();
    this.a.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.a.jdField_a_of_type_Bizm.getWindowToken(), 0);
    boolean bool;
    if ((this.a.jdField_a_of_type_Bizm.getAdapter() != null) && (this.a.jdField_a_of_type_Bizm.getAdapter().getCount() > 0))
    {
      int i = this.a.jdField_a_of_type_Bizm.getAdapter().getCount();
      if (i >= 5) {
        break label334;
      }
      int j = agej.a(7.5F, this.a.getResources());
      int k = agej.a(40.0F, this.a.getResources());
      this.a.jdField_a_of_type_Bizm.setDropDownHeight(i * (j * 2 + k) + j * 2);
      Object localObject = ((ImageView)paramView).getDrawable();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("arrow clicked, drawable is down=");
        if (localObject != this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) {
          break label359;
        }
        bool = true;
        label177:
        QLog.d("NewStyleDropdownView", 2, bool + ", isLastDropDown=" + this.a.jdField_a_of_type_Boolean);
      }
      if ((localObject != this.a.jdField_a_of_type_AndroidGraphicsDrawableDrawable) || (this.a.jdField_a_of_type_Boolean)) {
        break label365;
      }
      if (this.a.jdField_a_of_type_Bizn != null) {
        this.a.jdField_a_of_type_Bizn.c(false);
      }
      NewStyleDropdownView.a(this.a).postDelayed(new NewStyleDropdownView.2.1(this, paramView), 500L);
      localObject = paramView.getContext();
      if ((localObject != null) && ((localObject instanceof LoginActivity))) {
        bdll.a(((LoginActivity)localObject).app, "dc00898", "", "", "0X8007367", "0X8007367", 0, 0, "", "", "", "");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label334:
      this.a.jdField_a_of_type_Bizm.setDropDownHeight(agej.a(251.5F, this.a.getResources()));
      break;
      label359:
      bool = false;
      break label177;
      label365:
      if (this.a.jdField_a_of_type_Bizn != null) {
        this.a.jdField_a_of_type_Bizn.c(true);
      }
      this.a.jdField_a_of_type_Bizm.dismissDropDown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bizl
 * JD-Core Version:    0.7.0.1
 */