package com.tencent.biz.pubaccount.readinjoy.srtUtils;

public class SRTFactory
{
  public static ReadInJoySrtHandler.IRuleManager a(int paramInt)
  {
    if (paramInt == ReadInJoySrtHandler.a) {
      return new UGRuleManager();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.srtUtils.SRTFactory
 * JD-Core Version:    0.7.0.1
 */