import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.NegativeChildrenLayout;

class bhts
  implements View.OnClickListener
{
  bhts(bhtq parambhtq) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.a.dismiss();
      return;
    case 2131371022: 
      this.a.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.a.jdField_a_of_type_JavaUtilArrayList, alpo.a(2131706307), this.a.jdField_a_of_type_Bhtv);
      this.a.a(true);
      this.a.r = 1;
      this.a.c = alpo.a(2131706312);
      bhtq.a(this.a, paramView.getTag(), false);
      return;
    case 2131371018: 
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
      this.a.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.a.jdField_b_of_type_JavaUtilArrayList, alpo.a(2131706306), this.a.jdField_a_of_type_Bhtv);
      this.a.a(true);
      this.a.r = 2;
      this.a.c = alpo.a(2131706315);
      bhtq.a(this.a, paramView.getTag(), false);
      return;
    case 2131371024: 
      this.a.c(paramView);
      this.a.c();
      this.a.r = 3;
      this.a.c = alpo.a(2131706311);
      bhtq.a(this.a, paramView.getTag(), true);
      return;
    case 2131371021: 
      this.a.c(paramView);
      this.a.c();
      this.a.r = 4;
      this.a.c = this.a.jdField_b_of_type_JavaLangString;
      bhtq.a(this.a, paramView.getTag(), false);
      return;
    case 2131371020: 
      this.a.c(paramView);
      this.a.c();
      this.a.r = 5;
      this.a.c = BaseApplicationImpl.getContext().getString(2131718912);
      bhtq.a(this.a, paramView.getTag(), false);
      return;
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhts
 * JD-Core Version:    0.7.0.1
 */