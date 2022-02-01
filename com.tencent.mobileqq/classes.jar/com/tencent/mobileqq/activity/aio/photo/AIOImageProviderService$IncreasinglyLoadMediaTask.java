package com.tencent.mobileqq.activity.aio.photo;

import com.tencent.imcore.message.BaseMsgProxy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.MultiMsgProxy;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class AIOImageProviderService$IncreasinglyLoadMediaTask
  implements Runnable
{
  AIOImageProviderService$IncreasinglyLoadMediaTask(AIOImageProviderService paramAIOImageProviderService) {}
  
  public void run()
  {
    for (;;)
    {
      try
      {
        this.this$0.jdField_d_of_type_Boolean = true;
        if (this.this$0.jdField_d_of_type_Int < 60)
        {
          this.this$0.jdField_d_of_type_Boolean = false;
          this.this$0.b();
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        long l;
        ArrayList localArrayList1;
        ArrayList localArrayList2;
        int[] arrayOfInt;
        Object localObject4;
        Object localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AIOImageProviderService", 2, "out of memory", localOutOfMemoryError);
        this.this$0.jdField_d_of_type_Boolean = false;
        continue;
        List localList = AIOImageProviderService.a(this.this$0).getMessageFacade().a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Long, this.this$0.jdField_c_of_type_Int, this.this$0.jdField_d_of_type_Long, arrayOfInt, 60);
        continue;
        if ((AIOImageProviderService.a(this.this$0).getMultiMessageProxy() != null) && (!this.this$0.jdField_c_of_type_Boolean)) {
          continue;
        }
        this.this$0.jdField_d_of_type_Boolean = false;
        this.this$0.b();
        this.this$0.jdField_d_of_type_Boolean = false;
        continue;
        localList = FileManagerUtil.a(AIOImageProviderService.a(this.this$0).getMultiMessageProxy().a(this.this$0.jdField_a_of_type_Long));
        continue;
        localArrayList1.addAll(0, localList);
        localArrayList2.addAll(0, this.this$0.a(localList));
        continue;
      }
      catch (Exception localException)
      {
        label135:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AIOImageProviderService", 2, "IncreasinglyLoadMediaTask exception = " + localException.getMessage());
        this.this$0.jdField_d_of_type_Boolean = false;
        continue;
        this.this$0.b();
        continue;
      }
      finally
      {
        this.this$0.jdField_d_of_type_Boolean = false;
      }
      try
      {
        this.this$0.jdField_d_of_type_Boolean = false;
        return;
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "[IncreasinglyLoadTask] start");
      }
      if ((this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack == null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener == null))
      {
        this.this$0.jdField_d_of_type_Boolean = false;
        this.this$0.b();
        this.this$0.jdField_d_of_type_Boolean = false;
      }
      else
      {
        l = System.currentTimeMillis();
        localArrayList1 = new ArrayList();
        localArrayList2 = new ArrayList();
        if (this.this$0.jdField_a_of_type_Boolean) {
          continue;
        }
        if (this.this$0.jdField_b_of_type_JavaLangString != null) {
          continue;
        }
        this.this$0.jdField_d_of_type_Boolean = false;
        this.this$0.b();
        this.this$0.jdField_d_of_type_Boolean = false;
      }
    }
    arrayOfInt = new int[9];
    int[] tmp189_187 = arrayOfInt;
    tmp189_187[0] = -20000;
    int[] tmp195_189 = tmp189_187;
    tmp195_189[1] = -2000;
    int[] tmp201_195 = tmp195_189;
    tmp201_195[2] = -1035;
    int[] tmp207_201 = tmp201_195;
    tmp207_201[3] = -2011;
    int[] tmp213_207 = tmp207_201;
    tmp213_207[4] = -2022;
    int[] tmp219_213 = tmp213_207;
    tmp219_213[5] = -2005;
    int[] tmp225_219 = tmp219_213;
    tmp225_219[6] = -2017;
    int[] tmp232_225 = tmp225_219;
    tmp232_225[7] = -2071;
    int[] tmp239_232 = tmp232_225;
    tmp239_232[8] = -3017;
    tmp239_232;
    if (!this.this$0.jdField_c_of_type_Boolean)
    {
      localObject4 = AIOImageProviderService.a(this.this$0).getMessageProxy(this.this$0.jdField_a_of_type_Int).a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_Int, arrayOfInt);
      localObject2 = localObject4;
      if (((List)localObject4).size() < 60)
      {
        localObject2 = AIOImageProviderService.a(this.this$0).getMessageFacade().a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_Int, arrayOfInt, 60);
        this.this$0.jdField_d_of_type_Int = ((List)localObject2).size();
      }
    }
    for (;;)
    {
      if (this.this$0.jdField_c_of_type_Boolean) {
        break label816;
      }
      localArrayList1.addAll((Collection)localObject2);
      localArrayList2.addAll(this.this$0.a((List)localObject2));
      this.this$0.jdField_c_of_type_Boolean = true;
      if ((!this.this$0.jdField_a_of_type_Boolean) && (localArrayList2.size() < 30) && (this.this$0.jdField_d_of_type_Int >= 60)) {
        break label135;
      }
      if (localArrayList2.size() <= 0) {
        break label892;
      }
      AIOImageProviderService.a(this.this$0, localArrayList2);
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "[IncreasinglyLoadTask] end isMultiMsg: " + this.this$0.jdField_a_of_type_Boolean + ", tempList.size: " + localArrayList1.size() + ", tempDataList.size: " + localArrayList2.size() + ", cost:" + (System.currentTimeMillis() - l));
      }
      this.this$0.jdField_d_of_type_Boolean = false;
      break;
      if (!UinTypeUtil.g(this.this$0.jdField_a_of_type_Int)) {
        break label684;
      }
      localObject2 = this.this$0;
      ((AIOImageProviderService)localObject2).jdField_c_of_type_Long -= 1L;
      localObject2 = AIOImageProviderService.a(this.this$0).getMessageFacade().a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Long, this.this$0.jdField_c_of_type_Int, this.this$0.jdField_c_of_type_Long, arrayOfInt, 60);
      this.this$0.jdField_d_of_type_Int = ((List)localObject2).size();
      localObject4 = this.this$0;
      ((AIOImageProviderService)localObject4).e += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.IncreasinglyLoadMediaTask
 * JD-Core Version:    0.7.0.1
 */