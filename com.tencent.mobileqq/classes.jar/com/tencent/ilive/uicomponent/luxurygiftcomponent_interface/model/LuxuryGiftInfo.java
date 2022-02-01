package com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model;

import java.util.ArrayList;

public class LuxuryGiftInfo
{
  public static final int GIFT_NOBILITY_EFFECT_TYPE = 1;
  public static final int GIFT_TYPE_COMBO = 101;
  public static final int GIFT_TYPE_HONORABLE = 104;
  public static final int GIFT_TYPE_VOTE = 106;
  public String activeIcon;
  public String apngUrl;
  public int beginTs;
  public int belong;
  public String bigIcon;
  public ArrayList<LuxuryGiftInfo.GiftNewEffect> clickEffectList = new ArrayList();
  public String comment;
  public int defaultCount;
  public byte[] displayConfig;
  public boolean displayGiftName;
  public boolean displayIcon;
  public int displayType;
  public String displayWord;
  public int duration;
  public String effectId;
  public long effectType;
  public int endTs;
  public String giftComment;
  public ArrayList<LuxuryGiftInfo.GiftEffect> giftEffectList = new ArrayList();
  public long giftId;
  public String giftName;
  public String giftRootPath = "";
  public long giftScene;
  public int giftType;
  public int isLocked;
  public boolean isResUpdate = false;
  public String lottieConfigFilePath = "";
  public String lottiePlayConfigFilePath = "";
  public String mediaFilePath = "";
  public String middleIcon;
  public ArrayList<LuxuryGiftInfo.GiftNewEffect> newEffectList;
  public int price;
  public int priority;
  public int resLevel = 0;
  public String resourceMd5 = "";
  public byte[] resourcePack;
  public String resourceUrl = "";
  public String smallIcon;
  public ArrayList<LuxuryGiftInfo.SpecialNumber> specialNumList = new ArrayList();
  public long timestamp;
  public int vibrate;
  public int vibrateRange;
  public int visible;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent_interface.model.LuxuryGiftInfo
 * JD-Core Version:    0.7.0.1
 */