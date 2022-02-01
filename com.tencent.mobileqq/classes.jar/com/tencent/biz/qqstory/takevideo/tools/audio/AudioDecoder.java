package com.tencent.biz.qqstory.takevideo.tools.audio;

import android.support.annotation.RequiresApi;
import com.tencent.mobileqq.app.ThreadManager;

public class AudioDecoder
{
  private AudioDecoder.AudioDecoderListener jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioDecoder$AudioDecoderListener;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  public void a(AudioDecoder.AudioDecoderListener paramAudioDecoderListener)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoToolsAudioAudioDecoder$AudioDecoderListener = paramAudioDecoderListener;
  }
  
  @RequiresApi(api=16)
  public void a(String paramString, boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.excute(new AudioDecoder.1(this, paramString), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tools.audio.AudioDecoder
 * JD-Core Version:    0.7.0.1
 */