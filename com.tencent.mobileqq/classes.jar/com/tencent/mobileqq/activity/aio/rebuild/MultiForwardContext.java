package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import java.util.List;

public class MultiForwardContext
  extends AIOContext
{
  public ChatAdapter1 a()
  {
    return ((MultiForwardChatPie)this.a).a();
  }
  
  public ScrollerRunnable a()
  {
    return ((MultiForwardChatPie)this.a).a;
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence) {}
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardContext
 * JD-Core Version:    0.7.0.1
 */