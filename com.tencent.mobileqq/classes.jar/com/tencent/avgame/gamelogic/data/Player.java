package com.tencent.avgame.gamelogic.data;

import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import trpc.qq_vgame.common.AvGameCommon.RoomUserInfo;

public class Player
  implements Serializable
{
  public int enterTime;
  public String nick;
  public int role;
  public int status;
  public String uin;
  
  public Player()
  {
    reset();
  }
  
  public Player clone()
  {
    Player localPlayer = new Player();
    try
    {
      localPlayer.copyFrom(this);
      return localPlayer;
    }
    catch (Exception localException) {}
    return localPlayer;
  }
  
  public void copyFrom(Player paramPlayer)
  {
    if (paramPlayer == null) {
      return;
    }
    this.role = paramPlayer.role;
    this.uin = paramPlayer.uin;
    this.nick = paramPlayer.nick;
    this.status = paramPlayer.status;
    this.enterTime = paramPlayer.enterTime;
  }
  
  public boolean isHost()
  {
    return this.role == 1;
  }
  
  public boolean isSame(Player paramPlayer)
  {
    if (paramPlayer != null)
    {
      paramPlayer = paramPlayer.uin;
      if ((paramPlayer != null) && (paramPlayer.equalsIgnoreCase(this.uin))) {
        return true;
      }
    }
    return false;
  }
  
  public final void parseFrom(AvGameCommon.RoomUserInfo paramRoomUserInfo)
  {
    if (paramRoomUserInfo == null) {
      return;
    }
    this.role = paramRoomUserInfo.role.get();
    this.uin = Long.toString(paramRoomUserInfo.uin.get());
    this.nick = this.uin;
    this.status = paramRoomUserInfo.status.get();
    this.enterTime = paramRoomUserInfo.enter_time.get();
  }
  
  public void reset()
  {
    this.role = 0;
    this.uin = "";
    this.nick = "";
    this.status = 0;
    this.enterTime = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin");
    localStringBuilder.append("=");
    localStringBuilder.append(this.uin);
    localStringBuilder.append("|");
    localStringBuilder.append("role");
    localStringBuilder.append("=");
    localStringBuilder.append(this.role);
    localStringBuilder.append("|");
    localStringBuilder.append("nick");
    localStringBuilder.append("=");
    localStringBuilder.append(this.nick);
    localStringBuilder.append("|");
    localStringBuilder.append("status");
    localStringBuilder.append("=");
    localStringBuilder.append(this.status);
    localStringBuilder.append("|");
    localStringBuilder.append("enterTime");
    localStringBuilder.append("=");
    localStringBuilder.append(this.enterTime);
    localStringBuilder.append("|");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.Player
 * JD-Core Version:    0.7.0.1
 */