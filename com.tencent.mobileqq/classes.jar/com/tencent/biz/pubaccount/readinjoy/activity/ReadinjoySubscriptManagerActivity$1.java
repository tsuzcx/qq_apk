package com.tencent.biz.pubaccount.readinjoy.activity;

import android.text.TextUtils;
import java.util.Comparator;

class ReadinjoySubscriptManagerActivity$1
  implements Comparator<ReadinjoySubscriptManagerActivity.SubscribeFeedData>
{
  ReadinjoySubscriptManagerActivity$1(ReadinjoySubscriptManagerActivity paramReadinjoySubscriptManagerActivity) {}
  
  public int a(ReadinjoySubscriptManagerActivity.SubscribeFeedData paramSubscribeFeedData1, ReadinjoySubscriptManagerActivity.SubscribeFeedData paramSubscribeFeedData2)
  {
    int j = 2147483647;
    int i;
    if (TextUtils.isEmpty(ReadinjoySubscriptManagerActivity.SubscribeFeedData.a(paramSubscribeFeedData1)))
    {
      i = 2147483647;
      if (!TextUtils.isEmpty(ReadinjoySubscriptManagerActivity.SubscribeFeedData.a(paramSubscribeFeedData2))) {
        break label44;
      }
    }
    for (;;)
    {
      return i - j;
      i = ReadinjoySubscriptManagerActivity.SubscribeFeedData.a(paramSubscribeFeedData1).codePointAt(0);
      break;
      label44:
      j = ReadinjoySubscriptManagerActivity.SubscribeFeedData.a(paramSubscribeFeedData2).codePointAt(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity.1
 * JD-Core Version:    0.7.0.1
 */