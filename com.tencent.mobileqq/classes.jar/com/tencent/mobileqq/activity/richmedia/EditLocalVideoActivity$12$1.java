package com.tencent.mobileqq.activity.richmedia;

import com.tencent.mobileqq.activity.richmedia.trimvideo.video.widget.FixedSizeVideoView;

class EditLocalVideoActivity$12$1
  implements Runnable
{
  EditLocalVideoActivity$12$1(EditLocalVideoActivity.12 param12) {}
  
  public void run()
  {
    if (EditLocalVideoActivity.q(this.a.b) != null)
    {
      EditLocalVideoActivity.q(this.a.b).seekTo(0);
      EditLocalVideoActivity.q(this.a.b).start();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.EditLocalVideoActivity.12.1
 * JD-Core Version:    0.7.0.1
 */