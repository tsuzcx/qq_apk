package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortListView.RemoveListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class GroupManagerActivity$8
  implements DragSortListView.RemoveListener
{
  GroupManagerActivity$8(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void a(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RemoveListener which = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("GroupManagerActivity", 2, ((StringBuilder)localObject).toString());
    }
    paramInt -= 1;
    if ((paramInt >= 0) && (paramInt < this.a.a.size()))
    {
      localObject = (Groups)this.a.a.get(paramInt);
      byte b = (byte)((Groups)localObject).group_id;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("RemoveListener remove groupId :");
        localStringBuilder.append(b);
        QLog.d("GroupManagerActivity", 2, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("RemoveListener remove friend_count :");
        localStringBuilder.append(((Groups)localObject).group_friend_count);
        QLog.d("GroupManagerActivity", 2, localStringBuilder.toString());
      }
      if (b == 0)
      {
        localObject = new QQToast(this.a);
        ((QQToast)localObject).d(2000);
        ((QQToast)localObject).c(2131719712);
        ((QQToast)localObject).a();
        return;
      }
      GroupManagerActivity.a(this.a, b);
      ReportController.b(this.a.app, "CliOper", "", "", "category", "Delete_category", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.8
 * JD-Core Version:    0.7.0.1
 */