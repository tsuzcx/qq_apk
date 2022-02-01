package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VideoCombineHelper$CombineTask$5
  extends VideoCombineHelper.FFmpegCallback
{
  public void a(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("splitAudio end : isSuccess = ");
    localStringBuilder.append(paramBoolean);
    QLog.d(".troop.VideoCombineHelper", 2, localStringBuilder.toString());
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(this.jdField_a_of_type_JavaIoFile.getAbsolutePath(), true, "cmobine auido video done.");
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$Callback.a(this.b.getAbsolutePath(), false, "cmobine auido video done.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.CombineTask.5
 * JD-Core Version:    0.7.0.1
 */