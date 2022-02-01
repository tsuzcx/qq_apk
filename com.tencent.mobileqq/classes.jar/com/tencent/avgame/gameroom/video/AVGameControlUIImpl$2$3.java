package com.tencent.avgame.gameroom.video;

import ncp;

public class AVGameControlUIImpl$2$3
  implements Runnable
{
  public AVGameControlUIImpl$2$3(ncp paramncp, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ncp.a.a()) {
      return;
    }
    int i;
    if (this.jdField_a_of_type_Int == 0) {
      i = 3214;
    }
    for (;;)
    {
      AVGameControlUIImpl.a(this.jdField_a_of_type_Ncp.a, i);
      return;
      if (this.jdField_a_of_type_Int == 100) {
        i = 9642;
      } else {
        i = (int)(3214.2856F + 6428.5718F * this.jdField_a_of_type_Int / 100.0F);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.3
 * JD-Core Version:    0.7.0.1
 */