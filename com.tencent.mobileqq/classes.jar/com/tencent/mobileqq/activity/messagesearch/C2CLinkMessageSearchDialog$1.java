package com.tencent.mobileqq.activity.messagesearch;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

class C2CLinkMessageSearchDialog$1
  implements TextWatcher
{
  C2CLinkMessageSearchDialog$1(C2CLinkMessageSearchDialog paramC2CLinkMessageSearchDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.d.getText().toString().trim();
    if (paramEditable.length() == 0)
    {
      paramEditable = this.a;
      paramEditable.y = "";
      paramEditable.findViewById(2131435215).setVisibility(8);
      this.a.p.setVisibility(8);
      this.a.n.a();
      this.a.s.setVisibility(8);
      return;
    }
    if (!this.a.y.equals(paramEditable))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("afterTextChanged, lastChangedKeyword = ");
        ((StringBuilder)localObject).append(this.a.y);
        ((StringBuilder)localObject).append(",lastKeyWord:");
        ((StringBuilder)localObject).append(paramEditable);
        QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.a;
      ((C2CLinkMessageSearchDialog)localObject).y = paramEditable;
      ((C2CLinkMessageSearchDialog)localObject).findViewById(2131435215).setVisibility(0);
      this.a.b.setVisibility(0);
      this.a.a();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.C2CLinkMessageSearchDialog.1
 * JD-Core Version:    0.7.0.1
 */