package com.tencent.mobileqq.activity.aio.photo;

import adxu;
import adyh;
import akbj;
import akbp;
import apck;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
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
    ArrayList localArrayList1;
    label137:
    Object localObject7;
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
        ArrayList localArrayList2;
        Object localObject6;
        Object localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AIOImageProviderService", 2, "out of memory", localOutOfMemoryError);
        this.this$0.jdField_d_of_type_Boolean = false;
        continue;
        localList1 = AIOImageProviderService.a(this.this$0).a().a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Long, this.this$0.jdField_c_of_type_Int, this.this$0.jdField_d_of_type_Long, (int[])localObject7, 60);
        continue;
        if ((AIOImageProviderService.a(this.this$0).a() != null) && (!this.this$0.jdField_c_of_type_Boolean)) {
          continue;
        }
        this.this$0.jdField_d_of_type_Boolean = false;
        this.this$0.b();
        this.this$0.jdField_d_of_type_Boolean = false;
        continue;
        localList1 = apck.a(AIOImageProviderService.a(this.this$0).a().a(this.this$0.jdField_a_of_type_Long));
        continue;
        localArrayList2.addAll(0, localList1);
        localArrayList1.addAll(0, AIOImageProviderService.a(this.this$0, AIOImageProviderService.a(this.this$0), localList1));
        continue;
      }
      catch (Exception localException)
      {
        label555:
        label623:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("AIOImageProviderService", 2, "IncreasinglyLoadMediaTask exception = " + localException.getMessage());
        this.this$0.jdField_d_of_type_Boolean = false;
        continue;
        localList2 = this.this$0.jdField_b_of_type_JavaUtilList;
        continue;
        localList3 = this.this$0.jdField_b_of_type_JavaUtilList;
        i = 0;
        try
        {
          if (i >= localList2.size()) {
            break label1179;
          }
          localAIORichMediaData = (AIORichMediaData)localList2.get(i);
          if (AIOImageProviderService.a(localAIORichMediaData)) {
            break label1224;
          }
          ((List)localObject7).add(localAIORichMediaData);
        }
        finally {}
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
      if ((this.this$0.jdField_a_of_type_Adyh == null) && (this.this$0.jdField_a_of_type_Adxu == null))
      {
        this.this$0.jdField_d_of_type_Boolean = false;
        this.this$0.b();
        this.this$0.jdField_d_of_type_Boolean = false;
      }
      else
      {
        l = System.currentTimeMillis();
        localArrayList2 = new ArrayList();
        localArrayList1 = new ArrayList();
        if (!this.this$0.jdField_a_of_type_Boolean)
        {
          if (this.this$0.jdField_b_of_type_JavaLangString == null)
          {
            this.this$0.jdField_d_of_type_Boolean = false;
            this.this$0.b();
            this.this$0.jdField_d_of_type_Boolean = false;
            continue;
          }
          localObject7 = new int[8];
          Object tmp191_189 = localObject7;
          tmp191_189[0] = -20000;
          Object tmp197_191 = tmp191_189;
          tmp197_191[1] = -2000;
          Object tmp203_197 = tmp197_191;
          tmp203_197[2] = -1035;
          Object tmp209_203 = tmp203_197;
          tmp209_203[3] = -2011;
          Object tmp215_209 = tmp209_203;
          tmp215_209[4] = -2022;
          Object tmp221_215 = tmp215_209;
          tmp221_215[5] = -2005;
          Object tmp227_221 = tmp221_215;
          tmp227_221[6] = -2017;
          Object tmp234_227 = tmp227_221;
          tmp234_227[7] = -2071;
          tmp234_227;
          if (!this.this$0.jdField_c_of_type_Boolean)
          {
            localObject6 = AIOImageProviderService.a(this.this$0).a(this.this$0.jdField_a_of_type_Int).a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_Int, (int[])localObject7);
            localObject2 = localObject6;
            if (((List)localObject6).size() < 60)
            {
              localObject2 = AIOImageProviderService.a(this.this$0).a().a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_Int, (int[])localObject7, 60);
              this.this$0.jdField_d_of_type_Int = ((List)localObject2).size();
            }
          }
          for (;;)
          {
            if (this.this$0.jdField_c_of_type_Boolean) {
              break label997;
            }
            localArrayList2.addAll((Collection)localObject2);
            localArrayList1.addAll(AIOImageProviderService.a(this.this$0, AIOImageProviderService.a(this.this$0), (List)localObject2));
            this.this$0.jdField_c_of_type_Boolean = true;
            if ((!this.this$0.jdField_a_of_type_Boolean) && (localArrayList1.size() < 30) && (this.this$0.jdField_d_of_type_Int >= 60)) {
              break label137;
            }
            if (localArrayList1.size() <= 0) {
              break label1207;
            }
            localObject6 = this.this$0.jdField_a_of_type_Adyh;
            if (localObject6 != null)
            {
              localObject7 = new ArrayList();
              if (this.this$0.jdField_a_of_type_Int == 1) {
                break label1217;
              }
              if (this.this$0.jdField_a_of_type_Int != 1026) {
                break label1084;
              }
              break label1217;
              if ((this.this$0.jdField_a_of_type_Int != 1) && (this.this$0.jdField_a_of_type_Int != 0) && (this.this$0.jdField_a_of_type_Int != 3000)) {
                break label1096;
              }
              localObject2 = (AIORichMediaData[])((List)localObject2).toArray(new AIORichMediaData[((List)localObject2).size()]);
              if (localObject2.length > 0) {
                ((adyh)localObject6).a((AIORichMediaData[])localObject2, -1);
              }
            }
            localObject2 = this.this$0.jdField_a_of_type_Adxu;
            if (localObject2 != null)
            {
              localObject6 = (AIORichMediaData[])localArrayList1.toArray(new AIORichMediaData[localArrayList1.size()]);
              if (localObject6.length > 0) {
                ((adxu)localObject2).a((AIORichMediaData[])localObject6, -1);
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("AIOImageProviderService", 2, "[IncreasinglyLoadTask] end isMultiMsg: " + this.this$0.jdField_a_of_type_Boolean + ", tempList.size: " + localArrayList2.size() + ", tempDataList.size: " + localArrayList1.size() + ", cost:" + (System.currentTimeMillis() - l));
            }
            this.this$0.jdField_d_of_type_Boolean = false;
            break;
            if (!akbj.a(this.this$0.jdField_a_of_type_Int)) {
              break label863;
            }
            localObject2 = this.this$0;
            ((AIOImageProviderService)localObject2).jdField_c_of_type_Long -= 1L;
            localObject2 = AIOImageProviderService.a(this.this$0).a().a(this.this$0.jdField_b_of_type_JavaLangString, this.this$0.jdField_a_of_type_Int, this.this$0.jdField_b_of_type_Long, this.this$0.jdField_c_of_type_Int, this.this$0.jdField_c_of_type_Long, (int[])localObject7, 60);
            this.this$0.jdField_d_of_type_Int = ((List)localObject2).size();
            localObject6 = this.this$0;
            ((AIOImageProviderService)localObject6).e += 1;
          }
        }
      }
    }
    for (;;)
    {
      label863:
      List localList1;
      label997:
      List localList2;
      label1084:
      label1096:
      List localList3;
      int i;
      AIORichMediaData localAIORichMediaData;
      label1179:
      Object localObject5 = (AIORichMediaData[])((List)localObject7).toArray(new AIORichMediaData[((List)localObject7).size()]);
      break label555;
      label1207:
      this.this$0.b();
      break label623;
      label1217:
      localObject5 = localArrayList1;
      break;
      label1224:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.IncreasinglyLoadMediaTask
 * JD-Core Version:    0.7.0.1
 */