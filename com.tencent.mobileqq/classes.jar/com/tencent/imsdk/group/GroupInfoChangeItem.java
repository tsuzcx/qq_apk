package com.tencent.imsdk.group;

import java.io.Serializable;

public class GroupInfoChangeItem
  implements Serializable
{
  private String customInfoKey;
  private int groupInfoChangeType;
  private String valueChanged;
  
  public String getCustomInfoKey()
  {
    return this.customInfoKey;
  }
  
  public int getGroupInfoChangeType()
  {
    return this.groupInfoChangeType;
  }
  
  public String getValueChanged()
  {
    return this.valueChanged;
  }
  
  public void setCustomInfoKey(String paramString)
  {
    this.customInfoKey = paramString;
  }
  
  public void setGroupInfoChangeType(int paramInt)
  {
    this.groupInfoChangeType = paramInt;
  }
  
  public void setValueChanged(String paramString)
  {
    this.valueChanged = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupInfoChangeItem
 * JD-Core Version:    0.7.0.1
 */