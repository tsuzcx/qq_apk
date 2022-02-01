package com.tencent.mobileqq.apollo.api.model;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;
import trpc.cmshow.game.OpenGameBox.StBoxItem;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="sceneId,appid")
public class ApolloBattleGameInfo
  extends Entity
  implements Serializable
{
  public int adId;
  public String appid;
  public String avatar;
  public String background;
  public String footerIcon;
  public String gamerRange;
  public String name;
  public int sceneId;
  
  public static ApolloBattleGameInfo mergeFrom(int paramInt, OpenGameBox.StBoxItem paramStBoxItem)
  {
    if (paramStBoxItem == null) {
      return null;
    }
    ApolloBattleGameInfo localApolloBattleGameInfo = new ApolloBattleGameInfo();
    localApolloBattleGameInfo.sceneId = paramInt;
    localApolloBattleGameInfo.appid = paramStBoxItem.appid.get();
    localApolloBattleGameInfo.avatar = paramStBoxItem.avatar.get();
    localApolloBattleGameInfo.name = paramStBoxItem.name.get();
    localApolloBattleGameInfo.gamerRange = paramStBoxItem.gamer_range.get();
    localApolloBattleGameInfo.background = paramStBoxItem.background.get();
    localApolloBattleGameInfo.footerIcon = paramStBoxItem.footer_icon.get();
    localApolloBattleGameInfo.adId = paramStBoxItem.ad_id.get();
    return localApolloBattleGameInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloBattleGameInfo
 * JD-Core Version:    0.7.0.1
 */