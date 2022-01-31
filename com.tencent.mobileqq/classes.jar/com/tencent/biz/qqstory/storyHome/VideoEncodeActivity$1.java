package com.tencent.biz.qqstory.storyHome;

import android.widget.LinearLayout;
import com.tencent.biz.qqstory.database.PublishVideoEntry;

class VideoEncodeActivity$1
  implements Runnable
{
  VideoEncodeActivity$1(VideoEncodeActivity paramVideoEncodeActivity, PublishVideoEntry paramPublishVideoEntry) {}
  
  public void run()
  {
    try
    {
      VideoEncodeActivity.a(this.this$0, this.a);
      VideoEncodeActivity.a(this.this$0).post(new VideoEncodeActivity.1.1(this));
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.VideoEncodeActivity.1
 * JD-Core Version:    0.7.0.1
 */