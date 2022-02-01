package com.tencent.mobileqq.apollo.model;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="sceneId,appid")
public class CmBattleGameInfo
  extends Entity
  implements Serializable
{
  public int adId;
  public String appDesc;
  public String appid;
  public String avatar;
  public String background;
  public int boxType;
  public int followerCount;
  public String footerIcon;
  public int gameStyle;
  public String gamerRange;
  public String hallJumpUrl;
  public String miniappJumpUrl;
  public String name;
  public int sceneId;
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof CmBattleGameInfo)) {
      return false;
    }
    paramObject = (CmBattleGameInfo)paramObject;
    return (this.sceneId == paramObject.sceneId) && (this.gameStyle == paramObject.gameStyle) && (TextUtils.equals(this.appid, paramObject.appid));
  }
  
  public int hashCode()
  {
    return ((527 + this.appid.hashCode()) * 31 + this.sceneId) * 31 + this.gameStyle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.CmBattleGameInfo
 * JD-Core Version:    0.7.0.1
 */