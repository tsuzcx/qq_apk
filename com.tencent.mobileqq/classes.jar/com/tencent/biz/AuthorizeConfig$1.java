package com.tencent.biz;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import java.util.concurrent.ConcurrentHashMap;
import niz;
import nlx;
import nly;

public class AuthorizeConfig$1
  implements Runnable
{
  public AuthorizeConfig$1(niz paramniz) {}
  
  public void run()
  {
    long l = SystemClock.currentThreadTimeMillis();
    if (l > niz.jdField_a_of_type_Long + 10000L)
    {
      this.this$0.jdField_a_of_type_AndroidContentContext.getSharedPreferences("domainCmdRight", 4);
      niz.jdField_a_of_type_Long = l;
    }
    FlatBuffersParser.b();
    l = this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.getLong("lastUpdate", 0L);
    if (l != niz.jdField_b_of_type_Long)
    {
      niz.jdField_b_of_type_Long = l;
      this.this$0.jdField_a_of_type_Nly.b();
      this.this$0.jdField_a_of_type_Nlx.a();
      this.this$0.i = null;
      this.this$0.jdField_b_of_type_OrgJsonJSONObject = null;
      this.this$0.c = null;
      this.this$0.jdField_a_of_type_OrgJsonJSONObject = null;
      this.this$0.g = null;
      this.this$0.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.this$0.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.1
 * JD-Core Version:    0.7.0.1
 */