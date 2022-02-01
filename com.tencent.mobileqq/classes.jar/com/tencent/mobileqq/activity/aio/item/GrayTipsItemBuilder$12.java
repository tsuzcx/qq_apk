package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil.TipsClickedInterface;
import com.tencent.mobileqq.vas.VasH5PayUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.vip.AioVipKeywordHelper;

class GrayTipsItemBuilder$12
  implements QQFileManagerUtil.TipsClickedInterface
{
  GrayTipsItemBuilder$12(GrayTipsItemBuilder paramGrayTipsItemBuilder, String paramString1, String paramString2, MessageRecord paramMessageRecord, String paramString3, AioVipKeywordHelper paramAioVipKeywordHelper) {}
  
  public void onClick(View paramView)
  {
    paramView = new Bundle();
    paramView.putString(VasH5PayUtil.i, this.a);
    paramView.putString(VasH5PayUtil.c, this.b);
    if (!this.c.isSend()) {
      paramView.putString(VasH5PayUtil.a, this.c.senderuin);
    }
    VasH5PayUtil.a(this.f.c, paramView);
    String str = this.d;
    if (this.c.isSend()) {
      paramView = "0";
    } else {
      paramView = "1";
    }
    VasWebviewUtil.a(str, paramView, "1", this.e.a(this.f.d.a), this.f.d.b, "", "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.12
 * JD-Core Version:    0.7.0.1
 */