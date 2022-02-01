package com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model;

import com.tencent.falco.base.libapi.channel.helper.MsgExtInfo;
import java.util.ArrayList;
import java.util.List;

public class LuxuryGiftData
{
  public static final int SEND_GIFT_FROM_GRAB_HEADLINES = 1;
  public String consumerName;
  public long consumerUin;
  public List<LuxuryGiftData> data = new ArrayList();
  public String effectId;
  public int effectNum;
  public int effectType;
  public String effectWord;
  public String giftIcon;
  public int giftId;
  public String giftName;
  public int giftTimestamp;
  public int giftType;
  public int giftnum;
  public String headKey;
  public long headTimestamp;
  public String headUrl;
  public String mBusinessUid;
  public MsgExtInfo mMsgExtInfo;
  public String playName;
  public PlayTimeMonitor playTimeMonitor = new PlayTimeMonitor();
  public long playUin;
  public long roomid;
  public long subroomid;
  
  public LuxuryGiftData clone()
  {
    LuxuryGiftData localLuxuryGiftData = new LuxuryGiftData();
    localLuxuryGiftData.giftType = this.giftType;
    localLuxuryGiftData.consumerUin = this.consumerUin;
    localLuxuryGiftData.headTimestamp = this.headTimestamp;
    localLuxuryGiftData.headKey = this.headKey;
    localLuxuryGiftData.headUrl = this.headUrl;
    localLuxuryGiftData.consumerName = this.consumerName;
    localLuxuryGiftData.playUin = this.playUin;
    localLuxuryGiftData.playName = this.playName;
    localLuxuryGiftData.roomid = this.roomid;
    localLuxuryGiftData.subroomid = this.subroomid;
    localLuxuryGiftData.giftId = this.giftId;
    localLuxuryGiftData.giftnum = this.giftnum;
    localLuxuryGiftData.giftTimestamp = this.giftTimestamp;
    localLuxuryGiftData.effectId = this.effectId;
    localLuxuryGiftData.effectType = this.effectType;
    localLuxuryGiftData.effectNum = this.effectNum;
    localLuxuryGiftData.effectWord = this.effectWord;
    localLuxuryGiftData.playTimeMonitor = this.playTimeMonitor;
    localLuxuryGiftData.giftIcon = this.giftIcon;
    localLuxuryGiftData.mBusinessUid = this.mBusinessUid;
    List localList = this.data;
    if (localList != null) {
      localLuxuryGiftData.data = new ArrayList(localList);
    }
    localLuxuryGiftData.mMsgExtInfo = this.mMsgExtInfo;
    return localLuxuryGiftData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftData
 * JD-Core Version:    0.7.0.1
 */