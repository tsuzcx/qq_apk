package com.tencent.mobileqq.apollo.model;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.io.Serializable;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="sceneId,appid")
public class ApolloBattleGameInfo
  extends Entity
  implements Serializable
{
  public static final int BOX_TYPE_GAME = 0;
  public static final int BOX_TYPE_HALL = 1;
  public int adId;
  public String appid;
  public String avatar;
  public String background;
  public int boxType;
  public String footerIcon;
  public String gamerRange;
  public String hallJumpUrl;
  public String name;
  public int sceneId;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloBattleGameInfo
 * JD-Core Version:    0.7.0.1
 */