package com.tencent.ilivesdk.giftservice.controller;

import android.text.TextUtils;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.GZipUtil;
import com.tencent.falco.utils.HexUtil;
import com.tencent.falco.utils.MD5Utils;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilivesdk.giftservice.GiftService;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceAdapter;
import com.tencent.ilivesdk.giftservice_interface.model.GiftEffectResourceInfo;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResListener;
import java.io.File;

class GiftEffectResourceController$4$2
  implements Runnable
{
  GiftEffectResourceController$4$2(GiftEffectResourceController.4 param4, GiftEffectResourceInfo paramGiftEffectResourceInfo) {}
  
  public void run()
  {
    Object localObject1 = MD5Utils.getFileMd5(this.this$1.val$sourceFile.getPath());
    if (localObject1 != null) {
      localObject1 = HexUtil.bytesToHexString((byte[])localObject1);
    } else {
      localObject1 = "";
    }
    if ((!((String)localObject1).equalsIgnoreCase(this.val$destGiftEffectResourceInfo.mResourceMD5)) && (!TextUtils.isEmpty(this.val$destGiftEffectResourceInfo.mResourceMD5)))
    {
      localObject1 = GiftEffectResourceController.access$000(this.this$1.this$0).getServiceAdapter().getLogger();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("file md5 error!");
      ((StringBuilder)localObject2).append(this.val$destGiftEffectResourceInfo);
      ((LogInterface)localObject1).i("GiftEffectResourceController", ((StringBuilder)localObject2).toString(), new Object[0]);
      ThreadCenter.postDelayedUITask(this.this$1.this$0, new GiftEffectResourceController.4.2.1(this), 0L);
      return;
    }
    if (TextUtils.isEmpty(this.val$destGiftEffectResourceInfo.mGiftEffectId))
    {
      if (this.this$1.val$listener != null) {
        this.this$1.val$listener.onCompleted(null);
      }
      GiftEffectResourceController.access$000(this.this$1.this$0).getServiceAdapter().getLogger().i("GiftEffectResourceController", "gift id empty, return", new Object[0]);
      return;
    }
    localObject1 = new StringBuffer(GiftEffectResourceController.access$400(this.this$1.this$0).getPath());
    ((StringBuffer)localObject1).append("/");
    ((StringBuffer)localObject1).append(this.val$destGiftEffectResourceInfo.mGiftEffectId);
    ((StringBuffer)localObject1).append("/");
    localObject1 = ((StringBuffer)localObject1).toString();
    int i = GZipUtil.unZipFolder(this.this$1.val$sourceFile.getPath(), (String)localObject1);
    Object localObject2 = GiftEffectResourceController.access$000(this.this$1.this$0).getServiceAdapter().getLogger();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("uzip code:");
    ((StringBuilder)localObject3).append(i);
    ((LogInterface)localObject2).i("GiftEffectResourceController", ((StringBuilder)localObject3).toString(), new Object[0]);
    if (i != 0)
    {
      ThreadCenter.postDelayedUITask(this.this$1.this$0, new GiftEffectResourceController.4.2.2(this), 0L);
      return;
    }
    localObject2 = this.val$destGiftEffectResourceInfo;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(this.val$destGiftEffectResourceInfo.mGiftEffectId);
    ((StringBuilder)localObject3).append("/");
    ((GiftEffectResourceInfo)localObject2).mGiftRootPath = ((StringBuilder)localObject3).toString();
    localObject2 = this.val$destGiftEffectResourceInfo;
    localObject3 = this.this$1.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(this.val$destGiftEffectResourceInfo.mGiftEffectId);
    localStringBuilder.append("/");
    ((GiftEffectResourceInfo)localObject2).mMediaFilePath = GiftEffectResourceController.access$900((GiftEffectResourceController)localObject3, localStringBuilder.toString());
    localObject2 = this.val$destGiftEffectResourceInfo;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(this.val$destGiftEffectResourceInfo.mGiftEffectId);
    ((StringBuilder)localObject3).append("/data.json");
    ((GiftEffectResourceInfo)localObject2).mLottieConfigFilePath = ((StringBuilder)localObject3).toString();
    localObject2 = this.val$destGiftEffectResourceInfo;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(this.val$destGiftEffectResourceInfo.mGiftEffectId);
    ((StringBuilder)localObject3).append("/lottiestart.json");
    ((GiftEffectResourceInfo)localObject2).mLottiePlayConfigFilePath = ((StringBuilder)localObject3).toString();
    ThreadCenter.postDelayedUITask(this.this$1.this$0, new GiftEffectResourceController.4.2.3(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController.4.2
 * JD-Core Version:    0.7.0.1
 */