package com.tencent.mobileqq.activity;

import adnf;
import amqx;
import android.graphics.Bitmap;

public class JoinDiscussionActivity$MyDiscussionObserver$1
  implements Runnable
{
  public JoinDiscussionActivity$MyDiscussionObserver$1(adnf paramadnf) {}
  
  public void run()
  {
    Bitmap localBitmap = this.a.a.a.a(this.a.a.f);
    this.a.a.runOnUiThread(new JoinDiscussionActivity.MyDiscussionObserver.1.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity.MyDiscussionObserver.1
 * JD-Core Version:    0.7.0.1
 */