package com.tencent.ilivesdk.floatheartservice_interface.model;

import java.util.ArrayList;

public class FloatHeartInfo
{
  public static final int BRONZE_TYPE = 10;
  public static final int CUSTOM_GIFT_TYPE = 102;
  public static final int DIAMOND_TYPE = 50;
  public static final int EFFECT_FACE_RECOGNITION_TYPE = 1;
  public static final int GIFT_NOBILITY_EFFECT_TYPE = 1;
  public static final int GIFT_TAB_CUSTOMIZE = 2;
  public static final int GIFT_TAB_JINGPIN = 1;
  public static final int GIFT_TAB_LINKMIC = -1;
  public static final int GIFT_TAB_NOBILITY = 4;
  public static final int GIFT_TAB_PACKAGE = 3;
  public static final int GIFT_TAB_VOTE = 5;
  public static final int GIFT_TYPE_HIDE = 107;
  public static final int GOLD_TYPE = 30;
  public static final int HIDE_GIFT_TYPE_HEART = 1;
  public static final int LUXURY_GIFT_TYPE = 103;
  public static final int NORMAL_GIFT_TYPE = 101;
  public static final int PLATINUM_TYPE = 40;
  public static final int SILVER_TYPE = 20;
  public String activeIcon;
  public String apngUrl;
  public int beginTs;
  public int belong;
  public String bigIcon;
  public ArrayList<FloatHeartInfo.GiftNewEffect> clickEffectList;
  public String comment;
  public int danmuSpeed;
  public int danmuStyle;
  public int defaultCount;
  public byte[] displayConfig;
  public boolean displayGiftName;
  public boolean displayIcon;
  public int displayType;
  public String displayWord;
  public String effectId;
  public long effectType;
  public int endTs;
  public int friendScence;
  public String giftComment;
  public ArrayList<FloatHeartInfo.GiftEffect> giftEffectList;
  public int giftId;
  public String giftName;
  public long giftScene;
  public int giftType;
  public int hideGiftType;
  public int isLocked;
  public String middleIcon;
  public ArrayList<FloatHeartInfo.GiftNewEffect> newEffectList;
  public int nobelType;
  public int price;
  public int priority;
  public byte[] resourcePack;
  public String smallIcon;
  public ArrayList<FloatHeartInfo.SpecialNumber> specialNumList;
  public int tabId;
  public int timestamp;
  public int visible;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.floatheartservice_interface.model.FloatHeartInfo
 * JD-Core Version:    0.7.0.1
 */