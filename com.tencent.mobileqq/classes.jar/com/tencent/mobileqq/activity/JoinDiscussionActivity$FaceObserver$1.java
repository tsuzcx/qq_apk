package com.tencent.mobileqq.activity;

import adfc;
import alri;
import android.graphics.Bitmap;

public class JoinDiscussionActivity$FaceObserver$1
  implements Runnable
{
  public JoinDiscussionActivity$FaceObserver$1(adfc paramadfc) {}
  
  public void run()
  {
    Bitmap localBitmap = this.a.a.a.a(this.a.a.f);
    this.a.a.runOnUiThread(new JoinDiscussionActivity.FaceObserver.1.1(this, localBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.JoinDiscussionActivity.FaceObserver.1
 * JD-Core Version:    0.7.0.1
 */