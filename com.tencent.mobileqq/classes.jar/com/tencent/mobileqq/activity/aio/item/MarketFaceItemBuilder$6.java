package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import java.io.Serializable;
import java.util.List;

class MarketFaceItemBuilder$6
  implements Runnable
{
  MarketFaceItemBuilder$6(MarketFaceItemBuilder paramMarketFaceItemBuilder, String paramString, MarketFaceItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.this$0.A, H5MagicPlayerActivity.class);
    localIntent.putExtra("clickTime", System.currentTimeMillis());
    localIntent.putExtra("autoPlay", this.a);
    localIntent.putExtra("senderUin", this.b.q.senderuin);
    localIntent.putExtra("selfUin", this.this$0.d.getCurrentAccountUin());
    localIntent.putExtra("sessionInfo", this.this$0.f);
    localIntent.putExtra("emoticon", this.b.a.getEmoticon());
    Object localObject = (IEmoticonManagerService)this.this$0.d.getRuntimeService(IEmoticonManagerService.class);
    EmoticonPackage localEmoticonPackage = ((IEmoticonManagerService)localObject).syncFindEmoticonPackageById(this.b.a.getEmoticon().epId);
    if (localEmoticonPackage != null)
    {
      localObject = ((IEmoticonManagerService)localObject).syncGetSubEmoticonsByPackageId(localEmoticonPackage.childEpId);
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        localIntent.putExtra("childEmoticon", (Serializable)((List)localObject).get(0));
      }
    }
    this.this$0.A.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */