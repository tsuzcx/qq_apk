package com.tencent.mobileqq.activity.aio.item.supplier;

import android.widget.BaseAdapter;
import com.tencent.mobileqq.activity.aio.ChatItemBuilder;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.msglist.item.ItemBuilderSupplier;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBubbleBuilder;
import com.tencent.mobileqq.activity.aio.item.ArkAppItemBuilder;
import com.tencent.mobileqq.activity.aio.item.ArkAppPublicAccountItemBuilder;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;

public class ArkAppSupplier
  extends ItemBuilderSupplier
{
  private ArkAppItemBuilder f;
  private ArkAppPublicAccountItemBuilder g;
  private ArkAppItemBubbleBuilder h;
  
  protected ChatItemBuilder a(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    if ((paramChatMessage instanceof MessageForArkApp))
    {
      paramChatMessage = (MessageForArkApp)paramChatMessage;
      ArkAppMessage.Config localConfig = new ArkAppMessage.Config();
      if (paramChatMessage.ark_app_message != null)
      {
        localConfig.fromString(paramChatMessage.ark_app_message.config);
        if ((localConfig.showSender != null) && (localConfig.showSender.intValue() == 0))
        {
          i = 0;
          break label67;
        }
      }
    }
    int i = 1;
    label67:
    if ((this.c.a != 1008) && (this.c.a != 1038))
    {
      if ((i != 0) && (this.c.a != 9501))
      {
        if (this.h == null) {
          this.h = new ArkAppItemBubbleBuilder(this.b, paramBaseAdapter, this.a, this.c, this.e);
        }
        return this.h;
      }
      if (this.f == null) {
        this.f = new ArkAppItemBuilder(this.b, paramBaseAdapter, this.a, this.c, this.e);
      }
      return this.f;
    }
    if (this.g == null) {
      this.g = new ArkAppPublicAccountItemBuilder(this.b, paramBaseAdapter, this.a, this.c, this.e);
    }
    return this.g;
  }
  
  protected ChatItemBuilder b(ChatMessage paramChatMessage, BaseAdapter paramBaseAdapter)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.supplier.ArkAppSupplier
 * JD-Core Version:    0.7.0.1
 */