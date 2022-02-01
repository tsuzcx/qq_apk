package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.qphone.base.util.QLog;

class GroupManagerActivity$13
  extends FriendListObserver
{
  GroupManagerActivity$13(GroupManagerActivity paramGroupManagerActivity) {}
  
  public void onAddGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onAddGroupResp isSuccess = " + paramBoolean);
    }
    this.a.a(paramBoolean);
    GroupManagerActivity.c(this.a, true);
  }
  
  public void onDeleteGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onDeleteGroupResp isSuccess = " + paramBoolean);
    }
    this.a.a(paramBoolean);
    GroupManagerActivity.c(this.a, true);
  }
  
  public void onRenameGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onRenameGroupResp isSuccess = " + paramBoolean);
    }
    this.a.a(paramBoolean);
    GroupManagerActivity.c(this.a, true);
  }
  
  public void onResortGroupResp(boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("GroupManagerActivity", 2, "onResortGroupResp isSuccess = " + paramBoolean);
    }
    this.a.a(true);
    GroupManagerActivity.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.GroupManagerActivity.13
 * JD-Core Version:    0.7.0.1
 */