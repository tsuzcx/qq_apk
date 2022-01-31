package com.tencent.imcore.message;

import abss;
import abti;
import java.util.Map;

class C2CMessageManager$2$2
  implements Runnable
{
  C2CMessageManager$2$2(C2CMessageManager.2 param2) {}
  
  public void run()
  {
    if (this.a.this$0.a.b.containsKey(abti.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int))) {
      this.a.this$0.a.b.remove(abti.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Int));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.imcore.message.C2CMessageManager.2.2
 * JD-Core Version:    0.7.0.1
 */