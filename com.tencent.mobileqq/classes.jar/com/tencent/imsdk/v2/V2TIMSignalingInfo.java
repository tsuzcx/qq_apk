package com.tencent.imsdk.v2;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class V2TIMSignalingInfo
{
  public static final int SIGNALING_ACTION_TYPE_ACCEPT_INVITE = 3;
  public static final int SIGNALING_ACTION_TYPE_CANCEL_INVITE = 2;
  public static final int SIGNALING_ACTION_TYPE_INVITE = 1;
  public static final int SIGNALING_ACTION_TYPE_INVITE_TIMEOUT = 5;
  public static final int SIGNALING_ACTION_TYPE_REJECT_INVITE = 4;
  private int actionType;
  private int businessID = 0;
  private String data;
  private String groupID;
  private String inviteID;
  private List<String> inviteeList = new ArrayList();
  private String inviter;
  private V2TIMOfflinePushInfo offlinePushInfo;
  private boolean onlineUserOnly;
  private int timeout;
  
  void addInvitee(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    this.inviteeList.add(paramString);
  }
  
  public int getActionType()
  {
    return this.actionType;
  }
  
  public int getBusinessID()
  {
    return this.businessID;
  }
  
  public String getData()
  {
    return this.data;
  }
  
  public String getGroupID()
  {
    return this.groupID;
  }
  
  public String getInviteID()
  {
    return this.inviteID;
  }
  
  public List<String> getInviteeList()
  {
    return this.inviteeList;
  }
  
  public String getInviter()
  {
    return this.inviter;
  }
  
  public V2TIMOfflinePushInfo getOfflinePushInfo()
  {
    return this.offlinePushInfo;
  }
  
  public int getTimeout()
  {
    return this.timeout;
  }
  
  public boolean isOnlineUserOnly()
  {
    return this.onlineUserOnly;
  }
  
  public void setActionType(int paramInt)
  {
    this.actionType = paramInt;
  }
  
  public void setBusinessID(int paramInt)
  {
    this.businessID = paramInt;
  }
  
  public void setData(String paramString)
  {
    this.data = paramString;
  }
  
  public void setGroupID(String paramString)
  {
    this.groupID = paramString;
  }
  
  public void setInviteID(String paramString)
  {
    this.inviteID = paramString;
  }
  
  public void setInviteeList(List<String> paramList)
  {
    this.inviteeList = paramList;
  }
  
  public void setInviter(String paramString)
  {
    this.inviter = paramString;
  }
  
  protected void setOfflinePushInfo(V2TIMOfflinePushInfo paramV2TIMOfflinePushInfo)
  {
    this.offlinePushInfo = paramV2TIMOfflinePushInfo;
  }
  
  protected void setOnlineUserOnly(boolean paramBoolean)
  {
    this.onlineUserOnly = paramBoolean;
  }
  
  public void setTimeout(int paramInt)
  {
    this.timeout = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSignalingInfo
 * JD-Core Version:    0.7.0.1
 */