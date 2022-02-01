package com.tencent.mobileqq.apollo.api.aio.impl;

import com.tencent.mobileqq.apollo.view.FrameGifView;

class CmGameChatPie$15
  implements Runnable
{
  CmGameChatPie$15(CmGameChatPie paramCmGameChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a)
    {
      if (CmGameChatPie.b(this.this$0).b() == 3)
      {
        CmGameChatPie.b(this.this$0).b();
        return;
      }
      CmGameChatPie.b(this.this$0).setImageResource(2130839346);
      return;
    }
    CmGameChatPie.b(this.this$0).c();
    CmGameChatPie.b(this.this$0).setImageResource(2130839344);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.15
 * JD-Core Version:    0.7.0.1
 */