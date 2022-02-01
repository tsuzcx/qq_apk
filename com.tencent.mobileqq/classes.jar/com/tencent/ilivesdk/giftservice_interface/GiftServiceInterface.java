package com.tencent.ilivesdk.giftservice_interface;

import com.tencent.falco.base.libapi.ServiceBaseInterface;
import com.tencent.ilivesdk.giftservice_interface.model.GiftEffectResourceInfo;
import com.tencent.ilivesdk.giftservice_interface.model.GiftInfo;
import com.tencent.ilivesdk.giftservice_interface.model.GiftMessage;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResInfoListener;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract interface GiftServiceInterface
  extends ServiceBaseInterface
{
  public abstract void addReceiveGiftMessageListener(GiftServiceInterface.ReceiveGiftMessageListener paramReceiveGiftMessageListener);
  
  public abstract void delReceiveGiftMessageListener(GiftServiceInterface.ReceiveGiftMessageListener paramReceiveGiftMessageListener);
  
  public abstract void downloadGiftEffectResource(Map<Integer, List<GiftInfo>> paramMap, IGetGiftEffectResInfoListener paramIGetGiftEffectResInfoListener, IGetGiftEffectResListener paramIGetGiftEffectResListener);
  
  public abstract GiftInfo getGiftInfo(int paramInt);
  
  public abstract void init(GiftServiceAdapter paramGiftServiceAdapter);
  
  public abstract void presentGift(GiftMessage paramGiftMessage, GiftServiceInterface.OnPresentGiftCallback paramOnPresentGiftCallback);
  
  public abstract void queryAllGiftsInfo(long paramLong, int paramInt, GiftServiceInterface.OnQueryAllGiftsInfoCallback paramOnQueryAllGiftsInfoCallback);
  
  public abstract void queryGiftInfo(int paramInt, GiftServiceInterface.OnQueryGiftInfoCallback paramOnQueryGiftInfoCallback);
  
  public abstract void queryH264GiftInfo(ArrayList<String> paramArrayList, IGetGiftEffectResInfoListener paramIGetGiftEffectResInfoListener);
  
  public abstract void queryH264GiftRes(List<GiftEffectResourceInfo> paramList, IGetGiftEffectResListener paramIGetGiftEffectResListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface
 * JD-Core Version:    0.7.0.1
 */