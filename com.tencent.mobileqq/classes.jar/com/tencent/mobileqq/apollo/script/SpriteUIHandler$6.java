package com.tencent.mobileqq.apollo.script;

import alqu;

class SpriteUIHandler$6
  implements Runnable
{
  SpriteUIHandler$6(SpriteUIHandler paramSpriteUIHandler, alqu paramalqu, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Alqu != null)
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_Alqu.setVisibility(8);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_Alqu.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteUIHandler.6
 * JD-Core Version:    0.7.0.1
 */