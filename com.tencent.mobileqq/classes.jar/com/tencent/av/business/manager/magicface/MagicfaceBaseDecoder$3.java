package com.tencent.av.business.manager.magicface;

import java.lang.ref.WeakReference;

class MagicfaceBaseDecoder$3
  implements Runnable
{
  MagicfaceBaseDecoder$3(MagicfaceBaseDecoder paramMagicfaceBaseDecoder, String paramString, int paramInt) {}
  
  public void run()
  {
    MagicfaceBaseDecoder.MagicPlayListener localMagicPlayListener = (MagicfaceBaseDecoder.MagicPlayListener)this.this$0.b.get();
    if (localMagicPlayListener != null) {
      localMagicPlayListener.a(-1038L, this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicfaceBaseDecoder.3
 * JD-Core Version:    0.7.0.1
 */