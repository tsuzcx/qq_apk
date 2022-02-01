package com.tencent.biz.qqstory.takevideo.tools.audio;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.HashMap;
import java.util.Map;

public class SoundEffectDecodeManager
{
  protected int a;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = ThreadManagerV2.newFreeHandlerThread("SoundEffectDecodeManager", 0);
  private AudioDecoder jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioDecoder;
  private SoundEffectDecodeManager.DecoderListener jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioSoundEffectDecodeManager$DecoderListener;
  private Map<String, SoundEffectDecodeManager.SoundEffect> jdField_a_of_type_JavaUtilMap = new HashMap();
  protected int b = 1;
  protected int c = 1;
  
  public SoundEffectDecodeManager()
  {
    this.jdField_a_of_type_Int = 48000;
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new SoundEffectDecodeManager.AudioDecodeHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioDecoder = new AudioDecoder();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioSoundEffectDecodeManager$DecoderListener = new SoundEffectDecodeManager.DecoderListener(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioDecoder.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioSoundEffectDecodeManager$DecoderListener);
  }
  
  public byte[] a(String paramString, long paramLong1, long paramLong2)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.jdField_a_of_type_JavaUtilMap.containsKey(paramString);
        if (!bool)
        {
          paramString = null;
          return paramString;
        }
        byte[] arrayOfByte = ((SoundEffectDecodeManager.SoundEffect)this.jdField_a_of_type_JavaUtilMap.get(paramString)).a;
        if (arrayOfByte.length < paramLong1)
        {
          paramString = null;
          continue;
          int j = (int)(paramLong2 - paramLong1);
          int k = (int)(arrayOfByte.length - paramLong1);
          int i = k;
          if (j < k) {
            i = j;
          }
          paramString = new byte[i];
          System.arraycopy(arrayOfByte, (int)paramLong1, paramString, 0, i);
          continue;
        }
        if (paramLong1 < paramLong2) {
          continue;
        }
      }
      finally {}
      paramString = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tools.audio.SoundEffectDecodeManager
 * JD-Core Version:    0.7.0.1
 */