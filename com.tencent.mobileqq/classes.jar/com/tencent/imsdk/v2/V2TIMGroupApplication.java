package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupApplication;
import java.io.Serializable;

public class V2TIMGroupApplication
  implements Serializable
{
  public static final int V2TIM_GROUP_APPLICATION_GET_TYPE_INVITE = 1;
  public static final int V2TIM_GROUP_APPLICATION_GET_TYPE_JOIN = 0;
  public static final int V2TIM_GROUP_APPLICATION_HANDLE_RESULT_AGREE = 1;
  public static final int V2TIM_GROUP_APPLICATION_HANDLE_RESULT_REFUSE = 0;
  public static final int V2TIM_GROUP_APPLICATION_HANDLE_STATUS_HANDLED_BY_OTHER = 1;
  public static final int V2TIM_GROUP_APPLICATION_HANDLE_STATUS_HANDLED_BY_SELF = 2;
  public static final int V2TIM_GROUP_APPLICATION_HANDLE_STATUS_UNHANDLED = 0;
  private GroupApplication groupApplication = new GroupApplication();
  
  public long getAddTime()
  {
    return this.groupApplication.getRequestTime();
  }
  
  public String getFromUser()
  {
    return this.groupApplication.getFromUserID();
  }
  
  public String getFromUserFaceUrl()
  {
    return this.groupApplication.getFromUserFaceUrl();
  }
  
  public String getFromUserNickName()
  {
    return this.groupApplication.getFromUserNickName();
  }
  
  GroupApplication getGroupApplication()
  {
    return this.groupApplication;
  }
  
  public String getGroupID()
  {
    return this.groupApplication.getGroupID();
  }
  
  public int getHandleResult()
  {
    int i = this.groupApplication.getResponseType();
    if (i == GroupApplication.RESPONSE_TYPE_AGREE) {
      return 1;
    }
    if (i == GroupApplication.RESPONSE_TYPE_REFUSE) {
      return 0;
    }
    return 1;
  }
  
  public int getHandleStatus()
  {
    int i = this.groupApplication.getResponseStatus();
    if (i == GroupApplication.RESPONSE_STATUS_UNHANDLED) {
      return 0;
    }
    if (i == GroupApplication.RESPONSE_STATUS_HANDLED_BY_OTHER) {
      return 1;
    }
    if (i == GroupApplication.RESPONSE_STATUS_HANDLED_BY_SELF) {
      return 2;
    }
    return 0;
  }
  
  public String getHandledMsg()
  {
    return this.groupApplication.getResponseMessage();
  }
  
  public String getRequestMsg()
  {
    return this.groupApplication.getRequestMessage();
  }
  
  public String getToUser()
  {
    return this.groupApplication.getToUserID();
  }
  
  public int getType()
  {
    int i = this.groupApplication.getApplicationType();
    if (i == GroupApplication.REQUEST_TYPE_INVITE) {
      return 0;
    }
    if (i == GroupApplication.REQUEST_TYPE_JOIN) {
      return 1;
    }
    return 0;
  }
  
  void setGroupApplication(GroupApplication paramGroupApplication)
  {
    this.groupApplication = paramGroupApplication;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupApplication
 * JD-Core Version:    0.7.0.1
 */