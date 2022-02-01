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
    if (this.a.v)
    {
      this.a.v = false;
      return;
    }
    if (paramEditable == null) {
      paramEditable = "";
    } else {
      paramEditable = paramEditable.toString();
    }
    if (paramEditable.trim().equals(""))
    {
      this.a.d();
      return;
    }
    this.a.f.setVisibility(0);
    if (!NetworkUtil.isNetworkAvailable(this.a.m))
    {
      if (this.a.o != null)
      {
        this.a.o.b();
        this.a.o = null;
      }
      this.a.b();
      return;
    }
    paramEditable = this.a;
    paramEditable.u = false;
    if (paramEditable.o == null)
    {
      this.a.o = new CountdownTimeTask(new GroupFileSearchDialog.5.1(this), 800);
      ThreadManager.post(this.a.o, 5, null, true);
      return;
    }
    if (this.a.o.c() > 0L)
    {
      this.a.o.a();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("GroupFileSearchDialog", 2, "!!!!!! 这是个什么情况,逻辑出错了 !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((this.a.v) && ((!this.a.v) || (this.a.A > 0)))
    {
      this.a.e.setVisibility(0);
      return;
    }
    this.a.e.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.wtogether.view.GroupFileSearchDialog.5
 * JD-Core Version:    0.7.0.1
 */