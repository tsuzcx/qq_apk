package com.tencent.avgame.gameroom.video;

import com.tencent.mobileqq.utils.AudioHelper;
import nbp;
import ned;
import ner;

public class AVGameControlUIImpl$3$2
  implements Runnable
{
  public AVGameControlUIImpl$3$2(ned paramned) {}
  
  public void run()
  {
    if (this.a.a.a()) {
      return;
    }
    long l = AudioHelper.b();
    this.a.a.jdField_a_of_type_Ner.b("onAfterCloseCamera", l);
    AVGameControlUIImpl.b(this.a.a);
    this.a.a.jdField_a_of_type_Nbp.b(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.3.2
 * JD-Core Version:    0.7.0.1
 */