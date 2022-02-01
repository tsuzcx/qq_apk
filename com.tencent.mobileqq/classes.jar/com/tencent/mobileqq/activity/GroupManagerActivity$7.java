package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.adapter.GroupEditeDragSortAdapter;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.emosm.view.DragSortListView.DropListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.List;

class GroupManagerActivity$7
  implements DragSortListView.DropListener
{
  GroupManagerActivity$7(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void a_(int paramInt1, int paramInt2)
  {
    if (paramInt1 == paramInt2) {
      return;
    }
    int m = this.a.a.size();
    Object localObject = this.a;
    ((GroupManagerActivity)localObject).b = new byte[m];
    ((GroupManagerActivity)localObject).c = new byte[m];
    int k = 0;
    int i = 0;
    while (i < m)
    {
      this.a.b[i] = ((byte)((Groups)this.a.a.get(i)).group_id);
      i += 1;
    }
    int j;
    if (paramInt2 < paramInt1)
    {
      j = m - 1;
      for (;;)
      {
        i = k;
        if (j < 0) {
          break;
        }
        if ((paramInt2 < j) && (j <= paramInt1)) {
          this.a.c[j] = this.a.b[(j - 1)];
        } else if (j == paramInt2) {
          this.a.c[j] = this.a.b[paramInt1];
        } else {
          this.a.c[j] = this.a.b[j];
        }
        j -= 1;
      }
    }
    i = k;
    if (paramInt1 < paramInt2)
    {
      j = 0;
      for (;;)
      {
        i = k;
        if (j >= m) {
          break;
        }
        if ((j >= paramInt1) && (paramInt2 >= j))
        {
          if (j == paramInt2) {
            this.a.c[j] = this.a.b[paramInt1];
          } else {
            this.a.c[j] = this.a.b[(j + 1)];
          }
        }
        else {
          this.a.c[j] = this.a.b[j];
        }
        j += 1;
      }
    }
    while (i < m)
    {
      this.a.b[i] = ((byte)i);
      i += 1;
    }
    if (paramInt2 < paramInt1)
    {
      localObject = (Groups)this.a.a.remove(paramInt1);
      this.a.a.add(paramInt2, localObject);
    }
    else if (paramInt1 < paramInt2)
    {
      localObject = (Groups)this.a.a.remove(paramInt1);
      this.a.a.add(paramInt2, localObject);
    }
    GroupManagerActivity.g(this.a).notifyDataSetChanged();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DragSortListView.DropListener onDrop groupIdList = ");
      ((StringBuilder)localObject).append(Arrays.toString(this.a.c));
      QLog.d("GroupManagerActivity", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("DragSortListView.DropListener onDrop sortIdList = ");
      ((StringBuilder)localObject).append(Arrays.toString(this.a.b));
      QLog.d("GroupManagerActivity", 2, ((StringBuilder)localObject).toString());
    }
    localObject = this.a;
    GroupManagerActivity.a((GroupManagerActivity)localObject, ((GroupManagerActivity)localObject).a(((GroupManagerActivity)localObject).c, this.a.b));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SortFriendGroup needShowDialog = ");
      ((StringBuilder)localObject).append(GroupManagerActivity.f(this.a));
      QLog.d("GroupManagerActivity", 2, ((StringBuilder)localObject).toString());
    }
    if (GroupManagerActivity.f(this.a)) {
      this.a.a(2131890213);
    } else {
      this.a.a();
    }
    ReportController.b(this.a.app, "CliOper", "", "", "category", "Move_category", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.7
 * JD-Core Version:    0.7.0.1
 */