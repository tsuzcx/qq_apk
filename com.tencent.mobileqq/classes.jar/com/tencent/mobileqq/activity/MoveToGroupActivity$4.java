package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class MoveToGroupActivity$4
  implements DialogInterface.OnClickListener
{
  MoveToGroupActivity$4(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = MoveToGroupActivity.a(this.a).getInputValue();
    paramDialogInterface = (DialogInterface)localObject;
    if (((String)localObject).equals("")) {
      paramDialogInterface = this.a.getResources().getString(2131693060);
    }
    paramInt = MoveToGroupActivity.a(this.a).size();
    byte b = 1;
    if (paramInt > 0) {
      b = (byte)(((Groups)MoveToGroupActivity.a(this.a).get(MoveToGroupActivity.a(this.a).size() - 1)).seqid + 1);
    }
    localObject = this.a;
    MoveToGroupActivity.b((MoveToGroupActivity)localObject, ((MoveToGroupActivity)localObject).a(b, paramDialogInterface));
    if (QLog.isColorLevel())
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("AddFriendGroup needShowDialog = ");
      paramDialogInterface.append(MoveToGroupActivity.a(this.a));
      QLog.d("MoveToGroupActivity", 2, paramDialogInterface.toString());
    }
    if (MoveToGroupActivity.a(this.a)) {
      this.a.a(2131693094);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity.4
 * JD-Core Version:    0.7.0.1
 */