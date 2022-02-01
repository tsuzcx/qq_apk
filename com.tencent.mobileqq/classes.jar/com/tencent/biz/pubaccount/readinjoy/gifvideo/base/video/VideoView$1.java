package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

class VideoView$1
  implements Runnable
{
  VideoView$1(VideoView paramVideoView, int paramInt) {}
  
  public void run()
  {
    switch (this.a)
    {
    case 1: 
    case 2: 
    case 6: 
    case 10: 
    default: 
      return;
    case 0: 
      VideoView.access$000(this.this$0);
      return;
    case 3: 
    case 5: 
      this.this$0.showLoading();
      return;
    case 4: 
      this.this$0.onInit();
      return;
    case 7: 
      this.this$0.onPlay();
      return;
    case 9: 
      this.this$0.onStop();
      return;
    case -1: 
      this.this$0.onError();
      return;
    case 11: 
      this.this$0.onDestroy();
      return;
    }
    this.this$0.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoView.1
 * JD-Core Version:    0.7.0.1
 */