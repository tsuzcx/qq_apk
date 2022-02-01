package com.tencent.av.ui;

import com.tencent.av.VideoController;
import lvs;
import mak;

class AVActivity$11
  implements Runnable
{
  AVActivity$11(AVActivity paramAVActivity) {}
  
  public void run()
  {
    mak.a(VideoController.a().a, 8, 0L, true);
    if (!lvs.a)
    {
      mak.a(VideoController.a().a, 10, 3000L);
      lvs.a = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.11
 * JD-Core Version:    0.7.0.1
 */