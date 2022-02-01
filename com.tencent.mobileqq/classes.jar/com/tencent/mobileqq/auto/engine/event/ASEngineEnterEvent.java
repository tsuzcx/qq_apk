package com.tencent.mobileqq.auto.engine.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class ASEngineEnterEvent
  extends SimpleBaseEvent
{
  private String mBusinessKey;
  private boolean mCallBackSuccess;
  private boolean mHasPreload;
  private boolean mIsCancel;
  private String mLoadCostTime;
  private int mLoadResultCode;
  
  public ASEngineEnterEvent(String paramString)
  {
    this.mBusinessKey = paramString;
  }
  
  public String getBusinessKey()
  {
    return this.mBusinessKey;
  }
  
  public String getLoadCostTime()
  {
    return this.mLoadCostTime;
  }
  
  public int getResultCode()
  {
    return this.mLoadResultCode;
  }
  
  public boolean hasPreload()
  {
    return this.mHasPreload;
  }
  
  public boolean isCancel()
  {
    return this.mIsCancel;
  }
  
  public boolean isSuccess()
  {
    return this.mCallBackSuccess;
  }
  
  public void setCallBackResult(boolean paramBoolean)
  {
    this.mCallBackSuccess = paramBoolean;
  }
  
  public void setCancel(boolean paramBoolean)
  {
    this.mIsCancel = paramBoolean;
  }
  
  public void setHasPreload(boolean paramBoolean)
  {
    this.mHasPreload = paramBoolean;
  }
  
  public void setLoadCost(String paramString)
  {
    this.mLoadCostTime = paramString;
  }
  
  public void setResultCode(int paramInt)
  {
    this.mLoadResultCode = paramInt;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ASEngineEnterEvent{");
    localStringBuffer.append("mBusinessKey='");
    localStringBuffer.append(this.mBusinessKey);
    localStringBuffer.append('\'');
    localStringBuffer.append(", mCallBackSuccess=");
    localStringBuffer.append(this.mCallBackSuccess);
    localStringBuffer.append(", mIsCancel=");
    localStringBuffer.append(this.mIsCancel);
    localStringBuffer.append(", mLoadResultCode=");
    localStringBuffer.append(this.mLoadResultCode);
    localStringBuffer.append(", mHasPreload=");
    localStringBuffer.append(this.mHasPreload);
    localStringBuffer.append(", mLoadCostTime='");
    localStringBuffer.append(this.mLoadCostTime);
    localStringBuffer.append('\'');
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.event.ASEngineEnterEvent
 * JD-Core Version:    0.7.0.1
 */