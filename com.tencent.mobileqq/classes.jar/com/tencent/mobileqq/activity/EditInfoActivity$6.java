package com.tencent.mobileqq.activity;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.PresetWordsListAdapter;
import com.tencent.mobileqq.troop.activity.PresetWordsListAdapter.OnItemEventListener;
import com.tencent.mobileqq.troop.activity.PresetWordsListAdapter.ViewHolder;
import java.util.ArrayList;

class EditInfoActivity$6
  implements PresetWordsListAdapter.OnItemEventListener
{
  EditInfoActivity$6(EditInfoActivity paramEditInfoActivity) {}
  
  public void a(View paramView, int paramInt, PresetWordsListAdapter.ViewHolder paramViewHolder)
  {
    if ((paramInt >= 0) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() > paramInt))
    {
      int i = this.a.jdField_a_of_type_AndroidWidgetEditText.getSelectionStart();
      this.a.jdField_a_of_type_AndroidWidgetEditText.getText().insert(i, this.a.jdField_a_of_type_ComTencentMobileqqTroopActivityPresetWordsListAdapter.a(paramInt));
      ReportController.b(this.a.app, "dc00899", "Grp_set", "", "nickname edit", "nickname edit_def_click", 0, 0, String.valueOf(this.a.e), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.6
 * JD-Core Version:    0.7.0.1
 */