package com.tencent.biz;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.biz.authorize.FlatBuffersConfig;
import com.tencent.biz.authorize.JsonConfig;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import java.util.concurrent.ConcurrentHashMap;

class AuthorizeConfig$1
  implements Runnable
{
  AuthorizeConfig$1(AuthorizeConfig paramAuthorizeConfig) {}
  
  public void run()
  {
    long l = SystemClock.currentThreadTimeMillis();
    if (l > AuthorizeConfig.jdField_a_of_type_Long + 10000L)
    {
      this.this$0.jdField_a_of_type_AndroidContentContext.getSharedPreferences("domainCmdRight", 4);
      AuthorizeConfig.jdField_a_of_type_Long = l;
    }
    FlatBuffersParser.b();
    l = this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.getLong("lastUpdate", 0L);
    if (l != AuthorizeConfig.jdField_b_of_type_Long)
    {
      AuthorizeConfig.jdField_b_of_type_Long = l;
      this.this$0.jdField_a_of_type_ComTencentBizAuthorizeJsonConfig.b();
      this.this$0.jdField_a_of_type_ComTencentBizAuthorizeFlatBuffersConfig.a();
      this.this$0.f = null;
      this.this$0.jdField_b_of_type_OrgJsonJSONObject = null;
      this.this$0.c = null;
      this.this$0.jdField_a_of_type_OrgJsonJSONObject = null;
      this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.this$0.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.1
 * JD-Core Version:    0.7.0.1
 */