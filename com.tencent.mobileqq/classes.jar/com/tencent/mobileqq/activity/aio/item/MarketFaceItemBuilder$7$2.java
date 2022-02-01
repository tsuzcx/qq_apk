package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.H5MagicPlayerActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.AIOEmoticonUIHelper;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.magicface.view.MagicfaceViewController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;

class MarketFaceItemBuilder$7$2
  implements Runnable
{
  MarketFaceItemBuilder$7$2(MarketFaceItemBuilder.7 param7, Emoticon paramEmoticon, String paramString, MarketFaceItemBuilder.Holder paramHolder) {}
  
  public void run()
  {
    Object localObject1 = this.a;
    if ((localObject1 != null) && (((Emoticon)localObject1).jobType == 2) && (this.d.a.A != null) && ((this.d.a.A instanceof BaseActivity)))
    {
      localObject1 = ((BaseActivity)this.d.a.A).getChatFragment();
      if (localObject1 != null)
      {
        localObject1 = ((ChatFragment)localObject1).k();
        if ((localObject1 != null) && (MagicfaceViewController.b()))
        {
          localObject1 = (AIOEmoticonUIHelper)((BaseChatPie)localObject1).q(105);
          if (localObject1 != null) {
            ((AIOEmoticonUIHelper)localObject1).a(this.a, 1, this.b, false);
          }
        }
      }
      ReportController.b(this.d.a.d, "CliOper", "", "", "MbJieshou", "MbZidongBofang", 0, 0, "", "", "", "");
    }
    localObject1 = this.a;
    if ((localObject1 != null) && (((Emoticon)localObject1).jobType == 4) && (this.d.a.D.canPlayH5Magic()))
    {
      if (this.d.a.E)
      {
        this.c.t.setVisibility(0);
        this.c.t.setImageResource(2130837998);
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("magicFaceIcon visible,h5source download sucess and needplay epId = ");
          ((StringBuilder)localObject1).append(this.a.epId);
          QLog.d("MarketFaceItemBuilder", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        this.c.t.setVisibility(8);
      }
      localObject1 = new Intent(this.d.a.A, H5MagicPlayerActivity.class);
      ((Intent)localObject1).putExtra("clickTime", System.currentTimeMillis());
      ((Intent)localObject1).putExtra("autoPlay", "1");
      ((Intent)localObject1).putExtra("senderUin", this.b);
      ((Intent)localObject1).putExtra("selfUin", this.d.a.d.getCurrentAccountUin());
      ((Intent)localObject1).putExtra("sessionInfo", this.d.a.f);
      ((Intent)localObject1).putExtra("emoticon", this.a);
      Object localObject2 = (IEmoticonManagerService)this.d.a.d.getRuntimeService(IEmoticonManagerService.class);
      EmoticonPackage localEmoticonPackage = ((IEmoticonManagerService)localObject2).syncFindEmoticonPackageById(this.a.epId);
      if (localEmoticonPackage != null)
      {
        localObject2 = ((IEmoticonManagerService)localObject2).syncGetSubEmoticonsByPackageId(localEmoticonPackage.childEpId);
        if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
          ((Intent)localObject1).putExtra("childEmoticon", (Serializable)((List)localObject2).get(0));
        }
      }
      this.d.a.A.startActivity((Intent)localObject1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7.2
 * JD-Core Version:    0.7.0.1
 */