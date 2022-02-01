package com.tencent.aelight.camera.struct.camera;

import java.io.Serializable;

public class BaseVideoCaptureResult
  implements Serializable
{
  public static final int TYPE_MERGED = 1;
  public static final int TYPE_UNMERGED = 0;
  public String audioDataFilePath;
  public String bgmAudioDataFilePath;
  public int errorCode;
  public String mergedMp4FilePath;
  public int orientation;
  public int type;
  public int videoFrameCount = 0;
  public String videoMp4FilePath;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VideoCaptureResult{type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", errorCode=");
    localStringBuilder.append(this.errorCode);
    localStringBuilder.append(", mergedMp4FilePath='");
    localStringBuilder.append(this.mergedMp4FilePath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoMp4FilePath='");
    localStringBuilder.append(this.videoMp4FilePath);
    localStringBuilder.append('\'');
    localStringBuilder.append(", audioDataFilePath='");
    localStringBuilder.append(this.audioDataFilePath);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.struct.camera.BaseVideoCaptureResult
 * JD-Core Version:    0.7.0.1
 */