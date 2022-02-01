package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import pwi;

public class ReadInJoyUserInfoModule$1
  implements Runnable
{
  ReadInJoyUserInfoModule$1(ReadInJoyUserInfoModule paramReadInJoyUserInfoModule, String paramString, boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    boolean bool = true;
    if (ReadInJoyUserInfoModule.a(this.this$0).get(this.jdField_a_of_type_JavaLangString) != null)
    {
      QLog.d("ReadInJoyUserInfoModule", 2, "getSingleReadInJoyUserInfoWithParams return ahead of time, do not load db or network request, because the userInfo is loading.");
      return;
    }
    if (ReadInJoyUserInfoModule.a(this.this$0) != null)
    {
      localObject1 = ReadInJoyUserInfoModule.a(this.this$0).a(this.jdField_a_of_type_JavaLangString);
      if ((localObject1 != null) && ((!this.jdField_a_of_type_Boolean) || (!((ReadInJoyUserInfo)localObject1).isReadlTimeRead())) && (!this.jdField_b_of_type_Boolean))
      {
        QLog.d("ReadInJoyUserInfoModule", 2, "getSingleReadInJoyUserInfoWithParams, hit cache, do not request again.");
        ReadInJoyUserInfoModule.a(this.this$0).a(this.jdField_a_of_type_JavaLangString, (ReadInJoyUserInfo)localObject1);
        return;
      }
    }
    ReadInJoyUserInfoModule.a(this.this$0).put(this.jdField_a_of_type_JavaLangString, Boolean.valueOf(true));
    Object localObject1 = ReadInJoyUserInfoModule.a(this.this$0);
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    if ((!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {}
    for (;;)
    {
      localObject1 = ((pwi)localObject1).a((String)localObject2, bool);
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject2 = (ReadInJoyUserInfo)((List)localObject1).get(0);
        if ((localObject2 != null) && ((!this.jdField_a_of_type_Boolean) || (!((ReadInJoyUserInfo)localObject2).isReadlTimeRead())) && (!this.jdField_b_of_type_Boolean)) {
          break;
        }
      }
      if ((localObject1 != null) && (((List)localObject1).size() > 0) && (!this.jdField_a_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {
        break;
      }
      localObject1 = new ArrayList();
      ((List)localObject1).add(this.jdField_a_of_type_JavaLangString);
      this.this$0.a((List)localObject1, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.c);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.1
 * JD-Core Version:    0.7.0.1
 */