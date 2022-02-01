package com.tencent.mobileqq.activity.selectable;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.bubble.ChatXListView;

public class ChatSelCurPageForLSSHelper
{
  private BaseChatPie a;
  private boolean b = false;
  private Runnable c = new ChatSelCurPageForLSSHelper.1(this);
  
  public ChatSelCurPageForLSSHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  public void a()
  {
    this.b = true;
  }
  
  public void b()
  {
    if (!this.b) {
      return;
    }
    this.b = false;
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie != null) && (localBaseChatPie.U != null))
    {
      if (this.a.V == null) {
        return;
      }
      this.a.U.removeCallbacks(this.c);
      this.a.U.post(this.c);
    }
  }
  
  public void c()
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie != null) && (localBaseChatPie.U != null)) {
      this.a.U.removeCallbacks(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectable.ChatSelCurPageForLSSHelper
 * JD-Core Version:    0.7.0.1
 */