package com.tencent.biz.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CustomMenuBar$3
  implements View.OnClickListener
{
  CustomMenuBar$3(CustomMenuBar paramCustomMenuBar, ImageView paramImageView, TextView paramTextView, PopupMenu paramPopupMenu, String paramString1, int paramInt, String paramString2) {}
  
  public void onClick(View paramView)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupWindows == null)
      {
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean) {
          break label590;
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843393);
        if (CustomMenuBar.a()) {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131167210));
        } else {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131167077));
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentBizUiPopupMenu.a(paramView);
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupWindows = this.jdField_a_of_type_ComTencentBizUiPopupMenu;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.jdField_a_of_type_Int), this.b, String.valueOf(0), false);
      }
      else if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupWindows == this.jdField_a_of_type_ComTencentBizUiPopupMenu)
      {
        if (!this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b)
        {
          if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean) {
            break label590;
          }
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = true;
          this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843393);
          if (CustomMenuBar.a()) {
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131167210));
          } else {
            this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131167077));
          }
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
          this.jdField_a_of_type_ComTencentBizUiPopupMenu.a(paramView);
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
          ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.jdField_a_of_type_Int), this.b, String.valueOf(0), false);
        }
        else
        {
          this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
        }
      }
      else
      {
        if (this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean) {
          break label590;
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130843393);
        if (CustomMenuBar.a()) {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131167210));
        } else {
          this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.getResources().getColor(2131167077));
        }
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.b = false;
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_JavaLangRunnable);
        this.jdField_a_of_type_ComTencentBizUiPopupMenu.a(paramView);
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_AndroidViewView.setVisibility(0);
        this.jdField_a_of_type_ComTencentBizUiCustomMenuBar.jdField_a_of_type_ComTencentBizUiPopupWindows = this.jdField_a_of_type_ComTencentBizUiPopupMenu;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "P_CliOper", "Pb_account_lifeservice", this.jdField_a_of_type_JavaLangString, "mp_caidan_click", "aio_caidan_click", 0, 0, String.valueOf(1), String.valueOf(this.jdField_a_of_type_Int), this.b, String.valueOf(0), false);
      }
      label590:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.ui.CustomMenuBar.3
 * JD-Core Version:    0.7.0.1
 */