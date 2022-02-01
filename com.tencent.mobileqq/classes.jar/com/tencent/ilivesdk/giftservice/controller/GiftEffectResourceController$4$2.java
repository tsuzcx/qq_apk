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
    byte[] arrayOfByte = MD5Utils.getFileMd5(this.this$1.val$sourceFile.getPath());
    Object localObject = "";
    if (arrayOfByte != null) {
      localObject = HexUtil.bytesToHexString(arrayOfByte);
    }
    if ((!((String)localObject).equalsIgnoreCase(this.val$destGiftEffectResourceInfo.mResourceMD5)) && (!TextUtils.isEmpty(this.val$destGiftEffectResourceInfo.mResourceMD5)))
    {
      GiftEffectResourceController.access$000(this.this$1.this$0).getServiceAdapter().getLogger().i("GiftEffectResourceController", "file md5 error!" + this.val$destGiftEffectResourceInfo, new Object[0]);
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
    localObject = new StringBuffer(GiftEffectResourceController.access$400(this.this$1.this$0).getPath());
    ((StringBuffer)localObject).append("/");
    ((StringBuffer)localObject).append(this.val$destGiftEffectResourceInfo.mGiftEffectId);
    ((StringBuffer)localObject).append("/");
    localObject = ((StringBuffer)localObject).toString();
    int i = GZipUtil.unZipFolder(this.this$1.val$sourceFile.getPath(), (String)localObject);
    GiftEffectResourceController.access$000(this.this$1.this$0).getServiceAdapter().getLogger().i("GiftEffectResourceController", "uzip code:" + i, new Object[0]);
    if (i != 0)
    {
      ThreadCenter.postDelayedUITask(this.this$1.this$0, new GiftEffectResourceController.4.2.2(this), 0L);
      return;
    }
    this.val$destGiftEffectResourceInfo.mGiftRootPath = ((String)localObject + this.val$destGiftEffectResourceInfo.mGiftEffectId + "/");
    this.val$destGiftEffectResourceInfo.mMediaFilePath = GiftEffectResourceController.access$900(this.this$1.this$0, (String)localObject + this.val$destGiftEffectResourceInfo.mGiftEffectId + "/");
    this.val$destGiftEffectResourceInfo.mLottieConfigFilePath = ((String)localObject + this.val$destGiftEffectResourceInfo.mGiftEffectId + "/data.json");
    this.val$destGiftEffectResourceInfo.mLottiePlayConfigFilePath = ((String)localObject + this.val$destGiftEffectResourceInfo.mGiftEffectId + "/lottiestart.json");
    ThreadCenter.postDelayedUITask(this.this$1.this$0, new GiftEffectResourceController.4.2.3(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController.4.2
 * JD-Core Version:    0.7.0.1
 */