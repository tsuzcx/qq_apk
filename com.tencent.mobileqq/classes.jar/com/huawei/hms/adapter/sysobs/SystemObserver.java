package com.huawei.hms.adapter.sysobs;

import android.content.Intent;

public abstract interface SystemObserver
{
  public abstract boolean onSolutionResult(Intent paramIntent, String paramString);
  
  public abstract boolean onUpdateResult(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.adapter.sysobs.SystemObserver
 * JD-Core Version:    0.7.0.1
 */