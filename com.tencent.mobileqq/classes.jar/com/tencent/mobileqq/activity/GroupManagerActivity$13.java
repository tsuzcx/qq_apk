package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.qphone.base.util.QLog;

class GroupManagerActivity$13
  extends FriendListObserver
{
  GroupManagerActivity$13(GroupManagerActivity paramGroupManagerActivity) {}
  
  protected void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel())
    {
      paramGroupActionResp = new StringBuilder();
      paramGroupActionResp.append("onAddGroupResp isSuccess = ");
      paramGroupActionResp.append(paramBoolean);
      QLog.d("GroupManagerActivity", 2, paramGroupActionResp.toString());
    }
    this.a.a(paramBoolean);
    GroupManagerActivity.c(this.a, true);
  }
  
  protected void onDeleteGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel())
    {
      paramGroupActionResp = new StringBuilder();
      paramGroupActionResp.append("onDeleteGroupResp isSuccess = ");
      paramGroupActionResp.append(paramBoolean);
      QLog.d("GroupManagerActivity", 2, paramGroupActionResp.toString());
    }
    this.a.a(paramBoolean);
    GroupManagerActivity.c(this.a, true);
  }
  
  protected void onRenameGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel())
    {
      paramGroupActionResp = new StringBuilder();
      paramGroupActionResp.append("onRenameGroupResp isSuccess = ");
      paramGroupActionResp.append(paramBoolean);
      QLog.d("GroupManagerActivity", 2, paramGroupActionResp.toString());
    }
    this.a.a(paramBoolean);
    GroupManagerActivity.c(this.a, true);
  }
  
  protected void onResortGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel())
    {
      paramGroupActionResp = new StringBuilder();
      paramGroupActionResp.append("onResortGroupResp isSuccess = ");
      paramGroupActionResp.append(paramBoolean);
      QLog.d("GroupManagerActivity", 2, paramGroupActionResp.toString());
    }
    this.a.a(true);
    GroupManagerActivity.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.13
 * JD-Core Version:    0.7.0.1
 */