package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AccountNotMatchException;

class AIOImageProviderService$6
  implements Runnable
{
  AIOImageProviderService$6(AIOImageProviderService paramAIOImageProviderService, long paramLong, int paramInt) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_JavaUtilList;
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    do
    {
      do
      {
        return;
        localObject = AIOImageProviderService.a(this.this$0, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int);
      } while ((localObject == null) || (!MessageForPic.class.isInstance(localObject)));
      localObject = (MessageForPic)localObject;
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "payFlow,id:" + this.jdField_a_of_type_Long + ",subId:" + this.jdField_a_of_type_Int);
        }
        AIOImageProviderService.a((QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.this$0.jdField_a_of_type_JavaLangString), (MessageForPic)localObject);
        return;
      }
      catch (AccountNotMatchException localAccountNotMatchException) {}
    } while (!QLog.isColorLevel());
    QLog.d("AIOImageProviderService", 2, "no appRuntime");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.6
 * JD-Core Version:    0.7.0.1
 */