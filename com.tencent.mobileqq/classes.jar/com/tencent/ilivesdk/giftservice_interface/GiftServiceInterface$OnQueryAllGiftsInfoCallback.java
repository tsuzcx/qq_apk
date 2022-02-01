package com.tencent.ilivesdk.giftservice_interface;

import com.tencent.ilivesdk.giftservice_interface.model.GiftInfo;
import com.tencent.ilivesdk.giftservice_interface.model.TabInfo;
import java.util.List;
import java.util.Map;

public abstract interface GiftServiceInterface$OnQueryAllGiftsInfoCallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onGetAllGiftsInfo(Map<Integer, List<GiftInfo>> paramMap, List<TabInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface.OnQueryAllGiftsInfoCallback
 * JD-Core Version:    0.7.0.1
 */