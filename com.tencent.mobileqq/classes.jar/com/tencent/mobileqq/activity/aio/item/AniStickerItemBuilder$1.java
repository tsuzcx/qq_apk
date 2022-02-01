package com.tencent.mobileqq.activity.aio.item;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForAniSticker;
import mqq.app.MobileQQ;

class AniStickerItemBuilder$1
  implements DialogInterface.OnClickListener
{
  AniStickerItemBuilder$1(AniStickerItemBuilder paramAniStickerItemBuilder, MessageForAniSticker paramMessageForAniSticker) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ChatActivityFacade.b((QQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null), this.b.e, this.b.f, this.a.uniseq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.AniStickerItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */