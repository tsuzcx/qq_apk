package com.tencent.ilivesdk.giftservice_interface;

import com.tencent.ilivesdk.giftservice_interface.model.GiftMessage;

public abstract interface GiftServiceInterface$OnPresentGiftCallback
{
  public abstract void onFail(int paramInt, String paramString);
  
  public abstract void onPresentGift(GiftMessage paramGiftMessage);
  
  public abstract void onPresentGiftFail(GiftMessage paramGiftMessage);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice_interface.GiftServiceInterface.OnPresentGiftCallback
 * JD-Core Version:    0.7.0.1
 */