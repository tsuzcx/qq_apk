package com.tencent.av.wtogether.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ImageButton;
import android.widget.TextView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.widget.CountdownTimeTask;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class GroupFileSearchDialog$5
  implements TextWatcher
{
  GroupFileSearchDialog$5(GroupFileSearchDialog paramGroupFileSearchDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.a.e)
    {
      this.a.e = false;
      return;
    }
    if (paramEditable == null) {
      paramEditable = "";
    } else {
      paramEditable = paramEditable.toString();
    }
    if (paramEditable.trim().equals(""))
    {
      this.a.c();
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetImageButton.setVisibility(0);
    if (!NetworkUtil.isNetworkAvailable(this.a.jdField_a_of_type_AndroidAppActivity))
    {
      if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask.b();
        this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
      }
      this.a.b();
      return;
    }
    paramEditable = this.a;
    paramEditable.d = false;
    if (paramEditable.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask == null)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = new CountdownTimeTask(new GroupFileSearchDialog.5.1(this), 800);
      ThreadManager.post(this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask, 5, null, true);
      return;
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask.a() > 0L)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask.a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("GroupFileSearchDialog", 2, "!!!!!! 这是个什么情况,逻辑出错了 !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.a.e) && ((!this.a.e) || (this.a.jdField_b_of_type_Int > 0)))
    {
      this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.a.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.5
 * JD-Core Version:    0.7.0.1
 */