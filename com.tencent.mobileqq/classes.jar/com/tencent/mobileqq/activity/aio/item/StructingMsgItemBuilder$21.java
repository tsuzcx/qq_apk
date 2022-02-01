package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.widget.ProgressBar;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.app.TroopQZoneUploadAlbumHandler.Callback;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

class StructingMsgItemBuilder$21
  implements TroopQZoneUploadAlbumHandler.Callback
{
  StructingMsgItemBuilder$21(StructingMsgItemBuilder paramStructingMsgItemBuilder, MessageForStructing paramMessageForStructing, BaseChatItemLayout paramBaseChatItemLayout) {}
  
  public void a(View paramView, long paramLong, int paramInt1, int paramInt2)
  {
    if (this.a.uniseq != paramLong) {
      return;
    }
    paramView = (StructMsgForGeneralShare)this.a.structingMsg;
    if (paramInt1 != 1001) {
      paramInt2 = 100;
    }
    paramView.setProgress(paramInt2);
    paramView = this.b.findViewById(2131446454);
    if ((paramView instanceof ProgressBar))
    {
      ((ProgressBar)paramView).setProgress(paramInt2);
      if (paramInt2 == 100) {
        paramInt1 = 8;
      } else {
        paramInt1 = 0;
      }
      paramView.setVisibility(paramInt1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.21
 * JD-Core Version:    0.7.0.1
 */