package com.tencent.av.business.manager.magicface;

import java.lang.ref.WeakReference;

class MagicfaceBaseDecoder$3
  implements Runnable
{
  MagicfaceBaseDecoder$3(MagicfaceBaseDecoder paramMagicfaceBaseDecoder, String paramString, int paramInt) {}
  
  public void run()
  {
    MagicfaceBaseDecoder.MagicPlayListener localMagicPlayListener = (MagicfaceBaseDecoder.MagicPlayListener)this.this$0.a.get();
    if (localMagicPlayListener != null) {
      localMagicPlayListener.a(-1038L, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.3
 * JD-Core Version:    0.7.0.1
 */