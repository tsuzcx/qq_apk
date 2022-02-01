package com.tencent.mobileqq.activity.aio.stickerrecommended;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="usrMessage,recommendType")
public class StickerRecommendEntity
  extends Entity
{
  public long cachedTime;
  public String recList;
  public int recommendType;
  public String usrMessage;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity
 * JD-Core Version:    0.7.0.1
 */