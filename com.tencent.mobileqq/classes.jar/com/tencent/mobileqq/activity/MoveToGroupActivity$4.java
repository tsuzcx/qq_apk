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
    Object localObject = MoveToGroupActivity.e(this.a).getInputValue();
    paramDialogInterface = (DialogInterface)localObject;
    if (((String)localObject).equals("")) {
      paramDialogInterface = this.a.getResources().getString(2131890174);
    }
    paramInt = MoveToGroupActivity.c(this.a).size();
    byte b = 1;
    if (paramInt > 0) {
      b = (byte)(((Groups)MoveToGroupActivity.c(this.a).get(MoveToGroupActivity.c(this.a).size() - 1)).seqid + 1);
    }
    localObject = this.a;
    MoveToGroupActivity.b((MoveToGroupActivity)localObject, ((MoveToGroupActivity)localObject).a(b, paramDialogInterface));
    if (QLog.isColorLevel())
    {
      paramDialogInterface = new StringBuilder();
      paramDialogInterface.append("AddFriendGroup needShowDialog = ");
      paramDialogInterface.append(MoveToGroupActivity.f(this.a));
      QLog.d("MoveToGroupActivity", 2, paramDialogInterface.toString());
    }
    if (MoveToGroupActivity.f(this.a)) {
      this.a.a(2131890208);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MoveToGroupActivity.4
 * JD-Core Version:    0.7.0.1
 */