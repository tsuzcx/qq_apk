package com.tencent.biz.videostory.network.servlet;

import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import veg;
import xgr;
import xgs;
import xgt;
import xgw;
import xhc;

public class VSBaseServlet$1
  implements Runnable
{
  public VSBaseServlet$1(xhc paramxhc, VSBaseRequest paramVSBaseRequest) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = this.a.getRequestKey();
      localObject = xgt.a().a((String)localObject);
      if ((localObject == null) || (((xgs)localObject).a() == null))
      {
        veg.b("VSNetworkHelper| Protocol Cache", "cache not found or bundle deserialized failed");
        return;
      }
      localObject = this.a.decode(xhc.a(this.this$0, ((xgs)localObject).a()));
      VSNetworkHelper.a().a().a(this.a, (MessageMicro)localObject);
      veg.b("VSNetworkHelper| Protocol Cache", "send Cache Success costTime:" + (System.currentTimeMillis() - l));
      return;
    }
    catch (Exception localException)
    {
      veg.d("VSNetworkHelper| Protocol Cache", localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.network.servlet.VSBaseServlet.1
 * JD-Core Version:    0.7.0.1
 */