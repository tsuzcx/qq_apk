package com.tencent.biz.videostory.network.servlet;

import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import wsv;
import yvh;
import yvi;
import yvj;
import yvm;
import yvs;

public class VSBaseServlet$1
  implements Runnable
{
  public VSBaseServlet$1(yvs paramyvs, VSBaseRequest paramVSBaseRequest) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = this.a.getRequestKey();
      localObject = yvj.a().a((String)localObject);
      if ((localObject == null) || (((yvi)localObject).a() == null))
      {
        wsv.b("VSNetworkHelper| Protocol Cache", "cache not found or bundle deserialized failed");
        return;
      }
      localObject = this.a.decode(yvs.a(this.this$0, ((yvi)localObject).a()));
      VSNetworkHelper.a().a().a(this.a, (MessageMicro)localObject);
      wsv.b("VSNetworkHelper| Protocol Cache", "send Cache Success costTime:" + (System.currentTimeMillis() - l));
      return;
    }
    catch (Exception localException)
    {
      wsv.d("VSNetworkHelper| Protocol Cache", localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.network.servlet.VSBaseServlet.1
 * JD-Core Version:    0.7.0.1
 */