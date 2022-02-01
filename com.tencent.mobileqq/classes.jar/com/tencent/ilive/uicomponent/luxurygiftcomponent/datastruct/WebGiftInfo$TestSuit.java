package com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct;

public class WebGiftInfo$TestSuit
{
  private static String[] COMMENT = { "送了一个超级跑车", "送了一个皇家飞机", "带你私奔到太空" };
  private static String[] EFFECT_ID = { "car", "airplane", "rocket" };
  private static String[] GIFT_NAME = { "超级跑车", "皇家飞机", "私奔到太空" };
  
  public static WebGiftInfo obtain(int paramInt)
  {
    if (paramInt >= EFFECT_ID.length) {}
    WebGiftInfo localWebGiftInfo = new WebGiftInfo();
    localWebGiftInfo.senderName = "枫叶飘飘";
    localWebGiftInfo.senderHeadUrl = "";
    localWebGiftInfo.effectId = EFFECT_ID[0];
    localWebGiftInfo.giftName = GIFT_NAME[0];
    localWebGiftInfo.comment = COMMENT[0];
    return localWebGiftInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.uicomponent.luxurygiftcomponent.datastruct.WebGiftInfo.TestSuit
 * JD-Core Version:    0.7.0.1
 */