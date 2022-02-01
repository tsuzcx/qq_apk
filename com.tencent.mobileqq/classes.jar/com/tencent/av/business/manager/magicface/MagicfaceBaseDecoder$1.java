package com.tencent.av.business.manager.magicface;

class MagicfaceBaseDecoder$1
  implements Runnable
{
  MagicfaceBaseDecoder$1(MagicfaceBaseDecoder paramMagicfaceBaseDecoder) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    Thread.currentThread().setPriority(10);
    String str = this.this$0.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.b();
    MagicfaceBaseDecoder localMagicfaceBaseDecoder = this.this$0;
    localMagicfaceBaseDecoder.jdField_a_of_type_Boolean = true;
    localMagicfaceBaseDecoder.b(str);
    int j = this.this$0.a();
    localMagicfaceBaseDecoder = this.this$0;
    localMagicfaceBaseDecoder.jdField_a_of_type_Boolean = false;
    localMagicfaceBaseDecoder.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceData.b();
    this.this$0.a(str, j);
    Thread.currentThread().setPriority(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.1
 * JD-Core Version:    0.7.0.1
 */