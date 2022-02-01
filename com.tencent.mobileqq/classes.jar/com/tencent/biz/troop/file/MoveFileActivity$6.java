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
    paramEditable = this.a.getText().toString().trim();
    TextView localTextView = this.b.getBtnight();
    if (TroopFileUtils.d(paramEditable))
    {
      localTextView.setEnabled(false);
      localTextView.setTextColor(this.c.getResources().getColor(2131165998));
      return;
    }
    localTextView.setEnabled(true);
    localTextView.setTextColor(this.c.getResources().getColor(2131165990));
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 > 0)
    {
      Object localObject = paramCharSequence.toString();
      paramCharSequence = TroopFileUtils.c((String)localObject);
      if ((localObject != null) && (!((String)localObject).equals(paramCharSequence)))
      {
        localObject = this.c;
        ((MoveFileActivity)localObject).c = paramInt1;
        ((MoveFileActivity)localObject).d = true;
        this.a.setText(paramCharSequence);
        return;
      }
      if (this.c.d)
      {
        this.a.setSelection(this.c.c);
        this.c.d = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troop.file.MoveFileActivity.6
 * JD-Core Version:    0.7.0.1
 */