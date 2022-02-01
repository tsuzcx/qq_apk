package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.DiscussionHandler;

class JoinDiscussionActivity$MyDiscussionObserver$1
  implements Runnable
{
  JoinDiscussionActivity$MyDiscussionObserver$1(JoinDiscussionActivity.MyDiscussionObserver paramMyDiscussionObserver) {}
  
  public void run()
  {
    Bitmap localBitmap = this.a.a.g.d(this.a.a.o);
    this.a.a.runOnUiThread(new JoinDiscussionActivity.MyDiscussionObserver.1.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity.MyDiscussionObserver.1
 * JD-Core Version:    0.7.0.1
 */