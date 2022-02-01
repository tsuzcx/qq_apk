package com.tencent.aelight.camera.ae.play;

import android.graphics.Color;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;

class EditTextDialog$1
  implements TextWatcher
{
  EditTextDialog$1(EditTextDialog paramEditTextDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int j = paramEditable.length();
    int i = 0;
    paramEditable = String.format("%d/%d", new Object[] { Integer.valueOf(j), Integer.valueOf(EditTextDialog.access$000(this.this$0)) });
    if (j > EditTextDialog.access$000(this.this$0))
    {
      paramEditable = new SpannableString(paramEditable);
      int k = String.valueOf(j).length();
      paramEditable.setSpan(new ForegroundColorSpan(Color.parseColor("#12b7f5")), 0, k, 33);
      EditTextDialog.access$100(this.this$0).setText(paramEditable);
    }
    else
    {
      EditTextDialog.access$100(this.this$0).setText(paramEditable);
    }
    paramEditable = EditTextDialog.access$200(this.this$0);
    if (j <= 0) {
      i = 8;
    }
    paramEditable.setVisibility(i);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.play.EditTextDialog.1
 * JD-Core Version:    0.7.0.1
 */