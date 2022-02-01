package com.tencent.biz.subscribe.event;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StYouZanGood;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;

public class AttachGoodsEvent
  extends SimpleBaseEvent
{
  public ArrayList<CertifiedAccountMeta.StYouZanGood> mGoods;
  
  public AttachGoodsEvent(ArrayList<CertifiedAccountMeta.StYouZanGood> paramArrayList)
  {
    this.mGoods = paramArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.event.AttachGoodsEvent
 * JD-Core Version:    0.7.0.1
 */