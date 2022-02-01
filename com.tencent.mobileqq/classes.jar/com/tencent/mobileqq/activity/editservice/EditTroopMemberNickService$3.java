package com.tencent.mobileqq.activity.editservice;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.activity.PresetWordsListAdapter;
import com.tencent.mobileqq.troop.activity.PresetWordsListAdapter.OnItemEventListener;
import com.tencent.mobileqq.troop.activity.PresetWordsListAdapter.ViewHolder;
import java.util.ArrayList;

class EditTroopMemberNickService$3
  implements PresetWordsListAdapter.OnItemEventListener
{
  EditTroopMemberNickService$3(EditTroopMemberNickService paramEditTroopMemberNickService) {}
  
  public void a(View paramView, int paramInt, PresetWordsListAdapter.ViewHolder paramViewHolder)
  {
    if ((paramInt >= 0) && (this.a.o.size() > paramInt))
    {
      int i = this.a.a.getSelectionStart();
      this.a.a.getText().insert(i, this.a.n.a(paramInt));
      ReportController.b(EditTroopMemberNickService.b(this.a), "dc00899", "Grp_set", "", "nickname edit", "nickname edit_def_click", 0, 0, String.valueOf(this.a.j), "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.editservice.EditTroopMemberNickService.3
 * JD-Core Version:    0.7.0.1
 */