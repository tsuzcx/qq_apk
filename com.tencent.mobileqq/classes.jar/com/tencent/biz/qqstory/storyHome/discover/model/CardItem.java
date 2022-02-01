package com.tencent.biz.qqstory.storyHome.discover.model;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.database.CardEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.CardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GatherCardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NearbyCardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.NormalCardInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.OperationCardInfo;
import com.tencent.biz.qqstory.utils.AssertUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;

public class CardItem
  extends BaseUIItem
{
  public static final int CARD_TYPE_GATHER = 4;
  public static final int CARD_TYPE_NEARBY = 2;
  public static final int CARD_TYPE_NORMAL = 1;
  public static final int CARD_TYPE_OPERATION = 3;
  public String cardId;
  public int cardType;
  public CardItem.ActivityCardInfo gatherCardInfo;
  public boolean hasReportExp = false;
  public CardItem.NearbyCardInfo nearByCardInfo;
  public CardItem.NormalCardInfo normalCardInfo;
  public CardItem.OperationCardInfo operationCardInfo;
  
  public CardItem(CardEntry paramCardEntry)
  {
    this.cardId = paramCardEntry.cardId;
    this.cardType = paramCardEntry.cardType;
    int i = this.cardType;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            AssertUtils.fail("not support this type %d for cardId %s", new Object[] { Integer.valueOf(i), this.cardId });
            return;
          }
          this.gatherCardInfo = new CardItem.ActivityCardInfo(paramCardEntry.PBData);
          return;
        }
        this.operationCardInfo = new CardItem.OperationCardInfo(paramCardEntry.PBData);
        return;
      }
      this.nearByCardInfo = new CardItem.NearbyCardInfo(paramCardEntry.PBData);
      return;
    }
    this.normalCardInfo = new CardItem.NormalCardInfo(paramCardEntry.PBData);
  }
  
  public CardItem(qqstory_struct.CardInfo paramCardInfo)
  {
    this.cardId = paramCardInfo.card_id.get().toStringUtf8();
    this.cardType = paramCardInfo.card_type.get();
    int i = this.cardType;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            AssertUtils.fail("not support this type %d for cardId %s", new Object[] { Integer.valueOf(i), this.cardId });
            return;
          }
          this.gatherCardInfo = new CardItem.ActivityCardInfo(paramCardInfo.gather_card);
          return;
        }
        this.operationCardInfo = new CardItem.OperationCardInfo(paramCardInfo.operation_card);
        return;
      }
      this.nearByCardInfo = new CardItem.NearbyCardInfo(paramCardInfo.nearby_card);
      return;
    }
    this.normalCardInfo = new CardItem.NormalCardInfo(paramCardInfo.normal_card);
  }
  
  public CardItem(String paramString, CardItem.NormalCardInfo paramNormalCardInfo)
  {
    if ((paramString != null) && (paramNormalCardInfo != null))
    {
      this.cardId = paramString;
      this.cardType = 1;
      this.normalCardInfo = paramNormalCardInfo;
      return;
    }
    throw new IllegalArgumentException("parameter should not be null");
  }
  
  @Nullable
  public CardItem.CardVideoInfo getCardVideoInfo()
  {
    int i = this.cardType;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return null;
        }
        return this.operationCardInfo.a();
      }
      return this.nearByCardInfo.a();
    }
    return this.normalCardInfo.a();
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
    int i = this.cardType;
    localCardEntry.cardType = i;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            AssertUtils.fail("not support this type %d for cardId %s", new Object[] { Integer.valueOf(i), this.cardId });
            return localCardEntry;
          }
          localCardEntry.PBData = CardItem.ActivityCardInfo.a(this.gatherCardInfo).toByteArray();
          return localCardEntry;
        }
        localCardEntry.PBData = CardItem.OperationCardInfo.a(this.operationCardInfo).toByteArray();
        return localCardEntry;
      }
      localCardEntry.PBData = CardItem.NearbyCardInfo.a(this.nearByCardInfo).toByteArray();
      return localCardEntry;
    }
    localCardEntry.PBData = CardItem.NormalCardInfo.a(this.normalCardInfo).toByteArray();
    return localCardEntry;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CardItem{cardId='");
    localStringBuilder.append(this.cardId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", cardType=");
    localStringBuilder.append(this.cardType);
    localStringBuilder.append(", gatherCardInfo=");
    localStringBuilder.append(this.gatherCardInfo);
    localStringBuilder.append(", nearByCardInfo=");
    localStringBuilder.append(this.nearByCardInfo);
    localStringBuilder.append(", normalCardInfo=");
    localStringBuilder.append(this.normalCardInfo);
    localStringBuilder.append(", operationCardInfo=");
    localStringBuilder.append(this.operationCardInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.discover.model.CardItem
 * JD-Core Version:    0.7.0.1
 */