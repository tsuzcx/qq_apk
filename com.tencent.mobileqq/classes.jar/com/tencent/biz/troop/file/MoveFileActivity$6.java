package com.tencent.biz.troop.file;

import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.biz.widgets.InputDialog;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;

class MoveFileActivity$6
  implements TextWatcher
{
  MoveFileActivity$6(MoveFileActivity paramMoveFileActivity, EditText paramEditText, InputDialog paramInputDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim();
    TextView localTextView = this.jdField_a_of_type_ComTencentBizWidgetsInputDialog.getBtnight();
    if (TroopFileUtils.b(paramEditable))
    {
      localTextView.setEnabled(false);
      localTextView.setTextColor(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getResources().getColor(2131165606));
      return;
    }
    localTextView.setEnabled(true);
    localTextView.setTextColor(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.getResources().getColor(2131165601));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0)
    {
      Object localObject = paramCharSequence.toString();
      paramCharSequence = TroopFileUtils.b((String)localObject);
      if ((localObject != null) && (!((String)localObject).equals(paramCharSequence)))
      {
        localObject = this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity;
        ((MoveFileActivity)localObject).jdField_a_of_type_Int = paramInt1;
        ((MoveFileActivity)localObject).jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidWidgetEditText.setText(paramCharSequence);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.jdField_a_of_type_Int);
        this.jdField_a_of_type_ComTencentBizTroopFileMoveFileActivity.jdField_a_of_type_Boolean = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.6
 * JD-Core Version:    0.7.0.1
 */