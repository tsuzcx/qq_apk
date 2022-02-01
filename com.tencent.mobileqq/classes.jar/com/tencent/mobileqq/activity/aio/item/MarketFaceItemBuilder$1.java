package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.IEmojiListenerManager;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQProgressDialog;

class MarketFaceItemBuilder$1
  implements QueryCallback<EmoticonPackage>
{
  MarketFaceItemBuilder$1(MarketFaceItemBuilder paramMarketFaceItemBuilder, MarketFaceItemBuilder.Holder paramHolder, QQProgressDialog paramQQProgressDialog) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    ReportController.b(this.c.d, "CliOper", "", this.c.d.getCurrentAccountUin(), "ep_mall", "Clk_button_follow", 0, 0, "", "", this.a.a.getEmoticon().eId, "");
    if (paramEmoticonPackage == null)
    {
      this.c.I.a(107, this.c.d, this.c.A, this.a.a, this.c.f, MarketFaceItemBuilder.a(this.c));
      this.c.D.getEmojiListenerManager().addEmotionJsonDownloadListener(this.c.I);
      this.c.D.startDownloadEmosmJson(this.a.a.getEmoticon().epId, EmojiManagerServiceConstant.JSON_EMOSM_MALL);
      return;
    }
    MarketFaceItemBuilder.a(107, this.c.A, this.c.d, paramEmoticonPackage, this.a.a, this.c.f, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */