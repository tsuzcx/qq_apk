package com.tencent.mobileqq.apollo.script.drawerInfo;

import anbt;
import ancc;
import ancs;

public class SpriteDrawerInfoBridge$3
  implements Runnable
{
  public SpriteDrawerInfoBridge$3(ancs paramancs, anbt paramanbt, ancc paramancc) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Anbt != null) && (this.jdField_a_of_type_Ancc != null))
    {
      this.jdField_a_of_type_Anbt.a(this.jdField_a_of_type_Ancc.b, false);
      this.jdField_a_of_type_Anbt.a(this.jdField_a_of_type_Ancc.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.3
 * JD-Core Version:    0.7.0.1
 */