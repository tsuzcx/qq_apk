package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class EditLocalVideoActivity$12
  implements ActionSheet.OnButtonClickListener
{
  EditLocalVideoActivity$12(EditLocalVideoActivity paramEditLocalVideoActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity.a("608", "4", "2", true);
      EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity, 0);
      EditLocalVideoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity, 0);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity;
      EditLocalVideoActivity.c(paramView, EditLocalVideoActivity.b(paramView));
      EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity).postDelayed(new EditLocalVideoActivity.12.1(this), 300L);
      EditLocalVideoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity, false);
      EditLocalVideoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditLocalVideoActivity, false);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.12
 * JD-Core Version:    0.7.0.1
 */