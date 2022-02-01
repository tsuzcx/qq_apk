package com.tencent.biz.richframework.network.servlet;

import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import yqp;
import zwu;
import zwv;
import zww;
import zwz;
import zxf;

public class VSBaseServlet$1
  implements Runnable
{
  public VSBaseServlet$1(zxf paramzxf, VSBaseRequest paramVSBaseRequest) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = this.a.getRequestKey();
      localObject = zww.a().a((String)localObject);
      if ((localObject == null) || (((zwv)localObject).a() == null))
      {
        yqp.b("VSNetworkHelper| Protocol Cache", "cache not found or bundle deserialized failed,CmdName:" + this.a.getCmdName() + " Seq:" + this.a.getCurrentSeq());
        return;
      }
      localObject = this.a.decode(zxf.a(this.this$0, ((zwv)localObject).a()));
      VSNetworkHelper.a().a(this.a, (MessageMicro)localObject);
      yqp.b("VSNetworkHelper| Protocol Cache", "send Cache Success costTime:" + (System.currentTimeMillis() - l) + ",CmdName:" + this.a.getCmdName() + " Seq:" + this.a.getCurrentSeq());
      return;
    }
    catch (Exception localException)
    {
      yqp.d("VSNetworkHelper| Protocol Cache", localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.servlet.VSBaseServlet.1
 * JD-Core Version:    0.7.0.1
 */