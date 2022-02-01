package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import java.util.Comparator;

class AdvertisementInfoModule$1
  implements Comparator<AdvertisementInfo>
{
  AdvertisementInfoModule$1(AdvertisementInfoModule paramAdvertisementInfoModule) {}
  
  public int a(AdvertisementInfo paramAdvertisementInfo1, AdvertisementInfo paramAdvertisementInfo2)
  {
    return paramAdvertisementInfo1.mAdKdPos - paramAdvertisementInfo2.mAdKdPos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.AdvertisementInfoModule.1
 * JD-Core Version:    0.7.0.1
 */