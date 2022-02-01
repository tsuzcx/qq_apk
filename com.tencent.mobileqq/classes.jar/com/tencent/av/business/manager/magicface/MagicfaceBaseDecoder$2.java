package com.tencent.av.business.manager.magicface;

import java.lang.ref.WeakReference;

class MagicfaceBaseDecoder$2
  implements Runnable
{
  MagicfaceBaseDecoder$2(MagicfaceBaseDecoder paramMagicfaceBaseDecoder, String paramString) {}
  
  public void run()
  {
    MagicfaceBaseDecoder.MagicPlayListener localMagicPlayListener = (MagicfaceBaseDecoder.MagicPlayListener)this.this$0.b.get();
    if (localMagicPlayListener != null) {
      localMagicPlayListener.b(-1037L, this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.2
 * JD-Core Version:    0.7.0.1
 */