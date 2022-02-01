package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;

class VideoCombineHelper$CombineTask$6
  extends VideoCombineHelper.FFmpegCallback
{
  VideoCombineHelper$CombineTask$6(VideoCombineHelper.CombineTask paramCombineTask, VideoCombineHelper.Callback paramCallback, String paramString)
  {
    super(paramCombineTask.a);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.VideoCombineHelper", 2, "watermark doen");
    }
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(this.jdField_a_of_type_JavaLangString, paramBoolean, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.CombineTask.6
 * JD-Core Version:    0.7.0.1
 */