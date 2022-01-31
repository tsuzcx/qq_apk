package com.tencent.biz.videostory.network.servlet;

import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import urk;
import wxr;
import wxs;
import wxt;
import wxw;
import wyc;

public class VSBaseServlet$1
  implements Runnable
{
  public VSBaseServlet$1(wyc paramwyc, VSBaseRequest paramVSBaseRequest) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = this.a.getRequestKey();
      localObject = wxt.a().a((String)localObject);
      if ((localObject == null) || (((wxs)localObject).a() == null))
      {
        urk.b("VSNetworkHelper| Protocol Cache", "cache not found or bundle deserialized failed");
        return;
      }
      localObject = this.a.decode(wyc.a(this.this$0, ((wxs)localObject).a()));
      VSNetworkHelper.a().a().a(this.a, (MessageMicro)localObject);
      urk.b("VSNetworkHelper| Protocol Cache", "send Cache Success costTime:" + (System.currentTimeMillis() - l));
      return;
    }
    catch (Exception localException)
    {
      urk.d("VSNetworkHelper| Protocol Cache", localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.network.servlet.VSBaseServlet.1
 * JD-Core Version:    0.7.0.1
 */