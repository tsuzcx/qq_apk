package com.tencent.biz;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import java.util.concurrent.ConcurrentHashMap;
import myl;
import nbj;
import nbk;

public class AuthorizeConfig$1
  implements Runnable
{
  public AuthorizeConfig$1(myl parammyl) {}
  
  public void run()
  {
    long l = SystemClock.currentThreadTimeMillis();
    if (l > myl.jdField_a_of_type_Long + 10000L)
    {
      this.this$0.jdField_a_of_type_AndroidContentContext.getSharedPreferences("domainCmdRight", 4);
      myl.jdField_a_of_type_Long = l;
    }
    FlatBuffersParser.b();
    l = this.this$0.jdField_a_of_type_AndroidContentSharedPreferences.getLong("lastUpdate", 0L);
    if (l != myl.jdField_b_of_type_Long)
    {
      myl.jdField_b_of_type_Long = l;
      this.this$0.jdField_a_of_type_Nbk.b();
      this.this$0.jdField_a_of_type_Nbj.a();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.1
 * JD-Core Version:    0.7.0.1
 */