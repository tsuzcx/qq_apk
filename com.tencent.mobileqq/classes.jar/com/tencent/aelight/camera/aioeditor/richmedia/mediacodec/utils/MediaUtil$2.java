package com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.utils;

import com.tencent.aelight.camera.aioeditor.takevideo.localmedia.baoutils.common.Callbacks.Callback;
import com.tencent.aelight.camera.aioeditor.takevideo.localmedia.demos.MediaCodecThumbnailGenerator.ThumbnailProgress;
import com.tencent.qphone.base.util.QLog;

final class MediaUtil$2
  implements Callbacks.Callback<Boolean, MediaCodecThumbnailGenerator.ThumbnailProgress>
{
  MediaUtil$2(MediaUtil.FrameWithoutBlackResult paramFrameWithoutBlackResult) {}
  
  public Void a(Boolean paramBoolean, MediaCodecThumbnailGenerator.ThumbnailProgress paramThumbnailProgress)
  {
    if (paramThumbnailProgress.b != null)
    {
      this.a.a = paramThumbnailProgress.b;
      this.a.b = paramThumbnailProgress.d;
      paramBoolean = MediaUtil.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MediaCodecThumbnailGenerator progress ");
      localStringBuilder.append(paramThumbnailProgress.d);
      QLog.e(paramBoolean, 2, localStringBuilder.toString());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.utils.MediaUtil.2
 * JD-Core Version:    0.7.0.1
 */