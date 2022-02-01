package com.tencent.avgame.gameroom.video;

import com.tencent.mobileqq.utils.AudioHelper;
import ncq;
import nfk;
import nfy;

public class AVGameControlUIImpl$3$1
  implements Runnable
{
  public AVGameControlUIImpl$3$1(nfk paramnfk) {}
  
  public void run()
  {
    if (this.a.a.a()) {
      return;
    }
    long l = AudioHelper.b();
    this.a.a.jdField_a_of_type_Nfy.a("onAfterOpenCamera", l);
    AVGameControlUIImpl.b(this.a.a);
    this.a.a.jdField_a_of_type_Ncq.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.3.1
 * JD-Core Version:    0.7.0.1
 */