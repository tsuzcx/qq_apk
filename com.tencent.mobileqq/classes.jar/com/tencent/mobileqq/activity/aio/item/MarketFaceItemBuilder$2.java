package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class MarketFaceItemBuilder$2
  implements QueryCallback<EmoticonPackage>
{
  MarketFaceItemBuilder$2(MarketFaceItemBuilder paramMarketFaceItemBuilder, int paramInt, ChatMessage paramChatMessage) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    String str;
    int i;
    if (paramEmoticonPackage != null)
    {
      str = paramEmoticonPackage.epId;
      if ((3 != paramEmoticonPackage.jobType) && (5 != paramEmoticonPackage.jobType)) {
        i = 1;
      } else {
        i = 2;
      }
    }
    else
    {
      str = "0";
      i = -1;
    }
    int j = this.a;
    if (j == 2131431695)
    {
      ChatActivityFacade.b(this.c.A, this.c.d, this.b);
      ReportController.b(this.c.d, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "4", "", "", "");
      return;
    }
    if (j == 2131427822)
    {
      this.c.a(paramEmoticonPackage, str, i);
      return;
    }
    if ((j != 2131433653) && (j != 2131433419))
    {
      if (j == 2131438942)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 4, "marketface related click");
        }
        if ((MarketFaceItemBuilder.w != null) && (MarketFaceItemBuilder.x != null))
        {
          if (MarketFaceItemBuilder.w.getEmoticon() == null) {
            return;
          }
          ReportController.b(this.c.d, "dc00898", "", this.c.f.b, "0X800B115", "0X800B115", EmoticonPanelUtils.e(this.c.f.a), 0, "1", "", MarketFaceItemBuilder.w.getEmoticon().epId, MarketFaceItemBuilder.w.getEmoticon().eId);
          this.c.f(MarketFaceItemBuilder.x);
          return;
        }
      }
    }
    else {
      this.c.a(paramEmoticonPackage, str, i, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */