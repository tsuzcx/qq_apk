package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import java.util.ArrayList;
import java.util.List;

public class WSVerticalDataTransfer
  implements IWSDramaFeedTransfer<WSVerticalItemData>
{
  public ArrayList<WSVerticalItemData> b(stDrama paramstDrama, List<stDramaFeed> paramList)
  {
    return WSVerticalDataUtil.a(paramstDrama, paramList, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.WSVerticalDataTransfer
 * JD-Core Version:    0.7.0.1
 */