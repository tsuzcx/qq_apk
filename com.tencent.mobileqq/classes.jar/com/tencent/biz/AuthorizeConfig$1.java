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
    if (l > AuthorizeConfig.d + 10000L)
    {
      this.this$0.v.getSharedPreferences("domainCmdRight", 4);
      AuthorizeConfig.d = l;
    }
    FlatBuffersParser.c();
    l = this.this$0.w.getLong("lastUpdate", 0L);
    if (l != AuthorizeConfig.e)
    {
      AuthorizeConfig.e = l;
      this.this$0.x.g();
      this.this$0.y.f();
      AuthorizeConfig localAuthorizeConfig = this.this$0;
      localAuthorizeConfig.r = null;
      localAuthorizeConfig.g = null;
      localAuthorizeConfig.h = null;
      localAuthorizeConfig.f = null;
      localAuthorizeConfig.t.clear();
      this.this$0.u.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.1
 * JD-Core Version:    0.7.0.1
 */