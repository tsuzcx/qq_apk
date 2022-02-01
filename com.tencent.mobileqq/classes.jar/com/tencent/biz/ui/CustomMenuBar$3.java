package com.tencent.biz.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CustomMenuBar$3
  implements View.OnClickListener
{
  CustomMenuBar$3(CustomMenuBar paramCustomMenuBar, ImageView paramImageView, TextView paramTextView, PopupMenu paramPopupMenu, String paramString1, int paramInt, String paramString2) {}
  
  public void onClick(View paramView)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupWindows != null) {
          break label209;
        }
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843479);
        if (CustomMenuBar.a())
        {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131167185));
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_ComTencentBizUiPopupMenu.a(paramView);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupWindows = this.jdField_a_of_type_ComTencentBizUiPopupMenu;
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.jdField_a_of_type_Int), this.b, String.valueOf(0), false);
          continue;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131167054));
      }
      finally {}
      continue;
      label209:
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupWindows == this.jdField_a_of_type_ComTencentBizUiPopupMenu)
      {
        if (!this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b)
        {
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean) {}
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843479);
          if (CustomMenuBar.a()) {
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131167185));
          }
          for (;;)
          {
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
            this.jdField_a_of_type_ComTencentBizUiPopupMenu.a(paramView);
            this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
            ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.jdField_a_of_type_Int), this.b, String.valueOf(0), false);
            break;
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131167054));
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
        }
      }
      else {
        if (!this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean) {
          break;
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843479);
    if (CustomMenuBar.a()) {
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131167185));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_ComTencentBizUiPopupMenu.a(paramView);
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupWindows = this.jdField_a_of_type_ComTencentBizUiPopupMenu;
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.jdField_a_of_type_Int), this.b, String.valueOf(0), false);
      break;
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131167054));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar.3
 * JD-Core Version:    0.7.0.1
 */