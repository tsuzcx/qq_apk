package com.tencent.biz.qqstory.database;

import auko;

public class CardEntry
  extends auko
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
    return "cardListType=" + paramInt + " and topicId=" + paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.CardEntry
 * JD-Core Version:    0.7.0.1
 */