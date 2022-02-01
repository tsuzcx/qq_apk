package com.tencent.mobileqq.activity.contact.addcontact;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ClassificationSearchActivity$4
  implements View.OnClickListener
{
  ClassificationSearchActivity$4(ClassificationSearchActivity paramClassificationSearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
    if ((this.a.f != ClassificationSearchActivity.jdField_a_of_type_Int) && (this.a.f != ClassificationSearchActivity.d)) {
      this.a.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactSearchBaseFragment.d();
    } else {
      ClassificationSearchActivity.a(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ClassificationSearchActivity.4
 * JD-Core Version:    0.7.0.1
 */