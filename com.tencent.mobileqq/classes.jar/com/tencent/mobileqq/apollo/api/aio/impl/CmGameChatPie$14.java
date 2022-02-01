package com.tencent.mobileqq.apollo.api.aio.impl;

import com.tencent.mobileqq.apollo.view.FrameGifView;

class CmGameChatPie$14
  implements Runnable
{
  CmGameChatPie$14(CmGameChatPie paramCmGameChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a)
    {
      if (CmGameChatPie.a(this.this$0).b() == 3)
      {
        CmGameChatPie.a(this.this$0).b();
        return;
      }
      CmGameChatPie.a(this.this$0).setImageResource(2130839345);
      return;
    }
    CmGameChatPie.a(this.this$0).c();
    CmGameChatPie.a(this.this$0).setImageResource(2130839343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.impl.CmGameChatPie.14
 * JD-Core Version:    0.7.0.1
 */