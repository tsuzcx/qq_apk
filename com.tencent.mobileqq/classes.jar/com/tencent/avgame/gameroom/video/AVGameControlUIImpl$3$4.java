package com.tencent.avgame.gameroom.video;

import com.tencent.mobileqq.utils.AudioHelper;
import nfk;

public class AVGameControlUIImpl$3$4
  implements Runnable
{
  public AVGameControlUIImpl$3$4(nfk paramnfk) {}
  
  public void run()
  {
    long l = AudioHelper.b();
    this.a.a.a(l, "android.permission.CAMERA");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.3.4
 * JD-Core Version:    0.7.0.1
 */