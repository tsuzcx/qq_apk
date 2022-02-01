package com.tencent.mobileqq.activity.recent.gamemsgbox.data;

import com.tencent.mobileqq.gamecenter.data.GameMsgRemoteUserItem;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.qphone.base.util.QLog;

public class GameBoxRecentUser
  extends Entity
{
  public static final String TAG = "GameBoxRecentUser";
  @unique
  public String mConvertUin;
  public String mFromOpenId;
  public String mFromRoleId;
  public String mFromTinyId;
  public String mGameAppId;
  public String mSig;
  public long mTime;
  public String mToOpenId;
  public String mToRoleId;
  public String mToTinyId;
  
  public GameBoxRecentUser() {}
  
  public GameBoxRecentUser(String paramString, GameMsgRemoteUserItem paramGameMsgRemoteUserItem)
  {
    this.mGameAppId = paramGameMsgRemoteUserItem.a;
    this.mFromRoleId = paramGameMsgRemoteUserItem.b;
    this.mToRoleId = paramGameMsgRemoteUserItem.c;
    this.mFromTinyId = paramGameMsgRemoteUserItem.d;
    this.mToTinyId = paramGameMsgRemoteUserItem.e;
    this.mFromOpenId = paramGameMsgRemoteUserItem.f;
    this.mToOpenId = paramGameMsgRemoteUserItem.g;
    this.mSig = paramGameMsgRemoteUserItem.h;
    this.mTime = paramGameMsgRemoteUserItem.i;
    this.mConvertUin = paramString;
  }
  
  public void print()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder(500);
        localStringBuilder.append(" appId:");
        localStringBuilder.append(this.mGameAppId);
        localStringBuilder.append(",fromRoleId:");
        localStringBuilder.append(this.mFromRoleId);
        localStringBuilder.append(",toRoleId:");
        localStringBuilder.append(this.mToRoleId);
        localStringBuilder.append(",fromTinyId:");
        localStringBuilder.append(this.mToTinyId);
        localStringBuilder.append(",fromOpenId:");
        localStringBuilder.append(this.mFromOpenId);
        localStringBuilder.append(",toOpenId:");
        localStringBuilder.append(this.mToOpenId);
        localStringBuilder.append(",sig:");
        localStringBuilder.append(this.mSig);
        QLog.d("GameBoxRecentUser", 2, localStringBuilder.toString());
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.w("GameBoxRecentUser", 1, localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.data.GameBoxRecentUser
 * JD-Core Version:    0.7.0.1
 */