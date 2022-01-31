package com.tencent.mobileqq.activity.chathistory;

import afcm;
import afcn;
import akpu;
import akqa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import mqq.app.AccountNotMatchException;

class TroopAIOImageGeter$IncreasinglyLoadMediaTask
  implements Runnable
{
  TroopAIOImageGeter$IncreasinglyLoadMediaTask(TroopAIOImageGeter paramTroopAIOImageGeter) {}
  
  public void run()
  {
    Object localObject7;
    ArrayList localArrayList1;
    Object localObject8;
    for (;;)
    {
      try
      {
        this.this$0.jdField_a_of_type_Boolean = true;
        if (this.this$0.jdField_a_of_type_Int < 1)
        {
          this.this$0.jdField_a_of_type_Boolean = false;
          this.this$0.a();
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopAIOImageGeter", 2, "[IncreasinglyLoadTask] start");
        }
        if ((this.this$0.jdField_a_of_type_Afcm == null) && (this.this$0.jdField_a_of_type_Afcn == null))
        {
          this.this$0.jdField_a_of_type_Boolean = false;
          this.this$0.a();
          return;
        }
        l = System.currentTimeMillis();
        localObject7 = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(this.this$0.jdField_a_of_type_JavaLangString);
        localArrayList2 = new ArrayList();
        localArrayList1 = new ArrayList();
        if (this.this$0.jdField_b_of_type_Boolean) {
          continue;
        }
        if (this.this$0.jdField_b_of_type_JavaLangString == null)
        {
          this.this$0.jdField_a_of_type_Boolean = false;
          this.this$0.a();
          return;
        }
        localObject8 = new int[8];
        Object tmp193_191 = localObject8;
        tmp193_191[0] = -20000;
        Object tmp199_193 = tmp193_191;
        tmp199_193[1] = -2000;
        Object tmp205_199 = tmp199_193;
        tmp205_199[2] = -1035;
        Object tmp211_205 = tmp205_199;
        tmp211_205[3] = -2011;
        Object tmp217_211 = tmp211_205;
        tmp217_211[4] = -2022;
        Object tmp223_217 = tmp217_211;
        tmp223_217[5] = -2005;
        Object tmp229_223 = tmp223_217;
        tmp229_223[6] = -2017;
        Object tmp236_229 = tmp229_223;
        tmp236_229[7] = -2071;
        tmp236_229;
        if (this.this$0.jdField_c_of_type_Boolean) {
          continue;
        }
        localObject6 = ((QQAppInterface)localObject7).a(this.this$0.jdField_b_of_type_Int).a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_b_of_type_Int, (int[])localObject8);
        localObject1 = localObject6;
        if (((List)localObject6).size() < 1)
        {
          localObject1 = ((QQAppInterface)localObject7).a().a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_b_of_type_Int, (int[])localObject8, 1);
          this.this$0.jdField_a_of_type_Int = ((List)localObject1).size();
        }
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        long l;
        ArrayList localArrayList2;
        Object localObject6;
        Object localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopAIOImageGeter", 2, "no appRuntime");
        return;
        localObject2 = ((QQAppInterface)localObject7).a().a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_b_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_c_of_type_Int, this.this$0.jdField_d_of_type_Long, (int[])localObject8, 1);
        continue;
        if ((((QQAppInterface)localObject7).a() != null) && (!this.this$0.jdField_c_of_type_Boolean)) {
          continue;
        }
        this.this$0.jdField_a_of_type_Boolean = false;
        this.this$0.a();
        return;
        localObject2 = ((QQAppInterface)localObject7).a().a(this.this$0.jdField_a_of_type_Long);
        continue;
        localArrayList2.addAll(0, (Collection)localObject2);
        localArrayList1.addAll(0, TroopAIOImageGeter.a(this.this$0, (QQAppInterface)localObject7, (List)localObject2));
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label514:
        label582:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("TroopAIOImageGeter", 2, "out of memory", localOutOfMemoryError);
        return;
        localList = this.this$0.jdField_a_of_type_JavaUtilList;
        continue;
        localObject8 = this.this$0.jdField_a_of_type_JavaUtilList;
        i = 0;
        try
        {
          if (i >= localList.size()) {
            break label1083;
          }
          localAIORichMediaData = (AIORichMediaData)localList.get(i);
          if (this.this$0.a(localAIORichMediaData)) {
            break label1128;
          }
          ((List)localObject7).add(localAIORichMediaData);
        }
        finally {}
      }
      finally
      {
        this.this$0.jdField_a_of_type_Boolean = false;
      }
      if (this.this$0.jdField_c_of_type_Boolean) {
        continue;
      }
      localArrayList2.addAll((Collection)localObject1);
      localArrayList1.addAll(TroopAIOImageGeter.a(this.this$0, (QQAppInterface)localObject7, (List)localObject1));
      this.this$0.jdField_c_of_type_Boolean = true;
      if ((this.this$0.jdField_b_of_type_Boolean) || (localArrayList1.size() >= 0) || (this.this$0.jdField_a_of_type_Int < 1))
      {
        if (localArrayList1.size() <= 0) {
          break label1111;
        }
        localObject6 = this.this$0.jdField_a_of_type_Afcm;
        if (localObject6 != null)
        {
          localObject7 = new ArrayList();
          if (this.this$0.jdField_b_of_type_Int == 1) {
            break label1121;
          }
          if (this.this$0.jdField_b_of_type_Int != 1026) {
            continue;
          }
          break label1121;
          if (this.this$0.jdField_b_of_type_Int != 1) {
            continue;
          }
          localObject1 = (AIORichMediaData[])((List)localObject1).toArray(new AIORichMediaData[((List)localObject1).size()]);
          if (localObject1.length > 0) {
            ((afcm)localObject6).a((AIORichMediaData[])localObject1, -1);
          }
        }
        localObject1 = this.this$0.jdField_a_of_type_Afcn;
        if (localObject1 != null)
        {
          localObject6 = (AIORichMediaData[])localArrayList1.toArray(new AIORichMediaData[localArrayList1.size()]);
          if (localObject6.length > 0) {
            ((afcn)localObject1).a((AIORichMediaData[])localObject6, -1);
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("TroopAIOImageGeter", 2, "[IncreasinglyLoadTask] end isMultiMsg: " + this.this$0.jdField_b_of_type_Boolean + ", tempList.size: " + localArrayList2.size() + ", tempDataList.size: " + localArrayList1.size() + ", cost:" + (System.currentTimeMillis() - l));
        }
        this.this$0.jdField_a_of_type_Boolean = false;
        return;
        if (!akpu.a(this.this$0.jdField_b_of_type_Int)) {
          continue;
        }
        localObject1 = this.this$0;
        ((TroopAIOImageGeter)localObject1).jdField_b_of_type_Long -= 1L;
        localObject1 = ((QQAppInterface)localObject7).a().a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_b_of_type_Int, this.this$0.jdField_c_of_type_Long, this.this$0.jdField_c_of_type_Int, this.this$0.jdField_b_of_type_Long, (int[])localObject8, 1);
        this.this$0.jdField_a_of_type_Int = ((List)localObject1).size();
        localObject6 = this.this$0;
        ((TroopAIOImageGeter)localObject6).jdField_d_of_type_Int += 1;
      }
    }
    for (;;)
    {
      Object localObject2;
      List localList;
      int i;
      AIORichMediaData localAIORichMediaData;
      label1083:
      Object localObject5 = (AIORichMediaData[])((List)localObject7).toArray(new AIORichMediaData[((List)localObject7).size()]);
      break label514;
      label1111:
      this.this$0.a();
      break label582;
      label1121:
      localObject5 = localArrayList1;
      break;
      label1128:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOImageGeter.IncreasinglyLoadMediaTask
 * JD-Core Version:    0.7.0.1
 */