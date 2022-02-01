package com.tencent.mobileqq.activity.aio;

import afrb;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SessionInfo
  implements Parcelable, Cloneable
{
  public static final Parcelable.Creator<SessionInfo> CREATOR = new SessionInfo.1();
  public int addFriendSourceId = 3999;
  public afrb chatBg;
  public String contactUin;
  public String curFriendNick;
  public String curFriendUin;
  public int curType;
  public boolean debugFilterMemberMsgCommand;
  public String debugFilterMsgTargetUin;
  public String directArtificial = "";
  public int entrance = 0;
  public int extraUintype;
  public boolean isBarrageMsg;
  public int isFromForward;
  public boolean isFromFrdRecConfess;
  public boolean isFromGroupRecConfess;
  public boolean isNightMode;
  public boolean isQimUserBubbleForm;
  public boolean isQimUserOnline;
  public boolean isQimUserOnlineIcon;
  public boolean isQimUserTitleForm;
  public boolean isTimUserBubbleForm;
  public boolean isTimUserOnline;
  public boolean isTimUserOnlineIcon;
  public boolean isTimUserTitleForm;
  public boolean isUpComingPrevious;
  private Bundle mExtras;
  private String mFriendRoleId;
  public long mLastReadMsgId = -1L;
  private String mMyRoleId;
  public long miniMsgBarrageTimeLocation;
  public long miniMsgUniseq;
  public String phoneNum;
  public String realTroopUin;
  public int textSizeForTextItem;
  public int topicId;
  public String troopUin;
  public String uinName;
  
  public SessionInfo() {}
  
  public SessionInfo(Parcel paramParcel)
  {
    this.curType = paramParcel.readInt();
    this.curFriendUin = paramParcel.readString();
    this.troopUin = paramParcel.readString();
    this.curFriendNick = paramParcel.readString();
    this.phoneNum = paramParcel.readString();
    this.addFriendSourceId = paramParcel.readInt();
    this.mFriendRoleId = paramParcel.readString();
    this.mMyRoleId = paramParcel.readString();
    this.mExtras = paramParcel.readBundle(getClass().getClassLoader());
  }
  
  public SessionInfo(SessionInfo paramSessionInfo)
  {
    this.curType = paramSessionInfo.curType;
    this.curFriendUin = paramSessionInfo.curFriendUin;
    this.troopUin = paramSessionInfo.troopUin;
    this.curFriendNick = paramSessionInfo.curFriendNick;
    this.phoneNum = paramSessionInfo.phoneNum;
    this.addFriendSourceId = paramSessionInfo.addFriendSourceId;
    this.mFriendRoleId = paramSessionInfo.mFriendRoleId;
    this.mMyRoleId = paramSessionInfo.mMyRoleId;
    if (paramSessionInfo.mExtras != null) {
      this.mExtras = new Bundle(paramSessionInfo.mExtras);
    }
  }
  
  public Object clone()
  {
    return super.clone();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public String getFriendRoleId()
  {
    return this.mFriendRoleId;
  }
  
  public String getMyRoleId()
  {
    return this.mMyRoleId;
  }
  
  public void reset()
  {
    this.debugFilterMemberMsgCommand = false;
    this.debugFilterMsgTargetUin = null;
  }
  
  public void setExtras(Bundle paramBundle)
  {
    this.mExtras = paramBundle;
  }
  
  public void setFriendRoleId(String paramString)
  {
    this.mFriendRoleId = paramString;
  }
  
  public void setMyRoleId(String paramString)
  {
    this.mMyRoleId = paramString;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.curType);
    paramParcel.writeString(this.curFriendUin);
    paramParcel.writeString(this.troopUin);
    paramParcel.writeString(this.curFriendNick);
    paramParcel.writeString(this.phoneNum);
    paramParcel.writeInt(this.addFriendSourceId);
    paramParcel.writeString(this.mFriendRoleId);
    paramParcel.writeString(this.mMyRoleId);
    paramParcel.writeBundle(this.mExtras);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.SessionInfo
 * JD-Core Version:    0.7.0.1
 */