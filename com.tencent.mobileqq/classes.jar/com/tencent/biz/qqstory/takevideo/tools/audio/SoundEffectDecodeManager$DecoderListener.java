package com.tencent.biz.qqstory.takevideo.tools.audio;

import com.tencent.av.ui.funchat.record.PCMConverter;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class SoundEffectDecodeManager$DecoderListener
  implements AudioDecoder.AudioDecoderListener
{
  SoundEffectDecodeManager$DecoderListener(SoundEffectDecodeManager paramSoundEffectDecodeManager) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    SoundEffectDecodeManager.SoundEffect localSoundEffect = new SoundEffectDecodeManager.SoundEffect(this.a);
    localSoundEffect.jdField_a_of_type_ArrayOfByte = new byte[0];
    localSoundEffect.c = paramInt3;
    localSoundEffect.b = paramInt2;
    localSoundEffect.jdField_a_of_type_Int = paramInt1;
    SoundEffectDecodeManager.a(this.a).put(paramString, localSoundEffect);
  }
  
  public void a(String paramString)
  {
    synchronized (this.a)
    {
      if (QLog.isColorLevel()) {
        QLog.d("SoundEffectDecodeManager", 2, "SoundEffect decode finish, path : " + paramString);
      }
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    synchronized (this.a)
    {
      if (!SoundEffectDecodeManager.a(this.a).containsKey(paramString)) {
        return;
      }
      paramString = (SoundEffectDecodeManager.SoundEffect)SoundEffectDecodeManager.a(this.a).get(paramString);
      byte[] arrayOfByte1 = paramString.jdField_a_of_type_ArrayOfByte;
      paramArrayOfByte = PCMConverter.a(paramArrayOfByte, paramString.jdField_a_of_type_Int, paramString.b * 8, paramString.c, this.a.jdField_a_of_type_Int, this.a.b * 8, this.a.c);
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length + paramArrayOfByte.length];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte1.length);
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte2, arrayOfByte1.length, paramArrayOfByte.length);
      paramString.jdField_a_of_type_ArrayOfByte = arrayOfByte2;
      System.gc();
      return;
    }
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tools.audio.SoundEffectDecodeManager.DecoderListener
 * JD-Core Version:    0.7.0.1
 */