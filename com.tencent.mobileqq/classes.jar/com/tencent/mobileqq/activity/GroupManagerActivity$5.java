package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialogWtihInput;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GroupManagerActivity$5
  implements DialogInterface.OnClickListener
{
  GroupManagerActivity$5(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Object localObject = GroupManagerActivity.a(this.a).getInputValue();
    paramDialogInterface = (DialogInterface)localObject;
    if (((String)localObject).equals("")) {
      paramDialogInterface = this.a.getResources().getString(2131693060);
    }
    paramInt = GroupManagerActivity.a(this.a);
    byte b = 1;
    if (paramInt == 0)
    {
      if (this.a.a.size() > 0) {
        b = (byte)(((Groups)this.a.a.get(this.a.a.size() - 1)).seqid + 1);
      }
      localObject = this.a;
      GroupManagerActivity.a((GroupManagerActivity)localObject, ((GroupManagerActivity)localObject).a(b, paramDialogInterface));
      if (QLog.isColorLevel())
      {
        paramDialogInterface = new StringBuilder();
        paramDialogInterface.append("AddFriendGroup needShowDialog = ");
        paramDialogInterface.append(GroupManagerActivity.a(this.a));
        QLog.d("GroupManagerActivity", 2, paramDialogInterface.toString());
      }
      if (GroupManagerActivity.a(this.a)) {
        this.a.a(2131693094);
      }
      ReportController.b(this.a.app, "CliOper", "", "", "category", "Add_category", 0, 0, "", "", "", "");
      return;
    }
    if (1 == GroupManagerActivity.a(this.a))
    {
      localObject = this.a;
      GroupManagerActivity.a((GroupManagerActivity)localObject, ((GroupManagerActivity)localObject).b((byte)GroupManagerActivity.a((GroupManagerActivity)localObject).group_id, paramDialogInterface));
      if (QLog.isColorLevel())
      {
        paramDialogInterface = new StringBuilder();
        paramDialogInterface.append("EditeFriendGroup needShowDialog = ");
        paramDialogInterface.append(GroupManagerActivity.a(this.a));
        QLog.d("GroupManagerActivity", 2, paramDialogInterface.toString());
      }
      if (GroupManagerActivity.a(this.a)) {
        this.a.a(2131693097);
      }
      ReportController.b(this.a.app, "CliOper", "", "", "category", "Name_category", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.5
 * JD-Core Version:    0.7.0.1
 */