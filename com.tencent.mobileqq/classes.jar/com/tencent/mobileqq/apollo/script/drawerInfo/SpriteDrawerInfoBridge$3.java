package com.tencent.mobileqq.apollo.script.drawerInfo;

import airu;
import aisd;
import aist;

public class SpriteDrawerInfoBridge$3
  implements Runnable
{
  public SpriteDrawerInfoBridge$3(aist paramaist, airu paramairu, aisd paramaisd) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Airu != null) && (this.jdField_a_of_type_Aisd != null))
    {
      this.jdField_a_of_type_Airu.a(this.jdField_a_of_type_Aisd.b, false);
      this.jdField_a_of_type_Airu.a(this.jdField_a_of_type_Aisd.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.3
 * JD-Core Version:    0.7.0.1
 */