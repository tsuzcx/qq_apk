package com.tencent.ilivesdk.giftservice.controller;

import com.tencent.falco.base.libapi.downloader.IDownLoaderListener;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.ilivesdk.giftservice.GiftService;
import com.tencent.ilivesdk.giftservice_interface.GiftServiceAdapter;
import com.tencent.ilivesdk.giftservice_interface.model.GiftEffectResourceInfo;
import com.tencent.ilivesdk.giftservice_interface.model.IGetGiftEffectResListener;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class GiftEffectResourceController$4
  implements IDownLoaderListener
{
  GiftEffectResourceController$4(GiftEffectResourceController paramGiftEffectResourceController, IGetGiftEffectResListener paramIGetGiftEffectResListener, File paramFile) {}
  
  public void onDownloadStateChanged(int paramInt1, String paramString1, String paramString2, int paramInt2) {}
  
  public void onFail(int paramInt, String paramString1, String paramString2)
  {
    GiftEffectResourceController.access$000(this.this$0).getServiceAdapter().getLogger().e("GiftEffectResourceController", "download failed errorcode:" + paramInt, new Object[0]);
    paramString1 = new GiftEffectResourceInfo();
    ThreadCenter.postDelayedUITask(this.this$0, new GiftEffectResourceController.4.3(this, paramString1), 0L);
  }
  
  public void onProgress(String paramString, long paramLong, int paramInt1, int paramInt2) {}
  
  public void onSuccess(String paramString1, String paramString2)
  {
    GiftEffectResourceInfo localGiftEffectResourceInfo = new GiftEffectResourceInfo();
    Iterator localIterator = GiftEffectResourceController.access$600(this.this$0).entrySet().iterator();
    Map.Entry localEntry;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localEntry = (Map.Entry)localIterator.next();
    } while ((localEntry == null) || (localEntry.getValue() == null) || (!paramString1.equals(((GiftEffectResourceInfo)localEntry.getValue()).mResourceUrl)));
    for (paramString1 = (GiftEffectResourceInfo)localEntry.getValue();; paramString1 = localGiftEffectResourceInfo)
    {
      if (!new File(paramString2).exists())
      {
        GiftEffectResourceController.access$000(this.this$0).getServiceAdapter().getLogger().e("GiftEffectResourceController", "file is null", new Object[0]);
        ThreadCenter.postDelayedUITask(this.this$0, new GiftEffectResourceController.4.1(this, paramString1), 0L);
        return;
      }
      GiftEffectResourceController.access$802(this.this$0, new GiftEffectResourceController.4.2(this, paramString1));
      ThreadCenter.postLogicTask(GiftEffectResourceController.access$800(this.this$0));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.giftservice.controller.GiftEffectResourceController.4
 * JD-Core Version:    0.7.0.1
 */