package com.tencent.mobileqq.activity.aio.stickerrecommended;

import aukm;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="usrMessage")
public class StickerRecommendEntity
  extends aukm
{
  public long cachedTime;
  public String recList;
  public String usrMessage;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecommendEntity
 * JD-Core Version:    0.7.0.1
 */