package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.richmedia.videocompress.VideoConverter.Processor;
import com.tencent.richmedia.videocompress.VideoConverterConfig;

public class VideoCompositeHelper$HWCompressProcessor
  implements VideoConverter.Processor
{
  int jdField_a_of_type_Int = 1024000;
  final long jdField_a_of_type_Long;
  PublishVideoEntry jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  final String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 25;
  final long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  
  public VideoCompositeHelper$HWCompressProcessor(PublishVideoEntry paramPublishVideoEntry, String paramString, int paramInt1, long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry = paramPublishVideoEntry;
  }
  
  public VideoConverterConfig getEncodeConfig(int paramInt1, int paramInt2)
  {
    VideoConverterConfig localVideoConverterConfig = new VideoConverterConfig();
    if (paramInt1 <= paramInt2)
    {
      localVideoConverterConfig.output = this.jdField_a_of_type_JavaLangString;
      localVideoConverterConfig.videoBitRate = this.jdField_a_of_type_Int;
      localVideoConverterConfig.scaleRate = (960.0F / paramInt2);
      localVideoConverterConfig.videoFrameRate = this.jdField_b_of_type_Int;
      localVideoConverterConfig.beginTime = this.jdField_a_of_type_Long;
      localVideoConverterConfig.endTime = this.jdField_b_of_type_Long;
      localVideoConverterConfig.isMute = this.jdField_b_of_type_Boolean;
      localVideoConverterConfig.accurateSeek = this.jdField_c_of_type_Boolean;
      localVideoConverterConfig.bitrateMode = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hwBitrateMode;
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isNeedHighProfile)
      {
        localVideoConverterConfig.setProfileLevel = true;
        localVideoConverterConfig.profile = 8;
        localVideoConverterConfig.level = 512;
      }
      if (StoryConfigManager.e())
      {
        SLog.d(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "story debug mode is enable");
        StoryConfigManager localStoryConfigManager = (StoryConfigManager)SuperManager.a(10);
        paramInt1 = ((Integer)localStoryConfigManager.b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
        paramInt2 = ((Integer)localStoryConfigManager.b("int_story_debug_bitrate_mode", Integer.valueOf(localVideoConverterConfig.bitrateMode))).intValue();
        boolean bool = ((Boolean)localStoryConfigManager.b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
        localVideoConverterConfig.bitrateMode = paramInt2;
        localVideoConverterConfig.videoBitRate = (paramInt1 * 1000);
        if (!bool) {
          break label453;
        }
        localVideoConverterConfig.setProfileLevel = true;
        localVideoConverterConfig.profile = 8;
      }
    }
    for (localVideoConverterConfig.level = 512;; localVideoConverterConfig.level = 512)
    {
      SLog.a(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: getEncodeConfig() config.setRotation = " + localVideoConverterConfig.setRotation + ", scaleRate=" + localVideoConverterConfig.scaleRate + ", videoBitRate=" + localVideoConverterConfig.videoBitRate + ", videoFrameRate=" + localVideoConverterConfig.videoFrameRate + ", beginTime=" + localVideoConverterConfig.beginTime + ", endTime=" + localVideoConverterConfig.endTime, ", isMute=" + this.jdField_b_of_type_Boolean, ", accurateSeek=" + this.jdField_c_of_type_Boolean + ",bitrateMode=" + localVideoConverterConfig.bitrateMode + ",setProfileLevel=" + localVideoConverterConfig.setProfileLevel + ",profile=" + localVideoConverterConfig.profile + ", level=" + localVideoConverterConfig.level);
      return localVideoConverterConfig;
      paramInt2 = paramInt1;
      break;
      label453:
      localVideoConverterConfig.setProfileLevel = false;
      localVideoConverterConfig.profile = 1;
    }
  }
  
  public void onCancel()
  {
    SLog.c(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onCanceled");
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void onFail(Throwable paramThrowable)
  {
    SLog.e(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onFailed");
  }
  
  public void onProgress(int paramInt)
  {
    SLog.b(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onProgress:" + paramInt);
  }
  
  public void onSuccess()
  {
    SLog.e(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onSuccessed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */