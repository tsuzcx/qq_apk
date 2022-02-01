package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.data.ChatMessage;

class PttItemBuilder$Holder$1
  implements PttAudioWaveView.OnPressListener
{
  PttItemBuilder$Holder$1(PttItemBuilder.Holder paramHolder) {}
  
  public void a(boolean paramBoolean)
  {
    if (this.a.a != null)
    {
      View localView = (View)this.a.a.getParent();
      if ((this.a.a != null) && (localView.isPressed() != paramBoolean) && ((PttItemBuilder.Holder)localView.getTag() != null))
      {
        ChatMessage localChatMessage = AIOUtils.a(localView);
        if ((localChatMessage != null) && (localChatMessage.vipBubbleID == 0L)) {
          localView.setPressed(paramBoolean);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttItemBuilder.Holder.1
 * JD-Core Version:    0.7.0.1
 */