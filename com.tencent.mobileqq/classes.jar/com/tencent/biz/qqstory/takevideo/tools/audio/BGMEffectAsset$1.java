package com.tencent.biz.qqstory.takevideo.tools.audio;

import com.tencent.av.ui.funchat.record.PCMConverter;
import com.tencent.qphone.base.util.QLog;

class BGMEffectAsset$1
  implements AudioDecoder.AudioDecoderListener
{
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this.a.a = paramInt1;
    this.a.b = paramInt2;
    this.a.c = paramInt3;
  }
  
  public void a(String paramString)
  {
    synchronized (this.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BGMEffectAsset", 2, "BGM Decode finish,  path : " + paramString);
      }
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String arg4)
  {
    synchronized (this.a)
    {
      for (;;)
      {
        if (BGMEffectAsset.a(this.a).length >= BGMEffectAsset.a(this.a))
        {
          boolean bool = BGMEffectAsset.a(this.a);
          if (bool) {
            try
            {
              if (QLog.isColorLevel()) {
                QLog.d("BGMEffectAsset", 2, "over cache. wait()");
              }
              this.a.wait();
            }
            catch (InterruptedException localInterruptedException)
            {
              localInterruptedException.printStackTrace();
            }
          }
        }
      }
    }
    paramArrayOfByte = PCMConverter.a(paramArrayOfByte, this.a.a, this.a.b * 8, this.a.c, this.a.d, this.a.e * 8, this.a.f);
    byte[] arrayOfByte = new byte[BGMEffectAsset.a(this.a).length + paramArrayOfByte.length];
    System.arraycopy(BGMEffectAsset.a(this.a), 0, arrayOfByte, 0, BGMEffectAsset.a(this.a).length);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, BGMEffectAsset.a(this.a).length, paramArrayOfByte.length);
    BGMEffectAsset.a(this.a, arrayOfByte);
    System.gc();
  }
  
  public boolean a()
  {
    return BGMEffectAsset.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tools.audio.BGMEffectAsset.1
 * JD-Core Version:    0.7.0.1
 */