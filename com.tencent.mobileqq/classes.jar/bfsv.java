import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.NegativeChildrenLayout;

class bfsv
  implements View.OnClickListener
{
  bfsv(bfst parambfst) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.a.dismiss();
      return;
    case 2131370711: 
      this.a.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.a.jdField_a_of_type_JavaUtilArrayList, ajya.a(2131705935), this.a.jdField_a_of_type_Bfsy);
      this.a.a(true);
      this.a.r = 1;
      this.a.c = ajya.a(2131705940);
      bfst.a(this.a, paramView.getTag(), false);
      return;
    case 2131370707: 
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
      this.a.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.a.jdField_b_of_type_JavaUtilArrayList, ajya.a(2131705934), this.a.jdField_a_of_type_Bfsy);
      this.a.a(true);
      this.a.r = 2;
      this.a.c = ajya.a(2131705943);
      bfst.a(this.a, paramView.getTag(), false);
      return;
    case 2131370713: 
      this.a.c(paramView);
      this.a.c();
      this.a.r = 3;
      this.a.c = ajya.a(2131705939);
      bfst.a(this.a, paramView.getTag(), true);
      return;
    case 2131370710: 
      this.a.c(paramView);
      this.a.c();
      this.a.r = 4;
      this.a.c = this.a.jdField_b_of_type_JavaLangString;
      bfst.a(this.a, paramView.getTag(), false);
      return;
    case 2131370709: 
      this.a.c(paramView);
      this.a.c();
      this.a.r = 5;
      this.a.c = BaseApplicationImpl.getContext().getString(2131718479);
      bfst.a(this.a, paramView.getTag(), false);
      return;
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bfsv
 * JD-Core Version:    0.7.0.1
 */