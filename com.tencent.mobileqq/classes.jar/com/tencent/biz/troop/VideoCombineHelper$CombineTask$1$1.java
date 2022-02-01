package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VideoCombineHelper$CombineTask$1$1
  implements VideoCombineHelper.Callback
{
  VideoCombineHelper$CombineTask$1$1(VideoCombineHelper.CombineTask.1 param1, long paramLong) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("combineMp4_M4a end! isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" path = ");
      localStringBuilder.append(paramString1);
      QLog.d(".troop.VideoCombineHelper", 2, localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("combineMp4_M4aTime:");
      localStringBuilder.append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      QLog.d(".troop.trace_video_combine", 2, localStringBuilder.toString());
    }
    paramString1 = new File(paramString1);
    if ((paramBoolean) && (paramString1.exists()))
    {
      long l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1.a.a(paramString1, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1.a.b, new VideoCombineHelper.CombineTask.1.1.1(this, l));
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1.a.d = paramString2;
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1.a.a.a(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.CombineTask.1.1
 * JD-Core Version:    0.7.0.1
 */