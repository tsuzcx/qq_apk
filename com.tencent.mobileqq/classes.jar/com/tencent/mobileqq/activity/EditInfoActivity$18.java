package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.qphone.base.util.QLog;

class EditInfoActivity$18
  extends TroopBusinessObserver
{
  EditInfoActivity$18(EditInfoActivity paramEditInfoActivity) {}
  
  public void onGetTroopMemberAutoRemark(boolean paramBoolean, String paramString1, String paramString2)
  {
    if (paramBoolean)
    {
      if ((paramString1 != null) && (paramString1.equals(this.a.f)) && (!TextUtils.isEmpty(paramString2)) && (this.a.a != null))
      {
        this.a.a.setText(paramString2);
        this.a.a.setSelection(paramString2.length());
      }
      if (QLog.isColorLevel()) {
        QLog.d("EditInfoActivity", 2, new Object[] { paramString1, paramString2 });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.18
 * JD-Core Version:    0.7.0.1
 */