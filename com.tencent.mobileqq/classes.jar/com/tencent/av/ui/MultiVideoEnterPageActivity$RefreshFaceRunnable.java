package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;

class MultiVideoEnterPageActivity$RefreshFaceRunnable
  implements Runnable
{
  MultiVideoEnterPageActivity$RefreshFaceRunnable(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void run()
  {
    if (this.this$0.c != null)
    {
      MultiVideoEnterPageMembersControlUI[] arrayOfMultiVideoEnterPageMembersControlUI = this.this$0.c;
      int j = arrayOfMultiVideoEnterPageMembersControlUI.length;
      int i = 0;
      while (i < j)
      {
        arrayOfMultiVideoEnterPageMembersControlUI[i].c();
        i += 1;
      }
    }
    if (this.this$0.f != null) {
      this.this$0.f.a();
    }
    this.this$0.t.a().postDelayed(this, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.RefreshFaceRunnable
 * JD-Core Version:    0.7.0.1
 */