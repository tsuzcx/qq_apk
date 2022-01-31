package com.tencent.biz.videostory.network.servlet;

import com.tencent.biz.videostory.network.VSNetworkHelper;
import com.tencent.biz.videostory.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import wxe;
import yzw;
import yzx;
import yzy;
import zab;
import zah;

public class VSBaseServlet$1
  implements Runnable
{
  public VSBaseServlet$1(zah paramzah, VSBaseRequest paramVSBaseRequest) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = this.a.getRequestKey();
      localObject = yzy.a().a((String)localObject);
      if ((localObject == null) || (((yzx)localObject).a() == null))
      {
        wxe.b("VSNetworkHelper| Protocol Cache", "cache not found or bundle deserialized failed");
        return;
      }
      localObject = this.a.decode(zah.a(this.this$0, ((yzx)localObject).a()));
      VSNetworkHelper.a().a(this.a, (MessageMicro)localObject);
      wxe.b("VSNetworkHelper| Protocol Cache", "send Cache Success costTime:" + (System.currentTimeMillis() - l));
      return;
    }
    catch (Exception localException)
    {
      wxe.d("VSNetworkHelper| Protocol Cache", localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.videostory.network.servlet.VSBaseServlet.1
 * JD-Core Version:    0.7.0.1
 */