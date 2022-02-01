package com.tencent.mobileqq.activity.messagesearch;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.history.link.search.LinkMessageResultAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

class LinkMessageSearchDialog$1
  implements TextWatcher
{
  LinkMessageSearchDialog$1(LinkMessageSearchDialog paramLinkMessageSearchDialog) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a.d.getText().toString().trim();
    if (paramEditable.length() == 0)
    {
      paramEditable = this.a;
      paramEditable.A = "";
      paramEditable.findViewById(2131435215).setVisibility(8);
      this.a.q.setVisibility(8);
      this.a.o.a();
      this.a.u.setVisibility(8);
      return;
    }
    if (!this.a.A.equals(paramEditable))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("afterTextChanged, lastChangedKeyword = ");
        ((StringBuilder)localObject).append(this.a.A);
        ((StringBuilder)localObject).append(",lastKeyWord:");
        ((StringBuilder)localObject).append(paramEditable);
        QLog.i("LinkMessageSearchDialog", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = this.a;
      ((LinkMessageSearchDialog)localObject).A = paramEditable;
      ((LinkMessageSearchDialog)localObject).findViewById(2131435215).setVisibility(0);
      this.a.b.setVisibility(0);
      this.a.a();
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.messagesearch.LinkMessageSearchDialog.1
 * JD-Core Version:    0.7.0.1
 */