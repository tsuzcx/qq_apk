package com.tencent.mobileqq.activity.aio.item;

import com.etrump.mixlayout.ETTextView.TextAnimationListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;

class TextItemBuilder$9
  extends ETTextView.TextAnimationListener
{
  TextItemBuilder$9(TextItemBuilder paramTextItemBuilder) {}
  
  public void a(ChatMessage paramChatMessage, int paramInt) {}
  
  public void a(ChatMessage paramChatMessage, boolean paramBoolean, int paramInt)
  {
    Object localObject = "1";
    if ((!paramBoolean) && (paramChatMessage != null))
    {
      paramChatMessage.saveExtInfoToExtStr("font_animation_played", "1");
      ThreadManager.excute(new TextItemBuilder.9.1(this, paramChatMessage), 128, null, true);
    }
    String str = this.a.d.getCurrentUin();
    if (paramBoolean) {
      paramChatMessage = (ChatMessage)localObject;
    } else {
      paramChatMessage = "0";
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramInt);
    VasWebviewUtil.a(str, "Font_Mall", "0X800813C", "0", 0, 1, 1, null, paramChatMessage, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */