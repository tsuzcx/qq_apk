package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;

public class CardEntry
  extends Entity
{
  public static final int CARD_LIST_TYPE_DISCOVER = 0;
  public static final int CARD_LIST_TYPE_NEARBY = 1;
  public static final int CARD_LIST_TYPE_TOPIC = 2;
  public byte[] PBData;
  public String cardId;
  public int cardListType;
  public int cardType;
  public long topicId;
  
  public static String getCardIdSelection()
  {
    return "cardId=?";
  }
  
  public static String getTypeSelection(int paramInt, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cardListType=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" and topicId=");
    localStringBuilder.append(paramLong);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.CardEntry
 * JD-Core Version:    0.7.0.1
 */