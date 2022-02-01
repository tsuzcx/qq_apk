package com.tencent.avgame.gamelogic.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.avgame.util.ContactUtils;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import trpc.qq_vgame.common.AvGameCommon.RoomInfo;
import trpc.qq_vgame.common.AvGameCommon.RoomUserInfo;

public class RoomInfo
  implements Serializable
{
  public boolean fromMatchB2;
  public String gameName;
  public long id;
  public int matchShareId;
  public int matchStatus;
  public byte[] matchV2Extra;
  public boolean opened_match;
  public long owner;
  public List<Player> players = new ArrayList();
  public long seq;
  public boolean startMatching2Quick;
  
  public RoomInfo()
  {
    reset();
  }
  
  public RoomInfo clone()
  {
    RoomInfo localRoomInfo = new RoomInfo();
    localRoomInfo.copyFrom(this);
    return localRoomInfo;
  }
  
  public void copyFrom(RoomInfo paramRoomInfo)
  {
    if (paramRoomInfo == null) {
      return;
    }
    this.seq = paramRoomInfo.seq;
    this.id = paramRoomInfo.id;
    this.owner = paramRoomInfo.owner;
    this.gameName = paramRoomInfo.gameName;
    this.players.clear();
    this.players.addAll(paramRoomInfo.players);
    this.matchStatus = paramRoomInfo.matchStatus;
    this.opened_match = paramRoomInfo.opened_match;
    int i = paramRoomInfo.matchShareId;
    if (i > 0) {
      this.matchShareId = i;
    }
    paramRoomInfo = paramRoomInfo.matchV2Extra;
    if (paramRoomInfo != null) {
      this.matchV2Extra = paramRoomInfo;
    }
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (RoomInfo)paramObject;
      return this.id == paramObject.id;
    }
    return false;
  }
  
  public String getNick(String paramString)
  {
    Iterator localIterator = this.players.iterator();
    do
    {
      localObject = paramString;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (Player)localIterator.next();
    } while (!paramString.equals(((Player)localObject).uin));
    if (TextUtils.isEmpty(((Player)localObject).nick)) {
      return paramString;
    }
    Object localObject = ((Player)localObject).nick;
    return localObject;
  }
  
  public String getNick(String paramString, int paramInt)
  {
    return ContactUtils.a(getNick(paramString), paramInt);
  }
  
  public Player getPlayer(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Iterator localIterator = this.players.iterator();
    while (localIterator.hasNext())
    {
      Player localPlayer = (Player)localIterator.next();
      if (paramString.equalsIgnoreCase(localPlayer.uin)) {
        return localPlayer;
      }
    }
    return null;
  }
  
  public List<Player> getPlayers()
  {
    return this.players;
  }
  
  public List<String> getUins()
  {
    ArrayList localArrayList = new ArrayList(this.players.size());
    Iterator localIterator = this.players.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((Player)localIterator.next()).uin);
    }
    return localArrayList;
  }
  
  public int hashCode()
  {
    long l = this.id;
    return (int)(l ^ l >>> 32);
  }
  
  public boolean isRoomMatching()
  {
    return this.matchStatus == 1;
  }
  
  public boolean isUserInRoom(String paramString)
  {
    Iterator localIterator = this.players.iterator();
    while (localIterator.hasNext()) {
      if (paramString.equals(((Player)localIterator.next()).uin)) {
        return true;
      }
    }
    return false;
  }
  
  public void onChangeUserStatus(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Iterator localIterator = this.players.iterator();
    while (localIterator.hasNext())
    {
      Player localPlayer = (Player)localIterator.next();
      if (paramString.equalsIgnoreCase(localPlayer.uin)) {
        localPlayer.status = paramInt;
      }
    }
  }
  
  public void onGameOver()
  {
    Iterator localIterator = this.players.iterator();
    while (localIterator.hasNext()) {
      ((Player)localIterator.next()).status = 0;
    }
  }
  
  public void onGameStart()
  {
    Iterator localIterator = this.players.iterator();
    while (localIterator.hasNext()) {
      ((Player)localIterator.next()).status = 2;
    }
  }
  
  public final void parseFrom(AvGameCommon.RoomInfo paramRoomInfo)
  {
    if (paramRoomInfo == null) {
      return;
    }
    this.seq = paramRoomInfo.seq.get();
    this.id = paramRoomInfo.roomid.get();
    this.owner = paramRoomInfo.owner_uin.get();
    if (paramRoomInfo.game_name.get() != null) {
      localObject = paramRoomInfo.game_name.get();
    } else {
      localObject = "";
    }
    this.gameName = ((String)localObject);
    Object localObject = new ArrayList();
    if ((paramRoomInfo.users.has()) && (paramRoomInfo.users.get() != null))
    {
      Iterator localIterator = paramRoomInfo.users.get().iterator();
      while (localIterator.hasNext())
      {
        AvGameCommon.RoomUserInfo localRoomUserInfo = (AvGameCommon.RoomUserInfo)localIterator.next();
        Player localPlayer = new Player();
        localPlayer.parseFrom(localRoomUserInfo);
        ((List)localObject).add(localPlayer);
      }
    }
    this.players.clear();
    this.players.addAll((Collection)localObject);
    this.matchStatus = paramRoomInfo.match_status.get();
    this.opened_match = paramRoomInfo.opened_match.get();
  }
  
  public void reset()
  {
    this.seq = 0L;
    this.id = 0L;
    this.owner = 0L;
    this.gameName = "";
    this.opened_match = false;
    this.players.clear();
    this.matchStatus = 0;
    this.matchShareId = 0;
    this.matchV2Extra = null;
    this.fromMatchB2 = false;
    this.startMatching2Quick = false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("seq");
    localStringBuilder.append("=");
    localStringBuilder.append(this.seq);
    localStringBuilder.append("|");
    localStringBuilder.append("id");
    localStringBuilder.append("=");
    localStringBuilder.append(this.id);
    localStringBuilder.append("|");
    localStringBuilder.append("owner");
    localStringBuilder.append("=");
    localStringBuilder.append(this.owner);
    localStringBuilder.append("|");
    localStringBuilder.append("gameName");
    localStringBuilder.append("=");
    localStringBuilder.append(this.gameName);
    localStringBuilder.append("|");
    localStringBuilder.append("count");
    localStringBuilder.append("=");
    localStringBuilder.append(this.players.size());
    localStringBuilder.append("|");
    localStringBuilder.append("players:");
    localStringBuilder.append("=");
    localStringBuilder.append(Arrays.toString(this.players.toArray()));
    localStringBuilder.append("|");
    localStringBuilder.append("matchStatus:");
    localStringBuilder.append(this.matchStatus);
    localStringBuilder.append("|");
    localStringBuilder.append("matchShareId:");
    localStringBuilder.append(this.matchShareId);
    localStringBuilder.append("matchV2Extra:");
    localStringBuilder.append(this.matchV2Extra);
    return localStringBuilder.toString();
  }
  
  public void updateNicks(Map<String, String> paramMap)
  {
    Iterator localIterator = this.players.iterator();
    while (localIterator.hasNext())
    {
      Player localPlayer = (Player)localIterator.next();
      String str = localPlayer.uin;
      if ((!TextUtils.isEmpty(str)) && (paramMap.containsKey(str))) {
        localPlayer.nick = ((String)paramMap.get(str));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.RoomInfo
 * JD-Core Version:    0.7.0.1
 */