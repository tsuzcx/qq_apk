package com.tencent.mobileqq.apollo.model;

import com.tencent.qphone.base.util.QLog;

public class CmAvatarFaceInfo
{
  private int actionId;
  private int actionType;
  private boolean determine = false;
  private String icon;
  private int isDynamic;
  private boolean selectPosition = false;
  private int type;
  
  public int getActionId()
  {
    return this.actionId;
  }
  
  public int getActionType()
  {
    return this.actionType;
  }
  
  public String getIcon()
  {
    return this.icon;
  }
  
  public boolean isDynamic()
  {
    return this.isDynamic == 1;
  }
  
  public CmAvatarFaceInfo setActionId(int paramInt)
  {
    this.actionId = paramInt;
    return this;
  }
  
  public CmAvatarFaceInfo setActionType(String paramString)
  {
    try
    {
      this.actionType = Integer.parseInt(paramString);
      return this;
    }
    catch (Exception paramString)
    {
      this.actionType = 0;
      QLog.e("CmAvatarFaceInfo", 1, "setActionType exception", paramString);
    }
    return this;
  }
  
  public CmAvatarFaceInfo setIcon(String paramString)
  {
    this.icon = paramString;
    return this;
  }
  
  public CmAvatarFaceInfo setIsDynamic(int paramInt)
  {
    this.isDynamic = paramInt;
    return this;
  }
  
  public CmAvatarFaceInfo setType(int paramInt)
  {
    this.type = paramInt;
    return this;
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.CmAvatarFaceInfo
 * JD-Core Version:    0.7.0.1
 */