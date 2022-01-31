package com.tencent.mobileqq.app;

import akik;
import mqq.os.MqqHandler;

class TroopManager$12
  implements Runnable
{
  TroopManager$12(TroopManager paramTroopManager, String paramString, akik paramakik) {}
  
  public void run()
  {
    String str = this.this$0.d(this.jdField_a_of_type_JavaLangString);
    ThreadManager.getUIHandler().post(new TroopManager.12.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.12
 * JD-Core Version:    0.7.0.1
 */