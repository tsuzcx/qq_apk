package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VideoCombineHelper$CombineTask$1$2
  implements VideoCombineHelper.Callback
{
  VideoCombineHelper$CombineTask$1$2(VideoCombineHelper.CombineTask.1 param1, long paramLong) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      QLog.d(".troop.VideoCombineHelper", 2, "combineWording end! isSuccess:" + paramBoolean + " path = " + paramString1);
      QLog.d(".troop.trace_video_combine", 2, "combineWordingTime:" + (System.currentTimeMillis() - this.jdField_a_of_type_Long));
    }
    File localFile = new File(paramString1);
    if ((paramBoolean) && (localFile.exists()))
    {
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.e = paramString1;
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.a.b(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask);
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.b();
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.d = paramString2;
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.a.a(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.CombineTask.1.2
 * JD-Core Version:    0.7.0.1
 */