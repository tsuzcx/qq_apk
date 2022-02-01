package com.tencent.av.business.manager.magicface;

import java.lang.ref.WeakReference;

class MagicfaceBaseDecoder$4
  implements Runnable
{
  MagicfaceBaseDecoder$4(MagicfaceBaseDecoder paramMagicfaceBaseDecoder, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    MagicfaceBaseDecoder.MagicPlayListener localMagicPlayListener = (MagicfaceBaseDecoder.MagicPlayListener)this.this$0.a.get();
    if (localMagicPlayListener != null) {
      localMagicPlayListener.a(-1039L, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Boolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.4
 * JD-Core Version:    0.7.0.1
 */