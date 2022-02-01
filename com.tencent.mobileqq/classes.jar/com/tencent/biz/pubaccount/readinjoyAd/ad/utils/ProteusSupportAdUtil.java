package com.tencent.biz.pubaccount.readinjoyAd.ad.utils;

import com.tencent.mobileqq.kandian.biz.pts.api.IProteusSupportUtil;
import com.tencent.mobileqq.qroute.QRoute;

public class ProteusSupportAdUtil
{
  public static boolean a(int paramInt)
  {
    if (!((IProteusSupportUtil)QRoute.api(IProteusSupportUtil.class)).isSupportProteus()) {
      return false;
    }
    if ((paramInt != 39) && (paramInt != 66) && (paramInt != 127) && (paramInt != 115) && (paramInt != 116)) {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return false;
        }
        break;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ProteusSupportAdUtil
 * JD-Core Version:    0.7.0.1
 */