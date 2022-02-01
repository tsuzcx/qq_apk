package com.tencent.biz.troop;

import com.tencent.qphone.base.util.QLog;
import java.io.File;

class VideoCombineHelper$CombineTask$1
  implements VideoCombineHelper.Callback
{
  VideoCombineHelper$CombineTask$1(VideoCombineHelper.CombineTask paramCombineTask, VideoCombineHelper.CombineParams paramCombineParams) {}
  
  public void a(String paramString1, boolean paramBoolean, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("combineVideos end! isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" path = ");
      ((StringBuilder)localObject).append(paramString1);
      QLog.d(".troop.VideoCombineHelper", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(paramString1);
    if ((paramBoolean) && (((File)localObject).exists()))
    {
      if (this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineParams.a)
      {
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.b(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.jdField_a_of_type_JavaLangString != null)
      {
        l = System.currentTimeMillis();
        this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper.a(paramString1, this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask.jdField_a_of_type_JavaLangString, new VideoCombineHelper.CombineTask.1.1(this, l));
        return;
      }
      long l = System.currentTimeMillis();
      paramString1 = this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask;
      paramString1.a((File)localObject, paramString1.b, new VideoCombineHelper.CombineTask.1.2(this, l));
      return;
    }
    paramString1 = this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask;
    paramString1.d = paramString2;
    paramString1.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$TaskListener.a(this.jdField_a_of_type_ComTencentBizTroopVideoCombineHelper$CombineTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.troop.VideoCombineHelper.CombineTask.1
 * JD-Core Version:    0.7.0.1
 */