package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import java.util.List;

public class MultiForwardContext
  extends AIOContext
{
  public ChatAdapter1 P()
  {
    return ((MultiForwardChatPie)this.c).bC();
  }
  
  public ScrollerRunnable Q()
  {
    return ((MultiForwardChatPie)this.c).bj;
  }
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence) {}
  
  public void a(List<ChatMessage> paramList, CharSequence paramCharSequence, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardContext
 * JD-Core Version:    0.7.0.1
 */