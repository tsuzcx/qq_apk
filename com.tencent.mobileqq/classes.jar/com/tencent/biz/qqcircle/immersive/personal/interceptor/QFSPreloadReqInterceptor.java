package com.tencent.biz.qqcircle.immersive.personal.interceptor;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.requests.QCircleBaseRequest;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.sender.chain.BaseSenderChain;
import com.tencent.richframework.sender.interceptor.ReqInterceptor;

public class QFSPreloadReqInterceptor
  implements OnTaskListener<Object>, ReqInterceptor<QCircleBaseRequest, BaseSenderChain>
{
  private final String a;
  private QCircleBaseRequest b;
  private BaseSenderChain c;
  private final boolean d;
  
  public QFSPreloadReqInterceptor(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.d = paramBoolean;
  }
  
  public String a()
  {
    return "QFSPreloadReqInterceptor";
  }
  
  public void a(QCircleBaseRequest paramQCircleBaseRequest, BaseSenderChain paramBaseSenderChain)
  {
    if (TextUtils.isEmpty(this.a))
    {
      paramBaseSenderChain.a(paramQCircleBaseRequest);
      return;
    }
    this.b = paramQCircleBaseRequest;
    this.c = paramBaseSenderChain;
    if (this.d)
    {
      PreLoader.preLoad(this.a, new QFSPreloadReqInterceptor.1(this, paramQCircleBaseRequest));
      return;
    }
    if (PreLoader.exists(this.a))
    {
      PreLoader.addListener(this.a, this);
      return;
    }
    paramBaseSenderChain.a(paramQCircleBaseRequest);
  }
  
  public void onComplete(Object... paramVarArgs)
  {
    if (this.c != null)
    {
      if (this.b == null) {
        return;
      }
      try
      {
        boolean bool = ((Boolean)paramVarArgs[0]).booleanValue();
        long l = ((Long)paramVarArgs[1]).longValue();
        String str = (String)paramVarArgs[2];
        paramVarArgs = paramVarArgs[3];
        this.c.a(bool, l, str, this.b, paramVarArgs);
        return;
      }
      catch (Exception paramVarArgs)
      {
        QLog.e(a(), 1, paramVarArgs.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.interceptor.QFSPreloadReqInterceptor
 * JD-Core Version:    0.7.0.1
 */