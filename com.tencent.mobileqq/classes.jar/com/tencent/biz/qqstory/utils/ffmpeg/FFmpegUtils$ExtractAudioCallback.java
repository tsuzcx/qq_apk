package com.tencent.biz.qqstory.utils.ffmpeg;

import java.lang.ref.WeakReference;

public class FFmpegUtils$ExtractAudioCallback
  implements FFmpegExecuteResponseCallback
{
  private WeakReference<FFmpegUtils.ExtractAudioListener> mListener;
  
  public FFmpegUtils$ExtractAudioCallback(FFmpegUtils.ExtractAudioListener paramExtractAudioListener)
  {
    this.mListener = new WeakReference(paramExtractAudioListener);
  }
  
  public void onFailure(String paramString)
  {
    if ((this.mListener != null) && (this.mListener.get() != null)) {
      ((FFmpegUtils.ExtractAudioListener)this.mListener.get()).onFailed(paramString);
    }
  }
  
  public void onFinish(boolean paramBoolean) {}
  
  public void onProgress(String paramString) {}
  
  public void onStart() {}
  
  public void onSuccess(String paramString)
  {
    if ((this.mListener != null) && (this.mListener.get() != null)) {
      ((FFmpegUtils.ExtractAudioListener)this.mListener.get()).onSuccess(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.ffmpeg.FFmpegUtils.ExtractAudioCallback
 * JD-Core Version:    0.7.0.1
 */