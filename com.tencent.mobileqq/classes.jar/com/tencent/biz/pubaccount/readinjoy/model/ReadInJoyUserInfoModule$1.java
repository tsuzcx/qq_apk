package com.tencent.biz.pubaccount.readinjoy.model;

import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import oql;

public class ReadInJoyUserInfoModule$1
  implements Runnable
{
  ReadInJoyUserInfoModule$1(ReadInJoyUserInfoModule paramReadInJoyUserInfoModule, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    if (ReadInJoyUserInfoModule.a(this.this$0).get(this.jdField_a_of_type_JavaLangString) != null) {
      QLog.d("ReadInJoyUserInfoModule", 2, "getSingleReadInJoyUserInfoWithParams return ahead of time, do not load db or network request, because the userInfo is loading.");
    }
    do
    {
      return;
      if (ReadInJoyUserInfoModule.a(this.this$0) != null)
      {
        localObject = ReadInJoyUserInfoModule.a(this.this$0).a(this.jdField_a_of_type_JavaLangString);
        if (localObject != null)
        {
          QLog.d("ReadInJoyUserInfoModule", 2, "getSingleReadInJoyUserInfoWithParams, hit cache, do not request again.");
          ReadInJoyUserInfoModule.a(this.this$0).a(this.jdField_a_of_type_JavaLangString, (ReadInJoyUserInfo)localObject);
          return;
        }
      }
      ReadInJoyUserInfoModule.a(this.this$0).put(this.jdField_a_of_type_JavaLangString, Boolean.valueOf(true));
      localObject = ReadInJoyUserInfoModule.a(this.this$0).a(this.jdField_a_of_type_JavaLangString);
    } while ((localObject != null) && (((List)localObject).size() > 0));
    Object localObject = new ArrayList();
    ((List)localObject).add(this.jdField_a_of_type_JavaLangString);
    this.this$0.a((List)localObject, this.jdField_a_of_type_Int, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule.1
 * JD-Core Version:    0.7.0.1
 */