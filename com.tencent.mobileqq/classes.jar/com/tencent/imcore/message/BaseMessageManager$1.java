package com.tencent.imcore.message;

import acvh;
import acwr;
import android.os.Handler;

public class BaseMessageManager$1
  implements Runnable
{
  public BaseMessageManager$1(acvh paramacvh, String paramString1, int paramInt1, int paramInt2, acwr paramacwr, String paramString2) {}
  
  public void run()
  {
    this.this$0.a.a("refreshMessageListHead uin = " + this.jdField_a_of_type_JavaLangString + ", type = " + this.jdField_a_of_type_Int + ", count = " + this.jdField_b_of_type_Int + ", context = " + this.jdField_a_of_type_Acwr, ", timestamp = " + System.currentTimeMillis());
    this.this$0.b(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_a_of_type_Acwr);
    this.this$0.a(this.jdField_a_of_type_Acwr);
    this.this$0.a.a.post(new BaseMessageManager.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.BaseMessageManager.1
 * JD-Core Version:    0.7.0.1
 */