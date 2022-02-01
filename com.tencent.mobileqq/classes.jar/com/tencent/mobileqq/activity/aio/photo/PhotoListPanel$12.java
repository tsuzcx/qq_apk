package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.LinkedList;

class PhotoListPanel$12
  implements Runnable
{
  PhotoListPanel$12(PhotoListPanel paramPhotoListPanel) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694896);
    if (PhotoListPanel.a(this.this$0)) {
      localObject1 = this.this$0.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694898);
    }
    if (this.this$0.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      bool = true;
      Object localObject2 = localObject1;
      if (bool)
      {
        this.this$0.c.setContentDescription((String)localObject1 + this.this$0.jdField_a_of_type_JavaUtilLinkedList.size() + HardCodeUtil.a(2131708084));
        localObject2 = (String)localObject1 + "(" + this.this$0.jdField_a_of_type_JavaUtilLinkedList.size() + ")";
      }
      this.this$0.c.setText((CharSequence)localObject2);
      this.this$0.c.setEnabled(bool);
      if (bool) {
        break label270;
      }
      this.this$0.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.this$0.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.this$0.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.this$0.j();
    }
    for (;;)
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener.a(this.this$0.d());
      }
      return;
      bool = false;
      break;
      label270:
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a((String)this.this$0.jdField_a_of_type_JavaUtilLinkedList.peek()) != 1) {
        break label339;
      }
      this.this$0.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      if (!this.this$0.h) {
        this.this$0.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
      }
      this.this$0.j();
    }
    label339:
    this.this$0.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.this$0.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
    localObject1 = this.this$0.jdField_b_of_type_AndroidWidgetButton;
    if ((this.this$0.jdField_a_of_type_JavaUtilLinkedList.size() == 1) && (!PhotoListPanel.a(this.this$0))) {}
    for (boolean bool = true;; bool = false)
    {
      ((Button)localObject1).setEnabled(bool);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.12
 * JD-Core Version:    0.7.0.1
 */