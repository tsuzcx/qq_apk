package com.tencent.hippy.qq.tuwen.adapter;

import android.os.MessageQueue.IdleHandler;
import android.widget.ListAdapter;
import com.tencent.widget.ListView;

class TKDTuWenHippyCommentAdapter$1
  implements MessageQueue.IdleHandler
{
  TKDTuWenHippyCommentAdapter$1(TKDTuWenHippyCommentAdapter paramTKDTuWenHippyCommentAdapter) {}
  
  public boolean queueIdle()
  {
    this.this$0.vList.smoothScrollToPosition(this.this$0.vList.getAdapter().getCount() - 1);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.tuwen.adapter.TKDTuWenHippyCommentAdapter.1
 * JD-Core Version:    0.7.0.1
 */