package com.tencent.ilivesdk.giftservice.controller;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.falco.base.libapi.channel.ChannelCallback;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.ilivesdk.giftservice.GiftService;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceAdapter;
import com.tencent.ilivesdk.giftservice_interface.model.GiftEffectResourceInfo;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResInfoListener;
import com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.BatchGetLuxuryGiftVideoConfigRsp;
import com.tencent.protobuf.iliveLuxuryGiftVideoSvr.nano.VideoUrl;
import java.util.ArrayList;
import java.util.List;

class GiftEffectResourceController$1
  implements ChannelCallback
{
  GiftEffectResourceController$1(GiftEffectResourceController paramGiftEffectResourceController, IGetGiftEffectResInfoListener paramIGetGiftEffectResInfoListener) {}
  
  public void onError(boolean paramBoolean, int paramInt, String paramString)
  {
    LogInterface localLogInterface = GiftEffectResourceController.access$000(this.this$0).getServiceAdapter().getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" in error !!");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" code=");
    localStringBuilder.append(paramInt);
    localLogInterface.i("GiftEffectResourceController", localStringBuilder.toString(), new Object[0]);
    GiftEffectResourceController.access$100(this.this$0, null);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = null;
    if (paramArrayOfByte == null)
    {
      GiftEffectResourceController.access$000(this.this$0).getServiceAdapter().getLogger().i("GiftEffectResourceController", "data is null", new Object[0]);
      GiftEffectResourceController.access$100(this.this$0, null);
      paramArrayOfByte = this.val$listener;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.onCompleted(null);
      }
      return;
    }
    Object localObject1;
    Object localObject2;
    try
    {
      paramArrayOfByte = BatchGetLuxuryGiftVideoConfigRsp.parseFrom(paramArrayOfByte);
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      localObject1 = GiftEffectResourceController.access$000(this.this$0).getServiceAdapter().getLogger();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("BatchGetLuxuryGiftVideoConfigRsp.parseFrom is error:");
      ((StringBuilder)localObject2).append(paramArrayOfByte.getMessage());
      ((LogInterface)localObject1).e("GiftEffectResourceController", ((StringBuilder)localObject2).toString(), new Object[0]);
      paramArrayOfByte = localArrayList;
    }
    localArrayList = new ArrayList();
    int j = 0;
    int i = 0;
    while (j < paramArrayOfByte.videoUrl.length)
    {
      localObject1 = paramArrayOfByte.videoUrl[j];
      if (((VideoUrl)localObject1).isGrey == 0)
      {
        localObject2 = GiftEffectResourceController.access$000(this.this$0).getServiceAdapter().getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("giftId:");
        localStringBuilder.append(((VideoUrl)localObject1).lgeId);
        localStringBuilder.append("is not gray");
        ((LogInterface)localObject2).i("GiftEffectResourceController", localStringBuilder.toString(), new Object[0]);
      }
      else
      {
        localObject2 = new GiftEffectResourceInfo();
        ((GiftEffectResourceInfo)localObject2).mGiftEffectId = ((VideoUrl)localObject1).lgeId;
        ((GiftEffectResourceInfo)localObject2).mResourceMD5 = ((VideoUrl)localObject1).hash;
        ((GiftEffectResourceInfo)localObject2).mResLevel = ((VideoUrl)localObject1).level;
        ((GiftEffectResourceInfo)localObject2).mResourceUrl = ((VideoUrl)localObject1).url;
        ((GiftEffectResourceInfo)localObject2).mIsResUpdate = GiftEffectResourceController.access$200(this.this$0, ((GiftEffectResourceInfo)localObject2).mGiftEffectId, ((GiftEffectResourceInfo)localObject2).mResourceMD5);
        ((GiftEffectResourceInfo)localObject2).mVibrate = ((VideoUrl)localObject1).vibrate;
        ((GiftEffectResourceInfo)localObject2).mVibrateRange = ((VideoUrl)localObject1).vibrateRange;
        if (((GiftEffectResourceInfo)localObject2).mIsResUpdate) {
          i = 1;
        }
        localArrayList.add(localObject2);
      }
      j += 1;
    }
    if (i != 0) {
      GiftEffectResourceController.access$300(this.this$0);
    }
    paramArrayOfByte = this.val$listener;
    if (paramArrayOfByte != null) {
      paramArrayOfByte.onCompleted(localArrayList);
    }
    GiftEffectResourceController.access$100(this.this$0, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController.1
 * JD-Core Version:    0.7.0.1
 */