package com.tencent.mobileqq.apollo.api.script;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface ISpriteCommFunc
  extends QRouteApi
{
  public static final String AIO_AT = "aio_at";
  public static final String CMSHOW_STATUS = "cmshow_status";
  public static final String FRIEND_INTIMATE = "intimate";
  public static final String FULL_SCREEN_INPUT = "full_screen_input";
  public static final String GIFT_PANEL_FLOWER = "GiftPanel_flower";
  public static final String HOT_PIC = "hot_pic";
  public static final String ICE_BREAK = "ice_break";
  public static final String RECEIPT_MSG = "receipt_msg";
  public static final String SELECT_MORE_MSG = "select_more_msg";
  public static final String STICKER_BUBBLE = "StickerBubble";
  public static final String TROOP_ANONYOUS = "troop_anonyous";
  public static final String VAS_POKE = "vas_poke";
  
  public abstract boolean isSpriteActive(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract boolean isSpriteHidden(QQAppInterface paramQQAppInterface);
  
  public abstract boolean isSpriteHiddenForBusiness(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract void showOrHideSprite(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean);
  
  public abstract void stopAllTask(QQAppInterface paramQQAppInterface, String paramString);
  
  public abstract void stopTaskByMsg(long paramLong, QQAppInterface paramQQAppInterface, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.script.ISpriteCommFunc
 * JD-Core Version:    0.7.0.1
 */