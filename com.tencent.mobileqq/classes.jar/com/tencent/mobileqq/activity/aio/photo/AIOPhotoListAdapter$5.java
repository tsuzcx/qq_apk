package com.tencent.mobileqq.activity.aio.photo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AIOPhotoListAdapter$5
  implements View.OnClickListener
{
  AIOPhotoListAdapter$5(AIOPhotoListAdapter paramAIOPhotoListAdapter, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((AIOPhotoListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter) == null) || (AIOPhotoListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter).a.a(this.jdField_a_of_type_JavaLangString) == null))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = AIOPhotoListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter).a.a(this.jdField_a_of_type_JavaLangString, AIOPhotoListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter).jdField_d_of_type_Int, AIOPhotoListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter).jdField_d_of_type_JavaUtilList);
    String str2 = AIOPhotoListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter) + "";
    if (bool) {}
    for (String str1 = "1";; str1 = "2")
    {
      ReportController.b(null, "dc00898", "", "", "0X800AC87", "0X800AC87", 1, 0, str2, str1, "", "");
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOPhotoListAdapter.notifyDataSetChanged();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter.5
 * JD-Core Version:    0.7.0.1
 */