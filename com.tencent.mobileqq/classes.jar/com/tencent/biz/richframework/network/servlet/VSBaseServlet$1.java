package com.tencent.biz.richframework.network.servlet;

import aaap;
import aaaq;
import aaar;
import aaau;
import aaba;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.MessageMicro;
import yuk;

public class VSBaseServlet$1
  implements Runnable
{
  public VSBaseServlet$1(aaba paramaaba, VSBaseRequest paramVSBaseRequest) {}
  
  public void run()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = this.a.getRequestKey();
      localObject = aaar.a().a((String)localObject);
      if ((localObject == null) || (((aaaq)localObject).a() == null))
      {
        yuk.b("VSNetworkHelper| Protocol Cache", "cache not found or bundle deserialized failed,CmdName:" + this.a.getCmdName() + " Seq:" + this.a.getCurrentSeq());
        return;
      }
      localObject = this.a.decode(aaba.a(this.this$0, ((aaaq)localObject).a()));
      VSNetworkHelper.a().a(this.a, (MessageMicro)localObject);
      yuk.b("VSNetworkHelper| Protocol Cache", "send Cache Success costTime:" + (System.currentTimeMillis() - l) + ",CmdName:" + this.a.getCmdName() + " Seq:" + this.a.getCurrentSeq());
      return;
    }
    catch (Exception localException)
    {
      yuk.d("VSNetworkHelper| Protocol Cache", localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.network.servlet.VSBaseServlet.1
 * JD-Core Version:    0.7.0.1
 */