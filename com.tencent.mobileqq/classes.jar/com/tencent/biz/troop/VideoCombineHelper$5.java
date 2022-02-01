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
      QLog.d(".troop.VideoCombineHelper", 2, "splitAudio end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "splitAudioTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a));
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a = System.currentTimeMillis();
    }
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(this.jdField_a_of_type_JavaLangString, false, "splitAudio done.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.5
 * JD-Core Version:    0.7.0.1
 */