package com.tencent.mobileqq.app.message;

import akai;
import akbm;
import java.util.Map;

class C2CMessageManager$2$2
  implements Runnable
{
  C2CMessageManager$2$2(C2CMessageManager.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.a.b.containsKey(akbm.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int))) {
      this.a.this$0.a.b.remove(akbm.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.C2CMessageManager.2.2
 * JD-Core Version:    0.7.0.1
 */