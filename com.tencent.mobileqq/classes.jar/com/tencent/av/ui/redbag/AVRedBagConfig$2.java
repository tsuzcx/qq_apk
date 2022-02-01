package com.tencent.av.ui.redbag;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.app.VideoObserver;
import com.tencent.mobileqq.app.ThreadManager;

class AVRedBagConfig$2
  extends VideoObserver
{
  AVRedBagConfig$2(AVRedBagConfig paramAVRedBagConfig) {}
  
  public void a()
  {
    ThreadManager.post(new AVRedBagConfig.2.1(this), 10, null, true);
    this.a.a.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBagConfig.2
 * JD-Core Version:    0.7.0.1
 */