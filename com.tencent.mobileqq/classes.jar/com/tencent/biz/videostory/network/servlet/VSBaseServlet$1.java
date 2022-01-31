package com.tencent.biz.videostory.network.servlet;

import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import ved;
import xgo;
import xgp;
import xgq;
import xgt;
import xgz;

public class VSBaseServlet$1
  implements Runnable
{
  public VSBaseServlet$1(xgz paramxgz, VSBaseRequest paramVSBaseRequest) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = this.a.getRequestKey();
      localObject = xgq.a().a((String)localObject);
      if ((localObject == null) || (((xgp)localObject).a() == null))
      {
        ved.b("VSNetworkHelper| Protocol Cache", "cache not found or bundle deserialized failed");
        return;
      }
      localObject = this.a.decode(xgz.a(this.this$0, ((xgp)localObject).a()));
      VSNetworkHelper.a().a().a(this.a, (MessageMicro)localObject);
      ved.b("VSNetworkHelper| Protocol Cache", "send Cache Success costTime:" + (System.currentTimeMillis() - l));
      return;
    }
    catch (Exception localException)
    {
      ved.d("VSNetworkHelper| Protocol Cache", localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.network.servlet.VSBaseServlet.1
 * JD-Core Version:    0.7.0.1
 */