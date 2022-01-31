package com.tencent.av.ui;

import com.tencent.mobileqq.utils.AudioHelper;
import mdz;

public class AVActivity$MyVideoObserver$1
  implements Runnable
{
  public AVActivity$MyVideoObserver$1(mdz parammdz) {}
  
  public void run()
  {
    if (this.a.a.a != null)
    {
      long l = AudioHelper.b();
      this.a.a.a.f(l, 4096);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyVideoObserver.1
 * JD-Core Version:    0.7.0.1
 */