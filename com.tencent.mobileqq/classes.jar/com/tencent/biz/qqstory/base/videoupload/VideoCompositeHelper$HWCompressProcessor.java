package com.tencent.biz.qqstory.base.videoupload;

import android.os.Build.VERSION;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConvertConfig;
import java.io.File;
import wjl;
import wjs;
import ykq;

public class VideoCompositeHelper$HWCompressProcessor
  implements VideoConverter.Processor
{
  static final int DEFAULT_BITRATE = 1024000;
  static final int DEFAULT_FRAME_RATES = 25;
  static final int VIDEO_LONG_EDGE = 960;
  int cropHeight;
  int cropWidth;
  int cropX;
  int cropY;
  public Throwable e;
  boolean isCanceled;
  boolean mAccurateSeek;
  int mBusinessId;
  final long mEndTime;
  PublishVideoEntry mInfo;
  boolean mIsMute;
  final String mOutputFilePath;
  final long mStartTime;
  int mVideoBitrate = 1024000;
  int mVideoFrameRates = 25;
  
  public VideoCompositeHelper$HWCompressProcessor(PublishVideoEntry paramPublishVideoEntry, String paramString, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    this.mOutputFilePath = paramString;
    this.mVideoBitrate = paramInt1;
    this.mStartTime = paramLong1;
    this.mEndTime = paramLong2;
    this.mIsMute = paramBoolean1;
    this.mAccurateSeek = paramBoolean2;
    this.mBusinessId = paramInt2;
    this.mInfo = paramPublishVideoEntry;
  }
  
  public VideoConverter.VideoConvertConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    VideoConverter.VideoConvertConfig localVideoConvertConfig = new VideoConverter.VideoConvertConfig();
    if (paramInt1 <= paramInt2)
    {
      Object localObject = new File(this.mOutputFilePath);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localVideoConvertConfig.output = ((File)localObject);
      localVideoConvertConfig.videoBitRate = this.mVideoBitrate;
      localVideoConvertConfig.scaleRate = (960.0F / paramInt2);
      localVideoConvertConfig.videoFrameRate = this.mVideoFrameRates;
      localVideoConvertConfig.setRotation = shouldSetRotation();
      localVideoConvertConfig.beginTime = this.mStartTime;
      localVideoConvertConfig.endTime = this.mEndTime;
      localVideoConvertConfig.isMute = this.mIsMute;
      localVideoConvertConfig.accurateSeek = this.mAccurateSeek;
      localVideoConvertConfig.cropX = this.cropX;
      localVideoConvertConfig.cropY = this.cropY;
      localVideoConvertConfig.cropWidth = this.cropWidth;
      localVideoConvertConfig.cropHeight = this.cropHeight;
      localVideoConvertConfig.bitrateMode = this.mInfo.hwBitrateMode;
      if (this.mInfo.isNeedHighProfile)
      {
        localVideoConvertConfig.setProfileLevel = true;
        localVideoConvertConfig.profile = 8;
        localVideoConvertConfig.level = 512;
      }
      if (wjl.e())
      {
        ykq.d(VideoCompositeHelper.TAG, "story debug mode is enable");
        localObject = (wjl)wjs.a(10);
        paramInt1 = ((Integer)((wjl)localObject).b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
        paramInt2 = ((Integer)((wjl)localObject).b("int_story_debug_bitrate_mode", Integer.valueOf(localVideoConvertConfig.bitrateMode))).intValue();
        boolean bool = ((Boolean)((wjl)localObject).b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
        localVideoConvertConfig.bitrateMode = paramInt2;
        localVideoConvertConfig.videoBitRate = (paramInt1 * 1000);
        if (!bool) {
          break label571;
        }
        localVideoConvertConfig.setProfileLevel = true;
        localVideoConvertConfig.profile = 8;
      }
    }
    for (localVideoConvertConfig.level = 512;; localVideoConvertConfig.level = 512)
    {
      ykq.a(VideoCompositeHelper.TAG, "HWCompressProcessor, step: getEncodeConfig() config.setRotation = " + localVideoConvertConfig.setRotation + ", scaleRate=" + localVideoConvertConfig.scaleRate + ", videoBitRate=" + localVideoConvertConfig.videoBitRate + ", videoFrameRate=" + localVideoConvertConfig.videoFrameRate + ", beginTime=" + localVideoConvertConfig.beginTime + ", endTime=" + localVideoConvertConfig.endTime, ", isMute=" + this.mIsMute, ", accurateSeek=" + this.mAccurateSeek + ", cropX=" + this.cropX + ", cropY=" + this.cropY + ", cropWidth=" + this.cropWidth + ", cropHeight=" + this.cropHeight + ",bitrateMode=" + localVideoConvertConfig.bitrateMode + ",setProfileLevel=" + localVideoConvertConfig.setProfileLevel + ",profile=" + localVideoConvertConfig.profile + ", level=" + localVideoConvertConfig.level);
      return localVideoConvertConfig;
      paramInt2 = paramInt1;
      break;
      label571:
      localVideoConvertConfig.setProfileLevel = false;
      localVideoConvertConfig.profile = 1;
    }
  }
  
  public void onCanceled()
  {
    ykq.c(VideoCompositeHelper.TAG, "HWCompressProcessor, step: HWCompressProcessor onCanceled");
    this.isCanceled = true;
  }
  
  public void onFailed(Throwable paramThrowable)
  {
    ykq.e(VideoCompositeHelper.TAG, "HWCompressProcessor, step: HWCompressProcessor onFailed");
    this.e = paramThrowable;
  }
  
  public void onProgress(int paramInt)
  {
    ykq.b(VideoCompositeHelper.TAG, "HWCompressProcessor, step: HWCompressProcessor onProgress:" + paramInt);
  }
  
  public void onSuccessed()
  {
    ykq.e(VideoCompositeHelper.TAG, "HWCompressProcessor, step: HWCompressProcessor onSuccessed");
  }
  
  public void setCropRegion(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.cropX = paramInt1;
    this.cropY = paramInt2;
    this.cropWidth = paramInt3;
    this.cropHeight = paramInt4;
  }
  
  public boolean shouldSetRotation()
  {
    boolean bool = false;
    if ((Build.VERSION.SDK_INT >= 18) && (Build.VERSION.SDK_INT <= 19)) {
      bool = true;
    }
    while (Build.VERSION.SDK_INT <= 19) {
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */