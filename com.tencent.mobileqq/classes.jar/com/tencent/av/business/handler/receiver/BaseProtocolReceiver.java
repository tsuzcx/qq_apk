package com.tencent.av.business.handler.receiver;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract class BaseProtocolReceiver<T extends BusinessHandler>
{
  protected AppInterface a;
  protected T b;
  
  public BaseProtocolReceiver(AppInterface paramAppInterface, T paramT)
  {
    this.a = paramAppInterface;
    this.b = paramT;
  }
  
  public abstract String a();
  
  public abstract void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject);
  
  public boolean a(String paramString)
  {
    return TextUtils.equals(paramString, a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.handler.receiver.BaseProtocolReceiver
 * JD-Core Version:    0.7.0.1
 */