package com.tencent.mobileqq.activity.home;

import android.util.Pair;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.List;

class MainFragment$5
  implements ActionSheet.OnButtonClickListener
{
  MainFragment$5(MainFragment paramMainFragment, List paramList, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment.e();
    if ((paramInt < 0) && (paramInt >= this.jdField_a_of_type_JavaUtilList.size())) {
      return;
    }
    try
    {
      MainFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityHomeMainFragment, ((Integer)((Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt)).first).intValue(), (MainFragment.OverallMenuInfo)((Pair)this.jdField_a_of_type_JavaUtilList.get(paramInt)).second);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      return;
    }
    catch (Throwable paramView)
    {
      paramView.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.MainFragment.5
 * JD-Core Version:    0.7.0.1
 */