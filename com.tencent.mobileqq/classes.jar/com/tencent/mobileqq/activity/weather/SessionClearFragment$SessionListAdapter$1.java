package com.tencent.mobileqq.activity.weather;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.message.messageclean.CleanMessageItemInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class SessionClearFragment$SessionListAdapter$1
  implements View.OnClickListener
{
  SessionClearFragment$SessionListAdapter$1(SessionClearFragment.SessionListAdapter paramSessionListAdapter, SessionClearFragment.SessionHolder paramSessionHolder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionHolder.a.isChecked()) {}
    for (((CleanMessageItemInfo)this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.a.get(this.jdField_a_of_type_Int)).a = false;; ((CleanMessageItemInfo)this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.a.get(this.jdField_a_of_type_Int)).a = true)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.notifyItemChanged(this.jdField_a_of_type_Int);
      this.jdField_a_of_type_ComTencentMobileqqActivityWeatherSessionClearFragment$SessionListAdapter.a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment.SessionListAdapter.1
 * JD-Core Version:    0.7.0.1
 */