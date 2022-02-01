package com.tencent.avgame.gamelogic.data;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.ContactUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
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
  @NotNull
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
    if (paramRoomInfo == null) {}
    do
    {
      return;
      this.seq = paramRoomInfo.seq;
      this.id = paramRoomInfo.id;
      this.owner = paramRoomInfo.owner;
      this.gameName = paramRoomInfo.gameName;
      this.players.clear();
      this.players.addAll(paramRoomInfo.players);
      this.matchStatus = paramRoomInfo.matchStatus;
      this.opened_match = paramRoomInfo.opened_match;
      if (paramRoomInfo.matchShareId > 0) {
        this.matchShareId = paramRoomInfo.matchShareId;
      }
    } while (paramRoomInfo.matchV2Extra == null);
    this.matchV2Extra = paramRoomInfo.matchV2Extra;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (RoomInfo)paramObject;
    } while (this.id == paramObject.id);
    return false;
  }
  
  public String getNick(String paramString)
  {
    Iterator localIterator = this.players.iterator();
    Player localPlayer;
    while (localIterator.hasNext())
    {
      localPlayer = (Player)localIterator.next();
      if (paramString.equals(localPlayer.uin)) {
        if (!TextUtils.isEmpty(localPlayer.nick)) {
          break label52;
        }
      }
    }
    return paramString;
    label52:
    return localPlayer.nick;
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
    return (int)(this.id ^ this.id >>> 32);
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
    if (TextUtils.isEmpty(paramString)) {}
    Player localPlayer;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.players.iterator();
      }
      localPlayer = (Player)localIterator.next();
    } while (!paramString.equalsIgnoreCase(localPlayer.uin));
    localPlayer.status = paramInt;
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
    if (paramRoomInfo.game_name.get() != null) {}
    for (Object localObject = paramRoomInfo.game_name.get();; localObject = "")
    {
      this.gameName = ((String)localObject);
      localObject = new ArrayList();
      if ((!paramRoomInfo.users.has()) || (paramRoomInfo.users.get() == null)) {
        break;
      }
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
    localStringBuilder.append("seq").append("=").append(this.seq).append("|");
    localStringBuilder.append("id").append("=").append(this.id).append("|");
    localStringBuilder.append("owner").append("=").append(this.owner).append("|");
    localStringBuilder.append("gameName").append("=").append(this.gameName).append("|");
    localStringBuilder.append("count").append("=").append(this.players.size()).append("|");
    localStringBuilder.append("players:").append("=").append(Arrays.toString(this.players.toArray())).append("|");
    localStringBuilder.append("matchStatus:").append(this.matchStatus).append("|");
    localStringBuilder.append("matchShareId:").append(this.matchShareId);
    localStringBuilder.append("matchV2Extra:").append(this.matchV2Extra);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.data.RoomInfo
 * JD-Core Version:    0.7.0.1
 */