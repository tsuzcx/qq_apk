package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.troop.essencemsg.TroopEssenceReportUtil;
import com.tencent.mobileqq.util.DisplayUtil;

class TextItemBuilder$3
  implements Runnable
{
  TextItemBuilder$3(TextItemBuilder paramTextItemBuilder, TextItemBuilder.Holder paramHolder, ChatMessage paramChatMessage1, ChatMessage paramChatMessage2) {}
  
  public void run()
  {
    if ((this.a.h.getMeasuredWidth() < DisplayUtil.a(this.this$0.e, 70.0F)) && (this.b.isSend())) {
      TextItemBuilder.a(this.this$0, this.a.A);
    } else {
      this.this$0.a(this.a.A, this.a.j, null, this.c, 0, null);
    }
    QQAppInterface localQQAppInterface = this.this$0.d;
    View localView = this.a.A;
    String str;
    if (this.this$0.f != null) {
      str = this.this$0.f.b;
    } else {
      str = null;
    }
    TroopEssenceReportUtil.a(localQQAppInterface, localView, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */