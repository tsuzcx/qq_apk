package com.tencent.av.business.manager.magicface;

class MagicfaceBaseDecoder$1
  implements Runnable
{
  MagicfaceBaseDecoder$1(MagicfaceBaseDecoder paramMagicfaceBaseDecoder) {}
  
  public void run()
  {
    int i = Thread.currentThread().getPriority();
    Thread.currentThread().setPriority(10);
    String str = this.this$0.a.i();
    MagicfaceBaseDecoder localMagicfaceBaseDecoder = this.this$0;
    localMagicfaceBaseDecoder.d = true;
    localMagicfaceBaseDecoder.b(str);
    int j = this.this$0.e();
    localMagicfaceBaseDecoder = this.this$0;
    localMagicfaceBaseDecoder.d = false;
    localMagicfaceBaseDecoder.a.b();
    this.this$0.a(str, j);
    Thread.currentThread().setPriority(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.1
 * JD-Core Version:    0.7.0.1
 */