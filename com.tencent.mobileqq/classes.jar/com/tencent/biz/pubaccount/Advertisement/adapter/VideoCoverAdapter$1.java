package com.tencent.biz.pubaccount.Advertisement.adapter;

import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.biz.pubaccount.Advertisement.view.VideoCoverView;
import java.util.ArrayList;

class VideoCoverAdapter$1
  implements Runnable
{
  VideoCoverAdapter$1(VideoCoverAdapter paramVideoCoverAdapter) {}
  
  public void run()
  {
    if (VideoCoverAdapter.a(this.this$0) != null)
    {
      if (VideoCoverAdapter.a(this.this$0).size() == 0) {
        return;
      }
      VideoCoverItem localVideoCoverItem = (VideoCoverItem)VideoCoverAdapter.a(this.this$0).get(0);
      if (localVideoCoverItem != null)
      {
        if (localVideoCoverItem.d == null) {
          return;
        }
        ((VideoCoverView)localVideoCoverItem.d).a(VideoCoverAdapter.b(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.adapter.VideoCoverAdapter.1
 * JD-Core Version:    0.7.0.1
 */