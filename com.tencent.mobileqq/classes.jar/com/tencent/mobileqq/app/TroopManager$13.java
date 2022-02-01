package com.tencent.mobileqq.app;

import aofl;
import mqq.os.MqqHandler;

class TroopManager$13
  implements Runnable
{
  TroopManager$13(TroopManager paramTroopManager, String paramString, aofl paramaofl) {}
  
  public void run()
  {
    String str = this.this$0.d(this.jdField_a_of_type_JavaLangString);
    ThreadManager.getUIHandler().post(new TroopManager.13.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.13
 * JD-Core Version:    0.7.0.1
 */