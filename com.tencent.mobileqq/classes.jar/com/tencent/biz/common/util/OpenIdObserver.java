package com.tencent.biz.common.util;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.qphone.base.util.QLog;

public class OpenIdObserver
  extends MessageObserver
{
  protected void a(boolean paramBoolean, OpenID paramOpenID) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramInt != 1) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("isSuccess=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",data=");
    localStringBuilder.append(paramObject);
    QLog.d("openid", 2, localStringBuilder.toString());
    a(paramBoolean, (OpenID)paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.util.OpenIdObserver
 * JD-Core Version:    0.7.0.1
 */