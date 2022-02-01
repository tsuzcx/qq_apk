import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.NegativeChildrenLayout;

class blcp
  implements View.OnClickListener
{
  blcp(blcn paramblcn) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      this.a.dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.a.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.a.jdField_a_of_type_JavaUtilArrayList, anvx.a(2131705408), this.a.jdField_a_of_type_Blcs);
      this.a.a(true);
      this.a.r = 1;
      this.a.c = anvx.a(2131705413);
      blcn.a(this.a, paramView.getTag(), false);
      continue;
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.getParent();
      this.a.jdField_a_of_type_ComTencentWidgetNegativeChildrenLayout.setData(this.a.jdField_b_of_type_JavaUtilArrayList, anvx.a(2131705407), this.a.jdField_a_of_type_Blcs);
      this.a.a(true);
      this.a.r = 2;
      this.a.c = anvx.a(2131705416);
      blcn.a(this.a, paramView.getTag(), false);
      continue;
      this.a.c(paramView);
      this.a.c();
      this.a.r = 3;
      this.a.c = anvx.a(2131705412);
      blcn.a(this.a, paramView.getTag(), true);
      continue;
      this.a.c(paramView);
      this.a.c();
      this.a.r = 4;
      this.a.c = this.a.jdField_b_of_type_JavaLangString;
      blcn.a(this.a, paramView.getTag(), false);
      continue;
      this.a.c(paramView);
      this.a.c();
      this.a.r = 5;
      this.a.c = BaseApplicationImpl.getContext().getString(2131717772);
      blcn.a(this.a, paramView.getTag(), false);
      continue;
      this.a.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcp
 * JD-Core Version:    0.7.0.1
 */