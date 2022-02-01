package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VideoCombineHelper$CombineTask$1$1$1
  implements VideoCombineHelper.Callback
{
  VideoCombineHelper$CombineTask$1$1$1(VideoCombineHelper.CombineTask.1.1 param1, long paramLong) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("combineWording end! isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" path = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d(".troop.VideoCombineHelper", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("combineWordingTime:");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - this.jdField_a_of_type_Long);
      QLog.d(".troop.trace_video_combine", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(paramString1);
    if ((paramBoolean) && (((File)localObject).exists()))
    {
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1$1.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.e = paramString1;
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1$1.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.a.b(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1$1.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask);
      this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1$1.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.b();
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1$1.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.d = paramString2;
    this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1$1.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.a.a(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask$1$1.a.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.CombineTask.1.1.1
 * JD-Core Version:    0.7.0.1
 */