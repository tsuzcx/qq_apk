package com.tencent.mobileqq.activity.aio.core;

import com.tencent.mobileqq.emoticonview.EmotionKeywordAdapter;
import com.tencent.mobileqq.emoticonview.EmotionKeywordHorizonListView;
import java.util.List;

class BaseChatPie$62$1
  implements Runnable
{
  BaseChatPie$62$1(BaseChatPie.62 param62, List paramList) {}
  
  public void run()
  {
    BaseChatPie.access$1600(this.this$1.this$0).resetExposeList();
    BaseChatPie.access$1600(this.this$1.this$0).resetLoadFinishData();
    BaseChatPie.access$1600(this.this$1.this$0).setKeyword(this.this$1.val$text);
    BaseChatPie.access$1600(this.this$1.this$0).setData(this.val$dataList);
    BaseChatPie.access$1700(this.this$1.this$0).resetCurrentX(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.62.1
 * JD-Core Version:    0.7.0.1
 */