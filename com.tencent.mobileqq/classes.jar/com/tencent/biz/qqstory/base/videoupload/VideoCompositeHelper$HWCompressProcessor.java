package com.tencent.biz.qqstory.base.videoupload;

import android.os.Build.VERSION;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.Processor;
import com.tencent.mobileqq.shortvideo.util.videoconverter.VideoConverter.VideoConvertConfig;
import java.io.File;

public class VideoCompositeHelper$HWCompressProcessor
  implements VideoConverter.Processor
{
  int jdField_a_of_type_Int = 1024000;
  final long jdField_a_of_type_Long;
  PublishVideoEntry jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry;
  final String jdField_a_of_type_JavaLangString;
  public Throwable a;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int = 25;
  final long jdField_b_of_type_Long;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  int d;
  int e;
  int f;
  int g;
  
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
  
  public VideoConverter.VideoConvertConfig a(int paramInt1, int paramInt2)
  {
    VideoConverter.VideoConvertConfig localVideoConvertConfig = new VideoConverter.VideoConvertConfig();
    if (paramInt1 <= paramInt2)
    {
      Object localObject = new File(this.jdField_a_of_type_JavaLangString);
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      localVideoConvertConfig.jdField_a_of_type_JavaIoFile = ((File)localObject);
      localVideoConvertConfig.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localVideoConvertConfig.jdField_a_of_type_Float = (960.0F / paramInt2);
      localVideoConvertConfig.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
      localVideoConvertConfig.jdField_b_of_type_Boolean = a();
      localVideoConvertConfig.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
      localVideoConvertConfig.jdField_b_of_type_Long = this.jdField_b_of_type_Long;
      localVideoConvertConfig.jdField_c_of_type_Boolean = this.jdField_b_of_type_Boolean;
      localVideoConvertConfig.jdField_d_of_type_Boolean = this.jdField_c_of_type_Boolean;
      localVideoConvertConfig.g = this.jdField_d_of_type_Int;
      localVideoConvertConfig.h = this.e;
      localVideoConvertConfig.i = this.f;
      localVideoConvertConfig.j = this.g;
      localVideoConvertConfig.f = this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.hwBitrateMode;
      if (this.jdField_a_of_type_ComTencentBizQqstoryDatabasePublishVideoEntry.isNeedHighProfile)
      {
        localVideoConvertConfig.jdField_a_of_type_Boolean = true;
        localVideoConvertConfig.jdField_d_of_type_Int = 8;
        localVideoConvertConfig.e = 512;
      }
      if (StoryConfigManager.d())
      {
        SLog.d(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "story debug mode is enable");
        localObject = (StoryConfigManager)SuperManager.a(10);
        paramInt1 = ((Integer)((StoryConfigManager)localObject).b("int_story_debug_bitrate", Integer.valueOf(2000))).intValue();
        paramInt2 = ((Integer)((StoryConfigManager)localObject).b("int_story_debug_bitrate_mode", Integer.valueOf(localVideoConvertConfig.f))).intValue();
        boolean bool = ((Boolean)((StoryConfigManager)localObject).b("boolean_story_debug_use_high_profile", Boolean.valueOf(false))).booleanValue();
        localVideoConvertConfig.f = paramInt2;
        localVideoConvertConfig.jdField_a_of_type_Int = (paramInt1 * 1000);
        if (!bool) {
          break label571;
        }
        localVideoConvertConfig.jdField_a_of_type_Boolean = true;
        localVideoConvertConfig.jdField_d_of_type_Int = 8;
      }
    }
    for (localVideoConvertConfig.e = 512;; localVideoConvertConfig.e = 512)
    {
      SLog.a(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: getEncodeConfig() config.setRotation = " + localVideoConvertConfig.jdField_b_of_type_Boolean + ", scaleRate=" + localVideoConvertConfig.jdField_a_of_type_Float + ", videoBitRate=" + localVideoConvertConfig.jdField_a_of_type_Int + ", videoFrameRate=" + localVideoConvertConfig.jdField_b_of_type_Int + ", beginTime=" + localVideoConvertConfig.jdField_a_of_type_Long + ", endTime=" + localVideoConvertConfig.jdField_b_of_type_Long, ", isMute=" + this.jdField_b_of_type_Boolean, ", accurateSeek=" + this.jdField_c_of_type_Boolean + ", cropX=" + this.jdField_d_of_type_Int + ", cropY=" + this.e + ", cropWidth=" + this.f + ", cropHeight=" + this.g + ",bitrateMode=" + localVideoConvertConfig.f + ",setProfileLevel=" + localVideoConvertConfig.jdField_a_of_type_Boolean + ",profile=" + localVideoConvertConfig.jdField_d_of_type_Int + ", level=" + localVideoConvertConfig.e);
      return localVideoConvertConfig;
      paramInt2 = paramInt1;
      break;
      label571:
      localVideoConvertConfig.jdField_a_of_type_Boolean = false;
      localVideoConvertConfig.jdField_d_of_type_Int = 1;
    }
  }
  
  public void a()
  {
    SLog.e(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onSuccessed");
  }
  
  public void a(int paramInt)
  {
    SLog.b(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onProgress:" + paramInt);
  }
  
  public void a(Throwable paramThrowable)
  {
    SLog.e(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onFailed");
    this.jdField_a_of_type_JavaLangThrowable = paramThrowable;
  }
  
  public boolean a()
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
  
  public void b()
  {
    SLog.c(VideoCompositeHelper.jdField_a_of_type_JavaLangString, "HWCompressProcessor, step: HWCompressProcessor onCanceled");
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper.HWCompressProcessor
 * JD-Core Version:    0.7.0.1
 */