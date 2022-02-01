package com.tencent.av.business.manager.magicface;

import lgx;
import lha;

public class MagicfaceBaseDecoder$1
  implements Runnable
{
  public MagicfaceBaseDecoder$1(lgx paramlgx) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    Thread.currentThread().setPriority(10);
    String str = this.this$0.jdField_a_of_type_Lha.b();
    this.this$0.jdField_a_of_type_Boolean = true;
    this.this$0.b(str);
    int j = this.this$0.a();
    this.this$0.jdField_a_of_type_Boolean = false;
    this.this$0.jdField_a_of_type_Lha.b();
    this.this$0.a(str, j);
    Thread.currentThread().setPriority(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.1
 * JD-Core Version:    0.7.0.1
 */