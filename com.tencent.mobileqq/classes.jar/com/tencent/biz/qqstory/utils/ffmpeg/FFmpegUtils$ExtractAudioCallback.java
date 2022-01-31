package com.tencent.biz.qqstory.utils.ffmpeg;

import java.lang.ref.WeakReference;

public class FFmpegUtils$ExtractAudioCallback
  implements FFmpegExecuteResponseCallback
{
  private WeakReference a;
  
  public FFmpegUtils$ExtractAudioCallback(FFmpegUtils.ExtractAudioListener paramExtractAudioListener)
  {
    this.a = new WeakReference(paramExtractAudioListener);
  }
  
  public void a() {}
  
  public void a(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((FFmpegUtils.ExtractAudioListener)this.a.get()).a(paramString);
    }
  }
  
  public void a(boolean paramBoolean) {}
  
  public void b(String paramString)
  {
    if ((this.a != null) && (this.a.get() != null)) {
      ((FFmpegUtils.ExtractAudioListener)this.a.get()).b(paramString);
    }
  }
  
  public void c(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.ExtractAudioCallback
 * JD-Core Version:    0.7.0.1
 */