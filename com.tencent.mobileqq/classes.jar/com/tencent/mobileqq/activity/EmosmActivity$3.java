package com.tencent.mobileqq.activity;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.emosm.view.DragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQBlurView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EmosmActivity$3
  implements View.OnClickListener
{
  EmosmActivity$3(EmosmActivity paramEmosmActivity) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.jdField_b_of_type_Boolean)
    {
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131692203);
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(true);
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a(true);
      this.a.jdField_b_of_type_Boolean = true;
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
      this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      EmosmActivity.a(this.a).setVisibility(0);
      EmosmActivity.a(this.a).setVisibility(0);
      this.a.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      this.a.setTitle(String.format(this.a.getResources().getString(2131692202), new Object[] { Integer.valueOf(0) }));
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setPadding(0, 0, 0, ViewUtils.a(44.0F));
      ReportController.b(this.a.app, "CliOper", "", "", "EmosSetting", "EpsEdit", 0, 0, "", "", "", "");
      if (this.a.jdField_b_of_type_Int == 1) {
        ReportController.b(this.a.app, "dc00898", "", "", "0X800AB0F", "0X800AB0F", 0, 0, "", "", "", "");
      }
    }
    while ((this.a.jdField_a_of_type_Int != 2) && (this.a.jdField_a_of_type_Int != 1)) {
      for (;;)
      {
        this.a.a(this.a.jdField_b_of_type_Boolean);
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        ReportController.b(this.a.app, "dc00898", "", "", "0X800AB16", "0X800AB16", 0, 0, "", "", "", "");
      }
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(2131692201);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setDragEnabled(false);
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a(false);
    this.a.f();
    this.a.jdField_b_of_type_Boolean = false;
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.notifyDataSetChanged();
    this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortAdapter.a();
    this.a.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
    EmosmActivity.a(this.a).setVisibility(8);
    EmosmActivity.a(this.a).setVisibility(8);
    if (this.a.jdField_b_of_type_Int == 2) {
      this.a.setTitle(2131691996);
    }
    for (;;)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.setPadding(0, 0, 0, 0);
      break;
      this.a.setTitle(2131692210);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.3
 * JD-Core Version:    0.7.0.1
 */