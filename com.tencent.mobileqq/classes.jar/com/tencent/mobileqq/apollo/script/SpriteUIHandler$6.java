package com.tencent.mobileqq.apollo.script;

import ampv;

class SpriteUIHandler$6
  implements Runnable
{
  SpriteUIHandler$6(SpriteUIHandler paramSpriteUIHandler, ampv paramampv, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Ampv != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Ampv.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Ampv.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.6
 * JD-Core Version:    0.7.0.1
 */