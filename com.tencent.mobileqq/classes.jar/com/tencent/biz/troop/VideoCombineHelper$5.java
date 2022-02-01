package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;

class VideoCombineHelper$5
  extends VideoCombineHelper.FFmpegCallback
{
  VideoCombineHelper$5(VideoCombineHelper paramVideoCombineHelper, VideoCombineHelper.Callback paramCallback, String paramString)
  {
    super(paramVideoCombineHelper);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("splitAudio end : isSuccess = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(".troop.VideoCombineHelper", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("splitAudioTime: ");
      localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a);
      QLog.d(".troop.trace_video_combine", 2, localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(this.jdField_a_of_type_JavaLangString, false, "splitAudio done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.5
 * JD-Core Version:    0.7.0.1
 */