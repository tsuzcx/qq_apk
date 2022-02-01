package com.tencent.mobileqq.activity.aio.core;

import android.os.Bundle;
import bisg;
import com.tencent.mobileqq.bubble.ChatXListView;

class BaseChatPie$6
  implements bisg
{
  BaseChatPie$6(BaseChatPie paramBaseChatPie) {}
  
  public void afterDraw(Bundle paramBundle)
  {
    this.this$0.listView.b(true);
  }
  
  public void beforeDraw(Bundle paramBundle)
  {
    this.this$0.listView.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.6
 * JD-Core Version:    0.7.0.1
 */