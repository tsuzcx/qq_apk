package com.tencent.avgame.gameroom.video;

import com.tencent.mobileqq.utils.AudioHelper;
import ncq;
import nfk;
import nfy;

public class AVGameControlUIImpl$3$2
  implements Runnable
{
  public AVGameControlUIImpl$3$2(nfk paramnfk) {}
  
  public void run()
  {
    if (this.a.a.a()) {
      return;
    }
    long l = AudioHelper.b();
    this.a.a.jdField_a_of_type_Nfy.b("onAfterCloseCamera", l);
    AVGameControlUIImpl.b(this.a.a);
    this.a.a.jdField_a_of_type_Ncq.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.3.2
 * JD-Core Version:    0.7.0.1
 */