package com.tencent.ilivesdk.giftservice_interface.model;

import java.util.ArrayList;

public class GiftInfo
{
  public static final int GIFT_NOBILITY_EFFECT_TYPE = 1;
  public static final int GIFT_TAB_LINKMIC = -1;
  public static final int GIFT_TAB_NOBILITY = 4;
  public static final int GIFT_TYPE_VOTE = 106;
  public String mActiveIcon;
  public String mApngUrl;
  public int mBeginTs;
  public int mBelong;
  public String mBigIcon;
  public ArrayList<GiftInfo.GiftNewEffect> mClickEffectList = new ArrayList();
  public String mComment;
  public int mDefaultCount;
  public byte[] mDisplayConfig;
  public boolean mDisplayGiftName;
  public boolean mDisplayIcon;
  public int mDisplayType;
  public String mDisplayWord;
  public String mEffectId;
  public long mEffectType;
  public int mEndTs;
  public String mGiftComment;
  public ArrayList<GiftInfo.GiftEffect> mGiftEffectList = new ArrayList();
  public int mGiftId;
  public String mGiftName;
  public long mGiftScene;
  public int mGiftType;
  public int mIsLocked;
  public String mMiddleIcon;
  public ArrayList<GiftInfo.GiftNewEffect> mNewEffectList = new ArrayList();
  public int mNobelType;
  public int mPrice;
  public int mPriority;
  public byte[] mResourcePack;
  public String mSmallIcon;
  public ArrayList<GiftInfo.SpecialNumber> mSpecialNumList = new ArrayList();
  public int mTabId;
  public String mTagUrl;
  public long mTimestamp;
  public int mVisible;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GiftInfo{mGiftId=");
    localStringBuilder.append(this.mGiftId);
    localStringBuilder.append(", mGiftName='");
    localStringBuilder.append(this.mGiftName);
    localStringBuilder.append(", mPrice=");
    localStringBuilder.append(this.mPrice);
    localStringBuilder.append(", mGiftType=");
    localStringBuilder.append(this.mGiftType);
    localStringBuilder.append(", tabId=");
    localStringBuilder.append(this.mTabId);
    localStringBuilder.append(", mSmallIcon='");
    localStringBuilder.append(this.mSmallIcon);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice_interface.model.GiftInfo
 * JD-Core Version:    0.7.0.1
 */