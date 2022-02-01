package com.tencent.biz.pubaccount.readinjoyAd.ad.item;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebRecommendAdService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.repo.pts.entity.ProteusItemData;
import com.tencent.mobileqq.qroute.QRoute;

class WebFastProteusViewAdBannerBigPicCreator$ProteusItemViewHolder$1$1
  implements ViewBase.OnClickListener
{
  WebFastProteusViewAdBannerBigPicCreator$ProteusItemViewHolder$1$1(WebFastProteusViewAdBannerBigPicCreator.ProteusItemViewHolder.1 param1) {}
  
  public void onClick(ViewBase paramViewBase)
  {
    if ((this.a.c.b instanceof ProteusItemData))
    {
      int i = -1;
      boolean bool = false;
      int j = StringCommon.getStrIdFromString(paramViewBase.getClickEvnet());
      if (j != 1071)
      {
        if (j != 1111)
        {
          if (j != 1112)
          {
            if (j != 1127)
            {
              if (j != 1128)
              {
                switch (j)
                {
                default: 
                  switch (j)
                  {
                  default: 
                    break;
                  case 1125: 
                    i = 8;
                    break;
                  case 1124: 
                    i = 5;
                  }
                  break;
                case 1109: 
                  i = 3;
                  break;
                case 1108: 
                  i = 4;
                  break;
                case 1107: 
                  i = 102;
                  break;
                case 1106: 
                  i = 101;
                  break;
                }
              }
              else
              {
                i = 2;
                break label188;
              }
            }
            else
            {
              i = 1000;
              break label188;
            }
          }
          else {
            i = 102;
          }
        }
        else {
          i = 101;
        }
        bool = true;
        label188:
        if (((i == 4) || (i == 3) || (i == 1000) || (i == 8)) && (FastWeqAdUtils.h((AdData)this.a.a)))
        {
          FastWeqAdUtils.b(this.a.b, (AdData)this.a.a);
          return;
        }
        ((IRIJFastWebRecommendAdService)QRoute.api(IRIJFastWebRecommendAdService.class)).onAdJump(this.a.b, (AdData)this.a.c.b, bool, i);
        return;
      }
      JumpAdUtils.a(this.a.a, paramViewBase.getNativeView(), this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerBigPicCreator.ProteusItemViewHolder.1.1
 * JD-Core Version:    0.7.0.1
 */