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
    GiftEffectResourceController.access$000(this.this$0).getServiceAdapter().getLogger().i("GiftEffectResourceController", " in error !!" + paramString + " code=" + paramInt, new Object[0]);
    GiftEffectResourceController.access$100(this.this$0, null);
  }
  
  public void onRecv(byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = null;
    if (paramArrayOfByte == null)
    {
      GiftEffectResourceController.access$000(this.this$0).getServiceAdapter().getLogger().i("GiftEffectResourceController", "data is null", new Object[0]);
      GiftEffectResourceController.access$100(this.this$0, null);
      if (this.val$listener != null) {
        this.val$listener.onCompleted(null);
      }
      return;
    }
    try
    {
      paramArrayOfByte = BatchGetLuxuryGiftVideoConfigRsp.parseFrom(paramArrayOfByte);
      localArrayList = new ArrayList();
      int j = 0;
      i = 0;
      for (;;)
      {
        if (j >= paramArrayOfByte.videoUrl.length) {
          break label334;
        }
        localVideoUrl = paramArrayOfByte.videoUrl[j];
        if (localVideoUrl.isGrey != 0) {
          break;
        }
        GiftEffectResourceController.access$000(this.this$0).getServiceAdapter().getLogger().i("GiftEffectResourceController", "giftId:" + localVideoUrl.lgeId + "is not gray", new Object[0]);
        j += 1;
      }
    }
    catch (InvalidProtocolBufferNanoException paramArrayOfByte)
    {
      int i;
      for (;;)
      {
        VideoUrl localVideoUrl;
        GiftEffectResourceController.access$000(this.this$0).getServiceAdapter().getLogger().e("GiftEffectResourceController", "BatchGetLuxuryGiftVideoConfigRsp.parseFrom is error:" + paramArrayOfByte.getMessage(), new Object[0]);
        paramArrayOfByte = localArrayList;
        continue;
        GiftEffectResourceInfo localGiftEffectResourceInfo = new GiftEffectResourceInfo();
        localGiftEffectResourceInfo.mGiftEffectId = localVideoUrl.lgeId;
        localGiftEffectResourceInfo.mResourceMD5 = localVideoUrl.hash;
        localGiftEffectResourceInfo.mResLevel = localVideoUrl.level;
        localGiftEffectResourceInfo.mResourceUrl = localVideoUrl.url;
        localGiftEffectResourceInfo.mIsResUpdate = GiftEffectResourceController.access$200(this.this$0, localGiftEffectResourceInfo.mGiftEffectId, localGiftEffectResourceInfo.mResourceMD5);
        localGiftEffectResourceInfo.mVibrate = localVideoUrl.vibrate;
        localGiftEffectResourceInfo.mVibrateRange = localVideoUrl.vibrateRange;
        if (localGiftEffectResourceInfo.mIsResUpdate) {
          i = 1;
        }
        localArrayList.add(localGiftEffectResourceInfo);
      }
      label334:
      if (i != 0) {
        GiftEffectResourceController.access$300(this.this$0);
      }
      if (this.val$listener != null) {
        this.val$listener.onCompleted(localArrayList);
      }
      GiftEffectResourceController.access$100(this.this$0, localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController.1
 * JD-Core Version:    0.7.0.1
 */