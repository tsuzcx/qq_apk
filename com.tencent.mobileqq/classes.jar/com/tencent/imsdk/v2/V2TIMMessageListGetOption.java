package com.tencent.imsdk.v2;

public class V2TIMMessageListGetOption
{
  public static final int V2TIM_GET_CLOUD_NEWER_MSG = 2;
  public static final int V2TIM_GET_CLOUD_OLDER_MSG = 1;
  public static final int V2TIM_GET_LOCAL_NEWER_MSG = 4;
  public static final int V2TIM_GET_LOCAL_OLDER_MSG = 3;
  private int count;
  private int getType;
  private String groupID;
  private V2TIMMessage lastMsg;
  private String userID;
  
  public int getCount()
  {
    return this.count;
  }
  
  public int getGetType()
  {
    return this.getType;
  }
  
  public String getGroupID()
  {
    return this.groupID;
  }
  
  public V2TIMMessage getLastMsg()
  {
    return this.lastMsg;
  }
  
  public String getUserID()
  {
    return this.userID;
  }
  
  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }
  
  public void setGetType(int paramInt)
  {
    this.getType = paramInt;
  }
  
  public void setGroupID(String paramString)
  {
    this.groupID = paramString;
  }
  
  public void setLastMsg(V2TIMMessage paramV2TIMMessage)
  {
    this.lastMsg = paramV2TIMMessage;
  }
  
  public void setUserID(String paramString)
  {
    this.userID = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMMessageListGetOption
 * JD-Core Version:    0.7.0.1
 */