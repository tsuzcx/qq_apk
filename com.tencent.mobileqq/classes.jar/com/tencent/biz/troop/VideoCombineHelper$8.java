package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;

class VideoCombineHelper$8
  extends VideoCombineHelper.FFmpegCallback
{
  VideoCombineHelper$8(VideoCombineHelper paramVideoCombineHelper, VideoCombineHelper.Callback paramCallback, String paramString1, String paramString2)
  {
    super(paramVideoCombineHelper);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "combineUnit end : isSuccess = " + paramBoolean);
      QLog.d(".troop.trace_video_combine", 2, "combineAudioAndVideoTime: " + (System.currentTimeMillis() - this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a));
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a = System.currentTimeMillis();
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(this.jdField_a_of_type_JavaLangString, true, "cmobine auido video done.");
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(this.b, false, "cmobine auido video done.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.8
 * JD-Core Version:    0.7.0.1
 */