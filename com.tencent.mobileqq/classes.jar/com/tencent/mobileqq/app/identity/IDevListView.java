package com.tencent.mobileqq.app.identity;

import QQService.SvcRspGetDevLoginInfo;
import android.os.Bundle;

public abstract interface IDevListView
{
  public abstract void onDelAuthDevResult(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract void onDelHistoryDevResult(boolean paramBoolean, String paramString, int paramInt);
  
  public abstract void onGetAuthDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo);
  
  public abstract void onGetHistoryDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo);
  
  public abstract void onGetLoginDevResult(boolean paramBoolean, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo);
  
  public abstract void onRenameAuthDev(boolean paramBoolean, int paramInt, byte[] paramArrayOfByte, String paramString);
  
  public abstract void onWXSyncQQMsgOption(int paramInt, Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.IDevListView
 * JD-Core Version:    0.7.0.1
 */