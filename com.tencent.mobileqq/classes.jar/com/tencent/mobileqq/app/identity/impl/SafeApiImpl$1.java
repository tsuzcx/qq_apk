package com.tencent.mobileqq.app.identity.impl;

import QQService.SvcRspGetDevLoginInfo;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.identity.IDevListView;

class SafeApiImpl$1
  extends FriendListObserver
{
  SafeApiImpl$1(SafeApiImpl paramSafeApiImpl, IDevListView paramIDevListView) {}
  
  protected void onDelAuthDevResult(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a.onDelAuthDevResult(paramBoolean, paramString, paramInt);
  }
  
  protected void onDelHistoryDevResult(boolean paramBoolean, String paramString, int paramInt)
  {
    this.a.onDelHistoryDevResult(paramBoolean, paramString, paramInt);
  }
  
  protected void onGetAuthDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    this.a.onGetAuthDevResult(paramBoolean, paramSvcRspGetDevLoginInfo);
  }
  
  protected void onGetHistoryDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    this.a.onGetHistoryDevResult(paramBoolean, paramSvcRspGetDevLoginInfo);
  }
  
  protected void onGetLoginDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    this.a.onGetLoginDevResult(paramBoolean, paramSvcRspGetDevLoginInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.impl.SafeApiImpl.1
 * JD-Core Version:    0.7.0.1
 */