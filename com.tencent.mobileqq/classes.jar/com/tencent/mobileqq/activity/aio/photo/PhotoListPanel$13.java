package com.tencent.mobileqq.activity.aio.photo;

import android.app.Activity;
import android.content.res.Resources;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.LinkedList;

class PhotoListPanel$13
  implements Runnable
{
  PhotoListPanel$13(PhotoListPanel paramPhotoListPanel) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694885);
    if (PhotoListPanel.a(this.this$0)) {
      localObject1 = this.this$0.jdField_a_of_type_AndroidAppActivity.getResources().getString(2131694887);
    }
    int i = this.this$0.jdField_a_of_type_JavaUtilLinkedList.size();
    boolean bool2 = false;
    boolean bool1;
    if (i > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Object localObject2 = localObject1;
    if (bool1)
    {
      localObject2 = this.this$0.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(this.this$0.jdField_a_of_type_JavaUtilLinkedList.size());
      localStringBuilder.append(HardCodeUtil.a(2131708103));
      ((Button)localObject2).setContentDescription(localStringBuilder.toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("(");
      ((StringBuilder)localObject2).append(this.this$0.jdField_a_of_type_JavaUtilLinkedList.size());
      ((StringBuilder)localObject2).append(")");
      localObject2 = ((StringBuilder)localObject2).toString();
    }
    this.this$0.c.setText((CharSequence)localObject2);
    this.this$0.c.setEnabled(bool1);
    if (!bool1)
    {
      this.this$0.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
      this.this$0.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.this$0.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
      this.this$0.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      this.this$0.k();
    }
    else
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$PhotoPanelAdapter.a((String)this.this$0.jdField_a_of_type_JavaUtilLinkedList.peek()) == 1)
      {
        this.this$0.jdField_b_of_type_AndroidWidgetButton.setEnabled(false);
        if (!this.this$0.h) {
          this.this$0.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
        }
      }
      else
      {
        this.this$0.jdField_a_of_type_AndroidWidgetCheckBox.setEnabled(true);
        this.this$0.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
        this.this$0.jdField_b_of_type_AndroidWidgetTextView.setEnabled(true);
        localObject1 = this.this$0.jdField_b_of_type_AndroidWidgetButton;
        bool1 = bool2;
        if (this.this$0.jdField_a_of_type_JavaUtilLinkedList.size() == 1)
        {
          bool1 = bool2;
          if (!PhotoListPanel.a(this.this$0)) {
            bool1 = true;
          }
        }
        ((Button)localObject1).setEnabled(bool1);
      }
      this.this$0.k();
    }
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener != null) {
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoPhotoListPanel$ImageCountChangedListener.a(this.this$0.d());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanel.13
 * JD-Core Version:    0.7.0.1
 */