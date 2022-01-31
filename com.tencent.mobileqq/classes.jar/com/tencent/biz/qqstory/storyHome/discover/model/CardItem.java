package com.tencent.biz.qqstory.storyHome.discover.model;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.CardEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.CardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GatherCardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NearbyCardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NormalCardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.OperationCardInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import wli;
import wlk;
import wll;
import wlm;
import xqq;

public class CardItem
  extends BaseUIItem
{
  public static final int CARD_TYPE_GATHER = 4;
  public static final int CARD_TYPE_NEARBY = 2;
  public static final int CARD_TYPE_NORMAL = 1;
  public static final int CARD_TYPE_OPERATION = 3;
  public String cardId;
  public int cardType;
  public wli gatherCardInfo;
  public boolean hasReportExp;
  public wlk nearByCardInfo;
  public wll normalCardInfo;
  public wlm operationCardInfo;
  
  public CardItem(CardEntry paramCardEntry)
  {
    this.cardId = paramCardEntry.cardId;
    this.cardType = paramCardEntry.cardType;
    switch (this.cardType)
    {
    default: 
      xqq.a("not support this type %d for cardId %s", new Object[] { Integer.valueOf(this.cardType), this.cardId });
      return;
    case 1: 
      this.normalCardInfo = new wll(paramCardEntry.PBData);
      return;
    case 2: 
      this.nearByCardInfo = new wlk(paramCardEntry.PBData);
      return;
    case 3: 
      this.operationCardInfo = new wlm(paramCardEntry.PBData);
      return;
    }
    this.gatherCardInfo = new wli(paramCardEntry.PBData);
  }
  
  public CardItem(qqstory_struct.CardInfo paramCardInfo)
  {
    this.cardId = paramCardInfo.card_id.get().toStringUtf8();
    this.cardType = paramCardInfo.card_type.get();
    switch (this.cardType)
    {
    default: 
      xqq.a("not support this type %d for cardId %s", new Object[] { Integer.valueOf(this.cardType), this.cardId });
      return;
    case 1: 
      this.normalCardInfo = new wll(paramCardInfo.normal_card);
      return;
    case 2: 
      this.nearByCardInfo = new wlk(paramCardInfo.nearby_card);
      return;
    case 3: 
      this.operationCardInfo = new wlm(paramCardInfo.operation_card);
      return;
    }
    this.gatherCardInfo = new wli(paramCardInfo.gather_card);
  }
  
  public CardItem(String paramString, wll paramwll)
  {
    if ((paramString == null) || (paramwll == null)) {
      throw new IllegalArgumentException("parameter should not be null");
    }
    this.cardId = paramString;
    this.cardType = 1;
    this.normalCardInfo = paramwll;
  }
  
  @Nullable
  public CardItem.CardVideoInfo getCardVideoInfo()
  {
    switch (this.cardType)
    {
    default: 
      return null;
    case 1: 
      return this.normalCardInfo.a();
    case 2: 
      return this.nearByCardInfo.a();
    }
    return this.operationCardInfo.a();
  }
  
  @Nullable
  public String getFeedId()
  {
    CardItem.CardVideoInfo localCardVideoInfo = getCardVideoInfo();
    if (localCardVideoInfo != null) {
      return localCardVideoInfo.a();
    }
    return null;
  }
  
  public CardEntry toCardEntry()
  {
    CardEntry localCardEntry = new CardEntry();
    localCardEntry.cardId = this.cardId;
    localCardEntry.cardType = this.cardType;
    switch (this.cardType)
    {
    default: 
      xqq.a("not support this type %d for cardId %s", new Object[] { Integer.valueOf(this.cardType), this.cardId });
      return localCardEntry;
    case 1: 
      localCardEntry.PBData = wll.a(this.normalCardInfo).toByteArray();
      return localCardEntry;
    case 2: 
      localCardEntry.PBData = wlk.a(this.nearByCardInfo).toByteArray();
      return localCardEntry;
    case 3: 
      localCardEntry.PBData = wlm.a(this.operationCardInfo).toByteArray();
      return localCardEntry;
    }
    localCardEntry.PBData = wli.a(this.gatherCardInfo).toByteArray();
    return localCardEntry;
  }
  
  public String toString()
  {
    return "CardItem{cardId='" + this.cardId + '\'' + ", cardType=" + this.cardType + ", gatherCardInfo=" + this.gatherCardInfo + ", nearByCardInfo=" + this.nearByCardInfo + ", normalCardInfo=" + this.normalCardInfo + ", operationCardInfo=" + this.operationCardInfo + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.model.CardItem
 * JD-Core Version:    0.7.0.1
 */